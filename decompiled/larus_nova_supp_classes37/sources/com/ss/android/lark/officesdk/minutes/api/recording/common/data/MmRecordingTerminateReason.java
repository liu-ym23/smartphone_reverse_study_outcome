package com.ss.android.lark.officesdk.minutes.api.recording.common.data;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingTerminateReason;", "", "<init>", "(Ljava/lang/String;I)V", "HARDWARE_STOPPED", "HARDWARE_DISCONNECTED", "PRIORITY_REPLACED", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmRecordingTerminateReason extends Enum<MmRecordingTerminateReason> {
    public static final MmRecordingTerminateReason HARDWARE_DISCONNECTED = null;
    public static final MmRecordingTerminateReason HARDWARE_STOPPED = null;
    public static final MmRecordingTerminateReason PRIORITY_REPLACED = null;
    public static final /* synthetic */ MmRecordingTerminateReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmRecordingTerminateReason> getEntries() {
        return b;
    }

    static {
        MmRecordingTerminateReason r0 = new MmRecordingTerminateReason("HARDWARE_STOPPED", 0);
        HARDWARE_STOPPED = r0;
        MmRecordingTerminateReason r1 = new MmRecordingTerminateReason("HARDWARE_DISCONNECTED", 1);
        HARDWARE_DISCONNECTED = r1;
        MmRecordingTerminateReason r3 = new MmRecordingTerminateReason("PRIORITY_REPLACED", 2);
        PRIORITY_REPLACED = r3;
        MmRecordingTerminateReason[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static MmRecordingTerminateReason[] values() {
        return (MmRecordingTerminateReason[]) a.clone();
    }

    public static MmRecordingTerminateReason valueOf(String r1) {
        return (MmRecordingTerminateReason) a.a(MmRecordingTerminateReason.class, r1);
    }

    public MmRecordingTerminateReason(String r1, int r2) {
        super(r1, r2);
    }
}
