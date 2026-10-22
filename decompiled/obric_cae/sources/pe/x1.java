package pe;

/* JADX INFO: loaded from: classes2.dex */
public final class x1 {

    @ce.e(c = "kotlinx.coroutines.TimeoutKt", f = "Timeout.kt", l = {104}, m = "withTimeoutOrNull")
    public static final class a<T> extends ce.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ge.p f10086a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public he.o f10087b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public /* synthetic */ Object f10088m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f10089n;

        @Override // ce.a
        public final Object invokeSuspend(Object r8) {
            this.f10088m = r8;
            this.f10089n |= Integer.MIN_VALUE;
            return x1.b(0, null, this);
        }
    }

    public static final <U, T extends U> Object a(w1<U, ? super T> r8, ge.p<? super z, ? super ae.d<? super T>, ? extends Object> r10) {
        r8.i(new q0(j0.b(r8.f12625n.getContext()).V(r8.f10083o, r8, r8.f9991m)));
        boolean r11 = false;
        he.r.a(2, r10);     // Catch: Throwable -> L5
        Object r12 = r10.invoke(r8, r8);     // Catch: Throwable -> L5
    L7:
        be.a r13 = be.a.f3165a;
        if (r12 == r13) goto L32;
        Object r14 = r8.L(r12);
        if (r14 != k1.f10034b) goto L14;
        return r13;
    L14:
        if ((r14 instanceof o) == false) goto L27;
        Throwable r15 = ((o) r14).f10052a;
        if ((r15 instanceof v1) == true) goto L18;
    L19:
        r11 = true;
    L20:
        if (r11 == false) goto L22;
        throw r15;
    L22:
        if ((r12 instanceof o) == false) goto L29;
        throw ((o) r12).f10052a;
    L29:
        return r12;
    L18:
        if (((v1) r15).f10079a == r8) goto L20;
    L27:
        r12 = k1.a(r14);
        goto L29
    L32:
        return r13;
    L5:
        th = move-exception;
        r12 = new o(false, th);
        goto L7
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, pe.w1] */
    public static final <T> Object b(long r8, ge.p<? super z, ? super ae.d<? super T>, ? extends Object> r10, ae.d<? super T> r11) {
        if ((r11 instanceof a) == false) goto L7;
        a r12 = (a) r11;
        int r13 = r12.f10089n;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.f10089n = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.f10088m;
        be.a r15 = be.a.f3165a;
        int r16 = r12.f10089n;
        if (r16 == 0) goto L18;
        if (r16 != 1) goto L17;
        he.o r17 = r12.f10087b;
        defpackage.c.m0(r14);     // Catch: v1 -> L14
    L25:
        return r14;
    L14:
        v1 e10 = e;
    L29:
        if (e10.f10079a != r17.f8064a) goto L31;
        return null;
    L31:
        throw e10;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        defpackage.c.m0(r14);
        if (r8 > 0) goto L21;
        return null;
    L21:
        he.o r18 = new he.o();
        r12.f10086a = r10;     // Catch: v1 -> L26
        r12.f10087b = r18;     // Catch: v1 -> L26
        r12.f10089n = 1;     // Catch: v1 -> L26
        ?? r19 = (T) new w1(r8, r12);
        r18.f8064a = r19;     // Catch: v1 -> L26
        r14 = a(r19, r10);     // Catch: v1 -> L26
        if (r14 != r15) goto L25;
        return r15;
    L26:
        e = move-exception;
        e10 = e;
        r17 = r18;
    L7:
        r12 = new a(r11);
        goto L8
    }
}
