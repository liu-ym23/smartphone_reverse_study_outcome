package com.tencent.wcdb.database;

import com.tencent.wcdb.support.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class d extends com.tencent.wcdb.b {
    public static final SQLiteDatabase.a h = null;
    private final String[] i;
    private final j j;
    private final e k;
    private int l;
    private int m;
    private Map<String, Integer> n;

    static {
        h = new AnonymousClass1();
    }

    public d(e r2, String r3, j r4) {
        e r5 = (e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.memorydata.plugin");
        this.l = -1;
        if (r4 == null) goto L7;
        this.k = r5;
        this.n = null;
        this.j = r4;
        String[] r6 = r4.d();
        this.i = r6;
        this.c = com.tencent.wcdb.h.a(r6);
        return;
    L7:
        throw new IllegalArgumentException("query object cannot be null");
    }

    private void a(int r5) {
        a(d().l());
    L8:
        e = move-exception;
        c();
        throw e;
    L4:
        if (this.l != (-1)) goto L6;
        int r0 = com.tencent.wcdb.h.a(r5, 0);     // Catch: RuntimeException -> L8
        this.l = this.j.a(this.g, r0, r5, true);     // Catch: RuntimeException -> L8
        this.m = this.g.getNumRows();     // Catch: RuntimeException -> L8
        return;
    L6:
        int r1 = com.tencent.wcdb.h.a(r5, this.m);     // Catch: RuntimeException -> L8
        this.j.a(this.g, r1, r5, false);     // Catch: RuntimeException -> L8
    }

    @Override // com.tencent.wcdb.a
    public boolean a(int r2, int r3) {
        if (this.g != null) goto L5;
    L8:
        a(r3);
        int r4 = this.g.getStartPosition() + this.g.getNumRows();
        if (r3 < r4) goto L14;
        this.l = r4;
        return true;
    L14:
        return true;
    L5:
        if (r3 < this.g.getStartPosition()) goto L8;
        if (r3 >= (this.g.getStartPosition() + this.g.getNumRows())) goto L8;
        return true;
    }

    @Override // com.tencent.wcdb.a, com.tencent.wcdb.f, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        monitor-enter(this);
        this.j.close();     // Catch: Throwable -> L7
        this.k.b();     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public SQLiteDatabase d() {
        return this.j.a();
    }

    @Override // com.tencent.wcdb.a, android.database.Cursor
    public void deactivate() {
        super.deactivate();
        this.k.a();
    }

    @Override // com.tencent.wcdb.a
    public void finalize() {
    L7:
        th = move-exception;
        super.finalize();
        throw th;
    L3:
        if (this.g == null) goto L5;
        close();     // Catch: Throwable -> L7
    L5:
        super.finalize();
    }

    @Override // com.tencent.wcdb.a, com.tencent.wcdb.f, android.database.Cursor
    public int getColumnIndex(String r8) {
        if (this.n != null) goto L8;
        String[] r0 = this.i;
        int r2 = r0.length;
        HashMap r3 = new HashMap(r2, 1.0f);
        int r4 = 0;
    L5:
        if (r4 >= r2) goto L7;
        r3.put(r0[r4], Integer.valueOf(r4));
        r4 = r4 + 1;
        goto L5
    L7:
        this.n = r3;
    L8:
        int r1 = r8.lastIndexOf(46);
        if (r1 == (-1)) goto L11;
        Log.a("WCDB.SQLiteCursor", "requesting column name with table name -- " + r8, new Object[]{new Exception()});
        r8 = r8.substring(r1 + 1);
    L11:
        Integer r7 = (Integer) ZeusTransformUtils.preCheckCast(this.n.get(r8), Integer.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L14;
        return -1;
    L14:
        return r7.intValue();
    }

    @Override // com.tencent.wcdb.a, android.database.Cursor
    public String[] getColumnNames() {
        return this.i;
    }

    @Override // com.tencent.wcdb.a, com.tencent.wcdb.f, android.database.Cursor
    public int getCount() {
        if (this.l != (-1)) goto L6;
        a(0);
    L6:
        return this.l;
    }

    @Override // com.tencent.wcdb.a, android.database.Cursor
    public boolean moveToPosition(int r3) {
        if (super.moveToPosition(r3) == true) goto L5;
        return false;
    L5:
        int r0 = getCount();
        if (r3 < r0) goto L9;
        this.f15821b = r0;
        return false;
    L9:
        return true;
    }

    @Override // com.tencent.wcdb.a, android.database.Cursor
    public boolean requery() {
        if (isClosed() == false) goto L5;
        return false;
    L5:
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (this.j.a().k() == true) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L20
        return false;
    L11:
        if (this.g == null) goto L13;
        this.g.clear();     // Catch: Throwable -> L20
    L13:
        this.f15821b = -1;     // Catch: Throwable -> L20
        this.l = -1;     // Catch: Throwable -> L20
        this.k.a(this);     // Catch: Throwable -> L20
        monitor-exit(this);     // Catch: Throwable -> L20
        return super.requery();
    L17:
        e = move-exception;
        Log.b("WCDB.SQLiteCursor", "requery() failed " + e.getMessage(), new Object[]{e});
        return false;
    }
}
