package com.larus.drive.sdk.impl.utils;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.utils.ObjTokenGetUrlHelper$getUrlByToken$1$type$1", f = "ObjTokenGetUrlHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObjTokenGetUrlHelper$getUrlByToken$1$type$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $audioUrl;
    final /* synthetic */ Function1<String, Unit> $onFailure;
    final /* synthetic */ Function1<String, Unit> $onSuccess;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ObjTokenGetUrlHelper$getUrlByToken$1$type$1(String r1, Function1<? super String, Unit> r2, Function1<? super String, Unit> r3, Continuation<? super ObjTokenGetUrlHelper$getUrlByToken$1$type$1> r4) {
        this.$audioUrl = r1;
        this.$onSuccess = r2;
        this.$onFailure = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        ObjTokenGetUrlHelper$getUrlByToken$1$type$1 r0 = new ObjTokenGetUrlHelper$getUrlByToken$1$type$1(this.$audioUrl, this.$onSuccess, this.$onFailure, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r2);
        CoroutineScope r3 = (CoroutineScope) this.L$0;
        String r4 = this.$audioUrl;
        if (r4 == null) goto L7;
        this.$onSuccess.invoke(r4);
    L11:
        return Unit.INSTANCE;
    L7:
        Function1<String, Unit> r5 = this.$onFailure;
        if (r5 == null) goto L11;
        r5.invoke("");
        goto L11
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
