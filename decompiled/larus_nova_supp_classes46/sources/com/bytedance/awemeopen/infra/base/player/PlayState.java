package com.bytedance.awemeopen.infra.base.player;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/awemeopen/infra/base/player/PlayState;", "", "STATE_RESET", "STATE_PREPARE", "STATE_PREPARED", "STATE_START", "STATE_RESUME", "STATE_PAUSE", "STATE_STOP", "STATE_RELEASE", "ao_base_core_release"}, k = 1, mv = {1, 7, 1})
public final enum PlayState extends Enum<PlayState> {
    public static final PlayState STATE_PAUSE = null;
    public static final PlayState STATE_PREPARE = null;
    public static final PlayState STATE_PREPARED = null;
    public static final PlayState STATE_RELEASE = null;
    public static final PlayState STATE_RESET = null;
    public static final PlayState STATE_RESUME = null;
    public static final PlayState STATE_START = null;
    public static final PlayState STATE_STOP = null;
    public static final /* synthetic */ PlayState[] a = null;

    public static PlayState valueOf(String r1) {
        return (PlayState) r27.a.a(PlayState.class, r1);
    }

    public static PlayState[] values() {
        return (PlayState[]) a.clone();
    }

    static {
        PlayState r0 = new PlayState("STATE_RESET", 0);
        STATE_RESET = r0;
        PlayState r1 = new PlayState("STATE_PREPARE", 1);
        STATE_PREPARE = r1;
        PlayState r3 = new PlayState("STATE_PREPARED", 2);
        STATE_PREPARED = r3;
        PlayState r5 = new PlayState("STATE_START", 3);
        STATE_START = r5;
        PlayState r7 = new PlayState("STATE_RESUME", 4);
        STATE_RESUME = r7;
        PlayState r9 = new PlayState("STATE_PAUSE", 5);
        STATE_PAUSE = r9;
        PlayState r11 = new PlayState("STATE_STOP", 6);
        STATE_STOP = r11;
        PlayState r13 = new PlayState("STATE_RELEASE", 7);
        STATE_RELEASE = r13;
        a = new PlayState[]{r0, r1, r3, r5, r7, r9, r11, r13};
    }

    public PlayState(String r1, int r2) {
        super(r1, r2);
    }
}
