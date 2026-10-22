package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
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
import com.obric.memorydata.database.entity.ez;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
public final class ProactiveRecommendationsDao_Impl implements ProactiveRecommendationsDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<ez> __insertionAdapterOfProactiveRecommendationEntity;
    private final SharedSQLiteStatement __preparedStmtOfUpdateActionExecuteInstruction;
    private final SharedSQLiteStatement __preparedStmtOfUpdateIsDeleteBySubscriptionId;
    private final SharedSQLiteStatement __preparedStmtOfUpdateStatus;
    private final EntityDeletionOrUpdateAdapter<ez> __updateAdapterOfProactiveRecommendationEntity;

    public ProactiveRecommendationsDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfProactiveRecommendationEntity = new AnonymousClass1(this, r2);
        this.__updateAdapterOfProactiveRecommendationEntity = new AnonymousClass2(this, r2);
        this.__preparedStmtOfUpdateStatus = new AnonymousClass3(this, r2);
        this.__preparedStmtOfUpdateActionExecuteInstruction = new AnonymousClass4(this, r2);
        this.__preparedStmtOfUpdateIsDeleteBySubscriptionId = new AnonymousClass5(this, r2);
    }

    static /* synthetic */ RoomDatabase access$000(ProactiveRecommendationsDao_Impl r0) {
        return r0.__db;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.ProactiveRecommendationsDao
    public ez getById(String r43) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM ProactiveRecommendations WHERE recommend_id = ? LIMIT 1", 1);
        if (r43 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, "recommend_id");     // Catch: Throwable -> L66
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "task_id");     // Catch: Throwable -> L66
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "subscription_id");     // Catch: Throwable -> L66
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "recommend_text");     // Catch: Throwable -> L66
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "emoji");     // Catch: Throwable -> L66
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "action_execute_instruction");     // Catch: Throwable -> L66
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, "action_context");     // Catch: Throwable -> L66
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "source_packages");     // Catch: Throwable -> L66
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, "created");     // Catch: Throwable -> L66
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "updated");     // Catch: Throwable -> L66
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, "is_delete");     // Catch: Throwable -> L66
        int r1 = CursorUtil.getColumnIndexOrThrow(r5, "score");     // Catch: Throwable -> L66
        int r3 = CursorUtil.getColumnIndexOrThrow(r5, InfoRequestQPSOptTraceLogger.REASON);     // Catch: Throwable -> L66
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, "status");     // Catch: Throwable -> L66
        RoomSQLiteQuery r16 = r2;
        int r17 = CursorUtil.getColumnIndexOrThrow(r5, "type");     // Catch: Throwable -> L64
        int r18 = CursorUtil.getColumnIndexOrThrow(r5, "timestamp");     // Catch: Throwable -> L64
        int r19 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L64
        if (r5.moveToFirst() == true) goto L12;
        ez r20 = null;
    L62:
        r5.close();
        r16.release();
        return r20;
    L12:
        if (r5.isNull(r0) == false) goto L14;
        String r21 = null;
    L16:
        if (r5.isNull(r6) == false) goto L18;
        String r22 = null;
    L20:
        if (r5.isNull(r7) == false) goto L22;
        String r23 = null;
    L24:
        if (r5.isNull(r8) == false) goto L26;
        String r24 = null;
    L28:
        if (r5.isNull(r9) == false) goto L30;
        String r25 = null;
    L32:
        if (r5.isNull(r10) == false) goto L34;
        String r26 = null;
    L36:
        if (r5.isNull(r11) == false) goto L38;
        String r27 = null;
    L40:
        if (r5.isNull(r12) == false) goto L42;
        String r28 = null;
    L43:
        long r29 = r5.getLong(r13);     // Catch: Throwable -> L64
        long r30 = r5.getLong(r14);     // Catch: Throwable -> L64
        if (r5.getInt(r15) == 0) goto L46;
        boolean r32 = true;
    L47:
        double r33 = r5.getDouble(r1);     // Catch: Throwable -> L64
        if (r5.isNull(r3) == false) goto L50;
        String r35 = null;
    L52:
        if (r5.isNull(r4) == false) goto L54;
        String r36 = null;
    L56:
        if (r5.isNull(r17) == false) goto L58;
        String r37 = null;
    L59:
        r20 = new ez(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r32, r33, r35, r36, r37, r5.getLong(r18), r5.getLong(r19));     // Catch: Throwable -> L64
        goto L62
    L58:
        r37 = r5.getString(r17);     // Catch: Throwable -> L64
        goto L59
    L54:
        r36 = r5.getString(r4);     // Catch: Throwable -> L64
        goto L56
    L50:
        r35 = r5.getString(r3);     // Catch: Throwable -> L64
        goto L52
    L46:
        r32 = false;
        goto L47
    L42:
        r28 = r5.getString(r12);     // Catch: Throwable -> L64
        goto L43
    L38:
        r27 = r5.getString(r11);     // Catch: Throwable -> L64
        goto L40
    L34:
        r26 = r5.getString(r10);     // Catch: Throwable -> L64
        goto L36
    L30:
        r25 = r5.getString(r9);     // Catch: Throwable -> L64
        goto L32
    L26:
        r24 = r5.getString(r8);     // Catch: Throwable -> L64
        goto L28
    L22:
        r23 = r5.getString(r7);     // Catch: Throwable -> L64
        goto L24
    L18:
        r22 = r5.getString(r6);     // Catch: Throwable -> L64
        goto L20
    L14:
        r21 = r5.getString(r0);     // Catch: Throwable -> L64
    L64:
        th = th;
    L68:
        r5.close();
        r16.release();
        throw th;
    L66:
        th = th;
        r16 = r2;
        goto L68
    L5:
        r2.bindString(1, r43);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.ProactiveRecommendationsDao
    public List<ez> listBySubscriptionId(String r46) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM ProactiveRecommendations WHERE subscription_id = ? ORDER BY created DESC", 1);
        if (r46 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, "recommend_id");     // Catch: Throwable -> L68
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "task_id");     // Catch: Throwable -> L68
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "subscription_id");     // Catch: Throwable -> L68
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "recommend_text");     // Catch: Throwable -> L68
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "emoji");     // Catch: Throwable -> L68
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "action_execute_instruction");     // Catch: Throwable -> L68
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, "action_context");     // Catch: Throwable -> L68
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "source_packages");     // Catch: Throwable -> L68
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, "created");     // Catch: Throwable -> L68
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "updated");     // Catch: Throwable -> L68
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, "is_delete");     // Catch: Throwable -> L68
        int r1 = CursorUtil.getColumnIndexOrThrow(r5, "score");     // Catch: Throwable -> L68
        int r3 = CursorUtil.getColumnIndexOrThrow(r5, InfoRequestQPSOptTraceLogger.REASON);     // Catch: Throwable -> L68
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, "status");     // Catch: Throwable -> L68
        RoomSQLiteQuery r16 = r2;
        int r17 = CursorUtil.getColumnIndexOrThrow(r5, "type");     // Catch: Throwable -> L66
        int r18 = CursorUtil.getColumnIndexOrThrow(r5, "timestamp");     // Catch: Throwable -> L66
        int r19 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L66
        int r20 = r4;
        ArrayList r21 = new ArrayList(r5.getCount());     // Catch: Throwable -> L66
    L10:
        if (r5.moveToNext() == false) goto L64;
        if (r5.isNull(r0) == false) goto L15;
        String r22 = null;
    L17:
        if (r5.isNull(r6) == false) goto L19;
        String r23 = null;
    L21:
        if (r5.isNull(r7) == false) goto L23;
        String r24 = null;
    L25:
        if (r5.isNull(r8) == false) goto L27;
        String r25 = null;
    L29:
        if (r5.isNull(r9) == false) goto L31;
        String r26 = null;
    L33:
        if (r5.isNull(r10) == false) goto L35;
        String r27 = null;
    L37:
        if (r5.isNull(r11) == false) goto L39;
        String r28 = null;
    L41:
        if (r5.isNull(r12) == false) goto L43;
        String r29 = null;
    L44:
        long r30 = r5.getLong(r13);     // Catch: Throwable -> L66
        long r32 = r5.getLong(r14);     // Catch: Throwable -> L66
        if (r5.getInt(r15) == 0) goto L47;
        boolean r34 = true;
    L48:
        double r35 = r5.getDouble(r1);     // Catch: Throwable -> L66
        if (r5.isNull(r3) == false) goto L51;
        String r37 = null;
    L53:
        if (r5.isNull(r20) == false) goto L56;
        String r38 = null;
    L55:
        int r44 = r17;
        int r110 = r0;
        if (r5.isNull(r44) == false) goto L61;
        String r39 = null;
    L60:
        int r45 = r18;
        int r31 = r19;
        r19 = r31;
        r21.add(new ez(r22, r23, r24, r25, r26, r27, r28, r29, r30, r32, r34, r35, r37, r38, r39, r5.getLong(r45), r5.getLong(r31)));     // Catch: Throwable -> L66
        r0 = r110;
        r17 = r44;
        r18 = r45;
        r20 = r20;
        goto L10
    L61:
        r39 = r5.getString(r44);     // Catch: Throwable -> L66
        goto L60
    L56:
        r38 = r5.getString(r20);     // Catch: Throwable -> L66
        goto L55
    L51:
        r37 = r5.getString(r3);     // Catch: Throwable -> L66
        goto L53
    L47:
        r34 = false;
        goto L48
    L43:
        r29 = r5.getString(r12);     // Catch: Throwable -> L66
        goto L44
    L39:
        r28 = r5.getString(r11);     // Catch: Throwable -> L66
        goto L41
    L35:
        r27 = r5.getString(r10);     // Catch: Throwable -> L66
        goto L37
    L31:
        r26 = r5.getString(r9);     // Catch: Throwable -> L66
        goto L33
    L27:
        r25 = r5.getString(r8);     // Catch: Throwable -> L66
        goto L29
    L23:
        r24 = r5.getString(r7);     // Catch: Throwable -> L66
        goto L25
    L19:
        r23 = r5.getString(r6);     // Catch: Throwable -> L66
        goto L21
    L15:
        r22 = r5.getString(r0);     // Catch: Throwable -> L66
        goto L17
    L64:
        r5.close();
        r16.release();
        return r21;
    L66:
        th = th;
    L70:
        r5.close();
        r16.release();
        throw th;
    L68:
        th = th;
        r16 = r2;
        goto L70
    L5:
        r2.bindString(1, r46);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.ProactiveRecommendationsDao
    public List<ez> listTopAll(int r46) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM ProactiveRecommendations ORDER BY score DESC, created DESC LIMIT ?", 1);
        r1.bindLong(1, r46);
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, "recommend_id");     // Catch: Throwable -> L64
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "task_id");     // Catch: Throwable -> L64
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "subscription_id");     // Catch: Throwable -> L64
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "recommend_text");     // Catch: Throwable -> L64
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "emoji");     // Catch: Throwable -> L64
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "action_execute_instruction");     // Catch: Throwable -> L64
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, "action_context");     // Catch: Throwable -> L64
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "source_packages");     // Catch: Throwable -> L64
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, "created");     // Catch: Throwable -> L64
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "updated");     // Catch: Throwable -> L64
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, "is_delete");     // Catch: Throwable -> L64
        int r2 = CursorUtil.getColumnIndexOrThrow(r5, "score");     // Catch: Throwable -> L64
        int r3 = CursorUtil.getColumnIndexOrThrow(r5, InfoRequestQPSOptTraceLogger.REASON);     // Catch: Throwable -> L64
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, "status");     // Catch: Throwable -> L64
        RoomSQLiteQuery r16 = r1;
        int r17 = CursorUtil.getColumnIndexOrThrow(r5, "type");     // Catch: Throwable -> L62
        int r18 = CursorUtil.getColumnIndexOrThrow(r5, "timestamp");     // Catch: Throwable -> L62
        int r19 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L62
        int r20 = r4;
        ArrayList r21 = new ArrayList(r5.getCount());     // Catch: Throwable -> L62
    L6:
        if (r5.moveToNext() == false) goto L60;
        if (r5.isNull(r0) == false) goto L11;
        String r22 = null;
    L13:
        if (r5.isNull(r6) == false) goto L15;
        String r23 = null;
    L17:
        if (r5.isNull(r7) == false) goto L19;
        String r24 = null;
    L21:
        if (r5.isNull(r8) == false) goto L23;
        String r25 = null;
    L25:
        if (r5.isNull(r9) == false) goto L27;
        String r26 = null;
    L29:
        if (r5.isNull(r10) == false) goto L31;
        String r27 = null;
    L33:
        if (r5.isNull(r11) == false) goto L35;
        String r28 = null;
    L37:
        if (r5.isNull(r12) == false) goto L39;
        String r29 = null;
    L40:
        long r30 = r5.getLong(r13);     // Catch: Throwable -> L62
        long r32 = r5.getLong(r14);     // Catch: Throwable -> L62
        if (r5.getInt(r15) == 0) goto L43;
        boolean r34 = true;
    L44:
        double r35 = r5.getDouble(r2);     // Catch: Throwable -> L62
        if (r5.isNull(r3) == false) goto L47;
        String r37 = null;
    L49:
        if (r5.isNull(r20) == false) goto L52;
        String r38 = null;
    L51:
        int r44 = r17;
        int r110 = r0;
        if (r5.isNull(r44) == false) goto L57;
        String r39 = null;
    L56:
        int r45 = r18;
        int r31 = r19;
        r19 = r31;
        r21.add(new ez(r22, r23, r24, r25, r26, r27, r28, r29, r30, r32, r34, r35, r37, r38, r39, r5.getLong(r45), r5.getLong(r31)));     // Catch: Throwable -> L62
        r0 = r110;
        r17 = r44;
        r18 = r45;
        r20 = r20;
        goto L6
    L57:
        r39 = r5.getString(r44);     // Catch: Throwable -> L62
        goto L56
    L52:
        r38 = r5.getString(r20);     // Catch: Throwable -> L62
        goto L51
    L47:
        r37 = r5.getString(r3);     // Catch: Throwable -> L62
        goto L49
    L43:
        r34 = false;
        goto L44
    L39:
        r29 = r5.getString(r12);     // Catch: Throwable -> L62
        goto L40
    L35:
        r28 = r5.getString(r11);     // Catch: Throwable -> L62
        goto L37
    L31:
        r27 = r5.getString(r10);     // Catch: Throwable -> L62
        goto L33
    L27:
        r26 = r5.getString(r9);     // Catch: Throwable -> L62
        goto L29
    L23:
        r25 = r5.getString(r8);     // Catch: Throwable -> L62
        goto L25
    L19:
        r24 = r5.getString(r7);     // Catch: Throwable -> L62
        goto L21
    L15:
        r23 = r5.getString(r6);     // Catch: Throwable -> L62
        goto L17
    L11:
        r22 = r5.getString(r0);     // Catch: Throwable -> L62
        goto L13
    L60:
        r5.close();
        r16.release();
        return r21;
    L62:
        th = th;
    L66:
        r5.close();
        r16.release();
        throw th;
    L64:
        th = th;
        r16 = r1;
        goto L66
    }

    @Override // com.obric.memorydata.database.dao.ProactiveRecommendationsDao
    public List<ez> listTopByStatus(String r45, int r46) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM ProactiveRecommendations WHERE status = ? ORDER BY score DESC, created DESC LIMIT ?", 2);
        if (r45 != null) goto L5;
        r2.bindNull(1);
    L6:
        r2.bindLong(2, r46);
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, "recommend_id");     // Catch: Throwable -> L68
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "task_id");     // Catch: Throwable -> L68
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "subscription_id");     // Catch: Throwable -> L68
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "recommend_text");     // Catch: Throwable -> L68
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "emoji");     // Catch: Throwable -> L68
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "action_execute_instruction");     // Catch: Throwable -> L68
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, "action_context");     // Catch: Throwable -> L68
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "source_packages");     // Catch: Throwable -> L68
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, "created");     // Catch: Throwable -> L68
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "updated");     // Catch: Throwable -> L68
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, "is_delete");     // Catch: Throwable -> L68
        int r1 = CursorUtil.getColumnIndexOrThrow(r5, "score");     // Catch: Throwable -> L68
        int r3 = CursorUtil.getColumnIndexOrThrow(r5, InfoRequestQPSOptTraceLogger.REASON);     // Catch: Throwable -> L68
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, "status");     // Catch: Throwable -> L68
        RoomSQLiteQuery r16 = r2;
        int r47 = CursorUtil.getColumnIndexOrThrow(r5, "type");     // Catch: Throwable -> L66
        int r17 = CursorUtil.getColumnIndexOrThrow(r5, "timestamp");     // Catch: Throwable -> L66
        int r18 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L66
        int r19 = r4;
        ArrayList r20 = new ArrayList(r5.getCount());     // Catch: Throwable -> L66
    L10:
        if (r5.moveToNext() == false) goto L64;
        if (r5.isNull(r0) == false) goto L15;
        String r21 = null;
    L17:
        if (r5.isNull(r6) == false) goto L19;
        String r22 = null;
    L21:
        if (r5.isNull(r7) == false) goto L23;
        String r23 = null;
    L25:
        if (r5.isNull(r8) == false) goto L27;
        String r24 = null;
    L29:
        if (r5.isNull(r9) == false) goto L31;
        String r25 = null;
    L33:
        if (r5.isNull(r10) == false) goto L35;
        String r26 = null;
    L37:
        if (r5.isNull(r11) == false) goto L39;
        String r27 = null;
    L41:
        if (r5.isNull(r12) == false) goto L43;
        String r28 = null;
    L44:
        long r29 = r5.getLong(r13);     // Catch: Throwable -> L66
        long r31 = r5.getLong(r14);     // Catch: Throwable -> L66
        if (r5.getInt(r15) == 0) goto L47;
        boolean r33 = true;
    L48:
        double r34 = r5.getDouble(r1);     // Catch: Throwable -> L66
        if (r5.isNull(r3) == false) goto L51;
        String r36 = null;
    L53:
        if (r5.isNull(r19) == false) goto L56;
        String r37 = null;
    L55:
        int r43 = r0;
        int r30 = r47;
        if (r5.isNull(r30) == false) goto L61;
        String r38 = null;
    L60:
        int r44 = r17;
        int r32 = r18;
        r18 = r32;
        r20.add(new ez(r21, r22, r23, r24, r25, r26, r27, r28, r29, r31, r33, r34, r36, r37, r38, r5.getLong(r44), r5.getLong(r32)));     // Catch: Throwable -> L66
        r0 = r43;
        r47 = r30;
        r17 = r44;
        r19 = r19;
        goto L10
    L61:
        r38 = r5.getString(r30);     // Catch: Throwable -> L66
        goto L60
    L56:
        r37 = r5.getString(r19);     // Catch: Throwable -> L66
        goto L55
    L51:
        r36 = r5.getString(r3);     // Catch: Throwable -> L66
        goto L53
    L47:
        r33 = false;
        goto L48
    L43:
        r28 = r5.getString(r12);     // Catch: Throwable -> L66
        goto L44
    L39:
        r27 = r5.getString(r11);     // Catch: Throwable -> L66
        goto L41
    L35:
        r26 = r5.getString(r10);     // Catch: Throwable -> L66
        goto L37
    L31:
        r25 = r5.getString(r9);     // Catch: Throwable -> L66
        goto L33
    L27:
        r24 = r5.getString(r8);     // Catch: Throwable -> L66
        goto L29
    L23:
        r23 = r5.getString(r7);     // Catch: Throwable -> L66
        goto L25
    L19:
        r22 = r5.getString(r6);     // Catch: Throwable -> L66
        goto L21
    L15:
        r21 = r5.getString(r0);     // Catch: Throwable -> L66
        goto L17
    L64:
        r5.close();
        r16.release();
        return r20;
    L66:
        th = th;
    L70:
        r5.close();
        r16.release();
        throw th;
    L68:
        th = th;
        r16 = r2;
        goto L70
    L5:
        r2.bindString(1, r45);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.ProactiveRecommendationsDao
    public List<ez> listTopByStatuses(List<String> r45, int r46) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r45, List.class, "com.obric.memorydata.plugin");
        StringBuilder r3 = StringUtil.newStringBuilder();
        r3.append("SELECT * FROM ProactiveRecommendations WHERE status IN (");
        int r4 = r1.size();
        StringUtil.appendPlaceholders(r3, r4);
        r3.append(") ORDER BY score DESC, created DESC LIMIT ");
        r3.append("?");
        int r5 = r4 + 1;
        RoomSQLiteQuery r6 = RoomSQLiteQuery.acquire(r3.toString(), r5);
        Iterator r2 = r1.iterator();
        int r7 = 1;
    L4:
        if (r2.hasNext() == false) goto L10;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L8;
        r6.bindNull(r7);
    L9:
        r7 = r7 + 1;
        goto L4
    L8:
        r6.bindString(r7, r8);
        goto L9
    L10:
        r6.bindLong(r5, r46);
        this.__db.assertNotSuspendingTransaction();
        Cursor r9 = DBUtil.query(this.__db, r6, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r9, "recommend_id");     // Catch: Throwable -> L72
        int r10 = CursorUtil.getColumnIndexOrThrow(r9, "task_id");     // Catch: Throwable -> L72
        int r11 = CursorUtil.getColumnIndexOrThrow(r9, "subscription_id");     // Catch: Throwable -> L72
        int r12 = CursorUtil.getColumnIndexOrThrow(r9, "recommend_text");     // Catch: Throwable -> L72
        int r13 = CursorUtil.getColumnIndexOrThrow(r9, "emoji");     // Catch: Throwable -> L72
        int r14 = CursorUtil.getColumnIndexOrThrow(r9, "action_execute_instruction");     // Catch: Throwable -> L72
        int r15 = CursorUtil.getColumnIndexOrThrow(r9, "action_context");     // Catch: Throwable -> L72
        int r16 = CursorUtil.getColumnIndexOrThrow(r9, "source_packages");     // Catch: Throwable -> L72
        int r17 = CursorUtil.getColumnIndexOrThrow(r9, "created");     // Catch: Throwable -> L72
        int r18 = CursorUtil.getColumnIndexOrThrow(r9, "updated");     // Catch: Throwable -> L72
        int r19 = CursorUtil.getColumnIndexOrThrow(r9, "is_delete");     // Catch: Throwable -> L72
        int r20 = CursorUtil.getColumnIndexOrThrow(r9, "score");     // Catch: Throwable -> L72
        int r21 = CursorUtil.getColumnIndexOrThrow(r9, InfoRequestQPSOptTraceLogger.REASON);     // Catch: Throwable -> L72
        int r22 = CursorUtil.getColumnIndexOrThrow(r9, "status");     // Catch: Throwable -> L72
        RoomSQLiteQuery r110 = r6;
        int r47 = CursorUtil.getColumnIndexOrThrow(r9, "type");     // Catch: Throwable -> L70
        int r111 = CursorUtil.getColumnIndexOrThrow(r9, "timestamp");     // Catch: Throwable -> L70
        int r112 = CursorUtil.getColumnIndexOrThrow(r9, OaidModel.KEY_ID);     // Catch: Throwable -> L70
        int r113 = r22;
        ArrayList r23 = new ArrayList(r9.getCount());     // Catch: Throwable -> L70
    L14:
        if (r9.moveToNext() == false) goto L68;
        if (r9.isNull(r0) == false) goto L19;
        String r24 = null;
    L21:
        if (r9.isNull(r10) == false) goto L23;
        String r25 = null;
    L25:
        if (r9.isNull(r11) == false) goto L27;
        String r26 = null;
    L29:
        if (r9.isNull(r12) == false) goto L31;
        String r27 = null;
    L33:
        if (r9.isNull(r13) == false) goto L35;
        String r28 = null;
    L37:
        if (r9.isNull(r14) == false) goto L39;
        String r29 = null;
    L41:
        if (r9.isNull(r15) == false) goto L43;
        String r210 = null;
    L45:
        if (r9.isNull(r16) == false) goto L47;
        String r211 = null;
    L48:
        long r212 = r9.getLong(r17);     // Catch: Throwable -> L70
        long r31 = r9.getLong(r18);     // Catch: Throwable -> L70
        if (r9.getInt(r19) == 0) goto L51;
        boolean r33 = true;
    L52:
        double r34 = r9.getDouble(r20);     // Catch: Throwable -> L70
        if (r9.isNull(r21) == false) goto L55;
        String r36 = null;
    L57:
        if (r9.isNull(r113) == false) goto L60;
        String r37 = null;
    L59:
        int r43 = r0;
        int r30 = r47;
        if (r9.isNull(r30) == false) goto L65;
        String r38 = null;
    L64:
        int r44 = r111;
        int r32 = r112;
        r112 = r32;
        r23.add(new ez(r24, r25, r26, r27, r28, r29, r210, r211, r212, r31, r33, r34, r36, r37, r38, r9.getLong(r44), r9.getLong(r32)));     // Catch: Throwable -> L70
        r0 = r43;
        r47 = r30;
        r111 = r44;
        r113 = r113;
        goto L14
    L65:
        r38 = r9.getString(r30);     // Catch: Throwable -> L70
        goto L64
    L60:
        r37 = r9.getString(r113);     // Catch: Throwable -> L70
        goto L59
    L55:
        r36 = r9.getString(r21);     // Catch: Throwable -> L70
        goto L57
    L51:
        r33 = false;
        goto L52
    L47:
        r211 = r9.getString(r16);     // Catch: Throwable -> L70
        goto L48
    L43:
        r210 = r9.getString(r15);     // Catch: Throwable -> L70
        goto L45
    L39:
        r29 = r9.getString(r14);     // Catch: Throwable -> L70
        goto L41
    L35:
        r28 = r9.getString(r13);     // Catch: Throwable -> L70
        goto L37
    L31:
        r27 = r9.getString(r12);     // Catch: Throwable -> L70
        goto L33
    L27:
        r26 = r9.getString(r11);     // Catch: Throwable -> L70
        goto L29
    L23:
        r25 = r9.getString(r10);     // Catch: Throwable -> L70
        goto L25
    L19:
        r24 = r9.getString(r0);     // Catch: Throwable -> L70
        goto L21
    L68:
        r9.close();
        r110.release();
        return r23;
    L70:
        th = th;
    L74:
        r9.close();
        r110.release();
        throw th;
    L72:
        th = th;
        r110 = r6;
        goto L74
    }

    @Override // com.obric.memorydata.database.dao.ProactiveRecommendationsDao
    public i<List<ez>> observeTopAll(int r5) {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM ProactiveRecommendations ORDER BY score DESC, created DESC LIMIT ?", 1);
        r0.bindLong(1, r5);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"ProactiveRecommendations"}, new AnonymousClass6(this, r0));
    }

    @Override // com.obric.memorydata.database.dao.ProactiveRecommendationsDao
    public i<List<ez>> observeTopByStatus(String r4, int r5) {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM ProactiveRecommendations WHERE status = ? ORDER BY score DESC, created DESC LIMIT ?", 2);
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r5);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"ProactiveRecommendations"}, new AnonymousClass7(this, r0));
    L5:
        r0.bindString(1, r4);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.ProactiveRecommendationsDao
    public i<List<ez>> observeTopByStatuses(List<String> r7, int r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT * FROM ProactiveRecommendations WHERE status IN (");
        int r2 = r9.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(") ORDER BY score DESC, created DESC LIMIT ");
        r0.append("?");
        int r3 = 1;
        int r4 = r2 + 1;
        final RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), r4);
        Iterator r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L8;
        r1.bindNull(r3);
    L9:
        r3 = r3 + 1;
        goto L4
    L8:
        r1.bindString(r3, r5);
        goto L9
    L10:
        r1.bindLong(r4, r8);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"ProactiveRecommendations"}, new AnonymousClass8(this, r1));
    }

    @Override // com.obric.memorydata.database.dao.ProactiveRecommendationsDao
    public void update(ez r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfProactiveRecommendationEntity.handle(r2);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.ProactiveRecommendationsDao
    public int updateActionExecuteInstruction(String r3, String r4, long r5) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfUpdateActionExecuteInstruction.acquire();
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r5);
        if (r3 != null) goto L9;
        r0.bindNull(3);
    L10:
        this.__db.beginTransaction();
        int r6 = r0.executeUpdateDelete();     // Catch: Throwable -> L14
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateActionExecuteInstruction.release(r0);
        return r6;
    L14:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateActionExecuteInstruction.release(r0);
        throw th;
    L9:
        r0.bindString(3, r3);
        goto L10
    L5:
        r0.bindString(1, r4);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.ProactiveRecommendationsDao
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

    @Override // com.obric.memorydata.database.dao.ProactiveRecommendationsDao
    public int updateStatus(String r3, String r4, long r5) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfUpdateStatus.acquire();
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r5);
        if (r3 != null) goto L9;
        r0.bindNull(3);
    L10:
        this.__db.beginTransaction();
        int r6 = r0.executeUpdateDelete();     // Catch: Throwable -> L14
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateStatus.release(r0);
        return r6;
    L14:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateStatus.release(r0);
        throw th;
    L9:
        r0.bindString(3, r3);
        goto L10
    L5:
        r0.bindString(1, r4);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.ProactiveRecommendationsDao
    public void upsert(ez r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfProactiveRecommendationEntity.insert(r2);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
