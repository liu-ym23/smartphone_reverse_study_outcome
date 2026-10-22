package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Process;
import android.os.UserHandle;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class ProcessCompat {

    public static class Api19Impl {
        private static Method sMethodUserHandleIsAppMethod;
        private static boolean sResolved;
        private static final Object sResolvedLock = null;

        static {
            sResolvedLock = new Object();
        }

        private Api19Impl() {
        }

        @SuppressLint({"DiscouragedPrivateApi"})
        public static boolean isApplicationUid(int r5) {
            Object r10 = sResolvedLock;     // Catch: Exception -> L17
            monitor-enter(r10);     // Catch: Exception -> L17
        L8:
            th = move-exception;
            throw th;     // Catch: Exception -> L17
        L6:
            if (sResolved == true) goto L10;
            sResolved = true;     // Catch: Throwable -> L8
            sMethodUserHandleIsAppMethod = UserHandle.class.getDeclaredMethod("isApp", new Class[]{Integer.TYPE});     // Catch: Throwable -> L8
        L10:
            monitor-exit(r10);     // Catch: Throwable -> L8
            Method r11 = sMethodUserHandleIsAppMethod;     // Catch: Exception -> L17
            if (r11 == null) goto L24;
            Boolean r12 = (Boolean) r11.invoke(null, new Object[]{Integer.valueOf(r5)});     // Catch: Exception -> L17
            if (r12 == null) goto L20;
            return r12.booleanValue();
        L20:
            throw new NullPointerException();     // Catch: Exception -> L17
        L24:
            return true;
        L17:
            e = move-exception;
            e.printStackTrace();
            goto L24
        }
    }

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        public static boolean isApplicationUid(int r5) {
            return Process.isApplicationUid(r5);
        }
    }

    private ProcessCompat() {
    }

    public static boolean isApplicationUid(int r5) {
        return Api24Impl.isApplicationUid(r5);
    }
}
