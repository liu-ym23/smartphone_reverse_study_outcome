package com.bytedance.agentrobots.identity;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final enum RobotDeviceStatus$BootState extends Enum<RobotDeviceStatus$BootState> {
    public static final RobotDeviceStatus$BootState BOOT_STATE_GREEN = null;
    public static final RobotDeviceStatus$BootState BOOT_STATE_ORANGE = null;
    public static final RobotDeviceStatus$BootState BOOT_STATE_RED = null;
    public static final RobotDeviceStatus$BootState BOOT_STATE_YELLOW = null;
    public static final /* synthetic */ RobotDeviceStatus$BootState[] a = null;

    static {
        RobotDeviceStatus$BootState r0 = new RobotDeviceStatus$BootState("BOOT_STATE_GREEN", 0);
        BOOT_STATE_GREEN = r0;
        RobotDeviceStatus$BootState r1 = new RobotDeviceStatus$BootState("BOOT_STATE_ORANGE", 1);
        BOOT_STATE_ORANGE = r1;
        RobotDeviceStatus$BootState r10 = new RobotDeviceStatus$BootState("BOOT_STATE_YELLOW", 2);
        BOOT_STATE_YELLOW = r10;
        RobotDeviceStatus$BootState r11 = new RobotDeviceStatus$BootState("BOOT_STATE_RED", 3);
        BOOT_STATE_RED = r11;
        a = new RobotDeviceStatus$BootState[]{r0, r1, r10, r11};
    }

    public static RobotDeviceStatus$BootState[] values() {
        return (RobotDeviceStatus$BootState[]) a.clone();
    }

    public static RobotDeviceStatus$BootState fromInt(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return BOOT_STATE_GREEN;
    L12:
        return BOOT_STATE_RED;
    L14:
        return BOOT_STATE_ORANGE;
    L16:
        return BOOT_STATE_YELLOW;
    L18:
        return BOOT_STATE_GREEN;
    }

    public static RobotDeviceStatus$BootState valueOf(String r1) {
        return (RobotDeviceStatus$BootState) a.a(RobotDeviceStatus$BootState.class, r1);
    }

    public RobotDeviceStatus$BootState(String r1, int r10) {
        super(r1, r10);
    }
}
