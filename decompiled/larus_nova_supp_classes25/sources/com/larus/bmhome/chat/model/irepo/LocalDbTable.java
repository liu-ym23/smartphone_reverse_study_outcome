package com.larus.bmhome.chat.model.irepo;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/chat/model/irepo/LocalDbTable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "TABLE_BOT", "TABLE_CHAT", "TABLE_CVS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum LocalDbTable extends Enum<LocalDbTable> {
    public static final LocalDbTable TABLE_BOT = null;
    public static final LocalDbTable TABLE_CHAT = null;
    public static final LocalDbTable TABLE_CVS = null;
    public static final /* synthetic */ LocalDbTable[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<LocalDbTable> getEntries() {
        return b;
    }

    static {
        LocalDbTable r0 = new LocalDbTable("TABLE_BOT", 0, "bot");
        TABLE_BOT = r0;
        LocalDbTable r1 = new LocalDbTable("TABLE_CHAT", 1, "chat");
        TABLE_CHAT = r1;
        LocalDbTable r2 = new LocalDbTable("TABLE_CVS", 2, "conversation");
        TABLE_CVS = r2;
        LocalDbTable[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static LocalDbTable[] values() {
        return (LocalDbTable[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static LocalDbTable valueOf(String r1) {
        return (LocalDbTable) a.a(LocalDbTable.class, r1);
    }

    public LocalDbTable(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
