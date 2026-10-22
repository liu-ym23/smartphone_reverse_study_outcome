package com.bytedance.android.live.effect.beauty.newtemp;

import android.view.View;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ LiveOneTapBeautyListFragment a;

    public g(LiveOneTapBeautyListFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        this.a.S90(2131386947).showLoading();
        List<String> r5 = LiveEffectContext.h;
        c.a(LiveEffectContext.a.a(this.a.e).b().c(), this.a.e, new WeakReference(this.a.l));
    }
}
