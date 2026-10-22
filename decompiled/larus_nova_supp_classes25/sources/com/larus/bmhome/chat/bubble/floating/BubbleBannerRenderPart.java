package com.larus.bmhome.chat.bubble.floating;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/BubbleBannerRenderPart;", "", "<init>", "(Ljava/lang/String;I)V", "SPACER", "CONTENT", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum BubbleBannerRenderPart extends Enum<BubbleBannerRenderPart> {
    public static final BubbleBannerRenderPart CONTENT = null;
    public static final BubbleBannerRenderPart SPACER = null;
    public static final /* synthetic */ BubbleBannerRenderPart[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<BubbleBannerRenderPart> getEntries() {
        return b;
    }

    static {
        BubbleBannerRenderPart r0 = new BubbleBannerRenderPart("SPACER", 0);
        SPACER = r0;
        BubbleBannerRenderPart r1 = new BubbleBannerRenderPart("CONTENT", 1);
        CONTENT = r1;
        BubbleBannerRenderPart[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static BubbleBannerRenderPart[] values() {
        return (BubbleBannerRenderPart[]) a.clone();
    }

    public static BubbleBannerRenderPart valueOf(String r1) {
        return (BubbleBannerRenderPart) r27.a.a(BubbleBannerRenderPart.class, r1);
    }

    public BubbleBannerRenderPart(String r1, int r2) {
        super(r1, r2);
    }
}
