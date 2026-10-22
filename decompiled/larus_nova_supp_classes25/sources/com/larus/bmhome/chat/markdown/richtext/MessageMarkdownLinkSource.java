package com.larus.bmhome.chat.markdown.richtext;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/markdown/richtext/MessageMarkdownLinkSource;", "", "<init>", "(Ljava/lang/String;I)V", "MARKDOWN_LINK", "PLAIN_URL", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum MessageMarkdownLinkSource extends Enum<MessageMarkdownLinkSource> {
    public static final MessageMarkdownLinkSource MARKDOWN_LINK = null;
    public static final MessageMarkdownLinkSource PLAIN_URL = null;
    public static final /* synthetic */ MessageMarkdownLinkSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MessageMarkdownLinkSource> getEntries() {
        return b;
    }

    static {
        MessageMarkdownLinkSource r0 = new MessageMarkdownLinkSource("MARKDOWN_LINK", 0);
        MARKDOWN_LINK = r0;
        MessageMarkdownLinkSource r1 = new MessageMarkdownLinkSource("PLAIN_URL", 1);
        PLAIN_URL = r1;
        MessageMarkdownLinkSource[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static MessageMarkdownLinkSource[] values() {
        return (MessageMarkdownLinkSource[]) a.clone();
    }

    public static MessageMarkdownLinkSource valueOf(String r1) {
        return (MessageMarkdownLinkSource) r27.a.a(MessageMarkdownLinkSource.class, r1);
    }

    public MessageMarkdownLinkSource(String r1, int r2) {
        super(r1, r2);
    }
}
