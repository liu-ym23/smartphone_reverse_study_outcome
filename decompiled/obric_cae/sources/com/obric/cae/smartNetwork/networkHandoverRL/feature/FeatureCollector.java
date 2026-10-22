package com.obric.cae.smartNetwork.networkHandoverRL.feature;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.cae.caed.INefiListener;
import com.cae.caed.NefiInfoParcel;
import com.cae.caed.WifiStatsParcel;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetEvaluate;
import com.obric.cae.smartNetwork.nefid.NefidInterface;
import com.obric.cae.smartNetwork.networkHandover.HandoverParameterManager;
import com.obric.cae.smartNetwork.networkMonitor.ActivityMonitor;
import com.obric.cae.smartNetwork.qoe.CellularLteQoEParam;
import com.obric.cae.smartNetwork.qoe.CellularNrQoEParam;
import com.obric.cae.smartNetwork.qoe.CellularQoECallback;
import com.obric.cae.smartNetwork.qoe.CellularQoEParam;
import com.obric.cae.smartNetwork.qoe.CellularQoeEvaluate;
import com.obric.cae.smartNetwork.qoe.CellularQoeEvaluateStats;
import com.obric.cae.smartNetwork.qoe.NetworkQoEMonitor;
import com.obric.cae.smartNetwork.qoe.WiFiQoECallback;
import com.obric.cae.smartNetwork.qoe.WiFiQoEParam;
import defpackage.b;
import java.util.Calendar;
import java.util.List;
import v0.d;

/* JADX INFO: loaded from: classes2.dex */
public class FeatureCollector {
    private static final long DELTA_QUERY_INTERVAL_MS = 600000;
    private static final String KEY_FEATURE_INDEX = "feature_index";
    private static final String PREFS_NAME = "feature_prefs";
    private static final String TAG = "FeatureCollector";
    private static final int WIFI_SIGNAL_LEVEL_NUM = 5;
    private static final int WIFI_SIGNAL_LEVEL_THRESHOLD = 3;
    private ActivityMonitor mActivityMonitor;
    private final ActivityMonitor.ActivityMonitorListener mActivityMonitorListener;
    private AppCategoryHelper mAppCategoryHelper;
    private volatile int mCachedLocation;
    private volatile String mCachedSimId;
    private int mCellDataLevel;
    private int mCellSignalLevel;
    private final CellularQoECallback mCellularQoECallback;
    private ContentResolver mContentResolver;
    private Context mContext;
    private long mD7CellAppUsed;
    private long mD7CellTotalUsed;
    private long mD7WifiAppUsed;
    private DataUsageQuery mDataUsageQuery;
    private DdsSwitchCallback mDdsSwitchCallback;
    private FeatureStorage mFeatureStorage;
    private int mForeAppUid;
    private String mForePackageName;
    private HandoverParameterManager mHandoverParameterManager;
    private L4NetEvaluate mL4NetEvaluate;
    private volatile long mLastDeltaMb;
    private volatile String mLastDeltaMbSimId;
    private volatile long mLastDeltaMbTs;
    private String mLastPackageNameForUnacked;
    private int mLastWifiL4Unacked;
    private WiFiQoEParam mLastestWiFiQoEParam;
    private L4NetEvaluate.L4NetStats mLatestWifiL4Info;
    private int mLatestWifiRssi;
    private ContentObserver mLocationObserver;
    private NefidInterface mNefidInterface;
    private NefidListener mNefidListener;
    private final L4NetEvaluate.L4NetErrReportCb mNetErrReportCb;
    private NetworkQoEMonitor mNetworkQoEMonitor;
    private PackageManager mPackageManager;
    private SharedPreferences mSharedPreferences;
    private TelephonyManager mTelephonyManager;
    private L4NetEvaluate.UidNetifRateStats mUidNetifRateStats;
    private final WiFiQoECallback mWifiQoeCallback;

    public class DdsSwitchCallback extends TelephonyCallback implements TelephonyCallback.ActiveDataSubscriptionIdListener {
        final /* synthetic */ FeatureCollector this$0;

        private DdsSwitchCallback(FeatureCollector r8) {
            this.this$0 = r8;
        }

        @Override // android.telephony.TelephonyCallback.ActiveDataSubscriptionIdListener
        public void onActiveDataSubscriptionIdChanged(int r8) {
            b.m("onActiveDataSubscriptionIdChanged. subId: ", r8, FeatureCollector.TAG);
            FeatureCollector.access$100(this.this$0, r8);
            FeatureCollector.access$200(this.this$0, true);
        }

