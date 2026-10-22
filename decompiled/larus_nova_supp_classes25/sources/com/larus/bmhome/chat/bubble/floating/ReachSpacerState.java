package com.larus.bmhome.chat.bubble.floating;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/ReachSpacerState;", "", "<init>", "(Ljava/lang/String;I)V", "WAITING", "ENTERING", "VISIBLE", "EXITING", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum ReachSpacerState extends Enum<ReachSpacerState> {
    public static final ReachSpacerState ENTERING = null;
    public static final ReachSpacerState EXITING = null;
    public static final ReachSpacerState VISIBLE = null;
    public static final ReachSpacerState WAITING = null;
    public static final /* synthetic */ ReachSpacerState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ReachSpacerState> getEntries() {
        return b;
    }

    static {
        ReachSpacerState r0 = new ReachSpacerState("WAITING", 0);
        WAITING = r0;
        ReachSpacerState r1 = new ReachSpacerState("ENTERING", 1);
        ENTERING = r1;
        ReachSpacerState r3 = new ReachSpacerState("VISIBLE", 2);
        VISIBLE = r3;
        ReachSpacerState r5 = new ReachSpacerState("EXITING", 3);
        EXITING = r5;
        ReachSpacerState[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static ReachSpacerState[] values() {
        return (ReachSpacerState[]) a.clone();
    }

    public static ReachSpacerState valueOf(String r1) {
        return (ReachSpacerState) r27.a.a(ReachSpacerState.class, r1);
    }

    public ReachSpacerState(String r1, int r2) {
        super(r1, r2);
    }
}
