package i;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8070a;

    public /* synthetic */ a(int r8) {
        this.f8070a = r8;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r8) {
        switch(this.f8070a) {
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L11;
        };
    L5:
        r8.run();
        return;
    L7:
        r8.run();
        return;
    L9:
        r8.run();
        return;
    L11:
        r8.run();
    }
}
