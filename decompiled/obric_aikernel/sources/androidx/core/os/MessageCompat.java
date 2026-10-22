package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Message;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class MessageCompat {
    private static boolean sTryIsAsynchronous = true;
    private static boolean sTrySetAsynchronous = true;

    @RequiresApi(22)
    static class Api22Impl {
        private Api22Impl() {
        }

        @DoNotInline
        static boolean isAsynchronous(Message r10) {
            return r10.isAsynchronous();
        }

        @DoNotInline
        static void setAsynchronous(Message r10, boolean r11) {
            r10.setAsynchronous(r11);
        }
    }

    static {
    }

    private MessageCompat() {
    }

    @SuppressLint({"NewApi"})
    public static boolean isAsynchronous(@NonNull Message r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 22) goto L7;
        return Api22Impl.isAsynchronous(r10);
    L7:
        if (sTryIsAsynchronous == true) goto L9;
    L13:
        return false;
    L9:
        if (r11 < 16) goto L13;
        return Api22Impl.isAsynchronous(r10);
    L12:
        sTryIsAsynchronous = false;
        goto L13
    }

    @SuppressLint({"NewApi"})
    public static void setAsynchronous(@NonNull Message r10, boolean r11) {
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 22) goto L7;
        Api22Impl.setAsynchronous(r10, r11);
        return;
    L7:
        if (sTrySetAsynchronous == true) goto L9;
        return;
    L9:
        if (r12 < 16) goto L17;
        Api22Impl.setAsynchronous(r10, r11);     // Catch: NoSuchMethodError -> L12
        return;
    L12:
        sTrySetAsynchronous = false;
        return;
    }
}
