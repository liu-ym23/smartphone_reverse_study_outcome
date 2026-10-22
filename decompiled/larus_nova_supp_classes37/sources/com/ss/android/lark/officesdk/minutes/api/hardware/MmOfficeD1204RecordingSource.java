package com.ss.android.lark.officesdk.minutes.api.hardware;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/hardware/MmOfficeD1204RecordingSource;", "", "<init>", "(Ljava/lang/String;I)V", "EARBUDS", "CHARGING_CASE", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmOfficeD1204RecordingSource extends Enum<MmOfficeD1204RecordingSource> {
    public static final MmOfficeD1204RecordingSource CHARGING_CASE = null;
    public static final MmOfficeD1204RecordingSource EARBUDS = null;
    public static final /* synthetic */ MmOfficeD1204RecordingSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmOfficeD1204RecordingSource> getEntries() {
        return b;
    }

    static {
        MmOfficeD1204RecordingSource r0 = new MmOfficeD1204RecordingSource("EARBUDS", 0);
        EARBUDS = r0;
        MmOfficeD1204RecordingSource r1 = new MmOfficeD1204RecordingSource("CHARGING_CASE", 1);
        CHARGING_CASE = r1;
        MmOfficeD1204RecordingSource[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static MmOfficeD1204RecordingSource[] values() {
        return (MmOfficeD1204RecordingSource[]) a.clone();
    }

    public static MmOfficeD1204RecordingSource valueOf(String r1) {
        return (MmOfficeD1204RecordingSource) r27.a.a(MmOfficeD1204RecordingSource.class, r1);
    }

    public MmOfficeD1204RecordingSource(String r1, int r2) {
        super(r1, r2);
    }
}
