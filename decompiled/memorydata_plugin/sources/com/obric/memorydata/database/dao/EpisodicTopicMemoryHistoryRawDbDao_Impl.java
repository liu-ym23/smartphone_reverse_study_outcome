package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.bp;
import com.obric.memorydata.database.entity.bq;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class EpisodicTopicMemoryHistoryRawDbDao_Impl implements EpisodicTopicMemoryHistoryRawDbDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<bq> __deletionAdapterOfEpisodicTopicMemoryHistoryEntity;
    private final EntityInsertionAdapter<bq> __insertionAdapterOfEpisodicTopicMemoryHistoryEntity;
    private final EntityDeletionOrUpdateAdapter<bq> __updateAdapterOfEpisodicTopicMemoryHistoryEntity;

    public EpisodicTopicMemoryHistoryRawDbDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfEpisodicTopicMemoryHistoryEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfEpisodicTopicMemoryHistoryEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfEpisodicTopicMemoryHistoryEntity = new AnonymousClass3(this, r2);
    }

    private bq __entityCursorConverter_comObricMemorydataDatabaseEntityEpisodicTopicMemoryHistoryEntity(Cursor r40) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r40, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "episodic_topic_memory_id");
        int r3 = CursorUtil.getColumnIndex(r0, "episodic_topic_memory_summary");
        int r4 = CursorUtil.getColumnIndex(r0, "episodic_topic_memory_relateIds");
        int r5 = CursorUtil.getColumnIndex(r0, "episodic_topic_memory_logId");
        int r6 = CursorUtil.getColumnIndex(r0, "episodic_topic_memory_entityId");
        int r7 = CursorUtil.getColumnIndex(r0, "episodic_topic_memory_createTime");
        int r8 = CursorUtil.getColumnIndex(r0, "episodic_topic_memory_modifyTime");
        int r9 = CursorUtil.getColumnIndex(r0, "episodic_topic_memory_type");
        int r10 = CursorUtil.getColumnIndex(r0, "episodic_topic_memory_timestamp");
        int r11 = CursorUtil.getColumnIndex(r0, "episodic_topic_memory_packageName");
        int r12 = CursorUtil.getColumnIndex(r0, "episodic_topic_memory_hashCodeValue");
        int r13 = CursorUtil.getColumnIndex(r0, "episodic_topic_memory_uuid");
        int r14 = CursorUtil.getColumnIndex(r0, "episodic_topic_memory_poison_label");
        int r15 = CursorUtil.getColumnIndex(r0, "episodic_topic_memory_poison_label_version");
        int r16 = CursorUtil.getColumnIndex(r0, "episodic_topic_memory_content_hash");
        long r17 = 0;
        if (r1 != (-1)) goto L5;
        long r20 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        long r23 = 0;
    L9:
        String r18 = null;
        if (r3 != (-1)) goto L13;
    L11:
        String r25 = null;
    L16:
        if (r4 != (-1)) goto L19;
    L17:
        String r26 = null;
    L22:
        if (r5 != (-1)) goto L25;
    L23:
        String r27 = null;
    L28:
        if (r6 != (-1)) goto L31;
    L29:
        String r28 = null;
    L34:
        if (r7 != (-1)) goto L36;
        long r29 = 0;
    L37:
        if (r8 != (-1)) goto L39;
        long r31 = 0;
    L40:
        int r19 = 0;
        if (r9 != (-1)) goto L43;
        int r33 = 0;
    L44:
        if (r10 == (-1)) goto L47;
        r17 = r0.getLong(r10);
    L47:
        long r34 = r17;
        if (r11 != (-1)) goto L51;
    L49:
        String r36 = null;
    L54:
        if (r12 == (-1)) goto L57;
        r19 = r0.getInt(r12);
    L57:
        int r37 = r19;
        if (r13 != (-1)) goto L61;
    L59:
        String r38 = null;
    L64:
        bp r21 = new bp(r23, r25, r26, r27, r28, r29, r31, r33, r34, r36, r37, r38);
        if (r14 == (-1)) goto L72;
        if (r0.isNull(r14) == false) goto L69;
        Integer r22 = null;
    L70:
        r21.setPoisonLabel(r22);
        goto L72
    L69:
        r22 = Integer.valueOf(r0.getInt(r14));
    L72:
        if (r15 == (-1)) goto L79;
        if (r0.isNull(r15) == false) goto L76;
        Integer r24 = null;
    L77:
        r21.setPoisonLabelVersion(r24);
        goto L79
    L76:
        r24 = Integer.valueOf(r0.getInt(r15));
    L79:
        if (r16 == (-1)) goto L86;
        if (r0.isNull(r16) == true) goto L84;
        r18 = r0.getString(r16);
    L84:
        r21.setContentHash(r18);
    L86:
        return new bq(r20, r21);
    L61:
        if (r0.isNull(r13) == true) goto L59;
        r38 = r0.getString(r13);
        goto L64
    L51:
        if (r0.isNull(r11) == true) goto L49;
        r36 = r0.getString(r11);
        goto L54
    L43:
        r33 = r0.getInt(r9);
        goto L44
    L39:
        r31 = r0.getLong(r8);
        goto L40
    L36:
        r29 = r0.getLong(r7);
        goto L37
    L31:
        if (r0.isNull(r6) == true) goto L29;
        r28 = r0.getString(r6);
        goto L34
    L25:
        if (r0.isNull(r5) == true) goto L23;
        r27 = r0.getString(r5);
        goto L28
    L19:
        if (r0.isNull(r4) == true) goto L17;
        r26 = r0.getString(r4);
        goto L22
    L13:
        if (r0.isNull(r3) == true) goto L11;
        r25 = r0.getString(r3);
        goto L16
    L8:
        r23 = r0.getLong(r2);
        goto L9
    L5:
        r20 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<bq> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfEpisodicTopicMemoryHistoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<bq> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfEpisodicTopicMemoryHistoryEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    public int delete(bq r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfEpisodicTopicMemoryHistoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((bq) ZeusTransformUtils.preCheckCast(r3, bq.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return EpisodicTopicMemoryHistoryRawDbDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityId(String r1, String r2) {
        return EpisodicTopicMemoryHistoryRawDbDao.DefaultImpls.deleteByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityIdList(List<String> r3, String r4) {
        return EpisodicTopicMemoryHistoryRawDbDao.DefaultImpls.deleteByEntityIdList(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityIdListAndPackageName(List<String> r3, String r4) {
        return EpisodicTopicMemoryHistoryRawDbDao.DefaultImpls.deleteByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteById(long r1) {
        return EpisodicTopicMemoryHistoryRawDbDao.DefaultImpls.deleteById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.EpisodicTopicMemoryHistoryRawDbDao, com.obric.memorydata.database.dao.IHistoryEntityDao
    public String getPrefix() {
        return EpisodicTopicMemoryHistoryRawDbDao.DefaultImpls.getPrefix(this);
    }

    @Override // com.obric.memorydata.database.dao.EpisodicTopicMemoryHistoryRawDbDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return EpisodicTopicMemoryHistoryRawDbDao.DefaultImpls.getTableName(this);
    }

    public long insert(bq r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfEpisodicTopicMemoryHistoryEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((bq) ZeusTransformUtils.preCheckCast(r3, bq.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<bq> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfEpisodicTopicMemoryHistoryEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<bq> queryAll() {
        return EpisodicTopicMemoryHistoryRawDbDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return EpisodicTopicMemoryHistoryRawDbDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public List<bq> queryByEntityId(String r1, String r2) {
        return EpisodicTopicMemoryHistoryRawDbDao.DefaultImpls.queryByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public List<bq> queryByEntityIdListAndPackageName(List<String> r3, String r4) {
        return EpisodicTopicMemoryHistoryRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public bq queryById(long r1) {
        return EpisodicTopicMemoryHistoryRawDbDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<bq> queryByIds(List<Long> r3) {
        return EpisodicTopicMemoryHistoryRawDbDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public bq queryByUUID(String r1) {
        return EpisodicTopicMemoryHistoryRawDbDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public bq queryOne() {
        return EpisodicTopicMemoryHistoryRawDbDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<bq> queryWithLimitAndOffset(int r1, int r2) {
        return EpisodicTopicMemoryHistoryRawDbDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<bq> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityEpisodicTopicMemoryHistoryEntity(r6));     // Catch: Throwable -> L10
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

    public int update(bq r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfEpisodicTopicMemoryHistoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((bq) ZeusTransformUtils.preCheckCast(r3, bq.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<bq> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfEpisodicTopicMemoryHistoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
