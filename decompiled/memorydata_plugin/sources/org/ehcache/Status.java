package org.ehcache;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum Status extends Enum<Status> {
    private static final /* synthetic */ Status[] $VALUES = null;
    public static final Status AVAILABLE = null;
    public static final Status MAINTENANCE = null;
    public static final Status UNINITIALIZED = null;

    static {
        Status r0 = new Status("UNINITIALIZED", 0);
        UNINITIALIZED = r0;
        Status r1 = new Status("MAINTENANCE", 1);
        MAINTENANCE = r1;
        Status r3 = new Status("AVAILABLE", 2);
        AVAILABLE = r3;
        $VALUES = new Status[]{r0, r1, r3};
    }

    private Status(String r1, int r2) {
        super(r1, r2);
    }

    public static Status valueOf(String r2) {
        return (Status) ZeusTransformUtils.preCheckCast(Enum.valueOf(Status.class, r2), Status.class, "com.obric.memorydata.plugin");
    }

    public static Status[] values() {
        return (Status[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Status[].class, "com.obric.memorydata.plugin");
    }
}
