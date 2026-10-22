package com.bytedance.android.live.effect.beauty.filter;

import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.base.AdjustPercentBar;
import com.bytedance.android.live.effect.q;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements AdjustPercentBar.d {
    public final /* synthetic */ LiveComposerFilterFragment a;

    @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
    public final void a(int r1) {
    }

    @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
    public final void b() {
    }

    public d(LiveComposerFilterFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
    public final void onChanged(int r9) {
        LiveComposerFilterFragment r0 = this.a;
        int r1 = LiveComposerFilterFragment.q;
        LiveComposerFilterAdapter r2 = r0.T90();
        int r3 = r2.d;
        if (r3 >= 0) goto L5;
    L8:
        Sticker r4 = new Sticker();
    L9:
        Sticker r5 = r4;
        if (r5.getComposerConfigList().isEmpty() == false) goto L12;
        return;
    L12:
        LiveComposerFilterHelper r6 = this.a.U90();
        Sticker.ComposerConfig r7 = (Sticker.ComposerConfig) CollectionsKt.first(r5.getComposerConfigList());
        r6.getClass();
        Intrinsics.checkNotNullParameter(r5, "sticker");
        Intrinsics.checkNotNullParameter(r7, "composerConfig");
        ILiveEffectComposerManager.f.d(r6.b(), d0.a, r5, r7.getTag(), q.c(r7, r9), null, 48);
        int r11 = com.bytedance.android.live.effect.beauty.smallitem.d.e;
        com.bytedance.android.live.effect.beauty.smallitem.d.a.a(this.a.getType());
        return;
    L5:
        if (r3 >= r2.getItemCount()) goto L8;
        r4 = (Sticker) ListProtector.get(r2.a, r2.d);
        goto L9
    }
}
