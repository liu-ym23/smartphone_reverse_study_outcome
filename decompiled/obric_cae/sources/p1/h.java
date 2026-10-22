package p1;

import android.content.Context;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class h<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u1.a f9922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f9923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f9924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashSet<n1.a<T>> f9925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public T f9926e;

    public h(Context r8, u1.b r10) {
        this.f9922a = r10;
        Context r11 = r8.getApplicationContext();
        he.i.e(r11, "context.applicationContext");
        this.f9923b = r11;
        this.f9924c = new Object();
        this.f9925d = new LinkedHashSet();
    }

    public abstract T a();

    public final void b(o1.c r8) {
        he.i.f(r8, "listener");
        Object r10 = this.f9924c;
        monitor-enter(r10);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f9925d.remove(r8) == true) goto L7;
    L9:
        xd.j r11 = xd.j.f13877a;     // Catch: Throwable -> L12
        monitor-exit(r10);
        return;
    L7:
        if (this.f9925d.isEmpty() == false) goto L9;
        e();     // Catch: Throwable -> L12
        goto L9
    }

    public final void c(T r8) {
        Object r10 = this.f9924c;
        monitor-enter(r10);
        T r11 = this.f9926e;     // Catch: Throwable -> L13
        if (r11 != null) goto L7;
    L10:
        this.f9926e = r8;     // Catch: Throwable -> L13
        List r12 = yd.i.n1(this.f9925d);     // Catch: Throwable -> L13
        ((u1.b) this.f9922a).f12422c.execute(new androidx.room.k(3, r12, this));     // Catch: Throwable -> L13
        xd.j r13 = xd.j.f13877a;     // Catch: Throwable -> L13
        monitor-exit(r10);
        return;
    L7:
        if (he.i.a(r11, r8) == false) goto L10;
        monitor-exit(r10);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public abstract void d();

    public abstract void e();
}
