package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.Api;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003JO\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0006HÆ\u0001J\u0013\u0010#\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0006HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013¨\u0006'"}, d2 = {"Lcom/obric/memorydata/database/entity/ConnectWifiInfo;", "", Api.KEY_SSID, "", "bssid", "rssi", "", "frequency", "timestamp", "", "isMobileHotspot", "", "apStandard", "<init>", "(Ljava/lang/String;Ljava/lang/String;IIJZI)V", "getSsid", "()Ljava/lang/String;", "getBssid", "getRssi", "()I", "setRssi", "(I)V", "getFrequency", "getTimestamp", "()J", "()Z", "getApStandard", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ConnectWifiInfo {
    private final int apStandard;
    private final String bssid;
    private final int frequency;
    private final boolean isMobileHotspot;
    private int rssi;
    private final String ssid;
    private final long timestamp;

    public ConnectWifiInfo(String r2, String r3, int r4, int r5, long r6, boolean r8, int r9) {
        Intrinsics.checkNotNullParameter(r2, Api.KEY_SSID);
        Intrinsics.checkNotNullParameter(r3, "bssid");
        this.ssid = r2;
        this.bssid = r3;
        this.rssi = r4;
        this.frequency = r5;
        this.timestamp = r6;
        this.isMobileHotspot = r8;
        this.apStandard = r9;
    }

    public static /* synthetic */ ConnectWifiInfo copy$default(ConnectWifiInfo r9, String r10, String r11, int r12, int r13, long r14, boolean r16, int r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r1 = r9.ssid;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r2 = r9.bssid;
    L11:
        if ((r18 & 4) == 0) goto L13;
        int r3 = r9.rssi;
    L15:
        if ((r18 & 8) == 0) goto L17;
        int r4 = r9.frequency;
    L19:
        if ((r18 & 16) == 0) goto L21;
        long r5 = r9.timestamp;
    L23:
        if ((r18 & 32) == 0) goto L25;
        boolean r7 = r9.isMobileHotspot;
    L27:
        if ((r18 & 64) == 0) goto L29;
        int r8 = r9.apStandard;
    L31:
        return r9.copy(r1, r2, r3, r4, r5, r7, r8);
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r5 = r14;
        goto L23
    L17:
        r4 = r13;
        goto L19
    L13:
        r3 = r12;
        goto L15
    L9:
        r2 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
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

    public final long component5() {
        return this.timestamp;
    }

    public final boolean component6() {
        return this.isMobileHotspot;
    }

    public final int component7() {
        return this.apStandard;
    }

    public final ConnectWifiInfo copy(String r11, String r12, int r13, int r14, long r15, boolean r17, int r18) {
        Intrinsics.checkNotNullParameter(r11, Api.KEY_SSID);
        Intrinsics.checkNotNullParameter(r12, "bssid");
        return new ConnectWifiInfo(r11, r12, r13, r14, r15, r17, r18);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ConnectWifiInfo.class) == true) goto L8;
        return false;
    L8:
        ConnectWifiInfo r10 = (ConnectWifiInfo) ZeusTransformUtils.preCheckCast(r9, ConnectWifiInfo.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.ssid, r10.ssid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bssid, r10.bssid) == true) goto L15;
        return false;
    L15:
        if (this.rssi == r10.rssi) goto L18;
        return false;
    L18:
        if (this.frequency == r10.frequency) goto L21;
        return false;
    L21:
        if (this.timestamp == r10.timestamp) goto L24;
        return false;
    L24:
        if (this.isMobileHotspot == r10.isMobileHotspot) goto L27;
        return false;
    L27:
        if (this.apStandard == r10.apStandard) goto L29;
        return false;
    L29:
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

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return (((((((((((this.ssid.hashCode() * 31) + this.bssid.hashCode()) * 31) + Integer.hashCode(this.rssi)) * 31) + Integer.hashCode(this.frequency)) * 31) + Long.hashCode(this.timestamp)) * 31) + Boolean.hashCode(this.isMobileHotspot)) * 31) + Integer.hashCode(this.apStandard);
    }

    public final boolean isMobileHotspot() {
        return this.isMobileHotspot;
    }

    public final void setRssi(int r1) {
        this.rssi = r1;
    }

    public String toString() {
        return "ConnectWifiInfo(ssid=" + this.ssid + ", bssid=" + this.bssid + ", rssi=" + this.rssi + ", frequency=" + this.frequency + ", timestamp=" + this.timestamp + ", isMobileHotspot=" + this.isMobileHotspot + ", apStandard=" + this.apStandard + ')';
    }
}
