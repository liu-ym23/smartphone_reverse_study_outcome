package com.larus.bmhome.chat.bubble.floating;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/BubbleBannerDismissReason;", "", "<init>", "(Ljava/lang/String;I)V", "AUTO_DISMISS", "USER_CLICK", "MANUAL", "PAGE_LEAVE", "NEW_MESSAGE", "LOWER_PRIORITY", "HOST_UNAVAILABLE", "KEYBOARD", "ACTION_BAR_ITEM_CLICK", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum BubbleBannerDismissReason extends Enum<BubbleBannerDismissReason> {
    public static final BubbleBannerDismissReason ACTION_BAR_ITEM_CLICK = null;
    public static final BubbleBannerDismissReason AUTO_DISMISS = null;
    public static final BubbleBannerDismissReason HOST_UNAVAILABLE = null;
    public static final BubbleBannerDismissReason KEYBOARD = null;
    public static final BubbleBannerDismissReason LOWER_PRIORITY = null;
    public static final BubbleBannerDismissReason MANUAL = null;
    public static final BubbleBannerDismissReason NEW_MESSAGE = null;
    public static final BubbleBannerDismissReason PAGE_LEAVE = null;
    public static final BubbleBannerDismissReason USER_CLICK = null;
    public static final /* synthetic */ BubbleBannerDismissReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<BubbleBannerDismissReason> getEntries() {
        return b;
    }

    static {
        BubbleBannerDismissReason r0 = new BubbleBannerDismissReason("AUTO_DISMISS", 0);
        AUTO_DISMISS = r0;
        BubbleBannerDismissReason r1 = new BubbleBannerDismissReason("USER_CLICK", 1);
        USER_CLICK = r1;
        BubbleBannerDismissReason r3 = new BubbleBannerDismissReason("MANUAL", 2);
        MANUAL = r3;
        BubbleBannerDismissReason r5 = new BubbleBannerDismissReason("PAGE_LEAVE", 3);
        PAGE_LEAVE = r5;
        BubbleBannerDismissReason r7 = new BubbleBannerDismissReason("NEW_MESSAGE", 4);
        NEW_MESSAGE = r7;
        BubbleBannerDismissReason r9 = new BubbleBannerDismissReason("LOWER_PRIORITY", 5);
        LOWER_PRIORITY = r9;
        BubbleBannerDismissReason r11 = new BubbleBannerDismissReason("HOST_UNAVAILABLE", 6);
        HOST_UNAVAILABLE = r11;
        BubbleBannerDismissReason r13 = new BubbleBannerDismissReason("KEYBOARD", 7);
        KEYBOARD = r13;
        BubbleBannerDismissReason r15 = new BubbleBannerDismissReason("ACTION_BAR_ITEM_CLICK", 8);
        ACTION_BAR_ITEM_CLICK = r15;
        BubbleBannerDismissReason[] r14 = {r0, r1, r3, r5, r7, r9, r11, r13, r15};
        a = r14;
        b = EnumEntriesKt.enumEntries(r14);
    }

    public static BubbleBannerDismissReason[] values() {
        return (BubbleBannerDismissReason[]) a.clone();
    }

    public static BubbleBannerDismissReason valueOf(String r1) {
        return (BubbleBannerDismissReason) r27.a.a(BubbleBannerDismissReason.class, r1);
    }

    public BubbleBannerDismissReason(String r1, int r2) {
        super(r1, r2);
    }
}
