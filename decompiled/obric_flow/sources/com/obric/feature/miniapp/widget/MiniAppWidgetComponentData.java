package com.obric.feature.miniapp.widget;

import ai.j0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/obric/feature/miniapp/widget/MiniAppWidgetComponentData;", "", "appletId", "", "widgetId", "definitionId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppletId", "()Ljava/lang/String;", "getDefinitionId", "getWidgetId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "MiniAppWidgetHost_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MiniAppWidgetComponentData {
    private final String appletId;
    private final String definitionId;
    private final String widgetId;

    public MiniAppWidgetComponentData(String r5, String r10, String r11) {
        this.appletId = r5;
        this.widgetId = r10;
        this.definitionId = r11;
    }

    public static /* synthetic */ MiniAppWidgetComponentData copy$default(MiniAppWidgetComponentData r5, String r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = r5.appletId;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.widgetId;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = r5.definitionId;
    L12:
        return r5.copy(r10, r11, r12);
    }

    public final String component1() {
        return this.appletId;
    }

    public final String component2() {
        return this.widgetId;
    }

    public final String component3() {
        return this.definitionId;
    }

    public final MiniAppWidgetComponentData copy(String r5, String r10, String r11) {
        return new MiniAppWidgetComponentData(r5, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MiniAppWidgetComponentData) == true) goto L8;
        return false;
    L8:
        MiniAppWidgetComponentData r10 = (MiniAppWidgetComponentData) r5;
        if (Intrinsics.areEqual(this.appletId, r10.appletId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.widgetId, r10.widgetId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.definitionId, r10.definitionId) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getAppletId() {
        return this.appletId;
    }

    public final String getDefinitionId() {
        return this.definitionId;
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
        int r15 = (r12 + r14) * 31;
        String r16 = this.definitionId;
        if (r16 == null) goto L15;
        r10 = r16.hashCode();
    L15:
        return r15 + r10;
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
        String r11 = this.definitionId;
        return j0.q(androidx.constraintlayout.motion.widget.a.y("MiniAppWidgetComponentData(appletId=", r5, ", widgetId=", r10, ", definitionId="), r11, ")");
    }
}
