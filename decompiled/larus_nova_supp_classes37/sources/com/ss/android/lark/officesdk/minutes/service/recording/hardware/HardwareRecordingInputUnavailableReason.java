package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/hardware/HardwareRecordingInputUnavailableReason;", "", "<init>", "(Ljava/lang/String;I)V", "BLUETOOTH_DISCONNECTED", "SPEAKER_SWITCHED", "AUDIO_PATH_PREEMPTED", "AUDIO_ROUTE_CHANGED", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum HardwareRecordingInputUnavailableReason extends Enum<HardwareRecordingInputUnavailableReason> {
    public static final HardwareRecordingInputUnavailableReason AUDIO_PATH_PREEMPTED = null;
    public static final HardwareRecordingInputUnavailableReason AUDIO_ROUTE_CHANGED = null;
    public static final HardwareRecordingInputUnavailableReason BLUETOOTH_DISCONNECTED = null;
    public static final HardwareRecordingInputUnavailableReason SPEAKER_SWITCHED = null;
    public static final /* synthetic */ HardwareRecordingInputUnavailableReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<HardwareRecordingInputUnavailableReason> getEntries() {
        return b;
    }

    static {
        HardwareRecordingInputUnavailableReason r0 = new HardwareRecordingInputUnavailableReason("BLUETOOTH_DISCONNECTED", 0);
        BLUETOOTH_DISCONNECTED = r0;
        HardwareRecordingInputUnavailableReason r1 = new HardwareRecordingInputUnavailableReason("SPEAKER_SWITCHED", 1);
        SPEAKER_SWITCHED = r1;
        HardwareRecordingInputUnavailableReason r3 = new HardwareRecordingInputUnavailableReason("AUDIO_PATH_PREEMPTED", 2);
        AUDIO_PATH_PREEMPTED = r3;
        HardwareRecordingInputUnavailableReason r5 = new HardwareRecordingInputUnavailableReason("AUDIO_ROUTE_CHANGED", 3);
        AUDIO_ROUTE_CHANGED = r5;
        HardwareRecordingInputUnavailableReason[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static HardwareRecordingInputUnavailableReason[] values() {
        return (HardwareRecordingInputUnavailableReason[]) a.clone();
    }

    public static HardwareRecordingInputUnavailableReason valueOf(String r1) {
        return (HardwareRecordingInputUnavailableReason) r27.a.a(HardwareRecordingInputUnavailableReason.class, r1);
    }

    public HardwareRecordingInputUnavailableReason(String r1, int r2) {
        super(r1, r2);
    }
}
