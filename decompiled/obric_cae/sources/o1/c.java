package o1;

import androidx.work.m;
import he.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import p1.h;
import r1.t;
import xd.j;

/* JADX INFO: loaded from: classes.dex */
public abstract class c<T> implements n1.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h<T> f9612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f9613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f9614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public T f9615d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f9616e;

    public interface a {
        void a(ArrayList r8);

        void b(ArrayList r8);
    }

    public c(h<T> r8) {
        i.f(r8, "tracker");
        this.f9612a = r8;
        this.f9613b = new ArrayList();
        this.f9614c = new ArrayList();
    }

    @Override // n1.a
    public final void a(T r8) {
        this.f9615d = r8;
        e(this.f9616e, r8);
    }

    public abstract boolean b(t r8);

    public abstract boolean c(T r8);

    public final void d(Collection r8) {
        i.f(r8, "workSpecs");
        this.f9613b.clear();
        this.f9614c.clear();
        ArrayList r10 = this.f9613b;
        Iterator<T> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        T r12 = r11.next();
        if (b((t) r12) == false) goto L4;
        r10.add(r12);
        goto L4
    L8:
        ArrayList r13 = this.f9613b;
        ArrayList r14 = this.f9614c;
        Iterator r15 = r13.iterator();
    L10:
        if (r15.hasNext() == false) goto L13;
        r14.add(((t) r15.next()).f11339a);
        goto L10
    L13:
        if (this.f9613b.isEmpty() == false) goto L15;
        this.f9612a.b(this);
    L25:
        e(this.f9616e, this.f9615d);
        return;
    L15:
        h<T> r16 = this.f9612a;
        r16.getClass();
        Object r17 = r16.f9924c;
        monitor-enter(r17);
    L27:
        th = move-exception;
        throw th;
    L18:
        if (r16.f9925d.add(this) == true) goto L20;
    L23:
        j r18 = j.f13877a;     // Catch: Throwable -> L27
        monitor-exit(r17);
        goto L25
    L20:
        if (r16.f9925d.size() != 1) goto L22;
        r16.f9926e = r16.a();     // Catch: Throwable -> L27
        m.d().a(p1.i.f9927a, r16.getClass().getSimpleName() + ": initial state = " + r16.f9926e);     // Catch: Throwable -> L27
        r16.d();     // Catch: Throwable -> L27
    L22:
        a(r16.f9926e);     // Catch: Throwable -> L27
        goto L23
    }

    public final void e(a r8, T r10) {
        ArrayList r11 = this.f9613b;
        if (r11.isEmpty() == true) goto L13;
        if (r8 == null) goto L15;
        if (r10 != null) goto L8;
    L11:
        r8.a(r11);
        return;
    L8:
        if (c(r10) == true) goto L11;
        r8.b(r11);
        return;
    L15:
        return;
    }
}
