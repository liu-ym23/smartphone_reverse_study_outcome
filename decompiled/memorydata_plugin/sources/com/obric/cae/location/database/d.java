package com.obric.cae.location.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile d f7087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f7088b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7089a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f7090b;
        public final String c;
        public final String d;
        public final String e;
        public final String f;

        public a(String r2, String r3, String r4, String r5, String r6, String r7) {
            if (r2 != null) goto L5;
            r2 = "";
        L5:
            this.f7089a = r2;
            if (r3 != null) goto L8;
            r3 = "";
        L8:
            this.f7090b = r3;
            if (r4 != null) goto L11;
            r4 = "";
        L11:
            this.c = r4;
            if (r5 != null) goto L14;
            r5 = "";
        L14:
            this.d = r5;
            if (r6 != null) goto L17;
            r6 = "";
        L17:
            this.e = r6;
            if (r7 != null) goto L20;
            r7 = "";
        L20:
            this.f = r7;
        }

        public boolean a() {
            if (this.f.isEmpty() == false) goto L5;
        L7:
            return false;
        L5:
            if ("0".equals(this.f) == true) goto L7;
            return true;
        }
    }

    public static class b extends SQLiteOpenHelper {
        public b(Context r4) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), "star_pois.db", null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase r1) {
            r1.execSQL("create table poi_datas (_id INTEGER PRIMARY KEY,new_type_name_l1 TEXT DEFAULT '',new_type_name_l2 TEXT DEFAULT '',new_type_name_l3 TEXT DEFAULT '',new_type_code_l1 TEXT DEFAULT '',new_type_code_l2 TEXT DEFAULT '',new_type_code_l3 TEXT DEFAULT '',UNIQUE(new_type_name_l1,new_type_name_l2,new_type_name_l3,new_type_code_l1,new_type_code_l2,new_type_code_l3));");
            r1.execSQL("CREATE INDEX IF NOT EXISTS poi_datas_code_index ON poi_datas (new_type_code_l1,new_type_code_l2,new_type_code_l3);");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onDowngrade(SQLiteDatabase r2, int r3, int r4) {
            com.obric.cae.log.a.g("StarLocation-poi-db", "Downgrading database from version " + r3 + " to " + r4);
            r2.execSQL("DROP TABLE IF EXISTS poi_datas");
            r2.execSQL("create table poi_datas (_id INTEGER PRIMARY KEY,new_type_name_l1 TEXT DEFAULT '',new_type_name_l2 TEXT DEFAULT '',new_type_name_l3 TEXT DEFAULT '',new_type_code_l1 TEXT DEFAULT '',new_type_code_l2 TEXT DEFAULT '',new_type_code_l3 TEXT DEFAULT '',UNIQUE(new_type_name_l1,new_type_name_l2,new_type_name_l3,new_type_code_l1,new_type_code_l2,new_type_code_l3));");
            r2.execSQL("CREATE INDEX IF NOT EXISTS poi_datas_code_index ON poi_datas (new_type_code_l1,new_type_code_l2,new_type_code_l3);");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onOpen(SQLiteDatabase r1) {
            super.onOpen(r1);
            d.b(r1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase r2, int r3, int r4) {
            com.obric.cae.log.a.e("StarLocation-poi-db", "Upgrading database from version " + r3 + " to " + r4);
            r2.execSQL("DROP TABLE IF EXISTS poi_datas");
            r2.execSQL("create table poi_datas (_id INTEGER PRIMARY KEY,new_type_name_l1 TEXT DEFAULT '',new_type_name_l2 TEXT DEFAULT '',new_type_name_l3 TEXT DEFAULT '',new_type_code_l1 TEXT DEFAULT '',new_type_code_l2 TEXT DEFAULT '',new_type_code_l3 TEXT DEFAULT '',UNIQUE(new_type_name_l1,new_type_name_l2,new_type_name_l3,new_type_code_l1,new_type_code_l2,new_type_code_l3));");
            r2.execSQL("CREATE INDEX IF NOT EXISTS poi_datas_code_index ON poi_datas (new_type_code_l1,new_type_code_l2,new_type_code_l3);");
        }
    }

    public d(Context r4) {
        this.f7088b = new b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    public static int a(SQLiteDatabase r6, List r7) {
        Iterator r8 = ((List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin")).iterator();
        int r0 = 0;
    L4:
        if (r8.hasNext() == false) goto L15;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r8.next(), a.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L4;
        if (r2.a() == false) goto L4;
        ContentValues r3 = new ContentValues();
        r3.put("new_type_name_l1", r2.f7089a);
        r3.put("new_type_name_l2", r2.f7090b);
        r3.put("new_type_name_l3", r2.c);
        r3.put("new_type_code_l1", r2.d);
        r3.put("new_type_code_l2", r2.e);
        r3.put("new_type_code_l3", r2.f);
        if (r6.replace("poi_datas", null, r3) == (-1)) goto L14;
        r0 = r0 + 1;
        goto L4
    L14:
        throw new IllegalStateException("replace failed for poiData");
    L15:
        return r0;
    }

    public static synchronized d a(Context r3) {
        monitor-enter(d.class);
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (f7087a != null) goto L7;
        f7087a = new d(r4);     // Catch: Throwable -> L10
    L7:
        d r5 = f7087a;     // Catch: Throwable -> L10
        monitor-exit(d.class);
        return r5;
    L10:
        th = move-exception;
        throw th;
    }

    public static boolean a(SQLiteDatabase r2) {
        Cursor r3 = r2.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name=?", new String[]{"poi_datas"});
        if (r3 != null) goto L17;
    L13:
        boolean r0 = false;
    L14:
        if (r3 == null) goto L16;
        r3.close();
    L16:
        return r0;
    L17:
        if (r3.moveToFirst() == false) goto L13;
        r0 = true;
    L7:
        th = move-exception;
        r3.close();     // Catch: Throwable -> L10
    L12:
        throw th;
    L10:
        th = move-exception;
        th.addSuppressed(th);
        goto L12
    }

    public static void b(SQLiteDatabase r4) {
        if (a(r4) == true) goto L5;
        r4.execSQL("create table poi_datas (_id INTEGER PRIMARY KEY,new_type_name_l1 TEXT DEFAULT '',new_type_name_l2 TEXT DEFAULT '',new_type_name_l3 TEXT DEFAULT '',new_type_code_l1 TEXT DEFAULT '',new_type_code_l2 TEXT DEFAULT '',new_type_code_l3 TEXT DEFAULT '',UNIQUE(new_type_name_l1,new_type_name_l2,new_type_name_l3,new_type_code_l1,new_type_code_l2,new_type_code_l3));");
        com.obric.cae.log.a.e("StarLocation-poi-db", "created poi_datas table");
    L5:
        r4.execSQL("CREATE INDEX IF NOT EXISTS poi_datas_code_index ON poi_datas (new_type_code_l1,new_type_code_l2,new_type_code_l3);");
        int r5 = r4.delete("poi_datas", "new_type_code_l3 IS NULL OR new_type_code_l3='' OR new_type_code_l3='0'", null);
        if (r5 <= 0) goto L9;
        com.obric.cae.log.a.f("StarLocation-poi-db", "deleted invalid poi_datas count=" + r5);
        return;
    }

    public synchronized a a(String r13) {
        monitor-enter(this);
        if (r13 != null) goto L41;
    L34:
        monitor-exit(this);
        return null;
    L41:
    L36:
        th = move-exception;
        throw th;
    L6:
        if (r13.isEmpty() == true) goto L34;
        SQLiteDatabase r3 = this.f7088b.getReadableDatabase();     // Catch: Throwable -> L36
        b(r3);     // Catch: Throwable -> L36
        Cursor r2 = r3.query("poi_datas", new String[]{"new_type_name_l1", "new_type_name_l2", "new_type_name_l3", "new_type_code_l1", "new_type_code_l2", "new_type_code_l3"}, "new_type_code_l3=?", new String[]{r13}, null, null, null, "1");     // Catch: Exception -> L30 Throwable -> L36
        if (r2 != null) goto L42;
    L18:
        com.obric.cae.log.a.f("StarLocation-poi-db", "no poi data for newTypeCodeL3=".concat(r13));     // Catch: Throwable -> L23
        if (r2 == null) goto L21;
        r2.close();     // Catch: Exception -> L30 Throwable -> L36
    L21:
        monitor-exit(this);
        return null;
    L42:
    L23:
        th = move-exception;
        if (r2 != null) goto L39;
    L29:
        throw th;     // Catch: Exception -> L30 Throwable -> L36
    L39:
        r2.close();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L30 Throwable -> L36
        goto L29
    L12:
        if (r2.moveToFirst() == false) goto L18;
        a r0 = new a(r2.getString(r2.getColumnIndexOrThrow("new_type_name_l1")), r2.getString(r2.getColumnIndexOrThrow("new_type_name_l2")), r2.getString(r2.getColumnIndexOrThrow("new_type_name_l3")), r2.getString(r2.getColumnIndexOrThrow("new_type_code_l1")), r2.getString(r2.getColumnIndexOrThrow("new_type_code_l2")), r2.getString(r2.getColumnIndexOrThrow("new_type_code_l3")));     // Catch: Throwable -> L23
        r2.close();     // Catch: Exception -> L30 Throwable -> L36
        monitor-exit(this);
        return r0;
    L30:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-poi-db", "failed newTypeCodeL3=".concat(r13), e);     // Catch: Throwable -> L36
        return null;
    }

    public synchronized boolean a() {
        monitor-enter(this);
        SQLiteDatabase r0 = this.f7088b.getReadableDatabase();     // Catch: Throwable -> L29
        b(r0);     // Catch: Throwable -> L29
        Cursor r1 = r0.rawQuery("SELECT COUNT(1) FROM poi_datas", null);     // Catch: Exception -> L25 Throwable -> L29
        if (r1 != null) goto L36;
    L17:
        int r2 = -1;
    L18:
        if (r2 <= 0) goto L20;
        boolean r3 = true;
    L21:
        if (r1 == null) goto L23;
        r1.close();     // Catch: Exception -> L25 Throwable -> L29
    L23:
        monitor-exit(this);
        return r3;
    L20:
        r3 = false;
        goto L21
    L36:
    L11:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L14
    L16:
        throw th;     // Catch: Exception -> L25 Throwable -> L29
    L14:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L25 Throwable -> L29
        goto L16
    L8:
        if (r1.moveToFirst() == false) goto L17;
        r2 = r1.getInt(0);     // Catch: Throwable -> L11
    L25:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-poi-db", "failed", e);     // Catch: Throwable -> L29
        return false;
    L29:
        th = move-exception;
        throw th;
    }

    public synchronized boolean a(List<a> r6) {
        monitor-enter(this);
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        boolean r2 = false;
        if (r7.isEmpty() == false) goto L8;
        com.obric.cae.log.a.h("StarLocation-poi-db", "poiDatas is empty");     // Catch: Throwable -> L24
        monitor-exit(this);
        return false;
    L8:
        SQLiteDatabase r1 = this.f7088b.getWritableDatabase();     // Catch: Throwable -> L24
        r1.beginTransaction();     // Catch: Throwable -> L24
        b(r1);     // Catch: Throwable -> L15 Exception -> L17
        r1.delete("poi_datas", null, null);     // Catch: Throwable -> L15 Exception -> L17
        int r8 = a(r1, r7);     // Catch: Throwable -> L15 Exception -> L17
        r1.setTransactionSuccessful();     // Catch: Throwable -> L15 Exception -> L17
        com.obric.cae.log.a.f("StarLocation-poi-db", "success count=" + r8);     // Catch: Throwable -> L15 Exception -> L17
        if (r8 <= 0) goto L12;
        r2 = true;
    L12:
        r1.endTransaction();     // Catch: Throwable -> L24
        monitor-exit(this);
        return r2;
    L15:
        th = move-exception;
        r1.endTransaction();     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L17:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-poi-db", "failed", e);     // Catch: Throwable -> L15
        r1.endTransaction();     // Catch: Throwable -> L24
        return false;
    L24:
        th = move-exception;
        throw th;
    }
}
