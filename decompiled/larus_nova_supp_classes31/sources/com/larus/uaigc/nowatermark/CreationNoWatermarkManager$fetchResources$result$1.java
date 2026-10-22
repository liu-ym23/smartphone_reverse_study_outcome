package com.larus.uaigc.nowatermark;

import com.larus.network.bean.BizResponse;
import com.larus.uaigc.api.CreationNoWatermarkApi;
import com.larus.uaigc.api.i;
import com.larus.uaigc.api.j;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/uaigc/api/GetResourceWithoutWatermarkData;", "Lcom/larus/uaigc/api/CreationNoWatermarkApi;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.nowatermark.CreationNoWatermarkManager$fetchResources$result$1", f = "CreationNoWatermarkManager.kt", i = {}, l = {1418}, m = "invokeSuspend", n = {}, s = {})
public final class CreationNoWatermarkManager$fetchResources$result$1 extends SuspendLambda implements Function2<CreationNoWatermarkApi, Continuation<? super BizResponse<i>>, Object> {
    final /* synthetic */ List<String> $uris;
    final /* synthetic */ List<String> $vids;
    private /* synthetic */ Object L$0;
    int label;

    public CreationNoWatermarkManager$fetchResources$result$1(List<String> r1, List<String> r2, Continuation<? super CreationNoWatermarkManager$fetchResources$result$1> r3) {
        this.$uris = r1;
        this.$vids = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        CreationNoWatermarkManager$fetchResources$result$1 r0 = new CreationNoWatermarkManager$fetchResources$result$1(this.$uris, this.$vids, r5);
        r0.L$0 = r4;
        return r0;
    }

    public final Object invoke(CreationNoWatermarkApi r1, Continuation<? super BizResponse<i>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CreationNoWatermarkApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L18:
        return r7;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CreationNoWatermarkApi r8 = (CreationNoWatermarkApi) this.L$0;
        List<String> r2 = this.$uris;
        List<String> r4 = null;
        if ((!r2.isEmpty()) == true) goto L12;
        r2 = null;
    L12:
        List<String> r3 = this.$vids;
        if ((!r3.isEmpty()) == false) goto L15;
        r4 = r3;
    L15:
        j r5 = new j(r2, r4);
        this.label = 1;
        r7 = r8.getResourceWithoutWatermark(r5, this);
        if (r7 != r0) goto L18;
        return r0;
    }
}
