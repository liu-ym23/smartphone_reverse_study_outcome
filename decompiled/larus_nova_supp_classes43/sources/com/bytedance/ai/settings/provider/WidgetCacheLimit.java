package com.bytedance.ai.settings.provider;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ai/settings/provider/WidgetCacheLimit;", "", "widgetId", "", "packageName", "instanceLimit", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getWidgetId", "()Ljava/lang/String;", "getPackageName", "getInstanceLimit", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WidgetCacheLimit {

    @SerializedName("instance_limit")
    private final int instanceLimit;

    @SerializedName("package_name")
    private final String packageName;

    @SerializedName("widget_id")
    private final String widgetId;

    public WidgetCacheLimit() {
        this(null, null, 0, 7, null);
    }

    public static /* synthetic */ WidgetCacheLimit copy$default(WidgetCacheLimit r0, String r1, String r10, int r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r1 = r0.widgetId;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r10 = r0.packageName;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r11 = r0.instanceLimit;
    L12:
        return r0.copy(r1, r10, r11);
    }

    public final String component1() {
        return this.widgetId;
    }

    public final String component2() {
        return this.packageName;
    }

    public final int component3() {
        return this.instanceLimit;
    }

    public final WidgetCacheLimit copy(String r10, String r11, int r12) {
        return new WidgetCacheLimit(r10, r11, r12);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof WidgetCacheLimit) == true) goto L8;
        return false;
    L8:
        WidgetCacheLimit r11 = (WidgetCacheLimit) r10;
        if (Intrinsics.areEqual(this.widgetId, r11.widgetId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.packageName, r11.packageName) == true) goto L15;
        return false;
    L15:
        if (this.instanceLimit == r11.instanceLimit) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.widgetId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        String r12 = this.packageName;
        if (r12 == null) goto L11;
        r1 = r12.hashCode();
    L11:
        return ((r11 + r1) * 31) + this.instanceLimit;
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "WidgetCacheLimit(widgetId=" + this.widgetId + ", packageName=" + this.packageName + ", instanceLimit=" + this.instanceLimit + ')';
    }

    public final int getInstanceLimit() {
        return this.instanceLimit;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getWidgetId() {
        return this.widgetId;
    }

    public WidgetCacheLimit(String r1, String r10, int r11) {
        this.widgetId = r1;
        this.packageName = r10;
        this.instanceLimit = r11;
    }

    public /* synthetic */ WidgetCacheLimit(String r10, String r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = "";
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = "";
    L9:
        if ((r13 & 4) == 0) goto L11;
        r12 = -1;
    L11:
        this(r10, r11, r12);
    }
}
