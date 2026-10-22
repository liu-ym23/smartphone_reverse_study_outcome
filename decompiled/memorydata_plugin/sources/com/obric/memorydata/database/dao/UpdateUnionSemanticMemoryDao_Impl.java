package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.entity.iz;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
public final class UpdateUnionSemanticMemoryDao_Impl implements UpdateUnionSemanticMemoryDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<iz> __deletionAdapterOfUpdateUnionSemanticMemoryEntity;
    private final EntityInsertionAdapter<iz> __insertionAdapterOfUpdateUnionSemanticMemoryEntity;
    private final EntityInsertionAdapter<iz> __insertionAdapterOfUpdateUnionSemanticMemoryEntity_1;
    private final EntityDeletionOrUpdateAdapter<iz> __updateAdapterOfUpdateUnionSemanticMemoryEntity;

    public UpdateUnionSemanticMemoryDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfUpdateUnionSemanticMemoryEntity = new AnonymousClass1(this, r2);
        this.__insertionAdapterOfUpdateUnionSemanticMemoryEntity_1 = new AnonymousClass2(this, r2);
        this.__deletionAdapterOfUpdateUnionSemanticMemoryEntity = new AnonymousClass3(this, r2);
        this.__updateAdapterOfUpdateUnionSemanticMemoryEntity = new AnonymousClass4(this, r2);
    }

    private iz __entityCursorConverter_comObricMemorydataDatabaseEntityUpdateUnionSemanticMemoryEntity(Cursor r59) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r59, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "entityId");
        int r3 = CursorUtil.getColumnIndex(r0, "createTime");
        int r4 = CursorUtil.getColumnIndex(r0, "modifyTime");
        int r5 = CursorUtil.getColumnIndex(r0, "type");
        int r6 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r7 = CursorUtil.getColumnIndex(r0, ObricMemoryConstants.KEY_PACKAGE_NAME);
        int r8 = CursorUtil.getColumnIndex(r0, "hashCodeValue");
        int r9 = CursorUtil.getColumnIndex(r0, Api.KEY_UUID);
        int r10 = CursorUtil.getColumnIndex(r0, "semantic_type");
        int r11 = CursorUtil.getColumnIndex(r0, "tag_path");
        int r12 = CursorUtil.getColumnIndex(r0, "key_phrase");
        int r13 = CursorUtil.getColumnIndex(r0, "description");
        int r14 = CursorUtil.getColumnIndex(r0, "embedding_content");
        int r15 = CursorUtil.getColumnIndex(r0, "sources");
        int r16 = CursorUtil.getColumnIndex(r0, "user_edit");
        int r17 = CursorUtil.getColumnIndex(r0, "evidence_count");
        int r18 = CursorUtil.getColumnIndex(r0, "product_type");
        int r19 = CursorUtil.getColumnIndex(r0, "use_for_insight");
        int r110 = CursorUtil.getColumnIndex(r0, "confidence");
        int r111 = CursorUtil.getColumnIndex(r0, "updateResult");
        int r112 = CursorUtil.getColumnIndex(r0, "isUpdated");
        int r113 = CursorUtil.getColumnIndex(r0, "retryTime");
        int r114 = CursorUtil.getColumnIndex(r0, "lastExecuteUpdateTimestamp");
        long r23 = 0;
        if (r1 != (-1)) goto L5;
        long r29 = 0;
    L6:
        String r20 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r31 = null;
    L13:
        if (r3 != (-1)) goto L15;
        long r32 = 0;
    L16:
        if (r4 != (-1)) goto L18;
        long r34 = 0;
    L20:
        if (r5 != (-1)) goto L22;
        int r36 = 0;
    L23:
        if (r6 != (-1)) goto L25;
        long r37 = 0;
    L26:
        if (r7 != (-1)) goto L29;
    L27:
        String r39 = null;
    L32:
        if (r8 != (-1)) goto L34;
        int r40 = 0;
    L35:
        if (r9 != (-1)) goto L38;
    L36:
        String r41 = null;
    L41:
        if (r10 != (-1)) goto L44;
    L42:
        String r42 = null;
    L47:
        if (r11 != (-1)) goto L50;
    L48:
        String r43 = null;
    L53:
        if (r12 != (-1)) goto L56;
    L54:
        String r44 = null;
    L59:
        if (r13 != (-1)) goto L62;
    L60:
        String r45 = null;
    L65:
        if (r14 != (-1)) goto L68;
    L66:
        String r46 = null;
    L71:
        if (r58 != (-1)) goto L74;
    L72:
        String r47 = null;
    L77:
        boolean r21 = true;
        if (r16 != (-1)) goto L82;
        boolean r48 = false;
    L86:
        if (r17 != (-1)) goto L88;
        int r49 = 0;
    L90:
        if (r18 != (-1)) goto L92;
        int r50 = 0;
    L94:
        if (r19 != (-1)) goto L98;
        boolean r51 = false;
    L102:
        if (r110 != (-1)) goto L104;
        float r22 = 0.0f;
    L105:
        float r52 = r22;
        if (r111 != (-1)) goto L109;
    L107:
        String r53 = r20;
        if (r112 != (-1)) goto L116;
        boolean r54 = false;
    L120:
        if (r113 != (-1)) goto L122;
        int r55 = 0;
    L124:
        if (r114 == (-1)) goto L128;
        r23 = r0.getLong(r114);
    L128:
        return new iz(r29, r31, r32, r34, r36, r37, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r23);
    L122:
        r55 = r0.getInt(r113);
        goto L124
    L116:
        if (r0.getInt(r112) != 0) goto L119;
        r21 = false;
    L119:
        r54 = r21;
        goto L120
    L109:
        if (r0.isNull(r111) == true) goto L107;
        r20 = r0.getString(r111);
        goto L107
    L104:
        r22 = r0.getFloat(r110);
        goto L105
    L98:
        if (r0.getInt(r19) == 0) goto L100;
        boolean r24 = true;
    L101:
        r51 = r24;
        goto L102
    L100:
        r24 = false;
        goto L101
    L92:
        r50 = r0.getInt(r18);
        goto L94
    L88:
        r49 = r0.getInt(r17);
        goto L90
    L82:
        if (r0.getInt(r16) == 0) goto L84;
        boolean r25 = true;
    L85:
        r48 = r25;
        goto L86
    L84:
        r25 = false;
        goto L85
    L74:
        if (r0.isNull(r58) == true) goto L72;
        r47 = r0.getString(r15);
        goto L77
    L68:
        if (r0.isNull(r14) == true) goto L66;
        r46 = r0.getString(r14);
        goto L71
    L62:
        if (r0.isNull(r13) == true) goto L60;
        r45 = r0.getString(r13);
        goto L65
    L56:
        if (r0.isNull(r12) == true) goto L54;
        r44 = r0.getString(r12);
        goto L59
    L50:
        if (r0.isNull(r11) == true) goto L48;
        r43 = r0.getString(r11);
        goto L53
    L44:
        if (r0.isNull(r10) == true) goto L42;
        r42 = r0.getString(r10);
        goto L47
    L38:
        if (r0.isNull(r9) == true) goto L36;
        r41 = r0.getString(r9);
        goto L41
    L34:
        r40 = r0.getInt(r8);
        goto L35
    L29:
        if (r0.isNull(r7) == true) goto L27;
        r39 = r0.getString(r7);
        goto L32
    L25:
        r37 = r0.getLong(r6);
        goto L26
    L22:
        r36 = r0.getInt(r5);
        goto L23
    L18:
        r34 = r0.getLong(r4);
        goto L20
    L15:
        r32 = r0.getLong(r3);
        goto L16
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r31 = r0.getString(r2);
        goto L13
    L5:
        r29 = r0.getLong(r1);
        goto L6
    }

    static /* synthetic */ RoomDatabase access$000(UpdateUnionSemanticMemoryDao_Impl r0) {
        return r0.__db;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<iz> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfUpdateUnionSemanticMemoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<iz> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfUpdateUnionSemanticMemoryEntity_1.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.UpdateUnionSemanticMemoryDao
    public int countNotUpdatedByEntityIds(List<String> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT COUNT(1) FROM UpdateUnionSemanticMemory WHERE isUpdated = 0 AND entityId IN (");
        int r2 = r8.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(")");
        int r3 = 0;
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), r2 + 0);
        Iterator r9 = r8.iterator();
        int r4 = 1;
    L4:
        if (r9.hasNext() == false) goto L10;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L8;
        r1.bindNull(r4);
    L9:
        r4 = r4 + 1;
        goto L4
    L8:
        r1.bindString(r4, r5);
        goto L9
    L10:
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r1, false, null);
    L16:
        th = move-exception;
        r6.close();
        r1.release();
        throw th;
    L12:
        if (r6.moveToFirst() == false) goto L14;
        r3 = r6.getInt(0);     // Catch: Throwable -> L16
    L14:
        r6.close();
        r1.release();
        return r3;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(iz r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfUpdateUnionSemanticMemoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(iz r3) {
        return delete2((iz) ZeusTransformUtils.preCheckCast(r3, iz.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return UpdateUnionSemanticMemoryDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.UpdateUnionSemanticMemoryDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return UpdateUnionSemanticMemoryDao.DefaultImpls.getTableName(this);
    }

    @Override // com.obric.memorydata.database.dao.UpdateUnionSemanticMemoryDao
    public boolean hasNotUpdatedData() {
        boolean r1 = false;
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT 1 FROM UpdateUnionSemanticMemory WHERE isUpdated = 0 LIMIT 1)", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r3 = DBUtil.query(this.__db, r0, false, null);
    L10:
        th = move-exception;
        r3.close();
        r0.release();
        throw th;
    L4:
        if (r3.moveToFirst() == false) goto L8;
        if (r3.getInt(0) == 0) goto L8;
        r1 = true;
    L8:
        r3.close();
        r0.release();
        return r1;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.UpdateUnionSemanticMemoryDao
    public long insert(iz r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfUpdateUnionSemanticMemoryEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(iz r3) {
        return insert((iz) ZeusTransformUtils.preCheckCast(r3, iz.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.UpdateUnionSemanticMemoryDao, com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<iz> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfUpdateUnionSemanticMemoryEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.UpdateUnionSemanticMemoryDao
    public i<Boolean> observeHasNotUpdatedData() {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT 1 FROM UpdateUnionSemanticMemory WHERE isUpdated = 0 LIMIT 1)", 0);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"UpdateUnionSemanticMemory"}, new AnonymousClass5(this, r0));
    }

    @Override // com.obric.memorydata.database.dao.UpdateUnionSemanticMemoryDao, com.obric.memorydata.database.dao.BaseDao
    public List<iz> queryAll() {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM UpdateUnionSemanticMemory", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r4, OaidModel.KEY_ID);     // Catch: Throwable -> L68
        int r5 = CursorUtil.getColumnIndexOrThrow(r4, "entityId");     // Catch: Throwable -> L68
        int r6 = CursorUtil.getColumnIndexOrThrow(r4, "createTime");     // Catch: Throwable -> L68
        int r7 = CursorUtil.getColumnIndexOrThrow(r4, "modifyTime");     // Catch: Throwable -> L68
        int r8 = CursorUtil.getColumnIndexOrThrow(r4, "type");     // Catch: Throwable -> L68
        int r9 = CursorUtil.getColumnIndexOrThrow(r4, "timestamp");     // Catch: Throwable -> L68
        int r10 = CursorUtil.getColumnIndexOrThrow(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L68
        int r11 = CursorUtil.getColumnIndexOrThrow(r4, "hashCodeValue");     // Catch: Throwable -> L68
        int r12 = CursorUtil.getColumnIndexOrThrow(r4, Api.KEY_UUID);     // Catch: Throwable -> L68
        int r13 = CursorUtil.getColumnIndexOrThrow(r4, "semantic_type");     // Catch: Throwable -> L68
        int r14 = CursorUtil.getColumnIndexOrThrow(r4, "tag_path");     // Catch: Throwable -> L68
        int r15 = CursorUtil.getColumnIndexOrThrow(r4, "key_phrase");     // Catch: Throwable -> L68
        int r2 = CursorUtil.getColumnIndexOrThrow(r4, "description");     // Catch: Throwable -> L68
        int r3 = CursorUtil.getColumnIndexOrThrow(r4, "embedding_content");     // Catch: Throwable -> L68
        RoomSQLiteQuery r16 = r1;
        int r17 = CursorUtil.getColumnIndexOrThrow(r4, "sources");     // Catch: Throwable -> L66
        int r18 = CursorUtil.getColumnIndexOrThrow(r4, "user_edit");     // Catch: Throwable -> L66
        int r19 = CursorUtil.getColumnIndexOrThrow(r4, "evidence_count");     // Catch: Throwable -> L66
        int r20 = CursorUtil.getColumnIndexOrThrow(r4, "product_type");     // Catch: Throwable -> L66
        int r21 = CursorUtil.getColumnIndexOrThrow(r4, "use_for_insight");     // Catch: Throwable -> L66
        int r22 = CursorUtil.getColumnIndexOrThrow(r4, "confidence");     // Catch: Throwable -> L66
        int r23 = CursorUtil.getColumnIndexOrThrow(r4, "updateResult");     // Catch: Throwable -> L66
        int r24 = CursorUtil.getColumnIndexOrThrow(r4, "isUpdated");     // Catch: Throwable -> L66
        int r25 = CursorUtil.getColumnIndexOrThrow(r4, "retryTime");     // Catch: Throwable -> L66
        int r26 = CursorUtil.getColumnIndexOrThrow(r4, "lastExecuteUpdateTimestamp");     // Catch: Throwable -> L66
        int r27 = r3;
        ArrayList r28 = new ArrayList(r4.getCount());     // Catch: Throwable -> L66
    L6:
        if (r4.moveToNext() == false) goto L64;
        long r29 = r4.getLong(r0);     // Catch: Throwable -> L66
        if (r4.isNull(r5) == false) goto L11;
        String r31 = null;
    L12:
        long r32 = r4.getLong(r6);     // Catch: Throwable -> L66
        long r34 = r4.getLong(r7);     // Catch: Throwable -> L66
        int r36 = r4.getInt(r8);     // Catch: Throwable -> L66
        long r37 = r4.getLong(r9);     // Catch: Throwable -> L66
        if (r4.isNull(r10) == false) goto L15;
        String r39 = null;
    L16:
        int r40 = r4.getInt(r11);     // Catch: Throwable -> L66
        if (r4.isNull(r12) == false) goto L19;
        String r41 = null;
    L21:
        if (r4.isNull(r13) == false) goto L23;
        String r42 = null;
    L25:
        if (r4.isNull(r14) == false) goto L27;
        String r43 = null;
    L29:
        if (r4.isNull(r15) == false) goto L31;
        String r44 = null;
    L33:
        if (r4.isNull(r2) == false) goto L35;
        String r45 = null;
    L37:
        if (r4.isNull(r27) == false) goto L40;
        String r46 = null;
    L39:
        int r58 = r17;
        int r110 = r0;
        if (r4.isNull(r58) == false) goto L45;
        String r47 = null;
    L44:
        int r59 = r18;
        if (r4.getInt(r59) == 0) goto L49;
        boolean r48 = true;
    L50:
        int r510 = r19;
        int r49 = r4.getInt(r510);     // Catch: Throwable -> L66
        int r30 = r20;
        int r50 = r4.getInt(r30);     // Catch: Throwable -> L66
        r20 = r30;
        r21 = r21;
        if (r4.getInt(r21) == 0) goto L53;
        boolean r51 = true;
    L54:
        float r52 = r4.getFloat(r22);     // Catch: Throwable -> L66
        r22 = r22;
        r23 = r23;
        if (r4.isNull(r23) == false) goto L57;
        String r53 = null;
    L59:
        if (r4.getInt(r24) == 0) goto L61;
        boolean r54 = true;
    L62:
        int r55 = r4.getInt(r25);     // Catch: Throwable -> L66
        r25 = r25;
        int r33 = r26;
        r26 = r33;
        r28.add(new iz(r29, r31, r32, r34, r36, r37, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r4.getLong(r33)));     // Catch: Throwable -> L66
        r0 = r110;
        r17 = r58;
        r18 = r59;
        r19 = r510;
        r27 = r27;
        goto L6
    L61:
        r54 = false;
        goto L62
    L57:
        r53 = r4.getString(r23);     // Catch: Throwable -> L66
        goto L59
    L53:
        r51 = false;
        goto L54
    L49:
        r48 = false;
        goto L50
    L45:
        r47 = r4.getString(r58);     // Catch: Throwable -> L66
        goto L44
    L40:
        r46 = r4.getString(r27);     // Catch: Throwable -> L66
        goto L39
    L35:
        r45 = r4.getString(r2);     // Catch: Throwable -> L66
        goto L37
    L31:
        r44 = r4.getString(r15);     // Catch: Throwable -> L66
        goto L33
    L27:
        r43 = r4.getString(r14);     // Catch: Throwable -> L66
        goto L29
    L23:
        r42 = r4.getString(r13);     // Catch: Throwable -> L66
        goto L25
    L19:
        r41 = r4.getString(r12);     // Catch: Throwable -> L66
        goto L21
    L15:
        r39 = r4.getString(r10);     // Catch: Throwable -> L66
        goto L16
    L11:
        r31 = r4.getString(r5);     // Catch: Throwable -> L66
        goto L12
    L64:
        r4.close();
        r16.release();
        return r28;
    L66:
        th = th;
    L70:
        r4.close();
        r16.release();
        throw th;
    L68:
        th = th;
        r16 = r1;
        goto L70
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return UpdateUnionSemanticMemoryDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.UpdateUnionSemanticMemoryDao
    public iz queryByEntityId(String r58) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM UpdateUnionSemanticMemory WHERE entityId = ? LIMIT 1", 1);
        if (r58 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L70
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "entityId");     // Catch: Throwable -> L70
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "createTime");     // Catch: Throwable -> L70
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "modifyTime");     // Catch: Throwable -> L70
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "type");     // Catch: Throwable -> L70
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "timestamp");     // Catch: Throwable -> L70
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L70
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "hashCodeValue");     // Catch: Throwable -> L70
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, Api.KEY_UUID);     // Catch: Throwable -> L70
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "semantic_type");     // Catch: Throwable -> L70
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, "tag_path");     // Catch: Throwable -> L70
        int r1 = CursorUtil.getColumnIndexOrThrow(r5, "key_phrase");     // Catch: Throwable -> L70
        int r3 = CursorUtil.getColumnIndexOrThrow(r5, "description");     // Catch: Throwable -> L70
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, "embedding_content");     // Catch: Throwable -> L70
        RoomSQLiteQuery r16 = r2;
        int r17 = CursorUtil.getColumnIndexOrThrow(r5, "sources");     // Catch: Throwable -> L68
        int r18 = CursorUtil.getColumnIndexOrThrow(r5, "user_edit");     // Catch: Throwable -> L68
        int r19 = CursorUtil.getColumnIndexOrThrow(r5, "evidence_count");     // Catch: Throwable -> L68
        int r20 = CursorUtil.getColumnIndexOrThrow(r5, "product_type");     // Catch: Throwable -> L68
        int r21 = CursorUtil.getColumnIndexOrThrow(r5, "use_for_insight");     // Catch: Throwable -> L68
        int r22 = CursorUtil.getColumnIndexOrThrow(r5, "confidence");     // Catch: Throwable -> L68
        int r23 = CursorUtil.getColumnIndexOrThrow(r5, "updateResult");     // Catch: Throwable -> L68
        int r24 = CursorUtil.getColumnIndexOrThrow(r5, "isUpdated");     // Catch: Throwable -> L68
        int r25 = CursorUtil.getColumnIndexOrThrow(r5, "retryTime");     // Catch: Throwable -> L68
        int r26 = CursorUtil.getColumnIndexOrThrow(r5, "lastExecuteUpdateTimestamp");     // Catch: Throwable -> L68
        if (r5.moveToFirst() == false) goto L65;
        long r28 = r5.getLong(r0);     // Catch: Throwable -> L68
        if (r5.isNull(r6) == false) goto L14;
        String r30 = null;
    L15:
        long r31 = r5.getLong(r7);     // Catch: Throwable -> L68
        long r33 = r5.getLong(r8);     // Catch: Throwable -> L68
        int r35 = r5.getInt(r9);     // Catch: Throwable -> L68
        long r36 = r5.getLong(r10);     // Catch: Throwable -> L68
        if (r5.isNull(r11) == false) goto L18;
        String r38 = null;
    L19:
        int r39 = r5.getInt(r12);     // Catch: Throwable -> L68
        if (r5.isNull(r13) == false) goto L22;
        String r40 = null;
    L24:
        if (r5.isNull(r14) == false) goto L26;
        String r41 = null;
    L28:
        if (r5.isNull(r15) == false) goto L30;
        String r42 = null;
    L32:
        if (r5.isNull(r1) == false) goto L34;
        String r43 = null;
    L36:
        if (r5.isNull(r3) == false) goto L38;
        String r44 = null;
    L40:
        if (r5.isNull(r4) == false) goto L42;
        String r45 = null;
    L44:
        if (r5.isNull(r17) == false) goto L46;
        String r46 = null;
    L48:
        if (r5.getInt(r18) == 0) goto L50;
        boolean r47 = true;
    L51:
        int r48 = r5.getInt(r19);     // Catch: Throwable -> L68
        int r49 = r5.getInt(r20);     // Catch: Throwable -> L68
        if (r5.getInt(r21) == 0) goto L54;
        boolean r50 = true;
    L55:
        float r51 = r5.getFloat(r22);     // Catch: Throwable -> L68
        if (r5.isNull(r23) == false) goto L58;
        String r52 = null;
    L60:
        if (r5.getInt(r24) == 0) goto L62;
        boolean r53 = true;
    L63:
        iz r27 = new iz(r28, r30, r31, r33, r35, r36, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r5.getInt(r25), r5.getLong(r26));     // Catch: Throwable -> L68
    L66:
        r5.close();
        r16.release();
        return r27;
    L62:
        r53 = false;
        goto L63
    L58:
        r52 = r5.getString(r23);     // Catch: Throwable -> L68
        goto L60
    L54:
        r50 = false;
        goto L55
    L50:
        r47 = false;
        goto L51
    L46:
        r46 = r5.getString(r17);     // Catch: Throwable -> L68
        goto L48
    L42:
        r45 = r5.getString(r4);     // Catch: Throwable -> L68
        goto L44
    L38:
        r44 = r5.getString(r3);     // Catch: Throwable -> L68
        goto L40
    L34:
        r43 = r5.getString(r1);     // Catch: Throwable -> L68
        goto L36
    L30:
        r42 = r5.getString(r15);     // Catch: Throwable -> L68
        goto L32
    L26:
        r41 = r5.getString(r14);     // Catch: Throwable -> L68
        goto L28
    L22:
        r40 = r5.getString(r13);     // Catch: Throwable -> L68
        goto L24
    L18:
        r38 = r5.getString(r11);     // Catch: Throwable -> L68
        goto L19
    L14:
        r30 = r5.getString(r6);     // Catch: Throwable -> L68
        goto L15
    L65:
        r27 = null;
    L68:
        th = th;
    L72:
        r5.close();
        r16.release();
        throw th;
    L70:
        th = th;
        r16 = r2;
        goto L72
    L5:
        r2.bindString(1, r58);
        goto L6
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public iz queryById(long r1) {
        return UpdateUnionSemanticMemoryDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ iz queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<iz> queryByIds(List<Long> r3) {
        return UpdateUnionSemanticMemoryDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public iz queryByUUID(String r1) {
        return UpdateUnionSemanticMemoryDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ iz queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public iz queryOne() {
        return UpdateUnionSemanticMemoryDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ iz queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<iz> queryWithLimitAndOffset(int r1, int r2) {
        return UpdateUnionSemanticMemoryDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<iz> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityUpdateUnionSemanticMemoryEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(iz r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfUpdateUnionSemanticMemoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(iz r3) {
        return update2((iz) ZeusTransformUtils.preCheckCast(r3, iz.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<iz> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfUpdateUnionSemanticMemoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
