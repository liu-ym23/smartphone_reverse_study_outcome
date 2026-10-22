package com.obric.cae.wifi;

/* JADX INFO: loaded from: classes2.dex */
public class ScannedBandRecord {
    public String currentBssid;
    public String currentSsid;
    public String scannedFreqsMhz;
    public long timestamp;

    public ScannedBandRecord() {
    }

    public String toString() {
        StringBuilder r8 = new StringBuilder("BandRecord{currentBssid=");
        r8.append(this.currentBssid);
        r8.append(", currentSsid=");
        r8.append(this.currentSsid);
        r8.append(", scannedFreqsMhz=[");
        return android.aimedia.a.i(r8, this.scannedFreqsMhz, "]}");
    }
}
