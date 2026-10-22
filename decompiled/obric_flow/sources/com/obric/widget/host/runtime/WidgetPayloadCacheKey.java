package com.obric.widget.host.runtime;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetPayloadCacheKey;", "", "hostId", "", "appletId", "widgetId", "instanceId", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getHostId", "()Ljava/lang/String;", "getAppletId", "getWidgetId", "getInstanceId", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WidgetPayloadCacheKey {
    private final String appletId;
    private final String hostId;
    private final int instanceId;
    private final String widgetId;

    public WidgetPayloadCacheKey(String r5, String r10, String r11, int r12) {
        Intrinsics.checkNotNullParameter(r5, "hostId");
        Intrinsics.checkNotNullParameter(r10, "appletId");
        Intrinsics.checkNotNullParameter(r11, "widgetId");
        this.hostId = r5;
        this.appletId = r10;
        this.widgetId = r11;
        this.instanceId = r12;
    }

    public static /* synthetic */ WidgetPayloadCacheKey copy$default(WidgetPayloadCacheKey r5, String r10, String r11, String r12, int r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = r5.hostId;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = r5.appletId;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = r5.widgetId;
    L12:
        if ((r14 & 8) == 0) goto L15;
        r13 = r5.instanceId;
    L15:
        return r5.copy(r10, r11, r12, r13);
    }

    public final String component1() {
        return this.hostId;
    }

    public final String component2() {
        return this.appletId;
    }

    public final String component3() {
        return this.widgetId;
    }

    public final int component4() {
        return this.instanceId;
    }

    public final WidgetPayloadCacheKey copy(String r5, String r10, String r11, int r12) {
        Intrinsics.checkNotNullParameter(r5, "hostId");
        Intrinsics.checkNotNullParameter(r10, "appletId");
        Intrinsics.checkNotNullParameter(r11, "widgetId");
        return new WidgetPayloadCacheKey(r5, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WidgetPayloadCacheKey) == true) goto L8;
        return false;
    L8:
        WidgetPayloadCacheKey r10 = (WidgetPayloadCacheKey) r5;
        if (Intrinsics.areEqual(this.hostId, r10.hostId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appletId, r10.appletId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.widgetId, r10.widgetId) == true) goto L18;
        return false;
    L18:
        if (this.instanceId == r10.instanceId) goto L20;
        return false;
    L20:
        return true;
    }

    public final String getAppletId() {
        return this.appletId;
    }

    public final String getHostId() {
        return this.hostId;
    }

    public final int getInstanceId() {
        return this.instanceId;
    }

    public final String getWidgetId() {
        return this.widgetId;
    }

    public int hashCode() {
        int r5 = androidx.constraintlayout.motion.widget.a.c(androidx.constraintlayout.motion.widget.a.c(this.hostId.hashCode() * 31, 31, this.appletId), 31, this.widgetId);
        return Integer.hashCode(this.instanceId) + r5;
    }

    public String toString() {
        String r5 = this.hostId;
        String r10 = this.appletId;
        String r11 = this.widgetId;
        int r12 = this.instanceId;
        StringBuilder r13 = androidx.constraintlayout.motion.widget.a.y("WidgetPayloadCacheKey(hostId=", r5, ", appletId=", r10, ", widgetId=");
        r13.append(r11);
        r13.append(", instanceId=");
        r13.append(r12);
        r13.append(")");
        return r13.toString();
    }
}
