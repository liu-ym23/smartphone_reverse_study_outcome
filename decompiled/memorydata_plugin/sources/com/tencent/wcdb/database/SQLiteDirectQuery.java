package com.tencent.wcdb.database;

/* JADX INFO: loaded from: classes6.dex */
public class SQLiteDirectQuery extends i {
    private static final int[] c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.tencent.wcdb.support.a f15848b;

    static {
        c = new int[]{3, 1, 2, 3, 4, 0};
    }

    private static native byte[] nativeGetBlob(long r0, int r2);

    private static native double nativeGetDouble(long r0, int r2);

    private static native long nativeGetLong(long r0, int r2);

    private static native String nativeGetString(long r0, int r2);

    private static native int nativeGetType(long r0, int r2);

    private static native int nativeStep(long r0, int r2);

    public int getType(int r4) {
        return c[nativeGetType(this.f15857a.a(), r4)];
    }

    @Override // com.tencent.wcdb.database.i, com.tencent.wcdb.database.c
    public void onAllReferencesReleased() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f15857a == null) goto L6;
        this.f15857a.a(this.f15848b);     // Catch: Throwable -> L9
        this.f15857a.a(null);     // Catch: Throwable -> L9
    L6:
        monitor-exit(this);     // Catch: Throwable -> L9
        super.onAllReferencesReleased();
    }
}
