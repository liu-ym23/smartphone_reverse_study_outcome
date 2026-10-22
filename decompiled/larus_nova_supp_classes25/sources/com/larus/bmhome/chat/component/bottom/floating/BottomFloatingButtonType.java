package com.larus.bmhome.chat.component.bottom.floating;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/floating/BottomFloatingButtonType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "NONE", "FAST_SCROLL_BUTTON", "CHECK_FAST_SCROLL_BUTTON", "SHARE_LONG_IMAGE_BUTTON", "SHARE_LONG_IMAGE_BUTTON_SCROLLED", "CHECK_SHARE_LONG_IMAGE_BUTTON", "ADD_COLLECT_TIP", "LOOK_COLLECT_TIP", "BACK_CHAT_BUTTON", "VIEW_NEW_NEWS_BUTTON", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum BottomFloatingButtonType extends Enum<BottomFloatingButtonType> {
    public static final BottomFloatingButtonType ADD_COLLECT_TIP = null;
    public static final BottomFloatingButtonType BACK_CHAT_BUTTON = null;
    public static final BottomFloatingButtonType CHECK_FAST_SCROLL_BUTTON = null;
    public static final BottomFloatingButtonType CHECK_SHARE_LONG_IMAGE_BUTTON = null;
    public static final BottomFloatingButtonType FAST_SCROLL_BUTTON = null;
    public static final BottomFloatingButtonType LOOK_COLLECT_TIP = null;
    public static final BottomFloatingButtonType NONE = null;
    public static final BottomFloatingButtonType SHARE_LONG_IMAGE_BUTTON = null;
    public static final BottomFloatingButtonType SHARE_LONG_IMAGE_BUTTON_SCROLLED = null;
    public static final BottomFloatingButtonType VIEW_NEW_NEWS_BUTTON = null;
    public static final /* synthetic */ BottomFloatingButtonType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int type;

    public static EnumEntries<BottomFloatingButtonType> getEntries() {
        return b;
    }

    static {
        BottomFloatingButtonType r0 = new BottomFloatingButtonType("NONE", 0, 0);
        NONE = r0;
        BottomFloatingButtonType r1 = new BottomFloatingButtonType("FAST_SCROLL_BUTTON", 1, 1);
        FAST_SCROLL_BUTTON = r1;
        BottomFloatingButtonType r3 = new BottomFloatingButtonType("CHECK_FAST_SCROLL_BUTTON", 2, 2);
        CHECK_FAST_SCROLL_BUTTON = r3;
        BottomFloatingButtonType r5 = new BottomFloatingButtonType("SHARE_LONG_IMAGE_BUTTON", 3, 3);
        SHARE_LONG_IMAGE_BUTTON = r5;
        BottomFloatingButtonType r7 = new BottomFloatingButtonType("SHARE_LONG_IMAGE_BUTTON_SCROLLED", 4, 4);
        SHARE_LONG_IMAGE_BUTTON_SCROLLED = r7;
        BottomFloatingButtonType r9 = new BottomFloatingButtonType("CHECK_SHARE_LONG_IMAGE_BUTTON", 5, 5);
        CHECK_SHARE_LONG_IMAGE_BUTTON = r9;
        BottomFloatingButtonType r11 = new BottomFloatingButtonType("ADD_COLLECT_TIP", 6, 6);
        ADD_COLLECT_TIP = r11;
        BottomFloatingButtonType r13 = new BottomFloatingButtonType("LOOK_COLLECT_TIP", 7, 7);
        LOOK_COLLECT_TIP = r13;
        BottomFloatingButtonType r15 = new BottomFloatingButtonType("BACK_CHAT_BUTTON", 8, 8);
        BACK_CHAT_BUTTON = r15;
        BottomFloatingButtonType r14 = new BottomFloatingButtonType("VIEW_NEW_NEWS_BUTTON", 9, 9);
        VIEW_NEW_NEWS_BUTTON = r14;
        BottomFloatingButtonType[] r12 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static BottomFloatingButtonType[] values() {
        return (BottomFloatingButtonType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static BottomFloatingButtonType valueOf(String r1) {
        return (BottomFloatingButtonType) a.a(BottomFloatingButtonType.class, r1);
    }

    public BottomFloatingButtonType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
