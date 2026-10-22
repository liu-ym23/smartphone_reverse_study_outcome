package com.obric.cae.statusReport.network;

import android.content.Context;
import com.obric.cae.log.CaeLog;
import com.obric.cae.network.CaeNetworkHandoverData;
import com.obric.cae.network.CaeNetworkHandoverProto;
import com.obric.cae.network.FeatureDataPb;
import com.obric.cae.network.SwitchFeedbackData;
import com.obric.cae.smartNetwork.networkHandoverRL.feature.FeatureData;
import com.obric.cae.utils.CaeUtil;

/* JADX INFO: loaded from: classes2.dex */
public class HandoverFeedback {
    public static final int FEEDBACK_TYPE_NO_SWITCH_AND_INTERVENE = 3;
    public static final int FEEDBACK_TYPE_SWITCH_AND_INTERVENE = 2;
    public static final int FEEDBACK_TYPE_SWITCH_AND_NO_INTERVENE = 1;
    private static final String TAG = "HandoverFeedback";
    private static volatile HandoverFeedback mHandoverFeedback;
    private final Context mContext;

    private HandoverFeedback(Context r8) {
        this.mContext = r8;
    }

    private FeatureDataPb buildFeatureData(FeatureData r8) {
        return FeatureDataPb.newBuilder().setIndex(r8.getIndex()).setTimestamp(r8.getTimeStamp()).setCellUsedTraffic(r8.getCellUsedTraffic()).setCellRemainingTraffic(r8.getCellRemainingTraffic()).setPackageName(r8.getPackageName()).setAppCategory(r8.getAppCategory()).setD7CellAppUsed(r8.getD7CellAppUsed()).setD7CellTotalUsed(r8.getD7CellTotalUsed()).setD7TrafficAppUsed(r8.getD7TrafficAppUsed()).setAppSpeedRate(r8.getAppSpeedRate()).setTotalSpeedRate(r8.getTotalSpeedRate()).setCurLocation(r8.getCurLocation()).setWifiL2TxTput(r8.getWifiL2TxTput()).setWifiL2RxTput(r8.getWifiL2RxTput()).setWifiBand(r8.getWifiBand()).setWifiRssi(r8.getWifiRssi()).setWifiL4Rtt(r8.getWifiL4Rtt()).setWifiL4SendPkts(r8.getWifiL4SendPkts()).setWifiL4RecvPkts(r8.getWifiL4RecvPkts()).setWifiL4RecvOooRate(r8.getWifiL4RecvOooRate()).setWifiL4UnackPkts(r8.getWifiL4UnackPkts()).setWifiL4RetryRate(r8.getWifiL4RetryRate()).setWifiL4SendSpeed(r8.getWifiL4SendSpeed()).setWifiL4RecvSpeed(r8.getWifiL4RecvSpeed()).setCellL2State(r8.getCellL2State()).build();
    }

    private CaeNetworkHandoverProto buildHandoverData(SwitchFeedbackData r8) {
        CaeNetworkHandoverData.Builder r10 = CaeNetworkHandoverData.newBuilder().setSwitchFeedbackEvent(r8);
        return CaeNetworkHandoverProto.newBuilder().addNetworkHandoverEvent(r10).build();
    }

    public static HandoverFeedback getInstance(Context r8) {
        if (mHandoverFeedback != null) goto L15;
        monitor-enter(HandoverFeedback.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mHandoverFeedback != null) goto L9;
        mHandoverFeedback = new HandoverFeedback(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(HandoverFeedback.class);     // Catch: Throwable -> L11
    L15:
        return mHandoverFeedback;
    }

    public void reportNoSwitchAndInterveneEvent(int r8, long r10, FeatureData r11) {
        SwitchFeedbackData.Builder r12 = SwitchFeedbackData.newBuilder();
        r12.setSolutionType(r8);
        r12.setFeedbackType(3);
        r12.setSwitchInterveneTimestamp(r10);
        if (r11 == null) goto L5;
        r12.setSwitchInterveneFeature(buildFeatureData(r11));
    L5:
        CaeNetworkHandoverProto r13 = buildHandoverData(r12.build());
        CaeLog.i(TAG, "report handover feedback pb data. solutionType = " + r8 + " feedbackType = 3");
        CaeUtil.writePbEventSafely(System.currentTimeMillis(), 95, r13.toByteArray());
    }

    public void reportSwitchAndInterveneEvent(int r8, long r10, FeatureData r11, long r12, FeatureData r13) {
        SwitchFeedbackData.Builder r14 = SwitchFeedbackData.newBuilder();
        r14.setSolutionType(r8);
        r14.setFeedbackType(2);
        r14.setSwitchTimestamp(r10);
        r14.setSwitchInterveneTimestamp(r12);
        if (r11 == null) goto L5;
        r14.setSwitchFeature(buildFeatureData(r11));
    L5:
        if (r13 == null) goto L7;
        r14.setSwitchInterveneFeature(buildFeatureData(r13));
    L7:
        CaeNetworkHandoverProto r15 = buildHandoverData(r14.build());
        CaeLog.i(TAG, "report handover feedback pb data. solutionType = " + r8 + " feedbackType = 2");
        CaeUtil.writePbEventSafely(System.currentTimeMillis(), 95, r15.toByteArray());
    }

    public void reportSwitchAndNoInterveneEvent(int r8, long r10, FeatureData r11) {
        SwitchFeedbackData.Builder r12 = SwitchFeedbackData.newBuilder();
        r12.setSolutionType(r8);
        r12.setFeedbackType(1);
        r12.setSwitchTimestamp(r10);
        if (r11 == null) goto L5;
        r12.setSwitchFeature(buildFeatureData(r11));
    L5:
        CaeNetworkHandoverProto r13 = buildHandoverData(r12.build());
        CaeLog.i(TAG, "report handover feedback pb data. solutionType = " + r8 + " feedbackType = 1");
        CaeUtil.writePbEventSafely(System.currentTimeMillis(), 95, r13.toByteArray());
    }
}
