package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteDatabase;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"transaction", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/database/sqlite/SQLiteDatabase;", "exclusive", "", "body", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroid/database/sqlite/SQLiteDatabase;ZLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SQLiteDatabaseKt {
    public static final <T> T transaction(SQLiteDatabase r5, boolean r10, Function1<? super SQLiteDatabase, ? extends T> r11) {
        if (r10 == false) goto L4;
        r5.beginTransaction();
    L12:
        T r12 = r11.invoke(r5);     // Catch: Throwable -> L9
        r5.setTransactionSuccessful();     // Catch: Throwable -> L9
        InlineMarker.finallyStart(1);
        r5.endTransaction();
        InlineMarker.finallyEnd(1);
        return r12;
    L9:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r5.endTransaction();
        InlineMarker.finallyEnd(1);
        throw th;
    L4:
        r5.beginTransactionNonExclusive();
        goto L12
    }

    public static /* synthetic */ Object transaction$default(SQLiteDatabase r5, boolean r10, Function1 r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r10 = true;
    L5:
        if (r10 == false) goto L7;
        r5.beginTransaction();
    L14:
        Object r14 = r11.invoke(r5);     // Catch: Throwable -> L11
        r5.setTransactionSuccessful();     // Catch: Throwable -> L11
        InlineMarker.finallyStart(1);
        r5.endTransaction();
        InlineMarker.finallyEnd(1);
        return r14;
    L11:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r5.endTransaction();
        InlineMarker.finallyEnd(1);
        throw th;
    L7:
        r5.beginTransactionNonExclusive();
        goto L14
    }
}
