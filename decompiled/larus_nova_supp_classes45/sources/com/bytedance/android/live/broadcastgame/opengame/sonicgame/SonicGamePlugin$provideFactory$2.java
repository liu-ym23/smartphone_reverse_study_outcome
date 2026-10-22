package com.bytedance.android.live.broadcastgame.opengame.sonicgame;

import com.bytedance.android.live.broadcastgame.opengame.runtime.b0;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class SonicGamePlugin$provideFactory$2 extends b0 {
    public final /* synthetic */ SonicGamePlugin b;

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.b0
    public final Function0<com.bytedance.android.live.broadcastgame.opengame.panel.h> b() {
        return new SonicGamePlugin$provideFactory$2$providePanel$1(this);
    }

    public SonicGamePlugin$provideFactory$2(SonicGamePlugin r1) {
        this.b = r1;
    }
}
