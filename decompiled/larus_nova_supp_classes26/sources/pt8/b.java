package pt8;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b implements ot8.a {
    public final int a;
    public final boolean b;
    public final String c;
    public final String d;
    public final Integer e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final Function1<Boolean, Unit> i;

    public b() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        String r4 = this.c;
        int r5 = 0;
        if (r4 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r3 + r6) * 31;
        String r8 = this.d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Integer r11 = this.e;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        if (this.f == false) goto L21;
        int r14 = 1231;
    L22:
        int r15 = (r13 + r14) * 31;
        if (this.g == false) goto L25;
        int r16 = 1231;
    L26:
        int r17 = (r15 + r16) * 31;
        if (this.h == true) goto L30;
        r2 = 1237;
    L30:
        int r18 = (r17 + r2) * 31;
        Function1<Boolean, Unit> r19 = this.i;
        if (r19 == null) goto L35;
        r5 = r19.hashCode();
    L35:
        return r18 + r5;
    L25:
        r16 = 1237;
        goto L26
    L21:
        r14 = 1237;
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r4.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "WidgetCardMenu(id=" + this.a + ", removeAroundDivider=" + this.b + ", textString=" + this.c + ", iconUrl=" + this.d + ", textColor=" + this.e + ", isSelected=" + this.f + ", forbiddenDismissAfterClick=" + this.g + ", disableClick=" + this.h + ", onTap=" + this.i + ')';
    }

    @Override // ot8.a
    public final boolean a() {
        return this.b;
    }

    @Override // ot8.a
    public final int getId() {
        return this.a;
    }

    public b(int r1, String r2, String r3, Integer r4, boolean r5, boolean r6, Function1 r7) {
        this.a = r1;
        this.b = false;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = false;
        this.g = r5;
        this.h = r6;
        this.i = r7;
    }
}
