package com.bytedance.ai.applet.permission;

import com.bytedance.ai.applet.granting.GrantingAction;
import com.bytedance.ai.bridge.remote.model.AppletPermissionDetail;
import com.bytedance.ai.bridge.remote.model.ScopePermissionInfo;
import com.bytedance.ai.model.AppletRuntimeManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.j;
import u2.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ai/applet/granting/GrantingAction;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.permission.AppletAuthorizeHelper$authorizeOrThrow$isSystemAlreadyGranted$1$userAction$1", f = "AppletAuthorizeHelper.kt", i = {}, l = {202}, m = "invokeSuspend", n = {}, s = {})
public final class AppletAuthorizeHelper$authorizeOrThrow$isSystemAlreadyGranted$1$userAction$1 extends SuspendLambda implements Function1<Continuation<? super GrantingAction>, Object> {
    final /* synthetic */ String $scopeName;
    final /* synthetic */ AppletPermissionDetail $targetAppletDetail;
    int label;
    final /* synthetic */ AppletAuthorizeHelper this$0;

    public AppletAuthorizeHelper$authorizeOrThrow$isSystemAlreadyGranted$1$userAction$1(AppletAuthorizeHelper r1, String r10, AppletPermissionDetail r11, Continuation<? super AppletAuthorizeHelper$authorizeOrThrow$isSystemAlreadyGranted$1$userAction$1> r12) {
        this.this$0 = r1;
        this.$scopeName = r10;
        this.$targetAppletDetail = r11;
        super(1, r12);
    }

    public final Continuation<Unit> create(Continuation<?> r10) {
        return new AppletAuthorizeHelper$authorizeOrThrow$isSystemAlreadyGranted$1$userAction$1(this.this$0, this.$scopeName, this.$targetAppletDetail, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super GrantingAction> r10) {
        return create(r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r15);
    L27:
        return r15;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        AppletAuthorizeHelper r16 = this.this$0;
        String r10 = this.$scopeName;
        AppletPermissionDetail r11 = this.$targetAppletDetail;
        this.label = 1;
        String r12 = r16.a;
        com.bytedance.ai.monitor.b.b("doubao_apps_system_auth_popup_show", new c(AppletAuthorizeHelper.i(r10), r12, r11));
        j r13 = new j(IntrinsicsKt.intercepted(this), 1);
        r13.C();
        Integer r14 = Boxing.boxInt(0);
        String r17 = r11.getIconUrl();
        String r18 = r11.getAppletName();
        if (r18 != null) goto L11;
        r18 = r16.a;
    L11:
        String r19 = r18;
        String r110 = h.a(r10);
        Map<String, ScopePermissionInfo> r20 = r11.getScopesStatus();
        if (r20 == null) goto L17;
        ScopePermissionInfo r21 = r20.get(r10);
        if (r21 == null) goto L17;
        String r22 = r21.getNeededDescription();
        if (r22 == null) goto L17;
    L18:
        i r23 = new i(r14, r17, r19, r110, r22, "允许", "拒绝");
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r24 = AppletRuntimeManager.d;
        if (r24 == null) goto L21;
        r24.F(r23, new e(r16, r10, r11, r13));
    L22:
        r15 = r13.B();
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
        DebugProbesKt.probeCoroutineSuspended(this);
    L25:
        if (r15 != r0) goto L27;
        return r0;
    L21:
        Result.Companion r111 = Result.Companion;
        r13.resumeWith(Result.constructor-impl(GrantingAction.DISMISSED));
    L17:
        r22 = h.a(r10);
        goto L18
    }
}
