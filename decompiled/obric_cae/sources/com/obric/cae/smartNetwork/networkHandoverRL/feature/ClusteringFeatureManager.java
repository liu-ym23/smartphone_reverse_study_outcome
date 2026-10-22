package com.obric.cae.smartNetwork.networkHandoverRL.feature;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class ClusteringFeatureManager {
    private static final String TAG = "ClusteringFeatureManager";
    private static volatile ClusteringFeatureManager sInstance;
    private final DataUsageQuery mDataUsageQuery;

    public static class TrafficFeature {
        public long day7CellDataUsed;
        public long day7GameCellDataUsed;
        public long day7GameWifiDataUsed;
        public long day7NewsCellDataUsed;
        public long day7NewsWifiDataUsed;
        public long day7SocialCellDataUsed;
        public long day7SocialWifiDataUsed;
        public long day7VideoCellDataUsed;
        public long day7VideoWifiDataUsed;
        public long day7WifiDataUsed;

        public TrafficFeature(long r8, long r10, long r11, long r12, long r13, long r14, long r16, long r18, long r20, long r22) {
            this.day7CellDataUsed = r8;
            this.day7WifiDataUsed = r10;
            this.day7SocialCellDataUsed = r11;
            this.day7VideoCellDataUsed = r12;
            this.day7NewsCellDataUsed = r13;
            this.day7GameCellDataUsed = r14;
            this.day7SocialWifiDataUsed = r16;
            this.day7VideoWifiDataUsed = r18;
            this.day7NewsWifiDataUsed = r20;
            this.day7GameWifiDataUsed = r22;
        }

        public String toString() {
            return "TrafficFeature{day7CellDataUsed=" + this.day7CellDataUsed + "MB, day7WifiDataUsed=" + this.day7WifiDataUsed + "MB, day7SocialCellDataUsed=" + this.day7SocialCellDataUsed + "MB, day7VideoCellDataUsed=" + this.day7VideoCellDataUsed + "MB, day7NewsCellDataUsed=" + this.day7NewsCellDataUsed + "MB, day7GameCellDataUsed=" + this.day7GameCellDataUsed + "MB, day7SocialWifiDataUsed=" + this.day7SocialWifiDataUsed + "MB, day7VideoWifiDataUsed=" + this.day7VideoWifiDataUsed + "MB, day7NewsWifiDataUsed=" + this.day7NewsWifiDataUsed + "MB, day7GameWifiDataUsed=" + this.day7GameWifiDataUsed + "MB}";
        }
    }

    private ClusteringFeatureManager(Context r8) {
        this.mDataUsageQuery = new DataUsageQuery(r8);
    }

    public static ClusteringFeatureManager getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(ClusteringFeatureManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new ClusteringFeatureManager(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(ClusteringFeatureManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public TrafficFeature getTrafficFeature() {
        return new TrafficFeature(this.mDataUsageQuery.getTotalDataUsage(7, 0), this.mDataUsageQuery.getTotalDataUsage(7, 1), this.mDataUsageQuery.getCategoryDataUsage(7, 2, 0), this.mDataUsageQuery.getCategoryDataUsage(7, 1, 0), this.mDataUsageQuery.getCategoryDataUsage(7, 3, 0), this.mDataUsageQuery.getCategoryDataUsage(7, 4, 0), this.mDataUsageQuery.getCategoryDataUsage(7, 2, 1), this.mDataUsageQuery.getCategoryDataUsage(7, 1, 1), this.mDataUsageQuery.getCategoryDataUsage(7, 3, 1), this.mDataUsageQuery.getCategoryDataUsage(7, 4, 1));
    }
}
