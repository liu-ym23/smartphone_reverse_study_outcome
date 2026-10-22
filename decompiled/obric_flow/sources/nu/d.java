package nu;

import java.io.IOException;
import java.io.InputStream;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f20319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f20320c;

    public d(InputStream r5, f0 r10) {
        this.f20318a = 1;
        Intrinsics.checkNotNullParameter(r5, "input");
        Intrinsics.checkNotNullParameter(r10, "timeout");
        this.f20319b = r5;
        this.f20320c = r10;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Object r5 = this.f20319b;
        switch(this.f20318a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        ((InputStream) r5).close();
        return;
    L6:
        e r10 = (e) r5;
        r10.enter();
        ((c0) this.f20320c).close();     // Catch: Throwable -> L13 IOException -> L15
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L13 IOException -> L15
    L9:
        if (r10.exit() == true) goto L12;
        return;
    L12:
        throw r10.access$newTimeoutException(null);
    L15:
        e = move-exception;
        if (r10.exit() == true) goto L20;
        throw e;     // Catch: Throwable -> L13
    L20:
        throw r10.access$newTimeoutException(e);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        r10.exit();
        throw th;
    }

    @Override // nu.c0
    public final long read(j r5, long r10) {
        switch(this.f20318a) {
            case 0: goto L29;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "sink");
        if (r10 != 0) goto L8;
        return 0;
    L8:
        if (r10 < 0) goto L10;
        boolean r11 = true;
    L11:
        if (r11 == false) goto L28;
        ((f0) this.f20320c).throwIfReached();     // Catch: AssertionError -> L17
        y r12 = r5.P(1);     // Catch: AssertionError -> L17
        int r13 = ((InputStream) this.f20319b).read(r12.f20352a, r12.f20354c, (int) Math.min(r10, 8192 - r12.f20354c));     // Catch: AssertionError -> L17
        if (r13 == (-1)) goto L15;
        r12.f20354c += r13;     // Catch: AssertionError -> L17
        long r14 = r13;
        r5.f20328b += r14;     // Catch: AssertionError -> L17
        return r14;
    L15:
        if (r12.f20353b != r12.f20354c) goto L50;
        r5.f20327a = r12.a();     // Catch: AssertionError -> L17
        z.a(r12);     // Catch: AssertionError -> L17
    L50:
        return -1;
    L17:
        e = move-exception;
        if (f4.b.k(e) == true) goto L25;
        throw e;
    L25:
        throw new IOException(e);
    L28:
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.j(r10, "byteCount < 0: ").toString());
    L10:
        r11 = false;
        goto L11
    L29:
        Intrinsics.checkNotNullParameter(r5, "sink");
        e r15 = (e) this.f20319b;
        r15.enter();
        long r16 = ((c0) this.f20320c).read(r5, r10);     // Catch: Throwable -> L36 IOException -> L38
    L32:
        if (r15.exit() == true) goto L35;
        return r16;
    L35:
        throw r15.access$newTimeoutException(null);
    L38:
        e = move-exception;
        if (r15.exit() == true) goto L43;
        throw e;     // Catch: Throwable -> L36
    L43:
        throw r15.access$newTimeoutException(e);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        r15.exit();
        throw th;
    }

    @Override // nu.c0
    public final f0 timeout() {
        switch(this.f20318a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return (f0) this.f20320c;
    L7:
        return (e) this.f20319b;
    }

    public final String toString() {
        switch(this.f20318a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return "source(" + ((InputStream) this.f20319b) + ')';
    L7:
        return "AsyncTimeout.source(" + ((c0) this.f20320c) + ')';
    }

    public d(e r5, c0 r10) {
        this.f20318a = 0;
        this.f20319b = r5;
        this.f20320c = r10;
    }
}
