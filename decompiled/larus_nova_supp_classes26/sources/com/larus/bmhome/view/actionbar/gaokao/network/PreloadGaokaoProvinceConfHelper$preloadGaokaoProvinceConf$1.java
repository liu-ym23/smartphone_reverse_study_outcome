package com.larus.bmhome.view.actionbar.gaokao.network;

import com.larus.network.bean.BizResponse;
import dm9.a;
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
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.gaokao.network.PreloadGaokaoProvinceConfHelper$preloadGaokaoProvinceConf$1", f = "PreloadGaokaoProvinceConfHelper.kt", i = {}, l = {19}, m = "invokeSuspend", n = {}, s = {})
public final class PreloadGaokaoProvinceConfHelper$preloadGaokaoProvinceConf$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public PreloadGaokaoProvinceConfHelper$preloadGaokaoProvinceConf$1(Continuation<? super PreloadGaokaoProvinceConfHelper$preloadGaokaoProvinceConf$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new PreloadGaokaoProvinceConfHelper$preloadGaokaoProvinceConf$1(r2);
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
        BizResponse<GaokaoProvinceConfResponse> r3 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        a.b r6 = (a) r5;
        if ((r6 instanceof a.b) == false) goto L18;
        PreloadGaokaoProvinceConfHelper r2 = PreloadGaokaoProvinceConfHelper.a;
        a.b r7 = r6;
        if (r7.a.isSuccess() == false) goto L16;
        r3 = r7.a;
    L16:
        PreloadGaokaoProvinceConfHelper.b = r3;
    L21:
        return Unit.INSTANCE;
    L18:
        if ((r6 instanceof a.a) == false) goto L21;
        PreloadGaokaoProvinceConfHelper.b = null;
        goto L21
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        GaokaoApi.a r8 = GaokaoApi.a;
        PreloadGaokaoProvinceConfHelper$preloadGaokaoProvinceConf$1$result$1 r4 = new PreloadGaokaoProvinceConfHelper$preloadGaokaoProvinceConf$1$result$1(null);
        this.label = 1;
        r8.getClass();
        r5 = GaokaoApi.a.a(r4, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
