package com.ss.android.lark.officesdk.minutes.api.hardware.legacy;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/hardware/legacy/MmLegacyHardwareRuntimePhase;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "SYNCING", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmLegacyHardwareRuntimePhase extends Enum<MmLegacyHardwareRuntimePhase> {
    public static final MmLegacyHardwareRuntimePhase SYNCING = null;
    public static final MmLegacyHardwareRuntimePhase UNKNOWN = null;
    public static final /* synthetic */ MmLegacyHardwareRuntimePhase[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmLegacyHardwareRuntimePhase> getEntries() {
        return b;
    }

    static {
        MmLegacyHardwareRuntimePhase r0 = new MmLegacyHardwareRuntimePhase("UNKNOWN", 0);
        UNKNOWN = r0;
        MmLegacyHardwareRuntimePhase r1 = new MmLegacyHardwareRuntimePhase("SYNCING", 1);
        SYNCING = r1;
        MmLegacyHardwareRuntimePhase[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static MmLegacyHardwareRuntimePhase[] values() {
        return (MmLegacyHardwareRuntimePhase[]) a.clone();
    }

    public static MmLegacyHardwareRuntimePhase valueOf(String r1) {
        return (MmLegacyHardwareRuntimePhase) a.a(MmLegacyHardwareRuntimePhase.class, r1);
    }

    public MmLegacyHardwareRuntimePhase(String r1, int r2) {
        super(r1, r2);
    }
}
