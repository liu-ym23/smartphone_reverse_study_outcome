package com.obric.cae.libs.wifi.basicInfo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.obric.cae.libs.utils.LogUtil;
import com.obric.cae.libs.utils.WifiUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class BasicInfoManager {
    public static final int INT_ERROR = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static BasicInfoManager f5577h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WifiManager f5578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WifiState f5579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ScanResultBean f5580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ChannelsEnvironment f5581d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArrayList<WifiChangeListener> f5582e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f5583f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WifiInfoBean f5584g;

    public class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BasicInfoManager f5585a;

        public a(BasicInfoManager r8) {
            this.f5585a = r8;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r8, Intent r10) {
            String r11 = r10.getAction();
            if ("android.net.wifi.WIFI_STATE_CHANGED".equals(r11) == false) goto L10;
            this.f5585a.f5579b.handleWifiStateChanged(r10.getIntExtra("wifi_state", 4));
            BasicInfoManager r12 = this.f5585a;
            int r13 = r12.f5579b.getState();
            Iterator<WifiChangeListener> r14 = r12.f5582e.iterator();
        L6:
            if (r14.hasNext() == false) goto L8;
            r14.next().onWifiStateChanged(r13);
        L8:
            this.f5585a.b();
            return;
        L10:
            if ("android.net.wifi.STATE_CHANGE".equals(r11) == false) goto L16;
            NetworkInfo r15 = (NetworkInfo) r10.getParcelableExtra("networkInfo");
            this.f5585a.f5579b.handleConnectStateChanged(r15.getDetailedState());
            BasicInfoManager r16 = this.f5585a;
            int r17 = r16.f5579b.getState();
            Iterator<WifiChangeListener> r18 = r16.f5582e.iterator();
        L13:
            if (r18.hasNext() == false) goto L8;
            r18.next().onWifiStateChanged(r17);
            goto L13
        L16:
            if ("android.net.wifi.SCAN_RESULTS".equals(r11) == false) goto L22;
            this.f5585a.f5581d.update();
            this.f5585a.f5580c.update();
            BasicInfoManager r19 = this.f5585a;
            List<ScanResult> r20 = WifiUtils.getWifiScanResults(r19.f5583f, r19.f5578a);
            Iterator<WifiChangeListener> r21 = r19.f5582e.iterator();
        L19:
            if (r21.hasNext() == false) goto L29;
            r21.next().onScanInfoChanged(r20);
            goto L19
        L29:
            return;
        L22:
            if ("android.net.wifi.RSSI_CHANGED".equals(r11) == true) goto L8;
        }
    }

    public BasicInfoManager(Context r8) {
        this.f5582e = new CopyOnWriteArrayList();
        a r10 = new a(this);
        this.f5583f = r8;
        WifiManager r11 = (WifiManager) r8.getSystemService("wifi");
        this.f5578a = r11;
        this.f5579b = new WifiState();
        this.f5584g = new WifiInfoBean(r11);
        this.f5581d = new ChannelsEnvironment(r8, r11);
        this.f5580c = new ScanResultBean(r8, r11);
        IntentFilter r12 = new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED");
        r12.addAction("android.net.wifi.STATE_CHANGE");
        r12.addAction("android.net.wifi.SCAN_RESULTS");
        r12.addAction("android.net.wifi.RSSI_CHANGED");
        r8.registerReceiver(r10, r12);
        a();
        refreshData();
    }

    public static BasicInfoManager getInstance(Context r8) {
        if (r8 == null) goto L15;
        monitor-enter(BasicInfoManager.class);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (f5577h != null) goto L8;
        f5577h = new BasicInfoManager(r8);     // Catch: Throwable -> L11
    L8:
        monitor-exit(BasicInfoManager.class);     // Catch: Throwable -> L11
        return f5577h;
    L15:
        throw new IllegalArgumentException("context cannot be null");
    }

    public final void a() {
        if (this.f5578a.isWifiEnabled() == true) goto L5;
        this.f5579b.handleWifiStateChanged(1);
        return;
    L5:
        this.f5579b.handleWifiStateChanged(3);
        boolean r8 = WifiUtils.isWifiConnected(this.f5583f);
        WifiState r10 = this.f5579b;
        if (r8 == false) goto L8;
        r10.handleConnectStateChanged(NetworkInfo.DetailedState.CONNECTED);
        return;
    L8:
        r10.handleWifiStateChanged(3);
    }

    public final void b() {
        WifiInfoBean r8 = this.f5584g.update();
        if (r8 != null) goto L5;
        return;
    L5:
        LogUtil.d("BasicInfoManager", "Update WifiInfoBean:" + r8.toString());
        if (r8.equals(this.f5584g) == true) goto L14;
        Iterator<WifiChangeListener> r10 = this.f5582e.iterator();
    L9:
        if (r10.hasNext() == false) goto L11;
        r10.next().onWifiInfoChanged(true);
        goto L9
    L11:
        this.f5584g = r8;
        return;
    }

    public int getBand() {
        int r8 = getFrequency();
        if (WifiUtils.is24GHz(r8) == false) goto L7;
        return 1;
    L7:
        if (WifiUtils.is5GHz(r8) == false) goto L11;
        return 2;
    L11:
        if (WifiUtils.is6GHz(r8) == false) goto L14;
        return 8;
    L14:
        return -1;
    }

    public int getBandwidth() {
        if (getWifiState() == 5) goto L7;
        return -1;
    L7:
        return this.f5580c.getBandwidth();
    }

    public String getBssid() {
        if (getWifiState() == 5) goto L5;
        return null;
    L5:
        return this.f5584g.getBssid();
    }

    public int getChannel() {
        if (getWifiState() == 5) goto L5;
        return -1;
    L5:
        return this.f5584g.getChannel();
    }

    public int getCurrentChannelUsedCount() {
        if (getWifiState() == 5) goto L7;
        return -1;
    L7:
        return this.f5580c.getCurrentChannelUsedCount();
    }

    public int getFrequency() {
        if (getWifiState() == 5) goto L5;
        return -1;
    L5:
        return this.f5584g.getFrequency();
    }

    public List<ScanResult> getLastScanResults() {
        if (getWifiState() >= 3) goto L7;
        return null;
    L7:
        return this.f5580c.getLastScanResults();
    }

    public int getRssi() {
        if (getWifiState() == 5) goto L5;
        return -1;
    L5:
        return this.f5584g.getRssi();
    }

    public int getRxLinkSpeedMbps() {
        if (getWifiState() == 5) goto L7;
        return -1;
    L7:
        return this.f5584g.getRxLinkSpeedMbps();
    }

    public String getSsid() {
        if (getWifiState() == 5) goto L5;
        return null;
    L5:
        return this.f5584g.getSsid();
    }

    public int getTxLinkSpeedMbps() {
        if (getWifiState() == 5) goto L7;
        return -1;
    L7:
        return this.f5584g.getTxLinkSpeedMbps();
    }

    public int getWifiStandard() {
        return this.f5584g.getWifiStandard();
    }

    public int getWifiState() {
        return this.f5579b.getState();
    }

    public void refreshData() {
        b();
        startScan();
    }

    public boolean registerWifiChangeListener(WifiChangeListener r8) {
        return this.f5582e.add(r8);
    }

    public boolean startScan() {
        if (getWifiState() >= 3) goto L6;
        LogUtil.i("BasicInfoManager", "startScan failed");
        return false;
    L6:
        LogUtil.i("BasicInfoManager", "startScan");
        return this.f5580c.startScan();
    }

    public boolean unregisterWifiChangeListener(WifiChangeListener r8) {
        if (this.f5582e.contains(r8) == true) goto L5;
        return false;
    L5:
        return this.f5582e.remove(r8);
    }
}
