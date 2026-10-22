package k4;

import com.bytedance.ai.bridge.core.AIBridgeMethod;
import com.bytedance.ai.settings.d;
import i3.b;
import kotlin.jvm.internal.Intrinsics;
import p2.c;
import t5.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements b {
    @Override // i3.b
    public final int getPriority() {
        return 40;
    }

    @Override // i3.b
    public final void reset() {
    }

    public a() {
    }

    @Override // i3.b
    public final AIBridgeMethod.Error a(i3.a r10) {
        Intrinsics.checkNotNullParameter(r10, "invocation");
        if (c.b() == true) goto L5;
        return null;
    L5:
        d.a.getClass();
        l r0 = d.a().aiBridgeConfig().c();
        if (r0 != null) goto L9;
        r0 = new l(null);
    L9:
        if (r0.b() == true) goto L12;
        return null;
    L12:
        if (r0.a().contains(r10.a) == false) goto L14;
        return null;
    L14:
        com.bytedance.ai.applet.base.log.b r1 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.d("ai_bridge", "[AIBridge][MTS] method:" + r10.a + " prohibited on main thread", null);
        return new AIBridgeMethod.Error(-1, "method " + r10.a + " is not allowed to run on main thread (MTS)", null, f3.a.l);
    }
}
