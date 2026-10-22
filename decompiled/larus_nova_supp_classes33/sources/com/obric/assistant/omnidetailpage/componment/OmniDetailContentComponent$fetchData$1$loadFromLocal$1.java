package com.obric.assistant.omnidetailpage.componment;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.omnidetailpage.componment.OmniDetailContentComponent$fetchData$1$loadFromLocal$1", f = "OmniDetailContentComponent.kt", i = {}, l = {1198, 1197}, m = "invokeSuspend", n = {}, s = {})
public final class OmniDetailContentComponent$fetchData$1$loadFromLocal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ mf9.c $result;
    Object L$0;
    int label;
    final /* synthetic */ OmniDetailContentComponent this$0;

    public OmniDetailContentComponent$fetchData$1$loadFromLocal$1(OmniDetailContentComponent r1, mf9.c r2, Continuation<? super OmniDetailContentComponent$fetchData$1$loadFromLocal$1> r3) {
        this.this$0 = r1;
        this.$result = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new OmniDetailContentComponent$fetchData$1$loadFromLocal$1(this.this$0, this.$result, r4);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r6);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        OmniDetailContentComponent r2 = (OmniDetailContentComponent) this.L$0;
        ResultKt.throwOnFailure(r6);
    L13:
        this.L$0 = null;
        this.label = 2;
        if (OmniDetailContentComponent.m3(r2, (List) r6, this) != r0) goto L17;
        return r0;
    L10:
        ResultKt.throwOnFailure(r6);
        this.this$0.D = Boxing.boxBoolean(!this.$result.b);
        OmniDetailContentComponent r7 = this.this$0;
        mf9.c r3 = this.$result;
        r7.E = r3.b;
        List r8 = OmniDetailContentComponent.Y2(r7, r3.a);
        OmniDetailContentComponent.B3(this.this$0, r8, false);
        r2 = this.this$0;
        boolean r4 = this.$result.b;
        this.L$0 = r2;
        this.label = 1;
        r6 = OmniDetailContentComponent.h3(r2, r8, r4, this);
        if (r6 != r0) goto L13;
        return r0;
    }
}
