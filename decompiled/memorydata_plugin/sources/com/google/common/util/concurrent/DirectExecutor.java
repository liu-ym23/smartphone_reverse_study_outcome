package com.google.common.util.concurrent;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
final enum DirectExecutor extends Enum<DirectExecutor> implements Executor {
    private static final /* synthetic */ DirectExecutor[] $VALUES = null;
    public static final DirectExecutor INSTANCE = null;

    private static /* synthetic */ DirectExecutor[] $values() {
        return new DirectExecutor[]{INSTANCE};
    }

    static {
        INSTANCE = new DirectExecutor("INSTANCE", 0);
        $VALUES = $values();
    }

    private DirectExecutor(String r1, int r2) {
        super(r1, r2);
    }

    public static DirectExecutor valueOf(String r2) {
        return (DirectExecutor) ZeusTransformUtils.preCheckCast(Enum.valueOf(DirectExecutor.class, r2), DirectExecutor.class, "com.obric.memorydata.plugin");
    }

    public static DirectExecutor[] values() {
        return (DirectExecutor[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DirectExecutor[].class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r2) {
        ((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin")).run();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "MoreExecutors.directExecutor()";
    }
}
