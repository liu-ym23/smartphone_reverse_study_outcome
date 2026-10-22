package com.bytedance.crypto.pake;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum PakeRole extends Enum<PakeRole> {
    private static final /* synthetic */ PakeRole[] $VALUES = null;
    public static final PakeRole ALICE = null;
    public static final PakeRole BOB = null;

    static {
        PakeRole r0 = new PakeRole("ALICE", 0);
        ALICE = r0;
        PakeRole r1 = new PakeRole("BOB", 1);
        BOB = r1;
        $VALUES = new PakeRole[]{r0, r1};
    }

    private PakeRole(String r1, int r2) {
        super(r1, r2);
    }

    public static PakeRole valueOf(String r2) {
        return (PakeRole) ZeusTransformUtils.preCheckCast(Enum.valueOf(PakeRole.class, r2), PakeRole.class, "com.obric.memorydata.plugin");
    }

    public static PakeRole[] values() {
        return (PakeRole[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PakeRole[].class, "com.obric.memorydata.plugin");
    }
}
