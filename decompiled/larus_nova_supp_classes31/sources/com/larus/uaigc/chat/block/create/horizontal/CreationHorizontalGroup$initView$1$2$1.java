package com.larus.uaigc.chat.block.create.horizontal;

import android.view.View;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.block.create.horizontal.CreationHorizontalGroup$initView$1$2$1", f = "CreationHorizontalGroup.kt", i = {}, l = {212}, m = "invokeSuspend", n = {}, s = {})
final class CreationHorizontalGroup$initView$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ cz9.b $data;
    final /* synthetic */ View $root;
    final /* synthetic */ iy9.b $videoPlayParams;
    int label;
    final /* synthetic */ CreationHorizontalGroup this$0;

    public CreationHorizontalGroup$initView$1$2$1(CreationHorizontalGroup r1, cz9.b r2, iy9.b r3, View r4, Continuation<? super CreationHorizontalGroup$initView$1$2$1> r5) {
        this.this$0 = r1;
        this.$data = r2;
        this.$videoPlayParams = r3;
        this.$root = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new CreationHorizontalGroup$initView$1$2$1(this.this$0, this.$data, this.$videoPlayParams, this.$root, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        CreationHorizontalGroup r7 = this.this$0;
        cz9.b r2 = this.$data;
        iy9.b r3 = this.$videoPlayParams;
        View r4 = this.$root;
        this.label = 1;
        if (CreationHorizontalGroup.o(r7, r2, r3, r4, this) != r0) goto L12;
        return r0;
    }
}
