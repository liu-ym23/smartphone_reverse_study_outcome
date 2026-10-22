package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmRecordingQuotaCtaScene;", "", "<init>", "(Ljava/lang/String;I)V", "SUBTITLE", "SUMMARY", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmRecordingQuotaCtaScene extends Enum<MmRecordingQuotaCtaScene> {
    public static final MmRecordingQuotaCtaScene SUBTITLE = null;
    public static final MmRecordingQuotaCtaScene SUMMARY = null;
    public static final /* synthetic */ MmRecordingQuotaCtaScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmRecordingQuotaCtaScene> getEntries() {
        return b;
    }

    static {
        MmRecordingQuotaCtaScene r0 = new MmRecordingQuotaCtaScene("SUBTITLE", 0);
        SUBTITLE = r0;
        MmRecordingQuotaCtaScene r1 = new MmRecordingQuotaCtaScene("SUMMARY", 1);
        SUMMARY = r1;
        MmRecordingQuotaCtaScene[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static MmRecordingQuotaCtaScene[] values() {
        return (MmRecordingQuotaCtaScene[]) a.clone();
    }

    public static MmRecordingQuotaCtaScene valueOf(String r1) {
        return (MmRecordingQuotaCtaScene) r27.a.a(MmRecordingQuotaCtaScene.class, r1);
    }

    public MmRecordingQuotaCtaScene(String r1, int r2) {
        super(r1, r2);
    }
}
