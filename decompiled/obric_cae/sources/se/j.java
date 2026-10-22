package se;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import pe.e1;

/* JADX INFO: loaded from: classes2.dex */
public final class j<T> extends te.a<l> implements f<T>, c {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12126o = null;
    private volatile Object _state;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f12127n;

    static {
        f12126o = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_state");
    }

    public j(Object r8) {
        this._state = r8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v11, types: [se.d] */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6, types: [se.d] */
    /* JADX WARN: Type inference failed for: r11v7, types: [se.d] */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.util.concurrent.atomic.AtomicReferenceFieldUpdater] */
    /* JADX WARN: Type inference failed for: r14v2, types: [java.util.concurrent.atomic.AtomicReferenceFieldUpdater] */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.lang.Object, se.l] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18, types: [java.lang.Object, se.l] */
    /* JADX WARN: Type inference failed for: r5v19, types: [se.l] */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v22, types: [se.l] */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v6, types: [S extends te.b<?>[], te.b[]] */
    @Override // se.h
    public final be.a a(ua.b.C0174b.a r18, ae.d r19) {
        j<T> r8 = this;
        d r10 = r18;
        if ((r19 instanceof i) == false) goto L7;
        i r11 = (i) r19;
        int r12 = r11.f12125r;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.f12125r = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.f12123p;
        be.a r14 = be.a.f3165a;
        ?? r15 = r11.f12125r;
        if (r15 == 0) goto L28;
        if (r15 != 1) goto L116;
        l r16 = r11.f12120m;
        r10 = r11.f12119b;
        j<T> r17 = r11.f12118a;
        defpackage.c.m0(r13);     // Catch: Throwable -> L26
        r15 = r16;
        r8 = r17;
    L121:
        e1 r20 = (e1) r11.getContext().q0(e1.b.f10008a);     // Catch: Throwable -> L94
        ?? r110 = r10;
        Object r21 = null;
    L55:
        Object r111 = f12126o.get(r8);     // Catch: Throwable -> L94
        if (r20 != null) goto L58;
    L62:
        if (r21 == null) goto L66;
        r15 = r15;
        r110 = r110;
        if (he.i.a(r21, r111) == false) goto L66;
    L74:
        r15.getClass();     // Catch: Throwable -> L94
        b9.a r112 = k.f12128a;     // Catch: Throwable -> L94
        Object r113 = l.f12130a.getAndSet(r15, r112);     // Catch: Throwable -> L94
        he.i.c(r113);     // Catch: Throwable -> L94
        if (r113 != k.f12129b) goto L123;
        if (1 != 0) goto L55;
        r11.f12118a = r8;     // Catch: Throwable -> L94
        r11.f12119b = r110;     // Catch: Throwable -> L94
        r11.f12120m = r15;     // Catch: Throwable -> L94
        r11.f12121n = r20;     // Catch: Throwable -> L94
        r11.f12122o = r21;     // Catch: Throwable -> L94
        r11.f12125r = 3;     // Catch: Throwable -> L94
        pe.h r114 = new pe.h(1, l6.a.b0(r11));     // Catch: Throwable -> L94
        r114.q();     // Catch: Throwable -> L94
    L80:
        ?? r115 = l.f12130a;     // Catch: Throwable -> L94
        if (r115.compareAndSet(r15, r112, r114) == true) goto L82;
        if (r115.get(r15) == r112) goto L80;
        boolean r116 = false;
    L86:
        if (r116 == true) goto L88;
        r114.resumeWith(xd.j.f13877a);     // Catch: Throwable -> L94
    L88:
        Object r117 = r114.p();     // Catch: Throwable -> L94
        if (r117 != be.a.f3165a) goto L124;
        if (r117 != r14) goto L55;
        return r14;
    L124:
        if (xd.j.f13877a != r14) goto L55;
        goto L55
    L82:
        r116 = true;
        goto L86
    L123:
        if (0 != 0) goto L55;
    L66:
        if (r111 != te.e.f12392a) goto L68;
        Object r22 = null;
    L69:
        r11.f12118a = r8;     // Catch: Throwable -> L94
        r11.f12119b = r110;     // Catch: Throwable -> L94
        r11.f12120m = r15;     // Catch: Throwable -> L94
        r11.f12121n = r20;     // Catch: Throwable -> L94
        r11.f12122o = r111;     // Catch: Throwable -> L94
        r11.f12125r = 2;     // Catch: Throwable -> L94
        if (r110.e(r22, r11) != r14) goto L72;
        return r14;
    L72:
        r21 = r111;
        j<T> r118 = r8;
        e1 r23 = r20;
        ?? r24 = r15;
        ?? r119 = r110;
    L73:
        r20 = r23;
        r8 = r118;
        r15 = r24;
        r110 = r119;
        goto L74
    L68:
        r22 = r111;
        goto L69
    L58:
        if (r20.a() == true) goto L62;
        throw r20.k();     // Catch: Throwable -> L94
    L94:
        th = th;
    L98:
        j<T> r120 = r8;
    L99:
        monitor-enter(r120);
        int r25 = r120.f12387b - 1;     // Catch: Throwable -> L106
        r120.f12387b = r25;     // Catch: Throwable -> L106
        if (r25 != 0) goto L103;
        r120.f12388m = 0;     // Catch: Throwable -> L106
    L103:
        he.i.d(r15, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");     // Catch: Throwable -> L106
        r15.b(r120);     // Catch: Throwable -> L106
        monitor-exit(r120);
        throw th;
    L106:
        th = move-exception;
        throw th;
    L26:
        th = th;
        r15 = r16;
        r8 = r17;
        goto L98
    L116:
        if (r15 == 2) goto L18;
        if (r15 != 3) goto L17;
        r21 = r11.f12122o;
        e1 r26 = r11.f12121n;
        r15 = r11.f12120m;
        r110 = r11.f12119b;
        j<T> r121 = r11.f12118a;
        defpackage.c.m0(r13);     // Catch: Throwable -> L21
        r20 = r26;
        r8 = r121;
        goto L55
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r21 = r11.f12122o;
        r23 = r11.f12121n;
        l r27 = r11.f12120m;
        d r122 = r11.f12119b;
        r118 = r11.f12118a;
        defpackage.c.m0(r13);     // Catch: Throwable -> L21
        r24 = r27;
        r119 = r122;
    L21:
        th = th;
        goto L99
    L28:
        defpackage.c.m0(r13);
        monitor-enter(this);
        te.b[] r28 = r8.f12386a;     // Catch: Throwable -> L109
        if (r28 != null) goto L33;
        l[] r29 = new l[2];     // Catch: Throwable -> L109
        r8.f12386a = r29;     // Catch: Throwable -> L109
        te.b[] r30 = r29;
    L36:
        int r31 = r8.f12388m;     // Catch: Throwable -> L109
    L37:
        te.b r123 = r30[r31];     // Catch: Throwable -> L109
        te.b r124 = r123;
        if (r123 != null) goto L40;
        l r125 = new l();     // Catch: Throwable -> L109
        r30[r31] = r125;     // Catch: Throwable -> L109
        r124 = r125;
    L40:
        r31 = r31 + 1;     // Catch: Throwable -> L109
        if (r31 < r30.length) goto L44;
        r31 = 0;
    L44:
        if (r124.a(r8) == false) goto L37;
        r8.f12388m = r31;     // Catch: Throwable -> L109
        r8.f12387b++;     // Catch: Throwable -> L109
        monitor-exit(this);
        l r126 = (l) r124;
    L96:
        th = th;
        r15 = r126;
        goto L98
    L49:
        if ((r10 instanceof n) == false) goto L53;
        r11.f12118a = r8;     // Catch: Throwable -> L96
        r11.f12119b = r10;     // Catch: Throwable -> L96
        r11.f12120m = r126;     // Catch: Throwable -> L96
        r11.f12125r = 1;     // Catch: Throwable -> L96
        if (((n) r10).a(r11) != r14) goto L53;
        return r14;
    L53:
        r15 = r126;
        goto L121
    L33:
        int r32 = r8.f12387b;     // Catch: Throwable -> L109
        int r127 = r28.length;     // Catch: Throwable -> L109
        r30 = r28;
        if (r32 < r127) goto L36;
        Object[] r33 = Arrays.copyOf(r28, r28.length * 2);     // Catch: Throwable -> L109
        he.i.e(r33, "copyOf(this, newSize)");     // Catch: Throwable -> L109
        r8.f12386a = (te.b[]) r33;     // Catch: Throwable -> L109
        r30 = (te.b[]) r33;     // Catch: Throwable -> L109
    L109:
        th = move-exception;
        throw th;
    L7:
        r11 = new i(r8, r19);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // se.e
    public final void b(Boolean r8) {
        setValue(r8);
    }

    @Override // se.d
    public final Object e(T r8, ae.d<? super xd.j> r10) {
        setValue(r8);
        return xd.j.f13877a;
    }

    @Override // se.f
    public final void setValue(T r12) {
        if (r12 != null) goto L4;
        r12 = (T) te.e.f12392a;
    L4:
        monitor-enter(this);
        AtomicReferenceFieldUpdater r8 = f12126o;     // Catch: Throwable -> L58
        if (he.i.a(r8.get(this), r12) == false) goto L9;
    L7:
        monitor-exit(this);
        return;
    L9:
        r8.set(this, r12);     // Catch: Throwable -> L58
        int r13 = this.f12127n;     // Catch: Throwable -> L58
        if ((r13 & 1) != 0) goto L55;
        int r14 = r13 + 1;     // Catch: Throwable -> L58
        this.f12127n = r14;     // Catch: Throwable -> L58
        Object r10 = this.f12386a;     // Catch: Throwable -> L58
        xd.j r11 = xd.j.f13877a;     // Catch: Throwable -> L58
        monitor-exit(this);
    L13:
        l[] r15 = (l[]) r10;
        if (r15 == null) goto L44;
        int r16 = r15.length;
        int r17 = 0;
    L16:
        if (r17 >= r16) goto L44;
        l r18 = r15[r17];
        if (r18 == null) goto L43;
    L19:
        AtomicReferenceFieldUpdater r19 = l.f12130a;
        Object r20 = r19.get(r18);
        if (r20 == null) goto L43;
        b9.a r21 = k.f12129b;
        if (r20 == r21) goto L43;
        b9.a r22 = k.f12128a;
        if (r20 == r22) goto L28;
    L36:
        if (r19.compareAndSet(r18, r20, r22) == true) goto L37;
        if (r19.get(r18) == r20) goto L36;
        boolean r23 = false;
    L41:
        if (r23 == false) goto L19;
        ((pe.h) r20).resumeWith(xd.j.f13877a);
        goto L43
    L37:
        r23 = true;
    L28:
        if (r19.compareAndSet(r18, r20, r21) == true) goto L29;
        if (r19.get(r18) == r20) goto L28;
        boolean r24 = false;
    L33:
        if (r24 == false) goto L19;
    L29:
        r24 = true;
    L43:
        r17 = r17 + 1;
    L44:
        monitor-enter(this);
        int r25 = this.f12127n;     // Catch: Throwable -> L51
        if (r25 == r14) goto L47;
        Object r110 = this.f12386a;     // Catch: Throwable -> L51
        xd.j r26 = xd.j.f13877a;     // Catch: Throwable -> L51
        monitor-exit(this);
        r10 = r110;
        r14 = r25;
        goto L13
    L47:
        this.f12127n = r14 + 1;     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        throw th;
    L55:
        this.f12127n = r13 + 2;     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        throw th;
    }
}
