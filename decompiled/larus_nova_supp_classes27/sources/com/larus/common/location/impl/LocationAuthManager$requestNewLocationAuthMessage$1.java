package com.larus.common.location.impl;

import com.larus.network.http.HttpExtKt;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import hq9.y2;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.location.impl.LocationAuthManager$requestNewLocationAuthMessage$1", f = "LocationAuthManager.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
final class LocationAuthManager$requestNewLocationAuthMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ y2 $locationAuthData;
    int label;

    public LocationAuthManager$requestNewLocationAuthMessage$1(y2 r1, Continuation<? super LocationAuthManager$requestNewLocationAuthMessage$1> r2) {
        this.$locationAuthData = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new LocationAuthManager$requestNewLocationAuthMessage$1(this.$locationAuthData, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L14:
        com.larus.network.http.a r15 = (com.larus.network.http.a) r14;
        if ((r15 instanceof y) == false) goto L17;
        FLogger.a.d("LocationAuthManager", "requestNewLocationAuthMessage success");
    L19:
        return Unit.INSTANCE;
    L17:
        FLogger.a.d("LocationAuthManager", "requestNewLocationAuthMessage fail, response = " + r15.b);
        goto L19
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        int r4 = c.a;
        y2 r5 = this.$locationAuthData;
        JSONObject r6 = new JSONObject();
        r6.put("question_id", r5.a);
        r6.put("conv_id", r5.c);
        r6.put("local_message_id", r5.b);
        Unit r7 = Unit.INSTANCE;
        JSONObject r8 = r5.d;
        JSONObject r9 = new JSONObject();
        r9.put("scene", "fpa_location");
        r9.put("bot_id", "7234781073513644036");
        r9.put("ext", new JSONObject());
        if (r8 != null) goto L11;
        r8 = new JSONObject();
    L11:
        r9.put("trace_info", r8);
        JSONObject r10 = new JSONObject();
        r10.put("api_name", "");
        r10.put("params", r6.toString());
        r9.put("payload", r10.toString());
        this.label = 1;
        r14 = HttpExtKt.k("Basic", c.a.class, "https://mp.oceancloudapi.com/api/doubao/do_action_v2", r9, null, null, false, null, null, null, this, 1008);
        if (r14 != r0) goto L14;
        return r0;
    }
}
