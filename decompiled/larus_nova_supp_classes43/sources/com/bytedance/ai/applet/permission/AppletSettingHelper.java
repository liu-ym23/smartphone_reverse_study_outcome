package com.bytedance.ai.applet.permission;

import android.content.Context;
import com.bytedance.ai.applet.app.foundation.w;
import com.bytedance.ai.applet.granting.GrantStatus;
import com.bytedance.ai.bridge.remote.model.AppletPermissionDetail;
import com.bytedance.ai.bridge.remote.model.ScopePermissionInfo;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AppletSettingHelper implements w {
    public static final /* synthetic */ int b = 0;
    public final String a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void d() {
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void onDestroy() {
    }

    public AppletSettingHelper(String r10) {
        Intrinsics.checkNotNullParameter(r10, "appletId");
        this.a = r10;
    }

    public static Map b(AppletPermissionDetail r10) {
        LinkedHashMap r0 = new LinkedHashMap();
        Map<String, ScopePermissionInfo> r11 = r10.getScopesStatus();
        if (r11 != null) goto L5;
        r11 = MapsKt.emptyMap();
    L5:
        Iterator<Map.Entry<String, ScopePermissionInfo>> r12 = r11.entrySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L31;
        Map.Entry<String, ScopePermissionInfo> r1 = r12.next();
        String r13 = r1.getKey();
        ScopePermissionInfo r14 = r1.getValue();
        Boolean r15 = null;
        if (r14 == null) goto L11;
        Integer r16 = r14.getGrantStatus();
    L12:
        int r17 = GrantStatus.GRANTED.getValue();
        if (r16 != null) goto L16;
    L18:
        int r18 = GrantStatus.DENIED.getValue();
        if (r16 != null) goto L22;
    L23:
        int r19 = GrantStatus.REVOKED.getValue();
        if (r16 != null) goto L27;
    L29:
        if (r15 == null) goto L7;
        r0.put(r13, Boolean.valueOf(r15.booleanValue()));
        goto L7
    L27:
        if (r16.intValue() != r19) goto L29;
    L28:
        r15 = Boolean.FALSE;
        goto L29
    L22:
        if (r16.intValue() == r18) goto L28;
    L16:
        if (r16.intValue() != r17) goto L18;
        r15 = Boolean.TRUE;
        goto L29
    L11:
        r16 = null;
        goto L12
    L31:
        return r0;
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void a(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void g(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void h(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
    }

    public final Object c(AppletAuthTaskMonitor.Session r23, Continuation<? super g> r24) {
        if ((r24 instanceof AppletSettingHelper$getSetting$1) == false) goto L7;
        AppletSettingHelper$getSetting$1 r10 = (AppletSettingHelper$getSetting$1) r24;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r0 = r10.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r10.label;
        String r14 = null;
        if (r13 == 0) goto L18;
        if (r13 != 1) goto L17;
        AppletAuthTaskMonitor.Session r15 = (AppletAuthTaskMonitor.Session) r10.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L14
    L32:
        int r16 = g.c;     // Catch: Exception -> L14
        Map r1 = b((AppletPermissionDetail) r0);     // Catch: Exception -> L14
        Intrinsics.checkNotNullParameter(r1, "authSetting");     // Catch: Exception -> L14
        g r17 = new g(null, r1);     // Catch: Exception -> L14
        r15.d(new AppletAuthTaskMonitor.a("success", null, null, null, null, null, null, null, 510));     // Catch: Exception -> L14
        return r17;
    L14:
        e = e;
        AppletAuthTaskMonitor.Session r18 = r15;
    L37:
        if ((e instanceof CronetIOException) == false) goto L40;
        Integer r19 = Integer.valueOf(((CronetIOException) e).getStatusCode());
    L43:
        if (r19 != null) goto L45;
    L47:
        String r20 = e.getMessage();
        if (r20 != null) goto L50;
    L55:
        String r21 = "unknown error";
    L56:
        com.bytedance.ai.utils.g.a.e("AppletSettingHelper", "Failed to get setting for applet '" + this.a + "', reason: " + r21, e);
        r18.d(new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, null, "permission_status_check", AppletAuthTaskMonitor.ErrorCode.API_FAILED, r21, null, null, null, 482));
        int r22 = g.c;
        Intrinsics.checkNotNullParameter(r21, "reason");
        return new g(r21, MapsKt.emptyMap());
    L50:
        if ((!StringsKt.isBlank(r20)) == false) goto L52;
        r14 = r20;
    L52:
        if (r14 == null) goto L55;
        r21 = r14;
        goto L56
    L45:
        if (r19.intValue() <= 0) goto L47;
        r21 = "server response code（" + r19 + "） is not 2xx";
        goto L56
    L40:
        if ((e instanceof HttpResponseException) == false) goto L42;
        r19 = Integer.valueOf(((HttpResponseException) e).getStatusCode());
        goto L43
    L42:
        r19 = null;
        goto L43
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r0);
        if (this.a.length() != 0) goto L21;
        boolean r25 = true;
    L22:
        if (r25 == false) goto L25;
        int r26 = g.c;
        Intrinsics.checkNotNullParameter("appletId is null or empty", "reason");
        return new g("appletId is null or empty", MapsKt.emptyMap());
    L25:
        if (r23 != null) goto L27;
        SecureRandom r27 = AppletAuthTaskMonitor.a;
        r18 = AppletAuthTaskMonitor.g(new AppletAuthTaskMonitor.b("authorize", "native_api", "permission_check", "AppletAuthorizeManager.getSetting.call", this.a, "native_container", null, null, null, null, null, null, 4032));
    L58:
        AppletSettingHelper$getSetting$detail$1 r28 = new AppletSettingHelper$getSetting$detail$1(this, null);     // Catch: Exception -> L35
        r10.L$0 = r18;     // Catch: Exception -> L35
        r10.label = 1;     // Catch: Exception -> L35
        r0 = r18.f(r28, r10);     // Catch: Exception -> L35
        if (r0 != r12) goto L31;
        return r12;
    L31:
        r15 = r18;
    L35:
        e = e;
        goto L37
    L27:
        r18 = r23;
        goto L58
    L21:
        r25 = false;
    L7:
        r10 = new AppletSettingHelper$getSetting$1(this, r24);
        goto L8
    }
}
