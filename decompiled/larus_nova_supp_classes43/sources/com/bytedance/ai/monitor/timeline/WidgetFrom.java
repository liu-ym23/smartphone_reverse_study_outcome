package com.bytedance.ai.monitor.timeline;

import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ai/monitor/timeline/WidgetFrom;", "", a.KEY_FROM, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getFrom", "()Ljava/lang/String;", "NEW", "HISTORY", "MIXTURE", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WidgetFrom extends Enum<WidgetFrom> {
    public static final WidgetFrom HISTORY = null;
    public static final WidgetFrom MIXTURE = null;
    public static final WidgetFrom NEW = null;
    public static final /* synthetic */ WidgetFrom[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String from;

    public static EnumEntries<WidgetFrom> getEntries() {
        return b;
    }

    static {
        WidgetFrom r0 = new WidgetFrom("NEW", 0, "new");
        NEW = r0;
        WidgetFrom r1 = new WidgetFrom("HISTORY", 1, "history");
        HISTORY = r1;
        WidgetFrom r10 = new WidgetFrom("MIXTURE", 2, "mixture");
        MIXTURE = r10;
        WidgetFrom[] r11 = {r0, r1, r10};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static WidgetFrom[] values() {
        return (WidgetFrom[]) a.clone();
    }

    public final String getFrom() {
        return this.from;
    }

    public static WidgetFrom valueOf(String r1) {
        return (WidgetFrom) r27.a.a(WidgetFrom.class, r1);
    }

    public WidgetFrom(String r1, int r10, String r11) {
        super(r1, r10);
        this.from = r11;
    }
}
