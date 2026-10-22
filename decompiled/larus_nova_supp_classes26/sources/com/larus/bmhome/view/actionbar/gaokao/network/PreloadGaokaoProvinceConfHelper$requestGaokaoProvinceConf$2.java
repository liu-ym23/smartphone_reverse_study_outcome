package com.larus.bmhome.view.actionbar.gaokao.network;

import com.larus.network.bean.BizResponse;
import com.larus.utils.logger.FLogger;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/view/actionbar/gaokao/network/GaokaoProvinceConfResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.gaokao.network.PreloadGaokaoProvinceConfHelper$requestGaokaoProvinceConf$2", f = "PreloadGaokaoProvinceConfHelper.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
public final class PreloadGaokaoProvinceConfHelper$requestGaokaoProvinceConf$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BizResponse<GaokaoProvinceConfResponse>>, Object> {
    int label;

    public PreloadGaokaoProvinceConfHelper$requestGaokaoProvinceConf$2(Continuation<? super PreloadGaokaoProvinceConfHelper$requestGaokaoProvinceConf$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new PreloadGaokaoProvinceConfHelper$requestGaokaoProvinceConf$2(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super BizResponse<GaokaoProvinceConfResponse>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r21);
        Object r3 = r21;
    L14:
        a.b r4 = (a) r3;
        if ((r4 instanceof a.b) == false) goto L19;
        return r4.a;
    L19:
        if ((r4 instanceof a.a) == false) goto L23;
        FLogger.a.i("PreloadGaokaoProvinceConfHelper", String.valueOf(((a.a) r4).c));
        return new BizResponse(-1, null, null, null, 14, null);
    L23:
        return new BizResponse(-1, null, null, null, 14, null);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r21);
        BizResponse<GaokaoProvinceConfResponse> r5 = PreloadGaokaoProvinceConfHelper.b;
        if (r5 == null) goto L11;
        return r5;
    L11:
        GaokaoApi.a r6 = GaokaoApi.a;
        PreloadGaokaoProvinceConfHelper$requestGaokaoProvinceConf$2$result$1 r7 = new PreloadGaokaoProvinceConfHelper$requestGaokaoProvinceConf$2$result$1(null);
        this.label = 1;
        r6.getClass();
        r3 = GaokaoApi.a.a(r7, this);
        if (r3 != r1) goto L14;
        return r1;
    }
}
