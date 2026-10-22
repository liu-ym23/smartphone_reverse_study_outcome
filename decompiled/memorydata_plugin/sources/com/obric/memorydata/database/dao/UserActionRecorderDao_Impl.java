package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.entity.jb;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class UserActionRecorderDao_Impl implements UserActionRecorderDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<jb> __deletionAdapterOfUserActionEntity;
    private final EntityInsertionAdapter<jb> __insertionAdapterOfUserActionEntity;
    private final SharedSQLiteStatement __preparedStmtOfUpdateOcrContentByUniqueId;
    private final EntityDeletionOrUpdateAdapter<jb> __updateAdapterOfUserActionEntity;

    public UserActionRecorderDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfUserActionEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfUserActionEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfUserActionEntity = new AnonymousClass3(this, r2);
        this.__preparedStmtOfUpdateOcrContentByUniqueId = new AnonymousClass4(this, r2);
    }

    private jb __entityCursorConverter_comObricMemorydataDatabaseEntityUserActionEntity(Cursor r52) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r52, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, "dataId");
        int r2 = CursorUtil.getColumnIndex(r0, "dataVersion");
        int r3 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r4 = CursorUtil.getColumnIndex(r0, "imageId");
        int r5 = CursorUtil.getColumnIndex(r0, "appName");
        int r6 = CursorUtil.getColumnIndex(r0, ObricMemoryConstants.KEY_PACKAGE_NAME);
        int r7 = CursorUtil.getColumnIndex(r0, "activityName");
        int r8 = CursorUtil.getColumnIndex(r0, "viewTreeJsonString");
        int r9 = CursorUtil.getColumnIndex(r0, InfoRequestQPSOptTraceLogger.REASON);
        int r10 = CursorUtil.getColumnIndex(r0, "eventType");
        int r11 = CursorUtil.getColumnIndex(r0, "eventName");
        int r12 = CursorUtil.getColumnIndex(r0, "className");
        int r13 = CursorUtil.getColumnIndex(r0, "viewTreeTextInfo");
        int r14 = CursorUtil.getColumnIndex(r0, WsConstants.KEY_EXTRA);
        int r15 = CursorUtil.getColumnIndex(r0, "uniqueId");
        int r16 = CursorUtil.getColumnIndex(r0, "operateNodeInfo");
        int r17 = CursorUtil.getColumnIndex(r0, "description");
        int r18 = CursorUtil.getColumnIndex(r0, "imageUrl");
        int r19 = CursorUtil.getColumnIndex(r0, "mergeStatus");
        int r110 = CursorUtil.getColumnIndex(r0, "ocrContent");
        int r111 = CursorUtil.getColumnIndex(r0, "urlType");
        int r112 = CursorUtil.getColumnIndex(r0, "memoryState");
        int r113 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r22 = 0;
        if (r1 != (-1)) goto L5;
        int r25 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        int r26 = 0;
    L10:
        if (r3 != (-1)) goto L12;
        long r27 = 0;
    L13:
        if (r4 != (-1)) goto L15;
        long r29 = 0;
    L16:
        String r20 = null;
        if (r5 != (-1)) goto L20;
    L18:
        String r31 = null;
    L23:
        if (r6 != (-1)) goto L26;
    L24:
        String r32 = null;
    L29:
        if (r7 != (-1)) goto L32;
    L30:
        String r33 = null;
    L35:
        if (r8 != (-1)) goto L38;
    L36:
        String r34 = null;
    L41:
        if (r9 != (-1)) goto L44;
    L42:
        String r35 = null;
    L47:
        if (r10 != (-1)) goto L49;
        int r36 = 0;
    L50:
        if (r11 != (-1)) goto L53;
    L51:
        String r37 = null;
    L56:
        if (r12 != (-1)) goto L59;
    L57:
        String r38 = null;
    L62:
        if (r13 != (-1)) goto L65;
    L63:
        String r39 = null;
    L68:
        if (r14 != (-1)) goto L71;
    L69:
        String r40 = null;
    L74:
        if (r51 != (-1)) goto L77;
    L75:
        String r41 = null;
    L80:
        if (r52 != (-1)) goto L84;
    L81:
        String r42 = null;
    L87:
        if (r17 != (-1)) goto L91;
    L88:
        String r43 = null;
    L94:
        if (r18 != (-1)) goto L98;
    L95:
        String r44 = null;
    L101:
        if (r19 != (-1)) goto L103;
        int r45 = 0;
    L104:
        if (r19 != (-1)) goto L107;
    L105:
        String r46 = r20;
        if (r111 != (-1)) goto L112;
        int r47 = 0;
    L113:
        if (r21 == (-1)) goto L116;
        r22 = r0.getInt(r112);
    L116:
        int r48 = r22;
        if (r113 != (-1)) goto L119;
        long r49 = 0;
    L121:
        return new jb(r25, r26, r27, r29, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49);
    L119:
        r49 = r0.getLong(r113);
        goto L121
    L112:
        r47 = r0.getInt(r111);
        goto L113
    L107:
        if (r0.isNull(r19) == true) goto L105;
        r20 = r0.getString(r110);
        goto L105
    L103:
        r45 = r0.getInt(r19);
        goto L104
    L98:
        if (r0.isNull(r18) == true) goto L95;
        r44 = r0.getString(r18);
        goto L101
    L91:
        if (r0.isNull(r17) == true) goto L88;
        r43 = r0.getString(r17);
        goto L94
    L84:
        if (r0.isNull(r52) == true) goto L81;
        r42 = r0.getString(r16);
        goto L87
    L77:
        if (r0.isNull(r51) == true) goto L75;
        r41 = r0.getString(r15);
        goto L80
    L71:
        if (r0.isNull(r14) == true) goto L69;
        r40 = r0.getString(r14);
        goto L74
    L65:
        if (r0.isNull(r13) == true) goto L63;
        r39 = r0.getString(r13);
        goto L68
    L59:
        if (r0.isNull(r12) == true) goto L57;
        r38 = r0.getString(r12);
        goto L62
    L53:
        if (r0.isNull(r11) == true) goto L51;
        r37 = r0.getString(r11);
        goto L56
    L49:
        r36 = r0.getInt(r10);
        goto L50
    L44:
        if (r0.isNull(r9) == true) goto L42;
        r35 = r0.getString(r9);
        goto L47
    L38:
        if (r0.isNull(r8) == true) goto L36;
        r34 = r0.getString(r8);
        goto L41
    L32:
        if (r0.isNull(r7) == true) goto L30;
        r33 = r0.getString(r7);
        goto L35
    L26:
        if (r0.isNull(r6) == true) goto L24;
        r32 = r0.getString(r6);
        goto L29
    L20:
        if (r0.isNull(r5) == true) goto L18;
        r31 = r0.getString(r5);
        goto L23
    L15:
        r29 = r0.getLong(r4);
        goto L16
    L12:
        r27 = r0.getLong(r3);
        goto L13
    L8:
        r26 = r0.getInt(r2);
        goto L10
    L5:
        r25 = r0.getInt(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<jb> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfUserActionEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<jb> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfUserActionEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(jb r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfUserActionEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(jb r3) {
        return delete2((jb) ZeusTransformUtils.preCheckCast(r3, jb.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return UserActionRecorderDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.UserActionRecorderDao
    public jb findByUniqueId(String r53) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM UseActionRecorder WHERE uniqueId = ? LIMIT 1", 1);
        if (r53 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, "dataId");     // Catch: Throwable -> L74
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "dataVersion");     // Catch: Throwable -> L74
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "timestamp");     // Catch: Throwable -> L74
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "imageId");     // Catch: Throwable -> L74
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "appName");     // Catch: Throwable -> L74
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L74
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "activityName");     // Catch: Throwable -> L74
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "viewTreeJsonString");     // Catch: Throwable -> L74
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, InfoRequestQPSOptTraceLogger.REASON);     // Catch: Throwable -> L74
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "eventType");     // Catch: Throwable -> L74
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, "eventName");     // Catch: Throwable -> L74
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "className");     // Catch: Throwable -> L74
        int r15 = CursorUtil.getColumnIndexOrThrow(r1, "viewTreeTextInfo");     // Catch: Throwable -> L74
        int r3 = CursorUtil.getColumnIndexOrThrow(r1, WsConstants.KEY_EXTRA);     // Catch: Throwable -> L74
        RoomSQLiteQuery r16 = r2;
        int r17 = CursorUtil.getColumnIndexOrThrow(r1, "uniqueId");     // Catch: Throwable -> L72
        int r18 = CursorUtil.getColumnIndexOrThrow(r1, "operateNodeInfo");     // Catch: Throwable -> L72
        int r19 = CursorUtil.getColumnIndexOrThrow(r1, "description");     // Catch: Throwable -> L72
        int r20 = CursorUtil.getColumnIndexOrThrow(r1, "imageUrl");     // Catch: Throwable -> L72
        int r21 = CursorUtil.getColumnIndexOrThrow(r1, "mergeStatus");     // Catch: Throwable -> L72
        int r22 = CursorUtil.getColumnIndexOrThrow(r1, "ocrContent");     // Catch: Throwable -> L72
        int r23 = CursorUtil.getColumnIndexOrThrow(r1, "urlType");     // Catch: Throwable -> L72
        int r24 = CursorUtil.getColumnIndexOrThrow(r1, "memoryState");     // Catch: Throwable -> L72
        int r25 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L72
        if (r1.moveToFirst() == false) goto L69;
        int r26 = r1.getInt(r0);     // Catch: Throwable -> L72
        int r27 = r1.getInt(r4);     // Catch: Throwable -> L72
        long r28 = r1.getLong(r5);     // Catch: Throwable -> L72
        long r30 = r1.getLong(r6);     // Catch: Throwable -> L72
        if (r1.isNull(r7) == false) goto L14;
        String r32 = null;
    L16:
        if (r1.isNull(r8) == false) goto L18;
        String r33 = null;
    L20:
        if (r1.isNull(r9) == false) goto L22;
        String r34 = null;
    L24:
        if (r1.isNull(r10) == false) goto L26;
        String r35 = null;
    L28:
        if (r1.isNull(r11) == false) goto L30;
        String r36 = null;
    L31:
        int r37 = r1.getInt(r12);     // Catch: Throwable -> L72
        if (r1.isNull(r13) == false) goto L34;
        String r38 = null;
    L36:
        if (r1.isNull(r14) == false) goto L38;
        String r39 = null;
    L40:
        if (r1.isNull(r15) == false) goto L42;
        String r40 = null;
    L44:
        if (r1.isNull(r3) == false) goto L46;
        String r41 = null;
    L48:
        if (r1.isNull(r53) == false) goto L50;
        String r42 = null;
    L52:
        if (r1.isNull(r17) == false) goto L54;
        String r43 = null;
    L56:
        if (r1.isNull(r18) == false) goto L58;
        String r44 = null;
    L60:
        if (r1.isNull(r19) == false) goto L62;
        String r45 = null;
    L63:
        int r46 = r1.getInt(r21);     // Catch: Throwable -> L72
        if (r1.isNull(r22) == false) goto L66;
        String r47 = null;
    L67:
        jb r29 = new jb(r26, r27, r28, r30, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r1.getInt(r23), r1.getInt(r24), r1.getLong(r25));     // Catch: Throwable -> L72
    L70:
        r1.close();
        r16.release();
        return r29;
    L66:
        r47 = r1.getString(r22);     // Catch: Throwable -> L72
        goto L67
    L62:
        r45 = r1.getString(r20);     // Catch: Throwable -> L72
        goto L63
    L58:
        r44 = r1.getString(r19);     // Catch: Throwable -> L72
        goto L60
    L54:
        r43 = r1.getString(r18);     // Catch: Throwable -> L72
        goto L56
    L50:
        r42 = r1.getString(r17);     // Catch: Throwable -> L72
        goto L52
    L46:
        r41 = r1.getString(r3);     // Catch: Throwable -> L72
        goto L48
    L42:
        r40 = r1.getString(r15);     // Catch: Throwable -> L72
        goto L44
    L38:
        r39 = r1.getString(r14);     // Catch: Throwable -> L72
        goto L40
    L34:
        r38 = r1.getString(r13);     // Catch: Throwable -> L72
        goto L36
    L30:
        r36 = r1.getString(r11);     // Catch: Throwable -> L72
        goto L31
    L26:
        r35 = r1.getString(r10);     // Catch: Throwable -> L72
        goto L28
    L22:
        r34 = r1.getString(r9);     // Catch: Throwable -> L72
        goto L24
    L18:
        r33 = r1.getString(r8);     // Catch: Throwable -> L72
        goto L20
    L14:
        r32 = r1.getString(r7);     // Catch: Throwable -> L72
        goto L16
    L69:
        r29 = null;
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
        r2.bindString(1, r53);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.UserActionRecorderDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return UserActionRecorderDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(jb r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfUserActionEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(jb r3) {
        return insert2((jb) ZeusTransformUtils.preCheckCast(r3, jb.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<jb> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfUserActionEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<jb> queryAll() {
        return UserActionRecorderDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return UserActionRecorderDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public jb queryById(long r1) {
        return UserActionRecorderDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ jb queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<jb> queryByIds(List<Long> r3) {
        return UserActionRecorderDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public jb queryByUUID(String r1) {
        return UserActionRecorderDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ jb queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public jb queryOne() {
        return UserActionRecorderDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ jb queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<jb> queryWithLimitAndOffset(int r1, int r2) {
        return UserActionRecorderDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<jb> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityUserActionEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(jb r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfUserActionEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(jb r3) {
        return update2((jb) ZeusTransformUtils.preCheckCast(r3, jb.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<jb> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfUserActionEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.UserActionRecorderDao
    public void updateOcrContentByUniqueId(String r3, String r4) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfUpdateOcrContentByUniqueId.acquire();
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r3 != null) goto L9;
        r0.bindNull(2);
    L10:
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L14
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateOcrContentByUniqueId.release(r0);
        return;
    L14:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateOcrContentByUniqueId.release(r0);
        throw th;
    L9:
        r0.bindString(2, r3);
        goto L10
    L5:
        r0.bindString(1, r4);
        goto L7
    }
}
