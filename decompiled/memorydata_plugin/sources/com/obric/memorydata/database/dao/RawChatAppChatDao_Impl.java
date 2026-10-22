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
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.entity.fs;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class RawChatAppChatDao_Impl implements RawChatAppChatDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<fs> __deletionAdapterOfRawChatEntity;
    private final EntityInsertionAdapter<fs> __insertionAdapterOfRawChatEntity;
    private final SharedSQLiteStatement __preparedStmtOfUpdateAsUploaded;
    private final EntityDeletionOrUpdateAdapter<fs> __updateAdapterOfRawChatEntity;

    public RawChatAppChatDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfRawChatEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfRawChatEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfRawChatEntity = new AnonymousClass3(this, r2);
        this.__preparedStmtOfUpdateAsUploaded = new AnonymousClass4(this, r2);
    }

    private fs __entityCursorConverter_comObricMemorydataDatabaseEntityRawChatEntity(Cursor r37) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r37, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, "dataVersion");
        int r2 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r3 = CursorUtil.getColumnIndex(r0, "sequenceTime");
        int r4 = CursorUtil.getColumnIndex(r0, "chatType");
        int r5 = CursorUtil.getColumnIndex(r0, "chatName");
        int r6 = CursorUtil.getColumnIndex(r0, "msgPerson");
        int r7 = CursorUtil.getColumnIndex(r0, "msgType");
        int r8 = CursorUtil.getColumnIndex(r0, "msgContent");
        int r9 = CursorUtil.getColumnIndex(r0, "timeAccuracy");
        int r10 = CursorUtil.getColumnIndex(r0, "chatPeopleNum");
        int r11 = CursorUtil.getColumnIndex(r0, "refName");
        int r12 = CursorUtil.getColumnIndex(r0, "refContent");
        int r13 = CursorUtil.getColumnIndex(r0, "uploadState");
        int r14 = CursorUtil.getColumnIndex(r0, ObricMemoryConstants.KEY_PACKAGE_NAME);
        int r15 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r16 = 0;
        if (r1 != (-1)) goto L5;
        int r18 = 0;
    L7:
        if (r2 != (-1)) goto L9;
        long r17 = 0;
    L10:
        if (r3 != (-1)) goto L12;
        long r21 = 0;
    L13:
        if (r4 != (-1)) goto L15;
        int r23 = 0;
    L16:
        String r19 = null;
        if (r5 != (-1)) goto L20;
    L18:
        String r24 = null;
    L23:
        if (r6 != (-1)) goto L26;
    L24:
        String r25 = null;
    L29:
        if (r7 != (-1)) goto L31;
        int r26 = 0;
    L32:
        if (r8 != (-1)) goto L35;
    L33:
        String r27 = null;
    L38:
        if (r9 != (-1)) goto L40;
        int r28 = 0;
    L41:
        if (r10 != (-1)) goto L43;
        int r29 = 0;
    L44:
        if (r11 != (-1)) goto L47;
    L45:
        String r30 = null;
    L50:
        if (r12 != (-1)) goto L53;
    L51:
        String r31 = null;
    L56:
        if (r13 == (-1)) goto L59;
        r16 = r0.getInt(r13);
    L59:
        int r32 = r16;
        if (r14 != (-1)) goto L63;
    L61:
        String r33 = r19;
        if (r15 != (-1)) goto L68;
        long r34 = 0;
    L70:
        return new fs(r18, r17, r21, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34);
    L68:
        r34 = r0.getLong(r15);
        goto L70
    L63:
        if (r0.isNull(r14) == true) goto L61;
        r19 = r0.getString(r14);
        goto L61
    L53:
        if (r0.isNull(r12) == true) goto L51;
        r31 = r0.getString(r12);
        goto L56
    L47:
        if (r0.isNull(r11) == true) goto L45;
        r30 = r0.getString(r11);
        goto L50
    L43:
        r29 = r0.getInt(r10);
        goto L44
    L40:
        r28 = r0.getInt(r9);
        goto L41
    L35:
        if (r0.isNull(r8) == true) goto L33;
        r27 = r0.getString(r8);
        goto L38
    L31:
        r26 = r0.getInt(r7);
        goto L32
    L26:
        if (r0.isNull(r6) == true) goto L24;
        r25 = r0.getString(r6);
        goto L29
    L20:
        if (r0.isNull(r5) == true) goto L18;
        r24 = r0.getString(r5);
        goto L23
    L15:
        r23 = r0.getInt(r4);
        goto L16
    L12:
        r21 = r0.getLong(r3);
        goto L13
    L9:
        r17 = r0.getLong(r2);
        goto L10
    L5:
        r18 = r0.getInt(r1);
        goto L7
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<fs> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfRawChatEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<fs> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfRawChatEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(fs r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfRawChatEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(fs r3) {
        return delete2((fs) ZeusTransformUtils.preCheckCast(r3, fs.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return RawChatAppChatDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.RawChatAppChatDao
    public long getNeedUploadCount(String r4) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM RawWxChat WHERE uploadState == 0 AND packageName = ? ", 1);
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r3 = DBUtil.query(this.__db, r0, false, null);
    L14:
        th = move-exception;
        r3.close();
        r0.release();
        throw th;
    L8:
        if (r3.moveToFirst() == false) goto L11;
        long r1 = r3.getLong(0);     // Catch: Throwable -> L14
    L12:
        r3.close();
        r0.release();
        return r1;
    L11:
        r1 = 0;
        goto L12
    L5:
        r0.bindString(1, r4);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.RawChatAppChatDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return RawChatAppChatDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(fs r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfRawChatEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(fs r3) {
        return insert2((fs) ZeusTransformUtils.preCheckCast(r3, fs.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<fs> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfRawChatEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<fs> queryAll() {
        return RawChatAppChatDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return RawChatAppChatDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public fs queryById(long r1) {
        return RawChatAppChatDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ fs queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<fs> queryByIds(List<Long> r3) {
        return RawChatAppChatDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public fs queryByUUID(String r1) {
        return RawChatAppChatDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ fs queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.RawChatAppChatDao
    public List<fs> queryChatMsg(String r38, String r39, int r40, String r41, String r42) {
        RoomSQLiteQuery r5 = RoomSQLiteQuery.acquire("SELECT * FROM RawWxChat WHERE chatName = ? AND msgPerson = ? AND msgType = ? AND msgContent = ? AND packageName = ? ORDER BY sequenceTime ASC", 5);
        if (r38 != null) goto L5;
        r5.bindNull(1);
    L7:
        if (r39 != null) goto L9;
        r5.bindNull(2);
    L10:
        r5.bindLong(3, r40);
        if (r41 != null) goto L13;
        r5.bindNull(4);
    L14:
        if (r42 != null) goto L16;
        r5.bindNull(5);
    L17:
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r5, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, "dataVersion");     // Catch: Throwable -> L54
        int r3 = CursorUtil.getColumnIndexOrThrow(r1, "timestamp");     // Catch: Throwable -> L54
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "sequenceTime");     // Catch: Throwable -> L54
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "chatType");     // Catch: Throwable -> L54
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "chatName");     // Catch: Throwable -> L54
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "msgPerson");     // Catch: Throwable -> L54
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "msgType");     // Catch: Throwable -> L54
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "msgContent");     // Catch: Throwable -> L54
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "timeAccuracy");     // Catch: Throwable -> L54
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "chatPeopleNum");     // Catch: Throwable -> L54
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, "refName");     // Catch: Throwable -> L54
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "refContent");     // Catch: Throwable -> L54
        int r15 = CursorUtil.getColumnIndexOrThrow(r1, "uploadState");     // Catch: Throwable -> L54
        int r2 = CursorUtil.getColumnIndexOrThrow(r1, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L54
        RoomSQLiteQuery r16 = r5;
        int r310 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L52
        int r311 = r2;
        ArrayList r17 = new ArrayList(r1.getCount());     // Catch: Throwable -> L52
    L21:
        if (r1.moveToNext() == false) goto L50;
        int r18 = r1.getInt(r0);     // Catch: Throwable -> L52
        long r19 = r1.getLong(r3);     // Catch: Throwable -> L52
        long r21 = r1.getLong(r4);     // Catch: Throwable -> L52
        int r23 = r1.getInt(r6);     // Catch: Throwable -> L52
        if (r1.isNull(r7) == false) goto L26;
        String r24 = null;
    L28:
        if (r1.isNull(r8) == false) goto L30;
        String r25 = null;
    L31:
        int r26 = r1.getInt(r9);     // Catch: Throwable -> L52
        if (r1.isNull(r10) == false) goto L34;
        String r27 = null;
    L35:
        int r28 = r1.getInt(r11);     // Catch: Throwable -> L52
        int r29 = r1.getInt(r12);     // Catch: Throwable -> L52
        if (r1.isNull(r13) == false) goto L38;
        String r30 = null;
    L40:
        if (r1.isNull(r14) == false) goto L42;
        String r31 = null;
    L43:
        int r32 = r1.getInt(r15);     // Catch: Throwable -> L52
        int r20 = r311;
        if (r1.isNull(r20) == false) goto L47;
        String r33 = null;
    L46:
        int r36 = r0;
        int r22 = r310;
        r17.add(new fs(r18, r19, r21, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r1.getLong(r22)));     // Catch: Throwable -> L52
        r0 = r36;
        r310 = r22;
        r311 = r20;
        goto L21
    L47:
        r33 = r1.getString(r20);     // Catch: Throwable -> L52
        goto L46
    L42:
        r31 = r1.getString(r14);     // Catch: Throwable -> L52
        goto L43
    L38:
        r30 = r1.getString(r13);     // Catch: Throwable -> L52
        goto L40
    L34:
        r27 = r1.getString(r10);     // Catch: Throwable -> L52
        goto L35
    L30:
        r25 = r1.getString(r8);     // Catch: Throwable -> L52
        goto L31
    L26:
        r24 = r1.getString(r7);     // Catch: Throwable -> L52
        goto L28
    L50:
        r1.close();
        r16.release();
        return r17;
    L52:
        th = th;
    L56:
        r1.close();
        r16.release();
        throw th;
    L54:
        th = th;
        r16 = r5;
        goto L56
    L16:
        r5.bindString(5, r42);
        goto L17
    L13:
        r5.bindString(4, r41);
        goto L14
    L9:
        r5.bindString(2, r39);
        goto L10
    L5:
        r5.bindString(1, r38);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.RawChatAppChatDao
    public List<fs> queryChatMsgWithAccurateTime(long r38, String r40, String r41, int r42, String r43, String r44) {
        RoomSQLiteQuery r7 = RoomSQLiteQuery.acquire("SELECT * FROM RawWxChat WHERE ( sequenceTime BETWEEN ?-5 * 60 * 1000 AND ?+1000) AND chatName = ? AND msgPerson = ? AND msgType = ? AND msgContent = ? AND packageName = ? ORDER BY sequenceTime ASC", 7);
        r7.bindLong(1, r38);
        r7.bindLong(2, r38);
        if (r40 != null) goto L5;
        r7.bindNull(3);
    L7:
        if (r41 != null) goto L9;
        r7.bindNull(4);
    L10:
        r7.bindLong(5, r42);
        if (r43 != null) goto L13;
        r7.bindNull(6);
    L14:
        if (r44 != null) goto L16;
        r7.bindNull(7);
    L17:
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r7, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, "dataVersion");     // Catch: Throwable -> L54
        int r3 = CursorUtil.getColumnIndexOrThrow(r1, "timestamp");     // Catch: Throwable -> L54
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "sequenceTime");     // Catch: Throwable -> L54
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "chatType");     // Catch: Throwable -> L54
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "chatName");     // Catch: Throwable -> L54
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "msgPerson");     // Catch: Throwable -> L54
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "msgType");     // Catch: Throwable -> L54
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "msgContent");     // Catch: Throwable -> L54
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "timeAccuracy");     // Catch: Throwable -> L54
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "chatPeopleNum");     // Catch: Throwable -> L54
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, "refName");     // Catch: Throwable -> L54
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "refContent");     // Catch: Throwable -> L54
        int r15 = CursorUtil.getColumnIndexOrThrow(r1, "uploadState");     // Catch: Throwable -> L54
        int r2 = CursorUtil.getColumnIndexOrThrow(r1, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L54
        RoomSQLiteQuery r16 = r7;
        int r39 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L52
        int r310 = r2;
        ArrayList r17 = new ArrayList(r1.getCount());     // Catch: Throwable -> L52
    L21:
        if (r1.moveToNext() == false) goto L50;
        int r18 = r1.getInt(r0);     // Catch: Throwable -> L52
        long r19 = r1.getLong(r3);     // Catch: Throwable -> L52
        long r21 = r1.getLong(r4);     // Catch: Throwable -> L52
        int r23 = r1.getInt(r5);     // Catch: Throwable -> L52
        if (r1.isNull(r6) == false) goto L26;
        String r24 = null;
    L28:
        if (r1.isNull(r8) == false) goto L30;
        String r25 = null;
    L31:
        int r26 = r1.getInt(r9);     // Catch: Throwable -> L52
        if (r1.isNull(r10) == false) goto L34;
        String r27 = null;
    L35:
        int r28 = r1.getInt(r11);     // Catch: Throwable -> L52
        int r29 = r1.getInt(r12);     // Catch: Throwable -> L52
        if (r1.isNull(r13) == false) goto L38;
        String r30 = null;
    L40:
        if (r1.isNull(r14) == false) goto L42;
        String r31 = null;
    L43:
        int r32 = r1.getInt(r15);     // Catch: Throwable -> L52
        int r20 = r310;
        if (r1.isNull(r20) == false) goto L47;
        String r33 = null;
    L46:
        int r36 = r0;
        int r22 = r39;
        r17.add(new fs(r18, r19, r21, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r1.getLong(r22)));     // Catch: Throwable -> L52
        r0 = r36;
        r39 = r22;
        r310 = r20;
        goto L21
    L47:
        r33 = r1.getString(r20);     // Catch: Throwable -> L52
        goto L46
    L42:
        r31 = r1.getString(r14);     // Catch: Throwable -> L52
        goto L43
    L38:
        r30 = r1.getString(r13);     // Catch: Throwable -> L52
        goto L40
    L34:
        r27 = r1.getString(r10);     // Catch: Throwable -> L52
        goto L35
    L30:
        r25 = r1.getString(r8);     // Catch: Throwable -> L52
        goto L31
    L26:
        r24 = r1.getString(r6);     // Catch: Throwable -> L52
        goto L28
    L50:
        r1.close();
        r16.release();
        return r17;
    L52:
        th = th;
    L56:
        r1.close();
        r16.release();
        throw th;
    L54:
        th = th;
        r16 = r7;
        goto L56
    L16:
        r7.bindString(7, r44);
        goto L17
    L13:
        r7.bindString(6, r43);
        goto L14
    L9:
        r7.bindString(4, r41);
        goto L10
    L5:
        r7.bindString(3, r40);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.RawChatAppChatDao
    public List<String> queryNeedUploadChatNames(String r5) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT DISTINCT chatName FROM RawWxChat WHERE uploadState == 0 AND packageName = ?", 1);
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r2 = new ArrayList(r4.getCount());     // Catch: Throwable -> L18
    L8:
        if (r4.moveToNext() == false) goto L16;
        if (r4.isNull(0) == false) goto L13;
        String r3 = null;
    L14:
        r2.add(r3);     // Catch: Throwable -> L18
        goto L8
    L13:
        r3 = r4.getString(0);     // Catch: Throwable -> L18
        goto L14
    L16:
        r4.close();
        r0.release();
        return r2;
    L18:
        th = move-exception;
        r4.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, r5);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.RawChatAppChatDao
    public List<fs> queryNeedUploadWithChatName(String r39) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM RawWxChat WHERE uploadState == 0 AND chatName = ? ORDER BY sequenceTime ASC, id ASC", 1);
        if (r39 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, "dataVersion");     // Catch: Throwable -> L43
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "timestamp");     // Catch: Throwable -> L43
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "sequenceTime");     // Catch: Throwable -> L43
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "chatType");     // Catch: Throwable -> L43
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "chatName");     // Catch: Throwable -> L43
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "msgPerson");     // Catch: Throwable -> L43
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "msgType");     // Catch: Throwable -> L43
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "msgContent");     // Catch: Throwable -> L43
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "timeAccuracy");     // Catch: Throwable -> L43
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "chatPeopleNum");     // Catch: Throwable -> L43
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, "refName");     // Catch: Throwable -> L43
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "refContent");     // Catch: Throwable -> L43
        int r15 = CursorUtil.getColumnIndexOrThrow(r1, "uploadState");     // Catch: Throwable -> L43
        int r3 = CursorUtil.getColumnIndexOrThrow(r1, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L43
        RoomSQLiteQuery r16 = r2;
        int r310 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L41
        int r17 = r3;
        ArrayList r18 = new ArrayList(r1.getCount());     // Catch: Throwable -> L41
    L10:
        if (r1.moveToNext() == false) goto L39;
        int r19 = r1.getInt(r0);     // Catch: Throwable -> L41
        long r20 = r1.getLong(r4);     // Catch: Throwable -> L41
        long r22 = r1.getLong(r5);     // Catch: Throwable -> L41
        int r24 = r1.getInt(r6);     // Catch: Throwable -> L41
        if (r1.isNull(r7) == false) goto L15;
        String r25 = null;
    L17:
        if (r1.isNull(r8) == false) goto L19;
        String r26 = null;
    L20:
        int r27 = r1.getInt(r9);     // Catch: Throwable -> L41
        if (r1.isNull(r10) == false) goto L23;
        String r28 = null;
    L24:
        int r29 = r1.getInt(r11);     // Catch: Throwable -> L41
        int r30 = r1.getInt(r12);     // Catch: Throwable -> L41
        if (r1.isNull(r13) == false) goto L27;
        String r31 = null;
    L29:
        if (r1.isNull(r14) == false) goto L31;
        String r32 = null;
    L32:
        int r33 = r1.getInt(r15);     // Catch: Throwable -> L41
        int r21 = r17;
        if (r1.isNull(r21) == false) goto L36;
        String r34 = null;
    L35:
        int r37 = r0;
        int r23 = r310;
        r18.add(new fs(r19, r20, r22, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r1.getLong(r23)));     // Catch: Throwable -> L41
        r0 = r37;
        r310 = r23;
        r17 = r21;
        goto L10
    L36:
        r34 = r1.getString(r21);     // Catch: Throwable -> L41
        goto L35
    L31:
        r32 = r1.getString(r14);     // Catch: Throwable -> L41
        goto L32
    L27:
        r31 = r1.getString(r13);     // Catch: Throwable -> L41
        goto L29
    L23:
        r28 = r1.getString(r10);     // Catch: Throwable -> L41
        goto L24
    L19:
        r26 = r1.getString(r8);     // Catch: Throwable -> L41
        goto L20
    L15:
        r25 = r1.getString(r7);     // Catch: Throwable -> L41
        goto L17
    L39:
        r1.close();
        r16.release();
        return r18;
    L41:
        th = th;
    L45:
        r1.close();
        r16.release();
        throw th;
    L43:
        th = th;
        r16 = r2;
        goto L45
    L5:
        r2.bindString(1, r39);
        goto L6
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public fs queryOne() {
        return RawChatAppChatDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ fs queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<fs> queryWithLimitAndOffset(int r1, int r2) {
        return RawChatAppChatDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<fs> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityRawChatEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(fs r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfRawChatEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(fs r3) {
        return update2((fs) ZeusTransformUtils.preCheckCast(r3, fs.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<fs> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfRawChatEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.RawChatAppChatDao
    public void updateAsUploaded(long r3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfUpdateAsUploaded.acquire();
        r0.bindLong(1, r3);
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateAsUploaded.release(r0);
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateAsUploaded.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.RawChatAppChatDao
    public void updateAsUploaded(List<Long> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("UPDATE RawWxChat SET uploadState = 1 WHERE id IN (");
        StringUtil.appendPlaceholders(r0, r8.size());
        r0.append(")");
        SupportSQLiteStatement r1 = this.__db.compileStatement(r0.toString());
        Iterator r9 = r8.iterator();
        int r3 = 1;
    L4:
        if (r9.hasNext() == false) goto L6;
        r1.bindLong(r3, ((Long) ZeusTransformUtils.preCheckCast(r9.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
        r3 = r3 + 1;
        goto L4
    L6:
        this.__db.beginTransaction();
        r1.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        return;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
