package com.larus.bmhome.chat.bean;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/chat/bean/ActionType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", "Redirection", "SendMessage", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum ActionType extends Enum<ActionType> {
    public static final ActionType Redirection = null;
    public static final ActionType SendMessage = null;
    public static final ActionType Unknown = null;
    public static final /* synthetic */ ActionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<ActionType> getEntries() {
        return b;
    }

    static {
        ActionType r0 = new ActionType("Unknown", 0, 0);
        Unknown = r0;
        ActionType r1 = new ActionType("Redirection", 1, 1);
        Redirection = r1;
        ActionType r3 = new ActionType("SendMessage", 2, 2);
        SendMessage = r3;
        ActionType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ActionType[] values() {
        return (ActionType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ActionType valueOf(String r1) {
        return (ActionType) r27.a.a(ActionType.class, r1);
    }

    public ActionType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
