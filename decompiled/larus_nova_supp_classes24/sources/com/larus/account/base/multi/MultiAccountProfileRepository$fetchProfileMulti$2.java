package com.larus.account.base.multi;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.http.request.HttpHeaders;
import com.larus.network.FlowHttpConnection;
import com.larus.network.http.CommonApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/account/base/multi/MultiProfileInfoResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.account.base.multi.MultiAccountProfileRepository$fetchProfileMulti$2", f = "MultiAccountProfileRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MultiAccountProfileRepository$fetchProfileMulti$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super k>, Object> {
    final /* synthetic */ List<String> $visitIds;
    private /* synthetic */ Object L$0;
    int label;

    public MultiAccountProfileRepository$fetchProfileMulti$2(List<String> r1, Continuation<? super MultiAccountProfileRepository$fetchProfileMulti$2> r2) {
        this.$visitIds = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MultiAccountProfileRepository$fetchProfileMulti$2 r0 = new MultiAccountProfileRepository$fetchProfileMulti$2(this.$visitIds, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super k> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r15);
        CoroutineScope r16 = (CoroutineScope) this.L$0;
        List<String> r17 = this.$visitIds;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L7
        r2.put("visit_sec_ids", new JSONArray(r17));     // Catch: Throwable -> L7
        r2.put("from", 2);     // Catch: Throwable -> L7
        TypedByteArray r6 = new TypedByteArray("application/json", r2.toString().getBytes(Charsets.UTF_8), new String[0]);     // Catch: Throwable -> L7
        SsResponse r19 = ((CommonApi) FlowHttpConnection.c(FlowHttpConnection.a, "Social", CommonApi.class, null, null, null, 28)).doPost("/alice/profile/multi", null, r6, MapsKt.mapOf(TuplesKt.to(HttpHeaders.HEAD_KEY_CONTENT_TYPE, "application/json")), null).execute();     // Catch: Throwable -> L7
        int r0 = MultiAccountProfileRepository.a;     // Catch: Throwable -> L7
        Object r110 = Result.constructor-impl(MultiAccountProfileRepository.a((String) r19.body()));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r110) == false) goto L17;
        return null;
    L17:
        return r110;
    L7:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r110 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
