package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001f\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0002\u0010\rJ\u001b\u0010\f\u001a\u00020\u00072\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000f¢\u0006\u0002\u0010\u0010J\u0014\u0010\f\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0002\u0010\u0014J\u001b\u0010\u0015\u001a\u00020\u00162\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000f¢\u0006\u0002\u0010\u0017J\u0014\u0010\u0015\u001a\u00020\u00162\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018J#\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u000f2\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000f¢\u0006\u0002\u0010\u001aJ!\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018¢\u0006\u0002\u0010\u001bJ!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u001d2\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000f¢\u0006\u0002\u0010\u001eJ\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u001d2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018¨\u0006\u001f"}, d2 = {"Landroidx/room/EntityInsertionAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/room/SharedSQLiteStatement;", "database", "Landroidx/room/RoomDatabase;", "(Landroidx/room/RoomDatabase;)V", "bind", "", "statement", "Landroidx/sqlite/db/SupportSQLiteStatement;", "entity", "(Landroidx/sqlite/db/SupportSQLiteStatement;Ljava/lang/Object;)V", "insert", "(Ljava/lang/Object;)V", "entities", "", "([Ljava/lang/Object;)V", "", "insertAndReturnId", "", "(Ljava/lang/Object;)J", "insertAndReturnIdsArray", "", "([Ljava/lang/Object;)[J", "", "insertAndReturnIdsArrayBox", "([Ljava/lang/Object;)[Ljava/lang/Long;", "(Ljava/util/Collection;)[Ljava/lang/Long;", "insertAndReturnIdsList", "", "([Ljava/lang/Object;)Ljava/util/List;", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class EntityInsertionAdapter<T> extends SharedSQLiteStatement {
    public EntityInsertionAdapter(RoomDatabase r5) {
        Intrinsics.checkNotNullParameter(r5, "database");
        super(r5);
    }

    public abstract void bind(SupportSQLiteStatement r5, T r10);

    public final void insert(T r5) {
        SupportSQLiteStatement r10 = acquire();
        bind(r10, r5);     // Catch: Throwable -> L6
        r10.executeInsert();     // Catch: Throwable -> L6
        release(r10);
        return;
    L6:
        th = move-exception;
        release(r10);
        throw th;
    }

    public final long insertAndReturnId(T r5) {
        SupportSQLiteStatement r10 = acquire();
        bind(r10, r5);     // Catch: Throwable -> L6
        long r11 = r10.executeInsert();     // Catch: Throwable -> L6
        release(r10);
        return r11;
    L6:
        th = move-exception;
        release(r10);
        throw th;
    }

    public final long[] insertAndReturnIdsArray(Collection<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "entities");
        SupportSQLiteStatement r5 = acquire();
        long[] r11 = new long[r10.size()];     // Catch: Throwable -> L9
        Iterator<T> r12 = r10.iterator();     // Catch: Throwable -> L9
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L13;
        T r14 = r12.next();     // Catch: Throwable -> L9
        int r15 = r13 + 1;     // Catch: Throwable -> L9
        if (r13 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L9
    L11:
        bind(r5, r14);     // Catch: Throwable -> L9
        r11[r13] = r5.executeInsert();     // Catch: Throwable -> L9
        r13 = r15;
        goto L4
    L13:
        release(r5);
        return r11;
    L9:
        th = move-exception;
        release(r5);
        throw th;
    }

    public final Long[] insertAndReturnIdsArrayBox(Collection<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "entities");
        SupportSQLiteStatement r5 = acquire();
        Iterator<? extends T> r11 = r10.iterator();
        int r12 = r10.size();     // Catch: Throwable -> L7
        Long[] r13 = new Long[r12];     // Catch: Throwable -> L7
        int r14 = 0;
    L4:
        if (r14 >= r12) goto L9;
        bind(r5, r11.next());     // Catch: Throwable -> L7
        r13[r14] = Long.valueOf(r5.executeInsert());     // Catch: Throwable -> L7
        r14 = r14 + 1;
        goto L4
    L9:
        release(r5);
        return r13;
    L7:
        th = move-exception;
        release(r5);
        throw th;
    }

    public final List<Long> insertAndReturnIdsList(T[] r10) {
        Intrinsics.checkNotNullParameter(r10, "entities");
        SupportSQLiteStatement r5 = acquire();
        List r11 = CollectionsKt.createListBuilder();     // Catch: Throwable -> L6
        int r12 = r10.length;     // Catch: Throwable -> L6
        int r13 = 0;
    L4:
        if (r13 >= r12) goto L8;
        bind(r5, r10[r13]);     // Catch: Throwable -> L6
        r11.add(Long.valueOf(r5.executeInsert()));     // Catch: Throwable -> L6
        r13 = r13 + 1;     // Catch: Throwable -> L6
        goto L4
    L8:
        List<Long> r14 = CollectionsKt.build(r11);     // Catch: Throwable -> L6
        release(r5);
        return r14;
    L6:
        th = move-exception;
        release(r5);
        throw th;
    }

    public final void insert(T[] r5) {
        Intrinsics.checkNotNullParameter(r5, "entities");
        SupportSQLiteStatement r10 = acquire();
        int r11 = r5.length;     // Catch: Throwable -> L7
        int r12 = 0;
    L4:
        if (r12 >= r11) goto L9;
        bind(r10, r5[r12]);     // Catch: Throwable -> L7
        r10.executeInsert();     // Catch: Throwable -> L7
        r12 = r12 + 1;
        goto L4
    L9:
        release(r10);
        return;
    L7:
        th = move-exception;
        release(r10);
        throw th;
    }

    public final long[] insertAndReturnIdsArray(T[] r10) {
        Intrinsics.checkNotNullParameter(r10, "entities");
        SupportSQLiteStatement r5 = acquire();
        long[] r11 = new long[r10.length];     // Catch: Throwable -> L7
        int r12 = r10.length;     // Catch: Throwable -> L7
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r13 >= r12) goto L9;
        int r15 = r14 + 1;     // Catch: Throwable -> L7
        bind(r5, r10[r13]);     // Catch: Throwable -> L7
        r11[r14] = r5.executeInsert();     // Catch: Throwable -> L7
        r13 = r13 + 1;
        r14 = r15;
        goto L4
    L9:
        release(r5);
        return r11;
    L7:
        th = move-exception;
        release(r5);
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Long[] insertAndReturnIdsArrayBox(T[] r10) {
        Intrinsics.checkNotNullParameter(r10, "entities");
        SupportSQLiteStatement r5 = acquire();
        Iterator r11 = ArrayIteratorKt.iterator(r10);
        int r12 = r10.length;     // Catch: Throwable -> L7
        Long[] r13 = new Long[r12];     // Catch: Throwable -> L7
        int r14 = 0;
    L4:
        if (r14 >= r12) goto L9;
        bind(r5, r11.next());     // Catch: Throwable -> L7
        r13[r14] = Long.valueOf(r5.executeInsert());     // Catch: Throwable -> L7
        r14 = r14 + 1;
        goto L4
    L9:
        release(r5);
        return r13;
    L7:
        th = move-exception;
        release(r5);
        throw th;
    }

    public final List<Long> insertAndReturnIdsList(Collection<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "entities");
        SupportSQLiteStatement r10 = acquire();
        List r11 = CollectionsKt.createListBuilder();     // Catch: Throwable -> L7
        Iterator<T> r12 = r5.iterator();     // Catch: Throwable -> L7
    L5:
        if (r12.hasNext() == false) goto L9;
        bind(r10, r12.next());     // Catch: Throwable -> L7
        r11.add(Long.valueOf(r10.executeInsert()));     // Catch: Throwable -> L7
        goto L5
    L9:
        List<Long> r13 = CollectionsKt.build(r11);     // Catch: Throwable -> L7
        release(r10);
        return r13;
    L7:
        th = move-exception;
        release(r10);
        throw th;
    }

    public final void insert(Iterable<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "entities");
        SupportSQLiteStatement r10 = acquire();
        Iterator<? extends T> r11 = r5.iterator();     // Catch: Throwable -> L8
    L5:
        if (r11.hasNext() == false) goto L10;
        bind(r10, r11.next());     // Catch: Throwable -> L8
        r10.executeInsert();     // Catch: Throwable -> L8
        goto L5
    L10:
        release(r10);
        return;
    L8:
        th = move-exception;
        release(r10);
        throw th;
    }
}
