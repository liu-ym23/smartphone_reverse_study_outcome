package com.larus.uaigc.lynx;

import com.larus.uaigc.lynx.pocket.RoundInfo;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B¯\u0001\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\t\u0010+\u001a\u00020\bHÆ\u0003J\t\u0010,\u001a\u00020\bHÆ\u0003J\u0017\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003HÆ\u0003J\u0017\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003HÆ\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003J\t\u00100\u001a\u00020\u0004HÆ\u0003J\t\u00101\u001a\u00020\u0004HÆ\u0003J\t\u00102\u001a\u00020\u0004HÆ\u0003J\t\u00103\u001a\u00020\u0004HÆ\u0003J\t\u00104\u001a\u00020\u0004HÆ\u0003J\t\u00105\u001a\u00020\u0006HÆ\u0003J»\u0001\u00106\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u0006HÆ\u0001J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020\u0006HÖ\u0001J\t\u0010;\u001a\u00020\u0004HÖ\u0001R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u001f\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u001f\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0010\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0011\u0010\u0012\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#R\u0011\u0010\u0014\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001a¨\u0006<"}, d2 = {"Lcom/larus/uaigc/lynx/LynxPageData;", "", "pocketPageData", "", "", "inputTopToBottomHeight", "", "clickActionBarTimeMs", "", "schemaHandleTimeMs", "traceInfo", "scatterMap", "roundList", "", "Lcom/larus/uaigc/lynx/pocket/RoundInfo;", "cacheInvalid", "inputBoxShowSetting", "showLoadingButton", "hasUsedNewYearAvatar", "sourceSchema", "userHasLottery", "<init>", "(Ljava/util/Map;IJJLjava/util/Map;Ljava/util/Map;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getPocketPageData", "()Ljava/util/Map;", "getInputTopToBottomHeight", "()I", "getClickActionBarTimeMs", "()J", "getSchemaHandleTimeMs", "getTraceInfo", "getScatterMap", "getRoundList", "()Ljava/util/List;", "getCacheInvalid", "()Ljava/lang/String;", "getInputBoxShowSetting", "getShowLoadingButton", "getHasUsedNewYearAvatar", "getSourceSchema", "getUserHasLottery", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class LynxPageData {
    private final String cacheInvalid;
    private final long clickActionBarTimeMs;
    private final String hasUsedNewYearAvatar;
    private final String inputBoxShowSetting;
    private final int inputTopToBottomHeight;
    private final Map<String, Object> pocketPageData;
    private final List<RoundInfo> roundList;
    private final Map<String, Object> scatterMap;
    private final long schemaHandleTimeMs;
    private final String showLoadingButton;
    private final String sourceSchema;
    private final Map<String, Object> traceInfo;
    private final int userHasLottery;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LynxPageData copy$default(LynxPageData r16, Map r17, int r18, long r19, long r21, Map r23, Map r24, List r25, String r26, String r27, String r28, String r29, String r30, int r31, int r32, Object r33) {
        if ((r32 & 1) == 0) goto L5;
        Map r2 = r16.pocketPageData;
    L7:
        if ((r32 & 2) == 0) goto L9;
        int r3 = r16.inputTopToBottomHeight;
    L11:
        if ((r32 & 4) == 0) goto L13;
        long r4 = r16.clickActionBarTimeMs;
    L15:
        if ((r32 & 8) == 0) goto L17;
        long r6 = r16.schemaHandleTimeMs;
    L19:
        if ((r32 & 16) == 0) goto L21;
        Map r8 = r16.traceInfo;
    L23:
        if ((r32 & 32) == 0) goto L25;
        Map r9 = r16.scatterMap;
    L27:
        if ((r32 & 64) == 0) goto L29;
        List r10 = r16.roundList;
    L31:
        if ((r32 & 128) == 0) goto L33;
        String r11 = r16.cacheInvalid;
    L35:
        if ((r32 & 256) == 0) goto L37;
        String r12 = r16.inputBoxShowSetting;
    L39:
        if ((r32 & 512) == 0) goto L41;
        String r13 = r16.showLoadingButton;
    L43:
        if ((r32 & 1024) == 0) goto L45;
        String r14 = r16.hasUsedNewYearAvatar;
    L47:
        if ((r32 & 2048) == 0) goto L49;
        String r15 = r16.sourceSchema;
    L51:
        if ((r32 & 4096) == 0) goto L53;
        int r1 = r16.userHasLottery;
    L55:
        return r16.copy(r2, r3, r4, r6, r8, r9, r10, r11, r12, r13, r14, r15, r1);
    L53:
        r1 = r31;
        goto L55
    L49:
        r15 = r30;
        goto L51
    L45:
        r14 = r29;
        goto L47
    L41:
        r13 = r28;
        goto L43
    L37:
        r12 = r27;
        goto L39
    L33:
        r11 = r26;
        goto L35
    L29:
        r10 = r25;
        goto L31
    L25:
        r9 = r24;
        goto L27
    L21:
        r8 = r23;
        goto L23
    L17:
        r6 = r21;
        goto L19
    L13:
        r4 = r19;
        goto L15
    L9:
        r3 = r18;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }

    public final Map<String, Object> component1() {
        return this.pocketPageData;
    }

    public final String component10() {
        return this.showLoadingButton;
    }

    public final String component11() {
        return this.hasUsedNewYearAvatar;
    }

    public final String component12() {
        return this.sourceSchema;
    }

    public final int component13() {
        return this.userHasLottery;
    }

    public final int component2() {
        return this.inputTopToBottomHeight;
    }

    public final long component3() {
        return this.clickActionBarTimeMs;
    }

    public final long component4() {
        return this.schemaHandleTimeMs;
    }

    public final Map<String, Object> component5() {
        return this.traceInfo;
    }

    public final Map<String, Object> component6() {
        return this.scatterMap;
    }

    public final List<RoundInfo> component7() {
        return this.roundList;
    }

    public final String component8() {
        return this.cacheInvalid;
    }

    public final String component9() {
        return this.inputBoxShowSetting;
    }

    public final LynxPageData copy(Map<String, ? extends Object> r18, int r19, long r20, long r22, Map<String, ? extends Object> r24, Map<String, ? extends Object> r25, List<RoundInfo> r26, String r27, String r28, String r29, String r30, String r31, int r32) {
        Intrinsics.checkNotNullParameter(r18, "pocketPageData");
        Intrinsics.checkNotNullParameter(r24, "traceInfo");
        Intrinsics.checkNotNullParameter(r25, "scatterMap");
        Intrinsics.checkNotNullParameter(r26, "roundList");
        Intrinsics.checkNotNullParameter(r27, "cacheInvalid");
        Intrinsics.checkNotNullParameter(r28, "inputBoxShowSetting");
        Intrinsics.checkNotNullParameter(r29, "showLoadingButton");
        Intrinsics.checkNotNullParameter(r30, "hasUsedNewYearAvatar");
        Intrinsics.checkNotNullParameter(r31, "sourceSchema");
        return new LynxPageData(r18, r19, r20, r22, r24, r25, r26, r27, r28, r29, r30, r31, r32);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof LynxPageData) == true) goto L8;
        return false;
    L8:
        LynxPageData r9 = (LynxPageData) r8;
        if (Intrinsics.areEqual(this.pocketPageData, r9.pocketPageData) == true) goto L12;
        return false;
    L12:
        if (this.inputTopToBottomHeight == r9.inputTopToBottomHeight) goto L15;
        return false;
    L15:
        if (this.clickActionBarTimeMs == r9.clickActionBarTimeMs) goto L18;
        return false;
    L18:
        if (this.schemaHandleTimeMs == r9.schemaHandleTimeMs) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.traceInfo, r9.traceInfo) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.scatterMap, r9.scatterMap) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.roundList, r9.roundList) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.cacheInvalid, r9.cacheInvalid) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.inputBoxShowSetting, r9.inputBoxShowSetting) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.showLoadingButton, r9.showLoadingButton) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.hasUsedNewYearAvatar, r9.hasUsedNewYearAvatar) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.sourceSchema, r9.sourceSchema) == true) goto L45;
        return false;
    L45:
        if (this.userHasLottery == r9.userHasLottery) goto L47;
        return false;
    L47:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.pocketPageData.hashCode() * 31) + this.inputTopToBottomHeight) * 31;
        long r1 = this.clickActionBarTimeMs;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.schemaHandleTimeMs;
        return ((((((((((((((((((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.traceInfo.hashCode()) * 31) + this.scatterMap.hashCode()) * 31) + this.roundList.hashCode()) * 31) + this.cacheInvalid.hashCode()) * 31) + this.inputBoxShowSetting.hashCode()) * 31) + this.showLoadingButton.hashCode()) * 31) + this.hasUsedNewYearAvatar.hashCode()) * 31) + this.sourceSchema.hashCode()) * 31) + this.userHasLottery;
    }

    public String toString() {
        return "LynxPageData(pocketPageData=" + this.pocketPageData + ", inputTopToBottomHeight=" + this.inputTopToBottomHeight + ", clickActionBarTimeMs=" + this.clickActionBarTimeMs + ", schemaHandleTimeMs=" + this.schemaHandleTimeMs + ", traceInfo=" + this.traceInfo + ", scatterMap=" + this.scatterMap + ", roundList=" + this.roundList + ", cacheInvalid=" + this.cacheInvalid + ", inputBoxShowSetting=" + this.inputBoxShowSetting + ", showLoadingButton=" + this.showLoadingButton + ", hasUsedNewYearAvatar=" + this.hasUsedNewYearAvatar + ", sourceSchema=" + this.sourceSchema + ", userHasLottery=" + this.userHasLottery + ')';
    }

    public final String getCacheInvalid() {
        return this.cacheInvalid;
    }

    public final long getClickActionBarTimeMs() {
        return this.clickActionBarTimeMs;
    }

    public final String getHasUsedNewYearAvatar() {
        return this.hasUsedNewYearAvatar;
    }

    public final String getInputBoxShowSetting() {
        return this.inputBoxShowSetting;
    }

    public final int getInputTopToBottomHeight() {
        return this.inputTopToBottomHeight;
    }

    public final Map<String, Object> getPocketPageData() {
        return this.pocketPageData;
    }

    public final List<RoundInfo> getRoundList() {
        return this.roundList;
    }

    public final Map<String, Object> getScatterMap() {
        return this.scatterMap;
    }

    public final long getSchemaHandleTimeMs() {
        return this.schemaHandleTimeMs;
    }

    public final String getShowLoadingButton() {
        return this.showLoadingButton;
    }

    public final String getSourceSchema() {
        return this.sourceSchema;
    }

    public final Map<String, Object> getTraceInfo() {
        return this.traceInfo;
    }

    public final int getUserHasLottery() {
        return this.userHasLottery;
    }

    public LynxPageData(Map<String, ? extends Object> r13, int r14, long r15, long r17, Map<String, ? extends Object> r19, Map<String, ? extends Object> r20, List<RoundInfo> r21, String r22, String r23, String r24, String r25, String r26, int r27) {
        Intrinsics.checkNotNullParameter(r13, "pocketPageData");
        Intrinsics.checkNotNullParameter(r19, "traceInfo");
        Intrinsics.checkNotNullParameter(r20, "scatterMap");
        Intrinsics.checkNotNullParameter(r21, "roundList");
        Intrinsics.checkNotNullParameter(r22, "cacheInvalid");
        Intrinsics.checkNotNullParameter(r23, "inputBoxShowSetting");
        Intrinsics.checkNotNullParameter(r24, "showLoadingButton");
        Intrinsics.checkNotNullParameter(r25, "hasUsedNewYearAvatar");
        Intrinsics.checkNotNullParameter(r26, "sourceSchema");
        this.pocketPageData = r13;
        this.inputTopToBottomHeight = r14;
        this.clickActionBarTimeMs = r15;
        this.schemaHandleTimeMs = r17;
        this.traceInfo = r19;
        this.scatterMap = r20;
        this.roundList = r21;
        this.cacheInvalid = r22;
        this.inputBoxShowSetting = r23;
        this.showLoadingButton = r24;
        this.hasUsedNewYearAvatar = r25;
        this.sourceSchema = r26;
        this.userHasLottery = r27;
    }

    public /* synthetic */ LynxPageData(Map r19, int r20, long r21, long r23, Map r25, Map r26, List r27, String r28, String r29, String r30, String r31, String r32, int r33, int r34, DefaultConstructorMarker r35) {
        if ((r34 & 1) == 0) goto L5;
        Map r3 = MapsKt.emptyMap();
    L7:
        if ((r34 & 2) == 0) goto L9;
        int r4 = 0;
    L11:
        if ((r34 & 4) == 0) goto L13;
        long r7 = 0;
    L15:
        if ((r34 & 8) == 0) goto L17;
        long r9 = 0;
    L19:
        if ((r34 & 16) == 0) goto L21;
        Map r1 = MapsKt.emptyMap();
    L23:
        if ((r34 & 32) == 0) goto L25;
        Map r11 = MapsKt.emptyMap();
    L27:
        if ((r34 & 64) == 0) goto L29;
        List r12 = CollectionsKt.emptyList();
    L31:
        if ((r34 & 4096) == 0) goto L33;
        int r17 = 0;
    L34:
        this(r3, r4, r7, r9, r1, r11, r12, r28, r29, r30, r31, r32, r17);
        return;
    L33:
        r17 = r33;
        goto L34
    L29:
        r12 = r27;
        goto L31
    L25:
        r11 = r26;
        goto L27
    L21:
        r1 = r25;
        goto L23
    L17:
        r9 = r23;
        goto L19
    L13:
        r7 = r21;
        goto L15
    L9:
        r4 = r20;
        goto L11
    L5:
        r3 = r19;
        goto L7
    }
}
