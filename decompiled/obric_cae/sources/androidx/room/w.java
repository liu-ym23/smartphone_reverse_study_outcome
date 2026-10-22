package androidx.room;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class w implements a1.c, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f2712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2713b;

    @Override // a1.c
    public final a1.b Z() {
        if (this.f2713b == true) goto L6;
        k(true);
        this.f2713b = true;
    L6:
        throw null;
    }

    @Override // androidx.room.d
    public final a1.c a() {
        return null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        monitor-enter(this);
        throw null;     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        throw th;
    }

    @Override // a1.c
    public final String getDatabaseName() {
        throw null;
    }

    public final void i(File r8) {
        throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
    }

    public final void k(boolean r8) {
        if (getDatabaseName() == null) goto L7;
        throw null;
    L7:
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // a1.c
    public final void setWriteAheadLoggingEnabled(boolean r8) {
        throw null;
    }
}
