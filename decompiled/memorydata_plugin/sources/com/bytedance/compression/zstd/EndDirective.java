package com.bytedance.compression.zstd;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum EndDirective extends Enum<EndDirective> {
    private static final /* synthetic */ EndDirective[] $VALUES = null;
    public static final EndDirective CONTINUE = null;
    public static final EndDirective END = null;
    public static final EndDirective FLUSH = null;
    private final int value;

    static {
        EndDirective r0 = new EndDirective("CONTINUE", 0, 0);
        CONTINUE = r0;
        EndDirective r1 = new EndDirective("FLUSH", 1, 1);
        FLUSH = r1;
        EndDirective r3 = new EndDirective("END", 2, 2);
        END = r3;
        $VALUES = new EndDirective[]{r0, r1, r3};
    }

    private EndDirective(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static EndDirective valueOf(String r2) {
        return (EndDirective) ZeusTransformUtils.preCheckCast(Enum.valueOf(EndDirective.class, r2), EndDirective.class, "com.obric.memorydata.plugin");
    }

    public static EndDirective[] values() {
        return (EndDirective[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EndDirective[].class, "com.obric.memorydata.plugin");
    }

    int value() {
        return this.value;
    }
}
