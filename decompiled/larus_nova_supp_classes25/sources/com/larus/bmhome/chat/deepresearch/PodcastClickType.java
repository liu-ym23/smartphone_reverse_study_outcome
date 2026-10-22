package com.larus.bmhome.chat.deepresearch;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/deepresearch/PodcastClickType;", "", "<init>", "(Ljava/lang/String;I)V", "BUTTON", "ROOT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum PodcastClickType extends Enum<PodcastClickType> {
    public static final PodcastClickType BUTTON = null;
    public static final PodcastClickType ROOT = null;
    public static final /* synthetic */ PodcastClickType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PodcastClickType> getEntries() {
        return b;
    }

    static {
        PodcastClickType r0 = new PodcastClickType("BUTTON", 0);
        BUTTON = r0;
        PodcastClickType r1 = new PodcastClickType("ROOT", 1);
        ROOT = r1;
        PodcastClickType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static PodcastClickType[] values() {
        return (PodcastClickType[]) a.clone();
    }

    public static PodcastClickType valueOf(String r1) {
        return (PodcastClickType) a.a(PodcastClickType.class, r1);
    }

    public PodcastClickType(String r1, int r2) {
        super(r1, r2);
    }
}
