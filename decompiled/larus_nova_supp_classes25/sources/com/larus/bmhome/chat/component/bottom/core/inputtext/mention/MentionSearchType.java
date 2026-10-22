package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionSearchType;", "", "protocolValue", "", "<init>", "(Ljava/lang/String;II)V", "getProtocolValue", "()I", "MENTION", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
final enum MentionSearchType extends Enum<MentionSearchType> {
    public static final MentionSearchType MENTION = null;
    public static final /* synthetic */ MentionSearchType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int protocolValue;

    public static EnumEntries<MentionSearchType> getEntries() {
        return b;
    }

    static {
        MentionSearchType r0 = new MentionSearchType();
        MENTION = r0;
        MentionSearchType[] r1 = {r0};
        a = r1;
        b = EnumEntriesKt.enumEntries(r1);
    }

    public MentionSearchType() {
        super("MENTION", 0);
        this.protocolValue = 3;
    }

    public static MentionSearchType[] values() {
        return (MentionSearchType[]) a.clone();
    }

    public final int getProtocolValue() {
        return this.protocolValue;
    }

    public static MentionSearchType valueOf(String r1) {
        return (MentionSearchType) r27.a.a(MentionSearchType.class, r1);
    }
}
