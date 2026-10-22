package okhttp3.internal.connection;

import cvc.c;
import java.io.IOException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class RouteException extends RuntimeException {
    private IOException firstException;
    private IOException lastException;

    public IOException getFirstConnectException() {
        return this.firstException;
    }

    public IOException getLastConnectException() {
        return this.lastException;
    }

    public RouteException(IOException r1) {
        super(r1);
        this.firstException = r1;
        this.lastException = r1;
    }

    public void addConnectException(IOException r5) {
        IOException r0 = this.firstException;
        Method r1 = c.r;
        if (r1 != null) goto L9;
    L6:
        this.lastException = r5;
        return;
    L9:
        r1.invoke(r0, new Object[]{r5});     // Catch: Throwable -> L8
        goto L6
    }
}
