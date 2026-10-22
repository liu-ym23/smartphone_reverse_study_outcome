package androidx.core.os;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class HandlerCompat {
    private static final String TAG = "HandlerCompat";

    private static class Api28Impl {
        private Api28Impl() {
        }

        public static Handler createAsync(Looper r0) {
            return Handler.createAsync(r0);
        }

        public static Handler createAsync(Looper r2, Handler.Callback r3) {
            return Handler.createAsync(r2, (Handler.Callback) ZeusTransformUtils.wrapperContextForParams(r3, Handler.Callback.class, "com.obric.memorydata.plugin"));
        }

        public static boolean postDelayed(Handler r2, Runnable r3, Object r4, long r5) {
            return r2.postDelayed((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"), r4, r5);
        }
    }

    private static class Api29Impl {
        private Api29Impl() {
        }

        public static boolean hasCallbacks(Handler r2, Runnable r3) {
            return r2.hasCallbacks((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"));
        }
    }

    private HandlerCompat() {
    }

    public static Handler createAsync(Looper r8) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return Api28Impl.createAsync(r8);
    L7:
        if (Build.VERSION.SDK_INT < 17) goto L24;
        return (Handler) ZeusTransformUtils.preCheckCast(Handler.class.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{r8, null, true}), Handler.class, "com.obric.memorydata.plugin");
    L21:
        e = move-exception;
        Log.w(TAG, "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
    L10:
        e = move-exception;
        Throwable r9 = e.getCause();
        if (ZeusTransformUtils.instanceOf(r9, RuntimeException.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r9, Error.class) == false) goto L18;
        throw ((Error) ZeusTransformUtils.preCheckCast(r9, Error.class, "com.obric.memorydata.plugin"));
    L18:
        throw new RuntimeException(r9);
    L20:
        throw ((RuntimeException) ZeusTransformUtils.preCheckCast(r9, RuntimeException.class, "com.obric.memorydata.plugin"));
    L24:
        return new Handler(r8);
    }

    public static Handler createAsync(Looper r8, Handler.Callback r9) {
        Handler.Callback r10 = (Handler.Callback) ZeusTransformUtils.wrapperContextForParams(r9, Handler.Callback.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return Api28Impl.createAsync(r8, r10);
    L7:
        if (Build.VERSION.SDK_INT < 17) goto L24;
        return (Handler) ZeusTransformUtils.preCheckCast(Handler.class.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{r8, r10, true}), Handler.class, "com.obric.memorydata.plugin");
    L21:
        e = move-exception;
        Log.w(TAG, "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
    L10:
        e = move-exception;
        Throwable r11 = e.getCause();
        if (ZeusTransformUtils.instanceOf(r11, RuntimeException.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r11, Error.class) == false) goto L18;
        throw ((Error) ZeusTransformUtils.preCheckCast(r11, Error.class, "com.obric.memorydata.plugin"));
    L18:
        throw new RuntimeException(r11);
    L20:
        throw ((RuntimeException) ZeusTransformUtils.preCheckCast(r11, RuntimeException.class, "com.obric.memorydata.plugin"));
    L24:
        return new Handler(r8, r10);
    }

    public static boolean hasCallbacks(Handler r7, Runnable r8) {
        Runnable r9 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r8, Runnable.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return Api29Impl.hasCallbacks(r7, r9);
    L7:
        if (Build.VERSION.SDK_INT >= 16) goto L26;
        e = null;
    L25:
        throw new UnsupportedOperationException("Failed to call Handler.hasCallbacks(), but there is no safe failure mode for this method. Raising exception.", e);
    L26:
        return ((Boolean) ZeusTransformUtils.preCheckCast(Handler.class.getMethod("hasCallbacks", new Class[]{Runnable.class}).invoke(r7, new Object[]{r9}), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L10:
        e = e;
    L12:
        e = move-exception;
        Throwable r10 = e.getCause();
        if (ZeusTransformUtils.instanceOf(r10, RuntimeException.class) == true) goto L22;
        if (ZeusTransformUtils.instanceOf(r10, Error.class) == false) goto L20;
        throw ((Error) ZeusTransformUtils.preCheckCast(r10, Error.class, "com.obric.memorydata.plugin"));
    L20:
        throw new RuntimeException(r10);
    L22:
        throw ((RuntimeException) ZeusTransformUtils.preCheckCast(r10, RuntimeException.class, "com.obric.memorydata.plugin"));
    }

    public static boolean postDelayed(Handler r2, Runnable r3, Object r4, long r5) {
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        Message r7 = Message.obtain(r2, r6);
        r7.obj = r4;
        return r2.sendMessageDelayed(r7, r5);
    L5:
        return Api28Impl.postDelayed(r2, r6, r4, r5);
    }
}
