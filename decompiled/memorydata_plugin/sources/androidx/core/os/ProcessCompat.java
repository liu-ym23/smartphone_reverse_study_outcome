package androidx.core.os;

import android.os.Build;
import android.os.Process;
import android.os.UserHandle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class ProcessCompat {

    static class Api16Impl {
        private static Method sMethodUserIdIsAppMethod;
        private static boolean sResolved;
        private static final Object sResolvedLock = null;

        static {
            sResolvedLock = new Object();
        }

        private Api16Impl() {
        }

        static boolean isApplicationUid(int r7) {
            Object r1 = sResolvedLock;     // Catch: Exception -> L20
            monitor-enter(r1);     // Catch: Exception -> L20
        L17:
            th = move-exception;
            throw th;     // Catch: Exception -> L20
        L6:
            if (sResolved == true) goto L8;
            sResolved = true;     // Catch: Throwable -> L17
            sMethodUserIdIsAppMethod = ZeusTransformUtils.forName("android.os.UserId", "com.obric.memorydata.plugin").getDeclaredMethod("isApp", new Class[]{Integer.TYPE});     // Catch: Throwable -> L17
        L8:
            monitor-exit(r1);     // Catch: Throwable -> L17
            Method r2 = sMethodUserIdIsAppMethod;     // Catch: Exception -> L20
            if (r2 == null) goto L22;
            Boolean r8 = (Boolean) ZeusTransformUtils.preCheckCast(r2.invoke(null, new Object[]{Integer.valueOf(r7)}), Boolean.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L20
            if (r8 == null) goto L16;
            return r8.booleanValue();
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

    static class Api17Impl {
        private static Method sMethodUserHandleIsAppMethod;
        private static boolean sResolved;
        private static final Object sResolvedLock = null;

        static {
            sResolvedLock = new Object();
        }

        private Api17Impl() {
        }

        static boolean isApplicationUid(int r7) {
            Object r1 = sResolvedLock;     // Catch: Exception -> L20
            monitor-enter(r1);     // Catch: Exception -> L20
        L17:
            th = move-exception;
            throw th;     // Catch: Exception -> L20
        L6:
            if (sResolved == true) goto L8;
            sResolved = true;     // Catch: Throwable -> L17
            sMethodUserHandleIsAppMethod = UserHandle.class.getDeclaredMethod("isApp", new Class[]{Integer.TYPE});     // Catch: Throwable -> L17
        L8:
            monitor-exit(r1);     // Catch: Throwable -> L17
            Method r2 = sMethodUserHandleIsAppMethod;     // Catch: Exception -> L20
            if (r2 == null) goto L22;
            Boolean r8 = (Boolean) ZeusTransformUtils.preCheckCast(r2.invoke(null, new Object[]{Integer.valueOf(r7)}), Boolean.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L20
            if (r8 == null) goto L16;
            return r8.booleanValue();
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

    static class Api24Impl {
        private Api24Impl() {
        }

        static boolean isApplicationUid(int r0) {
            return Process.isApplicationUid(r0);
        }
    }

    private ProcessCompat() {
    }

    public static boolean isApplicationUid(int r2) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return Api24Impl.isApplicationUid(r2);
    L7:
        if (Build.VERSION.SDK_INT < 17) goto L11;
        return Api17Impl.isApplicationUid(r2);
    L11:
        if (Build.VERSION.SDK_INT == 16) goto L13;
        return true;
    L13:
        return Api16Impl.isApplicationUid(r2);
    }
}
