package com.bytedance.android.live.effect.beauty.smallitem;

import android.view.View;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.base.AdjustPercentBar;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.u3;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k implements AdjustPercentBar.d {
    public final /* synthetic */ LiveBeautySecondLevelFragment a;

    @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
    public final void a(int r1) {
    }

    @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
    public final void b() {
    }

    public k(LiveBeautySecondLevelFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
    public final void onChanged(int r11) {
        LiveBeautySecondLevelFragment r0 = this.a;
        if (r0.e != null) goto L5;
        return;
    L5:
        Disposable r1 = com.bytedance.android.live.effect.utils.k.a;
        List<String> r2 = LiveEffectContext.h;
        ILiveEffectComposerManager r3 = LiveEffectContext.a.a(r0.k).a();
        String r4 = com.bytedance.android.live.effect.api.d0.i;
        Sticker r5 = this.a.e;
        Intrinsics.checkNotNull(r5);
        Sticker r6 = this.a.e;
        if (r6 == null) goto L11;
        Sticker.ComposerConfig r7 = r6.getSmallItemConfig();
        if (r7 == null) goto L11;
        String r8 = r7.getTag();
        if (r8 == null) goto L11;
    L12:
        Sticker r9 = this.a.e;
        Intrinsics.checkNotNull(r9);
        int r12 = 0;
        String r13 = r8;
        ILiveEffectComposerManager.f.d(r3, r4, r5, r13, com.bytedance.android.live.effect.q.d(r9, r11), MapsKt.hashMapOf(new Pair[]{TuplesKt.to("is_adjust_by_user", "")}), 16);
        View r14 = this.a.Y90();
        int r15 = r3.a;
        if (r14 == null) goto L15;
        r14.postDelayed(new u3(r14), 100);
    L15:
        int r16 = d.e;
        d.a.a(this.a.k);
        Sticker r17 = this.a.e;
        if (r17 == null) goto L22;
        List r18 = r17.getComposerConfigList();
        if (r18 == null) goto L22;
        Sticker.ComposerConfig r19 = (Sticker.ComposerConfig) CollectionsKt.firstOrNull(r18);
        if (r19 == null) goto L22;
        r12 = r19.getDefaultValue();
    L22:
        LiveBeautySecondLevelFragment r21 = this.a;
        boolean r22 = r21.g;
        if (r22 == true) goto L25;
        if (r11 == r12) goto L25;
    L27:
        r21.U90();
        return;
    L25:
        if (r22 == false) goto L29;
        if (r11 == r12) goto L27;
        return;
    L29:
        return;
    L11:
        r8 = "";
        goto L12
    }
}
