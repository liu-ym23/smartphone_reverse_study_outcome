package com.bumptech.glide.load;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final enum EncodeStrategy extends Enum<EncodeStrategy> {
    private static final /* synthetic */ EncodeStrategy[] $VALUES = null;
    public static final EncodeStrategy NONE = null;
    public static final EncodeStrategy SOURCE = null;
    public static final EncodeStrategy TRANSFORMED = null;

    private static /* synthetic */ EncodeStrategy[] $values() {
        return new EncodeStrategy[]{SOURCE, TRANSFORMED, NONE};
    }

    static {
        SOURCE = new EncodeStrategy("SOURCE", 0);
        TRANSFORMED = new EncodeStrategy("TRANSFORMED", 1);
        NONE = new EncodeStrategy("NONE", 2);
        $VALUES = $values();
    }

    private EncodeStrategy(String r1, int r2) {
        super(r1, r2);
    }

    public static EncodeStrategy valueOf(String r2) {
        return (EncodeStrategy) ZeusTransformUtils.preCheckCast(Enum.valueOf(EncodeStrategy.class, r2), EncodeStrategy.class, "com.obric.memorydata.plugin");
    }

    public static EncodeStrategy[] values() {
        return (EncodeStrategy[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EncodeStrategy[].class, "com.obric.memorydata.plugin");
    }
}
