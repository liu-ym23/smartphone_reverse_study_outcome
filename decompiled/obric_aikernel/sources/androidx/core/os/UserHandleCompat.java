package androidx.core.os;

import android.os.Build;
import android.os.UserHandle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(17)
public class UserHandleCompat {

    @Nullable
    private static Method sGetUserIdMethod;

    @Nullable
    private static Constructor<UserHandle> sUserHandleConstructor;

    @RequiresApi(24)
    private static class Api24Impl {
        private Api24Impl() {
        }

        @NonNull
        static UserHandle getUserHandleForUid(int r10) {
            return UserHandle.getUserHandleForUid(r10);
        }
    }

    private UserHandleCompat() {
    }

    private static Method getGetUserIdMethod() {
        if (sGetUserIdMethod != null) goto L6;
        Method r10 = UserHandle.class.getDeclaredMethod("getUserId", new Class[]{Integer.TYPE});
        sGetUserIdMethod = r10;
        r10.setAccessible(true);
    L6:
        return sGetUserIdMethod;
    }

    private static Constructor<UserHandle> getUserHandleConstructor() {
        if (sUserHandleConstructor != null) goto L6;
        Constructor<UserHandle> r10 = UserHandle.class.getDeclaredConstructor(new Class[]{Integer.TYPE});
        sUserHandleConstructor = r10;
        r10.setAccessible(true);
    L6:
        return sUserHandleConstructor;
    }

    @NonNull
    public static UserHandle getUserHandleForUid(int r10) {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        Integer r11 = (Integer) getGetUserIdMethod().invoke(null, new Object[]{Integer.valueOf(r10)});     // Catch: InvocationTargetException -> L8 InstantiationException -> L11 IllegalAccessException -> L14 NoSuchMethodException -> L17
        return getUserHandleConstructor().newInstance(new Object[]{r11});
    L14:
        e = move-exception;
        IllegalAccessError r12 = new IllegalAccessError();
        r12.initCause(e);
        throw r12;
    L11:
        e = move-exception;
        InstantiationError r13 = new InstantiationError();
        r13.initCause(e);
        throw r13;
    L17:
        e = move-exception;
        NoSuchMethodError r14 = new NoSuchMethodError();
        r14.initCause(e);
        throw r14;
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return Api24Impl.getUserHandleForUid(r10);
    }
}
