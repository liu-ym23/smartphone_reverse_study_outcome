package com.bytedance.obric.memory.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum Status extends Enum<Status> {
    private static final /* synthetic */ Status[] $VALUES = null;

    @SerializedName("1")
    public static final Status Available = null;

    @SerializedName("2")
    public static final Status Deleted = null;
    private final int value;

    static {
        Status r0 = new Status("Available", 0, 1);
        Available = r0;
        Status r1 = new Status("Deleted", 1, 2);
        Deleted = r1;
        $VALUES = new Status[]{r0, r1};
    }

    private Status(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static Status findByValue(int r1) {
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L9;
        return null;
    L9:
        return Deleted;
    L11:
        return Available;
    }

    public static Status valueOf(String r2) {
        return (Status) ZeusTransformUtils.preCheckCast(Enum.valueOf(Status.class, r2), Status.class, "com.obric.memorydata.plugin");
    }

    public static Status[] values() {
        return (Status[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Status[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
