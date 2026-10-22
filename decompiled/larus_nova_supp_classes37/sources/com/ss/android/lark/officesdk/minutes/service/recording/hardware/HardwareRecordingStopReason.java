package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/hardware/HardwareRecordingStopReason;", "", "<init>", "(Ljava/lang/String;I)V", "USER_STOP", "INTERRUPTED_BY_HIGHER_PRIORITY", "HARDWARE_DISCONNECT", "HARDWARE_MEETING_CONFLICT", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum HardwareRecordingStopReason extends Enum<HardwareRecordingStopReason> {
    public static final HardwareRecordingStopReason HARDWARE_DISCONNECT = null;
    public static final HardwareRecordingStopReason HARDWARE_MEETING_CONFLICT = null;
    public static final HardwareRecordingStopReason INTERRUPTED_BY_HIGHER_PRIORITY = null;
    public static final HardwareRecordingStopReason USER_STOP = null;
    public static final /* synthetic */ HardwareRecordingStopReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<HardwareRecordingStopReason> getEntries() {
        return b;
    }

    static {
        HardwareRecordingStopReason r0 = new HardwareRecordingStopReason("USER_STOP", 0);
        USER_STOP = r0;
        HardwareRecordingStopReason r1 = new HardwareRecordingStopReason("INTERRUPTED_BY_HIGHER_PRIORITY", 1);
        INTERRUPTED_BY_HIGHER_PRIORITY = r1;
        HardwareRecordingStopReason r3 = new HardwareRecordingStopReason("HARDWARE_DISCONNECT", 2);
        HARDWARE_DISCONNECT = r3;
        HardwareRecordingStopReason r5 = new HardwareRecordingStopReason("HARDWARE_MEETING_CONFLICT", 3);
        HARDWARE_MEETING_CONFLICT = r5;
        HardwareRecordingStopReason[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static HardwareRecordingStopReason[] values() {
        return (HardwareRecordingStopReason[]) a.clone();
    }

    public static HardwareRecordingStopReason valueOf(String r1) {
        return (HardwareRecordingStopReason) r27.a.a(HardwareRecordingStopReason.class, r1);
    }

    public HardwareRecordingStopReason(String r1, int r2) {
        super(r1, r2);
    }
}
