package te;

import ge.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pe.e1;
import xd.j;

/* JADX INFO: loaded from: classes2.dex */
public final class g<T> extends ce.c implements se.d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final se.d<T> f12394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ae.f f12395b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f12396m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ae.f f12397n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ae.d<? super j> f12398o;

    public g(ae.f r8) {
        super(d.f12391a, ae.g.f354a);
        this.f12394a = null;
        this.f12395b = r8;
        this.f12396m = ((Number) r8.B(0, f.f12393a)).intValue();
    }

    @Override // se.d
    public final Object e(T r8, ae.d<? super j> r10) {
        Object r11 = g(r10, r8);     // Catch: Throwable -> L8
        if (r11 != be.a.f3165a) goto L7;
        return r11;
    L7:
        return j.f13877a;
    L8:
        th = move-exception;
        this.f12397n = new c(r10.getContext(), th);
        throw th;
    }

    public final Object g(ae.d<? super j> r19, T r20) {
        ae.f r8 = r19.getContext();
        e1 r10 = (e1) r8.q0(e1.b.f10008a);
        if (r10 != null) goto L5;
    L9:
        ae.f r11 = this.f12397n;
        if (r11 != r8) goto L12;
    L81:
        this.f12398o = r19;
        q<se.d<Object>, Object, ae.d<? super j>, Object> r12 = h.f12399a;
        se.d<T> r13 = this.f12394a;
        he.i.d(r13, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        Object r14 = r12.invoke(r13, r20, this);
        if (he.i.a(r14, be.a.f3165a) == true) goto L84;
        this.f12398o = null;
    L84:
        return r14;
    L12:
        if ((r11 instanceof c) == false) goto L77;
        String r15 = "\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + ((c) r11).f12389a + ", but then emission attempt of value '" + r20 + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ";
        he.i.f(r15, "<this>");
        List r16 = me.c.i1(new me.f(ne.j.C0(r15, new String[]{"\r\n", "\n", "\r"}, false, 0), new ne.i(r15)));
        ArrayList r17 = new ArrayList();
        Iterator<T> r18 = r16.iterator();
    L15:
        if (r18.hasNext() == false) goto L19;
        T r21 = r18.next();
        if ((true ^ ne.g.s0((String) r21)) == false) goto L15;
        r17.add(r21);
        goto L15
    L19:
        ArrayList r22 = new ArrayList(yd.f.f1(r17));
        Iterator r23 = r17.iterator();
    L21:
        if (r23.hasNext() == false) goto L33;
        String r24 = (String) r23.next();
        int r110 = r24.length();
        int r111 = 0;
    L24:
        if (r111 >= r110) goto L29;
        if ((!l6.a.i0(r24.charAt(r111))) == true) goto L30;
        r111 = r111 + 1;
    L30:
        if (r111 != (-1)) goto L32;
        r111 = r24.length();
    L32:
        r22.add(Integer.valueOf(r111));
        goto L21
    L29:
        r111 = -1;
        goto L30
    L33:
        Iterator r25 = r22.iterator();
        if (r25.hasNext() == true) goto L36;
        Comparable r26 = null;
    L42:
        Integer r27 = (Integer) r26;
        if (r27 == null) goto L45;
        int r28 = r27.intValue();
    L46:
        int r29 = (r16.size() * 0) + r15.length();
        int r30 = l6.a.O(r16);
        ArrayList r112 = new ArrayList();
        Iterator<T> r31 = r16.iterator();
        int r32 = 0;
    L48:
        if (r31.hasNext() == false) goto L74;
        T r113 = r31.next();
        int r114 = r32 + 1;
        if (r32 < 0) goto L72;
        String r115 = (String) r113;
        if (r32 == 0) goto L55;
        if (r32 == r30) goto L55;
    L57:
        he.i.f(r115, "<this>");
        if (r28 < 0) goto L60;
        boolean r33 = true;
    L61:
        if (r33 == false) goto L71;
        int r34 = r115.length();
        if (r28 > r34) goto L66;
        r34 = r28;
    L66:
        String r35 = r115.substring(r34);
        he.i.e(r35, "this as java.lang.String).substring(startIndex)");
        String r36 = (String) ne.b.f9542a.invoke(r35);
    L67:
        if (r36 == null) goto L69;
        r112.add(r36);
    L69:
        r32 = r114;
        goto L48
    L71:
        throw new IllegalArgumentException(android.aimedia.a.c("Requested character count ", r28, " is less than zero.").toString());
    L60:
        r33 = false;
    L55:
        if (ne.g.s0(r115) == false) goto L57;
        r36 = null;
        goto L67
    L72:
        l6.a.T0();
        throw null;
    L74:
        StringBuilder r37 = new StringBuilder(r29);
        yd.i.i1(r112, r37, "\n", "", "", -1, "...", null);
        String r38 = r37.toString();
        he.i.e(r38, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        throw new IllegalStateException(r38.toString());
    L45:
        r28 = 0;
        goto L46
    L36:
        r26 = (Comparable) r25.next();
    L38:
        if (r25.hasNext() == false) goto L42;
        Comparable r39 = (Comparable) r25.next();
        if (r26.compareTo(r39) <= 0) goto L38;
        r26 = r39;
        goto L38
    L77:
        if (((Number) r8.B(0, new i(this))).intValue() != this.f12396m) goto L80;
        this.f12397n = r8;
        goto L81
    L80:
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + this.f12395b + ",\n\t\tbut emission happened in " + r8 + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    L5:
        if (r10.a() == true) goto L9;
        throw r10.k();
    }

    @Override // ce.a, ce.d
    public final ce.d getCallerFrame() {
        ae.d<? super j> r8 = this.f12398o;
        if ((r8 instanceof ce.d) == true) goto L7;
        return null;
    L7:
        return (ce.d) r8;
    }

    @Override // ce.c, ae.d
    public final ae.f getContext() {
        ae.f r8 = this.f12397n;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return ae.g.f354a;
    }

    @Override // ce.a
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // ce.a
    public final Object invokeSuspend(Object r8) {
        Throwable r10 = xd.e.a(r8);
        if (r10 == null) goto L5;
        this.f12397n = new c(getContext(), r10);
    L5:
        ae.d<? super j> r11 = this.f12398o;
        if (r11 == null) goto L9;
        r11.resumeWith(r8);
    L9:
        return be.a.f3165a;
    }

    @Override // ce.c, ce.a
    public final void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
