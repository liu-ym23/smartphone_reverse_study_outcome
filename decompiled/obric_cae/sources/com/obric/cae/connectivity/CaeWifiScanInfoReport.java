package com.obric.cae.connectivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.obric.cae.utils.CaeUtil;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CaeWifiScanInfoReport implements IAoiDataCollector {
    private static final int CONNECTIVITY_EVENT_FEATURE_ID = 143;
    private static final String TAG = "CaeWifiScanInfoReport";
    private static CaeWifiScanInfoReport sInstance;
    private Context mContext;
    private String mCurrentPoiName;
    private boolean mIsRegistered;
    private long mTriggerTime;
    private WifiManager mWifiManager;
    private final BroadcastReceiver mWifiScanReceiver;

    public CaeWifiScanInfoReport() {
        this.mIsRegistered = false;
        this.mCurrentPoiName = "";
        this.mTriggerTime = 0;
        this.mWifiScanReceiver = new AnonymousClass1(this);
    }

    public static /* synthetic */ void access$000(CaeWifiScanInfoReport r8) {
        r8.handleScanResults();
    }

    public static CaeWifiScanInfoReport getInstance() {
        if (sInstance != null) goto L6;
        sInstance = new CaeWifiScanInfoReport();
    L6:
        return sInstance;
    }

    private void handleScanResults() {
        WifiManager r8 = this.mWifiManager;
        if (r8 != null) goto L40;
        return;
    L40:
        List<ScanResult> r10 = r8.getScanResults();     // Catch: Exception -> L34 SecurityException -> L36
        if (r10 != null) goto L8;
        return;
    L8:
        if (r10.isEmpty() == true) goto L52;
        long r11 = System.currentTimeMillis();     // Catch: Exception -> L34 SecurityException -> L36
        CaeUtil.timeMillisToDateString(r11);     // Catch: Exception -> L34 SecurityException -> L36
        CaeConnectivityDataProto.Builder r12 = CaeConnectivityDataProto.newBuilder();     // Catch: Exception -> L34 SecurityException -> L36
        CaeConnectivityProtoData.Builder r13 = CaeConnectivityProtoData.newBuilder();     // Catch: Exception -> L34 SecurityException -> L36
        long r14 = this.mTriggerTime;     // Catch: Exception -> L34 SecurityException -> L36
        if (r14 > 0) goto L14;
        r14 = r11;
    L14:
        CaeConnectivityProtoData.Builder r15 = r13.setDeviceTime(r14).setName(this.mCurrentPoiName);     // Catch: Exception -> L34 SecurityException -> L36
        Iterator<ScanResult> r16 = r10.iterator();     // Catch: Exception -> L34 SecurityException -> L36
    L16:
        if (r16.hasNext() == false) goto L29;
        ScanResult r17 = r16.next();     // Catch: Exception -> L34 SecurityException -> L36
        if (r17 == null) goto L16;
        if (r17.BSSID == null) goto L16;
        if (TextUtils.isEmpty(r17.SSID) == true) goto L16;
        WifiScanDataReport.Builder r18 = WifiScanDataReport.newBuilder().setSsid(r17.SSID).setBssid(r17.BSSID).setLevel(r17.level).setFrequency(r17.frequency).setChannelWidth(r17.channelWidth);     // Catch: Exception -> L34 SecurityException -> L36
        r18.setIsPasspointNetwork(r17.isPasspointNetwork());     // Catch: Exception -> L34 SecurityException -> L36
        r18.setIsSupport80211Mc(r17.is80211mcResponder());     // Catch: Exception -> L34 SecurityException -> L36
        String r19 = r17.capabilities;     // Catch: Exception -> L34 SecurityException -> L36
        if (r19 == null) goto L27;
        r18.setCapabilities(r19);     // Catch: Exception -> L34 SecurityException -> L36
    L27:
        r18.setWifiStandard(r17.getWifiStandard());     // Catch: Exception -> L34 SecurityException -> L36
        r18.setScanTimestampMs(r11 - (SystemClock.elapsedRealtime() - (r17.timestamp / 1000)));     // Catch: Exception -> L34 SecurityException -> L36
        r15.addWifiScanDataReport(r18);     // Catch: Exception -> L34 SecurityException -> L36
        goto L16
    L29:
        if (r15.getWifiScanDataReportCount() <= 0) goto L31;
        r12.addCaeConnectivityProto(r15);     // Catch: Exception -> L34 SecurityException -> L36
        CaeUtil.writePbEventSafely(r11, CONNECTIVITY_EVENT_FEATURE_ID, r12.build().toByteArray());     // Catch: Exception -> L34 SecurityException -> L36
        Log.i(TAG, "Reported " + r15.getWifiScanDataReportCount() + " scanned APs to CaeConnectivityDataProto");     // Catch: Exception -> L34 SecurityException -> L36
    L31:
        stopCollect();     // Catch: Exception -> L34 SecurityException -> L36
    L53:
        return;
    L52:
        return;
    L36:
        e = e;
        String r20 = "Missing location/wifi permissions for getScanResults";
    L38:
        Log.e(TAG, r20, e);
        return;
    L34:
        e = e;
        r20 = "Failed to handle and report scan results";
        goto L38
    }

    @Override // com.obric.cae.connectivity.IAoiDataCollector
    public void destroy() {
        stopCollect();
        this.mContext = null;
        this.mWifiManager = null;
    }

    @Override // com.obric.cae.connectivity.IAoiDataCollector
    public int getCollectorType() {
        return 1;
    }

    @Override // com.obric.cae.connectivity.IAoiDataCollector
    public void init(Context r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        Context r10 = r8.getApplicationContext();
        this.mContext = r10;
        this.mWifiManager = (WifiManager) r10.getSystemService("wifi");
        Log.i(TAG, "CaeWifiScanInfoReport initialized.");
    }

    @Override // com.obric.cae.connectivity.IAoiDataCollector
    public synchronized void startCollect(String r8, long r10) {
        monitor-enter(this);
        this.mCurrentPoiName = r8;     // Catch: Throwable -> L21
        this.mTriggerTime = r10;     // Catch: Throwable -> L21
        if (this.mContext != null) goto L7;
    L18:
        Log.e(TAG, "Cannot start collect: Not initialized.");     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L7:
        if (this.mWifiManager == null) goto L18;
        if (this.mIsRegistered == true) goto L16;
        this.mContext.registerReceiver(this.mWifiScanReceiver, new IntentFilter("android.net.wifi.SCAN_RESULTS"));     // Catch: Throwable -> L21
        this.mIsRegistered = true;     // Catch: Throwable -> L21
        Log.i(TAG, "Started collecting: Wifi scan receiver registered.");     // Catch: Throwable -> L21
        Log.i(TAG, "Triggered active Wi-Fi scan: " + this.mWifiManager.startScan());     // Catch: Exception -> L14 Throwable -> L21
    L14:
        e = move-exception;
        Log.e(TAG, "Failed to trigger active Wi-Fi scan", e);     // Catch: Throwable -> L21
    L16:
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.cae.connectivity.IAoiDataCollector
    public synchronized void stopCollect() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsRegistered == false) goto L11;
        Context r8 = this.mContext;     // Catch: Throwable -> L13
        if (r8 == null) goto L11;
        r8.unregisterReceiver(this.mWifiScanReceiver);     // Catch: Exception -> L9 Throwable -> L13
        this.mIsRegistered = false;     // Catch: Exception -> L9 Throwable -> L13
        Log.i(TAG, "Stopped collecting: Wifi scan receiver unregistered.");     // Catch: Exception -> L9 Throwable -> L13
    L9:
        e = move-exception;
        Log.e(TAG, "Failed to unregister receiver", e);     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
    }
}
