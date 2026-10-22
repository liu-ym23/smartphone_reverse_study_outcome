package com.obric.assistant.os.libs;

import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.capabilitykit.common.UiType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\bB\b\u0087\b\u0018\u00002\u00020\u0001B\u0083\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00105\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u00106\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u00108\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u00109\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010:\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010;\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010<\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010=\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010>\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010?\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010@\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010B\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010C\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010D\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010E\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u008a\u0002\u0010F\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010GJ\u0013\u0010H\u001a\u00020\u00032\b\u0010I\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010J\u001a\u00020\bHÖ\u0001J\t\u0010K\u001a\u00020\nHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u0002\u0010\u001cR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u0004\u0010\u001cR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u0005\u0010\u001cR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u0006\u0010\u001cR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b#\u0010\u001fR\u001a\u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b$\u0010\u001fR\u001a\u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b%\u0010\u001fR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b&\u0010\u001fR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b'\u0010\u001fR\u001a\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b(\u0010\u001fR\u001a\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b)\u0010\u001fR\u001a\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b*\u0010\u001fR\u001a\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b+\u0010\u001fR\u001a\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b,\u0010\u001fR\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u0015\u0010\u001cR\u001a\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b-\u0010\u001fR\u001a\u0010\u0017\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b.\u0010\u001fR\u001a\u0010\u0018\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b/\u0010\u001fR\u001a\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b0\u0010\u001f¨\u0006L"}, d2 = {"Lcom/obric/assistant/os/libs/VipStrategyReport;", "", "isVipNetworkFeatureEnabled", "", "isWifiAccelEnabled", "isSuperStableEnabled", "isVipChannelEnabled", "rateStrategyType", "", "foregroundAppPkg", "", "foregroundRateLimit", "vipChannelRateLimit", "backgroundRateLimit", "foregroundThroughput", "vipChannelThroughput", "backgroundThroughput", "doubaoRtt", "doubaoAvgRttFiveSec", "doubaoMaxRttFiveSec", "doubaoMinRttFiveSec", "isVpnEnabled", "wifiCurrentThroughput", "wifiRtt", "cellularThroughput", "cellularRtt", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getRateStrategyType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getForegroundAppPkg", "()Ljava/lang/String;", "getForegroundRateLimit", "getVipChannelRateLimit", "getBackgroundRateLimit", "getForegroundThroughput", "getVipChannelThroughput", "getBackgroundThroughput", "getDoubaoRtt", "getDoubaoAvgRttFiveSec", "getDoubaoMaxRttFiveSec", "getDoubaoMinRttFiveSec", "getWifiCurrentThroughput", "getWifiRtt", "getCellularThroughput", "getCellularRtt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/obric/assistant/os/libs/VipStrategyReport;", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VipStrategyReport {

    @SerializedName("backgroundRateLimit")
    private final Integer backgroundRateLimit;

    @SerializedName("backgroundThroughput")
    private final Integer backgroundThroughput;

    @SerializedName("cellularRtt")
    private final Integer cellularRtt;

    @SerializedName("cellularThroughput")
    private final Integer cellularThroughput;

    @SerializedName("doubaoAvgRttFiveSec")
    private final Integer doubaoAvgRttFiveSec;

    @SerializedName("doubaoMaxRttFiveSec")
    private final Integer doubaoMaxRttFiveSec;

    @SerializedName("doubaoMinRttFiveSec")
    private final Integer doubaoMinRttFiveSec;

    @SerializedName("doubaoRtt")
    private final Integer doubaoRtt;

    @SerializedName("foregroundAppPkg")
    private final String foregroundAppPkg;

    @SerializedName("foregroundRateLimit")
    private final Integer foregroundRateLimit;

    @SerializedName("foregroundThroughput")
    private final Integer foregroundThroughput;

    @SerializedName("isSuperStableEnabled")
    private final Boolean isSuperStableEnabled;

    @SerializedName("isVipChannelEnabled")
    private final Boolean isVipChannelEnabled;

    @SerializedName("isVipNetworkFeatureEnabled")
    private final Boolean isVipNetworkFeatureEnabled;

    @SerializedName("isVpnEnabled")
    private final Boolean isVpnEnabled;

    @SerializedName("isWifiAccelEnabled")
    private final Boolean isWifiAccelEnabled;

    @SerializedName("rateStrategyType")
    private final Integer rateStrategyType;

    @SerializedName("vipChannelRateLimit")
    private final Integer vipChannelRateLimit;

    @SerializedName("vipChannelThroughput")
    private final Integer vipChannelThroughput;

    @SerializedName("wifiCurrentThroughput")
    private final Integer wifiCurrentThroughput;

    @SerializedName("wifiRtt")
    private final Integer wifiRtt;

    public VipStrategyReport() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
    }

    public static /* synthetic */ VipStrategyReport copy$default(VipStrategyReport r17, Boolean r18, Boolean r19, Boolean r20, Boolean r21, Integer r22, String r23, Integer r24, Integer r25, Integer r26, Integer r27, Integer r28, Integer r29, Integer r30, Integer r31, Integer r32, Integer r33, Boolean r34, Integer r35, Integer r36, Integer r37, Integer r38, int r39, Object r40) {
        if ((r39 & 1) == 0) goto L5;
        Boolean r2 = r17.isVipNetworkFeatureEnabled;
    L7:
        if ((r39 & 2) == 0) goto L9;
        Boolean r3 = r17.isWifiAccelEnabled;
    L11:
        if ((r39 & 4) == 0) goto L13;
        Boolean r4 = r17.isSuperStableEnabled;
    L15:
        if ((r39 & 8) == 0) goto L17;
        Boolean r5 = r17.isVipChannelEnabled;
    L19:
        if ((r39 & 16) == 0) goto L21;
        Integer r6 = r17.rateStrategyType;
    L23:
        if ((r39 & 32) == 0) goto L25;
        String r7 = r17.foregroundAppPkg;
    L27:
        if ((r39 & 64) == 0) goto L29;
        Integer r8 = r17.foregroundRateLimit;
    L31:
        if ((r39 & 128) == 0) goto L33;
        Integer r9 = r17.vipChannelRateLimit;
    L35:
        if ((r39 & 256) == 0) goto L37;
        Integer r10 = r17.backgroundRateLimit;
    L39:
        if ((r39 & 512) == 0) goto L41;
        Integer r11 = r17.foregroundThroughput;
    L43:
        if ((r39 & 1024) == 0) goto L45;
        Integer r12 = r17.vipChannelThroughput;
    L47:
        if ((r39 & 2048) == 0) goto L49;
        Integer r13 = r17.backgroundThroughput;
    L51:
        if ((r39 & 4096) == 0) goto L53;
        Integer r14 = r17.doubaoRtt;
    L55:
        if ((r39 & 8192) == 0) goto L57;
        Integer r15 = r17.doubaoAvgRttFiveSec;
    L58:
        Integer r310 = r15;
        if ((r39 & 16384) == 0) goto L61;
        Integer r16 = r17.doubaoMaxRttFiveSec;
    L62:
        Integer r311 = r16;
        if ((r39 & 32768) == 0) goto L65;
        Integer r110 = r17.doubaoMinRttFiveSec;
    L66:
        Integer r312 = r110;
        if ((r39 & UiType.FLAG_ALARM_CLOCK_CARD) == 0) goto L69;
        Boolean r111 = r17.isVpnEnabled;
    L70:
        Boolean r313 = r111;
        if ((r39 & UiType.FLAG_PHONE_CARD) == 0) goto L73;
        Integer r112 = r17.wifiCurrentThroughput;
    L74:
        Integer r314 = r112;
        if ((r39 & UiType.FLAG_TIMER_CARD) == 0) goto L77;
        Integer r113 = r17.wifiRtt;
    L78:
        Integer r315 = r113;
        if ((r39 & UiType.FLAG_WIFI_QRCODE_CARD) == 0) goto L81;
        Integer r114 = r17.cellularThroughput;
    L83:
        if ((r39 & UiType.FLAG_APP_CHOOSER_CARD) == 0) goto L85;
        Integer r1 = r17.cellularRtt;
    L87:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r114, r1);
    L85:
        r1 = r38;
        goto L87
    L81:
        r114 = r37;
        goto L83
    L77:
        r113 = r36;
        goto L78
    L73:
        r112 = r35;
        goto L74
    L69:
        r111 = r34;
        goto L70
    L65:
        r110 = r33;
        goto L66
    L61:
        r16 = r32;
        goto L62
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final Boolean component1() {
        return this.isVipNetworkFeatureEnabled;
    }

    public final Integer component10() {
        return this.foregroundThroughput;
    }

    public final Integer component11() {
        return this.vipChannelThroughput;
    }

    public final Integer component12() {
        return this.backgroundThroughput;
    }

    public final Integer component13() {
        return this.doubaoRtt;
    }

    public final Integer component14() {
        return this.doubaoAvgRttFiveSec;
    }

    public final Integer component15() {
        return this.doubaoMaxRttFiveSec;
    }

    public final Integer component16() {
        return this.doubaoMinRttFiveSec;
    }

    public final Boolean component17() {
        return this.isVpnEnabled;
    }

    public final Integer component18() {
        return this.wifiCurrentThroughput;
    }

    public final Integer component19() {
        return this.wifiRtt;
    }

    public final Boolean component2() {
        return this.isWifiAccelEnabled;
    }

    public final Integer component20() {
        return this.cellularThroughput;
    }

    public final Integer component21() {
        return this.cellularRtt;
    }

    public final Boolean component3() {
        return this.isSuperStableEnabled;
    }

    public final Boolean component4() {
        return this.isVipChannelEnabled;
    }

    public final Integer component5() {
        return this.rateStrategyType;
    }

    public final String component6() {
        return this.foregroundAppPkg;
    }

    public final Integer component7() {
        return this.foregroundRateLimit;
    }

    public final Integer component8() {
        return this.vipChannelRateLimit;
    }

    public final Integer component9() {
        return this.backgroundRateLimit;
    }

    public final VipStrategyReport copy(Boolean r24, Boolean r25, Boolean r26, Boolean r27, Integer r28, String r29, Integer r30, Integer r31, Integer r32, Integer r33, Integer r34, Integer r35, Integer r36, Integer r37, Integer r38, Integer r39, Boolean r40, Integer r41, Integer r42, Integer r43, Integer r44) {
        return new VipStrategyReport(r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof VipStrategyReport) == true) goto L8;
        return false;
    L8:
        VipStrategyReport r6 = (VipStrategyReport) r5;
        if (Intrinsics.areEqual(this.isVipNetworkFeatureEnabled, r6.isVipNetworkFeatureEnabled) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isWifiAccelEnabled, r6.isWifiAccelEnabled) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.isSuperStableEnabled, r6.isSuperStableEnabled) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.isVipChannelEnabled, r6.isVipChannelEnabled) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.rateStrategyType, r6.rateStrategyType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.foregroundAppPkg, r6.foregroundAppPkg) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.foregroundRateLimit, r6.foregroundRateLimit) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.vipChannelRateLimit, r6.vipChannelRateLimit) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.backgroundRateLimit, r6.backgroundRateLimit) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.foregroundThroughput, r6.foregroundThroughput) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.vipChannelThroughput, r6.vipChannelThroughput) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.backgroundThroughput, r6.backgroundThroughput) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.doubaoRtt, r6.doubaoRtt) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.doubaoAvgRttFiveSec, r6.doubaoAvgRttFiveSec) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.doubaoMaxRttFiveSec, r6.doubaoMaxRttFiveSec) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.doubaoMinRttFiveSec, r6.doubaoMinRttFiveSec) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.isVpnEnabled, r6.isVpnEnabled) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.wifiCurrentThroughput, r6.wifiCurrentThroughput) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.wifiRtt, r6.wifiRtt) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.cellularThroughput, r6.cellularThroughput) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.cellularRtt, r6.cellularRtt) == true) goto L71;
        return false;
    L71:
        return true;
    }

    public int hashCode() {
        Boolean r0 = this.isVipNetworkFeatureEnabled;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.isWifiAccelEnabled;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.isSuperStableEnabled;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.isVipChannelEnabled;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.rateStrategyType;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.foregroundAppPkg;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.foregroundRateLimit;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.vipChannelRateLimit;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Integer r25 = this.backgroundRateLimit;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Integer r28 = this.foregroundThroughput;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        Integer r31 = this.vipChannelThroughput;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        Integer r34 = this.backgroundThroughput;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        Integer r37 = this.doubaoRtt;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        Integer r40 = this.doubaoAvgRttFiveSec;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        Integer r43 = this.doubaoMaxRttFiveSec;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        Integer r46 = this.doubaoMinRttFiveSec;
        if (r46 != null) goto L65;
        int r47 = 0;
    L66:
        int r48 = (r45 + r47) * 31;
        Boolean r49 = this.isVpnEnabled;
        if (r49 != null) goto L69;
        int r50 = 0;
    L70:
        int r51 = (r48 + r50) * 31;
        Integer r52 = this.wifiCurrentThroughput;
        if (r52 != null) goto L73;
        int r53 = 0;
    L74:
        int r54 = (r51 + r53) * 31;
        Integer r55 = this.wifiRtt;
        if (r55 != null) goto L77;
        int r56 = 0;
    L78:
        int r57 = (r54 + r56) * 31;
        Integer r58 = this.cellularThroughput;
        if (r58 != null) goto L81;
        int r59 = 0;
    L82:
        int r60 = (r57 + r59) * 31;
        Integer r61 = this.cellularRtt;
        if (r61 == null) goto L87;
        r1 = r61.hashCode();
    L87:
        return r60 + r1;
    L81:
        r59 = r58.hashCode();
        goto L82
    L77:
        r56 = r55.hashCode();
        goto L78
    L73:
        r53 = r52.hashCode();
        goto L74
    L69:
        r50 = r49.hashCode();
        goto L70
    L65:
        r47 = r46.hashCode();
        goto L66
    L61:
        r44 = r43.hashCode();
        goto L62
    L57:
        r41 = r40.hashCode();
        goto L58
    L53:
        r38 = r37.hashCode();
        goto L54
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
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
        return "VipStrategyReport(isVipNetworkFeatureEnabled=" + this.isVipNetworkFeatureEnabled + ", isWifiAccelEnabled=" + this.isWifiAccelEnabled + ", isSuperStableEnabled=" + this.isSuperStableEnabled + ", isVipChannelEnabled=" + this.isVipChannelEnabled + ", rateStrategyType=" + this.rateStrategyType + ", foregroundAppPkg=" + this.foregroundAppPkg + ", foregroundRateLimit=" + this.foregroundRateLimit + ", vipChannelRateLimit=" + this.vipChannelRateLimit + ", backgroundRateLimit=" + this.backgroundRateLimit + ", foregroundThroughput=" + this.foregroundThroughput + ", vipChannelThroughput=" + this.vipChannelThroughput + ", backgroundThroughput=" + this.backgroundThroughput + ", doubaoRtt=" + this.doubaoRtt + ", doubaoAvgRttFiveSec=" + this.doubaoAvgRttFiveSec + ", doubaoMaxRttFiveSec=" + this.doubaoMaxRttFiveSec + ", doubaoMinRttFiveSec=" + this.doubaoMinRttFiveSec + ", isVpnEnabled=" + this.isVpnEnabled + ", wifiCurrentThroughput=" + this.wifiCurrentThroughput + ", wifiRtt=" + this.wifiRtt + ", cellularThroughput=" + this.cellularThroughput + ", cellularRtt=" + this.cellularRtt + ')';
    }

    public final Integer getBackgroundRateLimit() {
        return this.backgroundRateLimit;
    }

    public final Integer getBackgroundThroughput() {
        return this.backgroundThroughput;
    }

    public final Integer getCellularRtt() {
        return this.cellularRtt;
    }

    public final Integer getCellularThroughput() {
        return this.cellularThroughput;
    }

    public final Integer getDoubaoAvgRttFiveSec() {
        return this.doubaoAvgRttFiveSec;
    }

    public final Integer getDoubaoMaxRttFiveSec() {
        return this.doubaoMaxRttFiveSec;
    }

    public final Integer getDoubaoMinRttFiveSec() {
        return this.doubaoMinRttFiveSec;
    }

    public final Integer getDoubaoRtt() {
        return this.doubaoRtt;
    }

    public final String getForegroundAppPkg() {
        return this.foregroundAppPkg;
    }

    public final Integer getForegroundRateLimit() {
        return this.foregroundRateLimit;
    }

    public final Integer getForegroundThroughput() {
        return this.foregroundThroughput;
    }

    public final Integer getRateStrategyType() {
        return this.rateStrategyType;
    }

    public final Integer getVipChannelRateLimit() {
        return this.vipChannelRateLimit;
    }

    public final Integer getVipChannelThroughput() {
        return this.vipChannelThroughput;
    }

    public final Integer getWifiCurrentThroughput() {
        return this.wifiCurrentThroughput;
    }

    public final Integer getWifiRtt() {
        return this.wifiRtt;
    }

    public final Boolean isSuperStableEnabled() {
        return this.isSuperStableEnabled;
    }

    public final Boolean isVipChannelEnabled() {
        return this.isVipChannelEnabled;
    }

    public final Boolean isVipNetworkFeatureEnabled() {
        return this.isVipNetworkFeatureEnabled;
    }

    public final Boolean isVpnEnabled() {
        return this.isVpnEnabled;
    }

    public final Boolean isWifiAccelEnabled() {
        return this.isWifiAccelEnabled;
    }

    public VipStrategyReport(Boolean r3, Boolean r4, Boolean r5, Boolean r6, Integer r7, String r8, Integer r9, Integer r10, Integer r11, Integer r12, Integer r13, Integer r14, Integer r15, Integer r16, Integer r17, Integer r18, Boolean r19, Integer r20, Integer r21, Integer r22, Integer r23) {
        this.isVipNetworkFeatureEnabled = r3;
        this.isWifiAccelEnabled = r4;
        this.isSuperStableEnabled = r5;
        this.isVipChannelEnabled = r6;
        this.rateStrategyType = r7;
        this.foregroundAppPkg = r8;
        this.foregroundRateLimit = r9;
        this.vipChannelRateLimit = r10;
        this.backgroundRateLimit = r11;
        this.foregroundThroughput = r12;
        this.vipChannelThroughput = r13;
        this.backgroundThroughput = r14;
        this.doubaoRtt = r15;
        this.doubaoAvgRttFiveSec = r16;
        this.doubaoMaxRttFiveSec = r17;
        this.doubaoMinRttFiveSec = r18;
        this.isVpnEnabled = r19;
        this.wifiCurrentThroughput = r20;
        this.wifiRtt = r21;
        this.cellularThroughput = r22;
        this.cellularRtt = r23;
    }

    public /* synthetic */ VipStrategyReport(Boolean r23, Boolean r24, Boolean r25, Boolean r26, Integer r27, String r28, Integer r29, Integer r30, Integer r31, Integer r32, Integer r33, Integer r34, Integer r35, Integer r36, Integer r37, Integer r38, Boolean r39, Integer r40, Integer r41, Integer r42, Integer r43, int r44, DefaultConstructorMarker r45) {
        if ((r44 & 1) == 0) goto L5;
        Boolean r1 = null;
    L7:
        if ((r44 & 2) == 0) goto L9;
        Boolean r3 = null;
    L11:
        if ((r44 & 4) == 0) goto L13;
        Boolean r4 = null;
    L15:
        if ((r44 & 8) == 0) goto L17;
        Boolean r5 = null;
    L19:
        if ((r44 & 16) == 0) goto L21;
        Integer r6 = null;
    L23:
        if ((r44 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r44 & 64) == 0) goto L29;
        Integer r8 = null;
    L31:
        if ((r44 & 128) == 0) goto L33;
        Integer r9 = null;
    L35:
        if ((r44 & 256) == 0) goto L37;
        Integer r10 = null;
    L39:
        if ((r44 & 512) == 0) goto L41;
        Integer r11 = null;
    L43:
        if ((r44 & 1024) == 0) goto L45;
        Integer r12 = null;
    L47:
        if ((r44 & 2048) == 0) goto L49;
        Integer r13 = null;
    L51:
        if ((r44 & 4096) == 0) goto L53;
        Integer r14 = null;
    L55:
        if ((r44 & 8192) == 0) goto L57;
        Integer r15 = null;
    L59:
        if ((r44 & 16384) == 0) goto L61;
        Integer r2 = null;
    L63:
        if ((r44 & 32768) == 0) goto L65;
        Integer r16 = null;
    L67:
        if ((r44 & UiType.FLAG_ALARM_CLOCK_CARD) == 0) goto L69;
        Boolean r17 = null;
    L71:
        if ((r44 & UiType.FLAG_PHONE_CARD) == 0) goto L73;
        Integer r18 = null;
    L75:
        if ((r44 & UiType.FLAG_TIMER_CARD) == 0) goto L77;
        Integer r19 = null;
    L79:
        if ((r44 & UiType.FLAG_WIFI_QRCODE_CARD) == 0) goto L81;
        Integer r20 = null;
    L83:
        if ((r44 & UiType.FLAG_APP_CHOOSER_CARD) == 0) goto L85;
        Integer r0 = null;
    L86:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r16, r17, r18, r19, r20, r0);
        return;
    L85:
        r0 = r43;
        goto L86
    L81:
        r20 = r42;
        goto L83
    L77:
        r19 = r41;
        goto L79
    L73:
        r18 = r40;
        goto L75
    L69:
        r17 = r39;
        goto L71
    L65:
        r16 = r38;
        goto L67
    L61:
        r2 = r37;
        goto L63
    L57:
        r15 = r36;
        goto L59
    L53:
        r14 = r35;
        goto L55
    L49:
        r13 = r34;
        goto L51
    L45:
        r12 = r33;
        goto L47
    L41:
        r11 = r32;
        goto L43
    L37:
        r10 = r31;
        goto L39
    L33:
        r9 = r30;
        goto L35
    L29:
        r8 = r29;
        goto L31
    L25:
        r7 = r28;
        goto L27
    L21:
        r6 = r27;
        goto L23
    L17:
        r5 = r26;
        goto L19
    L13:
        r4 = r25;
        goto L15
    L9:
        r3 = r24;
        goto L11
    L5:
        r1 = r23;
        goto L7
    }
}
