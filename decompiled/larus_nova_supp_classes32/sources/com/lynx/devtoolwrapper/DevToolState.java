package com.lynx.devtoolwrapper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum DevToolState extends Enum<DevToolState> {
    private static final /* synthetic */ DevToolState[] $VALUES = null;
    public static final DevToolState ATTACHED = null;
    public static final DevToolState CONNECTED = null;
    public static final DevToolState ENABLED = null;
    public static final DevToolState INITIALIZED = null;
    public static final DevToolState UNAVAILABLE = null;

    static {
        DevToolState r0 = new DevToolState("UNAVAILABLE", 0);
        UNAVAILABLE = r0;
        DevToolState r1 = new DevToolState("ATTACHED", 1);
        ATTACHED = r1;
        DevToolState r3 = new DevToolState("ENABLED", 2);
        ENABLED = r3;
        DevToolState r5 = new DevToolState("INITIALIZED", 3);
        INITIALIZED = r5;
        DevToolState r7 = new DevToolState("CONNECTED", 4);
        CONNECTED = r7;
        $VALUES = new DevToolState[]{r0, r1, r3, r5, r7};
    }

    public static DevToolState[] values() {
        return (DevToolState[]) $VALUES.clone();
    }

    public static DevToolState valueOf(String r1) {
        return (DevToolState) r27.a.a(DevToolState.class, r1);
    }

    private DevToolState(String r1, int r2) {
        super(r1, r2);
    }
}
