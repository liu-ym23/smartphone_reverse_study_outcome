package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceBusinessStatus;", "", "<init>", "(Ljava/lang/String;I)V", "INTERPRETATION", "RECORDING_MINUTES", "VIDEO_RECORDING", "VIDEO_CALL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricDeviceBusinessStatus extends Enum<DoraObricDeviceBusinessStatus> {
    public static final DoraObricDeviceBusinessStatus INTERPRETATION = null;
    public static final DoraObricDeviceBusinessStatus RECORDING_MINUTES = null;
    public static final DoraObricDeviceBusinessStatus VIDEO_CALL = null;
    public static final DoraObricDeviceBusinessStatus VIDEO_RECORDING = null;
    public static final /* synthetic */ DoraObricDeviceBusinessStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraObricDeviceBusinessStatus> getEntries() {
        return b;
    }

    static {
        DoraObricDeviceBusinessStatus r0 = new DoraObricDeviceBusinessStatus("INTERPRETATION", 0);
        INTERPRETATION = r0;
        DoraObricDeviceBusinessStatus r1 = new DoraObricDeviceBusinessStatus("RECORDING_MINUTES", 1);
        RECORDING_MINUTES = r1;
        DoraObricDeviceBusinessStatus r3 = new DoraObricDeviceBusinessStatus("VIDEO_RECORDING", 2);
        VIDEO_RECORDING = r3;
        DoraObricDeviceBusinessStatus r5 = new DoraObricDeviceBusinessStatus("VIDEO_CALL", 3);
        VIDEO_CALL = r5;
        DoraObricDeviceBusinessStatus[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static DoraObricDeviceBusinessStatus[] values() {
        return (DoraObricDeviceBusinessStatus[]) a.clone();
    }

    public static DoraObricDeviceBusinessStatus valueOf(String r1) {
        return (DoraObricDeviceBusinessStatus) r27.a.a(DoraObricDeviceBusinessStatus.class, r1);
    }

    public DoraObricDeviceBusinessStatus(String r1, int r2) {
        super(r1, r2);
    }
}
