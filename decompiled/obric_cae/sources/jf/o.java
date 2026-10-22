package jf;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Socket f8860k;

    public o(Socket r8) {
        this.f8860k = r8;
    }

    @Override // jf.c
    public final IOException n(@Nullable IOException r8) {
        SocketTimeoutException r10 = new SocketTimeoutException("timeout");
        if (r8 == null) goto L5;
        r10.initCause(r8);
    L5:
        return r10;
    }

    @Override // jf.c
    public final void o() {
        Socket r8 = this.f8860k;
        r8.close();     // Catch: AssertionError -> L5 Exception -> L17
    L23:
        return;
    L5:
        e = move-exception;
        if (e.getCause() != null) goto L9;
    L13:
        boolean r10 = false;
    L14:
        if (r10 == false) goto L16;
        Logger r11 = p.f8861a;
        Level r12 = Level.WARNING;
        StringBuilder r13 = new StringBuilder("Failed to close timed out socket ");
        Throwable r14 = e;
        Logger r15 = r11;
    L19:
        r13.append(r8);
        r15.log(r12, r13.toString(), r14);
        return;
    L16:
        throw e;
    L9:
        if (e.getMessage() == null) goto L13;
        if (e.getMessage().contains("getsockname failed") == false) goto L13;
        r10 = true;
    L17:
        e = move-exception;
        Logger r16 = p.f8861a;
        r12 = Level.WARNING;
        r13 = new StringBuilder("Failed to close timed out socket ");
        r14 = e;
        r15 = r16;
        goto L19
    }
}
