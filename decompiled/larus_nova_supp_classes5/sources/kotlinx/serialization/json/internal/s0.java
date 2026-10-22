package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import luc.e;
import luc.f;
import luc.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class s0 {
    public static final f a(f r3, kotlinx.serialization.modules.d r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "module");
        if (Intrinsics.areEqual(r3.getKind(), o.a.a) == false) goto L16;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r3, "descriptor");
        KClass r0 = luc.b.a(r3);
        if (r0 == null) goto L9;
        juc.d r1 = kotlinx.serialization.modules.d.c(r4, r0);
        if (r1 == null) goto L9;
        f r2 = r1.getDescriptor();
    L10:
        if (r2 == null) goto L19;
        f r5 = a(r2, r4);
        if (r5 != null) goto L20;
        return r3;
    L20:
        return r5;
    L19:
        return r3;
    L9:
        r2 = null;
        goto L10
    L16:
        if (r3.isInline() == true) goto L18;
        return r3;
    L18:
        return a(r3.h(0), r4);
    }

    public static final WriteMode b(ouc.a r2, f r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "desc");
        o r0 = r3.getKind();
        if ((r0 instanceof luc.d) == false) goto L6;
        return WriteMode.POLY_OBJ;
    L6:
        if (Intrinsics.areEqual(r0, luc.p.b.a) == false) goto L9;
        return WriteMode.LIST;
    L9:
        if (Intrinsics.areEqual(r0, luc.p.c.a) == false) goto L22;
        f r4 = a(r3.h(0), r2.b);
        o r1 = r4.getKind();
        if ((r1 instanceof e) == true) goto L26;
        if (Intrinsics.areEqual(r1, o.b.a) == true) goto L26;
        if (r2.a.d == false) goto L19;
        return WriteMode.LIST;
    L19:
        throw s.b(r4);
    L26:
        return WriteMode.MAP;
    L22:
        return WriteMode.OBJ;
    }
}
