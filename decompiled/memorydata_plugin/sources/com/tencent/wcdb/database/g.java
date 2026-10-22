package com.tencent.wcdb.database;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class g implements e {
    private static SQLiteDatabase.a f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SQLiteDatabase f15852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f15853b;
    private final String c;
    private final com.tencent.wcdb.support.a d;
    private i e;

    static {
        f = d.h;
    }

    public g(SQLiteDatabase r1, String r2, String r3, com.tencent.wcdb.support.a r4) {
        this.f15852a = r1;
        this.f15853b = r3;
        this.c = r2;
        this.d = r4;
    }

    @Override // com.tencent.wcdb.database.e
    public void a() {
    }

    @Override // com.tencent.wcdb.database.e
    public void a(com.tencent.wcdb.f r2) {
        com.tencent.wcdb.f r1 = (com.tencent.wcdb.f) ZeusTransformUtils.wrapperContextForParams(r2, com.tencent.wcdb.f.class, "com.obric.memorydata.plugin");
    }

    @Override // com.tencent.wcdb.database.e
    public void b() {
    }

    @Override // com.tencent.wcdb.database.e
    public com.tencent.wcdb.f query(SQLiteDatabase.a r5, Object[] r6) {
        SQLiteDatabase.a r7 = (SQLiteDatabase.a) ZeusTransformUtils.wrapperContextForParams(r5, SQLiteDatabase.a.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
        r7 = f;
    L5:
        i r0 = null;
        r0 = r7.a(this.f15852a, this.c, r6, this.d);     // Catch: RuntimeException -> L9
        com.tencent.wcdb.f r8 = r7.a(this.f15852a, this, this.f15853b, r0);     // Catch: RuntimeException -> L9
        this.e = r0;
        return r8;
    L9:
        e = move-exception;
        if (r0 == null) goto L12;
        r0.close();
    L12:
        throw e;
    }

    public String toString() {
        return "SQLiteDirectCursorDriver: " + this.c;
    }
}
