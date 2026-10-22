package com.larus.agents.impl.network;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.http.request.HttpHeaders;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.HttpExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/HttpDataResult;", "T", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.agents.impl.network.WorkExperienceRemote$post$2", f = "WorkExperienceApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class WorkExperienceRemote$post$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super dm9.a<Object>>, Object> {
    final /* synthetic */ JSONObject $body;
    final /* synthetic */ String $path;
    final /* synthetic */ Class<Object> $responseClass;
    int label;

    public WorkExperienceRemote$post$2(Class<Object> r1, String r2, JSONObject r3, Continuation<? super WorkExperienceRemote$post$2> r4) {
        this.$responseClass = r1;
        this.$path = r2;
        this.$body = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new WorkExperienceRemote$post$2(this.$responseClass, this.$path, this.$body, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super dm9.a<Object>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r14);
        Triple r15 = HttpExtKt.c("Basic", this.$responseClass, this.$path, "POST", null, this.$body, MapsKt.mapOf(TuplesKt.to(HttpHeaders.HEAD_KEY_CONTENT_TYPE, "application/json")), true, null, null, null, 7680);
        BizResponse r0 = (BizResponse) r15.component1();
        dm9.a.a r1 = (dm9.a.a) r15.component2();
        Throwable r16 = (Throwable) r15.component3();
        if (r0 == null) goto L9;
        if (r16 == null) goto L9;
        return new dm9.a.a(-1000, "experience response was intercepted", r16);
    L9:
        if (r0 != null) goto L17;
        if (r1 == null) goto L14;
        return r1;
    L14:
        return new dm9.a.a(-1000, "experience response is empty", r16);
    L17:
        return new dm9.a.b(r0, null);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
