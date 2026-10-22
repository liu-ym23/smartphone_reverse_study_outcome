package com.bytedance.ai.model.objects;

import ai.j0;
import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b5\b\u0087\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010-\u001a\u00020\t2\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010/\u001a\u00020\u0007H\u0016J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00104\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0092\u0001\u0010;\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010<J\t\u0010=\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0013\"\u0004\b\u0016\u0010\u0017R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001c\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR \u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010 \u0012\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001fR \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0017R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0017R \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0013\"\u0004\b&\u0010\u0017R \u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0013\"\u0004\b(\u0010\u0017R \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0013\"\u0004\b*\u0010\u0017R \u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0013\"\u0004\b,\u0010\u0017¨\u0006>"}, d2 = {"Lcom/bytedance/ai/model/objects/WidgetInfo;", "", "appletId", "", "widgetId", "widgetData", "boxType", "", "border", "", "archiveText", "responseForModel", "mixtureCardId", "mcpName", "fullScreenRefresh", "appType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppletId", "()Ljava/lang/String;", "getWidgetId", "getWidgetData", "setWidgetData", "(Ljava/lang/String;)V", "getBoxType$annotations", "()V", "getBoxType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBorder$annotations", "getBorder", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getArchiveText", "setArchiveText", "getResponseForModel", "setResponseForModel", "getMixtureCardId", "setMixtureCardId", "getMcpName", "setMcpName", "getFullScreenRefresh", "setFullScreenRefresh", "getAppType", "setAppType", "equals", "other", "hashCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/ai/model/objects/WidgetInfo;", "toString", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    @SerializedName("fullScreenRefresh")
    private String fullScreenRefresh;

    @SerializedName("mcpName")
    private String mcpName;

    @SerializedName("mixture_card_id")
    private String mixtureCardId;

    @SerializedName("response_for_model")
    private String responseForModel;

    @SerializedName("widget_data")
    private String widgetData;

    @SerializedName("widget_id")
    private final String widgetId;

    public WidgetInfo() {
        String r5 = null;
        String r10 = null;
        String r11 = null;
        Integer r12 = null;
        Boolean r13 = null;
        String r14 = null;
        String r15 = null;
        String r16 = null;
        String r17 = null;
        String r18 = null;
        String r19 = null;
        this(r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, 2047, null);
    }

    public static /* synthetic */ WidgetInfo copy$default(WidgetInfo r12, String r13, String r14, String r15, Integer r16, Boolean r17, String r18, String r19, String r20, String r21, String r22, String r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        String r5 = r12.appletId;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r10 = r12.widgetId;
    L11:
        if ((r24 & 4) == 0) goto L13;
        String r11 = r12.widgetData;
    L15:
        if ((r24 & 8) == 0) goto L17;
        Integer r26 = r12.boxType;
    L19:
        if ((r24 & 16) == 0) goto L21;
        Boolean r27 = r12.border;
    L23:
        if ((r24 & 32) == 0) goto L25;
        String r28 = r12.archiveText;
    L27:
        if ((r24 & 64) == 0) goto L29;
        String r29 = r12.responseForModel;
    L31:
        if ((r24 & 128) == 0) goto L33;
        String r30 = r12.mixtureCardId;
    L35:
        if ((r24 & 256) == 0) goto L37;
        String r110 = r12.mcpName;
    L39:
        if ((r24 & 512) == 0) goto L41;
        String r111 = r12.fullScreenRefresh;
    L43:
        if ((r24 & 1024) == 0) goto L45;
        String r31 = r12.appType;
    L47:
        return r12.copy(r5, r10, r11, r26, r27, r28, r29, r30, r110, r111, r31);
    L45:
        r31 = r23;
        goto L47
    L41:
        r111 = r22;
        goto L43
    L37:
        r110 = r21;
        goto L39
    L33:
        r30 = r20;
        goto L35
    L29:
        r29 = r19;
        goto L31
    L25:
        r28 = r18;
        goto L27
    L21:
        r27 = r17;
        goto L23
    L17:
        r26 = r16;
        goto L19
    L13:
        r11 = r15;
        goto L15
    L9:
        r10 = r14;
        goto L11
    L5:
        r5 = r13;
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

    public final WidgetInfo copy(String r14, String r15, String r16, Integer r17, Boolean r18, String r19, String r20, String r21, String r22, String r23, String r24) {
        return new WidgetInfo(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof WidgetInfo) == false) goto L16;
        WidgetInfo r10 = (WidgetInfo) r5;
        if (Intrinsics.areEqual(this.appletId, r10.appletId) == false) goto L16;
        if (Intrinsics.areEqual(this.widgetId, r10.widgetId) == false) goto L16;
        if (Intrinsics.areEqual(this.widgetData, r10.widgetData) == false) goto L16;
        if (Intrinsics.areEqual(this.boxType, r10.boxType) == false) goto L16;
        if (Intrinsics.areEqual(this.border, r10.border) == false) goto L16;
        return true;
    L16:
        return false;
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

    public final String getWidgetData() {
        return this.widgetData;
    }

    public final String getWidgetId() {
        return this.widgetId;
    }

    public int hashCode() {
        String r5 = this.appletId;
        int r10 = 0;
        if (r5 == null) goto L5;
        int r11 = r5.hashCode();
    L6:
        int r12 = r11 * 31;
        String r13 = this.widgetId;
        if (r13 == null) goto L9;
        int r14 = r13.hashCode();
    L10:
        int r15 = (r12 + r14) * 31;
        String r16 = this.widgetData;
        if (r16 == null) goto L13;
        int r17 = r16.hashCode();
    L14:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.boxType;
        if (r19 == null) goto L17;
        int r20 = r19.intValue();
    L18:
        int r21 = (r18 + r20) * 31;
        Boolean r22 = this.border;
        if (r22 == null) goto L22;
        r10 = r22.hashCode();
    L22:
        return r21 + r10;
    L17:
        r20 = 0;
        goto L18
    L13:
        r17 = 0;
        goto L14
    L9:
        r14 = 0;
        goto L10
    L5:
        r11 = 0;
        goto L6
    }

    public final void setAppType(String r5) {
        this.appType = r5;
    }

    public final void setArchiveText(String r5) {
        this.archiveText = r5;
    }

    public final void setFullScreenRefresh(String r5) {
        this.fullScreenRefresh = r5;
    }

    public final void setMcpName(String r5) {
        this.mcpName = r5;
    }

    public final void setMixtureCardId(String r5) {
        this.mixtureCardId = r5;
    }

    public final void setResponseForModel(String r5) {
        this.responseForModel = r5;
    }

    public final void setWidgetData(String r5) {
        this.widgetData = r5;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("WidgetInfo(appletId=");
        r5.append(this.appletId);
        r5.append(", widgetId=");
        r5.append(this.widgetId);
        r5.append(", widgetData=");
        r5.append(this.widgetData);
        r5.append(", boxType=");
        r5.append(this.boxType);
        r5.append(", border=");
        r5.append(this.border);
        r5.append(", archiveText=");
        r5.append(this.archiveText);
        r5.append(", responseForModel=");
        r5.append(this.responseForModel);
        r5.append(", mixtureCardId=");
        r5.append(this.mixtureCardId);
        r5.append(", mcpName=");
        r5.append(this.mcpName);
        r5.append(", fullScreenRefresh=");
        r5.append(this.fullScreenRefresh);
        r5.append(", appType=");
        return j0.p(r5, this.appType, ')');
    }

    public WidgetInfo(String r5, String r10, String r11, Integer r12, Boolean r13, String r14, String r15, String r16, String r17, String r18, String r19) {
        this.appletId = r5;
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
    }

    public /* synthetic */ WidgetInfo(String r5, String r10, String r11, Integer r12, Boolean r13, String r14, String r15, String r16, String r17, String r18, String r19, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L6;
        r5 = null;
    L6:
        if ((r110 & 2) == 0) goto L9;
        r10 = null;
    L9:
        if ((r110 & 4) == 0) goto L12;
        r11 = null;
    L12:
        if ((r110 & 8) == 0) goto L15;
        r12 = null;
    L15:
        if ((r110 & 16) == 0) goto L18;
        r13 = null;
    L18:
        if ((r110 & 32) == 0) goto L21;
        r14 = null;
    L21:
        if ((r110 & 64) == 0) goto L24;
        r15 = null;
    L24:
        if ((r110 & 128) == 0) goto L27;
        r16 = null;
    L27:
        if ((r110 & 256) == 0) goto L30;
        r17 = null;
    L30:
        if ((r110 & 512) == 0) goto L33;
        r18 = null;
    L33:
        if ((r110 & 1024) == 0) goto L35;
        r19 = null;
    L35:
        this(r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }
}
