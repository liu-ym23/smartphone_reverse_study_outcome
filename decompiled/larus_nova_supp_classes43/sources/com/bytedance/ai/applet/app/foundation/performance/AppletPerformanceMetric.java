package com.bytedance.ai.applet.app.foundation.performance;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/applet/app/foundation/performance/AppletPerformanceMetric;", "", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "", "entryType", "Lcom/bytedance/ai/applet/app/foundation/performance/AppletPerformanceEntryType;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lcom/bytedance/ai/applet/app/foundation/performance/AppletPerformanceEntryType;)V", "getValue", "()Ljava/lang/String;", "getEntryType", "()Lcom/bytedance/ai/applet/app/foundation/performance/AppletPerformanceEntryType;", "APP_LAUNCH", "ROUTE", "FIRST_RENDER", "FIRST_PAINT", "FIRST_CONTENTFUL_PAINT", "EVALUATE_SCRIPT", "DOWNLOAD_PACKAGE", "RESOURCE_TIMING", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppletPerformanceMetric extends Enum<AppletPerformanceMetric> {
    public static final AppletPerformanceMetric APP_LAUNCH = null;
    public static final AppletPerformanceMetric DOWNLOAD_PACKAGE = null;
    public static final AppletPerformanceMetric EVALUATE_SCRIPT = null;
    public static final AppletPerformanceMetric FIRST_CONTENTFUL_PAINT = null;
    public static final AppletPerformanceMetric FIRST_PAINT = null;
    public static final AppletPerformanceMetric FIRST_RENDER = null;
    public static final AppletPerformanceMetric RESOURCE_TIMING = null;
    public static final AppletPerformanceMetric ROUTE = null;
    public static final /* synthetic */ AppletPerformanceMetric[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final AppletPerformanceEntryType entryType;
    private final String value;

    public static EnumEntries<AppletPerformanceMetric> getEntries() {
        return b;
    }

    static {
        AppletPerformanceEntryType r1 = AppletPerformanceEntryType.NAVIGATION;
        AppletPerformanceMetric r0 = new AppletPerformanceMetric("APP_LAUNCH", 0, "appLaunch", r1);
        APP_LAUNCH = r0;
        AppletPerformanceMetric r10 = new AppletPerformanceMetric("ROUTE", 1, "route", r1);
        ROUTE = r10;
        AppletPerformanceEntryType r11 = AppletPerformanceEntryType.RENDER;
        AppletPerformanceMetric r12 = new AppletPerformanceMetric("FIRST_RENDER", 2, "firstRender", r11);
        FIRST_RENDER = r12;
        AppletPerformanceMetric r13 = new AppletPerformanceMetric("FIRST_PAINT", 3, "firstPaint", r11);
        FIRST_PAINT = r13;
        AppletPerformanceMetric r14 = new AppletPerformanceMetric("FIRST_CONTENTFUL_PAINT", 4, "firstContentfulPaint", r11);
        FIRST_CONTENTFUL_PAINT = r14;
        AppletPerformanceMetric r15 = new AppletPerformanceMetric("EVALUATE_SCRIPT", 5, "evaluateScript", AppletPerformanceEntryType.SCRIPT);
        EVALUATE_SCRIPT = r15;
        AppletPerformanceMetric r16 = new AppletPerformanceMetric("DOWNLOAD_PACKAGE", 6, "downloadPackage", AppletPerformanceEntryType.LOAD_PACKAGE);
        DOWNLOAD_PACKAGE = r16;
        AppletPerformanceMetric r17 = new AppletPerformanceMetric("RESOURCE_TIMING", 7, "resourceTiming", AppletPerformanceEntryType.RESOURCE);
        RESOURCE_TIMING = r17;
        AppletPerformanceMetric[] r18 = {r0, r10, r12, r13, r14, r15, r16, r17};
        a = r18;
        b = EnumEntriesKt.enumEntries(r18);
    }

    public static AppletPerformanceMetric[] values() {
        return (AppletPerformanceMetric[]) a.clone();
    }

    public final AppletPerformanceEntryType getEntryType() {
        return this.entryType;
    }

    public final String getValue() {
        return this.value;
    }

    public static AppletPerformanceMetric valueOf(String r1) {
        return (AppletPerformanceMetric) r27.a.a(AppletPerformanceMetric.class, r1);
    }

    public AppletPerformanceMetric(String r1, int r10, String r11, AppletPerformanceEntryType r12) {
        super(r1, r10);
        this.value = r11;
        this.entryType = r12;
    }
}
