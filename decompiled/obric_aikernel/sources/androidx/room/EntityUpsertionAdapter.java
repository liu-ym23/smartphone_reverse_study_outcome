package androidx.room;

import android.database.sqlite.SQLiteConstraintException;
import android.os.Build;
import androidx.annotation.RestrictTo;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class EntityUpsertionAdapter<T> {
    private final EntityInsertionAdapter<T> insertionAdapter;
    private final EntityDeletionOrUpdateAdapter<T> updateAdapter;

    public EntityUpsertionAdapter(EntityInsertionAdapter<T> r10, EntityDeletionOrUpdateAdapter<T> r11) {
        Intrinsics.checkNotNullParameter(r10, "insertionAdapter");
        Intrinsics.checkNotNullParameter(r11, "updateAdapter");
        this.insertionAdapter = r10;
        this.updateAdapter = r11;
    }

    private final void checkUniquenessException(SQLiteConstraintException r10) {
        String r11 = r10.getMessage();
        if (r11 != null) goto L5;
        throw r10;
    L5:
        if (Build.VERSION.SDK_INT > 19) goto L11;
        if (StringsKt.contains(r11, "unique", true) == true) goto L15;
        throw r10;
    L15:
        return;
    L11:
        if (StringsKt.contains(r11, "1555", true) == false) goto L13;
        return;
    L13:
        throw r10;
    }

    public final void upsert(Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "entities");
        Iterator<? extends T> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        T r12 = r11.next();
        this.insertionAdapter.insert(r12);     // Catch: SQLiteConstraintException -> L8
    L8:
        e = move-exception;
        checkUniquenessException(e);
        this.updateAdapter.handle(r12);
        goto L4
    }

    public final void upsert(T r10) {
        this.insertionAdapter.insert(r10);     // Catch: SQLiteConstraintException -> L4
        return;
    L4:
        e = move-exception;
        checkUniquenessException(e);
        this.updateAdapter.handle(r10);
    }

    public final void upsert(T[] r10) {
        Intrinsics.checkNotNullParameter(r10, "entities");
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L10;
        T r13 = r10[r12];
        this.insertionAdapter.insert(r13);     // Catch: SQLiteConstraintException -> L7
    L9:
        r12 = r12 + 1;
    L7:
        e = move-exception;
        checkUniquenessException(e);
        this.updateAdapter.handle(r13);
        goto L9
    }

    public final long upsertAndReturnId(T r10) {
        return this.insertionAdapter.insertAndReturnId(r10);
    L4:
        e = move-exception;
        checkUniquenessException(e);
        this.updateAdapter.handle(r10);
        return -1;
    }

    public final long[] upsertAndReturnIdsArray(Collection<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "entities");
        Iterator<? extends T> r11 = r10.iterator();
        int r12 = r10.size();
        long[] r13 = new long[r12];
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L10;
        T r15 = r11.next();
        long r16 = this.insertionAdapter.insertAndReturnId(r15);     // Catch: SQLiteConstraintException -> L7
    L9:
        r13[r14] = r16;
        r14 = r14 + 1;
    L7:
        e = move-exception;
        checkUniquenessException(e);
        this.updateAdapter.handle(r15);
        r16 = -1;
        goto L9
    L10:
        return r13;
    }

    public final long[] upsertAndReturnIdsArray(T[] r10) {
        Intrinsics.checkNotNullParameter(r10, "entities");
        int r11 = r10.length;
        long[] r12 = new long[r11];
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L9;
        long r14 = this.insertionAdapter.insertAndReturnId(r10[r13]);     // Catch: SQLiteConstraintException -> L6
    L8:
        r12[r13] = r14;
        r13 = r13 + 1;
    L6:
        e = move-exception;
        checkUniquenessException(e);
        this.updateAdapter.handle(r10[r13]);
        r14 = -1;
        goto L8
    L9:
        return r12;
    }

    public final Long[] upsertAndReturnIdsArrayBox(Collection<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "entities");
        Iterator<? extends T> r11 = r10.iterator();
        int r12 = r10.size();
        Long[] r13 = new Long[r12];
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L10;
        T r15 = r11.next();
        long r16 = this.insertionAdapter.insertAndReturnId(r15);     // Catch: SQLiteConstraintException -> L7
    L9:
        r13[r14] = Long.valueOf(r16);
        r14 = r14 + 1;
    L7:
        e = move-exception;
        checkUniquenessException(e);
        this.updateAdapter.handle(r15);
        r16 = -1;
        goto L9
    L10:
        return r13;
    }

    public final Long[] upsertAndReturnIdsArrayBox(T[] r10) {
        Intrinsics.checkNotNullParameter(r10, "entities");
        int r11 = r10.length;
        Long[] r12 = new Long[r11];
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L9;
        long r14 = this.insertionAdapter.insertAndReturnId(r10[r13]);     // Catch: SQLiteConstraintException -> L6
    L8:
        r12[r13] = Long.valueOf(r14);
        r13 = r13 + 1;
    L6:
        e = move-exception;
        checkUniquenessException(e);
        this.updateAdapter.handle(r10[r13]);
        r14 = -1;
        goto L8
    L9:
        return r12;
    }

    public final List<Long> upsertAndReturnIdsList(Collection<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "entities");
        List r11 = CollectionsKt.createListBuilder();
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        T r13 = r12.next();
        r11.add(Long.valueOf(this.insertionAdapter.insertAndReturnId(r13)));     // Catch: SQLiteConstraintException -> L8
    L8:
        e = move-exception;
        checkUniquenessException(e);
        this.updateAdapter.handle(r13);
        r11.add(-1L);
        goto L4
    L11:
        return CollectionsKt.build(r11);
    }

    public final List<Long> upsertAndReturnIdsList(T[] r10) {
        Intrinsics.checkNotNullParameter(r10, "entities");
        List r11 = CollectionsKt.createListBuilder();
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L11;
        T r14 = r10[r13];
        r11.add(Long.valueOf(this.insertionAdapter.insertAndReturnId(r14)));     // Catch: SQLiteConstraintException -> L7
    L9:
        r13 = r13 + 1;
    L7:
        e = move-exception;
        checkUniquenessException(e);
        this.updateAdapter.handle(r14);
        r11.add(-1L);
        goto L9
    L11:
        return CollectionsKt.build(r11);
    }
}
