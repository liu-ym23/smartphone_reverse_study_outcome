package cq8;

import com.larus.bmhome.actionbar.model.b0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class l0 extends a0 {
    public final String c;
    public final z d;
    public final String e;
    public final String f;
    public final Integer g;
    public final boolean h;
    public final b0 i;
    public final int j;
    public final List<y0> k;

    public l0() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof l0) == true) goto L8;
        return false;
    L8:
        l0 r6 = (l0) r5;
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L24;
        return false;
    L24:
        if (this.h == r6.h) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L30;
        return false;
    L30:
        if (this.j == r6.j) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.c.hashCode() * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        String r1 = this.f;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Integer r5 = this.g;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        if (this.h == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (r7 + r8) * 31;
        b0 r10 = this.i;
        if (r10 == null) goto L19;
        r2 = r10.hashCode();
    L19:
        return ((((r9 + r2) * 31) + this.j) * 31) + this.k.hashCode();
    L13:
        r8 = 1237;
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MultiSelectorDescriptor(widgetId=" + this.c + ", actionChannel=" + this.d + ", version=" + this.e + ", subTitle=" + this.f + ", marginTop=" + this.g + ", enableBottomLine=" + this.h + ", template=" + this.i + ", instructionType=" + this.j + ", childWidgetEntry=" + this.k + ')';
    }

    @Override // cq8.a0
    public final String a() {
        return this.e;
    }

    public l0(String r3, com.larus.bmhome.instruction.core.impl.base.b.C0015b r4, String r5, Integer r6, boolean r7, b0 r8, int r9, List r10) {
        String r0 = a0.a.a();
        Intrinsics.checkNotNullParameter(r3, "widgetId");
        Intrinsics.checkNotNullParameter(r4, "actionChannel");
        Intrinsics.checkNotNullParameter(r0, "version");
        Intrinsics.checkNotNullParameter(r10, "childWidgetEntry");
        super("MultiSelectorDescriptor");
        this.c = r3;
        this.d = r4;
        this.e = r0;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
        this.j = r9;
        this.k = r10;
    }
}
