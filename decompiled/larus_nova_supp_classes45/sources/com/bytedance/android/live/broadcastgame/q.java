package com.bytedance.android.live.broadcastgame;

import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ AudienceMagicBoxBehavior a;

    public q(AudienceMagicBoxBehavior r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        AudienceMagicBoxBehavior.b(this.a);
        LocalTestManager.a(new Class[]{wy.a.class});
    }
}
