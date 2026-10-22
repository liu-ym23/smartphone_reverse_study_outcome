package com.obric.cae.statusReport.network;

import android.content.Context;
import com.obric.cae.log.CaeLog;
import com.obric.cae.network.CaeNetworkHandoverData;
import com.obric.cae.network.CaeNetworkHandoverProto;
import com.obric.cae.network.ClusterData;
import com.obric.cae.smartNetwork.networkHandoverRL.feature.ClusteringFeatureManager;
import com.obric.cae.utils.CaeUtil;
import defpackage.b;

/* JADX INFO: loaded from: classes2.dex */
public class UserClusterReport {
    private static final String TAG = "UserClusterReport";
    private static volatile UserClusterReport mUserClusterReport;
    private final Context mContext;

    private UserClusterReport(Context r8) {
        this.mContext = r8;
    }

    private CaeNetworkHandoverProto buildHandoverData(ClusterData r8) {
        CaeNetworkHandoverData.Builder r10 = CaeNetworkHandoverData.newBuilder();
        r10.setClusterEvent(r8);
        return CaeNetworkHandoverProto.newBuilder().addNetworkHandoverEvent(r10).build();
    }

    public static UserClusterReport getInstance(Context r8) {
        if (mUserClusterReport != null) goto L15;
        monitor-enter(UserClusterReport.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mUserClusterReport != null) goto L9;
        mUserClusterReport = new UserClusterReport(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(UserClusterReport.class);     // Catch: Throwable -> L11
    L15:
        return mUserClusterReport;
    }

    public void reportClusterResult(int r8, ClusteringFeatureManager.TrafficFeature r10) {
        if (r10 != null) goto L6;
        CaeLog.e(TAG, "reportClusterResult: trafficFeature is null");
        return;
    L6:
        ClusterData.Builder r11 = ClusterData.newBuilder();
        r11.setTimestamp(System.currentTimeMillis());
        r11.setClusterId(r8);
        r11.setDay7CellDataUsed(r10.day7CellDataUsed);
        r11.setDay7WifiDataUsed(r10.day7WifiDataUsed);
        r11.setDay7SocialCellDataUsed(r10.day7SocialCellDataUsed);
        r11.setDay7VideoCellDataUsed(r10.day7VideoCellDataUsed);
        r11.setDay7NewsCellDataUsed(r10.day7NewsCellDataUsed);
        r11.setDay7GameCellDataUsed(r10.day7GameCellDataUsed);
        r11.setDay7SocialWifiDataUsed(r10.day7SocialWifiDataUsed);
        r11.setDay7VideoWifiDataUsed(r10.day7VideoWifiDataUsed);
        r11.setDay7NewsWifiDataUsed(r10.day7NewsWifiDataUsed);
        r11.setDay7GameWifiDataUsed(r10.day7GameWifiDataUsed);
        CaeNetworkHandoverProto r12 = buildHandoverData(r11.build());
        StringBuilder r13 = b.f("reportClusterResult: cluster = ", r8, ", Feature = ");
        r13.append(r10.toString());
        CaeLog.i(TAG, r13.toString());
        CaeUtil.writePbEventSafely(System.currentTimeMillis(), 95, r12.toByteArray());
    }
}
