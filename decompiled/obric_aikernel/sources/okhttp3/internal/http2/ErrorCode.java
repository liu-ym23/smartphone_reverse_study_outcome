package okhttp3.internal.http2;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
public final enum ErrorCode extends Enum<ErrorCode> {
    private static final /* synthetic */ ErrorCode[] $VALUES = null;
    public static final ErrorCode CANCEL = null;
    public static final ErrorCode COMPRESSION_ERROR = null;
    public static final ErrorCode CONNECT_ERROR = null;
    public static final a Companion = null;
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

    @SourceDebugExtension({"SMAP\nErrorCode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ErrorCode.kt\nokhttp3/internal/http2/ErrorCode$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,53:1\n1#2:54\n*E\n"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final ErrorCode a(int r10) {
            ErrorCode[] r11 = ErrorCode.values();
            int r12 = r11.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L11;
            ErrorCode r14 = r11[r13];
            if (r14.getHttpCode() != r10) goto L7;
            boolean r15 = true;
        L8:
            if (r15 == true) goto L15;
            r13 = r13 + 1;
            goto L3
        L15:
            return r14;
        L7:
            r15 = false;
            goto L8
        L11:
            return null;
        }
    }

    private static final /* synthetic */ ErrorCode[] $values() {
        return new ErrorCode[]{NO_ERROR, PROTOCOL_ERROR, INTERNAL_ERROR, FLOW_CONTROL_ERROR, SETTINGS_TIMEOUT, STREAM_CLOSED, FRAME_SIZE_ERROR, REFUSED_STREAM, CANCEL, COMPRESSION_ERROR, CONNECT_ERROR, ENHANCE_YOUR_CALM, INADEQUATE_SECURITY, HTTP_1_1_REQUIRED};
    }

    static {
        NO_ERROR = new ErrorCode("NO_ERROR", 0, 0);
        PROTOCOL_ERROR = new ErrorCode("PROTOCOL_ERROR", 1, 1);
        INTERNAL_ERROR = new ErrorCode("INTERNAL_ERROR", 2, 2);
        FLOW_CONTROL_ERROR = new ErrorCode("FLOW_CONTROL_ERROR", 3, 3);
        SETTINGS_TIMEOUT = new ErrorCode("SETTINGS_TIMEOUT", 4, 4);
        STREAM_CLOSED = new ErrorCode("STREAM_CLOSED", 5, 5);
        FRAME_SIZE_ERROR = new ErrorCode("FRAME_SIZE_ERROR", 6, 6);
        REFUSED_STREAM = new ErrorCode("REFUSED_STREAM", 7, 7);
        CANCEL = new ErrorCode("CANCEL", 8, 8);
        COMPRESSION_ERROR = new ErrorCode("COMPRESSION_ERROR", 9, 9);
        CONNECT_ERROR = new ErrorCode("CONNECT_ERROR", 10, 10);
        ENHANCE_YOUR_CALM = new ErrorCode("ENHANCE_YOUR_CALM", 11, 11);
        INADEQUATE_SECURITY = new ErrorCode("INADEQUATE_SECURITY", 12, 12);
        HTTP_1_1_REQUIRED = new ErrorCode("HTTP_1_1_REQUIRED", 13, 13);
        $VALUES = $values();
        Companion = new a(null);
    }

    private ErrorCode(String r10, int r11, int r12) {
        super(r10, r11);
        this.httpCode = r12;
    }

    public static ErrorCode valueOf(String r10) {
        return (ErrorCode) Enum.valueOf(ErrorCode.class, r10);
    }

    public static ErrorCode[] values() {
        return (ErrorCode[]) $VALUES.clone();
    }

    public final int getHttpCode() {
        return this.httpCode;
    }
}
