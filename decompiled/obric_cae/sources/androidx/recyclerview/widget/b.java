package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import j0.h0;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0021b f2434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f2435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f2436c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f2437a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a f2438b;

        public a() {
            this.f2437a = 0;
        }

        public final void a(int r8) {
            if (r8 < 64) goto L7;
            a r10 = this.f2438b;
            if (r10 == null) goto L9;
            r10.a(r8 - 64);
            return;
        L9:
            return;
        L7:
            this.f2437a &= ~(1 << r8);
        }

        public final int b(int r8) {
            a r10 = this.f2438b;
            if (r10 != null) goto L9;
            if (r8 >= 64) goto L6;
            long r11 = this.f2437a;
            return Long.bitCount(((1 << r8) - 1) & r11);
        L6:
            return Long.bitCount(this.f2437a);
        L9:
            if (r8 >= 64) goto L12;
            long r12 = this.f2437a;
            return Long.bitCount(((1 << r8) - 1) & r12);
        L12:
            int r13 = r10.b(r8 - 64);
            return Long.bitCount(this.f2437a) + r13;
        }

        public final void c() {
            if (this.f2438b != null) goto L6;
            this.f2438b = new a();
            return;
        }

        public final boolean d(int r8) {
            if (r8 < 64) goto L6;
            c();
            return this.f2438b.d(r8 - 64);
        L6:
            long r10 = this.f2437a;
            if (((1 << r8) & r10) == 0) goto L9;
            return true;
        L9:
            return false;
        }

        public final void e(int r10, boolean r11) {
            if (r10 < 64) goto L5;
            c();
            this.f2438b.e(r10 - 64, r11);
            return;
        L5:
            long r8 = this.f2437a;
            if ((Long.MIN_VALUE & r8) == 0) goto L8;
            boolean r12 = true;
        L9:
            long r13 = (1 << r10) - 1;
            this.f2437a = ((r8 & (~r13)) << 1) | (r8 & r13);
            if (r11 == false) goto L12;
            h(r10);
        L13:
            if (r12 == false) goto L15;
        L16:
            c();
            this.f2438b.e(0, r12);
            return;
        L15:
            if (this.f2438b != null) goto L16;
            return;
        L12:
            a(r10);
            goto L13
        L8:
            r12 = false;
            goto L9
        }

        public final boolean f(int r11) {
            if (r11 < 64) goto L6;
            c();
            return this.f2438b.f(r11 - 64);
        L6:
            long r8 = 1 << r11;
            long r10 = this.f2437a;
            if ((r10 & r8) == 0) goto L9;
            boolean r12 = true;
        L10:
            long r13 = r10 & (~r8);
            this.f2437a = r13;
            long r14 = r8 - 1;
            this.f2437a = (r13 & r14) | Long.rotateRight((~r14) & r13, 1);
            a r15 = this.f2438b;
            if (r15 != null) goto L13;
        L16:
            return r12;
        L13:
            if (r15.d(0) == false) goto L15;
            h(63);
        L15:
            this.f2438b.f(0);
            goto L16
        L9:
            r12 = false;
            goto L10
        }

        public final void g() {
            this.f2437a = 0;
            a r8 = this.f2438b;
            if (r8 == null) goto L6;
            r8.g();
            return;
        }

        public final void h(int r8) {
            if (r8 < 64) goto L5;
            c();
            this.f2438b.h(r8 - 64);
            return;
        L5:
            this.f2437a |= 1 << r8;
        }

        public final String toString() {
            if (this.f2438b != null) goto L6;
            return Long.toBinaryString(this.f2437a);
        L6:
            return this.f2438b.toString() + "xx" + Long.toBinaryString(this.f2437a);
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.b$b, reason: collision with other inner class name */
    public interface InterfaceC0021b {
    }

    public b(RecyclerView.e r8) {
        this.f2434a = r8;
        this.f2435b = new a();
        this.f2436c = new ArrayList();
    }

    public final void a(View r8, int r10, boolean r11) {
        InterfaceC0021b r12 = this.f2434a;
        if (r10 >= 0) goto L5;
        int r13 = ((RecyclerView.e) r12).a();
    L6:
        this.f2435b.e(r13, r11);
        if (r11 == false) goto L9;
        i(r8);
    L9:
        RecyclerView r14 = ((RecyclerView.e) r12).f2300a;
        r14.addView(r8, r13);
        r14.dispatchChildAttached(r8);
        return;
    L5:
        r13 = f(r10);
        goto L6
    }

    public final void b(View r8, int r10, ViewGroup.LayoutParams r11, boolean r12) {
        InterfaceC0021b r13 = this.f2434a;
        if (r10 >= 0) goto L5;
        int r14 = ((RecyclerView.e) r13).a();
    L6:
        this.f2435b.e(r14, r12);
        if (r12 == false) goto L9;
        i(r8);
    L9:
        RecyclerView.e r15 = (RecyclerView.e) r13;
        r15.getClass();
        RecyclerView.c0 r16 = RecyclerView.getChildViewHolderInt(r8);
        RecyclerView r17 = r15.f2300a;
        if (r16 != null) goto L12;
    L19:
        RecyclerView.access$000(r17, r8, r14, r11);
        return;
    L12:
        if (r16.k() == false) goto L14;
    L18:
        r16.f2290j &= -257;
        goto L19
    L14:
        if (r16.o() == true) goto L18;
        StringBuilder r18 = new StringBuilder("Called attach on a child which is not detached: ");
        r18.append(r16);
        throw new IllegalArgumentException(android.aimedia.a.b(r17, r18));
    L5:
        r14 = f(r10);
        goto L6
    }

    public final void c(int r8) {
        int r10 = f(r8);
        this.f2435b.f(r10);
        RecyclerView.e r11 = (RecyclerView.e) this.f2434a;
        View r12 = r11.f2300a.getChildAt(r10);
        RecyclerView r13 = r11.f2300a;
        if (r12 == null) goto L14;
        RecyclerView.c0 r14 = RecyclerView.getChildViewHolderInt(r12);
        if (r14 == null) goto L14;
        if (r14.k() == true) goto L9;
    L13:
        r14.b(256);
        goto L14
    L9:
        if (r14.o() == true) goto L13;
        StringBuilder r15 = new StringBuilder("called detach on an already detached child ");
        r15.append(r14);
        throw new IllegalArgumentException(android.aimedia.a.b(r13, r15));
    L14:
        RecyclerView.access$100(r13, r10);
    }

    public final View d(int r8) {
        int r10 = f(r8);
        return ((RecyclerView.e) this.f2434a).f2300a.getChildAt(r10);
    }

    public final int e() {
        return ((RecyclerView.e) this.f2434a).a() - this.f2436c.size();
    }

    public final int f(int r8) {
        if (r8 >= 0) goto L5;
        return -1;
    L5:
        int r10 = ((RecyclerView.e) this.f2434a).a();
        int r11 = r8;
    L6:
        if (r11 >= r10) goto L14;
        a r12 = this.f2435b;
        int r13 = r8 - (r11 - r12.b(r11));
        if (r13 == 0) goto L10;
        r11 = r11 + r13;
    L10:
        if (r12.d(r11) == false) goto L12;
        r11 = r11 + 1;
        goto L10
    L12:
        return r11;
    L14:
        return -1;
    }

    public final View g(int r8) {
        return ((RecyclerView.e) this.f2434a).f2300a.getChildAt(r8);
    }

    public final int h() {
        return ((RecyclerView.e) this.f2434a).a();
    }

    public final void i(View r8) {
        this.f2436c.add(r8);
        RecyclerView.e r10 = (RecyclerView.e) this.f2434a;
        r10.getClass();
        RecyclerView.c0 r11 = RecyclerView.getChildViewHolderInt(r8);
        if (r11 == null) goto L10;
        int r12 = r11.f2297q;
        if (r12 != (-1)) goto L8;
        WeakHashMap<View, h0> r13 = j0.w.f8437a;
        r12 = j0.w.d.c(r11.f2281a);
    L8:
        r11.f2296p = r12;
        r10.f2300a.setChildImportantForAccessibilityInternal(r11, 4);
        return;
    }

    public final boolean j(View r8) {
        return this.f2436c.contains(r8);
    }

    public final void k(View r8) {
        if (this.f2436c.remove(r8) == false) goto L8;
        RecyclerView.e r10 = (RecyclerView.e) this.f2434a;
        r10.getClass();
        RecyclerView.c0 r11 = RecyclerView.getChildViewHolderInt(r8);
        if (r11 == null) goto L9;
        int r12 = r11.f2296p;
        r10.f2300a.setChildImportantForAccessibilityInternal(r11, r12);
        r11.f2296p = 0;
        return;
    L9:
        return;
    }

    public final String toString() {
        return this.f2435b.toString() + ", hidden list:" + this.f2436c.size();
    }
}
