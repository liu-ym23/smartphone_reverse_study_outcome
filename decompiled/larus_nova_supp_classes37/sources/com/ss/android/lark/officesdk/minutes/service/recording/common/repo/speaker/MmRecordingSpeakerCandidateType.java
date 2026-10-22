package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/speaker/MmRecordingSpeakerCandidateType;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "ADD_NEW", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmRecordingSpeakerCandidateType extends Enum<MmRecordingSpeakerCandidateType> {
    public static final MmRecordingSpeakerCandidateType ADD_NEW = null;
    public static final MmRecordingSpeakerCandidateType NORMAL = null;
    public static final /* synthetic */ MmRecordingSpeakerCandidateType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmRecordingSpeakerCandidateType> getEntries() {
        return b;
    }

    static {
        MmRecordingSpeakerCandidateType r0 = new MmRecordingSpeakerCandidateType("NORMAL", 0);
        NORMAL = r0;
        MmRecordingSpeakerCandidateType r1 = new MmRecordingSpeakerCandidateType("ADD_NEW", 1);
        ADD_NEW = r1;
        MmRecordingSpeakerCandidateType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static MmRecordingSpeakerCandidateType[] values() {
        return (MmRecordingSpeakerCandidateType[]) a.clone();
    }

    public static MmRecordingSpeakerCandidateType valueOf(String r1) {
        return (MmRecordingSpeakerCandidateType) r27.a.a(MmRecordingSpeakerCandidateType.class, r1);
    }

    public MmRecordingSpeakerCandidateType(String r1, int r2) {
        super(r1, r2);
    }
}
