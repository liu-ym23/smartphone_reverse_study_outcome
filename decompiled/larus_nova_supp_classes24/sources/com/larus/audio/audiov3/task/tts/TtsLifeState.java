package com.larus.audio.audiov3.task.tts;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/audio/audiov3/task/tts/TtsLifeState;", "", "<init>", "(Ljava/lang/String;I)V", "TTS_START", "TTS_STOP", "TTS_ERROR", "TTS_PAUSE", "TTS_RESUME", "TTS_START_PLAYING", "TTS_FINISH_PLAYING", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum TtsLifeState extends Enum<TtsLifeState> {
    public static final TtsLifeState TTS_ERROR = null;
    public static final TtsLifeState TTS_FINISH_PLAYING = null;
    public static final TtsLifeState TTS_PAUSE = null;
    public static final TtsLifeState TTS_RESUME = null;
    public static final TtsLifeState TTS_START = null;
    public static final TtsLifeState TTS_START_PLAYING = null;
    public static final TtsLifeState TTS_STOP = null;
    public static final /* synthetic */ TtsLifeState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TtsLifeState> getEntries() {
        return b;
    }

    static {
        TtsLifeState r0 = new TtsLifeState("TTS_START", 0);
        TTS_START = r0;
        TtsLifeState r1 = new TtsLifeState("TTS_STOP", 1);
        TTS_STOP = r1;
        TtsLifeState r3 = new TtsLifeState("TTS_ERROR", 2);
        TTS_ERROR = r3;
        TtsLifeState r5 = new TtsLifeState("TTS_PAUSE", 3);
        TTS_PAUSE = r5;
        TtsLifeState r7 = new TtsLifeState("TTS_RESUME", 4);
        TTS_RESUME = r7;
        TtsLifeState r9 = new TtsLifeState("TTS_START_PLAYING", 5);
        TTS_START_PLAYING = r9;
        TtsLifeState r11 = new TtsLifeState("TTS_FINISH_PLAYING", 6);
        TTS_FINISH_PLAYING = r11;
        TtsLifeState[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
    }

    public static TtsLifeState[] values() {
        return (TtsLifeState[]) a.clone();
    }

    public static TtsLifeState valueOf(String r1) {
        return (TtsLifeState) a.a(TtsLifeState.class, r1);
    }

    public TtsLifeState(String r1, int r2) {
        super(r1, r2);
    }
}
