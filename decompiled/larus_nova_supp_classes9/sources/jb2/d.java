package jb2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends fk6.b {
    public final String d;
    public final gk6.a e;
    public final ek6.c f;
    public final boolean g;

    public final ek6.c b() {
        return this.f;
    }

    public final String c() {
        return this.d;
    }

    public final gk6.a d() {
        return this.e;
    }

    public /* synthetic */ d(String r3, gk6.a r4, ib2.a r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r5 = null;
    L9:
        if ((r6 & 8) == 0) goto L11;
        boolean r7 = true;
    L12:
        this(r3, r4, r5, r7);
        return;
    L11:
        r7 = false;
        goto L12
    }

    public d(String r2, gk6.a r3, ek6.c r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "payload");
        super(r2, r3, r4);
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
    }
}
