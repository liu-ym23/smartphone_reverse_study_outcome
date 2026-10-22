package com.tencent.wcdb.database;

import com.tencent.wcdb.CursorWindow;
import com.tencent.wcdb.support.Log;

/* JADX INFO: loaded from: classes6.dex */
public final class j extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.tencent.wcdb.support.a f15858b;

    j(SQLiteDatabase r1, String r2, Object[] r3, com.tencent.wcdb.support.a r4) {
        super(r1, r2, r3, r4);
        this.f15858b = r4;
    }

    int a(CursorWindow r10, int r11, int r12, boolean r13) {
        acquireReference();
        r10.acquireReference();     // Catch: Throwable -> L15
        int r14 = e().a(b(), c(), r10, r11, r12, r13, f(), this.f15858b);     // Catch: Throwable -> L8 SQLiteException -> L10
        r10.releaseReference();     // Catch: Throwable -> L15
        releaseReference();
        return r14;
    L8:
        th = move-exception;
        r10.releaseReference();     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L10:
        e = move-exception;
        Log.a("WCDB.SQLiteQuery", "exception: " + e.getMessage() + "; query: " + b());     // Catch: Throwable -> L8
        a(e);     // Catch: Throwable -> L8
        throw e;     // Catch: Throwable -> L8
    L15:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public String toString() {
        return "SQLiteQuery: " + b();
    }
}
