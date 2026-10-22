package androidx.room;

import android.database.sqlite.SQLiteConstraintException;
import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B!\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0013\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u000eJ\u001b\u0010\f\u001a\u00020\t2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0010¢\u0006\u0002\u0010\u0011J\u0014\u0010\f\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u0015J\u001b\u0010\u0016\u001a\u00020\u00172\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0010¢\u0006\u0002\u0010\u0018J\u0014\u0010\u0016\u001a\u00020\u00172\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019J#\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u00102\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0010¢\u0006\u0002\u0010\u001bJ!\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019¢\u0006\u0002\u0010\u001cJ!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\u001e2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0010¢\u0006\u0002\u0010\u001fJ\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\u001e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Landroidx/room/EntityUpsertionAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "", "insertionAdapter", "Landroidx/room/EntityInsertionAdapter;", "updateAdapter", "Landroidx/room/EntityDeletionOrUpdateAdapter;", "(Landroidx/room/EntityInsertionAdapter;Landroidx/room/EntityDeletionOrUpdateAdapter;)V", "checkUniquenessException", "", "ex", "Landroid/database/sqlite/SQLiteConstraintException;", "upsert", "entity", "(Ljava/lang/Object;)V", "entities", "", "([Ljava/lang/Object;)V", "", "upsertAndReturnId", "", "(Ljava/lang/Object;)J", "upsertAndReturnIdsArray", "", "([Ljava/lang/Object;)[J", "", "upsertAndReturnIdsArrayBox", "([Ljava/lang/Object;)[Ljava/lang/Long;", "(Ljava/util/Collection;)[Ljava/lang/Long;", "upsertAndReturnIdsList", "", "([Ljava/lang/Object;)Ljava/util/List;", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class EntityUpsertionAdapter<T> {
    private final EntityInsertionAdapter<T> insertionAdapter;
    private final EntityDeletionOrUpdateAdapter<T> updateAdapter;

    public EntityUpsertionAdapter(EntityInsertionAdapter<T> r5, EntityDeletionOrUpdateAdapter<T> r10) {
        Intrinsics.checkNotNullParameter(r5, "insertionAdapter");
        Intrinsics.checkNotNullParameter(r10, "updateAdapter");
        this.insertionAdapter = r5;
        this.updateAdapter = r10;
    }

    private final void checkUniquenessException(SQLiteConstraintException r5) {
        String r10 = r5.getMessage();
        if (r10 != null) goto L5;
        throw r5;
    L5:
        if (StringsKt.e(r10, "1555", true) == false) goto L7;
        return;
    L7:
        throw r5;
    }

    public final void upsert(T r5) {
        this.insertionAdapter.insert(r5);     // Catch: SQLiteConstraintException -> L4
        return;
    L4:
        e = move-exception;
        checkUniquenessException(e);
        this.updateAdapter.handle(r5);
    }

    public final long upsertAndReturnId(T r5) {
        return this.insertionAdapter.insertAndReturnId(r5);
    L4:
        e = move-exception;
        checkUniquenessException(e);
        this.updateAdapter.handle(r5);
        return -1;
    }

    public final long[] upsertAndReturnIdsArray(T[] r10) {
        Intrinsics.checkNotNullParameter(r10, "entities");
        int r5 = r10.length;
        long[] r11 = new long[r5];
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L9;
        long r13 = this.insertionAdapter.insertAndReturnId(r10[r12]);     // Catch: SQLiteConstraintException -> L6
    L8:
        r11[r12] = r13;
        r12 = r12 + 1;
    L6:
        e = move-exception;
        checkUniquenessException(e);
        this.updateAdapter.handle(r10[r12]);
        r13 = -1;
        goto L8
    L9:
        return r11;
    }

    public final Long[] upsertAndReturnIdsArrayBox(T[] r10) {
        Intrinsics.checkNotNullParameter(r10, "entities");
        int r5 = r10.length;
        Long[] r11 = new Long[r5];
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L9;
        long r13 = this.insertionAdapter.insertAndReturnId(r10[r12]);     // Catch: SQLiteConstraintException -> L6
    L8:
        r11[r12] = Long.valueOf(r13);
        r12 = r12 + 1;
    L6:
        e = move-exception;
        checkUniquenessException(e);
        this.updateAdapter.handle(r10[r12]);
        r13 = -1;
        goto L8
    L9:
        return r11;
    }

    public final List<Long> upsertAndReturnIdsList(T[] r10) {
        Intrinsics.checkNotNullParameter(r10, "entities");
        List r5 = CollectionsKt.createListBuilder();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L11;
        T r13 = r10[r12];
        r5.add(Long.valueOf(this.insertionAdapter.insertAndReturnId(r13)));     // Catch: SQLiteConstraintException -> L7
    L9:
        r12 = r12 + 1;
    L7:
        e = move-exception;
        checkUniquenessException(e);
        this.updateAdapter.handle(r13);
        r5.add(-1L);
        goto L9
    L11:
        return CollectionsKt.build(r5);
    }

    public final void upsert(T[] r5) {
        Intrinsics.checkNotNullParameter(r5, "entities");
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L10;
        T r12 = r5[r11];
        this.insertionAdapter.insert(r12);     // Catch: SQLiteConstraintException -> L7
    L9:
        r11 = r11 + 1;
    L7:
        e = move-exception;
        checkUniquenessException(e);
        this.updateAdapter.handle(r12);
        goto L9
    }

    public final long[] upsertAndReturnIdsArray(Collection<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "entities");
        Iterator<? extends T> r5 = r10.iterator();
        int r11 = r10.size();
        long[] r12 = new long[r11];
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L10;
        T r14 = r5.next();
        long r15 = this.insertionAdapter.insertAndReturnId(r14);     // Catch: SQLiteConstraintException -> L7
    L9:
        r12[r13] = r15;
        r13 = r13 + 1;
    L7:
        e = move-exception;
        checkUniquenessException(e);
        this.updateAdapter.handle(r14);
        r15 = -1;
        goto L9
    L10:
        return r12;
    }

    public final Long[] upsertAndReturnIdsArrayBox(Collection<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "entities");
        Iterator<? extends T> r5 = r10.iterator();
        int r11 = r10.size();
        Long[] r12 = new Long[r11];
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L10;
        T r14 = r5.next();
        long r15 = this.insertionAdapter.insertAndReturnId(r14);     // Catch: SQLiteConstraintException -> L7
    L9:
        r12[r13] = Long.valueOf(r15);
        r13 = r13 + 1;
    L7:
        e = move-exception;
        checkUniquenessException(e);
        this.updateAdapter.handle(r14);
        r15 = -1;
        goto L9
    L10:
        return r12;
    }

    public final void upsert(Iterable<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "entities");
        Iterator<? extends T> r10 = r5.iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        T r11 = r10.next();
        this.insertionAdapter.insert(r11);     // Catch: SQLiteConstraintException -> L8
    L8:
        e = move-exception;
        checkUniquenessException(e);
        this.updateAdapter.handle(r11);
        goto L4
    }

    public final List<Long> upsertAndReturnIdsList(Collection<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "entities");
        List r10 = CollectionsKt.createListBuilder();
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        T r12 = r11.next();
        r10.add(Long.valueOf(this.insertionAdapter.insertAndReturnId(r12)));     // Catch: SQLiteConstraintException -> L8
    L8:
        e = move-exception;
        checkUniquenessException(e);
        this.updateAdapter.handle(r12);
        r10.add(-1L);
        goto L4
    L11:
        return CollectionsKt.build(r10);
    }
}
