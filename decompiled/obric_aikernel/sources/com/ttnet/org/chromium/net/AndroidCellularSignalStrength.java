package com.ttnet.org.chromium.net;

import android.annotation.TargetApi;
import android.os.Build;
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

    private class CellStateListener extends PhoneStateListener implements ApplicationStatus.ApplicationStateListener {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final TelephonyManager mTelephonyManager;
        final /* synthetic */ AndroidCellularSignalStrength this$0;

        static {
        }

        CellStateListener(AndroidCellularSignalStrength r10) {
            this.this$0 = r10;
            ThreadUtils.assertOnBackgroundThread();
            TelephonyManager r11 = (TelephonyManager) ContextUtils.getApplicationContext().getSystemService("phone");
            this.mTelephonyManager = r11;
            if (r11.getSimState() == 5) goto L5;
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
        public void onApplicationStateChange(int r10) {
            if (r10 != 1) goto L6;
            register();
            return;
        L6:
            if (r10 != 2) goto L10;
            unregister();
            return;
        }

        @Override // android.telephony.PhoneStateListener
        @TargetApi(23)
        public void onSignalStrengthsChanged(SignalStrength r10) {
            if (ApplicationStatus.getStateForApplication() == 1) goto L9;
            return;
        L9:
            AndroidCellularSignalStrength.access$002(this.this$0, r10.getLevel());     // Catch: SecurityException -> L7
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
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        return;
    L6:
        if (TTAppSecurityManager.getInstance().isUserPrivacyRestrictionEnabled() == false) goto L8;
        return;
    L8:
        HandlerThread r10 = new HandlerThread("AndroidCellularSignalStrength");
        r10.start();
        new Handler(r10.getLooper()).post(new AnonymousClass1(this));
    }

    static /* synthetic */ int access$002(AndroidCellularSignalStrength r10, int r11) {
        r10.mSignalLevel = r11;
        return r11;
    }

    @CalledByNative
    @TargetApi(23)
    private static int getSignalStrengthLevel() {
        return sInstance.mSignalLevel;
    }
}
