package com.larus.bmhome.chat.list.cell.spacer;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/list/cell/spacer/SpacerCell$FollowLatestResult;", "", "<init>", "(Ljava/lang/String;I)V", "APPLIED", "DEFERRED", "STOPPED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum SpacerCell$FollowLatestResult extends Enum<SpacerCell$FollowLatestResult> {
    public static final SpacerCell$FollowLatestResult APPLIED = null;
    public static final SpacerCell$FollowLatestResult DEFERRED = null;
    public static final SpacerCell$FollowLatestResult STOPPED = null;
    public static final /* synthetic */ SpacerCell$FollowLatestResult[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SpacerCell$FollowLatestResult> getEntries() {
        return b;
    }

    static {
        SpacerCell$FollowLatestResult r0 = new SpacerCell$FollowLatestResult("APPLIED", 0);
        APPLIED = r0;
        SpacerCell$FollowLatestResult r1 = new SpacerCell$FollowLatestResult("DEFERRED", 1);
        DEFERRED = r1;
        SpacerCell$FollowLatestResult r3 = new SpacerCell$FollowLatestResult("STOPPED", 2);
        STOPPED = r3;
        SpacerCell$FollowLatestResult[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static SpacerCell$FollowLatestResult[] values() {
        return (SpacerCell$FollowLatestResult[]) a.clone();
    }

    public static SpacerCell$FollowLatestResult valueOf(String r1) {
        return (SpacerCell$FollowLatestResult) r27.a.a(SpacerCell$FollowLatestResult.class, r1);
    }

    public SpacerCell$FollowLatestResult(String r1, int r2) {
        super(r1, r2);
    }
}
