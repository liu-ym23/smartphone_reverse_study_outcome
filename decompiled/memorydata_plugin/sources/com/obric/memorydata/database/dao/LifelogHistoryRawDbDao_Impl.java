package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.lifelog.data.Lifelog;
import com.obric.memorydata.database.entity.LifelogEntity;
import com.obric.memorydata.database.entity.ch;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class LifelogHistoryRawDbDao_Impl implements LifelogHistoryRawDbDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<ch> __deletionAdapterOfLifelogHistoryEntity;
    private final EntityInsertionAdapter<ch> __insertionAdapterOfLifelogHistoryEntity;
    private final EntityDeletionOrUpdateAdapter<ch> __updateAdapterOfLifelogHistoryEntity;

    public LifelogHistoryRawDbDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfLifelogHistoryEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfLifelogHistoryEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfLifelogHistoryEntity = new AnonymousClass3(this, r2);
    }

    private ch __entityCursorConverter_comObricMemorydataDatabaseEntityLifelogHistoryEntity(Cursor r58) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r58, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "lifelog_id");
        int r3 = CursorUtil.getColumnIndex(r0, "lifelog_entityId");
        int r4 = CursorUtil.getColumnIndex(r0, "lifelog_createTime");
        int r5 = CursorUtil.getColumnIndex(r0, "lifelog_modifyTime");
        int r6 = CursorUtil.getColumnIndex(r0, "lifelog_type");
        int r7 = CursorUtil.getColumnIndex(r0, "lifelog_entityTimestamp");
        int r8 = CursorUtil.getColumnIndex(r0, "lifelog_packageName");
        int r9 = CursorUtil.getColumnIndex(r0, "lifelog_hashCodeValue");
        int r10 = CursorUtil.getColumnIndex(r0, "lifelog_uuid");
        int r11 = CursorUtil.getColumnIndex(r0, "lifelog_fullContent");
        int r12 = CursorUtil.getColumnIndex(r0, "lifelog_poison_label");
        int r13 = CursorUtil.getColumnIndex(r0, "lifelog_poison_label_version");
        int r14 = CursorUtil.getColumnIndex(r0, "lifelog_content_hash");
        int r15 = CursorUtil.getColumnIndex(r0, "lifelog_timestamp");
        int r16 = CursorUtil.getColumnIndex(r0, "lifelog_uid");
        int r17 = CursorUtil.getColumnIndex(r0, "lifelog_title");
        int r18 = CursorUtil.getColumnIndex(r0, "lifelog_contentAM");
        int r19 = CursorUtil.getColumnIndex(r0, "lifelog_contentPM");
        int r110 = CursorUtil.getColumnIndex(r0, "lifelog_finalContent");
        int r111 = CursorUtil.getColumnIndex(r0, "lifelog_imageUrl");
        int r112 = CursorUtil.getColumnIndex(r0, "lifelog_retryTime");
        int r113 = CursorUtil.getColumnIndex(r0, "lifelog_status");
        long r22 = 0;
        if (r1 != (-1)) goto L5;
        long r27 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        long r30 = 0;
    L9:
        String r20 = null;
        if (r3 != (-1)) goto L13;
    L11:
        String r32 = null;
    L16:
        if (r4 != (-1)) goto L18;
        long r33 = 0;
    L19:
        if (r5 != (-1)) goto L21;
        long r35 = 0;
    L22:
        int r21 = 0;
        if (r6 != (-1)) goto L25;
        int r37 = 0;
    L26:
        if (r7 != (-1)) goto L28;
        long r38 = 0;
    L29:
        if (r8 != (-1)) goto L32;
    L30:
        String r40 = null;
    L35:
        if (r9 != (-1)) goto L37;
        int r41 = 0;
    L38:
        if (r10 != (-1)) goto L41;
    L39:
        String r42 = null;
    L44:
        if (r11 != (-1)) goto L47;
    L45:
        String r44 = null;
    L50:
        if (r15 != (-1)) goto L52;
        long r46 = 0;
    L53:
        if (r16 == (-1)) goto L56;
        r22 = r0.getLong(r16);
    L56:
        long r48 = r22;
        if (r17 != (-1)) goto L61;
    L58:
        String r50 = null;
    L64:
        if (r18 != (-1)) goto L68;
    L65:
        String r51 = null;
    L71:
        if (r19 != (-1)) goto L75;
    L72:
        String r52 = null;
    L78:
        if (r110 != (-1)) goto L82;
    L79:
        String r53 = null;
    L85:
        if (r111 != (-1)) goto L89;
    L86:
        String r54 = null;
    L92:
        if (r112 != (-1)) goto L94;
        int r55 = 0;
    L96:
        if (r113 == (-1)) goto L99;
        r21 = r0.getInt(r113);
    L99:
        LifelogEntity r23 = new LifelogEntity(r30, r32, r33, r35, r37, r38, r40, r41, r42, new Lifelog(r46, r48, r50, r51, r52, r53, r54, r55, r21), r44);
        if (r12 == (-1)) goto L107;
        if (r0.isNull(r12) == false) goto L104;
        Integer r24 = null;
    L105:
        r23.setPoisonLabel(r24);
        goto L107
    L104:
        r24 = Integer.valueOf(r0.getInt(r12));
    L107:
        if (r13 == (-1)) goto L114;
        if (r0.isNull(r13) == false) goto L111;
        Integer r25 = null;
    L112:
        r23.setPoisonLabelVersion(r25);
        goto L114
    L111:
        r25 = Integer.valueOf(r0.getInt(r13));
    L114:
        if (r14 == (-1)) goto L121;
        if (r0.isNull(r14) == true) goto L119;
        r20 = r0.getString(r14);
    L119:
        r23.setContentHash(r20);
    L121:
        return new ch(r27, r23);
    L94:
        r55 = r0.getInt(r112);
        goto L96
    L89:
        if (r0.isNull(r111) == true) goto L86;
        r54 = r0.getString(r111);
        goto L92
    L82:
        if (r0.isNull(r110) == true) goto L79;
        r53 = r0.getString(r110);
        goto L85
    L75:
        if (r0.isNull(r19) == true) goto L72;
        r52 = r0.getString(r19);
        goto L78
    L68:
        if (r0.isNull(r18) == true) goto L65;
        r51 = r0.getString(r18);
        goto L71
    L61:
        if (r0.isNull(r17) == true) goto L58;
        r50 = r0.getString(r17);
        goto L64
    L52:
        r46 = r0.getLong(r15);
        goto L53
    L47:
        if (r0.isNull(r11) == true) goto L45;
        r44 = r0.getString(r11);
        goto L50
    L41:
        if (r0.isNull(r10) == true) goto L39;
        r42 = r0.getString(r10);
        goto L44
    L37:
        r41 = r0.getInt(r9);
        goto L38
    L32:
        if (r0.isNull(r8) == true) goto L30;
        r40 = r0.getString(r8);
        goto L35
    L28:
        r38 = r0.getLong(r7);
        goto L29
    L25:
        r37 = r0.getInt(r6);
        goto L26
    L21:
        r35 = r0.getLong(r5);
        goto L22
    L18:
        r33 = r0.getLong(r4);
        goto L19
    L13:
        if (r0.isNull(r3) == true) goto L11;
        r32 = r0.getString(r3);
        goto L16
    L8:
        r30 = r0.getLong(r2);
        goto L9
    L5:
        r27 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<ch> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfLifelogHistoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<ch> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfLifelogHistoryEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    public int delete(ch r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfLifelogHistoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(Object r3) {
        return delete((ch) ZeusTransformUtils.preCheckCast(r3, ch.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return LifelogHistoryRawDbDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityId(String r1, String r2) {
        return LifelogHistoryRawDbDao.DefaultImpls.deleteByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityIdList(List<String> r3, String r4) {
        return LifelogHistoryRawDbDao.DefaultImpls.deleteByEntityIdList(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityIdListAndPackageName(List<String> r3, String r4) {
        return LifelogHistoryRawDbDao.DefaultImpls.deleteByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteById(long r1) {
        return LifelogHistoryRawDbDao.DefaultImpls.deleteById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.LifelogHistoryRawDbDao, com.obric.memorydata.database.dao.IHistoryEntityDao
    public String getPrefix() {
        return LifelogHistoryRawDbDao.DefaultImpls.getPrefix(this);
    }

    @Override // com.obric.memorydata.database.dao.LifelogHistoryRawDbDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return LifelogHistoryRawDbDao.DefaultImpls.getTableName(this);
    }

    public long insert(ch r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfLifelogHistoryEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(Object r3) {
        return insert((ch) ZeusTransformUtils.preCheckCast(r3, ch.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<ch> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfLifelogHistoryEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ch> queryAll() {
        return LifelogHistoryRawDbDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return LifelogHistoryRawDbDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public List<ch> queryByEntityId(String r1, String r2) {
        return LifelogHistoryRawDbDao.DefaultImpls.queryByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public List<ch> queryByEntityIdListAndPackageName(List<String> r3, String r4) {
        return LifelogHistoryRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public ch queryById(long r1) {
        return LifelogHistoryRawDbDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ch> queryByIds(List<Long> r3) {
        return LifelogHistoryRawDbDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public ch queryByUUID(String r1) {
        return LifelogHistoryRawDbDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public ch queryOne() {
        return LifelogHistoryRawDbDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ch> queryWithLimitAndOffset(int r1, int r2) {
        return LifelogHistoryRawDbDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ch> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityLifelogHistoryEntity(r6));     // Catch: Throwable -> L10
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

    public int update(ch r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfLifelogHistoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(Object r3) {
        return update((ch) ZeusTransformUtils.preCheckCast(r3, ch.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<ch> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfLifelogHistoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
