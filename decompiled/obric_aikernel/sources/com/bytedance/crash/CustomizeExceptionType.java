package com.bytedance.crash;

/* JADX INFO: loaded from: classes.dex */
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
        CustomizeExceptionType r10 = new CustomizeExceptionType("XASAN", 0, "xasan");
        XASAN = r10;
        CustomizeExceptionType r11 = new CustomizeExceptionType("HEAP_TRACKER", 1, "heap_tracker");
        HEAP_TRACKER = r11;
        CustomizeExceptionType r12 = new CustomizeExceptionType("FD_TRACKER", 2, "fd_tracker");
        FD_TRACKER = r12;
        CustomizeExceptionType r13 = new CustomizeExceptionType("VM_MONITOR", 3, "vm_monitor");
        VM_MONITOR = r13;
        CustomizeExceptionType r14 = new CustomizeExceptionType("TLS_MONITOR", 4, "tls_monitor");
        TLS_MONITOR = r14;
        CustomizeExceptionType r15 = new CustomizeExceptionType("REF_MONITOR", 5, "ref_monitor");
        REF_MONITOR = r15;
        CustomizeExceptionType r16 = new CustomizeExceptionType("PRIO_MONITOR", 6, "priority_monitor");
        PRIO_MONITOR = r16;
        CustomizeExceptionType r17 = new CustomizeExceptionType("MAX", 7, "max");
        MAX = r17;
        $VALUES = new CustomizeExceptionType[]{r10, r11, r12, r13, r14, r15, r16, r17};
    }

    private CustomizeExceptionType(String r10, int r11, String r12) {
        super(r10, r11);
        this.mName = r12;
    }

    public static CustomizeExceptionType getType(String r10) {
        return valueOf(r10.toUpperCase());
    L5:
        return MAX;
    }

    public static CustomizeExceptionType valueOf(String r10) {
        return (CustomizeExceptionType) Enum.valueOf(CustomizeExceptionType.class, r10);
    }

    public static CustomizeExceptionType[] values() {
        return (CustomizeExceptionType[]) $VALUES.clone();
    }

    public String getName() {
        return this.mName;
    }

    @Override // java.lang.Enum
    public String toString() {
        return getName();
    }
}
