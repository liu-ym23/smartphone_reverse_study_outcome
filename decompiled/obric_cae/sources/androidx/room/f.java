package androidx.room;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class f<T> extends x {
    public f(r r8) {
        he.i.f(r8, "database");
        super(r8);
    }

    public abstract void bind(a1.f r8, T r10);

    public final void insert(Iterable<? extends T> r8) {
        he.i.f(r8, "entities");
        a1.f r10 = acquire();
        Iterator<? extends T> r11 = r8.iterator();     // Catch: Throwable -> L10
    L5:
        if (r11.hasNext() == false) goto L8;
        bind(r10, r11.next());     // Catch: Throwable -> L10
        r10.O();     // Catch: Throwable -> L10
        goto L5
    L8:
        release(r10);
        return;
    L10:
        th = move-exception;
        release(r10);
        throw th;
    }

    public final long insertAndReturnId(T r8) {
        a1.f r10 = acquire();
        bind(r10, r8);     // Catch: Throwable -> L6
        long r11 = r10.O();     // Catch: Throwable -> L6
        release(r10);
        return r11;
    L6:
        th = move-exception;
        release(r10);
        throw th;
    }

    public final long[] insertAndReturnIdsArray(Collection<? extends T> r8) {
        he.i.f(r8, "entities");
        a1.f r10 = acquire();
        long[] r11 = new long[r8.size()];     // Catch: Throwable -> L13
        Iterator<T> r12 = r8.iterator();     // Catch: Throwable -> L13
        int r13 = 0;
    L5:
        if (r12.hasNext() == false) goto L11;
        T r14 = r12.next();     // Catch: Throwable -> L13
        int r15 = r13 + 1;     // Catch: Throwable -> L13
        if (r13 < 0) goto L9;
        bind(r10, r14);     // Catch: Throwable -> L13
        r11[r13] = r10.O();     // Catch: Throwable -> L13
        r13 = r15;
        goto L5
    L9:
        l6.a.T0();     // Catch: Throwable -> L13
        throw null;     // Catch: Throwable -> L13
    L11:
        release(r10);
        return r11;
    L13:
        th = move-exception;
        release(r10);
        throw th;
    }

    public final Long[] insertAndReturnIdsArrayBox(Collection<? extends T> r8) {
        he.i.f(r8, "entities");
        a1.f r10 = acquire();
        Iterator<? extends T> r11 = r8.iterator();
        int r12 = r8.size();     // Catch: Throwable -> L9
        Long[] r13 = new Long[r12];     // Catch: Throwable -> L9
        int r14 = 0;
    L4:
        if (r14 >= r12) goto L7;
        bind(r10, r11.next());     // Catch: Throwable -> L9
        r13[r14] = Long.valueOf(r10.O());     // Catch: Throwable -> L9
        r14 = r14 + 1;
        goto L4
    L7:
        release(r10);
        return r13;
    L9:
        th = move-exception;
        release(r10);
        throw th;
    }

    public final List<Long> insertAndReturnIdsList(Collection<? extends T> r8) {
        he.i.f(r8, "entities");
        a1.f r10 = acquire();
        zd.a r11 = new zd.a();     // Catch: Throwable -> L10
        Iterator<T> r12 = r8.iterator();     // Catch: Throwable -> L10
    L5:
        if (r12.hasNext() == false) goto L7;
        bind(r10, r12.next());     // Catch: Throwable -> L10
        r11.add(Long.valueOf(r10.O()));     // Catch: Throwable -> L10
        goto L5
    L7:
        l6.a.q(r11);     // Catch: Throwable -> L10
        release(r10);
        return r11;
    L10:
        th = move-exception;
        release(r10);
        throw th;
    }

    public final void insert(T r8) {
        a1.f r10 = acquire();
        bind(r10, r8);     // Catch: Throwable -> L6
        r10.O();     // Catch: Throwable -> L6
        release(r10);
        return;
    L6:
        th = move-exception;
        release(r10);
        throw th;
    }

    public final long[] insertAndReturnIdsArray(T[] r10) {
        he.i.f(r10, "entities");
        a1.f r8 = acquire();
        long[] r11 = new long[r10.length];     // Catch: Throwable -> L9
        int r12 = r10.length;     // Catch: Throwable -> L9
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r13 >= r12) goto L7;
        int r15 = r14 + 1;     // Catch: Throwable -> L9
        bind(r8, r10[r13]);     // Catch: Throwable -> L9
        r11[r14] = r8.O();     // Catch: Throwable -> L9
        r13 = r13 + 1;
        r14 = r15;
        goto L4
    L7:
        release(r8);
        return r11;
    L9:
        th = move-exception;
        release(r8);
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Long[] insertAndReturnIdsArrayBox(T[] r8) {
        he.i.f(r8, "entities");
        a1.f r10 = acquire();
        he.a r11 = new he.a(r8);
        int r12 = r8.length;     // Catch: Throwable -> L9
        Long[] r13 = new Long[r12];     // Catch: Throwable -> L9
        int r14 = 0;
    L4:
        if (r14 >= r12) goto L7;
        bind(r10, r11.next());     // Catch: Throwable -> L9
        r13[r14] = Long.valueOf(r10.O());     // Catch: Throwable -> L9
        r14 = r14 + 1;
        goto L4
    L7:
        release(r10);
        return r13;
    L9:
        th = move-exception;
        release(r10);
        throw th;
    }

    public final void insert(T[] r8) {
        he.i.f(r8, "entities");
        a1.f r10 = acquire();
        int r11 = r8.length;     // Catch: Throwable -> L9
        int r12 = 0;
    L4:
        if (r12 >= r11) goto L7;
        bind(r10, r8[r12]);     // Catch: Throwable -> L9
        r10.O();     // Catch: Throwable -> L9
        r12 = r12 + 1;
        goto L4
    L7:
        release(r10);
        return;
    L9:
        th = move-exception;
        release(r10);
        throw th;
    }

    public final List<Long> insertAndReturnIdsList(T[] r8) {
        he.i.f(r8, "entities");
        a1.f r10 = acquire();
        zd.a r11 = new zd.a();     // Catch: Throwable -> L9
        int r12 = r8.length;     // Catch: Throwable -> L9
        int r13 = 0;
    L4:
        if (r13 >= r12) goto L6;
        bind(r10, r8[r13]);     // Catch: Throwable -> L9
        r11.add(Long.valueOf(r10.O()));     // Catch: Throwable -> L9
        r13 = r13 + 1;     // Catch: Throwable -> L9
        goto L4
    L6:
        l6.a.q(r11);     // Catch: Throwable -> L9
        release(r10);
        return r11;
    L9:
        th = move-exception;
        release(r10);
        throw th;
    }
}
