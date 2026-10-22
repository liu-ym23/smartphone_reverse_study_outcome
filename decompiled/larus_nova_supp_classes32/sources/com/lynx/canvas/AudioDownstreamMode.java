package com.lynx.canvas;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum AudioDownstreamMode extends Enum<AudioDownstreamMode> {
    private static final /* synthetic */ AudioDownstreamMode[] $VALUES = null;
    public static final AudioDownstreamMode KEEP_PLAYBACK = null;
    public static final AudioDownstreamMode REPLACE_PLAYBACK = null;
    public final int value;

    static {
        AudioDownstreamMode r0 = new AudioDownstreamMode("KEEP_PLAYBACK", 0, 0);
        KEEP_PLAYBACK = r0;
        AudioDownstreamMode r1 = new AudioDownstreamMode("REPLACE_PLAYBACK", 1, 1);
        REPLACE_PLAYBACK = r1;
        $VALUES = new AudioDownstreamMode[]{r0, r1};
    }

    public static AudioDownstreamMode[] values() {
        return (AudioDownstreamMode[]) $VALUES.clone();
    }

    public static AudioDownstreamMode valueOf(String r1) {
        return (AudioDownstreamMode) a.a(AudioDownstreamMode.class, r1);
    }

    private AudioDownstreamMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
