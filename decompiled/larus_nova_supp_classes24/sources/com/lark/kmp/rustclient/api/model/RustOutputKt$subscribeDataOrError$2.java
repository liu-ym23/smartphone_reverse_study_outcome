package com.lark.kmp.rustclient.api.model;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n"}, d2 = {"<anonymous>", "", "RAW", "DATA", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/lark/kmp/rustclient/api/model/RustOutput;", "cause", ""}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.lark.kmp.rustclient.api.model.RustOutputKt$subscribeDataOrError$2", f = "RustOutput.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RustOutputKt$subscribeDataOrError$2 extends SuspendLambda implements Function3<FlowCollector<? super g<Object, Object>>, Throwable, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Throwable, Unit> $onError;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public RustOutputKt$subscribeDataOrError$2(Function1<? super Throwable, Unit> r1, Continuation<? super RustOutputKt$subscribeDataOrError$2> r2) {
        this.$onError = r1;
        super(3, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((FlowCollector) r1, (Throwable) r2, (Continuation) r3);
    }

    public final Object invoke(FlowCollector<? super g<Object, Object>> r2, Throwable r3, Continuation<? super Unit> r4) {
        RustOutputKt$subscribeDataOrError$2 r5 = new RustOutputKt$subscribeDataOrError$2(this.$onError, r4);
        r5.L$0 = r3;
        return r5.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        Throwable r3 = (Throwable) this.L$0;
        this.$onError.invoke(r3);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
