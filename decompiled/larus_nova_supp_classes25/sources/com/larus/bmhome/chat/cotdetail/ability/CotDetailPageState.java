package com.larus.bmhome.chat.cotdetail.ability;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/cotdetail/ability/CotDetailPageState;", "", "<init>", "(Ljava/lang/String;I)V", "Loading", "Failed", "Success", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum CotDetailPageState extends Enum<CotDetailPageState> {
    public static final CotDetailPageState Failed = null;
    public static final CotDetailPageState Loading = null;
    public static final CotDetailPageState Success = null;
    public static final /* synthetic */ CotDetailPageState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CotDetailPageState> getEntries() {
        return b;
    }

    static {
        CotDetailPageState r0 = new CotDetailPageState("Loading", 0);
        Loading = r0;
        CotDetailPageState r1 = new CotDetailPageState("Failed", 1);
        Failed = r1;
        CotDetailPageState r3 = new CotDetailPageState("Success", 2);
        Success = r3;
        CotDetailPageState[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static CotDetailPageState[] values() {
        return (CotDetailPageState[]) a.clone();
    }

    public static CotDetailPageState valueOf(String r1) {
        return (CotDetailPageState) a.a(CotDetailPageState.class, r1);
    }

    public CotDetailPageState(String r1, int r2) {
        super(r1, r2);
    }
}
