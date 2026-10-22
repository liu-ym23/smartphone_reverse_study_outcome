package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class ServiceCompat {
    private static final int FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_Q = 255;
    private static final int FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_U = 1073745919;
    public static final int START_STICKY = 1;
    public static final int STOP_FOREGROUND_DETACH = 2;
    public static final int STOP_FOREGROUND_REMOVE = 1;

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static void stopForeground(Service r5, int r10) {
            r5.stopForeground(r10);
        }
    }

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static void startForeground(Service r5, int r10, Notification r11, int r12) {
            if (r12 != 0) goto L4;
        L7:
            r5.startForeground(r10, r11, r12);
            return;
        L4:
            if (r12 == (-1)) goto L7;
            r5.startForeground(r10, r11, r12 & 255);
        }
    }

    @RequiresApi(34)
    public static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        public static void startForeground(Service r5, int r10, Notification r11, int r12) {
            if (r12 != 0) goto L4;
        L7:
            r5.startForeground(r10, r11, r12);
            return;
        L4:
            if (r12 == (-1)) goto L7;
            r5.startForeground(r10, r11, r12 & ServiceCompat.FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_U);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface StopForegroundFlags {
    }

    private ServiceCompat() {
    }

    public static void startForeground(@NonNull Service r5, int r10, @NonNull Notification r11, int r12) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api34Impl.startForeground(r5, r10, r11, r12);
        return;
    L5:
        Api29Impl.startForeground(r5, r10, r11, r12);
    }

    public static void stopForeground(@NonNull Service r5, int r10) {
        Api24Impl.stopForeground(r5, r10);
    }
}
