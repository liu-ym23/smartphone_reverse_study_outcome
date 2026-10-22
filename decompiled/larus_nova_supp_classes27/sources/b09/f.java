package b09;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ int a;

    public /* synthetic */ f(int r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a != e.g) goto L7;
        e.f = false;
        FLogger.a.i("SecurityTokenBeatScheduler", "heartbeat success");
        e.a();
        return;
    }
}
