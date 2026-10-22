package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class x0 extends a0 {
    public final String c;
    public final z d;
    public final String e;
    public final com.larus.bmhome.actionbar.model.k0 f;
    public final boolean g;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof x0) == true) goto L8;
        return false;
    L8:
        x0 r6 = (x0) r5;
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
        if (this.g == r6.g) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.c.hashCode() * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        com.larus.bmhome.actionbar.model.k0 r1 = this.f;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r0 + r2) * 31;
        if (this.g == false) goto L9;
        int r4 = 1231;
    L11:
        return r3 + r4;
    L9:
        r4 = 1237;
        goto L11
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "UserMessageSenderDescriptor(widgetId=" + this.c + ", actionChannel=" + this.d + ", version=" + this.e + ", template=" + this.f + ", isMemorized=" + this.g + ')';
    }

    @Override // cq8.a0
    public final String a() {
        return this.e;
    }

    public x0(String r3, com.larus.bmhome.instruction.core.impl.base.b.C0015b r4, com.larus.bmhome.actionbar.model.k0 r5, boolean r6) {
        String r0 = a0.a.a();
        Intrinsics.checkNotNullParameter(r3, "widgetId");
        Intrinsics.checkNotNullParameter(r4, "actionChannel");
        Intrinsics.checkNotNullParameter(r0, "version");
        super("UserMessageSenderDescriptor");
        this.c = r3;
        this.d = r4;
        this.e = r0;
        this.f = r5;
        this.g = r6;
    }
}
