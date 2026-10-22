package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/summary/MmSummaryStatus;", "", "<init>", "(Ljava/lang/String;I)V", "None", "EmptyContent", "HasContent", "MeetingAISummaryOpenError", "hasContent", "", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmSummaryStatus extends Enum<MmSummaryStatus> {
    public static final MmSummaryStatus EmptyContent = null;
    public static final MmSummaryStatus HasContent = null;
    public static final MmSummaryStatus MeetingAISummaryOpenError = null;
    public static final MmSummaryStatus None = null;
    public static final /* synthetic */ MmSummaryStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmSummaryStatus> getEntries() {
        return b;
    }

    static {
        MmSummaryStatus r0 = new MmSummaryStatus("None", 0);
        None = r0;
        MmSummaryStatus r1 = new MmSummaryStatus("EmptyContent", 1);
        EmptyContent = r1;
        MmSummaryStatus r3 = new MmSummaryStatus("HasContent", 2);
        HasContent = r3;
        MmSummaryStatus r5 = new MmSummaryStatus("MeetingAISummaryOpenError", 3);
        MeetingAISummaryOpenError = r5;
        MmSummaryStatus[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static MmSummaryStatus[] values() {
        return (MmSummaryStatus[]) a.clone();
    }

    public final boolean hasContent() {
        if (this != HasContent) goto L5;
        return true;
    L5:
        return false;
    }

    public static MmSummaryStatus valueOf(String r1) {
        return (MmSummaryStatus) r27.a.a(MmSummaryStatus.class, r1);
    }

    public MmSummaryStatus(String r1, int r2) {
        super(r1, r2);
    }
}
