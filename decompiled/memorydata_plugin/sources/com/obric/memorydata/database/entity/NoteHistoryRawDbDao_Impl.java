package com.obric.memorydata.database.entity;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class NoteHistoryRawDbDao_Impl implements dx {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<dw> __deletionAdapterOfNoteHistoryEntity;
    private final EntityInsertionAdapter<dw> __insertionAdapterOfNoteHistoryEntity;
    private final EntityDeletionOrUpdateAdapter<dw> __updateAdapterOfNoteHistoryEntity;

    public NoteHistoryRawDbDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfNoteHistoryEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfNoteHistoryEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfNoteHistoryEntity = new AnonymousClass3(this, r2);
    }

    private dw __entityCursorConverter_comObricMemorydataDatabaseEntityNoteHistoryEntity(Cursor r54) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r54, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "note_id");
        int r3 = CursorUtil.getColumnIndex(r0, "note_entityId");
        int r4 = CursorUtil.getColumnIndex(r0, "note_createTime");
        int r5 = CursorUtil.getColumnIndex(r0, "note_modifyTime");
        int r6 = CursorUtil.getColumnIndex(r0, "note_type");
        int r7 = CursorUtil.getColumnIndex(r0, "note_timestamp");
        int r8 = CursorUtil.getColumnIndex(r0, "note_packageName");
        int r9 = CursorUtil.getColumnIndex(r0, "note_hashCodeValue");
        int r10 = CursorUtil.getColumnIndex(r0, "note_uuid");
        int r11 = CursorUtil.getColumnIndex(r0, "note_title");
        int r12 = CursorUtil.getColumnIndex(r0, "note_text");
        int r13 = CursorUtil.getColumnIndex(r0, "note_textConversion");
        int r14 = CursorUtil.getColumnIndex(r0, "note_formatMode");
        int r15 = CursorUtil.getColumnIndex(r0, "note_noteFolder");
        int r16 = CursorUtil.getColumnIndex(r0, "note_isFavorite");
        int r17 = CursorUtil.getColumnIndex(r0, "note_files");
        int r18 = CursorUtil.getColumnIndex(r0, "note_fullContent");
        int r19 = CursorUtil.getColumnIndex(r0, "note_contentWithTime");
        int r110 = CursorUtil.getColumnIndex(r0, "note_recordingIds");
        int r111 = CursorUtil.getColumnIndex(r0, "note_poison_label");
        int r112 = CursorUtil.getColumnIndex(r0, "note_poison_label_version");
        int r113 = CursorUtil.getColumnIndex(r0, "note_content_hash");
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
        boolean r21 = false;
        if (r6 != (-1)) goto L25;
        int r37 = 0;
    L26:
        if (r7 == (-1)) goto L29;
        r22 = r0.getLong(r7);
    L29:
        long r38 = r22;
        if (r8 != (-1)) goto L33;
    L31:
        String r40 = null;
    L36:
        if (r9 != (-1)) goto L38;
        int r41 = 0;
    L39:
        if (r10 != (-1)) goto L42;
    L40:
        String r42 = null;
    L45:
        if (r11 != (-1)) goto L48;
    L46:
        String r43 = null;
    L51:
        if (r12 != (-1)) goto L54;
    L52:
        String r44 = null;
    L57:
        if (r13 != (-1)) goto L60;
    L58:
        String r45 = null;
    L63:
        if (r14 != (-1)) goto L66;
    L64:
        String r46 = null;
    L69:
        if (r53 != (-1)) goto L72;
    L70:
        String r47 = null;
    L75:
        if (r54 != (-1)) goto L78;
    L76:
        boolean r48 = r21;
        if (r17 != (-1)) goto L84;
    L81:
        String r49 = null;
    L87:
        if (r18 != (-1)) goto L91;
    L88:
        String r50 = null;
    L94:
        if (r19 != (-1)) goto L98;
    L95:
        String r51 = null;
    L101:
        if (r110 != (-1)) goto L104;
    L102:
        String r52 = null;
    L107:
        gu r23 = new gu(r30, r32, r33, r35, r37, r38, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52);
        if (r111 == (-1)) goto L115;
        if (r0.isNull(r111) == false) goto L112;
        Integer r24 = null;
    L113:
        r23.setPoisonLabel(r24);
        goto L115
    L112:
        r24 = Integer.valueOf(r0.getInt(r111));
    L115:
        if (r112 == (-1)) goto L122;
        if (r0.isNull(r112) == false) goto L119;
        Integer r25 = null;
    L120:
        r23.setPoisonLabelVersion(r25);
        goto L122
    L119:
        r25 = Integer.valueOf(r0.getInt(r112));
    L122:
        if (r113 == (-1)) goto L129;
        if (r0.isNull(r113) == true) goto L127;
        r20 = r0.getString(r113);
    L127:
        r23.setContentHash(r20);
    L129:
        return new dw(r27, r23);
    L104:
        if (r0.isNull(r110) == true) goto L102;
        r52 = r0.getString(r110);
        goto L107
    L98:
        if (r0.isNull(r19) == true) goto L95;
        r51 = r0.getString(r19);
        goto L101
    L91:
        if (r0.isNull(r18) == true) goto L88;
        r50 = r0.getString(r18);
        goto L94
    L84:
        if (r0.isNull(r17) == true) goto L81;
        r49 = r0.getString(r17);
        goto L87
    L78:
        if (r0.getInt(r16) == 0) goto L76;
        r21 = true;
        goto L76
    L72:
        if (r0.isNull(r53) == true) goto L70;
        r47 = r0.getString(r15);
        goto L75
    L66:
        if (r0.isNull(r14) == true) goto L64;
        r46 = r0.getString(r14);
        goto L69
    L60:
        if (r0.isNull(r13) == true) goto L58;
        r45 = r0.getString(r13);
        goto L63
    L54:
        if (r0.isNull(r12) == true) goto L52;
        r44 = r0.getString(r12);
        goto L57
    L48:
        if (r0.isNull(r11) == true) goto L46;
        r43 = r0.getString(r11);
        goto L51
    L42:
        if (r0.isNull(r10) == true) goto L40;
        r42 = r0.getString(r10);
        goto L45
    L38:
        r41 = r0.getInt(r9);
        goto L39
    L33:
        if (r0.isNull(r8) == true) goto L31;
        r40 = r0.getString(r8);
        goto L36
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
    public void bulkDelete(List<dw> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfNoteHistoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<dw> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfNoteHistoryEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    public int delete(dw r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfNoteHistoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((dw) ZeusTransformUtils.preCheckCast(r3, dw.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return dx.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityId(String r1, String r2) {
        return dx.a.b(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityIdList(List<String> r3, String r4) {
        return dx.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityIdListAndPackageName(List<String> r3, String r4) {
        return dx.a.b(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteById(long r1) {
        return dx.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public String getPrefix() {
        return dx.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return dx.a.a(this);
    }

    public long insert(dw r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfNoteHistoryEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((dw) ZeusTransformUtils.preCheckCast(r3, dw.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<dw> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfNoteHistoryEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<dw> queryAll() {
        return dx.a.c(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return dx.a.d(this);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public List<dw> queryByEntityId(String r1, String r2) {
        return dx.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public List<dw> queryByEntityIdListAndPackageName(List<String> r3, String r4) {
        return dx.a.c(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public dw queryById(long r1) {
        return dx.a.b(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<dw> queryByIds(List<Long> r3) {
        return dx.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public dw queryByUUID(String r1) {
        return dx.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public dw queryOne() {
        return dx.a.f(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<dw> queryWithLimitAndOffset(int r1, int r2) {
        return dx.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<dw> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityNoteHistoryEntity(r6));     // Catch: Throwable -> L10
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

    public int update(dw r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfNoteHistoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((dw) ZeusTransformUtils.preCheckCast(r3, dw.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<dw> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfNoteHistoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
