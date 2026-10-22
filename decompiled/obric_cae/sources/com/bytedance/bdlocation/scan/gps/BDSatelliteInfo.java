package com.bytedance.bdlocation.scan.gps;

import ia.b;

/* JADX INFO: loaded from: classes.dex */
public class BDSatelliteInfo {

    @b("azimuth_degrees")
    public float azimuthDegrees;

    @b("carrier_frequency_hz")
    public float carrierFrequencyHz;

    @b("constellation_type")
    public int constellationType;

    @b("elevation_degrees")
    public float elevationDegrees;

    @b("has_carrier_frequency_hz")
    public boolean hasCarrierFrequencyHz;

    @b("svid")
    public int sVid;

    @b("snr")
    public float snr;

    @b("used_in_fix")
    public boolean usedInFix;

    public BDSatelliteInfo() {
    }
}
