package com.larus.bmhome.ability;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/ability/FloatChatWindowEventType;", "", "from", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getFrom", "()Ljava/lang/String;", "Init", "SendSuccess", "ManualDragUp", "ManualDragDown", "AnswerIntent", "RefreshPageIntent", "MaskClick", "BackPress", "Rebound", "ExternalRequest", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum FloatChatWindowEventType extends Enum<FloatChatWindowEventType> {
    public static final FloatChatWindowEventType AnswerIntent = null;
    public static final FloatChatWindowEventType BackPress = null;
    public static final FloatChatWindowEventType ExternalRequest = null;
    public static final FloatChatWindowEventType Init = null;
    public static final FloatChatWindowEventType ManualDragDown = null;
    public static final FloatChatWindowEventType ManualDragUp = null;
    public static final FloatChatWindowEventType MaskClick = null;
    public static final FloatChatWindowEventType Rebound = null;
    public static final FloatChatWindowEventType RefreshPageIntent = null;
    public static final FloatChatWindowEventType SendSuccess = null;
    public static final /* synthetic */ FloatChatWindowEventType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String from;

    public static EnumEntries<FloatChatWindowEventType> getEntries() {
        return b;
    }

    static {
        FloatChatWindowEventType r0 = new FloatChatWindowEventType("Init", 0, "init");
        Init = r0;
        FloatChatWindowEventType r1 = new FloatChatWindowEventType("SendSuccess", 1, "send_success");
        SendSuccess = r1;
        FloatChatWindowEventType r2 = new FloatChatWindowEventType("ManualDragUp", 2, "manual_drag_up");
        ManualDragUp = r2;
        FloatChatWindowEventType r4 = new FloatChatWindowEventType("ManualDragDown", 3, "manual_drag_down");
        ManualDragDown = r4;
        FloatChatWindowEventType r6 = new FloatChatWindowEventType("AnswerIntent", 4, "answer_intent");
        AnswerIntent = r6;
        FloatChatWindowEventType r8 = new FloatChatWindowEventType("RefreshPageIntent", 5, "refresh_page_intent");
        RefreshPageIntent = r8;
        FloatChatWindowEventType r10 = new FloatChatWindowEventType("MaskClick", 6, "mask_click");
        MaskClick = r10;
        FloatChatWindowEventType r12 = new FloatChatWindowEventType("BackPress", 7, "back_press");
        BackPress = r12;
        FloatChatWindowEventType r14 = new FloatChatWindowEventType("Rebound", 8, "rebound");
        Rebound = r14;
        FloatChatWindowEventType r13 = new FloatChatWindowEventType("ExternalRequest", 9, "external_request");
        ExternalRequest = r13;
        FloatChatWindowEventType[] r11 = {r0, r1, r2, r4, r6, r8, r10, r12, r14, r13};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static FloatChatWindowEventType[] values() {
        return (FloatChatWindowEventType[]) a.clone();
    }

    public final String getFrom() {
        return this.from;
    }

    public static FloatChatWindowEventType valueOf(String r1) {
        return (FloatChatWindowEventType) a.a(FloatChatWindowEventType.class, r1);
    }

    public FloatChatWindowEventType(String r1, int r2, String r3) {
        super(r1, r2);
        this.from = r3;
    }
}
