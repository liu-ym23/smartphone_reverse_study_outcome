package com.bytedance.ai.applet.app.foundation.performance;

import com.byted.cast.sink.api.CastInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ai/applet/app/foundation/performance/AppletPerformanceErrorCode;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "getCode", "()I", "UNKNOWN", "SUCCESS", "CANCELLED", "TIMEOUT", "INTERRUPTED", "INVALID_RENDER_TIMING", "WIDGET_RENDER_ERROR", "RENDER_VIEW_CREATE_ERROR", "PAGE_RENDER_ERROR", "ROUTE_ERROR", "LOAD_PACKAGE_ERROR", "SCRIPT_EVALUATION_ERROR", "SCRIPT_LOAD_ERROR", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppletPerformanceErrorCode extends Enum<AppletPerformanceErrorCode> {
    public static final AppletPerformanceErrorCode CANCELLED = null;
    public static final AppletPerformanceErrorCode INTERRUPTED = null;
    public static final AppletPerformanceErrorCode INVALID_RENDER_TIMING = null;
    public static final AppletPerformanceErrorCode LOAD_PACKAGE_ERROR = null;
    public static final AppletPerformanceErrorCode PAGE_RENDER_ERROR = null;
    public static final AppletPerformanceErrorCode RENDER_VIEW_CREATE_ERROR = null;
    public static final AppletPerformanceErrorCode ROUTE_ERROR = null;
    public static final AppletPerformanceErrorCode SCRIPT_EVALUATION_ERROR = null;
    public static final AppletPerformanceErrorCode SCRIPT_LOAD_ERROR = null;
    public static final AppletPerformanceErrorCode SUCCESS = null;
    public static final AppletPerformanceErrorCode TIMEOUT = null;
    public static final AppletPerformanceErrorCode UNKNOWN = null;
    public static final AppletPerformanceErrorCode WIDGET_RENDER_ERROR = null;
    public static final /* synthetic */ AppletPerformanceErrorCode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int code;

    public static EnumEntries<AppletPerformanceErrorCode> getEntries() {
        return b;
    }

    static {
        AppletPerformanceErrorCode r0 = new AppletPerformanceErrorCode("UNKNOWN", 0, -1);
        UNKNOWN = r0;
        AppletPerformanceErrorCode r1 = new AppletPerformanceErrorCode("SUCCESS", 1, 0);
        SUCCESS = r1;
        AppletPerformanceErrorCode r10 = new AppletPerformanceErrorCode("CANCELLED", 2, 1);
        CANCELLED = r10;
        AppletPerformanceErrorCode r11 = new AppletPerformanceErrorCode("TIMEOUT", 3, 2);
        TIMEOUT = r11;
        AppletPerformanceErrorCode r12 = new AppletPerformanceErrorCode("INTERRUPTED", 4, 3);
        INTERRUPTED = r12;
        AppletPerformanceErrorCode r13 = new AppletPerformanceErrorCode("INVALID_RENDER_TIMING", 5, 100);
        INVALID_RENDER_TIMING = r13;
        AppletPerformanceErrorCode r14 = new AppletPerformanceErrorCode("WIDGET_RENDER_ERROR", 6, 101);
        WIDGET_RENDER_ERROR = r14;
        AppletPerformanceErrorCode r15 = new AppletPerformanceErrorCode("RENDER_VIEW_CREATE_ERROR", 7, 102);
        RENDER_VIEW_CREATE_ERROR = r15;
        AppletPerformanceErrorCode r16 = new AppletPerformanceErrorCode("PAGE_RENDER_ERROR", 8, 103);
        PAGE_RENDER_ERROR = r16;
        AppletPerformanceErrorCode r17 = new AppletPerformanceErrorCode("ROUTE_ERROR", 9, 104);
        ROUTE_ERROR = r17;
        AppletPerformanceErrorCode r18 = new AppletPerformanceErrorCode("LOAD_PACKAGE_ERROR", 10, CastInfo.TYPE_CAST_RESUME);
        LOAD_PACKAGE_ERROR = r18;
        AppletPerformanceErrorCode r19 = new AppletPerformanceErrorCode("SCRIPT_EVALUATION_ERROR", 11, 200);
        SCRIPT_EVALUATION_ERROR = r19;
        AppletPerformanceErrorCode r20 = new AppletPerformanceErrorCode("SCRIPT_LOAD_ERROR", 12, 201);
        SCRIPT_LOAD_ERROR = r20;
        AppletPerformanceErrorCode[] r21 = {r0, r1, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20};
        a = r21;
        b = EnumEntriesKt.enumEntries(r21);
    }

    public static AppletPerformanceErrorCode[] values() {
        return (AppletPerformanceErrorCode[]) a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public static AppletPerformanceErrorCode valueOf(String r1) {
        return (AppletPerformanceErrorCode) r27.a.a(AppletPerformanceErrorCode.class, r1);
    }

    public AppletPerformanceErrorCode(String r1, int r10, int r11) {
        super(r1, r10);
        this.code = r11;
    }
}
