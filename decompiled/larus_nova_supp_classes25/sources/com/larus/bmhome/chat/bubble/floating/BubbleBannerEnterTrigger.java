package com.larus.bmhome.chat.bubble.floating;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/BubbleBannerEnterTrigger;", "", "<init>", "(Ljava/lang/String;I)V", "CONTAINER_READY", "SPACER_READY", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum BubbleBannerEnterTrigger extends Enum<BubbleBannerEnterTrigger> {
    public static final BubbleBannerEnterTrigger CONTAINER_READY = null;
    public static final BubbleBannerEnterTrigger SPACER_READY = null;
    public static final /* synthetic */ BubbleBannerEnterTrigger[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<BubbleBannerEnterTrigger> getEntries() {
        return b;
    }

    static {
        BubbleBannerEnterTrigger r0 = new BubbleBannerEnterTrigger("CONTAINER_READY", 0);
        CONTAINER_READY = r0;
        BubbleBannerEnterTrigger r1 = new BubbleBannerEnterTrigger("SPACER_READY", 1);
        SPACER_READY = r1;
        BubbleBannerEnterTrigger[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static BubbleBannerEnterTrigger[] values() {
        return (BubbleBannerEnterTrigger[]) a.clone();
    }

    public static BubbleBannerEnterTrigger valueOf(String r1) {
        return (BubbleBannerEnterTrigger) r27.a.a(BubbleBannerEnterTrigger.class, r1);
    }

    public BubbleBannerEnterTrigger(String r1, int r2) {
        super(r1, r2);
    }
}
