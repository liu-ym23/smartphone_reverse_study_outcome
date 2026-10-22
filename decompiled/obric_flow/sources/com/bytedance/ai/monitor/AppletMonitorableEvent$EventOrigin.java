package com.bytedance.ai.monitor;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/ai/monitor/AppletMonitorableEvent$EventOrigin", "", "Lcom/bytedance/ai/monitor/AppletMonitorableEvent$EventOrigin;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum AppletMonitorableEvent$EventOrigin extends Enum<AppletMonitorableEvent$EventOrigin> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppletMonitorableEvent$EventOrigin f2384a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AppletMonitorableEvent$EventOrigin f2385b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AppletMonitorableEvent$EventOrigin f2386c = null;
    public static final AppletMonitorableEvent$EventOrigin d = null;
    public static final /* synthetic */ AppletMonitorableEvent$EventOrigin[] e = null;

    static {
        AppletMonitorableEvent$EventOrigin r5 = new AppletMonitorableEvent$EventOrigin("Unknown", 0);
        f2384a = r5;
        AppletMonitorableEvent$EventOrigin r10 = new AppletMonitorableEvent$EventOrigin("Native", 1);
        f2385b = r10;
        AppletMonitorableEvent$EventOrigin r11 = new AppletMonitorableEvent$EventOrigin("MainJS", 2);
        f2386c = r11;
        AppletMonitorableEvent$EventOrigin r12 = new AppletMonitorableEvent$EventOrigin("UI", 3);
        d = r12;
        AppletMonitorableEvent$EventOrigin[] r13 = {r5, r10, r11, r12};
        e = r13;
        EnumEntriesKt.enumEntries(r13);
    }

    public AppletMonitorableEvent$EventOrigin(String r5, int r10) {
        super(r5, r10);
    }

    public static AppletMonitorableEvent$EventOrigin valueOf(String r5) {
        return (AppletMonitorableEvent$EventOrigin) Enum.valueOf(AppletMonitorableEvent$EventOrigin.class, r5);
    }

    public static AppletMonitorableEvent$EventOrigin[] values() {
        return (AppletMonitorableEvent$EventOrigin[]) e.clone();
    }
}
