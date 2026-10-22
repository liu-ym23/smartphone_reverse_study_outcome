package com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.model;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/slot/model/MmRecordingNestedScrollMode;", "", "<init>", "(Ljava/lang/String;I)V", "Disabled", "Enabled", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmRecordingNestedScrollMode extends Enum<MmRecordingNestedScrollMode> {
    public static final MmRecordingNestedScrollMode Disabled = null;
    public static final MmRecordingNestedScrollMode Enabled = null;
    public static final /* synthetic */ MmRecordingNestedScrollMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmRecordingNestedScrollMode> getEntries() {
        return b;
    }

    static {
        MmRecordingNestedScrollMode r0 = new MmRecordingNestedScrollMode("Disabled", 0);
        Disabled = r0;
        MmRecordingNestedScrollMode r1 = new MmRecordingNestedScrollMode("Enabled", 1);
        Enabled = r1;
        MmRecordingNestedScrollMode[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static MmRecordingNestedScrollMode[] values() {
        return (MmRecordingNestedScrollMode[]) a.clone();
    }

    public static MmRecordingNestedScrollMode valueOf(String r1) {
        return (MmRecordingNestedScrollMode) a.a(MmRecordingNestedScrollMode.class, r1);
    }

    public MmRecordingNestedScrollMode(String r1, int r2) {
        super(r1, r2);
    }
}
