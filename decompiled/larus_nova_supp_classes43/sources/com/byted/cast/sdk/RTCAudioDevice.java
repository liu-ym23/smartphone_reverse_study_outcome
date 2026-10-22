package com.byted.cast.sdk;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final enum RTCAudioDevice extends Enum<RTCAudioDevice> {
    private static final /* synthetic */ RTCAudioDevice[] $VALUES = null;
    public static final RTCAudioDevice BLUETOOTH = null;
    public static final RTCAudioDevice EARPIECE = null;
    public static final RTCAudioDevice NONE = null;
    public static final RTCAudioDevice SPEAKER = null;
    public static final RTCAudioDevice WIRED_HEADSET = null;
    private final int value;

    static {
        RTCAudioDevice r0 = new RTCAudioDevice("SPEAKER", 0, 0);
        SPEAKER = r0;
        RTCAudioDevice r1 = new RTCAudioDevice("EARPIECE", 1, 1);
        EARPIECE = r1;
        RTCAudioDevice r10 = new RTCAudioDevice("WIRED_HEADSET", 2, 2);
        WIRED_HEADSET = r10;
        RTCAudioDevice r11 = new RTCAudioDevice("BLUETOOTH", 3, 3);
        BLUETOOTH = r11;
        RTCAudioDevice r12 = new RTCAudioDevice("NONE", 4, -1);
        NONE = r12;
        $VALUES = new RTCAudioDevice[]{r0, r1, r10, r11, r12};
    }

    public static RTCAudioDevice[] values() {
        return (RTCAudioDevice[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static RTCAudioDevice valueOf(String r1) {
        return (RTCAudioDevice) a.a(RTCAudioDevice.class, r1);
    }

    private RTCAudioDevice(String r1, int r10, int r11) {
        super(r1, r10);
        this.value = r11;
    }
}
