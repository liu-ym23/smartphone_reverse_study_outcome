package androidx.room;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class e<T> extends x {
    public e(r r8) {
        he.i.f(r8, "database");
        super(r8);
    }

    public abstract void bind(a1.f r8, T r10);

    @Override // androidx.room.x
    public abstract String createQuery();

    public final int handle(T r8) {
        a1.f r10 = acquire();
        bind(r10, r8);     // Catch: Throwable -> L6
        int r11 = r10.g();     // Catch: Throwable -> L6
        release(r10);
        return r11;
    L6:
        th = move-exception;
        release(r10);
        throw th;
    }

    public final int handleMultiple(Iterable<? extends T> r8) {
        he.i.f(r8, "entities");
        a1.f r10 = acquire();
        Iterator<? extends T> r11 = r8.iterator();     // Catch: Throwable -> L10
        int r12 = 0;
    L5:
        if (r11.hasNext() == false) goto L8;
        bind(r10, r11.next());     // Catch: Throwable -> L10
        r12 = r12 + r10.g();
        goto L5
    L8:
        release(r10);
        return r12;
    L10:
        th = move-exception;
        release(r10);
        throw th;
    }

    public final int handleMultiple(T[] r8) {
        he.i.f(r8, "entities");
        a1.f r10 = acquire();
        int r11 = r8.length;     // Catch: Throwable -> L9
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r12 >= r11) goto L7;
        bind(r10, r8[r12]);     // Catch: Throwable -> L9
        r13 = r13 + r10.g();
        r12 = r12 + 1;
        goto L4
    L7:
        release(r10);
        return r13;
    L9:
        th = move-exception;
        release(r10);
        throw th;
    }
}
