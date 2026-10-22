package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.widget;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.message.model.ja;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c extends GameHonorEffectWidget.b {
    public final /* synthetic */ long d;
    public final /* synthetic */ Function1 e;
    public final /* synthetic */ ja f;

    public final void b() {
        ALogger.i("GameHonorEffectWidget", "session stop, id " + this.d);
        this.e.invoke(this);
    }

    public c(long r1, Function1 r3, ja r4, long r5, ja r7, GameHonorEffectWidget.a r8) {
        this.d = r1;
        this.e = r3;
        this.f = r4;
        super(r5, r7, r8);
    }
}
