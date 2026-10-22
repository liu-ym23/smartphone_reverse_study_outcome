package com.ttnet.org.chromium.net;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.HandlerThread;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.ttnet.org.chromium.base.ApplicationStatus;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.ThreadUtils;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("net::android")
public class AndroidCellularSignalStrength {
    private static final AndroidCellularSignalStrength sInstance = null;
    private volatile int mSignalLevel;

    public class CellStateListener extends PhoneStateListener implements ApplicationStatus.ApplicationStateListener {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final TelephonyManager mTelephonyManager;
        final /* synthetic */ AndroidCellularSignalStrength this$0;

        public CellStateListener(AndroidCellularSignalStrength r8) {
            this.this$0 = r8;
            ThreadUtils.assertOnBackgroundThread();
            TelephonyManager r10 = (TelephonyManager) ContextUtils.getApplicationContext().getSystemService("phone");
            this.mTelephonyManager = r10;
            if (r10.getSimState() == 5) goto L5;
            return;
        L5:
            ApplicationStatus.registerApplicationStateListener(this);
            onApplicationStateChange(ApplicationStatus.getStateForApplication());
        }

        private void register() {
            this.mTelephonyManager.listen(this, 256);
        }

        private void unregister() {
            AndroidCellularSignalStrength.access$002(this.this$0, Integer.MIN_VALUE);
            this.mTelephonyManager.listen(this, 0);
        }

        @Override // com.ttnet.org.chromium.base.ApplicationStatus.ApplicationStateListener
        public void onApplicationStateChange(int r8) {
            if (r8 != 1) goto L6;
            register();
            return;
        L6:
            if (r8 != 2) goto L10;
            unregister();
            return;
        }

        @Override // android.telephony.PhoneStateListener
        @TargetApi(23)
        public void onSignalStrengthsChanged(SignalStrength r8) {
            if (ApplicationStatus.getStateForApplication() == 1) goto L9;
            return;
        L9:
            AndroidCellularSignalStrength.access$002(this.this$0, r8.getLevel());     // Catch: SecurityException -> L7
            return;
        L7:
            AndroidCellularSignalStrength.access$002(this.this$0, Integer.MIN_VALUE);
        }
    }

    static {
        sInstance = new AndroidCellularSignalStrength();
    }

    private AndroidCellularSignalStrength() {
        this.mSignalLevel = Integer.MIN_VALUE;
        HandlerThread r8 = new HandlerThread("AndroidCellularSignalStrength");
        r8.start();
        new Handler(r8.getLooper()).post(new AnonymousClass1(this));
    }

    public static /* synthetic */ int access$002(AndroidCellularSignalStrength r8, int r10) {
        r8.mSignalLevel = r10;
        return r10;
    }

    @CalledByNative
    @TargetApi(23)
    private static int getSignalStrengthLevel() {
        return sInstance.mSignalLevel;
    }
}
