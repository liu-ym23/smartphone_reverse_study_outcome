package com.larus.dora.impl.feedback;

import com.bytedance.common.utility.NetworkUtils;
import com.larus.common.apphost.AppHost;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.feedback.DoraFeedbackImage$uploadImage$2$uploadJob$1", f = "DoraGFeedbackViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraFeedbackImage$uploadImage$2$uploadJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ kotlinx.coroutines.i<Unit> $continuation;
    final /* synthetic */ p0 $imageXUploader;
    int label;

    public DoraFeedbackImage$uploadImage$2$uploadJob$1(p0 r1, kotlinx.coroutines.i<? super Unit> r2, Continuation<? super DoraFeedbackImage$uploadImage$2$uploadJob$1> r3) {
        this.$imageXUploader = r1;
        this.$continuation = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraFeedbackImage$uploadImage$2$uploadJob$1(this.$imageXUploader, this.$continuation, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r3);
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == false) goto L7;
        this.$imageXUploader.a();
    L9:
        return Unit.INSTANCE;
    L7:
        kotlinx.coroutines.i<Unit> r4 = this.$continuation;
        Result.Companion r0 = Result.Companion;
        r4.resumeWith(Result.constructor-impl(ResultKt.createFailure(new IOException("Network not available"))));
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
