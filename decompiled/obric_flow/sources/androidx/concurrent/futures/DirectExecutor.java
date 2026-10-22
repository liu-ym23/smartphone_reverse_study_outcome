package androidx.concurrent.futures;

import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final enum DirectExecutor extends Enum<DirectExecutor> implements Executor {
    private static final /* synthetic */ DirectExecutor[] $VALUES = null;
    public static final DirectExecutor INSTANCE = null;

    static {
        DirectExecutor r5 = new DirectExecutor("INSTANCE", 0);
        INSTANCE = r5;
        $VALUES = new DirectExecutor[]{r5};
    }

    private DirectExecutor(String r5, int r10) {
        super(r5, r10);
    }

    public static DirectExecutor valueOf(String r5) {
        return (DirectExecutor) Enum.valueOf(DirectExecutor.class, r5);
    }

    public static DirectExecutor[] values() {
        return (DirectExecutor[]) $VALUES.clone();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r5) {
        r5.run();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "DirectExecutor";
    }
}
