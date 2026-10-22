package androidx.core.app;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class BundleCompat {

    @RequiresApi(18)
    static class Api18Impl {
        private Api18Impl() {
        }

        @DoNotInline
        static IBinder getBinder(Bundle r10, String r11) {
            return r10.getBinder(r11);
        }

        @DoNotInline
        static void putBinder(Bundle r10, String r11, IBinder r12) {
            r10.putBinder(r11, r12);
        }
    }

    @SuppressLint({"BanUncheckedReflection"})
    static class BeforeApi18Impl {
        private static final String TAG = "BundleCompatBaseImpl";
        private static Method sGetIBinderMethod;
        private static boolean sGetIBinderMethodFetched;
        private static Method sPutIBinderMethod;
        private static boolean sPutIBinderMethodFetched;

        private BeforeApi18Impl() {
        }

        public static IBinder getBinder(Bundle r10, String r11) {
            if (sGetIBinderMethodFetched == false) goto L16;
        L9:
            Method r12 = sGetIBinderMethod;
            if (r12 != null) goto L18;
        L15:
            return null;
        L18:
            return (IBinder) r12.invoke(r10, new Object[]{r11});
        L13:
            e = move-exception;
            Log.i(TAG, "Failed to invoke getIBinder via reflection", e);
            sGetIBinderMethod = null;
            goto L15
        L16:
            Method r13 = Bundle.class.getMethod("getIBinder", new Class[]{String.class});     // Catch: NoSuchMethodException -> L6
            sGetIBinderMethod = r13;     // Catch: NoSuchMethodException -> L6
            r13.setAccessible(true);     // Catch: NoSuchMethodException -> L6
        L8:
            sGetIBinderMethodFetched = true;
        L6:
            e = move-exception;
            Log.i(TAG, "Failed to retrieve getIBinder method", e);
            goto L8
        }

        public static void putBinder(Bundle r10, String r11, IBinder r12) {
            if (sPutIBinderMethodFetched == false) goto L18;
        L9:
            Method r13 = sPutIBinderMethod;
            if (r13 == null) goto L20;
            r13.invoke(r10, new Object[]{r11, r12});     // Catch: Throwable -> L13
            return;
        L13:
            e = move-exception;
            Log.i(TAG, "Failed to invoke putIBinder via reflection", e);
            sPutIBinderMethod = null;
            return;
        L20:
            return;
        L18:
            Method r14 = Bundle.class.getMethod("putIBinder", new Class[]{String.class, IBinder.class});     // Catch: NoSuchMethodException -> L6
            sPutIBinderMethod = r14;     // Catch: NoSuchMethodException -> L6
            r14.setAccessible(true);     // Catch: NoSuchMethodException -> L6
        L8:
            sPutIBinderMethodFetched = true;
        L6:
            e = move-exception;
            Log.i(TAG, "Failed to retrieve putIBinder method", e);
            goto L8
        }
    }

    private BundleCompat() {
    }

    @Nullable
    public static IBinder getBinder(@NonNull Bundle r10, @Nullable String r11) {
        if (Build.VERSION.SDK_INT < 18) goto L7;
        return Api18Impl.getBinder(r10, r11);
    L7:
        return BeforeApi18Impl.getBinder(r10, r11);
    }

    public static void putBinder(@NonNull Bundle r10, @Nullable String r11, @Nullable IBinder r12) {
        if (Build.VERSION.SDK_INT < 18) goto L5;
        Api18Impl.putBinder(r10, r11, r12);
        return;
    L5:
        BeforeApi18Impl.putBinder(r10, r11, r12);
    }
}
