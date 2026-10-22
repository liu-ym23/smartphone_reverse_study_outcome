package androidx.concurrent.futures;

import java.util.concurrent.Executor;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final enum DirectExecutor extends Enum<DirectExecutor> implements Executor {
    private static final /* synthetic */ DirectExecutor[] $VALUES = null;
    public static final DirectExecutor INSTANCE = null;

    @Override // java.lang.Enum
    public String toString() {
        return "DirectExecutor";
    }

    static {
        DirectExecutor r0 = new DirectExecutor("INSTANCE", 0);
        INSTANCE = r0;
        $VALUES = new DirectExecutor[]{r0};
    }

    public static DirectExecutor[] values() {
        return (DirectExecutor[]) $VALUES.clone();
    }

    public static DirectExecutor valueOf(String r1) {
        return (DirectExecutor) a.a(DirectExecutor.class, r1);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r1) {
        r1.run();
    }

    private DirectExecutor(String r1, int r2) {
        super(r1, r2);
    }
}
