package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/meta/MmRecordingWindowMode;", "", "<init>", "(Ljava/lang/String;I)V", "FULL_SCREEN_ACTIVITY", "FLOAT_WINDOW", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmRecordingWindowMode extends Enum<MmRecordingWindowMode> {
    public static final MmRecordingWindowMode FLOAT_WINDOW = null;
    public static final MmRecordingWindowMode FULL_SCREEN_ACTIVITY = null;
    public static final /* synthetic */ MmRecordingWindowMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmRecordingWindowMode> getEntries() {
        return b;
    }

    static {
        MmRecordingWindowMode r0 = new MmRecordingWindowMode("FULL_SCREEN_ACTIVITY", 0);
        FULL_SCREEN_ACTIVITY = r0;
        MmRecordingWindowMode r1 = new MmRecordingWindowMode("FLOAT_WINDOW", 1);
        FLOAT_WINDOW = r1;
        MmRecordingWindowMode[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static MmRecordingWindowMode[] values() {
        return (MmRecordingWindowMode[]) a.clone();
    }

    public static MmRecordingWindowMode valueOf(String r1) {
        return (MmRecordingWindowMode) r27.a.a(MmRecordingWindowMode.class, r1);
    }

    public MmRecordingWindowMode(String r1, int r2) {
        super(r1, r2);
    }
}
