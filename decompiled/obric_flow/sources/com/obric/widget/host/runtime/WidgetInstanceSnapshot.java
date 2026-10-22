package com.obric.widget.host.runtime;

import ai.j0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u0087\u0001\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0003HÖ\u0001J\t\u00101\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013¨\u00062"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetInstanceSnapshot;", "", "hostWidgetInstanceId", "", "hostItemId", "appWidgetId", "hostId", "", "appletId", "widgetId", "definitionId", "screenId", "cellX", "cellY", "spanX", "spanY", "<init>", "(IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIII)V", "getHostWidgetInstanceId", "()I", "getHostItemId", "getAppWidgetId", "getHostId", "()Ljava/lang/String;", "getAppletId", "getWidgetId", "getDefinitionId", "getScreenId", "getCellX", "getCellY", "getSpanX", "getSpanY", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "", "other", "hashCode", "toString", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WidgetInstanceSnapshot {
    private final int appWidgetId;
    private final String appletId;
    private final int cellX;
    private final int cellY;
    private final String definitionId;
    private final String hostId;
    private final int hostItemId;
    private final int hostWidgetInstanceId;
    private final int screenId;
    private final int spanX;
    private final int spanY;
    private final String widgetId;

    public WidgetInstanceSnapshot(int r5, int r10, int r11, String r12, String r13, String r14, String r15, int r16, int r17, int r18, int r19, int r110) {
        Intrinsics.checkNotNullParameter(r12, "hostId");
        this.hostWidgetInstanceId = r5;
        this.hostItemId = r10;
        this.appWidgetId = r11;
        this.hostId = r12;
        this.appletId = r13;
        this.widgetId = r14;
        this.definitionId = r15;
        this.screenId = r16;
        this.cellX = r17;
        this.cellY = r18;
        this.spanX = r19;
        this.spanY = r110;
    }

    public static /* synthetic */ WidgetInstanceSnapshot copy$default(WidgetInstanceSnapshot r13, int r14, int r15, int r16, String r17, String r18, String r19, String r20, int r21, int r22, int r23, int r24, int r25, int r26, Object r27) {
        if ((r26 & 1) == 0) goto L5;
        int r5 = r13.hostWidgetInstanceId;
    L7:
        if ((r26 & 2) == 0) goto L9;
        int r10 = r13.hostItemId;
    L11:
        if ((r26 & 4) == 0) goto L13;
        int r11 = r13.appWidgetId;
    L15:
        if ((r26 & 8) == 0) goto L17;
        String r12 = r13.hostId;
    L19:
        if ((r26 & 16) == 0) goto L21;
        String r28 = r13.appletId;
    L23:
        if ((r26 & 32) == 0) goto L25;
        String r29 = r13.widgetId;
    L27:
        if ((r26 & 64) == 0) goto L29;
        String r30 = r13.definitionId;
    L31:
        if ((r26 & 128) == 0) goto L33;
        int r31 = r13.screenId;
    L35:
        if ((r26 & 256) == 0) goto L37;
        int r110 = r13.cellX;
    L39:
        if ((r26 & 512) == 0) goto L41;
        int r111 = r13.cellY;
    L43:
        if ((r26 & 1024) == 0) goto L45;
        int r112 = r13.spanX;
    L47:
        if ((r26 & 2048) == 0) goto L49;
        int r32 = r13.spanY;
    L51:
        return r13.copy(r5, r10, r11, r12, r28, r29, r30, r31, r110, r111, r112, r32);
    L49:
        r32 = r25;
        goto L51
    L45:
        r112 = r24;
        goto L47
    L41:
        r111 = r23;
        goto L43
    L37:
        r110 = r22;
        goto L39
    L33:
        r31 = r21;
        goto L35
    L29:
        r30 = r20;
        goto L31
    L25:
        r29 = r19;
        goto L27
    L21:
        r28 = r18;
        goto L23
    L17:
        r12 = r17;
        goto L19
    L13:
        r11 = r16;
        goto L15
    L9:
        r10 = r15;
        goto L11
    L5:
        r5 = r14;
        goto L7
    }

    public final int component1() {
        return this.hostWidgetInstanceId;
    }

    public final int component10() {
        return this.cellY;
    }

    public final int component11() {
        return this.spanX;
    }

    public final int component12() {
        return this.spanY;
    }

    public final int component2() {
        return this.hostItemId;
    }

    public final int component3() {
        return this.appWidgetId;
    }

    public final String component4() {
        return this.hostId;
    }

    public final String component5() {
        return this.appletId;
    }

    public final String component6() {
        return this.widgetId;
    }

    public final String component7() {
        return this.definitionId;
    }

    public final int component8() {
        return this.screenId;
    }

    public final int component9() {
        return this.cellX;
    }

    public final WidgetInstanceSnapshot copy(int r15, int r16, int r17, String r18, String r19, String r20, String r21, int r22, int r23, int r24, int r25, int r26) {
        Intrinsics.checkNotNullParameter(r18, "hostId");
        return new WidgetInstanceSnapshot(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WidgetInstanceSnapshot) == true) goto L8;
        return false;
    L8:
        WidgetInstanceSnapshot r10 = (WidgetInstanceSnapshot) r5;
        if (this.hostWidgetInstanceId == r10.hostWidgetInstanceId) goto L12;
        return false;
    L12:
        if (this.hostItemId == r10.hostItemId) goto L15;
        return false;
    L15:
        if (this.appWidgetId == r10.appWidgetId) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.hostId, r10.hostId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.appletId, r10.appletId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.widgetId, r10.widgetId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.definitionId, r10.definitionId) == true) goto L30;
        return false;
    L30:
        if (this.screenId == r10.screenId) goto L33;
        return false;
    L33:
        if (this.cellX == r10.cellX) goto L36;
        return false;
    L36:
        if (this.cellY == r10.cellY) goto L39;
        return false;
    L39:
        if (this.spanX == r10.spanX) goto L42;
        return false;
    L42:
        if (this.spanY == r10.spanY) goto L44;
        return false;
    L44:
        return true;
    }

    public final int getAppWidgetId() {
        return this.appWidgetId;
    }

    public final String getAppletId() {
        return this.appletId;
    }

    public final int getCellX() {
        return this.cellX;
    }

    public final int getCellY() {
        return this.cellY;
    }

    public final String getDefinitionId() {
        return this.definitionId;
    }

    public final String getHostId() {
        return this.hostId;
    }

    public final int getHostItemId() {
        return this.hostItemId;
    }

    public final int getHostWidgetInstanceId() {
        return this.hostWidgetInstanceId;
    }

    public final int getScreenId() {
        return this.screenId;
    }

    public final int getSpanX() {
        return this.spanX;
    }

    public final int getSpanY() {
        return this.spanY;
    }

    public final String getWidgetId() {
        return this.widgetId;
    }

    public int hashCode() {
        int r5 = androidx.constraintlayout.motion.widget.a.c(androidx.room.jarjarred.org.antlr.runtime.a.c(this.appWidgetId, androidx.room.jarjarred.org.antlr.runtime.a.c(this.hostItemId, Integer.hashCode(this.hostWidgetInstanceId) * 31, 31), 31), 31, this.hostId);
        String r10 = this.appletId;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (r5 + r12) * 31;
        String r14 = this.widgetId;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.definitionId;
        if (r17 == null) goto L15;
        r11 = r17.hashCode();
    L15:
        return Integer.hashCode(this.spanY) + androidx.room.jarjarred.org.antlr.runtime.a.c(this.spanX, androidx.room.jarjarred.org.antlr.runtime.a.c(this.cellY, androidx.room.jarjarred.org.antlr.runtime.a.c(this.cellX, androidx.room.jarjarred.org.antlr.runtime.a.c(this.screenId, (r16 + r11) * 31, 31), 31), 31), 31);
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public String toString() {
        int r5 = this.hostWidgetInstanceId;
        int r10 = this.hostItemId;
        int r11 = this.appWidgetId;
        String r12 = this.hostId;
        String r13 = this.appletId;
        String r14 = this.widgetId;
        String r15 = this.definitionId;
        int r16 = this.screenId;
        int r17 = this.cellX;
        int r18 = this.cellY;
        int r19 = this.spanX;
        int r110 = this.spanY;
        StringBuilder r20 = j0.v("WidgetInstanceSnapshot(hostWidgetInstanceId=", r5, r10, ", hostItemId=", ", appWidgetId=");
        androidx.room.jarjarred.org.antlr.runtime.a.D(r20, r11, ", hostId=", r12, ", appletId=");
        androidx.constraintlayout.motion.widget.a.C(r20, r13, ", widgetId=", r14, ", definitionId=");
        r20.append(r15);
        r20.append(", screenId=");
        r20.append(r16);
        r20.append(", cellX=");
        androidx.room.jarjarred.org.antlr.runtime.a.C(r20, r17, ", cellY=", r18, ", spanX=");
        r20.append(r19);
        r20.append(", spanY=");
        r20.append(r110);
        r20.append(")");
        return r20.toString();
    }
}
