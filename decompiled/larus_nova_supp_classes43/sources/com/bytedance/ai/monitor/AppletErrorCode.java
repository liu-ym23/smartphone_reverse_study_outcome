package com.bytedance.ai.monitor;

import com.byted.cast.sink.api.CastInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ai/monitor/AppletErrorCode;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "setType", "(I)V", "SUCCESS", "APPLET_NOT_FOUND", "MAIN_JS_EMPTY", "TEMPLATE_BUNDLE_EMPTY", "PAGE_NOT_FOUND", "RUNTIME_ENTRY_EMPTY", "PAGE_NOT_READY", "JS_ERROR", "JS_WARNING", "WIDGET_LOAD_ERROR", "WEB_VIEW_CREATE_ERROR", "WEB_VIEW_LOAD_ERROR", "APPLET_RUNTIME_LOAD_ERROR", "LYNX_VIEW_CREATE_ERROR", "HOST_ACTIVITY_EMPTY", "RENDER_VIEW_CREATE_ERROR", "WIDGET_BIND_CANCEL_ERROR", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppletErrorCode extends Enum<AppletErrorCode> {
    public static final AppletErrorCode APPLET_NOT_FOUND = null;
    public static final AppletErrorCode APPLET_RUNTIME_LOAD_ERROR = null;
    public static final AppletErrorCode HOST_ACTIVITY_EMPTY = null;
    public static final AppletErrorCode JS_ERROR = null;
    public static final AppletErrorCode JS_WARNING = null;
    public static final AppletErrorCode LYNX_VIEW_CREATE_ERROR = null;
    public static final AppletErrorCode MAIN_JS_EMPTY = null;
    public static final AppletErrorCode PAGE_NOT_FOUND = null;
    public static final AppletErrorCode PAGE_NOT_READY = null;
    public static final AppletErrorCode RENDER_VIEW_CREATE_ERROR = null;
    public static final AppletErrorCode RUNTIME_ENTRY_EMPTY = null;
    public static final AppletErrorCode SUCCESS = null;
    public static final AppletErrorCode TEMPLATE_BUNDLE_EMPTY = null;
    public static final AppletErrorCode WEB_VIEW_CREATE_ERROR = null;
    public static final AppletErrorCode WEB_VIEW_LOAD_ERROR = null;
    public static final AppletErrorCode WIDGET_BIND_CANCEL_ERROR = null;
    public static final AppletErrorCode WIDGET_LOAD_ERROR = null;
    public static final /* synthetic */ AppletErrorCode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private int type;

    public static EnumEntries<AppletErrorCode> getEntries() {
        return b;
    }

    static {
        AppletErrorCode r0 = new AppletErrorCode("SUCCESS", 0, 0);
        SUCCESS = r0;
        AppletErrorCode r1 = new AppletErrorCode("APPLET_NOT_FOUND", 1, 101);
        APPLET_NOT_FOUND = r1;
        AppletErrorCode r10 = new AppletErrorCode("MAIN_JS_EMPTY", 2, 102);
        MAIN_JS_EMPTY = r10;
        AppletErrorCode r11 = new AppletErrorCode("TEMPLATE_BUNDLE_EMPTY", 3, 103);
        TEMPLATE_BUNDLE_EMPTY = r11;
        AppletErrorCode r12 = new AppletErrorCode("PAGE_NOT_FOUND", 4, 104);
        PAGE_NOT_FOUND = r12;
        AppletErrorCode r13 = new AppletErrorCode("RUNTIME_ENTRY_EMPTY", 5, CastInfo.TYPE_CAST_RESUME);
        RUNTIME_ENTRY_EMPTY = r13;
        AppletErrorCode r14 = new AppletErrorCode("PAGE_NOT_READY", 6, CastInfo.TYPE_DISCONNECT);
        PAGE_NOT_READY = r14;
        AppletErrorCode r15 = new AppletErrorCode("JS_ERROR", 7, 201);
        JS_ERROR = r15;
        AppletErrorCode r16 = new AppletErrorCode("JS_WARNING", 8, 202);
        JS_WARNING = r16;
        AppletErrorCode r17 = new AppletErrorCode("WIDGET_LOAD_ERROR", 9, 401);
        WIDGET_LOAD_ERROR = r17;
        AppletErrorCode r18 = new AppletErrorCode("WEB_VIEW_CREATE_ERROR", 10, 402);
        WEB_VIEW_CREATE_ERROR = r18;
        AppletErrorCode r19 = new AppletErrorCode("WEB_VIEW_LOAD_ERROR", 11, 403);
        WEB_VIEW_LOAD_ERROR = r19;
        AppletErrorCode r20 = new AppletErrorCode("APPLET_RUNTIME_LOAD_ERROR", 12, 404);
        APPLET_RUNTIME_LOAD_ERROR = r20;
        AppletErrorCode r21 = new AppletErrorCode("LYNX_VIEW_CREATE_ERROR", 13, 405);
        LYNX_VIEW_CREATE_ERROR = r21;
        AppletErrorCode r22 = new AppletErrorCode("HOST_ACTIVITY_EMPTY", 14, 406);
        HOST_ACTIVITY_EMPTY = r22;
        AppletErrorCode r23 = new AppletErrorCode("RENDER_VIEW_CREATE_ERROR", 15, 407);
        RENDER_VIEW_CREATE_ERROR = r23;
        AppletErrorCode r24 = new AppletErrorCode("WIDGET_BIND_CANCEL_ERROR", 16, 408);
        WIDGET_BIND_CANCEL_ERROR = r24;
        AppletErrorCode[] r25 = {r0, r1, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24};
        a = r25;
        b = EnumEntriesKt.enumEntries(r25);
    }

    public static AppletErrorCode[] values() {
        return (AppletErrorCode[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static AppletErrorCode valueOf(String r1) {
        return (AppletErrorCode) r27.a.a(AppletErrorCode.class, r1);
    }

    public final void setType(int r1) {
        this.type = r1;
    }

    public AppletErrorCode(String r1, int r10, int r11) {
        super(r1, r10);
        this.type = r11;
    }
}
