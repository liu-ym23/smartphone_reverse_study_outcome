package com.obric.oui.orecyclerview.widget;

import androidx.core.util.Pools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
final class a implements u.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ArrayList<b> f14110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ArrayList<b> f14111b;
    final InterfaceC0756a c;
    Runnable d;
    final boolean e;
    final u f;
    private Pools.Pool<b> g;
    private int h;

    /* JADX INFO: renamed from: com.obric.oui.orecyclerview.widget.a$a, reason: collision with other inner class name */
    interface InterfaceC0756a {
        RecyclerView.v a(int r1);

        void a(int r1, int r2);

        void a(int r1, int r2, Object r3);

        void a(b r1);

        void b(int r1, int r2);

        void b(b r1);

        void c(int r1, int r2);

        void d(int r1, int r2);
    }

    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14112a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f14113b;
        Object c;
        int d;

        b(int r1, int r2, int r3, Object r4) {
            this.f14112a = r1;
            this.f14113b = r2;
            this.d = r3;
            this.c = r4;
        }

        String a() {
            int r1 = this.f14112a;
            if (r1 != 1) goto L5;
            return "add";
        L5:
            if (r1 != 2) goto L7;
            return "rm";
        L7:
            if (r1 != 4) goto L9;
            return "up";
        L9:
            if (r1 == 8) goto L12;
            return "??";
        L12:
            return "mv";
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            int r0 = this.f14112a;
            if (r0 == r6.f14112a) goto L12;
            return false;
        L12:
            if (r0 != 8) goto L21;
            if (Math.abs(this.d - this.f14113b) != 1) goto L21;
            if (this.d != r6.f14113b) goto L21;
            if (this.f14113b != r6.d) goto L21;
            return true;
        L21:
            if (this.d == r6.d) goto L24;
            return false;
        L24:
            if (this.f14113b == r6.f14113b) goto L26;
            return false;
        L26:
            Object r4 = this.c;
            if (r4 == null) goto L32;
            if (r4.equals(r6.c) == true) goto L34;
            return false;
        L34:
            return true;
        L32:
            if (r6.c == null) goto L34;
            return false;
        }

        public int hashCode() {
            return (((this.f14112a * 31) + this.f14113b) * 31) + this.d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f14113b + "c:" + this.d + ",p:" + this.c + "]";
        }
    }

    a(InterfaceC0756a r3) {
        this((InterfaceC0756a) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0756a.class, "com.obric.memorydata.plugin"), false);
    }

    a(InterfaceC0756a r3, boolean r4) {
        InterfaceC0756a r5 = (InterfaceC0756a) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0756a.class, "com.obric.memorydata.plugin");
        this.g = new Pools.SimplePool(30);
        this.f14110a = new ArrayList();
        this.f14111b = new ArrayList();
        this.h = 0;
        this.c = r5;
        this.e = r4;
        this.f = new u(this);
    }

    private void b(b r1) {
        g(r1);
    }

    private void c(b r11) {
        int r0 = r11.f14113b;
        int r1 = r11.f14113b + r11.d;
        int r2 = r11.f14113b;
        byte r4 = -1;
        int r5 = 0;
    L4:
        if (r2 >= r1) goto L23;
        if (this.c.a(r2) == null) goto L8;
    L14:
        if (r4 != 0) goto L16;
        e(a(2, r0, r5, null));
        boolean r6 = true;
    L17:
        byte r7 = 1;
    L18:
        if (r6 == false) goto L20;
        r2 = r2 - r5;
        r1 = r1 - r5;
        r5 = 1;
    L21:
        r2 = r2 + 1;
        r4 = r7;
        goto L4
    L20:
        r5 = r5 + 1;
        goto L21
    L16:
        r6 = false;
        goto L17
    L8:
        if (d(r2) == true) goto L14;
        if (r4 != 1) goto L12;
        g(a(2, r0, r5, null));
        r6 = true;
    L13:
        r7 = 0;
        goto L18
    L12:
        r6 = false;
        goto L13
    L23:
        if (r5 == r11.d) goto L25;
        a(r11);
        r11 = a(2, r0, r5, null);
    L25:
        if (r4 != 0) goto L27;
        e(r11);
        return;
    L27:
        g(r11);
    }

    private int d(int r7, int r8) {
        int r0 = this.f14111b.size() - 1;
    L4:
        if (r0 < 0) goto L48;
        b r3 = (b) ZeusTransformUtils.preCheckCast(this.f14111b.get(r0), b.class, "com.obric.memorydata.plugin");
        if (r3.f14112a != 8) goto L35;
        if (r3.f14113b >= r3.d) goto L10;
        int r2 = r3.f14113b;
        int r4 = r3.d;
    L11:
        if (r7 < r2) goto L28;
        if (r7 > r4) goto L28;
        if (r2 != r3.f14113b) goto L21;
        if (r8 != 1) goto L18;
        int r5 = r3.d + 1;
    L17:
        r3.d = r5;
    L20:
        r7 = r7 + 1;
    L47:
        r0 = r0 - 1;
        goto L4
    L18:
        if (r8 != 2) goto L20;
        r5 = r3.d - 1;
        goto L17
    L21:
        if (r8 != 1) goto L24;
        int r6 = r3.f14113b + 1;
    L23:
        r3.f14113b = r6;
    L26:
        r7 = r7 - 1;
        goto L47
    L24:
        if (r8 != 2) goto L26;
        r6 = r3.f14113b - 1;
    L28:
        if (r7 >= r3.f14113b) goto L47;
        if (r8 != 1) goto L32;
        r3.f14113b++;
        int r9 = r3.d + 1;
    L31:
        r3.d = r9;
        goto L47
    L32:
        if (r8 != 2) goto L47;
        r3.f14113b--;
        r9 = r3.d - 1;
        goto L31
    L10:
        r2 = r3.d;
        r4 = r3.f14113b;
        goto L11
    L35:
        if (r3.f14113b <= r7) goto L37;
        if (r8 != 1) goto L45;
        int r10 = r3.f14113b + 1;
    L44:
        r3.f14113b = r10;
        goto L47
    L45:
        if (r8 != 2) goto L47;
        r10 = r3.f14113b - 1;
        goto L44
    L37:
        if (r3.f14112a != 1) goto L40;
        r7 = r7 - r3.d;
        goto L47
    L40:
        if (r3.f14112a != 2) goto L47;
        r7 = r7 + r3.d;
        goto L47
    L48:
        int r11 = this.f14111b.size() - 1;
    L49:
        if (r11 < 0) goto L61;
        b r1 = (b) ZeusTransformUtils.preCheckCast(this.f14111b.get(r11), b.class, "com.obric.memorydata.plugin");
        if (r1.f14112a != 8) goto L58;
        if (r1.d != r1.f14113b) goto L55;
    L59:
        this.f14111b.remove(r11);
        a(r1);
    L60:
        r11 = r11 - 1;
        goto L49
    L55:
        if (r1.d >= 0) goto L60;
    L58:
        if (r1.d > 0) goto L60;
    L61:
        return r7;
    }

    private void d(b r10) {
        int r0 = r10.f14113b;
        int r1 = r10.f14113b + r10.d;
        int r2 = r10.f14113b;
        byte r4 = -1;
        int r5 = 0;
    L4:
        if (r2 >= r1) goto L18;
        if (this.c.a(r2) == null) goto L8;
    L13:
        if (r4 != 0) goto L15;
        e(a(4, r0, r5, r10.c));
        r0 = r2;
        r5 = 0;
    L15:
        r4 = 1;
    L16:
        r5 = r5 + 1;
        r2 = r2 + 1;
        goto L4
    L8:
        if (d(r2) == true) goto L13;
        if (r4 != 1) goto L12;
        g(a(4, r0, r5, r10.c));
        r0 = r2;
        r5 = 0;
    L12:
        r4 = 0;
        goto L16
    L18:
        if (r5 == r10.d) goto L20;
        Object r3 = r10.c;
        a(r10);
        r10 = a(4, r0, r5, r3);
    L20:
        if (r4 != 0) goto L22;
        e(r10);
        return;
    L22:
        g(r10);
    }

    private boolean d(int r8) {
        int r0 = this.f14111b.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L18;
        b r3 = (b) ZeusTransformUtils.preCheckCast(this.f14111b.get(r2), b.class, "com.obric.memorydata.plugin");
        if (r3.f14112a != 8) goto L10;
        if (a(r3.d, r2 + 1) != r8) goto L17;
        return true;
    L17:
        r2 = r2 + 1;
        goto L3
    L10:
        if (r3.f14112a != 1) goto L17;
        int r4 = r3.f14113b + r3.d;
        int r5 = r3.f14113b;
    L12:
        if (r5 >= r4) goto L17;
        if (a(r5, r2 + 1) == r8) goto L15;
        r5 = r5 + 1;
        goto L12
    L15:
        return true;
    L18:
        return false;
    }

    private void e(b r13) {
        if (r13.f14112a == 1) goto L37;
        if (r13.f14112a == 8) goto L37;
        int r0 = d(r13.f14113b, r13.f14112a);
        int r2 = r13.f14113b;
        int r3 = r13.f14112a;
        if (r3 == 2) goto L12;
        if (r3 != 4) goto L11;
        int r4 = 1;
    L13:
        int r7 = 1;
        int r8 = 1;
    L15:
        if (r7 >= r13.d) goto L32;
        int r9 = d(r13.f14113b + (r4 * r7), r13.f14112a);
        int r10 = r13.f14112a;
        if (r10 == 2) goto L23;
        if (r10 == 4) goto L21;
    L19:
        boolean r11 = false;
    L25:
        if (r11 == false) goto L27;
        r8 = r8 + 1;
    L31:
        r7 = r7 + 1;
        goto L15
    L27:
        b r1 = a(r13.f14112a, r0, r8, r13.c);
        a(r1, r2);
        a(r1);
        if (r13.f14112a != 4) goto L30;
        r2 = r2 + r8;
    L30:
        r8 = 1;
        r0 = r9;
        goto L31
    L21:
        if (r9 != (r0 + 1)) goto L19;
    L22:
        r11 = true;
        goto L25
    L23:
        if (r9 != r0) goto L19;
    L32:
        Object r5 = r13.c;
        a(r13);
        if (r8 <= 0) goto L41;
        b r14 = a(r13.f14112a, r0, r8, r5);
        a(r14, r2);
        a(r14);
        return;
    L41:
        return;
    L11:
        throw new IllegalArgumentException("op should be remove or update." + r13);
    L12:
        r4 = 0;
    L37:
        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }

    private void f(b r1) {
        g(r1);
    }

    private void g(b r3) {
        this.f14111b.add(r3);
        int r0 = r3.f14112a;
        if (r0 != 1) goto L5;
        this.c.c(r3.f14113b, r3.d);
        return;
    L5:
        if (r0 != 2) goto L7;
        this.c.b(r3.f14113b, r3.d);
        return;
    L7:
        if (r0 != 4) goto L9;
        this.c.a(r3.f14113b, r3.d, r3.c);
        return;
    L9:
        if (r0 != 8) goto L12;
        this.c.d(r3.f14113b, r3.d);
        return;
    L12:
        throw new IllegalArgumentException("Unknown update op type for " + r3);
    }

    int a(int r5, int r6) {
        int r0 = this.f14111b.size();
    L3:
        if (r6 >= r0) goto L28;
        b r1 = (b) ZeusTransformUtils.preCheckCast(this.f14111b.get(r6), b.class, "com.obric.memorydata.plugin");
        if (r1.f14112a != 8) goto L16;
        if (r1.f14113b != r5) goto L10;
        r5 = r1.d;
    L27:
        r6 = r6 + 1;
        goto L3
    L10:
        if (r1.f14113b >= r5) goto L13;
        r5 = r5 - 1;
    L13:
        if (r1.d > r5) goto L27;
        r5 = r5 + 1;
        goto L27
    L16:
        if (r1.f14113b > r5) goto L27;
        if (r1.f14112a != 2) goto L25;
        if (r5 < (r1.f14113b + r1.d)) goto L21;
        r5 = r5 - r1.d;
        goto L27
    L21:
        return -1;
    L25:
        if (r1.f14112a != 1) goto L27;
        r5 = r5 + r1.d;
        goto L27
    L28:
        return r5;
    }

    @Override // com.obric.oui.orecyclerview.widget.u.a
    public b a(int r3, int r4, int r5, Object r6) {
        b r2 = (b) ZeusTransformUtils.preCheckCast(this.g.acquire(), b.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L7;
        r2.f14112a = r3;
        r2.f14113b = r4;
        r2.d = r5;
        r2.c = r6;
        return r2;
    L7:
        return new b(r3, r4, r5, r6);
    }

    void a() {
        a(this.f14110a);
        a(this.f14111b);
        this.h = 0;
    }

    @Override // com.obric.oui.orecyclerview.widget.u.a
    public void a(b r2) {
        if (this.e == true) goto L6;
        r2.c = null;
        this.g.release(r2);
        return;
    }

    void a(b r3, int r4) {
        this.c.a(r3);
        int r0 = r3.f14112a;
        if (r0 != 2) goto L5;
        this.c.a(r4, r3.d);
        return;
    L5:
        if (r0 != 4) goto L8;
        this.c.a(r4, r3.d, r3.c);
        return;
    L8:
        throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
    }

    void a(List<b> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = r7.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        a((b) ZeusTransformUtils.preCheckCast(r7.get(r2), b.class, "com.obric.memorydata.plugin"));
        r2 = r2 + 1;
        goto L3
    L5:
        r7.clear();
    }

    boolean a(int r1) {
        if ((this.h & r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean a(int r5, int r6, int r7) {
        if (r5 != r6) goto L6;
        return false;
    L6:
        if (r7 != 1) goto L12;
        this.f14110a.add(a(8, r5, r6, null));
        this.h |= 8;
        if (this.f14110a.size() == 1) goto L10;
        return false;
    L10:
        return true;
    L12:
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    boolean a(int r5, int r6, Object r7) {
        if (r6 >= 1) goto L5;
        return false;
    L5:
        this.f14110a.add(a(4, r5, r6, r7));
        this.h |= 4;
        if (this.f14110a.size() == 1) goto L8;
        return false;
    L8:
        return true;
    }

    int b(int r2) {
        return a(r2, 0);
    }

    void b() {
        this.f.a(this.f14110a);
        int r0 = this.f14110a.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L21;
        b r2 = (b) ZeusTransformUtils.preCheckCast(this.f14110a.get(r1), b.class, "com.obric.memorydata.plugin");
        int r3 = r2.f14112a;
        if (r3 != 1) goto L7;
        f(r2);
    L17:
        Runnable r4 = this.d;
        if (r4 == null) goto L20;
        r4.run();
    L20:
        r1 = r1 + 1;
        goto L3
    L7:
        if (r3 != 2) goto L9;
        c(r2);
        goto L17
    L9:
        if (r3 != 4) goto L11;
        d(r2);
        goto L17
    L11:
        if (r3 != 8) goto L17;
        b(r2);
        goto L17
    L21:
        this.f14110a.clear();
    }

    boolean b(int r5, int r6) {
        if (r6 >= 1) goto L5;
        return false;
    L5:
        this.f14110a.add(a(1, r5, r6, null));
        this.h |= 1;
        if (this.f14110a.size() == 1) goto L8;
        return false;
    L8:
        return true;
    }

    public int c(int r6) {
        int r0 = this.f14110a.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L31;
        b r2 = (b) ZeusTransformUtils.preCheckCast(this.f14110a.get(r1), b.class, "com.obric.memorydata.plugin");
        int r3 = r2.f14112a;
        if (r3 == 1) goto L28;
        if (r3 == 2) goto L21;
        if (r3 != 8) goto L30;
        if (r2.f14113b != r6) goto L15;
        r6 = r2.d;
        goto L30
    L15:
        if (r2.f14113b >= r6) goto L18;
        r6 = r6 - 1;
    L18:
        if (r2.d > r6) goto L30;
        r6 = r6 + 1;
    L30:
        r1 = r1 + 1;
        goto L3
    L21:
        if (r2.f14113b > r6) goto L30;
        if ((r2.f14113b + r2.d) > r6) goto L24;
        r6 = r6 - r2.d;
        goto L30
    L24:
        return -1;
    L28:
        if (r2.f14113b > r6) goto L30;
        r6 = r6 + r2.d;
        goto L30
    L31:
        return r6;
    }

    void c() {
        int r0 = this.f14111b.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        this.c.b((b) ZeusTransformUtils.preCheckCast(this.f14111b.get(r2), b.class, "com.obric.memorydata.plugin"));
        r2 = r2 + 1;
        goto L3
    L5:
        a(this.f14111b);
        this.h = 0;
    }

    boolean c(int r6, int r7) {
        if (r7 >= 1) goto L5;
        return false;
    L5:
        this.f14110a.add(a(2, r6, r7, null));
        this.h |= 2;
        if (this.f14110a.size() == 1) goto L8;
        return false;
    L8:
        return true;
    }

    boolean d() {
        if (this.f14110a.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    void e() {
        c();
        int r0 = this.f14110a.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L21;
        b r3 = (b) ZeusTransformUtils.preCheckCast(this.f14110a.get(r2), b.class, "com.obric.memorydata.plugin");
        int r4 = r3.f14112a;
        if (r4 != 1) goto L7;
        this.c.b(r3);
        this.c.c(r3.f14113b, r3.d);
    L17:
        Runnable r5 = this.d;
        if (r5 == null) goto L20;
        r5.run();
    L20:
        r2 = r2 + 1;
        goto L3
    L7:
        if (r4 != 2) goto L9;
        this.c.b(r3);
        this.c.a(r3.f14113b, r3.d);
        goto L17
    L9:
        if (r4 != 4) goto L11;
        this.c.b(r3);
        this.c.a(r3.f14113b, r3.d, r3.c);
        goto L17
    L11:
        if (r4 != 8) goto L17;
        this.c.b(r3);
        this.c.d(r3.f14113b, r3.d);
        goto L17
    L21:
        a(this.f14110a);
        this.h = 0;
    }

    boolean f() {
        if (this.f14111b.isEmpty() == false) goto L5;
    L7:
        return false;
    L5:
        if (this.f14110a.isEmpty() == true) goto L7;
        return true;
    }
}
