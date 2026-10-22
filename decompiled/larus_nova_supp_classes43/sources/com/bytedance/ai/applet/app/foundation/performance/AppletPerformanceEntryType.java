package com.bytedance.ai.applet.app.foundation.performance;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/applet/app/foundation/performance/AppletPerformanceEntryType;", "", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NAVIGATION", "RENDER", "SCRIPT", "LOAD_PACKAGE", "RESOURCE", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppletPerformanceEntryType extends Enum<AppletPerformanceEntryType> {
    public static final AppletPerformanceEntryType LOAD_PACKAGE = null;
    public static final AppletPerformanceEntryType NAVIGATION = null;
    public static final AppletPerformanceEntryType RENDER = null;
    public static final AppletPerformanceEntryType RESOURCE = null;
    public static final AppletPerformanceEntryType SCRIPT = null;
    public static final /* synthetic */ AppletPerformanceEntryType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<AppletPerformanceEntryType> getEntries() {
        return b;
    }

    static {
        AppletPerformanceEntryType r0 = new AppletPerformanceEntryType("NAVIGATION", 0, "navigation");
        NAVIGATION = r0;
        AppletPerformanceEntryType r1 = new AppletPerformanceEntryType("RENDER", 1, "render");
        RENDER = r1;
        AppletPerformanceEntryType r10 = new AppletPerformanceEntryType("SCRIPT", 2, "script");
        SCRIPT = r10;
        AppletPerformanceEntryType r11 = new AppletPerformanceEntryType("LOAD_PACKAGE", 3, "loadPackage");
        LOAD_PACKAGE = r11;
        AppletPerformanceEntryType r12 = new AppletPerformanceEntryType("RESOURCE", 4, "resource");
        RESOURCE = r12;
        AppletPerformanceEntryType[] r13 = {r0, r1, r10, r11, r12};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
    }

    public static AppletPerformanceEntryType[] values() {
        return (AppletPerformanceEntryType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static AppletPerformanceEntryType valueOf(String r1) {
        return (AppletPerformanceEntryType) r27.a.a(AppletPerformanceEntryType.class, r1);
    }

    public AppletPerformanceEntryType(String r1, int r10, String r11) {
        super(r1, r10);
        this.value = r11;
    }
}
