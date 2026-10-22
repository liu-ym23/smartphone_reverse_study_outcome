package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteDatabase;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class SQLiteDatabaseKt {
    public static final <T> T transaction(SQLiteDatabase r10, boolean r11, Function1<? super SQLiteDatabase, ? extends T> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "body");
        if (r11 == false) goto L5;
        r10.beginTransaction();
    L13:
        T r13 = r12.invoke(r10);     // Catch: Throwable -> L10
        r10.setTransactionSuccessful();     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        r10.endTransaction();
        InlineMarker.finallyEnd(1);
        return r13;
    L10:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r10.endTransaction();
        InlineMarker.finallyEnd(1);
        throw th;
    L5:
        r10.beginTransactionNonExclusive();
        goto L13
    }

    public static /* synthetic */ Object transaction$default(SQLiteDatabase r10, boolean r11, Function1 r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L5;
        r11 = true;
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "body");
        if (r11 == false) goto L8;
        r10.beginTransaction();
    L15:
        Object r15 = r12.invoke(r10);     // Catch: Throwable -> L12
        r10.setTransactionSuccessful();     // Catch: Throwable -> L12
        InlineMarker.finallyStart(1);
        r10.endTransaction();
        InlineMarker.finallyEnd(1);
        return r15;
    L12:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r10.endTransaction();
        InlineMarker.finallyEnd(1);
        throw th;
    L8:
        r10.beginTransactionNonExclusive();
        goto L15
    }
}
