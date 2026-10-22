package com.tencent.wcdb.database;

/* JADX INFO: loaded from: classes6.dex */
public final class m extends i {
    m(SQLiteDatabase r2, String r3, Object[] r4) {
        super(r2, r3, r4, null);
    }

    public int a(com.tencent.wcdb.support.a r5) {
        acquireReference();
        int r6 = e().b(b(), c(), f(), r5);     // Catch: Throwable -> L6 SQLiteDatabaseCorruptException -> L8
        releaseReference();
        return r6;
    L8:
        e = move-exception;
        a(e);     // Catch: Throwable -> L6
        throw e;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public long b(com.tencent.wcdb.support.a r5) {
        acquireReference();
        long r0 = e().c(b(), c(), f(), r5);     // Catch: Throwable -> L6 SQLiteDatabaseCorruptException -> L8
        releaseReference();
        return r0;
    L8:
        e = move-exception;
        a(e);     // Catch: Throwable -> L6
        throw e;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public long c(com.tencent.wcdb.support.a r5) {
        acquireReference();
        long r0 = e().a(b(), c(), f(), r5);     // Catch: Throwable -> L6 SQLiteDatabaseCorruptException -> L8
        releaseReference();
        return r0;
    L8:
        e = move-exception;
        a(e);     // Catch: Throwable -> L6
        throw e;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public int i() {
        return a(null);
    }

    public long j() {
        return b(null);
    }

    public long k() {
        return c(null);
    }

    public String toString() {
        return "SQLiteProgram: " + b();
    }
}
