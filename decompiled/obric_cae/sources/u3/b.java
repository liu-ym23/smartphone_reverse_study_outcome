package u3;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Handler f12425a;

    public b(Handler r8) {
        this.f12425a = r8;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r8) {
        Handler r10 = this.f12425a;
        if (r10.getLooper() != Looper.myLooper()) goto L5;
        r8.run();
        return;
    L5:
        r10.post(r8);
    }
}
