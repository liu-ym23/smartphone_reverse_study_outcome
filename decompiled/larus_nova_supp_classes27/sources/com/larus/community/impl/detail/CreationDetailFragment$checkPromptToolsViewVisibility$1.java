package com.larus.community.impl.detail;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.detail.CreationDetailFragment$checkPromptToolsViewVisibility$1", f = "CreationDetailFragment.kt", i = {}, l = {820}, m = "invokeSuspend", n = {}, s = {})
public final class CreationDetailFragment$checkPromptToolsViewVisibility$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $timeSinceLastScroll;
    int label;
    final /* synthetic */ CreationDetailFragment this$0;

    public CreationDetailFragment$checkPromptToolsViewVisibility$1(long r1, CreationDetailFragment r3, Continuation<? super CreationDetailFragment$checkPromptToolsViewVisibility$1> r4) {
        this.$timeSinceLastScroll = r1;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CreationDetailFragment$checkPromptToolsViewVisibility$1(this.$timeSinceLastScroll, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L11:
        CreationDetailFragment r9 = this.this$0;
        int r3 = CreationDetailFragment.u;
        com.larus.community.impl.detail.prompt.a r10 = r9.X90();
        if (r10 != null) goto L14;
    L16:
        r2 = false;
    L17:
        if (r2 == false) goto L22;
        com.larus.community.impl.detail.bottomtools.a r11 = this.this$0.V90();
        if (r11 == null) goto L22;
        r11.Cr();
    L22:
        return Unit.INSTANCE;
    L14:
        if (r10.vG() == true) goto L16;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        long r4 = ((long) 30) - this.$timeSinceLastScroll;
        this.label = 1;
        if (DelayKt.delay(r4, this) != r0) goto L11;
        return r0;
    }
}
