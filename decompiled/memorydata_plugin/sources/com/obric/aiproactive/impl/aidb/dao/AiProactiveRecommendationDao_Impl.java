package com.obric.aiproactive.impl.aidb.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
public final class AiProactiveRecommendationDao_Impl implements g {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<com.obric.aiproactive.impl.aidb.a.g> __deletionAdapterOfAiProactiveRecommendationEntity;
    private final EntityInsertionAdapter<com.obric.aiproactive.impl.aidb.a.g> __insertionAdapterOfAiProactiveRecommendationEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByTraceId;
    private final SharedSQLiteStatement __preparedStmtOfUpdateActionExecuteList;
    private final SharedSQLiteStatement __preparedStmtOfUpdateCardStatus;
    private final SharedSQLiteStatement __preparedStmtOfUpdateCardStatusAndFeedback;
    private final SharedSQLiteStatement __preparedStmtOfUpdateFeedback;
    private final EntityDeletionOrUpdateAdapter<com.obric.aiproactive.impl.aidb.a.g> __updateAdapterOfAiProactiveRecommendationEntity;

    public AiProactiveRecommendationDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfAiProactiveRecommendationEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfAiProactiveRecommendationEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfAiProactiveRecommendationEntity = new AnonymousClass3(this, r2);
        this.__preparedStmtOfUpdateCardStatus = new AnonymousClass4(this, r2);
        this.__preparedStmtOfUpdateCardStatusAndFeedback = new AnonymousClass5(this, r2);
        this.__preparedStmtOfUpdateActionExecuteList = new AnonymousClass6(this, r2);
        this.__preparedStmtOfUpdateFeedback = new AnonymousClass7(this, r2);
        this.__preparedStmtOfDeleteByTraceId = new AnonymousClass8(this, r2);
    }

    private com.obric.aiproactive.impl.aidb.a.g __entityCursorConverter_comObricAiproactiveImplAidbEntityAiProactiveRecommendationEntity(Cursor r48) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r48, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r3 = CursorUtil.getColumnIndex(r0, "recommend_text");
        int r4 = CursorUtil.getColumnIndex(r0, "recommend_title");
        int r5 = CursorUtil.getColumnIndex(r0, "recommend_title_masked");
        int r6 = CursorUtil.getColumnIndex(r0, "action_execute_list");
        int r7 = CursorUtil.getColumnIndex(r0, "emoji");
        int r8 = CursorUtil.getColumnIndex(r0, "display_duration_seconds");
        int r9 = CursorUtil.getColumnIndex(r0, "score");
        int r10 = CursorUtil.getColumnIndex(r0, InfoRequestQPSOptTraceLogger.REASON);
        int r11 = CursorUtil.getColumnIndex(r0, "evidence");
        int r12 = CursorUtil.getColumnIndex(r0, "card_status");
        int r13 = CursorUtil.getColumnIndex(r0, "feedback_type");
        int r14 = CursorUtil.getColumnIndex(r0, "feedback_reason");
        int r15 = CursorUtil.getColumnIndex(r0, "feedback_text");
        int r16 = CursorUtil.getColumnIndex(r0, "trace_id");
        int r17 = CursorUtil.getColumnIndex(r0, "created");
        int r18 = CursorUtil.getColumnIndex(r0, "updated");
        int r19 = CursorUtil.getColumnIndex(r0, "artifacts_json");
        long r110 = 0;
        if (r1 != (-1)) goto L5;
        long r24 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        long r26 = 0;
    L10:
        if (r3 != (-1)) goto L13;
    L11:
        String r28 = null;
    L16:
        if (r4 != (-1)) goto L19;
    L17:
        String r29 = null;
    L22:
        if (r5 != (-1)) goto L25;
    L23:
        String r30 = null;
    L28:
        if (r6 != (-1)) goto L31;
    L29:
        String r31 = null;
    L34:
        if (r7 != (-1)) goto L37;
    L35:
        String r32 = null;
    L40:
        if (r8 != (-1)) goto L43;
    L41:
        Integer r33 = null;
    L46:
        if (r9 != (-1)) goto L49;
    L47:
        Integer r34 = null;
    L52:
        if (r10 != (-1)) goto L55;
    L53:
        String r35 = null;
    L58:
        if (r11 != (-1)) goto L61;
    L59:
        String r36 = null;
    L64:
        if (r12 != (-1)) goto L67;
    L65:
        String r37 = null;
    L70:
        if (r13 != (-1)) goto L73;
    L71:
        String r38 = null;
    L76:
        if (r14 != (-1)) goto L79;
    L77:
        String r39 = null;
    L82:
        if (r47 != (-1)) goto L85;
    L83:
        String r40 = null;
    L88:
        if (r48 != (-1)) goto L92;
    L89:
        Long r41 = null;
    L95:
        if (r17 != (-1)) goto L97;
        long r42 = 0;
    L98:
        if (r17 == (-1)) goto L101;
        r110 = r0.getLong(r18);
    L101:
        long r44 = r110;
        if (r19 != (-1)) goto L105;
    L103:
        String r46 = null;
    L109:
        return new com.obric.aiproactive.impl.aidb.a.g(r24, r26, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r44, r46);
    L105:
        if (r0.isNull(r19) == true) goto L103;
        r46 = r0.getString(r19);
        goto L109
    L97:
        r42 = r0.getLong(r17);
        goto L98
    L92:
        if (r0.isNull(r48) == true) goto L89;
        r41 = Long.valueOf(r0.getLong(r16));
        goto L95
    L85:
        if (r0.isNull(r47) == true) goto L83;
        r40 = r0.getString(r15);
        goto L88
    L79:
        if (r0.isNull(r14) == true) goto L77;
        r39 = r0.getString(r14);
        goto L82
    L73:
        if (r0.isNull(r13) == true) goto L71;
        r38 = r0.getString(r13);
        goto L76
    L67:
        if (r0.isNull(r12) == true) goto L65;
        r37 = r0.getString(r12);
        goto L70
    L61:
        if (r0.isNull(r11) == true) goto L59;
        r36 = r0.getString(r11);
        goto L64
    L55:
        if (r0.isNull(r10) == true) goto L53;
        r35 = r0.getString(r10);
        goto L58
    L49:
        if (r0.isNull(r9) == true) goto L47;
        r34 = Integer.valueOf(r0.getInt(r9));
        goto L52
    L43:
        if (r0.isNull(r8) == true) goto L41;
        r33 = Integer.valueOf(r0.getInt(r8));
        goto L46
    L37:
        if (r0.isNull(r7) == true) goto L35;
        r32 = r0.getString(r7);
        goto L40
    L31:
        if (r0.isNull(r6) == true) goto L29;
        r31 = r0.getString(r6);
        goto L34
    L25:
        if (r0.isNull(r5) == true) goto L23;
        r30 = r0.getString(r5);
        goto L28
    L19:
        if (r0.isNull(r4) == true) goto L17;
        r29 = r0.getString(r4);
        goto L22
    L13:
        if (r0.isNull(r3) == true) goto L11;
        r28 = r0.getString(r3);
        goto L16
    L8:
        r26 = r0.getLong(r2);
        goto L10
    L5:
        r24 = r0.getLong(r1);
        goto L6
    }

    static /* synthetic */ SharedSQLiteStatement access$000(AiProactiveRecommendationDao_Impl r0) {
        return r0.__preparedStmtOfUpdateCardStatus;
    }

    static /* synthetic */ RoomDatabase access$100(AiProactiveRecommendationDao_Impl r0) {
        return r0.__db;
    }

    static /* synthetic */ SharedSQLiteStatement access$200(AiProactiveRecommendationDao_Impl r0) {
        return r0.__preparedStmtOfUpdateCardStatusAndFeedback;
    }

    static /* synthetic */ SharedSQLiteStatement access$300(AiProactiveRecommendationDao_Impl r0) {
        return r0.__preparedStmtOfUpdateActionExecuteList;
    }

    static /* synthetic */ SharedSQLiteStatement access$400(AiProactiveRecommendationDao_Impl r0) {
        return r0.__preparedStmtOfUpdateFeedback;
    }

    static /* synthetic */ SharedSQLiteStatement access$500(AiProactiveRecommendationDao_Impl r0) {
        return r0.__preparedStmtOfDeleteByTraceId;
    }

    static /* synthetic */ com.obric.aiproactive.impl.aidb.a.g access$600(AiProactiveRecommendationDao_Impl r2, Cursor r3) {
        return r2.__entityCursorConverter_comObricAiproactiveImplAidbEntityAiProactiveRecommendationEntity((Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin"));
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<com.obric.aiproactive.impl.aidb.a.g> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfAiProactiveRecommendationEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<com.obric.aiproactive.impl.aidb.a.g> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfAiProactiveRecommendationEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(com.obric.aiproactive.impl.aidb.a.g r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfAiProactiveRecommendationEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(com.obric.aiproactive.impl.aidb.a.g r3) {
        return delete2((com.obric.aiproactive.impl.aidb.a.g) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.impl.aidb.a.g.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return g.a.d(this);
    }

    public Object deleteByTraceId(final long r3, Continuation<? super Integer> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return CoroutinesRoom.execute(this.__db, true, new AnonymousClass12(this, r3), r6);
    }

    @Override // com.obric.aiproactive.impl.aidb.dao.g
    public Object findLatestTraceId(Continuation<? super Long> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("\n        SELECT trace_id FROM ProactiveRecommendation\n        WHERE trace_id IS NOT NULL\n        ORDER BY trace_id DESC, id DESC\n        LIMIT 1\n        ", 0);
        CancellationSignal r2 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, r2, new AnonymousClass14(this, r0), r7);
    }

    @Override // com.obric.aiproactive.impl.aidb.dao.g
    public Object findRecommendTextById(long r3, Continuation<? super String> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("\n        SELECT recommend_text FROM ProactiveRecommendation\n        WHERE id = ?\n        LIMIT 1\n        ", 1);
        r0.bindLong(1, r3);
        CancellationSignal r4 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, r4, new AnonymousClass15(this, r0), r6);
    }

    @Override // com.obric.aiproactive.impl.aidb.dao.g
    public Object findTraceIdById(long r3, Continuation<? super Long> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("\n        SELECT trace_id FROM ProactiveRecommendation\n        WHERE id = ?\n        LIMIT 1\n        ", 1);
        r0.bindLong(1, r3);
        CancellationSignal r4 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, r4, new AnonymousClass13(this, r0), r6);
    }

    @Override // com.obric.aiproactive.impl.aidb.dao.g
    public Long findTraceIdByIdSync(long r3) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("\n        SELECT trace_id FROM ProactiveRecommendation\n        WHERE id = ?\n        LIMIT 1\n        ", 1);
        r0.bindLong(1, r3);
        this.__db.assertNotSuspendingTransaction();
        Long r4 = null;
        Cursor r2 = DBUtil.query(this.__db, r0, false, null);
    L11:
        th = move-exception;
        r2.close();
        r0.release();
        throw th;
    L4:
        if (r2.moveToFirst() == true) goto L6;
    L9:
        r2.close();
        r0.release();
        return r4;
    L6:
        if (r2.isNull(0) == true) goto L9;
        r4 = Long.valueOf(r2.getLong(0));     // Catch: Throwable -> L11
        goto L9
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return g.a.a(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(com.obric.aiproactive.impl.aidb.a.g r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfAiProactiveRecommendationEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(com.obric.aiproactive.impl.aidb.a.g r3) {
        return insert2((com.obric.aiproactive.impl.aidb.a.g) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.impl.aidb.a.g.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<com.obric.aiproactive.impl.aidb.a.g> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfAiProactiveRecommendationEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.aiproactive.impl.aidb.dao.g
    public List<String> listArtifactJsonSync() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT artifacts_json FROM ProactiveRecommendation WHERE artifacts_json IS NOT NULL", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r3 = new ArrayList(r5.getCount());     // Catch: Throwable -> L14
    L4:
        if (r5.moveToNext() == false) goto L12;
        if (r5.isNull(0) == false) goto L9;
        String r4 = null;
    L10:
        r3.add(r4);     // Catch: Throwable -> L14
        goto L4
    L9:
        r4 = r5.getString(0);     // Catch: Throwable -> L14
        goto L10
    L12:
        r5.close();
        r0.release();
        return r3;
    L14:
        th = move-exception;
        r5.close();
        r0.release();
        throw th;
    }

    @Override // com.obric.aiproactive.impl.aidb.dao.g
    public Object listRecommendations(SupportSQLiteQuery r4, Continuation<? super List<com.obric.aiproactive.impl.aidb.a.g>> r5) {
        final SupportSQLiteQuery r6 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        CancellationSignal r0 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, r0, new AnonymousClass16(this, r6), r7);
    }

    @Override // com.obric.aiproactive.impl.aidb.dao.g
    public kotlinx.coroutines.flow.i<List<com.obric.aiproactive.impl.aidb.a.g>> observeRecommendations(SupportSQLiteQuery r4) {
        final SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"ProactiveRecommendation"}, new AnonymousClass17(this, r5));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.aiproactive.impl.aidb.a.g> queryAll() {
        return g.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return g.a.c(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.aiproactive.impl.aidb.a.g queryById(long r1) {
        return g.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.aiproactive.impl.aidb.a.g queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.aiproactive.impl.aidb.a.g> queryByIds(List<Long> r3) {
        return g.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.aiproactive.impl.aidb.a.g queryByUUID(String r1) {
        return g.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.aiproactive.impl.aidb.a.g queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.aiproactive.impl.aidb.dao.g
    public Object queryInt(SupportSQLiteQuery r4, Continuation<? super Integer> r5) {
        final SupportSQLiteQuery r6 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        CancellationSignal r0 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, r0, new AnonymousClass18(this, r6), r7);
    }

    @Override // com.obric.aiproactive.impl.aidb.dao.g
    public int queryIntSync(SupportSQLiteQuery r3) {
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

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.aiproactive.impl.aidb.a.g queryOne() {
        return g.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.aiproactive.impl.aidb.a.g queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.aiproactive.impl.aidb.a.g> queryWithLimitAndOffset(int r1, int r2) {
        return g.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.aiproactive.impl.aidb.a.g> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricAiproactiveImplAidbEntityAiProactiveRecommendationEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(com.obric.aiproactive.impl.aidb.a.g r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfAiProactiveRecommendationEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(com.obric.aiproactive.impl.aidb.a.g r3) {
        return update2((com.obric.aiproactive.impl.aidb.a.g) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.impl.aidb.a.g.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.aiproactive.impl.aidb.dao.g
    public Object updateActionExecuteList(final long r12, final String r14, final String r15, final long r16, Continuation<? super Unit> r18) {
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r18, Continuation.class, "com.obric.memorydata.plugin");
        return CoroutinesRoom.execute(this.__db, true, new AnonymousClass10(this, r14, r15, r16, r12), r0);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<com.obric.aiproactive.impl.aidb.a.g> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfAiProactiveRecommendationEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.aiproactive.impl.aidb.dao.g
    public Object updateCardStatus(final long r10, final String r12, final long r13, Continuation<? super Unit> r15) {
        Continuation r16 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        return CoroutinesRoom.execute(this.__db, true, new AnonymousClass19(this, r12, r13, r10), r16);
    }

    @Override // com.obric.aiproactive.impl.aidb.dao.g
    public Object updateCardStatusAndFeedback(final long r14, final String r16, final String r17, final String r18, final String r19, final long r20, Continuation<? super Unit> r22) {
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r22, Continuation.class, "com.obric.memorydata.plugin");
        return CoroutinesRoom.execute(this.__db, true, new AnonymousClass9(this, r16, r17, r18, r19, r20, r14), r0);
    }

    @Override // com.obric.aiproactive.impl.aidb.dao.g
    public Object updateFeedback(final long r13, final String r15, final String r16, final String r17, final long r18, Continuation<? super Unit> r20) {
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r20, Continuation.class, "com.obric.memorydata.plugin");
        return CoroutinesRoom.execute(this.__db, true, new AnonymousClass11(this, r15, r16, r17, r18, r13), r0);
    }
}
