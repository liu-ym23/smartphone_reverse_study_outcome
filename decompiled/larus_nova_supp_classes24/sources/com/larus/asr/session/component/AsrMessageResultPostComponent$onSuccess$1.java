package com.larus.asr.session.component;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.asr.session.component.AsrMessageResultPostComponent$onSuccess$1", f = "AsrMessageResultPostComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AsrMessageResultPostComponent$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $alterSnapshot;
    final /* synthetic */ f0 $context;
    final /* synthetic */ boolean $rawIntercepted;
    final /* synthetic */ boolean $successIntercepted;
    int label;
    final /* synthetic */ AsrMessageResultPostComponent this$0;

    public AsrMessageResultPostComponent$onSuccess$1(f0 r1, AsrMessageResultPostComponent r2, boolean r3, boolean r4, boolean r5, Continuation<? super AsrMessageResultPostComponent$onSuccess$1> r6) {
        this.$context = r1;
        this.this$0 = r2;
        this.$alterSnapshot = r3;
        this.$rawIntercepted = r4;
        this.$successIntercepted = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new AsrMessageResultPostComponent$onSuccess$1(this.$context, this.this$0, this.$alterSnapshot, this.$rawIntercepted, this.$successIntercepted, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r3);
        if (this.$context.a() == false) goto L7;
        AsrMessageResultPostComponent r4 = this.this$0;
        boolean r0 = this.$alterSnapshot;
        if (this.$rawIntercepted == false) goto L11;
    L14:
        boolean r1 = true;
    L15:
        r4.v(r0, r1);
        return Unit.INSTANCE;
    L11:
        if (this.$successIntercepted == true) goto L14;
        r1 = false;
        goto L15
    L7:
        return Unit.INSTANCE;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
