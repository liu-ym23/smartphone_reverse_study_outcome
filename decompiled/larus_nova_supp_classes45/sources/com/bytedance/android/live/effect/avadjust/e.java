package com.bytedance.android.live.effect.avadjust;

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
public final class e implements LiveColorAdjustAdapter.a {
    public final /* synthetic */ LiveColorAdjustFragment a;

    public e(LiveColorAdjustFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.effect.avadjust.LiveColorAdjustAdapter.a
    public final void a(Sticker r2) {
        LiveColorAdjustFragment r0 = this.a;
        r0.e = r2;
        r0.V90("ttlive_anchor_effect_LiveColorAdjustFragment_colorAdjustItemChange");
    }

    @Override // com.bytedance.android.live.effect.avadjust.LiveColorAdjustAdapter.a
    public final void b(boolean r6) {
        Boolean r0 = Boolean.valueOf(r6);
        m90.c<Boolean> r1 = m90.b.b;
        if ((!Intrinsics.areEqual(r0, r1.c(this.a.getType()))) == false) goto L13;
        List<String> r2 = LiveEffectContext.h;
        com.bytedance.android.live.effect.api.c r3 = LiveEffectContext.a.a(this.a.getType()).e();
        HashMap<String, String> r4 = new HashMap();
        if (r6 == false) goto L7;
        String r5 = "on";
    L8:
        r4.put("status", r5);
        r4.put("tab_name", "adjust");
        r4.put("event_page", this.a.q);
        Unit r7 = Unit.INSTANCE;
        r3.sendLog("livesdk_enable_beautify", r4);
        PthreadHandlerThreadV2 r8 = LiveEffectMonitor.a;
        NewBroadcastMonitor.a r9 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_ANCHOR_AV_ADJUST_EFFECT_STATUS, null, null, 14);
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
        r1.e(this.a.getType(), Boolean.valueOf(r6));
        xs2.b.a().post(new n90.c(r6, "live_adjustment"));
        this.a.V90("onEnableChange");
        if (r6 == true) goto L16;
        f2.c("调节效果已关闭", 0);
    L16:
        List<String> r12 = LiveEffectContext.h;
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).e().d(false);
    }
}
