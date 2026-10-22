package com.larus.bmhome.chat.component.bottom.floating;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/floating/BottomFloatingButtonAction;", "", "action", "", "<init>", "(Ljava/lang/String;II)V", "getAction", "()I", "SCROLL_UP", "SCROLL_DOWN", "SCREENSHOT", "AUTO_HIDE", "SHOW_ADD_COLLECT_TIP", "SHOW_LOOK_COLLECT_TIP", "BACK_CHAT", "HIDE_BACK_CHAT", "VIEW_NEW_NEWS", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum BottomFloatingButtonAction extends Enum<BottomFloatingButtonAction> {
    public static final BottomFloatingButtonAction AUTO_HIDE = null;
    public static final BottomFloatingButtonAction BACK_CHAT = null;
    public static final BottomFloatingButtonAction HIDE_BACK_CHAT = null;
    public static final BottomFloatingButtonAction SCREENSHOT = null;
    public static final BottomFloatingButtonAction SCROLL_DOWN = null;
    public static final BottomFloatingButtonAction SCROLL_UP = null;
    public static final BottomFloatingButtonAction SHOW_ADD_COLLECT_TIP = null;
    public static final BottomFloatingButtonAction SHOW_LOOK_COLLECT_TIP = null;
    public static final BottomFloatingButtonAction VIEW_NEW_NEWS = null;
    public static final /* synthetic */ BottomFloatingButtonAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int action;

    public static EnumEntries<BottomFloatingButtonAction> getEntries() {
        return b;
    }

    static {
        BottomFloatingButtonAction r0 = new BottomFloatingButtonAction("SCROLL_UP", 0, 1);
        SCROLL_UP = r0;
        BottomFloatingButtonAction r1 = new BottomFloatingButtonAction("SCROLL_DOWN", 1, 2);
        SCROLL_DOWN = r1;
        BottomFloatingButtonAction r4 = new BottomFloatingButtonAction("SCREENSHOT", 2, 3);
        SCREENSHOT = r4;
        BottomFloatingButtonAction r6 = new BottomFloatingButtonAction("AUTO_HIDE", 3, 4);
        AUTO_HIDE = r6;
        BottomFloatingButtonAction r8 = new BottomFloatingButtonAction("SHOW_ADD_COLLECT_TIP", 4, 5);
        SHOW_ADD_COLLECT_TIP = r8;
        BottomFloatingButtonAction r10 = new BottomFloatingButtonAction("SHOW_LOOK_COLLECT_TIP", 5, 6);
        SHOW_LOOK_COLLECT_TIP = r10;
        BottomFloatingButtonAction r12 = new BottomFloatingButtonAction("BACK_CHAT", 6, 7);
        BACK_CHAT = r12;
        BottomFloatingButtonAction r14 = new BottomFloatingButtonAction("HIDE_BACK_CHAT", 7, 8);
        HIDE_BACK_CHAT = r14;
        BottomFloatingButtonAction r13 = new BottomFloatingButtonAction("VIEW_NEW_NEWS", 8, 9);
        VIEW_NEW_NEWS = r13;
        BottomFloatingButtonAction[] r9 = {r0, r1, r4, r6, r8, r10, r12, r14, r13};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static BottomFloatingButtonAction[] values() {
        return (BottomFloatingButtonAction[]) a.clone();
    }

    public final int getAction() {
        return this.action;
    }

    public static BottomFloatingButtonAction valueOf(String r1) {
        return (BottomFloatingButtonAction) a.a(BottomFloatingButtonAction.class, r1);
    }

    public BottomFloatingButtonAction(String r1, int r2, int r3) {
        super(r1, r2);
        this.action = r3;
    }
}
