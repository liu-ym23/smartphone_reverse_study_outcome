package com.obric.widget.host.runtime;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetPendingRender;", "", "reason", "", "allowHidden", "", "<init>", "(Ljava/lang/String;Z)V", "getReason", "()Ljava/lang/String;", "getAllowHidden", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WidgetPendingRender {
    private final boolean allowHidden;
    private final String reason;

    public WidgetPendingRender(String r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "reason");
        this.reason = r5;
        this.allowHidden = r10;
    }

    public static /* synthetic */ WidgetPendingRender copy$default(WidgetPendingRender r5, String r10, boolean r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = r5.reason;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.allowHidden;
    L9:
        return r5.copy(r10, r11);
    }

    public final String component1() {
        return this.reason;
    }

    public final boolean component2() {
        return this.allowHidden;
    }

    public final WidgetPendingRender copy(String r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "reason");
        return new WidgetPendingRender(r5, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WidgetPendingRender) == true) goto L8;
        return false;
    L8:
        WidgetPendingRender r10 = (WidgetPendingRender) r5;
        if (Intrinsics.areEqual(this.reason, r10.reason) == true) goto L12;
        return false;
    L12:
        if (this.allowHidden == r10.allowHidden) goto L14;
        return false;
    L14:
        return true;
    }

    public final boolean getAllowHidden() {
        return this.allowHidden;
    }

    public final String getReason() {
        return this.reason;
    }

    public int hashCode() {
        int r5 = this.reason.hashCode() * 31;
        return Boolean.hashCode(this.allowHidden) + r5;
    }

    public String toString() {
        return "WidgetPendingRender(reason=" + this.reason + ", allowHidden=" + this.allowHidden + ")";
    }
}
