package com.bytedance.android.live.effect.avadjust.lens;

import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.base.AdjustPercentBar;
import com.bytedance.android.live.effect.q;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements AdjustPercentBar.d {
    public final /* synthetic */ LiveLensFragment a;

    @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
    public final void a(int r1) {
    }

    @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
    public final void b() {
    }

    public c(LiveLensFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
    public final void onChanged(int r9) {
        LiveLensFragment r0 = this.a;
        if (r0.e != null) goto L5;
        return;
    L5:
        List<String> r1 = LiveEffectContext.h;
        ILiveEffectComposerManager r2 = LiveEffectContext.a.a(r0.getType()).a();
        Sticker r3 = this.a.e;
        Intrinsics.checkNotNull(r3);
        Sticker r4 = this.a.e;
        if (r4 == null) goto L11;
        Sticker.ComposerConfig r5 = r4.getSmallItemConfig();
        if (r5 == null) goto L11;
        String r6 = r5.getTag();
        if (r6 == null) goto L11;
    L12:
        String r7 = r6;
        Sticker r8 = this.a.e;
        Intrinsics.checkNotNull(r8);
        ILiveEffectComposerManager.f.d(r2, "live_adjustment", r3, r7, q.d(r8, r9), null, 48);
        return;
    L11:
        r6 = "";
        goto L12
    }
}
