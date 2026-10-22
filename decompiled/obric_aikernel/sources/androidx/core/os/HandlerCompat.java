package androidx.core.os;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class HandlerCompat {
    private static final String TAG = "HandlerCompat";

    @RequiresApi(28)
    private static class Api28Impl {
        private Api28Impl() {
        }

        public static Handler createAsync(Looper r10) {
            return Handler.createAsync(r10);
        }

        public static Handler createAsync(Looper r10, Handler.Callback r11) {
            return Handler.createAsync(r10, r11);
        }

        public static boolean postDelayed(Handler r10, Runnable r11, Object r12, long r13) {
            return r10.postDelayed(r11, r12, r13);
        }
    }

    @RequiresApi(29)
    private static class Api29Impl {
        private Api29Impl() {
        }

        public static boolean hasCallbacks(Handler r10, Runnable r11) {
            return r10.hasCallbacks(r11);
        }
    }

    private HandlerCompat() {
    }

    @NonNull
    public static Handler createAsync(@NonNull Looper r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 28) goto L7;
        return Api28Impl.createAsync(r10);
    L7:
        if (r11 < 17) goto L24;
        return (Handler) Handler.class.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{r10, null, Boolean.TRUE});
    L21:
        e = move-exception;
        Log.w(TAG, "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
    L10:
        e = move-exception;
        Throwable r12 = e.getCause();
        if ((r12 instanceof RuntimeException) == true) goto L20;
        if ((r12 instanceof Error) == false) goto L18;
        throw ((Error) r12);
    L18:
        throw new RuntimeException(r12);
    L20:
        throw ((RuntimeException) r12);
    L24:
        return new Handler(r10);
    }

    @NonNull
    public static Handler createAsync(@NonNull Looper r10, @NonNull Handler.Callback r11) {
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 28) goto L7;
        return Api28Impl.createAsync(r10, r11);
    L7:
        if (r12 < 17) goto L24;
        return (Handler) Handler.class.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{r10, r11, Boolean.TRUE});
    L21:
        e = move-exception;
        Log.w(TAG, "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
    L10:
        e = move-exception;
        Throwable r13 = e.getCause();
        if ((r13 instanceof RuntimeException) == true) goto L20;
        if ((r13 instanceof Error) == false) goto L18;
        throw ((Error) r13);
    L18:
        throw new RuntimeException(r13);
    L20:
        throw ((RuntimeException) r13);
    L24:
        return new Handler(r10, r11);
    }

    @RequiresApi(16)
    public static boolean hasCallbacks(@NonNull Handler r10, @NonNull Runnable r11) {
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 29) goto L7;
        return Api29Impl.hasCallbacks(r10, r11);
    L7:
        if (r12 >= 16) goto L26;
        e = null;
    L25:
        throw new UnsupportedOperationException("Failed to call Handler.hasCallbacks(), but there is no safe failure mode for this method. Raising exception.", e);
    L26:
        return ((Boolean) Handler.class.getMethod("hasCallbacks", new Class[]{Runnable.class}).invoke(r10, new Object[]{r11})).booleanValue();
    L10:
        e = e;
    L12:
        e = move-exception;
        Throwable r13 = e.getCause();
        if ((r13 instanceof RuntimeException) == true) goto L22;
        if ((r13 instanceof Error) == false) goto L20;
        throw ((Error) r13);
    L20:
        throw new RuntimeException(r13);
    L22:
        throw ((RuntimeException) r13);
    }

    public static boolean postDelayed(@NonNull Handler r10, @NonNull Runnable r11, @Nullable Object r12, long r13) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        Message r14 = Message.obtain(r10, r11);
        r14.obj = r12;
        return r10.sendMessageDelayed(r14, r13);
    L5:
        return Api28Impl.postDelayed(r10, r11, r12, r13);
    }
}
