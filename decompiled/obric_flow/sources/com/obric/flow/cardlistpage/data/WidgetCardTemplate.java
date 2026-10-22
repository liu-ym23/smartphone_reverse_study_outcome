package com.obric.flow.cardlistpage.data;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/obric/flow/cardlistpage/data/WidgetCardTemplate;", "", "packageName", "", "className", "spanX", "", "spanY", "label", "order", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;I)V", "getClassName", "()Ljava/lang/String;", "getLabel", "getOrder", "()I", "getPackageName", "getSpanX", "getSpanY", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "CardListPage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WidgetCardTemplate {
    private final String className;
    private final String label;
    private final int order;
    private final String packageName;
    private final int spanX;
    private final int spanY;

    public WidgetCardTemplate(String r5, String r10, int r11, int r12, String r13, int r14) {
        Intrinsics.checkNotNullParameter(r5, "packageName");
        Intrinsics.checkNotNullParameter(r10, "className");
        Intrinsics.checkNotNullParameter(r13, "label");
        this.packageName = r5;
        this.className = r10;
        this.spanX = r11;
        this.spanY = r12;
        this.label = r13;
        this.order = r14;
    }

    public static /* synthetic */ WidgetCardTemplate copy$default(WidgetCardTemplate r5, String r10, String r11, int r12, int r13, String r14, int r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r10 = r5.packageName;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r11 = r5.className;
    L8:
        String r18 = r11;
        if ((r16 & 4) == 0) goto L11;
        r12 = r5.spanX;
    L11:
        int r19 = r12;
        if ((r16 & 8) == 0) goto L14;
        r13 = r5.spanY;
    L14:
        int r20 = r13;
        if ((r16 & 16) == 0) goto L17;
        r14 = r5.label;
    L17:
        String r21 = r14;
        if ((r16 & 32) == 0) goto L20;
        r15 = r5.order;
    L20:
        String r22 = r10;
        return r5.copy(r22, r18, r19, r20, r21, r15);
    }

    public final String component1() {
        return this.packageName;
    }

    public final String component2() {
        return this.className;
    }

    public final int component3() {
        return this.spanX;
    }

    public final int component4() {
        return this.spanY;
    }

    public final String component5() {
        return this.label;
    }

    public final int component6() {
        return this.order;
    }

    public final WidgetCardTemplate copy(String r10, String r11, int r12, int r13, String r14, int r15) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r11, "className");
        Intrinsics.checkNotNullParameter(r14, "label");
        return new WidgetCardTemplate(r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WidgetCardTemplate) == true) goto L8;
        return false;
    L8:
        WidgetCardTemplate r10 = (WidgetCardTemplate) r5;
        if (Intrinsics.areEqual(this.packageName, r10.packageName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.className, r10.className) == true) goto L15;
        return false;
    L15:
        if (this.spanX == r10.spanX) goto L18;
        return false;
    L18:
        if (this.spanY == r10.spanY) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.label, r10.label) == true) goto L24;
        return false;
    L24:
        if (this.order == r10.order) goto L26;
        return false;
    L26:
        return true;
    }

    public final String getClassName() {
        return this.className;
    }

    public final String getLabel() {
        return this.label;
    }

    public final int getOrder() {
        return this.order;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final int getSpanX() {
        return this.spanX;
    }

    public final int getSpanY() {
        return this.spanY;
    }

    public int hashCode() {
        int r5 = androidx.constraintlayout.motion.widget.a.c(this.packageName.hashCode() * 31, 31, this.className);
        int r10 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.spanX, r5, 31);
        int r11 = androidx.constraintlayout.motion.widget.a.c(androidx.room.jarjarred.org.antlr.runtime.a.c(this.spanY, r10, 31), 31, this.label);
        return Integer.hashCode(this.order) + r11;
    }

    public String toString() {
        String r5 = this.packageName;
        String r10 = this.className;
        int r11 = this.spanX;
        int r12 = this.spanY;
        String r13 = this.label;
        int r14 = this.order;
        StringBuilder r15 = androidx.constraintlayout.motion.widget.a.y("WidgetCardTemplate(packageName=", r5, ", className=", r10, ", spanX=");
        androidx.room.jarjarred.org.antlr.runtime.a.C(r15, r11, ", spanY=", r12, ", label=");
        r15.append(r13);
        r15.append(", order=");
        r15.append(r14);
        r15.append(")");
        return r15.toString();
    }
}
