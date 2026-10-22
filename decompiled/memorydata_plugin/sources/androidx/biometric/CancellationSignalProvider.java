package androidx.biometric;

import android.os.Build;
import android.os.CancellationSignal;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class CancellationSignalProvider {
    private static final String TAG = "CancelSignalProvider";
    private CancellationSignal mBiometricCancellationSignal;
    private androidx.core.os.CancellationSignal mFingerprintCancellationSignal;
    private final Injector mInjector;

    private static class Api16Impl {
        private Api16Impl() {
        }

        static void cancel(CancellationSignal r0) {
            r0.cancel();
        }

        static CancellationSignal create() {
            return new CancellationSignal();
        }
    }

    interface Injector {
        CancellationSignal getBiometricCancellationSignal();

        androidx.core.os.CancellationSignal getFingerprintCancellationSignal();
    }

    CancellationSignalProvider() {
        this.mInjector = new AnonymousClass1(this);
    }

    CancellationSignalProvider(Injector r3) {
        this.mInjector = (Injector) ZeusTransformUtils.wrapperContextForParams(r3, Injector.class, "com.obric.memorydata.plugin");
    }

    void cancel() {
        if (Build.VERSION.SDK_INT < 16) goto L11;
        CancellationSignal r0 = this.mBiometricCancellationSignal;
        if (r0 == null) goto L11;
        Api16Impl.cancel(r0);     // Catch: NullPointerException -> L8
    L10:
        this.mBiometricCancellationSignal = null;
    L8:
        e = move-exception;
        Log.e(TAG, "Got NPE while canceling biometric authentication.", e);
    L11:
        androidx.core.os.CancellationSignal r1 = this.mFingerprintCancellationSignal;
        if (r1 == null) goto L23;
        r1.cancel();     // Catch: NullPointerException -> L15
    L17:
        this.mFingerprintCancellationSignal = null;
        return;
    L15:
        e = move-exception;
        Log.e(TAG, "Got NPE while canceling fingerprint authentication.", e);
        goto L17
    }

    CancellationSignal getBiometricCancellationSignal() {
        if (this.mBiometricCancellationSignal != null) goto L6;
        this.mBiometricCancellationSignal = this.mInjector.getBiometricCancellationSignal();
    L6:
        return this.mBiometricCancellationSignal;
    }

    androidx.core.os.CancellationSignal getFingerprintCancellationSignal() {
        if (this.mFingerprintCancellationSignal != null) goto L6;
        this.mFingerprintCancellationSignal = this.mInjector.getFingerprintCancellationSignal();
    L6:
        return this.mFingerprintCancellationSignal;
    }
}
