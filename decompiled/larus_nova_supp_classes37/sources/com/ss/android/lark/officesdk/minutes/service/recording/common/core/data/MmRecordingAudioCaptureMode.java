package com.ss.android.lark.officesdk.minutes.service.recording.common.core.data;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/data/MmRecordingAudioCaptureMode;", "", "<init>", "(Ljava/lang/String;I)V", "RTC", "EXTERNAL_AUDIO_SOURCE", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmRecordingAudioCaptureMode extends Enum<MmRecordingAudioCaptureMode> {
    public static final MmRecordingAudioCaptureMode EXTERNAL_AUDIO_SOURCE = null;
    public static final MmRecordingAudioCaptureMode RTC = null;
    public static final /* synthetic */ MmRecordingAudioCaptureMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmRecordingAudioCaptureMode> getEntries() {
        return b;
    }

    static {
        MmRecordingAudioCaptureMode r0 = new MmRecordingAudioCaptureMode("RTC", 0);
        RTC = r0;
        MmRecordingAudioCaptureMode r1 = new MmRecordingAudioCaptureMode("EXTERNAL_AUDIO_SOURCE", 1);
        EXTERNAL_AUDIO_SOURCE = r1;
        MmRecordingAudioCaptureMode[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static MmRecordingAudioCaptureMode[] values() {
        return (MmRecordingAudioCaptureMode[]) a.clone();
    }

    public static MmRecordingAudioCaptureMode valueOf(String r1) {
        return (MmRecordingAudioCaptureMode) a.a(MmRecordingAudioCaptureMode.class, r1);
    }

    public MmRecordingAudioCaptureMode(String r1, int r2) {
        super(r1, r2);
    }
}
