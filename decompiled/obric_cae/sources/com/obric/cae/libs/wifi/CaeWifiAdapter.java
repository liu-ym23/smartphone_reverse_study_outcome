package com.obric.cae.libs.wifi;

import android.content.Context;
import android.net.wifi.ScanResult;
import com.obric.cae.libs.smartnetwork.CaeSmartNetworkManager;
import com.obric.cae.libs.statusreport.CaeStatusReportManager;
import com.obric.cae.libs.statusreport.LinkLayerQuality;
import com.obric.cae.libs.utils.CaelibUtils;
import com.obric.cae.libs.wifi.basicInfo.BasicInfoManager;
import com.obric.cae.libs.wifi.basicInfo.WifiChangeListener;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CaeWifiAdapter {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static CaeWifiAdapter f5573d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CaeStatusReportManager f5574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CaeSmartNetworkManager f5575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BasicInfoManager f5576c;

    public CaeWifiAdapter(Context r8) {
        this.f5574a = CaeStatusReportManager.getInstance(r8);
        this.f5575b = CaeSmartNetworkManager.getInstance(r8);
        this.f5576c = BasicInfoManager.getInstance(r8);
    }

    public static CaeWifiAdapter getInstance(Context r8) {
        if (r8 == null) goto L18;
        if (f5573d != null) goto L16;
        monitor-enter(CaeWifiAdapter.class);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (f5573d != null) goto L10;
        f5573d = new CaeWifiAdapter(r8);     // Catch: Throwable -> L12
    L10:
        monitor-exit(CaeWifiAdapter.class);     // Catch: Throwable -> L12
    L16:
        return f5573d;
    L18:
        throw new IllegalArgumentException("context cannot be null");
    }

    public int getBand() {
        return this.f5576c.getBand();
    }

    public int getBandwidth() {
        return this.f5576c.getBandwidth();
    }

    public String getBssid() {
        return this.f5576c.getBssid();
    }

    public String getCaeVersion() {
        return this.f5574a.getCaeVersion();
    }

    public String getCaelibVersion() {
        return CaelibUtils.getCaelibVersion();
    }

    public int getChannel() {
        return this.f5576c.getChannel();
    }

    public int getCurrentChannelUsedCount() {
        return this.f5576c.getCurrentChannelUsedCount();
    }

    public int getFrequency() {
        return this.f5576c.getFrequency();
    }

    public List<ScanResult> getLastScanResults() {
        return this.f5576c.getLastScanResults();
    }

    public LinkLayerQuality getLinkLayerQuality() {
        return this.f5574a.getLinkLayerQuality();
    }

    public int getLinkThroughput() {
        return this.f5575b.getLinkThroughput();
    }

    public int getRssi() {
        return this.f5576c.getRssi();
    }

    public int getRxLinkSpeedMbps() {
        return this.f5576c.getRxLinkSpeedMbps();
    }

    public String getSsid() {
        return this.f5576c.getSsid();
    }

    public int getTxLinkSpeedMbps() {
        return this.f5576c.getTxLinkSpeedMbps();
    }

    public int getWifiStandard() {
        return this.f5576c.getWifiStandard();
    }

    public int getWifiState() {
        return this.f5576c.getWifiState();
    }

    public void registerLinkLayerQualityChangedListener(CaeStatusReportManager.LinkLayerQualityChangedListener r8) {
        this.f5574a.registerLinkLayerQualityChangedListener(r8);
    }

    public void registerLinkThroughputListener(CaeSmartNetworkManager.CaeWifiLinkThroughputListener r8) {
        this.f5575b.registerLinkThroughputListener(r8);
    }

    public boolean registerWifiChangeListener(WifiChangeListener r8) {
        return this.f5576c.registerWifiChangeListener(r8);
    }

    public boolean startScan() {
        return this.f5576c.startScan();
    }

    public void unregisterLinkLayerQualityChangedListener(CaeStatusReportManager.LinkLayerQualityChangedListener r8) {
        this.f5574a.unregisterLinkLayerQualityChangedListener(r8);
    }

    public void unregisterLinkThroughputListener(CaeSmartNetworkManager.CaeWifiLinkThroughputListener r8) {
        this.f5575b.unregisterLinkThroughputListener(r8);
    }

    public boolean unregisterWifiChangeListener(WifiChangeListener r8) {
        return this.f5576c.unregisterWifiChangeListener(r8);
    }
}
