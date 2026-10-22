package com.bytedance.android.live.liveinteract.animation.universalwidget.effect;

import ca0.h;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements h {
    public final /* synthetic */ long a;
    public final /* synthetic */ Function1 b;

    public b(long r1, Function1 r3) {
        this.a = r1;
        this.b = r3;
    }

    public final void onResult(int r4) {
        ALogger.i("MicseatMixer#MultiLinkEffectManager", "appendComposer.session:" + this.a + ". onResult:" + r4);
        this.b.invoke(Boolean.TRUE);
    }
}
