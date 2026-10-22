package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum DefaultParamSource extends Enum<DefaultParamSource> {
    private static final /* synthetic */ DefaultParamSource[] $VALUES = null;

    @SerializedName("0")
    public static final DefaultParamSource Input = null;

    @SerializedName("1")
    public static final DefaultParamSource Variable = null;
    private final int value;

    static {
        DefaultParamSource r0 = new DefaultParamSource("Input", 0, 0);
        Input = r0;
        DefaultParamSource r1 = new DefaultParamSource("Variable", 1, 1);
        Variable = r1;
        $VALUES = new DefaultParamSource[]{r0, r1};
    }

    private DefaultParamSource(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static DefaultParamSource findByValue(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return null;
    L8:
        return Variable;
    L10:
        return Input;
    }

    public static DefaultParamSource valueOf(String r2) {
        return (DefaultParamSource) ZeusTransformUtils.preCheckCast(Enum.valueOf(DefaultParamSource.class, r2), DefaultParamSource.class, "com.obric.memorydata.plugin");
    }

    public static DefaultParamSource[] values() {
        return (DefaultParamSource[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DefaultParamSource[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
