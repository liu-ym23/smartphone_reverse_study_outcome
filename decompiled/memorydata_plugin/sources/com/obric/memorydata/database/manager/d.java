package com.obric.memorydata.database.manager;

import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/database/manager/LegacyProactiveSemanticRepair;", "", "<init>", "()V", "LEGACY_PROACTIVE_ROWS", "", "repair", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "allocateChangeSequence", "convertLegacyProactiveRows", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f9563a = null;

    static {
        f9563a = new d();
    }

    private d() {
    }

    private final void b(SupportSQLiteDatabase r2) {
        ((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).execSQL("UPDATE SemanticState SET num = MAX(\n                num,\n                COALESCE((SELECT MAX(change_seq) FROM UnionSemanticMemory), 0),\n                COALESCE((SELECT MAX(change_seq) FROM SemanticRetraction), 0)\n            ) + 1 WHERE `key` = 'change_seq'");
    }

    private final void c(SupportSQLiteDatabase r2) {
        ((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).execSQL(StringsKt.trimIndent("UPDATE UnionSemanticMemory\n                SET semantic_type = CASE\n                        WHEN semantic_type = 'interests' THEN 'preference'\n                        ELSE semantic_type\n                    END,\n                    tag_path = " + s.f9596a.b() + ",\n                    confidence = 4.0,\n                    confirmation_state = 'none',\n                    migration_version = 1,\n                    change_seq = (SELECT num FROM SemanticState WHERE `key` = 'change_seq')\n                WHERE product_type = 1003 AND migration_version = 0 AND change_seq = 0"));
    }

    public final void a(SupportSQLiteDatabase r5) {
        SupportSQLiteDatabase r6 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r5, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "database");
        r6.beginTransaction();
        Closeable r0 = (Closeable) ZeusTransformUtils.preCheckCast(r6.query("SELECT 1 FROM UnionSemanticMemory WHERE product_type = 1003 AND migration_version = 0 AND change_seq = 0 LIMIT 1"), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        boolean r1 = ((Cursor) ZeusTransformUtils.preCheckCast(r0, Cursor.class, "com.obric.memorydata.plugin")).moveToNext();     // Catch: Throwable -> L12
        CloseableKt.closeFinally(r0, null);     // Catch: Throwable -> L17
        if (r1 == false) goto L9;
        b(r6);     // Catch: Throwable -> L17
        c(r6);     // Catch: Throwable -> L17
    L9:
        r6.setTransactionSuccessful();     // Catch: Throwable -> L17
        r6.endTransaction();
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r6.endTransaction();
        throw th;
    }
}
