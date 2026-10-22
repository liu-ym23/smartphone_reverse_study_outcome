package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.entity.cm;
import com.obric.memorydata.database.entity.cn;
import com.obric.memorydata.database.entity.ip;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class MemoryContextSyncDao_Impl implements MemoryContextSyncDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<cn> __insertionAdapterOfMemoryContextSyncStateEntity;
    private final SharedSQLiteStatement __preparedStmtOfClearPending;
    private final SharedSQLiteStatement __preparedStmtOfClearState;
    private final SharedSQLiteStatement __preparedStmtOfDeletePendingIfUnchanged;
    private final SharedSQLiteStatement __preparedStmtOfInsertFullPending;
    private final SharedSQLiteStatement __preparedStmtOfReplacePendingIfUnchanged;

    public MemoryContextSyncDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfMemoryContextSyncStateEntity = new AnonymousClass1(this, r2);
        this.__preparedStmtOfClearState = new AnonymousClass2(this, r2);
        this.__preparedStmtOfClearPending = new AnonymousClass3(this, r2);
        this.__preparedStmtOfDeletePendingIfUnchanged = new AnonymousClass4(this, r2);
        this.__preparedStmtOfReplacePendingIfUnchanged = new AnonymousClass5(this, r2);
        this.__preparedStmtOfInsertFullPending = new AnonymousClass6(this, r2);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.MemoryContextSyncDao
    public void clearPending() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfClearPending.acquire();
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfClearPending.release(r0);
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfClearPending.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryContextSyncDao
    public void clearState() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfClearState.acquire();
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfClearState.release(r0);
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfClearState.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryContextSyncDao
    public int countPending() {
        int r1 = 0;
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM MemoryContextSyncPending", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r3 = DBUtil.query(this.__db, r0, false, null);
    L8:
        th = move-exception;
        r3.close();
        r0.release();
        throw th;
    L4:
        if (r3.moveToFirst() == false) goto L6;
        r1 = r3.getInt(0);     // Catch: Throwable -> L8
    L6:
        r3.close();
        r0.release();
        return r1;
    }

    @Override // com.obric.memorydata.database.dao.MemoryContextSyncDao
    public int deletePendingIfUnchanged(String r4, int r5, long r6) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeletePendingIfUnchanged.acquire();
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r5);
        r0.bindLong(3, r6);
        this.__db.beginTransaction();
        int r7 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfDeletePendingIfUnchanged.release(r0);
        return r7;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeletePendingIfUnchanged.release(r0);
        throw th;
    L5:
        r0.bindString(1, r4);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.MemoryContextSyncDao
    public void insertFullPending(long r3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfInsertFullPending.acquire();
        r0.bindLong(1, r3);
        r0.bindLong(2, r3);
        this.__db.beginTransaction();
        r0.executeInsert();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfInsertFullPending.release(r0);
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfInsertFullPending.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryContextSyncDao
    public List<cm> queryPending(int r11) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM MemoryContextSyncPending ORDER BY source_update_time ASC, uuid ASC LIMIT ?", 1);
        r0.bindLong(1, r11);
        this.__db.assertNotSuspendingTransaction();
        Cursor r10 = DBUtil.query(this.__db, r0, false, null);
        int r12 = CursorUtil.getColumnIndexOrThrow(r10, Api.KEY_UUID);     // Catch: Throwable -> L14
        int r2 = CursorUtil.getColumnIndexOrThrow(r10, "operation");     // Catch: Throwable -> L14
        int r3 = CursorUtil.getColumnIndexOrThrow(r10, "source_update_time");     // Catch: Throwable -> L14
        ArrayList r4 = new ArrayList(r10.getCount());     // Catch: Throwable -> L14
    L4:
        if (r10.moveToNext() == false) goto L12;
        if (r10.isNull(r12) == false) goto L9;
        String r5 = null;
    L10:
        r4.add(new cm(r5, r10.getInt(r2), r10.getLong(r3)));     // Catch: Throwable -> L14
        goto L4
    L9:
        r5 = r10.getString(r12);     // Catch: Throwable -> L14
        goto L10
    L12:
        r10.close();
        r0.release();
        return r4;
    L14:
        th = move-exception;
        r10.close();
        r0.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryContextSyncDao
    public cn queryState() {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM MemoryContextSyncState WHERE id = 0 LIMIT 1", 0);
        this.__db.assertNotSuspendingTransaction();
        cn r3 = null;
        Cursor r4 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r4, OaidModel.KEY_ID);     // Catch: Throwable -> L20
        int r5 = CursorUtil.getColumnIndexOrThrow(r4, "last_reported_reference_memory");     // Catch: Throwable -> L20
        int r6 = CursorUtil.getColumnIndexOrThrow(r4, "last_reported_personal_info");     // Catch: Throwable -> L20
        int r7 = CursorUtil.getColumnIndexOrThrow(r4, "last_reported_collection");     // Catch: Throwable -> L20
        int r8 = CursorUtil.getColumnIndexOrThrow(r4, "batch_not_before_ms");     // Catch: Throwable -> L20
        if (r4.moveToFirst() == false) goto L18;
        int r11 = r4.getInt(r0);     // Catch: Throwable -> L20
        if (r4.getInt(r5) == 0) goto L8;
        boolean r12 = true;
    L10:
        if (r4.getInt(r6) == 0) goto L12;
        boolean r13 = true;
    L14:
        if (r4.getInt(r7) == 0) goto L16;
        boolean r14 = true;
    L17:
        r3 = new cn(r11, r12, r13, r14, r4.getLong(r8));     // Catch: Throwable -> L20
        goto L18
    L16:
        r14 = false;
        goto L17
    L12:
        r13 = false;
        goto L14
    L8:
        r12 = false;
    L18:
        r4.close();
        r1.release();
        return r3;
    L20:
        th = move-exception;
        r4.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryContextSyncDao
    public List<ip> queryTargetSemanticByUuids(List<String> r80) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r80, List.class, "com.obric.memorydata.plugin");
        StringBuilder r3 = StringUtil.newStringBuilder();
        r3.append("SELECT * FROM UnionSemanticMemory WHERE uuid IN (");
        int r4 = r1.size();
        StringUtil.appendPlaceholders(r3, r4);
        r3.append(") AND ((product_type = 1002 AND evidence_count >= 5) OR product_type = 1003)");
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
        int r0 = CursorUtil.getColumnIndexOrThrow(r8, OaidModel.KEY_ID);     // Catch: Throwable -> L116
        int r9 = CursorUtil.getColumnIndexOrThrow(r8, "entityId");     // Catch: Throwable -> L116
        int r10 = CursorUtil.getColumnIndexOrThrow(r8, "createTime");     // Catch: Throwable -> L116
        int r11 = CursorUtil.getColumnIndexOrThrow(r8, "modifyTime");     // Catch: Throwable -> L116
        int r12 = CursorUtil.getColumnIndexOrThrow(r8, "type");     // Catch: Throwable -> L116
        int r13 = CursorUtil.getColumnIndexOrThrow(r8, "timestamp");     // Catch: Throwable -> L116
        int r14 = CursorUtil.getColumnIndexOrThrow(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L116
        int r15 = CursorUtil.getColumnIndexOrThrow(r8, "hashCodeValue");     // Catch: Throwable -> L116
        int r16 = CursorUtil.getColumnIndexOrThrow(r8, Api.KEY_UUID);     // Catch: Throwable -> L116
        int r17 = CursorUtil.getColumnIndexOrThrow(r8, "semantic_type");     // Catch: Throwable -> L116
        int r18 = CursorUtil.getColumnIndexOrThrow(r8, "tag_path");     // Catch: Throwable -> L116
        int r19 = CursorUtil.getColumnIndexOrThrow(r8, "key_phrase");     // Catch: Throwable -> L116
        int r20 = CursorUtil.getColumnIndexOrThrow(r8, "description");     // Catch: Throwable -> L116
        int r21 = CursorUtil.getColumnIndexOrThrow(r8, "embedding_content");     // Catch: Throwable -> L116
        RoomSQLiteQuery r110 = r5;
        int r111 = CursorUtil.getColumnIndexOrThrow(r8, "sources");     // Catch: Throwable -> L114
        int r112 = CursorUtil.getColumnIndexOrThrow(r8, "user_edit");     // Catch: Throwable -> L114
        int r113 = CursorUtil.getColumnIndexOrThrow(r8, "evidence_count");     // Catch: Throwable -> L114
        int r22 = CursorUtil.getColumnIndexOrThrow(r8, "product_type");     // Catch: Throwable -> L114
        int r23 = CursorUtil.getColumnIndexOrThrow(r8, "use_for_insight");     // Catch: Throwable -> L114
        int r24 = CursorUtil.getColumnIndexOrThrow(r8, "use_for_persona");     // Catch: Throwable -> L114
        int r25 = CursorUtil.getColumnIndexOrThrow(r8, "confidence");     // Catch: Throwable -> L114
        int r26 = CursorUtil.getColumnIndexOrThrow(r8, "logId");     // Catch: Throwable -> L114
        int r27 = CursorUtil.getColumnIndexOrThrow(r8, "important_raw_ref_ids");     // Catch: Throwable -> L114
        int r28 = CursorUtil.getColumnIndexOrThrow(r8, "source_raw_ref_ids");     // Catch: Throwable -> L114
        int r29 = CursorUtil.getColumnIndexOrThrow(r8, "scene_ids");     // Catch: Throwable -> L114
        int r210 = CursorUtil.getColumnIndexOrThrow(r8, "sourcePackageName");     // Catch: Throwable -> L114
        int r211 = CursorUtil.getColumnIndexOrThrow(r8, "change_seq");     // Catch: Throwable -> L114
        int r30 = CursorUtil.getColumnIndexOrThrow(r8, "confirmation_state");     // Catch: Throwable -> L114
        int r31 = CursorUtil.getColumnIndexOrThrow(r8, "migration_version");     // Catch: Throwable -> L114
        int r32 = CursorUtil.getColumnIndexOrThrow(r8, "evidence_ids");     // Catch: Throwable -> L114
        int r33 = CursorUtil.getColumnIndexOrThrow(r8, "conflict_entity_ids");     // Catch: Throwable -> L114
        int r34 = CursorUtil.getColumnIndexOrThrow(r8, "last_user_assert_at");     // Catch: Throwable -> L114
        int r35 = CursorUtil.getColumnIndexOrThrow(r8, "poison_label");     // Catch: Throwable -> L114
        int r36 = CursorUtil.getColumnIndexOrThrow(r8, "poison_label_version");     // Catch: Throwable -> L114
        int r37 = CursorUtil.getColumnIndexOrThrow(r8, "content_hash");     // Catch: Throwable -> L114
        int r38 = r21;
        ArrayList r39 = new ArrayList(r8.getCount());     // Catch: Throwable -> L114
    L14:
        if (r8.moveToNext() == false) goto L112;
        long r40 = r8.getLong(r0);     // Catch: Throwable -> L114
        if (r8.isNull(r9) == false) goto L19;
        String r42 = null;
    L20:
        long r43 = r8.getLong(r10);     // Catch: Throwable -> L114
        long r45 = r8.getLong(r11);     // Catch: Throwable -> L114
        int r47 = r8.getInt(r12);     // Catch: Throwable -> L114
        long r48 = r8.getLong(r13);     // Catch: Throwable -> L114
        if (r8.isNull(r14) == false) goto L23;
        String r50 = null;
    L24:
        int r51 = r8.getInt(r15);     // Catch: Throwable -> L114
        if (r8.isNull(r16) == false) goto L27;
        String r52 = null;
    L29:
        if (r8.isNull(r17) == false) goto L31;
        String r53 = null;
    L33:
        if (r8.isNull(r18) == false) goto L35;
        String r54 = null;
    L37:
        if (r8.isNull(r19) == false) goto L39;
        String r55 = null;
    L41:
        if (r8.isNull(r20) == false) goto L43;
        String r56 = null;
    L45:
        if (r8.isNull(r38) == false) goto L48;
        String r57 = null;
    L47:
        int r78 = r111;
        int r114 = r0;
        if (r8.isNull(r78) == false) goto L53;
        String r58 = null;
    L52:
        int r79 = r112;
        if (r8.getInt(r79) == 0) goto L57;
        boolean r59 = true;
    L58:
        int r710 = r113;
        int r60 = r8.getInt(r710);     // Catch: Throwable -> L114
        int r41 = r22;
        int r61 = r8.getInt(r41);     // Catch: Throwable -> L114
        r22 = r41;
        r23 = r23;
        if (r8.getInt(r23) == 0) goto L61;
        boolean r62 = true;
    L63:
        if (r8.getInt(r24) == 0) goto L65;
        boolean r63 = true;
    L66:
        float r64 = r8.getFloat(r25);     // Catch: Throwable -> L114
        r25 = r25;
        r26 = r26;
        if (r8.isNull(r26) == false) goto L69;
        String r65 = null;
    L71:
        if (r8.isNull(r27) == false) goto L73;
        String r66 = null;
    L75:
        if (r8.isNull(r28) == false) goto L77;
        String r67 = null;
    L79:
        if (r8.isNull(r29) == false) goto L81;
        String r68 = null;
    L83:
        if (r8.isNull(r210) == false) goto L85;
        String r69 = null;
    L86:
        long r70 = r8.getLong(r211);     // Catch: Throwable -> L114
        r211 = r211;
        r30 = r30;
        if (r8.isNull(r30) == false) goto L89;
        String r72 = null;
    L90:
        int r73 = r8.getInt(r31);     // Catch: Throwable -> L114
        r31 = r31;
        r32 = r32;
        if (r8.isNull(r32) == false) goto L93;
        String r74 = null;
    L95:
        if (r8.isNull(r33) == false) goto L97;
        String r75 = null;
    L98:
        long r76 = r8.getLong(r34);     // Catch: Throwable -> L114
        r34 = r34;
        ip r44 = new ip(r40, r42, r43, r45, r47, r48, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r72, r73, r74, r75, r76);     // Catch: Throwable -> L114
        int r310 = r19;
        int r46 = r35;
        if (r8.isNull(r46) == false) goto L101;
        Integer r49 = null;
    L102:
        r44.setPoisonLabel(r49);     // Catch: Throwable -> L114
        r36 = r36;
        if (r8.isNull(r36) == false) goto L105;
        Integer r71 = null;
    L106:
        r44.setPoisonLabelVersion(r71);     // Catch: Throwable -> L114
        r37 = r37;
        if (r8.isNull(r37) == false) goto L109;
        String r77 = null;
    L110:
        r44.setContentHash(r77);     // Catch: Throwable -> L114
        r39.add(r44);     // Catch: Throwable -> L114
        r0 = r114;
        r111 = r78;
        r112 = r79;
        r113 = r710;
        r19 = r310;
        r35 = r46;
        r38 = r38;
        goto L14
    L109:
        r77 = r8.getString(r37);     // Catch: Throwable -> L114
        goto L110
    L105:
        r71 = Integer.valueOf(r8.getInt(r36));     // Catch: Throwable -> L114
        goto L106
    L101:
        r49 = Integer.valueOf(r8.getInt(r46));     // Catch: Throwable -> L114
        goto L102
    L97:
        r75 = r8.getString(r33);     // Catch: Throwable -> L114
        goto L98
    L93:
        r74 = r8.getString(r32);     // Catch: Throwable -> L114
        goto L95
    L89:
        r72 = r8.getString(r30);     // Catch: Throwable -> L114
        goto L90
    L85:
        r69 = r8.getString(r210);     // Catch: Throwable -> L114
        goto L86
    L81:
        r68 = r8.getString(r29);     // Catch: Throwable -> L114
        goto L83
    L77:
        r67 = r8.getString(r28);     // Catch: Throwable -> L114
        goto L79
    L73:
        r66 = r8.getString(r27);     // Catch: Throwable -> L114
        goto L75
    L69:
        r65 = r8.getString(r26);     // Catch: Throwable -> L114
        goto L71
    L65:
        r63 = false;
        goto L66
    L61:
        r62 = false;
        goto L63
    L57:
        r59 = false;
        goto L58
    L53:
        r58 = r8.getString(r78);     // Catch: Throwable -> L114
        goto L52
    L48:
        r57 = r8.getString(r38);     // Catch: Throwable -> L114
        goto L47
    L43:
        r56 = r8.getString(r20);     // Catch: Throwable -> L114
        goto L45
    L39:
        r55 = r8.getString(r19);     // Catch: Throwable -> L114
        goto L41
    L35:
        r54 = r8.getString(r18);     // Catch: Throwable -> L114
        goto L37
    L31:
        r53 = r8.getString(r17);     // Catch: Throwable -> L114
        goto L33
    L27:
        r52 = r8.getString(r16);     // Catch: Throwable -> L114
        goto L29
    L23:
        r50 = r8.getString(r14);     // Catch: Throwable -> L114
        goto L24
    L19:
        r42 = r8.getString(r9);     // Catch: Throwable -> L114
        goto L20
    L112:
        r8.close();
        r110.release();
        return r39;
    L114:
        th = th;
    L118:
        r8.close();
        r110.release();
        throw th;
    L116:
        th = th;
        r110 = r5;
        goto L118
    }

    @Override // com.obric.memorydata.database.dao.MemoryContextSyncDao
    public int replacePendingIfUnchanged(String r4, int r5, long r6, int r8, long r9) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfReplacePendingIfUnchanged.acquire();
        r0.bindLong(1, r8);
        r0.bindLong(2, r9);
        if (r4 != null) goto L5;
        r0.bindNull(3);
    L6:
        r0.bindLong(4, r5);
        r0.bindLong(5, r6);
        this.__db.beginTransaction();
        int r7 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfReplacePendingIfUnchanged.release(r0);
        return r7;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfReplacePendingIfUnchanged.release(r0);
        throw th;
    L5:
        r0.bindString(3, r4);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.MemoryContextSyncDao
    public void upsertState(cn r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfMemoryContextSyncStateEntity.insert(r2);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
