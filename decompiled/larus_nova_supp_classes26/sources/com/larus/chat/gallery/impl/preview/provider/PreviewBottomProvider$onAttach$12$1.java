package com.larus.chat.gallery.impl.preview.provider;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.provider.PreviewBottomProvider$onAttach$12$1", f = "PreviewBottomProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PreviewBottomProvider$onAttach$12$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $success;
    int label;
    final /* synthetic */ PreviewBottomProvider this$0;

    public PreviewBottomProvider$onAttach$12$1(boolean r1, PreviewBottomProvider r2, Continuation<? super PreviewBottomProvider$onAttach$12$1> r3) {
        this.$success = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new PreviewBottomProvider$onAttach$12$1(this.$success, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r2);
        if (this.$success == false) goto L10;
        PreviewBottomProvider r3 = this.this$0;
        int r0 = PreviewBottomProvider.x;
        com.larus.gallery.api.w r4 = ((com.larus.gallery.api.t) r3).e;
        if (r4 == null) goto L10;
        r4.Rf(com.larus.gallery.api.p.c.a);
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
