package h0c;

import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.passportc.impl.v2.entity.UpdateUserContext;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d<S, E, C, R> implements c<S, E, C, R> {
    public final e<S, E, C, R> b;
    public f<C, S, R> c;

    public d(e<S, E, C, R> r2) {
        Intrinsics.checkNotNullParameter(r2, "stateMap");
        this.b = r2;
    }

    @Override // h0c.c
    public final void b(com.ss.android.lark.passportc.impl.v2.d r2) {
        Intrinsics.checkNotNullParameter(r2, "visitor");
        this.c = r2;
    }

    @Override // h0c.c
    public final b a(UpdateUserContext r7, UserState r8, UserState r9) {
        f<C, S, R> r0 = this.c;
        if (r0 == null) goto L5;
        r0.d(r7, r8, r9);
    L5:
        ArrayList r1 = new ArrayList();
        e<S, E, C, R> r2 = this.b;
        Iterator r3 = r2.a(r8, r9, r2.a.size()).iterator();
        boolean r4 = true;
    L7:
        if (r3.hasNext() == false) goto L20;
        i0c.d r5 = (i0c.d) r3.next();
        f<C, S, R> r6 = this.c;
        if (r6 == null) goto L11;
        r6.f(r7, r5);
    L11:
        b r10 = r5.a(r7);
        f<C, S, R> r11 = this.c;
        if (r11 == null) goto L14;
        r11.s(r7, r5, r10);
    L14:
        r10.getClass();
        if ((r10 instanceof b.c) == false) goto L16;
        T r12 = r10.a;
        if (r12 == 0) goto L7;
        r1.add(r12);
        goto L7
    L16:
        r4 = false;
        goto L7
    L20:
        if (r4 == false) goto L22;
        int r13 = b.b;
        b r14 = new b.c(r1);
    L23:
        f<C, S, R> r15 = this.c;
        if (r15 == null) goto L26;
        r15.l(r7, r8, r9, r14);
    L26:
        return r14;
    L22:
        int r16 = b.b;
        r14 = new b.C0143b(r1);
        goto L23
    }
}
