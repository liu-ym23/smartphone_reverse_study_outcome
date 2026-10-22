package com.larus.bmhome.chat.bubble.floating;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/BubbleBannerSource;", "", "<init>", "(Ljava/lang/String;I)V", "CMD", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum BubbleBannerSource extends Enum<BubbleBannerSource> {
    public static final BubbleBannerSource CMD = null;
    public static final /* synthetic */ BubbleBannerSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<BubbleBannerSource> getEntries() {
        return b;
    }

    static {
        BubbleBannerSource r0 = new BubbleBannerSource();
        CMD = r0;
        BubbleBannerSource[] r1 = {r0};
        a = r1;
        b = EnumEntriesKt.enumEntries(r1);
    }

    public BubbleBannerSource() {
        super("CMD", 0);
    }

    public static BubbleBannerSource[] values() {
        return (BubbleBannerSource[]) a.clone();
    }

    public static BubbleBannerSource valueOf(String r1) {
        return (BubbleBannerSource) r27.a.a(BubbleBannerSource.class, r1);
    }
}
