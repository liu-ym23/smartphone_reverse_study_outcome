package androidx.profileinstaller;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Executor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ b f393c = null;

    static {
        f393c = new b();
    }

    private /* synthetic */ b() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r10) {
        r10.run();
    }
}
