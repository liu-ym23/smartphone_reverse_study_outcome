package ga;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f9015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d f9016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e f9017d;

    public c(String r10, b r11, d r12, e r13) {
        Intrinsics.checkNotNullParameter(r10, "gridMode");
        Intrinsics.checkNotNullParameter(r11, "pageColumns");
        Intrinsics.checkNotNullParameter(r12, "pageGutter");
        Intrinsics.checkNotNullParameter(r13, "pageMargin");
        this.f9014a = r10;
        this.f9015b = r11;
        this.f9016c = r12;
        this.f9017d = r13;
    }

    public final String a() {
        return this.f9014a;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof c) == false) goto L14;
        c r11 = (c) r10;
        if (Intrinsics.areEqual(this.f9014a, r11.f9014a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f9015b, r11.f9015b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f9016c, r11.f9016c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9017d, r11.f9017d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r10 = this.f9014a;
        int r11 = 0;
        if (r10 == null) goto L5;
        int r12 = r10.hashCode();
    L6:
        int r13 = r12 * 31;
        b r14 = this.f9015b;
        if (r14 == null) goto L9;
        int r15 = r14.hashCode();
    L10:
        int r16 = (r13 + r15) * 31;
        d r17 = this.f9016c;
        if (r17 == null) goto L13;
        int r18 = r17.hashCode();
    L14:
        int r19 = (r16 + r18) * 31;
        e r20 = this.f9017d;
        if (r20 == null) goto L18;
        r11 = r20.hashCode();
    L18:
        return r19 + r11;
    L13:
        r18 = 0;
        goto L14
    L9:
        r15 = 0;
        goto L10
    L5:
        r12 = 0;
        goto L6
    }

    public String toString() {
        return "PageGridConfig(gridMode=" + this.f9014a + ", pageColumns=" + this.f9015b + ", pageGutter=" + this.f9016c + ", pageMargin=" + this.f9017d + ")";
    }
}
