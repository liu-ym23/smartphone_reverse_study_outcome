package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.AutoMemoryProEntity;
import com.obric.memorydata.database.entity.w;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class AutoMemoryProHistoryRawDbDao_Impl implements AutoMemoryProHistoryRawDbDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<w> __deletionAdapterOfAutoMemoryProHistoryEntity;
    private final EntityInsertionAdapter<w> __insertionAdapterOfAutoMemoryProHistoryEntity;
    private final EntityDeletionOrUpdateAdapter<w> __updateAdapterOfAutoMemoryProHistoryEntity;

    public AutoMemoryProHistoryRawDbDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfAutoMemoryProHistoryEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfAutoMemoryProHistoryEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfAutoMemoryProHistoryEntity = new AnonymousClass3(this, r2);
    }

    private w __entityCursorConverter_comObricMemorydataDatabaseEntityAutoMemoryProHistoryEntity(Cursor r59) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r59, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_id");
        int r3 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_entityId");
        int r4 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_createTime");
        int r5 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_modifyTime");
        int r6 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_type");
        int r7 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_packageName");
        int r8 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_hashCodeValue");
        int r9 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_uuid");
        int r10 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_rule_id");
        int r11 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_timestamp");
        int r12 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_title");
        int r13 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_content");
        int r14 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_subtitle");
        int r15 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_reason");
        int r16 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_log_id");
        int r17 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_trace_id");
        int r18 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_package_names");
        int r19 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_episodic_ids");
        int r110 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_semantic_ids");
        int r111 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_raw_observation_ids");
        int r112 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_fullContent");
        int r113 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_poison_label");
        int r114 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_poison_label_version");
        int r115 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_content_hash");
        long r24 = 0;
        if (r1 != (-1)) goto L5;
        long r29 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        long r32 = 0;
    L9:
        String r20 = null;
        if (r3 != (-1)) goto L13;
    L11:
        String r34 = null;
    L16:
        if (r4 != (-1)) goto L18;
        long r35 = 0;
    L19:
        if (r5 != (-1)) goto L21;
        long r37 = 0;
    L22:
        int r21 = 0;
        if (r6 != (-1)) goto L25;
        int r39 = 0;
    L26:
        if (r7 != (-1)) goto L29;
    L27:
        String r40 = null;
    L32:
        if (r8 != (-1)) goto L34;
        int r41 = 0;
    L35:
        if (r9 != (-1)) goto L38;
    L36:
        String r42 = null;
    L41:
        if (r10 != (-1)) goto L43;
        long r43 = 0;
    L44:
        if (r11 == (-1)) goto L47;
        r24 = r0.getLong(r11);
    L47:
        long r45 = r24;
        if (r12 != (-1)) goto L51;
    L49:
        String r47 = null;
    L54:
        if (r13 != (-1)) goto L57;
    L55:
        String r48 = null;
    L60:
        if (r14 != (-1)) goto L63;
    L61:
        String r49 = null;
    L66:
        if (r58 != (-1)) goto L69;
    L67:
        String r50 = null;
    L72:
        if (r59 != (-1)) goto L76;
    L73:
        String r51 = null;
    L79:
        if (r17 == (-1)) goto L82;
        r21 = r0.getInt(r17);
    L82:
        int r52 = r21;
        if (r18 != (-1)) goto L87;
    L84:
        String r53 = null;
    L90:
        if (r19 != (-1)) goto L94;
    L91:
        String r54 = null;
    L97:
        if (r110 != (-1)) goto L101;
    L98:
        String r55 = null;
    L104:
        if (r111 != (-1)) goto L108;
    L105:
        String r56 = null;
    L111:
        if (r112 != (-1)) goto L114;
    L112:
        String r57 = null;
    L117:
        AutoMemoryProEntity r22 = new AutoMemoryProEntity(r32, r34, r35, r37, r39, r40, r41, r42, r43, r45, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57);
        if (r113 == (-1)) goto L125;
        if (r0.isNull(r113) == false) goto L122;
        Integer r23 = null;
    L123:
        r22.setPoisonLabel(r23);
        goto L125
    L122:
        r23 = Integer.valueOf(r0.getInt(r113));
    L125:
        if (r114 == (-1)) goto L132;
        if (r0.isNull(r114) == false) goto L129;
        Integer r25 = null;
    L130:
        r22.setPoisonLabelVersion(r25);
        goto L132
    L129:
        r25 = Integer.valueOf(r0.getInt(r114));
    L132:
        if (r115 == (-1)) goto L139;
        if (r0.isNull(r115) == true) goto L137;
        r20 = r0.getString(r115);
    L137:
        r22.setContentHash(r20);
    L139:
        return new w(r29, r22);
    L114:
        if (r0.isNull(r112) == true) goto L112;
        r57 = r0.getString(r112);
        goto L117
    L108:
        if (r0.isNull(r111) == true) goto L105;
        r56 = r0.getString(r111);
        goto L111
    L101:
        if (r0.isNull(r110) == true) goto L98;
        r55 = r0.getString(r110);
        goto L104
    L94:
        if (r0.isNull(r19) == true) goto L91;
        r54 = r0.getString(r19);
        goto L97
    L87:
        if (r0.isNull(r18) == true) goto L84;
        r53 = r0.getString(r18);
        goto L90
    L76:
        if (r0.isNull(r59) == true) goto L73;
        r51 = r0.getString(r16);
        goto L79
    L69:
        if (r0.isNull(r58) == true) goto L67;
        r50 = r0.getString(r15);
        goto L72
    L63:
        if (r0.isNull(r14) == true) goto L61;
        r49 = r0.getString(r14);
        goto L66
    L57:
        if (r0.isNull(r13) == true) goto L55;
        r48 = r0.getString(r13);
        goto L60
    L51:
        if (r0.isNull(r12) == true) goto L49;
        r47 = r0.getString(r12);
        goto L54
    L43:
        r43 = r0.getLong(r10);
        goto L44
    L38:
        if (r0.isNull(r9) == true) goto L36;
        r42 = r0.getString(r9);
        goto L41
    L34:
        r41 = r0.getInt(r8);
        goto L35
    L29:
        if (r0.isNull(r7) == true) goto L27;
        r40 = r0.getString(r7);
        goto L32
    L25:
        r39 = r0.getInt(r6);
        goto L26
    L21:
        r37 = r0.getLong(r5);
        goto L22
    L18:
        r35 = r0.getLong(r4);
        goto L19
    L13:
        if (r0.isNull(r3) == true) goto L11;
        r34 = r0.getString(r3);
        goto L16
    L8:
        r32 = r0.getLong(r2);
        goto L9
    L5:
        r29 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<w> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfAutoMemoryProHistoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<w> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfAutoMemoryProHistoryEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    public int delete(w r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfAutoMemoryProHistoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((w) ZeusTransformUtils.preCheckCast(r3, w.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return AutoMemoryProHistoryRawDbDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityId(String r1, String r2) {
        return AutoMemoryProHistoryRawDbDao.DefaultImpls.deleteByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityIdList(List<String> r3, String r4) {
        return AutoMemoryProHistoryRawDbDao.DefaultImpls.deleteByEntityIdList(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityIdListAndPackageName(List<String> r3, String r4) {
        return AutoMemoryProHistoryRawDbDao.DefaultImpls.deleteByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteById(long r1) {
        return AutoMemoryProHistoryRawDbDao.DefaultImpls.deleteById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProHistoryRawDbDao, com.obric.memorydata.database.dao.IHistoryEntityDao
    public String getPrefix() {
        return AutoMemoryProHistoryRawDbDao.DefaultImpls.getPrefix(this);
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProHistoryRawDbDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return AutoMemoryProHistoryRawDbDao.DefaultImpls.getTableName(this);
    }

    public long insert(w r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfAutoMemoryProHistoryEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((w) ZeusTransformUtils.preCheckCast(r3, w.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<w> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfAutoMemoryProHistoryEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<w> queryAll() {
        return AutoMemoryProHistoryRawDbDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return AutoMemoryProHistoryRawDbDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public List<w> queryByEntityId(String r1, String r2) {
        return AutoMemoryProHistoryRawDbDao.DefaultImpls.queryByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public List<w> queryByEntityIdListAndPackageName(List<String> r3, String r4) {
        return AutoMemoryProHistoryRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public w queryById(long r1) {
        return AutoMemoryProHistoryRawDbDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<w> queryByIds(List<Long> r3) {
        return AutoMemoryProHistoryRawDbDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public w queryByUUID(String r1) {
        return AutoMemoryProHistoryRawDbDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public w queryOne() {
        return AutoMemoryProHistoryRawDbDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<w> queryWithLimitAndOffset(int r1, int r2) {
        return AutoMemoryProHistoryRawDbDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<w> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityAutoMemoryProHistoryEntity(r6));     // Catch: Throwable -> L10
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

    public int update(w r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfAutoMemoryProHistoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((w) ZeusTransformUtils.preCheckCast(r3, w.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<w> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfAutoMemoryProHistoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