        public /* synthetic */ DdsSwitchCallback(FeatureCollector r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public final class NefidListener extends INefiListener.Stub {
        final /* synthetic */ FeatureCollector this$0;

        public NefidListener(FeatureCollector r8) {
            this.this$0 = r8;
        }

        @Override // com.cae.caed.INefiListener
        public void OnInfoChanged(int r8, List<NefiInfoParcel> r10) {
            NefiInfoParcel r11 = r10.get(0);
            FeatureCollector.access$402(this.this$0, r11.f4156b.f4188a);
        }

        @Override // com.cae.caed.INefiListener
        public void OnWifiStatsChanged(List<WifiStatsParcel> r8) {
        }
    }

    public FeatureCollector(Context r8, NetworkQoEMonitor r10) {
        this.mLastPackageNameForUnacked = null;
        this.mForePackageName = "";
        this.mForeAppUid = 0;
        this.mCellSignalLevel = 1;
        this.mCellDataLevel = 1;
        this.mCachedLocation = 0;
        this.mNetErrReportCb = new AnonymousClass2(this);
        this.mWifiQoeCallback = new AnonymousClass3(this);
        this.mCellularQoECallback = new AnonymousClass4(this);
        this.mActivityMonitorListener = new AnonymousClass5(this);
        Context r11 = r8.getApplicationContext();
        this.mContext = r11;
        this.mContentResolver = r11.getContentResolver();
        this.mPackageManager = this.mContext.getPackageManager();
        this.mSharedPreferences = this.mContext.getSharedPreferences(PREFS_NAME, 0);
        this.mTelephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
        this.mNetworkQoEMonitor = r10;
        this.mNefidInterface = NefidInterface.getInstance(r8);
        this.mNefidListener = new NefidListener(this);
        this.mL4NetEvaluate = L4NetEvaluate.getInstance(this.mContext);
        this.mActivityMonitor = ActivityMonitor.getInstance(this.mContext);
        this.mDataUsageQuery = new DataUsageQuery(this.mContext);
        this.mHandoverParameterManager = HandoverParameterManager.getInstance(r8);
        this.mAppCategoryHelper = AppCategoryHelper.getInstance(this.mContext);
        this.mFeatureStorage = FeatureStorage.getInstance(this.mContext);
        registerDdsSwitchCallback();
        registerLocationObserver();
    }

    public static /* synthetic */ void access$100(FeatureCollector r8, int r10) {
        r8.refreshSimIdCache(r10);
    }

    public static /* synthetic */ void access$1000(FeatureCollector r8, CellularQoEParam r10) {
        r8.updateCellQoeLevel(r10);
    }

    public static /* synthetic */ void access$1100(FeatureCollector r8, CellularQoeEvaluateStats r10) {
        r8.updateCellQoeStats(r10);
    }

    public static /* synthetic */ String access$1202(FeatureCollector r8, String r10) {
        r8.mForePackageName = r10;
        return r10;
    }

    public static /* synthetic */ int access$1300(FeatureCollector r8, String r10) {
        return r8.getUidForPackage(r10);
    }

    public static /* synthetic */ long access$1402(FeatureCollector r8, long r10) {
        r8.mD7CellAppUsed = r10;
        return r10;
    }

    public static /* synthetic */ DataUsageQuery access$1500(FeatureCollector r8) {
        return r8.mDataUsageQuery;
    }

    public static /* synthetic */ long access$1602(FeatureCollector r8, long r10) {
        r8.mD7WifiAppUsed = r10;
        return r10;
    }

    public static /* synthetic */ long access$1702(FeatureCollector r8, long r10) {
        r8.mD7CellTotalUsed = r10;
        return r10;
    }

    public static /* synthetic */ long access$200(FeatureCollector r8, boolean r10) {
        return r8.getDeltaMbSinceLastQuery(r10);
    }

    public static /* synthetic */ void access$300(FeatureCollector r8) {
        r8.refreshLocationCache();
    }

    public static /* synthetic */ int access$402(FeatureCollector r8, int r10) {
        r8.mLatestWifiRssi = r10;
        return r10;
    }

    public static /* synthetic */ L4NetEvaluate.L4NetStats access$502(FeatureCollector r8, L4NetEvaluate.L4NetStats r10) {
        r8.mLatestWifiL4Info = r10;
        return r10;
    }

    public static /* synthetic */ L4NetEvaluate.UidNetifRateStats access$602(FeatureCollector r8, L4NetEvaluate.UidNetifRateStats r10) {
        r8.mUidNetifRateStats = r10;
        return r10;
    }

    public static /* synthetic */ int access$700(FeatureCollector r8) {
        return r8.mForeAppUid;
    }

    public static /* synthetic */ int access$702(FeatureCollector r8, int r10) {
        r8.mForeAppUid = r10;
        return r10;
    }

    public static /* synthetic */ L4NetEvaluate access$800(FeatureCollector r8) {
        return r8.mL4NetEvaluate;
    }

    public static /* synthetic */ WiFiQoEParam access$902(FeatureCollector r8, WiFiQoEParam r10) {
        r8.mLastestWiFiQoEParam = r10;
        return r10;
    }

    private int getAdjustedWifiL4Unacked(int r8) {
        boolean r10 = TextUtils.equals(this.mLastPackageNameForUnacked, this.mForePackageName);
        if (isStrongWifiSignal() == false) goto L6;
        if (r10 == false) goto L6;
        int r11 = Math.max(0, r8 - this.mLastWifiL4Unacked);
    L7:
        this.mLastPackageNameForUnacked = this.mForePackageName;
        this.mLastWifiL4Unacked = r8;
        return r11;
    L6:
        r11 = r8;
        goto L7
    }

    private int getCellL2Status() {
        if (this.mCellDataLevel == 1) goto L5;
        return 0;
    L5:
        if (this.mCellSignalLevel != 1) goto L9;
        return 1;
    L9:
        return 0;
    }

    private String getCurrentSimId() {
        return this.mCachedSimId;
    }

    private long getDeltaMbSinceLastQuery(boolean r11) {
        String r8 = getCurrentSimId();
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return 0;
    L5:
        long r10 = System.currentTimeMillis();
        boolean r12 = !TextUtils.equals(r8, this.mLastDeltaMbSimId);
        if (r11 == true) goto L15;
        if (r12 == true) goto L15;
        if ((r10 - this.mLastDeltaMbTs) >= 600000) goto L15;
        if (this.mLastDeltaMbTs <= 0) goto L15;
        return this.mLastDeltaMb;
    L15:
        return queryAndUpdateDeltaMbCache(r8, r10);
    }

    private int getFeatureIndex() {
        return this.mSharedPreferences.getInt(KEY_FEATURE_INDEX, 0);
    }

    private int getLocation() {
        return this.mCachedLocation;
    }

    private long getSimLongPref(String r8) {
        return this.mContext.getSharedPreferences(FeatureUtil.PREF_NAME, 0).getLong(r8, 0);
    L5:
        th = move-exception;
        android.aimedia.a.s(th, new StringBuilder("getSimLongPref error: "), TAG);
        return 0;
    }

    private String getTrafficInfoBySim(String r8) {
        return this.mContext.getSharedPreferences(FeatureUtil.PREF_NAME, 0).getString(r8, null);
    L5:
        th = move-exception;
        android.aimedia.a.s(th, new StringBuilder("getTrafficInfoBySim error: "), TAG);
        return null;
    }

    private int getUidForPackage(String r8) {
        return this.mPackageManager.getApplicationInfo(r8, 0).uid;
    L5:
        CaeLog.e(TAG, "getUidForPackage: " + r8 + " failed.");
        return 0;
    }

    private boolean hasRetransError(CellularQoeEvaluateStats r8) {
        if ((r8.errBitMap & CellularQoeEvaluate.ErrorType.UP_RETRANS_ERR.getValue()) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean hasRlfError(CellularQoeEvaluateStats r8) {
        if ((r8.errBitMap & CellularQoeEvaluate.ErrorType.RLF_ERR.getValue()) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isStrongWifiSignal() {
        if (WifiManager.calculateSignalLevel(this.mLatestWifiRssi, 5) < 3) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isValidFeature() {
        if (this.mLatestWifiL4Info != null) goto L5;
    L6:
        StringBuilder r8 = new StringBuilder("Invalid feature data.");
        String r10 = "";
        if (this.mLatestWifiL4Info != null) goto L9;
        String r11 = " mLatestWifiL4Info is null";
    L10:
        r8.append(r11);
        if (this.mLastestWiFiQoEParam != null) goto L13;
        r10 = " mLastestWiFiQoEParam is null";
    L13:
        r8.append(r10);
        CaeLog.e(TAG, r8.toString());
    L15:
        if (this.mLatestWifiL4Info != null) goto L17;
    L19:
        return false;
    L17:
        if (this.mLastestWiFiQoEParam == null) goto L19;
        return true;
    L9:
        r11 = "";
        goto L10
    L5:
        if (this.mLastestWiFiQoEParam != null) goto L15;
        goto L6
    }

    private long queryAndUpdateDeltaMbCache(String r8, long r10) {
        long r11 = 0;
        Calendar r12 = Calendar.getInstance();     // Catch: Throwable -> L7
        r12.setTimeInMillis(r10);     // Catch: Throwable -> L7
        r12.set(5, 1);     // Catch: Throwable -> L7
        r12.set(11, 0);     // Catch: Throwable -> L7
        r12.set(12, 0);     // Catch: Throwable -> L7
        r12.set(13, 0);     // Catch: Throwable -> L7
        r12.set(14, 0);     // Catch: Throwable -> L7
        long r13 = r12.getTimeInMillis();     // Catch: Throwable -> L7
        if (r13 >= r10) goto L9;
        r11 = Math.max(0, this.mDataUsageQuery.getTotalCellDataUsageBetween(r13, r10));     // Catch: Throwable -> L7
    L9:
        this.mLastDeltaMb = r11;
        this.mLastDeltaMbTs = r10;
        this.mLastDeltaMbSimId = r8;
        StringBuilder r14 = new StringBuilder("getDeltaMbSinceLastQuery. simId: ");
        r14.append(r8);
        r14.append(", deltaMb: ");
        r14.append(r11);
        android.aimedia.a.r(r14, "MB", TAG);
        return r11;
    L7:
        th = move-exception;
        android.aimedia.a.s(th, new StringBuilder("queryDeltaMbSinceMonthStart error: "), TAG);
        goto L9
    }

    private void refreshLocationCache() {
        String r8 = Settings.Global.getString(this.mContentResolver, "user_location_state");     // Catch: Throwable -> L8
        if (r8 != null) goto L6;
        this.mCachedLocation = 0;     // Catch: Throwable -> L8
    L11:
        return;
    L6:
        this.mCachedLocation = FeatureUtil.getCurrentLocation(r8);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        android.aimedia.a.s(th, new StringBuilder("refreshLocationCache error: "), TAG);
        this.mCachedLocation = 0;
    }

    private void refreshSimIdCache(int r8) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            java.lang.String r0 = "FeatureCollector"
            r1 = 0
            boolean r2 = android.telephony.SubscriptionManager.isValidSubscriptionId(r6)     // Catch: java.lang.Throwable -> L10 java.lang.SecurityException -> L1d
            if (r2 == 0) goto L33
            android.telephony.TelephonyManager r2 = r5.mTelephonyManager     // Catch: java.lang.Throwable -> L10 java.lang.SecurityException -> L1d
            java.lang.String r1 = r2.getSubscriberId(r6)     // Catch: java.lang.Throwable -> L10 java.lang.SecurityException -> L1d
            goto L33
        L10:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "getSubscriberId error: "
            r3.<init>(r4)
            java.lang.String r2 = r2.getMessage()
            goto L29
        L1d:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "getSubscriberId security exception: "
            r3.<init>(r4)
            java.lang.String r2 = r2.getMessage()
        L29:
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            com.obric.cae.log.CaeLog.w(r0, r2)
        L33:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "refreshSimIdCache. subId: "
            r2.<init>(r3)
            r2.append(r6)
            java.lang.String r6 = ", simId: "
            r2.append(r6)
            r2.append(r1)
            java.lang.String r6 = r2.toString()
            com.obric.cae.log.CaeLog.d(r0, r6)
            r5.mCachedSimId = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.cae.smartNetwork.networkHandoverRL.feature.FeatureCollector.refreshSimIdCache(int):void");
    }

    private void registerDdsSwitchCallback() {
        if (this.mTelephonyManager == null) goto L15;
        DdsSwitchCallback r8 = new DdsSwitchCallback(this, null);
        this.mDdsSwitchCallback = r8;
        this.mTelephonyManager.registerTelephonyCallback(new d(4), r8);     // Catch: Throwable -> L7 UnsupportedOperationException -> L9
    L16:
        return;
    L9:
        e = move-exception;
        StringBuilder r10 = new StringBuilder("DDS switch callback not supported: ");
        String r11 = e.getMessage();
    L11:
        r10.append(r11);
        CaeLog.w(TAG, r10.toString());
        return;
    L7:
        th = move-exception;
        r10 = new StringBuilder("register DDS callback failed: ");
        r11 = th.getMessage();
        goto L11
    }

    private void registerLocationObserver() {
        final Handler r8 = new Handler(Looper.getMainLooper());
        this.mLocationObserver = new AnonymousClass1(this, r8);
        this.mContentResolver.registerContentObserver(Settings.Global.getUriFor("user_location_state"), false, this.mLocationObserver);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        android.aimedia.a.s(th, new StringBuilder("register location observer failed: "), TAG);
    }

    private void setFeatureIndex(int r8) {
        this.mSharedPreferences.edit().putInt(KEY_FEATURE_INDEX, r8).apply();
    }

    private void updateCellQoeLevel(CellularQoEParam r8) {
        this.mCellSignalLevel = 0;
        if ((r8 instanceof CellularNrQoEParam) == false) goto L10;
        StringBuilder r10 = new StringBuilder("NR Cell Report: Rsrp = ");
        CellularNrQoEParam r11 = (CellularNrQoEParam) r8;
        r10.append(r11.getSsRsrp());
        r10.append(" Rsrq = ");
        r10.append(r11.getSsRsrq());
        CaeLog.i(TAG, r10.toString());
        if (r11.getSsRsrp() >= this.mHandoverParameterManager.getCellNrRsrpThreshold()) goto L7;
        return;
    L7:
        if (r11.getSsRsrq() < this.mHandoverParameterManager.getCellNrRsrqThreshold()) goto L17;
    L8:
        this.mCellSignalLevel = 1;
        return;
    L17:
        return;
    L10:
        if ((r8 instanceof CellularLteQoEParam) == false) goto L19;
        StringBuilder r12 = new StringBuilder("LTE Cell Report: Rsrp = ");
        CellularLteQoEParam r13 = (CellularLteQoEParam) r8;
        r12.append(r13.getRsrp());
        r12.append(" Rsrq = ");
        r12.append(r13.getRsrq());
        CaeLog.i(TAG, r12.toString());
        if (r13.getRsrp() >= this.mHandoverParameterManager.getCellLteRsrpThreshold()) goto L14;
        return;
    L14:
        if (r13.getRsrq() >= this.mHandoverParameterManager.getCellLteRsrqThreshold()) goto L8;
        return;
    }

    private void updateCellQoeStats(CellularQoeEvaluateStats r8) {
        if (hasRetransError(r8) == false) goto L5;
    L8:
        int r10 = 0;
    L9:
        this.mCellDataLevel = r10;
        return;
    L5:
        if (hasRlfError(r8) == true) goto L8;
        r10 = 1;
        goto L9
    }

    public FeatureData collectFeatureData() {
        if (isValidFeature() == false) goto L10;
        L4NetEvaluate.L4NetStats r8 = this.mLatestWifiL4Info;
        int r10 = r8.rttAve;
        int r11 = r8.sendRetrans;
        int r12 = r8.sendPackets;
        int r13 = r8.recvPackets;
        int r14 = r8.sendRate;
        int r15 = r8.recvRate;
        int r16 = r8.recvOooPercent;
        int r17 = r8.unacked;
        L4NetEvaluate.UidNetifRateStats r18 = this.mUidNetifRateStats;
        if (r18 == null) goto L7;
        L4NetEvaluate.UidQosStats r19 = r18.wlan0QosStats;
        int r20 = r19.recvRate;
        int r21 = r19.sendRate;
        L4NetEvaluate.UidQosStats r22 = r18.wlan1QosStats;
        int r23 = r22.recvRate;
        int r24 = r22.sendRate;
        int r25 = ((r20 + r21) + r23) + r24;
        int r26 = r19.rttAve + r22.rttAve;
        int r27 = r19.sendRetrans + r22.sendRetrans;
        int r110 = r19.sendPackets + r22.sendPackets;
        int r111 = r19.recvPackets + r22.recvPackets;
        int r28 = r21 + r24;
        r15 = r20 + r23;
        int r29 = r19.recvOooPercent + r22.recvOooPercent;
        r17 = r19.unacked + r22.unacked;
        r14 = r28;
        r11 = r27;
        r13 = r111;
        r16 = r29;
        r10 = r26;
    L8:
        int r30 = getAdjustedWifiL4Unacked(r17);
        long r112 = getUsedTraffic();
        long r113 = getRemainingTraffic();
        long r31 = getDeltaMbSinceLastQuery(false);
        FeatureData.Builder r32 = new FeatureData.Builder().setPackageName(this.mForePackageName).setAppCategory(this.mAppCategoryHelper.getAppCategory(this.mForePackageName)).setD7CellAppUsed((int) this.mD7CellAppUsed).setD7CellTotalUsed((int) this.mD7CellTotalUsed).setD7TrafficAppUsed((int) (this.mD7CellAppUsed + this.mD7WifiAppUsed)).setAppSpeedRate(r25);
        L4NetEvaluate.L4NetStats r33 = this.mLatestWifiL4Info;
        FeatureData r34 = r32.setTotalSpeedRate(r33.recvRate + r33.sendRate).setWifiBand(this.mLastestWiFiQoEParam.getBand()).setWifiRssi(this.mLatestWifiRssi).setWifiL2TxTput(this.mLastestWiFiQoEParam.getTxThroughput()).setWifiL2RxTput(this.mLastestWiFiQoEParam.getRxThroughput()).setWifiL4Rtt(r10).setWifiL4RetryRate(r11).setWifiL4SendPkts(r110).setWifiL4RecvPkts(r13).setWifiL4SendSpeed(r14).setWifiL4RecvSpeed(r15).setWifiL4RecvOooRate(r16).setWifiL4UnackPkts(r30).setCellUsedTraffic((int) (r112 + r31)).setCellRemainingTraffic((int) (r113 - r31)).setCurLocation(getLocation()).setCellL2State(getCellL2Status()).setIndex(getFeatureIndex() + 1).setTimeStamp(System.currentTimeMillis()).build();
        CaeLog.i(TAG, "collectFeatureData: " + r34.toString());
        setFeatureIndex(getFeatureIndex() + 1);
        this.mFeatureStorage.setLatestFeature(r34);
        return r34;
    L7:
        r110 = r12;
        r25 = 0;
        goto L8
    L10:
        return null;
    }

    public long getRemainingTraffic() {
        String r8 = getCurrentSimId();
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return 0;
    L5:
        String r10 = getTrafficInfoBySim(b.c("sim_remaining_traffic_", r8));
        if (r10 == null) goto L8;
        long r11 = (long) FeatureUtil.parseTrafficToMB(r10);
    L10:
        return Math.max(0, r11);
    L8:
        r11 = 0;
        goto L10
    }

    public long getUsedTraffic() {
        String r8 = getCurrentSimId();
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return 0;
    L5:
        String r10 = getTrafficInfoBySim(b.c("sim_used_traffic_", r8));
        if (r10 == null) goto L8;
        long r11 = (long) FeatureUtil.parseTrafficToMB(r10);
    L10:
        return Math.max(0, r11);
    L8:
        r11 = 0;
        goto L10
    }

    public void initialize() {
        Log.d(TAG, "Feature collector initialized");
        this.mNefidInterface.registerNefidInfoListener(this.mNefidListener, 1, "all", 1, 0, 2);
        this.mL4NetEvaluate.registerErrReportCb(this.mNetErrReportCb);
        this.mNetworkQoEMonitor.start();
        this.mNetworkQoEMonitor.registerWiFiQoECallback(this.mWifiQoeCallback);
        this.mNetworkQoEMonitor.registerCellularQoECallback(this.mCellularQoECallback);
        this.mActivityMonitor.registerActivityListener(this.mActivityMonitorListener);
    }

    public void release() {
        Log.d(TAG, "Feature collector resources released");
        this.mNefidInterface.unregisterNefidInfoListener(this.mNefidListener);
        this.mL4NetEvaluate.unregisterErrReportCb(this.mNetErrReportCb);
        this.mNetworkQoEMonitor.stop();
        this.mNetworkQoEMonitor.unregisterWiFiQoECallback(this.mWifiQoeCallback);
        this.mNetworkQoEMonitor.unregisterCellularQoECallback(this.mCellularQoECallback);
        this.mActivityMonitor.unregisterActivityListener(this.mActivityMonitorListener);
    }
}
