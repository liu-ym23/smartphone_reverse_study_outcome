package com.obric.cae.smartNetwork.throughtput;

import com.cae.caed.DeltaInfoParcel;
import com.cae.caed.LLStatsParcel;
import com.cae.caed.StaInfoParcel;

/* JADX INFO: loaded from: classes2.dex */
public class ThroughputFactor {
    private int mBandwidth;
    private int mBeContentionTime;
    private float mCcaBusyRate;
    private int mCenterFreq;
    private float mChannelBusyRate;
    private float mOntimeRate;
    private float mPerRate;
    private int mRssi;
    private int mRssiAck;
    private int mRssiData;
    private int mRssiMgmt;
    private float mRxLinkSpeed;
    private int mRxSpeed;
    private int mScanTime;
    private int mTotalRxMpdu;
    private int mTotalTxMpdu;
    private int mTotalTxRetriesMpdu;
    private float mTxLinkSpeed;
    private int mTxSpeed;
    private int mWifiStandard;

    public ThroughputFactor() {
        this.mRxLinkSpeed = 0.0f;
        this.mTxLinkSpeed = 0.0f;
        this.mOntimeRate = 0.0f;
        this.mCcaBusyRate = 0.0f;
        this.mChannelBusyRate = 0.0f;
        this.mTotalTxMpdu = 0;
        this.mTotalRxMpdu = 0;
        this.mTotalTxRetriesMpdu = 0;
        this.mPerRate = 0.0f;
        this.mRssi = 0;
        this.mTxSpeed = 0;
        this.mRxSpeed = 0;
        this.mCenterFreq = 0;
        this.mBeContentionTime = 0;
        this.mScanTime = 0;
        this.mRssiMgmt = 0;
        this.mRssiData = 0;
        this.mRssiAck = 0;
        this.mWifiStandard = 0;
        this.mBandwidth = 0;
    }

    public int getBandwidth() {
        return this.mBandwidth;
    }

    public int getBeContentionTime() {
        return this.mBeContentionTime;
    }

    public float getCcaBusyRate() {
        return this.mCcaBusyRate;
    }

    public int getCenterFreq() {
        return this.mCenterFreq;
    }

    public float getChannelBusyRate() {
        return this.mChannelBusyRate;
    }

    public float getOntimeRate() {
        return this.mOntimeRate;
    }

    public float getPerRate() {
        return this.mPerRate;
    }

    public int getRssi() {
        return this.mRssi;
    }

    public int getRssiAck() {
        return this.mRssiAck;
    }

    public int getRssiData() {
        return this.mRssiData;
    }

    public int getRssiMgmt() {
        return this.mRssiMgmt;
    }

    public float getRxLinkSpeed() {
        return this.mRxLinkSpeed;
    }

    public int getRxSpeed() {
        return this.mRxSpeed;
    }

    public int getScanTime() {
        return this.mScanTime;
    }

    public int getTotalRxMpdu() {
        return this.mTotalRxMpdu;
    }

    public int getTotalTxMpdu() {
        return this.mTotalTxMpdu;
    }

    public int getTotalTxRetriesMpdu() {
        return this.mTotalTxRetriesMpdu;
    }

    public float getTxLinkSpeed() {
        return this.mTxLinkSpeed;
    }

    public int getTxSpeed() {
        return this.mTxSpeed;
    }

    public int getWifiStandard() {
        return this.mWifiStandard;
    }

    public void setFactor(DeltaInfoParcel r8, StaInfoParcel r10, LLStatsParcel r11, int r12) {
        this.mTxLinkSpeed = r8.A;
        this.mRxLinkSpeed = r8.B;
        this.mOntimeRate = r8.f4110n;
        this.mCcaBusyRate = r8.f4113q;
        this.mChannelBusyRate = r8.f4112p;
        this.mTotalTxMpdu = r8.f4116t;
        this.mTotalRxMpdu = r8.f4117u;
        this.mTotalTxRetriesMpdu = r8.f4118v;
        this.mPerRate = r8.f4119w;
        this.mRssi = r10.f4188a;
        this.mTxSpeed = r8.f4121y;
        this.mRxSpeed = r8.f4122z;
        this.mCenterFreq = r8.f4108b;
        this.mBeContentionTime = r11.f4132n.f4095q;
        this.mScanTime = r8.f4109m;
        this.mRssiMgmt = r11.f4134p;
        this.mRssiData = r11.f4135q;
        this.mRssiAck = r11.f4136r;
        this.mWifiStandard = r12 + 2;
        this.mBandwidth = r11.f4137s;
    }

