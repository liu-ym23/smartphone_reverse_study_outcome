package com.tencent.wcdb.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.wcdb.support.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import net.zetetic.database.sqlcipher.SQLiteDatabaseConfiguration;

/* JADX INFO: loaded from: classes6.dex */
public final class SQLiteDatabase extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f15843a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final WeakHashMap<SQLiteDatabase, Object> f15844b = null;
    private static final String[] j = null;
    private final ThreadLocal<l> c;
    private final a d;
    private final com.tencent.wcdb.g e;
    private final Object f;
    private final f g;
    private SQLiteConnectionPool h;
    private boolean i;

    public interface CustomFunction {
        void a(String[] r1);
    }

    public interface a {
        i a(SQLiteDatabase r1, String r2, Object[] r3, com.tencent.wcdb.support.a r4);

        com.tencent.wcdb.f a(SQLiteDatabase r1, e r2, String r3, i r4);
    }

    static {
        SQLiteGlobal.a();
        f15844b = new WeakHashMap();
        j = new String[]{"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    }

    private SQLiteDatabase(String r3, int r4, a r5, com.tencent.wcdb.g r6) {
        a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.memorydata.plugin");
        com.tencent.wcdb.g r8 = (com.tencent.wcdb.g) ZeusTransformUtils.wrapperContextForParams(r6, com.tencent.wcdb.g.class, "com.obric.memorydata.plugin");
        this.c = new AnonymousClass1(this);
        this.f = new Object();
        this.d = r7;
        if (r8 != null) goto L6;
        r8 = new com.tencent.wcdb.i(true);
    L6:
        this.e = r8;
        this.g = new f(r3, r4);
    }

    private int a(String r5, Object[] r6, com.tencent.wcdb.support.a r7) {
        acquireReference();
    L25:
        th = move-exception;
        releaseReference();
        throw th;
    L4:
        if (com.tencent.wcdb.h.a(r5) != 3) goto L17;
        boolean r0 = false;
        Object r1 = this.f;     // Catch: Throwable -> L25
        monitor-enter(r1);     // Catch: Throwable -> L25
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L8:
        if (this.i == true) goto L10;
        this.i = true;     // Catch: Throwable -> L14
        r0 = true;
    L10:
        monitor-exit(r1);     // Catch: Throwable -> L14
        if (r0 == false) goto L17;
        m();     // Catch: Throwable -> L25
        goto L17
    L17:
        m r2 = new m(this, r5, r6);     // Catch: Throwable -> L25
        int r8 = r2.a(r7);     // Catch: Throwable -> L22
        r2.close();     // Catch: Throwable -> L25
        releaseReference();
        return r8;
    L22:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    }

    public static SQLiteDatabase a(a r2) {
        return a(SQLiteDatabaseConfiguration.MEMORY_DB_PATH, (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin"), net.zetetic.database.sqlcipher.SQLiteDatabase.CREATE_IF_NECESSARY);
    }

    public static SQLiteDatabase a(String r2, a r3, int r4) {
        return a(r2, (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin"), r4, null);
    }

    public static SQLiteDatabase a(String r9, a r10, int r11, com.tencent.wcdb.g r12) {
        return a(r9, null, null, (a) ZeusTransformUtils.wrapperContextForParams(r10, a.class, "com.obric.memorydata.plugin"), r11, (com.tencent.wcdb.g) ZeusTransformUtils.wrapperContextForParams(r12, com.tencent.wcdb.g.class, "com.obric.memorydata.plugin"), 0);
    }

    public static SQLiteDatabase a(String r9, byte[] r10, SQLiteCipherSpec r11, a r12, int r13, com.tencent.wcdb.g r14) {
        return a(r9, r10, r11, (a) ZeusTransformUtils.wrapperContextForParams(r12, a.class, "com.obric.memorydata.plugin"), r13, (com.tencent.wcdb.g) ZeusTransformUtils.wrapperContextForParams(r14, com.tencent.wcdb.g.class, "com.obric.memorydata.plugin"), 0);
    }

    public static SQLiteDatabase a(String r2, byte[] r3, SQLiteCipherSpec r4, a r5, int r6, com.tencent.wcdb.g r7, int r8) {
        SQLiteDatabase r0 = new SQLiteDatabase(r2, r6, (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.memorydata.plugin"), (com.tencent.wcdb.g) ZeusTransformUtils.wrapperContextForParams(r7, com.tencent.wcdb.g.class, "com.obric.memorydata.plugin"));
        r0.a(r3, r4, r8);
        return r0;
    }

    public static String a(String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L16;
        int r0 = r3.indexOf(32);
        int r1 = r3.indexOf(44);
        if (r0 <= 0) goto L10;
        if (r0 < r1) goto L9;
        if (r1 >= 0) goto L10;
    L9:
        return r3.substring(0, r0);
    L10:
        if (r1 <= 0) goto L17;
        if (r1 < r0) goto L14;
        if (r0 < 0) goto L14;
        return r3;
    L14:
        return r3.substring(0, r1);
    L17:
        return r3;
    L16:
        throw new IllegalStateException("Invalid tables");
    }

    private Set<String> a(ContentValues r3) {
        if (Build.VERSION.SDK_INT >= 11) goto L10;
        Field r0 = ZeusTransformUtils.forName("android.content.ContentValues", "com.obric.memorydata.plugin").getDeclaredField("mValues");     // Catch: Exception -> L6
        r0.setAccessible(true);     // Catch: Exception -> L6
        return ((HashMap) ZeusTransformUtils.preCheckCast(r0.get(r3), HashMap.class, "com.obric.memorydata.plugin")).keySet();
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    L10:
        return r3.keySet();
    }

    private void a(SQLiteTransactionListener r4, boolean r5) {
        SQLiteTransactionListener r6 = (SQLiteTransactionListener) ZeusTransformUtils.wrapperContextForParams(r4, SQLiteTransactionListener.class, "com.obric.memorydata.plugin");
        acquireReference();
        l r0 = c();     // Catch: Throwable -> L10
        if (r5 == false) goto L6;
        int r7 = 2;
    L7:
        r0.a(r7, r6, a(false), null);     // Catch: Throwable -> L10
        releaseReference();
        return;
    L6:
        r7 = 1;
    L10:
        th = move-exception;
        releaseReference();
        throw th;
    }

    private void a(byte[] r2, SQLiteCipherSpec r3, int r4) {
        b(r2, r3, r4);     // Catch: SQLiteException -> L4 SQLiteDatabaseCorruptException -> L6
    L10:
        return;
    L4:
        e = move-exception;
        Log.a("WCDB.SQLiteDatabase", "Failed to open database '" + a() + "'.", new Object[]{e});
        close();
        throw e;
    L6:
        b();     // Catch: SQLiteException -> L4
        b(r2, r3, r4);     // Catch: SQLiteException -> L4
        goto L10
    }

    private void b(boolean r4) {
        Object r0 = this.f;
        monitor-enter(r0);
        SQLiteConnectionPool r1 = this.h;     // Catch: Throwable -> L17
        this.h = null;     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        if (r4 == true) goto L16;
        WeakHashMap<SQLiteDatabase, Object> r5 = f15844b;
        monitor-enter(r5);
        r5.remove(this);     // Catch: Throwable -> L13
        monitor-exit(r5);     // Catch: Throwable -> L13
        if (r1 == null) goto L24;
        r1.close();
        return;
    L24:
        return;
    L13:
        th = move-exception;
        throw th;
    L16:
        return;
    L17:
        th = move-exception;
        throw th;
    }

    private void b(byte[] r3, SQLiteCipherSpec r4, int r5) {
        Object r0 = this.f;
        monitor-enter(r0);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (f15843a == false) goto L7;
    L11:
        this.h = SQLiteConnectionPool.a(this, this.g, r3, r4, r5);     // Catch: Throwable -> L22
        monitor-exit(r0);     // Catch: Throwable -> L22
        WeakHashMap<SQLiteDatabase, Object> r6 = f15844b;
        monitor-enter(r6);
        r6.put(this, null);     // Catch: Throwable -> L19
        monitor-exit(r6);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    L7:
        if (this.h == null) goto L11;
        throw new AssertionError();     // Catch: Throwable -> L22
    }

    private static boolean p() {
        Looper r0 = Looper.myLooper();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0 != Looper.getMainLooper()) goto L7;
        return true;
    }

    private boolean q() {
        if ((this.g.d & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void r() {
        if (this.h == null) goto L6;
        return;
    L6:
        throw new IllegalStateException("The database '" + this.g.f15851b + "' is not open.");
    }

    public int a(String r8, ContentValues r9, String r10, String[] r11, int r12) {
        if (r9 == null) goto L37;
        if (r9.size() == 0) goto L37;
        acquireReference();
        StringBuilder r0 = new StringBuilder(120);     // Catch: Throwable -> L33
        r0.append("UPDATE ");     // Catch: Throwable -> L33
        r0.append(j[r12]);     // Catch: Throwable -> L33
        r0.append(r8);     // Catch: Throwable -> L33
        r0.append(" SET ");     // Catch: Throwable -> L33
        int r13 = r9.size();     // Catch: Throwable -> L33
        if (r11 != null) goto L9;
        int r14 = r13;
    L10:
        Object[] r1 = new Object[r14];     // Catch: Throwable -> L33
        int r2 = 0;
        Iterator<String> r3 = a(r9).iterator();     // Catch: Throwable -> L33
    L12:
        if (r3.hasNext() == false) goto L18;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        if (r2 <= 0) goto L16;
        String r5 = ",";
    L17:
        r0.append(r5);     // Catch: Throwable -> L33
        r0.append(r4);     // Catch: Throwable -> L33
        r1[r2] = r9.get(r4);     // Catch: Throwable -> L33
        r0.append("=?");     // Catch: Throwable -> L33
        r2 = r2 + 1;     // Catch: Throwable -> L33
        goto L12
    L16:
        r5 = "";
        goto L17
    L18:
        if (r11 == null) goto L23;
        int r15 = r13;
    L20:
        if (r15 >= r14) goto L23;
        r1[r15] = r11[r15 - r13];     // Catch: Throwable -> L33
        r15 = r15 + 1;     // Catch: Throwable -> L33
    L23:
        if (TextUtils.isEmpty(r10) == true) goto L25;
        r0.append(" WHERE ");     // Catch: Throwable -> L33
        r0.append(r10);     // Catch: Throwable -> L33
    L25:
        m r16 = new m(this, r0.toString(), r1);     // Catch: Throwable -> L33
        int r17 = r16.i();     // Catch: Throwable -> L30
        r16.close();     // Catch: Throwable -> L33
        releaseReference();
        return r17;
    L30:
        th = move-exception;
        r16.close();     // Catch: Throwable -> L33
        throw th;     // Catch: Throwable -> L33
    L9:
        r14 = r11.length + r13;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        releaseReference();
        throw th;
    L37:
        throw new IllegalArgumentException("Empty values");
    }

    int a(boolean r1) {
        if (r1 == false) goto L4;
        int r0 = 1;
    L6:
        if (p() == true) goto L8;
        return r0;
    L8:
        return r0 | 4;
    L4:
        r0 = 2;
        goto L6
    }

    public long a(String r8, String r9, ContentValues r10, int r11) {
        acquireReference();
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L34
        r0.append("INSERT");     // Catch: Throwable -> L34
        r0.append(j[r11]);     // Catch: Throwable -> L34
        r0.append(" INTO ");     // Catch: Throwable -> L34
        r0.append(r8);     // Catch: Throwable -> L34
        r0.append('(');     // Catch: Throwable -> L34
        Object[] r12 = null;
        int r13 = 0;
        if (r10 != null) goto L6;
    L8:
        int r1 = 0;
    L10:
        if (r1 <= 0) goto L25;
        r12 = new Object[r1];     // Catch: Throwable -> L34
        Iterator<String> r14 = a(r10).iterator();     // Catch: Throwable -> L34
        int r3 = 0;
    L13:
        if (r14.hasNext() == false) goto L19;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
        if (r3 <= 0) goto L17;
        String r5 = ",";
    L18:
        r0.append(r5);     // Catch: Throwable -> L34
        r0.append(r4);     // Catch: Throwable -> L34
        r12[r3] = r10.get(r4);     // Catch: Throwable -> L34
        r3 = r3 + 1;     // Catch: Throwable -> L34
        goto L13
    L17:
        r5 = "";
        goto L18
    L19:
        r0.append(')');     // Catch: Throwable -> L34
        r0.append(" VALUES (");     // Catch: Throwable -> L34
    L20:
        if (r13 >= r1) goto L26;
        if (r13 <= 0) goto L23;
        String r15 = ",?";
    L24:
        r0.append(r15);     // Catch: Throwable -> L34
        r13 = r13 + 1;     // Catch: Throwable -> L34
        goto L20
    L23:
        r15 = "?";
    L26:
        r0.append(')');     // Catch: Throwable -> L34
        m r16 = new m(this, r0.toString(), r12);     // Catch: Throwable -> L34
        long r17 = r16.j();     // Catch: Throwable -> L31
        r16.close();     // Catch: Throwable -> L34
        releaseReference();
        return r17;
    L31:
        th = move-exception;
        r16.close();     // Catch: Throwable -> L34
        throw th;     // Catch: Throwable -> L34
    L25:
        r0.append(r9 + ") VALUES (NULL");     // Catch: Throwable -> L34
        goto L26
    L6:
        if (r10.size() <= 0) goto L8;
        r1 = r10.size();     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public long a(String r1, boolean r2, boolean r3) {
        if (r1 != null) goto L4;
        r1 = "unnamedNative";
    L4:
        if (r2 == false) goto L6;
        int r4 = 1;
    L7:
        if (r3 == false) goto L9;
        r4 = r4 | 4;
    L9:
        long r0 = c().a(r4).a(r1);
        if (r0 == 0) goto L13;
        return r0;
    L13:
        throw new IllegalStateException("SQLiteConnection native handle not initialized.");
    L6:
        r4 = 2;
        goto L7
    }

    public com.tencent.wcdb.f a(a r3, String r4, Object[] r5, String r6, com.tencent.wcdb.support.a r7) {
        a r8 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        acquireReference();
        g r0 = new g(this, r4, r6, r7);     // Catch: Throwable -> L10
        if (r8 != null) goto L7;
        r8 = this.d;     // Catch: Throwable -> L10
    L7:
        com.tencent.wcdb.f r9 = r0.query(r8, r5);     // Catch: Throwable -> L10
        releaseReference();
        return r9;
    L10:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public com.tencent.wcdb.f a(a r12, boolean r13, String r14, String[] r15, String r16, Object[] r17, String r18, String r19, String r20, String r21, com.tencent.wcdb.support.a r22) {
        a r2 = (a) ZeusTransformUtils.wrapperContextForParams(r12, a.class, "com.obric.memorydata.plugin");
        acquireReference();
        com.tencent.wcdb.f r0 = a(r2, k.a(r13, r14, r15, r16, r18, r19, r20, r21), r17, a(r14), r22);     // Catch: Throwable -> L6
        releaseReference();
        return r0;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public com.tencent.wcdb.f a(String r7, Object[] r8) {
        return a(null, r7, r8, null, null);
    }

    String a() {
        Object r0 = this.f;
        monitor-enter(r0);
        String r1 = this.g.f15851b;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void a(int r3) {
        c("PRAGMA user_version = " + r3);
    }

    public void a(long r1, Exception r3) {
        c().a(r3);
    }

    public void a(o r3) {
        o r4 = (o) ZeusTransformUtils.wrapperContextForParams(r3, o.class, "com.obric.memorydata.plugin");
        Object r0 = this.f;
        monitor-enter(r0);
        r();     // Catch: Throwable -> L7
        this.h.a(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void a(com.tencent.wcdb.extension.a r4) {
        com.tencent.wcdb.extension.a r5 = (com.tencent.wcdb.extension.a) ZeusTransformUtils.wrapperContextForParams(r4, com.tencent.wcdb.extension.a.class, "com.obric.memorydata.plugin");
        Object r0 = this.f;
        monitor-enter(r0);
        r();     // Catch: Throwable -> L13
        if (this.g.l.add(r5) == true) goto L16;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L16:
        this.h.a(this.g);     // Catch: RuntimeException -> L8 Throwable -> L13
    L8:
        e = move-exception;
        this.g.l.remove(r5);     // Catch: Throwable -> L13
        throw e;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public m b(String r3) {
        acquireReference();
        m r0 = new m(this, r3, null);     // Catch: Throwable -> L6
        releaseReference();
        return r0;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    void b() {
        this.e.a(this);
    }

    l c() {
        return (l) ZeusTransformUtils.preCheckCast(this.c.get(), l.class, "com.obric.memorydata.plugin");
    }

    public void c(String r2) {
        a(r2, null, null);
    }

    l d() {
        Object r0 = this.f;
        monitor-enter(r0);
        r();     // Catch: Throwable -> L8
        SQLiteConnectionPool r1 = this.h;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return new l(r1);
    L8:
        th = move-exception;
        throw th;
    }

    public int delete(String r4, String r5, String[] r6) {
        acquireReference();
        StringBuilder r7 = new StringBuilder().append("DELETE FROM ").append(r4);     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r5) == true) goto L6;
        String r8 = " WHERE " + r5;     // Catch: Throwable -> L15
    L7:
        m r0 = new m(this, r7.append(r8).toString(), r6);     // Catch: Throwable -> L15
        int r9 = r0.i();     // Catch: Throwable -> L12
        r0.close();     // Catch: Throwable -> L15
        releaseReference();
        return r9;
    L12:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L6:
        r8 = "";
    L15:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public void e() {
        a(null, true);
    }

    public void f() {
        acquireReference();
        c().a(null);     // Catch: Throwable -> L6
        releaseReference();
        return;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public void finalize() {
        b(true);     // Catch: Throwable -> L6
        super.finalize();
        return;
    L6:
        th = move-exception;
        super.finalize();
        throw th;
    }

    public void g() {
        acquireReference();
        c().a();     // Catch: Throwable -> L6
        releaseReference();
        return;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public void h() {
        Object r0 = this.f;
        monitor-enter(r0);
        r();     // Catch: Throwable -> L15
        if (q() == true) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L8:
        int r1 = this.g.d;     // Catch: Throwable -> L15
        f r2 = this.g;     // Catch: Throwable -> L15
        r2.d = (r2.d & (-2)) | 0;     // Catch: Throwable -> L15
        this.h.a(this.g);     // Catch: RuntimeException -> L12 Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L12:
        e = move-exception;
        this.g.d = r1;     // Catch: Throwable -> L15
        throw e;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public int i() {
        return Long.valueOf(com.tencent.wcdb.h.a(this, "PRAGMA user_version;", null)).intValue();
    }

    public long insert(String r2, String r3, ContentValues r4) {
        return a(r2, r3, r4, 0);
    L8:
        e = move-exception;
        throw e;
    L5:
        e = move-exception;
        Log.a("WCDB.SQLiteDatabase", "Error inserting %s: %s", new Object[]{r4, e});
        return -1;
    }

    public boolean j() {
        Object r0 = this.f;
        monitor-enter(r0);
        boolean r1 = q();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean k() {
        Object r0 = this.f;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.h == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    public final String l() {
        Object r0 = this.f;
        monitor-enter(r0);
        String r1 = this.g.f15850a;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void m() {
        Object r0 = this.f;
        monitor-enter(r0);
        r();     // Catch: Throwable -> L15
        if ((this.g.d & net.zetetic.database.sqlcipher.SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L8:
        this.g.d &= -536870913;     // Catch: Throwable -> L15
        this.h.a(this.g);     // Catch: RuntimeException -> L12 Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L12:
        e = move-exception;
        f r5 = this.g;     // Catch: Throwable -> L15
        r5.d = 536870912 | r5.d;     // Catch: Throwable -> L15
        throw e;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public o n() {
        Object r0 = this.f;
        monitor-enter(r0);
        r();     // Catch: Throwable -> L7
        o r1 = this.h.b();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public List<Pair<String, String>> o() {
        ArrayList r0 = new ArrayList();
        Object r1 = this.f;
        monitor-enter(r1);
        com.tencent.wcdb.f r3 = null;
        if (this.h != null) goto L9;
        monitor-exit(r1);     // Catch: Throwable -> L31
        return null;
    L9:
        if (this.i == true) goto L13;
        r0.add(new Pair("main", this.g.f15850a));     // Catch: Throwable -> L31
        monitor-exit(r1);     // Catch: Throwable -> L31
        return r0;
    L13:
        acquireReference();     // Catch: Throwable -> L31
        monitor-exit(r1);     // Catch: Throwable -> L31
        r3 = a("pragma database_list;", null);     // Catch: Throwable -> L24
    L17:
        if (r3.moveToNext() == false) goto L20;
        r0.add(new Pair(r3.getString(1), r3.getString(2)));     // Catch: Throwable -> L24
    L20:
        if (r3 == null) goto L22;
        r3.close();     // Catch: Throwable -> L28
    L22:
        releaseReference();
        return r0;
    L28:
        th = move-exception;
        releaseReference();
        throw th;
    L24:
        th = move-exception;
        if (r3 == null) goto L27;
        r3.close();     // Catch: Throwable -> L28
    L27:
        throw th;     // Catch: Throwable -> L28
    L31:
        th = move-exception;
        throw th;
    }

    @Override // com.tencent.wcdb.database.c
    public void onAllReferencesReleased() {
        b(false);
    }

    public com.tencent.wcdb.f query(String r11, String[] r12, String r13, Object[] r14, String r15, String r16, String r17) {
        return query(false, r11, r12, r13, r14, r15, r16, r17, null);
    }

    public com.tencent.wcdb.f query(String r11, String[] r12, String r13, Object[] r14, String r15, String r16, String r17, String r18) {
        return query(false, r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public com.tencent.wcdb.f query(boolean r13, String r14, String[] r15, String r16, Object[] r17, String r18, String r19, String r20, String r21) {
        return a(null, r13, r14, r15, r16, r17, r18, r19, r20, r21, null);
    }

    public com.tencent.wcdb.f query(boolean r13, String r14, String[] r15, String r16, Object[] r17, String r18, String r19, String r20, String r21, com.tencent.wcdb.support.a r22) {
        return a(null, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public String toString() {
        return "SQLiteDatabase: " + l();
    }

    public int update(String r7, ContentValues r8, String r9, String[] r10) {
        return a(r7, r8, r9, r10, 0);
    }
}
