package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.Api;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\"\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010!\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010#\u001a\u00020\bH\u0016J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003J\t\u0010(\u001a\u00020\nHÆ\u0003J\t\u0010)\u001a\u00020\fHÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003J\t\u0010+\u001a\u00020\fHÆ\u0003JY\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\fHÆ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u001a\u0010\u000e\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001c\"\u0004\b\u001f\u0010 ¨\u0006."}, d2 = {"Lcom/obric/memorydata/database/entity/ConnectWifiInfoSummary;", "", Api.KEY_SSID, "", "bssid", "rssi", "", "frequency", "", "isMobileHotspot", "", "useTime", "", "apStandard", "lastTimestamp", "<init>", "(Ljava/lang/String;Ljava/lang/String;[IIZJIJ)V", "getSsid", "()Ljava/lang/String;", "getBssid", "getRssi", "()[I", "setRssi", "([I)V", "getFrequency", "()I", "()Z", "getUseTime", "()J", "getApStandard", "getLastTimestamp", "setLastTimestamp", "(J)V", "equals", "other", "hashCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ConnectWifiInfoSummary {
    private final int apStandard;
    private final String bssid;
    private final int frequency;
    private final boolean isMobileHotspot;
    private long lastTimestamp;
    private int[] rssi;
    private final String ssid;
    private final long useTime;

    public ConnectWifiInfoSummary(String r2, String r3, int[] r4, int r5, boolean r6, long r7, int r9, long r10) {
        Intrinsics.checkNotNullParameter(r2, Api.KEY_SSID);
        Intrinsics.checkNotNullParameter(r3, "bssid");
        Intrinsics.checkNotNullParameter(r4, "rssi");
        this.ssid = r2;
        this.bssid = r3;
        this.rssi = r4;
        this.frequency = r5;
        this.isMobileHotspot = r6;
        this.useTime = r7;
        this.apStandard = r9;
        this.lastTimestamp = r10;
    }

    public /* synthetic */ ConnectWifiInfoSummary(String r14, String r15, int[] r16, int r17, boolean r18, long r19, int r21, long r22, int r24, DefaultConstructorMarker r25) {
        if ((r24 & 128) == 0) goto L5;
        long r11 = 0;
    L6:
        this(r14, r15, r16, r17, r18, r19, r21, r11);
        return;
    L5:
        r11 = r22;
        goto L6
    }

    public static /* synthetic */ ConnectWifiInfoSummary copy$default(ConnectWifiInfoSummary r12, String r13, String r14, int[] r15, int r16, boolean r17, long r18, int r20, long r21, int r23, Object r24) {
        if ((r23 & 1) == 0) goto L5;
        String r2 = r12.ssid;
    L7:
        if ((r23 & 2) == 0) goto L9;
        String r3 = r12.bssid;
    L11:
        if ((r23 & 4) == 0) goto L13;
        int[] r4 = r12.rssi;
    L15:
        if ((r23 & 8) == 0) goto L17;
        int r5 = r12.frequency;
    L19:
        if ((r23 & 16) == 0) goto L21;
        boolean r6 = r12.isMobileHotspot;
    L23:
        if ((r23 & 32) == 0) goto L25;
        long r7 = r12.useTime;
    L27:
        if ((r23 & 64) == 0) goto L29;
        int r9 = r12.apStandard;
    L31:
        if ((r23 & 128) == 0) goto L33;
        long r10 = r12.lastTimestamp;
    L35:
        return r12.copy(r2, r3, r4, r5, r6, r7, r9, r10);
    L33:
        r10 = r21;
        goto L35
    L29:
        r9 = r20;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    public final String component1() {
        return this.ssid;
    }

    public final String component2() {
        return this.bssid;
    }

    public final int[] component3() {
        return this.rssi;
    }

    public final int component4() {
        return this.frequency;
    }

    public final boolean component5() {
        return this.isMobileHotspot;
    }

    public final long component6() {
        return this.useTime;
    }

    public final int component7() {
        return this.apStandard;
    }

    public final long component8() {
        return this.lastTimestamp;
    }

    public final ConnectWifiInfoSummary copy(String r13, String r14, int[] r15, int r16, boolean r17, long r18, int r20, long r21) {
        Intrinsics.checkNotNullParameter(r13, Api.KEY_SSID);
        Intrinsics.checkNotNullParameter(r14, "bssid");
        Intrinsics.checkNotNullParameter(r15, "rssi");
        return new ConnectWifiInfoSummary(r13, r14, r15, r16, r17, r18, r20, r21);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L5;
        return true;
    L5:
        Class<?> r2 = getClass();
        if (r9 == null) goto L8;
        Class<?> r3 = r9.getClass();
    L10:
        if (Intrinsics.areEqual(r2, r3) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.obric.memorydata.database.entity.ConnectWifiInfoSummary");
        ConnectWifiInfoSummary r4 = (ConnectWifiInfoSummary) ZeusTransformUtils.preCheckCast(r9, ConnectWifiInfoSummary.class, "com.obric.memorydata.plugin");
        if (this.frequency == ((ConnectWifiInfoSummary) ZeusTransformUtils.preCheckCast(r9, ConnectWifiInfoSummary.class, "com.obric.memorydata.plugin")).frequency) goto L16;
        return false;
    L16:
        if (this.useTime == ((ConnectWifiInfoSummary) ZeusTransformUtils.preCheckCast(r9, ConnectWifiInfoSummary.class, "com.obric.memorydata.plugin")).useTime) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.ssid, ((ConnectWifiInfoSummary) ZeusTransformUtils.preCheckCast(r9, ConnectWifiInfoSummary.class, "com.obric.memorydata.plugin")).ssid) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.bssid, ((ConnectWifiInfoSummary) ZeusTransformUtils.preCheckCast(r9, ConnectWifiInfoSummary.class, "com.obric.memorydata.plugin")).bssid) == true) goto L25;
        return false;
    L25:
        if (Arrays.equals(this.rssi, ((ConnectWifiInfoSummary) ZeusTransformUtils.preCheckCast(r9, ConnectWifiInfoSummary.class, "com.obric.memorydata.plugin")).rssi) == true) goto L27;
        return false;
    L27:
        return true;
    L8:
        r3 = null;
        goto L10
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

    public final long getLastTimestamp() {
        return this.lastTimestamp;
    }

    public final int[] getRssi() {
        return this.rssi;
    }

    public final String getSsid() {
        return this.ssid;
    }

    public final long getUseTime() {
        return this.useTime;
    }

    public int hashCode() {
        return (((((((this.frequency * 31) + Long.hashCode(this.useTime)) * 31) + this.ssid.hashCode()) * 31) + this.bssid.hashCode()) * 31) + Arrays.hashCode(this.rssi);
    }

    public final boolean isMobileHotspot() {
        return this.isMobileHotspot;
    }

    public final void setLastTimestamp(long r1) {
        this.lastTimestamp = r1;
    }

    public final void setRssi(int[] r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.rssi = r2;
    }

    public String toString() {
        return "ConnectWifiInfoSummary(ssid=" + this.ssid + ", bssid=" + this.bssid + ", rssi=" + Arrays.toString(this.rssi) + ", frequency=" + this.frequency + ", isMobileHotspot=" + this.isMobileHotspot + ", useTime=" + this.useTime + ", apStandard=" + this.apStandard + ", lastTimestamp=" + this.lastTimestamp + ')';
    }
}
