package obric.flow.miniappwidget;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MiniAppWidgetRuntimeValidity f20508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f20510c;
    public final String d;
    public final boolean e;

    static {
    }

    public o(MiniAppWidgetRuntimeValidity r5, String r10, String r11, String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r5, "validity");
        this.f20508a = r5;
        this.f20509b = r10;
        this.f20510c = r11;
        this.d = r12;
        this.e = r13;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof o) == true) goto L8;
        return false;
    L8:
        o r10 = (o) r5;
        MiniAppWidgetRuntimeValidity r11 = r10.f20508a;
        if (this.f20508a == r11) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f20509b, r10.f20509b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f20510c, r10.f20510c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f20508a.hashCode() * 31;
        int r10 = 0;
        String r11 = this.f20509b;
        if (r11 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (r5 + r12) * 31;
        String r14 = this.f20510c;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.d;
        if (r17 == null) goto L15;
        r10 = r17.hashCode();
    L15:
        return Boolean.hashCode(this.e) + ((r16 + r10) * 31);
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r11.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("MiniAppWidgetRuntimeCheckResult(validity=");
        r5.append(this.f20508a);
        r5.append(", installState=");
        r5.append(this.f20509b);
        r5.append(", errorCode=");
        r5.append(this.f20510c);
        r5.append(", errorMessage=");
        r5.append(this.d);
        r5.append(", retryable=");
        return j0.r(r5, this.e, ")");
    }
}
