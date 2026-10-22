package obric.flow.miniappwidget;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f20471c;

    public d(String r5, String r10, String r11) {
        this.f20469a = r5;
        this.f20470b = r10;
        this.f20471c = r11;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r10 = (d) r5;
        String r11 = r10.f20469a;
        if (Intrinsics.areEqual(this.f20469a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f20470b, r10.f20470b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f20471c, r10.f20471c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(null, null) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(null, null) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r5 = 0;
        String r10 = this.f20469a;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        String r13 = this.f20470b;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f20471c;
        if (r16 == null) goto L15;
        r5 = r16.hashCode();
    L15:
        return (r15 + r5) * 961;
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r10.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("MiniAppWidgetComponentData(appletId=");
        r5.append(this.f20469a);
        r5.append(", widgetId=");
        r5.append(this.f20470b);
        r5.append(", definitionId=");
        return j0.q(r5, this.f20471c, ", spanX=null, spanY=null)");
    }
}
