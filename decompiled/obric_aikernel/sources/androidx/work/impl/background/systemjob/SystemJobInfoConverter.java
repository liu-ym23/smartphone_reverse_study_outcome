package androidx.work.impl.background.systemjob;

import android.annotation.SuppressLint;
import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.model.WorkSpec;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 23)
@SuppressLint({"ClassVerificationFailure"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class SystemJobInfoConverter {
    static final String EXTRA_IS_PERIODIC = "EXTRA_IS_PERIODIC";
    static final String EXTRA_WORK_SPEC_GENERATION = "EXTRA_WORK_SPEC_GENERATION";
    static final String EXTRA_WORK_SPEC_ID = "EXTRA_WORK_SPEC_ID";
    private static final String TAG = null;
    private final ComponentName mWorkServiceComponent;

    /* JADX INFO: renamed from: androidx.work.impl.background.systemjob.SystemJobInfoConverter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$work$NetworkType = null;

        static {
            int[] r10 = new int[NetworkType.values().length];
            $SwitchMap$androidx$work$NetworkType = r10;
            r10[NetworkType.NOT_REQUIRED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$androidx$work$NetworkType[NetworkType.CONNECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$androidx$work$NetworkType[NetworkType.UNMETERED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$androidx$work$NetworkType[NetworkType.NOT_ROAMING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$androidx$work$NetworkType[NetworkType.METERED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    static {
        TAG = Logger.tagWithPrefix("SystemJobInfoConverter");
    }

    @VisibleForTesting(otherwise = 3)
    SystemJobInfoConverter(@NonNull Context r10) {
        this.mWorkServiceComponent = new ComponentName(r10.getApplicationContext(), SystemJobService.class);
    }

    @RequiresApi(24)
    private static JobInfo.TriggerContentUri convertContentUriTrigger(Constraints.ContentUriTrigger r10) {
        boolean r11 = r10.isTriggeredForDescendants();
        return new JobInfo.TriggerContentUri(r10.getUri(), r11 ? 1 : 0);
    }

    static int convertNetworkType(NetworkType r10) {
        int r11 = AnonymousClass1.$SwitchMap$androidx$work$NetworkType[r10.ordinal()];
        if (r11 != 1) goto L5;
        return 0;
    L5:
        if (r11 != 2) goto L7;
        return 1;
    L7:
        if (r11 != 3) goto L9;
        return 2;
    L9:
        if (r11 == 4) goto L17;
        if (r11 == 5) goto L14;
    L19:
        Logger.get().debug(TAG, "API version too low. Cannot convert network type value " + r10);
        return 1;
    L14:
        if (Build.VERSION.SDK_INT < 26) goto L19;
        return 4;
    L17:
        if (Build.VERSION.SDK_INT < 24) goto L19;
        return 3;
    }

    static void setRequiredNetwork(@NonNull JobInfo.Builder r10, @NonNull NetworkType r11) {
        if (Build.VERSION.SDK_INT >= 30) goto L5;
    L7:
        r10.setRequiredNetworkType(convertNetworkType(r11));
        return;
    L5:
        if (r11 != NetworkType.TEMPORARILY_UNMETERED) goto L7;
        r10.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
    }

    JobInfo convert(WorkSpec r10, int r11) {
        Constraints r12 = r10.constraints;
        PersistableBundle r13 = new PersistableBundle();
        r13.putString(EXTRA_WORK_SPEC_ID, r10.id);
        r13.putInt(EXTRA_WORK_SPEC_GENERATION, r10.getGeneration());
        r13.putBoolean(EXTRA_IS_PERIODIC, r10.isPeriodic());
        JobInfo.Builder r14 = new JobInfo.Builder(r11, this.mWorkServiceComponent).setRequiresCharging(r12.requiresCharging()).setRequiresDeviceIdle(r12.requiresDeviceIdle()).setExtras(r13);
        setRequiredNetwork(r14, r12.getRequiredNetworkType());
        boolean r15 = false;
        if (r12.requiresDeviceIdle() == false) goto L5;
    L9:
        long r16 = Math.max(r10.calculateNextRunTime() - System.currentTimeMillis(), 0);
        int r17 = Build.VERSION.SDK_INT;
        if (r17 > 28) goto L13;
    L11:
        r14.setMinimumLatency(r16);
    L19:
        if (r17 >= 24) goto L21;
    L27:
        r14.setPersisted(false);
        int r18 = Build.VERSION.SDK_INT;
        if (r18 < 26) goto L31;
        r14.setRequiresBatteryNotLow(r12.requiresBatteryNotLow());
        r14.setRequiresStorageNotLow(r12.requiresStorageNotLow());
    L31:
        if (r10.runAttemptCount <= 0) goto L33;
        boolean r19 = true;
    L35:
        if (r16 <= 0) goto L38;
        r15 = true;
    L38:
        if (r18 < 31) goto L45;
        if (r10.expedited == false) goto L45;
        if (r19 == true) goto L45;
        if (r15 == true) goto L45;
        r14.setExpedited(true);
    L45:
        return r14.build();
    L33:
        r19 = false;
        goto L35
    L21:
        if (r12.hasContentUriTriggers() == false) goto L27;
        Iterator<Constraints.ContentUriTrigger> r110 = r12.getContentUriTriggers().iterator();
    L24:
        if (r110.hasNext() == false) goto L26;
        r14.addTriggerContentUri(convertContentUriTrigger(r110.next()));
        goto L24
    L26:
        r14.setTriggerContentUpdateDelay(r12.getContentTriggerUpdateDelayMillis());
        r14.setTriggerContentMaxDelay(r12.getContentTriggerMaxDelayMillis());
        goto L27
    L13:
        if (r16 > 0) goto L11;
        if (r10.expedited == true) goto L19;
        r14.setImportantWhileForeground(true);
        goto L19
    L5:
        if (r10.backoffPolicy != BackoffPolicy.LINEAR) goto L7;
        int r111 = 0;
    L8:
        r14.setBackoffCriteria(r10.backoffDelayDuration, r111);
        goto L9
    L7:
        r111 = 1;
        goto L8
    }
}
