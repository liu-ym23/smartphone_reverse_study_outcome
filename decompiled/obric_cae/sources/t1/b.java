package t1;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final enum b extends Enum<b> implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12239a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ b[] f12240b = null;

    static {
        b r8 = new b();
        f12239a = r8;
        f12240b = new b[]{r8};
    }

    public b() {
        super("INSTANCE", 0);
    }

    public static b valueOf(String r8) {
        return (b) Enum.valueOf(b.class, r8);
    }

    public static b[] values() {
        return (b[]) f12240b.clone();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r8) {
        r8.run();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "DirectExecutor";
    }
}
