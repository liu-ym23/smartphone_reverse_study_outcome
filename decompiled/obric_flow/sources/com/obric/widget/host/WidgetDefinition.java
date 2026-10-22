package com.obric.widget.host;

import androidx.constraintlayout.motion.widget.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0017\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000eHÆ\u0003Jz\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0007HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u001f\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006/"}, d2 = {"Lcom/obric/widget/host/WidgetDefinition;", "", "appletId", "", "widgetId", "displayName", "spanX", "", "spanY", "minSpanX", "minSpanY", "version", "", "extras", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIILjava/lang/Long;Ljava/util/Map;)V", "getAppletId", "()Ljava/lang/String;", "getWidgetId", "getDisplayName", "getSpanX", "()I", "getSpanY", "getMinSpanX", "getMinSpanY", "getVersion", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getExtras", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIILjava/lang/Long;Ljava/util/Map;)Lcom/obric/widget/host/WidgetDefinition;", "equals", "", "other", "hashCode", "toString", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WidgetDefinition {
    private final String appletId;
    private final String displayName;
    private final Map<String, Object> extras;
    private final int minSpanX;
    private final int minSpanY;
    private final int spanX;
    private final int spanY;
    private final Long version;
    private final String widgetId;

    public WidgetDefinition(String r5, String r10, String r11, int r12, int r13, int r14, int r15, Long r16, Map<String, ? extends Object> r17) {
        Intrinsics.checkNotNullParameter(r5, "appletId");
        Intrinsics.checkNotNullParameter(r10, "widgetId");
        Intrinsics.checkNotNullParameter(r17, "extras");
        this.appletId = r5;
        this.widgetId = r10;
        this.displayName = r11;
        this.spanX = r12;
        this.spanY = r13;
        this.minSpanX = r14;
        this.minSpanY = r15;
        this.version = r16;
        this.extras = r17;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetDefinition copy$default(WidgetDefinition r10, String r11, String r12, String r13, int r14, int r15, int r16, int r17, Long r18, Map r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        String r5 = r10.appletId;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r22 = r10.widgetId;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r23 = r10.displayName;
    L15:
        if ((r20 & 8) == 0) goto L17;
        int r24 = r10.spanX;
    L19:
        if ((r20 & 16) == 0) goto L21;
        int r25 = r10.spanY;
    L23:
        if ((r20 & 32) == 0) goto L25;
        int r26 = r10.minSpanX;
    L27:
        if ((r20 & 64) == 0) goto L29;
        int r27 = r10.minSpanY;
    L31:
        if ((r20 & 128) == 0) goto L33;
        Long r28 = r10.version;
    L35:
        if ((r20 & 256) == 0) goto L37;
        Map r29 = r10.extras;
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

    public final String component3() {
        return this.displayName;
    }

    public final int component4() {
        return this.spanX;
    }

    public final int component5() {
        return this.spanY;
    }

    public final int component6() {
        return this.minSpanX;
    }

    public final int component7() {
        return this.minSpanY;
    }

    public final Long component8() {
        return this.version;
    }

    public final Map<String, Object> component9() {
        return this.extras;
    }

    public final WidgetDefinition copy(String r12, String r13, String r14, int r15, int r16, int r17, int r18, Long r19, Map<String, ? extends Object> r20) {
        Intrinsics.checkNotNullParameter(r12, "appletId");
        Intrinsics.checkNotNullParameter(r13, "widgetId");
        Intrinsics.checkNotNullParameter(r20, "extras");
        return new WidgetDefinition(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WidgetDefinition) == true) goto L8;
        return false;
    L8:
        WidgetDefinition r10 = (WidgetDefinition) r5;
        if (Intrinsics.areEqual(this.appletId, r10.appletId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.widgetId, r10.widgetId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.displayName, r10.displayName) == true) goto L18;
        return false;
    L18:
        if (this.spanX == r10.spanX) goto L21;
        return false;
    L21:
        if (this.spanY == r10.spanY) goto L24;
        return false;
    L24:
        if (this.minSpanX == r10.minSpanX) goto L27;
        return false;
    L27:
        if (this.minSpanY == r10.minSpanY) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.version, r10.version) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.extras, r10.extras) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final String getAppletId() {
        return this.appletId;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final Map<String, Object> getExtras() {
        return this.extras;
    }

    public final int getMinSpanX() {
        return this.minSpanX;
    }

    public final int getMinSpanY() {
        return this.minSpanY;
    }

    public final int getSpanX() {
        return this.spanX;
    }

    public final int getSpanY() {
        return this.spanY;
    }

    public final Long getVersion() {
        return this.version;
    }

    public final String getWidgetId() {
        return this.widgetId;
    }

    public int hashCode() {
        int r5 = a.c(this.appletId.hashCode() * 31, 31, this.widgetId);
        String r10 = this.displayName;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.minSpanY, androidx.room.jarjarred.org.antlr.runtime.a.c(this.minSpanX, androidx.room.jarjarred.org.antlr.runtime.a.c(this.spanY, androidx.room.jarjarred.org.antlr.runtime.a.c(this.spanX, (r5 + r12) * 31, 31), 31), 31), 31);
        Long r14 = this.version;
        if (r14 == null) goto L11;
        r11 = r14.hashCode();
    L11:
        return this.extras.hashCode() + ((r13 + r11) * 31);
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public String toString() {
        String r5 = this.appletId;
        String r10 = this.widgetId;
        String r11 = this.displayName;
        int r12 = this.spanX;
        int r13 = this.spanY;
        int r14 = this.minSpanX;
        int r15 = this.minSpanY;
        Long r16 = this.version;
        Map<String, Object> r17 = this.extras;
        StringBuilder r18 = a.y("WidgetDefinition(appletId=", r5, ", widgetId=", r10, ", displayName=");
        r18.append(r11);
        r18.append(", spanX=");
        r18.append(r12);
        r18.append(", spanY=");
        androidx.room.jarjarred.org.antlr.runtime.a.C(r18, r13, ", minSpanX=", r14, ", minSpanY=");
        r18.append(r15);
        r18.append(", version=");
        r18.append(r16);
        r18.append(", extras=");
        r18.append(r17);
        r18.append(")");
        return r18.toString();
    }

    public /* synthetic */ WidgetDefinition(String r14, String r15, String r16, int r17, int r18, int r19, int r20, Long r21, Map r22, int r23, DefaultConstructorMarker r24) {
        if ((r23 & 4) == 0) goto L5;
        String r10 = null;
    L7:
        if ((r23 & 8) == 0) goto L9;
        int r11 = 0;
    L11:
        if ((r23 & 16) == 0) goto L13;
        int r12 = 0;
    L15:
        if ((r23 & 32) == 0) goto L17;
        int r13 = 0;
    L19:
        if ((r23 & 64) == 0) goto L21;
        int r110 = 0;
    L23:
        if ((r23 & 128) == 0) goto L25;
        Long r111 = null;
    L27:
        if ((r23 & 256) == 0) goto L29;
        Map r112 = MapsKt.emptyMap();
    L30:
        this(r14, r15, r10, r11, r12, r13, r110, r111, r112);
        return;
    L29:
        r112 = r22;
        goto L30
    L25:
        r111 = r21;
        goto L27
    L21:
        r110 = r20;
        goto L23
    L17:
        r13 = r19;
        goto L19
    L13:
        r12 = r18;
        goto L15
    L9:
        r11 = r17;
        goto L11
    L5:
        r10 = r16;
        goto L7
    }
}
