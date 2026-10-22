package com.larus.ugc.feed.impl.quickmenu;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/ugc/feed/impl/quickmenu/DismissReason;", "", "<init>", "(Ljava/lang/String;I)V", "CANCEL_BUTTON", "ITEM_CLICK", "OUTSIDE_TOUCH", "BACK_PRESS", "PROGRAMMATIC", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum DismissReason extends Enum<DismissReason> {
    public static final DismissReason BACK_PRESS = null;
    public static final DismissReason CANCEL_BUTTON = null;
    public static final DismissReason ITEM_CLICK = null;
    public static final DismissReason OUTSIDE_TOUCH = null;
    public static final DismissReason PROGRAMMATIC = null;
    public static final /* synthetic */ DismissReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DismissReason> getEntries() {
        return b;
    }

    static {
        DismissReason r0 = new DismissReason("CANCEL_BUTTON", 0);
        CANCEL_BUTTON = r0;
        DismissReason r1 = new DismissReason("ITEM_CLICK", 1);
        ITEM_CLICK = r1;
        DismissReason r3 = new DismissReason("OUTSIDE_TOUCH", 2);
        OUTSIDE_TOUCH = r3;
        DismissReason r5 = new DismissReason("BACK_PRESS", 3);
        BACK_PRESS = r5;
        DismissReason r7 = new DismissReason("PROGRAMMATIC", 4);
        PROGRAMMATIC = r7;
        DismissReason[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static DismissReason[] values() {
        return (DismissReason[]) a.clone();
    }

    public static DismissReason valueOf(String r1) {
        return (DismissReason) r27.a.a(DismissReason.class, r1);
    }

    public DismissReason(String r1, int r2) {
        super(r1, r2);
    }
}
