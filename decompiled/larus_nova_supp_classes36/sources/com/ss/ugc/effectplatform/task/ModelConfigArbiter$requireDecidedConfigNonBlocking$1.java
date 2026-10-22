package com.ss.ugc.effectplatform.task;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16})
final class ModelConfigArbiter$requireDecidedConfigNonBlocking$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $businessId;
    final /* synthetic */ x0 this$0;

    public ModelConfigArbiter$requireDecidedConfigNonBlocking$1(x0 r1, int r2) {
        this.this$0 = r1;
        this.$businessId = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1628invoke() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        x0 r1 = this.this$0;     // Catch: Throwable -> L4
        int r2 = this.$businessId;     // Catch: Throwable -> L4
        z.b r3 = x0.h;     // Catch: Throwable -> L4
        Result.constructor-impl(r1.a(r2, false));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1628invoke();
        return Unit.INSTANCE;
    }
}
