package com.larus.bmhome.chat.standarduikit.localfileblock.blockadapter;

import com.larus.bmhome.chat.standarduikit.localfileblock.view.PcLocalFileCardView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.localfileblock.blockadapter.PcLocalFileBlockHolder$refreshCachedFile$1", f = "PcLocalFileBlockHolder.kt", i = {}, l = {147}, m = "invokeSuspend", n = {}, s = {})
public final class PcLocalFileBlockHolder$refreshCachedFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onCacheReady;
    final /* synthetic */ com.larus.bmhome.chat.standarduikit.localfileblock.remote.g $request;
    final /* synthetic */ PcLocalFileCardView $view;
    Object L$0;
    int label;
    final /* synthetic */ PcLocalFileBlockHolder this$0;

    public PcLocalFileBlockHolder$refreshCachedFile$1(PcLocalFileCardView r1, PcLocalFileBlockHolder r2, com.larus.bmhome.chat.standarduikit.localfileblock.remote.g r3, Function0<Unit> r4, Continuation<? super PcLocalFileBlockHolder$refreshCachedFile$1> r5) {
        this.$view = r1;
        this.this$0 = r2;
        this.$request = r3;
        this.$onCacheReady = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new PcLocalFileBlockHolder$refreshCachedFile$1(this.$view, this.this$0, this.$request, this.$onCacheReady, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        PcLocalFileCardView r2 = (PcLocalFileCardView) this.L$0;
        ResultKt.throwOnFailure(r5);
    L12:
        r2.S5(((Boolean) r5).booleanValue());
        this.$onCacheReady.invoke();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        PcLocalFileCardView r6 = this.$view;
        PcLocalFileBlockHolder r3 = this.this$0;
        com.larus.bmhome.chat.standarduikit.localfileblock.remote.g r4 = this.$request;
        this.L$0 = r6;
        this.label = 1;
        Object r7 = PcLocalFileBlockHolder.j(r3, r4, this);
        if (r7 != r0) goto L11;
        return r0;
    L11:
        r2 = r6;
        r5 = r7;
        goto L12
    }
}
