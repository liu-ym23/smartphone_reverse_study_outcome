package com.bytedance.ai.settings.provider;

import ai.j0;
import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ai/settings/provider/WidgetReusedSettings;", "", "appletId", "", "widgetId", "reusedMaxSize", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getAppletId", "()Ljava/lang/String;", "getWidgetId", "getReusedMaxSize", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WidgetReusedSettings {

    @SerializedName("appletId")
    private final String appletId;

    @SerializedName("reusedMaxSize")
    private final int reusedMaxSize;

    @SerializedName("widgetId")
    private final String widgetId;

    public WidgetReusedSettings() {
        String r5 = null;
        String r10 = null;
        int r11 = 0;
        this(r5, r10, r11, 7, null);
    }

    public static /* synthetic */ WidgetReusedSettings copy$default(WidgetReusedSettings r5, String r10, String r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = r5.appletId;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.widgetId;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = r5.reusedMaxSize;
    L12:
        return r5.copy(r10, r11, r12);
    }

    public final String component1() {
        return this.appletId;
    }

    public final String component2() {
        return this.widgetId;
    }

    public final int component3() {
        return this.reusedMaxSize;
    }

    public final WidgetReusedSettings copy(String r5, String r10, int r11) {
        return new WidgetReusedSettings(r5, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WidgetReusedSettings) == true) goto L8;
        return false;
    L8:
        WidgetReusedSettings r10 = (WidgetReusedSettings) r5;
        if (Intrinsics.areEqual(this.appletId, r10.appletId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.widgetId, r10.widgetId) == true) goto L15;
        return false;
    L15:
        if (this.reusedMaxSize == r10.reusedMaxSize) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getAppletId() {
        return this.appletId;
    }

    public final int getReusedMaxSize() {
        return this.reusedMaxSize;
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
        if (r13 == null) goto L11;
        r10 = r13.hashCode();
    L11:
        return Integer.hashCode(this.reusedMaxSize) + ((r12 + r10) * 31);
    L5:
        r11 = r5.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("WidgetReusedSettings(appletId=");
        r5.append(this.appletId);
        r5.append(", widgetId=");
        r5.append(this.widgetId);
        r5.append(", reusedMaxSize=");
        return j0.n(r5, this.reusedMaxSize, ')');
    }

    public WidgetReusedSettings(String r5, String r10, int r11) {
        this.appletId = r5;
        this.widgetId = r10;
        this.reusedMaxSize = r11;
    }

    public /* synthetic */ WidgetReusedSettings(String r5, String r10, int r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r5 = "";
    L6:
        if ((r12 & 2) == 0) goto L9;
        r10 = "";
    L9:
        if ((r12 & 4) == 0) goto L11;
        r11 = 0;
    L11:
        this(r5, r10, r11);
    }
}
