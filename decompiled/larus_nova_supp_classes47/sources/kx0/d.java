package kx0;

import com.bytedance.android.live.recharge.view.CJShadowNode;
import com.bytedance.android.live.recharge.view.RechargeCjComponentView;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxUI;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d extends com.lynx.tasm.behavior.a {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
        super("live-cj-pay");
    }

    public final ShadowNode createShadowNode() {
        return new CJShadowNode();
    }

    public final LynxUI<?> createUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new RechargeCjComponentView(r2);
    }
}
