package nu;

import java.io.IOException;
import java.io.OutputStream;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f20316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f20317c;

    public c(OutputStream r5, f0 r10) {
        this.f20315a = 1;
        Intrinsics.checkNotNullParameter(r5, "out");
        Intrinsics.checkNotNullParameter(r10, "timeout");
        this.f20316b = r5;
        this.f20317c = r10;
    }

    @Override // nu.a0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Object r5 = this.f20316b;
        switch(this.f20315a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        ((OutputStream) r5).close();
        return;
    L6:
        e r10 = (e) r5;
        r10.enter();
        ((a0) this.f20317c).close();     // Catch: Throwable -> L13 IOException -> L15
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

    @Override // nu.a0, java.io.Flushable
    public final void flush() {
        Object r5 = this.f20316b;
        switch(this.f20315a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        ((OutputStream) r5).flush();
        return;
    L6:
        e r10 = (e) r5;
        r10.enter();
        ((a0) this.f20317c).flush();     // Catch: Throwable -> L13 IOException -> L15
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

    @Override // nu.a0
    public final f0 timeout() {
        switch(this.f20315a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return (f0) this.f20317c;
    L7:
        return (e) this.f20316b;
    }

    public final String toString() {
        switch(this.f20315a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return "sink(" + ((OutputStream) this.f20316b) + ')';
    L7:
        return "AsyncTimeout.sink(" + ((a0) this.f20317c) + ')';
    }

    @Override // nu.a0
    public final void write(j r12, long r13) {
        Object r5 = this.f20316b;
        Object r10 = this.f20317c;
        int r11 = this.f20315a;
        Intrinsics.checkNotNullParameter(r12, "source");
        switch(r11) {
            case 0: goto L11;
            default: goto L4;
        };
    L4:
        f4.a.d(r12.f20328b, 0, r13);
    L6:
        if (r13 <= 0) goto L10;
        ((f0) r10).throwIfReached();
        y r14 = r12.f20327a;
        Intrinsics.checkNotNull(r14);
        int r15 = (int) Math.min(r13, r14.f20354c - r14.f20353b);
        ((OutputStream) r5).write(r14.f20352a, r14.f20353b, r15);
        int r16 = r14.f20353b + r15;
        r14.f20353b = r16;
        long r17 = r15;
        r13 = r13 - r17;
        r12.f20328b -= r17;
        if (r16 != r14.f20354c) goto L6;
        r12.f20327a = r14.a();
        z.a(r14);
        goto L6
    L10:
        return;
    L11:
        f4.a.d(r12.f20328b, 0, r13);
    L13:
        if (r13 <= 0) goto L38;
        y r18 = r12.f20327a;
        Intrinsics.checkNotNull(r18);
        long r19 = 0;
    L16:
        if (r19 >= 65536) goto L21;
        r19 = r19 + ((long) (r18.f20354c - r18.f20353b));
        if (r19 >= r13) goto L19;
        r18 = r18.f;
        Intrinsics.checkNotNull(r18);
        goto L16
    L19:
        r19 = r13;
    L21:
        e r110 = (e) r5;
        r110.enter();
        ((a0) r10).write(r12, r19);     // Catch: Throwable -> L28 IOException -> L30
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L28 IOException -> L30
    L24:
        if (r110.exit() == true) goto L27;
        r13 = r13 - r19;
        goto L13
    L27:
        throw r110.access$newTimeoutException(null);
    L28:
        th = move-exception;
        r110.exit();
        throw th;
    L30:
        e = move-exception;
        if (r110.exit() == true) goto L35;
        throw e;     // Catch: Throwable -> L28
    L35:
        throw r110.access$newTimeoutException(e);     // Catch: Throwable -> L28
    }

    public c(e r5, a0 r10) {
        this.f20315a = 0;
        this.f20316b = r5;
        this.f20317c = r10;
    }
}
