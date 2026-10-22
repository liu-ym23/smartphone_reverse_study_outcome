package com.ss.ugc.effectplatform.repository;

import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16})
public final class AlgorithmRepository$fetchResourcesWithModelNames$1$run$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Exception $e;
    final /* synthetic */ AlgorithmRepository.fetchResourcesWithModelNames.1 this$0;

    public AlgorithmRepository$fetchResourcesWithModelNames$1$run$1(AlgorithmRepository.fetchResourcesWithModelNames.1 r1, Exception r2) {
        this.this$0 = r1;
        this.$e = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m22invoke() {
        AlgorithmRepository.fetchResourcesWithModelNames.1 r0 = this.this$0;
        IEffectPlatformBaseListener r1 = r0.c;
        if (r1 == null) goto L6;
        r1.onFail(r0.d, new ExceptionResult(this.$e));
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m22invoke();
        return Unit.INSTANCE;
    }
}
