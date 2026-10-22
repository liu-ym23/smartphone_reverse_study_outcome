package com.bytedance.ai.api.model.view;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/api/model/view/WidgetEvent;", "", "<init>", "(Ljava/lang/String;I)V", "SCROLL_TO_BOTTOM", "PAGE_UPDATE", "TIMING_SETUP", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WidgetEvent extends Enum<WidgetEvent> {
    public static final WidgetEvent PAGE_UPDATE = null;
    public static final WidgetEvent SCROLL_TO_BOTTOM = null;
    public static final WidgetEvent TIMING_SETUP = null;
    public static final /* synthetic */ WidgetEvent[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<WidgetEvent> getEntries() {
        return b;
    }

    static {
        WidgetEvent r0 = new WidgetEvent("SCROLL_TO_BOTTOM", 0);
        SCROLL_TO_BOTTOM = r0;
        WidgetEvent r1 = new WidgetEvent("PAGE_UPDATE", 1);
        PAGE_UPDATE = r1;
        WidgetEvent r10 = new WidgetEvent("TIMING_SETUP", 2);
        TIMING_SETUP = r10;
        WidgetEvent[] r11 = {r0, r1, r10};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static WidgetEvent[] values() {
        return (WidgetEvent[]) a.clone();
    }

    public static WidgetEvent valueOf(String r1) {
        return (WidgetEvent) a.a(WidgetEvent.class, r1);
    }

    public WidgetEvent(String r1, int r10) {
        super(r1, r10);
    }
}
