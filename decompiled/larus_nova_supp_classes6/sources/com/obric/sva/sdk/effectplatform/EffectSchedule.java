package com.obric.sva.sdk.effectplatform;

import android.content.Context;
import android.content.SharedPreferences;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.utils.LogUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0007J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/obric/sva/sdk/effectplatform/EffectSchedule;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "SP_NAME", "", "KEY_LAST_TRIGGER_TIME", "MINIUTE", "", "HOUR", "TWO_DAYS_MILLIS", "sp", "Landroid/content/SharedPreferences;", "getSp", "()Landroid/content/SharedPreferences;", "sp$delegate", "Lkotlin/Lazy;", "checkAndTrigger", "", "onTrigger", "Lkotlin/Function0;", "resetTriggerTime", "", "getRemainingTime", "minutesToHoursString", "minutes", "", "Companion", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class EffectSchedule {
    public static final Companion Companion = null;
    private static volatile EffectSchedule INSTANCE = null;
    public static final String TAG = "ConfigManager-EffectSchedule";
    private final int HOUR;
    private final String KEY_LAST_TRIGGER_TIME;
    private final int MINIUTE;
    private final String SP_NAME;
    private final int TWO_DAYS_MILLIS;
    private final Context context;
    private final Lazy sp$delegate;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/sva/sdk/effectplatform/EffectSchedule$Companion;", "", "<init>", "()V", "TAG", "", "INSTANCE", "Lcom/obric/sva/sdk/effectplatform/EffectSchedule;", "getInstance", "context", "Landroid/content/Context;", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final EffectSchedule getInstance(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            EffectSchedule r0 = EffectSchedule.access$getINSTANCE$cp();
            if (r0 != null) goto L13;
            monitor-enter(this);
            r0 = EffectSchedule.access$getINSTANCE$cp();     // Catch: Throwable -> L10
            if (r0 != null) goto L8;
            r0 = new EffectSchedule(r3.getApplicationContext(), null);     // Catch: Throwable -> L10
            EffectSchedule.access$setINSTANCE$cp(r0);     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ EffectSchedule(Context r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    public static /* synthetic */ SharedPreferences a(EffectSchedule r0) {
        return sp_delegate$lambda$0(r0);
    }

    public final void resetTriggerTime() {
        LogUtils.d(TAG, "resetTriggerTime", new Object[0]);
        getSp().edit().putLong(this.KEY_LAST_TRIGGER_TIME, System.currentTimeMillis()).apply();
    }

    private final SharedPreferences getSp() {
        return (SharedPreferences) this.sp$delegate.getValue();
    }

    public final String getRemainingTime() {
        long r0 = System.currentTimeMillis();
        long r4 = 0;
        long r2 = getSp().getLong(this.KEY_LAST_TRIGGER_TIME, 0) + ((long) this.TWO_DAYS_MILLIS);
        if (r2 <= r0) goto L5;
        long r3 = r2 - r0;
    L6:
        long r5 = r3 / ((long) this.MINIUTE);
        if (r5 < 0) goto L11;
        r4 = r5;
    L11:
        return minutesToHoursString(r4);
    L5:
        r3 = 0;
        goto L6
    }

    public static final /* synthetic */ EffectSchedule access$getINSTANCE$cp() {
        return INSTANCE;
    }

    private EffectSchedule(Context r1) {
        this.context = r1;
        this.SP_NAME = "EffectSchedule";
        this.KEY_LAST_TRIGGER_TIME = "last_trigger_time";
        this.MINIUTE = 60000;
        int r2 = 60000 * 60;
        this.HOUR = r2;
        this.TWO_DAYS_MILLIS = r2 * 48;
        this.sp$delegate = LazyKt.lazy(new n(this));
    }

    public static final /* synthetic */ void access$setINSTANCE$cp(EffectSchedule r0) {
        INSTANCE = r0;
    }

    private final String minutesToHoursString(long r7) {
        if (r7 < 0) goto L13;
        long r2 = 60;
        long r4 = r7 / r2;
        long r8 = r7 % r2;
        if (r4 != 0) goto L8;
        return r8 + " MINUTES";
    L8:
        if (r8 != 0) goto L11;
        return r4 + " HOUR";
    L11:
        return r4 + " HOUR " + r8 + " MINUTES";
    L13:
        throw new IllegalArgumentException("MINUTES MUST > 0");
    }

    private static final SharedPreferences sp_delegate$lambda$0(EffectSchedule r2) {
        return r2.context.getSharedPreferences(r2.SP_NAME, 0);
    }

    public final boolean checkAndTrigger(Function0<Boolean> r13) {
        Intrinsics.checkNotNullParameter(r13, "onTrigger");
        long r0 = System.currentTimeMillis();
        long r2 = getSp().getLong(this.KEY_LAST_TRIGGER_TIME, 0);
        LogUtils.d(TAG, "currentTime " + r0 + " lastTriggerTime " + r2, new Object[0]);
        long r3 = r0 - r2;
        if (r3 < this.TWO_DAYS_MILLIS) goto L5;
    L8:
        LogUtils.d(TAG, "onTrigger invoke", new Object[0]);
        r13.invoke();
        getSp().edit().putLong(this.KEY_LAST_TRIGGER_TIME, r0).apply();
        return true;
    L5:
        if (r3 < 0) goto L8;
        return false;
    }
}
