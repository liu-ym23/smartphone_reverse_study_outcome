package com.obric.cae.statusReport.network;

import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.obric.cae.log.CaeLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkTrafficCollect {
    private static final String TAG = "NetworkTrafficCollect";
    private final Context mContext;
    private boolean mIsCollecting;
    private final NetworkStatsManager mNetworkStatsManager;
    private final PackageManager mPackageManager;
    private Map<String, Long> mStartAppDataUsage;
    private long mStartCollectTime;
    private long mStartTotalDataUsage;
    private String mSubscriberId;
    private final TelephonyManager mTelephonyManager;

    public class DataUsage {
        private final Map<String, Long> appDataUsage;
        private long dataUsage;
        private long dwellTime;
        final /* synthetic */ NetworkTrafficCollect this$0;

        public DataUsage(NetworkTrafficCollect r8) {
            this.this$0 = r8;
            this.appDataUsage = new HashMap();
        }

        public void addAppDataUsage(String r8, long r10) {
            this.appDataUsage.put(r8, Long.valueOf(r10));
        }

        public void addDataUsage(long r8) {
            this.dataUsage = r8;
        }

        public void addDwellTime(long r8) {
            this.dwellTime = r8;
        }

        public Map<String, Long> getAppDataUsage() {
            return this.appDataUsage;
        }

        public long getDataUsage() {
            return this.dataUsage;
        }

        public long getDwellTime() {
            return this.dwellTime;
        }

        public String toString() {
            return "DataUsage { dwellTime: " + this.dwellTime + "s, dataUsage: " + this.dataUsage + "MB }";
        }
    }

    public NetworkTrafficCollect(Context r8) {
        this.mSubscriberId = null;
        this.mIsCollecting = false;
        this.mStartCollectTime = 0;
        this.mStartTotalDataUsage = 0;
        this.mStartAppDataUsage = null;
        this.mContext = r8;
        this.mTelephonyManager = (TelephonyManager) r8.getSystemService("phone");
        this.mNetworkStatsManager = (NetworkStatsManager) r8.getSystemService("netstats");
        this.mPackageManager = r8.getPackageManager();
    }

    public static /* synthetic */ Long a(Map r8, String r10, Long r11) {
        return lambda$getAppMobileDataUsage$0(r8, r10, r11);
    }

    private Map<String, Long> getAppMobileDataUsage(long r10, long r11) {
        final HashMap r8 = new HashMap();
        NetworkStats r12 = this.mNetworkStatsManager.querySummary(0, getDefaultSubscriberId(), r10, r11);     // Catch: RemoteException -> L5
    L7:
        if (r12 == null) goto L23;
        if (r12.hasNextBucket() == false) goto L23;
        NetworkStats.Bucket r13 = new NetworkStats.Bucket();     // Catch: Throwable -> L20
        r12.getNextBucket(r13);     // Catch: Throwable -> L20
        String r14 = getPackageName(r13.getUid());     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(r14) == true) goto L7;
        if (r8.containsKey(r14) == false) goto L17;
        long r15 = ((Long) r8.get(r14)).longValue() + r13.getRxBytes();     // Catch: Throwable -> L20
        long r16 = r13.getTxBytes();     // Catch: Throwable -> L20
    L18:
        r8.put(r14, Long.valueOf(r15 + r16));     // Catch: Throwable -> L20
        goto L7
    L17:
        r15 = r13.getRxBytes();     // Catch: Throwable -> L20
        r16 = r13.getTxBytes();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        r12.close();
        throw th;
    L23:
        if (r12 == null) goto L25;
        r12.close();
    L25:
        r8.replaceAll(new a(r8));
        return r8;
    L5:
        e = move-exception;
        CaeLog.e(TAG, "querySummary failed: " + e.getMessage());
        r12 = null;
        goto L7
    }

    private String getDefaultSubscriberId() {
        int r8 = SubscriptionManager.getDefaultDataSubscriptionId();
        if (SubscriptionManager.isValidSubscriptionId(r8) == true) goto L7;
        return null;
    L7:
        return this.mTelephonyManager.getSubscriberId(r8);
    }

    private String getPackageName(int r8) {
        String[] r10 = this.mPackageManager.getPackagesForUid(r8);
        if (r10 != null) goto L5;
    L7:
        return "";
    L5:
        if (r10.length <= 0) goto L7;
        return r10[0];
    }

    private long getTotalDataUsage(int r10, long r11, long r13) {
        long r8 = 0;
        if (r10 != 0) goto L5;
        NetworkStats.Bucket r12 = this.mNetworkStatsManager.querySummaryForDevice(r10, getDefaultSubscriberId(), r11, r13);     // Catch: RemoteException -> L12
    L9:
        if (r12 == null) goto L15;
        r8 = 0 + r12.getRxBytes();     // Catch: RemoteException -> L12
        r8 = r8 + r12.getTxBytes();
    L15:
        return (r8 / 1024) / 1024;
    L5:
        if (r10 == 1) goto L7;
        r12 = null;
        goto L9
    L7:
        r12 = this.mNetworkStatsManager.querySummaryForDevice(r10, null, r11, r13);     // Catch: RemoteException -> L12
    L12:
        e = move-exception;
        CaeLog.e(TAG, "querySummaryForDevice failed: " + e.getMessage());
        goto L15
    }

    private static /* synthetic */ Long lambda$getAppMobileDataUsage$0(Map r8, String r10, Long r11) {
        return Long.valueOf((((Long) r8.get(r10)).longValue() / 1024) / 1024);
    }

    public boolean isCollecting() {
        return this.mIsCollecting;
    }

    public void startQueryNetworkTraffic() {
        if (this.mIsCollecting == false) goto L5;
        CaeLog.e(TAG, "already collecting and again start collecting.");
    L5:
        String r8 = getDefaultSubscriberId();
        this.mSubscriberId = r8;
        if (r8 != null) goto L9;
        CaeLog.e(TAG, "getDefaultSubscriberId return null. cancel mobile data traffic collect.");
        return;
    L9:
        long r10 = System.currentTimeMillis();
        this.mStartCollectTime = r10;
        this.mIsCollecting = true;
        this.mStartTotalDataUsage = getTotalDataUsage(0, 0, r10);
        this.mStartAppDataUsage = getAppMobileDataUsage(0, this.mStartCollectTime);
        CaeLog.i(TAG, "SubscriberId: " + this.mSubscriberId + ", start collecting, totalDataUsage = " + this.mStartTotalDataUsage + "MB");
    }

    public DataUsage stopQueryNetworkTraffic() {
        DataUsage r8 = new DataUsage(this);
        long r10 = System.currentTimeMillis();
        if (this.mIsCollecting == true) goto L7;
        CaeLog.e(TAG, "mobile data traffic not collecting.");
        return r8;
    L7:
        if (Objects.equals(this.mSubscriberId, getDefaultSubscriberId()) == true) goto L10;
        CaeLog.e(TAG, "subscriberId not match. current subscriberId: " + getDefaultSubscriberId() + ", collect subscriberId: " + this.mSubscriberId);
        return r8;
    L10:
        long r11 = getTotalDataUsage(0, 0, r10);
        Map<String, Long> r12 = getAppMobileDataUsage(0, r10);
        r8.addDwellTime((r10 - this.mStartCollectTime) / 1000);
        r8.addDataUsage(r11 - this.mStartTotalDataUsage);
        CaeLog.i(TAG, "SubscriberId: " + this.mSubscriberId + ", stop collecting, totalDataUsage = " + r11 + "MB, deltaDataUsage = " + (r11 - this.mStartTotalDataUsage) + "MB, deltaDwellTime = " + ((r10 - this.mStartCollectTime) / 1000) + "s");
        Iterator<Map.Entry<String, Long>> r13 = r12.entrySet().iterator();
    L12:
        if (r13.hasNext() == false) goto L16;
        Map.Entry<String, Long> r14 = r13.next();
        String r15 = r14.getKey();
        long r16 = r14.getValue().longValue();
        long r17 = r16 - this.mStartAppDataUsage.getOrDefault(r15, Long.valueOf(r16)).longValue();
        if (r17 <= 0) goto L12;
        CaeLog.i(TAG, "SubscriberId: " + this.mSubscriberId + ", app: " + r15 + ", deltaDataUsage = " + r17 + "MB");
        r8.addAppDataUsage(r15, r17);
        goto L12
    L16:
        this.mIsCollecting = false;
        return r8;
    }
}
