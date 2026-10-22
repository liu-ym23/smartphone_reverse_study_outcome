package androidx.lifecycle;

import android.annotation.SuppressLint;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class n extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j.a<l, a> f2177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h.b f2178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakReference<m> f2179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2180e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2181f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2182g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<h.b> f2183h;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h.b f2184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final k f2185b;

        public a(l r8, h.b r10) {
            he.i.c(r8);
            HashMap r11 = q.f2187a;
            boolean r12 = r8 instanceof k;
            boolean r13 = r8 instanceof c;
            if (r12 == false) goto L6;
            if (r13 == false) goto L6;
            k r14 = new DefaultLifecycleObserverAdapter((c) r8, (k) r8);
        L20:
            this.f2185b = r14;
            this.f2184a = r10;
            return;
        L6:
            if (r13 == false) goto L8;
            r14 = new DefaultLifecycleObserverAdapter((c) r8, null);
            goto L20
        L8:
            if (r12 == false) goto L10;
            r14 = (k) r8;
            goto L20
        L10:
            Class<?> r15 = r8.getClass();
            if (q.c(r15) != 2) goto L19;
            Object r16 = q.f2188b.get(r15);
            he.i.c(r16);
            List r17 = (List) r16;
            int r18 = 0;
            if (r17.size() != 1) goto L15;
            r14 = new SingleGeneratedAdapterObserver(q.a((Constructor) r17.get(0), r8));
            goto L20
        L15:
            int r19 = r17.size();
            e[] r20 = new e[r19];
        L16:
            if (r18 >= r19) goto L18;
            r20[r18] = q.a((Constructor) r17.get(r18), r8);
            r18 = r18 + 1;
            goto L16
        L18:
            r14 = new CompositeGeneratedAdaptersObserver(r20);
            goto L20
        L19:
            r14 = new ReflectiveGenericLifecycleObserver(r8);
            goto L20
        }

        public final void a(m r8, h.a r10) {
            h.b r11 = r10.a();
            h.b r12 = this.f2184a;
            he.i.f(r12, "state1");
            if (r11.compareTo(r12) >= 0) goto L5;
            r12 = r11;
        L5:
            this.f2184a = r12;
            this.f2185b.onStateChanged(r8, r10);
            this.f2184a = r11;
        }
    }

    public n(m r8) {
        he.i.f(r8, "provider");
        this.f2176a = true;
        this.f2177b = new j.a();
        this.f2178c = h.b.f2158b;
        this.f2183h = new ArrayList();
        this.f2179d = new WeakReference(r8);
    }

    @Override // androidx.lifecycle.h
    public final void a(l r8) {
        he.i.f(r8, "observer");
        e("addObserver");
        h.b r10 = this.f2178c;
        h.b r11 = h.b.f2157a;
        if (r10 == r11) goto L6;
        r11 = h.b.f2158b;
    L6:
        a r12 = new a(r8, r11);
        if (this.f2177b.b(r8, r12) == null) goto L9;
        return;
    L9:
        m r13 = this.f2179d.get();
        if (r13 != null) goto L13;
        return;
    L13:
        if (this.f2180e == 0) goto L15;
    L18:
        boolean r14 = true;
    L19:
        h.b r15 = d(r8);
        this.f2180e++;
    L21:
        if (r12.f2184a.compareTo(r15) >= 0) goto L29;
        if (this.f2177b.f8355o.containsKey(r8) == false) goto L29;
        h.b r16 = r12.f2184a;
        ArrayList<h.b> r17 = this.f2183h;
        r17.add(r16);
        h.a.C0016a r18 = h.a.Companion;
        h.b r19 = r12.f2184a;
        r18.getClass();
        h.a r20 = h.a.C0016a.b(r19);
        if (r20 == null) goto L28;
        r12.a(r13, r20);
        r17.remove(r17.size() - 1);
        r15 = d(r8);
        goto L21
    L28:
        throw new IllegalStateException("no event up from " + r12.f2184a);
    L29:
        if (r14 == true) goto L31;
        i();
    L31:
        this.f2180e--;
        return;
    L15:
        if (this.f2181f == true) goto L18;
        r14 = false;
        goto L19
    }

    @Override // androidx.lifecycle.h
    public final h.b b() {
        return this.f2178c;
    }

    @Override // androidx.lifecycle.h
    public final void c(l r8) {
        he.i.f(r8, "observer");
        e("removeObserver");
        this.f2177b.c(r8);
    }

    public final h.b d(l r8) {
        j.a<l, a> r10 = this.f2177b;
        h.b r11 = null;
        if (r10.f8355o.containsKey(r8) == false) goto L5;
        j.b.c<l, a> r12 = r10.f8355o.get(r8).f8363n;
    L6:
        if (r12 == null) goto L10;
        a r13 = r12.f8361b;
        if (r13 == null) goto L10;
        h.b r14 = r13.f2184a;
    L11:
        ArrayList<h.b> r15 = this.f2183h;
        if ((!r15.isEmpty()) == false) goto L14;
        r11 = r15.get(r15.size() - 1);
    L14:
        h.b r16 = this.f2178c;
        he.i.f(r16, "state1");
        if (r14 != null) goto L17;
    L19:
        r14 = r16;
    L20:
        if (r11 == null) goto L25;
        if (r11.compareTo(r14) >= 0) goto L25;
        return r11;
    L25:
        return r14;
    L17:
        if (r14.compareTo(r16) >= 0) goto L19;
    L10:
        r14 = null;
        goto L11
    L5:
        r12 = null;
        goto L6
    }

    @SuppressLint({"RestrictedApi"})
    public final void e(String r8) {
        if (this.f2176a == true) goto L5;
        return;
    L5:
        if (i.c.A().B() == false) goto L8;
        return;
    L8:
        throw new IllegalStateException(defpackage.b.d("Method ", r8, " must be called on the main thread").toString());
    }

    public final void f(h.a r8) {
        he.i.f(r8, "event");
        e("handleLifecycleEvent");
        g(r8.a());
    }

    public final void g(h.b r8) {
        h.b r10 = this.f2178c;
        if (r10 != r8) goto L6;
        return;
    L6:
        if (r10 == h.b.f2158b) goto L8;
    L11:
        boolean r11 = true;
    L12:
        if (r11 == false) goto L25;
        this.f2178c = r8;
        if (this.f2181f == false) goto L16;
    L22:
        this.f2182g = true;
        return;
    L16:
        if (this.f2180e != 0) goto L22;
        this.f2181f = true;
        i();
        this.f2181f = false;
        if (this.f2178c != h.b.f2157a) goto L26;
        this.f2177b = new j.a();
        return;
    L26:
        return;
    L25:
        throw new IllegalStateException(("no event down from " + this.f2178c + " in component " + this.f2179d.get()).toString());
    L8:
        if (r8 != h.b.f2157a) goto L11;
        r11 = false;
        goto L12
    }

    public final void h(h.b r8) {
        he.i.f(r8, "state");
        e("setCurrentState");
        g(r8);
    }

    public final void i() {
        m r8 = this.f2179d.get();
        if (r8 == null) goto L58;
    L4:
        j.a<l, a> r10 = this.f2177b;
        if (r10.f8359n == 0) goto L11;
        j.b.c<l, a> r11 = r10.f8356a;
        he.i.c(r11);
        h.b r12 = r11.f8361b.f2184a;
        j.b.c<l, a> r13 = this.f2177b.f8357b;
        he.i.c(r13);
        h.b r14 = r13.f8361b.f2184a;
        if (r12 == r14) goto L10;
    L12:
        boolean r15 = false;
    L13:
        this.f2182g = false;
        if (r15 == true) goto L56;
        h.b r16 = this.f2178c;
        j.b.c<l, a> r17 = this.f2177b.f8356a;
        he.i.c(r17);
        int r18 = r16.compareTo(r17.f8361b.f2184a);
        ArrayList<h.b> r19 = this.f2183h;
        if (r18 >= 0) goto L34;
        j.a<l, a> r20 = this.f2177b;
        j.b.C0094b r21 = new j.b.C0094b(r20.f8357b, r20.f8356a);
        r20.f8358m.put(r21, Boolean.FALSE);
    L19:
        if (r21.hasNext() == false) goto L34;
        if (this.f2182g == true) goto L34;
        Map.Entry r22 = (Map.Entry) r21.next();
        he.i.e(r22, "next()");
        l r23 = (l) r22.getKey();
        a r24 = (a) r22.getValue();
    L24:
        if (r24.f2184a.compareTo(this.f2178c) <= 0) goto L19;
        if (this.f2182g == true) goto L19;
        if (this.f2177b.f8355o.containsKey(r23) == false) goto L19;
        h.a.C0016a r25 = h.a.Companion;
        h.b r26 = r24.f2184a;
        r25.getClass();
        h.a r27 = h.a.C0016a.a(r26);
        if (r27 == null) goto L33;
        r19.add(r27.a());
        r24.a(r8, r27);
        r19.remove(r19.size() - 1);
        goto L24
    L33:
        throw new IllegalStateException("no event down from " + r24.f2184a);
    L34:
        j.b.c<l, a> r28 = this.f2177b.f8357b;
        if (this.f2182g == true) goto L4;
        if (r28 == null) goto L4;
        if (this.f2178c.compareTo(r28.f8361b.f2184a) <= 0) goto L4;
        j.a<l, a> r29 = this.f2177b;
        r29.getClass();
        j.b.d r30 = new j.b.d(r29);
        r29.f8358m.put(r30, Boolean.FALSE);
    L41:
        if (r30.hasNext() == false) goto L4;
        if (this.f2182g == true) goto L4;
        Map.Entry r31 = (Map.Entry) r30.next();
        l r32 = (l) r31.getKey();
        a r33 = (a) r31.getValue();
    L46:
        if (r33.f2184a.compareTo(this.f2178c) >= 0) goto L41;
        if (this.f2182g == true) goto L41;
        if (this.f2177b.f8355o.containsKey(r32) == false) goto L41;
        r19.add(r33.f2184a);
        h.a.C0016a r34 = h.a.Companion;
        h.b r35 = r33.f2184a;
        r34.getClass();
        h.a r36 = h.a.C0016a.b(r35);
        if (r36 == null) goto L55;
        r33.a(r8, r36);
        r19.remove(r19.size() - 1);
        goto L46
    L55:
        throw new IllegalStateException("no event up from " + r33.f2184a);
    L56:
        return;
    L10:
        if (this.f2178c != r14) goto L12;
    L11:
        r15 = true;
        goto L13
    L58:
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
    }
}
