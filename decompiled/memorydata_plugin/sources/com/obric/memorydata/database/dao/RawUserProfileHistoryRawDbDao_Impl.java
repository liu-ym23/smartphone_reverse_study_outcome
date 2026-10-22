package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.hn;
import com.obric.memorydata.database.entity.hp;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class RawUserProfileHistoryRawDbDao_Impl implements RawUserProfileHistoryRawDbDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<hp> __deletionAdapterOfRawUserProfileHistoryEntity;
    private final EntityInsertionAdapter<hp> __insertionAdapterOfRawUserProfileHistoryEntity;
    private final EntityDeletionOrUpdateAdapter<hp> __updateAdapterOfRawUserProfileHistoryEntity;

    public RawUserProfileHistoryRawDbDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfRawUserProfileHistoryEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfRawUserProfileHistoryEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfRawUserProfileHistoryEntity = new AnonymousClass3(this, r2);
    }

    private hp __entityCursorConverter_comObricMemorydataDatabaseEntityRawUserProfileHistoryEntity(Cursor r42) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r42, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "user_profile_id");
        int r3 = CursorUtil.getColumnIndex(r0, "user_profile_entityId");
        int r4 = CursorUtil.getColumnIndex(r0, "user_profile_createTime");
        int r5 = CursorUtil.getColumnIndex(r0, "user_profile_modifyTime");
        int r6 = CursorUtil.getColumnIndex(r0, "user_profile_type");
        int r7 = CursorUtil.getColumnIndex(r0, "user_profile_timestamp");
        int r8 = CursorUtil.getColumnIndex(r0, "user_profile_packageName");
        int r9 = CursorUtil.getColumnIndex(r0, "user_profile_hashCodeValue");
        int r10 = CursorUtil.getColumnIndex(r0, "user_profile_uuid");
        int r11 = CursorUtil.getColumnIndex(r0, "user_profile_profileKey");
        int r12 = CursorUtil.getColumnIndex(r0, "user_profile_profileValue");
        int r13 = CursorUtil.getColumnIndex(r0, "user_profile_isFromAutoLearn");
        int r14 = CursorUtil.getColumnIndex(r0, "user_profile_fullContent");
        int r15 = CursorUtil.getColumnIndex(r0, "user_profile_poison_label");
        int r16 = CursorUtil.getColumnIndex(r0, "user_profile_poison_label_version");
        int r17 = CursorUtil.getColumnIndex(r0, "user_profile_content_hash");
        long r18 = 0;
        if (r1 != (-1)) goto L5;
        long r21 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        long r24 = 0;
    L9:
        String r19 = null;
        if (r3 != (-1)) goto L13;
    L11:
        String r26 = null;
    L16:
        if (r4 != (-1)) goto L18;
        long r27 = 0;
    L19:
        if (r5 != (-1)) goto L21;
        long r29 = 0;
    L22:
        boolean r20 = false;
        if (r6 != (-1)) goto L25;
        int r31 = 0;
    L26:
        if (r7 == (-1)) goto L29;
        r18 = r0.getLong(r7);
    L29:
        long r32 = r18;
        if (r8 != (-1)) goto L33;
    L31:
        String r34 = null;
    L36:
        if (r9 != (-1)) goto L38;
        int r35 = 0;
    L39:
        if (r10 != (-1)) goto L42;
    L40:
        String r36 = null;
    L45:
        if (r11 != (-1)) goto L48;
    L46:
        String r37 = null;
    L51:
        if (r12 != (-1)) goto L54;
    L52:
        String r38 = null;
    L57:
        if (r13 != (-1)) goto L60;
    L58:
        boolean r39 = r20;
        if (r14 != (-1)) goto L65;
    L63:
        String r40 = null;
    L68:
        hn r22 = new hn(r24, r26, r27, r29, r31, r32, r34, r35, r36, r37, r38, r39, r40);
        if (r15 == (-1)) goto L76;
        if (r0.isNull(r15) == false) goto L73;
        Integer r23 = null;
    L74:
        r22.setPoisonLabel(r23);
        goto L76
    L73:
        r23 = Integer.valueOf(r0.getInt(r15));
    L76:
        if (r16 == (-1)) goto L83;
        if (r0.isNull(r16) == false) goto L80;
        Integer r25 = null;
    L81:
        r22.setPoisonLabelVersion(r25);
        goto L83
    L80:
        r25 = Integer.valueOf(r0.getInt(r16));
    L83:
        if (r17 == (-1)) goto L90;
        if (r0.isNull(r17) == true) goto L88;
        r19 = r0.getString(r17);
    L88:
        r22.setContentHash(r19);
    L90:
        return new hp(r21, r22);
    L65:
        if (r0.isNull(r14) == true) goto L63;
        r40 = r0.getString(r14);
        goto L68
    L60:
        if (r0.getInt(r13) == 0) goto L58;
        r20 = true;
        goto L58
    L54:
        if (r0.isNull(r12) == true) goto L52;
        r38 = r0.getString(r12);
        goto L57
    L48:
        if (r0.isNull(r11) == true) goto L46;
        r37 = r0.getString(r11);
        goto L51
    L42:
        if (r0.isNull(r10) == true) goto L40;
        r36 = r0.getString(r10);
        goto L45
    L38:
        r35 = r0.getInt(r9);
        goto L39
    L33:
        if (r0.isNull(r8) == true) goto L31;
        r34 = r0.getString(r8);
        goto L36
    L25:
        r31 = r0.getInt(r6);
        goto L26
    L21:
        r29 = r0.getLong(r5);
        goto L22
    L18:
        r27 = r0.getLong(r4);
        goto L19
    L13:
        if (r0.isNull(r3) == true) goto L11;
        r26 = r0.getString(r3);
        goto L16
    L8:
        r24 = r0.getLong(r2);
        goto L9
    L5:
        r21 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<hp> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfRawUserProfileHistoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<hp> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfRawUserProfileHistoryEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    public int delete(hp r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfRawUserProfileHistoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((hp) ZeusTransformUtils.preCheckCast(r3, hp.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return RawUserProfileHistoryRawDbDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityId(String r1, String r2) {
        return RawUserProfileHistoryRawDbDao.DefaultImpls.deleteByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityIdList(List<String> r3, String r4) {
        return RawUserProfileHistoryRawDbDao.DefaultImpls.deleteByEntityIdList(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityIdListAndPackageName(List<String> r3, String r4) {
        return RawUserProfileHistoryRawDbDao.DefaultImpls.deleteByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteById(long r1) {
        return RawUserProfileHistoryRawDbDao.DefaultImpls.deleteById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.RawUserProfileHistoryRawDbDao, com.obric.memorydata.database.dao.IHistoryEntityDao
    public String getPrefix() {
        return RawUserProfileHistoryRawDbDao.DefaultImpls.getPrefix(this);
    }

    @Override // com.obric.memorydata.database.dao.RawUserProfileHistoryRawDbDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return RawUserProfileHistoryRawDbDao.DefaultImpls.getTableName(this);
    }

    public long insert(hp r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfRawUserProfileHistoryEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((hp) ZeusTransformUtils.preCheckCast(r3, hp.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<hp> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfRawUserProfileHistoryEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<hp> queryAll() {
        return RawUserProfileHistoryRawDbDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return RawUserProfileHistoryRawDbDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public List<hp> queryByEntityId(String r1, String r2) {
        return RawUserProfileHistoryRawDbDao.DefaultImpls.queryByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public List<hp> queryByEntityIdListAndPackageName(List<String> r3, String r4) {
        return RawUserProfileHistoryRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public hp queryById(long r1) {
        return RawUserProfileHistoryRawDbDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<hp> queryByIds(List<Long> r3) {
        return RawUserProfileHistoryRawDbDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public hp queryByUUID(String r1) {
        return RawUserProfileHistoryRawDbDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public hp queryOne() {
        return RawUserProfileHistoryRawDbDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<hp> queryWithLimitAndOffset(int r1, int r2) {
        return RawUserProfileHistoryRawDbDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<hp> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityRawUserProfileHistoryEntity(r6));     // Catch: Throwable -> L10
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

    public int update(hp r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfRawUserProfileHistoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((hp) ZeusTransformUtils.preCheckCast(r3, hp.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<hp> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfRawUserProfileHistoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
