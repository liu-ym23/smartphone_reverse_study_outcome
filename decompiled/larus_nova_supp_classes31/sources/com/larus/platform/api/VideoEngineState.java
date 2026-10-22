package com.larus.platform.api;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/platform/api/VideoEngineState;", "", "<init>", "(Ljava/lang/String;I)V", "LOAD_STATE_STALLED", "LOAD_STATE_ERROR", "PLAYBACK_STATE_PLAYING", "PLAYBACK_STATE_PAUSED", "PLAYBACK_STATE_STOPPED", "PLAYBACK_STATE_ERROR", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum VideoEngineState extends Enum<VideoEngineState> {
    public static final VideoEngineState LOAD_STATE_ERROR = null;
    public static final VideoEngineState LOAD_STATE_STALLED = null;
    public static final VideoEngineState PLAYBACK_STATE_ERROR = null;
    public static final VideoEngineState PLAYBACK_STATE_PAUSED = null;
    public static final VideoEngineState PLAYBACK_STATE_PLAYING = null;
    public static final VideoEngineState PLAYBACK_STATE_STOPPED = null;
    public static final /* synthetic */ VideoEngineState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<VideoEngineState> getEntries() {
        return b;
    }

    static {
        VideoEngineState r0 = new VideoEngineState("LOAD_STATE_STALLED", 0);
        LOAD_STATE_STALLED = r0;
        VideoEngineState r1 = new VideoEngineState("LOAD_STATE_ERROR", 1);
        LOAD_STATE_ERROR = r1;
        VideoEngineState r3 = new VideoEngineState("PLAYBACK_STATE_PLAYING", 2);
        PLAYBACK_STATE_PLAYING = r3;
        VideoEngineState r5 = new VideoEngineState("PLAYBACK_STATE_PAUSED", 3);
        PLAYBACK_STATE_PAUSED = r5;
        VideoEngineState r7 = new VideoEngineState("PLAYBACK_STATE_STOPPED", 4);
        PLAYBACK_STATE_STOPPED = r7;
        VideoEngineState r9 = new VideoEngineState("PLAYBACK_STATE_ERROR", 5);
        PLAYBACK_STATE_ERROR = r9;
        VideoEngineState[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static VideoEngineState[] values() {
        return (VideoEngineState[]) a.clone();
    }

    public static VideoEngineState valueOf(String r1) {
        return (VideoEngineState) r27.a.a(VideoEngineState.class, r1);
    }

    public VideoEngineState(String r1, int r2) {
        super(r1, r2);
    }
}
