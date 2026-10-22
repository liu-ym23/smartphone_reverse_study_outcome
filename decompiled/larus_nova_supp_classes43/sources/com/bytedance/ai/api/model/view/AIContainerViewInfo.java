package com.bytedance.ai.api.model.view;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ai/api/model/view/AIContainerViewInfo;", "", "appletId", "", "widgetId", "widgetData", "boxType", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getAppletId", "()Ljava/lang/String;", "getWidgetId", "getWidgetData", "getBoxType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/ai/api/model/view/AIContainerViewInfo;", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIContainerViewInfo {

    @SerializedName("applet_id")
    private final String appletId;

    @SerializedName("box_type")
    private final Integer boxType;

    @SerializedName("view_data")
    private final String widgetData;

    @SerializedName("view_id")
    private final String widgetId;

    public AIContainerViewInfo() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ AIContainerViewInfo copy$default(AIContainerViewInfo r0, String r1, String r10, String r11, Integer r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r1 = r0.appletId;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r10 = r0.widgetId;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r11 = r0.widgetData;
    L12:
        if ((r13 & 8) == 0) goto L15;
        r12 = r0.boxType;
    L15:
        return r0.copy(r1, r10, r11, r12);
    }

    public final String component1() {
        return this.appletId;
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

    public final AIContainerViewInfo copy(String r10, String r11, String r12, Integer r13) {
        return new AIContainerViewInfo(r10, r11, r12, r13);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AIContainerViewInfo) == true) goto L8;
        return false;
    L8:
        AIContainerViewInfo r11 = (AIContainerViewInfo) r10;
        if (Intrinsics.areEqual(this.appletId, r11.appletId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.widgetId, r11.widgetId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.widgetData, r11.widgetData) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.boxType, r11.boxType) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.appletId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        String r12 = this.widgetId;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.widgetData;
        if (r15 != null) goto L13;
        int r16 = 0;
    L14:
        int r17 = (r14 + r16) * 31;
        Integer r18 = this.boxType;
        if (r18 == null) goto L19;
        r1 = r18.hashCode();
    L19:
        return r17 + r1;
    L13:
        r16 = r15.hashCode();
        goto L14
    L9:
        r13 = r12.hashCode();
        goto L10
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AIContainerViewInfo(appletId=" + this.appletId + ", widgetId=" + this.widgetId + ", widgetData=" + this.widgetData + ", boxType=" + this.boxType + ')';
    }

    public final String getAppletId() {
        return this.appletId;
    }

    public final Integer getBoxType() {
        return this.boxType;
    }

    public final String getWidgetData() {
        return this.widgetData;
    }

    public final String getWidgetId() {
        return this.widgetId;
    }

    public AIContainerViewInfo(String r1, String r10, String r11, Integer r12) {
        this.appletId = r1;
        this.widgetId = r10;
        this.widgetData = r11;
        this.boxType = r12;
    }

    public /* synthetic */ AIContainerViewInfo(String r10, String r11, String r12, Integer r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = null;
    L12:
        if ((r14 & 8) == 0) goto L14;
        r13 = null;
    L14:
        this(r10, r11, r12, r13);
    }
}
