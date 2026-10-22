package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007j\u0002\b\u0004j\u0002\b\u0005¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/summary/MmSummaryViewType;", "", "<init>", "(Ljava/lang/String;I)V", "Markdown", "FishBone", "isFishBone", "", "isMarkdown", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmSummaryViewType extends Enum<MmSummaryViewType> {
    public static final MmSummaryViewType FishBone = null;
    public static final MmSummaryViewType Markdown = null;
    public static final /* synthetic */ MmSummaryViewType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmSummaryViewType> getEntries() {
        return b;
    }

    static {
        MmSummaryViewType r0 = new MmSummaryViewType("Markdown", 0);
        Markdown = r0;
        MmSummaryViewType r1 = new MmSummaryViewType("FishBone", 1);
        FishBone = r1;
        MmSummaryViewType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static MmSummaryViewType[] values() {
        return (MmSummaryViewType[]) a.clone();
    }

    public final boolean isFishBone() {
        if (this != FishBone) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isMarkdown() {
        if (this != Markdown) goto L5;
        return true;
    L5:
        return false;
    }

    public static MmSummaryViewType valueOf(String r1) {
        return (MmSummaryViewType) r27.a.a(MmSummaryViewType.class, r1);
    }

    public MmSummaryViewType(String r1, int r2) {
        super(r1, r2);
    }
}
