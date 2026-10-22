package androidx.room;

import androidx.exifinterface.media.ExifInterface;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0000\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001d\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH$J\u0013\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0002\u0010\u0010J\u001b\u0010\u0011\u001a\u00020\u000f2\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0013¢\u0006\u0002\u0010\u0014J\u0014\u0010\u0011\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015¨\u0006\u0016"}, d2 = {"Landroidx/room/EntityDeletionOrUpdateAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/room/SharedSQLiteStatement;", "database", "Landroidx/room/RoomDatabase;", "(Landroidx/room/RoomDatabase;)V", "bind", "", "statement", "Landroidx/sqlite/db/SupportSQLiteStatement;", "entity", "(Landroidx/sqlite/db/SupportSQLiteStatement;Ljava/lang/Object;)V", "createQuery", "", "handle", "", "(Ljava/lang/Object;)I", "handleMultiple", "entities", "", "([Ljava/lang/Object;)I", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class EntityDeletionOrUpdateAdapter<T> extends SharedSQLiteStatement {
    public EntityDeletionOrUpdateAdapter(RoomDatabase r2) {
        Intrinsics.checkNotNullParameter(r2, "database");
        super(r2);
    }

    public abstract void bind(SupportSQLiteStatement r1, T r2);

    @Override // androidx.room.SharedSQLiteStatement
    public abstract String createQuery();

    public final int handle(T r2) {
        SupportSQLiteStatement r0 = acquire();
        bind(r0, r2);     // Catch: Throwable -> L6
        int r3 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        release(r0);
        return r3;
    L6:
        th = move-exception;
        release(r0);
        throw th;
    }

    public final int handleMultiple(Iterable<? extends T> r4) {
        Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "entities");
        SupportSQLiteStatement r0 = acquire();
        int r1 = 0;
        Iterator<T> r6 = r5.iterator();     // Catch: Throwable -> L10
    L5:
        if (r6.hasNext() == false) goto L8;
        bind(r0, r6.next());     // Catch: Throwable -> L10
        r1 = r1 + r0.executeUpdateDelete();
        goto L5
    L8:
        release(r0);
        return r1;
    L10:
        th = move-exception;
        release(r0);
        throw th;
    }

    public final int handleMultiple(T[] r6) {
        Intrinsics.checkNotNullParameter(r6, "entities");
        SupportSQLiteStatement r0 = acquire();
        int r1 = r6.length;     // Catch: Throwable -> L9
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= r1) goto L7;
        bind(r0, r6[r2]);     // Catch: Throwable -> L9
        r3 = r3 + r0.executeUpdateDelete();
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
}
