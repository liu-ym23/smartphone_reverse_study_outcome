package com.larus.bmhome.actionbar.util;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/actionbar/util/ActionBarSendMsgReplyFormat;", "", "<init>", "(Ljava/lang/String;I)V", "REPLICA_REPLY", "REPLICA_GENERATING", "instruction_core_api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum ActionBarSendMsgReplyFormat extends Enum<ActionBarSendMsgReplyFormat> {
    public static final ActionBarSendMsgReplyFormat REPLICA_GENERATING = null;
    public static final ActionBarSendMsgReplyFormat REPLICA_REPLY = null;
    public static final /* synthetic */ ActionBarSendMsgReplyFormat[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ActionBarSendMsgReplyFormat> getEntries() {
        return b;
    }

    static {
        ActionBarSendMsgReplyFormat r0 = new ActionBarSendMsgReplyFormat("REPLICA_REPLY", 0);
        REPLICA_REPLY = r0;
        ActionBarSendMsgReplyFormat r1 = new ActionBarSendMsgReplyFormat("REPLICA_GENERATING", 1);
        REPLICA_GENERATING = r1;
        ActionBarSendMsgReplyFormat[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ActionBarSendMsgReplyFormat[] values() {
        return (ActionBarSendMsgReplyFormat[]) a.clone();
    }

    public static ActionBarSendMsgReplyFormat valueOf(String r1) {
        return (ActionBarSendMsgReplyFormat) r27.a.a(ActionBarSendMsgReplyFormat.class, r1);
    }

    public ActionBarSendMsgReplyFormat(String r1, int r2) {
        super(r1, r2);
    }
}
