package com.ss.ugc.effectplatform.task;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "Lcom/ss/ugc/effectplatform/model/e;", "R", "", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class BaseNetworkTask$onCancel$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BaseNetworkTask this$0;

    public BaseNetworkTask$onCancel$1(BaseNetworkTask r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1566invoke() {
        BaseNetworkTask r0 = this.this$0;
        String r1 = r0.k;
        if (r1 == null) goto L6;
        r0.j.c(r1);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1566invoke();
        return Unit.INSTANCE;
    }
}
