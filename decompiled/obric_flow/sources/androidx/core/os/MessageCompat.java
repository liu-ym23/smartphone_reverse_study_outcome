package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Message;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class MessageCompat {
    private static boolean sTryIsAsynchronous = true;
    private static boolean sTrySetAsynchronous = true;

    @RequiresApi(22)
    public static class Api22Impl {
        private Api22Impl() {
        }

        @DoNotInline
        public static boolean isAsynchronous(Message r5) {
            return r5.isAsynchronous();
        }

        @DoNotInline
        public static void setAsynchronous(Message r5, boolean r10) {
            r5.setAsynchronous(r10);
        }
    }

    private MessageCompat() {
    }

    @SuppressLint({"NewApi"})
    public static boolean isAsynchronous(@NonNull Message r5) {
        return Api22Impl.isAsynchronous(r5);
    }

    @SuppressLint({"NewApi"})
    public static void setAsynchronous(@NonNull Message r5, boolean r10) {
        Api22Impl.setAsynchronous(r5, r10);
    }
}
