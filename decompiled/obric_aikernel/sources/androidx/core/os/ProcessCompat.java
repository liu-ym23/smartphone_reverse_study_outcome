package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Process;
import android.os.UserHandle;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class ProcessCompat {

    @RequiresApi(16)
    static class Api16Impl {
        private static Method sMethodUserIdIsAppMethod;
        private static boolean sResolved;
        private static final Object sResolvedLock = null;

        static {
            sResolvedLock = new Object();
        }

        private Api16Impl() {
        }

        @SuppressLint({"PrivateApi"})
        static boolean isApplicationUid(int r10) {
            Object r11 = sResolvedLock;     // Catch: Exception -> L20
            monitor-enter(r11);     // Catch: Exception -> L20
        L17:
            th = move-exception;
            throw th;     // Catch: Exception -> L20
        L6:
            if (sResolved == true) goto L8;
            sResolved = true;     // Catch: Throwable -> L17
            sMethodUserIdIsAppMethod = Class.forName("android.os.UserId").getDeclaredMethod("isApp", new Class[]{Integer.TYPE});     // Catch: Throwable -> L17
        L8:
            monitor-exit(r11);     // Catch: Throwable -> L17
            Method r12 = sMethodUserIdIsAppMethod;     // Catch: Exception -> L20
            if (r12 == null) goto L22;
            Boolean r13 = (Boolean) r12.invoke(null, new Object[]{Integer.valueOf(r10)});     // Catch: Exception -> L20
            if (r13 == null) goto L16;
            return r13.booleanValue();
        L16:
            throw new NullPointerException();     // Catch: Exception -> L20
        L22:
            return true;
        L20:
            e = move-exception;
            e.printStackTrace();
            goto L22
        }
    }

    @RequiresApi(17)
    static class Api17Impl {
        private static Method sMethodUserHandleIsAppMethod;
        private static boolean sResolved;
        private static final Object sResolvedLock = null;

        static {
            sResolvedLock = new Object();
        }

        private Api17Impl() {
        }

        @SuppressLint({"DiscouragedPrivateApi"})
        static boolean isApplicationUid(int r10) {
            Object r11 = sResolvedLock;     // Catch: Exception -> L20
            monitor-enter(r11);     // Catch: Exception -> L20
        L17:
            th = move-exception;
            throw th;     // Catch: Exception -> L20
        L6:
            if (sResolved == true) goto L8;
            sResolved = true;     // Catch: Throwable -> L17
            sMethodUserHandleIsAppMethod = UserHandle.class.getDeclaredMethod("isApp", new Class[]{Integer.TYPE});     // Catch: Throwable -> L17
        L8:
            monitor-exit(r11);     // Catch: Throwable -> L17
            Method r12 = sMethodUserHandleIsAppMethod;     // Catch: Exception -> L20
            if (r12 == null) goto L22;
            Boolean r13 = (Boolean) r12.invoke(null, new Object[]{Integer.valueOf(r10)});     // Catch: Exception -> L20
            if (r13 == null) goto L16;
            return r13.booleanValue();
        L16:
            throw new NullPointerException();     // Catch: Exception -> L20
        L22:
            return true;
        L20:
            e = move-exception;
            e.printStackTrace();
            goto L22
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        static boolean isApplicationUid(int r10) {
            return Process.isApplicationUid(r10);
        }
    }

    private ProcessCompat() {
    }

    public static boolean isApplicationUid(int r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 24) goto L7;
        return Api24Impl.isApplicationUid(r10);
    L7:
        if (r11 < 17) goto L11;
        return Api17Impl.isApplicationUid(r10);
    L11:
        if (r11 == 16) goto L13;
        return true;
    L13:
        return Api16Impl.isApplicationUid(r10);
    }
}
