package com.obric.cae.statusReport.wifi;

import android.net.wifi.MloLink;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import com.obric.cae.utils.CaeWifiUtil;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CaeWifiInfo {
    private static final String TAG = "CaeWifiInfo";
    private String mBand;
    private String mBand1;
    private String mBssid;
    private int mFrequency;
    private int mFrequency1;
    private String mFriendlyName;
    private String mManufacturer;
    private boolean mMloEnable;
    private String mSsid;
    private int mWifiStandard;
    private String mWifigenertaion;

    public CaeWifiInfo() {
        this.mSsid = "";
        this.mBssid = "";
        this.mWifiStandard = 0;
        this.mWifigenertaion = "";
        this.mBand = "";
        this.mBand1 = "";
        this.mFrequency = 0;
        this.mFrequency1 = 0;
        this.mMloEnable = false;
        this.mManufacturer = "";
        this.mFriendlyName = "";
    }

    private void reset() {
        this.mSsid = "";
        this.mBssid = "";
        this.mWifiStandard = 0;
        this.mWifigenertaion = "";
        this.mBand = "";
        this.mBand1 = "";
        this.mFrequency = 0;
        this.mFrequency1 = 0;
        this.mMloEnable = false;
        this.mManufacturer = "";
        this.mFriendlyName = "";
    }

    public String getBand() {
        return this.mBand;
    }

    public String getBand1() {
        return this.mBand1;
    }

    public String getBssid() {
        return this.mBssid;
    }

    public int getFrequency() {
        return this.mFrequency;
    }

    public int getFrequency1() {
        return this.mFrequency1;
    }

    public boolean getMloEnable() {
        return this.mMloEnable;
    }

    public String getSsid() {
        return this.mSsid;
    }

    public int getWifiStandard() {
        return this.mWifiStandard;
    }

    public String getWifigenertaion() {
        return this.mWifigenertaion;
    }

    public CaeWifiInfo makeCopy() {
        return new CaeWifiInfo(this);
    }

    public void setFriendlyName(String r8) {
        this.mFriendlyName = r8;
    }

    public void setManufacaturer(String r8) {
        this.mManufacturer = r8;
    }

    public void updateCaeWifiInfo(WifiInfo r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.getSupplicantState() != SupplicantState.COMPLETED) goto L18;
        reset();
        this.mSsid = r8.getSSID();
        this.mBssid = r8.getBSSID();
        int r10 = r8.getWifiStandard();
        this.mWifiStandard = r10;
        this.mWifigenertaion = CaeWifiUtil.wifiStandardToGenerationString(r10);
        this.mBand = CaeWifiUtil.toBand(r8.getFrequency());
        this.mFrequency = r8.getFrequency();
        this.mMloEnable = false;
        if (this.mWifiStandard != 8) goto L15;
        List<MloLink> r11 = r8.getAffiliatedMloLinks();
        if (r11.size() < 2) goto L11;
        boolean r12 = true;
    L12:
        this.mMloEnable = r12;
        if (r12 == false) goto L15;
        this.mFrequency = ScanResult.convertChannelToFrequencyMhzIfSupported(r11.get(0).getChannel(), r11.get(0).getBand());
        this.mFrequency1 = ScanResult.convertChannelToFrequencyMhzIfSupported(r11.get(1).getChannel(), r11.get(1).getBand());
        this.mBand = CaeWifiUtil.toBand(this.mFrequency);
        this.mBand1 = CaeWifiUtil.toBand(this.mFrequency1);
        goto L15
    L11:
        r12 = false;
    L15:
        StringBuilder r13 = new StringBuilder("updateRouterInfo, bssid=");
        r13.append(CaeWifiUtil.maskMACAddress(this.mBssid));
        r13.append(" band=");
        r13.append(this.mBand);
        r13.append(" band1=");
        r13.append(this.mBand1);
        r13.append(" mloEnable=");
        r13.append(this.mMloEnable);
        r13.append(" frequncy=");
        r13.append(this.mFrequency);
        r13.append(" frequncy1=");
        defpackage.a.j(r13, this.mFrequency1, TAG);
        return;
    }

    public CaeWifiInfo(CaeWifiInfo r8) {
        this.mSsid = r8.mSsid;
        this.mBssid = r8.mBssid;
        this.mWifiStandard = r8.mWifiStandard;
        this.mWifigenertaion = r8.mWifigenertaion;
        this.mBand = r8.mBand;
        this.mBand1 = r8.mBand1;
        this.mFrequency = r8.mFrequency;
        this.mFrequency1 = r8.mFrequency1;
        this.mMloEnable = r8.mMloEnable;
        this.mManufacturer = r8.mManufacturer;
        this.mFriendlyName = r8.mFriendlyName;
    }
}
