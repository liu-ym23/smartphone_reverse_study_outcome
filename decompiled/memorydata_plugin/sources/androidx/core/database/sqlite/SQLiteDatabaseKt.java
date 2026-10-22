package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteDatabase;
import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"transaction", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/database/sqlite/SQLiteDatabase;", "exclusive", "", "body", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroid/database/sqlite/SQLiteDatabase;ZLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SQLiteDatabaseKt {
    public static final <T> T transaction(SQLiteDatabase r2, boolean r3, Function1<? super SQLiteDatabase, ? extends T> r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        if (r3 == false) goto L5;
        r2.beginTransaction();
    L13:
        T r6 = (T) r5.invoke(r2);
        r2.setTransactionSuccessful();     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        r2.endTransaction();
        InlineMarker.finallyEnd(1);
        return r6;
    L10:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r2.endTransaction();
        InlineMarker.finallyEnd(1);
        throw th;
    L5:
        r2.beginTransactionNonExclusive();
        goto L13
    }

    public static /* synthetic */ Object transaction$default(SQLiteDatabase r1, boolean r2, Function1 r3, int r4, Object r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L5;
        r2 = true;
    L5:
        if (r2 == false) goto L7;
        r1.beginTransaction();
    L14:
        Object r7 = r6.invoke(r1);     // Catch: Throwable -> L11
        r1.setTransactionSuccessful();     // Catch: Throwable -> L11
        InlineMarker.finallyStart(1);
        r1.endTransaction();
        InlineMarker.finallyEnd(1);
        return r7;
    L11:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r1.endTransaction();
        InlineMarker.finallyEnd(1);
        throw th;
    L7:
        r1.beginTransactionNonExclusive();
        goto L14
    }
}
