package com.obric.widget.host;

import ai.j0;
import androidx.room.jarjarred.org.antlr.runtime.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0011HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u000e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/obric/widget/host/WidgetInstanceKey;", "", "appletId", "", "widgetId", "instanceId", "hostId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppletId", "()Ljava/lang/String;", "getWidgetId", "getInstanceId", "getHostId", "stableId", "getStableId", "instanceIdAsInt", "", "()Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WidgetInstanceKey {
    private final String appletId;
    private final String hostId;
    private final String instanceId;
    private final String widgetId;

    public WidgetInstanceKey(String r5, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r5, "appletId");
        Intrinsics.checkNotNullParameter(r10, "widgetId");
        Intrinsics.checkNotNullParameter(r11, "instanceId");
        Intrinsics.checkNotNullParameter(r12, "hostId");
        this.appletId = r5;
        this.widgetId = r10;
        this.instanceId = r11;
        this.hostId = r12;
    }

    public static /* synthetic */ WidgetInstanceKey copy$default(WidgetInstanceKey r5, String r10, String r11, String r12, String r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = r5.appletId;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = r5.widgetId;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = r5.instanceId;
    L12:
        if ((r14 & 8) == 0) goto L15;
        r13 = r5.hostId;
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
        return this.instanceId;
    }

    public final String component4() {
        return this.hostId;
    }

    public final WidgetInstanceKey copy(String r5, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r5, "appletId");
        Intrinsics.checkNotNullParameter(r10, "widgetId");
        Intrinsics.checkNotNullParameter(r11, "instanceId");
        Intrinsics.checkNotNullParameter(r12, "hostId");
        return new WidgetInstanceKey(r5, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WidgetInstanceKey) == true) goto L8;
        return false;
    L8:
        WidgetInstanceKey r10 = (WidgetInstanceKey) r5;
        if (Intrinsics.areEqual(this.appletId, r10.appletId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.widgetId, r10.widgetId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.instanceId, r10.instanceId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.hostId, r10.hostId) == true) goto L20;
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

    public final String getInstanceId() {
        return this.instanceId;
    }

    public final String getStableId() {
        String r5 = this.appletId;
        String r10 = this.widgetId;
        String r11 = this.instanceId;
        String r12 = this.hostId;
        return j0.q(a.y(r5, "/", r10, "/", r11), "@", r12);
    }

    public final String getWidgetId() {
        return this.widgetId;
    }

    public int hashCode() {
        int r5 = androidx.constraintlayout.motion.widget.a.c(androidx.constraintlayout.motion.widget.a.c(this.appletId.hashCode() * 31, 31, this.widgetId), 31, this.instanceId);
        return this.hostId.hashCode() + r5;
    }

    public final Integer instanceIdAsInt() {
        return StringsKt.toIntOrNull(this.instanceId);
    }

    public String toString() {
        String r5 = this.appletId;
        String r10 = this.widgetId;
        String r11 = this.instanceId;
        String r12 = this.hostId;
        return androidx.constraintlayout.motion.widget.a.u(androidx.constraintlayout.motion.widget.a.y("WidgetInstanceKey(appletId=", r5, ", widgetId=", r10, ", instanceId="), r11, ", hostId=", r12, ")");
    }
}
