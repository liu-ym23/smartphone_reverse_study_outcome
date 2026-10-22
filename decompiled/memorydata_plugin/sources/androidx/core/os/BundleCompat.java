package androidx.core.os;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class BundleCompat {

    static class Api18Impl {
        private Api18Impl() {
        }

        static IBinder getBinder(Bundle r0, String r1) {
            return r0.getBinder(r1);
        }

        static void putBinder(Bundle r2, String r3, IBinder r4) {
            r2.putBinder(r3, (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.memorydata.plugin"));
        }
    }

    static class Api33Impl {
        private Api33Impl() {
        }

        static <T> T getParcelable(Bundle r0, String r1, Class<T> r2) {
            return (T) r0.getParcelable(r1, r2);
        }

        static <T> T[] getParcelableArray(Bundle r0, String r1, Class<T> r2) {
            return (T[]) r0.getParcelableArray(r1, r2);
        }

        static <T> ArrayList<T> getParcelableArrayList(Bundle r0, String r1, Class<? extends T> r2) {
            return r0.getParcelableArrayList(r1, r2);
        }

        static <T> SparseArray<T> getSparseParcelableArray(Bundle r0, String r1, Class<? extends T> r2) {
            return r0.getSparseParcelableArray(r1, r2);
        }
    }

    static class BeforeApi18Impl {
        private static final String TAG = "BundleCompat";
        private static Method sGetIBinderMethod;
        private static boolean sGetIBinderMethodFetched;
        private static Method sPutIBinderMethod;
        private static boolean sPutIBinderMethodFetched;

        private BeforeApi18Impl() {
        }

        public static IBinder getBinder(Bundle r7, String r8) {
            if (sGetIBinderMethodFetched == false) goto L18;
        L9:
            Method r0 = sGetIBinderMethod;
            if (r0 != null) goto L16;
        L15:
            return null;
        L16:
            return (IBinder) ZeusTransformUtils.preCheckCast(r0.invoke(r7, new Object[]{r8}), IBinder.class, "com.obric.memorydata.plugin");
        L13:
            e = move-exception;
            Log.i(TAG, "Failed to invoke getIBinder via reflection", e);
            sGetIBinderMethod = null;
            goto L15
        L18:
            Method r1 = Bundle.class.getMethod("getIBinder", new Class[]{String.class});     // Catch: NoSuchMethodException -> L6
            sGetIBinderMethod = r1;     // Catch: NoSuchMethodException -> L6
            r1.setAccessible(true);     // Catch: NoSuchMethodException -> L6
        L8:
            sGetIBinderMethodFetched = true;
        L6:
            e = move-exception;
            Log.i(TAG, "Failed to retrieve getIBinder method", e);
            goto L8
        }

        public static void putBinder(Bundle r8, String r9, IBinder r10) {
            IBinder r11 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r10, IBinder.class, "com.obric.memorydata.plugin");
            if (sPutIBinderMethodFetched == false) goto L16;
        L9:
            Method r0 = sPutIBinderMethod;
            if (r0 == null) goto L20;
            r0.invoke(r8, new Object[]{r9, r11});     // Catch: Throwable -> L13
            return;
        L13:
            e = move-exception;
            Log.i(TAG, "Failed to invoke putIBinder via reflection", e);
            sPutIBinderMethod = null;
            return;
        L20:
            return;
        L16:
            Method r1 = Bundle.class.getMethod("putIBinder", new Class[]{String.class, IBinder.class});     // Catch: NoSuchMethodException -> L6
            sPutIBinderMethod = r1;     // Catch: NoSuchMethodException -> L6
            r1.setAccessible(true);     // Catch: NoSuchMethodException -> L6
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

    public static IBinder getBinder(Bundle r2, String r3) {
        if (Build.VERSION.SDK_INT < 18) goto L7;
        return Api18Impl.getBinder(r2, r3);
    L7:
        return BeforeApi18Impl.getBinder(r2, r3);
    }

    public static <T> T getParcelable(Bundle r2, String r3, Class<T> r4) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        T r5 = (T) r2.getParcelable(r3);
        if (ZeusTransformUtils.instanceOf(r4, r5) == true) goto L11;
        return null;
    L11:
        return r5;
    L5:
        return (T) Api33Impl.getParcelable(r2, r3, r4);
    }

    public static Parcelable[] getParcelableArray(Bundle r2, String r3, Class<? extends Parcelable> r4) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return (Parcelable[]) ZeusTransformUtils.preCheckCast(Api33Impl.getParcelableArray(r2, r3, r4), Parcelable[].class, "com.obric.memorydata.plugin");
    L7:
        return r2.getParcelableArray(r3);
    }

    public static <T> ArrayList<T> getParcelableArrayList(Bundle r2, String r3, Class<? extends T> r4) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api33Impl.getParcelableArrayList(r2, r3, r4);
    L7:
        return r2.getParcelableArrayList(r3);
    }

    public static <T> SparseArray<T> getSparseParcelableArray(Bundle r2, String r3, Class<? extends T> r4) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api33Impl.getSparseParcelableArray(r2, r3, r4);
    L7:
        return r2.getSparseParcelableArray(r3);
    }

    public static void putBinder(Bundle r2, String r3, IBinder r4) {
        IBinder r5 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 18) goto L5;
        Api18Impl.putBinder(r2, r3, r5);
        return;
    L5:
        BeforeApi18Impl.putBinder(r2, r3, r5);
    }
}
