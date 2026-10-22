package com.bytedance.ai.bridge.method.system.location;

import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.permission.AppletAuthorizeHelper;
import com.bytedance.ai.applet.permission.Scope;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import java.security.SecureRandom;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.system.location.LocationAuthorization$authorizeBackgroundLocationBestEffort$1", f = "LocationAuthorization.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {})
final class LocationAuthorization$authorizeBackgroundLocationBestEffort$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appId;
    final /* synthetic */ e3.d $bridgeContext;
    final /* synthetic */ Function0<Unit> $onComplete;
    final /* synthetic */ String $permissionCheckDetail;
    final /* synthetic */ Scope $scope;
    int label;

    public LocationAuthorization$authorizeBackgroundLocationBestEffort$1(String r1, Function0<Unit> r10, e3.d r11, String r12, Scope r13, Continuation<? super LocationAuthorization$authorizeBackgroundLocationBestEffort$1> r14) {
        this.$appId = r1;
        this.$onComplete = r10;
        this.$bridgeContext = r11;
        this.$permissionCheckDetail = r12;
        this.$scope = r13;
        super(1, r14);
    }

    public final Continuation<Unit> create(Continuation<?> r10) {
        return new LocationAuthorization$authorizeBackgroundLocationBestEffort$1(this.$appId, this.$onComplete, this.$bridgeContext, this.$permissionCheckDetail, this.$scope, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r10) {
        return create(r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L19
    L17:
        Result.constructor-impl((com.bytedance.ai.applet.permission.f) r13);     // Catch: Throwable -> L19
    L21:
        this.$onComplete.invoke();
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r13);
        AppletAppManagerService r14 = AppletAppManagerService.INSTANCE;
        String r10 = this.$appId;
        r14.getClass();
        AppletApplication r15 = AppletAppManagerService.a(r10);
        if (r15 != null) goto L13;
        this.$onComplete.invoke();
        return Unit.INSTANCE;
    L13:
        int r11 = LocationAuthorization.a;
        e3.d r12 = this.$bridgeContext;
        String r16 = this.$permissionCheckDetail;
        String r17 = this.$appId;
        Scope r18 = this.$scope;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L19
        SecureRandom r20 = AppletAuthTaskMonitor.a;     // Catch: Throwable -> L19
        AppletAuthTaskMonitor.Session r21 = AppletAuthTaskMonitor.g(AppletAuthTaskMonitor.b(r12, "authorize", "jsb", "permission_check", r16, r17, r18.getValue()));     // Catch: Throwable -> L19
        AppletAuthorizeHelper r22 = r15.h().a();     // Catch: Throwable -> L19
        String r23 = r18.getValue();     // Catch: Throwable -> L19
        this.label = 1;     // Catch: Throwable -> L19
        r13 = AppletAuthorizeHelper.e(r22, r23, true, null, null, r21, this, 12);     // Catch: Throwable -> L19
        if (r13 != r0) goto L17;
        return r0;
    L19:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    }
}
