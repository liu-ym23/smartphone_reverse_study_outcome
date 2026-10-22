package com.larus.bmhome.instruction.core.impl.repo;

import com.larus.bmhome.actionbar.model.x0;
import com.larus.im.internal.delegate.c0;
import com.larus.im.internal.delegate.j0;
import gd9.e;
import gd9.t;
import java.util.LinkedHashMap;
import java.util.Map;
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
import kotlinx.coroutines.CoroutineScope;
import wp8.b;
import xt7.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/actionbar/model/CustomActionBarConfResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.instruction.core.impl.repo.ActionBarConfRepo$requestActionBarConfV3$2", f = "ActionBarConfRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ActionBarConfRepo$requestActionBarConfV3$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super x0>, Object> {
    final /* synthetic */ Map<String, String> $customHeaders;
    final /* synthetic */ b $requestBody;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ a this$0;

    public ActionBarConfRepo$requestActionBarConfV3$2(a r1, b r2, Map<String, String> r3, Continuation<? super ActionBarConfRepo$requestActionBarConfV3$2> r4) {
        this.this$0 = r1;
        this.$requestBody = r2;
        this.$customHeaders = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        ActionBarConfRepo$requestActionBarConfV3$2 r0 = new ActionBarConfRepo$requestActionBarConfV3$2(this.this$0, this.$requestBody, this.$customHeaders, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super x0> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L32;
        ResultKt.throwOnFailure(r8);
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        j0 r0 = this.this$0.a;
        b r10 = this.$requestBody;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        Object r11 = Result.constructor-impl(d.b.a(b.Companion.serializer(), r10));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r11) == false) goto L12;
        r11 = null;
    L12:
        String r12 = (String) r11;
        if (r12 != null) goto L15;
        r12 = "";
    L15:
        String r2 = r12;
        LinkedHashMap r3 = new LinkedHashMap();
        Map<String, String> r13 = this.$customHeaders;
        r3.putAll(MapsKt.mapOf(TuplesKt.to("Content-Type", "application/json; charset=utf-8")));
        if (r13 == null) goto L18;
        r3.putAll(r13);
    L18:
        e r14 = t.a.a(r0, "/alice/bot/action_bar_v3/list", r2, r3, null, 16);
        if (r14.c() == true) goto L22;
        c0.b.w("ActionBarConfRepo", "requestActionBarConfV3 HTTP failed");
        return null;
    L22:
        String r15 = r14.d;
        if (r15 != null) goto L25;
        return null;
    L25:
        a.C0017a r16 = (a.C0017a) d.b.c(a.C0017a.Companion.serializer(), r15);
        if (r16.a == 0) goto L28;
        c0.b.w("ActionBarConfRepo", "requestActionBarConfV3 biz error, code=" + r16.a + ", msg=" + r16.b);
        throw new ActionBarBusinessException(r16.a, r16.b);
    L28:
        return r16.c;
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L32:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
