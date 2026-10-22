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
import com.obric.memorydata.database.entity.db;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class MemoryReviewFeedbackDao_Impl implements MemoryReviewFeedbackDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<db> __deletionAdapterOfMemoryReviewFeedbackEntity;
    private final EntityInsertionAdapter<db> __insertionAdapterOfMemoryReviewFeedbackEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final EntityDeletionOrUpdateAdapter<db> __updateAdapterOfMemoryReviewFeedbackEntity;

    public MemoryReviewFeedbackDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfMemoryReviewFeedbackEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfMemoryReviewFeedbackEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfMemoryReviewFeedbackEntity = new AnonymousClass3(this, r2);
        this.__preparedStmtOfDeleteAll = new AnonymousClass4(this, r2);
    }

    private db __entityCursorConverter_comObricMemorydataDatabaseEntityMemoryReviewFeedbackEntity(Cursor r40) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r40, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "record_id");
        int r3 = CursorUtil.getColumnIndex(r0, "module");
        int r4 = CursorUtil.getColumnIndex(r0, "vote");
        int r5 = CursorUtil.getColumnIndex(r0, "reasons_json");
        int r6 = CursorUtil.getColumnIndex(r0, "comment");
        int r7 = CursorUtil.getColumnIndex(r0, "displayed_card_json");
        int r8 = CursorUtil.getColumnIndex(r0, "status");
        int r9 = CursorUtil.getColumnIndex(r0, "error");
        int r10 = CursorUtil.getColumnIndex(r0, "trace_json");
        int r11 = CursorUtil.getColumnIndex(r0, "update_time");
        int r12 = CursorUtil.getColumnIndex(r0, "server_uniq_id");
        int r13 = CursorUtil.getColumnIndex(r0, "server_status");
        int r14 = CursorUtil.getColumnIndex(r0, "server_error");
        int r15 = CursorUtil.getColumnIndex(r0, "server_update_time");
        long r16 = 0;
        if (r1 != (-1)) goto L5;
        long r21 = 0;
    L6:
        String r17 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r23 = null;
    L13:
        if (r3 != (-1)) goto L16;
    L14:
        String r24 = null;
    L19:
        if (r4 != (-1)) goto L22;
    L20:
        String r25 = null;
    L25:
        if (r5 != (-1)) goto L28;
    L26:
        String r26 = null;
    L31:
        if (r6 != (-1)) goto L34;
    L32:
        String r27 = null;
    L37:
        if (r7 != (-1)) goto L40;
    L38:
        String r28 = null;
    L43:
        if (r8 != (-1)) goto L46;
    L44:
        String r29 = null;
    L49:
        if (r9 != (-1)) goto L52;
    L50:
        String r30 = null;
    L55:
        if (r10 != (-1)) goto L58;
    L56:
        String r31 = null;
    L61:
        if (r11 != (-1)) goto L63;
        long r32 = 0;
    L64:
        if (r12 != (-1)) goto L67;
    L65:
        String r34 = null;
    L70:
        if (r13 != (-1)) goto L73;
    L71:
        String r35 = null;
    L76:
        if (r14 != (-1)) goto L79;
    L77:
        String r36 = r17;
        if (r15 == (-1)) goto L86;
        r16 = r0.getLong(r15);
    L86:
        return new db(r21, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r34, r35, r36, r16);
    L79:
        if (r0.isNull(r14) == true) goto L77;
        r17 = r0.getString(r14);
        goto L77
    L73:
        if (r0.isNull(r13) == true) goto L71;
        r35 = r0.getString(r13);
        goto L76
    L67:
        if (r0.isNull(r12) == true) goto L65;
        r34 = r0.getString(r12);
        goto L70
    L63:
        r32 = r0.getLong(r11);
        goto L64
    L58:
        if (r0.isNull(r10) == true) goto L56;
        r31 = r0.getString(r10);
        goto L61
    L52:
        if (r0.isNull(r9) == true) goto L50;
        r30 = r0.getString(r9);
        goto L55
    L46:
        if (r0.isNull(r8) == true) goto L44;
        r29 = r0.getString(r8);
        goto L49
    L40:
        if (r0.isNull(r7) == true) goto L38;
        r28 = r0.getString(r7);
        goto L43
    L34:
        if (r0.isNull(r6) == true) goto L32;
        r27 = r0.getString(r6);
        goto L37
    L28:
        if (r0.isNull(r5) == true) goto L26;
        r26 = r0.getString(r5);
        goto L31
    L22:
        if (r0.isNull(r4) == true) goto L20;
        r25 = r0.getString(r4);
        goto L25
    L16:
        if (r0.isNull(r3) == true) goto L14;
        r24 = r0.getString(r3);
        goto L19
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r23 = r0.getString(r2);
        goto L13
    L5:
        r21 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<db> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfMemoryReviewFeedbackEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryReviewFeedbackDao, com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<db> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfMemoryReviewFeedbackEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(db r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfMemoryReviewFeedbackEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(db r3) {
        return delete2((db) ZeusTransformUtils.preCheckCast(r3, db.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.MemoryReviewFeedbackDao, com.obric.memorydata.database.dao.BaseDao
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

    @Override // com.obric.memorydata.database.dao.MemoryReviewFeedbackDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return MemoryReviewFeedbackDao.DefaultImpls.getTableName(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.MemoryReviewFeedbackDao
    public long insert(db r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfMemoryReviewFeedbackEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(db r3) {
        return insert((db) ZeusTransformUtils.preCheckCast(r3, db.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.MemoryReviewFeedbackDao, com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<db> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfMemoryReviewFeedbackEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<db> queryAll() {
        return MemoryReviewFeedbackDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return MemoryReviewFeedbackDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public db queryById(long r1) {
        return MemoryReviewFeedbackDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ db queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<db> queryByIds(List<Long> r3) {
        return MemoryReviewFeedbackDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.MemoryReviewFeedbackDao
    public List<db> queryByModulesAndRecords(List<String> r38, List<String> r39) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r38, List.class, "com.obric.memorydata.plugin");
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r39, List.class, "com.obric.memorydata.plugin");
        StringBuilder r4 = StringUtil.newStringBuilder();
        r4.append("SELECT * FROM MemoryReviewFeedback WHERE module IN (");
        int r5 = r1.size();
        StringUtil.appendPlaceholders(r4, r5);
        r4.append(") AND record_id IN (");
        int r6 = r3.size();
        StringUtil.appendPlaceholders(r4, r6);
        r4.append(")");
        RoomSQLiteQuery r7 = RoomSQLiteQuery.acquire(r4.toString(), (r5 + 0) + r6);
        Iterator r2 = r1.iterator();
        int r8 = 1;
    L4:
        if (r2.hasNext() == false) goto L10;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L8;
        r7.bindNull(r8);
    L9:
        r8 = r8 + 1;
        goto L4
    L8:
        r7.bindString(r8, r9);
        goto L9
    L10:
        int r10 = r5 + 1;
        Iterator r11 = r3.iterator();
    L12:
        if (r11.hasNext() == false) goto L18;
        String r12 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L16;
        r7.bindNull(r10);
    L17:
        r10 = r10 + 1;
        goto L12
    L16:
        r7.bindString(r10, r12);
        goto L17
    L18:
        this.__db.assertNotSuspendingTransaction();
        Cursor r13 = DBUtil.query(this.__db, r7, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r13, OaidModel.KEY_ID);     // Catch: Throwable -> L79
        int r14 = CursorUtil.getColumnIndexOrThrow(r13, "record_id");     // Catch: Throwable -> L79
        int r15 = CursorUtil.getColumnIndexOrThrow(r13, "module");     // Catch: Throwable -> L79
        int r16 = CursorUtil.getColumnIndexOrThrow(r13, "vote");     // Catch: Throwable -> L79
        int r17 = CursorUtil.getColumnIndexOrThrow(r13, "reasons_json");     // Catch: Throwable -> L79
        int r18 = CursorUtil.getColumnIndexOrThrow(r13, "comment");     // Catch: Throwable -> L79
        int r19 = CursorUtil.getColumnIndexOrThrow(r13, "displayed_card_json");     // Catch: Throwable -> L79
        int r110 = CursorUtil.getColumnIndexOrThrow(r13, "status");     // Catch: Throwable -> L79
        int r111 = CursorUtil.getColumnIndexOrThrow(r13, "error");     // Catch: Throwable -> L79
        int r112 = CursorUtil.getColumnIndexOrThrow(r13, "trace_json");     // Catch: Throwable -> L79
        int r113 = CursorUtil.getColumnIndexOrThrow(r13, "update_time");     // Catch: Throwable -> L79
        int r114 = CursorUtil.getColumnIndexOrThrow(r13, "server_uniq_id");     // Catch: Throwable -> L79
        int r115 = CursorUtil.getColumnIndexOrThrow(r13, "server_status");     // Catch: Throwable -> L79
        int r20 = CursorUtil.getColumnIndexOrThrow(r13, "server_error");     // Catch: Throwable -> L79
        RoomSQLiteQuery r310 = r7;
        int r311 = CursorUtil.getColumnIndexOrThrow(r13, "server_update_time");     // Catch: Throwable -> L77
        int r116 = r20;
        ArrayList r21 = new ArrayList(r13.getCount());     // Catch: Throwable -> L77
    L22:
        if (r13.moveToNext() == false) goto L75;
        long r117 = r13.getLong(r0);     // Catch: Throwable -> L77
        if (r13.isNull(r14) == false) goto L27;
        String r22 = null;
    L29:
        if (r13.isNull(r15) == false) goto L31;
        String r23 = null;
    L33:
        if (r13.isNull(r16) == false) goto L35;
        String r24 = null;
    L37:
        if (r13.isNull(r17) == false) goto L39;
        String r25 = null;
    L41:
        if (r13.isNull(r18) == false) goto L43;
        String r26 = null;
    L45:
        if (r13.isNull(r19) == false) goto L47;
        String r27 = null;
    L49:
        if (r13.isNull(r110) == false) goto L51;
        String r28 = null;
    L53:
        if (r13.isNull(r111) == false) goto L55;
        String r29 = null;
    L57:
        if (r13.isNull(r112) == false) goto L59;
        String r210 = null;
    L60:
        long r211 = r13.getLong(r113);     // Catch: Throwable -> L77
        if (r13.isNull(r114) == false) goto L63;
        String r31 = null;
    L65:
        if (r13.isNull(r115) == false) goto L67;
        String r32 = null;
    L69:
        if (r13.isNull(r116) == false) goto L72;
        String r33 = null;
    L71:
        int r36 = r0;
        int r30 = r311;
        r21.add(new db(r117, r22, r23, r24, r25, r26, r27, r28, r29, r210, r211, r31, r32, r33, r13.getLong(r30)));     // Catch: Throwable -> L77
        r0 = r36;
        r311 = r30;
        r116 = r116;
        goto L22
    L72:
        r33 = r13.getString(r116);     // Catch: Throwable -> L77
        goto L71
    L67:
        r32 = r13.getString(r115);     // Catch: Throwable -> L77
        goto L69
    L63:
        r31 = r13.getString(r114);     // Catch: Throwable -> L77
        goto L65
    L59:
        r210 = r13.getString(r112);     // Catch: Throwable -> L77
        goto L60
    L55:
        r29 = r13.getString(r111);     // Catch: Throwable -> L77
        goto L57
    L51:
        r28 = r13.getString(r110);     // Catch: Throwable -> L77
        goto L53
    L47:
        r27 = r13.getString(r19);     // Catch: Throwable -> L77
        goto L49
    L43:
        r26 = r13.getString(r18);     // Catch: Throwable -> L77
        goto L45
    L39:
        r25 = r13.getString(r17);     // Catch: Throwable -> L77
        goto L41
    L35:
        r24 = r13.getString(r16);     // Catch: Throwable -> L77
        goto L37
    L31:
        r23 = r13.getString(r15);     // Catch: Throwable -> L77
        goto L33
    L27:
        r22 = r13.getString(r14);     // Catch: Throwable -> L77
        goto L29
    L75:
        r13.close();
        r310.release();
        return r21;
    L77:
        th = th;
    L81:
        r13.close();
        r310.release();
        throw th;
    L79:
        th = th;
        r310 = r7;
        goto L81
    }

    @Override // com.obric.memorydata.database.dao.MemoryReviewFeedbackDao
    public List<db> queryByModulesAndStatus(List<String> r38, String r39) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r38, List.class, "com.obric.memorydata.plugin");
        StringBuilder r4 = StringUtil.newStringBuilder();
        r4.append("SELECT * FROM MemoryReviewFeedback WHERE module IN (");
        int r5 = r2.size();
        StringUtil.appendPlaceholders(r4, r5);
        r4.append(") AND status = ");
        r4.append("?");
        int r6 = 1;
        int r7 = r5 + 1;
        RoomSQLiteQuery r8 = RoomSQLiteQuery.acquire(r4.toString(), r7);
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L10;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L8;
        r8.bindNull(r6);
    L9:
        r6 = r6 + 1;
        goto L4
    L8:
        r8.bindString(r6, r9);
        goto L9
    L10:
        if (r39 != null) goto L12;
        r8.bindNull(r7);
    L13:
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r8, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L74
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "record_id");     // Catch: Throwable -> L74
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "module");     // Catch: Throwable -> L74
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "vote");     // Catch: Throwable -> L74
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, "reasons_json");     // Catch: Throwable -> L74
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "comment");     // Catch: Throwable -> L74
        int r15 = CursorUtil.getColumnIndexOrThrow(r1, "displayed_card_json");     // Catch: Throwable -> L74
        int r16 = CursorUtil.getColumnIndexOrThrow(r1, "status");     // Catch: Throwable -> L74
        int r17 = CursorUtil.getColumnIndexOrThrow(r1, "error");     // Catch: Throwable -> L74
        int r18 = CursorUtil.getColumnIndexOrThrow(r1, "trace_json");     // Catch: Throwable -> L74
        int r19 = CursorUtil.getColumnIndexOrThrow(r1, "update_time");     // Catch: Throwable -> L74
        int r110 = CursorUtil.getColumnIndexOrThrow(r1, "server_uniq_id");     // Catch: Throwable -> L74
        int r111 = CursorUtil.getColumnIndexOrThrow(r1, "server_status");     // Catch: Throwable -> L74
        int r20 = CursorUtil.getColumnIndexOrThrow(r1, "server_error");     // Catch: Throwable -> L74
        RoomSQLiteQuery r310 = r8;
        int r311 = CursorUtil.getColumnIndexOrThrow(r1, "server_update_time");     // Catch: Throwable -> L72
        int r112 = r20;
        ArrayList r21 = new ArrayList(r1.getCount());     // Catch: Throwable -> L72
    L17:
        if (r1.moveToNext() == false) goto L70;
        long r113 = r1.getLong(r0);     // Catch: Throwable -> L72
        if (r1.isNull(r10) == false) goto L22;
        String r22 = null;
    L24:
        if (r1.isNull(r11) == false) goto L26;
        String r23 = null;
    L28:
        if (r1.isNull(r12) == false) goto L30;
        String r24 = null;
    L32:
        if (r1.isNull(r13) == false) goto L34;
        String r25 = null;
    L36:
        if (r1.isNull(r14) == false) goto L38;
        String r26 = null;
    L40:
        if (r1.isNull(r15) == false) goto L42;
        String r27 = null;
    L44:
        if (r1.isNull(r16) == false) goto L46;
        String r28 = null;
    L48:
        if (r1.isNull(r17) == false) goto L50;
        String r29 = null;
    L52:
        if (r1.isNull(r18) == false) goto L54;
        String r210 = null;
    L55:
        long r211 = r1.getLong(r19);     // Catch: Throwable -> L72
        if (r1.isNull(r110) == false) goto L58;
        String r31 = null;
    L60:
        if (r1.isNull(r111) == false) goto L62;
        String r32 = null;
    L64:
        if (r1.isNull(r112) == false) goto L67;
        String r33 = null;
    L66:
        int r36 = r0;
        int r30 = r311;
        r21.add(new db(r113, r22, r23, r24, r25, r26, r27, r28, r29, r210, r211, r31, r32, r33, r1.getLong(r30)));     // Catch: Throwable -> L72
        r0 = r36;
        r311 = r30;
        r112 = r112;
        goto L17
    L67:
        r33 = r1.getString(r112);     // Catch: Throwable -> L72
        goto L66
    L62:
        r32 = r1.getString(r111);     // Catch: Throwable -> L72
        goto L64
    L58:
        r31 = r1.getString(r110);     // Catch: Throwable -> L72
        goto L60
    L54:
        r210 = r1.getString(r18);     // Catch: Throwable -> L72
        goto L55
    L50:
        r29 = r1.getString(r17);     // Catch: Throwable -> L72
        goto L52
    L46:
        r28 = r1.getString(r16);     // Catch: Throwable -> L72
        goto L48
    L42:
        r27 = r1.getString(r15);     // Catch: Throwable -> L72
        goto L44
    L38:
        r26 = r1.getString(r14);     // Catch: Throwable -> L72
        goto L40
    L34:
        r25 = r1.getString(r13);     // Catch: Throwable -> L72
        goto L36
    L30:
        r24 = r1.getString(r12);     // Catch: Throwable -> L72
        goto L32
    L26:
        r23 = r1.getString(r11);     // Catch: Throwable -> L72
        goto L28
    L22:
        r22 = r1.getString(r10);     // Catch: Throwable -> L72
        goto L24
    L70:
        r1.close();
        r310.release();
        return r21;
    L72:
        th = th;
    L76:
        r1.close();
        r310.release();
        throw th;
    L74:
        th = th;
        r310 = r8;
        goto L76
    L12:
        r8.bindString(r7, r39);
        goto L13
    }

    @Override // com.obric.memorydata.database.dao.MemoryReviewFeedbackDao
    public db queryByRecord(String r38, String r39) {
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("SELECT * FROM MemoryReviewFeedback WHERE module = ? AND record_id = ? LIMIT 1", 2);
        if (r38 != null) goto L5;
        r3.bindNull(1);
    L6:
        if (r39 != null) goto L8;
        r3.bindNull(2);
    L9:
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r3, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L69
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "record_id");     // Catch: Throwable -> L69
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "module");     // Catch: Throwable -> L69
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "vote");     // Catch: Throwable -> L69
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "reasons_json");     // Catch: Throwable -> L69
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "comment");     // Catch: Throwable -> L69
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "displayed_card_json");     // Catch: Throwable -> L69
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "status");     // Catch: Throwable -> L69
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "error");     // Catch: Throwable -> L69
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "trace_json");     // Catch: Throwable -> L69
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, "update_time");     // Catch: Throwable -> L69
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "server_uniq_id");     // Catch: Throwable -> L69
        int r15 = CursorUtil.getColumnIndexOrThrow(r1, "server_status");     // Catch: Throwable -> L69
        int r2 = CursorUtil.getColumnIndexOrThrow(r1, "server_error");     // Catch: Throwable -> L69
        RoomSQLiteQuery r16 = r3;
        int r17 = CursorUtil.getColumnIndexOrThrow(r1, "server_update_time");     // Catch: Throwable -> L67
        if (r1.moveToFirst() == false) goto L64;
        long r19 = r1.getLong(r0);     // Catch: Throwable -> L67
        if (r1.isNull(r4) == false) goto L17;
        String r21 = null;
    L19:
        if (r1.isNull(r5) == false) goto L21;
        String r22 = null;
    L23:
        if (r1.isNull(r6) == false) goto L25;
        String r23 = null;
    L27:
        if (r1.isNull(r7) == false) goto L29;
        String r24 = null;
    L31:
        if (r1.isNull(r8) == false) goto L33;
        String r25 = null;
    L35:
        if (r1.isNull(r9) == false) goto L37;
        String r26 = null;
    L39:
        if (r1.isNull(r10) == false) goto L41;
        String r27 = null;
    L43:
        if (r1.isNull(r11) == false) goto L45;
        String r28 = null;
    L47:
        if (r1.isNull(r12) == false) goto L49;
        String r29 = null;
    L50:
        long r30 = r1.getLong(r13);     // Catch: Throwable -> L67
        if (r1.isNull(r14) == false) goto L53;
        String r32 = null;
    L55:
        if (r1.isNull(r15) == false) goto L57;
        String r33 = null;
    L59:
        if (r1.isNull(r2) == false) goto L61;
        String r34 = null;
    L62:
        db r18 = new db(r19, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r32, r33, r34, r1.getLong(r17));     // Catch: Throwable -> L67
    L65:
        r1.close();
        r16.release();
        return r18;
    L61:
        r34 = r1.getString(r2);     // Catch: Throwable -> L67
        goto L62
    L57:
        r33 = r1.getString(r15);     // Catch: Throwable -> L67
        goto L59
    L53:
        r32 = r1.getString(r14);     // Catch: Throwable -> L67
        goto L55
    L49:
        r29 = r1.getString(r12);     // Catch: Throwable -> L67
        goto L50
    L45:
        r28 = r1.getString(r11);     // Catch: Throwable -> L67
        goto L47
    L41:
        r27 = r1.getString(r10);     // Catch: Throwable -> L67
        goto L43
    L37:
        r26 = r1.getString(r9);     // Catch: Throwable -> L67
        goto L39
    L33:
        r25 = r1.getString(r8);     // Catch: Throwable -> L67
        goto L35
    L29:
        r24 = r1.getString(r7);     // Catch: Throwable -> L67
        goto L31
    L25:
        r23 = r1.getString(r6);     // Catch: Throwable -> L67
        goto L27
    L21:
        r22 = r1.getString(r5);     // Catch: Throwable -> L67
        goto L23
    L17:
        r21 = r1.getString(r4);     // Catch: Throwable -> L67
        goto L19
    L64:
        r18 = null;
    L67:
        th = th;
    L71:
        r1.close();
        r16.release();
        throw th;
    L69:
        th = th;
        r16 = r3;
        goto L71
    L8:
        r3.bindString(2, r39);
        goto L9
    L5:
        r3.bindString(1, r38);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.MemoryReviewFeedbackDao
    public List<db> queryByRecords(String r38, List<String> r39) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r39, List.class, "com.obric.memorydata.plugin");
        StringBuilder r4 = StringUtil.newStringBuilder();
        r4.append("SELECT * FROM MemoryReviewFeedback WHERE module = ");
        r4.append("?");
        r4.append(" AND record_id IN (");
        int r5 = r2.size();
        StringUtil.appendPlaceholders(r4, r5);
        r4.append(")");
        RoomSQLiteQuery r6 = RoomSQLiteQuery.acquire(r4.toString(), r5 + 1);
        if (r38 != null) goto L5;
        r6.bindNull(1);
    L6:
        int r1 = 2;
        Iterator r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L14;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L12;
        r6.bindNull(r1);
    L13:
        r1 = r1 + 1;
        goto L8
    L12:
        r6.bindString(r1, r7);
        goto L13
    L14:
        this.__db.assertNotSuspendingTransaction();
        Cursor r8 = DBUtil.query(this.__db, r6, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r8, OaidModel.KEY_ID);     // Catch: Throwable -> L75
        int r9 = CursorUtil.getColumnIndexOrThrow(r8, "record_id");     // Catch: Throwable -> L75
        int r10 = CursorUtil.getColumnIndexOrThrow(r8, "module");     // Catch: Throwable -> L75
        int r11 = CursorUtil.getColumnIndexOrThrow(r8, "vote");     // Catch: Throwable -> L75
        int r12 = CursorUtil.getColumnIndexOrThrow(r8, "reasons_json");     // Catch: Throwable -> L75
        int r13 = CursorUtil.getColumnIndexOrThrow(r8, "comment");     // Catch: Throwable -> L75
        int r14 = CursorUtil.getColumnIndexOrThrow(r8, "displayed_card_json");     // Catch: Throwable -> L75
        int r15 = CursorUtil.getColumnIndexOrThrow(r8, "status");     // Catch: Throwable -> L75
        int r16 = CursorUtil.getColumnIndexOrThrow(r8, "error");     // Catch: Throwable -> L75
        int r17 = CursorUtil.getColumnIndexOrThrow(r8, "trace_json");     // Catch: Throwable -> L75
        int r18 = CursorUtil.getColumnIndexOrThrow(r8, "update_time");     // Catch: Throwable -> L75
        int r19 = CursorUtil.getColumnIndexOrThrow(r8, "server_uniq_id");     // Catch: Throwable -> L75
        int r110 = CursorUtil.getColumnIndexOrThrow(r8, "server_status");     // Catch: Throwable -> L75
        int r20 = CursorUtil.getColumnIndexOrThrow(r8, "server_error");     // Catch: Throwable -> L75
        RoomSQLiteQuery r310 = r6;
        int r311 = CursorUtil.getColumnIndexOrThrow(r8, "server_update_time");     // Catch: Throwable -> L73
        int r111 = r20;
        ArrayList r21 = new ArrayList(r8.getCount());     // Catch: Throwable -> L73
    L18:
        if (r8.moveToNext() == false) goto L71;
        long r112 = r8.getLong(r0);     // Catch: Throwable -> L73
        if (r8.isNull(r9) == false) goto L23;
        String r22 = null;
    L25:
        if (r8.isNull(r10) == false) goto L27;
        String r23 = null;
    L29:
        if (r8.isNull(r11) == false) goto L31;
        String r24 = null;
    L33:
        if (r8.isNull(r12) == false) goto L35;
        String r25 = null;
    L37:
        if (r8.isNull(r13) == false) goto L39;
        String r26 = null;
    L41:
        if (r8.isNull(r14) == false) goto L43;
        String r27 = null;
    L45:
        if (r8.isNull(r15) == false) goto L47;
        String r28 = null;
    L49:
        if (r8.isNull(r16) == false) goto L51;
        String r29 = null;
    L53:
        if (r8.isNull(r17) == false) goto L55;
        String r210 = null;
    L56:
        long r211 = r8.getLong(r18);     // Catch: Throwable -> L73
        if (r8.isNull(r19) == false) goto L59;
        String r31 = null;
    L61:
        if (r8.isNull(r110) == false) goto L63;
        String r32 = null;
    L65:
        if (r8.isNull(r111) == false) goto L68;
        String r33 = null;
    L67:
        int r36 = r0;
        int r30 = r311;
        r21.add(new db(r112, r22, r23, r24, r25, r26, r27, r28, r29, r210, r211, r31, r32, r33, r8.getLong(r30)));     // Catch: Throwable -> L73
        r0 = r36;
        r311 = r30;
        r111 = r111;
        goto L18
    L68:
        r33 = r8.getString(r111);     // Catch: Throwable -> L73
        goto L67
    L63:
        r32 = r8.getString(r110);     // Catch: Throwable -> L73
        goto L65
    L59:
        r31 = r8.getString(r19);     // Catch: Throwable -> L73
        goto L61
    L55:
        r210 = r8.getString(r17);     // Catch: Throwable -> L73
        goto L56
    L51:
        r29 = r8.getString(r16);     // Catch: Throwable -> L73
        goto L53
    L47:
        r28 = r8.getString(r15);     // Catch: Throwable -> L73
        goto L49
    L43:
        r27 = r8.getString(r14);     // Catch: Throwable -> L73
        goto L45
    L39:
        r26 = r8.getString(r13);     // Catch: Throwable -> L73
        goto L41
    L35:
        r25 = r8.getString(r12);     // Catch: Throwable -> L73
        goto L37
    L31:
        r24 = r8.getString(r11);     // Catch: Throwable -> L73
        goto L33
    L27:
        r23 = r8.getString(r10);     // Catch: Throwable -> L73
        goto L29
    L23:
        r22 = r8.getString(r9);     // Catch: Throwable -> L73
        goto L25
    L71:
        r8.close();
        r310.release();
        return r21;
    L73:
        th = th;
    L77:
        r8.close();
        r310.release();
        throw th;
    L75:
        th = th;
        r310 = r6;
        goto L77
    L5:
        r6.bindString(1, r38);
        goto L6
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public db queryByUUID(String r1) {
        return MemoryReviewFeedbackDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ db queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public db queryOne() {
        return MemoryReviewFeedbackDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ db queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<db> queryWithLimitAndOffset(int r1, int r2) {
        return MemoryReviewFeedbackDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<db> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityMemoryReviewFeedbackEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(db r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfMemoryReviewFeedbackEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(db r3) {
        return update2((db) ZeusTransformUtils.preCheckCast(r3, db.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<db> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfMemoryReviewFeedbackEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
