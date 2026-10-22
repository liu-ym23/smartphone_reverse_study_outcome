package com.bytedance.android.live.effect.composer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Handler;
import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l extends SQLiteOpenHelper {
    public final List<a> a;
    public long b;

    public static final class a {
        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L8;
            a r4 = (a) r3;
            r4.getClass();
            if (Intrinsics.areEqual(null, null) == false) goto L12;
            r4.getClass();
            return true;
        L12:
            return false;
        L8:
            return false;
        }

        public final int getType() {
            return 0;
        }

        public final int hashCode() {
            return (0 * 31) + 0;
        }

        public final String toString() {
            return "ChangInfo(node=null, type=0)";
        }
    }

    public static final class b {
    }

    public static final class c implements Runnable {
        public final /* synthetic */ l a;

        public c(l r1) {
            this.a = r1;
        }

        public final void a() {
            l r0 = this.a;
            if (((ArrayList) r0.a).size() == 0) goto L23;
            List r1 = CollectionsKt.toList(r0.a);
            SQLiteDatabase r2 = r0.getWritableDatabase();
            r2.beginTransaction();
            Iterator r3 = r1.iterator();     // Catch: Throwable -> L16 SQLiteException -> L18
        L7:
            if (r3.hasNext() == false) goto L14;
            a r4 = (a) r3.next();     // Catch: Throwable -> L16 SQLiteException -> L18
            switch(r4.getType()) {
                case 10001: goto L13;
                case 10002: goto L12;
                case 10003: goto L11;
                default: goto L7;
            };     // Catch: Throwable -> L16 SQLiteException -> L18
        L11:
            r4.getClass();     // Catch: Throwable -> L16 SQLiteException -> L18
            r0.d(null, r2);     // Catch: Throwable -> L16 SQLiteException -> L18
            goto L7
        L12:
            r4.getClass();     // Catch: Throwable -> L16 SQLiteException -> L18
            r0.a(null, r2);     // Catch: Throwable -> L16 SQLiteException -> L18
            goto L7
        L13:
            r4.getClass();     // Catch: Throwable -> L16 SQLiteException -> L18
            r0.b(null, r2);     // Catch: Throwable -> L16 SQLiteException -> L18
            goto L7
        L14:
            r2.setTransactionSuccessful();     // Catch: Throwable -> L16 SQLiteException -> L18
        L20:
            r2.endTransaction();
            r2.close();
            ((ArrayList) r0.a).clear();
            goto L23
        L18:
            e = move-exception;
            ALogger.e("LiveComposerSQLiteHelper", e);     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            r2.endTransaction();
            r2.close();
            throw th;
        L23:
            r0.getClass();
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r3) {
        c(true, "");
        if (r3 == null) goto L5;
        r3.execSQL("CREATE TABLE IF NOT EXISTS live_composer_node (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,panel TEXT,effect_id TEXT,resource_id TEXT,path TEXT,update_time INTEGER,use INTEGER,is_high_cost INTEGER)");
    L5:
        if (r3 == null) goto L7;
        r3.execSQL("CREATE TABLE IF NOT EXISTS live_composer_tag_node(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,tag TEXT,value REAL,node_id INTEGER)");
    L7:
        c(false, "onCreate");
    }

    public l(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "dbName");
        super(r3, r4, null, 3);
        this.a = new ArrayList();
        PthreadHandlerThreadV2 r5 = new PthreadHandlerThreadV2("ComposerSQLiteHelperThread");
        ThreadMethodProxy.start(r5);
        new Handler(r5.getLooper());
        new c(this);
    }

    public final void a(n r12, SQLiteDatabase r13) {
        c(true, "");
        Cursor r3 = r13.query("live_composer_node", new String[]{"id"}, "effect_id = ?", new String[]{r12.b}, null, null, null);     // Catch: SQLiteException -> L11
        if (r3.moveToFirst() == false) goto L6;
        int r0 = r3.getInt(r3.getColumnIndex("id"));     // Catch: SQLiteException -> L11
    L7:
        r3.close();     // Catch: SQLiteException -> L11
        r13.delete("live_composer_node", "effect_id = ?", new String[]{r12.b});     // Catch: SQLiteException -> L11
        if (r0 == (-1)) goto L13;
        r13.delete("live_composer_tag_node", "node_id = ?", new String[]{String.valueOf(r0)});     // Catch: SQLiteException -> L11
    L13:
        c(false, "deleteComposerNode");
        return;
    L6:
        r0 = -1;
    L11:
        e = move-exception;
        ALogger.e("LiveComposerSQLiteHelper", e);
        goto L13
    }

    public final void b(n r9, SQLiteDatabase r11) {
        int r1 = 1;
        c(true, "");
        ContentValues r2 = new ContentValues();     // Catch: SQLiteException -> L16
        r2.put("panel", r9.a);     // Catch: SQLiteException -> L16
        r2.put("effect_id", r9.b);     // Catch: SQLiteException -> L16
        r2.put("resource_id", r9.c);     // Catch: SQLiteException -> L16
        r2.put("path", r9.d);     // Catch: SQLiteException -> L16
        r2.put("update_time", Long.valueOf(r9.g));     // Catch: SQLiteException -> L16
        if (r9.j == false) goto L6;
        int r4 = 1;
    L7:
        r2.put("use", Integer.valueOf(r4));     // Catch: SQLiteException -> L16
        if (r9.f == true) goto L11;
        r1 = 0;
    L11:
        r2.put("is_high_cost", Integer.valueOf(r1));     // Catch: SQLiteException -> L16
        long r3 = r11.insert("live_composer_node", null, r2);     // Catch: SQLiteException -> L16
        Iterator r12 = ((ArrayList) r9.i).iterator();     // Catch: SQLiteException -> L16
    L13:
        if (r12.hasNext() == false) goto L18;
        p r5 = (p) r12.next();     // Catch: SQLiteException -> L16
        ContentValues r6 = new ContentValues();     // Catch: SQLiteException -> L16
        r6.put("tag", r5.b);     // Catch: SQLiteException -> L16
        r6.put("value", r5.a);     // Catch: SQLiteException -> L16
        r6.put("node_id", Long.valueOf(r3));     // Catch: SQLiteException -> L16
        r11.insert("live_composer_tag_node", null, r6);     // Catch: SQLiteException -> L16
    L18:
        c(false, "saveComposerNode");
        return;
    L6:
        r4 = 0;
    L16:
        e = move-exception;
        ALogger.e("LiveComposerSQLiteHelper", e);
        goto L18
    }

    public final void c(boolean r5, String r6) {
        if (r5 == false) goto L5;
        this.b = System.currentTimeMillis();
        return;
    L5:
        ALogger.d("LiveUxTracer", "compose sql, duration of " + r6 + ": " + (System.currentTimeMillis() - this.b) + ", thread: " + ThreadMethodProxy.currentThread().getName());
    }

    public final void d(n r12, SQLiteDatabase r13) {
        c(true, "");
        Cursor r3 = r13.query("live_composer_node", new String[]{"id"}, "effect_id = ?", new String[]{r12.b}, null, null, null);     // Catch: SQLiteException -> L14
        if (r3.moveToFirst() == false) goto L6;
        int r0 = r3.getInt(r3.getColumnIndex("id"));     // Catch: SQLiteException -> L14
    L7:
        r3.close();     // Catch: SQLiteException -> L14
        ContentValues r4 = new ContentValues();     // Catch: SQLiteException -> L14
        r4.put("update_time", Long.valueOf(r12.g));     // Catch: SQLiteException -> L14
        r13.update("live_composer_node", r4, "effect_id = ?", new String[]{r12.b});     // Catch: SQLiteException -> L14
        if (r0 == (-1)) goto L16;
        Iterator r14 = new ArrayList(r12.i).iterator();     // Catch: SQLiteException -> L14
    L10:
        if (r14.hasNext() == false) goto L16;
        p r5 = (p) r14.next();     // Catch: SQLiteException -> L14
        ContentValues r6 = new ContentValues();     // Catch: SQLiteException -> L14
        r6.put("value", r5.a);     // Catch: SQLiteException -> L14
        r13.update("live_composer_tag_node", r6, "node_id = ? and tag = ?", new String[]{String.valueOf(r0), r5.b});     // Catch: SQLiteException -> L14
    L16:
        c(false, "updateComposerNode");
        return;
    L6:
        r0 = -1;
    L14:
        e = move-exception;
        ALogger.e("LiveComposerSQLiteHelper", e);
        goto L16
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase r1, int r2, int r3) {
        if (r1 != null) goto L4;
        return;
    L4:
        r1.execSQL("Drop Table if exists live_composer_node");
        r1.execSQL("Drop Table if exists live_composer_tag_node");
        onCreate(r1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r1, int r2, int r3) {
        if (r2 >= 2) goto L7;
        if (r1 == null) goto L7;
        r1.execSQL("ALTER TABLE live_composer_node ADD COLUMN resource_id TEXT DEFAULT \"\" NOT NULL;");
    L7:
        if (r2 >= 3) goto L11;
        if (r1 == null) goto L12;
        r1.execSQL("ALTER TABLE live_composer_node ADD COLUMN is_high_cost INTEGER DEFAULT 0 NOT NULL;");
        return;
    L12:
        return;
    }
}
