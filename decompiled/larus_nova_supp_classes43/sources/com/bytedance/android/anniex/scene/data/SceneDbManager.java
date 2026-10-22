package com.bytedance.android.anniex.scene.data;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.bytedance.android.anniex.scene.connect.SceneConnectCenter;
import com.bytedance.android.anniex.scene.core.SceneManager;
import com.bytedance.android.anniex.scene.core.UrlUsageTracker;
import com.bytedance.android.anniex.scene.core.j;
import com.bytedance.android.anniex.scene.settings.SwitchCenter;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class SceneDbManager {
    public static final a r = null;
    public static volatile SceneDbManager s;
    public final com.bytedance.android.anniex.scene.data.a a;
    public final ReentrantLock b;
    public final int c;
    public final int d;
    public final long e;
    public final List<Triple<String, String, Long>> f;
    public int g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final SceneDbManager$sceneCountMap$1 l;
    public final Lazy m;
    public int n;
    public final int o;
    public final double p;
    public final TimeUnit q;

    public static final class a {
        public a() {
        }

        public final SceneDbManager a(Context r10) {
            Intrinsics.checkNotNullParameter(r10, "context");
            SceneDbManager r0 = SceneDbManager.s;
            if (r0 != null) goto L13;
            monitor-enter(this);
            r0 = SceneDbManager.s;     // Catch: Throwable -> L10
            if (r0 != null) goto L8;
            r0 = new SceneDbManager(r10);     // Catch: Throwable -> L10
            SceneDbManager.s = r0;     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r0;
        }
    }

    public static final class b {
        public int a;
        public int b;

        public b() {
            this(0, 0);
        }

        public b(int r1, int r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    static {
        r = new a();
    }

    public final SQLiteDatabase f() {
        return (SQLiteDatabase) this.m.getValue();
    }

    public final void c() {
        long r0 = System.currentTimeMillis();
        Cursor r10 = f().rawQuery("SELECT COUNT(*) FROM url_records_table", null);
        if (r10.moveToFirst() == false) goto L7;
        int r11 = r10.getInt(0);
        HybridLogger r12 = HybridLogger.a;
        UrlUsageTracker r13 = UrlUsageTracker.n;
        StringBuilder r14 = new StringBuilder("cleanupIfNecessary total:");
        r14.append(r11);
        r14.append(", maxSize:");
        Lazy r15 = SwitchCenter.E;
        r14.append(((Number) r15.getValue()).longValue());
        HybridLogger.f("UrlUsageTracker", r14.toString(), null, 12);
        long r16 = r11;
        if (r16 <= ((Number) r15.getValue()).longValue()) goto L7;
        long r17 = r16 - ((Number) r15.getValue()).longValue();
        f().execSQL("\n                    DELETE FROM url_records_table WHERE count IN (\n                        SELECT count FROM url_records_table\n                        ORDER BY count ASC LIMIT " + r17 + "\n                    )\n                    ");
        StringBuilder r18 = new StringBuilder("cleanupIfNecessary 使用策略：count，删除记录数：");
        r18.append(r17);
        HybridLogger.f("UrlUsageTracker", r18.toString(), null, 12);
    L7:
        r10.close();
        HybridLogger r19 = HybridLogger.a;
        UrlUsageTracker r20 = UrlUsageTracker.n;
        HybridLogger.f("UrlUsageTracker", "cleanupIfNecessary 数据清理结束 耗时：" + (System.currentTimeMillis() - r0), null, 12);
    }

    public SceneDbManager(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        com.bytedance.android.anniex.scene.data.a.C0097a r0 = com.bytedance.android.anniex.scene.data.a.a;
        Intrinsics.checkNotNullParameter(r10, "context");
        com.bytedance.android.anniex.scene.data.a r1 = com.bytedance.android.anniex.scene.data.a.b;
        if (r1 != null) goto L13;
        monitor-enter(r0);
        r1 = com.bytedance.android.anniex.scene.data.a.b;     // Catch: Throwable -> L10
        if (r1 != null) goto L8;
        r1 = new com.bytedance.android.anniex.scene.data.a(r10);     // Catch: Throwable -> L10
        com.bytedance.android.anniex.scene.data.a.b = r1;     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);
    L10:
        th = move-exception;
        throw th;
    L13:
        this.a = r1;
        this.b = new ReentrantLock();
        this.c = ((Number) SwitchCenter.q.getValue()).intValue();
        this.d = ((Number) SwitchCenter.r.getValue()).intValue();
        this.e = ((Number) SwitchCenter.s.getValue()).longValue();
        this.f = new ArrayList();
        this.h = ((Number) SwitchCenter.t.getValue()).intValue();
        this.i = ((Number) SwitchCenter.u.getValue()).intValue();
        this.j = ((Number) SwitchCenter.v.getValue()).intValue();
        int r11 = ((Number) SwitchCenter.m.getValue()).intValue();
        this.k = r11;
        this.l = new SceneDbManager$sceneCountMap$1(this, r11);
        this.m = LazyKt.lazy(new SceneDbManager$db$2(this));
        this.o = ((Number) SwitchCenter.C.getValue()).intValue();
        this.p = ((Number) SwitchCenter.D.getValue()).doubleValue();
        this.q = TimeUnit.DAYS;
    }

    public static void i(SQLiteDatabase r10) {
        Application r0 = h.h.b;
        if (r0 == null) goto L6;
        final long r11 = r0.getDatabasePath("scene_recognition.db").length();
        final long r12 = r11 / ((long) 1024);
        final int r13 = g(r10, "scenes");
        final int r14 = g(r10, "transitions");
        SceneConnectCenter.f(r13, r14, g(r10, "url_records_table"), (int) r12);
        int r15 = za.b.a;
        SceneManager r16 = SceneManager.n;
        za.b.a("AnnieXSceneManager", new SceneDbManager$reportSqliteStatus$1$1(r12, r11, r13, r14));
        return;
    }

    public final boolean a(SQLiteDatabase r10) {
        r10.execSQL("DELETE FROM scenes WHERE timestamp < ?", new Long[]{Long.valueOf(System.currentTimeMillis() - this.e)});
        Cursor r11 = r10.rawQuery("SELECT COUNT(*) FROM scenes", null);
        Cursor r12 = r11;     // Catch: Throwable -> L13
        if (r12.moveToFirst() == true) goto L6;
    L10:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L13
        CloseableKt.closeFinally(r11, null);
        return false;
    L6:
        if (r12.getInt(0) <= this.c) goto L10;
        r10.execSQL(StringsKt.trimIndent("\n                    DELETE FROM scenes\n                    WHERE scene_id IN (\n                        SELECT scene_id\n                        FROM scenes\n                        ORDER BY timestamp ASC\n                        LIMIT " + (r12.getInt(0) - this.c) + "\n                    )\n                "));     // Catch: Throwable -> L13
        int r14 = za.b.a;     // Catch: Throwable -> L13
        SceneManager r15 = SceneManager.n;     // Catch: Throwable -> L13
        SceneDbManager$autoCleanScenes$1$1 r0 = SceneDbManager$autoCleanScenes$1$1.INSTANCE;     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter("AnnieXSceneManager", com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter(r0, com.bytedance.android.ec.core.event.a.KEY_MSG);     // Catch: Throwable -> L13
        za.b.b(5, "AnnieXSceneManager", r0);     // Catch: Throwable -> L13
        CloseableKt.closeFinally(r11, null);
        return true;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    }

    public final boolean b(SQLiteDatabase r10) {
        r10.execSQL("DELETE FROM transitions WHERE last_update < ?", new Long[]{Long.valueOf(System.currentTimeMillis() - this.e)});
        Cursor r11 = r10.rawQuery("SELECT COUNT(*) FROM transitions", null);
        Cursor r12 = r11;     // Catch: Throwable -> L13
        if (r12.moveToFirst() == true) goto L6;
    L10:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L13
        CloseableKt.closeFinally(r11, null);
        return false;
    L6:
        if (r12.getInt(0) <= this.d) goto L10;
        r10.execSQL(StringsKt.trimIndent("\n                    DELETE FROM transitions\n                    WHERE rowid IN (\n                        SELECT rowid FROM transitions\n                        ORDER BY last_update ASC\n                        LIMIT " + (r12.getInt(0) - this.d) + "\n                    )\n                "));     // Catch: Throwable -> L13
        int r14 = za.b.a;     // Catch: Throwable -> L13
        SceneManager r15 = SceneManager.n;     // Catch: Throwable -> L13
        za.b.a("AnnieXSceneManager", SceneDbManager$autoCleanTransitions$1$1.INSTANCE);     // Catch: Throwable -> L13
        CloseableKt.closeFinally(r11, null);
        return true;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    }

    public final void e(SQLiteDatabase r17) {
        Iterator r10 = ((ArrayList) this.f).iterator();
    L4:
        if (r10.hasNext() == false) goto L21;
        Triple r11 = (Triple) r10.next();
        String r12 = (String) r11.component1();
        String r13 = (String) r11.component2();
        long r14 = ((Number) r11.component3()).longValue();
        long r15 = System.currentTimeMillis();
        int r16 = 0;
        Cursor r18 = r17.rawQuery(StringsKt.trimIndent("\n            SELECT count, avg_duration\n            FROM transitions\n            WHERE from_scene_id = ? AND to_scene_id = ?\n            "), new String[]{r12, r13});
        Cursor r19 = r18;     // Catch: Throwable -> L15
        if (r19.moveToFirst() == false) goto L9;
        r16 = r19.getInt(0);     // Catch: Throwable -> L15
        long r110 = r19.getLong(1);     // Catch: Throwable -> L15
    L10:
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r18, null);
        if (r16 > 0) goto L13;
        SQLiteStatement r20 = r17.compileStatement(StringsKt.trimIndent("\n                INSERT INTO transitions\n                (from_scene_id, to_scene_id,\n                 count, last_update,\n                 avg_duration)\n                VALUES (?, ?, 1, ?, ?)\n                "));
        r20.bindString(1, r12);
        r20.bindString(2, r13);
        r20.bindLong(3, r15);
        r20.bindLong(4, r14);
        r20.executeInsert();
        r20.close();
        goto L4
    L13:
        long r112 = (r110 * ((long) r16)) + r14;
        long r21 = r16 + 1;
        SQLiteStatement r22 = r17.compileStatement(StringsKt.trimIndent("\n                UPDATE transitions SET\n                    count = ?,\n                    last_update = ?,\n                    avg_duration = ?\n                WHERE from_scene_id = ? AND to_scene_id = ?\n                "));
        r22.bindLong(1, r21);
        r22.bindLong(2, r15);
        r22.bindLong(3, r112 / r21);
        r22.bindString(4, r12);
        r22.bindString(5, r13);
        r22.executeUpdateDelete();
        r22.close();
        goto L4
    L9:
        r110 = 0;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r18, th);
        throw th;
    L21:
        ((ArrayList) this.f).clear();
    }

    public final Triple<List<c>, Double, Double> h(long r27) {
        int[] r11 = {0, 1};
        ArrayList r12 = new ArrayList();
        Cursor r10 = f().rawQuery("SELECT count FROM url_records_table", null);     // Catch: Exception -> L35
        double r16 = 0.0d;
    L5:
        if (r10.moveToNext() == false) goto L7;
        r16 = r16 + r10.getDouble(0);     // Catch: Exception -> L35
        goto L5
    L7:
        r10.close();     // Catch: Exception -> L35
        StringBuilder r13 = new StringBuilder();     // Catch: Exception -> L35
        r13.append(StringsKt.trimIndent("\n                SELECT url,\n                       count,\n                       last_visit_ts,\n                       status\n                FROM url_records_table\n            "));     // Catch: Exception -> L35
        r13.append(" WHERE status IN (" + ArraysKt.joinToString$default(r11, ",", null, null, 0, null, SceneDbManager$queryTopUrlsByOrderColumn$selectionArgs$placeholders$1.INSTANCE, 30, null) + ')');     // Catch: Exception -> L35
        ArrayList r14 = new ArrayList(2);     // Catch: Exception -> L35
        int r15 = 0;
    L8:
        if (r15 >= 2) goto L10;
        r14.add(String.valueOf(r11[r15]));     // Catch: Exception -> L35
        r15 = r15 + 1;     // Catch: Exception -> L35
        goto L8
    L10:
        Object[] r17 = r14.toArray(new String[0]);     // Catch: Exception -> L35
        if (r17 == null) goto L34;
        r13.append(" ORDER BY count DESC");     // Catch: Exception -> L35
        Cursor r0 = f().rawQuery(r13.toString(), (String[]) r17);     // Catch: Exception -> L35
        double r18 = 0.0d;
        double r19 = 0.0d;
        int r110 = 0;
    L14:
        if (r0.moveToNext() == false) goto L24;
        double r20 = r0.getDouble(1);     // Catch: Exception -> L35
        int r21 = r0.getInt(3);     // Catch: Exception -> L35
        r18 = r18 + r20;     // Catch: Exception -> L35
        if (((Boolean) SwitchCenter.S.getValue()).booleanValue() == false) goto L18;
        if (r21 != 0) goto L14;
    L18:
        r110 = r110 + 1;     // Catch: Exception -> L35
        if (r110 > r27) goto L24;
        r12.add(new c(r0.getString(0), r20, r0.getLong(2)));     // Catch: Exception -> L35
        if (r21 != 0) goto L14;
        r19 = r19 + r20;     // Catch: Exception -> L35
    L24:
        r0.close();     // Catch: Exception -> L35
        double r1 = 0;
        if (r16 <= r1) goto L27;
        double r22 = r18 / r16;     // Catch: Exception -> L35
    L29:
        if (r19 <= r1) goto L31;
        double r23 = r19 / r16;     // Catch: Exception -> L35
    L48:
        return new Triple(r12, Double.valueOf(r22), Double.valueOf(r23));
    L31:
        r23 = 0.0d;
        goto L48
    L27:
        r22 = 0.0d;
        goto L29
    L34:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Exception -> L35
    L35:
        e = move-exception;
        HybridLogger r24 = HybridLogger.a;
        UrlUsageTracker r25 = UrlUsageTracker.n;
        HybridLogger.i("UrlUsageTracker", "queryTopUrlsByTemplateTotalSize 查询（排序字段：count）异常：" + e.getMessage(), null, 12);
        r12.clear();
        return new Triple(r12, Double.valueOf(0.0d), Double.valueOf(0.0d));
    }

    public static int g(SQLiteDatabase r10, String r11) {
        Cursor r12 = r10.rawQuery("SELECT COUNT(*) FROM ".concat(r11), null);
        Cursor r13 = r12;     // Catch: Throwable -> L8
        int r14 = 0;
        if (r13.moveToFirst() == false) goto L6;
        r14 = r13.getInt(0);     // Catch: Throwable -> L8
    L6:
        CloseableKt.closeFinally(r12, null);
        return r14;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);
        throw th;
    }

    public final synchronized void d(j r18, Map<String, UrlUsageTracker.a> r19) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r18, "scoreModel");     // Catch: Throwable -> L37
        Intrinsics.checkNotNullParameter(r19, "cacheMap");     // Catch: Throwable -> L37
        long r10 = System.currentTimeMillis();     // Catch: Throwable -> L37
        f().beginTransaction();     // Catch: Throwable -> L37
        HybridLogger r11 = HybridLogger.a;     // Catch: Throwable -> L27 Exception -> L29
        UrlUsageTracker r12 = UrlUsageTracker.n;     // Catch: Throwable -> L27 Exception -> L29
        HybridLogger.f("UrlUsageTracker", "flushBatch 数据入库, cacheMap size:" + r19.size(), null, 12);     // Catch: Throwable -> L27 Exception -> L29
        int r13 = 1;
        int r0 = this.n + 1;     // Catch: Throwable -> L27 Exception -> L29
        this.n = r0;     // Catch: Throwable -> L27 Exception -> L29
        if ((r0 % this.o) != 0) goto L9;
        c();     // Catch: Throwable -> L27 Exception -> L29
    L9:
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L27 Exception -> L29
        Iterator<Map.Entry<String, UrlUsageTracker.a>> r14 = r19.entrySet().iterator();     // Catch: Throwable -> L27 Exception -> L29
    L11:
        if (r14.hasNext() == false) goto L24;
        Map.Entry<String, UrlUsageTracker.a> r15 = r14.next();     // Catch: Throwable -> L27 Exception -> L29
        String r16 = r15.getKey();     // Catch: Throwable -> L27 Exception -> L29
        UrlUsageTracker.a r17 = r15.getValue();     // Catch: Throwable -> L27 Exception -> L29
        String r110 = r17.c;     // Catch: Throwable -> L27 Exception -> L29
        if (r110 != null) goto L15;
        r110 = za.c.a(r16);     // Catch: Throwable -> L27 Exception -> L29
    L15:
        if (r110 == null) goto L17;
        double r111 = r17.a;     // Catch: Throwable -> L27 Exception -> L29
        SQLiteDatabase r20 = f();     // Catch: Throwable -> L27 Exception -> L29
        String[] r112 = new String[r13];     // Catch: Throwable -> L27 Exception -> L29
        r112[0] = r110;     // Catch: Throwable -> L27 Exception -> L29
        Cursor r21 = r20.rawQuery("SELECT count, last_visit_ts FROM url_records_table WHERE url=?", r112);     // Catch: Throwable -> L27 Exception -> L29
        if (r21.moveToFirst() == false) goto L23;
        r111 = r111 + (r21.getDouble(0) * Math.exp((-this.p) * this.q.convert(r10 - r21.getLong(r13), TimeUnit.MILLISECONDS)));     // Catch: Throwable -> L27 Exception -> L29
    L23:
        r21.close();     // Catch: Throwable -> L27 Exception -> L29
        ContentValues r22 = new ContentValues();     // Catch: Throwable -> L27 Exception -> L29
        r22.put(com.bytedance.android.ec.core.event.a.KEY_URL, r110);     // Catch: Throwable -> L27 Exception -> L29
        r22.put("count", Double.valueOf(r111));     // Catch: Throwable -> L27 Exception -> L29
        r22.put(com.bytedance.android.ec.core.event.a.KEY_STATUS, Integer.valueOf(r17.d));     // Catch: Throwable -> L27 Exception -> L29
        r22.put("last_visit_ts", Long.valueOf(r10));     // Catch: Throwable -> L27 Exception -> L29
        f().insertWithOnConflict("url_records_table", null, r22, 5);     // Catch: Throwable -> L27 Exception -> L29
        r14 = r14;
        r13 = 1;
        goto L11
    L17:
        if (SwitchCenter.c() == false) goto L11;
        r1.add(r16);     // Catch: Throwable -> L27 Exception -> L29
        goto L11
    L24:
        f().setTransactionSuccessful();     // Catch: Throwable -> L27 Exception -> L29
        SceneConnectCenter.b(r1);     // Catch: Throwable -> L27 Exception -> L29
        HybridLogger r23 = HybridLogger.a;     // Catch: Throwable -> L27 Exception -> L29
        UrlUsageTracker r24 = UrlUsageTracker.n;     // Catch: Throwable -> L27 Exception -> L29
        HybridLogger.f("UrlUsageTracker", "flushBatch 数据入库完毕，耗时:" + (System.currentTimeMillis() - r10), null, 12);     // Catch: Throwable -> L27 Exception -> L29
    L32:
        f().endTransaction();     // Catch: Throwable -> L37
        monitor-exit(this);
        return;
    L29:
        e = move-exception;
        HybridLogger r25 = HybridLogger.a;     // Catch: Throwable -> L27
        UrlUsageTracker r26 = UrlUsageTracker.n;     // Catch: Throwable -> L27
        HybridLogger.i("UrlUsageTracker", "flushBatch 数据入库异常：" + e.getMessage(), null, 12);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        f().endTransaction();     // Catch: Throwable -> L37
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 29, insn: 0x01e4: MOVE (r2 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r29 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) (LINE:50332132), block:B:100:0x01e4 */
    /* JADX WARN: Type inference failed for: r23v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [double] */
    public final synchronized com.bytedance.android.anniex.scene.data.b j(final com.bytedance.android.anniex.scene.core.h r26, final com.bytedance.android.anniex.scene.core.h r27, long r28) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r26, "scene");     // Catch: Throwable -> L125
        int r10 = za.b.a;     // Catch: Throwable -> L125
        SceneManager r11 = SceneManager.n;     // Catch: Throwable -> L125
        za.b.a("AnnieXSceneManager", new SceneDbManager$saveSceneAndGetStats$1(r26));     // Catch: Throwable -> L125
        long r12 = System.currentTimeMillis();     // Catch: Throwable -> L125
        LinkedHashMap r13 = new LinkedHashMap();     // Catch: Throwable -> L125
        ReentrantLock r14 = this.b;     // Catch: Throwable -> L125
        r14.lock();     // Catch: Throwable -> L125
        SQLiteDatabase r15 = f();     // Catch: Throwable -> L122
        r15.beginTransaction();     // Catch: Throwable -> L122
        int r16 = 0;
        this.a.b(r26);     // Catch: Throwable -> L107 Exception -> L109
        if (r27 == null) goto L18;
        ((ArrayList) this.f).add(new Triple(r27.a, r26.a, Long.valueOf(r28)));     // Catch: Exception -> L15 Throwable -> L107
        Integer r17 = r27.k;     // Catch: Exception -> L15 Throwable -> L107
        if (r17 == null) goto L18;
        if (r17.intValue() <= 0) goto L18;
        za.b.a("AnnieXSceneManager", new SceneDbManager$saveSceneAndGetStats$2$1$1(r26, r27));     // Catch: Exception -> L15 Throwable -> L107
        this.a.b(r27);     // Catch: Exception -> L15 Throwable -> L107
    L15:
        e = e;
        int r18 = 0;
    L50:
        r12 = r12;
    L106:
        ?? r19 = 0;
    L111:
        Lazy r20 = SceneConnectCenter.a;     // Catch: Throwable -> L107
        String r0 = e.getMessage();     // Catch: Throwable -> L107
        if (r0 != null) goto L114;
        r0 = "";
    L114:
        SceneConnectCenter.e(r0);     // Catch: Throwable -> L107
        f().endTransaction();     // Catch: Throwable -> L122
        ?? r23 = r19;
        int r21 = r18;
        int r22 = r16;
        ?? r24 = r23;
    L116:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L122
        r14.unlock();     // Catch: Throwable -> L125
        int r25 = za.b.a;     // Catch: Throwable -> L125
        SceneManager r29 = SceneManager.n;     // Catch: Throwable -> L125
        final long r30 = r12;
        za.b.a("AnnieXSceneManager", new SceneDbManager$saveSceneAndGetStats$3(r30));     // Catch: Throwable -> L125
        com.bytedance.android.anniex.scene.data.b r31 = new com.bytedance.android.anniex.scene.data.b(r21, r22, r24, r13);     // Catch: Throwable -> L125
        monitor-exit(this);
        return r31;
    L18:
        int r32 = 1;
        if (this.l.containsKey(r26.a) == false) goto L51;
        b r33 = (b) this.l.get(r26.a);     // Catch: Exception -> L15 Throwable -> L107
        if (r33 == null) goto L24;
        int r34 = r33.a;     // Catch: Exception -> L15 Throwable -> L107
    L25:
        r18 = r34 + 1;
        b r110 = (b) this.l.get(r26.a);     // Catch: Exception -> L47 Throwable -> L107
        if (r110 == null) goto L29;
        int r111 = r110.b;     // Catch: Exception -> L47 Throwable -> L107
    L30:
        Integer r112 = r26.k;     // Catch: Exception -> L47 Throwable -> L107
        if (r112 == null) goto L34;
        int r113 = r112.intValue();     // Catch: Exception -> L47 Throwable -> L107
    L35:
        int r114 = r111 + r113;
        b r115 = (b) this.l.get(r26.a);     // Catch: Exception -> L45 Throwable -> L107
        if (r115 == null) goto L40;
        r115.a = r18;     // Catch: Exception -> L45 Throwable -> L107
    L40:
        b r116 = (b) this.l.get(r26.a);     // Catch: Exception -> L45 Throwable -> L107
        if (r116 == null) goto L144;
        r116.b = r114;     // Catch: Exception -> L45 Throwable -> L107
    L144:
        SQLiteDatabase r117 = f();     // Catch: Exception -> L101 Throwable -> L107
        String r118 = StringsKt.trimIndent("\n                        SELECT to_scene_id,\n                         count,\n                         avg_duration, -- 新增字段\n                         (SELECT SUM(count)\n                         FROM transitions\n                         WHERE from_scene_id = ?) as total\n                         FROM transitions\n                         WHERE from_scene_id = ?\n                     ");     // Catch: Exception -> L101 Throwable -> L107
        int r119 = 2;
        String r35 = r26.a;     // Catch: Exception -> L101 Throwable -> L107
        Cursor r120 = r117.rawQuery(r118, new String[]{r35, r35});     // Catch: Exception -> L101 Throwable -> L107
        Cursor r36 = r120;     // Catch: Throwable -> L92
        double r121 = 0.0d;
        double r122 = 0.0d;
    L131:
    L67:
        th = th;
    L91:
        Throwable r37 = th;
    L148:
        throw r37;     // Catch: Throwable -> L95
    L95:
        th = move-exception;
        CloseableKt.closeFinally(r120, r37);     // Catch: Exception -> L99 Throwable -> L107
        throw th;     // Catch: Exception -> L99 Throwable -> L107
    L58:
        if (r36.moveToNext() == false) goto L69;
        String r123 = r36.getString(r16);     // Catch: Throwable -> L67
        int r38 = r36.getInt(r32);     // Catch: Throwable -> L67
        long r39 = r36.getLong(r119);     // Catch: Throwable -> L67
        int r40 = r36.getInt(3);     // Catch: Throwable -> L67
        if (r40 <= 0) goto L62;
        double r124 = ((double) r38) / ((double) r40);
    L128:
        r13.put(r123, TuplesKt.to(Integer.valueOf(r38), Double.valueOf(r124)));     // Catch: Throwable -> L65
        r122 = r122 + (r39 * r124);
        r121 = r121 + r124;
        r18 = r18;
        r12 = r12;
        r16 = 0;
        r32 = 1;
        r119 = 2;
    L65:
        th = th;
        goto L91
    L62:
        r124 = 0.0d;
        goto L128
    L69:
        int r210 = r18;
        r12 = r12;
        double r125 = r121;
        if (r125 <= 0) goto L72;
        r122 = r122 / r125;
    L72:
        double r41 = r122;
        Unit r42 = Unit.INSTANCE;     // Catch: Throwable -> L89
        CloseableKt.closeFinally(r120, null);     // Catch: Exception -> L99 Throwable -> L107
        int r43 = this.g + 1;     // Catch: Exception -> L99 Throwable -> L107
        this.g = r43;     // Catch: Exception -> L99 Throwable -> L107
        if ((r43 % this.j) != 0) goto L79;
        e(f());     // Catch: Exception -> L99 Throwable -> L107
    L79:
        if ((this.g % this.h) != 0) goto L86;
        boolean r44 = a(f());     // Catch: Exception -> L99 Throwable -> L107
        boolean r45 = b(f());     // Catch: Exception -> L99 Throwable -> L107
        if (r44 == true) goto L85;
        if (r45 == true) goto L85;
        if ((this.g % this.i) != 0) goto L86;
    L85:
        i(f());     // Catch: Exception -> L99 Throwable -> L107
    L86:
        f().setTransactionSuccessful();     // Catch: Exception -> L99 Throwable -> L107
        f().endTransaction();     // Catch: Throwable -> L122
        r24 = r41;
        r22 = r114;
        r21 = r210;
    L89:
        th = move-exception;
        r37 = th;
    L92:
        th = move-exception;
        r37 = th;
    L101:
        e = e;
        r18 = r18;
    L103:
        r16 = r114;
    L99:
        e = e;
        r18 = r29;
        r16 = r114;
        r19 = r15;
    L45:
        e = e;
        goto L103
    L34:
        r113 = 0;
        goto L35
    L29:
        r111 = 1;
    L47:
        e = e;
        goto L50
    L24:
        r34 = 0;
        goto L25
    L51:
        Pair<Integer, Integer> r46 = this.a.a(r26.a);     // Catch: Throwable -> L107 Exception -> L109
        int r126 = ((Number) r46.component1()).intValue();     // Catch: Throwable -> L107 Exception -> L109
        int r47 = ((Number) r46.component2()).intValue();     // Catch: Throwable -> L107 Exception -> L109
        this.l.put(r26.a, new b(r126, r47));     // Catch: Exception -> L104 Throwable -> L107
        r114 = r47;
        r18 = r126;
    L104:
        e = e;
        r12 = r12;
        r16 = r47;
        r18 = r126;
    L109:
        e = e;
        r12 = r12;
        r18 = 0;
        r19 = 0;
        r16 = 0;
    L107:
        th = move-exception;
        f().endTransaction();     // Catch: Throwable -> L122
        throw th;     // Catch: Throwable -> L122
    L122:
        th = move-exception;
        r14.unlock();     // Catch: Throwable -> L125
        throw th;     // Catch: Throwable -> L125
    L125:
        th = move-exception;
        throw th;
    }
}
