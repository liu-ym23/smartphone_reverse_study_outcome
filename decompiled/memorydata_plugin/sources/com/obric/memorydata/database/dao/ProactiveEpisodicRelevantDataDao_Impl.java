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
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.database.entity.es;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class ProactiveEpisodicRelevantDataDao_Impl implements ProactiveEpisodicRelevantDataDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<es> __deletionAdapterOfProactiveEpisodicRelevantData;
    private final EntityInsertionAdapter<es> __insertionAdapterOfProactiveEpisodicRelevantData;
    private final EntityInsertionAdapter<es> __insertionAdapterOfProactiveEpisodicRelevantData_1;
    private final SharedSQLiteStatement __preparedStmtOfUpdateDetailStatusByEpisodicId;
    private final EntityDeletionOrUpdateAdapter<es> __updateAdapterOfProactiveEpisodicRelevantData;

    public ProactiveEpisodicRelevantDataDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfProactiveEpisodicRelevantData = new AnonymousClass1(this, r2);
        this.__insertionAdapterOfProactiveEpisodicRelevantData_1 = new AnonymousClass2(this, r2);
        this.__deletionAdapterOfProactiveEpisodicRelevantData = new AnonymousClass3(this, r2);
        this.__updateAdapterOfProactiveEpisodicRelevantData = new AnonymousClass4(this, r2);
        this.__preparedStmtOfUpdateDetailStatusByEpisodicId = new AnonymousClass5(this, r2);
    }

    private es __entityCursorConverter_comObricMemorydataDatabaseEntityProactiveEpisodicRelevantData(Cursor r41) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r41, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "episodic_id");
        int r3 = CursorUtil.getColumnIndex(r0, "source_query");
        int r4 = CursorUtil.getColumnIndex(r0, "source_text");
        int r5 = CursorUtil.getColumnIndex(r0, "source_link");
        int r6 = CursorUtil.getColumnIndex(r0, "source_link_type");
        int r7 = CursorUtil.getColumnIndex(r0, "screenshot");
        int r8 = CursorUtil.getColumnIndex(r0, "source_package_name");
        int r9 = CursorUtil.getColumnIndex(r0, "source_app_name");
        int r10 = CursorUtil.getColumnIndex(r0, "product_type");
        int r11 = CursorUtil.getColumnIndex(r0, EventBody.KEY_CATEGORY);
        int r12 = CursorUtil.getColumnIndex(r0, "tag_list");
        int r13 = CursorUtil.getColumnIndex(r0, "summary");
        int r14 = CursorUtil.getColumnIndex(r0, "detail_status");
        int r15 = CursorUtil.getColumnIndex(r0, "in_app_object_id");
        int r16 = CursorUtil.getColumnIndex(r0, "in_app_rule_family");
        int r17 = CursorUtil.getColumnIndex(r0, "in_app_activity_name");
        int r18 = CursorUtil.getColumnIndex(r0, "in_app_event_time");
        if (r1 != (-1)) goto L5;
        long r19 = 0;
    L6:
        long r21 = r19;
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
        int r20 = 0;
        if (r10 != (-1)) goto L58;
        int r31 = 0;
    L59:
        if (r11 != (-1)) goto L62;
    L60:
        String r32 = null;
    L65:
        if (r12 != (-1)) goto L68;
    L66:
        String r33 = null;
    L71:
        if (r13 != (-1)) goto L74;
    L72:
        String r34 = null;
    L77:
        if (r14 == (-1)) goto L80;
        r20 = r0.getInt(r14);
    L80:
        int r35 = r20;
        if (r15 != (-1)) goto L84;
    L82:
        String r36 = null;
    L87:
        if (r41 != (-1)) goto L91;
    L88:
        String r37 = null;
    L94:
        if (r17 != (-1)) goto L98;
    L95:
        String r38 = null;
    L101:
        if (r18 != (-1)) goto L104;
    L102:
        Long r39 = null;
    L108:
        return new es(r21, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39);
    L104:
        if (r0.isNull(r18) == true) goto L102;
        r39 = Long.valueOf(r0.getLong(r18));
        goto L108
    L98:
        if (r0.isNull(r17) == true) goto L95;
        r38 = r0.getString(r17);
        goto L101
    L91:
        if (r0.isNull(r41) == true) goto L88;
        r37 = r0.getString(r16);
        goto L94
    L84:
        if (r0.isNull(r15) == true) goto L82;
        r36 = r0.getString(r15);
        goto L87
    L74:
        if (r0.isNull(r13) == true) goto L72;
        r34 = r0.getString(r13);
        goto L77
    L68:
        if (r0.isNull(r12) == true) goto L66;
        r33 = r0.getString(r12);
        goto L71
    L62:
        if (r0.isNull(r11) == true) goto L60;
        r32 = r0.getString(r11);
        goto L65
    L58:
        r31 = r0.getInt(r10);
        goto L59
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
        r19 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<es> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfProactiveEpisodicRelevantData.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<es> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfProactiveEpisodicRelevantData_1.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(es r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfProactiveEpisodicRelevantData.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(es r3) {
        return delete2((es) ZeusTransformUtils.preCheckCast(r3, es.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return ProactiveEpisodicRelevantDataDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.ProactiveEpisodicRelevantDataDao
    public int deleteByIds(List<String> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("DELETE FROM ProactiveEpisodicRelevantData WHERE episodic_id in (");
        StringUtil.appendPlaceholders(r0, r7.size());
        r0.append(")");
        String r1 = r0.toString();
        SupportSQLiteStatement r2 = this.__db.compileStatement(r1);
        Iterator r8 = r7.iterator();
        int r3 = 1;
    L4:
        if (r8.hasNext() == false) goto L10;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L8;
        r2.bindNull(r3);
    L9:
        r3 = r3 + 1;
        goto L4
    L8:
        r2.bindString(r3, r4);
        goto L9
    L10:
        this.__db.beginTransaction();
        int r9 = r2.executeUpdateDelete();     // Catch: Throwable -> L14
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.__db.endTransaction();
        return r9;
    L14:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.ProactiveEpisodicRelevantDataDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return ProactiveEpisodicRelevantDataDao.DefaultImpls.getTableName(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.ProactiveEpisodicRelevantDataDao
    public long insert(es r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfProactiveEpisodicRelevantData.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(es r3) {
        return insert((es) ZeusTransformUtils.preCheckCast(r3, es.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<es> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfProactiveEpisodicRelevantData_1.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<es> queryAll() {
        return ProactiveEpisodicRelevantDataDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return ProactiveEpisodicRelevantDataDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.ProactiveEpisodicRelevantDataDao
    public List<es> queryByEpisodicId(String r43) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM ProactiveEpisodicRelevantData WHERE episodic_id = ?", 1);
        if (r43 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L78
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "episodic_id");     // Catch: Throwable -> L78
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "source_query");     // Catch: Throwable -> L78
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "source_text");     // Catch: Throwable -> L78
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "source_link");     // Catch: Throwable -> L78
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "source_link_type");     // Catch: Throwable -> L78
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "screenshot");     // Catch: Throwable -> L78
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "source_package_name");     // Catch: Throwable -> L78
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "source_app_name");     // Catch: Throwable -> L78
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "product_type");     // Catch: Throwable -> L78
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, EventBody.KEY_CATEGORY);     // Catch: Throwable -> L78
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "tag_list");     // Catch: Throwable -> L78
        int r15 = CursorUtil.getColumnIndexOrThrow(r1, "summary");     // Catch: Throwable -> L78
        int r3 = CursorUtil.getColumnIndexOrThrow(r1, "detail_status");     // Catch: Throwable -> L78
        RoomSQLiteQuery r16 = r2;
        int r44 = CursorUtil.getColumnIndexOrThrow(r1, "in_app_object_id");     // Catch: Throwable -> L76
        int r17 = CursorUtil.getColumnIndexOrThrow(r1, "in_app_rule_family");     // Catch: Throwable -> L76
        int r18 = CursorUtil.getColumnIndexOrThrow(r1, "in_app_activity_name");     // Catch: Throwable -> L76
        int r19 = CursorUtil.getColumnIndexOrThrow(r1, "in_app_event_time");     // Catch: Throwable -> L76
        int r20 = r3;
        ArrayList r21 = new ArrayList(r1.getCount());     // Catch: Throwable -> L76
    L10:
        if (r1.moveToNext() == false) goto L74;
        long r22 = r1.getLong(r0);     // Catch: Throwable -> L76
        if (r1.isNull(r4) == false) goto L15;
        String r24 = null;
    L17:
        if (r1.isNull(r5) == false) goto L19;
        String r25 = null;
    L21:
        if (r1.isNull(r6) == false) goto L23;
        String r26 = null;
    L25:
        if (r1.isNull(r7) == false) goto L27;
        String r27 = null;
    L29:
        if (r1.isNull(r8) == false) goto L31;
        String r28 = null;
    L33:
        if (r1.isNull(r9) == false) goto L35;
        String r29 = null;
    L37:
        if (r1.isNull(r10) == false) goto L39;
        String r30 = null;
    L41:
        if (r1.isNull(r11) == false) goto L43;
        String r31 = null;
    L44:
        int r32 = r1.getInt(r12);     // Catch: Throwable -> L76
        if (r1.isNull(r13) == false) goto L47;
        String r33 = null;
    L49:
        if (r1.isNull(r14) == false) goto L51;
        String r34 = null;
    L53:
        if (r1.isNull(r15) == false) goto L55;
        String r35 = null;
    L56:
        int r36 = r1.getInt(r20);     // Catch: Throwable -> L76
        int r23 = r0;
        r44 = r44;
        if (r1.isNull(r44) == false) goto L59;
        String r37 = null;
    L61:
        if (r1.isNull(r17) == false) goto L63;
        String r38 = null;
    L65:
        if (r1.isNull(r18) == false) goto L67;
        String r39 = null;
    L69:
        if (r1.isNull(r19) == false) goto L71;
        Long r40 = null;
    L72:
        r21.add(new es(r22, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40));     // Catch: Throwable -> L76
        r0 = r23;
        r20 = r20;
        goto L10
    L71:
        r40 = Long.valueOf(r1.getLong(r19));     // Catch: Throwable -> L76
        goto L72
    L67:
        r39 = r1.getString(r18);     // Catch: Throwable -> L76
        goto L69
    L63:
        r38 = r1.getString(r17);     // Catch: Throwable -> L76
        goto L65
    L59:
        r37 = r1.getString(r44);     // Catch: Throwable -> L76
        goto L61
    L55:
        r35 = r1.getString(r15);     // Catch: Throwable -> L76
        goto L56
    L51:
        r34 = r1.getString(r14);     // Catch: Throwable -> L76
        goto L53
    L47:
        r33 = r1.getString(r13);     // Catch: Throwable -> L76
        goto L49
    L43:
        r31 = r1.getString(r11);     // Catch: Throwable -> L76
        goto L44
    L39:
        r30 = r1.getString(r10);     // Catch: Throwable -> L76
        goto L41
    L35:
        r29 = r1.getString(r9);     // Catch: Throwable -> L76
        goto L37
    L31:
        r28 = r1.getString(r8);     // Catch: Throwable -> L76
        goto L33
    L27:
        r27 = r1.getString(r7);     // Catch: Throwable -> L76
        goto L29
    L23:
        r26 = r1.getString(r6);     // Catch: Throwable -> L76
        goto L25
    L19:
        r25 = r1.getString(r5);     // Catch: Throwable -> L76
        goto L21
    L15:
        r24 = r1.getString(r4);     // Catch: Throwable -> L76
        goto L17
    L74:
        r1.close();
        r16.release();
        return r21;
    L76:
        th = th;
    L80:
        r1.close();
        r16.release();
        throw th;
    L78:
        th = th;
        r16 = r2;
        goto L80
    L5:
        r2.bindString(1, r43);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.ProactiveEpisodicRelevantDataDao
    public List<es> queryByEpisodicIds(List<String> r43) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r43, List.class, "com.obric.memorydata.plugin");
        StringBuilder r3 = StringUtil.newStringBuilder();
        r3.append("SELECT * FROM ProactiveEpisodicRelevantData WHERE episodic_id IN (");
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
        int r0 = CursorUtil.getColumnIndexOrThrow(r8, OaidModel.KEY_ID);     // Catch: Throwable -> L82
        int r9 = CursorUtil.getColumnIndexOrThrow(r8, "episodic_id");     // Catch: Throwable -> L82
        int r10 = CursorUtil.getColumnIndexOrThrow(r8, "source_query");     // Catch: Throwable -> L82
        int r11 = CursorUtil.getColumnIndexOrThrow(r8, "source_text");     // Catch: Throwable -> L82
        int r12 = CursorUtil.getColumnIndexOrThrow(r8, "source_link");     // Catch: Throwable -> L82
        int r13 = CursorUtil.getColumnIndexOrThrow(r8, "source_link_type");     // Catch: Throwable -> L82
        int r14 = CursorUtil.getColumnIndexOrThrow(r8, "screenshot");     // Catch: Throwable -> L82
        int r15 = CursorUtil.getColumnIndexOrThrow(r8, "source_package_name");     // Catch: Throwable -> L82
        int r16 = CursorUtil.getColumnIndexOrThrow(r8, "source_app_name");     // Catch: Throwable -> L82
        int r17 = CursorUtil.getColumnIndexOrThrow(r8, "product_type");     // Catch: Throwable -> L82
        int r18 = CursorUtil.getColumnIndexOrThrow(r8, EventBody.KEY_CATEGORY);     // Catch: Throwable -> L82
        int r19 = CursorUtil.getColumnIndexOrThrow(r8, "tag_list");     // Catch: Throwable -> L82
        int r110 = CursorUtil.getColumnIndexOrThrow(r8, "summary");     // Catch: Throwable -> L82
        int r20 = CursorUtil.getColumnIndexOrThrow(r8, "detail_status");     // Catch: Throwable -> L82
        RoomSQLiteQuery r44 = r5;
        int r111 = CursorUtil.getColumnIndexOrThrow(r8, "in_app_object_id");     // Catch: Throwable -> L80
        int r112 = CursorUtil.getColumnIndexOrThrow(r8, "in_app_rule_family");     // Catch: Throwable -> L80
        int r113 = CursorUtil.getColumnIndexOrThrow(r8, "in_app_activity_name");     // Catch: Throwable -> L80
        int r114 = CursorUtil.getColumnIndexOrThrow(r8, "in_app_event_time");     // Catch: Throwable -> L80
        int r21 = r20;
        ArrayList r22 = new ArrayList(r8.getCount());     // Catch: Throwable -> L80
    L14:
        if (r8.moveToNext() == false) goto L78;
        long r23 = r8.getLong(r0);     // Catch: Throwable -> L80
        if (r8.isNull(r9) == false) goto L19;
        String r24 = null;
    L21:
        if (r8.isNull(r10) == false) goto L23;
        String r25 = null;
    L25:
        if (r8.isNull(r11) == false) goto L27;
        String r26 = null;
    L29:
        if (r8.isNull(r12) == false) goto L31;
        String r27 = null;
    L33:
        if (r8.isNull(r13) == false) goto L35;
        String r28 = null;
    L37:
        if (r8.isNull(r14) == false) goto L39;
        String r29 = null;
    L41:
        if (r8.isNull(r15) == false) goto L43;
        String r30 = null;
    L45:
        if (r8.isNull(r16) == false) goto L47;
        String r31 = null;
    L48:
        int r32 = r8.getInt(r17);     // Catch: Throwable -> L80
        if (r8.isNull(r18) == false) goto L51;
        String r33 = null;
    L53:
        if (r8.isNull(r19) == false) goto L55;
        String r34 = null;
    L57:
        if (r8.isNull(r110) == false) goto L59;
        String r35 = null;
    L60:
        int r36 = r8.getInt(r21);     // Catch: Throwable -> L80
        int r210 = r0;
        r111 = r111;
        if (r8.isNull(r111) == false) goto L63;
        String r37 = null;
    L65:
        if (r8.isNull(r112) == false) goto L67;
        String r38 = null;
    L69:
        if (r8.isNull(r113) == false) goto L71;
        String r39 = null;
    L73:
        if (r8.isNull(r114) == false) goto L75;
        Long r40 = null;
    L76:
        r22.add(new es(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40));     // Catch: Throwable -> L80
        r0 = r210;
        r21 = r21;
        goto L14
    L75:
        r40 = Long.valueOf(r8.getLong(r114));     // Catch: Throwable -> L80
        goto L76
    L71:
        r39 = r8.getString(r113);     // Catch: Throwable -> L80
        goto L73
    L67:
        r38 = r8.getString(r112);     // Catch: Throwable -> L80
        goto L69
    L63:
        r37 = r8.getString(r111);     // Catch: Throwable -> L80
        goto L65
    L59:
        r35 = r8.getString(r110);     // Catch: Throwable -> L80
        goto L60
    L55:
        r34 = r8.getString(r19);     // Catch: Throwable -> L80
        goto L57
    L51:
        r33 = r8.getString(r18);     // Catch: Throwable -> L80
        goto L53
    L47:
        r31 = r8.getString(r16);     // Catch: Throwable -> L80
        goto L48
    L43:
        r30 = r8.getString(r15);     // Catch: Throwable -> L80
        goto L45
    L39:
        r29 = r8.getString(r14);     // Catch: Throwable -> L80
        goto L41
    L35:
        r28 = r8.getString(r13);     // Catch: Throwable -> L80
        goto L37
    L31:
        r27 = r8.getString(r12);     // Catch: Throwable -> L80
        goto L33
    L27:
        r26 = r8.getString(r11);     // Catch: Throwable -> L80
        goto L29
    L23:
        r25 = r8.getString(r10);     // Catch: Throwable -> L80
        goto L25
    L19:
        r24 = r8.getString(r9);     // Catch: Throwable -> L80
        goto L21
    L78:
        r8.close();
        r44.release();
        return r22;
    L80:
        th = th;
    L84:
        r8.close();
        r44.release();
        throw th;
    L82:
        th = th;
        r44 = r5;
        goto L84
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public es queryById(long r1) {
        return ProactiveEpisodicRelevantDataDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ es queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<es> queryByIds(List<Long> r3) {
        return ProactiveEpisodicRelevantDataDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public es queryByUUID(String r1) {
        return ProactiveEpisodicRelevantDataDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ es queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.ProactiveEpisodicRelevantDataDao
    public Integer queryDetailStatusByEpisodicId(String r4) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT detail_status FROM ProactiveEpisodicRelevantData WHERE episodic_id = ? LIMIT 1", 1);
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Integer r1 = null;
        Cursor r3 = DBUtil.query(this.__db, r0, false, null);
    L15:
        th = move-exception;
        r3.close();
        r0.release();
        throw th;
    L8:
        if (r3.moveToFirst() == true) goto L10;
    L13:
        r3.close();
        r0.release();
        return r1;
    L10:
        if (r3.isNull(0) == true) goto L13;
        r1 = Integer.valueOf(r3.getInt(0));     // Catch: Throwable -> L15
        goto L13
    L5:
        r0.bindString(1, r4);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.ProactiveEpisodicRelevantDataDao
    public es queryLatestBySourceLink(String r41) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM ProactiveEpisodicRelevantData WHERE source_link = ? ORDER BY id DESC LIMIT 1", 1);
        if (r41 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L78
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "episodic_id");     // Catch: Throwable -> L78
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "source_query");     // Catch: Throwable -> L78
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "source_text");     // Catch: Throwable -> L78
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "source_link");     // Catch: Throwable -> L78
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "source_link_type");     // Catch: Throwable -> L78
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "screenshot");     // Catch: Throwable -> L78
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "source_package_name");     // Catch: Throwable -> L78
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "source_app_name");     // Catch: Throwable -> L78
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "product_type");     // Catch: Throwable -> L78
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, EventBody.KEY_CATEGORY);     // Catch: Throwable -> L78
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "tag_list");     // Catch: Throwable -> L78
        int r15 = CursorUtil.getColumnIndexOrThrow(r1, "summary");     // Catch: Throwable -> L78
        int r3 = CursorUtil.getColumnIndexOrThrow(r1, "detail_status");     // Catch: Throwable -> L78
        RoomSQLiteQuery r16 = r2;
        int r17 = CursorUtil.getColumnIndexOrThrow(r1, "in_app_object_id");     // Catch: Throwable -> L76
        int r18 = CursorUtil.getColumnIndexOrThrow(r1, "in_app_rule_family");     // Catch: Throwable -> L76
        int r19 = CursorUtil.getColumnIndexOrThrow(r1, "in_app_activity_name");     // Catch: Throwable -> L76
        int r20 = CursorUtil.getColumnIndexOrThrow(r1, "in_app_event_time");     // Catch: Throwable -> L76
        if (r1.moveToFirst() == false) goto L73;
        long r21 = r1.getLong(r0);     // Catch: Throwable -> L76
        if (r1.isNull(r4) == false) goto L14;
        String r23 = null;
    L16:
        if (r1.isNull(r5) == false) goto L18;
        String r24 = null;
    L20:
        if (r1.isNull(r6) == false) goto L22;
        String r25 = null;
    L24:
        if (r1.isNull(r7) == false) goto L26;
        String r26 = null;
    L28:
        if (r1.isNull(r8) == false) goto L30;
        String r27 = null;
    L32:
        if (r1.isNull(r9) == false) goto L34;
        String r28 = null;
    L36:
        if (r1.isNull(r10) == false) goto L38;
        String r29 = null;
    L40:
        if (r1.isNull(r11) == false) goto L42;
        String r30 = null;
    L43:
        int r31 = r1.getInt(r12);     // Catch: Throwable -> L76
        if (r1.isNull(r13) == false) goto L46;
        String r32 = null;
    L48:
        if (r1.isNull(r14) == false) goto L50;
        String r33 = null;
    L52:
        if (r1.isNull(r15) == false) goto L54;
        String r34 = null;
    L55:
        int r35 = r1.getInt(r3);     // Catch: Throwable -> L76
        if (r1.isNull(r17) == false) goto L58;
        String r36 = null;
    L60:
        if (r1.isNull(r17) == false) goto L62;
        String r37 = null;
    L64:
        if (r1.isNull(r18) == false) goto L66;
        String r38 = null;
    L68:
        if (r1.isNull(r20) == false) goto L70;
        Long r39 = null;
    L71:
        es r22 = new es(r21, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39);     // Catch: Throwable -> L76
    L74:
        r1.close();
        r16.release();
        return r22;
    L70:
        r39 = Long.valueOf(r1.getLong(r20));     // Catch: Throwable -> L76
        goto L71
    L66:
        r38 = r1.getString(r19);     // Catch: Throwable -> L76
        goto L68
    L62:
        r37 = r1.getString(r18);     // Catch: Throwable -> L76
        goto L64
    L58:
        r36 = r1.getString(r17);     // Catch: Throwable -> L76
        goto L60
    L54:
        r34 = r1.getString(r15);     // Catch: Throwable -> L76
        goto L55
    L50:
        r33 = r1.getString(r14);     // Catch: Throwable -> L76
        goto L52
    L46:
        r32 = r1.getString(r13);     // Catch: Throwable -> L76
        goto L48
    L42:
        r30 = r1.getString(r11);     // Catch: Throwable -> L76
        goto L43
    L38:
        r29 = r1.getString(r10);     // Catch: Throwable -> L76
        goto L40
    L34:
        r28 = r1.getString(r9);     // Catch: Throwable -> L76
        goto L36
    L30:
        r27 = r1.getString(r8);     // Catch: Throwable -> L76
        goto L32
    L26:
        r26 = r1.getString(r7);     // Catch: Throwable -> L76
        goto L28
    L22:
        r25 = r1.getString(r6);     // Catch: Throwable -> L76
        goto L24
    L18:
        r24 = r1.getString(r5);     // Catch: Throwable -> L76
        goto L20
    L14:
        r23 = r1.getString(r4);     // Catch: Throwable -> L76
        goto L16
    L73:
        r22 = null;
    L76:
        th = th;
    L80:
        r1.close();
        r16.release();
        throw th;
    L78:
        th = th;
        r16 = r2;
        goto L80
    L5:
        r2.bindString(1, r41);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.ProactiveEpisodicRelevantDataDao
    public es queryLatestRecentInApp(String r39, String r40, String r41, long r42, long r44) {
        RoomSQLiteQuery r4 = RoomSQLiteQuery.acquire("SELECT * FROM ProactiveEpisodicRelevantData WHERE source_package_name = ? AND in_app_activity_name = ? AND in_app_rule_family = ? AND in_app_event_time BETWEEN ? AND ? ORDER BY in_app_event_time DESC, id DESC LIMIT 1", 5);
        if (r39 != null) goto L5;
        r4.bindNull(1);
    L7:
        if (r40 != null) goto L9;
        r4.bindNull(2);
    L11:
        if (r41 != null) goto L13;
        r4.bindNull(3);
    L14:
        r4.bindLong(4, r42);
        r4.bindLong(5, r44);
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r4, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L86
        int r3 = CursorUtil.getColumnIndexOrThrow(r1, "episodic_id");     // Catch: Throwable -> L86
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "source_query");     // Catch: Throwable -> L86
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "source_text");     // Catch: Throwable -> L86
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "source_link");     // Catch: Throwable -> L86
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "source_link_type");     // Catch: Throwable -> L86
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "screenshot");     // Catch: Throwable -> L86
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "source_package_name");     // Catch: Throwable -> L86
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "source_app_name");     // Catch: Throwable -> L86
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "product_type");     // Catch: Throwable -> L86
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, EventBody.KEY_CATEGORY);     // Catch: Throwable -> L86
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "tag_list");     // Catch: Throwable -> L86
        int r15 = CursorUtil.getColumnIndexOrThrow(r1, "summary");     // Catch: Throwable -> L86
        int r2 = CursorUtil.getColumnIndexOrThrow(r1, "detail_status");     // Catch: Throwable -> L86
        RoomSQLiteQuery r16 = r4;
        int r17 = CursorUtil.getColumnIndexOrThrow(r1, "in_app_object_id");     // Catch: Throwable -> L84
        int r18 = CursorUtil.getColumnIndexOrThrow(r1, "in_app_rule_family");     // Catch: Throwable -> L84
        int r19 = CursorUtil.getColumnIndexOrThrow(r1, "in_app_activity_name");     // Catch: Throwable -> L84
        int r20 = CursorUtil.getColumnIndexOrThrow(r1, "in_app_event_time");     // Catch: Throwable -> L84
        if (r1.moveToFirst() == false) goto L81;
        long r110 = r1.getLong(r0);     // Catch: Throwable -> L84
        if (r1.isNull(r3) == false) goto L22;
        String r21 = null;
    L24:
        if (r1.isNull(r5) == false) goto L26;
        String r22 = null;
    L28:
        if (r1.isNull(r6) == false) goto L30;
        String r23 = null;
    L32:
        if (r1.isNull(r7) == false) goto L34;
        String r24 = null;
    L36:
        if (r1.isNull(r8) == false) goto L38;
        String r25 = null;
    L40:
        if (r1.isNull(r9) == false) goto L42;
        String r26 = null;
    L44:
        if (r1.isNull(r10) == false) goto L46;
        String r27 = null;
    L48:
        if (r1.isNull(r11) == false) goto L50;
        String r28 = null;
    L51:
        int r29 = r1.getInt(r12);     // Catch: Throwable -> L84
        if (r1.isNull(r13) == false) goto L54;
        String r30 = null;
    L56:
        if (r1.isNull(r14) == false) goto L58;
        String r31 = null;
    L60:
        if (r1.isNull(r15) == false) goto L62;
        String r32 = null;
    L63:
        int r33 = r1.getInt(r2);     // Catch: Throwable -> L84
        if (r1.isNull(r17) == false) goto L66;
        String r34 = null;
    L68:
        if (r1.isNull(r40) == false) goto L70;
        String r35 = null;
    L72:
        if (r1.isNull(r41) == false) goto L74;
        String r36 = null;
    L76:
        if (r1.isNull(r20) == false) goto L78;
        Long r37 = null;
    L79:
        es r38 = new es(r110, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37);     // Catch: Throwable -> L84
    L82:
        r1.close();
        r16.release();
        return r38;
    L78:
        r37 = Long.valueOf(r1.getLong(r20));     // Catch: Throwable -> L84
        goto L79
    L74:
        r36 = r1.getString(r19);     // Catch: Throwable -> L84
        goto L76
    L70:
        r35 = r1.getString(r18);     // Catch: Throwable -> L84
        goto L72
    L66:
        r34 = r1.getString(r17);     // Catch: Throwable -> L84
        goto L68
    L62:
        r32 = r1.getString(r15);     // Catch: Throwable -> L84
        goto L63
    L58:
        r31 = r1.getString(r14);     // Catch: Throwable -> L84
        goto L60
    L54:
        r30 = r1.getString(r13);     // Catch: Throwable -> L84
        goto L56
    L50:
        r28 = r1.getString(r11);     // Catch: Throwable -> L84
        goto L51
    L46:
        r27 = r1.getString(r10);     // Catch: Throwable -> L84
        goto L48
    L42:
        r26 = r1.getString(r9);     // Catch: Throwable -> L84
        goto L44
    L38:
        r25 = r1.getString(r8);     // Catch: Throwable -> L84
        goto L40
    L34:
        r24 = r1.getString(r7);     // Catch: Throwable -> L84
        goto L36
    L30:
        r23 = r1.getString(r6);     // Catch: Throwable -> L84
        goto L32
    L26:
        r22 = r1.getString(r5);     // Catch: Throwable -> L84
        goto L28
    L22:
        r21 = r1.getString(r3);     // Catch: Throwable -> L84
        goto L24
    L81:
        r38 = null;
    L84:
        th = th;
    L88:
        r1.close();
        r16.release();
        throw th;
    L86:
        th = th;
        r16 = r4;
        goto L88
    L13:
        r4.bindString(3, r41);
        goto L14
    L9:
        r4.bindString(2, r40);
        goto L11
    L5:
        r4.bindString(1, r39);
        goto L7
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public es queryOne() {
        return ProactiveEpisodicRelevantDataDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ es queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<es> queryWithLimitAndOffset(int r1, int r2) {
        return ProactiveEpisodicRelevantDataDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<es> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityProactiveEpisodicRelevantData(r6));     // Catch: Throwable -> L10
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
    public int update2(es r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfProactiveEpisodicRelevantData.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(es r3) {
        return update2((es) ZeusTransformUtils.preCheckCast(r3, es.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<es> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfProactiveEpisodicRelevantData.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.ProactiveEpisodicRelevantDataDao
    public int updateDetailStatusByEpisodicId(String r4, int r5) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfUpdateDetailStatusByEpisodicId.acquire();
        r0.bindLong(1, r5);
        if (r4 != null) goto L5;
        r0.bindNull(2);
    L6:
        this.__db.beginTransaction();
        int r6 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateDetailStatusByEpisodicId.release(r0);
        return r6;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateDetailStatusByEpisodicId.release(r0);
        throw th;
    L5:
        r0.bindString(2, r4);
        goto L6
    }
}
