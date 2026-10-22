package com.tencent.wcdb.database;

import android.content.Context;
import com.tencent.wcdb.support.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f15854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f15855b;
    private final SQLiteDatabase.a c;
    private final int d;
    private SQLiteDatabase e;
    private boolean f;
    private boolean g;
    private boolean h;
    private final com.tencent.wcdb.g i;
    private byte[] j;
    private SQLiteCipherSpec k;
    private int l;
    private boolean m;

    static {
        SQLiteGlobal.a();
    }

    public h(Context r3, String r4, byte[] r5, SQLiteCipherSpec r6, SQLiteDatabase.a r7, int r8, com.tencent.wcdb.g r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        SQLiteDatabase.a r11 = (SQLiteDatabase.a) ZeusTransformUtils.wrapperContextForParams(r7, SQLiteDatabase.a.class, "com.obric.memorydata.plugin");
        com.tencent.wcdb.g r12 = (com.tencent.wcdb.g) ZeusTransformUtils.wrapperContextForParams(r9, com.tencent.wcdb.g.class, "com.obric.memorydata.plugin");
        if (r8 < 1) goto L11;
        this.f15854a = ZeusTransformUtils.wrapperContext(r10, "com.obric.memorydata.plugin");
        this.f15855b = r4;
        this.c = r11;
        this.d = r8;
        this.i = r12;
        this.j = r5;
        if (r6 != null) goto L7;
        SQLiteCipherSpec r13 = null;
    L8:
        this.k = r13;
        this.m = false;
        return;
    L7:
        r13 = new SQLiteCipherSpec(r6);
        goto L8
    L11:
        throw new IllegalArgumentException("Version must be >= 1, was " + r8);
    }

    private SQLiteDatabase a(boolean r13) {
        SQLiteDatabase r0 = this.e;
        if (r0 == null) goto L13;
        if (r0.k() == true) goto L7;
        this.e = null;
        goto L13
    L7:
        if (r13 == false) goto L11;
        if (this.e.j() == true) goto L13;
    L11:
        return this.e;
    L13:
        if (this.f == true) goto L51;
        SQLiteDatabase r1 = this.e;
        this.f = true;     // Catch: Throwable -> L43
        if (r1 == null) goto L21;
        if (r13 == true) goto L19;
    L35:
        SQLiteDatabase r14 = d(r1);     // Catch: Throwable -> L43
        this.f = false;
        if (r1 != null) goto L39;
    L41:
        return r14;
    L39:
        if (r1 == this.e) goto L41;
        r1.close();
        goto L41
    L19:
        if (r1.j() == false) goto L35;
        r1.h();     // Catch: Throwable -> L43
        goto L35
    L21:
        String r5 = this.f15855b;     // Catch: Throwable -> L43
        if (r5 != null) goto L25;
        SQLiteDatabase r15 = SQLiteDatabase.a(null);     // Catch: Throwable -> L43
    L24:
        r1 = r15;
        goto L35
    L25:
        boolean r11 = this.h;     // Catch: Throwable -> L43
        this.m = true;     // Catch: SQLiteException -> L32 Throwable -> L43
        if (this.g == false) goto L29;
        int r8 = 8;
    L30:
        this.l = r8;     // Catch: SQLiteException -> L32 Throwable -> L43
        r15 = com.tencent.wcdb.support.b.a(this.f15854a, r5, this.j, this.k, r8, this.c, this.i, r11 ? 1 : 0);     // Catch: SQLiteException -> L32 Throwable -> L43
    L29:
        r8 = 0;
    L32:
        e = move-exception;
        if (r13 == true) goto L42;
        Log.a("WCDB.SQLiteOpenHelper", "Couldn't open " + this.f15855b + " for writing (will try read-only):", new Object[]{e});     // Catch: Throwable -> L43
        r15 = SQLiteDatabase.a(this.f15854a.getDatabasePath(this.f15855b).getPath(), this.j, this.k, this.c, 1, this.i);     // Catch: Throwable -> L43
        goto L24
    L42:
        throw e;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        this.f = false;
        if (r1 != null) goto L47;
    L49:
        throw th;
    L47:
        if (r1 == this.e) goto L49;
        r1.close();
        goto L49
    L51:
        throw new IllegalStateException("getDatabase called recursively");
    }

    private SQLiteDatabase d(SQLiteDatabase r4) {
        a(r4);
        int r0 = r4.i();
        if (r0 != this.d) goto L5;
    L20:
        c(r4);
        if (r4.j() == false) goto L23;
        Log.b("WCDB.SQLiteOpenHelper", "Opened " + this.f15855b + " in read-only mode");
    L23:
        this.e = r4;
        return r4;
    L5:
        if (r4.j() == true) goto L19;
        r4.e();
        if (r0 != 0) goto L9;
        b(r4);     // Catch: Throwable -> L15
    L13:
        r4.a(this.d);     // Catch: Throwable -> L15
        r4.g();     // Catch: Throwable -> L15
        r4.f();
        goto L20
    L9:
        int r1 = this.d;     // Catch: Throwable -> L15
        if (r0 <= r1) goto L12;
        b(r4, r0, r1);     // Catch: Throwable -> L15
        goto L13
    L12:
        a(r4, r0, r1);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r4.f();
        throw th;
    L19:
        throw new SQLiteException("Can't upgrade read-only database from version " + r4.i() + " to " + this.d + ": " + this.f15855b);
    }

    public SQLiteDatabase a() {
        monitor-enter(this);
        SQLiteDatabase r0 = a(true);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    public void a(SQLiteDatabase r1) {
    }

    public abstract void a(SQLiteDatabase r1, int r2, int r3);

    public abstract void b(SQLiteDatabase r1);

    public void b(SQLiteDatabase r2, int r3, int r4) {
        throw new SQLiteException("Can't downgrade database from version " + r3 + " to " + r4);
    }

    public void c(SQLiteDatabase r1) {
    }
}
