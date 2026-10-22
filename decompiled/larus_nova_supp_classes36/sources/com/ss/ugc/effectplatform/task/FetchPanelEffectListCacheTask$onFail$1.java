package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16})
final class FetchPanelEffectListCacheTask$onFail$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ExceptionResult $exceptionResult;
    final /* synthetic */ FetchPanelEffectListCacheTask this$0;

    public FetchPanelEffectListCacheTask$onFail$1(FetchPanelEffectListCacheTask r1, ExceptionResult r2) {
        this.this$0 = r1;
        this.$exceptionResult = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1612invoke() {
        FetchPanelEffectListCacheTask r0 = this.this$0;
        IEffectPlatformBaseListener r1 = r0.g.N.a(r0.i);
        if (r1 == null) goto L5;
        r1.onFail(null, this.$exceptionResult);
    L5:
        FetchPanelEffectListCacheTask r2 = this.this$0;
        r2.g.N.c(r2.i);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1612invoke();
        return Unit.INSTANCE;
    }
}
