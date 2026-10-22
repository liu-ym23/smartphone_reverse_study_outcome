package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.helper;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/helper/MmSubtitleSmoothType;", "", "<init>", "(Ljava/lang/String;I)V", "SOURCE", "TARGET", "UNKNOWN", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmSubtitleSmoothType extends Enum<MmSubtitleSmoothType> {
    public static final MmSubtitleSmoothType SOURCE = null;
    public static final MmSubtitleSmoothType TARGET = null;
    public static final MmSubtitleSmoothType UNKNOWN = null;
    public static final /* synthetic */ MmSubtitleSmoothType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmSubtitleSmoothType> getEntries() {
        return b;
    }

    static {
        MmSubtitleSmoothType r0 = new MmSubtitleSmoothType("SOURCE", 0);
        SOURCE = r0;
        MmSubtitleSmoothType r1 = new MmSubtitleSmoothType("TARGET", 1);
        TARGET = r1;
        MmSubtitleSmoothType r3 = new MmSubtitleSmoothType("UNKNOWN", 2);
        UNKNOWN = r3;
        MmSubtitleSmoothType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static MmSubtitleSmoothType[] values() {
        return (MmSubtitleSmoothType[]) a.clone();
    }

    public static MmSubtitleSmoothType valueOf(String r1) {
        return (MmSubtitleSmoothType) a.a(MmSubtitleSmoothType.class, r1);
    }

    public MmSubtitleSmoothType(String r1, int r2) {
        super(r1, r2);
    }
}
