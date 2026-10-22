package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/hardware/HardwareRecordingInterruptionReason;", "", "<init>", "(Ljava/lang/String;I)V", "BLUETOOTH_DISCONNECTED", "AUDIO_MODE_SWITCHED", "MIC_IN_USE", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum HardwareRecordingInterruptionReason extends Enum<HardwareRecordingInterruptionReason> {
    public static final HardwareRecordingInterruptionReason AUDIO_MODE_SWITCHED = null;
    public static final HardwareRecordingInterruptionReason BLUETOOTH_DISCONNECTED = null;
    public static final HardwareRecordingInterruptionReason MIC_IN_USE = null;
    public static final /* synthetic */ HardwareRecordingInterruptionReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<HardwareRecordingInterruptionReason> getEntries() {
        return b;
    }

    static {
        HardwareRecordingInterruptionReason r0 = new HardwareRecordingInterruptionReason("BLUETOOTH_DISCONNECTED", 0);
        BLUETOOTH_DISCONNECTED = r0;
        HardwareRecordingInterruptionReason r1 = new HardwareRecordingInterruptionReason("AUDIO_MODE_SWITCHED", 1);
        AUDIO_MODE_SWITCHED = r1;
        HardwareRecordingInterruptionReason r3 = new HardwareRecordingInterruptionReason("MIC_IN_USE", 2);
        MIC_IN_USE = r3;
        HardwareRecordingInterruptionReason[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static HardwareRecordingInterruptionReason[] values() {
        return (HardwareRecordingInterruptionReason[]) a.clone();
    }

    public static HardwareRecordingInterruptionReason valueOf(String r1) {
        return (HardwareRecordingInterruptionReason) r27.a.a(HardwareRecordingInterruptionReason.class, r1);
    }

    public HardwareRecordingInterruptionReason(String r1, int r2) {
        super(r1, r2);
    }
}
