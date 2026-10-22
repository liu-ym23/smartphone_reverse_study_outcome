package com.bytedance.android.live.effect.common;

import com.bytedance.android.live.effect.base.AdjustPercentBar;
import com.bytedance.android.livesdkapi.depend.model.Sticker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements AdjustPercentBar.d {
    public final /* synthetic */ Sticker.ComposerConfig a;
    public final /* synthetic */ AdjustBarListAdapter b;

    @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
    public final void b() {
    }

    @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
    public final void a(int r3) {
        AdjustBarListAdapter r4 = this.b;
        Sticker r0 = r4.a;
        if (r0 == null) goto L6;
        r4.d.a(r0, this.a);
        return;
    }

    @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
    public final void onChanged(int r4) {
        AdjustBarListAdapter r0 = this.b;
        Sticker r1 = r0.a;
        if (r1 == null) goto L6;
        r0.d.b(r1, this.a, r4);
        return;
    }

    public c(Sticker.ComposerConfig r1, AdjustBarListAdapter r2) {
        this.a = r1;
        this.b = r2;
    }
}
