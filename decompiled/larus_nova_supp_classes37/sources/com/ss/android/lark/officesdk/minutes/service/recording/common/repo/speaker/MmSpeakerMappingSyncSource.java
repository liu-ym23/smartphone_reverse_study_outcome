package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/speaker/MmSpeakerMappingSyncSource;", "", "<init>", "(Ljava/lang/String;I)V", "MEETING_INFO_READY", "SUBTITLE_PUSH", "MANUAL_MARK", "SPEAKER_INFO_CHANGE_PUSH", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmSpeakerMappingSyncSource extends Enum<MmSpeakerMappingSyncSource> {
    public static final MmSpeakerMappingSyncSource MANUAL_MARK = null;
    public static final MmSpeakerMappingSyncSource MEETING_INFO_READY = null;
    public static final MmSpeakerMappingSyncSource SPEAKER_INFO_CHANGE_PUSH = null;
    public static final MmSpeakerMappingSyncSource SUBTITLE_PUSH = null;
    public static final /* synthetic */ MmSpeakerMappingSyncSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmSpeakerMappingSyncSource> getEntries() {
        return b;
    }

    static {
        MmSpeakerMappingSyncSource r0 = new MmSpeakerMappingSyncSource("MEETING_INFO_READY", 0);
        MEETING_INFO_READY = r0;
        MmSpeakerMappingSyncSource r1 = new MmSpeakerMappingSyncSource("SUBTITLE_PUSH", 1);
        SUBTITLE_PUSH = r1;
        MmSpeakerMappingSyncSource r3 = new MmSpeakerMappingSyncSource("MANUAL_MARK", 2);
        MANUAL_MARK = r3;
        MmSpeakerMappingSyncSource r5 = new MmSpeakerMappingSyncSource("SPEAKER_INFO_CHANGE_PUSH", 3);
        SPEAKER_INFO_CHANGE_PUSH = r5;
        MmSpeakerMappingSyncSource[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static MmSpeakerMappingSyncSource[] values() {
        return (MmSpeakerMappingSyncSource[]) a.clone();
    }

    public static MmSpeakerMappingSyncSource valueOf(String r1) {
        return (MmSpeakerMappingSyncSource) r27.a.a(MmSpeakerMappingSyncSource.class, r1);
    }

    public MmSpeakerMappingSyncSource(String r1, int r2) {
        super(r1, r2);
    }
}
