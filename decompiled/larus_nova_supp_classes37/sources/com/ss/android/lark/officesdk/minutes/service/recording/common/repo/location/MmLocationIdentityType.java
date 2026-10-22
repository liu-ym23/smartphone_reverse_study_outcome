package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/location/MmLocationIdentityType;", "", "<init>", "(Ljava/lang/String;I)V", "RECORDING_ID", "MINUTES_TOKEN", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmLocationIdentityType extends Enum<MmLocationIdentityType> {
    public static final MmLocationIdentityType MINUTES_TOKEN = null;
    public static final MmLocationIdentityType RECORDING_ID = null;
    public static final /* synthetic */ MmLocationIdentityType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmLocationIdentityType> getEntries() {
        return b;
    }

    static {
        MmLocationIdentityType r0 = new MmLocationIdentityType("RECORDING_ID", 0);
        RECORDING_ID = r0;
        MmLocationIdentityType r1 = new MmLocationIdentityType("MINUTES_TOKEN", 1);
        MINUTES_TOKEN = r1;
        MmLocationIdentityType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static MmLocationIdentityType[] values() {
        return (MmLocationIdentityType[]) a.clone();
    }

    public static MmLocationIdentityType valueOf(String r1) {
        return (MmLocationIdentityType) r27.a.a(MmLocationIdentityType.class, r1);
    }

    public MmLocationIdentityType(String r1, int r2) {
        super(r1, r2);
    }
}
