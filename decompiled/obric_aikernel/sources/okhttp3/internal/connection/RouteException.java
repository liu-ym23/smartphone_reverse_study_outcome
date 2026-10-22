package okhttp3.internal.connection;

import java.io.IOException;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class RouteException extends RuntimeException {
    private final IOException firstConnectException;
    private IOException lastConnectException;

    public RouteException(IOException r10) {
        Intrinsics.checkNotNullParameter(r10, "firstConnectException");
        super(r10);
        this.firstConnectException = r10;
        this.lastConnectException = r10;
    }

    public final void addConnectException(IOException r10) {
        Intrinsics.checkNotNullParameter(r10, "e");
        ExceptionsKt.addSuppressed(this.firstConnectException, r10);
        this.lastConnectException = r10;
    }

    public final IOException getFirstConnectException() {
        return this.firstConnectException;
    }

    public final IOException getLastConnectException() {
        return this.lastConnectException;
    }
}
