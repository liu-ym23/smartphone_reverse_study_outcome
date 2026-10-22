package com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.model;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/service/floatwindow/model/MmRecordingFloatLifecycleState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "SHOWING", "SHOWN", "DISMISSING", "DISMISSED", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmRecordingFloatLifecycleState extends Enum<MmRecordingFloatLifecycleState> {
    public static final MmRecordingFloatLifecycleState DISMISSED = null;
    public static final MmRecordingFloatLifecycleState DISMISSING = null;
    public static final MmRecordingFloatLifecycleState IDLE = null;
    public static final MmRecordingFloatLifecycleState SHOWING = null;
    public static final MmRecordingFloatLifecycleState SHOWN = null;
    public static final /* synthetic */ MmRecordingFloatLifecycleState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmRecordingFloatLifecycleState> getEntries() {
        return b;
    }

    static {
        MmRecordingFloatLifecycleState r0 = new MmRecordingFloatLifecycleState("IDLE", 0);
        IDLE = r0;
        MmRecordingFloatLifecycleState r1 = new MmRecordingFloatLifecycleState("SHOWING", 1);
        SHOWING = r1;
        MmRecordingFloatLifecycleState r3 = new MmRecordingFloatLifecycleState("SHOWN", 2);
        SHOWN = r3;
        MmRecordingFloatLifecycleState r5 = new MmRecordingFloatLifecycleState("DISMISSING", 3);
        DISMISSING = r5;
        MmRecordingFloatLifecycleState r7 = new MmRecordingFloatLifecycleState("DISMISSED", 4);
        DISMISSED = r7;
        MmRecordingFloatLifecycleState[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static MmRecordingFloatLifecycleState[] values() {
        return (MmRecordingFloatLifecycleState[]) a.clone();
    }

    public static MmRecordingFloatLifecycleState valueOf(String r1) {
        return (MmRecordingFloatLifecycleState) a.a(MmRecordingFloatLifecycleState.class, r1);
    }

    public MmRecordingFloatLifecycleState(String r1, int r2) {
        super(r1, r2);
    }
}
