package com.bytedance.android.live.effect.sticker;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.utils.LiveEffectMonitor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l implements IFetchEffectListener {
    public final /* synthetic */ k a;
    public final /* synthetic */ long b;

    public final void onStart(Effect r1) {
    }

    public final void onSuccess(Object r4) {
        Effect r5 = (Effect) r4;
        if (r5 != null) goto L5;
        PthreadHandlerThreadV2 r6 = LiveEffectMonitor.a;
        LiveEffectMonitor.h();
        this.a.a();
        return;
    L5:
        k r0 = this.a;
        r0.d.put(r5.getEffect_id(), r5);
        r0.a();
    }

    public l(k r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFail(Effect r3, ExceptionResult r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        ALogger.d("ttlive_anchor_effect_MultiAnchorEffectHelper", "download failed,effectID:" + this.b);
        PthreadHandlerThreadV2 r5 = LiveEffectMonitor.a;
        LiveEffectMonitor.h();
        this.a.a();
    }
}
