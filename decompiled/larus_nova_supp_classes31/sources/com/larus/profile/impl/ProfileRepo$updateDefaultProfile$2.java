package com.larus.profile.impl;

import com.larus.account.base.api.ILoginService;
import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.basic.experience.downgrade.api.IFlowDowngradeService;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
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
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "Lcom/larus/profile/api/bean/UpdateProfileResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.ProfileRepo$updateDefaultProfile$2", f = "ProfileRepo.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, s = {})
public final class ProfileRepo$updateDefaultProfile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.network.http.a<? extends fs9.y>>, Object> {
    int label;

    public ProfileRepo$updateDefaultProfile$2(Continuation<? super ProfileRepo$updateDefaultProfile$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new ProfileRepo$updateDefaultProfile$2(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.network.http.a<fs9.y>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L12:
        return (com.larus.network.http.a) r13;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        FlowDowngradeServiceDelegate r2 = FlowDowngradeServiceDelegate.INSTANCE;
        JSONObject r5 = new JSONObject();
        r5.put("entity_id", ILoginService.a.getAccountInfo().c);
        r5.put("nickname", "");
        r5.put("user_name", "");
        r5.put("avatar_url", "");
        r5.put("is_register", true);
        Unit r6 = Unit.INSTANCE;
        Map r9 = MapsKt.mapOf(TuplesKt.to("source", "update_default_profile"));
        this.label = 1;
        r13 = IFlowDowngradeService.a.b(r2, "Social", fs9.y.class, "/alice/profile/update_profile", r5, null, true, null, r9, this, 944);
        if (r13 != r0) goto L12;
        return r0;
    }
}
