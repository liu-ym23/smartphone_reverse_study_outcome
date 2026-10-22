package com.ss.android.lark.officesdk.minutes.api.recording.common.data;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmHardwareRecordingAudioRoute;", "", "<init>", "(Ljava/lang/String;I)V", "BLUETOOTH", "SPEAKER", "WIRED_HEADSET", "EARPIECE", "UNKNOWN", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmHardwareRecordingAudioRoute extends Enum<MmHardwareRecordingAudioRoute> {
    public static final MmHardwareRecordingAudioRoute BLUETOOTH = null;
    public static final MmHardwareRecordingAudioRoute EARPIECE = null;
    public static final MmHardwareRecordingAudioRoute SPEAKER = null;
    public static final MmHardwareRecordingAudioRoute UNKNOWN = null;
    public static final MmHardwareRecordingAudioRoute WIRED_HEADSET = null;
    public static final /* synthetic */ MmHardwareRecordingAudioRoute[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmHardwareRecordingAudioRoute> getEntries() {
        return b;
    }

    static {
        MmHardwareRecordingAudioRoute r0 = new MmHardwareRecordingAudioRoute("BLUETOOTH", 0);
        BLUETOOTH = r0;
        MmHardwareRecordingAudioRoute r1 = new MmHardwareRecordingAudioRoute("SPEAKER", 1);
        SPEAKER = r1;
        MmHardwareRecordingAudioRoute r3 = new MmHardwareRecordingAudioRoute("WIRED_HEADSET", 2);
        WIRED_HEADSET = r3;
        MmHardwareRecordingAudioRoute r5 = new MmHardwareRecordingAudioRoute("EARPIECE", 3);
        EARPIECE = r5;
        MmHardwareRecordingAudioRoute r7 = new MmHardwareRecordingAudioRoute("UNKNOWN", 4);
        UNKNOWN = r7;
        MmHardwareRecordingAudioRoute[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static MmHardwareRecordingAudioRoute[] values() {
        return (MmHardwareRecordingAudioRoute[]) a.clone();
    }

    public static MmHardwareRecordingAudioRoute valueOf(String r1) {
        return (MmHardwareRecordingAudioRoute) a.a(MmHardwareRecordingAudioRoute.class, r1);
    }

    public MmHardwareRecordingAudioRoute(String r1, int r2) {
        super(r1, r2);
    }
}
