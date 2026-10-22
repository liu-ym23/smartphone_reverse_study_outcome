package com.tencent.wcdb.database;

import java.io.Closeable;

/* JADX INFO: loaded from: classes6.dex */
public abstract class c implements Closeable {
    private int mReferenceCount;

    public c() {
        this.mReferenceCount = 1;
    }

    public void acquireReference() {
        monitor-enter(this);
        int r0 = this.mReferenceCount;     // Catch: Throwable -> L10
        if (r0 <= 0) goto L9;
        this.mReferenceCount = r0 + 1;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L9:
        throw new IllegalStateException("attempt to re-open an already-closed object: " + this);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        releaseReference();
    }

    public abstract void onAllReferencesReleased();

    @Deprecated
    public void onAllReferencesReleasedFromContainer() {
        onAllReferencesReleased();
    }

    public void releaseReference() {
        monitor-enter(this);
        boolean r1 = true;
        int r0 = this.mReferenceCount - 1;     // Catch: Throwable -> L11
        this.mReferenceCount = r0;     // Catch: Throwable -> L11
        if (r0 == 0) goto L7;
        r1 = false;
    L7:
        monitor-exit(this);     // Catch: Throwable -> L11
        if (r1 == false) goto L16;
        onAllReferencesReleased();
        return;
    L16:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public void releaseReferenceFromContainer() {
        monitor-enter(this);
        boolean r1 = true;
        int r0 = this.mReferenceCount - 1;     // Catch: Throwable -> L11
        this.mReferenceCount = r0;     // Catch: Throwable -> L11
        if (r0 == 0) goto L7;
        r1 = false;
    L7:
        monitor-exit(this);     // Catch: Throwable -> L11
        if (r1 == false) goto L16;
        onAllReferencesReleased();
        return;
    L16:
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
