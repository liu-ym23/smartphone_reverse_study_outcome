package com.larus.dora.obric.device_management.explore;

import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.explore.DoraObricGlassesBasicDetailFragment$bindDetailLottie$1$animationJson$1", f = "DoraObricGlassesBasicDetailFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraObricGlassesBasicDetailFragment$bindDetailLottie$1$animationJson$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ File $lottieFile;
    private /* synthetic */ Object L$0;
    int label;

    public DoraObricGlassesBasicDetailFragment$bindDetailLottie$1$animationJson$1(File r1, Continuation<? super DoraObricGlassesBasicDetailFragment$bindDetailLottie$1$animationJson$1> r2) {
        this.$lottieFile = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        DoraObricGlassesBasicDetailFragment$bindDetailLottie$1$animationJson$1 r0 = new DoraObricGlassesBasicDetailFragment$bindDetailLottie$1$animationJson$1(this.$lottieFile, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r5);
        CoroutineScope r6 = (CoroutineScope) this.L$0;
        File r7 = this.$lottieFile;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        Object r8 = Result.constructor-impl(FilesKt.readText$default(r7, null, 1, null));     // Catch: Throwable -> L7
    L9:
        Throwable r2 = Result.exceptionOrNull-impl(r8);
        if (r2 == null) goto L13;
        g49.d.b("DoraObricGlassesBasicDetailFragment", "read media detail lottie failed: " + r2.getMessage());
    L13:
        if (Result.isFailure-impl(r8) == false) goto L16;
        return null;
    L16:
        return r8;
    L7:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
