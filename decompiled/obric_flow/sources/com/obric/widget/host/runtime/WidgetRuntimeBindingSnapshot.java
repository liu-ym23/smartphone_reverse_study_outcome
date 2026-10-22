package com.obric.widget.host.runtime;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetRuntimeBindingSnapshot;", "", "appletId", "", "widgetId", "instanceId", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getAppletId", "()Ljava/lang/String;", "getWidgetId", "getInstanceId", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WidgetRuntimeBindingSnapshot {
    private final String appletId;
    private final int instanceId;
    private final String widgetId;

    public WidgetRuntimeBindingSnapshot(String r5, String r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "appletId");
        Intrinsics.checkNotNullParameter(r10, "widgetId");
        this.appletId = r5;
        this.widgetId = r10;
        this.instanceId = r11;
    }

    public static /* synthetic */ WidgetRuntimeBindingSnapshot copy$default(WidgetRuntimeBindingSnapshot r5, String r10, String r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = r5.appletId;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.widgetId;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = r5.instanceId;
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
        return this.instanceId;
    }

    public final WidgetRuntimeBindingSnapshot copy(String r5, String r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "appletId");
        Intrinsics.checkNotNullParameter(r10, "widgetId");
        return new WidgetRuntimeBindingSnapshot(r5, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WidgetRuntimeBindingSnapshot) == true) goto L8;
        return false;
    L8:
        WidgetRuntimeBindingSnapshot r10 = (WidgetRuntimeBindingSnapshot) r5;
        if (Intrinsics.areEqual(this.appletId, r10.appletId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.widgetId, r10.widgetId) == true) goto L15;
        return false;
    L15:
        if (this.instanceId == r10.instanceId) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getAppletId() {
        return this.appletId;
    }

    public final int getInstanceId() {
        return this.instanceId;
    }

    public final String getWidgetId() {
        return this.widgetId;
    }

    public int hashCode() {
        int r5 = androidx.constraintlayout.motion.widget.a.c(this.appletId.hashCode() * 31, 31, this.widgetId);
        return Integer.hashCode(this.instanceId) + r5;
    }

    public String toString() {
        String r5 = this.appletId;
        String r10 = this.widgetId;
        int r11 = this.instanceId;
        return androidx.constraintlayout.motion.widget.a.s(androidx.constraintlayout.motion.widget.a.y("WidgetRuntimeBindingSnapshot(appletId=", r5, ", widgetId=", r10, ", instanceId="), r11, ")");
    }
}
