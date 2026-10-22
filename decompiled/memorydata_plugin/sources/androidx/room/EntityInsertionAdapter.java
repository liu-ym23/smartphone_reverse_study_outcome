package androidx.room;

import androidx.exifinterface.media.ExifInterface;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001f\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0002\u0010\rJ\u001b\u0010\f\u001a\u00020\u00072\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000f¢\u0006\u0002\u0010\u0010J\u0014\u0010\f\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0002\u0010\u0014J\u001b\u0010\u0015\u001a\u00020\u00162\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000f¢\u0006\u0002\u0010\u0017J\u0014\u0010\u0015\u001a\u00020\u00162\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018J#\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u000f2\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000f¢\u0006\u0002\u0010\u001aJ!\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018¢\u0006\u0002\u0010\u001bJ!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u001d2\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000f¢\u0006\u0002\u0010\u001eJ\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u001d2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018¨\u0006\u001f"}, d2 = {"Landroidx/room/EntityInsertionAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/room/SharedSQLiteStatement;", "database", "Landroidx/room/RoomDatabase;", "(Landroidx/room/RoomDatabase;)V", "bind", "", "statement", "Landroidx/sqlite/db/SupportSQLiteStatement;", "entity", "(Landroidx/sqlite/db/SupportSQLiteStatement;Ljava/lang/Object;)V", "insert", "(Ljava/lang/Object;)V", "entities", "", "([Ljava/lang/Object;)V", "", "insertAndReturnId", "", "(Ljava/lang/Object;)J", "insertAndReturnIdsArray", "", "([Ljava/lang/Object;)[J", "", "insertAndReturnIdsArrayBox", "([Ljava/lang/Object;)[Ljava/lang/Long;", "(Ljava/util/Collection;)[Ljava/lang/Long;", "insertAndReturnIdsList", "", "([Ljava/lang/Object;)Ljava/util/List;", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class EntityInsertionAdapter<T> extends SharedSQLiteStatement {
    public EntityInsertionAdapter(RoomDatabase r2) {
        Intrinsics.checkNotNullParameter(r2, "database");
        super(r2);
    }

    public abstract void bind(SupportSQLiteStatement r1, T r2);

    public final void insert(Iterable<? extends T> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "entities");
        SupportSQLiteStatement r0 = acquire();
        Iterator<T> r5 = r4.iterator();     // Catch: Throwable -> L10
    L5:
        if (r5.hasNext() == false) goto L8;
        bind(r0, r5.next());     // Catch: Throwable -> L10
        r0.executeInsert();     // Catch: Throwable -> L10
        goto L5
    L8:
        release(r0);
        return;
    L10:
        th = move-exception;
        release(r0);
        throw th;
    }

    public final void insert(T r2) {
        SupportSQLiteStatement r0 = acquire();
        bind(r0, r2);     // Catch: Throwable -> L6
        r0.executeInsert();     // Catch: Throwable -> L6
        release(r0);
        return;
    L6:
        th = move-exception;
        release(r0);
        throw th;
    }

    public final void insert(T[] r5) {
        Intrinsics.checkNotNullParameter(r5, "entities");
        SupportSQLiteStatement r0 = acquire();
        int r1 = 0;
        int r2 = r5.length;     // Catch: Throwable -> L9
    L4:
        if (r1 >= r2) goto L7;
        bind(r0, r5[r1]);     // Catch: Throwable -> L9
        r0.executeInsert();     // Catch: Throwable -> L9
        r1 = r1 + 1;
        goto L4
    L7:
        release(r0);
        return;
    L9:
        th = move-exception;
        release(r0);
        throw th;
    }

    public final long insertAndReturnId(T r4) {
        SupportSQLiteStatement r0 = acquire();
        bind(r0, r4);     // Catch: Throwable -> L6
        long r1 = r0.executeInsert();     // Catch: Throwable -> L6
        release(r0);
        return r1;
    L6:
        th = move-exception;
        release(r0);
        throw th;
    }

    public final long[] insertAndReturnIdsArray(Collection<? extends T> r8) {
        Collection r9 = (Collection) ZeusTransformUtils.wrapperContextForParams(r8, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "entities");
        SupportSQLiteStatement r0 = acquire();
        long[] r2 = new long[r9.size()];     // Catch: Throwable -> L13
        int r1 = 0;
        Iterator<T> r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L13
    L4:
        if (r10.hasNext() == false) goto L11;
        T r3 = r10.next();     // Catch: Throwable -> L13
        int r4 = r1 + 1;     // Catch: Throwable -> L13
        if (r1 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L13
    L9:
        bind(r0, r3);     // Catch: Throwable -> L13
        r2[r1] = r0.executeInsert();     // Catch: Throwable -> L13
        r1 = r4;
        goto L4
    L11:
        release(r0);
        return r2;
    L13:
        th = move-exception;
        release(r0);
        throw th;
    }

    public final long[] insertAndReturnIdsArray(T[] r10) {
        Intrinsics.checkNotNullParameter(r10, "entities");
        SupportSQLiteStatement r0 = acquire();
        long[] r1 = new long[r10.length];     // Catch: Throwable -> L9
        int r2 = r10.length;     // Catch: Throwable -> L9
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r3 >= r2) goto L7;
        int r6 = r4 + 1;     // Catch: Throwable -> L9
        bind(r0, r10[r3]);     // Catch: Throwable -> L9
        r1[r4] = r0.executeInsert();     // Catch: Throwable -> L9
        r3 = r3 + 1;
        r4 = r6;
        goto L4
    L7:
        release(r0);
        return r1;
    L9:
        th = move-exception;
        release(r0);
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Long[] insertAndReturnIdsArrayBox(Collection<? extends T> r7) {
        Collection r8 = (Collection) ZeusTransformUtils.wrapperContextForParams(r7, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "entities");
        SupportSQLiteStatement r0 = acquire();
        Iterator r1 = r8.iterator();
        int r2 = 0;
        int r9 = r8.size();     // Catch: Throwable -> L9
        Long[] r3 = new Long[r9];     // Catch: Throwable -> L9
    L4:
        if (r2 >= r9) goto L7;
        bind(r0, r1.next());     // Catch: Throwable -> L9
        r3[r2] = Long.valueOf(r0.executeInsert());     // Catch: Throwable -> L9
        r2 = r2 + 1;
        goto L4
    L7:
        release(r0);
        return r3;
    L9:
        th = move-exception;
        release(r0);
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Long[] insertAndReturnIdsArrayBox(T[] r7) {
        Intrinsics.checkNotNullParameter(r7, "entities");
        SupportSQLiteStatement r0 = acquire();
        Iterator r1 = ArrayIteratorKt.iterator(r7);
        int r2 = 0;
        int r8 = r7.length;     // Catch: Throwable -> L9
        Long[] r3 = new Long[r8];     // Catch: Throwable -> L9
    L4:
        if (r2 >= r8) goto L7;
        bind(r0, r1.next());     // Catch: Throwable -> L9
        r3[r2] = Long.valueOf(r0.executeInsert());     // Catch: Throwable -> L9
        r2 = r2 + 1;
        goto L4
    L7:
        release(r0);
        return r3;
    L9:
        th = move-exception;
        release(r0);
        throw th;
    }

    public final List<Long> insertAndReturnIdsList(Collection<? extends T> r6) {
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "entities");
        SupportSQLiteStatement r0 = acquire();
        List r2 = CollectionsKt.createListBuilder();     // Catch: Throwable -> L10
        Iterator<T> r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L10
    L5:
        if (r8.hasNext() == false) goto L7;
        bind(r0, r8.next());     // Catch: Throwable -> L10
        r2.add(Long.valueOf(r0.executeInsert()));     // Catch: Throwable -> L10
        goto L5
    L7:
        List<Long> r9 = CollectionsKt.build(r2);     // Catch: Throwable -> L10
        release(r0);
        return r9;
    L10:
        th = move-exception;
        release(r0);
        throw th;
    }

    public final List<Long> insertAndReturnIdsList(T[] r7) {
        Intrinsics.checkNotNullParameter(r7, "entities");
        SupportSQLiteStatement r0 = acquire();
        List r1 = CollectionsKt.createListBuilder();     // Catch: Throwable -> L9
        int r2 = 0;
        int r3 = r7.length;     // Catch: Throwable -> L9
    L4:
        if (r2 >= r3) goto L6;
        bind(r0, r7[r2]);     // Catch: Throwable -> L9
        r1.add(Long.valueOf(r0.executeInsert()));     // Catch: Throwable -> L9
        r2 = r2 + 1;     // Catch: Throwable -> L9
        goto L4
    L6:
        List<Long> r8 = CollectionsKt.build(r1);     // Catch: Throwable -> L9
        release(r0);
        return r8;
    L9:
        th = move-exception;
        release(r0);
        throw th;
    }
}
