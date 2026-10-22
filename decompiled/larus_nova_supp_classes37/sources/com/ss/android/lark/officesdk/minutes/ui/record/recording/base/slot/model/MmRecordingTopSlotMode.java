package com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.model;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/slot/model/MmRecordingTopSlotMode;", "", "<init>", "(Ljava/lang/String;I)V", "OCCUPY", "OVERLAY", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmRecordingTopSlotMode extends Enum<MmRecordingTopSlotMode> {
    public static final MmRecordingTopSlotMode OCCUPY = null;
    public static final MmRecordingTopSlotMode OVERLAY = null;
    public static final /* synthetic */ MmRecordingTopSlotMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmRecordingTopSlotMode> getEntries() {
        return b;
    }

    static {
        MmRecordingTopSlotMode r0 = new MmRecordingTopSlotMode("OCCUPY", 0);
        OCCUPY = r0;
        MmRecordingTopSlotMode r1 = new MmRecordingTopSlotMode("OVERLAY", 1);
        OVERLAY = r1;
        MmRecordingTopSlotMode[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static MmRecordingTopSlotMode[] values() {
        return (MmRecordingTopSlotMode[]) a.clone();
    }

    public static MmRecordingTopSlotMode valueOf(String r1) {
        return (MmRecordingTopSlotMode) a.a(MmRecordingTopSlotMode.class, r1);
    }

    public MmRecordingTopSlotMode(String r1, int r2) {
        super(r1, r2);
    }
}
