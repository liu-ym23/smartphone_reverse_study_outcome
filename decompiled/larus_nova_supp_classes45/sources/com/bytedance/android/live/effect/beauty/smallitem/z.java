package com.bytedance.android.live.effect.beauty.smallitem;

import android.view.View;
import com.bytedance.android.live.effect.LiveSmallItemBeautyHelper;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class z implements View.OnClickListener {
    public final /* synthetic */ LiveSmallItemBeautyFragment a;

    public z(LiveSmallItemBeautyFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        List<String> r4 = LiveEffectContext.h;
        LiveSmallItemBeautyHelper.d(LiveEffectContext.a.a(this.a.k).b().g(), this.a.x, 10);
    }
}
