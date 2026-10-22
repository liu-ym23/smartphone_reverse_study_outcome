package com.obric.memorydata.database.legacy.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.lifelog.data.Lifelog;
import com.obric.memorydata.database.legacy.entity.LifelogEntityOld;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class LifelogDaoOld_Impl implements x {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<LifelogEntityOld> __deletionAdapterOfLifelogEntityOld;
    private final EntityInsertionAdapter<LifelogEntityOld> __insertionAdapterOfLifelogEntityOld;
    private final EntityDeletionOrUpdateAdapter<LifelogEntityOld> __updateAdapterOfLifelogEntityOld;

    public LifelogDaoOld_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfLifelogEntityOld = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfLifelogEntityOld = new AnonymousClass2(this, r2);
        this.__updateAdapterOfLifelogEntityOld = new AnonymousClass3(this, r2);
    }

    private LifelogEntityOld __entityCursorConverter_comObricMemorydataDatabaseLegacyEntityLifelogEntityOld(Cursor r57) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r57, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "entityId");
        int r3 = CursorUtil.getColumnIndex(r0, "createTime");
        int r4 = CursorUtil.getColumnIndex(r0, "modifyTime");
        int r5 = CursorUtil.getColumnIndex(r0, "type");
        int r6 = CursorUtil.getColumnIndex(r0, "entityTimestamp");
        int r7 = CursorUtil.getColumnIndex(r0, ObricMemoryConstants.KEY_PACKAGE_NAME);
        int r8 = CursorUtil.getColumnIndex(r0, "hashCodeValue");
        int r9 = CursorUtil.getColumnIndex(r0, Api.KEY_UUID);
        int r10 = CursorUtil.getColumnIndex(r0, "fullContent");
        int r11 = CursorUtil.getColumnIndex(r0, "personalDbSplitMigrated");
        int r12 = CursorUtil.getColumnIndex(r0, "poison_label");
        int r13 = CursorUtil.getColumnIndex(r0, "poison_label_version");
        int r14 = CursorUtil.getColumnIndex(r0, "content_hash");
        int r15 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r16 = CursorUtil.getColumnIndex(r0, "uid");
        int r17 = CursorUtil.getColumnIndex(r0, "title");
        int r18 = CursorUtil.getColumnIndex(r0, "contentAM");
        int r19 = CursorUtil.getColumnIndex(r0, "contentPM");
        int r110 = CursorUtil.getColumnIndex(r0, "finalContent");
        int r111 = CursorUtil.getColumnIndex(r0, "imageUrl");
        int r112 = CursorUtil.getColumnIndex(r0, "retryTime");
        int r113 = CursorUtil.getColumnIndex(r0, "status");
        long r22 = 0;
        if (r1 != (-1)) goto L5;
        long r28 = 0;
    L6:
        String r20 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r30 = null;
    L13:
        if (r3 != (-1)) goto L15;
        long r31 = 0;
    L16:
        if (r4 != (-1)) goto L18;
        long r33 = 0;
    L19:
        int r21 = 0;
        if (r5 != (-1)) goto L22;
        int r35 = 0;
    L23:
        if (r6 != (-1)) goto L25;
        long r36 = 0;
    L26:
        if (r7 != (-1)) goto L29;
    L27:
        String r38 = null;
    L32:
        if (r8 != (-1)) goto L34;
        int r39 = 0;
    L35:
        if (r9 != (-1)) goto L38;
    L36:
        String r40 = null;
    L41:
        if (r10 != (-1)) goto L44;
    L42:
        String r42 = null;
    L47:
        if (r11 != (-1)) goto L50;
        boolean r43 = false;
    L54:
        if (r15 != (-1)) goto L56;
        long r45 = 0;
    L57:
        if (r16 == (-1)) goto L60;
        r22 = r0.getLong(r16);
    L60:
        long r47 = r22;
        if (r17 != (-1)) goto L65;
    L62:
        String r49 = null;
    L68:
        if (r18 != (-1)) goto L72;
    L69:
        String r50 = null;
    L75:
        if (r19 != (-1)) goto L79;
    L76:
        String r51 = null;
    L82:
        if (r110 != (-1)) goto L86;
    L83:
        String r52 = null;
    L89:
        if (r111 != (-1)) goto L93;
    L90:
        String r53 = null;
    L96:
        if (r112 != (-1)) goto L98;
        int r54 = 0;
    L100:
        if (r113 == (-1)) goto L103;
        r21 = r0.getInt(r113);
    L103:
        LifelogEntityOld r23 = new LifelogEntityOld(r28, r30, r31, r33, r35, r36, r38, r39, r40, new Lifelog(r45, r47, r49, r50, r51, r52, r53, r54, r21), r42, r43);
        if (r12 == (-1)) goto L111;
        if (r0.isNull(r12) == false) goto L108;
        Integer r24 = null;
    L109:
        r23.setPoisonLabel(r24);
        goto L111
    L108:
        r24 = Integer.valueOf(r0.getInt(r12));
    L111:
        if (r13 == (-1)) goto L118;
        if (r0.isNull(r13) == false) goto L115;
        Integer r25 = null;
    L116:
        r23.setPoisonLabelVersion(r25);
        goto L118
    L115:
        r25 = Integer.valueOf(r0.getInt(r13));
    L118:
        if (r14 != (-1)) goto L120;
    L124:
        return r23;
    L120:
        if (r0.isNull(r14) == true) goto L123;
        r20 = r0.getString(r14);
    L123:
        r23.setContentHash(r20);
        goto L124
    L98:
        r54 = r0.getInt(r112);
        goto L100
    L93:
        if (r0.isNull(r111) == true) goto L90;
        r53 = r0.getString(r111);
        goto L96
    L86:
        if (r0.isNull(r110) == true) goto L83;
        r52 = r0.getString(r110);
        goto L89
    L79:
        if (r0.isNull(r19) == true) goto L76;
        r51 = r0.getString(r19);
        goto L82
    L72:
        if (r0.isNull(r18) == true) goto L69;
        r50 = r0.getString(r18);
        goto L75
    L65:
        if (r0.isNull(r17) == true) goto L62;
        r49 = r0.getString(r17);
        goto L68
    L56:
        r45 = r0.getLong(r15);
        goto L57
    L50:
        if (r0.getInt(r11) == 0) goto L52;
        boolean r26 = true;
    L53:
        r43 = r26;
        goto L54
    L52:
        r26 = false;
        goto L53
    L44:
        if (r0.isNull(r10) == true) goto L42;
        r42 = r0.getString(r10);
        goto L47
    L38:
        if (r0.isNull(r9) == true) goto L36;
        r40 = r0.getString(r9);
        goto L41
    L34:
        r39 = r0.getInt(r8);
        goto L35
    L29:
        if (r0.isNull(r7) == true) goto L27;
        r38 = r0.getString(r7);
        goto L32
    L25:
        r36 = r0.getLong(r6);
        goto L26
    L22:
        r35 = r0.getInt(r5);
        goto L23
    L18:
        r33 = r0.getLong(r4);
        goto L19
    L15:
        r31 = r0.getLong(r3);
        goto L16
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r30 = r0.getString(r2);
        goto L13
    L5:
        r28 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<LifelogEntityOld> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfLifelogEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<LifelogEntityOld> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfLifelogEntityOld.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(LifelogEntityOld r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfLifelogEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(LifelogEntityOld r3) {
        return delete2((LifelogEntityOld) ZeusTransformUtils.preCheckCast(r3, LifelogEntityOld.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return x.a.d(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return x.a.a(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(LifelogEntityOld r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfLifelogEntityOld.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(LifelogEntityOld r3) {
        return insert2((LifelogEntityOld) ZeusTransformUtils.preCheckCast(r3, LifelogEntityOld.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<LifelogEntityOld> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfLifelogEntityOld.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<LifelogEntityOld> queryAll() {
        return x.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return x.a.c(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public LifelogEntityOld queryById(long r1) {
        return x.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ LifelogEntityOld queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<LifelogEntityOld> queryByIds(List<Long> r3) {
        return x.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public LifelogEntityOld queryByUUID(String r1) {
        return x.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ LifelogEntityOld queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public LifelogEntityOld queryOne() {
        return x.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ LifelogEntityOld queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<LifelogEntityOld> queryWithLimitAndOffset(int r1, int r2) {
        return x.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<LifelogEntityOld> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseLegacyEntityLifelogEntityOld(r6));     // Catch: Throwable -> L10
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
    public int update2(LifelogEntityOld r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfLifelogEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(LifelogEntityOld r3) {
        return update2((LifelogEntityOld) ZeusTransformUtils.preCheckCast(r3, LifelogEntityOld.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<LifelogEntityOld> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfLifelogEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
