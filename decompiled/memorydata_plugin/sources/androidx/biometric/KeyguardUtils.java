package androidx.biometric;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class KeyguardUtils {

    private static class Api16Impl {
        private Api16Impl() {
        }

        static boolean isKeyguardSecure(KeyguardManager r0) {
            return r0.isKeyguardSecure();
        }
    }

    private static class Api23Impl {
        private Api23Impl() {
        }

        static KeyguardManager getKeyguardManager(Context r2) {
            return (KeyguardManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSystemService(KeyguardManager.class), KeyguardManager.class, "com.obric.memorydata.plugin");
        }

        static boolean isDeviceSecure(KeyguardManager r0) {
            return r0.isDeviceSecure();
        }
    }

    private KeyguardUtils() {
    }

    static KeyguardManager getKeyguardManager(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        Object r5 = r4.getSystemService("keyguard");
        if (ZeusTransformUtils.instanceOf(r5, KeyguardManager.class) == true) goto L11;
        return null;
    L11:
        return (KeyguardManager) ZeusTransformUtils.preCheckCast(r5, KeyguardManager.class, "com.obric.memorydata.plugin");
    L5:
        return Api23Impl.getKeyguardManager(r4);
    }

    static boolean isDeviceSecuredWithCredential(Context r3) {
        KeyguardManager r4 = getKeyguardManager((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        if (r4 != null) goto L6;
        return false;
    L6:
        if (Build.VERSION.SDK_INT < 23) goto L10;
        return Api23Impl.isDeviceSecure(r4);
    L10:
        if (Build.VERSION.SDK_INT >= 16) goto L12;
        return false;
    L12:
        return Api16Impl.isKeyguardSecure(r4);
    }
}
