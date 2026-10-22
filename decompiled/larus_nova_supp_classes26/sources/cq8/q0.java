package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class q0 extends a0 {
    public final String c;
    public final z d;
    public final String e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof q0) == true) goto L8;
        return false;
    L8:
        q0 r6 = (q0) r5;
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.c.hashCode() * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public final String toString() {
        return "StubDescriptor(widgetId=" + this.c + ", actionChannel=" + this.d + ", version=" + this.e + ')';
    }

    @Override // cq8.a0
    public final String a() {
        return this.e;
    }

    public q0(String r3, com.larus.bmhome.instruction.core.impl.base.b.C0015b r4) {
        String r0 = a0.a.a();
        Intrinsics.checkNotNullParameter(r3, "widgetId");
        Intrinsics.checkNotNullParameter(r4, "actionChannel");
        Intrinsics.checkNotNullParameter(r0, "version");
        super("StubDescriptor");
        this.c = r3;
        this.d = r4;
        this.e = r0;
    }
}
