package com.bytedance.ai.monitor.timeline;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/monitor/timeline/WidgetFrom;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum WidgetFrom extends Enum<WidgetFrom> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WidgetFrom[] f2395a = null;

    static {
        WidgetFrom[] r5 = {new WidgetFrom("NEW", 0, "new"), new WidgetFrom("HISTORY", 1, "history"), new WidgetFrom("MIXTURE", 2, "mixture")};
        f2395a = r5;
        EnumEntriesKt.enumEntries(r5);
    }

    public WidgetFrom(String r5, int r10, String r11) {
        super(r5, r10);
    }

    public static WidgetFrom valueOf(String r5) {
        return (WidgetFrom) Enum.valueOf(WidgetFrom.class, r5);
    }

    public static WidgetFrom[] values() {
        return (WidgetFrom[]) f2395a.clone();
    }
}
