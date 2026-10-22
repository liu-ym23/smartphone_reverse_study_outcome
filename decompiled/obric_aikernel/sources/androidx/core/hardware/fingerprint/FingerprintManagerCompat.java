package androidx.core.hardware.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class FingerprintManagerCompat {
    private final Context mContext;

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @RequiresPermission("android.permission.USE_FINGERPRINT")
        @DoNotInline
        static void authenticate(Object r10, Object r11, CancellationSignal r12, int r13, Object r14, Handler r15) {
            ((FingerprintManager) r10).authenticate((FingerprintManager.CryptoObject) r11, r12, r13, (FingerprintManager.AuthenticationCallback) r14, r15);
        }

        @DoNotInline
        static FingerprintManager.CryptoObject getCryptoObject(Object r10) {
            return ((FingerprintManager.AuthenticationResult) r10).getCryptoObject();
        }

        @DoNotInline
        public static FingerprintManager getFingerprintManagerOrNull(Context r10) {
            int r11 = Build.VERSION.SDK_INT;
            if (r11 == 23) goto L5;
            if (r11 > 23) goto L8;
            return null;
        L8:
            if (r10.getPackageManager().hasSystemFeature("android.hardware.fingerprint") == true) goto L5;
            return null;
        L5:
            return (FingerprintManager) r10.getSystemService(FingerprintManager.class);
        }

        @RequiresPermission("android.permission.USE_FINGERPRINT")
        @DoNotInline
        static boolean hasEnrolledFingerprints(Object r10) {
            return ((FingerprintManager) r10).hasEnrolledFingerprints();
        }

        @RequiresPermission("android.permission.USE_FINGERPRINT")
        @DoNotInline
        static boolean isHardwareDetected(Object r10) {
            return ((FingerprintManager) r10).isHardwareDetected();
        }

        @DoNotInline
        public static CryptoObject unwrapCryptoObject(Object r10) {
            FingerprintManager.CryptoObject r11 = (FingerprintManager.CryptoObject) r10;
            if (r11 != null) goto L6;
            return null;
        L6:
            if (r11.getCipher() == null) goto L10;
            return new CryptoObject(r11.getCipher());
        L10:
            if (r11.getSignature() == null) goto L14;
            return new CryptoObject(r11.getSignature());
        L14:
            if (r11.getMac() != null) goto L16;
            return null;
        L16:
            return new CryptoObject(r11.getMac());
        }

        @DoNotInline
        public static FingerprintManager.CryptoObject wrapCryptoObject(CryptoObject r10) {
            if (r10 != null) goto L6;
            return null;
        L6:
            if (r10.getCipher() == null) goto L10;
            return new FingerprintManager.CryptoObject(r10.getCipher());
        L10:
            if (r10.getSignature() == null) goto L14;
            return new FingerprintManager.CryptoObject(r10.getSignature());
        L14:
            if (r10.getMac() != null) goto L16;
            return null;
        L16:
            return new FingerprintManager.CryptoObject(r10.getMac());
        }
    }

    public static abstract class AuthenticationCallback {
        public AuthenticationCallback() {
        }

        public void onAuthenticationError(int r10, CharSequence r11) {
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationHelp(int r10, CharSequence r11) {
        }

        public void onAuthenticationSucceeded(AuthenticationResult r10) {
        }
    }

    public static final class AuthenticationResult {
        private final CryptoObject mCryptoObject;

        public AuthenticationResult(CryptoObject r10) {
            this.mCryptoObject = r10;
        }

        public CryptoObject getCryptoObject() {
            return this.mCryptoObject;
        }
    }

    public static class CryptoObject {
        private final Cipher mCipher;
        private final Mac mMac;
        private final Signature mSignature;

        public CryptoObject(@NonNull Signature r10) {
            this.mSignature = r10;
            this.mCipher = null;
            this.mMac = null;
        }

        public CryptoObject(@NonNull Cipher r10) {
            this.mCipher = r10;
            this.mSignature = null;
            this.mMac = null;
        }

        public CryptoObject(@NonNull Mac r10) {
            this.mMac = r10;
            this.mCipher = null;
            this.mSignature = null;
        }

        @Nullable
        public Cipher getCipher() {
            return this.mCipher;
        }

        @Nullable
        public Mac getMac() {
            return this.mMac;
        }

        @Nullable
        public Signature getSignature() {
            return this.mSignature;
        }
    }

    private FingerprintManagerCompat(Context r10) {
        this.mContext = r10;
    }

    @NonNull
    public static FingerprintManagerCompat from(@NonNull Context r10) {
        return new FingerprintManagerCompat(r10);
    }

    @Nullable
    @RequiresApi(23)
    private static FingerprintManager getFingerprintManagerOrNull(@NonNull Context r10) {
        return Api23Impl.getFingerprintManagerOrNull(r10);
    }

    @RequiresApi(23)
    static CryptoObject unwrapCryptoObject(FingerprintManager.CryptoObject r10) {
        return Api23Impl.unwrapCryptoObject(r10);
    }

    @RequiresApi(23)
    private static FingerprintManager.AuthenticationCallback wrapCallback(final AuthenticationCallback r10) {
        return new AnonymousClass1(r10);
    }

    @RequiresApi(23)
    private static FingerprintManager.CryptoObject wrapCryptoObject(CryptoObject r10) {
        return Api23Impl.wrapCryptoObject(r10);
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    public void authenticate(@Nullable CryptoObject r10, int r11, @Nullable androidx.core.os.CancellationSignal r12, @NonNull AuthenticationCallback r13, @Nullable Handler r14) {
        if (Build.VERSION.SDK_INT < 23) goto L11;
        FingerprintManager r15 = getFingerprintManagerOrNull(this.mContext);
        if (r15 == null) goto L12;
        if (r12 == null) goto L8;
        CancellationSignal r16 = (CancellationSignal) r12.getCancellationSignalObject();
    L9:
        FingerprintManager.CryptoObject r17 = wrapCryptoObject(r10);
        Api23Impl.authenticate(r15, r17, r16, r11, wrapCallback(r13), r14);
        return;
    L8:
        r16 = null;
        goto L9
    L12:
        return;
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    public boolean hasEnrolledFingerprints() {
        if (Build.VERSION.SDK_INT < 23) goto L10;
        FingerprintManager r10 = getFingerprintManagerOrNull(this.mContext);
        if (r10 != null) goto L7;
        return false;
    L7:
        if (Api23Impl.hasEnrolledFingerprints(r10) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    public boolean isHardwareDetected() {
        if (Build.VERSION.SDK_INT < 23) goto L10;
        FingerprintManager r10 = getFingerprintManagerOrNull(this.mContext);
        if (r10 != null) goto L7;
        return false;
    L7:
        if (Api23Impl.isHardwareDetected(r10) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }
}
