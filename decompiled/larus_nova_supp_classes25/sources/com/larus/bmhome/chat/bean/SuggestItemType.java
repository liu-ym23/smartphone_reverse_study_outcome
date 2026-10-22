package com.larus.bmhome.chat.bean;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/bean/SuggestItemType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "VideoRichMediaWelcomeBack", "ArticleRichMediaWelcomeBack", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum SuggestItemType extends Enum<SuggestItemType> {
    public static final SuggestItemType ArticleRichMediaWelcomeBack = null;
    public static final SuggestItemType VideoRichMediaWelcomeBack = null;
    public static final /* synthetic */ SuggestItemType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<SuggestItemType> getEntries() {
        return b;
    }

    static {
        SuggestItemType r0 = new SuggestItemType("VideoRichMediaWelcomeBack", 0, 150);
        VideoRichMediaWelcomeBack = r0;
        SuggestItemType r1 = new SuggestItemType("ArticleRichMediaWelcomeBack", 1, 151);
        ArticleRichMediaWelcomeBack = r1;
        SuggestItemType[] r2 = {r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static SuggestItemType[] values() {
        return (SuggestItemType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SuggestItemType valueOf(String r1) {
        return (SuggestItemType) r27.a.a(SuggestItemType.class, r1);
    }

    public SuggestItemType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
