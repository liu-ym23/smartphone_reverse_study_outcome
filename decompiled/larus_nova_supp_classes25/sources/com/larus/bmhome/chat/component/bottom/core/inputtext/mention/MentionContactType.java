package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionContactType;", "", "protocolValue", "", "<init>", "(Ljava/lang/String;II)V", "getProtocolValue", "()I", "USER", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
final enum MentionContactType extends Enum<MentionContactType> {
    public static final MentionContactType USER = null;
    public static final /* synthetic */ MentionContactType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int protocolValue;

    public static EnumEntries<MentionContactType> getEntries() {
        return b;
    }

    static {
        MentionContactType r0 = new MentionContactType();
        USER = r0;
        MentionContactType[] r1 = {r0};
        a = r1;
        b = EnumEntriesKt.enumEntries(r1);
    }

    public MentionContactType() {
        super("USER", 0);
        this.protocolValue = 1;
    }

    public static MentionContactType[] values() {
        return (MentionContactType[]) a.clone();
    }

    public final int getProtocolValue() {
        return this.protocolValue;
    }

    public static MentionContactType valueOf(String r1) {
        return (MentionContactType) r27.a.a(MentionContactType.class, r1);
    }
}
