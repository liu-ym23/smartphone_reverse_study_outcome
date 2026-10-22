package com.lynx.xelement.overlay;

import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.LynxBehavior;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxGeneratorName;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@LynxBehavior(isCreateAsync = false, tagName = {"overlay"})
@LynxGeneratorName(packageName = "com.lynx.xelement.overlay")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/lynx/xelement/overlay/LynxUIOverlayNG;", "Lcom/lynx/xelement/overlay/LynxUIOverlay;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", LynxResourceModule.PARAMS_KEY, NameKeys.UnloadStrategy_No_Strategy, "(Lcom/lynx/tasm/behavior/LynxContext;Ljava/lang/Object;)V", "Overlay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class LynxUIOverlayNG extends LynxUIOverlay {
    public LynxUIOverlayNG(LynxContext r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }
}
