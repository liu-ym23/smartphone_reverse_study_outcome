package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007j\u0002\b\u0004j\u0002\b\u0005¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/meta/MmRecordingUITab;", "", "<init>", "(Ljava/lang/String;I)V", "SUBTITLE", "SUMMARY", "isInSubtitle", "", "isInSummary", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmRecordingUITab extends Enum<MmRecordingUITab> {
    public static final MmRecordingUITab SUBTITLE = null;
    public static final MmRecordingUITab SUMMARY = null;
    public static final /* synthetic */ MmRecordingUITab[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmRecordingUITab> getEntries() {
        return b;
    }

    static {
        MmRecordingUITab r0 = new MmRecordingUITab("SUBTITLE", 0);
        SUBTITLE = r0;
        MmRecordingUITab r1 = new MmRecordingUITab("SUMMARY", 1);
        SUMMARY = r1;
        MmRecordingUITab[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static MmRecordingUITab[] values() {
        return (MmRecordingUITab[]) a.clone();
    }

    public final boolean isInSubtitle() {
        if (this != SUBTITLE) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isInSummary() {
        if (this != SUMMARY) goto L5;
        return true;
    L5:
        return false;
    }

    public static MmRecordingUITab valueOf(String r1) {
        return (MmRecordingUITab) r27.a.a(MmRecordingUITab.class, r1);
    }

    public MmRecordingUITab(String r1, int r2) {
        super(r1, r2);
    }
}
