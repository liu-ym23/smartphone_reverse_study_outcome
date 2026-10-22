package fo1;

import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.larus.apm.impl.protector.RunnableProtector;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements Runnable {
    public final /* synthetic */ b a;
    public final /* synthetic */ LiveMode b;

    public c(b r1, LiveMode r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.f(this.a, this.b);     // Catch: Throwable -> L6
        ILinkServiceExternal r0 = k.f(ILinkServiceExternal.class);     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.updateLiveMode(this.b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
