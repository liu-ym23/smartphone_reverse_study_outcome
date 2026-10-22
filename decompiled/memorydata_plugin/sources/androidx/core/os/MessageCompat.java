package androidx.core.os;

import android.os.Build;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
public final class MessageCompat {
    private static boolean sTryIsAsynchronous = true;
    private static boolean sTrySetAsynchronous = true;

    static class Api22Impl {
        private Api22Impl() {
        }

        static boolean isAsynchronous(Message r0) {
            return r0.isAsynchronous();
        }

        static void setAsynchronous(Message r0, boolean r1) {
            r0.setAsynchronous(r1);
        }
    }

    static {
    }

    private MessageCompat() {
    }

    public static boolean isAsynchronous(Message r3) {
        if (Build.VERSION.SDK_INT < 22) goto L7;
        return Api22Impl.isAsynchronous(r3);
    L7:
        if (sTryIsAsynchronous == true) goto L9;
    L13:
        return false;
    L9:
        if (Build.VERSION.SDK_INT < 16) goto L13;
        return Api22Impl.isAsynchronous(r3);
    L12:
        sTryIsAsynchronous = false;
        goto L13
    }

    public static void setAsynchronous(Message r2, boolean r3) {
        if (Build.VERSION.SDK_INT < 22) goto L7;
        Api22Impl.setAsynchronous(r2, r3);
        return;
    L7:
        if (sTrySetAsynchronous == true) goto L9;
        return;
    L9:
        if (Build.VERSION.SDK_INT < 16) goto L17;
        Api22Impl.setAsynchronous(r2, r3);     // Catch: NoSuchMethodError -> L12
        return;
    L12:
        sTrySetAsynchronous = false;
        return;
    }
}
