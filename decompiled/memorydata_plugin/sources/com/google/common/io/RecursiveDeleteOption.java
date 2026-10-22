package com.google.common.io;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum RecursiveDeleteOption extends Enum<RecursiveDeleteOption> {
    private static final /* synthetic */ RecursiveDeleteOption[] $VALUES = null;
    public static final RecursiveDeleteOption ALLOW_INSECURE = null;

    private static /* synthetic */ RecursiveDeleteOption[] $values() {
        return new RecursiveDeleteOption[]{ALLOW_INSECURE};
    }

    static {
        ALLOW_INSECURE = new RecursiveDeleteOption("ALLOW_INSECURE", 0);
        $VALUES = $values();
    }

    private RecursiveDeleteOption(String r1, int r2) {
        super(r1, r2);
    }

    public static RecursiveDeleteOption valueOf(String r2) {
        return (RecursiveDeleteOption) ZeusTransformUtils.preCheckCast(Enum.valueOf(RecursiveDeleteOption.class, r2), RecursiveDeleteOption.class, "com.obric.memorydata.plugin");
    }

    public static RecursiveDeleteOption[] values() {
        return (RecursiveDeleteOption[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RecursiveDeleteOption[].class, "com.obric.memorydata.plugin");
    }
}
