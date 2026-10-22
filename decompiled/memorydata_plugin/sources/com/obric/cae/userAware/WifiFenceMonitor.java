package com.obric.cae.userAware;

import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.obric.cae.log.a;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes3.dex */
public class WifiFenceMonitor {
    private static final String KEY_COMPANY_FENCE_SCAN_RESULTS = "company_fence_scan_results";
    private static final String KEY_FENCE_BSSIDS = "fence_bssids";
    private static final String KEY_HOME_BSSIDS = "home_bssids";
    private static final String KEY_HOME_FENCE_SCAN_RESULTS = "home_fence_scan_results";
    private static final String PREF_NAME = "wifi_fence_prefs";
    private static final String TAG = "WifiFenceMonitor";
    private final Set<Map<String, Integer>> mCompanyFenceScanResults;
    private final Context mContext;
    private int mFenceBssidNotFoundCount;
    private final Set<String> mFenceBssids;
    private int mFenceType;
    private boolean mHomeApConnected;
    private final Set<Map<String, Integer>> mHomeFenceScanResults;
    private final Set<String> mHomeWifiBssids;
    private boolean mInFence;
    private boolean mInHome;
    private boolean mIsRunning;
    private String mLastConnectedBssid;
    private boolean mLearningActive;
    private final Object mLock;
    private final PluginBroadcastReceiver mReceiver;
    private final WifiScanStateMachine mStateMachine;
    private final WifiManager mWifiManager;

    public WifiFenceMonitor(Context r6, WifiScanStateMachine r7, List<String> r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        this.mFenceBssids = new FixedSizeSet(200);
        FixedSizeSet r0 = new FixedSizeSet(20);
        this.mHomeWifiBssids = r0;
        this.mHomeFenceScanResults = new FixedSizeSet(50);
        this.mCompanyFenceScanResults = new FixedSizeSet(20);
        this.mInFence = false;
        this.mInHome = false;
        this.mLearningActive = false;
        this.mIsRunning = false;
        this.mFenceBssidNotFoundCount = 0;
        this.mLastConnectedBssid = null;
        this.mHomeApConnected = false;
        this.mLock = new Object();
        this.mReceiver = new AnonymousClass1(this);
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        this.mContext = ZeusTransformUtils.wrapperContext(r11, "com.obric.memorydata.plugin");
        this.mWifiManager = (WifiManager) ZeusTransformUtils.preCheckCast(r11.getSystemService(LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI), WifiManager.class, "com.obric.memorydata.plugin");
        this.mStateMachine = r7;
        if (r10 == null) goto L5;
        r0.addAll(r10);
        a.c(TAG, "Initial home BSSIDs: " + r10);
    L5:
        restoreBssidSets();
    }

    public static /* synthetic */ WifiManager access$000(WifiFenceMonitor r0) {
        return r0.mWifiManager;
    }

    public static /* synthetic */ String access$100(WifiFenceMonitor r0) {
        return r0.mLastConnectedBssid;
    }

