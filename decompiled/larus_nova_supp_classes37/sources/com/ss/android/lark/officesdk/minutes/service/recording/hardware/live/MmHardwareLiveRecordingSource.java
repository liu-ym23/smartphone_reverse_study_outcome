package com.ss.android.lark.officesdk.minutes.service.recording.hardware.live;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/hardware/live/MmHardwareLiveRecordingSource;", "", "<init>", "(Ljava/lang/String;I)V", "D1204_CHARGING_CASE", "D3200_DEVICE", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmHardwareLiveRecordingSource extends Enum<MmHardwareLiveRecordingSource> {
    public static final MmHardwareLiveRecordingSource D1204_CHARGING_CASE = null;
    public static final MmHardwareLiveRecordingSource D3200_DEVICE = null;
    public static final /* synthetic */ MmHardwareLiveRecordingSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmHardwareLiveRecordingSource> getEntries() {
        return b;
    }

    static {
        MmHardwareLiveRecordingSource r0 = new MmHardwareLiveRecordingSource("D1204_CHARGING_CASE", 0);
        D1204_CHARGING_CASE = r0;
        MmHardwareLiveRecordingSource r1 = new MmHardwareLiveRecordingSource("D3200_DEVICE", 1);
        D3200_DEVICE = r1;
        MmHardwareLiveRecordingSource[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static MmHardwareLiveRecordingSource[] values() {
        return (MmHardwareLiveRecordingSource[]) a.clone();
    }

    public static MmHardwareLiveRecordingSource valueOf(String r1) {
        return (MmHardwareLiveRecordingSource) r27.a.a(MmHardwareLiveRecordingSource.class, r1);
    }

    public MmHardwareLiveRecordingSource(String r1, int r2) {
        super(r1, r2);
    }
}
