package okhttp3.internal.http2;

import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class StreamResetException extends IOException {
    public final ErrorCode errorCode;

    public StreamResetException(ErrorCode r3) {
        super("stream was reset: " + r3);
        this.errorCode = r3;
    }
}
