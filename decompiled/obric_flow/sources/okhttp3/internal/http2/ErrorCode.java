package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0001\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/http2/ErrorCode;", "", "httpCode", "", "(Ljava/lang/String;II)V", "getHttpCode", "()I", "NO_ERROR", "PROTOCOL_ERROR", "INTERNAL_ERROR", "FLOW_CONTROL_ERROR", "SETTINGS_TIMEOUT", "STREAM_CLOSED", "FRAME_SIZE_ERROR", "REFUSED_STREAM", "CANCEL", "COMPRESSION_ERROR", "CONNECT_ERROR", "ENHANCE_YOUR_CALM", "INADEQUATE_SECURITY", "HTTP_1_1_REQUIRED", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final enum ErrorCode extends Enum<ErrorCode> {
    private static final /* synthetic */ ErrorCode[] $VALUES = null;
    public static final ErrorCode CANCEL = null;
    public static final ErrorCode COMPRESSION_ERROR = null;
    public static final ErrorCode CONNECT_ERROR = null;
    public static final Companion Companion = null;
    public static final ErrorCode ENHANCE_YOUR_CALM = null;
    public static final ErrorCode FLOW_CONTROL_ERROR = null;
    public static final ErrorCode FRAME_SIZE_ERROR = null;
    public static final ErrorCode HTTP_1_1_REQUIRED = null;
    public static final ErrorCode INADEQUATE_SECURITY = null;
    public static final ErrorCode INTERNAL_ERROR = null;
    public static final ErrorCode NO_ERROR = null;
    public static final ErrorCode PROTOCOL_ERROR = null;
    public static final ErrorCode REFUSED_STREAM = null;
    public static final ErrorCode SETTINGS_TIMEOUT = null;
    public static final ErrorCode STREAM_CLOSED = null;
    private final int httpCode;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lokhttp3/internal/http2/ErrorCode$Companion;", "", "()V", "fromHttp2", "Lokhttp3/internal/http2/ErrorCode;", "code", "", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public final ErrorCode fromHttp2(int r5) {
            ErrorCode[] r10 = ErrorCode.values();
            int r11 = r10.length;
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L8;
            ErrorCode r13 = r10[r12];
            if (r13.getHttpCode() == r5) goto L12;
            r12 = r12 + 1;
            goto L3
        L12:
            return r13;
        L8:
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }
    }

    static {
        ErrorCode r5 = new ErrorCode("NO_ERROR", 0, 0);
        NO_ERROR = r5;
        ErrorCode r10 = new ErrorCode("PROTOCOL_ERROR", 1, 1);
        PROTOCOL_ERROR = r10;
        ErrorCode r11 = new ErrorCode("INTERNAL_ERROR", 2, 2);
        INTERNAL_ERROR = r11;
        ErrorCode r12 = new ErrorCode("FLOW_CONTROL_ERROR", 3, 3);
        FLOW_CONTROL_ERROR = r12;
        ErrorCode r13 = new ErrorCode("SETTINGS_TIMEOUT", 4, 4);
        SETTINGS_TIMEOUT = r13;
        ErrorCode r14 = new ErrorCode("STREAM_CLOSED", 5, 5);
        STREAM_CLOSED = r14;
        ErrorCode r15 = new ErrorCode("FRAME_SIZE_ERROR", 6, 6);
        FRAME_SIZE_ERROR = r15;
        ErrorCode r16 = new ErrorCode("REFUSED_STREAM", 7, 7);
        REFUSED_STREAM = r16;
        ErrorCode r17 = new ErrorCode("CANCEL", 8, 8);
        CANCEL = r17;
        ErrorCode r18 = new ErrorCode("COMPRESSION_ERROR", 9, 9);
        COMPRESSION_ERROR = r18;
        ErrorCode r19 = new ErrorCode("CONNECT_ERROR", 10, 10);
        CONNECT_ERROR = r19;
        ErrorCode r110 = new ErrorCode("ENHANCE_YOUR_CALM", 11, 11);
        ENHANCE_YOUR_CALM = r110;
        ErrorCode r111 = new ErrorCode("INADEQUATE_SECURITY", 12, 12);
        INADEQUATE_SECURITY = r111;
        ErrorCode r112 = new ErrorCode("HTTP_1_1_REQUIRED", 13, 13);
        HTTP_1_1_REQUIRED = r112;
        $VALUES = new ErrorCode[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112};
        Companion = new Companion(null);
    }

    private ErrorCode(String r5, int r10, int r11) {
        super(r5, r10);
        this.httpCode = r11;
    }

    public static ErrorCode valueOf(String r5) {
        return (ErrorCode) Enum.valueOf(ErrorCode.class, r5);
    }

    public static ErrorCode[] values() {
        return (ErrorCode[]) $VALUES.clone();
    }

    public final int getHttpCode() {
        return this.httpCode;
    }
}
