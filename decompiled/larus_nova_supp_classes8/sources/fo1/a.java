package fo1;

import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.floatview.p;
import com.larus.apm.impl.protector.RunnableProtector;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements Runnable {
    public final /* synthetic */ b a;

    public a(b r1) {
        this.a = r1;
    }

    public final void a() {
        ILinkServiceExternal r0 = k.f(ILinkServiceExternal.class);
        if (r0 == null) goto L5;
        r0.updateLiveMode(this.a.i);
    L5:
        b r1 = this.a;
        b.f(r1, r1.i);
        this.a.b();
        boolean r2 = p.a;
        com.bytedance.android.livesdk.floatview.inner.b.c = this.a.b();
        IInteractService r3 = k.f(IInteractService.class);
        if (r3 == null) goto L11;
        com.bytedance.android.live.liveinteract.service.g r4 = r3.getInteractFloatWindowService();
        if (r4 == null) goto L12;
        com.bytedance.android.live.liveinteract.service.g r5 = r4;
        r5.c(this.a.b());
        return;
    L12:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
