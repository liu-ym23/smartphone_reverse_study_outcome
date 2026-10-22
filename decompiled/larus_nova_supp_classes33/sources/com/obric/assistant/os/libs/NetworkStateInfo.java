package com.obric.assistant.os.libs;

import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B§\u0001\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010#\u001a\u0004\u0018\u00010\u0004J\b\u0010$\u001a\u0004\u0018\u00010\u0006J\b\u0010%\u001a\u0004\u0018\u00010\bJ\b\u0010&\u001a\u0004\u0018\u00010\nJ\b\u0010'\u001a\u0004\u0018\u00010\fJ\u0013\u0010(\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003HÆ\u0003J\u0013\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0003HÆ\u0003J\u0013\u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0003HÆ\u0003J\u0013\u0010,\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u00100\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u00101\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010!J®\u0001\u00102\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00032\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00032\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00032\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u00020\u00122\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u000207HÖ\u0001J\t\u00108\u001a\u000209HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R \u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R \u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b\u0011\u0010!R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b\u0013\u0010!R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b\u0014\u0010!¨\u0006:"}, d2 = {"Lcom/obric/assistant/os/libs/NetworkStateInfo;", "", "networkChangedEvents", "", "Lcom/obric/assistant/os/libs/NetworkChangedEvent;", "powerModeChangedEvents", "Lcom/obric/assistant/os/libs/PowerModeChangedEvent;", "wifiQoEQueue", "Lcom/obric/assistant/os/libs/WifiQoE;", "l4QoEQueue", "Lcom/obric/assistant/os/libs/L4QoE;", "cellularQoEQueue", "Lcom/obric/assistant/os/libs/CellularQoE;", "defaultNetworkInfo", "Lcom/obric/assistant/os/libs/NetworkInfo;", "vipStrategyReport", "Lcom/obric/assistant/os/libs/VipStrategyReport;", "isIdleMode", "", "isPowerSaveMode", "isSleepMode", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/obric/assistant/os/libs/NetworkInfo;Lcom/obric/assistant/os/libs/VipStrategyReport;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getNetworkChangedEvents", "()Ljava/util/List;", "getPowerModeChangedEvents", "getWifiQoEQueue", "getL4QoEQueue", "getCellularQoEQueue", "getDefaultNetworkInfo", "()Lcom/obric/assistant/os/libs/NetworkInfo;", "getVipStrategyReport", "()Lcom/obric/assistant/os/libs/VipStrategyReport;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLastNetworkEvent", "getLastPowerModeEvent", "getLastWifiQoE", "getLastL4QoE", "getLastCellularQoE", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/obric/assistant/os/libs/NetworkInfo;Lcom/obric/assistant/os/libs/VipStrategyReport;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/obric/assistant/os/libs/NetworkStateInfo;", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NetworkStateInfo {

    @SerializedName("CellularQoEQueue")
    private final List<CellularQoE> cellularQoEQueue;

    @SerializedName("defaultNetworkInfo")
    private final NetworkInfo defaultNetworkInfo;

    @SerializedName("isIdleMode")
    private final Boolean isIdleMode;

    @SerializedName("isPowerSaveMode")
    private final Boolean isPowerSaveMode;

    @SerializedName("isSleepMode")
    private final Boolean isSleepMode;

    @SerializedName("L4QoEQueue")
    private final List<L4QoE> l4QoEQueue;

    @SerializedName("networkChangedEvents")
    private final List<NetworkChangedEvent> networkChangedEvents;

    @SerializedName("powerModeChangedEvents")
    private final List<PowerModeChangedEvent> powerModeChangedEvents;

    @SerializedName("vipStrategyReport")
    private final VipStrategyReport vipStrategyReport;

    @SerializedName("wifiQoEQueue")
    private final List<WifiQoE> wifiQoEQueue;

    public NetworkStateInfo() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NetworkStateInfo copy$default(NetworkStateInfo r11, List r12, List r13, List r14, List r15, List r16, NetworkInfo r17, VipStrategyReport r18, Boolean r19, Boolean r20, Boolean r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        List r2 = r11.networkChangedEvents;
    L7:
        if ((r22 & 2) == 0) goto L9;
        List r3 = r11.powerModeChangedEvents;
    L11:
        if ((r22 & 4) == 0) goto L13;
        List r4 = r11.wifiQoEQueue;
    L15:
        if ((r22 & 8) == 0) goto L17;
        List r5 = r11.l4QoEQueue;
    L19:
        if ((r22 & 16) == 0) goto L21;
        List r6 = r11.cellularQoEQueue;
    L23:
        if ((r22 & 32) == 0) goto L25;
        NetworkInfo r7 = r11.defaultNetworkInfo;
    L27:
        if ((r22 & 64) == 0) goto L29;
        VipStrategyReport r8 = r11.vipStrategyReport;
    L31:
        if ((r22 & 128) == 0) goto L33;
        Boolean r9 = r11.isIdleMode;
    L35:
        if ((r22 & 256) == 0) goto L37;
        Boolean r10 = r11.isPowerSaveMode;
    L39:
        if ((r22 & 512) == 0) goto L41;
        Boolean r1 = r11.isSleepMode;
    L43:
        return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L41:
        r1 = r21;
        goto L43
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    public final List<NetworkChangedEvent> component1() {
        return this.networkChangedEvents;
    }

    public final Boolean component10() {
        return this.isSleepMode;
    }

    public final List<PowerModeChangedEvent> component2() {
        return this.powerModeChangedEvents;
    }

    public final List<WifiQoE> component3() {
        return this.wifiQoEQueue;
    }

    public final List<L4QoE> component4() {
        return this.l4QoEQueue;
    }

    public final List<CellularQoE> component5() {
        return this.cellularQoEQueue;
    }

    public final NetworkInfo component6() {
        return this.defaultNetworkInfo;
    }

    public final VipStrategyReport component7() {
        return this.vipStrategyReport;
    }

    public final Boolean component8() {
        return this.isIdleMode;
    }

    public final Boolean component9() {
        return this.isPowerSaveMode;
    }

    public final NetworkStateInfo copy(List<NetworkChangedEvent> r13, List<PowerModeChangedEvent> r14, List<WifiQoE> r15, List<L4QoE> r16, List<CellularQoE> r17, NetworkInfo r18, VipStrategyReport r19, Boolean r20, Boolean r21, Boolean r22) {
        return new NetworkStateInfo(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof NetworkStateInfo) == true) goto L8;
        return false;
    L8:
        NetworkStateInfo r6 = (NetworkStateInfo) r5;
        if (Intrinsics.areEqual(this.networkChangedEvents, r6.networkChangedEvents) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.powerModeChangedEvents, r6.powerModeChangedEvents) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.wifiQoEQueue, r6.wifiQoEQueue) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.l4QoEQueue, r6.l4QoEQueue) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.cellularQoEQueue, r6.cellularQoEQueue) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.defaultNetworkInfo, r6.defaultNetworkInfo) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.vipStrategyReport, r6.vipStrategyReport) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.isIdleMode, r6.isIdleMode) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.isPowerSaveMode, r6.isPowerSaveMode) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.isSleepMode, r6.isSleepMode) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        List<NetworkChangedEvent> r0 = this.networkChangedEvents;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<PowerModeChangedEvent> r4 = this.powerModeChangedEvents;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<WifiQoE> r7 = this.wifiQoEQueue;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        List<L4QoE> r10 = this.l4QoEQueue;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        List<CellularQoE> r13 = this.cellularQoEQueue;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        NetworkInfo r16 = this.defaultNetworkInfo;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        VipStrategyReport r19 = this.vipStrategyReport;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Boolean r22 = this.isIdleMode;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Boolean r25 = this.isPowerSaveMode;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Boolean r28 = this.isSleepMode;
        if (r28 == null) goto L43;
        r1 = r28.hashCode();
    L43:
        return r27 + r1;
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
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
        return "NetworkStateInfo(networkChangedEvents=" + this.networkChangedEvents + ", powerModeChangedEvents=" + this.powerModeChangedEvents + ", wifiQoEQueue=" + this.wifiQoEQueue + ", l4QoEQueue=" + this.l4QoEQueue + ", cellularQoEQueue=" + this.cellularQoEQueue + ", defaultNetworkInfo=" + this.defaultNetworkInfo + ", vipStrategyReport=" + this.vipStrategyReport + ", isIdleMode=" + this.isIdleMode + ", isPowerSaveMode=" + this.isPowerSaveMode + ", isSleepMode=" + this.isSleepMode + ')';
    }

    public final CellularQoE getLastCellularQoE() {
        List<CellularQoE> r0 = this.cellularQoEQueue;
        Object r1 = null;
        if (r0 == null) goto L32;
        Iterator<T> r2 = r0.iterator();
        if (r2.hasNext() == false) goto L28;
        r1 = r2.next();
        if (r2.hasNext() == false) goto L28;
        CellularQoE r3 = (CellularQoE) r1;
        if (r3 == null) goto L15;
        Long r4 = r3.getTimestamp();
        if (r4 == null) goto L15;
        long r5 = r4.longValue();
    L16:
        Object r6 = r2.next();
        CellularQoE r7 = (CellularQoE) r6;
        if (r7 == null) goto L21;
        Long r8 = r7.getTimestamp();
        if (r8 == null) goto L21;
        long r9 = r8.longValue();
    L23:
        if (r5 >= r9) goto L26;
        r1 = r6;
        r5 = r9;
    L26:
        if (r2.hasNext() == true) goto L16;
    L21:
        r9 = 0;
    L15:
        r5 = 0;
    L28:
        return (CellularQoE) r1;
    L32:
        return null;
    }

    public final L4QoE getLastL4QoE() {
        List<L4QoE> r0 = this.l4QoEQueue;
        Object r1 = null;
        if (r0 == null) goto L32;
        Iterator<T> r2 = r0.iterator();
        if (r2.hasNext() == false) goto L28;
        r1 = r2.next();
        if (r2.hasNext() == false) goto L28;
        L4QoE r3 = (L4QoE) r1;
        if (r3 == null) goto L15;
        Long r4 = r3.getTimestamp();
        if (r4 == null) goto L15;
        long r5 = r4.longValue();
    L16:
        Object r6 = r2.next();
        L4QoE r7 = (L4QoE) r6;
        if (r7 == null) goto L21;
        Long r8 = r7.getTimestamp();
        if (r8 == null) goto L21;
        long r9 = r8.longValue();
    L23:
        if (r5 >= r9) goto L26;
        r1 = r6;
        r5 = r9;
    L26:
        if (r2.hasNext() == true) goto L16;
    L21:
        r9 = 0;
    L15:
        r5 = 0;
    L28:
        return (L4QoE) r1;
    L32:
        return null;
    }

    public final NetworkChangedEvent getLastNetworkEvent() {
        List<NetworkChangedEvent> r0 = this.networkChangedEvents;
        Object r1 = null;
        if (r0 == null) goto L32;
        Iterator<T> r2 = r0.iterator();
        if (r2.hasNext() == false) goto L28;
        r1 = r2.next();
        if (r2.hasNext() == false) goto L28;
        NetworkChangedEvent r3 = (NetworkChangedEvent) r1;
        if (r3 == null) goto L15;
        Long r4 = r3.getTimestamp();
        if (r4 == null) goto L15;
        long r5 = r4.longValue();
    L16:
        Object r6 = r2.next();
        NetworkChangedEvent r7 = (NetworkChangedEvent) r6;
        if (r7 == null) goto L21;
        Long r8 = r7.getTimestamp();
        if (r8 == null) goto L21;
        long r9 = r8.longValue();
    L23:
        if (r5 >= r9) goto L26;
        r1 = r6;
        r5 = r9;
    L26:
        if (r2.hasNext() == true) goto L16;
    L21:
        r9 = 0;
    L15:
        r5 = 0;
    L28:
        return (NetworkChangedEvent) r1;
    L32:
        return null;
    }

    public final PowerModeChangedEvent getLastPowerModeEvent() {
        List<PowerModeChangedEvent> r0 = this.powerModeChangedEvents;
        Object r1 = null;
        if (r0 == null) goto L32;
        Iterator<T> r2 = r0.iterator();
        if (r2.hasNext() == false) goto L28;
        r1 = r2.next();
        if (r2.hasNext() == false) goto L28;
        PowerModeChangedEvent r3 = (PowerModeChangedEvent) r1;
        if (r3 == null) goto L15;
        Long r4 = r3.getTimestamp();
        if (r4 == null) goto L15;
        long r5 = r4.longValue();
    L16:
        Object r6 = r2.next();
        PowerModeChangedEvent r7 = (PowerModeChangedEvent) r6;
        if (r7 == null) goto L21;
        Long r8 = r7.getTimestamp();
        if (r8 == null) goto L21;
        long r9 = r8.longValue();
    L23:
        if (r5 >= r9) goto L26;
        r1 = r6;
        r5 = r9;
    L26:
        if (r2.hasNext() == true) goto L16;
    L21:
        r9 = 0;
    L15:
        r5 = 0;
    L28:
        return (PowerModeChangedEvent) r1;
    L32:
        return null;
    }

    public final WifiQoE getLastWifiQoE() {
        List<WifiQoE> r0 = this.wifiQoEQueue;
        Object r1 = null;
        if (r0 == null) goto L32;
        Iterator<T> r2 = r0.iterator();
        if (r2.hasNext() == false) goto L28;
        r1 = r2.next();
        if (r2.hasNext() == false) goto L28;
        WifiQoE r3 = (WifiQoE) r1;
        if (r3 == null) goto L15;
        Long r4 = r3.getTimestamp();
        if (r4 == null) goto L15;
        long r5 = r4.longValue();
    L16:
        Object r6 = r2.next();
        WifiQoE r7 = (WifiQoE) r6;
        if (r7 == null) goto L21;
        Long r8 = r7.getTimestamp();
        if (r8 == null) goto L21;
        long r9 = r8.longValue();
    L23:
        if (r5 >= r9) goto L26;
        r1 = r6;
        r5 = r9;
    L26:
        if (r2.hasNext() == true) goto L16;
    L21:
        r9 = 0;
    L15:
        r5 = 0;
    L28:
        return (WifiQoE) r1;
    L32:
        return null;
    }

    public final List<CellularQoE> getCellularQoEQueue() {
        return this.cellularQoEQueue;
    }

    public final NetworkInfo getDefaultNetworkInfo() {
        return this.defaultNetworkInfo;
    }

    public final List<L4QoE> getL4QoEQueue() {
        return this.l4QoEQueue;
    }

    public final List<NetworkChangedEvent> getNetworkChangedEvents() {
        return this.networkChangedEvents;
    }

    public final List<PowerModeChangedEvent> getPowerModeChangedEvents() {
        return this.powerModeChangedEvents;
    }

    public final VipStrategyReport getVipStrategyReport() {
        return this.vipStrategyReport;
    }

    public final List<WifiQoE> getWifiQoEQueue() {
        return this.wifiQoEQueue;
    }

    public final Boolean isIdleMode() {
        return this.isIdleMode;
    }

    public final Boolean isPowerSaveMode() {
        return this.isPowerSaveMode;
    }

    public final Boolean isSleepMode() {
        return this.isSleepMode;
    }

    public NetworkStateInfo(List<NetworkChangedEvent> r1, List<PowerModeChangedEvent> r2, List<WifiQoE> r3, List<L4QoE> r4, List<CellularQoE> r5, NetworkInfo r6, VipStrategyReport r7, Boolean r8, Boolean r9, Boolean r10) {
        this.networkChangedEvents = r1;
        this.powerModeChangedEvents = r2;
        this.wifiQoEQueue = r3;
        this.l4QoEQueue = r4;
        this.cellularQoEQueue = r5;
        this.defaultNetworkInfo = r6;
        this.vipStrategyReport = r7;
        this.isIdleMode = r8;
        this.isPowerSaveMode = r9;
        this.isSleepMode = r10;
    }

    public /* synthetic */ NetworkStateInfo(List r12, List r13, List r14, List r15, List r16, NetworkInfo r17, VipStrategyReport r18, Boolean r19, Boolean r20, Boolean r21, int r22, DefaultConstructorMarker r23) {
        Boolean r2 = null;
        if ((r22 & 1) == 0) goto L5;
        List r1 = null;
    L7:
        if ((r22 & 2) == 0) goto L9;
        List r3 = null;
    L11:
        if ((r22 & 4) == 0) goto L13;
        List r4 = null;
    L15:
        if ((r22 & 8) == 0) goto L17;
        List r5 = null;
    L19:
        if ((r22 & 16) == 0) goto L21;
        List r6 = null;
    L23:
        if ((r22 & 32) == 0) goto L25;
        NetworkInfo r7 = null;
    L27:
        if ((r22 & 64) == 0) goto L29;
        VipStrategyReport r8 = null;
    L31:
        if ((r22 & 128) == 0) goto L33;
        Boolean r9 = null;
    L35:
        if ((r22 & 256) == 0) goto L37;
        Boolean r10 = null;
    L39:
        if ((r22 & 512) != 0) goto L42;
        r2 = r21;
    L42:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r2);
        return;
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }
}
