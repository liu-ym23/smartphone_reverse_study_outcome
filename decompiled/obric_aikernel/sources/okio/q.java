package okio;

import java.io.RandomAccessFile;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends g {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final RandomAccessFile f12267i;

    public q(boolean r10, RandomAccessFile r11) {
        Intrinsics.checkNotNullParameter(r11, "randomAccessFile");
        super(r10);
        this.f12267i = r11;
    }

    @Override // okio.g
    protected synchronized void l() {
        monitor-enter(this);
        this.f12267i.close();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // okio.g
    protected synchronized int o(long r10, byte[] r11, int r12, int r13) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r11, "array");     // Catch: Throwable -> L14
        this.f12267i.seek(r10);     // Catch: Throwable -> L14
        int r14 = 0;
    L4:
        if (r14 >= r13) goto L12;
        int r15 = this.f12267i.read(r11, r12, r13 - r14);     // Catch: Throwable -> L14
        if (r15 == (-1)) goto L8;
        r14 = r14 + r15;
        goto L4
    L8:
        if (r14 != 0) goto L12;
        monitor-exit(this);
        return -1;
    L12:
        monitor-exit(this);
        return r14;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // okio.g
    protected synchronized long p() {
        monitor-enter(this);
        long r10 = this.f12267i.length();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }
}
