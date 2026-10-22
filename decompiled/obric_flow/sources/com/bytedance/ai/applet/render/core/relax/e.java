package com.bytedance.ai.applet.render.core.relax;

import android.content.Context;
import com.relax.relaxclay.UIRenderClayCreator;
import com.relax.relaxui.envs.UIRenderRelaxUI;
import com.relax.uirender.UIRenderRegistry;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {
    public static UIRenderRegistry.RenderType a(Context r5, RelaxRenderView$RenderMode r10) {
        if (f.e == true) goto L6;
        f.e = true;
        UIRenderRelaxUI.initGlobal(r5.getApplicationContext(), null);
        UIRenderRegistry.register(UIRenderRegistry.RenderType.CLAY, new UIRenderClayCreator());
        UIRenderRegistry.register(UIRenderRegistry.RenderType.LYNX_UI, new d());
    L6:
        return r10.a();
    }
}
