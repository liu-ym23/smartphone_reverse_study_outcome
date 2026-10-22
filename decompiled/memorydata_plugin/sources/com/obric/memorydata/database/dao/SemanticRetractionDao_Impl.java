package com.obric.memorydata.database.dao;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.obric.memorydata.database.entity.ii;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class SemanticRetractionDao_Impl implements SemanticRetractionDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<ii> __insertionAdapterOfSemanticRetractionEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfDeleteConsumed;

    public SemanticRetractionDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfSemanticRetractionEntity = new AnonymousClass1(this, r2);
        this.__preparedStmtOfDeleteAll = new AnonymousClass2(this, r2);
        this.__preparedStmtOfDeleteConsumed = new AnonymousClass3(this, r2);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.SemanticRetractionDao
    public int deleteAll() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteAll.acquire();
        this.__db.beginTransaction();
        int r1 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAll.release(r0);
        return r1;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAll.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.SemanticRetractionDao
    public int deleteConsumed(long r3, long r5) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteConsumed.acquire();
        r0.bindLong(1, r3);
        r0.bindLong(2, r5);
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteConsumed.release(r0);
        return r4;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteConsumed.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.SemanticRetractionDao
    public long insert(ii r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfSemanticRetractionEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
