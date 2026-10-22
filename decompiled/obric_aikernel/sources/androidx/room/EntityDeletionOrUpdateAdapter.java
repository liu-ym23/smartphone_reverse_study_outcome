package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class EntityDeletionOrUpdateAdapter<T> extends SharedSQLiteStatement {
    public EntityDeletionOrUpdateAdapter(RoomDatabase r10) {
        Intrinsics.checkNotNullParameter(r10, "database");
        super(r10);
    }

    protected abstract void bind(SupportSQLiteStatement r10, T r11);

    @Override // androidx.room.SharedSQLiteStatement
    protected abstract String createQuery();

    public final int handle(T r10) {
        SupportSQLiteStatement r11 = acquire();
        bind(r11, r10);     // Catch: Throwable -> L6
        int r12 = r11.executeUpdateDelete();     // Catch: Throwable -> L6
        release(r11);
        return r12;
    L6:
        th = move-exception;
        release(r11);
        throw th;
    }

    public final int handleMultiple(Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "entities");
        SupportSQLiteStatement r11 = acquire();
        int r12 = 0;
        Iterator<? extends T> r13 = r10.iterator();     // Catch: Throwable -> L10
    L5:
        if (r13.hasNext() == false) goto L8;
        bind(r11, r13.next());     // Catch: Throwable -> L10
        r12 = r12 + r11.executeUpdateDelete();
        goto L5
    L8:
        release(r11);
        return r12;
    L10:
        th = move-exception;
        release(r11);
        throw th;
    }

    public final int handleMultiple(T[] r10) {
        Intrinsics.checkNotNullParameter(r10, "entities");
        SupportSQLiteStatement r11 = acquire();
        int r12 = r10.length;     // Catch: Throwable -> L9
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r13 >= r12) goto L7;
        bind(r11, r10[r13]);     // Catch: Throwable -> L9
        r14 = r14 + r11.executeUpdateDelete();
        r13 = r13 + 1;
        goto L4
    L7:
        release(r11);
        return r14;
    L9:
        th = move-exception;
        release(r11);
        throw th;
    }
}
