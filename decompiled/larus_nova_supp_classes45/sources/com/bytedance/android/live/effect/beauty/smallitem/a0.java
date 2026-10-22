package com.bytedance.android.live.effect.beauty.smallitem;

import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.base.AdjustPercentBar;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.u3;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a0 implements AdjustPercentBar.d {
    public final /* synthetic */ LiveSmallItemBeautyFragment a;

    @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
    public final void a(int r1) {
    }

    @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
    public final void b() {
    }

    public a0(LiveSmallItemBeautyFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
    public final void onChanged(int r9) {
        LiveSmallItemBeautyFragment r0 = this.a;
        if (r0.f != null) goto L5;
        return;
    L5:
        Disposable r1 = com.bytedance.android.live.effect.utils.k.a;
        List<String> r2 = LiveEffectContext.h;
        ILiveEffectComposerManager r3 = LiveEffectContext.a.a(r0.k).a();
        String r4 = com.bytedance.android.live.effect.api.d0.i;
        Sticker r5 = this.a.f;
        Intrinsics.checkNotNull(r5);
        Sticker r6 = this.a.f;
        if (r6 == null) goto L11;
        Sticker.ComposerConfig r7 = r6.getSmallItemConfig();
        if (r7 == null) goto L11;
        String r8 = r7.getTag();
        if (r8 == null) goto L11;
    L12:
        String r11 = r8;
        Sticker r12 = this.a.f;
        Intrinsics.checkNotNull(r12);
        ILiveEffectComposerManager.f.d(r3, r4, r5, r11, com.bytedance.android.live.effect.q.d(r12, r9), null, 48);
        AdjustPercentBar r13 = this.a.U90();
        int r14 = r3.a;
        if (r13 == null) goto L15;
        r13.postDelayed(new u3(r13), 100);
    L15:
        int r15 = d.e;
        d.a.a(this.a.k);
        return;
    L11:
        r8 = "";
        goto L12
    }
}
