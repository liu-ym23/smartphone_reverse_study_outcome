package com.bytedance.android.live.effect.beauty;

import android.view.View;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j implements View.OnClickListener {
    public final /* synthetic */ LiveBeautyTemplateDetailFragment a;

    public j(LiveBeautyTemplateDetailFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        this.a.S90(2131386947).showLoading();
        List<String> r6 = LiveEffectContext.h;
        com.bytedance.android.live.effect.beauty.smallitem.d.d(LiveEffectContext.a.a(this.a.h).b().l(), "style", this.a.h, new WeakReference(this.a.o), 8);
    }
}
