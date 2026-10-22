package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/MmSubtitleSpeakerType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "SCD_SPEAKER", "VOICE_PRINT_SPEAKER", "isLarkUser", "", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmSubtitleSpeakerType extends Enum<MmSubtitleSpeakerType> {
    public static final a Companion = null;
    public static final MmSubtitleSpeakerType SCD_SPEAKER = null;
    public static final MmSubtitleSpeakerType UNKNOWN = null;
    public static final MmSubtitleSpeakerType VOICE_PRINT_SPEAKER = null;
    public static final /* synthetic */ MmSubtitleSpeakerType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<MmSubtitleSpeakerType> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmSubtitleSpeakerType$a] */
    static {
        MmSubtitleSpeakerType r0 = new MmSubtitleSpeakerType("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        MmSubtitleSpeakerType r1 = new MmSubtitleSpeakerType("SCD_SPEAKER", 1, 1);
        SCD_SPEAKER = r1;
        MmSubtitleSpeakerType r3 = new MmSubtitleSpeakerType("VOICE_PRINT_SPEAKER", 2, 2);
        VOICE_PRINT_SPEAKER = r3;
        MmSubtitleSpeakerType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static MmSubtitleSpeakerType[] values() {
        return (MmSubtitleSpeakerType[]) a.clone();
    }

    public final boolean isLarkUser() {
        if (this != VOICE_PRINT_SPEAKER) goto L5;
        return true;
    L5:
        return false;
    }

    public final int getValue() {
        return this.value;
    }

    public static MmSubtitleSpeakerType valueOf(String r1) {
        return (MmSubtitleSpeakerType) r27.a.a(MmSubtitleSpeakerType.class, r1);
    }

    public MmSubtitleSpeakerType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
