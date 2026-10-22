package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleHighlightStyle;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "JUMP", "SELECTED", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmSubtitleHighlightStyle extends Enum<MmSubtitleHighlightStyle> {
    public static final MmSubtitleHighlightStyle JUMP = null;
    public static final MmSubtitleHighlightStyle NONE = null;
    public static final MmSubtitleHighlightStyle SELECTED = null;
    public static final /* synthetic */ MmSubtitleHighlightStyle[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmSubtitleHighlightStyle> getEntries() {
        return b;
    }

    static {
        MmSubtitleHighlightStyle r0 = new MmSubtitleHighlightStyle("NONE", 0);
        NONE = r0;
        MmSubtitleHighlightStyle r1 = new MmSubtitleHighlightStyle("JUMP", 1);
        JUMP = r1;
        MmSubtitleHighlightStyle r3 = new MmSubtitleHighlightStyle("SELECTED", 2);
        SELECTED = r3;
        MmSubtitleHighlightStyle[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static MmSubtitleHighlightStyle[] values() {
        return (MmSubtitleHighlightStyle[]) a.clone();
    }

    public static MmSubtitleHighlightStyle valueOf(String r1) {
        return (MmSubtitleHighlightStyle) r27.a.a(MmSubtitleHighlightStyle.class, r1);
    }

    public MmSubtitleHighlightStyle(String r1, int r2) {
        super(r1, r2);
    }
}
