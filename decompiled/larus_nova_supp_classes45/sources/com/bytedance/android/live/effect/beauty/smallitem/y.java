package com.bytedance.android.live.effect.beauty.smallitem;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.utils.LiveEffectMonitor;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class y implements LiveSmallItemBeautyAdapter.a {
    public final /* synthetic */ LiveSmallItemBeautyFragment a;

    public y(LiveSmallItemBeautyFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.effect.beauty.smallitem.LiveSmallItemBeautyAdapter.a
    public final void a(Sticker r3) {
        LiveSmallItemBeautyFragment r0 = this.a;
        r0.f = r3;
        r0.V90("ttlive_anchor_effect_LiveSmallItemBeautyFragment_beautyItemChange");
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.isSubItem() == false) goto L9;
        int r4 = d.e;
        d.a.a(this.a.k);
        return;
    }

    @Override // com.bytedance.android.live.effect.beauty.smallitem.LiveSmallItemBeautyAdapter.a
    public final void b(boolean r7) {
        Boolean r0 = Boolean.valueOf(r7);
        m90.c<Boolean> r1 = m90.b.a;
        if ((!Intrinsics.areEqual(r0, r1.c(this.a.k))) == false) goto L9;
        List<String> r2 = LiveEffectContext.h;
        com.bytedance.android.live.effect.api.c r3 = LiveEffectContext.a.a(this.a.k).e();
        HashMap<String, String> r4 = new HashMap();
        if (r7 == false) goto L7;
        String r5 = "on";
    L8:
        r4.put("status", r5);
        Unit r6 = Unit.INSTANCE;
        r3.sendLog("livesdk_enable_beautify", r4);
        PthreadHandlerThreadV2 r8 = LiveEffectMonitor.a;
        LiveEffectMonitor.a(r7);
        goto L9
    L7:
        r5 = "off";
    L9:
        r1.e(this.a.k, Boolean.valueOf(r7));
        xs2.b.a().post(new n90.c(r7, com.bytedance.android.live.effect.api.d0.i));
        m90.c<Integer> r9 = m90.b.A;
        Integer r11 = r9.c(this.a.k);
        if (r7 == true) goto L16;
        if (r11 == null) goto L16;
        if (r11.intValue() != 0) goto L16;
        r9.e(this.a.k, 1);
    L22:
        this.a.V90("ttlive_anchor_effect_LiveSmallItemBeautyFragment_beautyEnableChange");
        if (r7 == true) goto L25;
        f2.c("美颜效果已关闭", 0);
        int r12 = d.e;
        d.a.a(this.a.k);
    L25:
        List<String> r13 = LiveEffectContext.h;
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).e().d(false);
        return;
    L16:
        if (r7 == false) goto L22;
        if (r11 == null) goto L22;
        if (r11.intValue() != 1) goto L22;
        r9.e(this.a.k, 2);
        goto L22
    }
}
