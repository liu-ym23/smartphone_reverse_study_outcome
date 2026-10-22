package com.larus.bmhome.chat.bean;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/chat/bean/PageType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "UNKNOWN", "Chat", SuggestActionType.IMAGE_TEMPLATE, SuggestActionType.VIDEO, "MUSIC_TEMPLATE", "AWEME_FEED", "AI_GENERATE", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum PageType extends Enum<PageType> {
    public static final PageType AI_GENERATE = null;
    public static final PageType AWEME_FEED = null;
    public static final PageType Chat = null;
    public static final a Companion = null;
    public static final PageType IMAGE_TEMPLATE = null;
    public static final PageType MUSIC_TEMPLATE = null;
    public static final PageType UNKNOWN = null;
    public static final PageType VIDEO = null;
    public static final /* synthetic */ PageType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int type;

    public static EnumEntries<PageType> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.bean.PageType$a] */
    static {
        PageType r0 = new PageType("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        PageType r1 = new PageType("Chat", 1, 1);
        Chat = r1;
        PageType r3 = new PageType(SuggestActionType.IMAGE_TEMPLATE, 2, 2);
        IMAGE_TEMPLATE = r3;
        PageType r5 = new PageType(SuggestActionType.VIDEO, 3, 3);
        VIDEO = r5;
        PageType r7 = new PageType("MUSIC_TEMPLATE", 4, 4);
        MUSIC_TEMPLATE = r7;
        PageType r9 = new PageType("AWEME_FEED", 5, 5);
        AWEME_FEED = r9;
        PageType r11 = new PageType("AI_GENERATE", 6, 6);
        AI_GENERATE = r11;
        PageType[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
        Companion = new a();
    }

    public static PageType[] values() {
        return (PageType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static PageType valueOf(String r1) {
        return (PageType) r27.a.a(PageType.class, r1);
    }

    public PageType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
