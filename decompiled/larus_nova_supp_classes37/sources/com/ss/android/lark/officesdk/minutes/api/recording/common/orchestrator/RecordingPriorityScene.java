package com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/orchestrator/RecordingPriorityScene;", "", "<init>", "(Ljava/lang/String;I)V", "D3200_RECORDING", "D3200_FILE_SYNC", "D1204_CHARGING_CASE_RECORDING", "D1204_CHARGING_CASE_FILE_SYNC", "D1204_UPLOAD_WALLPAPER", "SOFTWARE_RECORDING", "STANDALONE_AI_INTERPRETATION", "MEDIA_RECORD", "CALL_RECORD", "VIDEO_CONFERENCE", "OTA", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum RecordingPriorityScene extends Enum<RecordingPriorityScene> {
    public static final RecordingPriorityScene CALL_RECORD = null;
    public static final RecordingPriorityScene D1204_CHARGING_CASE_FILE_SYNC = null;
    public static final RecordingPriorityScene D1204_CHARGING_CASE_RECORDING = null;
    public static final RecordingPriorityScene D1204_UPLOAD_WALLPAPER = null;
    public static final RecordingPriorityScene D3200_FILE_SYNC = null;
    public static final RecordingPriorityScene D3200_RECORDING = null;
    public static final RecordingPriorityScene MEDIA_RECORD = null;
    public static final RecordingPriorityScene OTA = null;
    public static final RecordingPriorityScene SOFTWARE_RECORDING = null;
    public static final RecordingPriorityScene STANDALONE_AI_INTERPRETATION = null;
    public static final RecordingPriorityScene VIDEO_CONFERENCE = null;
    public static final /* synthetic */ RecordingPriorityScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<RecordingPriorityScene> getEntries() {
        return b;
    }

    static {
        RecordingPriorityScene r0 = new RecordingPriorityScene("D3200_RECORDING", 0);
        D3200_RECORDING = r0;
        RecordingPriorityScene r1 = new RecordingPriorityScene("D3200_FILE_SYNC", 1);
        D3200_FILE_SYNC = r1;
        RecordingPriorityScene r3 = new RecordingPriorityScene("D1204_CHARGING_CASE_RECORDING", 2);
        D1204_CHARGING_CASE_RECORDING = r3;
        RecordingPriorityScene r5 = new RecordingPriorityScene("D1204_CHARGING_CASE_FILE_SYNC", 3);
        D1204_CHARGING_CASE_FILE_SYNC = r5;
        RecordingPriorityScene r7 = new RecordingPriorityScene("D1204_UPLOAD_WALLPAPER", 4);
        D1204_UPLOAD_WALLPAPER = r7;
        RecordingPriorityScene r9 = new RecordingPriorityScene("SOFTWARE_RECORDING", 5);
        SOFTWARE_RECORDING = r9;
        RecordingPriorityScene r11 = new RecordingPriorityScene("STANDALONE_AI_INTERPRETATION", 6);
        STANDALONE_AI_INTERPRETATION = r11;
        RecordingPriorityScene r13 = new RecordingPriorityScene("MEDIA_RECORD", 7);
        MEDIA_RECORD = r13;
        RecordingPriorityScene r15 = new RecordingPriorityScene("CALL_RECORD", 8);
        CALL_RECORD = r15;
        RecordingPriorityScene r14 = new RecordingPriorityScene("VIDEO_CONFERENCE", 9);
        VIDEO_CONFERENCE = r14;
        RecordingPriorityScene r12 = new RecordingPriorityScene("OTA", 10);
        OTA = r12;
        RecordingPriorityScene[] r10 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
    }

    public static RecordingPriorityScene[] values() {
        return (RecordingPriorityScene[]) a.clone();
    }

    public static RecordingPriorityScene valueOf(String r1) {
        return (RecordingPriorityScene) a.a(RecordingPriorityScene.class, r1);
    }

    public RecordingPriorityScene(String r1, int r2) {
        super(r1, r2);
    }
}
