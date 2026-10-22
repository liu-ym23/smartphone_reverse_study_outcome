package com.bytedance.ai.applet.app.foundation.performance;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/applet/app/foundation/performance/AppletPerformanceOutcome;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "FAILED", "CANCELLED", "TIMEOUT", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppletPerformanceOutcome extends Enum<AppletPerformanceOutcome> {
    public static final AppletPerformanceOutcome CANCELLED = null;
    public static final AppletPerformanceOutcome FAILED = null;
    public static final AppletPerformanceOutcome SUCCESS = null;
    public static final AppletPerformanceOutcome TIMEOUT = null;
    public static final /* synthetic */ AppletPerformanceOutcome[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AppletPerformanceOutcome> getEntries() {
        return b;
    }

    static {
        AppletPerformanceOutcome r0 = new AppletPerformanceOutcome("SUCCESS", 0);
        SUCCESS = r0;
        AppletPerformanceOutcome r1 = new AppletPerformanceOutcome("FAILED", 1);
        FAILED = r1;
        AppletPerformanceOutcome r10 = new AppletPerformanceOutcome("CANCELLED", 2);
        CANCELLED = r10;
        AppletPerformanceOutcome r11 = new AppletPerformanceOutcome("TIMEOUT", 3);
        TIMEOUT = r11;
        AppletPerformanceOutcome[] r12 = {r0, r1, r10, r11};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static AppletPerformanceOutcome[] values() {
        return (AppletPerformanceOutcome[]) a.clone();
    }

    public static AppletPerformanceOutcome valueOf(String r1) {
        return (AppletPerformanceOutcome) r27.a.a(AppletPerformanceOutcome.class, r1);
    }

    public AppletPerformanceOutcome(String r1, int r10) {
        super(r1, r10);
    }
}
