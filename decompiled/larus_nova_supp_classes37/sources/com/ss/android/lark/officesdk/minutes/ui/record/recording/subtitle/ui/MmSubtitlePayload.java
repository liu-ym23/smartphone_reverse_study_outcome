package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitlePayload;", "", "<init>", "(Ljava/lang/String;I)V", "CONTENT", "AVATAR", "SPEAKER", "EDIT_STATE", "TIME", "HIGHLIGHT", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmSubtitlePayload extends Enum<MmSubtitlePayload> {
    public static final MmSubtitlePayload AVATAR = null;
    public static final MmSubtitlePayload CONTENT = null;
    public static final MmSubtitlePayload EDIT_STATE = null;
    public static final MmSubtitlePayload HIGHLIGHT = null;
    public static final MmSubtitlePayload SPEAKER = null;
    public static final MmSubtitlePayload TIME = null;
    public static final /* synthetic */ MmSubtitlePayload[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmSubtitlePayload> getEntries() {
        return b;
    }

    static {
        MmSubtitlePayload r0 = new MmSubtitlePayload("CONTENT", 0);
        CONTENT = r0;
        MmSubtitlePayload r1 = new MmSubtitlePayload("AVATAR", 1);
        AVATAR = r1;
        MmSubtitlePayload r3 = new MmSubtitlePayload("SPEAKER", 2);
        SPEAKER = r3;
        MmSubtitlePayload r5 = new MmSubtitlePayload("EDIT_STATE", 3);
        EDIT_STATE = r5;
        MmSubtitlePayload r7 = new MmSubtitlePayload("TIME", 4);
        TIME = r7;
        MmSubtitlePayload r9 = new MmSubtitlePayload("HIGHLIGHT", 5);
        HIGHLIGHT = r9;
        MmSubtitlePayload[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static MmSubtitlePayload[] values() {
        return (MmSubtitlePayload[]) a.clone();
    }

    public static MmSubtitlePayload valueOf(String r1) {
        return (MmSubtitlePayload) r27.a.a(MmSubtitlePayload.class, r1);
    }

    public MmSubtitlePayload(String r1, int r2) {
        super(r1, r2);
    }
}