    public String toString() {
        StringBuilder r8 = new StringBuilder("ThroughputFactor{mWifiStandard=");
        r8.append(this.mWifiStandard);
        r8.append(", mCenterFreq=");
        r8.append(this.mCenterFreq);
        r8.append(", mBandwidth=");
        r8.append(this.mBandwidth);
        r8.append(", mRssi=");
        r8.append(this.mRssi);
        r8.append(", mRssiMgmt=");
        r8.append(this.mRssiMgmt);
        r8.append(", mRssiData=");
        r8.append(this.mRssiData);
        r8.append(", mRssiAck=");
        r8.append(this.mRssiAck);
        r8.append(", mTxLinkSpeed=");
        r8.append(this.mTxLinkSpeed);
        r8.append(", mRxLinkSpeed=");
        r8.append(this.mRxLinkSpeed);
        r8.append(", mOntimeRate=");
        r8.append(this.mOntimeRate);
        r8.append(", mCcaBusyRate=");
        r8.append(this.mCcaBusyRate);
        r8.append(", mChannelBusyRate=");
        r8.append(this.mChannelBusyRate);
        r8.append(", mTotalTxMpdu=");
        r8.append(this.mTotalTxMpdu);
        r8.append(", mTotalRxMpdu=");
        r8.append(this.mTotalRxMpdu);
        r8.append(", mTotalTxRetriesMpdu=");
        r8.append(this.mTotalTxRetriesMpdu);
        r8.append(", mPerRate=");
        r8.append(this.mPerRate);
        r8.append(", mTxSpeed=");
        r8.append(this.mTxSpeed);
        r8.append(", mRxSpeed=");
        r8.append(this.mRxSpeed);
        r8.append(", mBeContentionTime=");
        r8.append(this.mBeContentionTime);
        r8.append(", mScanTime=");
        return android.aimedia.a.f(r8, this.mScanTime, '}');
    }

    public ThroughputFactor(DeltaInfoParcel r8, StaInfoParcel r10, LLStatsParcel r11, int r12) {
        if (r8 != null) goto L5;
        this.mOntimeRate = 0.0f;
        this.mCcaBusyRate = 0.0f;
        this.mChannelBusyRate = 0.0f;
        this.mTotalTxMpdu = 0;
        this.mTotalRxMpdu = 0;
        this.mTotalTxRetriesMpdu = 0;
        this.mPerRate = 0.0f;
        this.mTxSpeed = 0;
        this.mRxSpeed = 0;
        this.mCenterFreq = 0;
        this.mScanTime = 0;
    L6:
        if (r10 != null) goto L8;
        this.mRssi = 0;
        this.mWifiStandard = 0;
    L9:
        if (r11 != null) goto L11;
        this.mBeContentionTime = 0;
        this.mRssiMgmt = 0;
        this.mRssiData = 0;
        this.mRssiAck = 0;
        this.mBandwidth = 0;
        return;
    L11:
        this.mBeContentionTime = r11.f4132n.f4095q;
        this.mRssiMgmt = r11.f4134p;
        this.mRssiData = r11.f4135q;
        this.mRssiAck = r11.f4136r;
        this.mBandwidth = r11.f4137s;
        return;
    L8:
        this.mRssi = r10.f4188a;
        this.mWifiStandard = r12 + 2;
        goto L9
    L5:
        this.mOntimeRate = r8.f4110n;
        this.mCcaBusyRate = r8.f4113q;
        this.mChannelBusyRate = r8.f4112p;
        this.mTotalTxMpdu = r8.f4116t;
        this.mTotalRxMpdu = r8.f4117u;
        this.mTotalTxRetriesMpdu = r8.f4118v;
        this.mPerRate = r8.f4119w;
        this.mTxSpeed = r8.f4121y;
        this.mRxSpeed = r8.f4122z;
        this.mCenterFreq = r8.f4108b;
        this.mRxLinkSpeed = r8.B;
        this.mTxLinkSpeed = r8.A;
        this.mScanTime = r8.f4109m;
        goto L6
    }
}
