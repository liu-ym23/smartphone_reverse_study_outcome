package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum OverpassPlacholder extends Enum<OverpassPlacholder> {
    private static final /* synthetic */ OverpassPlacholder[] $VALUES = null;

    @SerializedName("1")
    public static final OverpassPlacholder One = null;
    private final int value;

    static {
        OverpassPlacholder r0 = new OverpassPlacholder("One", 0, 1);
        One = r0;
        $VALUES = new OverpassPlacholder[]{r0};
    }

    private OverpassPlacholder(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static OverpassPlacholder findByValue(int r1) {
        if (r1 == 1) goto L7;
        return null;
    L7:
        return One;
    }

    public static OverpassPlacholder valueOf(String r2) {
        return (OverpassPlacholder) ZeusTransformUtils.preCheckCast(Enum.valueOf(OverpassPlacholder.class, r2), OverpassPlacholder.class, "com.obric.memorydata.plugin");
    }

    public static OverpassPlacholder[] values() {
        return (OverpassPlacholder[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), OverpassPlacholder[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
