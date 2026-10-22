package okio;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
final class e0 extends c {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Socket f12207n;

    public e0(Socket r10) {
        Intrinsics.checkNotNullParameter(r10, "socket");
        this.f12207n = r10;
    }

    @Override // okio.c
    protected void B() {
        this.f12207n.close();     // Catch: AssertionError -> L5 Exception -> L10
    L16:
        return;
    L5:
        e = move-exception;
        if (t.c(e) == false) goto L9;
        Logger r10 = u.a();
        Level r11 = Level.WARNING;
        StringBuilder r12 = new StringBuilder();
        Throwable r13 = e;
        Logger r14 = r10;
    L12:
        r12.append("Failed to close timed out socket ");
        r12.append(this.f12207n);
        r14.log(r11, r12.toString(), r13);
        return;
    L9:
        throw e;
    L10:
        e = move-exception;
        Logger r15 = u.a();
        r11 = Level.WARNING;
        r12 = new StringBuilder();
        r13 = e;
        r14 = r15;
        goto L12
    }

    @Override // okio.c
    protected IOException x(IOException r10) {
        SocketTimeoutException r11 = new SocketTimeoutException("timeout");
        if (r10 == null) goto L5;
        r11.initCause(r10);
    L5:
        return r11;
    }
}
