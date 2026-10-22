package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINoteSheetState;", "", "<init>", "(Ljava/lang/String;I)V", "FULL", "HALF", "CLOSED", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmAINoteSheetState extends Enum<MmAINoteSheetState> {
    public static final MmAINoteSheetState CLOSED = null;
    public static final MmAINoteSheetState FULL = null;
    public static final MmAINoteSheetState HALF = null;
    public static final /* synthetic */ MmAINoteSheetState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmAINoteSheetState> getEntries() {
        return b;
    }

    static {
        MmAINoteSheetState r0 = new MmAINoteSheetState("FULL", 0);
        FULL = r0;
        MmAINoteSheetState r1 = new MmAINoteSheetState("HALF", 1);
        HALF = r1;
        MmAINoteSheetState r3 = new MmAINoteSheetState("CLOSED", 2);
        CLOSED = r3;
        MmAINoteSheetState[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static MmAINoteSheetState[] values() {
        return (MmAINoteSheetState[]) a.clone();
    }

    public static MmAINoteSheetState valueOf(String r1) {
        return (MmAINoteSheetState) r27.a.a(MmAINoteSheetState.class, r1);
    }

    public MmAINoteSheetState(String r1, int r2) {
        super(r1, r2);
    }
}
