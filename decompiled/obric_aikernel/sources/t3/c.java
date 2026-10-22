package t3;

import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class c extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap<f, t3.a> f12928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f12929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f12930d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f f12931e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f f12932f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private HashMap<f, f> f12933g;

    private class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f12934a;

        a(c r10, int r11, int r12, long r13) {
            this.f12934a = r10;
            super(null);
        }

        @Override // t3.e
        public void a() {
        }

        @Override // t3.e
        public void b(int r10, f r11) {
            c.i(this.f12934a).a(1);
        }

        @Override // t3.e
        public void c(f r12, int r13, f r14, f r15, int r16, d[] r17, d[] r18) {
            c.i(this.f12934a).a(32);
            t3.a r10 = new t3.a(r12, r13, r14, r15, r16, r17, r18);
            c.j(this.f12934a).put(r12, r10);
        }

        @Override // t3.e
        public void d(int r10, f r11) {
            c.i(this.f12934a).a(254);
        }

        @Override // t3.e
        public void e(f r10, int r11, f r12, byte[] r13) {
            c.i(this.f12934a).a(33);
        }

        @Override // t3.e
        public void f(f r10, int r11, int r12) {
            c.i(this.f12934a).a(3);
        }

        @Override // t3.e
        public void g(f r10, int r11, int r12) {
            c.i(this.f12934a).a(2);
        }

        @Override // t3.e
        public void h(f r10, int r11, int r12) {
            c.i(this.f12934a).a(142);
        }

        @Override // t3.e
        public void i(f r10, int r11) {
            c.i(this.f12934a).a(4);
        }

        @Override // t3.e
        public void j(f r10, int r11, int r12, f r13, byte[] r14) {
            c.i(this.f12934a).a(34);
        }

        @Override // t3.e
        public void k(int r10, f r11, int r12, int r13, int r14, byte[] r15) {
            c.i(this.f12934a).a(35);
        }

        @Override // t3.e
        public void l(f r10, int r11) {
            c.i(this.f12934a).a(6);
        }

        @Override // t3.e
        public void m(f r10, int r11, int r12) {
            c.i(this.f12934a).a(8);
        }
    }

    class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        HashMap<Integer, Long> f12935a;

        b(c r10) {
            this.f12935a = new HashMap();
        }

        public void a(int r10) {
            Long r11 = this.f12935a.get(Integer.valueOf(r10));
            if (r11 != null) goto L5;
            r11 = 0L;
        L5:
            this.f12935a.put(Integer.valueOf(r10), Long.valueOf(r11.longValue() + 1));
        }

        public String toString() {
            StringBuilder r10 = new StringBuilder();
            r10.append("[");
            Iterator<Integer> r11 = this.f12935a.keySet().iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            int r12 = r11.next().intValue();
            r10.append(String.format("k=%x v=%d,", new Object[]{Integer.valueOf(r12), this.f12935a.get(Integer.valueOf(r12))}));
            goto L4
        L6:
            r10.append("]");
            return r10.toString();
        }
    }

    public c() {
        super(null);
        this.f12928b = new HashMap();
        this.f12929c = new b(this);
        this.f12930d = new b(this);
        this.f12931e = null;
        this.f12932f = null;
        this.f12933g = null;
        this.f12933g = new HashMap();
    }

    static /* synthetic */ b i(c r10) {
        return r10.f12930d;
    }

    static /* synthetic */ HashMap j(c r10) {
        return r10.f12928b;
    }

    @Override // t3.h
    public void a() {
        p3.c.c("mRecord=" + this.f12929c, new Object[0]);
        p3.c.c("mHeapRecord=" + this.f12930d, new Object[0]);
        p3.c.c("mClassDump size=" + this.f12928b.size(), new Object[0]);
        p3.c.c("mActivityStringId=" + this.f12931e + " mActivityClassObjectId=" + this.f12932f, new Object[0]);
    }

    @Override // t3.h
    public void b(String r10, int r11, long r12) {
    }

    @Override // t3.h
    public /* bridge */ /* synthetic */ e c(int r10, int r11, long r12) {
        return l(r10, r11, r12);
    }

    @Override // t3.h
    public void d(int r10, f r11, int r12, f r13, int r14, long r15) {
        this.f12929c.a(2);
        f r16 = this.f12931e;
        if (r16 != null) goto L5;
        this.f12933g.put(r13, r11);
        return;
    L5:
        if (r16.equals(r13) == false) goto L9;
        this.f12932f = r11;
        p3.c.c("find activity object id=" + this.f12932f, new Object[0]);
        return;
    }

    @Override // t3.h
    public void e(f r10, f r11, f r12, f r13, int r14, int r15, int r16, long r17) {
    }

    @Override // t3.h
    public void f(int r10, int r11, f[] r12, int r13, long r14) {
    }

    @Override // t3.h
    public void g(f r10, String r11, int r12, long r13) {
        this.f12929c.a(1);
        if (this.f12931e == null) goto L5;
        return;
    L5:
        if ("android.app.Activity".equals(r11) == false) goto L9;
        this.f12931e = r10;
        p3.c.c("find activity string id=" + this.f12931e, new Object[0]);
        this.f12932f = this.f12933g.get(this.f12931e);
        p3.c.c("find activity from cache object id=" + this.f12932f + " cache size=" + this.f12933g.size(), new Object[0]);
        this.f12933g.clear();
        return;
    }

    @Override // t3.h
    public void h(int r10, int r11, long r12, byte[] r13) {
    }

    public HashMap<f, t3.a> k() {
        return this.f12928b;
    }

    public a l(int r10, int r11, long r12) {
        this.f12929c.a(28);
        return new a(this, r10, r11, r12);
    L5:
        th = move-exception;
        throw new RuntimeException(th);
    }
}
