package com.larus.bmhome.chat.office.ppt;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/office/ppt/PPTGenActionType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "AUTO_CHAT", "INTELLIGENCE_CHAT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum PPTGenActionType extends Enum<PPTGenActionType> {

    @SerializedName("0")
    public static final PPTGenActionType AUTO_CHAT = null;

    @SerializedName("1")
    public static final PPTGenActionType INTELLIGENCE_CHAT = null;
    public static final /* synthetic */ PPTGenActionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int type;

    public static EnumEntries<PPTGenActionType> getEntries() {
        return b;
    }

    static {
        PPTGenActionType r0 = new PPTGenActionType("AUTO_CHAT", 0, 0);
        AUTO_CHAT = r0;
        PPTGenActionType r1 = new PPTGenActionType("INTELLIGENCE_CHAT", 1, 1);
        INTELLIGENCE_CHAT = r1;
        PPTGenActionType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static PPTGenActionType[] values() {
        return (PPTGenActionType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static PPTGenActionType valueOf(String r1) {
        return (PPTGenActionType) a.a(PPTGenActionType.class, r1);
    }

    public PPTGenActionType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
