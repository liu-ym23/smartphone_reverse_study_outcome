package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.obric.memorydata.database.entity.SpeakerEmbeddingPendingEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class SpeakerEmbeddingPendingDao_Impl implements SpeakerEmbeddingPendingDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<SpeakerEmbeddingPendingEntity> __insertionAdapterOfSpeakerEmbeddingPendingEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfDeletePreparedByEmbeddingId;
    private final SharedSQLiteStatement __preparedStmtOfUpdatePhaseState;
    private final SharedSQLiteStatement __preparedStmtOfUpdateRawObservationIdsAndPhaseState;

    public SpeakerEmbeddingPendingDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfSpeakerEmbeddingPendingEntity = new AnonymousClass1(this, r2);
        this.__preparedStmtOfUpdateRawObservationIdsAndPhaseState = new AnonymousClass2(this, r2);
        this.__preparedStmtOfUpdatePhaseState = new AnonymousClass3(this, r2);
        this.__preparedStmtOfDeletePreparedByEmbeddingId = new AnonymousClass4(this, r2);
        this.__preparedStmtOfDeleteAll = new AnonymousClass5(this, r2);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.SpeakerEmbeddingPendingDao
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

    @Override // com.obric.memorydata.database.dao.SpeakerEmbeddingPendingDao
    public int deletePreparedByEmbeddingId(String r3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeletePreparedByEmbeddingId.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfDeletePreparedByEmbeddingId.release(r0);
        return r4;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeletePreparedByEmbeddingId.release(r0);
        throw th;
    L5:
        r0.bindString(1, r3);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.SpeakerEmbeddingPendingDao
    public long insert(SpeakerEmbeddingPendingEntity r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfSpeakerEmbeddingPendingEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.SpeakerEmbeddingPendingDao
    public SpeakerEmbeddingPendingEntity queryByEmbeddingId(String r25) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM SpeakerEmbeddingPending WHERE embedding_id = ? LIMIT 1", 1);
        if (r25 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        SpeakerEmbeddingPendingEntity r3 = null;
        String r4 = null;
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, "embedding_id");     // Catch: Throwable -> L40
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "session_id");     // Catch: Throwable -> L40
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "local_speaker_id");     // Catch: Throwable -> L40
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "model_version");     // Catch: Throwable -> L40
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "vector");     // Catch: Throwable -> L40
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "raw_observation_ids");     // Catch: Throwable -> L40
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "phase_state");     // Catch: Throwable -> L40
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "created_at");     // Catch: Throwable -> L40
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "updated_at");     // Catch: Throwable -> L40
        if (r1.moveToFirst() == true) goto L10;
    L38:
        r1.close();
        r2.release();
        return r3;
    L10:
        if (r1.isNull(r0) == false) goto L12;
        String r13 = null;
    L14:
        if (r1.isNull(r5) == false) goto L16;
        String r14 = null;
    L18:
        if (r1.isNull(r6) == false) goto L20;
        String r15 = null;
    L22:
        if (r1.isNull(r7) == false) goto L24;
        String r16 = null;
    L26:
        if (r1.isNull(r8) == false) goto L28;
        String r17 = null;
    L30:
        if (r1.isNull(r9) == false) goto L32;
        String r18 = null;
    L34:
        if (r1.isNull(r10) == true) goto L37;
        r4 = r1.getString(r10);     // Catch: Throwable -> L40
    L37:
        r3 = new SpeakerEmbeddingPendingEntity(r13, r14, r15, r16, r17, r18, r4, r1.getLong(r11), r1.getLong(r12));     // Catch: Throwable -> L40
        goto L38
    L32:
        r18 = r1.getString(r9);     // Catch: Throwable -> L40
        goto L34
    L28:
        r17 = r1.getString(r8);     // Catch: Throwable -> L40
        goto L30
    L24:
        r16 = r1.getString(r7);     // Catch: Throwable -> L40
        goto L26
    L20:
        r15 = r1.getString(r6);     // Catch: Throwable -> L40
        goto L22
    L16:
        r14 = r1.getString(r5);     // Catch: Throwable -> L40
        goto L18
    L12:
        r13 = r1.getString(r0);     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        r1.close();
        r2.release();
        throw th;
    L5:
        r2.bindString(1, r25);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.SpeakerEmbeddingPendingDao
    public List<SpeakerEmbeddingPendingEntity> queryByEmbeddingIds(List<String> r27) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r27, List.class, "com.obric.memorydata.plugin");
        StringBuilder r3 = StringUtil.newStringBuilder();
        r3.append("SELECT * FROM SpeakerEmbeddingPending WHERE embedding_id IN (");
        int r4 = r1.size();
        StringUtil.appendPlaceholders(r3, r4);
        r3.append(")");
        RoomSQLiteQuery r5 = RoomSQLiteQuery.acquire(r3.toString(), r4 + 0);
        Iterator r2 = r1.iterator();
        int r6 = 1;
    L4:
        if (r2.hasNext() == false) goto L10;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L8;
        r5.bindNull(r6);
    L9:
        r6 = r6 + 1;
        goto L4
    L8:
        r5.bindString(r6, r7);
        goto L9
    L10:
        this.__db.assertNotSuspendingTransaction();
        Cursor r8 = DBUtil.query(this.__db, r5, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r8, "embedding_id");     // Catch: Throwable -> L46
        int r9 = CursorUtil.getColumnIndexOrThrow(r8, "session_id");     // Catch: Throwable -> L46
        int r10 = CursorUtil.getColumnIndexOrThrow(r8, "local_speaker_id");     // Catch: Throwable -> L46
        int r11 = CursorUtil.getColumnIndexOrThrow(r8, "model_version");     // Catch: Throwable -> L46
        int r12 = CursorUtil.getColumnIndexOrThrow(r8, "vector");     // Catch: Throwable -> L46
        int r13 = CursorUtil.getColumnIndexOrThrow(r8, "raw_observation_ids");     // Catch: Throwable -> L46
        int r14 = CursorUtil.getColumnIndexOrThrow(r8, "phase_state");     // Catch: Throwable -> L46
        int r15 = CursorUtil.getColumnIndexOrThrow(r8, "created_at");     // Catch: Throwable -> L46
        int r16 = CursorUtil.getColumnIndexOrThrow(r8, "updated_at");     // Catch: Throwable -> L46
        ArrayList r17 = new ArrayList(r8.getCount());     // Catch: Throwable -> L46
    L12:
        if (r8.moveToNext() == false) goto L44;
        if (r8.isNull(r0) == false) goto L17;
        String r18 = null;
    L19:
        if (r8.isNull(r9) == false) goto L21;
        String r19 = null;
    L23:
        if (r8.isNull(r10) == false) goto L25;
        String r110 = null;
    L27:
        if (r8.isNull(r11) == false) goto L29;
        String r111 = null;
    L31:
        if (r8.isNull(r12) == false) goto L33;
        String r112 = null;
    L35:
        if (r8.isNull(r13) == false) goto L37;
        String r20 = null;
    L39:
        if (r8.isNull(r14) == false) goto L41;
        String r21 = null;
    L42:
        r17.add(new SpeakerEmbeddingPendingEntity(r18, r19, r110, r111, r112, r20, r21, r8.getLong(r15), r8.getLong(r16)));     // Catch: Throwable -> L46
        goto L12
    L41:
        r21 = r8.getString(r14);     // Catch: Throwable -> L46
        goto L42
    L37:
        r20 = r8.getString(r13);     // Catch: Throwable -> L46
        goto L39
    L33:
        r112 = r8.getString(r12);     // Catch: Throwable -> L46
        goto L35
    L29:
        r111 = r8.getString(r11);     // Catch: Throwable -> L46
        goto L31
    L25:
        r110 = r8.getString(r10);     // Catch: Throwable -> L46
        goto L27
    L21:
        r19 = r8.getString(r9);     // Catch: Throwable -> L46
        goto L23
    L17:
        r18 = r8.getString(r0);     // Catch: Throwable -> L46
        goto L19
    L44:
        r8.close();
        r5.release();
        return r17;
    L46:
        th = move-exception;
        r8.close();
        r5.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.SpeakerEmbeddingPendingDao
    public int updatePhaseState(String r3, String r4, long r5) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfUpdatePhaseState.acquire();
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r5);
        if (r3 != null) goto L9;
        r0.bindNull(3);
    L10:
        this.__db.beginTransaction();
        int r6 = r0.executeUpdateDelete();     // Catch: Throwable -> L14
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.__db.endTransaction();
        this.__preparedStmtOfUpdatePhaseState.release(r0);
        return r6;
    L14:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfUpdatePhaseState.release(r0);
        throw th;
    L9:
        r0.bindString(3, r3);
        goto L10
    L5:
        r0.bindString(1, r4);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.SpeakerEmbeddingPendingDao
    public int updateRawObservationIdsAndPhaseState(String r3, String r4, String r5, long r6) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfUpdateRawObservationIdsAndPhaseState.acquire();
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r5 != null) goto L9;
        r0.bindNull(2);
    L10:
        r0.bindLong(3, r6);
        if (r3 != null) goto L13;
        r0.bindNull(4);
    L14:
        this.__db.beginTransaction();
        int r7 = r0.executeUpdateDelete();     // Catch: Throwable -> L18
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L18
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateRawObservationIdsAndPhaseState.release(r0);
        return r7;
    L18:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateRawObservationIdsAndPhaseState.release(r0);
        throw th;
    L13:
        r0.bindString(4, r3);
        goto L14
    L9:
        r0.bindString(2, r5);
        goto L10
    L5:
        r0.bindString(1, r4);
        goto L7
    }
}
