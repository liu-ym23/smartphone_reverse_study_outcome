package com.ss.android.lark.officesdk.minutes.service.recording.common.core.data;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u000bJ\u0006\u0010\u0010\u001a\u00020\u0011j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/data/RecordingSessionType;", "", "<init>", "(Ljava/lang/String;I)V", "SOFTWARE_RECORDING", "HARDWARE_RECORDING", "HARDWARE_LIVE_RECORDING", "HISTORY_RECORDING", "PRE_MEETING_NATIVE_RECORDING", "STANDALONE_AI_INTERPRETATION", "isRealTimeRecordingOrInterpretation", "", "isRecordingFeatureSession", "isRealTimeRecording", "isHardwareRecording", "shouldCreateAudioService", "audioCaptureMode", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/data/MmRecordingAudioCaptureMode;", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum RecordingSessionType extends Enum<RecordingSessionType> {
    public static final RecordingSessionType HARDWARE_LIVE_RECORDING = null;
    public static final RecordingSessionType HARDWARE_RECORDING = null;
    public static final RecordingSessionType HISTORY_RECORDING = null;
    public static final RecordingSessionType PRE_MEETING_NATIVE_RECORDING = null;
    public static final RecordingSessionType SOFTWARE_RECORDING = null;
    public static final RecordingSessionType STANDALONE_AI_INTERPRETATION = null;
    public static final /* synthetic */ RecordingSessionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RecordingSessionType.values().length];
            r0[RecordingSessionType.PRE_MEETING_NATIVE_RECORDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[RecordingSessionType.HARDWARE_LIVE_RECORDING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static EnumEntries<RecordingSessionType> getEntries() {
        return b;
    }

    static {
        RecordingSessionType r0 = new RecordingSessionType("SOFTWARE_RECORDING", 0);
        SOFTWARE_RECORDING = r0;
        RecordingSessionType r1 = new RecordingSessionType("HARDWARE_RECORDING", 1);
        HARDWARE_RECORDING = r1;
        RecordingSessionType r3 = new RecordingSessionType("HARDWARE_LIVE_RECORDING", 2);
        HARDWARE_LIVE_RECORDING = r3;
        RecordingSessionType r5 = new RecordingSessionType("HISTORY_RECORDING", 3);
        HISTORY_RECORDING = r5;
        RecordingSessionType r7 = new RecordingSessionType("PRE_MEETING_NATIVE_RECORDING", 4);
        PRE_MEETING_NATIVE_RECORDING = r7;
        RecordingSessionType r9 = new RecordingSessionType("STANDALONE_AI_INTERPRETATION", 5);
        STANDALONE_AI_INTERPRETATION = r9;
        RecordingSessionType[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static RecordingSessionType[] values() {
        return (RecordingSessionType[]) a.clone();
    }

    public final MmRecordingAudioCaptureMode audioCaptureMode() {
        int r0 = a.a[ordinal()];
        if (r0 == 1) goto L8;
        if (r0 == 2) goto L8;
        return MmRecordingAudioCaptureMode.RTC;
    L8:
        return MmRecordingAudioCaptureMode.EXTERNAL_AUDIO_SOURCE;
    }

    public final boolean isHardwareRecording() {
        if (this != HARDWARE_RECORDING) goto L5;
    L10:
        return true;
    L5:
        if (this == HARDWARE_LIVE_RECORDING) goto L10;
        if (this == PRE_MEETING_NATIVE_RECORDING) goto L10;
        return false;
    }

    public final boolean isRealTimeRecordingOrInterpretation() {
        if (this != SOFTWARE_RECORDING) goto L5;
    L14:
        return true;
    L5:
        if (this == HARDWARE_RECORDING) goto L14;
        if (this == HARDWARE_LIVE_RECORDING) goto L14;
        if (this == PRE_MEETING_NATIVE_RECORDING) goto L14;
        if (this == STANDALONE_AI_INTERPRETATION) goto L14;
        return false;
    }

    public final boolean isRecordingFeatureSession() {
        if (this != SOFTWARE_RECORDING) goto L5;
    L12:
        return true;
    L5:
        if (this == HARDWARE_RECORDING) goto L12;
        if (this == HARDWARE_LIVE_RECORDING) goto L12;
        if (this == PRE_MEETING_NATIVE_RECORDING) goto L12;
        return false;
    }

    public final boolean shouldCreateAudioService() {
        if (this != SOFTWARE_RECORDING) goto L5;
    L12:
        return true;
    L5:
        if (this == STANDALONE_AI_INTERPRETATION) goto L12;
        if (this == PRE_MEETING_NATIVE_RECORDING) goto L12;
        if (this == HARDWARE_LIVE_RECORDING) goto L12;
        return false;
    }

    public final boolean isRealTimeRecording() {
        return isRecordingFeatureSession();
    }

    public static RecordingSessionType valueOf(String r1) {
        return (RecordingSessionType) r27.a.a(RecordingSessionType.class, r1);
    }

    public RecordingSessionType(String r1, int r2) {
        super(r1, r2);
    }
}
