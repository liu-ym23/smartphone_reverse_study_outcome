package com.bumptech.glide.load.engine;

/* JADX INFO: loaded from: classes.dex */
final enum DecodeJob$RunReason extends Enum<DecodeJob$RunReason> {
    public static final DecodeJob$RunReason DECODE_DATA = null;
    public static final DecodeJob$RunReason INITIALIZE = null;
    public static final DecodeJob$RunReason SWITCH_TO_SOURCE_SERVICE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DecodeJob$RunReason[] f1436a = null;

    static {
        DecodeJob$RunReason r5 = new DecodeJob$RunReason("INITIALIZE", 0);
        INITIALIZE = r5;
        DecodeJob$RunReason r10 = new DecodeJob$RunReason("SWITCH_TO_SOURCE_SERVICE", 1);
        SWITCH_TO_SOURCE_SERVICE = r10;
        DecodeJob$RunReason r11 = new DecodeJob$RunReason("DECODE_DATA", 2);
        DECODE_DATA = r11;
        f1436a = new DecodeJob$RunReason[]{r5, r10, r11};
    }

    public static DecodeJob$RunReason valueOf(String r5) {
        return (DecodeJob$RunReason) Enum.valueOf(DecodeJob$RunReason.class, r5);
    }

    public static DecodeJob$RunReason[] values() {
        return (DecodeJob$RunReason[]) f1436a.clone();
    }
}
