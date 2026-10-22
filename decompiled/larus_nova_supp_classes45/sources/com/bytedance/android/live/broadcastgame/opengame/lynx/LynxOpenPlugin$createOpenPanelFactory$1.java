package com.bytedance.android.live.broadcastgame.opengame.lynx;

import com.bytedance.android.live.broadcastgame.opengame.runtime.b0;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LynxOpenPlugin$createOpenPanelFactory$1 extends b0 {
    public final /* synthetic */ LynxOpenPlugin b;

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.b0
    public final Function0<com.bytedance.android.live.broadcastgame.opengame.panel.h> b() {
        return new LynxOpenPlugin$createOpenPanelFactory$1$providePanel$1(this);
    }

    public LynxOpenPlugin$createOpenPanelFactory$1(LynxOpenPlugin r1) {
        this.b = r1;
    }
}
