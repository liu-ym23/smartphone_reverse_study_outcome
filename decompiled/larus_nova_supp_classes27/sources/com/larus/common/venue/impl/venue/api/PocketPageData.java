package com.larus.common.venue.impl.venue.api;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b)\b\u0087\b\u0018\u00002\u00020\u0001B¯\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u0013\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010,\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u00101\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J¶\u0001\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u00020\u000b2\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\tHÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R \u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R \u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017¨\u0006:"}, d2 = {"Lcom/larus/common/venue/impl/venue/api/PocketPageData;", "", "pageId", "", "topPockets", "", "Lcom/larus/common/venue/impl/venue/api/Pocket;", "bottomPockets", "status", "", "showInputBox", "", "versionCode", "defaultSelectedPocketId", "configName", "iconUrl", "intentionWeight", "Lcom/larus/common/venue/impl/venue/api/IntentionWeightConfig;", "operator", "updateTime", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getPageId", "()Ljava/lang/String;", "getTopPockets", "()Ljava/util/List;", "getBottomPockets", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getShowInputBox", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getVersionCode", "getDefaultSelectedPocketId", "getConfigName", "getIconUrl", "getIntentionWeight", "getOperator", "getUpdateTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/common/venue/impl/venue/api/PocketPageData;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PocketPageData {

    @SerializedName("bottom_pockets")
    private final List<Pocket> bottomPockets;

    @SerializedName("config_name")
    private final String configName;

    @SerializedName("default_selected_pocket_id")
    private final String defaultSelectedPocketId;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("intention_weight")
    private final List<IntentionWeightConfig> intentionWeight;

    @SerializedName("operator")
    private final String operator;

    @SerializedName("page_id")
    private final String pageId;

    @SerializedName("show_input_box")
    private final Boolean showInputBox;

    @SerializedName("status")
    private final Integer status;

    @SerializedName("top_pockets")
    private final List<Pocket> topPockets;

    @SerializedName("update_time")
    private final String updateTime;

    @SerializedName("version_code")
    private final String versionCode;

    public PocketPageData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PocketPageData copy$default(PocketPageData r13, String r14, List r15, List r16, Integer r17, Boolean r18, String r110, String r20, String r21, String r22, List r23, String r24, String r25, int r26, Object r27) {
        if ((r26 & 1) == 0) goto L5;
        String r2 = r13.pageId;
    L7:
        if ((r26 & 2) == 0) goto L9;
        List r3 = r13.topPockets;
    L11:
        if ((r26 & 4) == 0) goto L13;
        List r4 = r13.bottomPockets;
    L15:
        if ((r26 & 8) == 0) goto L17;
        Integer r5 = r13.status;
    L19:
        if ((r26 & 16) == 0) goto L21;
        Boolean r6 = r13.showInputBox;
    L23:
        if ((r26 & 32) == 0) goto L25;
        String r7 = r13.versionCode;
    L27:
        if ((r26 & 64) == 0) goto L29;
        String r8 = r13.defaultSelectedPocketId;
    L31:
        if ((r26 & 128) == 0) goto L33;
        String r9 = r13.configName;
    L35:
        if ((r26 & 256) == 0) goto L37;
        String r10 = r13.iconUrl;
    L39:
        if ((r26 & 512) == 0) goto L41;
        List r11 = r13.intentionWeight;
    L43:
        if ((r26 & 1024) == 0) goto L45;
        String r12 = r13.operator;
    L47:
        if ((r26 & 2048) == 0) goto L49;
        String r1 = r13.updateTime;
    L51:
        return r13.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r1);
    L49:
        r1 = r25;
        goto L51
    L45:
        r12 = r24;
        goto L47
    L41:
        r11 = r23;
        goto L43
    L37:
        r10 = r22;
        goto L39
    L33:
        r9 = r21;
        goto L35
    L29:
        r8 = r20;
        goto L31
    L25:
        r7 = r110;
        goto L27
    L21:
        r6 = r18;
        goto L23
    L17:
        r5 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r2 = r14;
        goto L7
    }

    public final String component1() {
        return this.pageId;
    }

    public final List<IntentionWeightConfig> component10() {
        return this.intentionWeight;
    }

    public final String component11() {
        return this.operator;
    }

    public final String component12() {
        return this.updateTime;
    }

    public final List<Pocket> component2() {
        return this.topPockets;
    }

    public final List<Pocket> component3() {
        return this.bottomPockets;
    }

    public final Integer component4() {
        return this.status;
    }

    public final Boolean component5() {
        return this.showInputBox;
    }

    public final String component6() {
        return this.versionCode;
    }

    public final String component7() {
        return this.defaultSelectedPocketId;
    }

    public final String component8() {
        return this.configName;
    }

    public final String component9() {
        return this.iconUrl;
    }

    public final PocketPageData copy(String r15, List<Pocket> r16, List<Pocket> r17, Integer r18, Boolean r110, String r20, String r21, String r22, String r23, List<IntentionWeightConfig> r24, String r25, String r26) {
        return new PocketPageData(r15, r16, r17, r18, r110, r20, r21, r22, r23, r24, r25, r26);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PocketPageData) == true) goto L8;
        return false;
    L8:
        PocketPageData r6 = (PocketPageData) r5;
        if (Intrinsics.areEqual(this.pageId, r6.pageId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.topPockets, r6.topPockets) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bottomPockets, r6.bottomPockets) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.status, r6.status) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.showInputBox, r6.showInputBox) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.versionCode, r6.versionCode) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.defaultSelectedPocketId, r6.defaultSelectedPocketId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.configName, r6.configName) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.iconUrl, r6.iconUrl) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.intentionWeight, r6.intentionWeight) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.operator, r6.operator) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.updateTime, r6.updateTime) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        String r0 = this.pageId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<Pocket> r4 = this.topPockets;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<Pocket> r7 = this.bottomPockets;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.status;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.showInputBox;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.versionCode;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r20 = this.defaultSelectedPocketId;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r18 + r21) * 31;
        String r23 = this.configName;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        String r26 = this.iconUrl;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        List<IntentionWeightConfig> r30 = this.intentionWeight;
        if (r30 != null) goto L41;
        int r31 = 0;
    L42:
        int r32 = (r28 + r31) * 31;
        String r33 = this.operator;
        if (r33 != null) goto L45;
        int r34 = 0;
    L46:
        int r35 = (r32 + r34) * 31;
        String r36 = this.updateTime;
        if (r36 == null) goto L51;
        r1 = r36.hashCode();
    L51:
        return r35 + r1;
    L45:
        r34 = r33.hashCode();
        goto L46
    L41:
        r31 = r30.hashCode();
        goto L42
    L37:
        r27 = r26.hashCode();
        goto L38
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
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
        return "PocketPageData(pageId=" + this.pageId + ", topPockets=" + this.topPockets + ", bottomPockets=" + this.bottomPockets + ", status=" + this.status + ", showInputBox=" + this.showInputBox + ", versionCode=" + this.versionCode + ", defaultSelectedPocketId=" + this.defaultSelectedPocketId + ", configName=" + this.configName + ", iconUrl=" + this.iconUrl + ", intentionWeight=" + this.intentionWeight + ", operator=" + this.operator + ", updateTime=" + this.updateTime + ')';
    }

    public final List<Pocket> getBottomPockets() {
        return this.bottomPockets;
    }

    public final String getConfigName() {
        return this.configName;
    }

    public final String getDefaultSelectedPocketId() {
        return this.defaultSelectedPocketId;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final List<IntentionWeightConfig> getIntentionWeight() {
        return this.intentionWeight;
    }

    public final String getOperator() {
        return this.operator;
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final Boolean getShowInputBox() {
        return this.showInputBox;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final List<Pocket> getTopPockets() {
        return this.topPockets;
    }

    public final String getUpdateTime() {
        return this.updateTime;
    }

    public final String getVersionCode() {
        return this.versionCode;
    }

    public PocketPageData(String r1, List<Pocket> r2, List<Pocket> r3, Integer r4, Boolean r5, String r6, String r7, String r8, String r9, List<IntentionWeightConfig> r10, String r11, String r12) {
        this.pageId = r1;
        this.topPockets = r2;
        this.bottomPockets = r3;
        this.status = r4;
        this.showInputBox = r5;
        this.versionCode = r6;
        this.defaultSelectedPocketId = r7;
        this.configName = r8;
        this.iconUrl = r9;
        this.intentionWeight = r10;
        this.operator = r11;
        this.updateTime = r12;
    }

    public /* synthetic */ PocketPageData(String r14, List r15, List r16, Integer r17, Boolean r18, String r110, String r20, String r21, String r22, List r23, String r24, String r25, int r26, DefaultConstructorMarker r27) {
        String r2 = null;
        if ((r26 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r26 & 2) == 0) goto L9;
        List r3 = null;
    L11:
        if ((r26 & 4) == 0) goto L13;
        List r4 = null;
    L15:
        if ((r26 & 8) == 0) goto L17;
        Integer r5 = null;
    L19:
        if ((r26 & 16) == 0) goto L21;
        Boolean r6 = null;
    L23:
        if ((r26 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r26 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r26 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r26 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r26 & 512) == 0) goto L41;
        List r11 = null;
    L43:
        if ((r26 & 1024) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r26 & 2048) != 0) goto L50;
        r2 = r25;
    L50:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r2);
        return;
    L45:
        r12 = r24;
        goto L47
    L41:
        r11 = r23;
        goto L43
    L37:
        r10 = r22;
        goto L39
    L33:
        r9 = r21;
        goto L35
    L29:
        r8 = r20;
        goto L31
    L25:
        r7 = r110;
        goto L27
    L21:
        r6 = r18;
        goto L23
    L17:
        r5 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r1 = r14;
        goto L7
    }
}
