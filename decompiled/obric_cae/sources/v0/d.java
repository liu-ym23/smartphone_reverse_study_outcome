package v0;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12687a;

    public /* synthetic */ d(int r8) {
        this.f12687a = r8;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r8) {
        switch(this.f12687a) {
            case 0: goto L13;
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L7;
            case 4: goto L5;
            default: goto L15;
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
        return;
    L13:
        r8.run();
        return;
    L15:
        r8.run();
    }
}
