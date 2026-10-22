package com.larus.bmhome.chat.layout.item;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/chat/layout/item/SummaryGenerateType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "Normal", "EmptyAudio", "NotCompleteSentence", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum SummaryGenerateType extends Enum<SummaryGenerateType> {
    public static final SummaryGenerateType EmptyAudio = null;
    public static final SummaryGenerateType Normal = null;
    public static final SummaryGenerateType NotCompleteSentence = null;
    public static final /* synthetic */ SummaryGenerateType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int type;

    public static EnumEntries<SummaryGenerateType> getEntries() {
        return b;
    }

    static {
        SummaryGenerateType r0 = new SummaryGenerateType("Normal", 0, 0);
        Normal = r0;
        SummaryGenerateType r1 = new SummaryGenerateType("EmptyAudio", 1, 1);
        EmptyAudio = r1;
        SummaryGenerateType r3 = new SummaryGenerateType("NotCompleteSentence", 2, 2);
        NotCompleteSentence = r3;
        SummaryGenerateType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static SummaryGenerateType[] values() {
        return (SummaryGenerateType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static SummaryGenerateType valueOf(String r1) {
        return (SummaryGenerateType) r27.a.a(SummaryGenerateType.class, r1);
    }

    public SummaryGenerateType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
