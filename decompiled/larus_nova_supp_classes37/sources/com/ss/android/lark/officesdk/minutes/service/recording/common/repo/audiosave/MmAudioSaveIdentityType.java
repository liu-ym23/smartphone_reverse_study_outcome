package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/audiosave/MmAudioSaveIdentityType;", "", "<init>", "(Ljava/lang/String;I)V", "RECORDING_ID", "MINUTES_TOKEN", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmAudioSaveIdentityType extends Enum<MmAudioSaveIdentityType> {
    public static final MmAudioSaveIdentityType MINUTES_TOKEN = null;
    public static final MmAudioSaveIdentityType RECORDING_ID = null;
    public static final /* synthetic */ MmAudioSaveIdentityType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmAudioSaveIdentityType> getEntries() {
        return b;
    }

    static {
        MmAudioSaveIdentityType r0 = new MmAudioSaveIdentityType("RECORDING_ID", 0);
        RECORDING_ID = r0;
        MmAudioSaveIdentityType r1 = new MmAudioSaveIdentityType("MINUTES_TOKEN", 1);
        MINUTES_TOKEN = r1;
        MmAudioSaveIdentityType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static MmAudioSaveIdentityType[] values() {
        return (MmAudioSaveIdentityType[]) a.clone();
    }

    public static MmAudioSaveIdentityType valueOf(String r1) {
        return (MmAudioSaveIdentityType) r27.a.a(MmAudioSaveIdentityType.class, r1);
    }

    public MmAudioSaveIdentityType(String r1, int r2) {
        super(r1, r2);
    }
}
