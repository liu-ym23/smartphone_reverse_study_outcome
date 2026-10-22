package com.ss.android.lark.officesdk.minutes.api.hardware;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/hardware/MmOfficeD1204RecordingStatus;", "", "<init>", "(Ljava/lang/String;I)V", "RECORDING", "PAUSED", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmOfficeD1204RecordingStatus extends Enum<MmOfficeD1204RecordingStatus> {
    public static final MmOfficeD1204RecordingStatus PAUSED = null;
    public static final MmOfficeD1204RecordingStatus RECORDING = null;
    public static final /* synthetic */ MmOfficeD1204RecordingStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmOfficeD1204RecordingStatus> getEntries() {
        return b;
    }

    static {
        MmOfficeD1204RecordingStatus r0 = new MmOfficeD1204RecordingStatus("RECORDING", 0);
        RECORDING = r0;
        MmOfficeD1204RecordingStatus r1 = new MmOfficeD1204RecordingStatus("PAUSED", 1);
        PAUSED = r1;
        MmOfficeD1204RecordingStatus[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static MmOfficeD1204RecordingStatus[] values() {
        return (MmOfficeD1204RecordingStatus[]) a.clone();
    }

    public static MmOfficeD1204RecordingStatus valueOf(String r1) {
        return (MmOfficeD1204RecordingStatus) r27.a.a(MmOfficeD1204RecordingStatus.class, r1);
    }

    public MmOfficeD1204RecordingStatus(String r1, int r2) {
        super(r1, r2);
    }
}
