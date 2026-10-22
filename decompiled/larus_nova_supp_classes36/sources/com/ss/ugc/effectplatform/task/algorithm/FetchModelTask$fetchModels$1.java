package com.ss.ugc.effectplatform.task.algorithm;

import bytekn.foundation.logger.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16})
final class FetchModelTask$fetchModels$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ FetchModelTask this$0;

    public FetchModelTask$fetchModels$1(FetchModelTask r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1643invoke() {
        Logger.INSTANCE.d("JKL", "[模型][释放锁][模型队列为空][" + this.this$0.u + ']');
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1643invoke();
        return Unit.INSTANCE;
    }
}
