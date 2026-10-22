package com.lynx.tasm.behavior.ui.krypton;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum LynxKryptonAudioDownstreamMode extends Enum<LynxKryptonAudioDownstreamMode> {
    private static final /* synthetic */ LynxKryptonAudioDownstreamMode[] $VALUES = null;
    public static final LynxKryptonAudioDownstreamMode KEEP_PLAYBACK = null;
    public static final LynxKryptonAudioDownstreamMode REPLACE_PLAYBACK = null;

    static {
        LynxKryptonAudioDownstreamMode r0 = new LynxKryptonAudioDownstreamMode("KEEP_PLAYBACK", 0);
        KEEP_PLAYBACK = r0;
        LynxKryptonAudioDownstreamMode r1 = new LynxKryptonAudioDownstreamMode("REPLACE_PLAYBACK", 1);
        REPLACE_PLAYBACK = r1;
        $VALUES = new LynxKryptonAudioDownstreamMode[]{r0, r1};
    }

    public static LynxKryptonAudioDownstreamMode[] values() {
        return (LynxKryptonAudioDownstreamMode[]) $VALUES.clone();
    }

    public static LynxKryptonAudioDownstreamMode valueOf(String r1) {
        return (LynxKryptonAudioDownstreamMode) a.a(LynxKryptonAudioDownstreamMode.class, r1);
    }

    private LynxKryptonAudioDownstreamMode(String r1, int r2) {
        super(r1, r2);
    }
}
