package com.obric.cae.smartNetwork.networkHandoverRL.feature;

import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.os.RemoteException;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.obric.cae.log.CaeLog;
import defpackage.b;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class DataUsageQuery {
    private static final String TAG = "DataUsageQuery";
    private final Context mContext;
    private final NetworkStatsManager mNetworkStatsManager;
    private final TelephonyManager mTelephonyManager;

    public DataUsageQuery(Context r8) {
        this.mContext = r8;
        this.mTelephonyManager = (TelephonyManager) r8.getSystemService("phone");
        this.mNetworkStatsManager = (NetworkStatsManager) r8.getSystemService("netstats");
    }

    private long calculateAppDataUsage(NetworkStats r8, String r10) {
        long r11 = 0;
    L4:
        if (r8.hasNextBucket() == false) goto L9;
        NetworkStats.Bucket r12 = new NetworkStats.Bucket();
        r8.getNextBucket(r12);
        if (r10.equals(getPackageNameByUid(r12.getUid())) == false) goto L4;
        long r13 = r12.getRxBytes();
        r11 = (r12.getTxBytes() + r13) + r11;
        goto L4
    L9:
        return r11 / 1048576;
    }

    private long calculateCategoryDataUsage(NetworkStats r10, int r11) {
        AppCategoryHelper r8 = AppCategoryHelper.getInstance(this.mContext);
        long r12 = 0;
    L4:
        if (r10.hasNextBucket() == false) goto L14;
        NetworkStats.Bucket r13 = new NetworkStats.Bucket();
        r10.getNextBucket(r13);
        String r14 = getPackageNameByUid(r13.getUid());
        if (r14 == null) goto L4;
        if (r14.isEmpty() == true) goto L4;
        if (r8.getAppCategory(r14) != r11) goto L4;
        long r15 = r13.getRxBytes();
        r12 = (r13.getTxBytes() + r15) + r12;
        goto L4
    L14:
        return r12 / 1048576;
    }

    private String getDefaultSubscriberId() {
        int r8 = SubscriptionManager.getDefaultDataSubscriptionId();
        if (SubscriptionManager.isValidSubscriptionId(r8) == true) goto L10;
        return null;
    L10:
        return this.mTelephonyManager.getSubscriberId(r8);
    L7:
        e = move-exception;
        CaeLog.e(TAG, "getSubscriberId security exception: " + e.getMessage());
        return null;
    }

    private String getPackageNameByUid(int r8) {
        String[] r10 = this.mContext.getPackageManager().getPackagesForUid(r8);     // Catch: Exception -> L8
        if (r10 != null) goto L5;
        return "";
    L5:
        if (r10.length <= 0) goto L15;
        return r10[0];
    L15:
        return "";
    L8:
        e = move-exception;
        b.k(e, new StringBuilder("getPackagesForUid failed: "), TAG);
        return "";
    }

    public long getAppDataUsage(String r12, int r13, int r14) {
        if (r12 == null) goto L31;
        if (r13 <= 0) goto L31;
        long r8 = System.currentTimeMillis();
        long r10 = r8 - TimeUnit.DAYS.toMillis(r13);
        NetworkStats r11 = null;
        if (r14 != 0) goto L13;
        String r15 = getDefaultSubscriberId();
        if (r15 != null) goto L12;
        CaeLog.w(TAG, "No valid subscriber ID");
        return 0;
    L12:
        String r16 = r15;
    L32:
        r11 = this.mNetworkStatsManager.querySummary(r14, r16, r10, r8);     // Catch: Throwable -> L21 RemoteException -> L23
        if (r11 == null) goto L19;
        long r17 = calculateAppDataUsage(r11, r12);     // Catch: Throwable -> L21 RemoteException -> L23
        r11.close();
        return r17;
    L19:
        if (r11 == null) goto L27;
    L20:
        r11.close();
    L27:
        return 0;
    L21:
        th = move-exception;
        if (r11 == null) goto L30;
        r11.close();
    L30:
        throw th;
    L23:
        e = move-exception;
        CaeLog.e(TAG, "querySummary failed for type " + r14 + ": " + e.getMessage());     // Catch: Throwable -> L21
        if (r11 == null) goto L27;
    L13:
        r16 = null;
    L31:
        return 0;
    }

    public long getCategoryDataUsage(int r12, int r13, int r14) {
        if (r12 > 0) goto L5;
        return 0;
    L5:
        long r8 = System.currentTimeMillis();
        long r10 = r8 - TimeUnit.DAYS.toMillis(r12);
        NetworkStats r11 = null;
        if (r14 != 0) goto L12;
        String r15 = getDefaultSubscriberId();
        if (r15 != null) goto L11;
        CaeLog.w(TAG, "No valid subscriber ID");
        return 0;
    L11:
        String r16 = r15;
    L30:
        r11 = this.mNetworkStatsManager.querySummary(r14, r16, r10, r8);     // Catch: Throwable -> L20 RemoteException -> L22
        if (r11 == null) goto L18;
        long r17 = calculateCategoryDataUsage(r11, r13);     // Catch: Throwable -> L20 RemoteException -> L22
        r11.close();
        return r17;
    L18:
        if (r11 == null) goto L26;
    L19:
        r11.close();
    L26:
        return 0;
    L22:
        e = move-exception;
        CaeLog.e(TAG, "querySummary failed for type " + r14 + ": " + e.getMessage());     // Catch: Throwable -> L20
        if (r11 == null) goto L26;
    L20:
        th = move-exception;
        if (r11 == null) goto L29;
        r11.close();
    L29:
        throw th;
    L12:
        r16 = null;
        goto L30
    }

    public long getTotalCellDataUsage(int r10) {
        if (r10 > 0) goto L5;
        return 0;
    L5:
        long r8 = System.currentTimeMillis();
        long r11 = r8 - TimeUnit.DAYS.toMillis(r10);
        String r12 = getDefaultSubscriberId();
        if (r12 != null) goto L16;
        CaeLog.w(TAG, "No valid subscriber ID");
        return 0;
    L16:
        NetworkStats.Bucket r13 = this.mNetworkStatsManager.querySummaryForDevice(0, r12, r11, r8);     // Catch: RemoteException -> L13
        if (r13 == null) goto L15;
        return (r13.getRxBytes() + r13.getTxBytes()) / 1048576;
    L15:
        return 0;
    L13:
        e = move-exception;
        CaeLog.e(TAG, "querySummaryForDevice failed: " + e.getMessage());
        goto L15
    }

    public long getTotalCellDataUsageBetween(long r11, long r13) {
        if (r13 > 0) goto L5;
    L19:
        return 0;
    L5:
        if (r11 <= 0) goto L19;
        if (r13 < r11) goto L19;
        String r8 = getDefaultSubscriberId();
        if (r8 != null) goto L20;
        CaeLog.w(TAG, "No valid subscriber ID");
        return 0;
    L20:
        NetworkStats.Bucket r10 = this.mNetworkStatsManager.querySummaryForDevice(0, r8, r11, r13);     // Catch: RemoteException -> L17
        if (r10 == null) goto L19;
        return (r10.getRxBytes() + r10.getTxBytes()) / 1048576;
    L17:
        e = move-exception;
        CaeLog.e(TAG, "querySummaryForDevice failed: " + e.getMessage());
        goto L19
    }

    public long getTotalDataUsage(int r10, int r11) {
        if (r10 > 0) goto L5;
        return 0;
    L5:
        long r8 = System.currentTimeMillis();
        long r12 = r8 - TimeUnit.DAYS.toMillis(r10);
        if (r11 != 0) goto L11;
        String r13 = getDefaultSubscriberId();
        if (r13 != null) goto L20;
        CaeLog.w(TAG, "No valid subscriber ID");
        return 0;
    L20:
        NetworkStats.Bucket r14 = this.mNetworkStatsManager.querySummaryForDevice(r11, r13, r12, r8);     // Catch: RemoteException -> L17
        if (r14 == null) goto L19;
        return (r14.getRxBytes() + r14.getTxBytes()) / 1048576;
    L19:
        return 0;
    L17:
        e = move-exception;
        StringBuilder r15 = b.f("querySummaryForDevice failed for type ", r11, ": ");
        r15.append(e.getMessage());
        CaeLog.e(TAG, r15.toString());
        goto L19
    L11:
        r13 = null;
        goto L20
    }
}
