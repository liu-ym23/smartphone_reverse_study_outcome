package com.bytedance.ttnet.mpa;

/* JADX INFO: loaded from: classes.dex */
public final enum TTNetMpaService$HookMode extends Enum<TTNetMpaService$HookMode> {
    private static final /* synthetic */ TTNetMpaService$HookMode[] $VALUES = null;
    public static final TTNetMpaService$HookMode BYTE = null;
    public static final TTNetMpaService$HookMode SHADOW = null;
    public static final TTNetMpaService$HookMode SYMBOL = null;

    static {
        TTNetMpaService$HookMode r10 = new TTNetMpaService$HookMode("SYMBOL", 0);
        SYMBOL = r10;
        TTNetMpaService$HookMode r11 = new TTNetMpaService$HookMode("BYTE", 1);
        BYTE = r11;
        TTNetMpaService$HookMode r12 = new TTNetMpaService$HookMode("SHADOW", 2);
        SHADOW = r12;
        $VALUES = new TTNetMpaService$HookMode[]{r10, r11, r12};
    }

    private TTNetMpaService$HookMode(String r10, int r11) {
        super(r10, r11);
    }

    public static TTNetMpaService$HookMode valueOf(String r10) {
        return (TTNetMpaService$HookMode) Enum.valueOf(TTNetMpaService$HookMode.class, r10);
    }

    public static TTNetMpaService$HookMode[] values() {
        return (TTNetMpaService$HookMode[]) $VALUES.clone();
    }
}
