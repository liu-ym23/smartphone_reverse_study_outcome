package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.fa;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class ProactiveSemanticRelevantDataDao_Impl implements ProactiveSemanticRelevantDataDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<fa> __deletionAdapterOfProactiveSemanticRelevantData;
    private final EntityInsertionAdapter<fa> __insertionAdapterOfProactiveSemanticRelevantData;
    private final EntityInsertionAdapter<fa> __insertionAdapterOfProactiveSemanticRelevantData_1;
    private final EntityDeletionOrUpdateAdapter<fa> __updateAdapterOfProactiveSemanticRelevantData;

    public ProactiveSemanticRelevantDataDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfProactiveSemanticRelevantData = new AnonymousClass1(this, r2);
        this.__insertionAdapterOfProactiveSemanticRelevantData_1 = new AnonymousClass2(this, r2);
        this.__deletionAdapterOfProactiveSemanticRelevantData = new AnonymousClass3(this, r2);
        this.__updateAdapterOfProactiveSemanticRelevantData = new AnonymousClass4(this, r2);
    }

    private fa __entityCursorConverter_comObricMemorydataDatabaseEntityProactiveSemanticRelevantData(Cursor r25) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r25, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "semantic_id");
        int r3 = CursorUtil.getColumnIndex(r0, "source_query");
        int r4 = CursorUtil.getColumnIndex(r0, "source_text");
        int r5 = CursorUtil.getColumnIndex(r0, "source_screenshot");
        int r6 = CursorUtil.getColumnIndex(r0, "source_app_name");
        int r7 = CursorUtil.getColumnIndex(r0, "source_package_name");
        int r8 = CursorUtil.getColumnIndex(r0, "detail_status");
        int r9 = CursorUtil.getColumnIndex(r0, "product_type");
        if (r1 != (-1)) goto L5;
        long r11 = 0;
    L6:
        long r14 = r11;
        String r10 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r16 = null;
    L13:
        if (r3 != (-1)) goto L16;
    L14:
        String r17 = null;
    L19:
        if (r4 != (-1)) goto L22;
    L20:
        String r18 = null;
    L25:
        if (r5 != (-1)) goto L28;
    L26:
        String r19 = null;
    L31:
        if (r6 != (-1)) goto L34;
    L32:
        String r20 = null;
    L37:
        if (r7 != (-1)) goto L40;
    L38:
        String r21 = r10;
        if (r8 != (-1)) goto L46;
        int r22 = 0;
    L47:
        if (r9 != (-1)) goto L49;
        int r23 = 0;
    L51:
        return new fa(r14, r16, r17, r18, r19, r20, r21, r22, r23);
    L49:
        r23 = r0.getInt(r9);
        goto L51
    L46:
        r22 = r0.getInt(r8);
        goto L47
    L40:
        if (r0.isNull(r7) == true) goto L38;
        r10 = r0.getString(r7);
        goto L38
    L34:
        if (r0.isNull(r6) == true) goto L32;
        r20 = r0.getString(r6);
        goto L37
    L28:
        if (r0.isNull(r5) == true) goto L26;
        r19 = r0.getString(r5);
        goto L31
    L22:
        if (r0.isNull(r4) == true) goto L20;
        r18 = r0.getString(r4);
        goto L25
    L16:
        if (r0.isNull(r3) == true) goto L14;
        r17 = r0.getString(r3);
        goto L19
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r16 = r0.getString(r2);
        goto L13
    L5:
        r11 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<fa> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfProactiveSemanticRelevantData.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<fa> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfProactiveSemanticRelevantData_1.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(fa r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfProactiveSemanticRelevantData.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(fa r3) {
        return delete2((fa) ZeusTransformUtils.preCheckCast(r3, fa.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return ProactiveSemanticRelevantDataDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.ProactiveSemanticRelevantDataDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return ProactiveSemanticRelevantDataDao.DefaultImpls.getTableName(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.ProactiveSemanticRelevantDataDao
    public long insert(fa r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfProactiveSemanticRelevantData.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(fa r3) {
        return insert((fa) ZeusTransformUtils.preCheckCast(r3, fa.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<fa> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfProactiveSemanticRelevantData_1.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<fa> queryAll() {
        return ProactiveSemanticRelevantDataDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return ProactiveSemanticRelevantDataDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public fa queryById(long r1) {
        return ProactiveSemanticRelevantDataDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ fa queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<fa> queryByIds(List<Long> r3) {
        return ProactiveSemanticRelevantDataDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.ProactiveSemanticRelevantDataDao
    public List<fa> queryByMemoryId(String r26) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM ProactiveSemanticRelevantData WHERE semantic_id = ?", 1);
        if (r26 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L38
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "semantic_id");     // Catch: Throwable -> L38
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "source_query");     // Catch: Throwable -> L38
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "source_text");     // Catch: Throwable -> L38
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "source_screenshot");     // Catch: Throwable -> L38
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "source_app_name");     // Catch: Throwable -> L38
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "source_package_name");     // Catch: Throwable -> L38
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "detail_status");     // Catch: Throwable -> L38
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "product_type");     // Catch: Throwable -> L38
        ArrayList r12 = new ArrayList(r1.getCount());     // Catch: Throwable -> L38
    L8:
        if (r1.moveToNext() == false) goto L36;
        long r15 = r1.getLong(r0);     // Catch: Throwable -> L38
        if (r1.isNull(r4) == false) goto L13;
        String r17 = null;
    L15:
        if (r1.isNull(r5) == false) goto L17;
        String r18 = null;
    L19:
        if (r1.isNull(r6) == false) goto L21;
        String r19 = null;
    L23:
        if (r1.isNull(r7) == false) goto L25;
        String r20 = null;
    L27:
        if (r1.isNull(r8) == false) goto L29;
        String r21 = null;
    L31:
        if (r1.isNull(r9) == false) goto L33;
        String r22 = null;
    L34:
        r12.add(new fa(r15, r17, r18, r19, r20, r21, r22, r1.getInt(r10), r1.getInt(r11)));     // Catch: Throwable -> L38
        goto L8
    L33:
        r22 = r1.getString(r9);     // Catch: Throwable -> L38
        goto L34
    L29:
        r21 = r1.getString(r8);     // Catch: Throwable -> L38
        goto L31
    L25:
        r20 = r1.getString(r7);     // Catch: Throwable -> L38
        goto L27
    L21:
        r19 = r1.getString(r6);     // Catch: Throwable -> L38
        goto L23
    L17:
        r18 = r1.getString(r5);     // Catch: Throwable -> L38
        goto L19
    L13:
        r17 = r1.getString(r4);     // Catch: Throwable -> L38
        goto L15
    L36:
        r1.close();
        r2.release();
        return r12;
    L38:
        th = move-exception;
        r1.close();
        r2.release();
        throw th;
    L5:
        r2.bindString(1, r26);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.ProactiveSemanticRelevantDataDao
    public List<fa> queryByMemoryIds(List<String> r26) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r26, List.class, "com.obric.memorydata.plugin");
        StringBuilder r3 = StringUtil.newStringBuilder();
        r3.append("SELECT * FROM ProactiveSemanticRelevantData WHERE semantic_id IN (");
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
        int r0 = CursorUtil.getColumnIndexOrThrow(r8, OaidModel.KEY_ID);     // Catch: Throwable -> L42
        int r9 = CursorUtil.getColumnIndexOrThrow(r8, "semantic_id");     // Catch: Throwable -> L42
        int r10 = CursorUtil.getColumnIndexOrThrow(r8, "source_query");     // Catch: Throwable -> L42
        int r11 = CursorUtil.getColumnIndexOrThrow(r8, "source_text");     // Catch: Throwable -> L42
        int r12 = CursorUtil.getColumnIndexOrThrow(r8, "source_screenshot");     // Catch: Throwable -> L42
        int r13 = CursorUtil.getColumnIndexOrThrow(r8, "source_app_name");     // Catch: Throwable -> L42
        int r14 = CursorUtil.getColumnIndexOrThrow(r8, "source_package_name");     // Catch: Throwable -> L42
        int r15 = CursorUtil.getColumnIndexOrThrow(r8, "detail_status");     // Catch: Throwable -> L42
        int r16 = CursorUtil.getColumnIndexOrThrow(r8, "product_type");     // Catch: Throwable -> L42
        ArrayList r17 = new ArrayList(r8.getCount());     // Catch: Throwable -> L42
    L12:
        if (r8.moveToNext() == false) goto L40;
        long r18 = r8.getLong(r0);     // Catch: Throwable -> L42
        if (r8.isNull(r9) == false) goto L17;
        String r19 = null;
    L19:
        if (r8.isNull(r10) == false) goto L21;
        String r110 = null;
    L23:
        if (r8.isNull(r11) == false) goto L25;
        String r111 = null;
    L27:
        if (r8.isNull(r12) == false) goto L29;
        String r20 = null;
    L31:
        if (r8.isNull(r13) == false) goto L33;
        String r21 = null;
    L35:
        if (r8.isNull(r14) == false) goto L37;
        String r22 = null;
    L38:
        r17.add(new fa(r18, r19, r110, r111, r20, r21, r22, r8.getInt(r15), r8.getInt(r16)));     // Catch: Throwable -> L42
        goto L12
    L37:
        r22 = r8.getString(r14);     // Catch: Throwable -> L42
        goto L38
    L33:
        r21 = r8.getString(r13);     // Catch: Throwable -> L42
        goto L35
    L29:
        r20 = r8.getString(r12);     // Catch: Throwable -> L42
        goto L31
    L25:
        r111 = r8.getString(r11);     // Catch: Throwable -> L42
        goto L27
    L21:
        r110 = r8.getString(r10);     // Catch: Throwable -> L42
        goto L23
    L17:
        r19 = r8.getString(r9);     // Catch: Throwable -> L42
        goto L19
    L40:
        r8.close();
        r5.release();
        return r17;
    L42:
        th = move-exception;
        r8.close();
        r5.release();
        throw th;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public fa queryByUUID(String r1) {
        return ProactiveSemanticRelevantDataDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ fa queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.ProactiveSemanticRelevantDataDao
    public fa queryFirstBySourceScreenshot(String r25) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM ProactiveSemanticRelevantData WHERE source_screenshot = ? LIMIT 1", 1);
        if (r25 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        fa r3 = null;
        String r4 = null;
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L36
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "semantic_id");     // Catch: Throwable -> L36
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "source_query");     // Catch: Throwable -> L36
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "source_text");     // Catch: Throwable -> L36
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "source_screenshot");     // Catch: Throwable -> L36
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "source_app_name");     // Catch: Throwable -> L36
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "source_package_name");     // Catch: Throwable -> L36
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "detail_status");     // Catch: Throwable -> L36
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "product_type");     // Catch: Throwable -> L36
        if (r1.moveToFirst() == false) goto L34;
        long r14 = r1.getLong(r0);     // Catch: Throwable -> L36
        if (r1.isNull(r5) == false) goto L12;
        String r16 = null;
    L14:
        if (r1.isNull(r6) == false) goto L16;
        String r17 = null;
    L18:
        if (r1.isNull(r7) == false) goto L20;
        String r18 = null;
    L22:
        if (r1.isNull(r8) == false) goto L24;
        String r19 = null;
    L26:
        if (r1.isNull(r9) == false) goto L28;
        String r20 = null;
    L30:
        if (r1.isNull(r10) == true) goto L33;
        r4 = r1.getString(r10);     // Catch: Throwable -> L36
    L33:
        r3 = new fa(r14, r16, r17, r18, r19, r20, r4, r1.getInt(r11), r1.getInt(r12));     // Catch: Throwable -> L36
        goto L34
    L28:
        r20 = r1.getString(r9);     // Catch: Throwable -> L36
        goto L30
    L24:
        r19 = r1.getString(r8);     // Catch: Throwable -> L36
        goto L26
    L20:
        r18 = r1.getString(r7);     // Catch: Throwable -> L36
        goto L22
    L16:
        r17 = r1.getString(r6);     // Catch: Throwable -> L36
        goto L18
    L12:
        r16 = r1.getString(r5);     // Catch: Throwable -> L36
    L34:
        r1.close();
        r2.release();
        return r3;
    L36:
        th = move-exception;
        r1.close();
        r2.release();
        throw th;
    L5:
        r2.bindString(1, r25);
        goto L6
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public fa queryOne() {
        return ProactiveSemanticRelevantDataDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ fa queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<fa> queryWithLimitAndOffset(int r1, int r2) {
        return ProactiveSemanticRelevantDataDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<fa> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityProactiveSemanticRelevantData(r6));     // Catch: Throwable -> L10
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
    public int update2(fa r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfProactiveSemanticRelevantData.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(fa r3) {
        return update2((fa) ZeusTransformUtils.preCheckCast(r3, fa.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<fa> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfProactiveSemanticRelevantData.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
