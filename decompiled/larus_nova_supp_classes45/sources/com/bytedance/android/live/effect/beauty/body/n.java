package com.bytedance.android.live.effect.beauty.body;

import android.view.View;
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
public final class n implements AdjustPercentBar.d {
    public final /* synthetic */ LiveBodyBeautyListFragment a;

    @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
    public final void a(int r1) {
    }

    @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
    public final void b() {
    }

    public n(LiveBodyBeautyListFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
    public final void onChanged(int r9) {
        LiveBodyBeautyListFragment r0 = this.a;
        if (r0.f != null) goto L5;
        return;
    L5:
        Disposable r1 = com.bytedance.android.live.effect.utils.k.a;
        List<String> r2 = LiveEffectContext.h;
        ILiveEffectComposerManager r3 = LiveEffectContext.a.a(r0.l).a();
        Sticker r4 = this.a.f;
        Intrinsics.checkNotNull(r4);
        Sticker r5 = this.a.f;
        if (r5 == null) goto L11;
        Sticker.ComposerConfig r6 = r5.getSmallItemConfig();
        if (r6 == null) goto L11;
        String r7 = r6.getTag();
        if (r7 == null) goto L11;
    L12:
        String r8 = r7;
        Sticker r11 = this.a.f;
        Intrinsics.checkNotNull(r11);
        ILiveEffectComposerManager.f.d(r3, "livebody", r4, r8, com.bytedance.android.live.effect.q.d(r11, r9), null, 48);
        View r12 = this.a.W90();
        int r13 = r3.a;
        if (r12 == null) goto L15;
        r12.postDelayed(new u3(r12), 100);
    L15:
        Sticker r14 = this.a.f;
        if (r14 == null) goto L20;
        Sticker.ComposerConfig r15 = r14.getSmallItemConfig();
        if (r15 == null) goto L20;
        int r16 = r15.getDefaultValue();
    L21:
        LiveBodyBeautyListFragment r17 = this.a;
        boolean r18 = r17.g;
        if (r18 == true) goto L24;
        if (r9 == r16) goto L24;
    L26:
        r17.T90();
        return;
    L24:
        if (r18 == false) goto L28;
        if (r9 == r16) goto L26;
        return;
    L28:
        return;
    L20:
        r16 = 0;
    L11:
        r7 = "";
        goto L12
    }
}
