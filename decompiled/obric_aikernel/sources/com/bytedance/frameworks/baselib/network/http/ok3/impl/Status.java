package com.bytedance.frameworks.baselib.network.http.ok3.impl;

/* JADX INFO: loaded from: classes.dex */
final enum Status extends Enum<Status> {
    private static final /* synthetic */ Status[] $VALUES = null;
    public static final Status CANCELED = null;
    public static final Status FAILED = null;
    public static final Status IO_PENDING = null;
    public static final Status SUCCESS = null;
    public static final Status UNKNOWN = null;

    static {
        Status r10 = new Status("UNKNOWN", 0);
        UNKNOWN = r10;
        Status r11 = new Status("SUCCESS", 1);
        SUCCESS = r11;
        Status r12 = new Status("IO_PENDING", 2);
        IO_PENDING = r12;
        Status r13 = new Status("CANCELED", 3);
        CANCELED = r13;
        Status r14 = new Status("FAILED", 4);
        FAILED = r14;
        $VALUES = new Status[]{r10, r11, r12, r13, r14};
    }

    private Status(String r10, int r11) {
        super(r10, r11);
    }

    public static Status valueOf(String r10) {
        return (Status) Enum.valueOf(Status.class, r10);
    }

    public static Status[] values() {
        return (Status[]) $VALUES.clone();
    }
}
