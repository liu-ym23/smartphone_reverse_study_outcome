package com.bytedance.ai.monitor;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/ai/monitor/AppletError$ErrorLevel", "", "Lcom/bytedance/ai/monitor/AppletError$ErrorLevel;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum AppletError$ErrorLevel extends Enum<AppletError$ErrorLevel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppletError$ErrorLevel f2376a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AppletError$ErrorLevel[] f2377b = null;

    static {
        AppletError$ErrorLevel r5 = new AppletError$ErrorLevel("Warn", 0);
        AppletError$ErrorLevel r10 = new AppletError$ErrorLevel("Error", 1);
        f2376a = r10;
        AppletError$ErrorLevel[] r11 = {r5, r10};
        f2377b = r11;
        EnumEntriesKt.enumEntries(r11);
    }

    public AppletError$ErrorLevel(String r5, int r10) {
        super(r5, r10);
    }

    public static AppletError$ErrorLevel valueOf(String r5) {
        return (AppletError$ErrorLevel) Enum.valueOf(AppletError$ErrorLevel.class, r5);
    }

    public static AppletError$ErrorLevel[] values() {
        return (AppletError$ErrorLevel[]) f2377b.clone();
    }
}
