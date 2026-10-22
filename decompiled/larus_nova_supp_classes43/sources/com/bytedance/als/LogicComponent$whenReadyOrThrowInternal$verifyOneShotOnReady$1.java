package com.bytedance.als;

import com.bytedance.als.exceptions.ALSFrameworkInternalException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/bytedance/als/b;", "T", "api", "", "invoke", "(Lcom/bytedance/als/b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final class LogicComponent$whenReadyOrThrowInternal$verifyOneShotOnReady$1 extends Lambda implements Function1<b, Unit> {
    final /* synthetic */ Function1 $onReady;
    final /* synthetic */ Ref.BooleanRef $onReadyInvoked;

    public LogicComponent$whenReadyOrThrowInternal$verifyOneShotOnReady$1(Ref.BooleanRef r1, Function1 r10) {
        this.$onReadyInvoked = r1;
        this.$onReady = r10;
        super(1);
    }

    public final void invoke(b r10) {
        Intrinsics.checkNotNullParameter(r10, "api");
        Ref.BooleanRef r0 = this.$onReadyInvoked;
        if (r0.element == true) goto L7;
        r0.element = true;
        this.$onReady.invoke(r10);
        return;
    L7:
        throw new ALSFrameworkInternalException("Repeated call");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((b) r1);
        return Unit.INSTANCE;
    }
}
