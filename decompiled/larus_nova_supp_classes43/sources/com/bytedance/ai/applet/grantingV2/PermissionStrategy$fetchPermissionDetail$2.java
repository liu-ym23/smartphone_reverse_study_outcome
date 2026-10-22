package com.bytedance.ai.applet.grantingV2;

import com.bytedance.ai.applet.granting.GrantStatus;
import com.bytedance.ai.bridge.remote.UserAuthService;
import com.bytedance.ai.bridge.remote.model.AppletPermissionDetail;
import com.bytedance.ai.bridge.remote.model.ScopePermissionInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ai/applet/granting/GrantStatus;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.grantingV2.PermissionStrategy$fetchPermissionDetail$2", f = "PermissionStrategy.kt", i = {}, l = {337}, m = "invokeSuspend", n = {}, s = {})
public final class PermissionStrategy$fetchPermissionDetail$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super GrantStatus>, Object> {
    final /* synthetic */ String $appletId;
    final /* synthetic */ String $scopeName;
    int label;

    public PermissionStrategy$fetchPermissionDetail$2(String r1, String r10, Continuation<? super PermissionStrategy$fetchPermissionDetail$2> r11) {
        this.$appletId = r1;
        this.$scopeName = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new PermissionStrategy$fetchPermissionDetail$2(this.$appletId, this.$scopeName, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super GrantStatus> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
        Object r11 = ((Result) r10).unbox-impl();
    L11:
        Object r12 = null;
        if (Result.isFailure-impl(r11) == false) goto L14;
        Object r13 = null;
    L15:
        List r14 = (List) r13;
        if (r14 != null) goto L21;
        Throwable r15 = Result.exceptionOrNull-impl(r11);
        if (r15 == null) goto L20;
        throw r15;
    L20:
        throw new Exception("Permission detail is null");
    L21:
        String r16 = this.$appletId;
        Iterator r17 = r14.iterator();
    L23:
        if (r17.hasNext() == false) goto L27;
        Object r18 = r17.next();
        if (Intrinsics.areEqual(((AppletPermissionDetail) r18).getAppletId(), r16) == false) goto L23;
        r12 = r18;
    L27:
        AppletPermissionDetail r19 = (AppletPermissionDetail) r12;
        if (r19 == null) goto L38;
        Map<String, ScopePermissionInfo> r20 = r19.getScopesStatus();
        if (r20 == null) goto L36;
        ScopePermissionInfo r21 = r20.get(this.$scopeName);
        if (r21 == null) goto L36;
        GrantStatus.a r22 = GrantStatus.Companion;
        Integer r23 = r21.getGrantStatus();
        r22.getClass();
        return GrantStatus.a.a(r23);
    L36:
        throw new Exception("Cannot find info for " + this.$scopeName);
    L38:
        throw new Exception("Cannot find info for " + this.$appletId);
    L14:
        r13 = r11;
        goto L15
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        UserAuthService r24 = UserAuthService.a;
        List r25 = CollectionsKt.listOf(this.$appletId);
        List r26 = CollectionsKt.listOf(this.$scopeName);
        this.label = 1;
        r11 = UserAuthService.p(r25, r26, this);
        if (r11 != r0) goto L11;
        return r0;
    }
}
