package com.larus.commercecredit.impl.page;

import com.larus.commercecredit.api.CreditInfoScene;
import com.larus.commercecredit.impl.utils.CommerceCreditConfigManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.commercecredit.impl.page.CommerceCreditInfoFragment$updateViews$1$1", f = "CommerceCreditInfoFragment.kt", i = {}, l = {150}, m = "invokeSuspend", n = {}, s = {})
final class CommerceCreditInfoFragment$updateViews$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CommerceCreditInfoFragment this$0;

    public CommerceCreditInfoFragment$updateViews$1$1(CommerceCreditInfoFragment r1, Continuation<? super CommerceCreditInfoFragment$updateViews$1$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CommerceCreditInfoFragment$updateViews$1$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        CommerceCreditConfigManager r13 = CommerceCreditConfigManager.a;
        CreditInfoScene r3 = CreditInfoScene.COMMERCE_CREDIT_INFO_PANEL_RETRY;
        int r14 = com.larus.commercecredit.impl.utils.k.a;
        String r6 = com.larus.commercecredit.impl.utils.k.a(this.this$0.getArguments(), "previous_page");
        String r7 = com.larus.commercecredit.impl.utils.k.a(this.this$0.getArguments(), "enter_method");
        final CommerceCreditInfoFragment r15 = this.this$0;
        Function3 r8 = new q(r15);
        this.label = 1;
        if (CommerceCreditConfigManager.b(r3, false, false, r6, r7, r8, this, 2) != r0) goto L12;
        return r0;
    }
}
