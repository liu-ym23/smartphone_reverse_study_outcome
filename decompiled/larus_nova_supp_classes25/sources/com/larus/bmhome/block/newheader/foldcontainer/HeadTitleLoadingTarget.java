package com.larus.bmhome.block.newheader.foldcontainer;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/block/newheader/foldcontainer/HeadTitleLoadingTarget;", "", "<init>", "(Ljava/lang/String;I)V", "CONTAINER", "TEXT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum HeadTitleLoadingTarget extends Enum<HeadTitleLoadingTarget> {
    public static final HeadTitleLoadingTarget CONTAINER = null;
    public static final HeadTitleLoadingTarget TEXT = null;
    public static final /* synthetic */ HeadTitleLoadingTarget[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<HeadTitleLoadingTarget> getEntries() {
        return b;
    }

    static {
        HeadTitleLoadingTarget r0 = new HeadTitleLoadingTarget("CONTAINER", 0);
        CONTAINER = r0;
        HeadTitleLoadingTarget r1 = new HeadTitleLoadingTarget("TEXT", 1);
        TEXT = r1;
        HeadTitleLoadingTarget[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static HeadTitleLoadingTarget[] values() {
        return (HeadTitleLoadingTarget[]) a.clone();
    }

    public static HeadTitleLoadingTarget valueOf(String r1) {
        return (HeadTitleLoadingTarget) r27.a.a(HeadTitleLoadingTarget.class, r1);
    }

    public HeadTitleLoadingTarget(String r1, int r2) {
        super(r1, r2);
    }
}
