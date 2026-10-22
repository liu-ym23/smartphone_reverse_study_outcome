package com.tencent.wcdb.database;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public abstract class i extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f15856b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected SQLiteConnection.c f15857a;
    private final SQLiteDatabase c;
    private final String d;
    private final boolean e;
    private final String[] f;
    private final int g;
    private final Object[] h;
    private l i;

    static {
        f15856b = new String[0];
    }

    public i(SQLiteDatabase r7, String r8, Object[] r9, com.tencent.wcdb.support.a r10) {
        this.c = r7;
        String r11 = r8.trim();
        this.d = r11;
        int r0 = com.tencent.wcdb.h.a(r11);
        if (r0 != 4) goto L5;
    L19:
        this.e = false;
        this.f = f15856b;
        this.g = 0;
    L20:
        if (r9 != null) goto L22;
    L26:
        int r12 = this.g;
        if (r12 == 0) goto L31;
        Object[] r13 = new Object[r12];
        this.h = r13;
        if (r9 == null) goto L32;
        System.arraycopy(r9, 0, r13, 0, r9.length);
    L32:
        this.f15857a = null;
        this.i = null;
        return;
    L31:
        this.h = null;
        goto L32
    L22:
        if (r9.length <= this.g) goto L26;
        throw new IllegalArgumentException("Too many bind arguments.  " + r9.length + " arguments were provided but the statement needs " + this.g + " arguments.");
    L5:
        if (r0 == 5) goto L19;
        if (r0 == 6) goto L19;
        boolean r1 = true;
        if (r0 != 1) goto L11;
        boolean r3 = true;
    L12:
        n r4 = new n();
        r7.c().a(r11, r7.a(r3), r10, r4);
        if (r0 != 8) goto L15;
    L17:
        r1 = false;
    L18:
        this.e = r1;
        this.f = r4.f15866b;
        this.g = r4.f15865a;
        goto L20
    L15:
        if (r4.c == false) goto L17;
    L11:
        r3 = false;
        goto L12
    }

    private void a(int r3, Object r4) {
        if (r3 < 1) goto L9;
        if (r3 > this.g) goto L9;
        this.h[r3 - 1] = r4;
        return;
    L9:
        throw new IllegalArgumentException("Cannot bind argument at index " + r3 + " because the index is out of range.  The statement has " + this.g + " parameters.");
    }

    public final SQLiteDatabase a() {
        return this.c;
    }

    public void a(int r1, long r2) {
        a(r1, Long.valueOf(r2));
    }

    public void a(int r2, String r3) {
        if (r3 == null) goto L6;
        a(r2, r3);
        return;
    L6:
        throw new IllegalArgumentException("the bind value at index " + r2 + " is null");
    }

    public final void a(SQLiteException r3) {
        boolean r1 = true;
        if (ZeusTransformUtils.instanceOf(r3, SQLiteDatabaseCorruptException.class) == false) goto L6;
    L11:
        if (r1 == false) goto L14;
        SQLiteDebug.a(this.c);
        this.c.b();
        return;
    L14:
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, SQLiteFullException.class) == true) goto L8;
    L10:
        r1 = false;
        goto L11
    L8:
        if (this.e == false) goto L10;
        goto L10
    }

    public void a(String[] r3) {
        if (r3 == null) goto L6;
        int r0 = r3.length;
    L4:
        if (r0 == 0) goto L8;
        a(r0, r3[r0 - 1]);
        r0 = r0 - 1;
        goto L4
    L8:
        return;
    }

    public final String b() {
        return this.d;
    }

    public final Object[] c() {
        return this.h;
    }

    public final String[] d() {
        return this.f;
    }

    public final l e() {
        return this.c.c();
    }

    public final int f() {
        return this.c.a(this.e);
    }

    public void finalize() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.i != null) goto L11;
        if (this.f15857a != null) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L12
        super.finalize();
        return;
    L11:
        throw new SQLiteMisuseException("Acquired prepared statement is not released.");     // Catch: Throwable -> L12
    }

    public void g() {
        Object[] r1 = this.h;
        if (r1 == null) goto L6;
        Arrays.fill(r1, null);
        return;
    }

    public synchronized void h() {
        monitor-enter(this);
        l r0 = this.i;     // Catch: Throwable -> L21
        if (r0 == null) goto L6;
    L9:
        if (r0 == null) goto L20;
        if (this.f15857a == null) goto L20;
        if (r0 != this.c.c()) goto L18;
        this.i.a(this.f15857a);     // Catch: Throwable -> L21
        this.f15857a = null;     // Catch: Throwable -> L21
        this.i = null;     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L18:
        throw new IllegalStateException("SQLiteProgram has bound to another thread.");     // Catch: Throwable -> L21
    L20:
        throw new IllegalStateException("Internal state error.");     // Catch: Throwable -> L21
    L6:
        if (this.f15857a != null) goto L9;
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        throw th;
    }

    @Override // com.tencent.wcdb.database.c
    public void onAllReferencesReleased() {
        h();
        g();
    }
}
