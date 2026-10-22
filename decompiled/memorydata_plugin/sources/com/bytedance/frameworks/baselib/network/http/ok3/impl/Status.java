package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.obric.memorydata.database.entity.RawObservationEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
final enum Status extends Enum<Status> {
    private static final /* synthetic */ Status[] $VALUES = null;
    public static final Status CANCELED = null;
    public static final Status FAILED = null;
    public static final Status IO_PENDING = null;
    public static final Status SUCCESS = null;
    public static final Status UNKNOWN = null;

    static {
        Status r0 = new Status("UNKNOWN", 0);
        UNKNOWN = r0;
        Status r1 = new Status("SUCCESS", 1);
        SUCCESS = r1;
        Status r3 = new Status("IO_PENDING", 2);
        IO_PENDING = r3;
        Status r5 = new Status("CANCELED", 3);
        CANCELED = r5;
        Status r7 = new Status(RawObservationEntity.STATE_FAILED, 4);
        FAILED = r7;
        $VALUES = new Status[]{r0, r1, r3, r5, r7};
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
