package esb;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.monitor.i;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements ComponentCallbacks2 {
    public final /* synthetic */ i a;
    public final /* synthetic */ b b;

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r1) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(final int r4) {
        if (r4 >= 15) goto L5;
        return;
    L5:
        ExecutorService r0 = CoreThreadPool.getDefault().getCachedThreadPool();
        final i r1 = this.a;
        r0.execute(new c(this, r4, r1));
    }

    public e(b r1, i r2) {
        this.b = r1;
        this.a = r2;
    }
}
