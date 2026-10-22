package f2;

import com.bytedance.ai.applet.grantingV2.McpGrantingManager;
import com.bytedance.ai.model.AppletRuntimeManager;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g implements g2.e {
    public g() {
    }

    @Override // g2.e
    public final void onActivityDestroy() {
    }

    @Override // g2.e
    public final void onActivityPaused() {
    }

    @Override // g2.e
    public final void onActivityResumed() {
    }

    @Override // g2.e
    public final void onContextCleared(final String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        McpGrantingManager.a.getClass();
        com.bytedance.ai.utils.g.a.i("McpGrantingManagerV2", "onContextCleared");
        McpGrantingManager.d("context_cleared", null);
        AppletRuntimeManager r0 = AppletRuntimeManager.INSTANCE;
        Function1 r1 = new f(r10);
        r0.getClass();
        AppletRuntimeManager.g(r1);
    }

    @Override // g2.e
    public final void onViewCreated(final String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        AppletRuntimeManager r0 = AppletRuntimeManager.INSTANCE;
        Function1 r1 = new e(r10);
        r0.getClass();
        AppletRuntimeManager.g(r1);
    }

    @Override // g2.e
    public final void onViewDestroyed(final String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r0 = AppletRuntimeManager.d;
        if (r0 == null) goto L7;
        int r1 = r0.R(r10);
    L9:
        if (r1 <= 0) goto L12;
        com.bytedance.ai.utils.g.a.i("AppletEnv", "skip unBindSession(" + r10 + "), activeChatUICount=" + r1);
        return;
    L12:
        com.bytedance.ai.utils.g.a.i("AppletEnv", "unBindSession(" + r10 + ')');
        AppletRuntimeManager.g(new d(r10));
        return;
    L7:
        r1 = 0;
        goto L9
    }
}
