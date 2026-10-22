package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/statistics/HardwareRecordSource;", "", "trackValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTrackValue", "()Ljava/lang/String;", "CALL", "APP", "MEDIA", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum HardwareRecordSource extends Enum<HardwareRecordSource> {
    public static final HardwareRecordSource APP = null;
    public static final HardwareRecordSource CALL = null;
    public static final HardwareRecordSource MEDIA = null;
    public static final /* synthetic */ HardwareRecordSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String trackValue;

    public static EnumEntries<HardwareRecordSource> getEntries() {
        return b;
    }

    static {
        HardwareRecordSource r0 = new HardwareRecordSource("CALL", 0, "call");
        CALL = r0;
        HardwareRecordSource r1 = new HardwareRecordSource("APP", 1, "app");
        APP = r1;
        HardwareRecordSource r2 = new HardwareRecordSource("MEDIA", 2, "media");
        MEDIA = r2;
        HardwareRecordSource[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static HardwareRecordSource[] values() {
        return (HardwareRecordSource[]) a.clone();
    }

    public final String getTrackValue() {
        return this.trackValue;
    }

    public static HardwareRecordSource valueOf(String r1) {
        return (HardwareRecordSource) r27.a.a(HardwareRecordSource.class, r1);
    }

    public HardwareRecordSource(String r1, int r2, String r3) {
        super(r1, r2);
        this.trackValue = r3;
    }
}
