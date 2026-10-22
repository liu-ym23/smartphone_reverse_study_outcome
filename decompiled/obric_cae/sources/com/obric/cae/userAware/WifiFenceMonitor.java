package com.obric.cae.userAware;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
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
    private final BroadcastReceiver mReceiver;
    private final WifiScanStateMachine mStateMachine;
    private final WifiManager mWifiManager;

    public WifiFenceMonitor(Context r8, WifiScanStateMachine r10, List<String> r11) {
        this.mFenceBssids = new FixedSizeSet(200);
        FixedSizeSet r12 = new FixedSizeSet(20);
        this.mHomeWifiBssids = r12;
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
        Context r13 = r8.getApplicationContext();
        this.mContext = r13;
        this.mWifiManager = (WifiManager) r13.getSystemService("wifi");
        this.mStateMachine = r10;
        if (r11 == null) goto L5;
        r12.addAll(r11);
        CommSenseLog.d(TAG, "Initial home BSSIDs: " + r11);
    L5:
        restoreBssidSets();
    }

    public static /* synthetic */ WifiManager access$000(WifiFenceMonitor r8) {
        return r8.mWifiManager;
    }

    public static /* synthetic */ String access$100(WifiFenceMonitor r8) {
        return r8.mLastConnectedBssid;
    }

    public static /* synthetic */ String access$102(WifiFenceMonitor r8, String r10) {
        r8.mLastConnectedBssid = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$200(WifiFenceMonitor r8) {
        return r8.mHomeApConnected;
    }

    public static /* synthetic */ boolean access$202(WifiFenceMonitor r8, boolean r10) {
        r8.mHomeApConnected = r10;
        return r10;
    }

    public static /* synthetic */ Set access$300(WifiFenceMonitor r8) {
        return r8.mHomeWifiBssids;
    }

    public static /* synthetic */ boolean access$402(WifiFenceMonitor r8, boolean r10) {
        r8.mLearningActive = r10;
        return r10;
    }

    public static /* synthetic */ void access$500(WifiFenceMonitor r8, boolean r10) {
        r8.handleWifiFence(r10);
    }

    public static /* synthetic */ Set access$600(WifiFenceMonitor r8) {
        return r8.mFenceBssids;
    }

    private Set<Map<String, Integer>> deserializeScanResults(String r8) {
        LinkedHashSet r10 = new LinkedHashSet();
        if (r8.isEmpty() == false) goto L5;
        return r10;
    L5:
        String[] r11 = r8.split("\\|\\|");
        int r12 = r11.length;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L14;
        String r14 = r11[r13];
        String[] r15 = r14.split(BdimCategoryConstants.SEPARATOR_COLON, 2);
        if (r15.length != 2) goto L13;
        String r16 = r15[0];
        int r17 = Integer.parseInt(r15[1]);     // Catch: NumberFormatException -> L12
        HashMap r18 = new HashMap();     // Catch: NumberFormatException -> L12
        r18.put(r16, Integer.valueOf(r17));     // Catch: NumberFormatException -> L12
        r10.add(r18);     // Catch: NumberFormatException -> L12
    L12:
        CommSenseLog.e(TAG, "Invalid frequency format in scan result: ".concat(r14));
    L13:
        r13 = r13 + 1;
        goto L6
    L14:
        return r10;
    }

    private void handleWifiFence(boolean r8) {
        StringBuilder r10 = android.aimedia.a.l("handleWifiFence: nowInFence=", r8, ", mInFence=");
        r10.append(this.mInFence);
        CommSenseLog.d(TAG, r10.toString());
        this.mFenceBssidNotFoundCount = 0;
        if (r8 == true) goto L5;
    L7:
        if (r8 == false) goto L9;
        return;
    L9:
        if (this.mInFence == false) goto L14;
        this.mInFence = false;
        CommSenseLog.d(TAG, "Transition: onWifiExit()");
        this.mStateMachine.onWifiExit();
        return;
    L14:
        return;
    L5:
        if (this.mInFence == true) goto L7;
        this.mInFence = true;
        CommSenseLog.d(TAG, "Transition: onWifiEnter()");
        this.mStateMachine.onWifiEnter();
    }

    private void persistBssidSets() {
        this.mContext.getSharedPreferences(PREF_NAME, 0).edit().putString(KEY_HOME_BSSIDS, String.join(",", this.mHomeWifiBssids)).putString(KEY_FENCE_BSSIDS, String.join(",", this.mFenceBssids)).putString(KEY_HOME_FENCE_SCAN_RESULTS, serializeScanResults(this.mHomeFenceScanResults)).putString(KEY_COMPANY_FENCE_SCAN_RESULTS, serializeScanResults(this.mCompanyFenceScanResults)).apply();
    }

    private void restoreBssidSets() {
        LinkedHashSet r8 = new LinkedHashSet();
        LinkedHashSet r10 = new LinkedHashSet();
        String r11 = this.mContext.getSharedPreferences(PREF_NAME, 0).getString(KEY_HOME_BSSIDS, "");
        String r12 = this.mContext.getSharedPreferences(PREF_NAME, 0).getString(KEY_FENCE_BSSIDS, "");
        if (r11.isEmpty() == true) goto L8;
        String[] r13 = r11.split(",");
        int r14 = r13.length;
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L8;
        r8.add(r13[r15]);
        r15 = r15 + 1;
    L8:
        if (r12.isEmpty() == true) goto L12;
        String[] r16 = r12.split(",");
        int r17 = r16.length;
        int r18 = 0;
    L10:
        if (r18 >= r17) goto L12;
        r10.add(r16[r18]);
        r18 = r18 + 1;
    L12:
        this.mHomeWifiBssids.clear();
        this.mHomeWifiBssids.addAll(r8);
        this.mFenceBssids.clear();
        this.mFenceBssids.addAll(r10);
        String r19 = this.mContext.getSharedPreferences(PREF_NAME, 0).getString(KEY_HOME_FENCE_SCAN_RESULTS, "");
        this.mHomeFenceScanResults.clear();
        this.mHomeFenceScanResults.addAll(deserializeScanResults(r19));
        String r20 = this.mContext.getSharedPreferences(PREF_NAME, 0).getString(KEY_COMPANY_FENCE_SCAN_RESULTS, "");
        this.mCompanyFenceScanResults.clear();
        this.mCompanyFenceScanResults.addAll(deserializeScanResults(r20));
    }

    private String serializeScanResults(Set<Map<String, Integer>> r8) {
        StringBuilder r10 = new StringBuilder();
        Iterator<Map<String, Integer>> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L13;
        Iterator<Map.Entry<String, Integer>> r12 = r11.next().entrySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L4;
        Map.Entry<String, Integer> r13 = r12.next();
        if (r10.length() <= 0) goto L11;
        r10.append("||");
    L11:
        r10.append(r13.getKey());
        r10.append(BdimCategoryConstants.SEPARATOR_COLON);
        r10.append(r13.getValue());
        goto L7
    L13:
        return r10.toString();
    }

    public void addHomeWifiBssid(String r8) {
        if (r8 == null) goto L5;
        this.mHomeWifiBssids.add(r8);
        this.mFenceBssids.add(r8);
        CommSenseLog.d(TAG, "addHomeWifiBssid: ".concat(r8));
        return;
    }

    public void clearHomeWifiBssids() {
        Iterator<String> r8 = this.mHomeWifiBssids.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        String r10 = r8.next();
        this.mFenceBssids.remove(r10);
        goto L4
    L6:
        this.mHomeWifiBssids.clear();
        handleWifiFence(false);
        CommSenseLog.d(TAG, "clearHomeWifiBssids");
    }

    public Set<Map<String, Integer>> getCompanyFenceScanResults() {
        CommSenseLog.d(TAG, "getCompanyFenceScanResults size is" + this.mCompanyFenceScanResults.size());
        return new LinkedHashSet(this.mCompanyFenceScanResults);
    }

    public Set<String> getFenceBssids() {
        return new LinkedHashSet(this.mFenceBssids);
    }

    public Set<String> getHomeBssids() {
        return new LinkedHashSet(this.mHomeWifiBssids);
    }

    public Set<Map<String, Integer>> getHomeFenceScanResults() {
        CommSenseLog.d(TAG, "getHomeFenceScanResults size is" + this.mHomeFenceScanResults.size());
        return new LinkedHashSet(this.mHomeFenceScanResults);
    }

    public Set<String> getHomeWifiBssids() {
        return new LinkedHashSet(this.mHomeWifiBssids);
    }

    public void handleScanResults(List<ScanResult> r10) {
        Object r8 = this.mLock;
        monitor-enter(r8);
        CommSenseLog.d(TAG, "Scan results size: " + r10.size());     // Catch: Throwable -> L41
        Iterator<ScanResult> r11 = r10.iterator();     // Catch: Throwable -> L41
        boolean r12 = false;
    L6:
        if (r11.hasNext() == false) goto L22;
        ScanResult r13 = r11.next();     // Catch: Throwable -> L41
        String r14 = r13.BSSID;     // Catch: Throwable -> L41
        if (this.mLearningActive == false) goto L16;
        this.mFenceBssids.add(r14);     // Catch: Throwable -> L41
        HashMap r15 = new HashMap();     // Catch: Throwable -> L41
        r15.put(r13.SSID, Integer.valueOf(r13.frequency));     // Catch: Throwable -> L41
        if (this.mFenceType != 3) goto L13;
        Set<Map<String, Integer>> r16 = this.mCompanyFenceScanResults;     // Catch: Throwable -> L41
    L12:
        r16.add(r15);     // Catch: Throwable -> L41
        CommSenseLog.d(TAG, "Learning mode: added to mFenceBssids: " + r14 + " mHomeFenceScanResults size is" + this.mHomeFenceScanResults.size() + " mCompanyFenceScanResults size is" + this.mCompanyFenceScanResults.size());     // Catch: Throwable -> L41
        goto L16
    L13:
        r16 = this.mHomeFenceScanResults;     // Catch: Throwable -> L41
    L16:
        if (this.mFenceBssids.contains(r14) == false) goto L6;
        CommSenseLog.d(TAG, "Fence BSSID detected in scan: " + r14);     // Catch: Throwable -> L41
        if (this.mLearningActive == false) goto L19;
        r12 = true;
        goto L6
    L19:
        r12 = true;
    L22:
        if (this.mFenceBssids.size() != this.mHomeWifiBssids.size()) goto L24;
    L38:
        CommSenseLog.d(TAG, "Have not learned any BSSIDs or in home, do not switch WifiFenceState");     // Catch: Throwable -> L41
        monitor-exit(r8);     // Catch: Throwable -> L41
        return;
    L24:
        if (this.mInHome == true) goto L38;
        if (r12 == false) goto L29;
        handleWifiFence(true);     // Catch: Throwable -> L41
    L36:
        monitor-exit(r8);     // Catch: Throwable -> L41
        return;
    L29:
        if (this.mInFence == false) goto L36;
        int r17 = this.mFenceBssidNotFoundCount + 1;     // Catch: Throwable -> L41
        this.mFenceBssidNotFoundCount = r17;     // Catch: Throwable -> L41
        if (r17 >= 3) goto L33;
    L35:
        CommSenseLog.d(TAG, "Fence BSSID not found in scan, incrementing count to " + this.mFenceBssidNotFoundCount);     // Catch: Throwable -> L41
        goto L36
    L33:
        if (this.mHomeApConnected == true) goto L35;
        handleWifiFence(false);     // Catch: Throwable -> L41
        this.mFenceBssidNotFoundCount = 0;     // Catch: Throwable -> L41
        CommSenseLog.d(TAG, "Fence BSSID not found for 3 scans, resetting");     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        throw th;
    }

    public boolean isHomeWifiBssid(String r8) {
        if (r8 != null) goto L4;
    L6:
        boolean r10 = false;
    L7:
        CommSenseLog.d(TAG, "isHomeWifiBssid(" + r8 + ") = " + r10);
        return r10;
    L4:
        if (this.mHomeWifiBssids.contains(r8) == false) goto L6;
        r10 = true;
        goto L7
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void onEnterHome() {
        CommSenseLog.d(TAG, "Enter home: enable learning mode");
        this.mInHome = true;
        this.mLearningActive = true;
    }

    public void onExitHome() {
        CommSenseLog.d(TAG, "Exit home: disable learning mode");
        this.mLearningActive = false;
        this.mInHome = false;
        persistBssidSets();
    }

    public void removeHomeWifiBssid(String r8) {
        if (r8 == null) goto L5;
        this.mHomeWifiBssids.remove(r8);
        this.mFenceBssids.remove(r8);
        CommSenseLog.d(TAG, "removeHomeWifiBssid: ".concat(r8));
        return;
    }

    public void start(int r8) {
        CommSenseLog.d(TAG, "Start monitoring fence type: " + r8);
        this.mFenceType = r8;
        this.mContext.registerReceiver(this.mReceiver, defpackage.a.c("android.net.wifi.SCAN_RESULTS", "android.net.wifi.STATE_CHANGE"));
        this.mIsRunning = true;
    }

    public void stop() {
        CommSenseLog.d(TAG, "Stop monitoring");
        this.mContext.unregisterReceiver(this.mReceiver);
        this.mInFence = false;
        this.mLearningActive = false;
        this.mIsRunning = false;
    }
}
