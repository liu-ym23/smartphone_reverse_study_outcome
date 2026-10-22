package com.larus.profile.impl;

import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.basic.experience.downgrade.api.IFlowDowngradeService;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.downgrade.FlowDowngradeToastConfig;
import com.larus.platform.service.z2;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "Lcom/larus/profile/api/bean/ProfileOverviewResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.ProfileRepo$requireProfileOverview$2", f = "ProfileRepo.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
public final class ProfileRepo$requireProfileOverview$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.network.http.a<? extends fs9.u>>, Object> {
    final /* synthetic */ boolean $hasCache;
    final /* synthetic */ ProfileRequestSource $source;
    final /* synthetic */ String $userId;
    int label;

    public ProfileRepo$requireProfileOverview$2(ProfileRequestSource r1, boolean r2, String r3, Continuation<? super ProfileRepo$requireProfileOverview$2> r4) {
        this.$source = r1;
        this.$hasCache = r2;
        this.$userId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ProfileRepo$requireProfileOverview$2(this.$source, this.$hasCache, this.$userId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.network.http.a<fs9.u>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r15);
    L29:
        return r15;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        FlowDowngradeServiceDelegate r2 = FlowDowngradeServiceDelegate.INSTANCE;
        JSONObject r5 = new JSONObject();
        r5.put("visit_id", this.$userId);
        Unit r6 = Unit.INSTANCE;
        Pair[] r9 = new Pair[3];
        boolean r11 = false;
        r9[0] = TuplesKt.to("source", this.$source.getValue());
        if (this.$hasCache == false) goto L11;
        String r10 = "1";
    L12:
        r9[1] = TuplesKt.to("has_cache", r10);
        z2 r12 = z2.a;
        FlowDowngradeToastConfig r13 = r12.getFlowDowngradeToastConfig();
        String r14 = null;
        if (r13 == null) goto L15;
        String r16 = r13.getTrafficDegradationLoadingFailureCn();
    L16:
        if (r16 != null) goto L18;
    L19:
        r11 = true;
    L20:
        if (r11 == false) goto L22;
        String r17 = AppHost.a.getApplication().getString(2131910603);
    L26:
        r9[2] = TuplesKt.to("toast_text", r17);
        Map r18 = MapsKt.mapOf(r9);
        this.label = 1;
        r15 = IFlowDowngradeService.a.b(r2, "Social", fs9.u.class, "/alice/profile/overview", r5, null, false, null, r18, this, 1008);
        if (r15 != r0) goto L29;
        return r0;
    L22:
        FlowDowngradeToastConfig r19 = r12.getFlowDowngradeToastConfig();
        if (r19 == null) goto L25;
        r14 = r19.getTrafficDegradationLoadingFailureCn();
    L25:
        r17 = String.valueOf(r14);
        goto L26
    L18:
        if (r16.length() != 0) goto L20;
    L15:
        r16 = null;
        goto L16
    L11:
        r10 = "0";
        goto L12
    }
}
