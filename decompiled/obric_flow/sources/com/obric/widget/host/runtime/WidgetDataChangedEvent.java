package com.obric.widget.host.runtime;

import ai.j0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jv\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0006HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011¨\u0006-"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetDataChangedEvent;", "", "appletId", "", "widgetId", "instanceId", "", "hostId", "widgetData", "reason", "dataVersion", "", "updatedAt", "state", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "getAppletId", "()Ljava/lang/String;", "getWidgetId", "getInstanceId", "()I", "getHostId", "getWidgetData", "getReason", "getDataVersion", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getUpdatedAt", "getState", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)Lcom/obric/widget/host/runtime/WidgetDataChangedEvent;", "equals", "", "other", "hashCode", "toString", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WidgetDataChangedEvent {
    private final String appletId;
    private final Long dataVersion;
    private final String hostId;
    private final int instanceId;
    private final String reason;
    private final String state;
    private final Long updatedAt;
    private final String widgetData;
    private final String widgetId;

    public WidgetDataChangedEvent(String r5, String r10, int r11, String r12, String r13, String r14, Long r15, Long r16, String r17) {
        Intrinsics.checkNotNullParameter(r12, "hostId");
        this.appletId = r5;
        this.widgetId = r10;
        this.instanceId = r11;
        this.hostId = r12;
        this.widgetData = r13;
        this.reason = r14;
        this.dataVersion = r15;
        this.updatedAt = r16;
        this.state = r17;
    }

    public static /* synthetic */ WidgetDataChangedEvent copy$default(WidgetDataChangedEvent r10, String r11, String r12, int r13, String r14, String r15, String r16, Long r17, Long r18, String r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        String r5 = r10.appletId;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r22 = r10.widgetId;
    L11:
        if ((r20 & 4) == 0) goto L13;
        int r23 = r10.instanceId;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r24 = r10.hostId;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r25 = r10.widgetData;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r26 = r10.reason;
    L27:
        if ((r20 & 64) == 0) goto L29;
        Long r27 = r10.dataVersion;
    L31:
        if ((r20 & 128) == 0) goto L33;
        Long r28 = r10.updatedAt;
    L35:
        if ((r20 & 256) == 0) goto L37;
        String r29 = r10.state;
    L39:
        return r10.copy(r5, r22, r23, r24, r25, r26, r27, r28, r29);
    L37:
        r29 = r19;
        goto L39
    L33:
        r28 = r18;
        goto L35
    L29:
        r27 = r17;
        goto L31
    L25:
        r26 = r16;
        goto L27
    L21:
        r25 = r15;
        goto L23
    L17:
        r24 = r14;
        goto L19
    L13:
        r23 = r13;
        goto L15
    L9:
        r22 = r12;
        goto L11
    L5:
        r5 = r11;
        goto L7
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

    public final String component4() {
        return this.hostId;
    }

    public final String component5() {
        return this.widgetData;
    }

    public final String component6() {
        return this.reason;
    }

    public final Long component7() {
        return this.dataVersion;
    }

    public final Long component8() {
        return this.updatedAt;
    }

    public final String component9() {
        return this.state;
    }

    public final WidgetDataChangedEvent copy(String r12, String r13, int r14, String r15, String r16, String r17, Long r18, Long r19, String r20) {
        Intrinsics.checkNotNullParameter(r15, "hostId");
        return new WidgetDataChangedEvent(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WidgetDataChangedEvent) == true) goto L8;
        return false;
    L8:
        WidgetDataChangedEvent r10 = (WidgetDataChangedEvent) r5;
        if (Intrinsics.areEqual(this.appletId, r10.appletId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.widgetId, r10.widgetId) == true) goto L15;
        return false;
    L15:
        if (this.instanceId == r10.instanceId) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.hostId, r10.hostId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.widgetData, r10.widgetData) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.reason, r10.reason) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.dataVersion, r10.dataVersion) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.updatedAt, r10.updatedAt) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.state, r10.state) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final String getAppletId() {
        return this.appletId;
    }

    public final Long getDataVersion() {
        return this.dataVersion;
    }

    public final String getHostId() {
        return this.hostId;
    }

    public final int getInstanceId() {
        return this.instanceId;
    }

    public final String getReason() {
        return this.reason;
    }

    public final String getState() {
        return this.state;
    }

    public final Long getUpdatedAt() {
        return this.updatedAt;
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
        int r15 = androidx.constraintlayout.motion.widget.a.c(androidx.room.jarjarred.org.antlr.runtime.a.c(this.instanceId, (r12 + r14) * 31, 31), 31, this.hostId);
        String r16 = this.widgetData;
        if (r16 != null) goto L13;
        int r17 = 0;
    L14:
        int r18 = (r15 + r17) * 31;
        String r19 = this.reason;
        if (r19 != null) goto L17;
        int r20 = 0;
    L18:
        int r21 = (r18 + r20) * 31;
        Long r22 = this.dataVersion;
        if (r22 != null) goto L21;
        int r23 = 0;
    L22:
        int r24 = (r21 + r23) * 31;
        Long r25 = this.updatedAt;
        if (r25 != null) goto L25;
        int r26 = 0;
    L26:
        int r27 = (r24 + r26) * 31;
        String r28 = this.state;
        if (r28 == null) goto L31;
        r10 = r28.hashCode();
    L31:
        return r27 + r10;
    L25:
        r26 = r25.hashCode();
        goto L26
    L21:
        r23 = r22.hashCode();
        goto L22
    L17:
        r20 = r19.hashCode();
        goto L18
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
        String r5 = this.appletId;
        String r10 = this.widgetId;
        int r11 = this.instanceId;
        String r12 = this.hostId;
        String r13 = this.widgetData;
        String r14 = this.reason;
        Long r15 = this.dataVersion;
        Long r16 = this.updatedAt;
        String r17 = this.state;
        StringBuilder r18 = androidx.constraintlayout.motion.widget.a.y("WidgetDataChangedEvent(appletId=", r5, ", widgetId=", r10, ", instanceId=");
        androidx.room.jarjarred.org.antlr.runtime.a.D(r18, r11, ", hostId=", r12, ", widgetData=");
        androidx.constraintlayout.motion.widget.a.C(r18, r13, ", reason=", r14, ", dataVersion=");
        r18.append(r15);
        r18.append(", updatedAt=");
        r18.append(r16);
        r18.append(", state=");
        return j0.q(r18, r17, ")");
    }
}
