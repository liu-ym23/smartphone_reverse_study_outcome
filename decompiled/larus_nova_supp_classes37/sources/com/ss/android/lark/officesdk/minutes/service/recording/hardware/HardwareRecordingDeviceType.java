package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/hardware/HardwareRecordingDeviceType;", "", "<init>", "(Ljava/lang/String;I)V", "LIBERTY_D1204", "UNKNOWN", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum HardwareRecordingDeviceType extends Enum<HardwareRecordingDeviceType> {
    public static final HardwareRecordingDeviceType LIBERTY_D1204 = null;
    public static final HardwareRecordingDeviceType UNKNOWN = null;
    public static final /* synthetic */ HardwareRecordingDeviceType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<HardwareRecordingDeviceType> getEntries() {
        return b;
    }

    static {
        HardwareRecordingDeviceType r0 = new HardwareRecordingDeviceType("LIBERTY_D1204", 0);
        LIBERTY_D1204 = r0;
        HardwareRecordingDeviceType r1 = new HardwareRecordingDeviceType("UNKNOWN", 1);
        UNKNOWN = r1;
        HardwareRecordingDeviceType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static HardwareRecordingDeviceType[] values() {
        return (HardwareRecordingDeviceType[]) a.clone();
    }

    public static HardwareRecordingDeviceType valueOf(String r1) {
        return (HardwareRecordingDeviceType) r27.a.a(HardwareRecordingDeviceType.class, r1);
    }

    public HardwareRecordingDeviceType(String r1, int r2) {
        super(r1, r2);
    }
}
