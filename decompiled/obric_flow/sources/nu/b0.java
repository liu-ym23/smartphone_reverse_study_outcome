package nu;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Socket f20314a;

    public b0(Socket r5) {
        Intrinsics.checkNotNullParameter(r5, "socket");
        this.f20314a = r5;
    }

    @Override // nu.e
    public final IOException newTimeoutException(IOException r5) {
        SocketTimeoutException r10 = new SocketTimeoutException("timeout");
        if (r5 == null) goto L5;
        r10.initCause(r5);
    L5:
        return r10;
    }

    @Override // nu.e
    public final void timedOut() {
        Socket r5 = this.f20314a;
        r5.close();     // Catch: AssertionError -> L5 Exception -> L10
    L16:
        return;
    L5:
        e = move-exception;
        if (f4.b.k(e) == false) goto L9;
        t.f20339a.log(Level.WARNING, "Failed to close timed out socket " + r5, e);
        return;
    L9:
        throw e;
    L10:
        e = move-exception;
        t.f20339a.log(Level.WARNING, "Failed to close timed out socket " + r5, e);
    }
}
