package androidx.core.os;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class HandlerCompat {
    private static final String TAG = "HandlerCompat";

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        public static Handler createAsync(Looper r5) {
            return Handler.createAsync(r5);
        }

        public static boolean postDelayed(Handler r5, Runnable r10, Object r11, long r12) {
            return r5.postDelayed(r10, r11, r12);
        }

        public static Handler createAsync(Looper r5, Handler.Callback r10) {
            return Handler.createAsync(r5, r10);
        }
    }

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        public static boolean hasCallbacks(Handler r5, Runnable r10) {
            return r5.hasCallbacks(r10);
        }
    }

    private HandlerCompat() {
    }

    @NonNull
    public static Handler createAsync(@NonNull Looper r5) {
        return Api28Impl.createAsync(r5);
    }

    public static boolean hasCallbacks(@NonNull Handler r5, @NonNull Runnable r10) {
        return Api29Impl.hasCallbacks(r5, r10);
    }

    public static boolean postDelayed(@NonNull Handler r5, @NonNull Runnable r10, @Nullable Object r11, long r12) {
        return Api28Impl.postDelayed(r5, r10, r11, r12);
    }

    @NonNull
    public static Handler createAsync(@NonNull Looper r5, @NonNull Handler.Callback r10) {
        return Api28Impl.createAsync(r5, r10);
    }
}
