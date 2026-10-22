package com.obric.memorydata.database.manager;

import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/database/manager/SemanticMigrationDeduplication;", "", "<init>", "()V", "queryDuplicateIds", "", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f9586a = null;

    static {
        f9586a = new o();
    }

    private o() {
    }

    public final Set<String> a(SupportSQLiteDatabase r7) {
        SupportSQLiteDatabase r6 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r7, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "database");
        Closeable r8 = (Closeable) ZeusTransformUtils.preCheckCast(r6.query("SELECT entityId, key_phrase FROM UnionSemanticMemory WHERE product_type IN (1001, 1002, 1003, 1004) AND key_phrase IS NOT NULL ORDER BY key_phrase COLLATE BINARY, CASE WHEN product_type = 1003 THEN 0 WHEN user_edit = 1 THEN 1 WHEN product_type = 1002 THEN 2 ELSE 3 END, modifyTime DESC, id DESC"), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r9 = (Cursor) ZeusTransformUtils.preCheckCast(r8, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        Set r1 = SetsKt.createSetBuilder();     // Catch: Throwable -> L15
        String r3 = null;
    L5:
        if (r9.moveToNext() == false) goto L12;
        String r4 = r9.getString(1);     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L15
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L5;
        if (Intrinsics.areEqual(r4, r3) == false) goto L11;
        String r5 = r9.getString(0);     // Catch: Throwable -> L15
        Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");     // Catch: Throwable -> L15
        r1.add(r5);     // Catch: Throwable -> L15
    L11:
        r3 = r4;
        goto L5
    L12:
        Set<String> r10 = SetsKt.build(r1);     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r8, null);
        return r10;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);
        throw th;
    }
}
