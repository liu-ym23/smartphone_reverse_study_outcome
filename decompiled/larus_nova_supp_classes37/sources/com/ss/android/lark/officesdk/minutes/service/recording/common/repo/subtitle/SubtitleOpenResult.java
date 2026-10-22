package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/SubtitleOpenResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "FAILURE", "DEGRADED", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum SubtitleOpenResult extends Enum<SubtitleOpenResult> {
    public static final SubtitleOpenResult DEGRADED = null;
    public static final SubtitleOpenResult FAILURE = null;
    public static final SubtitleOpenResult SUCCESS = null;
    public static final /* synthetic */ SubtitleOpenResult[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SubtitleOpenResult> getEntries() {
        return b;
    }

    static {
        SubtitleOpenResult r0 = new SubtitleOpenResult("SUCCESS", 0);
        SUCCESS = r0;
        SubtitleOpenResult r1 = new SubtitleOpenResult("FAILURE", 1);
        FAILURE = r1;
        SubtitleOpenResult r3 = new SubtitleOpenResult("DEGRADED", 2);
        DEGRADED = r3;
        SubtitleOpenResult[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static SubtitleOpenResult[] values() {
        return (SubtitleOpenResult[]) a.clone();
    }

    public static SubtitleOpenResult valueOf(String r1) {
        return (SubtitleOpenResult) r27.a.a(SubtitleOpenResult.class, r1);
    }

    public SubtitleOpenResult(String r1, int r2) {
        super(r1, r2);
    }
}
