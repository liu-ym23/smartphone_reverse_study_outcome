package com.lark.kmp.rustclient.api.model;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\n"}, d2 = {"<anonymous>", "", "RAW", "DATA", "r", "Lcom/lark/kmp/rustclient/api/model/RustOutput;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.lark.kmp.rustclient.api.model.RustOutputKt$subscribeDataOrError$1", f = "RustOutput.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RustOutputKt$subscribeDataOrError$1 extends SuspendLambda implements Function2<g<Object, Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Throwable, Unit> $onError;
    final /* synthetic */ Function1<Object, Unit> $onNext;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public RustOutputKt$subscribeDataOrError$1(Function1<Object, Unit> r1, Function1<? super Throwable, Unit> r2, Continuation<? super RustOutputKt$subscribeDataOrError$1> r3) {
        this.$onNext = r1;
        this.$onError = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        RustOutputKt$subscribeDataOrError$1 r0 = new RustOutputKt$subscribeDataOrError$1(this.$onNext, this.$onError, r5);
        r0.L$0 = r4;
        return r0;
    }

    public final Object invoke(g<Object, Object> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((g) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r2);
        g r3 = (g) this.L$0;
        if ((r3 instanceof k) == false) goto L8;
        this.$onNext.invoke(((k) r3).b);
    L11:
        return Unit.INSTANCE;
    L8:
        if ((r3 instanceof b) == false) goto L13;
        this.$onError.invoke(((b) r3).b.a());
        goto L11
    L13:
        throw new NoWhenBranchMatchedException();
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
