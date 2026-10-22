package com.obric.assistant.ability;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/assistant/ability/PageStateChangedReason;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "OTHER", "WINDOW_ACTION_VIEW_CLICK", "ISLAND_CLICK", "AUTO_INCREASE", "SWIPE_GESTURE_VIEW", "SWIPE_UP_VIEW", "REQUEST_UNLOCK_FAILED", "RESTORE_STATE_FROM_DISMISS", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PageStateChangedReason extends Enum<PageStateChangedReason> {
    public static final PageStateChangedReason AUTO_INCREASE = null;
    public static final PageStateChangedReason ISLAND_CLICK = null;
    public static final PageStateChangedReason OTHER = null;
    public static final PageStateChangedReason REQUEST_UNLOCK_FAILED = null;
    public static final PageStateChangedReason RESTORE_STATE_FROM_DISMISS = null;
    public static final PageStateChangedReason SWIPE_GESTURE_VIEW = null;
    public static final PageStateChangedReason SWIPE_UP_VIEW = null;
    public static final PageStateChangedReason WINDOW_ACTION_VIEW_CLICK = null;
    public static final /* synthetic */ PageStateChangedReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PageStateChangedReason> getEntries() {
        return b;
    }

    static {
        PageStateChangedReason r0 = new PageStateChangedReason("OTHER", 0);
        OTHER = r0;
        PageStateChangedReason r1 = new PageStateChangedReason("WINDOW_ACTION_VIEW_CLICK", 1);
        WINDOW_ACTION_VIEW_CLICK = r1;
        PageStateChangedReason r3 = new PageStateChangedReason("ISLAND_CLICK", 2);
        ISLAND_CLICK = r3;
        PageStateChangedReason r5 = new PageStateChangedReason("AUTO_INCREASE", 3);
        AUTO_INCREASE = r5;
        PageStateChangedReason r7 = new PageStateChangedReason("SWIPE_GESTURE_VIEW", 4);
        SWIPE_GESTURE_VIEW = r7;
        PageStateChangedReason r9 = new PageStateChangedReason("SWIPE_UP_VIEW", 5);
        SWIPE_UP_VIEW = r9;
        PageStateChangedReason r11 = new PageStateChangedReason("REQUEST_UNLOCK_FAILED", 6);
        REQUEST_UNLOCK_FAILED = r11;
        PageStateChangedReason r13 = new PageStateChangedReason("RESTORE_STATE_FROM_DISMISS", 7);
        RESTORE_STATE_FROM_DISMISS = r13;
        PageStateChangedReason[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
    }

    public static PageStateChangedReason[] values() {
        return (PageStateChangedReason[]) a.clone();
    }

    public static PageStateChangedReason valueOf(String r1) {
        return (PageStateChangedReason) a.a(PageStateChangedReason.class, r1);
    }

    public PageStateChangedReason(String r1, int r2) {
        super(r1, r2);
    }
}
