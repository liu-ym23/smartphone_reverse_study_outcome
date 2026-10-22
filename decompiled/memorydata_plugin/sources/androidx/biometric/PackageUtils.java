package androidx.biometric;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class PackageUtils {

    private static class Api23Impl {
        private Api23Impl() {
        }

        static boolean hasSystemFeatureFingerprint(PackageManager r1) {
            return r1.hasSystemFeature("android.hardware.fingerprint");
        }
    }

    private static class Api29Impl {
        private Api29Impl() {
        }

        static boolean hasSystemFeatureFace(PackageManager r1) {
            return r1.hasSystemFeature("android.hardware.biometrics.face");
        }

        static boolean hasSystemFeatureIris(PackageManager r1) {
            return r1.hasSystemFeature("android.hardware.biometrics.iris");
        }
    }

    private PackageUtils() {
    }

    static boolean hasSystemFeatureFace(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 29) goto L10;
        if (r3 == null) goto L10;
        if (r3.getPackageManager() == null) goto L10;
        if (Api29Impl.hasSystemFeatureFace(r3.getPackageManager()) == false) goto L10;
        return true;
    L10:
        return false;
    }

    static boolean hasSystemFeatureFingerprint(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 23) goto L10;
        if (r3 == null) goto L10;
        if (r3.getPackageManager() == null) goto L10;
        if (Api23Impl.hasSystemFeatureFingerprint(r3.getPackageManager()) == false) goto L10;
        return true;
    L10:
        return false;
    }

    static boolean hasSystemFeatureIris(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 29) goto L10;
        if (r3 == null) goto L10;
        if (r3.getPackageManager() == null) goto L10;
        if (Api29Impl.hasSystemFeatureIris(r3.getPackageManager()) == false) goto L10;
        return true;
    L10:
        return false;
    }
}
