package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "T", "R", "Lcom/ss/ugc/effectplatform/model/NetResponseChecker;", "invoke", "com/ss/ugc/effectplatform/task/BaseNetworkTask$onSuccess$1$1"}, k = 3, mv = {1, 1, 16})
public final class BaseNetworkTask$onSuccess$$inlined$apply$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Object $data$inlined;
    final /* synthetic */ BaseNetworkTask this$0;

    public BaseNetworkTask$onSuccess$$inlined$apply$lambda$1(BaseNetworkTask r1, Object r2) {
        this.this$0 = r1;
        this.$data$inlined = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1567invoke() {
        BaseNetworkTask r0 = this.this$0;
        IEffectPlatformBaseListener r1 = r0.j.a(r0.k);
        if (r1 == null) goto L5;
        r1.onSuccess(this.$data$inlined);
    L5:
        BaseNetworkTask r2 = this.this$0;
        r2.j.c(r2.k);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1567invoke();
        return Unit.INSTANCE;
    }
}
