package com.bytedance.ai.bridge.method.system.location;

import android.app.Activity;
import android.content.Context;
import com.byted.cast.sink.api.CastInfo;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.permission.AppletAuthorizeHelper;
import com.bytedance.ai.applet.permission.Scope;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import com.google.gson.JsonObject;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.system.location.LocationAuthorization$authorize$1", f = "LocationAuthorization.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
public final class LocationAuthorization$authorize$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appId;
    final /* synthetic */ e3.d $bridgeContext;
    final /* synthetic */ f3.h<Object> $callback;
    final /* synthetic */ Activity $context;
    final /* synthetic */ Function1<Context, Unit> $onSuccess;
    final /* synthetic */ String $permissionCheckDetail;
    final /* synthetic */ Scope $scope;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public LocationAuthorization$authorize$1(String r1, f3.h<Object> r10, e3.d r11, String r12, Scope r13, Function1<? super Context, Unit> r14, Activity r15, Continuation<? super LocationAuthorization$authorize$1> r16) {
        this.$appId = r1;
        this.$callback = r10;
        this.$bridgeContext = r11;
        this.$permissionCheckDetail = r12;
        this.$scope = r13;
        this.$onSuccess = r14;
        this.$context = r15;
        super(1, r16);
    }

    public final Continuation<Unit> create(Continuation<?> r11) {
        return new LocationAuthorization$authorize$1(this.$appId, this.$callback, this.$bridgeContext, this.$permissionCheckDetail, this.$scope, this.$onSuccess, this.$context, r11);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L15:
        com.bytedance.ai.applet.permission.f r14 = (com.bytedance.ai.applet.permission.f) r13;
        Map<String, Object> r10 = r14.c;
        f3.h<Object> r11 = this.$callback;
        Iterator<Map.Entry<String, Object>> r12 = r10.entrySet().iterator();
    L17:
        if (r12.hasNext() == false) goto L20;
        Map.Entry<String, Object> r15 = r12.next();
        r11.a(r15.getKey(), r15.getValue());
        goto L17
    L20:
        if (r14.a == false) goto L22;
        this.$onSuccess.invoke(this.$context);
    L40:
        return Unit.INSTANCE;
    L22:
        int r16 = LocationAuthorization.a;
        String r17 = r14.b;
        if (r17 != null) goto L26;
        r17 = "";
    L26:
        if (StringsKt.startsWith$default(r17, "system_permission_denied", false, 2, null) == false) goto L29;
        Integer r18 = Integer.valueOf(CastInfo.TYPE_DISCONNECT);
        f3.a.C0156a r19 = f3.a.c;
        f3.a r20 = f3.b.a;
        Intrinsics.checkNotNullParameter(r19, "<this>");
        Triple r110 = new Triple(r18, "system permission denied", f3.b.i);
    L38:
        int r21 = ((Number) r110.component1()).intValue();
        String r22 = (String) r110.component2();
        f3.a r111 = (f3.a) r110.component3();
        f3.h<Object> r23 = this.$callback;
        JsonObject r24 = new JsonObject();
        r24.addProperty("errCode", Boxing.boxInt(r21));
        r24.addProperty("errMsg", r22);
        Unit r25 = Unit.INSTANCE;
        r23.c(r22, r21, r111, r24);
        goto L40
    L29:
        if (StringsKt.startsWith$default(r17, "applet_permission_denied", false, 2, null) == false) goto L32;
        Integer r26 = Integer.valueOf(CastInfo.TYPE_PAUSED);
        f3.a.C0156a r27 = f3.a.c;
        f3.a r28 = f3.b.a;
        Intrinsics.checkNotNullParameter(r27, "<this>");
        r110 = new Triple(r26, "user permission denied", f3.b.i);
        goto L38
    L32:
        if (StringsKt.startsWith$default(r17, "applet_permission_cancelled", false, 2, null) == false) goto L35;
        r110 = new Triple(Integer.valueOf(CastInfo.TYPE_PAUSED), "user permission denied", f3.a.o);
        goto L38
    L35:
        if (StringsKt.startsWith$default(r17, "network_failure", false, 2, null) == false) goto L37;
        String r112 = StringsKt.substringAfter(r17, ':', "internal error");
        f3.a.C0156a r29 = f3.a.c;
        f3.a r30 = f3.b.a;
        Intrinsics.checkNotNullParameter(r29, "<this>");
        r110 = new Triple(0, r112, f3.b.j);
        goto L38
    L37:
        r110 = new Triple(0, "internal error", f3.a.f);
        goto L38
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        AppletAppManagerService r113 = AppletAppManagerService.INSTANCE;
        String r31 = this.$appId;
        r113.getClass();
        AppletApplication r114 = AppletAppManagerService.a(r31);
        if (r114 != null) goto L12;
        f3.h.a.a(this.$callback, "app " + this.$appId + " not found", f3.a.f, null, 10);
        return Unit.INSTANCE;
    L12:
        SecureRandom r32 = AppletAuthTaskMonitor.a;
        AppletAuthTaskMonitor.Session r33 = AppletAuthTaskMonitor.g(AppletAuthTaskMonitor.b(this.$bridgeContext, "authorize", "jsb", "permission_check", this.$permissionCheckDetail, this.$appId, this.$scope.getValue()));
        AppletAuthorizeHelper r34 = r114.h().a();
        String r35 = this.$scope.getValue();
        this.label = 1;
        r13 = AppletAuthorizeHelper.e(r34, r35, true, null, null, r33, this, 12);
        if (r13 != r0) goto L15;
        return r0;
    }
}
