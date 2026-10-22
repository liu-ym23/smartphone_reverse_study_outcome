package com.bytedance.android.anniex.scene.data;

import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.bytedance.android.anniex.scene.core.f;
import com.bytedance.ies.bullet.core.h;
import com.lynx.tasm.utils.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ea.a f3420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantLock f3421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3422c;
    public final int d;
    public final long e;
    public final ArrayList f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f3423h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f3424i;

    public a(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r10, "context");
        this.f3420a = new ea.a(r10, "scene_recognition.db", null, 3, 1);
        this.f3421b = new ReentrantLock();
        this.f3422c = ((Number) com.bytedance.android.anniex.scene.settings.a.f3454l.getValue()).intValue();
        this.d = ((Number) com.bytedance.android.anniex.scene.settings.a.f3455m.getValue()).intValue();
        this.e = ((Number) com.bytedance.android.anniex.scene.settings.a.f3456n.getValue()).longValue();
        this.f = new ArrayList();
        this.f3423h = ((Number) com.bytedance.android.anniex.scene.settings.a.f3457o.getValue()).intValue();
        this.f3424i = ((Number) com.bytedance.android.anniex.scene.settings.a.f3458p.getValue()).intValue();
    }

    public static int a(SQLiteDatabase r5, String r10) {
        Cursor r11 = r5.rawQuery("SELECT COUNT(*) FROM ".concat(r10), null);
        int r12 = 0;
        if (r11.moveToFirst() == false) goto L9;
        r12 = r11.getInt(0);     // Catch: Throwable -> L7
    L9:
        CloseableKt.closeFinally(r11, null);
        return r12;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    }

    public static void f(SQLiteDatabase r10) {
        Application r5 = h.g.f5316b;
        if (r5 == null) goto L6;
        final long r11 = r5.getDatabasePath("scene_recognition.db").length();
        final long r12 = r11 / ((long) 1024);
        final int r13 = a(r10, "scenes");
        final int r14 = a(r10, "transitions");
        com.bytedance.android.anniex.scene.connect.a.b(r13, r14, (int) r12);
        Function0<String> r15 = new SceneDbManager$reportSqliteStatus$1$1(r12, r11, r13, r14);
        Intrinsics.checkNotNullParameter("AnnieXSceneManager", "tag");
        Intrinsics.checkNotNullParameter(r15, "message");
        g.f(3, r15);
        return;
    }

    public final b b(final f r18, String r19, long r20) {
        Intrinsics.checkNotNullParameter(r18, "scene");
        Function0<String> r5 = new SceneDbManager$saveSceneAndGetStats$1(r18);
        Object r10 = "AnnieXSceneManager";
        String r11 = "tag";
        Intrinsics.checkNotNullParameter("AnnieXSceneManager", "tag");
        Intrinsics.checkNotNullParameter(r5, "message");
        g.f(3, r5);
        final long r12 = System.currentTimeMillis();
        ea.a r13 = this.f3420a;
        SQLiteDatabase r14 = r13.getWritableDatabase();
        LinkedHashMap r15 = new LinkedHashMap();
        ReentrantLock r16 = this.f3421b;
        r16.lock();
        r14.beginTransaction();     // Catch: Throwable -> L60
        int r17 = 0;
        r13.d(r18);     // Catch: Throwable -> L10 Exception -> L50
        String r21 = r18.f3391a;
        if (r19 != null) goto L73;
    L14:
        int r22 = r13.b(r21);     // Catch: Throwable -> L10 Exception -> L50
        Cursor r23 = r14.rawQuery(StringsKt.trimIndent("\n                        SELECT to_scene_id,\n                         count,\n                         (SELECT SUM(count)\n                         FROM transitions\n                         WHERE from_scene_id = ?) as total\n                         FROM transitions\n                         WHERE from_scene_id = ?\n                     "), new String[]{r21, r21});     // Catch: Throwable -> L10 Exception -> L48
    L67:
    L26:
        th = th;
    L25:
        Throwable r24 = th;
        throw r24;     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        CloseableKt.closeFinally(r23, r24);     // Catch: Throwable -> L10 Exception -> L33
        throw th;     // Catch: Throwable -> L10 Exception -> L33
    L33:
        e = e;
    L34:
        r17 = r22;
    L52:
        String r25 = e.getMessage();     // Catch: Throwable -> L10
        if (r25 != null) goto L55;
        r25 = "";
    L55:
        com.bytedance.android.anniex.scene.connect.a.d(r25);     // Catch: Throwable -> L10
        r22 = r17;
    L57:
        r14.endTransaction();     // Catch: Throwable -> L60
        Unit r26 = Unit.INSTANCE;     // Catch: Throwable -> L60
        r16.unlock();
        Function0<String> r27 = new SceneDbManager$saveSceneAndGetStats$3(r12);
        Intrinsics.checkNotNullParameter(r15, r16);
        Intrinsics.checkNotNullParameter(r27, "message");
        g.f(3, r27);
        return new b(r22, r15);
    L17:
        if (r23.moveToNext() == false) goto L28;
        String r28 = r23.getString(r17);     // Catch: Throwable -> L26
        int r29 = r23.getInt(1);     // Catch: Throwable -> L26
        int r110 = r23.getInt(2);     // Catch: Throwable -> L26
        Object r111 = r10;
        String r112 = r11;
        if (r110 <= 0) goto L22;
        double r30 = ((double) r29) / ((double) r110);
    L75:
        r15.put(r28, TuplesKt.to(Integer.valueOf(r29), Double.valueOf(r30)));     // Catch: Throwable -> L24
        r10 = r111;
        r11 = r112;
        r17 = 0;
    L24:
        th = th;
        goto L25
    L22:
        r30 = 0.0d;
        goto L75
    L28:
        r111 = r10;
        r112 = r11;
        Unit r31 = Unit.INSTANCE;     // Catch: Throwable -> L24
        CloseableKt.closeFinally(r23, null);     // Catch: Throwable -> L10 Exception -> L33
        int r32 = this.g + 1;     // Catch: Throwable -> L10 Exception -> L33
        this.g = r32;     // Catch: Throwable -> L10 Exception -> L33
        if ((r32 % this.f3424i) != 0) goto L36;
        e(r14);     // Catch: Throwable -> L10 Exception -> L33
    L36:
        if ((this.g % this.f3423h) != 0) goto L41;
        boolean r33 = c(r14);     // Catch: Throwable -> L10 Exception -> L33
        boolean r34 = d(r14);     // Catch: Throwable -> L10 Exception -> L33
        if (r33 == true) goto L40;
        if (r34 == false) goto L41;
    L40:
        f(r14);     // Catch: Throwable -> L10 Exception -> L33
    L41:
        r14.setTransactionSuccessful();     // Catch: Throwable -> L10 Exception -> L33
    L48:
        e = e;
        r111 = "AnnieXSceneManager";
        r112 = "tag";
        goto L34
    L73:
        ArrayList r113 = this.f;     // Catch: Throwable -> L10 Exception -> L12
        r111 = new Triple(r19, r21, Long.valueOf(r20));     // Catch: Throwable -> L10 Exception -> L12
        r113.add(r111);     // Catch: Throwable -> L10 Exception -> L12
    L12:
        e = e;
        r111 = "AnnieXSceneManager";
        r112 = "tag";
    L10:
        th = move-exception;
        r14.endTransaction();     // Catch: Throwable -> L60
        throw th;     // Catch: Throwable -> L60
    L50:
        e = e;
        r111 = "AnnieXSceneManager";
        r112 = "tag";
        r17 = 0;
    L60:
        th = move-exception;
        r16.unlock();
        throw th;
    }

    public final boolean c(SQLiteDatabase r10) {
        r10.execSQL("DELETE FROM scenes WHERE timestamp < ?", new Long[]{Long.valueOf(System.currentTimeMillis() - this.e)});
        Cursor r5 = r10.rawQuery("SELECT COUNT(*) FROM scenes", null);
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);
        throw th;
    L4:
        if (r5.moveToFirst() == false) goto L13;
        int r11 = r5.getInt(0);     // Catch: Throwable -> L11
        int r12 = this.f3422c;
        if (r11 <= r12) goto L13;
        r10.execSQL(StringsKt.trimIndent("\n                    DELETE FROM scenes\n                    WHERE scene_id IN (\n                        SELECT scene_id\n                        FROM scenes\n                        ORDER BY timestamp ASC\n                        LIMIT " + (r5.getInt(0) - r12) + "\n                    )\n                "));     // Catch: Throwable -> L11
        SceneDbManager$autoCleanScenes$1$1 r13 = SceneDbManager$autoCleanScenes$1$1.f3413a;     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter("AnnieXSceneManager", "tag");     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r13, "message");     // Catch: Throwable -> L11
        g.f(5, r13);     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r5, null);
        return true;
    L13:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r5, null);
        return false;
    }

    public final boolean d(SQLiteDatabase r10) {
        r10.execSQL("DELETE FROM transitions WHERE last_update < ?", new Long[]{Long.valueOf(System.currentTimeMillis() - this.e)});
        Cursor r5 = r10.rawQuery("SELECT COUNT(*) FROM transitions", null);
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);
        throw th;
    L4:
        if (r5.moveToFirst() == false) goto L13;
        int r11 = r5.getInt(0);     // Catch: Throwable -> L11
        int r12 = this.d;
        if (r11 <= r12) goto L13;
        r10.execSQL(StringsKt.trimIndent("\n                    DELETE FROM transitions\n                    WHERE rowid IN (\n                        SELECT rowid FROM transitions\n                        ORDER BY last_update ASC\n                        LIMIT " + (r5.getInt(0) - r12) + "\n                    )\n                "));     // Catch: Throwable -> L11
        SceneDbManager$autoCleanTransitions$1$1 r13 = SceneDbManager$autoCleanTransitions$1$1.f3414a;     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter("AnnieXSceneManager", "tag");     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r13, "message");     // Catch: Throwable -> L11
        g.f(3, r13);     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r5, null);
        return true;
    L13:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r5, null);
        return false;
    }

    public final void e(SQLiteDatabase r17) {
        ArrayList r5 = this.f;
        Iterator r10 = r5.iterator();
    L4:
        if (r10.hasNext() == false) goto L21;
        Triple r11 = (Triple) r10.next();
        String r12 = (String) r11.component1();
        String r13 = (String) r11.component2();
        long r14 = ((Number) r11.component3()).longValue();
        long r15 = System.currentTimeMillis();
        Cursor r16 = r17.rawQuery(StringsKt.trimIndent("\n            SELECT count, avg_duration\n            FROM transitions\n            WHERE from_scene_id = ? AND to_scene_id = ?\n            "), new String[]{r12, r13});
        int r18 = 0;
        if (r16.moveToFirst() == false) goto L11;
        r18 = r16.getInt(0);     // Catch: Throwable -> L9
        long r19 = r16.getLong(1);     // Catch: Throwable -> L9
    L12:
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L9
        CloseableKt.closeFinally(r16, null);
        if (r18 > 0) goto L15;
        SQLiteStatement r20 = r17.compileStatement(StringsKt.trimIndent("\n                INSERT INTO transitions\n                (from_scene_id, to_scene_id,\n                 count, last_update,\n                 avg_duration)\n                VALUES (?, ?, 1, ?, ?)\n                "));
        r20.bindString(1, r12);
        r20.bindString(2, r13);
        r20.bindLong(3, r15);
        r20.bindLong(4, r14);
        r20.executeInsert();
        r20.close();
        goto L4
    L15:
        long r111 = (r19 * ((long) r18)) + r14;
        long r21 = r18 + 1;
        SQLiteStatement r22 = r17.compileStatement(StringsKt.trimIndent("\n                UPDATE transitions SET\n                    count = ?,\n                    last_update = ?,\n                    avg_duration = ?\n                WHERE from_scene_id = ? AND to_scene_id = ?\n                "));
        r22.bindLong(1, r21);
        r22.bindLong(2, r15);
        r22.bindLong(3, r111 / r21);
        r22.bindString(4, r12);
        r22.bindString(5, r13);
        r22.executeUpdateDelete();
        r22.close();
        goto L4
    L11:
        r19 = 0;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r16, th);
        throw th;
    L21:
        r5.clear();
    }
}
