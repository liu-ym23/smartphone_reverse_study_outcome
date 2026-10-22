package com.larus.dora.impl.dynamic.loader;

import com.larus.dora.impl.dynamic.z1;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;", "com/larus/dora/impl/dynamic/loader/DoraDynamicDataLoader$requestData$2"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.loader.DoraDynamicDataLoader$requestData$2", f = "DoraDynamicDataLoader.kt", i = {}, l = {243}, m = "invokeSuspend", n = {}, s = {})
public final class DoraDynamicDataLoader$requestAndProcessData$$inlined$requestData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super z1>, Object> {
    final /* synthetic */ String $model;
    final /* synthetic */ String $pageKey;
    final /* synthetic */ Integer $productId;
    int label;
    final /* synthetic */ a this$0;

    public DoraDynamicDataLoader$requestAndProcessData$$inlined$requestData$1(a r1, Integer r2, String r3, String r4, Continuation r5) {
        this.this$0 = r1;
        this.$productId = r2;
        this.$model = r3;
        this.$pageKey = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DoraDynamicDataLoader$requestAndProcessData$$inlined$requestData$1(this.this$0, this.$productId, this.$model, this.$pageKey, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super z1> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L11:
        com.larus.network.http.f r12 = (com.larus.network.http.a) r11;
        if ((r12 instanceof com.larus.network.http.f) == false) goto L15;
        FLogger.a.e("DoraDynamicDataLoader", "Network request failed: " + r12.d.getMessage());
        return null;
    L15:
        return ((com.larus.network.http.a) r12).b;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        Integer r13 = this.$productId;
        String r2 = this.$pageKey;
        com.larus.dora.api.network.a r3 = com.larus.dora.api.network.a.a;
        JSONObject r6 = new JSONObject();
        r6.put("product_id", String.valueOf(r13));
        r6.put(DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY, r2);
        this.label = 1;
        r11 = com.larus.dora.api.network.a.c(r3, z1.class, "/alice/device/page_data", r6, null, this, 248);
        if (r11 != r0) goto L11;
        return r0;
    }
}
