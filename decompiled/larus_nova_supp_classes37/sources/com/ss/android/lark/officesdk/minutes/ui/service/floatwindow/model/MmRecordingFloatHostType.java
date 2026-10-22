package com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.model;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/service/floatwindow/model/MmRecordingFloatHostType;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "SYSTEM", "ACTIVITY", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmRecordingFloatHostType extends Enum<MmRecordingFloatHostType> {
    public static final MmRecordingFloatHostType ACTIVITY = null;
    public static final MmRecordingFloatHostType NONE = null;
    public static final MmRecordingFloatHostType SYSTEM = null;
    public static final /* synthetic */ MmRecordingFloatHostType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmRecordingFloatHostType> getEntries() {
        return b;
    }

    static {
        MmRecordingFloatHostType r0 = new MmRecordingFloatHostType("NONE", 0);
        NONE = r0;
        MmRecordingFloatHostType r1 = new MmRecordingFloatHostType("SYSTEM", 1);
        SYSTEM = r1;
        MmRecordingFloatHostType r3 = new MmRecordingFloatHostType("ACTIVITY", 2);
        ACTIVITY = r3;
        MmRecordingFloatHostType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static MmRecordingFloatHostType[] values() {
        return (MmRecordingFloatHostType[]) a.clone();
    }

    public static MmRecordingFloatHostType valueOf(String r1) {
        return (MmRecordingFloatHostType) a.a(MmRecordingFloatHostType.class, r1);
    }

    public MmRecordingFloatHostType(String r1, int r2) {
        super(r1, r2);
    }
}
