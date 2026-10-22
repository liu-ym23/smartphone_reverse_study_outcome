package com.bytedance.android.live.effect.beauty.body;

import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
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
public final class k implements LiveBodyBeautyAdapter.a {
    public final /* synthetic */ LiveBodyBeautyListFragment a;
    public final /* synthetic */ LiveBodyBeautyAdapter b;

    @Override // com.bytedance.android.live.effect.beauty.body.LiveBodyBeautyAdapter.a
    public final void a(Sticker r2) {
        LiveBodyBeautyListFragment r0 = this.a;
        r0.f = r2;
        r0.X90();
    }

    @Override // com.bytedance.android.live.effect.beauty.body.LiveBodyBeautyAdapter.a
    public final void b(boolean r6) {
        Boolean r0 = Boolean.valueOf(r6);
        m90.c<Boolean> r1 = m90.b.j;
        if ((!Intrinsics.areEqual(r0, r1.c(this.a.l))) == false) goto L13;
        List<String> r2 = LiveEffectContext.h;
        com.bytedance.android.live.effect.api.c r3 = LiveEffectContext.a.a(this.a.l).e();
        HashMap<String, String> r4 = new HashMap();
        if (r6 == false) goto L7;
        String r5 = "on";
    L8:
        r4.put("status", r5);
        Unit r7 = Unit.INSTANCE;
        r3.sendLog("livesdk_enable_beautify", r4);
        PthreadHandlerThreadV2 r8 = LiveEffectMonitor.a;
        NewBroadcastMonitor.a r9 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_ANCHOR_BODY_BEAUTY_EFFECT_STATUS, null, null, 14);
        if (r6 == false) goto L11;
        String r11 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L12:
        r9.c(r11);
        r9.a().report();
        goto L13
    L11:
        r11 = "0";
        goto L12
    L7:
        r5 = "off";
    L13:
        r1.e(this.a.l, Boolean.valueOf(r6));
        xs2.b.a().post(new n90.c(r6, "livebody"));
        this.a.X90();
        if (r6 == true) goto L17;
        f2.c("美体效果已关闭", 0);
    L17:
        if (this.a.m == false) goto L19;
        this.b.notifyDataSetChanged();
    L19:
        List<String> r12 = LiveEffectContext.h;
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).e().d(false);
    }

    @Override // com.bytedance.android.live.effect.beauty.body.LiveBodyBeautyAdapter.a
    public final void c(Sticker r4) {
        Intrinsics.checkNotNullParameter(r4, "sticker");
        int r0 = com.bytedance.android.live.effect.utils.a.a;
        String r5 = r4.getName();
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        Intrinsics.checkNotNullParameter(r5, "effectName");
        HashMap r1 = new HashMap();
        r1.put("effect_name", r5);
        com.bytedance.android.live.effect.utils.c.a("livesdk_beautybody_icon_click", r1, "");
    }

    public k(LiveBodyBeautyListFragment r1, LiveBodyBeautyAdapter r2) {
        this.a = r1;
        this.b = r2;
    }
}
