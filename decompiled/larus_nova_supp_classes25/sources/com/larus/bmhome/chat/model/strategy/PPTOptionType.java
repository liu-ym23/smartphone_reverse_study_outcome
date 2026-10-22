package com.larus.bmhome.chat.model.strategy;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/chat/model/strategy/PPTOptionType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "UNKNOWN", "PAGE_SIZE", "TEMPLATE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum PPTOptionType extends Enum<PPTOptionType> {
    public static final PPTOptionType PAGE_SIZE = null;
    public static final PPTOptionType TEMPLATE = null;
    public static final PPTOptionType UNKNOWN = null;
    public static final /* synthetic */ PPTOptionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int type;

    public static EnumEntries<PPTOptionType> getEntries() {
        return b;
    }

    static {
        PPTOptionType r0 = new PPTOptionType("UNKNOWN", 0, -1);
        UNKNOWN = r0;
        PPTOptionType r1 = new PPTOptionType("PAGE_SIZE", 1, 0);
        PAGE_SIZE = r1;
        PPTOptionType r2 = new PPTOptionType("TEMPLATE", 2, 1);
        TEMPLATE = r2;
        PPTOptionType[] r5 = {r0, r1, r2};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static PPTOptionType[] values() {
        return (PPTOptionType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static PPTOptionType valueOf(String r1) {
        return (PPTOptionType) r27.a.a(PPTOptionType.class, r1);
    }

    public PPTOptionType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
