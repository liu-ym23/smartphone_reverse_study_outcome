package com.larus.bmhome.ability;

import com.larus.bmhome.chat.bean.SuggestActionType;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/ability/MessageMonitorItemType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "IMAGE", SuggestActionType.VIDEO, "LINK", "LYNX", "POTENTIAL_FORMULA", "POTENTIAL_TABLE", "POTENTIAL_BOLD", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum MessageMonitorItemType extends Enum<MessageMonitorItemType> {
    public static final MessageMonitorItemType IMAGE = null;
    public static final MessageMonitorItemType LINK = null;
    public static final MessageMonitorItemType LYNX = null;
    public static final MessageMonitorItemType POTENTIAL_BOLD = null;
    public static final MessageMonitorItemType POTENTIAL_FORMULA = null;
    public static final MessageMonitorItemType POTENTIAL_TABLE = null;
    public static final MessageMonitorItemType VIDEO = null;
    public static final /* synthetic */ MessageMonitorItemType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<MessageMonitorItemType> getEntries() {
        return b;
    }

    static {
        MessageMonitorItemType r0 = new MessageMonitorItemType("IMAGE", 0, "image");
        IMAGE = r0;
        MessageMonitorItemType r1 = new MessageMonitorItemType(SuggestActionType.VIDEO, 1, "video");
        VIDEO = r1;
        MessageMonitorItemType r2 = new MessageMonitorItemType("LINK", 2, "link");
        LINK = r2;
        MessageMonitorItemType r4 = new MessageMonitorItemType("LYNX", 3, "lynx");
        LYNX = r4;
        MessageMonitorItemType r6 = new MessageMonitorItemType("POTENTIAL_FORMULA", 4, "potential_formula");
        POTENTIAL_FORMULA = r6;
        MessageMonitorItemType r8 = new MessageMonitorItemType("POTENTIAL_TABLE", 5, "potential_table");
        POTENTIAL_TABLE = r8;
        MessageMonitorItemType r10 = new MessageMonitorItemType("POTENTIAL_BOLD", 6, "potential_bold");
        POTENTIAL_BOLD = r10;
        MessageMonitorItemType[] r12 = {r0, r1, r2, r4, r6, r8, r10};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static MessageMonitorItemType[] values() {
        return (MessageMonitorItemType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static MessageMonitorItemType valueOf(String r1) {
        return (MessageMonitorItemType) a.a(MessageMonitorItemType.class, r1);
    }

    public MessageMonitorItemType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
