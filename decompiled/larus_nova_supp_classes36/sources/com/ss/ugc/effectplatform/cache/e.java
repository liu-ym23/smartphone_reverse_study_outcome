package com.ss.ugc.effectplatform.cache;

import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.net.StrategyCacheClearModel;
import com.ss.ugc.effectplatform.task.b;
import com.ss.ugc.effectplatform.task.q1;
import com.ss.ugc.effectplatform.util.q;
import klc.a;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements IEffectPlatformBaseListener<StrategyCacheClearModel> {
    public final /* synthetic */ g a;
    public final /* synthetic */ Function3 b;

    public final void onSuccess(Object r5) {
        final StrategyCacheClearModel r6 = (StrategyCacheClearModel) r5;
        Logger.INSTANCE.d("JKL", "queryCacheClearStrategyFromServer onSuccess");
        g.a(this.a, "before");
        q1 r0 = this.a.a.D;
        if (r0 == null) goto L6;
        r0.a(new b(q.a(), new EffectCacheCleaner$cleanResourcesByServerStrategyWithAllowList$1$onSuccess$1(this, r6)));
        return;
    }

    public e(g r1, Function3 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFail(Object r8, ExceptionResult r9) {
        StrategyCacheClearModel r10 = (StrategyCacheClearModel) r8;
        Logger.INSTANCE.d("JKL", "queryFromServer onFail, server error: logId: " + r9.getLogId());
        a r0 = (a) this.a.a.v.a;
        if (r0 == null) goto L6;
        klc.b.m(r0, -1, "server error", r9.getLogId(), null, null, 24);
        return;
    }
}
