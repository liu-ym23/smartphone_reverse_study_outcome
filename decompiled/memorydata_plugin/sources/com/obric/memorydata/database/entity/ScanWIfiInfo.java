package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.Api;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/database/entity/ScanWIfiInfo;", "", Api.KEY_SSID, "", "bssid", "rssi", "", "frequency", "apStandard", "<init>", "(Ljava/lang/String;Ljava/lang/String;III)V", "getSsid", "()Ljava/lang/String;", "getBssid", "getRssi", "()I", "getFrequency", "getApStandard", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScanWIfiInfo {
    private final int apStandard;
    private final String bssid;
    private final int frequency;
    private final int rssi;
    private final String ssid;

    public ScanWIfiInfo(String r2, String r3, int r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, Api.KEY_SSID);
        Intrinsics.checkNotNullParameter(r3, "bssid");
        this.ssid = r2;
        this.bssid = r3;
        this.rssi = r4;
        this.frequency = r5;
        this.apStandard = r6;
    }

    public static /* synthetic */ ScanWIfiInfo copy$default(ScanWIfiInfo r3, String r4, String r5, int r6, int r7, int r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.ssid;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.bssid;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.rssi;
    L11:
        int r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.frequency;
    L14:
        int r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.apStandard;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.ssid;
    }

    public final String component2() {
        return this.bssid;
    }

    public final int component3() {
        return this.rssi;
    }

    public final int component4() {
        return this.frequency;
    }

    public final int component5() {
        return this.apStandard;
    }

    public final ScanWIfiInfo copy(String r7, String r8, int r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r7, Api.KEY_SSID);
        Intrinsics.checkNotNullParameter(r8, "bssid");
        return new ScanWIfiInfo(r7, r8, r9, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ScanWIfiInfo.class) == true) goto L8;
        return false;
    L8:
        ScanWIfiInfo r6 = (ScanWIfiInfo) ZeusTransformUtils.preCheckCast(r5, ScanWIfiInfo.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.ssid, r6.ssid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bssid, r6.bssid) == true) goto L15;
        return false;
    L15:
        if (this.rssi == r6.rssi) goto L18;
        return false;
    L18:
        if (this.frequency == r6.frequency) goto L21;
        return false;
    L21:
        if (this.apStandard == r6.apStandard) goto L23;
        return false;
    L23:
        return true;
    }

    public final int getApStandard() {
        return this.apStandard;
    }

    public final String getBssid() {
        return this.bssid;
    }

    public final int getFrequency() {
        return this.frequency;
    }

    public final int getRssi() {
        return this.rssi;
    }

    public final String getSsid() {
        return this.ssid;
    }

    public int hashCode() {
        return (((((((this.ssid.hashCode() * 31) + this.bssid.hashCode()) * 31) + Integer.hashCode(this.rssi)) * 31) + Integer.hashCode(this.frequency)) * 31) + Integer.hashCode(this.apStandard);
    }

    public String toString() {
        return "ScanWIfiInfo(ssid=" + this.ssid + ", bssid=" + this.bssid + ", rssi=" + this.rssi + ", frequency=" + this.frequency + ", apStandard=" + this.apStandard + ')';
    }
}
