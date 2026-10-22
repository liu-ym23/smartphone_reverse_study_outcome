package com.bytedance.ai.applet.app.foundation.performance;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/applet/app/foundation/performance/AppletPerformanceNavigationType;", "", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NAVIGATE_TO", "REDIRECT_TO", "RE_LAUNCH", "OPEN_PAGE", "OPEN_PAGE_IN_CHAT", "SWITCH_TAB", "NAVIGATE_BACK", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppletPerformanceNavigationType extends Enum<AppletPerformanceNavigationType> {
    public static final AppletPerformanceNavigationType NAVIGATE_BACK = null;
    public static final AppletPerformanceNavigationType NAVIGATE_TO = null;
    public static final AppletPerformanceNavigationType OPEN_PAGE = null;
    public static final AppletPerformanceNavigationType OPEN_PAGE_IN_CHAT = null;
    public static final AppletPerformanceNavigationType REDIRECT_TO = null;
    public static final AppletPerformanceNavigationType RE_LAUNCH = null;
    public static final AppletPerformanceNavigationType SWITCH_TAB = null;
    public static final /* synthetic */ AppletPerformanceNavigationType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<AppletPerformanceNavigationType> getEntries() {
        return b;
    }

    static {
        AppletPerformanceNavigationType r0 = new AppletPerformanceNavigationType("NAVIGATE_TO", 0, "navigateTo");
        NAVIGATE_TO = r0;
        AppletPerformanceNavigationType r1 = new AppletPerformanceNavigationType("REDIRECT_TO", 1, "redirectTo");
        REDIRECT_TO = r1;
        AppletPerformanceNavigationType r10 = new AppletPerformanceNavigationType("RE_LAUNCH", 2, "reLaunch");
        RE_LAUNCH = r10;
        AppletPerformanceNavigationType r11 = new AppletPerformanceNavigationType("OPEN_PAGE", 3, "openPage");
        OPEN_PAGE = r11;
        AppletPerformanceNavigationType r12 = new AppletPerformanceNavigationType("OPEN_PAGE_IN_CHAT", 4, "openPageInChat");
        OPEN_PAGE_IN_CHAT = r12;
        AppletPerformanceNavigationType r13 = new AppletPerformanceNavigationType("SWITCH_TAB", 5, "switchTab");
        SWITCH_TAB = r13;
        AppletPerformanceNavigationType r14 = new AppletPerformanceNavigationType("NAVIGATE_BACK", 6, "navigateBack");
        NAVIGATE_BACK = r14;
        AppletPerformanceNavigationType[] r15 = {r0, r1, r10, r11, r12, r13, r14};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
    }

    public static AppletPerformanceNavigationType[] values() {
        return (AppletPerformanceNavigationType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static AppletPerformanceNavigationType valueOf(String r1) {
        return (AppletPerformanceNavigationType) r27.a.a(AppletPerformanceNavigationType.class, r1);
    }

    public AppletPerformanceNavigationType(String r1, int r10, String r11) {
        super(r1, r10);
        this.value = r11;
    }
}
