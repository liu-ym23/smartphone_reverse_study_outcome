package okio;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0014R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lokio/SocketAsyncTimeout;", "Lokio/AsyncTimeout;", "socket", "Ljava/net/Socket;", "(Ljava/net/Socket;)V", "logger", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", "newTimeoutException", "Ljava/io/IOException;", "cause", "timedOut", "", "jvm"}, k = 1, mv = {1, 1, 11})
final class SocketAsyncTimeout extends AsyncTimeout {
    private final Logger logger;
    private final Socket socket;

    public SocketAsyncTimeout(Socket r2) {
        Intrinsics.checkParameterIsNotNull(r2, "socket");
        this.socket = r2;
        this.logger = Logger.getLogger("okio.Okio");
    }

    @Override // okio.AsyncTimeout
    public IOException newTimeoutException(IOException r3) {
        SocketTimeoutException r2 = new SocketTimeoutException(LocationMonitorConst.TIMEOUT);
        if (r3 == null) goto L6;
        r2.initCause((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin"));
    L6:
        return (IOException) ZeusTransformUtils.preCheckCast(r2, IOException.class, "com.obric.memorydata.plugin");
    }

    @Override // okio.AsyncTimeout
    public void timedOut() {
        this.socket.close();     // Catch: AssertionError -> L5 Exception -> L11
    L17:
        return;
    L5:
        e = move-exception;
        if (Okio.isAndroidGetsocknameError(e) == false) goto L10;
        Logger r3 = this.logger;
        Level r4 = Level.WARNING;
        StringBuilder r5 = new StringBuilder();
        Object r2 = e;
    L13:
        r3.log(r4, r5.append("Failed to close timed out socket ").append(this.socket).toString(), (Throwable) ZeusTransformUtils.preCheckCast(r2, Throwable.class, "com.obric.memorydata.plugin"));
        return;
    L10:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L11:
        e = move-exception;
        r3 = this.logger;
        r4 = Level.WARNING;
        r5 = new StringBuilder();
        r2 = e;
        goto L13
    }
}
