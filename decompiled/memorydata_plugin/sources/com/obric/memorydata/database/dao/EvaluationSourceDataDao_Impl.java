package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.entity.bu;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class EvaluationSourceDataDao_Impl implements EvaluationSourceDataDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<bu> __deletionAdapterOfEvaluationSourceDataEntity;
    private final EntityInsertionAdapter<bu> __insertionAdapterOfEvaluationSourceDataEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByDataId;
    private final SharedSQLiteStatement __preparedStmtOfDeleteBySessionTypeAndExtra;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByUserIndex;
    private final EntityDeletionOrUpdateAdapter<bu> __updateAdapterOfEvaluationSourceDataEntity;

    public EvaluationSourceDataDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfEvaluationSourceDataEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfEvaluationSourceDataEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfEvaluationSourceDataEntity = new AnonymousClass3(this, r2);
        this.__preparedStmtOfDeleteByDataId = new AnonymousClass4(this, r2);
        this.__preparedStmtOfDeleteByUserIndex = new AnonymousClass5(this, r2);
        this.__preparedStmtOfDeleteBySessionTypeAndExtra = new AnonymousClass6(this, r2);
    }

    private bu __entityCursorConverter_comObricMemorydataDatabaseEntityEvaluationSourceDataEntity(Cursor r52) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r52, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r2 = CursorUtil.getColumnIndex(r0, "dataId");
        int r3 = CursorUtil.getColumnIndex(r0, "groupId");
        int r4 = CursorUtil.getColumnIndex(r0, "dataContent");
        int r5 = CursorUtil.getColumnIndex(r0, "targetSummaryEvent");
        int r6 = CursorUtil.getColumnIndex(r0, ObricMemoryConstants.KEY_SESSION_ID);
        int r7 = CursorUtil.getColumnIndex(r0, "userType");
        int r8 = CursorUtil.getColumnIndex(r0, "sessionType");
        int r9 = CursorUtil.getColumnIndex(r0, "originalData");
        int r10 = CursorUtil.getColumnIndex(r0, "groundTruth");
        int r11 = CursorUtil.getColumnIndex(r0, "groundTruthReason");
        int r12 = CursorUtil.getColumnIndex(r0, "searchText");
        int r13 = CursorUtil.getColumnIndex(r0, WsConstants.KEY_EXTRA);
        int r14 = CursorUtil.getColumnIndex(r0, "validQuery");
        int r15 = CursorUtil.getColumnIndex(r0, "largeModelUsage");
        int r16 = CursorUtil.getColumnIndex(r0, "gsb");
        int r17 = CursorUtil.getColumnIndex(r0, "gsbReason");
        int r18 = CursorUtil.getColumnIndex(r0, "retrievalScore");
        int r19 = CursorUtil.getColumnIndex(r0, "retrievalScoreReason");
        int r110 = CursorUtil.getColumnIndex(r0, "userIndex");
        int r111 = CursorUtil.getColumnIndex(r0, "realValue");
        int r112 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        long r21 = 0;
        if (r1 != (-1)) goto L5;
        long r27 = 0;
    L6:
        int r20 = 0;
        if (r2 != (-1)) goto L9;
        int r29 = 0;
    L10:
        if (r3 != (-1)) goto L12;
        int r30 = 0;
    L14:
        if (r4 != (-1)) goto L17;
    L15:
        String r31 = null;
    L20:
        if (r5 != (-1)) goto L23;
    L21:
        String r32 = null;
    L26:
        if (r6 != (-1)) goto L28;
        int r33 = 0;
    L29:
        if (r7 != (-1)) goto L31;
        int r34 = 0;
    L32:
        if (r8 != (-1)) goto L35;
    L33:
        String r35 = null;
    L38:
        if (r9 != (-1)) goto L41;
    L39:
        String r36 = null;
    L44:
        if (r10 != (-1)) goto L47;
    L45:
        Long r37 = null;
    L50:
        if (r11 != (-1)) goto L53;
    L51:
        String r38 = null;
    L56:
        if (r12 != (-1)) goto L59;
    L57:
        String r39 = null;
    L62:
        if (r13 != (-1)) goto L65;
    L63:
        String r40 = null;
    L68:
        if (r14 != (-1)) goto L70;
        int r41 = 0;
    L71:
        if (r51 != (-1)) goto L74;
    L72:
        Long r42 = null;
    L77:
        if (r52 != (-1)) goto L81;
    L78:
        Long r43 = null;
    L84:
        if (r17 != (-1)) goto L88;
    L85:
        String r44 = null;
    L91:
        if (r18 != (-1)) goto L95;
    L92:
        String r45 = null;
    L98:
        if (r19 != (-1)) goto L102;
    L99:
        String r46 = null;
    L105:
        if (r110 == (-1)) goto L108;
        r20 = r0.getInt(r110);
    L108:
        int r47 = r20;
        if (r111 != (-1)) goto L113;
    L110:
        String r48 = null;
    L116:
        if (r112 == (-1)) goto L120;
        r21 = r0.getLong(r112);
    L120:
        return new bu(r27, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r21);
    L113:
        if (r0.isNull(r111) == true) goto L110;
        r48 = r0.getString(r111);
        goto L116
    L102:
        if (r0.isNull(r19) == true) goto L99;
        r46 = r0.getString(r19);
        goto L105
    L95:
        if (r0.isNull(r18) == true) goto L92;
        r45 = r0.getString(r18);
        goto L98
    L88:
        if (r0.isNull(r17) == true) goto L85;
        r44 = r0.getString(r17);
        goto L91
    L81:
        if (r0.isNull(r52) == true) goto L78;
        r43 = Long.valueOf(r0.getLong(r16));
        goto L84
    L74:
        if (r0.isNull(r51) == true) goto L72;
        r42 = Long.valueOf(r0.getLong(r15));
        goto L77
    L70:
        r41 = r0.getInt(r14);
        goto L71
    L65:
        if (r0.isNull(r13) == true) goto L63;
        r40 = r0.getString(r13);
        goto L68
    L59:
        if (r0.isNull(r12) == true) goto L57;
        r39 = r0.getString(r12);
        goto L62
    L53:
        if (r0.isNull(r11) == true) goto L51;
        r38 = r0.getString(r11);
        goto L56
    L47:
        if (r0.isNull(r10) == true) goto L45;
        r37 = Long.valueOf(r0.getLong(r10));
        goto L50
    L41:
        if (r0.isNull(r9) == true) goto L39;
        r36 = r0.getString(r9);
        goto L44
    L35:
        if (r0.isNull(r8) == true) goto L33;
        r35 = r0.getString(r8);
        goto L38
    L31:
        r34 = r0.getInt(r7);
        goto L32
    L28:
        r33 = r0.getInt(r6);
        goto L29
    L23:
        if (r0.isNull(r5) == true) goto L21;
        r32 = r0.getString(r5);
        goto L26
    L17:
        if (r0.isNull(r4) == true) goto L15;
        r31 = r0.getString(r4);
        goto L20
    L12:
        r30 = r0.getInt(r3);
        goto L14
    L9:
        r29 = r0.getInt(r2);
        goto L10
    L5:
        r27 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<bu> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfEvaluationSourceDataEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<bu> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfEvaluationSourceDataEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(bu r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfEvaluationSourceDataEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(bu r3) {
        return delete2((bu) ZeusTransformUtils.preCheckCast(r3, bu.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return EvaluationSourceDataDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.EvaluationSourceDataDao
    public int deleteByDataId(int r4) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteByDataId.acquire();
        r0.bindLong(1, r4);
        this.__db.beginTransaction();
        int r5 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByDataId.release(r0);
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByDataId.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.EvaluationSourceDataDao
    public int deleteBySessionTypeAndExtra(String r3, String r4) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteBySessionTypeAndExtra.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r4 != null) goto L9;
        r0.bindNull(2);
    L10:
        this.__db.beginTransaction();
        int r5 = r0.executeUpdateDelete();     // Catch: Throwable -> L14
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteBySessionTypeAndExtra.release(r0);
        return r5;
    L14:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteBySessionTypeAndExtra.release(r0);
        throw th;
    L9:
        r0.bindString(2, r4);
        goto L10
    L5:
        r0.bindString(1, r3);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.EvaluationSourceDataDao
    public int deleteByUserIndex(int r4) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteByUserIndex.acquire();
        r0.bindLong(1, r4);
        this.__db.beginTransaction();
        int r5 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByUserIndex.release(r0);
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByUserIndex.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.EvaluationSourceDataDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return EvaluationSourceDataDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(bu r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfEvaluationSourceDataEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(bu r3) {
        return insert2((bu) ZeusTransformUtils.preCheckCast(r3, bu.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<bu> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfEvaluationSourceDataEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<bu> queryAll() {
        return EvaluationSourceDataDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return EvaluationSourceDataDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.EvaluationSourceDataDao
    public bu queryByDataContentAndSessionType(String r49, String r50) {
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("SELECT * FROM EvaluationSourceData WHERE dataContent = ? AND sessionType = ?", 2);
        if (r49 != null) goto L5;
        r3.bindNull(1);
    L6:
        if (r50 != null) goto L8;
        r3.bindNull(2);
    L9:
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r3, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, "timestamp");     // Catch: Throwable -> L77
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "dataId");     // Catch: Throwable -> L77
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "groupId");     // Catch: Throwable -> L77
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "dataContent");     // Catch: Throwable -> L77
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "targetSummaryEvent");     // Catch: Throwable -> L77
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, ObricMemoryConstants.KEY_SESSION_ID);     // Catch: Throwable -> L77
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "userType");     // Catch: Throwable -> L77
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "sessionType");     // Catch: Throwable -> L77
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "originalData");     // Catch: Throwable -> L77
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "groundTruth");     // Catch: Throwable -> L77
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, "groundTruthReason");     // Catch: Throwable -> L77
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "searchText");     // Catch: Throwable -> L77
        int r15 = CursorUtil.getColumnIndexOrThrow(r1, WsConstants.KEY_EXTRA);     // Catch: Throwable -> L77
        int r2 = CursorUtil.getColumnIndexOrThrow(r1, "validQuery");     // Catch: Throwable -> L77
        RoomSQLiteQuery r16 = r3;
        int r17 = CursorUtil.getColumnIndexOrThrow(r1, "largeModelUsage");     // Catch: Throwable -> L75
        int r18 = CursorUtil.getColumnIndexOrThrow(r1, "gsb");     // Catch: Throwable -> L75
        int r19 = CursorUtil.getColumnIndexOrThrow(r1, "gsbReason");     // Catch: Throwable -> L75
        int r20 = CursorUtil.getColumnIndexOrThrow(r1, "retrievalScore");     // Catch: Throwable -> L75
        int r21 = CursorUtil.getColumnIndexOrThrow(r1, "retrievalScoreReason");     // Catch: Throwable -> L75
        int r22 = CursorUtil.getColumnIndexOrThrow(r1, "userIndex");     // Catch: Throwable -> L75
        int r23 = CursorUtil.getColumnIndexOrThrow(r1, "realValue");     // Catch: Throwable -> L75
        int r24 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L75
        if (r1.moveToFirst() == false) goto L72;
        long r25 = r1.getLong(r0);     // Catch: Throwable -> L75
        int r26 = r1.getInt(r4);     // Catch: Throwable -> L75
        int r27 = r1.getInt(r5);     // Catch: Throwable -> L75
        if (r1.isNull(r6) == false) goto L17;
        String r28 = null;
    L19:
        if (r1.isNull(r7) == false) goto L21;
        String r29 = null;
    L22:
        int r30 = r1.getInt(r8);     // Catch: Throwable -> L75
        int r31 = r1.getInt(r9);     // Catch: Throwable -> L75
        if (r1.isNull(r10) == false) goto L25;
        String r32 = null;
    L27:
        if (r1.isNull(r11) == false) goto L29;
        String r33 = null;
    L31:
        if (r1.isNull(r12) == false) goto L33;
        Long r34 = null;
    L35:
        if (r1.isNull(r13) == false) goto L37;
        String r35 = null;
    L39:
        if (r1.isNull(r14) == false) goto L41;
        String r36 = null;
    L43:
        if (r1.isNull(r15) == false) goto L45;
        String r37 = null;
    L46:
        int r38 = r1.getInt(r2);     // Catch: Throwable -> L75
        if (r1.isNull(r17) == false) goto L49;
        Long r39 = null;
    L51:
        if (r1.isNull(r50) == false) goto L53;
        Long r40 = null;
    L55:
        if (r1.isNull(r17) == false) goto L57;
        String r41 = null;
    L59:
        if (r1.isNull(r18) == false) goto L61;
        String r42 = null;
    L63:
        if (r1.isNull(r19) == false) goto L65;
        String r43 = null;
    L66:
        int r44 = r1.getInt(r22);     // Catch: Throwable -> L75
        if (r1.isNull(r23) == false) goto L69;
        String r45 = null;
    L70:
        bu r46 = new bu(r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r1.getLong(r24));     // Catch: Throwable -> L75
    L73:
        r1.close();
        r16.release();
        return r46;
    L69:
        r45 = r1.getString(r23);     // Catch: Throwable -> L75
        goto L70
    L65:
        r43 = r1.getString(r21);     // Catch: Throwable -> L75
        goto L66
    L61:
        r42 = r1.getString(r20);     // Catch: Throwable -> L75
        goto L63
    L57:
        r41 = r1.getString(r19);     // Catch: Throwable -> L75
        goto L59
    L53:
        r40 = Long.valueOf(r1.getLong(r18));     // Catch: Throwable -> L75
        goto L55
    L49:
        r39 = Long.valueOf(r1.getLong(r17));     // Catch: Throwable -> L75
        goto L51
    L45:
        r37 = r1.getString(r15);     // Catch: Throwable -> L75
        goto L46
    L41:
        r36 = r1.getString(r14);     // Catch: Throwable -> L75
        goto L43
    L37:
        r35 = r1.getString(r13);     // Catch: Throwable -> L75
        goto L39
    L33:
        r34 = Long.valueOf(r1.getLong(r12));     // Catch: Throwable -> L75
        goto L35
    L29:
        r33 = r1.getString(r11);     // Catch: Throwable -> L75
        goto L31
    L25:
        r32 = r1.getString(r10);     // Catch: Throwable -> L75
        goto L27
    L21:
        r29 = r1.getString(r7);     // Catch: Throwable -> L75
        goto L22
    L17:
        r28 = r1.getString(r6);     // Catch: Throwable -> L75
        goto L19
    L72:
        r46 = null;
    L75:
        th = th;
    L79:
        r1.close();
        r16.release();
        throw th;
    L77:
        th = th;
        r16 = r3;
        goto L79
    L8:
        r3.bindString(2, r50);
        goto L9
    L5:
        r3.bindString(1, r49);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.EvaluationSourceDataDao
    public List<bu> queryByDataId(int r51) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM EvaluationSourceData WHERE dataId = ?", 1);
        r1.bindLong(1, r51);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L70
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "dataId");     // Catch: Throwable -> L70
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "groupId");     // Catch: Throwable -> L70
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "dataContent");     // Catch: Throwable -> L70
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "targetSummaryEvent");     // Catch: Throwable -> L70
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, ObricMemoryConstants.KEY_SESSION_ID);     // Catch: Throwable -> L70
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "userType");     // Catch: Throwable -> L70
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "sessionType");     // Catch: Throwable -> L70
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "originalData");     // Catch: Throwable -> L70
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "groundTruth");     // Catch: Throwable -> L70
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "groundTruthReason");     // Catch: Throwable -> L70
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "searchText");     // Catch: Throwable -> L70
        int r15 = CursorUtil.getColumnIndexOrThrow(r2, WsConstants.KEY_EXTRA);     // Catch: Throwable -> L70
        int r3 = CursorUtil.getColumnIndexOrThrow(r2, "validQuery");     // Catch: Throwable -> L70
        RoomSQLiteQuery r16 = r1;
        int r52 = CursorUtil.getColumnIndexOrThrow(r2, "largeModelUsage");     // Catch: Throwable -> L68
        int r17 = CursorUtil.getColumnIndexOrThrow(r2, "gsb");     // Catch: Throwable -> L68
        int r18 = CursorUtil.getColumnIndexOrThrow(r2, "gsbReason");     // Catch: Throwable -> L68
        int r19 = CursorUtil.getColumnIndexOrThrow(r2, "retrievalScore");     // Catch: Throwable -> L68
        int r20 = CursorUtil.getColumnIndexOrThrow(r2, "retrievalScoreReason");     // Catch: Throwable -> L68
        int r21 = CursorUtil.getColumnIndexOrThrow(r2, "userIndex");     // Catch: Throwable -> L68
        int r22 = CursorUtil.getColumnIndexOrThrow(r2, "realValue");     // Catch: Throwable -> L68
        int r23 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L68
        int r24 = r3;
        ArrayList r25 = new ArrayList(r2.getCount());     // Catch: Throwable -> L68
    L6:
        if (r2.moveToNext() == false) goto L66;
        long r26 = r2.getLong(r0);     // Catch: Throwable -> L68
        int r28 = r2.getInt(r4);     // Catch: Throwable -> L68
        int r29 = r2.getInt(r5);     // Catch: Throwable -> L68
        if (r2.isNull(r6) == false) goto L11;
        String r30 = null;
    L13:
        if (r2.isNull(r7) == false) goto L15;
        String r31 = null;
    L16:
        int r32 = r2.getInt(r8);     // Catch: Throwable -> L68
        int r33 = r2.getInt(r9);     // Catch: Throwable -> L68
        if (r2.isNull(r10) == false) goto L19;
        String r34 = null;
    L21:
        if (r2.isNull(r11) == false) goto L23;
        String r35 = null;
    L25:
        if (r2.isNull(r12) == false) goto L27;
        Long r36 = null;
    L29:
        if (r2.isNull(r13) == false) goto L31;
        String r37 = null;
    L33:
        if (r2.isNull(r14) == false) goto L35;
        String r38 = null;
    L37:
        if (r2.isNull(r15) == false) goto L39;
        String r39 = null;
    L40:
        int r40 = r2.getInt(r24);     // Catch: Throwable -> L68
        int r27 = r0;
        r52 = r52;
        if (r2.isNull(r52) == false) goto L43;
        Long r41 = null;
    L45:
        if (r2.isNull(r17) == false) goto L47;
        Long r42 = null;
    L49:
        if (r2.isNull(r18) == false) goto L51;
        String r43 = null;
    L53:
        if (r2.isNull(r19) == false) goto L55;
        String r44 = null;
    L57:
        if (r2.isNull(r20) == false) goto L59;
        String r45 = null;
    L60:
        int r46 = r2.getInt(r21);     // Catch: Throwable -> L68
        r21 = r21;
        r22 = r22;
        if (r2.isNull(r22) == false) goto L63;
        String r47 = null;
    L64:
        long r48 = r2.getLong(r23);     // Catch: Throwable -> L68
        r23 = r23;
        r25.add(new bu(r26, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48));     // Catch: Throwable -> L68
        r0 = r27;
        r24 = r24;
        goto L6
    L63:
        r47 = r2.getString(r22);     // Catch: Throwable -> L68
        goto L64
    L59:
        r45 = r2.getString(r20);     // Catch: Throwable -> L68
        goto L60
    L55:
        r44 = r2.getString(r19);     // Catch: Throwable -> L68
        goto L57
    L51:
        r43 = r2.getString(r18);     // Catch: Throwable -> L68
        goto L53
    L47:
        r42 = Long.valueOf(r2.getLong(r17));     // Catch: Throwable -> L68
        goto L49
    L43:
        r41 = Long.valueOf(r2.getLong(r52));     // Catch: Throwable -> L68
        goto L45
    L39:
        r39 = r2.getString(r15);     // Catch: Throwable -> L68
        goto L40
    L35:
        r38 = r2.getString(r14);     // Catch: Throwable -> L68
        goto L37
    L31:
        r37 = r2.getString(r13);     // Catch: Throwable -> L68
        goto L33
    L27:
        r36 = Long.valueOf(r2.getLong(r12));     // Catch: Throwable -> L68
        goto L29
    L23:
        r35 = r2.getString(r11);     // Catch: Throwable -> L68
        goto L25
    L19:
        r34 = r2.getString(r10);     // Catch: Throwable -> L68
        goto L21
    L15:
        r31 = r2.getString(r7);     // Catch: Throwable -> L68
        goto L16
    L11:
        r30 = r2.getString(r6);     // Catch: Throwable -> L68
        goto L13
    L66:
        r2.close();
        r16.release();
        return r25;
    L68:
        th = th;
    L72:
        r2.close();
        r16.release();
        throw th;
    L70:
        th = th;
        r16 = r1;
        goto L72
    }

    @Override // com.obric.memorydata.database.dao.EvaluationSourceDataDao
    public List<bu> queryByDataIdAndSessionType(int r50, String r51) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM EvaluationSourceData WHERE dataId = ? AND sessionType = ?", 2);
        r2.bindLong(1, r50);
        if (r51 != null) goto L5;
        r2.bindNull(2);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, "timestamp");     // Catch: Throwable -> L75
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "dataId");     // Catch: Throwable -> L75
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "groupId");     // Catch: Throwable -> L75
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "dataContent");     // Catch: Throwable -> L75
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "targetSummaryEvent");     // Catch: Throwable -> L75
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, ObricMemoryConstants.KEY_SESSION_ID);     // Catch: Throwable -> L75
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "userType");     // Catch: Throwable -> L75
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "sessionType");     // Catch: Throwable -> L75
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "originalData");     // Catch: Throwable -> L75
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "groundTruth");     // Catch: Throwable -> L75
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, "groundTruthReason");     // Catch: Throwable -> L75
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "searchText");     // Catch: Throwable -> L75
        int r15 = CursorUtil.getColumnIndexOrThrow(r1, WsConstants.KEY_EXTRA);     // Catch: Throwable -> L75
        int r3 = CursorUtil.getColumnIndexOrThrow(r1, "validQuery");     // Catch: Throwable -> L75
        RoomSQLiteQuery r16 = r2;
        int r52 = CursorUtil.getColumnIndexOrThrow(r1, "largeModelUsage");     // Catch: Throwable -> L73
        int r53 = CursorUtil.getColumnIndexOrThrow(r1, "gsb");     // Catch: Throwable -> L73
        int r17 = CursorUtil.getColumnIndexOrThrow(r1, "gsbReason");     // Catch: Throwable -> L73
        int r18 = CursorUtil.getColumnIndexOrThrow(r1, "retrievalScore");     // Catch: Throwable -> L73
        int r19 = CursorUtil.getColumnIndexOrThrow(r1, "retrievalScoreReason");     // Catch: Throwable -> L73
        int r20 = CursorUtil.getColumnIndexOrThrow(r1, "userIndex");     // Catch: Throwable -> L73
        int r21 = CursorUtil.getColumnIndexOrThrow(r1, "realValue");     // Catch: Throwable -> L73
        int r22 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L73
        int r23 = r3;
        ArrayList r24 = new ArrayList(r1.getCount());     // Catch: Throwable -> L73
    L10:
        if (r1.moveToNext() == false) goto L71;
        long r25 = r1.getLong(r0);     // Catch: Throwable -> L73
        int r27 = r1.getInt(r4);     // Catch: Throwable -> L73
        int r28 = r1.getInt(r5);     // Catch: Throwable -> L73
        if (r1.isNull(r6) == false) goto L15;
        String r29 = null;
    L17:
        if (r1.isNull(r7) == false) goto L19;
        String r30 = null;
    L20:
        int r31 = r1.getInt(r8);     // Catch: Throwable -> L73
        int r32 = r1.getInt(r9);     // Catch: Throwable -> L73
        if (r1.isNull(r10) == false) goto L23;
        String r33 = null;
    L25:
        if (r1.isNull(r11) == false) goto L27;
        String r34 = null;
    L29:
        if (r1.isNull(r12) == false) goto L31;
        Long r35 = null;
    L33:
        if (r1.isNull(r13) == false) goto L35;
        String r36 = null;
    L37:
        if (r1.isNull(r14) == false) goto L39;
        String r37 = null;
    L41:
        if (r1.isNull(r15) == false) goto L43;
        String r38 = null;
    L44:
        int r39 = r1.getInt(r23);     // Catch: Throwable -> L73
        int r26 = r0;
        r52 = r52;
        if (r1.isNull(r52) == false) goto L48;
        Long r40 = null;
    L47:
        r53 = r53;
        if (r1.isNull(r53) == false) goto L52;
        Long r41 = null;
    L54:
        if (r1.isNull(r17) == false) goto L56;
        String r42 = null;
    L58:
        if (r1.isNull(r18) == false) goto L60;
        String r43 = null;
    L62:
        if (r1.isNull(r19) == false) goto L64;
        String r44 = null;
    L65:
        int r45 = r1.getInt(r20);     // Catch: Throwable -> L73
        r20 = r20;
        r21 = r21;
        if (r1.isNull(r21) == false) goto L68;
        String r46 = null;
    L69:
        long r47 = r1.getLong(r22);     // Catch: Throwable -> L73
        r22 = r22;
        r24.add(new bu(r25, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47));     // Catch: Throwable -> L73
        r0 = r26;
        r23 = r23;
        goto L10
    L68:
        r46 = r1.getString(r21);     // Catch: Throwable -> L73
        goto L69
    L64:
        r44 = r1.getString(r19);     // Catch: Throwable -> L73
        goto L65
    L60:
        r43 = r1.getString(r18);     // Catch: Throwable -> L73
        goto L62
    L56:
        r42 = r1.getString(r17);     // Catch: Throwable -> L73
        goto L58
    L52:
        r41 = Long.valueOf(r1.getLong(r53));     // Catch: Throwable -> L73
        goto L54
    L48:
        r40 = Long.valueOf(r1.getLong(r52));     // Catch: Throwable -> L73
        goto L47
    L43:
        r38 = r1.getString(r15);     // Catch: Throwable -> L73
        goto L44
    L39:
        r37 = r1.getString(r14);     // Catch: Throwable -> L73
        goto L41
    L35:
        r36 = r1.getString(r13);     // Catch: Throwable -> L73
        goto L37
    L31:
        r35 = Long.valueOf(r1.getLong(r12));     // Catch: Throwable -> L73
        goto L33
    L27:
        r34 = r1.getString(r11);     // Catch: Throwable -> L73
        goto L29
    L23:
        r33 = r1.getString(r10);     // Catch: Throwable -> L73
        goto L25
    L19:
        r30 = r1.getString(r7);     // Catch: Throwable -> L73
        goto L20
    L15:
        r29 = r1.getString(r6);     // Catch: Throwable -> L73
        goto L17
    L71:
        r1.close();
        r16.release();
        return r24;
    L73:
        th = th;
    L77:
        r1.close();
        r16.release();
        throw th;
    L75:
        th = th;
        r16 = r2;
        goto L77
    L5:
        r2.bindString(2, r51);
        goto L6
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public bu queryById(long r1) {
        return EvaluationSourceDataDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ bu queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<bu> queryByIds(List<Long> r3) {
        return EvaluationSourceDataDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.EvaluationSourceDataDao
    public List<bu> queryBySessionType(String r51) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM EvaluationSourceData WHERE sessionType = ?", 1);
        if (r51 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, "timestamp");     // Catch: Throwable -> L74
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "dataId");     // Catch: Throwable -> L74
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "groupId");     // Catch: Throwable -> L74
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "dataContent");     // Catch: Throwable -> L74
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "targetSummaryEvent");     // Catch: Throwable -> L74
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, ObricMemoryConstants.KEY_SESSION_ID);     // Catch: Throwable -> L74
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "userType");     // Catch: Throwable -> L74
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "sessionType");     // Catch: Throwable -> L74
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "originalData");     // Catch: Throwable -> L74
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "groundTruth");     // Catch: Throwable -> L74
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, "groundTruthReason");     // Catch: Throwable -> L74
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "searchText");     // Catch: Throwable -> L74
        int r15 = CursorUtil.getColumnIndexOrThrow(r1, WsConstants.KEY_EXTRA);     // Catch: Throwable -> L74
        int r3 = CursorUtil.getColumnIndexOrThrow(r1, "validQuery");     // Catch: Throwable -> L74
        RoomSQLiteQuery r16 = r2;
        int r52 = CursorUtil.getColumnIndexOrThrow(r1, "largeModelUsage");     // Catch: Throwable -> L72
        int r17 = CursorUtil.getColumnIndexOrThrow(r1, "gsb");     // Catch: Throwable -> L72
        int r18 = CursorUtil.getColumnIndexOrThrow(r1, "gsbReason");     // Catch: Throwable -> L72
        int r19 = CursorUtil.getColumnIndexOrThrow(r1, "retrievalScore");     // Catch: Throwable -> L72
        int r20 = CursorUtil.getColumnIndexOrThrow(r1, "retrievalScoreReason");     // Catch: Throwable -> L72
        int r21 = CursorUtil.getColumnIndexOrThrow(r1, "userIndex");     // Catch: Throwable -> L72
        int r22 = CursorUtil.getColumnIndexOrThrow(r1, "realValue");     // Catch: Throwable -> L72
        int r23 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L72
        int r24 = r3;
        ArrayList r25 = new ArrayList(r1.getCount());     // Catch: Throwable -> L72
    L10:
        if (r1.moveToNext() == false) goto L70;
        long r26 = r1.getLong(r0);     // Catch: Throwable -> L72
        int r28 = r1.getInt(r4);     // Catch: Throwable -> L72
        int r29 = r1.getInt(r5);     // Catch: Throwable -> L72
        if (r1.isNull(r6) == false) goto L15;
        String r30 = null;
    L17:
        if (r1.isNull(r7) == false) goto L19;
        String r31 = null;
    L20:
        int r32 = r1.getInt(r8);     // Catch: Throwable -> L72
        int r33 = r1.getInt(r9);     // Catch: Throwable -> L72
        if (r1.isNull(r10) == false) goto L23;
        String r34 = null;
    L25:
        if (r1.isNull(r11) == false) goto L27;
        String r35 = null;
    L29:
        if (r1.isNull(r12) == false) goto L31;
        Long r36 = null;
    L33:
        if (r1.isNull(r13) == false) goto L35;
        String r37 = null;
    L37:
        if (r1.isNull(r14) == false) goto L39;
        String r38 = null;
    L41:
        if (r1.isNull(r15) == false) goto L43;
        String r39 = null;
    L44:
        int r40 = r1.getInt(r24);     // Catch: Throwable -> L72
        int r27 = r0;
        r52 = r52;
        if (r1.isNull(r52) == false) goto L47;
        Long r41 = null;
    L49:
        if (r1.isNull(r17) == false) goto L51;
        Long r42 = null;
    L53:
        if (r1.isNull(r18) == false) goto L55;
        String r43 = null;
    L57:
        if (r1.isNull(r19) == false) goto L59;
        String r44 = null;
    L61:
        if (r1.isNull(r20) == false) goto L63;
        String r45 = null;
    L64:
        int r46 = r1.getInt(r21);     // Catch: Throwable -> L72
        r21 = r21;
        r22 = r22;
        if (r1.isNull(r22) == false) goto L67;
        String r47 = null;
    L68:
        long r48 = r1.getLong(r23);     // Catch: Throwable -> L72
        r23 = r23;
        r25.add(new bu(r26, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48));     // Catch: Throwable -> L72
        r0 = r27;
        r24 = r24;
        goto L10
    L67:
        r47 = r1.getString(r22);     // Catch: Throwable -> L72
        goto L68
    L63:
        r45 = r1.getString(r20);     // Catch: Throwable -> L72
        goto L64
    L59:
        r44 = r1.getString(r19);     // Catch: Throwable -> L72
        goto L61
    L55:
        r43 = r1.getString(r18);     // Catch: Throwable -> L72
        goto L57
    L51:
        r42 = Long.valueOf(r1.getLong(r17));     // Catch: Throwable -> L72
        goto L53
    L47:
        r41 = Long.valueOf(r1.getLong(r52));     // Catch: Throwable -> L72
        goto L49
    L43:
        r39 = r1.getString(r15);     // Catch: Throwable -> L72
        goto L44
    L39:
        r38 = r1.getString(r14);     // Catch: Throwable -> L72
        goto L41
    L35:
        r37 = r1.getString(r13);     // Catch: Throwable -> L72
        goto L37
    L31:
        r36 = Long.valueOf(r1.getLong(r12));     // Catch: Throwable -> L72
        goto L33
    L27:
        r35 = r1.getString(r11);     // Catch: Throwable -> L72
        goto L29
    L23:
        r34 = r1.getString(r10);     // Catch: Throwable -> L72
        goto L25
    L19:
        r31 = r1.getString(r7);     // Catch: Throwable -> L72
        goto L20
    L15:
        r30 = r1.getString(r6);     // Catch: Throwable -> L72
        goto L17
    L70:
        r1.close();
        r16.release();
        return r25;
    L72:
        th = th;
    L76:
        r1.close();
        r16.release();
        throw th;
    L74:
        th = th;
        r16 = r2;
        goto L76
    L5:
        r2.bindString(1, r51);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.EvaluationSourceDataDao
    public bu queryBySessionTypeAndExtra(String r49, String r50) {
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("SELECT * FROM EvaluationSourceData WHERE sessionType = ? AND extra = ?", 2);
        if (r49 != null) goto L5;
        r3.bindNull(1);
    L6:
        if (r50 != null) goto L8;
        r3.bindNull(2);
    L9:
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r3, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, "timestamp");     // Catch: Throwable -> L77
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "dataId");     // Catch: Throwable -> L77
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "groupId");     // Catch: Throwable -> L77
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "dataContent");     // Catch: Throwable -> L77
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "targetSummaryEvent");     // Catch: Throwable -> L77
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, ObricMemoryConstants.KEY_SESSION_ID);     // Catch: Throwable -> L77
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "userType");     // Catch: Throwable -> L77
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "sessionType");     // Catch: Throwable -> L77
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "originalData");     // Catch: Throwable -> L77
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "groundTruth");     // Catch: Throwable -> L77
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, "groundTruthReason");     // Catch: Throwable -> L77
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "searchText");     // Catch: Throwable -> L77
        int r15 = CursorUtil.getColumnIndexOrThrow(r1, WsConstants.KEY_EXTRA);     // Catch: Throwable -> L77
        int r2 = CursorUtil.getColumnIndexOrThrow(r1, "validQuery");     // Catch: Throwable -> L77
        RoomSQLiteQuery r16 = r3;
        int r17 = CursorUtil.getColumnIndexOrThrow(r1, "largeModelUsage");     // Catch: Throwable -> L75
        int r18 = CursorUtil.getColumnIndexOrThrow(r1, "gsb");     // Catch: Throwable -> L75
        int r19 = CursorUtil.getColumnIndexOrThrow(r1, "gsbReason");     // Catch: Throwable -> L75
        int r20 = CursorUtil.getColumnIndexOrThrow(r1, "retrievalScore");     // Catch: Throwable -> L75
        int r21 = CursorUtil.getColumnIndexOrThrow(r1, "retrievalScoreReason");     // Catch: Throwable -> L75
        int r22 = CursorUtil.getColumnIndexOrThrow(r1, "userIndex");     // Catch: Throwable -> L75
        int r23 = CursorUtil.getColumnIndexOrThrow(r1, "realValue");     // Catch: Throwable -> L75
        int r24 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L75
        if (r1.moveToFirst() == false) goto L72;
        long r25 = r1.getLong(r0);     // Catch: Throwable -> L75
        int r26 = r1.getInt(r4);     // Catch: Throwable -> L75
        int r27 = r1.getInt(r5);     // Catch: Throwable -> L75
        if (r1.isNull(r6) == false) goto L17;
        String r28 = null;
    L19:
        if (r1.isNull(r7) == false) goto L21;
        String r29 = null;
    L22:
        int r30 = r1.getInt(r8);     // Catch: Throwable -> L75
        int r31 = r1.getInt(r9);     // Catch: Throwable -> L75
        if (r1.isNull(r10) == false) goto L25;
        String r32 = null;
    L27:
        if (r1.isNull(r11) == false) goto L29;
        String r33 = null;
    L31:
        if (r1.isNull(r12) == false) goto L33;
        Long r34 = null;
    L35:
        if (r1.isNull(r13) == false) goto L37;
        String r35 = null;
    L39:
        if (r1.isNull(r14) == false) goto L41;
        String r36 = null;
    L43:
        if (r1.isNull(r15) == false) goto L45;
        String r37 = null;
    L46:
        int r38 = r1.getInt(r2);     // Catch: Throwable -> L75
        if (r1.isNull(r17) == false) goto L49;
        Long r39 = null;
    L51:
        if (r1.isNull(r50) == false) goto L53;
        Long r40 = null;
    L55:
        if (r1.isNull(r17) == false) goto L57;
        String r41 = null;
    L59:
        if (r1.isNull(r18) == false) goto L61;
        String r42 = null;
    L63:
        if (r1.isNull(r19) == false) goto L65;
        String r43 = null;
    L66:
        int r44 = r1.getInt(r22);     // Catch: Throwable -> L75
        if (r1.isNull(r23) == false) goto L69;
        String r45 = null;
    L70:
        bu r46 = new bu(r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r1.getLong(r24));     // Catch: Throwable -> L75
    L73:
        r1.close();
        r16.release();
        return r46;
    L69:
        r45 = r1.getString(r23);     // Catch: Throwable -> L75
        goto L70
    L65:
        r43 = r1.getString(r21);     // Catch: Throwable -> L75
        goto L66
    L61:
        r42 = r1.getString(r20);     // Catch: Throwable -> L75
        goto L63
    L57:
        r41 = r1.getString(r19);     // Catch: Throwable -> L75
        goto L59
    L53:
        r40 = Long.valueOf(r1.getLong(r18));     // Catch: Throwable -> L75
        goto L55
    L49:
        r39 = Long.valueOf(r1.getLong(r17));     // Catch: Throwable -> L75
        goto L51
    L45:
        r37 = r1.getString(r15);     // Catch: Throwable -> L75
        goto L46
    L41:
        r36 = r1.getString(r14);     // Catch: Throwable -> L75
        goto L43
    L37:
        r35 = r1.getString(r13);     // Catch: Throwable -> L75
        goto L39
    L33:
        r34 = Long.valueOf(r1.getLong(r12));     // Catch: Throwable -> L75
        goto L35
    L29:
        r33 = r1.getString(r11);     // Catch: Throwable -> L75
        goto L31
    L25:
        r32 = r1.getString(r10);     // Catch: Throwable -> L75
        goto L27
    L21:
        r29 = r1.getString(r7);     // Catch: Throwable -> L75
        goto L22
    L17:
        r28 = r1.getString(r6);     // Catch: Throwable -> L75
        goto L19
    L72:
        r46 = null;
    L75:
        th = th;
    L79:
        r1.close();
        r16.release();
        throw th;
    L77:
        th = th;
        r16 = r3;
        goto L79
    L8:
        r3.bindString(2, r50);
        goto L9
    L5:
        r3.bindString(1, r49);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.EvaluationSourceDataDao
    public List<bu> queryBySessionTypes(List<String> r51) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r51, List.class, "com.obric.memorydata.plugin");
        StringBuilder r3 = StringUtil.newStringBuilder();
        r3.append("SELECT * FROM EvaluationSourceData WHERE sessionType IN (");
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
        int r0 = CursorUtil.getColumnIndexOrThrow(r8, "timestamp");     // Catch: Throwable -> L78
        int r9 = CursorUtil.getColumnIndexOrThrow(r8, "dataId");     // Catch: Throwable -> L78
        int r10 = CursorUtil.getColumnIndexOrThrow(r8, "groupId");     // Catch: Throwable -> L78
        int r11 = CursorUtil.getColumnIndexOrThrow(r8, "dataContent");     // Catch: Throwable -> L78
        int r12 = CursorUtil.getColumnIndexOrThrow(r8, "targetSummaryEvent");     // Catch: Throwable -> L78
        int r13 = CursorUtil.getColumnIndexOrThrow(r8, ObricMemoryConstants.KEY_SESSION_ID);     // Catch: Throwable -> L78
        int r14 = CursorUtil.getColumnIndexOrThrow(r8, "userType");     // Catch: Throwable -> L78
        int r15 = CursorUtil.getColumnIndexOrThrow(r8, "sessionType");     // Catch: Throwable -> L78
        int r16 = CursorUtil.getColumnIndexOrThrow(r8, "originalData");     // Catch: Throwable -> L78
        int r17 = CursorUtil.getColumnIndexOrThrow(r8, "groundTruth");     // Catch: Throwable -> L78
        int r18 = CursorUtil.getColumnIndexOrThrow(r8, "groundTruthReason");     // Catch: Throwable -> L78
        int r19 = CursorUtil.getColumnIndexOrThrow(r8, "searchText");     // Catch: Throwable -> L78
        int r110 = CursorUtil.getColumnIndexOrThrow(r8, WsConstants.KEY_EXTRA);     // Catch: Throwable -> L78
        int r20 = CursorUtil.getColumnIndexOrThrow(r8, "validQuery");     // Catch: Throwable -> L78
        RoomSQLiteQuery r52 = r5;
        int r111 = CursorUtil.getColumnIndexOrThrow(r8, "largeModelUsage");     // Catch: Throwable -> L76
        int r112 = CursorUtil.getColumnIndexOrThrow(r8, "gsb");     // Catch: Throwable -> L76
        int r113 = CursorUtil.getColumnIndexOrThrow(r8, "gsbReason");     // Catch: Throwable -> L76
        int r114 = CursorUtil.getColumnIndexOrThrow(r8, "retrievalScore");     // Catch: Throwable -> L76
        int r21 = CursorUtil.getColumnIndexOrThrow(r8, "retrievalScoreReason");     // Catch: Throwable -> L76
        int r22 = CursorUtil.getColumnIndexOrThrow(r8, "userIndex");     // Catch: Throwable -> L76
        int r23 = CursorUtil.getColumnIndexOrThrow(r8, "realValue");     // Catch: Throwable -> L76
        int r24 = CursorUtil.getColumnIndexOrThrow(r8, OaidModel.KEY_ID);     // Catch: Throwable -> L76
        int r25 = r20;
        ArrayList r26 = new ArrayList(r8.getCount());     // Catch: Throwable -> L76
    L14:
        if (r8.moveToNext() == false) goto L74;
        long r27 = r8.getLong(r0);     // Catch: Throwable -> L76
        int r28 = r8.getInt(r9);     // Catch: Throwable -> L76
        int r29 = r8.getInt(r10);     // Catch: Throwable -> L76
        if (r8.isNull(r11) == false) goto L19;
        String r30 = null;
    L21:
        if (r8.isNull(r12) == false) goto L23;
        String r31 = null;
    L24:
        int r32 = r8.getInt(r13);     // Catch: Throwable -> L76
        int r33 = r8.getInt(r14);     // Catch: Throwable -> L76
        if (r8.isNull(r15) == false) goto L27;
        String r34 = null;
    L29:
        if (r8.isNull(r16) == false) goto L31;
        String r35 = null;
    L33:
        if (r8.isNull(r17) == false) goto L35;
        Long r36 = null;
    L37:
        if (r8.isNull(r18) == false) goto L39;
        String r37 = null;
    L41:
        if (r8.isNull(r19) == false) goto L43;
        String r38 = null;
    L45:
        if (r8.isNull(r110) == false) goto L47;
        String r39 = null;
    L48:
        int r40 = r8.getInt(r25);     // Catch: Throwable -> L76
        int r210 = r0;
        r111 = r111;
        if (r8.isNull(r111) == false) goto L51;
        Long r41 = null;
    L53:
        if (r8.isNull(r112) == false) goto L55;
        Long r42 = null;
    L57:
        if (r8.isNull(r113) == false) goto L59;
        String r43 = null;
    L61:
        if (r8.isNull(r114) == false) goto L63;
        String r44 = null;
    L65:
        if (r8.isNull(r21) == false) goto L67;
        String r45 = null;
    L68:
        int r46 = r8.getInt(r22);     // Catch: Throwable -> L76
        r22 = r22;
        r23 = r23;
        if (r8.isNull(r23) == false) goto L71;
        String r47 = null;
    L72:
        long r48 = r8.getLong(r24);     // Catch: Throwable -> L76
        r24 = r24;
        r26.add(new bu(r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48));     // Catch: Throwable -> L76
        r0 = r210;
        r25 = r25;
        goto L14
    L71:
        r47 = r8.getString(r23);     // Catch: Throwable -> L76
        goto L72
    L67:
        r45 = r8.getString(r21);     // Catch: Throwable -> L76
        goto L68
    L63:
        r44 = r8.getString(r114);     // Catch: Throwable -> L76
        goto L65
    L59:
        r43 = r8.getString(r113);     // Catch: Throwable -> L76
        goto L61
    L55:
        r42 = Long.valueOf(r8.getLong(r112));     // Catch: Throwable -> L76
        goto L57
    L51:
        r41 = Long.valueOf(r8.getLong(r111));     // Catch: Throwable -> L76
        goto L53
    L47:
        r39 = r8.getString(r110);     // Catch: Throwable -> L76
        goto L48
    L43:
        r38 = r8.getString(r19);     // Catch: Throwable -> L76
        goto L45
    L39:
        r37 = r8.getString(r18);     // Catch: Throwable -> L76
        goto L41
    L35:
        r36 = Long.valueOf(r8.getLong(r17));     // Catch: Throwable -> L76
        goto L37
    L31:
        r35 = r8.getString(r16);     // Catch: Throwable -> L76
        goto L33
    L27:
        r34 = r8.getString(r15);     // Catch: Throwable -> L76
        goto L29
    L23:
        r31 = r8.getString(r12);     // Catch: Throwable -> L76
        goto L24
    L19:
        r30 = r8.getString(r11);     // Catch: Throwable -> L76
        goto L21
    L74:
        r8.close();
        r52.release();
        return r26;
    L76:
        th = th;
    L80:
        r8.close();
        r52.release();
        throw th;
    L78:
        th = th;
        r52 = r5;
        goto L80
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public bu queryByUUID(String r1) {
        return EvaluationSourceDataDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ bu queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.EvaluationSourceDataDao
    public List<bu> queryByUserIndex(int r51) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM EvaluationSourceData WHERE userIndex = ?", 1);
        r1.bindLong(1, r51);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L70
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "dataId");     // Catch: Throwable -> L70
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "groupId");     // Catch: Throwable -> L70
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "dataContent");     // Catch: Throwable -> L70
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "targetSummaryEvent");     // Catch: Throwable -> L70
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, ObricMemoryConstants.KEY_SESSION_ID);     // Catch: Throwable -> L70
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "userType");     // Catch: Throwable -> L70
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "sessionType");     // Catch: Throwable -> L70
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "originalData");     // Catch: Throwable -> L70
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "groundTruth");     // Catch: Throwable -> L70
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "groundTruthReason");     // Catch: Throwable -> L70
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "searchText");     // Catch: Throwable -> L70
        int r15 = CursorUtil.getColumnIndexOrThrow(r2, WsConstants.KEY_EXTRA);     // Catch: Throwable -> L70
        int r3 = CursorUtil.getColumnIndexOrThrow(r2, "validQuery");     // Catch: Throwable -> L70
        RoomSQLiteQuery r16 = r1;
        int r52 = CursorUtil.getColumnIndexOrThrow(r2, "largeModelUsage");     // Catch: Throwable -> L68
        int r17 = CursorUtil.getColumnIndexOrThrow(r2, "gsb");     // Catch: Throwable -> L68
        int r18 = CursorUtil.getColumnIndexOrThrow(r2, "gsbReason");     // Catch: Throwable -> L68
        int r19 = CursorUtil.getColumnIndexOrThrow(r2, "retrievalScore");     // Catch: Throwable -> L68
        int r20 = CursorUtil.getColumnIndexOrThrow(r2, "retrievalScoreReason");     // Catch: Throwable -> L68
        int r21 = CursorUtil.getColumnIndexOrThrow(r2, "userIndex");     // Catch: Throwable -> L68
        int r22 = CursorUtil.getColumnIndexOrThrow(r2, "realValue");     // Catch: Throwable -> L68
        int r23 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L68
        int r24 = r3;
        ArrayList r25 = new ArrayList(r2.getCount());     // Catch: Throwable -> L68
    L6:
        if (r2.moveToNext() == false) goto L66;
        long r26 = r2.getLong(r0);     // Catch: Throwable -> L68
        int r28 = r2.getInt(r4);     // Catch: Throwable -> L68
        int r29 = r2.getInt(r5);     // Catch: Throwable -> L68
        if (r2.isNull(r6) == false) goto L11;
        String r30 = null;
    L13:
        if (r2.isNull(r7) == false) goto L15;
        String r31 = null;
    L16:
        int r32 = r2.getInt(r8);     // Catch: Throwable -> L68
        int r33 = r2.getInt(r9);     // Catch: Throwable -> L68
        if (r2.isNull(r10) == false) goto L19;
        String r34 = null;
    L21:
        if (r2.isNull(r11) == false) goto L23;
        String r35 = null;
    L25:
        if (r2.isNull(r12) == false) goto L27;
        Long r36 = null;
    L29:
        if (r2.isNull(r13) == false) goto L31;
        String r37 = null;
    L33:
        if (r2.isNull(r14) == false) goto L35;
        String r38 = null;
    L37:
        if (r2.isNull(r15) == false) goto L39;
        String r39 = null;
    L40:
        int r40 = r2.getInt(r24);     // Catch: Throwable -> L68
        int r27 = r0;
        r52 = r52;
        if (r2.isNull(r52) == false) goto L43;
        Long r41 = null;
    L45:
        if (r2.isNull(r17) == false) goto L47;
        Long r42 = null;
    L49:
        if (r2.isNull(r18) == false) goto L51;
        String r43 = null;
    L53:
        if (r2.isNull(r19) == false) goto L55;
        String r44 = null;
    L57:
        if (r2.isNull(r20) == false) goto L59;
        String r45 = null;
    L60:
        int r46 = r2.getInt(r21);     // Catch: Throwable -> L68
        r21 = r21;
        r22 = r22;
        if (r2.isNull(r22) == false) goto L63;
        String r47 = null;
    L64:
        long r48 = r2.getLong(r23);     // Catch: Throwable -> L68
        r23 = r23;
        r25.add(new bu(r26, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48));     // Catch: Throwable -> L68
        r0 = r27;
        r24 = r24;
        goto L6
    L63:
        r47 = r2.getString(r22);     // Catch: Throwable -> L68
        goto L64
    L59:
        r45 = r2.getString(r20);     // Catch: Throwable -> L68
        goto L60
    L55:
        r44 = r2.getString(r19);     // Catch: Throwable -> L68
        goto L57
    L51:
        r43 = r2.getString(r18);     // Catch: Throwable -> L68
        goto L53
    L47:
        r42 = Long.valueOf(r2.getLong(r17));     // Catch: Throwable -> L68
        goto L49
    L43:
        r41 = Long.valueOf(r2.getLong(r52));     // Catch: Throwable -> L68
        goto L45
    L39:
        r39 = r2.getString(r15);     // Catch: Throwable -> L68
        goto L40
    L35:
        r38 = r2.getString(r14);     // Catch: Throwable -> L68
        goto L37
    L31:
        r37 = r2.getString(r13);     // Catch: Throwable -> L68
        goto L33
    L27:
        r36 = Long.valueOf(r2.getLong(r12));     // Catch: Throwable -> L68
        goto L29
    L23:
        r35 = r2.getString(r11);     // Catch: Throwable -> L68
        goto L25
    L19:
        r34 = r2.getString(r10);     // Catch: Throwable -> L68
        goto L21
    L15:
        r31 = r2.getString(r7);     // Catch: Throwable -> L68
        goto L16
    L11:
        r30 = r2.getString(r6);     // Catch: Throwable -> L68
        goto L13
    L66:
        r2.close();
        r16.release();
        return r25;
    L68:
        th = th;
    L72:
        r2.close();
        r16.release();
        throw th;
    L70:
        th = th;
        r16 = r1;
        goto L72
    }

    @Override // com.obric.memorydata.database.dao.EvaluationSourceDataDao
    public List<bu> queryByUserIndexDataIdAndSessionType(int r49, int r50, String r51) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM EvaluationSourceData WHERE userIndex = ? AND dataId = ? AND sessionType = ?", 3);
        r2.bindLong(1, r49);
        r2.bindLong(2, r50);
        if (r51 != null) goto L5;
        r2.bindNull(3);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, "timestamp");     // Catch: Throwable -> L76
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "dataId");     // Catch: Throwable -> L76
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "groupId");     // Catch: Throwable -> L76
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "dataContent");     // Catch: Throwable -> L76
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "targetSummaryEvent");     // Catch: Throwable -> L76
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, ObricMemoryConstants.KEY_SESSION_ID);     // Catch: Throwable -> L76
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "userType");     // Catch: Throwable -> L76
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "sessionType");     // Catch: Throwable -> L76
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "originalData");     // Catch: Throwable -> L76
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "groundTruth");     // Catch: Throwable -> L76
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, "groundTruthReason");     // Catch: Throwable -> L76
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "searchText");     // Catch: Throwable -> L76
        int r15 = CursorUtil.getColumnIndexOrThrow(r1, WsConstants.KEY_EXTRA);     // Catch: Throwable -> L76
        int r3 = CursorUtil.getColumnIndexOrThrow(r1, "validQuery");     // Catch: Throwable -> L76
        RoomSQLiteQuery r16 = r2;
        int r410 = CursorUtil.getColumnIndexOrThrow(r1, "largeModelUsage");     // Catch: Throwable -> L74
        int r52 = CursorUtil.getColumnIndexOrThrow(r1, "gsb");     // Catch: Throwable -> L74
        int r53 = CursorUtil.getColumnIndexOrThrow(r1, "gsbReason");     // Catch: Throwable -> L74
        int r17 = CursorUtil.getColumnIndexOrThrow(r1, "retrievalScore");     // Catch: Throwable -> L74
        int r18 = CursorUtil.getColumnIndexOrThrow(r1, "retrievalScoreReason");     // Catch: Throwable -> L74
        int r19 = CursorUtil.getColumnIndexOrThrow(r1, "userIndex");     // Catch: Throwable -> L74
        int r20 = CursorUtil.getColumnIndexOrThrow(r1, "realValue");     // Catch: Throwable -> L74
        int r21 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L74
        int r22 = r3;
        ArrayList r23 = new ArrayList(r1.getCount());     // Catch: Throwable -> L74
    L10:
        if (r1.moveToNext() == false) goto L72;
        long r24 = r1.getLong(r0);     // Catch: Throwable -> L74
        int r26 = r1.getInt(r4);     // Catch: Throwable -> L74
        int r27 = r1.getInt(r5);     // Catch: Throwable -> L74
        if (r1.isNull(r6) == false) goto L15;
        String r28 = null;
    L17:
        if (r1.isNull(r7) == false) goto L19;
        String r29 = null;
    L20:
        int r30 = r1.getInt(r8);     // Catch: Throwable -> L74
        int r31 = r1.getInt(r9);     // Catch: Throwable -> L74
        if (r1.isNull(r10) == false) goto L23;
        String r32 = null;
    L25:
        if (r1.isNull(r11) == false) goto L27;
        String r33 = null;
    L29:
        if (r1.isNull(r12) == false) goto L31;
        Long r34 = null;
    L33:
        if (r1.isNull(r13) == false) goto L35;
        String r35 = null;
    L37:
        if (r1.isNull(r14) == false) goto L39;
        String r36 = null;
    L41:
        if (r1.isNull(r15) == false) goto L43;
        String r37 = null;
    L44:
        int r38 = r1.getInt(r22);     // Catch: Throwable -> L74
        int r25 = r0;
        r410 = r410;
        if (r1.isNull(r410) == false) goto L48;
        Long r39 = null;
    L47:
        r52 = r52;
        if (r1.isNull(r52) == false) goto L53;
        Long r40 = null;
    L52:
        r53 = r53;
        if (r1.isNull(r53) == false) goto L57;
        String r41 = null;
    L59:
        if (r1.isNull(r17) == false) goto L61;
        String r42 = null;
    L63:
        if (r1.isNull(r18) == false) goto L65;
        String r43 = null;
    L66:
        int r44 = r1.getInt(r19);     // Catch: Throwable -> L74
        r19 = r19;
        r20 = r20;
        if (r1.isNull(r20) == false) goto L69;
        String r45 = null;
    L70:
        long r46 = r1.getLong(r21);     // Catch: Throwable -> L74
        r21 = r21;
        r23.add(new bu(r24, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46));     // Catch: Throwable -> L74
        r0 = r25;
        r22 = r22;
        goto L10
    L69:
        r45 = r1.getString(r20);     // Catch: Throwable -> L74
        goto L70
    L65:
        r43 = r1.getString(r18);     // Catch: Throwable -> L74
        goto L66
    L61:
        r42 = r1.getString(r17);     // Catch: Throwable -> L74
        goto L63
    L57:
        r41 = r1.getString(r53);     // Catch: Throwable -> L74
        goto L59
    L53:
        r40 = Long.valueOf(r1.getLong(r52));     // Catch: Throwable -> L74
        goto L52
    L48:
        r39 = Long.valueOf(r1.getLong(r410));     // Catch: Throwable -> L74
        goto L47
    L43:
        r37 = r1.getString(r15);     // Catch: Throwable -> L74
        goto L44
    L39:
        r36 = r1.getString(r14);     // Catch: Throwable -> L74
        goto L41
    L35:
        r35 = r1.getString(r13);     // Catch: Throwable -> L74
        goto L37
    L31:
        r34 = Long.valueOf(r1.getLong(r12));     // Catch: Throwable -> L74
        goto L33
    L27:
        r33 = r1.getString(r11);     // Catch: Throwable -> L74
        goto L29
    L23:
        r32 = r1.getString(r10);     // Catch: Throwable -> L74
        goto L25
    L19:
        r29 = r1.getString(r7);     // Catch: Throwable -> L74
        goto L20
    L15:
        r28 = r1.getString(r6);     // Catch: Throwable -> L74
        goto L17
    L72:
        r1.close();
        r16.release();
        return r23;
    L74:
        th = th;
    L78:
        r1.close();
        r16.release();
        throw th;
    L76:
        th = th;
        r16 = r2;
        goto L78
    L5:
        r2.bindString(3, r51);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.EvaluationSourceDataDao
    public Integer queryMaxSessionIdByUserIndexAndDataId(int r5, int r6) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT MAX(sessionId) FROM EvaluationSourceData WHERE userIndex = ? AND dataId = ?", 2);
        r0.bindLong(1, r5);
        r0.bindLong(2, r6);
        this.__db.assertNotSuspendingTransaction();
        Integer r7 = null;
        Cursor r4 = DBUtil.query(this.__db, r0, false, null);
    L12:
        th = move-exception;
        r4.close();
        r0.release();
        throw th;
    L4:
        if (r4.moveToFirst() == true) goto L6;
    L10:
        r4.close();
        r0.release();
        return r7;
    L6:
        if (r4.isNull(0) == true) goto L10;
        r7 = Integer.valueOf(r4.getInt(0));     // Catch: Throwable -> L12
        goto L10
    }

    @Override // com.obric.memorydata.database.dao.EvaluationSourceDataDao
    public Integer queryMaxUserIndex() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT MAX(userIndex) FROM EvaluationSourceData", 0);
        this.__db.assertNotSuspendingTransaction();
        Integer r2 = null;
        Cursor r4 = DBUtil.query(this.__db, r0, false, null);
    L12:
        th = move-exception;
        r4.close();
        r0.release();
        throw th;
    L4:
        if (r4.moveToFirst() == true) goto L6;
    L10:
        r4.close();
        r0.release();
        return r2;
    L6:
        if (r4.isNull(0) == true) goto L10;
        r2 = Integer.valueOf(r4.getInt(0));     // Catch: Throwable -> L12
        goto L10
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public bu queryOne() {
        return EvaluationSourceDataDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ bu queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<bu> queryWithLimitAndOffset(int r1, int r2) {
        return EvaluationSourceDataDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<bu> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityEvaluationSourceDataEntity(r6));     // Catch: Throwable -> L10
        goto L5
    L8:
        r6.close();
        return r0;
    L10:
        th = move-exception;
        r6.close();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public Cursor rawQueryForCursor(SupportSQLiteQuery r3) {
        SupportSQLiteQuery r4 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        return this.__db.query(r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int rawQueryForInt(SupportSQLiteQuery r3) {
        SupportSQLiteQuery r4 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        int r0 = 0;
        Cursor r2 = DBUtil.query(this.__db, r4, false, null);
    L8:
        th = move-exception;
        r2.close();
        throw th;
    L4:
        if (r2.moveToFirst() == false) goto L6;
        r0 = r2.getInt(0);     // Catch: Throwable -> L8
    L6:
        r2.close();
        return r0;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public long rawQueryForLong(SupportSQLiteQuery r3) {
        SupportSQLiteQuery r4 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r4, false, null);
    L10:
        th = move-exception;
        r2.close();
        throw th;
    L4:
        if (r2.moveToFirst() == false) goto L7;
        long r0 = r2.getLong(0);     // Catch: Throwable -> L10
    L8:
        r2.close();
        return r0;
    L7:
        r0 = 0;
        goto L8
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public int update2(bu r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfEvaluationSourceDataEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(bu r3) {
        return update2((bu) ZeusTransformUtils.preCheckCast(r3, bu.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<bu> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfEvaluationSourceDataEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
