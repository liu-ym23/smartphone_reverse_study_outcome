package com.bytedance.android.live.effect.beauty.makeups;

import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements LiveMakeupsBeautyAdapter.a {
    public final /* synthetic */ LiveMakeupsBeautyFragment a;

    public b(LiveMakeupsBeautyFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.effect.beauty.makeups.LiveMakeupsBeautyAdapter.a
    public final void a(Sticker r5) {
        m90.c<Boolean> r0 = m90.b.h;
        LiveEffectContextFactoryDelegate$Type r1 = this.a.i;
        if (r5 == null) goto L5;
        boolean r3 = true;
    L6:
        r0.e(r1, Boolean.valueOf(r3));
        if ((!Intrinsics.areEqual(r5, this.a.e)) == false) goto L9;
        int r2 = com.bytedance.android.live.effect.beauty.smallitem.d.e;
        com.bytedance.android.live.effect.beauty.smallitem.d.a.a(this.a.i);
    L9:
        LiveMakeupsBeautyFragment r4 = this.a;
        r4.e = r5;
        List<String> r6 = LiveEffectContext.h;
        a.C0185a.a(LiveEffectContext.a.a(r4.i).b().f(), r5, "ttlive_anchor_effect_LiveMakeupsBeautyFragment_OnSelectItemChange_");
        this.a.U90();
        return;
    L5:
        r3 = false;
        goto L6
    }
}
