package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0000\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001d\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH$J\u0013\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0002\u0010\u0010J\u001b\u0010\u0011\u001a\u00020\u000f2\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0013¢\u0006\u0002\u0010\u0014J\u0014\u0010\u0011\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015¨\u0006\u0016"}, d2 = {"Landroidx/room/EntityDeletionOrUpdateAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/room/SharedSQLiteStatement;", "database", "Landroidx/room/RoomDatabase;", "(Landroidx/room/RoomDatabase;)V", "bind", "", "statement", "Landroidx/sqlite/db/SupportSQLiteStatement;", "entity", "(Landroidx/sqlite/db/SupportSQLiteStatement;Ljava/lang/Object;)V", "createQuery", "", "handle", "", "(Ljava/lang/Object;)I", "handleMultiple", "entities", "", "([Ljava/lang/Object;)I", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class EntityDeletionOrUpdateAdapter<T> extends SharedSQLiteStatement {
    public EntityDeletionOrUpdateAdapter(RoomDatabase r5) {
        Intrinsics.checkNotNullParameter(r5, "database");
        super(r5);
    }

    public abstract void bind(SupportSQLiteStatement r5, T r10);

    @Override // androidx.room.SharedSQLiteStatement
    public abstract String createQuery();

    public final int handle(T r5) {
        SupportSQLiteStatement r10 = acquire();
        bind(r10, r5);     // Catch: Throwable -> L6
        int r11 = r10.executeUpdateDelete();     // Catch: Throwable -> L6
        release(r10);
        return r11;
    L6:
        th = move-exception;
        release(r10);
        throw th;
    }

    public final int handleMultiple(Iterable<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "entities");
        SupportSQLiteStatement r10 = acquire();
        Iterator<? extends T> r11 = r5.iterator();     // Catch: Throwable -> L8
        int r12 = 0;
    L5:
        if (r11.hasNext() == false) goto L10;
        bind(r10, r11.next());     // Catch: Throwable -> L8
        r12 = r12 + r10.executeUpdateDelete();
        goto L5
    L10:
        release(r10);
        return r12;
    L8:
        th = move-exception;
        release(r10);
        throw th;
    }

    public final int handleMultiple(T[] r10) {
        Intrinsics.checkNotNullParameter(r10, "entities");
        SupportSQLiteStatement r5 = acquire();
        int r11 = r10.length;     // Catch: Throwable -> L7
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r12 >= r11) goto L9;
        bind(r5, r10[r12]);     // Catch: Throwable -> L7
        r13 = r13 + r5.executeUpdateDelete();
        r12 = r12 + 1;
        goto L4
    L9:
        release(r5);
        return r13;
    L7:
        th = move-exception;
        release(r5);
        throw th;
    }
}
