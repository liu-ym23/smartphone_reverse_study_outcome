package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class AlarmManagerCompat {

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static AlarmManager.AlarmClockInfo createAlarmClockInfo(long r5, PendingIntent r10) {
            return new AlarmManager.AlarmClockInfo(r5, r10);
        }

        @DoNotInline
        public static void setAlarmClock(AlarmManager r5, Object r10, PendingIntent r11) {
            r5.setAlarmClock((AlarmManager.AlarmClockInfo) r10, r11);
        }
    }

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static void setAndAllowWhileIdle(AlarmManager r5, int r10, long r11, PendingIntent r12) {
            r5.setAndAllowWhileIdle(r10, r11, r12);
        }

        @DoNotInline
        public static void setExactAndAllowWhileIdle(AlarmManager r5, int r10, long r11, PendingIntent r12) {
            r5.setExactAndAllowWhileIdle(r10, r11, r12);
        }
    }

    @RequiresApi(31)
    public static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        public static boolean canScheduleExactAlarms(AlarmManager r5) {
            return r5.canScheduleExactAlarms();
        }
    }

    private AlarmManagerCompat() {
    }

    public static boolean canScheduleExactAlarms(@NonNull AlarmManager r5) {
        return Api31Impl.canScheduleExactAlarms(r5);
    }

    @SuppressLint({"MissingPermission"})
    public static void setAlarmClock(@NonNull AlarmManager r5, long r10, @NonNull PendingIntent r11, @NonNull PendingIntent r12) {
        Api21Impl.setAlarmClock(r5, Api21Impl.createAlarmClockInfo(r10, r11), r12);
    }

    public static void setAndAllowWhileIdle(@NonNull AlarmManager r5, int r10, long r11, @NonNull PendingIntent r12) {
        Api23Impl.setAndAllowWhileIdle(r5, r10, r11, r12);
    }

    public static void setExact(@NonNull AlarmManager r5, int r10, long r11, @NonNull PendingIntent r12) {
        r5.setExact(r10, r11, r12);
    }

    public static void setExactAndAllowWhileIdle(@NonNull AlarmManager r5, int r10, long r11, @NonNull PendingIntent r12) {
        Api23Impl.setExactAndAllowWhileIdle(r5, r10, r11, r12);
    }
}
