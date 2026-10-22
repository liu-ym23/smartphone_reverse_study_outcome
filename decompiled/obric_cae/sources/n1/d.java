package n1;

import androidx.work.m;
import he.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import o1.f;
import p1.h;
import r1.t;
import xd.j;

/* JADX INFO: loaded from: classes.dex */
public final class d implements o1.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f9423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o1.c<?>[] f9424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f9425c;

    public d(p.c r10, c r11) {
        i.f(r10, "trackers");
        o1.a r8 = new o1.a((h) r10.f9866a, 0);
        o1.b r12 = new o1.b((p1.c) r10.f9867b);
        o1.b r13 = new o1.b((h) r10.f9869d);
        Object r14 = r10.f9868c;
        o1.c<?>[] r15 = {r8, r12, r13, new o1.d((h) r14), new o1.a((h) r14, 1), new f((h) r14), new o1.e((h) r14)};
        this.f9423a = r11;
        this.f9424b = r15;
        this.f9425c = new Object();
    }

    @Override // o1.c.a
    public final void a(ArrayList r8) {
        i.f(r8, "workSpecs");
        Object r10 = this.f9425c;
        monitor-enter(r10);
        c r11 = this.f9423a;     // Catch: Throwable -> L9
        if (r11 == null) goto L7;
        r11.c(r8);     // Catch: Throwable -> L9
        j r12 = j.f13877a;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r10);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // o1.c.a
    public final void b(ArrayList r8) {
        i.f(r8, "workSpecs");
        Object r10 = this.f9425c;
        monitor-enter(r10);
        ArrayList r11 = new ArrayList();     // Catch: Throwable -> L19
        Iterator r12 = r8.iterator();     // Catch: Throwable -> L19
    L6:
        if (r12.hasNext() == false) goto L10;
        Object r13 = r12.next();     // Catch: Throwable -> L19
        if (c(((t) r13).f11339a) == false) goto L6;
        r11.add(r13);     // Catch: Throwable -> L19
        goto L6
    L10:
        Iterator r14 = r11.iterator();     // Catch: Throwable -> L19
    L12:
        if (r14.hasNext() == false) goto L14;
        t r15 = (t) r14.next();     // Catch: Throwable -> L19
        m.d().a(e.f9426a, "Constraints met for " + r15);     // Catch: Throwable -> L19
        goto L12
    L14:
        c r16 = this.f9423a;     // Catch: Throwable -> L19
        if (r16 == null) goto L17;
        r16.e(r11);     // Catch: Throwable -> L19
        j r17 = j.f13877a;     // Catch: Throwable -> L19
    L17:
        monitor-exit(r10);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public final boolean c(String r8) {
        i.f(r8, "workSpecId");
        Object r10 = this.f9425c;
        monitor-enter(r10);
        o1.c<?>[] r11 = this.f9424b;     // Catch: Throwable -> L25
        int r12 = r11.length;     // Catch: Throwable -> L25
        boolean r13 = false;
        int r14 = 0;
    L6:
        if (r14 >= r12) goto L18;
        o1.c<?> r15 = r11[r14];     // Catch: Throwable -> L25
        r15.getClass();     // Catch: Throwable -> L25
        Object r16 = r15.f9615d;     // Catch: Throwable -> L25
        if (r16 != null) goto L10;
    L14:
        boolean r17 = false;
    L15:
        if (r17 == true) goto L19;
        r14 = r14 + 1;     // Catch: Throwable -> L25
    L19:
        if (r15 == null) goto L21;
        m.d().a(e.f9426a, "Work " + r8 + " constrained by " + r15.getClass().getSimpleName());     // Catch: Throwable -> L25
    L21:
        if (r15 != null) goto L23;
        r13 = true;
    L23:
        monitor-exit(r10);
        return r13;
    L10:
        if (r15.c(r16) == false) goto L14;
        if (r15.f9614c.contains(r8) == false) goto L14;
        r17 = true;
        goto L15
    L18:
        r15 = null;
    L25:
        th = move-exception;
        throw th;
    }

    public final void d(Collection r10) {
        i.f(r10, "workSpecs");
        Object r8 = this.f9425c;
        monitor-enter(r8);
        o1.c<?>[] r11 = this.f9424b;     // Catch: Throwable -> L22
        int r12 = r11.length;     // Catch: Throwable -> L22
        int r13 = 0;
        int r14 = 0;
    L5:
        if (r14 >= r12) goto L10;
        o1.c<?> r15 = r11[r14];     // Catch: Throwable -> L22
        if (r15.f9616e == null) goto L9;
        r15.f9616e = null;     // Catch: Throwable -> L22
        r15.e(null, r15.f9615d);     // Catch: Throwable -> L22
    L9:
        r14 = r14 + 1;     // Catch: Throwable -> L22
        goto L5
    L10:
        o1.c<?>[] r16 = this.f9424b;     // Catch: Throwable -> L22
        int r17 = r16.length;     // Catch: Throwable -> L22
        int r18 = 0;
    L11:
        if (r18 >= r17) goto L13;
        r16[r18].d(r10);     // Catch: Throwable -> L22
        r18 = r18 + 1;     // Catch: Throwable -> L22
        goto L11
    L13:
        o1.c<?>[] r19 = this.f9424b;     // Catch: Throwable -> L22
        int r20 = r19.length;     // Catch: Throwable -> L22
    L14:
        if (r13 >= r20) goto L19;
        o1.c<?> r21 = r19[r13];     // Catch: Throwable -> L22
        if (r21.f9616e == this) goto L18;
        r21.f9616e = this;     // Catch: Throwable -> L22
        r21.e(this, r21.f9615d);     // Catch: Throwable -> L22
    L18:
        r13 = r13 + 1;     // Catch: Throwable -> L22
        goto L14
    L19:
        j r22 = j.f13877a;     // Catch: Throwable -> L22
        monitor-exit(r8);
        return;
    L22:
        th = move-exception;
        throw th;
    }

    public final void e() {
        Object r8 = this.f9425c;
        monitor-enter(r8);
        o1.c<?>[] r10 = this.f9424b;     // Catch: Throwable -> L13
        int r11 = r10.length;     // Catch: Throwable -> L13
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L10;
        o1.c<?> r13 = r10[r12];     // Catch: Throwable -> L13
        ArrayList r14 = r13.f9613b;     // Catch: Throwable -> L13
        if ((!r14.isEmpty()) == false) goto L9;
        r14.clear();     // Catch: Throwable -> L13
        r13.f9612a.b(r13);     // Catch: Throwable -> L13
    L9:
        r12 = r12 + 1;     // Catch: Throwable -> L13
        goto L5
    L10:
        j r15 = j.f13877a;     // Catch: Throwable -> L13
        monitor-exit(r8);
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
