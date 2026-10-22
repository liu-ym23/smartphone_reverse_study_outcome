package obric.flow.miniappwidget;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f20468c;
    public final e d;
    public final Object e;

    public c(String r5, String r10, f r11, e r12) {
        Intrinsics.checkNotNullParameter(r10, "instanceId");
        Intrinsics.checkNotNullParameter(r11, "definition");
        Intrinsics.checkNotNullParameter(r12, "config");
        this.f20466a = r5;
        this.f20467b = r10;
        this.f20468c = r11;
        this.d = r12;
        this.e = null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r10 = (c) r5;
        String r11 = r10.f20466a;
        if (Intrinsics.areEqual(this.f20466a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f20467b, r10.f20467b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f20468c, r10.f20468c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r5 = 0;
        String r10 = this.f20466a;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = (this.d.hashCode() + ((this.f20468c.hashCode() + androidx.constraintlayout.motion.widget.a.c(r11 * 31, 31, this.f20467b)) * 31)) * 31;
        Object r13 = this.e;
        if (r13 == null) goto L11;
        r5 = r13.hashCode();
    L11:
        return r12 + r5;
    L5:
        r11 = r10.hashCode();
        goto L6
    }

    public final String toString() {
        return "MiniAppWidgetCardParams(cardId=" + this.f20466a + ", instanceId=" + this.f20467b + ", definition=" + this.f20468c + ", config=" + this.d + ", restoreData=" + this.e + ")";
    }
}
