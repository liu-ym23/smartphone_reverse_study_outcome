package com.ss.android.lark.officesdk.minutes.api.recording.common.data;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "RECORDING", "PAUSED", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmRecordingState extends Enum<MmRecordingState> {
    public static final MmRecordingState IDLE = null;
    public static final MmRecordingState PAUSED = null;
    public static final MmRecordingState RECORDING = null;
    public static final /* synthetic */ MmRecordingState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmRecordingState> getEntries() {
        return b;
    }

    static {
        MmRecordingState r0 = new MmRecordingState("IDLE", 0);
        IDLE = r0;
        MmRecordingState r1 = new MmRecordingState("RECORDING", 1);
        RECORDING = r1;
        MmRecordingState r3 = new MmRecordingState("PAUSED", 2);
        PAUSED = r3;
        MmRecordingState[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static MmRecordingState[] values() {
        return (MmRecordingState[]) a.clone();
    }

    public static MmRecordingState valueOf(String r1) {
        return (MmRecordingState) a.a(MmRecordingState.class, r1);
    }

    public MmRecordingState(String r1, int r2) {
        super(r1, r2);
    }
}
