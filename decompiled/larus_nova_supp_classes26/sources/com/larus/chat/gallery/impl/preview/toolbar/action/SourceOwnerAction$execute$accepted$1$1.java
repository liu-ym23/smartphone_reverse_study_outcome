package com.larus.chat.gallery.impl.preview.toolbar.action;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.toolbar.action.SourceOwnerAction$execute$accepted$1$1", f = "SourceOwnerAction.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SourceOwnerAction$execute$accepted$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ l0 $context;
    final /* synthetic */ com.larus.chat.gallery.api.y $result;
    int label;

    public SourceOwnerAction$execute$accepted$1$1(com.larus.chat.gallery.api.y r1, l0 r2, Continuation<? super SourceOwnerAction$execute$accepted$1$1> r3) {
        this.$result = r1;
        this.$context = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SourceOwnerAction$execute$accepted$1$1(this.$result, this.$context, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r15);
        com.larus.chat.gallery.api.y r16 = this.$result;
        if (Intrinsics.areEqual(r16, com.larus.chat.gallery.api.y.b.a) == false) goto L8;
        this.$context.e.Rf(com.larus.gallery.api.p.g.a);
    L18:
        return Unit.INSTANCE;
    L8:
        if ((r16 instanceof com.larus.chat.gallery.api.y.d) == false) goto L11;
        l0 r17 = this.$context;
        r17.e.Rf(new com.larus.gallery.api.p.j(xy8.d.a(r17.a, null, null, null, null, null, null, null, null, null, 0, 131071), false));
        goto L18
    L11:
        if (Intrinsics.areEqual(r16, com.larus.chat.gallery.api.y.a.a) == true) goto L18;
        if (Intrinsics.areEqual(r16, com.larus.chat.gallery.api.y.c.a) == true) goto L18;
        throw new NoWhenBranchMatchedException();
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
