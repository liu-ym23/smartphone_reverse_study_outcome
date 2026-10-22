package com.bytedance.ai.monitor;

import androidx.compose.runtime.ComposerKt;
import com.bytedance.ies.bullet.lynx.impl.LynxErrorCode;
import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/monitor/AppletErrorCode;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum AppletErrorCode extends Enum<AppletErrorCode> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AppletErrorCode f2378b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AppletErrorCode f2379c = null;
    public static final AppletErrorCode d = null;
    public static final /* synthetic */ AppletErrorCode[] e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2380a;

    static {
        AppletErrorCode r5 = new AppletErrorCode("SUCCESS", 0, 0);
        f2378b = r5;
        AppletErrorCode r10 = new AppletErrorCode("APPLET_NOT_FOUND", 1, 101);
        AppletErrorCode r11 = new AppletErrorCode("MAIN_JS_EMPTY", 2, 102);
        AppletErrorCode r12 = new AppletErrorCode("TEMPLATE_BUNDLE_EMPTY", 3, 103);
        AppletErrorCode r13 = new AppletErrorCode("PAGE_NOT_FOUND", 4, 104);
        AppletErrorCode r14 = new AppletErrorCode("RUNTIME_ENTRY_EMPTY", 5, 105);
        AppletErrorCode r15 = new AppletErrorCode("JS_ERROR", 6, 201);
        f2379c = r15;
        AppletErrorCode r16 = new AppletErrorCode("JS_WARNING", 7, ComposerKt.compositionLocalMapKey);
        AppletErrorCode r17 = new AppletErrorCode("WIDGET_LOAD_ERROR", 8, LynxErrorCode.LYNX_ERROR_CODE_UPDATE);
        d = r17;
        AppletErrorCode[] r18 = {r5, r10, r11, r12, r13, r14, r15, r16, r17, new AppletErrorCode("WEB_VIEW_CREATE_ERROR", 9, 402), new AppletErrorCode("WEB_VIEW_LOAD_ERROR", 10, 403), new AppletErrorCode("APPLET_RUNTIME_LOAD_ERROR", 11, 404), new AppletErrorCode("LYNX_VIEW_CREATE_ERROR", 12, 405), new AppletErrorCode("HOST_ACTIVITY_EMPTY", 13, 406), new AppletErrorCode("RENDER_VIEW_CREATE_ERROR", 14, 407)};
        e = r18;
        EnumEntriesKt.enumEntries(r18);
    }

    public AppletErrorCode(String r5, int r10, int r11) {
        super(r5, r10);
        this.f2380a = r11;
    }

    public static AppletErrorCode valueOf(String r5) {
        return (AppletErrorCode) Enum.valueOf(AppletErrorCode.class, r5);
    }

    public static AppletErrorCode[] values() {
        return (AppletErrorCode[]) e.clone();
    }
}
