package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/hardware/HardwareRecordingSessionState;", "", "<init>", "(Ljava/lang/String;I)V", "STARTING", "RECORDING", "PAUSED", "WAITING_CALL_RECOVERY", "WAITING_INPUT_RECOVERY", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum HardwareRecordingSessionState extends Enum<HardwareRecordingSessionState> {
    public static final HardwareRecordingSessionState PAUSED = null;
    public static final HardwareRecordingSessionState RECORDING = null;
    public static final HardwareRecordingSessionState STARTING = null;
    public static final HardwareRecordingSessionState WAITING_CALL_RECOVERY = null;
    public static final HardwareRecordingSessionState WAITING_INPUT_RECOVERY = null;
    public static final /* synthetic */ HardwareRecordingSessionState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<HardwareRecordingSessionState> getEntries() {
        return b;
    }

    static {
        HardwareRecordingSessionState r0 = new HardwareRecordingSessionState("STARTING", 0);
        STARTING = r0;
        HardwareRecordingSessionState r1 = new HardwareRecordingSessionState("RECORDING", 1);
        RECORDING = r1;
        HardwareRecordingSessionState r3 = new HardwareRecordingSessionState("PAUSED", 2);
        PAUSED = r3;
        HardwareRecordingSessionState r5 = new HardwareRecordingSessionState("WAITING_CALL_RECOVERY", 3);
        WAITING_CALL_RECOVERY = r5;
        HardwareRecordingSessionState r7 = new HardwareRecordingSessionState("WAITING_INPUT_RECOVERY", 4);
        WAITING_INPUT_RECOVERY = r7;
        HardwareRecordingSessionState[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static HardwareRecordingSessionState[] values() {
        return (HardwareRecordingSessionState[]) a.clone();
    }

    public static HardwareRecordingSessionState valueOf(String r1) {
        return (HardwareRecordingSessionState) r27.a.a(HardwareRecordingSessionState.class, r1);
    }

    public HardwareRecordingSessionState(String r1, int r2) {
        super(r1, r2);
    }
}
