package com.larus.bmhome.chat.cell.slot;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/chat/cell/slot/MessageBottomExtActionType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "JUMP_DEEP_THINK", "FORCE_DEEP_THINK", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum MessageBottomExtActionType extends Enum<MessageBottomExtActionType> {
    public static final MessageBottomExtActionType FORCE_DEEP_THINK = null;
    public static final MessageBottomExtActionType JUMP_DEEP_THINK = null;
    public static final MessageBottomExtActionType UNKNOWN = null;
    public static final /* synthetic */ MessageBottomExtActionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<MessageBottomExtActionType> getEntries() {
        return b;
    }

    static {
        MessageBottomExtActionType r0 = new MessageBottomExtActionType("UNKNOWN", 0, -1);
        UNKNOWN = r0;
        MessageBottomExtActionType r1 = new MessageBottomExtActionType("JUMP_DEEP_THINK", 1, 1);
        JUMP_DEEP_THINK = r1;
        MessageBottomExtActionType r2 = new MessageBottomExtActionType("FORCE_DEEP_THINK", 2, 2);
        FORCE_DEEP_THINK = r2;
        MessageBottomExtActionType[] r5 = {r0, r1, r2};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static MessageBottomExtActionType[] values() {
        return (MessageBottomExtActionType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MessageBottomExtActionType valueOf(String r1) {
        return (MessageBottomExtActionType) r27.a.a(MessageBottomExtActionType.class, r1);
    }

    public MessageBottomExtActionType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
