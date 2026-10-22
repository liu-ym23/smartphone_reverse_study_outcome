package com.obric.oui.orecyclerview.widget;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Comparator<c> f14185a = null;

    public static abstract class a {
        public a() {
        }

        public abstract int a();

        public abstract boolean a(int r1, int r2);

        public abstract int b();

        public abstract boolean b(int r1, int r2);

        public Object c(int r1, int r2) {
            return null;
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int[] f14186a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f14187b;

        b(int r1) {
            int[] r2 = new int[r1];
            this.f14186a = r2;
            this.f14187b = r2.length / 2;
        }

        int a(int r2) {
            return this.f14186a[r2 + this.f14187b];
        }

        void a(int r2, int r3) {
            this.f14186a[r2 + this.f14187b] = r3;
        }

        int[] a() {
            return this.f14186a;
        }
    }

    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f14188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f14189b;
        public final int c;

        c(int r1, int r2, int r3) {
            this.f14188a = r1;
            this.f14189b = r2;
            this.c = r3;
        }

        int a() {
            return this.f14188a + this.c;
        }

        int b() {
            return this.f14189b + this.c;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<c> f14190a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int[] f14191b;
        private final int[] c;
        private final a d;
        private final int e;
        private final int f;
        private final boolean g;

        d(a r3, List<c> r4, int[] r5, int[] r6, boolean r7) {
            this.f14190a = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            this.f14191b = r5;
            this.c = r6;
            Arrays.fill(r5, 0);
            Arrays.fill(r6, 0);
            this.d = r3;
            this.e = r3.a();
            this.f = r3.b();
            this.g = r7;
            a();
            b();
        }

        private static f a(Collection<f> r3, int r4, boolean r5) {
            Iterator r6 = ((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r6.hasNext() == false) goto L10;
            f r0 = (f) ZeusTransformUtils.preCheckCast(r6.next(), f.class, "com.obric.memorydata.plugin");
            if (r0.f14192a != r4) goto L4;
            if (r0.c != r5) goto L4;
            r6.remove();
        L12:
            if (r6.hasNext() == false) goto L18;
            f r7 = (f) ZeusTransformUtils.preCheckCast(r6.next(), f.class, "com.obric.memorydata.plugin");
            int r2 = r7.f14193b;
            if (r5 == false) goto L16;
            int r8 = r2 - 1;
        L17:
            r7.f14193b = r8;
            goto L12
        L16:
            r8 = r2 + 1;
            goto L17
        L18:
            return r0;
        L10:
            r0 = null;
            goto L12
        }

        private void a() {
            if (this.f14190a.isEmpty() == false) goto L5;
            c r0 = null;
        L6:
            if (r0 != null) goto L8;
        L11:
            this.f14190a.add(0, new c(0, 0, 0));
        L12:
            this.f14190a.add(new c(this.e, this.f, 0));
            return;
        L8:
            if (r0.f14188a != 0) goto L11;
            if (r0.f14189b == 0) goto L12;
        L5:
            r0 = (c) ZeusTransformUtils.preCheckCast(this.f14190a.get(0), c.class, "com.obric.memorydata.plugin");
            goto L6
        }

        private void a(int r7) {
            int r0 = this.f14190a.size();
            int r1 = 0;
            int r2 = 0;
        L3:
            if (r1 >= r0) goto L19;
            c r3 = (c) ZeusTransformUtils.preCheckCast(this.f14190a.get(r1), c.class, "com.obric.memorydata.plugin");
        L6:
            if (r2 >= r3.f14189b) goto L18;
            if (this.c[r2] != 0) goto L17;
            if (this.d.a(r7, r2) == false) goto L17;
            if (this.d.b(r7, r2) == false) goto L14;
            int r4 = 8;
        L15:
            this.f14191b[r7] = (r2 << 4) | r4;
            this.c[r2] = (r7 << 4) | r4;
            return;
        L14:
            r4 = 4;
        L17:
            r2 = r2 + 1;
            goto L6
        L18:
            r2 = r3.b();
            r1 = r1 + 1;
            goto L3
        }

        private void b() {
            Iterator<c> r0 = this.f14190a.iterator();
        L4:
            if (r0.hasNext() == false) goto L14;
            c r1 = (c) ZeusTransformUtils.preCheckCast(r0.next(), c.class, "com.obric.memorydata.plugin");
            int r2 = 0;
        L7:
            if (r2 >= r1.c) goto L4;
            int r3 = r1.f14188a + r2;
            int r4 = r1.f14189b + r2;
            if (this.d.b(r3, r4) == false) goto L11;
            int r5 = 1;
        L12:
            this.f14191b[r3] = (r4 << 4) | r5;
            this.c[r4] = (r3 << 4) | r5;
            r2 = r2 + 1;
            goto L7
        L11:
            r5 = 2;
            goto L12
        L14:
            if (this.g == false) goto L21;
            c();
            return;
        }

        private void c() {
            Iterator<c> r0 = this.f14190a.iterator();
            int r1 = 0;
        L4:
            if (r0.hasNext() == false) goto L13;
            c r2 = (c) ZeusTransformUtils.preCheckCast(r0.next(), c.class, "com.obric.memorydata.plugin");
        L7:
            if (r1 >= r2.f14188a) goto L12;
            if (this.f14191b[r1] != 0) goto L11;
            a(r1);
        L11:
            r1 = r1 + 1;
            goto L7
        L12:
            r1 = r2.a();
            goto L4
        }

        public void a(RecyclerView.Adapter r2) {
            a(new com.obric.oui.orecyclerview.widget.b(r2));
        }

        public void a(r r14) {
            r r15 = (r) ZeusTransformUtils.wrapperContextForParams(r14, r.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r15, com.obric.oui.orecyclerview.widget.e.class) == false) goto L5;
            com.obric.oui.orecyclerview.widget.e r16 = (com.obric.oui.orecyclerview.widget.e) ZeusTransformUtils.preCheckCast(r15, com.obric.oui.orecyclerview.widget.e.class, "com.obric.memorydata.plugin");
        L6:
            int r0 = this.e;
            ArrayDeque r2 = new ArrayDeque();
            int r3 = this.e;
            int r4 = this.f;
            int r5 = this.f14190a.size() - 1;
        L7:
            if (r5 < 0) goto L38;
            c r7 = (c) ZeusTransformUtils.preCheckCast(this.f14190a.get(r5), c.class, "com.obric.memorydata.plugin");
            int r8 = r7.a();
            int r9 = r7.b();
        L9:
            int r10 = 0;
            if (r3 <= r8) goto L20;
            r3 = r3 - 1;
            int r11 = this.f14191b[r3];
            if ((r11 & 12) != 0) goto L13;
            r16.b(r3, 1);
            r0 = r0 - 1;
            goto L9
        L13:
            int r12 = r11 >> 4;
            f r13 = a(r2, r12, false);
            if (r13 != null) goto L15;
            r2.add(new f(r3, (r0 - r3) - 1, true));
            goto L9
        L15:
            int r17 = (r0 - r13.f14193b) - 1;
            r16.c(r3, r17);
            if ((r11 & 4) == 0) goto L9;
            r16.a(r17, 1, this.d.c(r3, r12));
        L20:
            if (r4 <= r9) goto L30;
            r4 = r4 - 1;
            int r18 = this.c[r4];
            if ((r18 & 12) != 0) goto L23;
            r16.a(r3, 1);
            r0 = r0 + 1;
            goto L20
        L23:
            int r19 = r18 >> 4;
            f r110 = a(r2, r19, true);
            if (r110 == null) goto L25;
            r16.c((r0 - r110.f14193b) - 1, r3);
            if ((r18 & 4) == 0) goto L20;
            r16.a(r3, 1, this.d.c(r19, r4));
            goto L20
        L25:
            r2.add(new f(r4, r0 - r3, false));
            goto L20
        L30:
            int r6 = r7.f14188a;
            int r20 = r7.f14189b;
        L32:
            if (r10 >= r7.c) goto L37;
            if ((this.f14191b[r6] & 15) != 2) goto L36;
            r16.a(r6, 1, this.d.c(r6, r20));
        L36:
            r6 = r6 + 1;
            r20 = r20 + 1;
            r10 = r10 + 1;
            goto L32
        L37:
            r3 = r7.f14188a;
            r4 = r7.f14189b;
            r5 = r5 - 1;
            goto L7
        L38:
            r16.a();
            return;
        L5:
            r16 = new com.obric.oui.orecyclerview.widget.e(r15);
            goto L6
        }
    }

    public static abstract class e<T> {
        public e() {
        }

        public abstract boolean a(T r1, T r2);

        public abstract boolean b(T r1, T r2);

        public Object c(T r1, T r2) {
            return null;
        }
    }

    private static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14192a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f14193b;
        boolean c;

        f(int r1, int r2, boolean r3) {
            this.f14192a = r1;
            this.f14193b = r2;
            this.c = r3;
        }
    }

    static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14194a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f14195b;
        int c;
        int d;

        public g() {
        }

        public g(int r1, int r2, int r3, int r4) {
            this.f14194a = r1;
            this.f14195b = r2;
            this.c = r3;
            this.d = r4;
        }

        int a() {
            return this.f14195b - this.f14194a;
        }

        int b() {
            return this.d - this.c;
        }
    }

    static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f14196a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14197b;
        public int c;
        public int d;
        public boolean e;

        h() {
        }

        boolean a() {
            if ((this.d - this.f14197b) == (this.c - this.f14196a)) goto L5;
            return true;
        L5:
            return false;
        }

        boolean b() {
            if ((this.d - this.f14197b) <= (this.c - this.f14196a)) goto L5;
            return true;
        L5:
            return false;
        }

        int c() {
            return Math.min(this.c - this.f14196a, this.d - this.f14197b);
        }

        c d() {
            if (a() == true) goto L5;
            int r1 = this.f14196a;
            return new c(r1, this.f14197b, this.c - r1);
        L5:
            if (this.e == false) goto L9;
            return new c(this.f14196a, this.f14197b, c());
        L9:
            if (b() == false) goto L13;
            return new c(this.f14196a, this.f14197b + 1, c());
        L13:
            return new c(this.f14196a + 1, this.f14197b, c());
        }
    }

    static {
        f14185a = new AnonymousClass1();
    }

    public static d a(a r1) {
        return a(r1, true);
    }

    public static d a(a r10, boolean r11) {
        int r0 = r10.a();
        int r1 = r10.b();
        ArrayList r4 = new ArrayList();
        ArrayList r2 = new ArrayList();
        r2.add(new g(0, r0, 0, r1));
        int r3 = ((((r0 + r1) + 1) / 2) * 2) + 1;
        b r5 = new b(r3);
        b r6 = new b(r3);
        ArrayList r7 = new ArrayList();
    L4:
        if (r2.isEmpty() == true) goto L16;
        g r8 = (g) ZeusTransformUtils.preCheckCast(r2.remove(r2.size() - 1), g.class, "com.obric.memorydata.plugin");
        h r9 = a(r8, r10, r5, r6);
        if (r9 != null) goto L8;
        r7.add(r8);
        goto L4
    L8:
        if (r9.c() <= 0) goto L11;
        r4.add(r9.d());
    L11:
        if (r7.isEmpty() == false) goto L13;
        g r12 = new g();
    L14:
        r12.f14194a = r8.f14194a;
        r12.c = r8.c;
        r12.f14195b = r9.f14196a;
        r12.d = r9.f14197b;
        r2.add(r12);
        r8.f14195b = r8.f14195b;
        r8.d = r8.d;
        r8.f14194a = r9.c;
        r8.c = r9.d;
        r2.add(r8);
        goto L4
    L13:
        r12 = (g) ZeusTransformUtils.preCheckCast(r7.remove(r7.size() - 1), g.class, "com.obric.memorydata.plugin");
        goto L14
    L16:
        Collections.sort(r4, f14185a);
        return new d(r10, r4, r5.a(), r6.a(), r11);
    }

    private static h a(g r4, a r5, b r6, b r7) {
        if (r4.a() >= 1) goto L5;
    L16:
        return null;
    L5:
        if (r4.b() < 1) goto L16;
        int r0 = ((r4.a() + r4.b()) + 1) / 2;
        r6.a(1, r4.f14194a);
        r7.a(1, r4.f14195b);
        int r2 = 0;
    L8:
        if (r2 >= r0) goto L16;
        h r3 = a(r4, r5, r6, r7, r2);
        if (r3 != null) goto L11;
        h r8 = b(r4, r5, r6, r7, r2);
        if (r8 != null) goto L14;
        r2 = r2 + 1;
        goto L8
    L14:
        return r8;
    L11:
        return r3;
    }

    private static h a(g r11, a r12, b r13, b r14, int r15) {
        boolean r2 = true;
        if ((Math.abs(r11.a() - r11.b()) % 2) == 1) goto L6;
        r2 = false;
    L6:
        int r0 = r11.a() - r11.b();
        int r3 = -r15;
        int r4 = r3;
    L7:
        if (r4 > r15) goto L39;
        if (r4 == r3) goto L14;
        if (r4 != r15) goto L11;
    L13:
        int r5 = r13.a(r4 - 1);
        int r6 = r5 + 1;
    L15:
        int r7 = (r11.c + (r6 - r11.f14194a)) - r4;
        if (r15 == 0) goto L20;
        if (r6 != r5) goto L20;
        int r8 = r7 - 1;
    L22:
        if (r6 >= r11.f14195b) goto L28;
        if (r7 >= r11.d) goto L28;
        if (r12.a(r6, r7) == false) goto L28;
        r6 = r6 + 1;
        r7 = r7 + 1;
    L28:
        r13.a(r4, r6);
        if (r2 == false) goto L38;
        int r9 = r0 - r4;
        if (r9 < (r3 + 1)) goto L38;
        if (r9 > (r15 - 1)) goto L38;
        if (r14.a(r9) > r6) goto L38;
        h r16 = new h();
        r16.f14196a = r5;
        r16.f14197b = r8;
        r16.c = r6;
        r16.d = r7;
        r16.e = false;
        return r16;
    L38:
        r4 = r4 + 2;
    L20:
        r8 = r7;
        goto L22
    L11:
        if (r13.a(r4 + 1) <= r13.a(r4 - 1)) goto L13;
    L14:
        r5 = r13.a(r4 + 1);
        r6 = r5;
        goto L15
    L39:
        return null;
    }

    private static h b(g r11, a r12, b r13, b r14, int r15) {
        if (((r11.a() - r11.b()) % 2) != 0) goto L5;
        boolean r0 = true;
    L6:
        int r2 = r11.a() - r11.b();
        int r3 = -r15;
        int r4 = r3;
    L7:
        if (r4 > r15) goto L38;
        if (r4 == r3) goto L14;
        if (r4 != r15) goto L11;
    L13:
        int r5 = r14.a(r4 - 1);
        int r6 = r5 - 1;
    L15:
        int r7 = r11.d - ((r11.f14195b - r6) - r4);
        if (r15 == 0) goto L20;
        if (r6 != r5) goto L20;
        int r8 = r7 + 1;
    L22:
        if (r6 <= r11.f14194a) goto L28;
        if (r7 <= r11.c) goto L28;
        if (r12.a(r6 - 1, r7 - 1) == false) goto L28;
        r6 = r6 - 1;
        r7 = r7 - 1;
    L28:
        r14.a(r4, r6);
        if (r0 == false) goto L37;
        int r9 = r2 - r4;
        if (r9 < r3) goto L37;
        if (r9 > r15) goto L37;
        if (r13.a(r9) < r6) goto L37;
        h r16 = new h();
        r16.f14196a = r6;
        r16.f14197b = r7;
        r16.c = r5;
        r16.d = r8;
        r16.e = true;
        return r16;
    L37:
        r4 = r4 + 2;
    L20:
        r8 = r7;
        goto L22
    L11:
        if (r14.a(r4 + 1) >= r14.a(r4 - 1)) goto L13;
    L14:
        r5 = r14.a(r4 + 1);
        r6 = r5;
        goto L15
    L38:
        return null;
    L5:
        r0 = false;
        goto L6
    }
}
