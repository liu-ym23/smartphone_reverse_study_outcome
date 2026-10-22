package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/SubtitleFailedQuotaDecision;", "", "<init>", "(Ljava/lang/String;I)V", "SEND_FAILED", "CLEAR", "PEND", "NOOP", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum SubtitleFailedQuotaDecision extends Enum<SubtitleFailedQuotaDecision> {
    public static final SubtitleFailedQuotaDecision CLEAR = null;
    public static final SubtitleFailedQuotaDecision NOOP = null;
    public static final SubtitleFailedQuotaDecision PEND = null;
    public static final SubtitleFailedQuotaDecision SEND_FAILED = null;
    public static final /* synthetic */ SubtitleFailedQuotaDecision[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SubtitleFailedQuotaDecision> getEntries() {
        return b;
    }

    static {
        SubtitleFailedQuotaDecision r0 = new SubtitleFailedQuotaDecision("SEND_FAILED", 0);
        SEND_FAILED = r0;
        SubtitleFailedQuotaDecision r1 = new SubtitleFailedQuotaDecision("CLEAR", 1);
        CLEAR = r1;
        SubtitleFailedQuotaDecision r3 = new SubtitleFailedQuotaDecision("PEND", 2);
        PEND = r3;
        SubtitleFailedQuotaDecision r5 = new SubtitleFailedQuotaDecision("NOOP", 3);
        NOOP = r5;
        SubtitleFailedQuotaDecision[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static SubtitleFailedQuotaDecision[] values() {
        return (SubtitleFailedQuotaDecision[]) a.clone();
    }

    public static SubtitleFailedQuotaDecision valueOf(String r1) {
        return (SubtitleFailedQuotaDecision) r27.a.a(SubtitleFailedQuotaDecision.class, r1);
    }

    public SubtitleFailedQuotaDecision(String r1, int r2) {
        super(r1, r2);
    }
}
