package okhttp3.internal.http2;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0001\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lokhttp3/internal/http2/ErrorCode;", "", "httpCode", "", "(Ljava/lang/String;II)V", "getHttpCode", "()I", "NO_ERROR", "PROTOCOL_ERROR", "INTERNAL_ERROR", "FLOW_CONTROL_ERROR", "REFUSED_STREAM", "CANCEL", "COMPRESSION_ERROR", "CONNECT_ERROR", "ENHANCE_YOUR_CALM", "INADEQUATE_SECURITY", "HTTP_1_1_REQUIRED", "Companion", "okhttp"}, k = 1, mv = {1, 1, 15})
public final enum ErrorCode extends Enum<ErrorCode> {
    private static final /* synthetic */ ErrorCode[] $VALUES = null;
    public static final ErrorCode CANCEL = null;
    public static final ErrorCode COMPRESSION_ERROR = null;
    public static final ErrorCode CONNECT_ERROR = null;
    public static final Companion Companion = null;
    public static final ErrorCode ENHANCE_YOUR_CALM = null;
    public static final ErrorCode FLOW_CONTROL_ERROR = null;
    public static final ErrorCode HTTP_1_1_REQUIRED = null;
    public static final ErrorCode INADEQUATE_SECURITY = null;
    public static final ErrorCode INTERNAL_ERROR = null;
    public static final ErrorCode NO_ERROR = null;
    public static final ErrorCode PROTOCOL_ERROR = null;
    public static final ErrorCode REFUSED_STREAM = null;
    private final int httpCode;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lokhttp3/internal/http2/ErrorCode$Companion;", "", "()V", "fromHttp2", "Lokhttp3/internal/http2/ErrorCode;", "code", "", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final ErrorCode fromHttp2(int r6) {
            ErrorCode[] r5 = ErrorCode.values();
            int r0 = r5.length;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L11;
            ErrorCode r3 = r5[r2];
            if (r3.getHttpCode() != r6) goto L7;
            boolean r4 = true;
        L8:
            if (r4 == true) goto L15;
            r2 = r2 + 1;
            goto L3
        L15:
            return r3;
        L7:
            r4 = false;
            goto L8
        L11:
            return null;
        }
    }

    static {
        ErrorCode r2 = new ErrorCode("NO_ERROR", 0, 0);
        NO_ERROR = r2;
        ErrorCode r3 = new ErrorCode("PROTOCOL_ERROR", 1, 1);
        PROTOCOL_ERROR = r3;
        ErrorCode r4 = new ErrorCode("INTERNAL_ERROR", 2, 2);
        INTERNAL_ERROR = r4;
        ErrorCode r5 = new ErrorCode("FLOW_CONTROL_ERROR", 3, 3);
        FLOW_CONTROL_ERROR = r5;
        ErrorCode r6 = new ErrorCode("REFUSED_STREAM", 4, 7);
        REFUSED_STREAM = r6;
        ErrorCode r7 = new ErrorCode("CANCEL", 5, 8);
        CANCEL = r7;
        ErrorCode r8 = new ErrorCode("COMPRESSION_ERROR", 6, 9);
        COMPRESSION_ERROR = r8;
        ErrorCode r9 = new ErrorCode("CONNECT_ERROR", 7, 10);
        CONNECT_ERROR = r9;
        ErrorCode r10 = new ErrorCode("ENHANCE_YOUR_CALM", 8, 11);
        ENHANCE_YOUR_CALM = r10;
        ErrorCode r0 = new ErrorCode("INADEQUATE_SECURITY", 9, 12);
        INADEQUATE_SECURITY = r0;
        ErrorCode r1 = new ErrorCode("HTTP_1_1_REQUIRED", 10, 13);
        HTTP_1_1_REQUIRED = r1;
        $VALUES = new ErrorCode[]{r2, r3, r4, r5, r6, r7, r8, r9, r10, r0, r1};
        Companion = new Companion(null);
    }

    private ErrorCode(String r1, int r2, int r3) {
        super(r1, r2);
        this.httpCode = r3;
    }

    public static ErrorCode valueOf(String r2) {
        return (ErrorCode) ZeusTransformUtils.preCheckCast(Enum.valueOf(ErrorCode.class, r2), ErrorCode.class, "com.obric.memorydata.plugin");
    }

    public static ErrorCode[] values() {
        return (ErrorCode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ErrorCode[].class, "com.obric.memorydata.plugin");
    }

    public final int getHttpCode() {
        return this.httpCode;
    }
}
