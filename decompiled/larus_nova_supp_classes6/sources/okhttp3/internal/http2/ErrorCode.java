package okhttp3.internal.http2;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final enum ErrorCode extends Enum<ErrorCode> {
    public static final ErrorCode CANCEL = null;
    public static final ErrorCode COMPRESSION_ERROR = null;
    public static final ErrorCode CONNECT_ERROR = null;
    public static final ErrorCode ENHANCE_YOUR_CALM = null;
    public static final ErrorCode FLOW_CONTROL_ERROR = null;
    public static final ErrorCode HTTP_1_1_REQUIRED = null;
    public static final ErrorCode INADEQUATE_SECURITY = null;
    public static final ErrorCode INTERNAL_ERROR = null;
    public static final ErrorCode NO_ERROR = null;
    public static final ErrorCode PROTOCOL_ERROR = null;
    public static final ErrorCode REFUSED_STREAM = null;
    public static final /* synthetic */ ErrorCode[] a = null;
    public final int httpCode;

    static {
        ErrorCode r0 = new ErrorCode("NO_ERROR", 0, 0);
        NO_ERROR = r0;
        ErrorCode r1 = new ErrorCode("PROTOCOL_ERROR", 1, 1);
        PROTOCOL_ERROR = r1;
        ErrorCode r3 = new ErrorCode("INTERNAL_ERROR", 2, 2);
        INTERNAL_ERROR = r3;
        ErrorCode r5 = new ErrorCode("FLOW_CONTROL_ERROR", 3, 3);
        FLOW_CONTROL_ERROR = r5;
        ErrorCode r7 = new ErrorCode("REFUSED_STREAM", 4, 7);
        REFUSED_STREAM = r7;
        ErrorCode r9 = new ErrorCode("CANCEL", 5, 8);
        CANCEL = r9;
        ErrorCode r12 = new ErrorCode("COMPRESSION_ERROR", 6, 9);
        COMPRESSION_ERROR = r12;
        ErrorCode r15 = new ErrorCode("CONNECT_ERROR", 7, 10);
        CONNECT_ERROR = r15;
        ErrorCode r13 = new ErrorCode("ENHANCE_YOUR_CALM", 8, 11);
        ENHANCE_YOUR_CALM = r13;
        ErrorCode r11 = new ErrorCode("INADEQUATE_SECURITY", 9, 12);
        INADEQUATE_SECURITY = r11;
        ErrorCode r4 = new ErrorCode("HTTP_1_1_REQUIRED", 10, 13);
        HTTP_1_1_REQUIRED = r4;
        a = new ErrorCode[]{r0, r1, r3, r5, r7, r9, r12, r15, r13, r11, r4};
    }

    public static ErrorCode[] values() {
        return (ErrorCode[]) a.clone();
    }

    public static ErrorCode fromHttp2(int r5) {
        ErrorCode[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        ErrorCode r3 = r0[r2];
        if (r3.httpCode == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return null;
    }

    public static ErrorCode valueOf(String r1) {
        return (ErrorCode) a.a(ErrorCode.class, r1);
    }

    public ErrorCode(String r1, int r2, int r3) {
        super(r1, r2);
        this.httpCode = r3;
    }
}
