package com.bytedance.bdlocation.scan.gps;

import ia.b;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BDGnssInfo {

    @b("callback_clock")
    public long callbackClock;

    @b("satellite_info")
    public List<BDSatelliteInfo> satelliteInfos;

    @b("satellite_num")
    public int satelliteNum;

    @b("snr")
    public List<Float> snr;

    @b("timestamp")
    public long timestamp;

    public BDGnssInfo() {
    }
}
