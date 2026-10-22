package obric.flow.miniappwidget;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f20507c;
    public final String d;

    public n(String r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "appletId");
        Intrinsics.checkNotNullParameter(r10, "widgetId");
        this.f20505a = r5;
        this.f20506b = r10;
        this.f20507c = null;
        this.d = r11;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof n) == true) goto L8;
        return false;
    L8:
        n r10 = (n) r5;
        String r11 = r10.f20505a;
        if (Intrinsics.areEqual(this.f20505a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f20506b, r10.f20506b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f20507c, r10.f20507c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r5 = androidx.constraintlayout.motion.widget.a.c(this.f20505a.hashCode() * 31, 31, this.f20506b);
        int r10 = 0;
        Long r11 = this.f20507c;
        if (r11 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (r5 + r12) * 31;
        String r14 = this.d;
        if (r14 == null) goto L11;
        r10 = r14.hashCode();
    L11:
        return r13 + r10;
    L5:
        r12 = r11.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("MiniAppWidgetRuntimeCheckRequest(appletId=");
        r5.append(this.f20505a);
        r5.append(", widgetId=");
        r5.append(this.f20506b);
        r5.append(", preferredVersion=");
        r5.append(this.f20507c);
        r5.append(", definitionId=");
        return j0.q(r5, this.d, ")");
    }
}
