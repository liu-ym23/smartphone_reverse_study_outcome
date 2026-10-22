package com.larus.drive.biz.impl.viewmodel;

import com.larus.utils.logger.FLogger;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel$loadFiles$1$onError$1", f = "AbsDriveListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AbsDriveListViewModel$loadFiles$1$onError$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $error;
    int label;
    final /* synthetic */ AbsDriveListViewModel this$0;

    public AbsDriveListViewModel$loadFiles$1$onError$1(AbsDriveListViewModel r1, String r2, Continuation<? super AbsDriveListViewModel$loadFiles$1$onError$1> r3) {
        this.this$0 = r1;
        this.$error = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AbsDriveListViewModel$loadFiles$1$onError$1(this.this$0, this.$error, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        FLogger.a.i(this.this$0.getTag(), "loadFiles: onError " + this.$error);
        AbsDriveListViewModel.access$get_isLoading$p(this.this$0).setValue(Boxing.boxBoolean(false));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
