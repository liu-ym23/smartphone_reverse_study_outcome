package com.tencent.wcdb.database;

import android.database.sqlite.SQLiteTransactionListener;
import com.tencent.wcdb.CursorWindow;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f15861a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SQLiteConnectionPool f15862b;
    private SQLiteConnection c;
    private int d;
    private int e;
    private a f;
    private a g;

    /* JADX INFO: renamed from: com.tencent.wcdb.database.l$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a f15863a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f15864b;
        public SQLiteTransactionListener c;
        public boolean d;
        public boolean e;

        private a() {
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }
    }

    static {
    }

    public l(SQLiteConnectionPool r1) {
        if (r1 == null) goto L7;
        this.f15862b = r1;
        return;
    L7:
        throw new IllegalArgumentException("connectionPool must not be null");
    }

    private a a(int r4, SQLiteTransactionListener r5) {
        SQLiteTransactionListener r6 = (SQLiteTransactionListener) ZeusTransformUtils.wrapperContextForParams(r5, SQLiteTransactionListener.class, "com.obric.memorydata.plugin");
        a r0 = this.f;
        AnonymousClass1 r1 = null;
        if (r0 == null) goto L5;
        this.f = r0.f15863a;
        r0.f15863a = null;
        r0.d = false;
        r0.e = false;
    L6:
        r0.f15864b = r4;
        r0.c = r6;
        return r0;
    L5:
        r0 = new a(r1);
        goto L6
    }

    private void a(a r2) {
        r2.f15863a = this.f;
        r2.c = null;
        this.f = r2;
    }

    private void a(com.tencent.wcdb.support.a r6, boolean r7) {
        if (r6 == null) goto L4;
        r6.b();
    L4:
        a r0 = this.g;
        boolean r3 = false;
        if (r0.d == true) goto L8;
        if (r7 == true) goto L8;
    L10:
        boolean r8 = false;
    L11:
        SQLiteTransactionListener r1 = r0.c;
        if (r1 != null) goto L37;
    L19:
        r3 = r8;
        e = null;
    L20:
        this.g = r0.f15863a;
        a(r0);
        a r2 = this.g;
        if (r2 == null) goto L39;
        if (r3 == true) goto L30;
        r2.e = true;
    L30:
        if (e != null) goto L32;
        return;
    L32:
        throw e;
    L39:
        if (r3 == false) goto L27;
        SQLiteConnection r4 = this.c;     // Catch: Throwable -> L33
        String r5 = "COMMIT;";
    L26:
        r4.a(r5, null, r6);     // Catch: Throwable -> L33
        b();
        goto L30
    L27:
        r4 = this.c;     // Catch: Throwable -> L33
        r5 = "ROLLBACK;";
    L33:
        th = move-exception;
        b();
        throw th;
    L37:
        if (r8 == false) goto L15;
        r1.onCommit();     // Catch: RuntimeException -> L17
    L36:
        goto L19
    L15:
        r1.onRollback();     // Catch: RuntimeException -> L17
    L17:
        e = e;
    L8:
        if (r0.e == true) goto L10;
        r8 = true;
        goto L11
    }

    private void a(String r3, int r4, boolean r5, com.tencent.wcdb.support.a r6) {
        if (this.c != null) goto L5;
        SQLiteConnection r7 = this.f15862b.a(r3, r4, r6);
        this.c = r7;
        this.d = r4;
        r7.a(true, r5);
    L5:
        this.e++;
    }

    private void b() {
        int r0 = this.e - 1;
        this.e = r0;
        if (r0 == 0) goto L11;
        return;
    L11:
        this.c.a(false, false);     // Catch: Throwable -> L7
        this.f15862b.a(this.c);     // Catch: Throwable -> L7
        this.c = null;
        return;
    L7:
        th = move-exception;
        this.c = null;
        throw th;
    }

    private void b(int r4, SQLiteTransactionListener r5, int r6, com.tencent.wcdb.support.a r7) {
        SQLiteTransactionListener r8 = (SQLiteTransactionListener) ZeusTransformUtils.wrapperContextForParams(r5, SQLiteTransactionListener.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L6;
        r7.b();
    L6:
        if (this.g != null) goto L35;
        a(null, r6, true, r7);
    L35:
    L30:
        th = move-exception;
        if (this.g != null) goto L34;
        b();
    L34:
        throw th;
    L9:
        if (this.g != null) goto L18;
        if (r4 != 1) goto L12;
        SQLiteConnection r9 = this.c;     // Catch: Throwable -> L30
        String r0 = "BEGIN IMMEDIATE;";
    L14:
        r9.a(r0, null, r7);     // Catch: Throwable -> L30
        goto L18
    L12:
        if (r4 == 2) goto L15;
        r9 = this.c;     // Catch: Throwable -> L30
        r0 = "BEGIN;";
        goto L14
    L15:
        r9 = this.c;     // Catch: Throwable -> L30
        r0 = "BEGIN EXCLUSIVE;";
    L18:
        if (r8 != null) goto L36;
    L26:
        a r10 = a(r4, r8);     // Catch: Throwable -> L30
        r10.f15863a = this.g;     // Catch: Throwable -> L30
        this.g = r10;     // Catch: Throwable -> L30
        if (r10 != null) goto L38;
        b();
        return;
    L38:
        return;
    L36:
        r8.onBegin();     // Catch: RuntimeException -> L21 Throwable -> L30
    L21:
        e = move-exception;
        if (this.g != null) goto L25;
        this.c.a("ROLLBACK;", null, r7);     // Catch: Throwable -> L30
    L25:
        throw e;     // Catch: Throwable -> L30
    }

    private void c() {
        if (this.g == null) goto L6;
        return;
    L6:
        throw new IllegalStateException("Cannot perform this operation because there is no current transaction.");
    }

    private void d() {
        a r1 = this.g;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.d == true) goto L8;
        return;
    L8:
        throw new IllegalStateException("Cannot perform this operation because the transaction has already been marked successful.  The only thing you can do now is call endTransaction().");
    }

    private boolean d(String r2, Object[] r3, int r4, com.tencent.wcdb.support.a r5) {
        if (r5 == null) goto L4;
        r5.b();
    L4:
        int r6 = com.tencent.wcdb.h.a(r2);
        if (r6 != 4) goto L7;
        a(2, null, r4, r5);
        return true;
    L7:
        if (r6 != 5) goto L9;
        a();
        a(r5);
        return true;
    L9:
        if (r6 == 6) goto L12;
        return false;
    L12:
        a(r5);
        return true;
    }

    public int a(String r11, Object[] r12, CursorWindow r13, int r14, int r15, boolean r16, int r17, com.tencent.wcdb.support.a r18) {
        if (r11 == null) goto L19;
        if (r13 == null) goto L17;
        if (d(r11, r12, r17, r18) == false) goto L9;
        r13.clear();
        return 0;
    L9:
        a(r11, r17, false, r18);
        int r0 = this.c.a(r11, r12, r13, r14, r15, r16, r18);     // Catch: Throwable -> L13
        b();
        return r0;
    L13:
        th = move-exception;
        b();
        throw th;
    L17:
        throw new IllegalArgumentException("window must not be null.");
    L19:
        throw new IllegalArgumentException("sql must not be null.");
    }

    public long a(String r2, Object[] r3, int r4, com.tencent.wcdb.support.a r5) {
        if (r2 == null) goto L15;
        if (d(r2, r3, r4, r5) == false) goto L7;
        return 0;
    L7:
        a(r2, r4, false, r5);
        long r6 = this.c.b(r2, r3, r5);     // Catch: Throwable -> L11
        b();
        return r6;
    L11:
        th = move-exception;
        b();
        throw th;
    L15:
        throw new IllegalArgumentException("sql must not be null.");
    }

    SQLiteConnection a(int r3) {
        a(null, r3, true, null);
        return this.c;
    }

    public void a() {
        c();
        d();
        this.g.d = true;
    }

    public void a(int r3, SQLiteTransactionListener r4, int r5, com.tencent.wcdb.support.a r6) {
        SQLiteTransactionListener r7 = (SQLiteTransactionListener) ZeusTransformUtils.wrapperContextForParams(r4, SQLiteTransactionListener.class, "com.obric.memorydata.plugin");
        d();
        b(r3, r7, r5, r6);
    }

    void a(SQLiteConnection.c r2) {
        SQLiteConnection r0 = this.c;
        if (r0 == null) goto L6;
        r0.a(r2);
        b();
        return;
    }

    public void a(com.tencent.wcdb.support.a r2) {
        c();
        if (f15861a == false) goto L5;
    L9:
        a(r2, false);
        return;
    L5:
        if (this.c != null) goto L9;
        throw new AssertionError();
    }

    void a(Exception r2) {
        SQLiteConnection r0 = this.c;
        if (r0 == null) goto L5;
        r0.a(r2);
    L5:
        b();
    }

    public void a(String r2, int r3, com.tencent.wcdb.support.a r4, n r5) {
        if (r2 == null) goto L13;
        if (r4 == null) goto L5;
        r4.b();
    L5:
        a(r2, r3, false, r4);
        this.c.a(r2, r5);     // Catch: Throwable -> L9
        b();
        return;
    L9:
        th = move-exception;
        b();
        throw th;
    L13:
        throw new IllegalArgumentException("sql must not be null.");
    }

    public int b(String r3, Object[] r4, int r5, com.tencent.wcdb.support.a r6) {
        if (r3 == null) goto L14;
        if (d(r3, r4, r5, r6) == false) goto L6;
        return 0;
    L6:
        a(r3, r5, false, r6);
        int r7 = this.c.d(r3, r4, r6);     // Catch: Throwable -> L10
        b();
        return r7;
    L10:
        th = move-exception;
        b();
        throw th;
    L14:
        throw new IllegalArgumentException("sql must not be null.");
    }

    public long c(String r2, Object[] r3, int r4, com.tencent.wcdb.support.a r5) {
        if (r2 == null) goto L15;
        if (d(r2, r3, r4, r5) == false) goto L7;
        return 0;
    L7:
        a(r2, r4, false, r5);
        long r6 = this.c.e(r2, r3, r5);     // Catch: Throwable -> L11
        b();
        return r6;
    L11:
        th = move-exception;
        b();
        throw th;
    L15:
        throw new IllegalArgumentException("sql must not be null.");
    }
}
