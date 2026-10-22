package yn0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i implements l81.i {
    public static final i a = null;

    public i() {
    }

    static {
        a = new i();
    }

    public final void a(d90.d r2, j70.f r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "layerContext");
        Intrinsics.checkNotNullParameter(r3, "elementType");
        if ((r2 instanceof d90.a) == true) goto L5;
        r2 = null;
    L5:
        d90.a r5 = (d90.a) r2;
        if (r5 == null) goto L9;
        d90.c.b(r5, r3, r4);
        return;
    }
}
