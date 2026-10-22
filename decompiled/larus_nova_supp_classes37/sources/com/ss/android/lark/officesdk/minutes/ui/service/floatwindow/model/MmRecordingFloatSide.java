package com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.model;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/service/floatwindow/model/MmRecordingFloatSide;", "", "<init>", "(Ljava/lang/String;I)V", "LEFT", "RIGHT", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmRecordingFloatSide extends Enum<MmRecordingFloatSide> {
    public static final MmRecordingFloatSide LEFT = null;
    public static final MmRecordingFloatSide RIGHT = null;
    public static final /* synthetic */ MmRecordingFloatSide[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmRecordingFloatSide> getEntries() {
        return b;
    }

    static {
        MmRecordingFloatSide r0 = new MmRecordingFloatSide("LEFT", 0);
        LEFT = r0;
        MmRecordingFloatSide r1 = new MmRecordingFloatSide("RIGHT", 1);
        RIGHT = r1;
        MmRecordingFloatSide[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static MmRecordingFloatSide[] values() {
        return (MmRecordingFloatSide[]) a.clone();
    }

    public static MmRecordingFloatSide valueOf(String r1) {
        return (MmRecordingFloatSide) a.a(MmRecordingFloatSide.class, r1);
    }

    public MmRecordingFloatSide(String r1, int r2) {
        super(r1, r2);
    }
}
