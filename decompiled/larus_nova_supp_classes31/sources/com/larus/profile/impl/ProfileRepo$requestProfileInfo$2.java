package com.larus.profile.impl;

import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.basic.experience.downgrade.api.IFlowDowngradeService;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.downgrade.FlowDowngradeToastConfig;
import com.larus.platform.service.z2;
import com.tencent.open.log.TraceLevel;
import fs9.r;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "Lcom/larus/profile/api/bean/ProfileBotListResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.ProfileRepo$requestProfileInfo$2", f = "ProfileRepo.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
final class ProfileRepo$requestProfileInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.network.http.a<? extends r>>, Object> {
    final /* synthetic */ boolean $hasCache;
    final /* synthetic */ String $index;
    final /* synthetic */ int $limit;
    final /* synthetic */ ProfileRequestSource $source;
    final /* synthetic */ String $userId;
    int label;

    public ProfileRepo$requestProfileInfo$2(ProfileRequestSource r1, boolean r2, String r3, String r4, int r5, Continuation<? super ProfileRepo$requestProfileInfo$2> r6) {
        this.$source = r1;
        this.$hasCache = r2;
        this.$userId = r3;
        this.$index = r4;
        this.$limit = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ProfileRepo$requestProfileInfo$2(this.$source, this.$hasCache, this.$userId, this.$index, this.$limit, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.network.http.a<r>> r2) {
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
        String r6 = this.$userId;
        String r7 = this.$index;
        int r8 = this.$limit;
        r5.put("visit_id", r6);
        r5.put("index", r7);
        r5.put("limit", r8);
        Unit r9 = Unit.INSTANCE;
        Pair[] r10 = new Pair[3];
        boolean r11 = false;
        r10[0] = TuplesKt.to("source", this.$source.getValue());
        if (this.$hasCache == false) goto L11;
        String r12 = "1";
    L12:
        r10[1] = TuplesKt.to("has_cache", r12);
        z2 r13 = z2.a;
        FlowDowngradeToastConfig r14 = r13.getFlowDowngradeToastConfig();
        String r16 = null;
        if (r14 == null) goto L15;
        String r17 = r14.getTrafficDegradationLoadingFailureCn();
    L16:
        if (r17 != null) goto L18;
    L19:
        r11 = true;
    L20:
        if (r11 == false) goto L22;
        String r18 = AppHost.a.getApplication().getString(2131910603);
    L26:
        r10[2] = TuplesKt.to("toast_text", r18);
        Map r19 = MapsKt.mapOf(r10);
        this.label = 1;
        r15 = IFlowDowngradeService.a.b(r2, "Social", r.class, "/alice/profile/bot_list", r5, null, false, null, r19, this, 1008);
        if (r15 != r0) goto L29;
        return r0;
    L22:
        FlowDowngradeToastConfig r110 = r13.getFlowDowngradeToastConfig();
        if (r110 == null) goto L25;
        r16 = r110.getTrafficDegradationLoadingFailureCn();
    L25:
        r18 = String.valueOf(r16);
        goto L26
    L18:
        if (r17.length() != 0) goto L20;
    L15:
        r17 = null;
        goto L16
    L11:
        r12 = "0";
        goto L12
    }
}