    public static /* synthetic */ String access$102(WifiFenceMonitor r0, String r1) {
        r0.mLastConnectedBssid = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$200(WifiFenceMonitor r0) {
        return r0.mHomeApConnected;
    }

    public static /* synthetic */ boolean access$202(WifiFenceMonitor r0, boolean r1) {
        r0.mHomeApConnected = r1;
        return r1;
    }

    public static /* synthetic */ Set access$300(WifiFenceMonitor r0) {
        return r0.mHomeWifiBssids;
    }

    public static /* synthetic */ boolean access$402(WifiFenceMonitor r0, boolean r1) {
        r0.mLearningActive = r1;
        return r1;
    }

    public static /* synthetic */ void access$500(WifiFenceMonitor r0, boolean r1) {
        r0.handleWifiFence(r1);
    }

    public static /* synthetic */ Set access$600(WifiFenceMonitor r0) {
        return r0.mFenceBssids;
    }

    private Set<Map<String, Integer>> deserializeScanResults(String r8) {
        LinkedHashSet r7 = new LinkedHashSet();
        if (r8.isEmpty() == false) goto L5;
        return r7;
    L5:
        String[] r9 = r8.split("\\|\\|");
        int r0 = r9.length;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L14;
        String r3 = r9[r2];
        String[] r4 = r3.split(ParameterizedMessage.ERROR_MSG_SEPARATOR, 2);
        if (r4.length != 2) goto L13;
        String r5 = r4[0];
        int r6 = Integer.parseInt(r4[1]);     // Catch: NumberFormatException -> L12
        HashMap r10 = new HashMap();     // Catch: NumberFormatException -> L12
        r10.put(r5, Integer.valueOf(r6));     // Catch: NumberFormatException -> L12
        r7.add(r10);     // Catch: NumberFormatException -> L12
    L12:
        a.i(TAG, "Invalid frequency format in scan result: ".concat(r3));
    L13:
        r2 = r2 + 1;
        goto L6
    L14:
        return r7;
    }

    private void handleWifiFence(boolean r4) {
        a.c(TAG, "handleWifiFence: nowInFence=" + r4 + ", mInFence=" + this.mInFence);
        this.mFenceBssidNotFoundCount = 0;
        if (r4 == true) goto L5;
    L7:
        if (r4 == false) goto L9;
        return;
    L9:
        if (this.mInFence == false) goto L14;
        this.mInFence = false;
        a.c(TAG, "Transition: onWifiExit()");
        this.mStateMachine.onWifiExit();
        return;
    L14:
        return;
    L5:
        if (this.mInFence == true) goto L7;
        this.mInFence = true;
        a.c(TAG, "Transition: onWifiEnter()");
        this.mStateMachine.onWifiEnter();
    }

    private void persistBssidSets() {
        this.mContext.getSharedPreferences(PREF_NAME, 0).edit().putString(KEY_HOME_BSSIDS, String.join(",", this.mHomeWifiBssids)).putString(KEY_FENCE_BSSIDS, String.join(",", this.mFenceBssids)).putString(KEY_HOME_FENCE_SCAN_RESULTS, serializeScanResults(this.mHomeFenceScanResults)).putString(KEY_COMPANY_FENCE_SCAN_RESULTS, serializeScanResults(this.mCompanyFenceScanResults)).apply();
    }

    private void restoreBssidSets() {
        LinkedHashSet r0 = new LinkedHashSet();
        LinkedHashSet r1 = new LinkedHashSet();
        String r2 = this.mContext.getSharedPreferences(PREF_NAME, 0).getString(KEY_HOME_BSSIDS, "");
        String r5 = this.mContext.getSharedPreferences(PREF_NAME, 0).getString(KEY_FENCE_BSSIDS, "");
        if (r2.isEmpty() == true) goto L8;
        String[] r3 = r2.split(",");
        int r7 = r3.length;
        int r9 = 0;
    L5:
        if (r9 >= r7) goto L8;
        r0.add(r3[r9]);
        r9 = r9 + 1;
    L8:
        if (r5.isEmpty() == true) goto L12;
        String[] r4 = r5.split(",");
        int r6 = r4.length;
        int r8 = 0;
    L10:
        if (r8 >= r6) goto L12;
        r1.add(r4[r8]);
        r8 = r8 + 1;
    L12:
        this.mHomeWifiBssids.clear();
        this.mHomeWifiBssids.addAll(r0);
        this.mFenceBssids.clear();
        this.mFenceBssids.addAll(r1);
        String r10 = this.mContext.getSharedPreferences(PREF_NAME, 0).getString(KEY_HOME_FENCE_SCAN_RESULTS, "");
        this.mHomeFenceScanResults.clear();
        this.mHomeFenceScanResults.addAll(deserializeScanResults(r10));
        String r11 = this.mContext.getSharedPreferences(PREF_NAME, 0).getString(KEY_COMPANY_FENCE_SCAN_RESULTS, "");
        this.mCompanyFenceScanResults.clear();
        this.mCompanyFenceScanResults.addAll(deserializeScanResults(r11));
    }

    private String serializeScanResults(Set<Map<String, Integer>> r6) {
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
        StringBuilder r7 = new StringBuilder();
        Iterator r8 = r5.iterator();
    L4:
        if (r8.hasNext() == false) goto L13;
        Iterator r1 = ((Map) ZeusTransformUtils.preCheckCast(r8.next(), Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L4;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r7.length() <= 0) goto L11;
        r7.append("||");
    L11:
        r7.append((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin")).append(ParameterizedMessage.ERROR_MSG_SEPARATOR).append(r2.getValue());
        goto L7
    L13:
        return r7.toString();
    }

    public void addHomeWifiBssid(String r2) {
        if (r2 == null) goto L5;
        this.mHomeWifiBssids.add(r2);
        this.mFenceBssids.add(r2);
        a.c(TAG, "addHomeWifiBssid: ".concat(r2));
        return;
    }

    public void clearHomeWifiBssids() {
        Iterator<String> r0 = this.mHomeWifiBssids.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        this.mFenceBssids.remove(r1);
        goto L4
    L6:
        this.mHomeWifiBssids.clear();
        handleWifiFence(false);
        a.c(TAG, "clearHomeWifiBssids");
    }

    public Set<Map<String, Integer>> getCompanyFenceScanResults() {
        a.c(TAG, "getCompanyFenceScanResults size is" + this.mCompanyFenceScanResults.size());
        return new LinkedHashSet(this.mCompanyFenceScanResults);
    }

    public Set<String> getFenceBssids() {
        return new LinkedHashSet(this.mFenceBssids);
    }

    public Set<String> getHomeBssids() {
        return new LinkedHashSet(this.mHomeWifiBssids);
    }

    public Set<Map<String, Integer>> getHomeFenceScanResults() {
        a.c(TAG, "getHomeFenceScanResults size is" + this.mHomeFenceScanResults.size());
        return new LinkedHashSet(this.mHomeFenceScanResults);
    }

    public Set<String> getHomeWifiBssids() {
        return new LinkedHashSet(this.mHomeWifiBssids);
    }

    public void handleScanResults(List<ScanResult> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Object r1 = this.mLock;
        monitor-enter(r1);
        a.c(TAG, "Scan results size: " + r11.size());     // Catch: Throwable -> L40
        Iterator r12 = r11.iterator();     // Catch: Throwable -> L40
        boolean r3 = false;
    L6:
        if (r12.hasNext() == false) goto L21;
        ScanResult r4 = (ScanResult) ZeusTransformUtils.preCheckCast(r12.next(), ScanResult.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
        String r6 = r4.BSSID;     // Catch: Throwable -> L40
        if (this.mLearningActive == false) goto L15;
        this.mFenceBssids.add(r6);     // Catch: Throwable -> L40
        HashMap r7 = new HashMap();     // Catch: Throwable -> L40
        r7.put(r4.SSID, Integer.valueOf(r4.frequency));     // Catch: Throwable -> L40
        if (this.mFenceType != 3) goto L13;
        Set<Map<String, Integer>> r5 = this.mCompanyFenceScanResults;     // Catch: Throwable -> L40
    L12:
        r5.add(r7);     // Catch: Throwable -> L40
        goto L15
    L13:
        r5 = this.mHomeFenceScanResults;     // Catch: Throwable -> L40
    L15:
        if (this.mFenceBssids.contains(r6) == false) goto L6;
        a.c(TAG, "Fence BSSID detected in scan: " + r6);     // Catch: Throwable -> L40
        if (this.mLearningActive == false) goto L18;
        r3 = true;
        goto L6
    L18:
        r3 = true;
    L21:
        if (this.mFenceBssids.size() != this.mHomeWifiBssids.size()) goto L23;
    L37:
        a.c(TAG, "Have not learned any BSSIDs or in home, do not switch WifiFenceState");     // Catch: Throwable -> L40
        monitor-exit(r1);     // Catch: Throwable -> L40
        return;
    L23:
        if (this.mInHome == true) goto L37;
        if (r3 == false) goto L28;
        handleWifiFence(true);     // Catch: Throwable -> L40
    L35:
        monitor-exit(r1);     // Catch: Throwable -> L40
        return;
    L28:
        if (this.mInFence == false) goto L35;
        int r13 = this.mFenceBssidNotFoundCount + 1;     // Catch: Throwable -> L40
        this.mFenceBssidNotFoundCount = r13;     // Catch: Throwable -> L40
        if (r13 >= 3) goto L32;
    L34:
        a.c(TAG, "Fence BSSID not found in scan, incrementing count to " + this.mFenceBssidNotFoundCount);     // Catch: Throwable -> L40
        goto L35
    L32:
        if (this.mHomeApConnected == true) goto L34;
        handleWifiFence(false);     // Catch: Throwable -> L40
        this.mFenceBssidNotFoundCount = 0;     // Catch: Throwable -> L40
        a.c(TAG, "Fence BSSID not found for 3 scans, resetting");     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        throw th;
    }

    public boolean isHomeWifiBssid(String r3) {
        if (r3 != null) goto L4;
    L6:
        boolean r2 = false;
    L7:
        a.c(TAG, "isHomeWifiBssid(" + r3 + ") = " + r2);
        return r2;
    L4:
        if (this.mHomeWifiBssids.contains(r3) == false) goto L6;
        r2 = true;
        goto L7
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void onEnterHome() {
        a.c(TAG, "Enter home: enable learning mode");
        this.mInHome = true;
        this.mLearningActive = true;
    }

    public void onExitHome() {
        a.c(TAG, "Exit home: disable learning mode");
        this.mLearningActive = false;
        this.mInHome = false;
        persistBssidSets();
    }

    public void removeHomeWifiBssid(String r2) {
        if (r2 == null) goto L5;
        this.mHomeWifiBssids.remove(r2);
        this.mFenceBssids.remove(r2);
        a.c(TAG, "removeHomeWifiBssid: ".concat(r2));
        return;
    }

    public void start(int r4) {
        a.c(TAG, "Start monitoring fence type: " + r4);
        this.mFenceType = r4;
        IntentFilter r5 = new IntentFilter();
        r5.addAction("android.net.wifi.SCAN_RESULTS");
        r5.addAction("android.net.wifi.STATE_CHANGE");
        ZeusTransformUtils.registerReceiver(this.mContext, this.mReceiver, r5, "com.obric.memorydata.plugin");
        this.mIsRunning = true;
    }

    public void stop() {
        a.c(TAG, "Stop monitoring");
        ZeusTransformUtils.unregisterReceiver(this.mContext, this.mReceiver, "com.obric.memorydata.plugin");
        this.mInFence = false;
        this.mLearningActive = false;
        this.mIsRunning = false;
    }
}
