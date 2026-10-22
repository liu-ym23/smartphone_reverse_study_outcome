package com.larus.bmhome.chat.markdown.richtext;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/markdown/richtext/MessageFileKind;", "", "<init>", "(Ljava/lang/String;I)V", "FILE", "DIRECTORY", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum MessageFileKind extends Enum<MessageFileKind> {
    public static final MessageFileKind DIRECTORY = null;
    public static final MessageFileKind FILE = null;
    public static final /* synthetic */ MessageFileKind[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MessageFileKind> getEntries() {
        return b;
    }

    static {
        MessageFileKind r0 = new MessageFileKind("FILE", 0);
        FILE = r0;
        MessageFileKind r1 = new MessageFileKind("DIRECTORY", 1);
        DIRECTORY = r1;
        MessageFileKind[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static MessageFileKind[] values() {
        return (MessageFileKind[]) a.clone();
    }

    public static MessageFileKind valueOf(String r1) {
        return (MessageFileKind) r27.a.a(MessageFileKind.class, r1);
    }

    public MessageFileKind(String r1, int r2) {
        super(r1, r2);
    }
}
