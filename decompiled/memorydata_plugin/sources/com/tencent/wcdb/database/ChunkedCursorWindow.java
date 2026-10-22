package com.tencent.wcdb.database;

/* JADX INFO: loaded from: classes6.dex */
public class ChunkedCursorWindow extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f15825a;

    private void a() {
        long r0 = this.f15825a;
        if (r0 == 0) goto L6;
        nativeDispose(r0);
        this.f15825a = 0;
        return;
    }

    private static native void nativeClear(long r0);

    private static native long nativeCreate(int r0);

    private static native void nativeDispose(long r0);

    private static native void nativeEndRow(long r0, long r2);

    private static native byte[] nativeGetBlob(long r0, int r2);

    private static native double nativeGetDouble(long r0, int r2);

    private static native long nativeGetLong(long r0, int r2);

    private static native int nativeGetNumChunks(long r0);

    private static native long nativeGetRow(long r0, int r2);

    private static native String nativeGetString(long r0, int r2);

    private static native int nativeGetType(long r0, int r2);

    private static native long nativeRemoveChunk(long r0, int r2);

    private static native boolean nativeSetNumColumns(long r0, int r2);

    long a(int r5) {
        acquireReference();
        long r0 = nativeGetRow(this.f15825a, r5);
        if (r0 != 0) goto L5;
        releaseReference();
    L5:
        return r0;
    }

    void a(long r3) {
        if (r3 != 0) goto L5;
        return;
    L5:
        nativeEndRow(this.f15825a, r3);
        releaseReference();
    }

    public void finalize() {
        a();     // Catch: Throwable -> L5
        super.finalize();
        return;
    L5:
        th = move-exception;
        super.finalize();
        throw th;
    }

    public int getType(int r5, int r6) {
        long r0 = a(r5);
        if (r0 == 0) goto L11;
        int r7 = nativeGetType(r0, r6);     // Catch: Throwable -> L7
        a(r0);
        return r7;
    L7:
        th = move-exception;
        a(r0);
        throw th;
    L11:
        throw new IllegalStateException("Couldn't read row " + r5 + ", column " + r6 + " from ChunkedCursorWindow.");
    }

    @Override // com.tencent.wcdb.database.c
    public void onAllReferencesReleased() {
        a();
    }
}
