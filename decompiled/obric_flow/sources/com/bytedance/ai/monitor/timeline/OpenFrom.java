package com.bytedance.ai.monitor.timeline;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/monitor/timeline/OpenFrom;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum OpenFrom extends Enum<OpenFrom> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OpenFrom[] f2394a = null;

    static {
        OpenFrom[] r5 = {new OpenFrom("APPLET_MAIN_OPEN", 0, "applet_main_open"), new OpenFrom("APPLET_VIEW_OPEN", 1, "applet_view_open"), new OpenFrom("OLD_APPLET_MAIN_OPEN", 2, "old_applet_main_open"), new OpenFrom("OLD_APPLET_VIEW_OPEN", 3, "old_applet_view_open"), new OpenFrom("NATIVE", 4, "native"), new OpenFrom("DEBUG", 5, "debug"), new OpenFrom("OLD_APPLET_MAIN_CREATE", 6, "applet_main_create"), new OpenFrom("OLD_APPLET_VIEW_CREATE", 7, "applet_main_create")};
        f2394a = r5;
        EnumEntriesKt.enumEntries(r5);
    }

    public OpenFrom(String r5, int r10, String r11) {
        super(r5, r10);
    }

    public static OpenFrom valueOf(String r5) {
        return (OpenFrom) Enum.valueOf(OpenFrom.class, r5);
    }

    public static OpenFrom[] values() {
        return (OpenFrom[]) f2394a.clone();
    }
}
