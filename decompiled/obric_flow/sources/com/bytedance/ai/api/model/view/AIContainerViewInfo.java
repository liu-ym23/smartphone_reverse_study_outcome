package com.bytedance.ai.api.model.view;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ai/api/model/view/AIContainerViewInfo;", "", "appletId", "", "widgetId", "widgetData", "boxType", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getAppletId", "()Ljava/lang/String;", "getWidgetId", "getWidgetData", "getBoxType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/ai/api/model/view/AIContainerViewInfo;", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
        String r5 = null;
        String r10 = null;
        String r11 = null;
        Integer r12 = null;
        this(r5, r10, r11, r12, 15, null);
    }

    public static /* synthetic */ AIContainerViewInfo copy$default(AIContainerViewInfo r5, String r10, String r11, String r12, Integer r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = r5.appletId;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = r5.widgetId;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = r5.widgetData;
    L12:
        if ((r14 & 8) == 0) goto L15;
        r13 = r5.boxType;
    L15:
        return r5.copy(r10, r11, r12, r13);
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

    public final AIContainerViewInfo copy(String r5, String r10, String r11, Integer r12) {
        return new AIContainerViewInfo(r5, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AIContainerViewInfo) == true) goto L8;
        return false;
    L8:
        AIContainerViewInfo r10 = (AIContainerViewInfo) r5;
        if (Intrinsics.areEqual(this.appletId, r10.appletId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.widgetId, r10.widgetId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.widgetData, r10.widgetData) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.boxType, r10.boxType) == true) goto L20;
        return false;
    L20:
        return true;
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

    public int hashCode() {
        String r5 = this.appletId;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        String r13 = this.widgetId;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        String r16 = this.widgetData;
        if (r16 != null) goto L13;
        int r17 = 0;
    L14:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.boxType;
        if (r19 == null) goto L19;
        r10 = r19.hashCode();
    L19:
        return r18 + r10;
    L13:
        r17 = r16.hashCode();
        goto L14
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r5.hashCode();
        goto L6
    }

    public String toString() {
        return "AIContainerViewInfo(appletId=" + this.appletId + ", widgetId=" + this.widgetId + ", widgetData=" + this.widgetData + ", boxType=" + this.boxType + ')';
    }

    public AIContainerViewInfo(String r5, String r10, String r11, Integer r12) {
        this.appletId = r5;
        this.widgetId = r10;
        this.widgetData = r11;
        this.boxType = r12;
    }

    public /* synthetic */ AIContainerViewInfo(String r5, String r10, String r11, Integer r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r5 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r10 = null;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r11 = null;
    L12:
        if ((r13 & 8) == 0) goto L14;
        r12 = null;
    L14:
        this(r5, r10, r11, r12);
    }
}
