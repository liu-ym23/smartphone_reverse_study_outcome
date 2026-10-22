package androidx.core.os;

import android.os.Build;
import android.os.UserHandle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class UserHandleCompat {
    private static Method sGetUserIdMethod;
    private static Constructor<UserHandle> sUserHandleConstructor;

    private static class Api24Impl {
        private Api24Impl() {
        }

        static UserHandle getUserHandleForUid(int r0) {
            return UserHandle.getUserHandleForUid(r0);
        }
    }

    private UserHandleCompat() {
    }

    private static Method getGetUserIdMethod() {
        if (sGetUserIdMethod != null) goto L6;
        Method r0 = UserHandle.class.getDeclaredMethod("getUserId", new Class[]{Integer.TYPE});
        sGetUserIdMethod = r0;
        r0.setAccessible(true);
    L6:
        return sGetUserIdMethod;
    }

    private static Constructor<UserHandle> getUserHandleConstructor() {
        if (sUserHandleConstructor != null) goto L6;
        Constructor<UserHandle> r0 = UserHandle.class.getDeclaredConstructor(new Class[]{Integer.TYPE});
        sUserHandleConstructor = r0;
        r0.setAccessible(true);
    L6:
        return sUserHandleConstructor;
    }

    public static UserHandle getUserHandleForUid(int r6) {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        Integer r7 = (Integer) ZeusTransformUtils.preCheckCast(getGetUserIdMethod().invoke(null, new Object[]{Integer.valueOf(r6)}), Integer.class, "com.obric.memorydata.plugin");     // Catch: InvocationTargetException -> L8 InstantiationException -> L11 IllegalAccessException -> L14 NoSuchMethodException -> L17
        return (UserHandle) ZeusTransformUtils.preCheckCast(getUserHandleConstructor().newInstance(new Object[]{r7}), UserHandle.class, "com.obric.memorydata.plugin");
    L14:
        e = move-exception;
        IllegalAccessError r0 = new IllegalAccessError();
        r0.initCause(e);
        throw r0;
    L11:
        e = move-exception;
        InstantiationError r1 = new InstantiationError();
        r1.initCause(e);
        throw r1;
    L17:
        e = move-exception;
        NoSuchMethodError r2 = new NoSuchMethodError();
        r2.initCause(e);
        throw r2;
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return Api24Impl.getUserHandleForUid(r6);
    }
}
