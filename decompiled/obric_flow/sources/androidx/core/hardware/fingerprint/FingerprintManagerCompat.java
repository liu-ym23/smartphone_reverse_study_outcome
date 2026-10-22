package androidx.core.hardware.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@Deprecated
public class FingerprintManagerCompat {
    private final Context mContext;

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @RequiresPermission("android.permission.USE_FINGERPRINT")
        @DoNotInline
        public static void authenticate(Object r10, Object r11, CancellationSignal r12, int r13, Object r14, Handler r15) {
            ((FingerprintManager) r10).authenticate((FingerprintManager.CryptoObject) r11, r12, r13, (FingerprintManager.AuthenticationCallback) r14, r15);
        }

        @DoNotInline
        public static FingerprintManager.CryptoObject getCryptoObject(Object r5) {
            return ((FingerprintManager.AuthenticationResult) r5).getCryptoObject();
        }

        @DoNotInline
        public static FingerprintManager getFingerprintManagerOrNull(Context r5) {
            if (r5.getPackageManager().hasSystemFeature("android.hardware.fingerprint") == true) goto L5;
            return null;
        L5:
            return (FingerprintManager) r5.getSystemService(FingerprintManager.class);
        }

        @RequiresPermission("android.permission.USE_FINGERPRINT")
        @DoNotInline
        public static boolean hasEnrolledFingerprints(Object r5) {
            return ((FingerprintManager) r5).hasEnrolledFingerprints();
        }

        @RequiresPermission("android.permission.USE_FINGERPRINT")
        @DoNotInline
        public static boolean isHardwareDetected(Object r5) {
            return ((FingerprintManager) r5).isHardwareDetected();
        }

        @DoNotInline
        public static CryptoObject unwrapCryptoObject(Object r5) {
            FingerprintManager.CryptoObject r10 = (FingerprintManager.CryptoObject) r5;
            if (r10 != null) goto L6;
            return null;
        L6:
            if (r10.getCipher() == null) goto L10;
            return new CryptoObject(r10.getCipher());
        L10:
            if (r10.getSignature() == null) goto L14;
            return new CryptoObject(r10.getSignature());
        L14:
            if (r10.getMac() != null) goto L16;
            return null;
        L16:
            return new CryptoObject(r10.getMac());
        }

        @DoNotInline
        public static FingerprintManager.CryptoObject wrapCryptoObject(CryptoObject r5) {
            if (r5 != null) goto L6;
            return null;
        L6:
            if (r5.getCipher() == null) goto L10;
            return new FingerprintManager.CryptoObject(r5.getCipher());
        L10:
            if (r5.getSignature() == null) goto L14;
            return new FingerprintManager.CryptoObject(r5.getSignature());
        L14:
            if (r5.getMac() != null) goto L16;
            return null;
        L16:
            return new FingerprintManager.CryptoObject(r5.getMac());
        }
    }

    public static abstract class AuthenticationCallback {
        public AuthenticationCallback() {
        }

        public void onAuthenticationError(int r5, @NonNull CharSequence r10) {
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationHelp(int r5, @NonNull CharSequence r10) {
        }

        public void onAuthenticationSucceeded(@NonNull AuthenticationResult r5) {
        }
    }

    public static final class AuthenticationResult {
        private final CryptoObject mCryptoObject;

        public AuthenticationResult(@NonNull CryptoObject r5) {
            this.mCryptoObject = r5;
        }

        @NonNull
        public CryptoObject getCryptoObject() {
            return this.mCryptoObject;
        }
    }

    public static class CryptoObject {
        private final Cipher mCipher;
        private final Mac mMac;
        private final Signature mSignature;

        public CryptoObject(@NonNull Signature r5) {
            this.mSignature = r5;
            this.mCipher = null;
            this.mMac = null;
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

        public CryptoObject(@NonNull Cipher r5) {
            this.mCipher = r5;
            this.mSignature = null;
            this.mMac = null;
        }

        public CryptoObject(@NonNull Mac r5) {
            this.mMac = r5;
            this.mCipher = null;
            this.mSignature = null;
        }
    }

    private FingerprintManagerCompat(Context r5) {
        this.mContext = r5;
    }

    @NonNull
    public static FingerprintManagerCompat from(@NonNull Context r5) {
        return new FingerprintManagerCompat(r5);
    }

    @Nullable
    @RequiresApi(23)
    private static FingerprintManager getFingerprintManagerOrNull(@NonNull Context r5) {
        return Api23Impl.getFingerprintManagerOrNull(r5);
    }

    @RequiresApi(23)
    public static CryptoObject unwrapCryptoObject(FingerprintManager.CryptoObject r5) {
        return Api23Impl.unwrapCryptoObject(r5);
    }

    @RequiresApi(23)
    private static FingerprintManager.AuthenticationCallback wrapCallback(final AuthenticationCallback r5) {
        return new AnonymousClass1(r5);
    }

    @RequiresApi(23)
    private static FingerprintManager.CryptoObject wrapCryptoObject(CryptoObject r5) {
        return Api23Impl.wrapCryptoObject(r5);
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public void authenticate(@Nullable CryptoObject r10, int r11, @Nullable androidx.core.os.CancellationSignal r12, @NonNull AuthenticationCallback r13, @Nullable Handler r14) {
        if (r12 == null) goto L5;
        CancellationSignal r15 = (CancellationSignal) r12.getCancellationSignalObject();
    L6:
        authenticate(r10, r11, r15, r13, r14);
        return;
    L5:
        r15 = null;
        goto L6
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    public boolean hasEnrolledFingerprints() {
        FingerprintManager r5 = getFingerprintManagerOrNull(this.mContext);
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (Api23Impl.hasEnrolledFingerprints(r5) == false) goto L7;
        return true;
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    public boolean isHardwareDetected() {
        FingerprintManager r5 = getFingerprintManagerOrNull(this.mContext);
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (Api23Impl.isHardwareDetected(r5) == false) goto L7;
        return true;
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    public void authenticate(@Nullable CryptoObject r10, int r11, @Nullable CancellationSignal r12, @NonNull AuthenticationCallback r13, @Nullable Handler r14) {
        FingerprintManager r5 = getFingerprintManagerOrNull(this.mContext);
        if (r5 == null) goto L6;
        Api23Impl.authenticate(r5, wrapCryptoObject(r10), r12, r11, wrapCallback(r13), r14);
        return;
    }
}
