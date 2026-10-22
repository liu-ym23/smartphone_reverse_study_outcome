package com.obric.cae.wifi;

import android.content.Context;
import android.util.Log;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetEvaluate;
import com.obric.cae.smartNetwork.networkHandoverRL.feature.FeatureData;

/* JADX INFO: loaded from: classes2.dex */
public class WifiL4QoEFeatureCollector {
    private static final String TAG = "WifiL4QoEFeatureCollector";
    private final Context mContext;
    private final L4NetEvaluate mL4NetEvaluate;
    private volatile L4NetEvaluate.L4NetStats mLatestWifiL4Info;
    private final L4NetEvaluate.L4NetErrReportCb mNetErrReportCb;

    public WifiL4QoEFeatureCollector(Context r8) {
        this.mNetErrReportCb = new AnonymousClass1(this);
        Context r10 = r8.getApplicationContext();
        this.mContext = r10;
        this.mL4NetEvaluate = L4NetEvaluate.getInstance(r10);
    }

    public static /* synthetic */ L4NetEvaluate.L4NetStats access$002(WifiL4QoEFeatureCollector r8, L4NetEvaluate.L4NetStats r10) {
        r8.mLatestWifiL4Info = r10;
        return r10;
    }

    public FeatureData collectFeatureData() {
        L4NetEvaluate.L4NetStats r8 = this.mLatestWifiL4Info;
        if (r8 != null) goto L7;
        CaeLog.e(TAG, "Invalid feature data. mLatestWifiL4Info is null");
        return null;
    L7:
        return new FeatureData.Builder().setWifiL4Rtt(r8.rttAve).setWifiL4RetryRate(r8.sendRetrans).setWifiL4SendPkts(r8.sendPackets).setWifiL4RecvPkts(r8.recvPackets).setWifiL4SendSpeed(r8.sendRate).setWifiL4RecvSpeed(r8.recvRate).setWifiL4RecvOooRate(r8.recvOooPercent).setWifiL4UnackPkts(r8.unacked).build();
    }

    public void initialize() {
        Log.d(TAG, "WifiL4QoEFeatureCollector initialized");
        this.mL4NetEvaluate.registerErrReportCb(this.mNetErrReportCb);
    }

    public void release() {
        Log.d(TAG, "WifiL4QoEFeatureCollector released");
        this.mL4NetEvaluate.unregisterErrReportCb(this.mNetErrReportCb);
    }
}
