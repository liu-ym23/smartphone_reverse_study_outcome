package com.larus.bmhome.chat.list.cell.spacer;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/chat/list/cell/spacer/SpacerAnimationState;", "", "<init>", "(Ljava/lang/String;I)V", "WAITING", "NONE", "EXPAND", "COLLAPSE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum SpacerAnimationState extends Enum<SpacerAnimationState> {
    public static final SpacerAnimationState COLLAPSE = null;
    public static final SpacerAnimationState EXPAND = null;
    public static final SpacerAnimationState NONE = null;
    public static final SpacerAnimationState WAITING = null;
    public static final /* synthetic */ SpacerAnimationState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SpacerAnimationState> getEntries() {
        return b;
    }

    static {
        SpacerAnimationState r0 = new SpacerAnimationState("WAITING", 0);
        WAITING = r0;
        SpacerAnimationState r1 = new SpacerAnimationState("NONE", 1);
        NONE = r1;
        SpacerAnimationState r3 = new SpacerAnimationState("EXPAND", 2);
        EXPAND = r3;
        SpacerAnimationState r5 = new SpacerAnimationState("COLLAPSE", 3);
        COLLAPSE = r5;
        SpacerAnimationState[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static SpacerAnimationState[] values() {
        return (SpacerAnimationState[]) a.clone();
    }

    public static SpacerAnimationState valueOf(String r1) {
        return (SpacerAnimationState) r27.a.a(SpacerAnimationState.class, r1);
    }

    public SpacerAnimationState(String r1, int r2) {
        super(r1, r2);
    }
}
