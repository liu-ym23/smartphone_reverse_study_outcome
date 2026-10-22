package com.bytedance.ai.model.objects;

import com.google.gson.annotations.SerializedName;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\bB\b\u0087\b\u0018\u00002\u00020\u0001B¯\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u00107\u001a\u00020\t2\b\u00108\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00109\u001a\u00020\u0007H\u0016J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010>\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J¶\u0001\u0010H\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010IJ\t\u0010J\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0016\"\u0004\b\u0019\u0010\u001aR \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001f\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR \u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010#\u0012\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\"R \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0016\"\u0004\b%\u0010\u001aR \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010\u001aR \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0016\"\u0004\b)\u0010\u001aR \u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0016\"\u0004\b+\u0010\u001aR \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u001aR \u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0016\"\u0004\b/\u0010\u001aR \u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0016\"\u0004\b1\u0010\u001aR\"\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b2\u0010\"\"\u0004\b3\u00104R \u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0016\"\u0004\b6\u0010\u001a¨\u0006K"}, d2 = {"Lcom/bytedance/ai/model/objects/WidgetInfo;", "", "appletId", "", "widgetId", "widgetData", "boxType", "", "border", "", "archiveText", "responseForModel", "mixtureCardId", "mcpName", "fullScreenRefresh", "appType", "entityId", "soloCard", "versionTag", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getAppletId", "()Ljava/lang/String;", "getWidgetId", "getWidgetData", "setWidgetData", "(Ljava/lang/String;)V", "getBoxType$annotations", "()V", "getBoxType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBorder$annotations", "getBorder", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getArchiveText", "setArchiveText", "getResponseForModel", "setResponseForModel", "getMixtureCardId", "setMixtureCardId", "getMcpName", "setMcpName", "getFullScreenRefresh", "setFullScreenRefresh", "getAppType", "setAppType", "getEntityId", "setEntityId", "getSoloCard", "setSoloCard", "(Ljava/lang/Boolean;)V", "getVersionTag", "setVersionTag", "equals", "other", "hashCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/bytedance/ai/model/objects/WidgetInfo;", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WidgetInfo {

    @SerializedName("app_type")
    private String appType;

    @SerializedName("applet_id")
    private final String appletId;

    @SerializedName("archive_text")
    private String archiveText;

    @SerializedName("border")
    private final Boolean border;

    @SerializedName("box_type")
    private final Integer boxType;

    @SerializedName("entity_id")
    private String entityId;

    @SerializedName("fullScreenRefresh")
    private String fullScreenRefresh;

    @SerializedName("mcpName")
    private String mcpName;

    @SerializedName("mixture_card_id")
    private String mixtureCardId;

    @SerializedName("response_for_model")
    private String responseForModel;

    @SerializedName("solo_card")
    private Boolean soloCard;

    @SerializedName("version_tag")
    private String versionTag;

    @SerializedName("widget_data")
    private String widgetData;

    @SerializedName("widget_id")
    private final String widgetId;

    public WidgetInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    }

    public static /* synthetic */ WidgetInfo copy$default(WidgetInfo r15, String r16, String r17, String r18, Integer r19, Boolean r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, Boolean r28, String r29, int r30, Object r31) {
        if ((r30 & 1) == 0) goto L5;
        String r10 = r15.appletId;
    L7:
        if ((r30 & 2) == 0) goto L9;
        String r11 = r15.widgetId;
    L11:
        if ((r30 & 4) == 0) goto L13;
        String r12 = r15.widgetData;
    L15:
        if ((r30 & 8) == 0) goto L17;
        Integer r13 = r15.boxType;
    L19:
        if ((r30 & 16) == 0) goto L21;
        Boolean r14 = r15.border;
    L23:
        if ((r30 & 32) == 0) goto L25;
        String r32 = r15.archiveText;
    L27:
        if ((r30 & 64) == 0) goto L29;
        String r33 = r15.responseForModel;
    L31:
        if ((r30 & 128) == 0) goto L33;
        String r34 = r15.mixtureCardId;
    L35:
        if ((r30 & 256) == 0) goto L37;
        String r110 = r15.mcpName;
    L39:
        if ((r30 & 512) == 0) goto L41;
        String r111 = r15.fullScreenRefresh;
    L43:
        if ((r30 & 1024) == 0) goto L45;
        String r112 = r15.appType;
    L47:
        if ((r30 & 2048) == 0) goto L49;
        String r113 = r15.entityId;
    L51:
        if ((r30 & 4096) == 0) goto L53;
        Boolean r114 = r15.soloCard;
    L55:
        if ((r30 & 8192) == 0) goto L57;
        String r1 = r15.versionTag;
    L59:
        return r15.copy(r10, r11, r12, r13, r14, r32, r33, r34, r110, r111, r112, r113, r114, r1);
    L57:
        r1 = r29;
        goto L59
    L53:
        r114 = r28;
        goto L55
    L49:
        r113 = r27;
        goto L51
    L45:
        r112 = r26;
        goto L47
    L41:
        r111 = r25;
        goto L43
    L37:
        r110 = r24;
        goto L39
    L33:
        r34 = r23;
        goto L35
    L29:
        r33 = r22;
        goto L31
    L25:
        r32 = r21;
        goto L27
    L21:
        r14 = r20;
        goto L23
    L17:
        r13 = r19;
        goto L19
    L13:
        r12 = r18;
        goto L15
    L9:
        r11 = r17;
        goto L11
    L5:
        r10 = r16;
        goto L7
    }

    @Deprecated(message = "will be removed, use Widget.border instead")
    public static /* synthetic */ void getBorder$annotations() {
    }

    @Deprecated(message = "will be removed, use Widget.boxType instead")
    public static /* synthetic */ void getBoxType$annotations() {
    }

    public final String component1() {
        return this.appletId;
    }

    public final String component10() {
        return this.fullScreenRefresh;
    }

    public final String component11() {
        return this.appType;
    }

    public final String component12() {
        return this.entityId;
    }

    public final Boolean component13() {
        return this.soloCard;
    }

    public final String component14() {
        return this.versionTag;
    }

    public final String component2() {
        return this.widgetId;
    }

    public final String component3() {
        return this.widgetData;
    }

    public final Integer component4() {
        return this.boxType;
    }

    public final Boolean component5() {
        return this.border;
    }

    public final String component6() {
        return this.archiveText;
    }

    public final String component7() {
        return this.responseForModel;
    }

    public final String component8() {
        return this.mixtureCardId;
    }

    public final String component9() {
        return this.mcpName;
    }

    public final WidgetInfo copy(String r17, String r18, String r19, Integer r20, Boolean r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, Boolean r29, String r30) {
        return new WidgetInfo(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30);
    }

    public String toString() {
        return "WidgetInfo(appletId=" + this.appletId + ", widgetId=" + this.widgetId + ", widgetData=" + this.widgetData + ", boxType=" + this.boxType + ", border=" + this.border + ", archiveText=" + this.archiveText + ", responseForModel=" + this.responseForModel + ", mixtureCardId=" + this.mixtureCardId + ", mcpName=" + this.mcpName + ", fullScreenRefresh=" + this.fullScreenRefresh + ", appType=" + this.appType + ", entityId=" + this.entityId + ", soloCard=" + this.soloCard + ", versionTag=" + this.versionTag + ')';
    }

    public int hashCode() {
        String r0 = this.appletId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        String r12 = this.widgetId;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.widgetData;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        Integer r18 = this.boxType;
        if (r18 == null) goto L17;
        int r19 = r18.intValue();
    L18:
        int r20 = (r17 + r19) * 31;
        Boolean r21 = this.border;
        if (r21 == null) goto L22;
        r1 = r21.hashCode();
    L22:
        return r20 + r1;
    L17:
        r19 = 0;
        goto L18
    L13:
        r16 = 0;
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public final String getAppType() {
        return this.appType;
    }

    public final String getAppletId() {
        return this.appletId;
    }

    public final String getArchiveText() {
        return this.archiveText;
    }

    public final Boolean getBorder() {
        return this.border;
    }

    public final Integer getBoxType() {
        return this.boxType;
    }

    public final String getEntityId() {
        return this.entityId;
    }

    public final String getFullScreenRefresh() {
        return this.fullScreenRefresh;
    }

    public final String getMcpName() {
        return this.mcpName;
    }

    public final String getMixtureCardId() {
        return this.mixtureCardId;
    }

    public final String getResponseForModel() {
        return this.responseForModel;
    }

    public final Boolean getSoloCard() {
        return this.soloCard;
    }

    public final String getVersionTag() {
        return this.versionTag;
    }

    public final String getWidgetData() {
        return this.widgetData;
    }

    public final String getWidgetId() {
        return this.widgetId;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof WidgetInfo) == false) goto L16;
        WidgetInfo r11 = (WidgetInfo) r10;
        if (Intrinsics.areEqual(this.appletId, r11.appletId) == true) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(this.widgetId, r11.widgetId) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.widgetData, r11.widgetData) == true) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(this.boxType, r11.boxType) == true) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(this.border, r11.border) == false) goto L21;
        return true;
    L21:
        return false;
    L16:
        return false;
    }

    public final void setAppType(String r1) {
        this.appType = r1;
    }

    public final void setArchiveText(String r1) {
        this.archiveText = r1;
    }

    public final void setEntityId(String r1) {
        this.entityId = r1;
    }

    public final void setFullScreenRefresh(String r1) {
        this.fullScreenRefresh = r1;
    }

    public final void setMcpName(String r1) {
        this.mcpName = r1;
    }

    public final void setMixtureCardId(String r1) {
        this.mixtureCardId = r1;
    }

    public final void setResponseForModel(String r1) {
        this.responseForModel = r1;
    }

    public final void setSoloCard(Boolean r1) {
        this.soloCard = r1;
    }

    public final void setVersionTag(String r1) {
        this.versionTag = r1;
    }

    public final void setWidgetData(String r1) {
        this.widgetData = r1;
    }

    public WidgetInfo(String r1, String r10, String r11, Integer r12, Boolean r13, String r14, String r15, String r16, String r17, String r18, String r19, String r110, Boolean r111, String r112) {
        this.appletId = r1;
        this.widgetId = r10;
        this.widgetData = r11;
        this.boxType = r12;
        this.border = r13;
        this.archiveText = r14;
        this.responseForModel = r15;
        this.mixtureCardId = r16;
        this.mcpName = r17;
        this.fullScreenRefresh = r18;
        this.appType = r19;
        this.entityId = r110;
        this.soloCard = r111;
        this.versionTag = r112;
    }

    public /* synthetic */ WidgetInfo(String r16, String r17, String r18, Integer r19, Boolean r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, Boolean r28, String r29, int r30, DefaultConstructorMarker r31) {
        String r10 = null;
        if ((r30 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r30 & 2) == 0) goto L9;
        String r11 = null;
    L11:
        if ((r30 & 4) == 0) goto L13;
        String r12 = null;
    L15:
        if ((r30 & 8) == 0) goto L17;
        Integer r13 = null;
    L19:
        if ((r30 & 16) == 0) goto L21;
        Boolean r14 = null;
    L23:
        if ((r30 & 32) == 0) goto L25;
        String r15 = null;
    L27:
        if ((r30 & 64) == 0) goto L29;
        String r32 = null;
    L31:
        if ((r30 & 128) == 0) goto L33;
        String r33 = null;
    L35:
        if ((r30 & 256) == 0) goto L37;
        String r110 = null;
    L39:
        if ((r30 & 512) == 0) goto L41;
        String r111 = null;
    L43:
        if ((r30 & 1024) == 0) goto L45;
        String r112 = null;
    L47:
        if ((r30 & 2048) == 0) goto L49;
        String r113 = null;
    L51:
        if ((r30 & 4096) == 0) goto L53;
        Boolean r114 = Boolean.FALSE;
    L55:
        if ((r30 & 8192) != 0) goto L58;
        r10 = r29;
    L58:
        this(r1, r11, r12, r13, r14, r15, r32, r33, r110, r111, r112, r113, r114, r10);
        return;
    L53:
        r114 = r28;
        goto L55
    L49:
        r113 = r27;
        goto L51
    L45:
        r112 = r26;
        goto L47
    L41:
        r111 = r25;
        goto L43
    L37:
        r110 = r24;
        goto L39
    L33:
        r33 = r23;
        goto L35
    L29:
        r32 = r22;
        goto L31
    L25:
        r15 = r21;
        goto L27
    L21:
        r14 = r20;
        goto L23
    L17:
        r13 = r19;
        goto L19
    L13:
        r12 = r18;
        goto L15
    L9:
        r11 = r17;
        goto L11
    L5:
        r1 = r16;
        goto L7
    }
}
