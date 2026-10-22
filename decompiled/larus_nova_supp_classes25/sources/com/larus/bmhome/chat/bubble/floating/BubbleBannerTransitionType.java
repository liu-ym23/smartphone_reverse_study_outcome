package com.larus.bmhome.chat.bubble.floating;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/BubbleBannerTransitionType;", "", "<init>", "(Ljava/lang/String;I)V", "ENTER", "EXIT", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum BubbleBannerTransitionType extends Enum<BubbleBannerTransitionType> {
    public static final BubbleBannerTransitionType ENTER = null;
    public static final BubbleBannerTransitionType EXIT = null;
    public static final /* synthetic */ BubbleBannerTransitionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<BubbleBannerTransitionType> getEntries() {
        return b;
    }

    static {
        BubbleBannerTransitionType r0 = new BubbleBannerTransitionType("ENTER", 0);
        ENTER = r0;
        BubbleBannerTransitionType r1 = new BubbleBannerTransitionType("EXIT", 1);
        EXIT = r1;
        BubbleBannerTransitionType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static BubbleBannerTransitionType[] values() {
        return (BubbleBannerTransitionType[]) a.clone();
    }

    public static BubbleBannerTransitionType valueOf(String r1) {
        return (BubbleBannerTransitionType) r27.a.a(BubbleBannerTransitionType.class, r1);
    }

    public BubbleBannerTransitionType(String r1, int r2) {
        super(r1, r2);
    }
}
