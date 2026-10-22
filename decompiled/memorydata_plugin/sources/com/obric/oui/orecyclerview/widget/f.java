package com.obric.oui.orecyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final b f14155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final a f14156b;
    final List<View> c;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f14157a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        a f14158b;

        a() {
            this.f14157a = 0;
        }

        private void b() {
            if (this.f14158b != null) goto L6;
            this.f14158b = new a();
            return;
        }

        void a() {
            this.f14157a = 0;
            a r2 = this.f14158b;
            if (r2 == null) goto L6;
            r2.a();
            return;
        }

        void a(int r5) {
            if (r5 < 64) goto L5;
            b();
            this.f14158b.a(r5 - 64);
            return;
        L5:
            this.f14157a |= 1 << r5;
        }

        void b(int r5) {
            if (r5 < 64) goto L7;
            a r4 = this.f14158b;
            if (r4 == null) goto L9;
            r4.b(r5 - 64);
            return;
        L9:
            return;
        L7:
            this.f14157a &= ~(1 << r5);
        }

        boolean c(int r5) {
            if (r5 < 64) goto L6;
            b();
            return this.f14158b.c(r5 - 64);
        L6:
            long r0 = this.f14157a;
            if (((1 << r5) & r0) == 0) goto L9;
            return true;
        L9:
            return false;
        }

        boolean d(int r11) {
            if (r11 < 64) goto L6;
            b();
            return this.f14158b.d(r11 - 64);
        L6:
            long r2 = 1 << r11;
            long r4 = this.f14157a;
            if ((r4 & r2) == 0) goto L9;
            boolean r12 = true;
        L10:
            long r5 = r4 & (~r2);
            this.f14157a = r5;
            long r3 = r2 - 1;
            this.f14157a = (r5 & r3) | Long.rotateRight((~r3) & r5, 1);
            a r0 = this.f14158b;
            if (r0 != null) goto L13;
        L16:
            return r12;
        L13:
            if (r0.c(0) == false) goto L15;
            a(63);
        L15:
            this.f14158b.d(0);
            goto L16
        L9:
            r12 = false;
            goto L10
        }

        int e(int r5) {
            a r0 = this.f14158b;
            if (r0 != null) goto L9;
            if (r5 < 64) goto L8;
            long r4 = this.f14157a;
        L7:
            return Long.bitCount(r4);
        L8:
            long r1 = this.f14157a;
            r4 = ((1 << r5) - 1) & r1;
            goto L7
        L9:
            if (r5 < 64) goto L8;
            return r0.e(r5 - 64) + Long.bitCount(this.f14157a);
        }

        void insert(int r10, boolean r11) {
            if (r10 < 64) goto L5;
            b();
            this.f14158b.insert(r10 - 64, r11);
            return;
        L5:
            long r0 = this.f14157a;
            if ((Long.MIN_VALUE & r0) == 0) goto L8;
            boolean r2 = true;
        L9:
            long r7 = (1 << r10) - 1;
            this.f14157a = ((r0 & (~r7)) << 1) | (r0 & r7);
            if (r11 == false) goto L12;
            a(r10);
        L13:
            if (r2 == false) goto L15;
        L16:
            b();
            this.f14158b.insert(0, r2);
            return;
        L15:
            if (this.f14158b != null) goto L16;
            return;
        L12:
            b(r10);
            goto L13
        L8:
            r2 = false;
            goto L9
        }

        public String toString() {
            if (this.f14158b != null) goto L6;
            return Long.toBinaryString(this.f14157a);
        L6:
            return this.f14158b.toString() + "xx" + Long.toBinaryString(this.f14157a);
        }
    }

    interface b {
        int a();

        int a(View r1);

        void a(int r1);

        void a(View r1, int r2);

        void a(View r1, int r2, ViewGroup.LayoutParams r3);

        View b(int r1);

        RecyclerView.v b(View r1);

        void b();

        void c(int r1);

        void c(View r1);

        void d(View r1);
    }

    f(b r3) {
        this.f14155a = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        this.f14156b = new a();
        this.c = new ArrayList();
    }

    private int f(int r5) {
        if (r5 >= 0) goto L5;
        return -1;
    L5:
        int r1 = this.f14155a.a();
        int r2 = r5;
    L6:
        if (r2 >= r1) goto L14;
        int r3 = r5 - (r2 - this.f14156b.e(r2));
        if (r3 == 0) goto L10;
        r2 = r2 + r3;
    L10:
        if (this.f14156b.c(r2) == false) goto L12;
        r2 = r2 + 1;
        goto L10
    L12:
        return r2;
    L14:
        return -1;
    }

    private void g(View r2) {
        this.c.add(r2);
        this.f14155a.c(r2);
    }

    private boolean h(View r2) {
        if (this.c.remove(r2) == false) goto L6;
        this.f14155a.d(r2);
        return true;
    L6:
        return false;
    }

    void a() {
        this.f14156b.a();
        int r0 = this.c.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        this.f14155a.d((View) ZeusTransformUtils.preCheckCast(this.c.get(r0), View.class, "com.obric.memorydata.plugin"));
        this.c.remove(r0);
        r0 = r0 - 1;
        goto L3
    L5:
        this.f14155a.b();
    }

    void a(int r3) {
        int r4 = f(r3);
        View r0 = this.f14155a.b(r4);
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.f14156b.d(r4) == false) goto L8;
        h(r0);
    L8:
        this.f14155a.a(r4);
    }

    void a(View r3) {
        int r0 = this.f14155a.a(r3);
        if (r0 >= 0) goto L6;
        return;
    L6:
        if (this.f14156b.d(r0) == false) goto L8;
        h(r3);
    L8:
        this.f14155a.a(r0);
    }

    void a(View r2, int r3, ViewGroup.LayoutParams r4, boolean r5) {
        if (r3 >= 0) goto L4;
        int r6 = this.f14155a.a();
    L5:
        this.f14156b.insert(r6, r5);
        if (r5 == false) goto L8;
        g(r2);
    L8:
        this.f14155a.a(r2, r6, r4);
        return;
    L4:
        r6 = f(r3);
        goto L5
    }

    void a(View r2, int r3, boolean r4) {
        if (r3 >= 0) goto L4;
        int r5 = this.f14155a.a();
    L5:
        this.f14156b.insert(r5, r4);
        if (r4 == false) goto L8;
        g(r2);
    L8:
        this.f14155a.a(r2, r5);
        return;
    L4:
        r5 = f(r3);
        goto L5
    }

    void a(View r2, boolean r3) {
        a(r2, -1, r3);
    }

    int b() {
        return this.f14155a.a() - this.c.size();
    }

    int b(View r3) {
        int r4 = this.f14155a.a(r3);
        if (r4 != (-1)) goto L6;
        return -1;
    L6:
        if (this.f14156b.c(r4) == false) goto L9;
        return -1;
    L9:
        return r4 - this.f14156b.e(r4);
    }

    View b(int r1) {
        int r2 = f(r1);
        return this.f14155a.b(r2);
    }

    int c() {
        return this.f14155a.a();
    }

    View c(int r6) {
        int r0 = this.c.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L12;
        View r2 = (View) ZeusTransformUtils.preCheckCast(this.c.get(r1), View.class, "com.obric.memorydata.plugin");
        RecyclerView.v r3 = this.f14155a.b(r2);
        if (r3.m() != r6) goto L11;
        if (r3.y() == true) goto L11;
        if (r3.B() == true) goto L11;
        return r2;
    L11:
        r1 = r1 + 1;
        goto L3
    L12:
        return null;
    }

    boolean c(View r1) {
        return this.c.contains(r1);
    }

    View d(int r1) {
        return this.f14155a.b(r1);
    }

    void d(View r3) {
        int r0 = this.f14155a.a(r3);
        if (r0 < 0) goto L7;
        this.f14156b.a(r0);
        g(r3);
        return;
    L7:
        throw new IllegalArgumentException("view is not a child, cannot hide " + r3);
    }

    void e(int r2) {
        int r3 = f(r2);
        this.f14156b.d(r3);
        this.f14155a.c(r3);
    }

    void e(View r3) {
        int r0 = this.f14155a.a(r3);
        if (r0 < 0) goto L11;
        if (this.f14156b.c(r0) == false) goto L9;
        this.f14156b.b(r0);
        h(r3);
        return;
    L9:
        throw new RuntimeException("trying to unhide a view that was not hidden" + r3);
    L11:
        throw new IllegalArgumentException("view is not a child, cannot hide " + r3);
    }

    boolean f(View r4) {
        int r0 = this.f14155a.a(r4);
        if (r0 != (-1)) goto L7;
        h(r4);
        return true;
    L7:
        if (this.f14156b.c(r0) == false) goto L10;
        this.f14156b.d(r0);
        h(r4);
        this.f14155a.a(r0);
        return true;
    L10:
        return false;
    }

    public String toString() {
        return this.f14156b.toString() + ", hidden list:" + this.c.size();
    }
}
