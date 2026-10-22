package com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.atmosphere.hot;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends BaseControllerListener<Object> {
    public final /* synthetic */ MiniAppHotAtmosphereView a;

    public b(MiniAppHotAtmosphereView r1) {
        this.a = r1;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        this.a.b = true;
    }
}
