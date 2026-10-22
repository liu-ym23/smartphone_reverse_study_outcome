package com.bytedance.crash;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum CustomizeExceptionType extends Enum<CustomizeExceptionType> {
    private static final /* synthetic */ CustomizeExceptionType[] $VALUES = null;
    public static final CustomizeExceptionType FD_TRACKER = null;
    public static final CustomizeExceptionType HEAP_TRACKER = null;
    public static final CustomizeExceptionType MAX = null;
    public static final CustomizeExceptionType PRIO_MONITOR = null;
    public static final CustomizeExceptionType REF_MONITOR = null;
    public static final CustomizeExceptionType TLS_MONITOR = null;
    public static final CustomizeExceptionType VM_MONITOR = null;
    public static final CustomizeExceptionType XASAN = null;
    private final String mName;

    static {
        CustomizeExceptionType r0 = new CustomizeExceptionType("XASAN", 0, "xasan");
        XASAN = r0;
        CustomizeExceptionType r1 = new CustomizeExceptionType("HEAP_TRACKER", 1, "heap_tracker");
        HEAP_TRACKER = r1;
        CustomizeExceptionType r3 = new CustomizeExceptionType("FD_TRACKER", 2, "fd_tracker");
        FD_TRACKER = r3;
        CustomizeExceptionType r5 = new CustomizeExceptionType("VM_MONITOR", 3, "vm_monitor");
        VM_MONITOR = r5;
        CustomizeExceptionType r7 = new CustomizeExceptionType("TLS_MONITOR", 4, "tls_monitor");
        TLS_MONITOR = r7;
        CustomizeExceptionType r9 = new CustomizeExceptionType("REF_MONITOR", 5, "ref_monitor");
        REF_MONITOR = r9;
        CustomizeExceptionType r11 = new CustomizeExceptionType("PRIO_MONITOR", 6, "priority_monitor");
        PRIO_MONITOR = r11;
        CustomizeExceptionType r13 = new CustomizeExceptionType("MAX", 7, "max");
        MAX = r13;
        $VALUES = new CustomizeExceptionType[]{r0, r1, r3, r5, r7, r9, r11, r13};
    }

    private CustomizeExceptionType(String r1, int r2, String r3) {
        super(r1, r2);
        this.mName = r3;
    }

    public static CustomizeExceptionType getType(String r0) {
        return valueOf(r0.toUpperCase());
    L5:
        return MAX;
    }

    public static CustomizeExceptionType valueOf(String r2) {
        return (CustomizeExceptionType) ZeusTransformUtils.preCheckCast(Enum.valueOf(CustomizeExceptionType.class, r2), CustomizeExceptionType.class, "com.obric.memorydata.plugin");
    }

    public static CustomizeExceptionType[] values() {
        return (CustomizeExceptionType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CustomizeExceptionType[].class, "com.obric.memorydata.plugin");
    }

    public String getName() {
        return this.mName;
    }

    @Override // java.lang.Enum
    public String toString() {
        return getName();
    }
}
