package ou1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import ju1.h;
import ju1.n;
import ju1.o;
import ju1.p;
import ju1.q;
import ju1.r;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements nu1.f<q> {
    public final nu1.b a;

    public static final class a {
    }

    static {
    }

    public g() {
        nu1.a r0 = nu1.a.a;
        Intrinsics.checkNotNullParameter(r0, "expressionExecutor");
        this.a = r0;
    }

    @Override // nu1.f
    public final n a(h r9, Map r10) {
        q r11 = (q) r9;
        Intrinsics.checkNotNullParameter(r11, "strategy");
        Intrinsics.checkNotNullParameter(r10, "stateMap");
        ArrayList r0 = new ArrayList();
        Iterator<T> r1 = r11.j().iterator();
        float r2 = 0.0f;
        float r3 = 0.0f;
    L4:
        if (r1.hasNext() == false) goto L9;
        o r4 = (o) r1.next();
        if (Intrinsics.areEqual(this.a.a(r4.a(), r10), Boolean.TRUE) == false) goto L4;
        r3 = r3 + (r4.b() * r4.c());
        r2 = r2 + r4.c();
        r0.add(r4);
        goto L4
    L9:
        if (r0.isEmpty() == true) goto L31;
        if (r2 <= 0) goto L31;
        float r5 = r3 / r2;
        Iterator<T> r6 = r11.k().iterator();
    L15:
        if (r6.hasNext() == false) goto L22;
        Object r7 = r6.next();
        if (r5 < ((p) r7).b()) goto L19;
        boolean r8 = true;
    L20:
        if (r8 == false) goto L15;
    L23:
        p r12 = (p) r7;
        if (r12 == null) goto L26;
        Integer r13 = Integer.valueOf(r12.a());
    L27:
        if (r13 != null) goto L43;
        return new r(r11.g(), true, r10, null);
    L43:
        return new r(r13.intValue(), false, r10, r0);
    L26:
        r13 = null;
        goto L27
    L19:
        r8 = false;
        goto L20
    L22:
        r7 = null;
    L31:
        return new r(r11.g(), true, r10, null);
    }
}
