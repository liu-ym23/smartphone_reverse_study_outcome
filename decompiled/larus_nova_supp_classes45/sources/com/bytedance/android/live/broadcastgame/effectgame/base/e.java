package com.bytedance.android.live.broadcastgame.effectgame.base;

import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements IFetchEffectListener {
    public final /* synthetic */ c.a a;
    public final /* synthetic */ String b;

    public final void onStart(Effect r2) {
        Intrinsics.checkNotNullParameter(r2, NewBroadcastMonitor.STAGE.EFFECT);
    }

    public final void onSuccess(Object r2) {
        Effect r3 = (Effect) r2;
        Intrinsics.checkNotNullParameter(r3, NewBroadcastMonitor.STAGE.EFFECT);
        com.bytedance.android.live.effect.sticker.d.c(r3).subscribe(new d(this));
    }

    public e(c.a r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFail(Effect r2, ExceptionResult r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        this.a.b(this.b, r3);
    }
}
