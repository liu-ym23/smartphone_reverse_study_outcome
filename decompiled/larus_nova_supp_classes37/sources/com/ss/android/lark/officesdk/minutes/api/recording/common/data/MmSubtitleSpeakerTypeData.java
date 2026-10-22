package com.ss.android.lark.officesdk.minutes.api.recording.common.data;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmSubtitleSpeakerTypeData;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "NORMAL", "SCD_SPEAKER", "VOICE_PRINT_SPEAKER", "toString", "", "Companion", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmSubtitleSpeakerTypeData extends Enum<MmSubtitleSpeakerTypeData> {
    public static final a Companion = null;
    public static final MmSubtitleSpeakerTypeData NORMAL = null;
    public static final MmSubtitleSpeakerTypeData SCD_SPEAKER = null;
    public static final MmSubtitleSpeakerTypeData UNKNOWN = null;
    public static final MmSubtitleSpeakerTypeData VOICE_PRINT_SPEAKER = null;
    public static final /* synthetic */ MmSubtitleSpeakerTypeData[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<MmSubtitleSpeakerTypeData> getEntries() {
        return b;
    }

    static {
        MmSubtitleSpeakerTypeData r0 = new MmSubtitleSpeakerTypeData("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        MmSubtitleSpeakerTypeData r1 = new MmSubtitleSpeakerTypeData("NORMAL", 1, 1);
        NORMAL = r1;
        MmSubtitleSpeakerTypeData r3 = new MmSubtitleSpeakerTypeData("SCD_SPEAKER", 2, 2);
        SCD_SPEAKER = r3;
        MmSubtitleSpeakerTypeData r5 = new MmSubtitleSpeakerTypeData("VOICE_PRINT_SPEAKER", 3, 3);
        VOICE_PRINT_SPEAKER = r5;
        MmSubtitleSpeakerTypeData[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
        Companion = new a();
    }

    public static MmSubtitleSpeakerTypeData[] values() {
        return (MmSubtitleSpeakerTypeData[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "MmSubtitleSpeakerTypeData(name=" + name() + ", value=" + this.value + ')';
    }

    public final int getValue() {
        return this.value;
    }

    public static MmSubtitleSpeakerTypeData valueOf(String r1) {
        return (MmSubtitleSpeakerTypeData) r27.a.a(MmSubtitleSpeakerTypeData.class, r1);
    }

    public MmSubtitleSpeakerTypeData(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
