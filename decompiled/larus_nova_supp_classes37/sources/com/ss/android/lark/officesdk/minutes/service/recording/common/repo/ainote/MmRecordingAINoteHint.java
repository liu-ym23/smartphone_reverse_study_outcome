package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/ainote/MmRecordingAINoteHint;", "", "<init>", "(Ljava/lang/String;I)V", "SubtitleMissing", "MarkThrottle", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmRecordingAINoteHint extends Enum<MmRecordingAINoteHint> {
    public static final MmRecordingAINoteHint MarkThrottle = null;
    public static final MmRecordingAINoteHint SubtitleMissing = null;
    public static final /* synthetic */ MmRecordingAINoteHint[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmRecordingAINoteHint> getEntries() {
        return b;
    }

    static {
        MmRecordingAINoteHint r0 = new MmRecordingAINoteHint("SubtitleMissing", 0);
        SubtitleMissing = r0;
        MmRecordingAINoteHint r1 = new MmRecordingAINoteHint("MarkThrottle", 1);
        MarkThrottle = r1;
        MmRecordingAINoteHint[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static MmRecordingAINoteHint[] values() {
        return (MmRecordingAINoteHint[]) a.clone();
    }

    public static MmRecordingAINoteHint valueOf(String r1) {
        return (MmRecordingAINoteHint) r27.a.a(MmRecordingAINoteHint.class, r1);
    }

    public MmRecordingAINoteHint(String r1, int r2) {
        super(r1, r2);
    }
}
