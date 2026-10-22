package com.bytedance.ai.bridge.method.system.location;

import android.content.Context;
import com.byted.cast.sink.api.CastInfo;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.permission.AppletAuthorizeHelper;
import com.bytedance.ai.applet.permission.Scope;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.model.objects.PermissionDetail;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import com.google.gson.JsonObject;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.system.location.GetLocationMethod$authorize$1", f = "GetLocationMethod.kt", i = {}, l = {CastInfo.TYPE_PAUSED}, m = "invokeSuspend", n = {}, s = {})
final class GetLocationMethod$authorize$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appId;
    final /* synthetic */ e3.d $bridgeContext;
    final /* synthetic */ f3.h<AbsGetLocationMethodIDL.b> $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ AbsGetLocationMethodIDL.a $params;
    int label;
    final /* synthetic */ GetLocationMethod this$0;

    public GetLocationMethod$authorize$1(String r1, f3.h<AbsGetLocationMethodIDL.b> r10, e3.d r11, GetLocationMethod r12, Context r13, AbsGetLocationMethodIDL.a r14, Continuation<? super GetLocationMethod$authorize$1> r15) {
        this.$appId = r1;
        this.$callback = r10;
        this.$bridgeContext = r11;
        this.this$0 = r12;
        this.$context = r13;
        this.$params = r14;
        super(2, r15);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new GetLocationMethod$authorize$1(this.$appId, this.$callback, this.$bridgeContext, this.this$0, this.$context, this.$params, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r24) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r24);
        Object r1 = r24;
    L19:
        com.bytedance.ai.applet.permission.f r11 = (com.bytedance.ai.applet.permission.f) r1;
        com.bytedance.ai.utils.g.a.i("AISDK_JSB_GetLocationMethod", "authorize result: appId=" + this.$appId + ", success=" + r11.a + ", reason=" + r11.b);
        Map<String, Object> r12 = r11.c;
        f3.h<AbsGetLocationMethodIDL.b> r13 = this.$callback;
        Iterator<Map.Entry<String, Object>> r14 = r12.entrySet().iterator();
    L21:
        if (r14.hasNext() == false) goto L23;
        Map.Entry<String, Object> r15 = r14.next();
        r13.a(r15.getKey(), r15.getValue());
        goto L21
    L23:
        boolean r16 = false;
        if (r11.a == false) goto L32;
        GetLocationMethod r17 = this.this$0;
        Context r18 = this.$context;
        AbsGetLocationMethodIDL.a r19 = this.$params;
        f3.h<AbsGetLocationMethodIDL.b> r20 = this.$callback;
        int r21 = GetLocationMethod.c;
        r17.getClass();
        r4.k r110 = r4.a.k;
        if (r110 != null) goto L28;
        com.bytedance.ai.utils.g r22 = com.bytedance.ai.utils.g.a;
        StringBuilder r23 = new StringBuilder("call failed, errNo=");
        f3.a r25 = f3.a.f;
        r23.append(r25.a);
        r23.append(", msg=HostSystemActionDepend is null");
        r22.e("AISDK_JSB_GetLocationMethod", r23.toString());
        f3.h.a.a(r20, "HostSystemActionDepend is null", r25, null, 10);
    L47:
        return Unit.INSTANCE;
    L28:
        Integer r111 = r19.getMode();
        Long r112 = r19.getTimeoutMs();
        String r113 = r19.getSource();
        Long r114 = r19.getMaxCacheTimeMs();
        Boolean r26 = r19.getAcceptLightLocation();
        if (r26 == null) goto L31;
        r16 = r26.booleanValue();
    L31:
        r110.d(r18, r111, r112, r113, r114, new c(r20), Boolean.valueOf(r16), r19.getExtra());
        goto L47
    L32:
        GetLocationMethod r27 = this.this$0;
        String r28 = r11.b;
        int r29 = GetLocationMethod.c;
        r27.getClass();
        if (r28 != null) goto L36;
        r28 = "";
    L36:
        if (StringsKt.startsWith$default(r28, "system_permission_denied", false, 2, null) == false) goto L39;
        Triple r30 = new Triple(Integer.valueOf(CastInfo.TYPE_DISCONNECT), "system permission denied", f3.a.j);
    L45:
        int r31 = ((Number) r30.component1()).intValue();
        String r32 = (String) r30.component2();
        f3.a r33 = (f3.a) r30.component3();
        com.bytedance.ai.utils.g.a.e("AISDK_JSB_GetLocationMethod", "call failed, errNo=" + r33.a + ", msg=" + r32);
        f3.h<AbsGetLocationMethodIDL.b> r34 = this.$callback;
        JsonObject r35 = new JsonObject();
        r35.addProperty("errCode", Boxing.boxInt(r31));
        r35.addProperty("errMsg", r32);
        Unit r36 = Unit.INSTANCE;
        r34.c(r32, r31, r33, r35);
        goto L47
    L39:
        if (StringsKt.startsWith$default(r28, "applet_permission_denied", false, 2, null) == false) goto L41;
    L44:
        r30 = new Triple(Integer.valueOf(CastInfo.TYPE_PAUSED), "user permission denied", f3.a.k);
        goto L45
    L41:
        if (StringsKt.startsWith$default(r28, "applet_permission_cancelled", false, 2, null) == true) goto L44;
        r30 = new Triple(0, "internal error", f3.a.f);
        goto L45
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r24);
        AppletAppManagerService r37 = AppletAppManagerService.INSTANCE;
        String r38 = this.$appId;
        r37.getClass();
        AppletApplication r39 = AppletAppManagerService.a(r38);
        if (r39 != null) goto L12;
        com.bytedance.ai.utils.g r40 = com.bytedance.ai.utils.g.a;
        StringBuilder r41 = new StringBuilder("call failed, errNo=");
        f3.a r42 = f3.a.q;
        r41.append(r42.a);
        r41.append(", msg=app ");
        r41.append(this.$appId);
        r41.append(" not found");
        r40.e("AISDK_JSB_GetLocationMethod", r41.toString());
        f3.h.a.a(this.$callback, "app " + this.$appId + " not found", r42, null, 10);
        return Unit.INSTANCE;
    L12:
        com.bytedance.ai.utils.g r43 = com.bytedance.ai.utils.g.a;
        StringBuilder r44 = new StringBuilder("authorize before call: appId=");
        r44.append(this.$appId);
        r44.append(", manifestAppletId=");
        r44.append(r39.j().K);
        r44.append(", appType=");
        r44.append(r39.j().F);
        r44.append(", permKeys=");
        Map<String, PermissionDetail> r45 = r39.j().W;
        if (r45 == null) goto L15;
        Set<String> r46 = r45.keySet();
    L16:
        r44.append(r46);
        r43.i("AISDK_JSB_GetLocationMethod", r44.toString());
        SecureRandom r47 = AppletAuthTaskMonitor.a;
        e3.d r115 = this.$bridgeContext;
        String r48 = this.$appId;
        Scope r49 = Scope.userLocation;
        AppletAuthTaskMonitor.Session r50 = AppletAuthTaskMonitor.g(AppletAuthTaskMonitor.b(r115, "authorize", "jsb", "permission_check", "doubao.getLocation.permission_check.call", r48, r49.getValue()));
        AppletAuthorizeHelper r51 = r39.h().a();
        String r52 = r49.getValue();
        this.label = 1;
        r1 = AppletAuthorizeHelper.e(r51, r52, true, null, null, r50, this, 12);
        if (r1 != r10) goto L19;
        return r10;
    L15:
        r46 = null;
        goto L16
    }
}
