package com.obric.assistant.remote_card_container.widget;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.remote_card_container.widget.RemoteCardContainer$onCardStateChanged$1", f = "RemoteCardContainer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RemoteCardContainer$onCardStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cardUri;
    int label;
    final /* synthetic */ RemoteCardContainer this$0;

    public RemoteCardContainer$onCardStateChanged$1(String r1, RemoteCardContainer r2, Continuation<? super RemoteCardContainer$onCardStateChanged$1> r3) {
        this.$cardUri = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RemoteCardContainer$onCardStateChanged$1(this.$cardUri, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r3);
        String r4 = this.$cardUri;
        a r0 = this.this$0.b;
        if (r0 == null) goto L7;
        String r1 = r0.a;
    L9:
        if (Intrinsics.areEqual(r4, r1) == false) goto L12;
        p9a.b.a("RemoteCardContainer", "onCardStateChanged");
        RemoteCardContainer r5 = this.this$0;
        r5.d(r5.b, false);
    L12:
        return Unit.INSTANCE;
    L7:
        r1 = null;
        goto L9
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
