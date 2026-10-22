package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n.h<RecyclerView.c0, a> f2428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n.e<RecyclerView.c0> f2429b;

    public static class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final i0.d f2430d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2431a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView.l.c f2432b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public RecyclerView.l.c f2433c;

        static {
            f2430d = new i0.d(20);
        }

        public a() {
        }

        public static a a() {
            a r8 = (a) f2430d.a();
            if (r8 == null) goto L5;
            return r8;
        L5:
            return new a();
        }
    }

    public interface b {
    }

    public a0() {
        this.f2428a = new n.h();
        this.f2429b = new n.e();
    }

    public final void a(RecyclerView.c0 r8, RecyclerView.l.c r10) {
        n.h<RecyclerView.c0, a> r11 = this.f2428a;
        a r12 = r11.getOrDefault(r8, null);
        if (r12 != null) goto L5;
        r12 = a.a();
        r11.put(r8, r12);
    L5:
        r12.f2433c = r10;
        r12.f2431a |= 8;
    }

    public final RecyclerView.l.c b(RecyclerView.c0 r8, int r10) {
        n.h<RecyclerView.c0, a> r11 = this.f2428a;
        int r12 = r11.f(r8);
        if (r12 >= 0) goto L5;
        return null;
    L5:
        a r13 = r11.k(r12);
        if (r13 == null) goto L21;
        int r14 = r13.f2431a;
        if ((r14 & r10) == 0) goto L21;
        int r15 = r14 & (~r10);
        r13.f2431a = r15;
        if (r10 != 4) goto L13;
        RecyclerView.l.c r16 = r13.f2432b;
    L16:
        if ((r15 & 12) != 0) goto L18;
        r11.j(r12);
        r13.f2431a = 0;
        r13.f2432b = null;
        r13.f2433c = null;
        a.f2430d.b(r13);
    L18:
        return r16;
    L13:
        if (r10 != 8) goto L20;
        r16 = r13.f2433c;
        goto L16
    L20:
        throw new IllegalArgumentException("Must provide flag PRE or POST");
    L21:
        return null;
    }

    public final void c(RecyclerView.c0 r8) {
        a r10 = this.f2428a.getOrDefault(r8, null);
        if (r10 != null) goto L5;
        return;
    L5:
        r10.f2431a &= -2;
    }

    public final void d(RecyclerView.c0 r8) {
        n.e<RecyclerView.c0> r10 = this.f2429b;
        if (r10.f9371a == false) goto L5;
        r10.c();
    L5:
        int r11 = r10.f9374n - 1;
    L6:
        if (r11 < 0) goto L13;
        if (r8 == r10.h(r11)) goto L9;
        r11 = r11 - 1;
        goto L6
    L9:
        Object[] r12 = r10.f9373m;
        Object r13 = r12[r11];
        Object r14 = n.e.f9370o;
        if (r13 == r14) goto L13;
        r12[r11] = r14;
        r10.f9371a = true;
    L13:
        a r15 = this.f2428a.remove(r8);
        if (r15 == null) goto L19;
        r15.f2431a = 0;
        r15.f2432b = null;
        r15.f2433c = null;
        a.f2430d.b(r15);
        return;
    }
}
