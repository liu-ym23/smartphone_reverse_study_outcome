package com.bytedance.android.live.effect.beauty.makeups;

import android.view.View;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ LiveMakeupsBeautyFragment a;

    public c(LiveMakeupsBeautyFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        List<String> r3 = LiveEffectContext.h;
        a r4 = LiveEffectContext.a.a(this.a.i).b().f();
        d r5 = (d) r4;
        r5.b(this.a.o);
    }
}
