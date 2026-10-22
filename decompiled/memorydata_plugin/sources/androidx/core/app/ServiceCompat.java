package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class ServiceCompat {
    private static final int FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_Q = 255;
    private static final int FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_U = 1073745919;
    public static final int START_STICKY = 1;
    public static final int STOP_FOREGROUND_DETACH = 2;
    public static final int STOP_FOREGROUND_REMOVE = 1;

    static class Api24Impl {
        private Api24Impl() {
        }

        static void stopForeground(Service r2, int r3) {
            ((Service) ZeusTransformUtils.wrapperContextForParams(r2, Service.class, "com.obric.memorydata.plugin")).stopForeground(r3);
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static void startForeground(Service r2, int r3, Notification r4, int r5) {
            Service r6 = (Service) ZeusTransformUtils.wrapperContextForParams(r2, Service.class, "com.obric.memorydata.plugin");
            if (r5 != 0) goto L5;
        L8:
            r6.startForeground(r3, r4, r5);
            return;
        L5:
            if (r5 == (-1)) goto L8;
            r5 = r5 & 255;
            goto L8
        }
    }

    static class Api34Impl {
        private Api34Impl() {
        }

        static void startForeground(Service r2, int r3, Notification r4, int r5) {
            Service r6 = (Service) ZeusTransformUtils.wrapperContextForParams(r2, Service.class, "com.obric.memorydata.plugin");
            if (r5 != 0) goto L5;
        L8:
            r6.startForeground(r3, r4, r5);
            return;
        L5:
            if (r5 == (-1)) goto L8;
            r5 = r5 & ServiceCompat.FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_U;
            goto L8
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StopForegroundFlags {
    }

    private ServiceCompat() {
    }

    public static void startForeground(Service r2, int r3, Notification r4, int r5) {
        Service r6 = (Service) ZeusTransformUtils.wrapperContextForParams(r2, Service.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 34) goto L6;
        Api34Impl.startForeground(r6, r3, r4, r5);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 29) goto L8;
        Api29Impl.startForeground(r6, r3, r4, r5);
        return;
    L8:
        r6.startForeground(r3, r4);
    }

    public static void stopForeground(Service r2, int r3) {
        Service r4 = (Service) ZeusTransformUtils.wrapperContextForParams(r2, Service.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 24) goto L5;
        Api24Impl.stopForeground(r4, r3);
        return;
    L5:
        boolean r0 = true;
        if ((r3 & 1) != 0) goto L9;
        r0 = false;
    L9:
        r4.stopForeground(r0);
    }
}
