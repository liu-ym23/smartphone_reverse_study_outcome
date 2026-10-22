package com.larus.vesdk.impl.utils;

import android.graphics.Bitmap;
import com.larus.ivykit.forest.IFlowForestService;
import com.larus.platform.api.c4;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.vesdk.impl.utils.VeOCRController$hasTxtOnImage$4", f = "VeOCRController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VeOCRController$hasTxtOnImage$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ c4.b $callback;
    private /* synthetic */ Object L$0;
    int label;

    public VeOCRController$hasTxtOnImage$4(c4.b r1, Bitmap r2, Continuation<? super VeOCRController$hasTxtOnImage$4> r3) {
        this.$callback = r1;
        this.$bitmap = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        VeOCRController$hasTxtOnImage$4 r0 = new VeOCRController$hasTxtOnImage$4(this.$callback, this.$bitmap, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L27;
        ResultKt.throwOnFailure(r6);
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        c4.b r8 = this.$callback;
        Bitmap r0 = this.$bitmap;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L18
        Lazy r2 = n.a;     // Catch: Throwable -> L18
        IFlowForestService r3 = (IFlowForestService) ServiceManager.get().getService(IFlowForestService.class);     // Catch: Throwable -> L18
        boolean r4 = false;
        if (r3 == null) goto L8;
        String r5 = r3.b(n.b, "vesdk_model_resource", false);     // Catch: Throwable -> L18
    L9:
        if (r5 != null) goto L11;
    L12:
        r4 = true;
    L13:
        if (r4 == false) goto L15;
        r8.onError("model file is not exits");     // Catch: Throwable -> L18
    L16:
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L20:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L25;
        FLogger.a.e("VeOCRController", "ocr image by ve error:" + r10);
    L25:
        return Unit.INSTANCE;
    L15:
        n.a(r0, r5, r8);     // Catch: Throwable -> L18
        goto L16
    L11:
        if (r5.length() != 0) goto L13;
    L8:
        r5 = null;
    L18:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L27:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
