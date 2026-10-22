package com.ss.android.lark.officesdk.minutes.api.hardware;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/hardware/MmOfficeHardwareRecordingState;", "", "<init>", "(Ljava/lang/String;I)V", "STARTING", "RECORDING", "PAUSED", "WAITING_RECOVERY", "NONE", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmOfficeHardwareRecordingState extends Enum<MmOfficeHardwareRecordingState> {
    public static final MmOfficeHardwareRecordingState NONE = null;
    public static final MmOfficeHardwareRecordingState PAUSED = null;
    public static final MmOfficeHardwareRecordingState RECORDING = null;
    public static final MmOfficeHardwareRecordingState STARTING = null;
    public static final MmOfficeHardwareRecordingState WAITING_RECOVERY = null;
    public static final /* synthetic */ MmOfficeHardwareRecordingState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmOfficeHardwareRecordingState> getEntries() {
        return b;
    }

    static {
        MmOfficeHardwareRecordingState r0 = new MmOfficeHardwareRecordingState("STARTING", 0);
        STARTING = r0;
        MmOfficeHardwareRecordingState r1 = new MmOfficeHardwareRecordingState("RECORDING", 1);
        RECORDING = r1;
        MmOfficeHardwareRecordingState r3 = new MmOfficeHardwareRecordingState("PAUSED", 2);
        PAUSED = r3;
        MmOfficeHardwareRecordingState r5 = new MmOfficeHardwareRecordingState("WAITING_RECOVERY", 3);
        WAITING_RECOVERY = r5;
        MmOfficeHardwareRecordingState r7 = new MmOfficeHardwareRecordingState("NONE", 4);
        NONE = r7;
        MmOfficeHardwareRecordingState[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static MmOfficeHardwareRecordingState[] values() {
        return (MmOfficeHardwareRecordingState[]) a.clone();
    }

    public static MmOfficeHardwareRecordingState valueOf(String r1) {
        return (MmOfficeHardwareRecordingState) r27.a.a(MmOfficeHardwareRecordingState.class, r1);
    }

    public MmOfficeHardwareRecordingState(String r1, int r2) {
        super(r1, r2);
    }
}
