package androidx.room;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f2649a;

    public j(i r8) {
        this.f2649a = r8;
    }

    public final zd.f a() {
        i r8 = this.f2649a;
        zd.f r10 = new zd.f();
        Cursor r11 = r.query$default(r8.f2623a, new a1.a("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"), null, 2, null);
    L24:
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        defpackage.c.A(r11, th);
        throw th;
    L4:
        if (r11.moveToNext() == false) goto L6;
        r10.add(Integer.valueOf(r11.getInt(0)));     // Catch: Throwable -> L19
        goto L24
    L6:
        xd.j r12 = xd.j.f13877a;     // Catch: Throwable -> L19
        defpackage.c.A(r11, null);
        l6.a.r(r10);
        if ((!r10.isEmpty()) == true) goto L10;
    L18:
        return r10;
    L10:
        if (this.f2649a.f2630h == null) goto L17;
        a1.f r13 = this.f2649a.f2630h;
        if (r13 == null) goto L15;
        r13.g();
        goto L18
    L15:
        throw new IllegalArgumentException("Required value was null.".toString());
    L17:
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // java.lang.Runnable
    public final void run() {
        Lock r8 = this.f2649a.f2623a.getCloseLock$room_runtime_release();
        r8.lock();
    L19:
        th = move-exception;
        r8.unlock();
        this.f2649a.getClass();
        throw th;
    L21:
        e = move-exception;
        Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);     // Catch: Throwable -> L19
    L23:
        Set<Integer> r10 = yd.m.f14121a;     // Catch: Throwable -> L19
    L27:
        r8.unlock();
        this.f2649a.getClass();
        if ((!r10.isEmpty()) == false) goto L41;
        i r11 = this.f2649a;
        j.b<i.c, i.d> r12 = r11.f2633k;
        monitor-enter(r12);
        Iterator<Map.Entry<i.c, i.d>> r13 = r11.f2633k.iterator();     // Catch: Throwable -> L38
    L32:
        j.b.e r14 = (j.b.e) r13;     // Catch: Throwable -> L38
        if (r14.hasNext() == false) goto L35;
        ((i.d) ((Map.Entry) r14.next()).getValue()).a(r10);     // Catch: Throwable -> L38
        goto L32
    L35:
        xd.j r15 = xd.j.f13877a;     // Catch: Throwable -> L38
        monitor-exit(r12);
        return;
    L38:
        th = move-exception;
        throw th;
    L41:
        return;
    L24:
        e = move-exception;
        Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);     // Catch: Throwable -> L19
        goto L23
    L4:
        if (this.f2649a.c() == true) goto L8;
    L5:
        r8.unlock();
        this.f2649a.getClass();
        return;
    L8:
        if (this.f2649a.f2628f.compareAndSet(true, false) == false) goto L5;
        if (this.f2649a.f2623a.inTransaction() == true) goto L5;
        a1.b r16 = this.f2649a.f2623a.getOpenHelper().Z();     // Catch: Throwable -> L19 SQLiteException -> L21 IllegalStateException -> L24
        r16.o();     // Catch: Throwable -> L19 SQLiteException -> L21 IllegalStateException -> L24
        r10 = a();     // Catch: Throwable -> L16
        r16.m();     // Catch: Throwable -> L16
        r16.t();     // Catch: Throwable -> L19 SQLiteException -> L21 IllegalStateException -> L24
    L16:
        th = move-exception;
        r16.t();     // Catch: Throwable -> L19 SQLiteException -> L21 IllegalStateException -> L24
        throw th;     // Catch: Throwable -> L19 SQLiteException -> L21 IllegalStateException -> L24
    }
}
