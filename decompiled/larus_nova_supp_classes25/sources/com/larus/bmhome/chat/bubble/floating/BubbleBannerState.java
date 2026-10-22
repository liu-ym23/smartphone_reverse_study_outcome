package com.larus.bmhome.chat.bubble.floating;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/BubbleBannerState;", "", "<init>", "(Ljava/lang/String;I)V", "RECEIVED", "RESOLVED", "ENTERING", "VISIBLE", "EXITING", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum BubbleBannerState extends Enum<BubbleBannerState> {
    public static final BubbleBannerState ENTERING = null;
    public static final BubbleBannerState EXITING = null;
    public static final BubbleBannerState RECEIVED = null;
    public static final BubbleBannerState RESOLVED = null;
    public static final BubbleBannerState VISIBLE = null;
    public static final /* synthetic */ BubbleBannerState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<BubbleBannerState> getEntries() {
        return b;
    }

    static {
        BubbleBannerState r0 = new BubbleBannerState("RECEIVED", 0);
        RECEIVED = r0;
        BubbleBannerState r1 = new BubbleBannerState("RESOLVED", 1);
        RESOLVED = r1;
        BubbleBannerState r3 = new BubbleBannerState("ENTERING", 2);
        ENTERING = r3;
        BubbleBannerState r5 = new BubbleBannerState("VISIBLE", 3);
        VISIBLE = r5;
        BubbleBannerState r7 = new BubbleBannerState("EXITING", 4);
        EXITING = r7;
        BubbleBannerState[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static BubbleBannerState[] values() {
        return (BubbleBannerState[]) a.clone();
    }

    public static BubbleBannerState valueOf(String r1) {
        return (BubbleBannerState) r27.a.a(BubbleBannerState.class, r1);
    }

    public BubbleBannerState(String r1, int r2) {
        super(r1, r2);
    }
}
