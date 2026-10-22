package com.bytedance.android.live.platformplayer.layout;

import android.os.SystemClock;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h0<T> implements Observer {
    public final /* synthetic */ LivePlayerWidget a;
    public final /* synthetic */ Ref.LongRef b;
    public final /* synthetic */ List c;

    public h0(LivePlayerWidget r1, Ref.LongRef r2, List r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onChanged(Object r5) {
        Boolean r6 = (Boolean) r5;
        if (this.b.element != 0) goto L6;
        return;
    L6:
        if (((Widget) this.a).context == null) goto L19;
        long r0 = SystemClock.elapsedRealtime();
        if (r0 <= this.b.element) goto L16;
        IPerformanceManager r7 = jc1.k.f(IPerformanceManager.class);
        if (r7 == null) goto L13;
        r7.onStreamNetStallEnd();
    L13:
        IPerformanceManager r8 = jc1.k.f(IPerformanceManager.class);
        if (r8 == null) goto L16;
        r8.onStreamNetStall(Long.valueOf(r0 - this.b.element));
    L16:
        LivePlayerWidget r9 = this.a;
        int r1 = LivePlayerWidget.V2;
        r9.getClass();
        return;
    }
}
