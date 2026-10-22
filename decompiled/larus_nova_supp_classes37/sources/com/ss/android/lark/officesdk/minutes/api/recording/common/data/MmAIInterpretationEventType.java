package com.ss.android.lark.officesdk.minutes.api.recording.common.data;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0015\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmAIInterpretationEventType;", "", "<init>", "(Ljava/lang/String;I)V", "TARGET_LANGUAGE_SELECTED", "TARGET_LANGUAGE_UNCHANGED", "START_SUCCESS", "START_FAILED", "STOP_SUCCESS", "STOP_FAILED", "SWITCH_SUCCESS", "SWITCH_FAILED", "NO_TARGET_LANGUAGE", "LANGUAGE_LIST_EMPTY", "ENTRY_UNAVAILABLE", "RECORDING_NOT_FOUND", "SPOKEN_LANGUAGE_UNSUPPORTED", "HEADSET_RECOMMENDED", "HEADSET_FORCE_REQUIRED", "PLAYBACK_MUTED_BY_ORIGINAL_AUDIO_SAVE_WITHOUT_HEADSET", "STOPPED_BY_HUMAN_INTERPRETATION_STARTED", "START_WAITING", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmAIInterpretationEventType extends Enum<MmAIInterpretationEventType> {
    public static final MmAIInterpretationEventType ENTRY_UNAVAILABLE = null;
    public static final MmAIInterpretationEventType HEADSET_FORCE_REQUIRED = null;
    public static final MmAIInterpretationEventType HEADSET_RECOMMENDED = null;
    public static final MmAIInterpretationEventType LANGUAGE_LIST_EMPTY = null;
    public static final MmAIInterpretationEventType NO_TARGET_LANGUAGE = null;
    public static final MmAIInterpretationEventType PLAYBACK_MUTED_BY_ORIGINAL_AUDIO_SAVE_WITHOUT_HEADSET = null;
    public static final MmAIInterpretationEventType RECORDING_NOT_FOUND = null;
    public static final MmAIInterpretationEventType SPOKEN_LANGUAGE_UNSUPPORTED = null;
    public static final MmAIInterpretationEventType START_FAILED = null;
    public static final MmAIInterpretationEventType START_SUCCESS = null;
    public static final MmAIInterpretationEventType START_WAITING = null;
    public static final MmAIInterpretationEventType STOPPED_BY_HUMAN_INTERPRETATION_STARTED = null;
    public static final MmAIInterpretationEventType STOP_FAILED = null;
    public static final MmAIInterpretationEventType STOP_SUCCESS = null;
    public static final MmAIInterpretationEventType SWITCH_FAILED = null;
    public static final MmAIInterpretationEventType SWITCH_SUCCESS = null;
    public static final MmAIInterpretationEventType TARGET_LANGUAGE_SELECTED = null;
    public static final MmAIInterpretationEventType TARGET_LANGUAGE_UNCHANGED = null;
    public static final /* synthetic */ MmAIInterpretationEventType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmAIInterpretationEventType> getEntries() {
        return b;
    }

    static {
        MmAIInterpretationEventType r0 = new MmAIInterpretationEventType("TARGET_LANGUAGE_SELECTED", 0);
        TARGET_LANGUAGE_SELECTED = r0;
        MmAIInterpretationEventType r1 = new MmAIInterpretationEventType("TARGET_LANGUAGE_UNCHANGED", 1);
        TARGET_LANGUAGE_UNCHANGED = r1;
        MmAIInterpretationEventType r3 = new MmAIInterpretationEventType("START_SUCCESS", 2);
        START_SUCCESS = r3;
        MmAIInterpretationEventType r5 = new MmAIInterpretationEventType("START_FAILED", 3);
        START_FAILED = r5;
        MmAIInterpretationEventType r7 = new MmAIInterpretationEventType("STOP_SUCCESS", 4);
        STOP_SUCCESS = r7;
        MmAIInterpretationEventType r9 = new MmAIInterpretationEventType("STOP_FAILED", 5);
        STOP_FAILED = r9;
        MmAIInterpretationEventType r11 = new MmAIInterpretationEventType("SWITCH_SUCCESS", 6);
        SWITCH_SUCCESS = r11;
        MmAIInterpretationEventType r13 = new MmAIInterpretationEventType("SWITCH_FAILED", 7);
        SWITCH_FAILED = r13;
        MmAIInterpretationEventType r15 = new MmAIInterpretationEventType("NO_TARGET_LANGUAGE", 8);
        NO_TARGET_LANGUAGE = r15;
        MmAIInterpretationEventType r14 = new MmAIInterpretationEventType("LANGUAGE_LIST_EMPTY", 9);
        LANGUAGE_LIST_EMPTY = r14;
        MmAIInterpretationEventType r12 = new MmAIInterpretationEventType("ENTRY_UNAVAILABLE", 10);
        ENTRY_UNAVAILABLE = r12;
        MmAIInterpretationEventType r10 = new MmAIInterpretationEventType("RECORDING_NOT_FOUND", 11);
        RECORDING_NOT_FOUND = r10;
        MmAIInterpretationEventType r8 = new MmAIInterpretationEventType("SPOKEN_LANGUAGE_UNSUPPORTED", 12);
        SPOKEN_LANGUAGE_UNSUPPORTED = r8;
        MmAIInterpretationEventType r6 = new MmAIInterpretationEventType("HEADSET_RECOMMENDED", 13);
        HEADSET_RECOMMENDED = r6;
        MmAIInterpretationEventType r4 = new MmAIInterpretationEventType("HEADSET_FORCE_REQUIRED", 14);
        HEADSET_FORCE_REQUIRED = r4;
        MmAIInterpretationEventType r2 = new MmAIInterpretationEventType("PLAYBACK_MUTED_BY_ORIGINAL_AUDIO_SAVE_WITHOUT_HEADSET", 15);
        PLAYBACK_MUTED_BY_ORIGINAL_AUDIO_SAVE_WITHOUT_HEADSET = r2;
        MmAIInterpretationEventType r16 = new MmAIInterpretationEventType("STOPPED_BY_HUMAN_INTERPRETATION_STARTED", 16);
        STOPPED_BY_HUMAN_INTERPRETATION_STARTED = r16;
        MmAIInterpretationEventType r17 = new MmAIInterpretationEventType("START_WAITING", 17);
        START_WAITING = r17;
        MmAIInterpretationEventType[] r18 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17};
        a = r18;
        b = EnumEntriesKt.enumEntries(r18);
    }

    public static MmAIInterpretationEventType[] values() {
        return (MmAIInterpretationEventType[]) a.clone();
    }

    public static MmAIInterpretationEventType valueOf(String r1) {
        return (MmAIInterpretationEventType) a.a(MmAIInterpretationEventType.class, r1);
    }

    public MmAIInterpretationEventType(String r1, int r2) {
        super(r1, r2);
    }
}
