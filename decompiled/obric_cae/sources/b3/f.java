package b3;

import java.util.concurrent.LinkedTransferQueue;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedTransferQueue f3042a;

    public f() {
        this.f3042a = new LinkedTransferQueue();
        new Thread(new e(this), "looper_monitor");
    }
}
