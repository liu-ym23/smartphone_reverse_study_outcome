package com.larus.profile.impl;

import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.basic.experience.downgrade.api.IFlowDowngradeService;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.downgrade.FlowDowngradeToastConfig;
import com.larus.platform.service.z2;
import com.larus.profile.api.bean.UserCreationGroupListResponse;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "Lcom/larus/profile/api/bean/UserCreationGroupListResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.ProfileRepo$requestPrivateCreationGroupList$2", f = "ProfileRepo.kt", i = {}, l = {149}, m = "invokeSuspend", n = {}, s = {})
public final class ProfileRepo$requestPrivateCreationGroupList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.network.http.a<? extends UserCreationGroupListResponse>>, Object> {
    final /* synthetic */ String $cursor;
    final /* synthetic */ String $downgradeSource;
    final /* synthetic */ int $pageSize;
    final /* synthetic */ String $visitId;
    int label;

    public ProfileRepo$requestPrivateCreationGroupList$2(String r1, int r2, String r3, String r4, Continuation<? super ProfileRepo$requestPrivateCreationGroupList$2> r5) {
        this.$visitId = r1;
        this.$pageSize = r2;
        this.$cursor = r3;
        this.$downgradeSource = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ProfileRepo$requestPrivateCreationGroupList$2(this.$visitId, this.$pageSize, this.$cursor, this.$downgradeSource, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.network.http.a<UserCreationGroupListResponse>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L35:
        return r13;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        FlowDowngradeServiceDelegate r2 = FlowDowngradeServiceDelegate.INSTANCE;
        JSONObject r5 = new JSONObject();
        String r6 = this.$visitId;
        int r7 = this.$pageSize;
        String r8 = this.$cursor;
        if (com.larus.utils.o0.d(r6) == false) goto L13;
        if (r6 != null) goto L12;
        r6 = "";
    L12:
        r5.put("visit_id", r6);
    L13:
        r5.put("page_size", r7);
        r5.put("cursor", r8);
        r5.put("private_status", 2);
        r5.put("scene", 1);
        Unit r9 = Unit.INSTANCE;
        LinkedHashMap r10 = new LinkedHashMap();
        String r11 = this.$downgradeSource;
        if (r11 == null) goto L16;
        String r12 = (String) r10.put("source", r11);
    L16:
        z2 r14 = z2.a;
        FlowDowngradeToastConfig r15 = r14.getFlowDowngradeToastConfig();
        String r16 = null;
        if (r15 == null) goto L19;
        String r17 = r15.getTrafficDegradationLoadingFailureCn();
    L20:
        if (r17 != null) goto L22;
    L25:
        boolean r18 = true;
    L26:
        if (r18 == false) goto L28;
        String r19 = AppHost.a.getApplication().getString(2131910603);
    L32:
        Intrinsics.checkNotNull(r19);
        r10.put("toast_text", r19);
        this.label = 1;
        r13 = IFlowDowngradeService.a.b(r2, "Social", UserCreationGroupListResponse.class, "/alice/profile/creation/group_list", r5, null, true, null, r10, this, 944);
        if (r13 != r0) goto L35;
        return r0;
    L28:
        FlowDowngradeToastConfig r20 = r14.getFlowDowngradeToastConfig();
        if (r20 == null) goto L31;
        r16 = r20.getTrafficDegradationLoadingFailureCn();
    L31:
        r19 = String.valueOf(r16);
        goto L32
    L22:
        if (r17.length() == 0) goto L25;
        r18 = false;
        goto L26
    L19:
        r17 = null;
        goto L20
    }
}
