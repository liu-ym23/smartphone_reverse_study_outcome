package com.ss.android.lark.officesdk.minutes.service.foundation.hardware;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/hardware/MmHardwareExternalAudioDeviceType;", "", "<init>", "(Ljava/lang/String;I)V", "D3200", "D1204", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmHardwareExternalAudioDeviceType extends Enum<MmHardwareExternalAudioDeviceType> {
    public static final MmHardwareExternalAudioDeviceType D1204 = null;
    public static final MmHardwareExternalAudioDeviceType D3200 = null;
    public static final /* synthetic */ MmHardwareExternalAudioDeviceType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmHardwareExternalAudioDeviceType> getEntries() {
        return b;
    }

    static {
        MmHardwareExternalAudioDeviceType r0 = new MmHardwareExternalAudioDeviceType("D3200", 0);
        D3200 = r0;
        MmHardwareExternalAudioDeviceType r1 = new MmHardwareExternalAudioDeviceType("D1204", 1);
        D1204 = r1;
        MmHardwareExternalAudioDeviceType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static MmHardwareExternalAudioDeviceType[] values() {
        return (MmHardwareExternalAudioDeviceType[]) a.clone();
    }

    public static MmHardwareExternalAudioDeviceType valueOf(String r1) {
        return (MmHardwareExternalAudioDeviceType) a.a(MmHardwareExternalAudioDeviceType.class, r1);
    }

    public MmHardwareExternalAudioDeviceType(String r1, int r2) {
        super(r1, r2);
    }
}
