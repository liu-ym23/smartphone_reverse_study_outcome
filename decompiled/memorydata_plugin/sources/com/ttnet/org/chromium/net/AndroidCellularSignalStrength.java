package com.ttnet.org.chromium.net;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.ttnet.org.chromium.base.ApplicationStatus;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.ThreadUtils;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
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

        CellStateListener(AndroidCellularSignalStrength r3) {
            this.this$0 = r3;
            ThreadUtils.assertOnBackgroundThread();
            TelephonyManager r4 = (TelephonyManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService(MemoryKeyInfoEntity.KEY_PHONE), TelephonyManager.class, "com.obric.memorydata.plugin");
            this.mTelephonyManager = r4;
            if (r4.getSimState() == 5) goto L5;
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
        public void onApplicationStateChange(int r2) {
            if (r2 != 1) goto L6;
            register();
            return;
        L6:
            if (r2 != 2) goto L10;
            unregister();
            return;
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength r3) {
            if (ApplicationStatus.getStateForApplication() == 1) goto L9;
            return;
        L9:
            AndroidCellularSignalStrength.access$002(this.this$0, r3.getLevel());     // Catch: SecurityException -> L7
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
        HandlerThread r0 = new HandlerThread("AndroidCellularSignalStrength");
        r0.start();
        new Handler(r0.getLooper()).post(new AnonymousClass1(this));
    }

    static /* synthetic */ int access$002(AndroidCellularSignalStrength r0, int r1) {
        r0.mSignalLevel = r1;
        return r1;
    }

    private static int getSignalStrengthLevel() {
        return sInstance.mSignalLevel;
    }
}
