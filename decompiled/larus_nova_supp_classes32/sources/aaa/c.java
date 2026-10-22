package aaa;

import com.obric.aiagent.platform.depend.ILogDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.framework.services.SingletonProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c implements a {
    public static final c a = null;
    public static final a b = null;

    public c() {
    }

    static {
        a = new c();
        ServiceManager.get().bind(a.class, new SingletonProvider(new b()));     // Catch: Exception -> L9
        Object r2 = ServiceManager.get().getService(a.class, false);     // Catch: Exception -> L9
        if (((a) r2) != null) goto L6;
        ILogDepend.a.w("WindowEffects", "bind WindowEffectsImpl failed");     // Catch: Exception -> L9
    L7:
        a r3 = (a) r2;     // Catch: Exception -> L9
    L11:
        b = r3;
        return;
    L6:
        ILogDepend.a.i("WindowEffects", "bind WindowEffectsImpl success");     // Catch: Exception -> L9
    L9:
        e = move-exception;
        ILogDepend.a.e("WindowEffects", "bind WindowEffectsImpl failed", e);
        r3 = null;
        goto L11
    }

    @Override // aaa.a
    public final void stopActivateEffect() {
        a r0 = b;
        if (r0 == null) goto L6;
        r0.stopActivateEffect();
        return;
    }

    @Override // aaa.a
    public final void startActivateEffect(boolean r2) {
        a r0 = b;
        if (r0 == null) goto L6;
        r0.startActivateEffect(r2);
        return;
    }

    @Override // aaa.a
    public final void a(boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "windowLayerName");
        a r0 = b;
        if (r0 == null) goto L6;
        r0.a(r2, r3);
        return;
    }

    @Override // aaa.a
    public final void b(boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "windowLayerName");
        a r0 = b;
        if (r0 == null) goto L6;
        r0.b(r2, r3);
        return;
    }
}
