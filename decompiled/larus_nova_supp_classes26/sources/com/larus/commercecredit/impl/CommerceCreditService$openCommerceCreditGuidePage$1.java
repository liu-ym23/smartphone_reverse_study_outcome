package com.larus.commercecredit.impl;

import android.content.Context;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.commercecredit.impl.utils.CommerceCreditConfigManager;
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
@DebugMetadata(c = "com.larus.commercecredit.impl.CommerceCreditService$openCommerceCreditGuidePage$1", f = "CommerceCreditService.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
public final class CommerceCreditService$openCommerceCreditGuidePage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ DowngradeSource $source;
    int label;

    public CommerceCreditService$openCommerceCreditGuidePage$1(DowngradeSource r1, Context r2, Continuation<? super CommerceCreditService$openCommerceCreditGuidePage$1> r3) {
        this.$source = r1;
        this.$context = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CommerceCreditService$openCommerceCreditGuidePage$1(this.$source, this.$context, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.commercecredit.impl.b] */
    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        CommerceCreditConfigManager r6 = CommerceCreditConfigManager.a;
        DowngradeSource r7 = this.$source;
        final Context r2 = this.$context;
        ?? r3 = new b(r2);
        this.label = 1;
        if (CommerceCreditConfigManager.i(r7, r3, this) != r0) goto L12;
        return r0;
    }
}
