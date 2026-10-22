package com.obric.cae.smartNetwork.qoe;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.obric.cae.log.CaeLog;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class CellularQoEStateTracker implements NetworkQoEStateTraker {
    private static final String TAG = "CellularQoEStateTracker";
    private final Set<CellularQoECallback> mCellularQoECallbackSet;
    private Context mContext;
    private final PhoneStateListener mPhoneStateListener;
    private TelephonyManager mTelephonyManager;

    public CellularQoEStateTracker(Context r8) {
        this.mCellularQoECallbackSet = new CopyOnWriteArraySet();
        this.mContext = r8;
        this.mTelephonyManager = (TelephonyManager) r8.getSystemService("phone");
        final Executor r10 = this.mContext.getMainExecutor();
        this.mPhoneStateListener = new AnonymousClass1(this, r10);
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public static /* synthetic */ Set access$100(CellularQoEStateTracker r8) {
        return r8.mCellularQoECallbackSet;
    }

    public void registerQoECallback(CellularQoECallback r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        this.mCellularQoECallbackSet.add(r8);
    }

    @Override // com.obric.cae.smartNetwork.qoe.NetworkQoEStateTraker
    public void startTracker() {
        if (this.mTelephonyManager != null) goto L6;
        Log.e(TAG, "TelephonyManager is null");
        return;
    L6:
        CaeLog.d(TAG, "start");
        this.mTelephonyManager.listen(this.mPhoneStateListener, 256);
    }

    @Override // com.obric.cae.smartNetwork.qoe.NetworkQoEStateTraker
    public void stopTracker() {
        if (this.mTelephonyManager != null) goto L6;
        CaeLog.e(TAG, "TelephonyManager is null");
        return;
    L6:
        CaeLog.d(TAG, "stop");
        this.mTelephonyManager.listen(this.mPhoneStateListener, 0);
    }

    public void unRegisterQoECallback(CellularQoECallback r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        this.mCellularQoECallbackSet.remove(r8);
    }
}
