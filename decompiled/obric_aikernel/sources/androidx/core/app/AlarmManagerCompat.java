package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class AlarmManagerCompat {

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static void setExact(AlarmManager r10, int r11, long r12, PendingIntent r13) {
            r10.setExact(r11, r12, r13);
        }
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static AlarmManager.AlarmClockInfo createAlarmClockInfo(long r10, PendingIntent r11) {
            return new AlarmManager.AlarmClockInfo(r10, r11);
        }

        @DoNotInline
        static void setAlarmClock(AlarmManager r10, Object r11, PendingIntent r12) {
            r10.setAlarmClock((AlarmManager.AlarmClockInfo) r11, r12);
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static void setAndAllowWhileIdle(AlarmManager r10, int r11, long r12, PendingIntent r13) {
            r10.setAndAllowWhileIdle(r11, r12, r13);
        }

        @DoNotInline
        static void setExactAndAllowWhileIdle(AlarmManager r10, int r11, long r12, PendingIntent r13) {
            r10.setExactAndAllowWhileIdle(r11, r12, r13);
        }
    }

    private AlarmManagerCompat() {
    }

    @SuppressLint({"MissingPermission"})
    public static void setAlarmClock(@NonNull AlarmManager r10, long r11, @NonNull PendingIntent r12, @NonNull PendingIntent r13) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        Api21Impl.setAlarmClock(r10, Api21Impl.createAlarmClockInfo(r11, r12), r13);
        return;
    L5:
        setExact(r10, 0, r11, r13);
    }

    public static void setAndAllowWhileIdle(@NonNull AlarmManager r10, int r11, long r12, @NonNull PendingIntent r13) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        Api23Impl.setAndAllowWhileIdle(r10, r11, r12, r13);
        return;
    L5:
        r10.set(r11, r12, r13);
    }

    public static void setExact(@NonNull AlarmManager r10, int r11, long r12, @NonNull PendingIntent r13) {
        if (Build.VERSION.SDK_INT < 19) goto L5;
        Api19Impl.setExact(r10, r11, r12, r13);
        return;
    L5:
        r10.set(r11, r12, r13);
    }

    public static void setExactAndAllowWhileIdle(@NonNull AlarmManager r10, int r11, long r12, @NonNull PendingIntent r13) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        Api23Impl.setExactAndAllowWhileIdle(r10, r11, r12, r13);
        return;
    L5:
        setExact(r10, r11, r12, r13);
    }
}
