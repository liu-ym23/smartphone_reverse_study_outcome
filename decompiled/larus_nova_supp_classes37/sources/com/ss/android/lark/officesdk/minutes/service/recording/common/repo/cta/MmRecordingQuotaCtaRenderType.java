package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmRecordingQuotaCtaRenderType;", "", "<init>", "(Ljava/lang/String;I)V", "Default", "WindowLimited5H", "WindowLimited7D", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmRecordingQuotaCtaRenderType extends Enum<MmRecordingQuotaCtaRenderType> {
    public static final MmRecordingQuotaCtaRenderType Default = null;
    public static final MmRecordingQuotaCtaRenderType WindowLimited5H = null;
    public static final MmRecordingQuotaCtaRenderType WindowLimited7D = null;
    public static final /* synthetic */ MmRecordingQuotaCtaRenderType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmRecordingQuotaCtaRenderType> getEntries() {
        return b;
    }

    static {
        MmRecordingQuotaCtaRenderType r0 = new MmRecordingQuotaCtaRenderType("Default", 0);
        Default = r0;
        MmRecordingQuotaCtaRenderType r1 = new MmRecordingQuotaCtaRenderType("WindowLimited5H", 1);
        WindowLimited5H = r1;
        MmRecordingQuotaCtaRenderType r3 = new MmRecordingQuotaCtaRenderType("WindowLimited7D", 2);
        WindowLimited7D = r3;
        MmRecordingQuotaCtaRenderType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static MmRecordingQuotaCtaRenderType[] values() {
        return (MmRecordingQuotaCtaRenderType[]) a.clone();
    }

    public static MmRecordingQuotaCtaRenderType valueOf(String r1) {
        return (MmRecordingQuotaCtaRenderType) r27.a.a(MmRecordingQuotaCtaRenderType.class, r1);
    }

    public MmRecordingQuotaCtaRenderType(String r1, int r2) {
        super(r1, r2);
    }
}
