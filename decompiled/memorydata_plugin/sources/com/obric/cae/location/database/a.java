package com.obric.cae.location.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.location.Location;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile a f7066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f7067b;
    public final b c;
    public final b d;

    /* JADX INFO: renamed from: com.obric.cae.location.database.a$a, reason: collision with other inner class name */
    public static class C0353a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7068a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f7069b;
        public final String c;
        public final long d;
        public final long e;
        public Double f;
        public Double g;
        public Double h;
        public String i;
        public String j;

        public C0353a(String r1, String r2, String r3, long r4, long r6) {
            this.f7068a = r1;
            this.f7069b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r6;
        }

        public String a() {
            return this.f7069b;
        }

        public void a(double r1) {
            this.f = Double.valueOf(r1);
        }

        public void a(String r1) {
            this.i = r1;
        }

        public String b() {
            return this.c;
        }

        public void b(double r1) {
            this.g = Double.valueOf(r1);
        }

        public void b(String r1) {
            this.j = r1;
        }

        public long c() {
            return this.d;
        }

        public void c(double r1) {
            this.h = Double.valueOf(r1);
        }

        public long d() {
            return this.e;
        }

        public Double e() {
            return this.f;
        }

        public Double f() {
            return this.g;
        }

        public Double g() {
            return this.h;
        }

        public String getType() {
            return this.f7068a;
        }

        public String h() {
            return this.i;
        }

        public String i() {
            return this.j;
        }
    }

    public static class b extends SQLiteOpenHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7070a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f7071b;

        public b(Context r3, String r4, String r5) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, null, 1);
            this.f7070a = r4;
            this.f7071b = r5;
        }

        public static boolean a(SQLiteDatabase r2) {
            Cursor r3 = r2.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name=?", new String[]{"cells_info"});
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

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase r1) {
            r1.execSQL(this.f7071b);
            r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS cells_info_unique_index ON cells_info (type,mcc,mnc,lac,cid);");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onDowngrade(SQLiteDatabase r3, int r4, int r5) {
            com.obric.cae.log.a.g("StarLocation-cell-db", "Downgrading database " + this.f7070a + " from version " + r4 + " to " + r5);
            r3.execSQL("DROP TABLE IF EXISTS cells_info");
            r3.execSQL(this.f7071b);
            r3.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS cells_info_unique_index ON cells_info (type,mcc,mnc,lac,cid);");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onOpen(SQLiteDatabase r3) {
            super.onOpen(r3);
            if (a(r3) == true) goto L5;
            r3.execSQL(this.f7071b);
            com.obric.cae.log.a.e("StarLocation-cell-db", "onOpen schema repair created cells_info table, db=" + this.f7070a);
        L5:
            r3.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS cells_info_unique_index ON cells_info (type,mcc,mnc,lac,cid);");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase r7, int r8, int r9) {
            com.obric.cae.log.a.e("StarLocation-cell-db", "Upgrading database " + this.f7070a + " from version " + r8 + " to " + r9);
            r7.beginTransaction();
            r7.execSQL("DROP TABLE IF EXISTS cells_info");     // Catch: Throwable -> L5 Exception -> L7
            r7.execSQL(this.f7071b);     // Catch: Throwable -> L5 Exception -> L7
            r7.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS cells_info_unique_index ON cells_info (type,mcc,mnc,lac,cid);");     // Catch: Throwable -> L5 Exception -> L7
            r7.setTransactionSuccessful();     // Catch: Throwable -> L5 Exception -> L7
            com.obric.cae.log.a.e("StarLocation-cell-db", "Database upgrade successful " + this.f7070a + " from " + r8 + " to " + r9);     // Catch: Throwable -> L5 Exception -> L7
        L9:
            r7.endTransaction();
            return;
        L7:
            e = move-exception;
            com.obric.cae.log.a.a("StarLocation-cell-db", "Error upgrading database " + this.f7070a + " from " + r8 + " to " + r9, e);     // Catch: Throwable -> L5
        L5:
            th = move-exception;
            r7.endTransaction();
            throw th;
        }
    }

    public a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        this.f7067b = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        this.c = new b(r5, "star_cell.db", "create table cells_info (_id INTEGER PRIMARY KEY,type TEXT,mcc TEXT,mnc TEXT,lac INTEGER,cid INTEGER,latitude REAL,longitude REAL,radius REAL,pois TEXT DEFAULT '',aois TEXT DEFAULT '');");
        this.d = new b(r5, "near_cell.db", "create table cells_info (_id INTEGER PRIMARY KEY,type TEXT,mcc TEXT,mnc TEXT,lac INTEGER,cid INTEGER);");
    }

    public static ContentValues a(Cursor r4) {
        Cursor r5 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r4, Cursor.class, "com.obric.memorydata.plugin");
        ContentValues r0 = new ContentValues();
        r0.put("type", r5.getString(r5.getColumnIndexOrThrow("type")));
        r0.put("mcc", r5.getString(r5.getColumnIndexOrThrow("mcc")));
        r0.put("mnc", r5.getString(r5.getColumnIndexOrThrow("mnc")));
        r0.put("lac", Long.valueOf(r5.getLong(r5.getColumnIndexOrThrow("lac"))));
        r0.put("cid", Long.valueOf(r5.getLong(r5.getColumnIndexOrThrow("cid"))));
        return r0;
    }

    public static Cursor a(b r10, String[] r11, String r12, String[] r13) {
        com.obric.cae.log.a.a("StarLocation-cell-db", "DB query, table=cells_info, selection=" + r12);
        return r10.getReadableDatabase().query("cells_info", r11, r12, r13, null, null, null);
    }

    public static synchronized a a(Context r3) {
        monitor-enter(a.class);
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (f7066a != null) goto L7;
        f7066a = new a(r4);     // Catch: Throwable -> L10
    L7:
        a r5 = f7066a;     // Catch: Throwable -> L10
        monitor-exit(a.class);
        return r5;
    L10:
        th = move-exception;
        throw th;
    }

    public static boolean a(b r6, ContentValues r7) {
        com.obric.cae.log.a.c("StarLocation-cell-db", "DB replace, table=cells_info, values=" + r7);
        long r2 = r6.getWritableDatabase().replace("cells_info", null, r7);
        if (r2 != (-1)) goto L5;
        com.obric.cae.log.a.c("StarLocation-cell-db", "replace failed for cells_info values: " + r7);
    L5:
        if (r2 == (-1)) goto L7;
        return true;
    L7:
        return false;
    }

    public static String[] b() {
        return new String[]{"type", "mcc", "mnc", "lac", "cid", "latitude", "longitude", "radius", "pois", "aois"};
    }

    public static String[] b(String r2, String r3, String r4, long r5, long r7) {
        return new String[]{r2, r3, r4, String.valueOf(r5), String.valueOf(r7)};
    }

    public static String[] c() {
        return new String[]{"type", "mcc", "mnc", "lac", "cid", "latitude", "longitude"};
    }

    public synchronized Cursor a(String r3, String r4, String r5, long r6, long r8) {
        monitor-enter(this);
        Cursor r7 = a(this.c, b(), "type = ? AND mcc = ? AND mnc = ? AND lac = ? AND cid = ?", b(r3, r4, r5, r6, r8));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r7;
    L6:
        th = move-exception;
        throw th;
    }

    public void a() {
        com.obric.cae.location.cell.a.a(this.f7067b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v6 */
    public synchronized boolean a(Location r26) {
        monitor-enter(this);
        if (r26 != null) goto L93;
    L84:
        com.obric.cae.log.a.c("StarLocation-cell-db", "refreshNearCellDb skip, invalid last delivered location=" + r26);     // Catch: Throwable -> L86
    L78:
        monitor-exit(this);
        return false;
    L93:
        com.obric.cae.location.util.d r3 = com.obric.cae.location.util.d.a();     // Catch: Throwable -> L86
        double r4 = r26.getLatitude();     // Catch: Throwable -> L86
        SQLiteDatabase r6 = r26.getLongitude();     // Catch: Throwable -> L86
        if (r3.a(r4, r6) == false) goto L84;
        SQLiteDatabase r5 = this.c.getReadableDatabase();     // Catch: Throwable -> L86
        SQLiteDatabase r7 = this.d.getWritableDatabase();     // Catch: Throwable -> L86
        r7.beginTransaction();     // Catch: Throwable -> L86
        Cursor r8 = r5.query("cells_info", c(), null, null, null, null, null);     // Catch: Throwable -> L74
        Double r9 = null;
        r7.delete("cells_info", null, null);     // Catch: Throwable -> L62
        int r10 = 0;
        int r11 = 0;
        int r12 = 0;
    L11:
        if (r8.moveToNext() == false) goto L50;
        int r13 = r8.getColumnIndexOrThrow("latitude");     // Catch: Throwable -> L62
        if (r8.isNull(r13) == false) goto L16;
        Double r14 = r9;
    L17:
        int r15 = r8.getColumnIndexOrThrow("longitude");     // Catch: Throwable -> L62
        if (r8.isNull(r15) == false) goto L20;
        Double r16 = r9;
    L21:
        if (r14 == null) goto L47;
        if (r16 == null) goto L47;
        double r17 = r26.getLatitude();     // Catch: Throwable -> L62
        SQLiteDatabase r23 = r7;
        double r2 = r26.getLongitude();     // Catch: Throwable -> L45
        int r24 = r11;
        double r18 = r14.doubleValue();     // Catch: Throwable -> L45
        double r19 = r16.doubleValue();     // Catch: Throwable -> L45
        com.obric.cae.location.util.d r20 = com.obric.cae.location.util.d.a();     // Catch: Throwable -> L45
        if (r20.a(r17, r2) == true) goto L91;
    L36:
        boolean r110 = false;
    L37:
        if (r110 == false) goto L38;
        SQLiteDatabase r21 = r23;
        Double r22 = null;
        if (r21.replace("cells_info", null, a(r8)) == (-1)) goto L43;
        r7 = r21;
        r9 = null;
        r11 = r24 + 1;     // Catch: Throwable -> L60
        goto L11
    L43:
        r10 = r10 + 1;     // Catch: Throwable -> L60
        SQLiteDatabase r25 = r21;
    L49:
        r7 = r25;
        r9 = r22;
        r11 = r24;
        goto L11
    L38:
        SQLiteDatabase r27 = r23;
        r22 = null;
    L94:
        r12 = r12 + 1;     // Catch: Throwable -> L60
        r25 = r27;
    L60:
        th = th;
    L64:
        Throwable r28 = th;
        r6 = r27;
    L65:
        if (r8 == null) goto L113;
        r8.close();     // Catch: Throwable -> L68
    L114:
        throw r28;     // Catch: Throwable -> L72
    L68:
        th = move-exception;
        r28.addSuppressed(th);     // Catch: Throwable -> L72
        throw r28;     // Catch: Throwable -> L72
    L113:
        throw r28;     // Catch: Throwable -> L72
    L91:
    L34:
        th = move-exception;
        r28 = th;
        r6 = r23;
        goto L65
    L28:
        if (r20.a(r18, r19) == false) goto L36;
        if (r20.a(r17, r2, r18, r19) > 3000.0d) goto L36;
        r110 = true;
    L45:
        th = th;
        r27 = r23;
    L47:
        r24 = r11;
        r22 = r9;
        r27 = r7;
        goto L94
    L20:
        r16 = Double.valueOf(r8.getDouble(r15));     // Catch: Throwable -> L62
        goto L21
    L16:
        r14 = Double.valueOf(r8.getDouble(r13));     // Catch: Throwable -> L62
        goto L17
    L50:
        r27 = r7;
        com.obric.cae.log.a.d("StarLocation-cell-db", new StringBuilder().append("refreshNearCellDb finished, matched=").append(r11).append(", skipped=").append(r12).append(", failed=").append(r10).append(", thresholdMeters=").append(3000.0d).append(", location=").append(r26.getLatitude()).append(",").append(r26.getLongitude()).toString());     // Catch: Throwable -> L60
        if (r10 != 0) goto L53;
        r27.setTransactionSuccessful();     // Catch: Throwable -> L60
    L53:
        if (r10 != 0) goto L55;
        boolean r111 = true;
    L56:
        r8.close();     // Catch: Throwable -> L72
        r27.endTransaction();     // Catch: Throwable -> L86
        monitor-exit(this);
        return r111;
    L55:
        r111 = false;
    L62:
        th = th;
        r27 = r7;
    L72:
        th = th;
    L97:
        com.obric.cae.log.a.a("StarLocation-cell-db", "refreshNearCellDb failed", th);     // Catch: Throwable -> L81
        r6.endTransaction();     // Catch: Throwable -> L86
        goto L78
    L81:
        th = move-exception;
        r6.endTransaction();     // Catch: Throwable -> L86
        throw th;     // Catch: Throwable -> L86
    L74:
        th = th;
        r6 = r7;
    L86:
        th = move-exception;
        throw th;
    }

    public synchronized boolean a(C0353a r4) {
        monitor-enter(this);
        if (r4 != null) goto L8;
        com.obric.cae.log.a.c("StarLocation-cell-db", "insertOrReplaceCellInfo, cellInfo is null");     // Catch: Throwable -> L25
        monitor-exit(this);
        return false;
    L8:
        ContentValues r0 = new ContentValues();     // Catch: Throwable -> L25
        r0.put("type", r4.getType());     // Catch: Throwable -> L25
        r0.put("mcc", r4.a());     // Catch: Throwable -> L25
        r0.put("mnc", r4.b());     // Catch: Throwable -> L25
        r0.put("lac", Long.valueOf(r4.c()));     // Catch: Throwable -> L25
        r0.put("cid", Long.valueOf(r4.d()));     // Catch: Throwable -> L25
        if (r4.e() != null) goto L11;
        r0.putNull("latitude");     // Catch: Throwable -> L25
    L13:
        if (r4.f() != null) goto L15;
        r0.putNull("longitude");     // Catch: Throwable -> L25
    L17:
        if (r4.g() != null) goto L19;
        r0.putNull("radius");     // Catch: Throwable -> L25
    L20:
        r0.put("pois", r4.h());     // Catch: Throwable -> L25
        r0.put("aois", r4.i());     // Catch: Throwable -> L25
        boolean r5 = a(this.c, r0);     // Catch: Throwable -> L25
        if (r5 == false) goto L23;
        com.obric.cae.log.a.f("StarLocation-cell-db", "refreshToRfsAsync after successful cell db write, success=" + com.obric.cae.location.cell.a.a(this.f7067b));     // Catch: Throwable -> L25
    L23:
        monitor-exit(this);
        return r5;
    L19:
        r0.put("radius", r4.g());     // Catch: Throwable -> L25
        goto L20
    L15:
        r0.put("longitude", r4.f());     // Catch: Throwable -> L25
        goto L17
    L11:
        r0.put("latitude", r4.e());     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }
}
