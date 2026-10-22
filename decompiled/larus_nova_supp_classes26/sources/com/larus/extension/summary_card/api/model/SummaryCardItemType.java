package com.larus.extension.summary_card.api.model;

import com.larus.bmhome.instruction.handler.InstructionHandlerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/extension/summary_card/api/model/SummaryCardItemType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", InstructionHandlerType.VIDEO, "ARTICLE", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SummaryCardItemType extends Enum<SummaryCardItemType> {
    public static final SummaryCardItemType ARTICLE = null;
    public static final SummaryCardItemType VIDEO = null;
    public static final /* synthetic */ SummaryCardItemType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<SummaryCardItemType> getEntries() {
        return b;
    }

    static {
        SummaryCardItemType r0 = new SummaryCardItemType(InstructionHandlerType.VIDEO, 0, 0);
        VIDEO = r0;
        SummaryCardItemType r1 = new SummaryCardItemType("ARTICLE", 1, 1);
        ARTICLE = r1;
        SummaryCardItemType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static SummaryCardItemType[] values() {
        return (SummaryCardItemType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SummaryCardItemType valueOf(String r1) {
        return (SummaryCardItemType) a.a(SummaryCardItemType.class, r1);
    }

    public SummaryCardItemType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
