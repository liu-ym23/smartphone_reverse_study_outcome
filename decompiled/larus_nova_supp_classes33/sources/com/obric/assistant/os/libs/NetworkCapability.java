package com.obric.assistant.os.libs;

import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010JV\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u0010R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0014\u0010\u0010¨\u0006\""}, d2 = {"Lcom/obric/assistant/os/libs/NetworkCapability;", "", "ssid", "", "bssid", "freq", "", "rssi", "linkSpeed", "rxLinkSpeed", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getSsid", "()Ljava/lang/String;", "getBssid", "getFreq", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRssi", "getLinkSpeed", "getRxLinkSpeed", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/obric/assistant/os/libs/NetworkCapability;", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NetworkCapability {

    @SerializedName("bssid")
    private final String bssid;

    @SerializedName("freq")
    private final Integer freq;

    @SerializedName("linkspeed")
    private final Integer linkSpeed;

    @SerializedName("rssi")
    private final Integer rssi;

    @SerializedName("rxLinkspeed")
    private final Integer rxLinkSpeed;

    @SerializedName("ssid")
    private final String ssid;

    public NetworkCapability() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ NetworkCapability copy$default(NetworkCapability r4, String r5, String r6, Integer r7, Integer r8, Integer r9, Integer r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.ssid;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.bssid;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.freq;
    L11:
        Integer r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.rssi;
    L14:
        Integer r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.linkSpeed;
    L17:
        Integer r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.rxLinkSpeed;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.ssid;
    }

    public final String component2() {
        return this.bssid;
    }

    public final Integer component3() {
        return this.freq;
    }

    public final Integer component4() {
        return this.rssi;
    }

    public final Integer component5() {
        return this.linkSpeed;
    }

    public final Integer component6() {
        return this.rxLinkSpeed;
    }

    public final NetworkCapability copy(String r9, String r10, Integer r11, Integer r12, Integer r13, Integer r14) {
        return new NetworkCapability(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof NetworkCapability) == true) goto L8;
        return false;
    L8:
        NetworkCapability r6 = (NetworkCapability) r5;
        if (Intrinsics.areEqual(this.ssid, r6.ssid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bssid, r6.bssid) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.freq, r6.freq) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.rssi, r6.rssi) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.linkSpeed, r6.linkSpeed) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.rxLinkSpeed, r6.rxLinkSpeed) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r0 = this.ssid;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.bssid;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.freq;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.rssi;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.linkSpeed;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.rxLinkSpeed;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "NetworkCapability(ssid=" + this.ssid + ", bssid=" + this.bssid + ", freq=" + this.freq + ", rssi=" + this.rssi + ", linkSpeed=" + this.linkSpeed + ", rxLinkSpeed=" + this.rxLinkSpeed + ')';
    }

    public final String getBssid() {
        return this.bssid;
    }

    public final Integer getFreq() {
        return this.freq;
    }

    public final Integer getLinkSpeed() {
        return this.linkSpeed;
    }

    public final Integer getRssi() {
        return this.rssi;
    }

    public final Integer getRxLinkSpeed() {
        return this.rxLinkSpeed;
    }

    public final String getSsid() {
        return this.ssid;
    }

    public NetworkCapability(String r1, String r2, Integer r3, Integer r4, Integer r5, Integer r6) {
        this.ssid = r1;
        this.bssid = r2;
        this.freq = r3;
        this.rssi = r4;
        this.linkSpeed = r5;
        this.rxLinkSpeed = r6;
    }

    public /* synthetic */ NetworkCapability(String r6, String r7, Integer r8, Integer r9, Integer r10, Integer r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        String r14 = null;
    L7:
        if ((r12 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r12 & 4) == 0) goto L13;
        Integer r2 = null;
    L15:
        if ((r12 & 8) == 0) goto L17;
        Integer r3 = null;
    L19:
        if ((r12 & 16) == 0) goto L21;
        Integer r4 = null;
    L23:
        if ((r12 & 32) == 0) goto L25;
        Integer r15 = null;
    L26:
        this(r14, r1, r2, r3, r4, r15);
        return;
    L25:
        r15 = r11;
        goto L26
    L21:
        r4 = r10;
        goto L23
    L17:
        r3 = r9;
        goto L19
    L13:
        r2 = r8;
        goto L15
    L9:
        r1 = r7;
        goto L11
    L5:
        r14 = r6;
        goto L7
    }
}
