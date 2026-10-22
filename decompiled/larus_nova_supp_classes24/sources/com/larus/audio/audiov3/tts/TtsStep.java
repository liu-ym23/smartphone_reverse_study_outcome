package com.larus.audio.audiov3.tts;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/audio/audiov3/tts/TtsStep;", "", "traceName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTraceName", "()Ljava/lang/String;", "STEP_TTS_CREATE_HANDLER", "STEP_TTS_TIMEOUT", "STEP_TTS_TO_AUDIO_PLAY", "STEP_TTS_PRE_SUB_TO_TEXT_SHOW", "STEP_TTS_GET_FIRST_AUDIO_DATA", "STEP_TTS_PLAYER_PLAY_TIME", "STEP_TTS_LAG_EVENT", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum TtsStep extends Enum<TtsStep> {
    public static final TtsStep STEP_TTS_CREATE_HANDLER = null;
    public static final TtsStep STEP_TTS_GET_FIRST_AUDIO_DATA = null;
    public static final TtsStep STEP_TTS_LAG_EVENT = null;
    public static final TtsStep STEP_TTS_PLAYER_PLAY_TIME = null;
    public static final TtsStep STEP_TTS_PRE_SUB_TO_TEXT_SHOW = null;
    public static final TtsStep STEP_TTS_TIMEOUT = null;
    public static final TtsStep STEP_TTS_TO_AUDIO_PLAY = null;
    public static final /* synthetic */ TtsStep[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String traceName;

    public static EnumEntries<TtsStep> getEntries() {
        return b;
    }

    static {
        TtsStep r0 = new TtsStep("STEP_TTS_CREATE_HANDLER", 0, "tts_create_handler");
        STEP_TTS_CREATE_HANDLER = r0;
        TtsStep r1 = new TtsStep("STEP_TTS_TIMEOUT", 1, "step_tts_timeout");
        STEP_TTS_TIMEOUT = r1;
        TtsStep r2 = new TtsStep("STEP_TTS_TO_AUDIO_PLAY", 2, "tts_to_audio_play");
        STEP_TTS_TO_AUDIO_PLAY = r2;
        TtsStep r4 = new TtsStep("STEP_TTS_PRE_SUB_TO_TEXT_SHOW", 3, "step_tts_pre_sub_to_text_show");
        STEP_TTS_PRE_SUB_TO_TEXT_SHOW = r4;
        TtsStep r6 = new TtsStep("STEP_TTS_GET_FIRST_AUDIO_DATA", 4, "step_tts_get_first_audio_data");
        STEP_TTS_GET_FIRST_AUDIO_DATA = r6;
        TtsStep r8 = new TtsStep("STEP_TTS_PLAYER_PLAY_TIME", 5, "step_tts_player_play_time");
        STEP_TTS_PLAYER_PLAY_TIME = r8;
        TtsStep r10 = new TtsStep("STEP_TTS_LAG_EVENT", 6, "tts_player_lag_event");
        STEP_TTS_LAG_EVENT = r10;
        TtsStep[] r12 = {r0, r1, r2, r4, r6, r8, r10};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static TtsStep[] values() {
        return (TtsStep[]) a.clone();
    }

    public final String getTraceName() {
        return this.traceName;
    }

    public static TtsStep valueOf(String r1) {
        return (TtsStep) a.a(TtsStep.class, r1);
    }

    public TtsStep(String r1, int r2, String r3) {
        super(r1, r2);
        this.traceName = r3;
    }
}
