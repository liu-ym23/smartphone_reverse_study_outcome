package com.larus.uaigc.lynx.pocket;

import com.bytedance.keva.Keva;
import com.larus.network.bean.BizResponse;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002\u0018\u00010\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "", "", "", "Lcom/larus/uaigc/lynx/pocket/PocketApi;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.lynx.pocket.PocketDataCache$refreshGetPocketPageDataResponseDataCache$2$result$1", f = "PocketDataCache.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
public final class PocketDataCache$refreshGetPocketPageDataResponseDataCache$2$result$1 extends SuspendLambda implements Function2<PocketApi, Continuation<? super BizResponse<Map<String, ? extends Object>>>, Object> {
    final /* synthetic */ String $source;
    private /* synthetic */ Object L$0;
    int label;

    public PocketDataCache$refreshGetPocketPageDataResponseDataCache$2$result$1(String r1, Continuation<? super PocketDataCache$refreshGetPocketPageDataResponseDataCache$2$result$1> r2) {
        this.$source = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        PocketDataCache$refreshGetPocketPageDataResponseDataCache$2$result$1 r0 = new PocketDataCache$refreshGetPocketPageDataResponseDataCache$2$result$1(this.$source, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(PocketApi r1, Continuation<? super BizResponse<Map<String, Object>>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((PocketApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L11:
        return r8;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        PocketApi r9 = (PocketApi) this.L$0;
        PocketDataCache.a.getClass();
        boolean r3 = o0.d(((Keva) PocketDataCache.b.getValue()).getString("pocket_page_online_data_".concat(o.a.getDeviceId()), ""));
        FLogger.a.i("SpringMainVenueDataManager", "[hasGetPocketPageDataResponseDataCache] hasCache = " + r3);
        GetPocketPageDataRequest r2 = new GetPocketPageDataRequest(Boxing.boxBoolean(r3), this.$source);
        this.label = 1;
        r8 = r9.getPocketPageData(r2, this);
        if (r8 != r0) goto L11;
        return r0;
    }
}
