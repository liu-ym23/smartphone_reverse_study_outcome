package com.bytedance.ai.api.model.view;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/api/model/view/WidgetEvent;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum WidgetEvent extends Enum<WidgetEvent> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WidgetEvent f1707a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ WidgetEvent[] f1708b = null;

    static {
        WidgetEvent r5 = new WidgetEvent("SCROLL_TO_BOTTOM", 0);
        WidgetEvent r10 = new WidgetEvent("PAGE_UPDATE", 1);
        f1707a = r10;
        WidgetEvent[] r11 = {r5, r10, new WidgetEvent("TIMING_SETUP", 2)};
        f1708b = r11;
        EnumEntriesKt.enumEntries(r11);
    }

    public WidgetEvent(String r5, int r10) {
        super(r5, r10);
    }

    public static WidgetEvent valueOf(String r5) {
        return (WidgetEvent) Enum.valueOf(WidgetEvent.class, r5);
    }

    public static WidgetEvent[] values() {
        return (WidgetEvent[]) f1708b.clone();
    }
}
