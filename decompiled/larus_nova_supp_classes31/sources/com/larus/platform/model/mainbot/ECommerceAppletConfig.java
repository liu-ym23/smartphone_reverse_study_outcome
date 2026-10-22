package com.larus.platform.model.mainbot;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/larus/platform/model/mainbot/ECommerceAppletConfig;", "", "clickWidgetImageToDetail", "", "<init>", "(Z)V", "getClickWidgetImageToDetail", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ECommerceAppletConfig {

    @SerializedName("click_widget_image_to_detail")
    private final boolean clickWidgetImageToDetail;

    public ECommerceAppletConfig() {
        boolean r2 = false;
        this(r2, 1, null);
    }

    public static /* synthetic */ ECommerceAppletConfig copy$default(ECommerceAppletConfig r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.clickWidgetImageToDetail;
    L6:
        return r0.copy(r1);
    }

    public final boolean component1() {
        return this.clickWidgetImageToDetail;
    }

    public final ECommerceAppletConfig copy(boolean r2) {
        return new ECommerceAppletConfig(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof ECommerceAppletConfig) == true) goto L9;
        return false;
    L9:
        if (this.clickWidgetImageToDetail == ((ECommerceAppletConfig) r4).clickWidgetImageToDetail) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        if (this.clickWidgetImageToDetail == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public String toString() {
        return "ECommerceAppletConfig(clickWidgetImageToDetail=" + this.clickWidgetImageToDetail + ')';
    }

    public final boolean getClickWidgetImageToDetail() {
        return this.clickWidgetImageToDetail;
    }

    public ECommerceAppletConfig(boolean r1) {
        this.clickWidgetImageToDetail = r1;
    }

    public /* synthetic */ ECommerceAppletConfig(boolean r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        this(r1);
    }
}
