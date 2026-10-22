package com.larus.profile.impl;

import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.basic.experience.downgrade.api.IFlowDowngradeService;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.downgrade.FlowDowngradeToastConfig;
import com.larus.platform.service.z2;
import com.tencent.open.log.TraceLevel;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "Lcom/larus/profile/api/bean/UserCreationListResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.ProfileRepo$requestUserCreationList$2", f = "ProfileRepo.kt", i = {}, l = {114}, m = "invokeSuspend", n = {}, s = {})
public final class ProfileRepo$requestUserCreationList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.network.http.a<? extends fs9.b0>>, Object> {
    final /* synthetic */ fs9.x $request;
    int label;

    public ProfileRepo$requestUserCreationList$2(fs9.x r1, Continuation<? super ProfileRepo$requestUserCreationList$2> r2) {
        this.$request = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ProfileRepo$requestUserCreationList$2(this.$request, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.network.http.a<fs9.b0>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L46:
        return r13;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        FlowDowngradeServiceDelegate r2 = FlowDowngradeServiceDelegate.INSTANCE;
        JSONObject r5 = new JSONObject();
        fs9.x r6 = this.$request;
        String r8 = "";
        if (com.larus.utils.o0.d(r6.b) == false) goto L15;
        String r7 = r6.b;
        if (r7 != null) goto L13;
        r7 = "";
    L13:
        r5.put("visit_id", r7);
    L15:
        if (com.larus.utils.o0.d(r6.f) == false) goto L21;
        String r9 = r6.f;
        if (r9 == null) goto L20;
        r8 = r9;
    L20:
        r5.put("visit_lark_id", r8);
    L21:
        r5.put("page_size", r6.a);
        r5.put("cursor", r6.c);
        r5.put("from", r6.g);
        Integer r10 = r6.d;
        if (r10 == null) goto L24;
        r5.put("private_status", r10);
    L24:
        Unit r11 = Unit.INSTANCE;
        LinkedHashMap r12 = new LinkedHashMap();
        String r14 = this.$request.e;
        if (r14 == null) goto L27;
        String r15 = (String) r12.put("source", r14);
    L27:
        z2 r16 = z2.a;
        FlowDowngradeToastConfig r17 = r16.getFlowDowngradeToastConfig();
        String r18 = null;
        if (r17 == null) goto L30;
        String r19 = r17.getTrafficDegradationLoadingFailureCn();
    L31:
        if (r19 != null) goto L33;
    L36:
        boolean r110 = true;
    L37:
        if (r110 == false) goto L39;
        String r20 = AppHost.a.getApplication().getString(2131910603);
    L43:
        Intrinsics.checkNotNull(r20);
        r12.put("toast_text", r20);
        this.label = 1;
        r13 = IFlowDowngradeService.a.b(r2, "Social", fs9.b0.class, "/alice/profile/creation/list", r5, null, true, null, r12, this, 944);
        if (r13 != r0) goto L46;
        return r0;
    L39:
        FlowDowngradeToastConfig r21 = r16.getFlowDowngradeToastConfig();
        if (r21 == null) goto L42;
        r18 = r21.getTrafficDegradationLoadingFailureCn();
    L42:
        r20 = String.valueOf(r18);
        goto L43
    L33:
        if (r19.length() == 0) goto L36;
        r110 = false;
        goto L37
    L30:
        r19 = null;
        goto L31
    }
}
