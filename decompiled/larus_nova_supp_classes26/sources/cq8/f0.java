package cq8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f0 extends a0 {
    public final String c;
    public final z d;
    public final String e;
    public final List<g0> f;
    public final String g;
    public final boolean h;
    public final List<y0> i;

    public f0() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f0) == true) goto L8;
        return false;
    L8:
        f0 r6 = (f0) r5;
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
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.c.hashCode() * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        String r1 = this.g;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r0 + r2) * 31;
        if (this.h == false) goto L9;
        int r4 = 1231;
    L11:
        return ((r3 + r4) * 31) + this.i.hashCode();
    L9:
        r4 = 1237;
        goto L11
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MenuTabContainerDescriptor(widgetId=" + this.c + ", actionChannel=" + this.d + ", version=" + this.e + ", tabs=" + this.f + ", subTitle=" + this.g + ", enableBottomLine=" + this.h + ", childWidgetEntry=" + this.i + ')';
    }

    @Override // cq8.a0
    public final String a() {
        return this.e;
    }

    public f0(String r3, com.larus.bmhome.instruction.core.impl.base.b.C0015b r4, List r5, String r6, boolean r7, List r8) {
        String r0 = a0.a.a();
        Intrinsics.checkNotNullParameter(r3, "widgetId");
        Intrinsics.checkNotNullParameter(r4, "actionChannel");
        Intrinsics.checkNotNullParameter(r0, "version");
        Intrinsics.checkNotNullParameter(r5, "tabs");
        Intrinsics.checkNotNullParameter(r8, "childWidgetEntry");
        super("MenuTabContainerDescriptor");
        this.c = r3;
        this.d = r4;
        this.e = r0;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
    }
}
