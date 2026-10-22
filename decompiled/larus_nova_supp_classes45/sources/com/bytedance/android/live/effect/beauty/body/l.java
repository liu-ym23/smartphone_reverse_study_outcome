package com.bytedance.android.live.effect.beauty.body;

import android.view.View;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ LiveBodyBeautyListFragment a;

    public l(LiveBodyBeautyListFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        List<String> r3 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.a.l).b().p().b(this.a.x);
    }
}
