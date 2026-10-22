package com.ss.ugc.effectplatform.task;

import bytekn.foundation.logger.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16})
final class EffectFetcherTask$executeImp2$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ y this$0;

    public EffectFetcherTask$executeImp2$3(y r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1589invoke() {
        Logger.INSTANCE.w("JKL", "[特效][等待锁][特效文件已存在][等待模型下载][" + this.this$0.h.getName() + ']');
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1589invoke();
        return Unit.INSTANCE;
    }
}
