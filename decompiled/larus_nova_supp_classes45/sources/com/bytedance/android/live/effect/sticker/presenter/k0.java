package com.bytedance.android.live.effect.sticker.presenter;

import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.effectmanager.effect.model.Effect;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k0 implements Runnable {
    public final /* synthetic */ l0 a;
    public final /* synthetic */ Effect b;

    public k0(l0 r1, Effect r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o.c r0 = this.a.a;     // Catch: Throwable -> L10
        if (r0 != null) goto L5;
        return;
    L5:
        if (LiveEffectSettings.LIVE_EFFECT_FIX_STICKER_CONVERT_WITH_PANEL.getValue().booleanValue() == false) goto L7;
        Sticker r1 = com.bytedance.android.live.effect.sticker.d.d(this.b, this.a.b);     // Catch: Throwable -> L10
    L8:
        r0.a(r1);     // Catch: Throwable -> L10
        return;
    L7:
        r1 = com.bytedance.android.live.effect.sticker.d.b(this.b);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L17;
        throw th;
    }
}
