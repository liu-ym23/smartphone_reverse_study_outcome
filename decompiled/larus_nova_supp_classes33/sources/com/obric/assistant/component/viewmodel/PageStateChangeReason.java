package com.obric.assistant.component.viewmodel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/component/viewmodel/PageStateChangeReason;", "", "<init>", "(Ljava/lang/String;I)V", "OTHER", "PANEL_RESHOW", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PageStateChangeReason extends Enum<PageStateChangeReason> {
    public static final PageStateChangeReason OTHER = null;
    public static final PageStateChangeReason PANEL_RESHOW = null;
    public static final /* synthetic */ PageStateChangeReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PageStateChangeReason> getEntries() {
        return b;
    }

    static {
        PageStateChangeReason r0 = new PageStateChangeReason("OTHER", 0);
        OTHER = r0;
        PageStateChangeReason r1 = new PageStateChangeReason("PANEL_RESHOW", 1);
        PANEL_RESHOW = r1;
        PageStateChangeReason[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static PageStateChangeReason[] values() {
        return (PageStateChangeReason[]) a.clone();
    }

    public static PageStateChangeReason valueOf(String r1) {
        return (PageStateChangeReason) a.a(PageStateChangeReason.class, r1);
    }

    public PageStateChangeReason(String r1, int r2) {
        super(r1, r2);
    }
}
