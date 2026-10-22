package androidx.core.hardware.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class FingerprintManagerCompat {
    private final Context mContext;

    static class Api23Impl {
        private Api23Impl() {
        }

        static void authenticate(Object r8, Object r9, CancellationSignal r10, int r11, Object r12, Handler r13) {
            ((FingerprintManager) ZeusTransformUtils.preCheckCast(r8, FingerprintManager.class, "com.obric.memorydata.plugin")).authenticate((FingerprintManager.CryptoObject) ZeusTransformUtils.preCheckCast(r9, FingerprintManager.CryptoObject.class, "com.obric.memorydata.plugin"), r10, r11, (FingerprintManager.AuthenticationCallback) ZeusTransformUtils.preCheckCast(r12, FingerprintManager.AuthenticationCallback.class, "com.obric.memorydata.plugin"), r13);
        }

        static FingerprintManager.CryptoObject getCryptoObject(Object r2) {
            return ((FingerprintManager.AuthenticationResult) ZeusTransformUtils.preCheckCast(r2, FingerprintManager.AuthenticationResult.class, "com.obric.memorydata.plugin")).getCryptoObject();
        }

        public static FingerprintManager getFingerprintManagerOrNull(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            if (Build.VERSION.SDK_INT != 23) goto L7;
        L5:
            return (FingerprintManager) ZeusTransformUtils.preCheckCast(r4.getSystemService(FingerprintManager.class), FingerprintManager.class, "com.obric.memorydata.plugin");
        L7:
            if (Build.VERSION.SDK_INT > 23) goto L9;
            return null;
        L9:
            if (r4.getPackageManager().hasSystemFeature("android.hardware.fingerprint") == true) goto L5;
            return null;
        }

        static boolean hasEnrolledFingerprints(Object r2) {
            return ((FingerprintManager) ZeusTransformUtils.preCheckCast(r2, FingerprintManager.class, "com.obric.memorydata.plugin")).hasEnrolledFingerprints();
        }

        static boolean isHardwareDetected(Object r2) {
            return ((FingerprintManager) ZeusTransformUtils.preCheckCast(r2, FingerprintManager.class, "com.obric.memorydata.plugin")).isHardwareDetected();
        }

        public static CryptoObject unwrapCryptoObject(Object r2) {
            FingerprintManager.CryptoObject r3 = (FingerprintManager.CryptoObject) ZeusTransformUtils.preCheckCast(r2, FingerprintManager.CryptoObject.class, "com.obric.memorydata.plugin");
            if (r3 != null) goto L6;
            return null;
        L6:
            if (r3.getCipher() == null) goto L10;
            return new CryptoObject(r3.getCipher());
        L10:
            if (r3.getSignature() == null) goto L14;
            return new CryptoObject(r3.getSignature());
        L14:
            if (r3.getMac() != null) goto L16;
            return null;
        L16:
            return new CryptoObject(r3.getMac());
        }

        public static FingerprintManager.CryptoObject wrapCryptoObject(CryptoObject r2) {
            if (r2 != null) goto L6;
            return null;
        L6:
            if (r2.getCipher() == null) goto L10;
            return new FingerprintManager.CryptoObject(r2.getCipher());
        L10:
            if (r2.getSignature() == null) goto L14;
            return new FingerprintManager.CryptoObject(r2.getSignature());
        L14:
            if (r2.getMac() != null) goto L16;
            return null;
        L16:
            return new FingerprintManager.CryptoObject(r2.getMac());
        }
    }

    public static abstract class AuthenticationCallback {
        public AuthenticationCallback() {
        }

        public void onAuthenticationError(int r1, CharSequence r2) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationHelp(int r1, CharSequence r2) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        }

        public void onAuthenticationSucceeded(AuthenticationResult r1) {
        }
    }

    public static final class AuthenticationResult {
        private final CryptoObject mCryptoObject;

        public AuthenticationResult(CryptoObject r1) {
            this.mCryptoObject = r1;
        }

        public CryptoObject getCryptoObject() {
            return this.mCryptoObject;
        }
    }

    public static class CryptoObject {
        private final Cipher mCipher;
        private final Mac mMac;
        private final Signature mSignature;

        public CryptoObject(Signature r1) {
            this.mSignature = r1;
            this.mCipher = null;
            this.mMac = null;
        }

        public CryptoObject(Cipher r1) {
            this.mCipher = r1;
            this.mSignature = null;
            this.mMac = null;
        }

        public CryptoObject(Mac r1) {
            this.mMac = r1;
            this.mCipher = null;
            this.mSignature = null;
        }

        public Cipher getCipher() {
            return this.mCipher;
        }

        public Mac getMac() {
            return this.mMac;
        }

        public Signature getSignature() {
            return this.mSignature;
        }
    }

    private FingerprintManagerCompat(Context r3) {
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    public static FingerprintManagerCompat from(Context r2) {
        return new FingerprintManagerCompat((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    private static FingerprintManager getFingerprintManagerOrNull(Context r2) {
        return Api23Impl.getFingerprintManagerOrNull((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    static CryptoObject unwrapCryptoObject(FingerprintManager.CryptoObject r0) {
        return Api23Impl.unwrapCryptoObject(r0);
    }

    private static FingerprintManager.AuthenticationCallback wrapCallback(final AuthenticationCallback r1) {
        return new AnonymousClass1(r1);
    }

    private static FingerprintManager.CryptoObject wrapCryptoObject(CryptoObject r0) {
        return Api23Impl.wrapCryptoObject(r0);
    }

    public void authenticate(CryptoObject r7, int r8, androidx.core.os.CancellationSignal r9, AuthenticationCallback r10, Handler r11) {
        if (Build.VERSION.SDK_INT < 23) goto L11;
        FingerprintManager r0 = getFingerprintManagerOrNull(this.mContext);
        if (r0 == null) goto L12;
        if (r9 == null) goto L8;
        CancellationSignal r6 = (CancellationSignal) ZeusTransformUtils.preCheckCast(r9.getCancellationSignalObject(), CancellationSignal.class, "com.obric.memorydata.plugin");
    L9:
        FingerprintManager.CryptoObject r1 = wrapCryptoObject(r7);
        Api23Impl.authenticate(r0, r1, r6, r8, wrapCallback(r10), r11);
        return;
    L8:
        r6 = null;
        goto L9
    L12:
        return;
    }

    public boolean hasEnrolledFingerprints() {
        if (Build.VERSION.SDK_INT < 23) goto L10;
        FingerprintManager r3 = getFingerprintManagerOrNull(this.mContext);
        if (r3 != null) goto L7;
        return false;
    L7:
        if (Api23Impl.hasEnrolledFingerprints(r3) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public boolean isHardwareDetected() {
        if (Build.VERSION.SDK_INT < 23) goto L10;
        FingerprintManager r3 = getFingerprintManagerOrNull(this.mContext);
        if (r3 != null) goto L7;
        return false;
    L7:
        if (Api23Impl.isHardwareDetected(r3) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }
}
