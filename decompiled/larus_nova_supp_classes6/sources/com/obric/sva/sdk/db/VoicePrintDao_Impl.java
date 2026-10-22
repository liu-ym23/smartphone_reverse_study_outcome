package com.obric.sva.sdk.db;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class VoicePrintDao_Impl implements VoicePrintDao {
    private final RoomDatabase __db;
    private final SharedSQLiteStatement __preparedStmtOfClear;

    @Override // com.obric.sva.sdk.db.VoicePrintDao
    public void clear() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfClear.acquire();
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfClear.release(r0);
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfClear.release(r0);
        throw th;
    }

    @Override // com.obric.sva.sdk.db.VoicePrintDao
    public List<SvaVoicePrintControl> getVoicePrintInfos() {
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("SELECT * FROM `sva_voice_print`", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r3, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "id");     // Catch: Throwable -> L30
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "version_id");     // Catch: Throwable -> L30
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "uuid");     // Catch: Throwable -> L30
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "audio_engine_version");     // Catch: Throwable -> L30
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "state");     // Catch: Throwable -> L30
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "misc");     // Catch: Throwable -> L30
        ArrayList r10 = new ArrayList(r2.getCount());     // Catch: Throwable -> L30
    L4:
        if (r2.moveToNext() == false) goto L28;
        if (r2.isNull(r0) == false) goto L9;
        Long r13 = null;
    L11:
        if (r2.isNull(r5) == false) goto L13;
        String r14 = null;
    L15:
        if (r2.isNull(r6) == false) goto L17;
        String r15 = null;
    L19:
        if (r2.isNull(r7) == false) goto L21;
        String r16 = null;
    L22:
        int r17 = r2.getInt(r8);     // Catch: Throwable -> L30
        if (r2.isNull(r9) == false) goto L25;
        String r18 = null;
    L26:
        r10.add(new SvaVoicePrintControl(r13, r14, r15, r16, r17, r18));     // Catch: Throwable -> L30
        goto L4
    L25:
        r18 = r2.getString(r9);     // Catch: Throwable -> L30
        goto L26
    L21:
        r16 = r2.getString(r7);     // Catch: Throwable -> L30
        goto L22
    L17:
        r15 = r2.getString(r6);     // Catch: Throwable -> L30
        goto L19
    L13:
        r14 = r2.getString(r5);     // Catch: Throwable -> L30
        goto L15
    L9:
        r13 = Long.valueOf(r2.getLong(r0));     // Catch: Throwable -> L30
        goto L11
    L28:
        r2.close();
        r3.release();
        return r10;
    L30:
        th = move-exception;
        r2.close();
        r3.release();
        throw th;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    public VoicePrintDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__preparedStmtOfClear = new AnonymousClass1(this, r2);
    }

    @Override // com.obric.sva.sdk.db.VoicePrintDao
    public List<SvaVoicePrintControl> getVoicePrintInfo(String r20) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM `sva_voice_print` WHERE `uuid` = ? ", 1);
        if (r20 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r3 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r3, "id");     // Catch: Throwable -> L34
        int r5 = CursorUtil.getColumnIndexOrThrow(r3, "version_id");     // Catch: Throwable -> L34
        int r6 = CursorUtil.getColumnIndexOrThrow(r3, "uuid");     // Catch: Throwable -> L34
        int r7 = CursorUtil.getColumnIndexOrThrow(r3, "audio_engine_version");     // Catch: Throwable -> L34
        int r8 = CursorUtil.getColumnIndexOrThrow(r3, "state");     // Catch: Throwable -> L34
        int r9 = CursorUtil.getColumnIndexOrThrow(r3, "misc");     // Catch: Throwable -> L34
        ArrayList r10 = new ArrayList(r3.getCount());     // Catch: Throwable -> L34
    L8:
        if (r3.moveToNext() == false) goto L32;
        if (r3.isNull(r0) == false) goto L13;
        Long r13 = null;
    L15:
        if (r3.isNull(r5) == false) goto L17;
        String r14 = null;
    L19:
        if (r3.isNull(r6) == false) goto L21;
        String r15 = null;
    L23:
        if (r3.isNull(r7) == false) goto L25;
        String r16 = null;
    L26:
        int r17 = r3.getInt(r8);     // Catch: Throwable -> L34
        if (r3.isNull(r9) == false) goto L29;
        String r18 = null;
    L30:
        r10.add(new SvaVoicePrintControl(r13, r14, r15, r16, r17, r18));     // Catch: Throwable -> L34
        goto L8
    L29:
        r18 = r3.getString(r9);     // Catch: Throwable -> L34
        goto L30
    L25:
        r16 = r3.getString(r7);     // Catch: Throwable -> L34
        goto L26
    L21:
        r15 = r3.getString(r6);     // Catch: Throwable -> L34
        goto L23
    L17:
        r14 = r3.getString(r5);     // Catch: Throwable -> L34
        goto L19
    L13:
        r13 = Long.valueOf(r3.getLong(r0));     // Catch: Throwable -> L34
        goto L15
    L32:
        r3.close();
        r2.release();
        return r10;
    L34:
        th = move-exception;
        r3.close();
        r2.release();
        throw th;
    L5:
        r2.bindString(1, r20);
        goto L6
    }
}
