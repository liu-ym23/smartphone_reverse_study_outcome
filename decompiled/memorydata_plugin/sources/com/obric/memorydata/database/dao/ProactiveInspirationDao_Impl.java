package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.memorydata.database.entity.et;
import com.obric.memorydata.database.entity.ez;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
public final class ProactiveInspirationDao_Impl implements ProactiveInspirationDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<et> __insertionAdapterOfProactiveInspirationEntity;
    private final SharedSQLiteStatement __preparedStmtOfUpdateIsDeleteBySubscriptionId;
    private final SharedSQLiteStatement __preparedStmtOfUpdateRecommendStatus;

    public ProactiveInspirationDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfProactiveInspirationEntity = new AnonymousClass1(this, r2);
        this.__preparedStmtOfUpdateRecommendStatus = new AnonymousClass2(this, r2);
        this.__preparedStmtOfUpdateIsDeleteBySubscriptionId = new AnonymousClass3(this, r2);
    }

    static /* synthetic */ RoomDatabase access$000(ProactiveInspirationDao_Impl r0) {
        return r0.__db;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.ProactiveInspirationDao
    public et getById(String r34) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM ProactiveInspiration WHERE inspiration_id = ? ORDER BY created DESC LIMIT 1", 1);
        if (r34 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        et r4 = null;
        String r5 = null;
        Cursor r6 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r6, "inspiration_id");     // Catch: Throwable -> L40
        int r7 = CursorUtil.getColumnIndexOrThrow(r6, "task_id");     // Catch: Throwable -> L40
        int r8 = CursorUtil.getColumnIndexOrThrow(r6, "recommend_id");     // Catch: Throwable -> L40
        int r9 = CursorUtil.getColumnIndexOrThrow(r6, "recommend_status");     // Catch: Throwable -> L40
        int r10 = CursorUtil.getColumnIndexOrThrow(r6, "feedback_action");     // Catch: Throwable -> L40
        int r11 = CursorUtil.getColumnIndexOrThrow(r6, "user_feedback");     // Catch: Throwable -> L40
        int r12 = CursorUtil.getColumnIndexOrThrow(r6, "recommendation_snapshot");     // Catch: Throwable -> L40
        int r13 = CursorUtil.getColumnIndexOrThrow(r6, "created");     // Catch: Throwable -> L40
        int r14 = CursorUtil.getColumnIndexOrThrow(r6, "updated");     // Catch: Throwable -> L40
        int r15 = CursorUtil.getColumnIndexOrThrow(r6, "is_delete");     // Catch: Throwable -> L40
        int r16 = CursorUtil.getColumnIndexOrThrow(r6, "timestamp");     // Catch: Throwable -> L40
        int r1 = CursorUtil.getColumnIndexOrThrow(r6, OaidModel.KEY_ID);     // Catch: Throwable -> L40
        if (r6.moveToFirst() == true) goto L10;
    L38:
        r6.close();
        r2.release();
        return r4;
    L10:
        if (r6.isNull(r0) == false) goto L12;
        String r17 = null;
    L14:
        if (r6.isNull(r7) == false) goto L16;
        String r18 = null;
    L18:
        if (r6.isNull(r8) == false) goto L20;
        String r19 = null;
    L21:
        int r20 = r6.getInt(r9);     // Catch: Throwable -> L40
        if (r6.isNull(r10) == false) goto L24;
        String r21 = null;
    L26:
        if (r6.isNull(r11) == false) goto L28;
        String r22 = null;
    L30:
        if (r6.isNull(r12) == false) goto L32;
    L31:
        String r23 = r5;
        long r24 = r6.getLong(r13);     // Catch: Throwable -> L40
        long r26 = r6.getLong(r14);     // Catch: Throwable -> L40
        if (r6.getInt(r15) == 0) goto L36;
        boolean r28 = true;
    L37:
        r4 = new et(r17, r18, r19, r20, r21, r22, r23, r24, r26, r28, r6.getLong(r16), r6.getLong(r1));     // Catch: Throwable -> L40
        goto L38
    L36:
        r28 = false;
        goto L37
    L32:
        r5 = r6.getString(r12);     // Catch: Throwable -> L40
        goto L31
    L28:
        r22 = r6.getString(r11);     // Catch: Throwable -> L40
        goto L30
    L24:
        r21 = r6.getString(r10);     // Catch: Throwable -> L40
        goto L26
    L20:
        r19 = r6.getString(r8);     // Catch: Throwable -> L40
        goto L21
    L16:
        r18 = r6.getString(r7);     // Catch: Throwable -> L40
        goto L18
    L12:
        r17 = r6.getString(r0);     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        r6.close();
        r2.release();
        throw th;
    L5:
        r2.bindString(1, r34);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.ProactiveInspirationDao
    public List<ProactiveInspirationRecommendationRow> listAllDayJoinedByDayKey(List<Integer> r3, String r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.beginTransaction();
        List<ProactiveInspirationRecommendationRow> r6 = ProactiveInspirationDao.DefaultImpls.listAllDayJoinedByDayKey(this, r5, r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r6;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.ProactiveInspirationDao
    public List<et> listAllDaySeedRowsByDayKey(List<Integer> r35, String r36) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r35, List.class, "com.obric.memorydata.plugin");
        StringBuilder r4 = StringUtil.newStringBuilder();
        r4.append("SELECT * FROM ProactiveInspiration WHERE id IN (SELECT MAX(id) FROM ProactiveInspiration WHERE recommend_status IN (");
        int r5 = r2.size();
        StringUtil.appendPlaceholders(r4, r5);
        r4.append(") AND is_delete = 0 GROUP BY inspiration_id) AND DATE(datetime(created / 1000, 'unixepoch', 'localtime')) = ");
        r4.append("?");
        r4.append(" ORDER BY created DESC, id DESC");
        int r6 = r5 + 1;
        RoomSQLiteQuery r7 = RoomSQLiteQuery.acquire(r4.toString(), r6);
        Iterator r3 = r2.iterator();
        int r8 = 1;
    L4:
        if (r3.hasNext() == false) goto L6;
        r7.bindLong(r8, ((Integer) ZeusTransformUtils.preCheckCast(r3.next(), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r8 = r8 + 1;
        goto L4
    L6:
        if (r36 != null) goto L8;
        r7.bindNull(r6);
    L9:
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        Cursor r9 = DBUtil.query(this.__db, r7, false, null);     // Catch: Throwable -> L55
        int r0 = CursorUtil.getColumnIndexOrThrow(r9, "inspiration_id");     // Catch: Throwable -> L51
        int r10 = CursorUtil.getColumnIndexOrThrow(r9, "task_id");     // Catch: Throwable -> L51
        int r11 = CursorUtil.getColumnIndexOrThrow(r9, "recommend_id");     // Catch: Throwable -> L51
        int r12 = CursorUtil.getColumnIndexOrThrow(r9, "recommend_status");     // Catch: Throwable -> L51
        int r13 = CursorUtil.getColumnIndexOrThrow(r9, "feedback_action");     // Catch: Throwable -> L51
        int r14 = CursorUtil.getColumnIndexOrThrow(r9, "user_feedback");     // Catch: Throwable -> L51
        int r15 = CursorUtil.getColumnIndexOrThrow(r9, "recommendation_snapshot");     // Catch: Throwable -> L51
        int r16 = CursorUtil.getColumnIndexOrThrow(r9, "created");     // Catch: Throwable -> L51
        int r17 = CursorUtil.getColumnIndexOrThrow(r9, "updated");     // Catch: Throwable -> L51
        int r18 = CursorUtil.getColumnIndexOrThrow(r9, "is_delete");     // Catch: Throwable -> L51
        int r19 = CursorUtil.getColumnIndexOrThrow(r9, "timestamp");     // Catch: Throwable -> L51
        int r20 = CursorUtil.getColumnIndexOrThrow(r9, OaidModel.KEY_ID);     // Catch: Throwable -> L51
        RoomSQLiteQuery r110 = r7;
        ArrayList r21 = new ArrayList(r9.getCount());     // Catch: Throwable -> L49
    L15:
        if (r9.moveToNext() == false) goto L45;
        if (r9.isNull(r0) == false) goto L19;
        String r111 = null;
    L21:
        if (r9.isNull(r10) == false) goto L23;
        String r112 = null;
    L25:
        if (r9.isNull(r11) == false) goto L27;
        String r22 = null;
    L28:
        int r23 = r9.getInt(r12);     // Catch: Throwable -> L49
        if (r9.isNull(r13) == false) goto L31;
        String r24 = null;
    L33:
        if (r9.isNull(r14) == false) goto L35;
        String r25 = null;
    L37:
        if (r9.isNull(r15) == false) goto L39;
        String r26 = null;
    L40:
        long r27 = r9.getLong(r16);     // Catch: Throwable -> L49
        long r28 = r9.getLong(r17);     // Catch: Throwable -> L49
        if (r9.getInt(r18) == 0) goto L43;
        boolean r29 = true;
    L44:
        r21.add(new et(r111, r112, r22, r23, r24, r25, r26, r27, r28, r29, r9.getLong(r19), r9.getLong(r20)));     // Catch: Throwable -> L49
        goto L15
    L43:
        r29 = false;
        goto L44
    L39:
        r26 = r9.getString(r15);     // Catch: Throwable -> L49
        goto L40
    L35:
        r25 = r9.getString(r14);     // Catch: Throwable -> L49
        goto L37
    L31:
        r24 = r9.getString(r13);     // Catch: Throwable -> L49
        goto L33
    L27:
        r22 = r9.getString(r11);     // Catch: Throwable -> L49
        goto L28
    L23:
        r112 = r9.getString(r10);     // Catch: Throwable -> L49
        goto L25
    L19:
        r111 = r9.getString(r0);     // Catch: Throwable -> L49
        goto L21
    L45:
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L49
        r9.close();     // Catch: Throwable -> L55
        r110.release();     // Catch: Throwable -> L55
        this.__db.endTransaction();
        return r21;
    L49:
        th = th;
    L53:
        r9.close();     // Catch: Throwable -> L55
        r110.release();     // Catch: Throwable -> L55
        throw th;     // Catch: Throwable -> L55
    L51:
        th = th;
        r110 = r7;
    L55:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    L8:
        r7.bindString(r6, r36);
        goto L9
    }

    @Override // com.obric.memorydata.database.dao.ProactiveInspirationDao
    public List<ProactiveInspirationBatchSeedRow> listBatchSeedRowsByRecommendStatuses(List<Integer> r3) {
        return ProactiveInspirationDao.DefaultImpls.listBatchSeedRowsByRecommendStatuses(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.ProactiveInspirationDao
    public List<ProactiveInspirationBatchSeedSnapshotRow> listBatchSeedSnapshotRowsByRecommendStatuses(List<Integer> r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT i.id AS inspirationRowId, i.updated AS inspirationUpdated, i.recommend_status AS recommendStatus, i.recommend_id AS recommendId, i.recommendation_snapshot AS recommendationSnapshot FROM ProactiveInspiration i WHERE i.id IN (SELECT MAX(id) FROM ProactiveInspiration WHERE recommend_status IN (");
        int r2 = r15.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(") AND is_delete = 0 GROUP BY inspiration_id) ORDER BY i.created DESC, i.id DESC");
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), r2 + 0);
        Iterator r16 = r15.iterator();
        int r4 = 1;
    L4:
        if (r16.hasNext() == false) goto L6;
        r1.bindLong(r4, ((Integer) ZeusTransformUtils.preCheckCast(r16.next(), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r4 = r4 + 1;
        goto L4
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r13 = DBUtil.query(this.__db, r1, false, null);
        ArrayList r3 = new ArrayList(r13.getCount());     // Catch: Throwable -> L22
    L8:
        if (r13.moveToNext() == false) goto L20;
        long r6 = r13.getLong(0);     // Catch: Throwable -> L22
        long r8 = r13.getLong(1);     // Catch: Throwable -> L22
        int r10 = r13.getInt(2);     // Catch: Throwable -> L22
        if (r13.isNull(3) == false) goto L13;
        String r11 = null;
    L15:
        if (r13.isNull(4) == false) goto L17;
        String r12 = null;
    L18:
        r3.add(new ProactiveInspirationBatchSeedSnapshotRow(r6, r8, r10, r11, r12));     // Catch: Throwable -> L22
        goto L8
    L17:
        r12 = r13.getString(4);     // Catch: Throwable -> L22
        goto L18
    L13:
        r11 = r13.getString(3);     // Catch: Throwable -> L22
        goto L15
    L20:
        r13.close();
        r1.release();
        return r3;
    L22:
        th = move-exception;
        r13.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.ProactiveInspirationDao
    public List<et> listByRecommendId(String r34) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM ProactiveInspiration WHERE recommend_id = ? ORDER BY created DESC", 1);
        if (r34 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, "inspiration_id");     // Catch: Throwable -> L42
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "task_id");     // Catch: Throwable -> L42
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "recommend_id");     // Catch: Throwable -> L42
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "recommend_status");     // Catch: Throwable -> L42
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "feedback_action");     // Catch: Throwable -> L42
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "user_feedback");     // Catch: Throwable -> L42
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, "recommendation_snapshot");     // Catch: Throwable -> L42
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "created");     // Catch: Throwable -> L42
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, "updated");     // Catch: Throwable -> L42
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "is_delete");     // Catch: Throwable -> L42
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, "timestamp");     // Catch: Throwable -> L42
        int r1 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L42
        ArrayList r3 = new ArrayList(r5.getCount());     // Catch: Throwable -> L42
    L8:
        if (r5.moveToNext() == false) goto L40;
        if (r5.isNull(r0) == false) goto L13;
        String r17 = null;
    L15:
        if (r5.isNull(r6) == false) goto L17;
        String r18 = null;
    L19:
        if (r5.isNull(r7) == false) goto L21;
        String r19 = null;
    L22:
        int r20 = r5.getInt(r8);     // Catch: Throwable -> L42
        if (r5.isNull(r9) == false) goto L25;
        String r21 = null;
    L27:
        if (r5.isNull(r10) == false) goto L29;
        String r22 = null;
    L31:
        if (r5.isNull(r11) == false) goto L33;
        String r23 = null;
    L34:
        long r24 = r5.getLong(r12);     // Catch: Throwable -> L42
        long r26 = r5.getLong(r13);     // Catch: Throwable -> L42
        if (r5.getInt(r14) == 0) goto L37;
        boolean r28 = true;
    L38:
        r3.add(new et(r17, r18, r19, r20, r21, r22, r23, r24, r26, r28, r5.getLong(r15), r5.getLong(r1)));     // Catch: Throwable -> L42
        goto L8
    L37:
        r28 = false;
        goto L38
    L33:
        r23 = r5.getString(r11);     // Catch: Throwable -> L42
        goto L34
    L29:
        r22 = r5.getString(r10);     // Catch: Throwable -> L42
        goto L31
    L25:
        r21 = r5.getString(r9);     // Catch: Throwable -> L42
        goto L27
    L21:
        r19 = r5.getString(r7);     // Catch: Throwable -> L42
        goto L22
    L17:
        r18 = r5.getString(r6);     // Catch: Throwable -> L42
        goto L19
    L13:
        r17 = r5.getString(r0);     // Catch: Throwable -> L42
        goto L15
    L40:
        r5.close();
        r2.release();
        return r3;
    L42:
        th = move-exception;
        r5.close();
        r2.release();
        throw th;
    L5:
        r2.bindString(1, r34);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.ProactiveInspirationDao
    public List<ProactiveInspirationRecommendationRow> listDayJoinedByDayKey(List<Integer> r3, String r4, int r5, int r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.beginTransaction();
        List<ProactiveInspirationRecommendationRow> r8 = ProactiveInspirationDao.DefaultImpls.listDayJoinedByDayKey(this, r7, r4, r5, r6);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r8;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.ProactiveInspirationDao
    public List<et> listDaySeedRowsByDayKey(List<Integer> r35, String r36, int r37, int r38) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r35, List.class, "com.obric.memorydata.plugin");
        StringBuilder r4 = StringUtil.newStringBuilder();
        r4.append("SELECT * FROM ProactiveInspiration WHERE id IN (SELECT MAX(id) FROM ProactiveInspiration WHERE recommend_status IN (");
        int r5 = r2.size();
        StringUtil.appendPlaceholders(r4, r5);
        r4.append(") AND is_delete = 0 GROUP BY inspiration_id) AND DATE(datetime(created / 1000, 'unixepoch', 'localtime')) = ");
        r4.append("?");
        r4.append(" ORDER BY created DESC, id DESC LIMIT ");
        r4.append("?");
        r4.append(" OFFSET ");
        r4.append("?");
        int r6 = r5 + 3;
        RoomSQLiteQuery r7 = RoomSQLiteQuery.acquire(r4.toString(), r6);
        Iterator r3 = r2.iterator();
        int r8 = 1;
    L4:
        if (r3.hasNext() == false) goto L6;
        r7.bindLong(r8, ((Integer) ZeusTransformUtils.preCheckCast(r3.next(), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r8 = r8 + 1;
        goto L4
    L6:
        int r9 = r5 + 1;
        if (r36 != null) goto L9;
        r7.bindNull(r9);
    L10:
        r7.bindLong(r5 + 2, r38);
        r7.bindLong(r6, r37);
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        Cursor r10 = DBUtil.query(this.__db, r7, false, null);     // Catch: Throwable -> L56
        int r0 = CursorUtil.getColumnIndexOrThrow(r10, "inspiration_id");     // Catch: Throwable -> L52
        int r11 = CursorUtil.getColumnIndexOrThrow(r10, "task_id");     // Catch: Throwable -> L52
        int r12 = CursorUtil.getColumnIndexOrThrow(r10, "recommend_id");     // Catch: Throwable -> L52
        int r13 = CursorUtil.getColumnIndexOrThrow(r10, "recommend_status");     // Catch: Throwable -> L52
        int r14 = CursorUtil.getColumnIndexOrThrow(r10, "feedback_action");     // Catch: Throwable -> L52
        int r15 = CursorUtil.getColumnIndexOrThrow(r10, "user_feedback");     // Catch: Throwable -> L52
        int r16 = CursorUtil.getColumnIndexOrThrow(r10, "recommendation_snapshot");     // Catch: Throwable -> L52
        int r17 = CursorUtil.getColumnIndexOrThrow(r10, "created");     // Catch: Throwable -> L52
        int r18 = CursorUtil.getColumnIndexOrThrow(r10, "updated");     // Catch: Throwable -> L52
        int r19 = CursorUtil.getColumnIndexOrThrow(r10, "is_delete");     // Catch: Throwable -> L52
        int r20 = CursorUtil.getColumnIndexOrThrow(r10, "timestamp");     // Catch: Throwable -> L52
        int r21 = CursorUtil.getColumnIndexOrThrow(r10, OaidModel.KEY_ID);     // Catch: Throwable -> L52
        RoomSQLiteQuery r110 = r7;
        ArrayList r22 = new ArrayList(r10.getCount());     // Catch: Throwable -> L50
    L16:
        if (r10.moveToNext() == false) goto L46;
        if (r10.isNull(r0) == false) goto L20;
        String r111 = null;
    L22:
        if (r10.isNull(r11) == false) goto L24;
        String r112 = null;
    L26:
        if (r10.isNull(r12) == false) goto L28;
        String r23 = null;
    L29:
        int r24 = r10.getInt(r13);     // Catch: Throwable -> L50
        if (r10.isNull(r14) == false) goto L32;
        String r25 = null;
    L34:
        if (r10.isNull(r15) == false) goto L36;
        String r26 = null;
    L38:
        if (r10.isNull(r16) == false) goto L40;
        String r27 = null;
    L41:
        long r28 = r10.getLong(r17);     // Catch: Throwable -> L50
        long r29 = r10.getLong(r18);     // Catch: Throwable -> L50
        if (r10.getInt(r19) == 0) goto L44;
        boolean r210 = true;
    L45:
        r22.add(new et(r111, r112, r23, r24, r25, r26, r27, r28, r29, r210, r10.getLong(r20), r10.getLong(r21)));     // Catch: Throwable -> L50
        goto L16
    L44:
        r210 = false;
        goto L45
    L40:
        r27 = r10.getString(r16);     // Catch: Throwable -> L50
        goto L41
    L36:
        r26 = r10.getString(r15);     // Catch: Throwable -> L50
        goto L38
    L32:
        r25 = r10.getString(r14);     // Catch: Throwable -> L50
        goto L34
    L28:
        r23 = r10.getString(r12);     // Catch: Throwable -> L50
        goto L29
    L24:
        r112 = r10.getString(r11);     // Catch: Throwable -> L50
        goto L26
    L20:
        r111 = r10.getString(r0);     // Catch: Throwable -> L50
        goto L22
    L46:
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L50
        r10.close();     // Catch: Throwable -> L56
        r110.release();     // Catch: Throwable -> L56
        this.__db.endTransaction();
        return r22;
    L50:
        th = th;
    L54:
        r10.close();     // Catch: Throwable -> L56
        r110.release();     // Catch: Throwable -> L56
        throw th;     // Catch: Throwable -> L56
    L52:
        th = th;
        r110 = r7;
    L56:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    L9:
        r7.bindString(r9, r36);
        goto L10
    }

    @Override // com.obric.memorydata.database.dao.ProactiveInspirationDao
    public List<ProactiveInspirationRecommendationRow> listJoinedRowsByIds(List<Long> r3) {
        return ProactiveInspirationDao.DefaultImpls.listJoinedRowsByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.ProactiveInspirationDao
    public Map<String, ez> listRecommendationsByIds(List<String> r3) {
        return ProactiveInspirationDao.DefaultImpls.listRecommendationsByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.ProactiveInspirationDao
    public List<ez> listRecommendationsByIdsRaw(List<String> r46) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r46, List.class, "com.obric.memorydata.plugin");
        StringBuilder r3 = StringUtil.newStringBuilder();
        r3.append("SELECT * FROM ProactiveRecommendations WHERE recommend_id IN (");
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
        int r0 = CursorUtil.getColumnIndexOrThrow(r8, "recommend_id");     // Catch: Throwable -> L72
        int r9 = CursorUtil.getColumnIndexOrThrow(r8, "task_id");     // Catch: Throwable -> L72
        int r10 = CursorUtil.getColumnIndexOrThrow(r8, "subscription_id");     // Catch: Throwable -> L72
        int r11 = CursorUtil.getColumnIndexOrThrow(r8, "recommend_text");     // Catch: Throwable -> L72
        int r12 = CursorUtil.getColumnIndexOrThrow(r8, "emoji");     // Catch: Throwable -> L72
        int r13 = CursorUtil.getColumnIndexOrThrow(r8, "action_execute_instruction");     // Catch: Throwable -> L72
        int r14 = CursorUtil.getColumnIndexOrThrow(r8, "action_context");     // Catch: Throwable -> L72
        int r15 = CursorUtil.getColumnIndexOrThrow(r8, "source_packages");     // Catch: Throwable -> L72
        int r16 = CursorUtil.getColumnIndexOrThrow(r8, "created");     // Catch: Throwable -> L72
        int r17 = CursorUtil.getColumnIndexOrThrow(r8, "updated");     // Catch: Throwable -> L72
        int r18 = CursorUtil.getColumnIndexOrThrow(r8, "is_delete");     // Catch: Throwable -> L72
        int r19 = CursorUtil.getColumnIndexOrThrow(r8, "score");     // Catch: Throwable -> L72
        int r20 = CursorUtil.getColumnIndexOrThrow(r8, InfoRequestQPSOptTraceLogger.REASON);     // Catch: Throwable -> L72
        int r21 = CursorUtil.getColumnIndexOrThrow(r8, "status");     // Catch: Throwable -> L72
        RoomSQLiteQuery r110 = r5;
        int r111 = CursorUtil.getColumnIndexOrThrow(r8, "type");     // Catch: Throwable -> L70
        int r112 = CursorUtil.getColumnIndexOrThrow(r8, "timestamp");     // Catch: Throwable -> L70
        int r113 = CursorUtil.getColumnIndexOrThrow(r8, OaidModel.KEY_ID);     // Catch: Throwable -> L70
        int r22 = r21;
        ArrayList r23 = new ArrayList(r8.getCount());     // Catch: Throwable -> L70
    L14:
        if (r8.moveToNext() == false) goto L68;
        if (r8.isNull(r0) == false) goto L19;
        String r24 = null;
    L21:
        if (r8.isNull(r9) == false) goto L23;
        String r25 = null;
    L25:
        if (r8.isNull(r10) == false) goto L27;
        String r26 = null;
    L29:
        if (r8.isNull(r11) == false) goto L31;
        String r27 = null;
    L33:
        if (r8.isNull(r12) == false) goto L35;
        String r28 = null;
    L37:
        if (r8.isNull(r13) == false) goto L39;
        String r29 = null;
    L41:
        if (r8.isNull(r14) == false) goto L43;
        String r210 = null;
    L45:
        if (r8.isNull(r15) == false) goto L47;
        String r211 = null;
    L48:
        long r30 = r8.getLong(r16);     // Catch: Throwable -> L70
        long r32 = r8.getLong(r17);     // Catch: Throwable -> L70
        if (r8.getInt(r18) == 0) goto L51;
        boolean r34 = true;
    L52:
        double r35 = r8.getDouble(r19);     // Catch: Throwable -> L70
        if (r8.isNull(r20) == false) goto L55;
        String r37 = null;
    L57:
        if (r8.isNull(r22) == false) goto L60;
        String r38 = null;
    L59:
        int r44 = r111;
        int r114 = r0;
        if (r8.isNull(r44) == false) goto L65;
        String r39 = null;
    L64:
        int r45 = r112;
        int r31 = r113;
        r113 = r31;
        r23.add(new ez(r24, r25, r26, r27, r28, r29, r210, r211, r30, r32, r34, r35, r37, r38, r39, r8.getLong(r45), r8.getLong(r31)));     // Catch: Throwable -> L70
        r0 = r114;
        r111 = r44;
        r112 = r45;
        r22 = r22;
        goto L14
    L65:
        r39 = r8.getString(r44);     // Catch: Throwable -> L70
        goto L64
    L60:
        r38 = r8.getString(r22);     // Catch: Throwable -> L70
        goto L59
    L55:
        r37 = r8.getString(r20);     // Catch: Throwable -> L70
        goto L57
    L51:
        r34 = false;
        goto L52
    L47:
        r211 = r8.getString(r15);     // Catch: Throwable -> L70
        goto L48
    L43:
        r210 = r8.getString(r14);     // Catch: Throwable -> L70
        goto L45
    L39:
        r29 = r8.getString(r13);     // Catch: Throwable -> L70
        goto L41
    L35:
        r28 = r8.getString(r12);     // Catch: Throwable -> L70
        goto L37
    L31:
        r27 = r8.getString(r11);     // Catch: Throwable -> L70
        goto L33
    L27:
        r26 = r8.getString(r10);     // Catch: Throwable -> L70
        goto L29
    L23:
        r25 = r8.getString(r9);     // Catch: Throwable -> L70
        goto L25
    L19:
        r24 = r8.getString(r0);     // Catch: Throwable -> L70
        goto L21
    L68:
        r8.close();
        r110.release();
        return r23;
    L70:
        th = th;
    L74:
        r8.close();
        r110.release();
        throw th;
    L72:
        th = th;
        r110 = r5;
        goto L74
    }

    @Override // com.obric.memorydata.database.dao.ProactiveInspirationDao
    public List<et> listSeedRowsByIds(List<Long> r34) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r34, List.class, "com.obric.memorydata.plugin");
        StringBuilder r3 = StringUtil.newStringBuilder();
        r3.append("SELECT * FROM ProactiveInspiration WHERE id IN (");
        int r4 = r1.size();
        StringUtil.appendPlaceholders(r3, r4);
        r3.append(") AND is_delete = 0");
        RoomSQLiteQuery r5 = RoomSQLiteQuery.acquire(r3.toString(), r4 + 0);
        Iterator r2 = r1.iterator();
        int r6 = 1;
    L4:
        if (r2.hasNext() == false) goto L6;
        r5.bindLong(r6, ((Long) ZeusTransformUtils.preCheckCast(r2.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
        r6 = r6 + 1;
        goto L4
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r7 = DBUtil.query(this.__db, r5, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r7, "inspiration_id");     // Catch: Throwable -> L42
        int r8 = CursorUtil.getColumnIndexOrThrow(r7, "task_id");     // Catch: Throwable -> L42
        int r9 = CursorUtil.getColumnIndexOrThrow(r7, "recommend_id");     // Catch: Throwable -> L42
        int r10 = CursorUtil.getColumnIndexOrThrow(r7, "recommend_status");     // Catch: Throwable -> L42
        int r11 = CursorUtil.getColumnIndexOrThrow(r7, "feedback_action");     // Catch: Throwable -> L42
        int r12 = CursorUtil.getColumnIndexOrThrow(r7, "user_feedback");     // Catch: Throwable -> L42
        int r13 = CursorUtil.getColumnIndexOrThrow(r7, "recommendation_snapshot");     // Catch: Throwable -> L42
        int r14 = CursorUtil.getColumnIndexOrThrow(r7, "created");     // Catch: Throwable -> L42
        int r15 = CursorUtil.getColumnIndexOrThrow(r7, "updated");     // Catch: Throwable -> L42
        int r16 = CursorUtil.getColumnIndexOrThrow(r7, "is_delete");     // Catch: Throwable -> L42
        int r17 = CursorUtil.getColumnIndexOrThrow(r7, "timestamp");     // Catch: Throwable -> L42
        int r18 = CursorUtil.getColumnIndexOrThrow(r7, OaidModel.KEY_ID);     // Catch: Throwable -> L42
        ArrayList r19 = new ArrayList(r7.getCount());     // Catch: Throwable -> L42
    L8:
        if (r7.moveToNext() == false) goto L40;
        if (r7.isNull(r0) == false) goto L13;
        String r110 = null;
    L15:
        if (r7.isNull(r8) == false) goto L17;
        String r111 = null;
    L19:
        if (r7.isNull(r9) == false) goto L21;
        String r112 = null;
    L22:
        int r20 = r7.getInt(r10);     // Catch: Throwable -> L42
        if (r7.isNull(r11) == false) goto L25;
        String r21 = null;
    L27:
        if (r7.isNull(r12) == false) goto L29;
        String r22 = null;
    L31:
        if (r7.isNull(r13) == false) goto L33;
        String r23 = null;
    L34:
        long r24 = r7.getLong(r14);     // Catch: Throwable -> L42
        long r26 = r7.getLong(r15);     // Catch: Throwable -> L42
        if (r7.getInt(r16) == 0) goto L37;
        boolean r28 = true;
    L38:
        r19.add(new et(r110, r111, r112, r20, r21, r22, r23, r24, r26, r28, r7.getLong(r17), r7.getLong(r18)));     // Catch: Throwable -> L42
        goto L8
    L37:
        r28 = false;
        goto L38
    L33:
        r23 = r7.getString(r13);     // Catch: Throwable -> L42
        goto L34
    L29:
        r22 = r7.getString(r12);     // Catch: Throwable -> L42
        goto L31
    L25:
        r21 = r7.getString(r11);     // Catch: Throwable -> L42
        goto L27
    L21:
        r112 = r7.getString(r9);     // Catch: Throwable -> L42
        goto L22
    L17:
        r111 = r7.getString(r8);     // Catch: Throwable -> L42
        goto L19
    L13:
        r110 = r7.getString(r0);     // Catch: Throwable -> L42
        goto L15
    L40:
        r7.close();
        r5.release();
        return r19;
    L42:
        th = move-exception;
        r7.close();
        r5.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.ProactiveInspirationDao
    public i<List<ProactiveDayHeaderRow>> observeAllDayHeadersByRecommendStatuses(List<Integer> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT DATE(datetime(created / 1000, 'unixepoch', 'localtime')) AS dayKey, CAST(strftime('%s', DATE(datetime(created / 1000, 'unixepoch', 'localtime')) || ' 00:00:00', 'utc') AS INTEGER) * 1000 AS dayStartMillis, COUNT(*) AS count FROM ProactiveInspiration i WHERE i.id IN (SELECT MAX(id) FROM ProactiveInspiration WHERE recommend_status IN (");
        int r2 = r9.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(") AND is_delete = 0 GROUP BY inspiration_id) GROUP BY dayKey ORDER BY dayStartMillis DESC");
        final RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), r2 + 0);
        Iterator r10 = r9.iterator();
        int r4 = 1;
    L4:
        if (r10.hasNext() == false) goto L7;
        r1.bindLong(r4, ((Integer) ZeusTransformUtils.preCheckCast(r10.next(), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r4 = r4 + 1;
        goto L4
    L7:
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"ProactiveInspiration"}, new AnonymousClass4(this, r1));
    }

    @Override // com.obric.memorydata.database.dao.ProactiveInspirationDao
    public i<List<ProactiveInspirationBatchSeedRow>> observeBatchSeedRowsByRecommendStatuses(List<Integer> r3) {
        return ProactiveInspirationDao.DefaultImpls.observeBatchSeedRowsByRecommendStatuses(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.ProactiveInspirationDao
    public i<List<ProactiveInspirationBatchSeedSnapshotRow>> observeBatchSeedSnapshotRowsByRecommendStatuses(List<Integer> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT i.id AS inspirationRowId, i.updated AS inspirationUpdated, i.recommend_status AS recommendStatus, i.recommend_id AS recommendId, i.recommendation_snapshot AS recommendationSnapshot FROM ProactiveInspiration i WHERE i.id IN (SELECT MAX(id) FROM ProactiveInspiration WHERE recommend_status IN (");
        int r2 = r9.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(") AND is_delete = 0 GROUP BY inspiration_id) ORDER BY i.created DESC, i.id DESC");
        final RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), r2 + 0);
        Iterator r10 = r9.iterator();
        int r4 = 1;
    L4:
        if (r10.hasNext() == false) goto L7;
        r1.bindLong(r4, ((Integer) ZeusTransformUtils.preCheckCast(r10.next(), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r4 = r4 + 1;
        goto L4
    L7:
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"ProactiveInspiration"}, new AnonymousClass6(this, r1));
    }

    @Override // com.obric.memorydata.database.dao.ProactiveInspirationDao
    public i<List<ProactiveInspirationRecommendationRow>> observeDayJoinedByDayKey(List<Integer> r3, String r4, int r5, int r6) {
        return ProactiveInspirationDao.DefaultImpls.observeDayJoinedByDayKey(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    @Override // com.obric.memorydata.database.dao.ProactiveInspirationDao
    public i<List<et>> observeDaySeedRowsByDayKey(List<Integer> r9, String r10, int r11, int r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT * FROM ProactiveInspiration WHERE id IN (SELECT MAX(id) FROM ProactiveInspiration WHERE recommend_status IN (");
        int r2 = r13.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(") AND is_delete = 0 GROUP BY inspiration_id) AND DATE(datetime(created / 1000, 'unixepoch', 'localtime')) = ");
        r0.append("?");
        r0.append(" ORDER BY created DESC, id DESC LIMIT ");
        r0.append("?");
        r0.append(" OFFSET ");
        r0.append("?");
        int r3 = r2 + 3;
        final RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), r3);
        Iterator r14 = r13.iterator();
        int r5 = 1;
    L4:
        if (r14.hasNext() == false) goto L6;
        r1.bindLong(r5, ((Integer) ZeusTransformUtils.preCheckCast(r14.next(), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r5 = r5 + 1;
        goto L4
    L6:
        int r15 = r2 + 1;
        if (r10 != null) goto L9;
        r1.bindNull(r15);
    L10:
        r1.bindLong(r2 + 2, r12);
        r1.bindLong(r3, r11);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"ProactiveInspiration"}, new AnonymousClass5(this, r1));
    L9:
        r1.bindString(r15, r10);
        goto L10
    }

    @Override // com.obric.memorydata.database.dao.ProactiveInspirationDao
    public int updateIsDeleteBySubscriptionId(String r4, boolean r5, long r6) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfUpdateIsDeleteBySubscriptionId.acquire();
        r0.bindLong(1, r5 ? 1 : 0);
        r0.bindLong(2, r6);
        if (r4 != null) goto L5;
        r0.bindNull(3);
    L6:
        this.__db.beginTransaction();
        int r7 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateIsDeleteBySubscriptionId.release(r0);
        return r7;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateIsDeleteBySubscriptionId.release(r0);
        throw th;
    L5:
        r0.bindString(3, r4);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.ProactiveInspirationDao
    public int updateRecommendStatus(String r4, int r5, long r6) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfUpdateRecommendStatus.acquire();
        r0.bindLong(1, r5);
        r0.bindLong(2, r6);
        if (r4 != null) goto L5;
        r0.bindNull(3);
    L6:
        this.__db.beginTransaction();
        int r7 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateRecommendStatus.release(r0);
        return r7;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateRecommendStatus.release(r0);
        throw th;
    L5:
        r0.bindString(3, r4);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.ProactiveInspirationDao
    public void upsert(et r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfProactiveInspirationEntity.insert(r2);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
