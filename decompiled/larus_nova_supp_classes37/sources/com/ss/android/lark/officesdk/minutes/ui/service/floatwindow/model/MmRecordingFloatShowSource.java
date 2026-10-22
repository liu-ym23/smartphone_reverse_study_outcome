package com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.model;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/service/floatwindow/model/MmRecordingFloatShowSource;", "", "<init>", "(Ljava/lang/String;I)V", "USER_LEAVE", "PAGE_INVISIBLE", "APP_BACKGROUND", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmRecordingFloatShowSource extends Enum<MmRecordingFloatShowSource> {
    public static final MmRecordingFloatShowSource APP_BACKGROUND = null;
    public static final MmRecordingFloatShowSource PAGE_INVISIBLE = null;
    public static final MmRecordingFloatShowSource USER_LEAVE = null;
    public static final /* synthetic */ MmRecordingFloatShowSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmRecordingFloatShowSource> getEntries() {
        return b;
    }

    static {
        MmRecordingFloatShowSource r0 = new MmRecordingFloatShowSource("USER_LEAVE", 0);
        USER_LEAVE = r0;
        MmRecordingFloatShowSource r1 = new MmRecordingFloatShowSource("PAGE_INVISIBLE", 1);
        PAGE_INVISIBLE = r1;
        MmRecordingFloatShowSource r3 = new MmRecordingFloatShowSource("APP_BACKGROUND", 2);
        APP_BACKGROUND = r3;
        MmRecordingFloatShowSource[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static MmRecordingFloatShowSource[] values() {
        return (MmRecordingFloatShowSource[]) a.clone();
    }

    public static MmRecordingFloatShowSource valueOf(String r1) {
        return (MmRecordingFloatShowSource) a.a(MmRecordingFloatShowSource.class, r1);
    }

    public MmRecordingFloatShowSource(String r1, int r2) {
        super(r1, r2);
    }
}
