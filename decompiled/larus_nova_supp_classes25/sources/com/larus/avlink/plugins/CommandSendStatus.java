package com.larus.avlink.plugins;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/larus/avlink/plugins/CommandSendStatus;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "INITIALIZE", "DOUBAO_RECV", "DOUBAO_SEND", "DORA_SDK", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum CommandSendStatus extends Enum<CommandSendStatus> {
    public static final a Companion = null;
    public static final CommandSendStatus DORA_SDK = null;
    public static final CommandSendStatus DOUBAO_RECV = null;
    public static final CommandSendStatus DOUBAO_SEND = null;
    public static final CommandSendStatus INITIALIZE = null;
    public static final /* synthetic */ CommandSendStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<CommandSendStatus> getEntries() {
        return b;
    }

    static {
        CommandSendStatus r0 = new CommandSendStatus("INITIALIZE", 0, "initialize");
        INITIALIZE = r0;
        CommandSendStatus r1 = new CommandSendStatus("DOUBAO_RECV", 1, "doubao_recv");
        DOUBAO_RECV = r1;
        CommandSendStatus r3 = new CommandSendStatus("DOUBAO_SEND", 2, "doubao_send");
        DOUBAO_SEND = r3;
        CommandSendStatus r5 = new CommandSendStatus("DORA_SDK", 3, "dora");
        DORA_SDK = r5;
        CommandSendStatus[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
        Companion = new a();
    }

    public static CommandSendStatus[] values() {
        return (CommandSendStatus[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static CommandSendStatus valueOf(String r1) {
        return (CommandSendStatus) r27.a.a(CommandSendStatus.class, r1);
    }

    public CommandSendStatus(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
