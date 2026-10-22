package com.obric.widget.host.runtime;

import ai.j0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 +2\u00020\u0001:\u0001+B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003Je\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0006HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u0006,"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetDataSnapshot;", "", "appletId", "", "widgetId", "instanceId", "", "widgetData", "hostId", "schemaVersion", "dataVersion", "", "updatedAt", "state", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;IJJLjava/lang/String;)V", "getAppletId", "()Ljava/lang/String;", "getWidgetId", "getInstanceId", "()I", "getWidgetData", "getHostId", "getSchemaVersion", "getDataVersion", "()J", "getUpdatedAt", "getState", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WidgetDataSnapshot {
    public static final Companion Companion = null;
    public static final String DEFAULT_HOST_ID = "launcher";
    public static final int DEFAULT_SCHEMA_VERSION = 1;
    public static final String STATE_CONTENT = "content";
    public static final String STATE_EMPTY = "empty";
    public static final String STATE_ERROR = "error";
    public static final String STATE_STALE = "stale";
    private final String appletId;
    private final long dataVersion;
    private final String hostId;
    private final int instanceId;
    private final int schemaVersion;
    private final String state;
    private final long updatedAt;
    private final String widgetData;
    private final String widgetId;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetDataSnapshot$Companion;", "", "<init>", "()V", "DEFAULT_HOST_ID", "", "DEFAULT_SCHEMA_VERSION", "", "STATE_CONTENT", "STATE_EMPTY", "STATE_ERROR", "STATE_STALE", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public WidgetDataSnapshot(String r5, String r10, int r11, String r12, String r13, int r14, long r15, long r16, String r17) {
        Intrinsics.checkNotNullParameter(r5, "appletId");
        Intrinsics.checkNotNullParameter(r10, "widgetId");
        Intrinsics.checkNotNullParameter(r13, "hostId");
        Intrinsics.checkNotNullParameter(r17, "state");
        this.appletId = r5;
        this.widgetId = r10;
        this.instanceId = r11;
        this.widgetData = r12;
        this.hostId = r13;
        this.schemaVersion = r14;
        this.dataVersion = r15;
        this.updatedAt = r16;
        this.state = r17;
    }

    public static /* synthetic */ WidgetDataSnapshot copy$default(WidgetDataSnapshot r12, String r13, String r14, int r15, String r16, String r17, int r18, long r19, long r21, String r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        String r5 = r12.appletId;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r10 = r12.widgetId;
    L11:
        if ((r24 & 4) == 0) goto L13;
        int r11 = r12.instanceId;
    L15:
        if ((r24 & 8) == 0) goto L17;
        String r20 = r12.widgetData;
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r22 = r12.hostId;
    L23:
        if ((r24 & 32) == 0) goto L25;
        int r26 = r12.schemaVersion;
    L27:
        if ((r24 & 64) == 0) goto L29;
        long r27 = r12.dataVersion;
    L31:
        if ((r24 & 128) == 0) goto L33;
        long r110 = r12.updatedAt;
    L35:
        if ((r24 & 256) == 0) goto L37;
        String r28 = r12.state;
    L39:
        return r12.copy(r5, r10, r11, r20, r22, r26, r27, r110, r28);
    L37:
        r28 = r23;
        goto L39
    L33:
        r110 = r21;
        goto L35
    L29:
        r27 = r19;
        goto L31
    L25:
        r26 = r18;
        goto L27
    L21:
        r22 = r17;
        goto L23
    L17:
        r20 = r16;
        goto L19
    L13:
        r11 = r15;
        goto L15
    L9:
        r10 = r14;
        goto L11
    L5:
        r5 = r13;
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
        return this.widgetData;
    }

    public final String component5() {
        return this.hostId;
    }

    public final int component6() {
        return this.schemaVersion;
    }

    public final long component7() {
        return this.dataVersion;
    }

    public final long component8() {
        return this.updatedAt;
    }

    public final String component9() {
        return this.state;
    }

    public final WidgetDataSnapshot copy(String r14, String r15, int r16, String r17, String r18, int r19, long r20, long r22, String r24) {
        Intrinsics.checkNotNullParameter(r14, "appletId");
        Intrinsics.checkNotNullParameter(r15, "widgetId");
        Intrinsics.checkNotNullParameter(r18, "hostId");
        Intrinsics.checkNotNullParameter(r24, "state");
        return new WidgetDataSnapshot(r14, r15, r16, r17, r18, r19, r20, r22, r24);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof WidgetDataSnapshot) == true) goto L8;
        return false;
    L8:
        WidgetDataSnapshot r11 = (WidgetDataSnapshot) r10;
        if (Intrinsics.areEqual(this.appletId, r11.appletId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.widgetId, r11.widgetId) == true) goto L15;
        return false;
    L15:
        if (this.instanceId == r11.instanceId) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.widgetData, r11.widgetData) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.hostId, r11.hostId) == true) goto L24;
        return false;
    L24:
        if (this.schemaVersion == r11.schemaVersion) goto L27;
        return false;
    L27:
        if (this.dataVersion == r11.dataVersion) goto L30;
        return false;
    L30:
        if (this.updatedAt == r11.updatedAt) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.state, r11.state) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final String getAppletId() {
        return this.appletId;
    }

    public final long getDataVersion() {
        return this.dataVersion;
    }

    public final String getHostId() {
        return this.hostId;
    }

    public final int getInstanceId() {
        return this.instanceId;
    }

    public final int getSchemaVersion() {
        return this.schemaVersion;
    }

    public final String getState() {
        return this.state;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public final String getWidgetData() {
        return this.widgetData;
    }

    public final String getWidgetId() {
        return this.widgetId;
    }

    public int hashCode() {
        int r5 = androidx.constraintlayout.motion.widget.a.c(this.appletId.hashCode() * 31, 31, this.widgetId);
        int r10 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.instanceId, r5, 31);
        String r11 = this.widgetData;
        if (r11 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = androidx.constraintlayout.motion.widget.a.c((r10 + r12) * 31, 31, this.hostId);
        int r14 = androidx.room.jarjarred.org.antlr.runtime.a.e(androidx.room.jarjarred.org.antlr.runtime.a.e(androidx.room.jarjarred.org.antlr.runtime.a.c(this.schemaVersion, r13, 31), this.dataVersion, 31), this.updatedAt, 31);
        return this.state.hashCode() + r14;
    L5:
        r12 = r11.hashCode();
        goto L6
    }

    public String toString() {
        String r5 = this.appletId;
        String r10 = this.widgetId;
        int r11 = this.instanceId;
        String r12 = this.widgetData;
        String r13 = this.hostId;
        int r14 = this.schemaVersion;
        long r15 = this.dataVersion;
        long r16 = this.updatedAt;
        String r17 = this.state;
        StringBuilder r18 = androidx.constraintlayout.motion.widget.a.y("WidgetDataSnapshot(appletId=", r5, ", widgetId=", r10, ", instanceId=");
        androidx.room.jarjarred.org.antlr.runtime.a.D(r18, r11, ", widgetData=", r12, ", hostId=");
        r18.append(r13);
        r18.append(", schemaVersion=");
        r18.append(r14);
        r18.append(", dataVersion=");
        r18.append(r15);
        kotlin.collections.a.o(r18, ", updatedAt=", r16, ", state=");
        return j0.q(r18, r17, ")");
    }

    public /* synthetic */ WidgetDataSnapshot(String r15, String r16, int r17, String r18, String r19, int r20, long r21, long r23, String r25, int r26, DefaultConstructorMarker r27) {
        if ((r26 & 16) == 0) goto L5;
        String r10 = "launcher";
    L7:
        if ((r26 & 32) == 0) goto L9;
        int r11 = 1;
    L11:
        if ((r26 & 64) == 0) goto L13;
        long r12 = 0;
    L15:
        if ((r26 & 128) == 0) goto L17;
        long r13 = 0;
    L19:
        if ((r26 & 256) == 0) goto L21;
        String r14 = "content";
    L22:
        this(r15, r16, r17, r18, r10, r11, r12, r13, r14);
        return;
    L21:
        r14 = r25;
        goto L22
    L17:
        r13 = r23;
        goto L19
    L13:
        r12 = r21;
        goto L15
    L9:
        r11 = r20;
        goto L11
    L5:
        r10 = r19;
        goto L7
    }
}
