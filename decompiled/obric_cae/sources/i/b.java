package i;

import com.ttnet.org.chromium.base.task.AsyncTask;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8071a;

    public /* synthetic */ b(int r8) {
        this.f8071a = r8;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r8) {
        switch(this.f8071a) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L9;
        };
    L5:
        r8.run();
        return;
    L7:
        c.A().z(r8);
        return;
    L9:
        AsyncTask.a(r8);
    }
}
