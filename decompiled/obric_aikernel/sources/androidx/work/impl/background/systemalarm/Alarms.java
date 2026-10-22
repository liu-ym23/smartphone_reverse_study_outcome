package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationCompat;
import androidx.work.Logger;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.SystemIdInfoKt;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.utils.IdGenerator;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class Alarms {
    private static final String TAG = null;

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static void setExact(AlarmManager r10, int r11, long r12, PendingIntent r13) {
            r10.setExact(r11, r12, r13);
        }
    }

    static {
        TAG = Logger.tagWithPrefix("Alarms");
    }

    private Alarms() {
    }

    public static void cancelAlarm(@NonNull Context r10, @NonNull WorkDatabase r11, @NonNull WorkGenerationalId r12) {
        SystemIdInfoDao r13 = r11.systemIdInfoDao();
        SystemIdInfo r14 = r13.getSystemIdInfo(r12);
        if (r14 == null) goto L6;
        cancelExactAlarm(r10, r12, r14.systemId);
        Logger.get().debug(TAG, "Removing SystemIdInfo for workSpecId (" + r12 + ")");
        r13.removeSystemIdInfo(r12);
        return;
    }

    private static void cancelExactAlarm(@NonNull Context r10, @NonNull WorkGenerationalId r11, int r12) {
        AlarmManager r13 = (AlarmManager) r10.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intent r14 = CommandHandler.createDelayMetIntent(r10, r11);
        if (Build.VERSION.SDK_INT < 23) goto L5;
        int r15 = 603979776;
    L6:
        PendingIntent r16 = PendingIntent.getService(r10, r12, r14, r15);
        if (r16 == null) goto L11;
        if (r13 == null) goto L12;
        Logger.get().debug(TAG, "Cancelling existing alarm with (workSpecId, systemId) (" + r11 + ", " + r12 + ")");
        r13.cancel(r16);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r15 = 536870912;
        goto L6
    }

    public static void setAlarm(@NonNull Context r10, @NonNull WorkDatabase r11, @NonNull WorkGenerationalId r12, long r13) {
        SystemIdInfoDao r14 = r11.systemIdInfoDao();
        SystemIdInfo r15 = r14.getSystemIdInfo(r12);
        if (r15 == null) goto L5;
        cancelExactAlarm(r10, r12, r15.systemId);
        int r16 = r15.systemId;
    L6:
        setExactAlarm(r10, r12, r16, r13);
        return;
    L5:
        r16 = new IdGenerator(r11).nextAlarmManagerId();
        r14.insertSystemIdInfo(SystemIdInfoKt.systemIdInfo(r12, r16));
        goto L6
    }

    private static void setExactAlarm(@NonNull Context r10, @NonNull WorkGenerationalId r11, int r12, long r13) {
        AlarmManager r14 = (AlarmManager) r10.getSystemService(NotificationCompat.CATEGORY_ALARM);
        int r15 = Build.VERSION.SDK_INT;
        if (r15 < 23) goto L5;
        int r16 = 201326592;
    L6:
        PendingIntent r17 = PendingIntent.getService(r10, r12, CommandHandler.createDelayMetIntent(r10, r11), r16);
        if (r14 != null) goto L9;
        return;
    L9:
        if (r15 < 19) goto L11;
        Api19Impl.setExact(r14, 0, r13, r17);
        return;
    L11:
        r14.set(0, r13, r17);
        return;
    L5:
        r16 = 134217728;
        goto L6
    }
}
