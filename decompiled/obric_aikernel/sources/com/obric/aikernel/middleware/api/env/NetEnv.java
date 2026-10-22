package com.obric.aikernel.middleware.api.env;

/* JADX INFO: loaded from: classes2.dex */
public final enum NetEnv extends Enum<NetEnv> {
    private static final /* synthetic */ NetEnv[] $VALUES = null;
    public static final NetEnv BOE = null;
    public static final NetEnv ONLINE = null;
    public static final NetEnv PPE = null;

    private static final /* synthetic */ NetEnv[] $values() {
        return new NetEnv[]{ONLINE, PPE, BOE};
    }

    static {
        ONLINE = new NetEnv("ONLINE", 0);
        PPE = new NetEnv("PPE", 1);
        BOE = new NetEnv("BOE", 2);
        $VALUES = $values();
    }

    private NetEnv(String r10, int r11) {
        super(r10, r11);
    }

    public static NetEnv valueOf(String r10) {
        return (NetEnv) Enum.valueOf(NetEnv.class, r10);
    }

    public static NetEnv[] values() {
        return (NetEnv[]) $VALUES.clone();
    }
}
