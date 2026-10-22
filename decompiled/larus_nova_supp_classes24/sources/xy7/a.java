package xy7;

import com.bytedance.ies.xelement.overlay.ng.LynxOverlayViewProxyNG;
import com.larksuite.component.card.component.xcomponent.CardOverlayShadowNodeNG;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxUI;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a extends com.lynx.tasm.behavior.a {
    public final ShadowNode createShadowNode() {
        return new CardOverlayShadowNodeNG();
    }

    public a() {
        super("x-overlay-ng");
    }

    public final LynxUI<?> createUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return createUIWithParams(r2, null);
    }

    public final LynxUI<?> createUIWithParams(LynxContext r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new LynxOverlayViewProxyNG(r2, r3);
    }
}
