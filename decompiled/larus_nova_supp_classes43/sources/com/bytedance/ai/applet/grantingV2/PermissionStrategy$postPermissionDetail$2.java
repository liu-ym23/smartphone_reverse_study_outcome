package com.bytedance.ai.applet.grantingV2;

import com.bytedance.ai.applet.granting.GrantStatus;
import com.bytedance.ai.bridge.remote.UserAuthService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.grantingV2.PermissionStrategy$postPermissionDetail$2", f = "PermissionStrategy.kt", i = {}, l = {362}, m = "invokeSuspend", n = {}, s = {})
public final class PermissionStrategy$postPermissionDetail$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $appletId;
    final /* synthetic */ GrantStatus $grantStatus;
    final /* synthetic */ String $scopeName;
    int label;

    public PermissionStrategy$postPermissionDetail$2(String r1, String r10, GrantStatus r11, Continuation<? super PermissionStrategy$postPermissionDetail$2> r12) {
        this.$appletId = r1;
        this.$scopeName = r10;
        this.$grantStatus = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new PermissionStrategy$postPermissionDetail$2(this.$appletId, this.$scopeName, this.$grantStatus, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
        Object r11 = ((Result) r10).unbox-impl();
    L12:
        if (Result.isFailure-impl(r11) == false) goto L14;
        Object r12 = null;
    L15:
        Boolean r13 = (Boolean) r12;
        if (r13 == null) goto L19;
        boolean r14 = r13.booleanValue();
        com.bytedance.ai.utils.g.a.i("PermissionStrategyV2", "postPermissionDetail: " + r14);
        return Boxing.boxBoolean(r14);
    L19:
        Throwable r15 = Result.exceptionOrNull-impl(r11);
        if (r15 == null) goto L22;
        throw r15;
    L22:
        throw new Exception("Permission detail is null");
    L14:
        r12 = r11;
        goto L15
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        UserAuthService r16 = UserAuthService.a;
        String r17 = this.$appletId;
        String r18 = this.$scopeName;
        Integer r19 = Boxing.boxInt(u2.g.a(this.$grantStatus));
        this.label = 1;
        r11 = UserAuthService.r(r17, r18, r19, this);
        if (r11 != r0) goto L12;
        return r0;
    }
}
