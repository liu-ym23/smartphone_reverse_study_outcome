package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/MmDisplaySpeakerEditBackgroundStyle;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "DISABLE_MARKED", "DISABLE_UNMARKED", "EDITABLE_MARKED", "EDITABLE_UNMARKED", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmDisplaySpeakerEditBackgroundStyle extends Enum<MmDisplaySpeakerEditBackgroundStyle> {
    public static final MmDisplaySpeakerEditBackgroundStyle DISABLE_MARKED = null;
    public static final MmDisplaySpeakerEditBackgroundStyle DISABLE_UNMARKED = null;
    public static final MmDisplaySpeakerEditBackgroundStyle EDITABLE_MARKED = null;
    public static final MmDisplaySpeakerEditBackgroundStyle EDITABLE_UNMARKED = null;
    public static final MmDisplaySpeakerEditBackgroundStyle NONE = null;
    public static final /* synthetic */ MmDisplaySpeakerEditBackgroundStyle[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmDisplaySpeakerEditBackgroundStyle> getEntries() {
        return b;
    }

    static {
        MmDisplaySpeakerEditBackgroundStyle r0 = new MmDisplaySpeakerEditBackgroundStyle("NONE", 0);
        NONE = r0;
        MmDisplaySpeakerEditBackgroundStyle r1 = new MmDisplaySpeakerEditBackgroundStyle("DISABLE_MARKED", 1);
        DISABLE_MARKED = r1;
        MmDisplaySpeakerEditBackgroundStyle r3 = new MmDisplaySpeakerEditBackgroundStyle("DISABLE_UNMARKED", 2);
        DISABLE_UNMARKED = r3;
        MmDisplaySpeakerEditBackgroundStyle r5 = new MmDisplaySpeakerEditBackgroundStyle("EDITABLE_MARKED", 3);
        EDITABLE_MARKED = r5;
        MmDisplaySpeakerEditBackgroundStyle r7 = new MmDisplaySpeakerEditBackgroundStyle("EDITABLE_UNMARKED", 4);
        EDITABLE_UNMARKED = r7;
        MmDisplaySpeakerEditBackgroundStyle[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static MmDisplaySpeakerEditBackgroundStyle[] values() {
        return (MmDisplaySpeakerEditBackgroundStyle[]) a.clone();
    }

    public static MmDisplaySpeakerEditBackgroundStyle valueOf(String r1) {
        return (MmDisplaySpeakerEditBackgroundStyle) r27.a.a(MmDisplaySpeakerEditBackgroundStyle.class, r1);
    }

    public MmDisplaySpeakerEditBackgroundStyle(String r1, int r2) {
        super(r1, r2);
    }
}
