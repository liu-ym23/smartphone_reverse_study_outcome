package com.obric.widget.host.runtime;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J[\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0007HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013¨\u0006&"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;", "", "appletId", "", "widgetId", "previewUri", "previewRes", "", "spanX", "spanY", "minSpanX", "minSpanY", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIII)V", "getAppletId", "()Ljava/lang/String;", "getWidgetId", "getPreviewUri", "getPreviewRes", "()I", "getSpanX", "getSpanY", "getMinSpanX", "getMinSpanY", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WidgetDefinitionMetadata {
    private final String appletId;
    private final int minSpanX;
    private final int minSpanY;
    private final int previewRes;
    private final String previewUri;
    private final int spanX;
    private final int spanY;
    private final String widgetId;

    public WidgetDefinitionMetadata(String r5, String r10, String r11, int r12, int r13, int r14, int r15, int r16) {
        Intrinsics.checkNotNullParameter(r5, "appletId");
        Intrinsics.checkNotNullParameter(r10, "widgetId");
        this.appletId = r5;
        this.widgetId = r10;
        this.previewUri = r11;
        this.previewRes = r12;
        this.spanX = r13;
        this.spanY = r14;
        this.minSpanX = r15;
        this.minSpanY = r16;
    }

    public static /* synthetic */ WidgetDefinitionMetadata copy$default(WidgetDefinitionMetadata r10, String r11, String r12, String r13, int r14, int r15, int r16, int r17, int r18, int r19, Object r110) {
        if ((r19 & 1) == 0) goto L5;
        String r5 = r10.appletId;
    L7:
        if ((r19 & 2) == 0) goto L9;
        String r20 = r10.widgetId;
    L11:
        if ((r19 & 4) == 0) goto L13;
        String r21 = r10.previewUri;
    L15:
        if ((r19 & 8) == 0) goto L17;
        int r22 = r10.previewRes;
    L19:
        if ((r19 & 16) == 0) goto L21;
        int r23 = r10.spanX;
    L23:
        if ((r19 & 32) == 0) goto L25;
        int r24 = r10.spanY;
    L27:
        if ((r19 & 64) == 0) goto L29;
        int r25 = r10.minSpanX;
    L31:
        if ((r19 & 128) == 0) goto L33;
        int r26 = r10.minSpanY;
    L35:
        return r10.copy(r5, r20, r21, r22, r23, r24, r25, r26);
    L33:
        r26 = r18;
        goto L35
    L29:
        r25 = r17;
        goto L31
    L25:
        r24 = r16;
        goto L27
    L21:
        r23 = r15;
        goto L23
    L17:
        r22 = r14;
        goto L19
    L13:
        r21 = r13;
        goto L15
    L9:
        r20 = r12;
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
        return this.previewUri;
    }

    public final int component4() {
        return this.previewRes;
    }

    public final int component5() {
        return this.spanX;
    }

    public final int component6() {
        return this.spanY;
    }

    public final int component7() {
        return this.minSpanX;
    }

    public final int component8() {
        return this.minSpanY;
    }

    public final WidgetDefinitionMetadata copy(String r11, String r12, String r13, int r14, int r15, int r16, int r17, int r18) {
        Intrinsics.checkNotNullParameter(r11, "appletId");
        Intrinsics.checkNotNullParameter(r12, "widgetId");
        return new WidgetDefinitionMetadata(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WidgetDefinitionMetadata) == true) goto L8;
        return false;
    L8:
        WidgetDefinitionMetadata r10 = (WidgetDefinitionMetadata) r5;
        if (Intrinsics.areEqual(this.appletId, r10.appletId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.widgetId, r10.widgetId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.previewUri, r10.previewUri) == true) goto L18;
        return false;
    L18:
        if (this.previewRes == r10.previewRes) goto L21;
        return false;
    L21:
        if (this.spanX == r10.spanX) goto L24;
        return false;
    L24:
        if (this.spanY == r10.spanY) goto L27;
        return false;
    L27:
        if (this.minSpanX == r10.minSpanX) goto L30;
        return false;
    L30:
        if (this.minSpanY == r10.minSpanY) goto L32;
        return false;
    L32:
        return true;
    }

    public final String getAppletId() {
        return this.appletId;
    }

    public final int getMinSpanX() {
        return this.minSpanX;
    }

    public final int getMinSpanY() {
        return this.minSpanY;
    }

    public final int getPreviewRes() {
        return this.previewRes;
    }

    public final String getPreviewUri() {
        return this.previewUri;
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
        int r5 = androidx.constraintlayout.motion.widget.a.c(this.appletId.hashCode() * 31, 31, this.widgetId);
        String r10 = this.previewUri;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = (r5 + r11) * 31;
        int r13 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.previewRes, r12, 31);
        int r14 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.spanX, r13, 31);
        int r15 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.spanY, r14, 31);
        int r16 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.minSpanX, r15, 31);
        return Integer.hashCode(this.minSpanY) + r16;
    L5:
        r11 = r10.hashCode();
        goto L6
    }

    public String toString() {
        String r5 = this.appletId;
        String r10 = this.widgetId;
        String r11 = this.previewUri;
        int r12 = this.previewRes;
        int r13 = this.spanX;
        int r14 = this.spanY;
        int r15 = this.minSpanX;
        int r16 = this.minSpanY;
        StringBuilder r17 = androidx.constraintlayout.motion.widget.a.y("WidgetDefinitionMetadata(appletId=", r5, ", widgetId=", r10, ", previewUri=");
        r17.append(r11);
        r17.append(", previewRes=");
        r17.append(r12);
        r17.append(", spanX=");
        androidx.room.jarjarred.org.antlr.runtime.a.C(r17, r13, ", spanY=", r14, ", minSpanX=");
        r17.append(r15);
        r17.append(", minSpanY=");
        r17.append(r16);
        r17.append(")");
        return r17.toString();
    }

    public /* synthetic */ WidgetDefinitionMetadata(String r11, String r12, String r13, int r14, int r15, int r16, int r17, int r18, int r19, DefaultConstructorMarker r20) {
        if ((r19 & 8) == 0) goto L5;
        int r5 = 0;
    L6:
        this(r11, r12, r13, r5, r15, r16, r17, r18);
        return;
    L5:
        r5 = r14;
        goto L6
    }
}
