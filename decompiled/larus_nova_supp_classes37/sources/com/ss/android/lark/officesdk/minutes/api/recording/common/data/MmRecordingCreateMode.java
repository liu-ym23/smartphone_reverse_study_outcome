package com.ss.android.lark.officesdk.minutes.api.recording.common.data;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingCreateMode;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT_RTC", "OFFLINE_LOCAL", "HARDWARE_LIVE", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmRecordingCreateMode extends Enum<MmRecordingCreateMode> {
    public static final MmRecordingCreateMode DEFAULT_RTC = null;
    public static final MmRecordingCreateMode HARDWARE_LIVE = null;
    public static final MmRecordingCreateMode OFFLINE_LOCAL = null;
    public static final /* synthetic */ MmRecordingCreateMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmRecordingCreateMode> getEntries() {
        return b;
    }

    static {
        MmRecordingCreateMode r0 = new MmRecordingCreateMode("DEFAULT_RTC", 0);
        DEFAULT_RTC = r0;
        MmRecordingCreateMode r1 = new MmRecordingCreateMode("OFFLINE_LOCAL", 1);
        OFFLINE_LOCAL = r1;
        MmRecordingCreateMode r3 = new MmRecordingCreateMode("HARDWARE_LIVE", 2);
        HARDWARE_LIVE = r3;
        MmRecordingCreateMode[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static MmRecordingCreateMode[] values() {
        return (MmRecordingCreateMode[]) a.clone();
    }

    public static MmRecordingCreateMode valueOf(String r1) {
        return (MmRecordingCreateMode) a.a(MmRecordingCreateMode.class, r1);
    }

    public MmRecordingCreateMode(String r1, int r2) {
        super(r1, r2);
    }
}
