package com.bytedance.android.live.effect.avadjust;

import android.view.View;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ LiveColorAdjustFragment a;

    public f(LiveColorAdjustFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        List<String> r3 = LiveEffectContext.h;
        l.b(LiveEffectContext.a.a(this.a.getType()).b().n(), this.a.n);
    }
}
