package androidx.core.app;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class AlarmManagerCompat {

    static class Api19Impl {
        private Api19Impl() {
        }

        static void setExact(AlarmManager r0, int r1, long r2, PendingIntent r4) {
            r0.setExact(r1, r2, r4);
        }
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static AlarmManager.AlarmClockInfo createAlarmClockInfo(long r1, PendingIntent r3) {
            return new AlarmManager.AlarmClockInfo(r1, r3);
        }

        static void setAlarmClock(AlarmManager r2, Object r3, PendingIntent r4) {
            r2.setAlarmClock((AlarmManager.AlarmClockInfo) ZeusTransformUtils.preCheckCast(r3, AlarmManager.AlarmClockInfo.class, "com.obric.memorydata.plugin"), r4);
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static void setAndAllowWhileIdle(AlarmManager r0, int r1, long r2, PendingIntent r4) {
            r0.setAndAllowWhileIdle(r1, r2, r4);
        }

        static void setExactAndAllowWhileIdle(AlarmManager r0, int r1, long r2, PendingIntent r4) {
            r0.setExactAndAllowWhileIdle(r1, r2, r4);
        }
    }

    private AlarmManagerCompat() {
    }

    public static void setAlarmClock(AlarmManager r2, long r3, PendingIntent r5, PendingIntent r6) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        Api21Impl.setAlarmClock(r2, Api21Impl.createAlarmClockInfo(r3, r5), r6);
        return;
    L5:
        setExact(r2, 0, r3, r6);
    }

    public static void setAndAllowWhileIdle(AlarmManager r2, int r3, long r4, PendingIntent r6) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        Api23Impl.setAndAllowWhileIdle(r2, r3, r4, r6);
        return;
    L5:
        r2.set(r3, r4, r6);
    }

    public static void setExact(AlarmManager r2, int r3, long r4, PendingIntent r6) {
        if (Build.VERSION.SDK_INT < 19) goto L5;
        Api19Impl.setExact(r2, r3, r4, r6);
        return;
    L5:
        r2.set(r3, r4, r6);
    }

    public static void setExactAndAllowWhileIdle(AlarmManager r2, int r3, long r4, PendingIntent r6) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        Api23Impl.setExactAndAllowWhileIdle(r2, r3, r4, r6);
        return;
    L5:
        setExact(r2, r3, r4, r6);
    }
}
