package com.ss.android.lark.officesdk.minutes.api.hardware.legacy;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/hardware/legacy/MmLegacyHardwareBannerSubStatus;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "BLUETOOTH_SYNCING", "WIFI_FILE_CONNECTING", "WIFI_FILE_SYNCING", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmLegacyHardwareBannerSubStatus extends Enum<MmLegacyHardwareBannerSubStatus> {
    public static final MmLegacyHardwareBannerSubStatus BLUETOOTH_SYNCING = null;
    public static final MmLegacyHardwareBannerSubStatus UNKNOWN = null;
    public static final MmLegacyHardwareBannerSubStatus WIFI_FILE_CONNECTING = null;
    public static final MmLegacyHardwareBannerSubStatus WIFI_FILE_SYNCING = null;
    public static final /* synthetic */ MmLegacyHardwareBannerSubStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmLegacyHardwareBannerSubStatus> getEntries() {
        return b;
    }

    static {
        MmLegacyHardwareBannerSubStatus r0 = new MmLegacyHardwareBannerSubStatus("UNKNOWN", 0);
        UNKNOWN = r0;
        MmLegacyHardwareBannerSubStatus r1 = new MmLegacyHardwareBannerSubStatus("BLUETOOTH_SYNCING", 1);
        BLUETOOTH_SYNCING = r1;
        MmLegacyHardwareBannerSubStatus r3 = new MmLegacyHardwareBannerSubStatus("WIFI_FILE_CONNECTING", 2);
        WIFI_FILE_CONNECTING = r3;
        MmLegacyHardwareBannerSubStatus r5 = new MmLegacyHardwareBannerSubStatus("WIFI_FILE_SYNCING", 3);
        WIFI_FILE_SYNCING = r5;
        MmLegacyHardwareBannerSubStatus[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static MmLegacyHardwareBannerSubStatus[] values() {
        return (MmLegacyHardwareBannerSubStatus[]) a.clone();
    }

    public static MmLegacyHardwareBannerSubStatus valueOf(String r1) {
        return (MmLegacyHardwareBannerSubStatus) a.a(MmLegacyHardwareBannerSubStatus.class, r1);
    }

    public MmLegacyHardwareBannerSubStatus(String r1, int r2) {
        super(r1, r2);
    }
}
