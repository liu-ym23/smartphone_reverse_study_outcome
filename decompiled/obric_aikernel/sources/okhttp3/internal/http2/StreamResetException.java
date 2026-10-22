package okhttp3.internal.http2;

import java.io.IOException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class StreamResetException extends IOException {

    @JvmField
    public final ErrorCode errorCode;

    public StreamResetException(ErrorCode r10) {
        Intrinsics.checkNotNullParameter(r10, "errorCode");
        super("stream was reset: " + r10);
        this.errorCode = r10;
    }
}
