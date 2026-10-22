package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/MmSubtitleScrollMode;", "", "<init>", "(Ljava/lang/String;I)V", "FOLLOW", "FREE", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmSubtitleScrollMode extends Enum<MmSubtitleScrollMode> {
    public static final MmSubtitleScrollMode FOLLOW = null;
    public static final MmSubtitleScrollMode FREE = null;
    public static final /* synthetic */ MmSubtitleScrollMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmSubtitleScrollMode> getEntries() {
        return b;
    }

    static {
        MmSubtitleScrollMode r0 = new MmSubtitleScrollMode("FOLLOW", 0);
        FOLLOW = r0;
        MmSubtitleScrollMode r1 = new MmSubtitleScrollMode("FREE", 1);
        FREE = r1;
        MmSubtitleScrollMode[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static MmSubtitleScrollMode[] values() {
        return (MmSubtitleScrollMode[]) a.clone();
    }

    public static MmSubtitleScrollMode valueOf(String r1) {
        return (MmSubtitleScrollMode) r27.a.a(MmSubtitleScrollMode.class, r1);
    }

    public MmSubtitleScrollMode(String r1, int r2) {
        super(r1, r2);
    }
}
