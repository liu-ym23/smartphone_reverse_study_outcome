package f2;

import com.bytedance.ai.model.AppletRuntimeManager;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j implements g2.c {
    public j() {
    }

    @Override // g2.c
    public final void onAllActivityDestroyed() {
    }

    @Override // g2.c
    public final void onAppBackground() {
        AppletRuntimeManager r0 = AppletRuntimeManager.INSTANCE;
        Function1 r1 = new h();
        r0.getClass();
        AppletRuntimeManager.g(r1);
        AppletRuntimeManager.f = true;
    }

    @Override // g2.c
    public final void onAppForeground() {
        AppletRuntimeManager r0 = AppletRuntimeManager.INSTANCE;
        Function1 r1 = new i();
        r0.getClass();
        AppletRuntimeManager.g(r1);
        AppletRuntimeManager.f = false;
    }
}
