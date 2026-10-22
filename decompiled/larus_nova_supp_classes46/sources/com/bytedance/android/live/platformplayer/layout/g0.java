package com.bytedance.android.live.platformplayer.layout;

import android.os.SystemClock;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g0<T> implements Observer {
    public final /* synthetic */ LivePlayerWidget a;
    public final /* synthetic */ Ref.LongRef b;

    public g0(LivePlayerWidget r1, Ref.LongRef r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r3) {
        Boolean r4 = (Boolean) r3;
        Ref.LongRef r5 = this.b;
        r5.element = SystemClock.elapsedRealtime();
        IPerformanceManager r6 = jc1.k.f(IPerformanceManager.class);
        if (r6 == null) goto L5;
        r6.onStreamNetStallStart();
    L5:
        LivePlayerWidget r7 = this.a;
        int r0 = LivePlayerWidget.V2;
        r7.getClass();
    }
}
