package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class EntityInsertionAdapter<T> extends SharedSQLiteStatement {
    public EntityInsertionAdapter(RoomDatabase r10) {
        Intrinsics.checkNotNullParameter(r10, "database");
        super(r10);
    }

    protected abstract void bind(SupportSQLiteStatement r10, T r11);

    public final void insert(Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "entities");
        SupportSQLiteStatement r11 = acquire();
        Iterator<? extends T> r12 = r10.iterator();     // Catch: Throwable -> L10
    L5:
        if (r12.hasNext() == false) goto L8;
        bind(r11, r12.next());     // Catch: Throwable -> L10
        r11.executeInsert();     // Catch: Throwable -> L10
        goto L5
    L8:
        release(r11);
        return;
    L10:
        th = move-exception;
        release(r11);
        throw th;
    }

    public final void insert(T r10) {
        SupportSQLiteStatement r11 = acquire();
        bind(r11, r10);     // Catch: Throwable -> L6
        r11.executeInsert();     // Catch: Throwable -> L6
        release(r11);
        return;
    L6:
        th = move-exception;
        release(r11);
        throw th;
    }

    public final void insert(T[] r10) {
        Intrinsics.checkNotNullParameter(r10, "entities");
        SupportSQLiteStatement r11 = acquire();
        int r12 = 0;
        int r13 = r10.length;     // Catch: Throwable -> L9
    L4:
        if (r12 >= r13) goto L7;
        bind(r11, r10[r12]);     // Catch: Throwable -> L9
        r11.executeInsert();     // Catch: Throwable -> L9
        r12 = r12 + 1;
        goto L4
    L7:
        release(r11);
        return;
    L9:
        th = move-exception;
        release(r11);
        throw th;
    }

    public final long insertAndReturnId(T r10) {
        SupportSQLiteStatement r11 = acquire();
        bind(r11, r10);     // Catch: Throwable -> L6
        long r12 = r11.executeInsert();     // Catch: Throwable -> L6
        release(r11);
        return r12;
    L6:
        th = move-exception;
        release(r11);
        throw th;
    }

    public final long[] insertAndReturnIdsArray(Collection<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "entities");
        SupportSQLiteStatement r11 = acquire();
        long[] r12 = new long[r10.size()];     // Catch: Throwable -> L13
        int r13 = 0;
        Iterator<T> r14 = r10.iterator();     // Catch: Throwable -> L13
    L4:
        if (r14.hasNext() == false) goto L11;
        T r15 = r14.next();     // Catch: Throwable -> L13
        int r16 = r13 + 1;     // Catch: Throwable -> L13
        if (r13 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L13
    L9:
        bind(r11, r15);     // Catch: Throwable -> L13
        r12[r13] = r11.executeInsert();     // Catch: Throwable -> L13
        r13 = r16;
        goto L4
    L11:
        release(r11);
        return r12;
    L13:
        th = move-exception;
        release(r11);
        throw th;
    }

    public final long[] insertAndReturnIdsArray(T[] r10) {
        Intrinsics.checkNotNullParameter(r10, "entities");
        SupportSQLiteStatement r11 = acquire();
        long[] r12 = new long[r10.length];     // Catch: Throwable -> L9
        int r13 = r10.length;     // Catch: Throwable -> L9
        int r14 = 0;
        int r15 = 0;
    L4:
        if (r14 >= r13) goto L7;
        int r16 = r15 + 1;     // Catch: Throwable -> L9
        bind(r11, r10[r14]);     // Catch: Throwable -> L9
        r12[r15] = r11.executeInsert();     // Catch: Throwable -> L9
        r14 = r14 + 1;
        r15 = r16;
        goto L4
    L7:
        release(r11);
        return r12;
    L9:
        th = move-exception;
        release(r11);
        throw th;
    }

    public final Long[] insertAndReturnIdsArrayBox(Collection<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "entities");
        SupportSQLiteStatement r11 = acquire();
        Iterator<? extends T> r12 = r10.iterator();
        int r13 = 0;
        int r14 = r10.size();     // Catch: Throwable -> L9
        Long[] r15 = new Long[r14];     // Catch: Throwable -> L9
    L4:
        if (r13 >= r14) goto L7;
        bind(r11, r12.next());     // Catch: Throwable -> L9
        r15[r13] = Long.valueOf(r11.executeInsert());     // Catch: Throwable -> L9
        r13 = r13 + 1;
        goto L4
    L7:
        release(r11);
        return r15;
    L9:
        th = move-exception;
        release(r11);
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Long[] insertAndReturnIdsArrayBox(T[] r10) {
        Intrinsics.checkNotNullParameter(r10, "entities");
        SupportSQLiteStatement r11 = acquire();
        Iterator r12 = ArrayIteratorKt.iterator(r10);
        int r13 = 0;
        int r14 = r10.length;     // Catch: Throwable -> L9
        Long[] r15 = new Long[r14];     // Catch: Throwable -> L9
    L4:
        if (r13 >= r14) goto L7;
        bind(r11, r12.next());     // Catch: Throwable -> L9
        r15[r13] = Long.valueOf(r11.executeInsert());     // Catch: Throwable -> L9
        r13 = r13 + 1;
        goto L4
    L7:
        release(r11);
        return r15;
    L9:
        th = move-exception;
        release(r11);
        throw th;
    }

    public final List<Long> insertAndReturnIdsList(Collection<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "entities");
        SupportSQLiteStatement r11 = acquire();
        List r12 = CollectionsKt.createListBuilder();     // Catch: Throwable -> L10
        Iterator<T> r13 = r10.iterator();     // Catch: Throwable -> L10
    L5:
        if (r13.hasNext() == false) goto L7;
        bind(r11, r13.next());     // Catch: Throwable -> L10
        r12.add(Long.valueOf(r11.executeInsert()));     // Catch: Throwable -> L10
        goto L5
    L7:
        List<Long> r14 = CollectionsKt.build(r12);     // Catch: Throwable -> L10
        release(r11);
        return r14;
    L10:
        th = move-exception;
        release(r11);
        throw th;
    }

    public final List<Long> insertAndReturnIdsList(T[] r10) {
        Intrinsics.checkNotNullParameter(r10, "entities");
        SupportSQLiteStatement r11 = acquire();
        List r12 = CollectionsKt.createListBuilder();     // Catch: Throwable -> L9
        int r13 = 0;
        int r14 = r10.length;     // Catch: Throwable -> L9
    L4:
        if (r13 >= r14) goto L6;
        bind(r11, r10[r13]);     // Catch: Throwable -> L9
        r12.add(Long.valueOf(r11.executeInsert()));     // Catch: Throwable -> L9
        r13 = r13 + 1;     // Catch: Throwable -> L9
        goto L4
    L6:
        List<Long> r15 = CollectionsKt.build(r12);     // Catch: Throwable -> L9
        release(r11);
        return r15;
    L9:
        th = move-exception;
        release(r11);
        throw th;
    }
}
