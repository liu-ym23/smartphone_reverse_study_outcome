package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.dg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class MemorySynthesisDao_Impl implements MemorySynthesisDao {
    private final RoomDatabase __db;

    public MemorySynthesisDao_Impl(RoomDatabase r1) {
        this.__db = r1;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.MemorySynthesisDao
    public List<dg> readyCards(int r31, long r32, long r34) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM MemorySynthesisTaskCard WHERE status = 'READY' AND trim(query) != '' AND createTime >= ? AND createTime < ? ORDER BY createTime DESC, taskId DESC LIMIT ?", 3);
        r1.bindLong(1, r32);
        r1.bindLong(2, r34);
        r1.bindLong(3, r31);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "taskId");     // Catch: Throwable -> L50
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "runId");     // Catch: Throwable -> L50
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "schemaVersion");     // Catch: Throwable -> L50
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, ChatMessage.TYPE_QUERY);     // Catch: Throwable -> L50
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, InfoRequestQPSOptTraceLogger.REASON);     // Catch: Throwable -> L50
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "taskDesignJson");     // Catch: Throwable -> L50
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "memoryRefsJson");     // Catch: Throwable -> L50
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "checkpointsJson");     // Catch: Throwable -> L50
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "queryStyleJson");     // Catch: Throwable -> L50
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "reviewJson");     // Catch: Throwable -> L50
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "status");     // Catch: Throwable -> L50
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "createTime");     // Catch: Throwable -> L50
        ArrayList r15 = new ArrayList(r2.getCount());     // Catch: Throwable -> L50
    L4:
        if (r2.moveToNext() == false) goto L48;
        if (r2.isNull(r0) == false) goto L9;
        String r17 = null;
    L11:
        if (r2.isNull(r4) == false) goto L13;
        String r18 = null;
    L14:
        int r19 = r2.getInt(r5);     // Catch: Throwable -> L50
        if (r2.isNull(r6) == false) goto L17;
        String r20 = null;
    L19:
        if (r2.isNull(r7) == false) goto L21;
        String r21 = null;
    L23:
        if (r2.isNull(r8) == false) goto L25;
        String r22 = null;
    L27:
        if (r2.isNull(r9) == false) goto L29;
        String r23 = null;
    L31:
        if (r2.isNull(r10) == false) goto L33;
        String r24 = null;
    L35:
        if (r2.isNull(r11) == false) goto L37;
        String r25 = null;
    L39:
        if (r2.isNull(r12) == false) goto L41;
        String r26 = null;
    L43:
        if (r2.isNull(r13) == false) goto L45;
        String r27 = null;
    L46:
        r15.add(new dg(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r2.getLong(r14)));     // Catch: Throwable -> L50
        goto L4
    L45:
        r27 = r2.getString(r13);     // Catch: Throwable -> L50
        goto L46
    L41:
        r26 = r2.getString(r12);     // Catch: Throwable -> L50
        goto L43
    L37:
        r25 = r2.getString(r11);     // Catch: Throwable -> L50
        goto L39
    L33:
        r24 = r2.getString(r10);     // Catch: Throwable -> L50
        goto L35
    L29:
        r23 = r2.getString(r9);     // Catch: Throwable -> L50
        goto L31
    L25:
        r22 = r2.getString(r8);     // Catch: Throwable -> L50
        goto L27
    L21:
        r21 = r2.getString(r7);     // Catch: Throwable -> L50
        goto L23
    L17:
        r20 = r2.getString(r6);     // Catch: Throwable -> L50
        goto L19
    L13:
        r18 = r2.getString(r4);     // Catch: Throwable -> L50
        goto L14
    L9:
        r17 = r2.getString(r0);     // Catch: Throwable -> L50
        goto L11
    L48:
        r2.close();
        r1.release();
        return r15;
    L50:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }
}
