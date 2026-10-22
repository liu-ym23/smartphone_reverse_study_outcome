package com.bytedance.als;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/bytedance/als/b;", "T", "it", "", "invoke", "(Lcom/bytedance/als/b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final class LogicComponent$whenReadyOrThrow$2 extends Lambda implements Function1<b, Unit> {
    final /* synthetic */ Function1 $callback;

    public LogicComponent$whenReadyOrThrow$2(Function1 r1) {
        this.$callback = r1;
        super(1);
    }

    public final void invoke(b r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        this.$callback.invoke(r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((b) r1);
        return Unit.INSTANCE;
    }
}
