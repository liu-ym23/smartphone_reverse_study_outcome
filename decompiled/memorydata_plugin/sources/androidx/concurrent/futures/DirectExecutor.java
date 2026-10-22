package androidx.concurrent.futures;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final enum DirectExecutor extends Enum<DirectExecutor> implements Executor {
    private static final /* synthetic */ DirectExecutor[] $VALUES = null;
    public static final DirectExecutor INSTANCE = null;

    static {
        DirectExecutor r0 = new DirectExecutor("INSTANCE", 0);
        INSTANCE = r0;
        $VALUES = new DirectExecutor[]{r0};
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
        return "DirectExecutor";
    }
}
