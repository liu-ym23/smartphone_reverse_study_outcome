package com.bytedance.ai.applet.douyinAuth;

import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.granting.GrantingAction;
import com.bytedance.ai.applet.grantingV2.McpGrantingManager;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.remote.model.AppMeta;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import com.bytedance.ai.utils.g;
import com.bytedance.ai.utils.l;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;
import p4.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class DouyinGeneralAuthHelper {
    public static final DouyinGeneralAuthHelper a = null;

    public static final class a implements Function2<Boolean, String, Unit> {
        public final /* synthetic */ i<e> a;

        public a(j r1) {
            this.a = r1;
        }

        public final Object invoke(Object r10, Object r11) {
            boolean r12 = ((Boolean) r10).booleanValue();
            String r13 = (String) r11;
            if (this.a.isActive() == false) goto L10;
            i<e> r0 = this.a;
            Result.Companion r1 = Result.Companion;
            if (r13 == null) goto L8;
            r12 = false;
        L8:
            r0.resumeWith(Result.constructor-impl(new e(r12, r13)));
        L10:
            return Unit.INSTANCE;
        }
    }

    public static final class b implements Function2<GrantingAction, String, Unit> {
        public final /* synthetic */ i<d> a;

        public b(j r1) {
            this.a = r1;
        }

        public final Object invoke(Object r10, Object r11) {
            GrantingAction r12 = (GrantingAction) r10;
            String r13 = (String) r11;
            Intrinsics.checkNotNullParameter(r12, "userAction");
            if (this.a.isActive() == false) goto L6;
            i<d> r0 = this.a;
            Result.Companion r1 = Result.Companion;
            r0.resumeWith(Result.constructor-impl(new d(r12, r13)));
        L6:
            return Unit.INSTANCE;
        }
    }

    static {
        a = new DouyinGeneralAuthHelper();
    }

    public DouyinGeneralAuthHelper() {
    }

    public final Object b(String r22, Continuation<? super c> r23) {
        String r1 = r22;
        if ((r23 instanceof DouyinGeneralAuthHelper$fetchDouyinGeneralAuthPrepareResult$1) == false) goto L7;
        DouyinGeneralAuthHelper$fetchDouyinGeneralAuthPrepareResult$1 r10 = (DouyinGeneralAuthHelper$fetchDouyinGeneralAuthPrepareResult$1) r23;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r0 = r10.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r10.label;
        boolean r14 = true;
        String r15 = null;
        if (r13 == 0) goto L19;
        if (r13 != 1) goto L18;
        int r16 = r10.I$0;
        String r17 = (String) r10.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L14 TimeoutCancellationException -> L16
        int r18 = r16;
        r1 = r17;
    L122:
        Result r19 = (Result) r0;     // Catch: Exception -> L26 TimeoutCancellationException -> L119
    L32:
        if (r19 == null) goto L37;
        Object r20 = r19.unbox-impl();
        if (Result.isFailure-impl(r20) == false) goto L36;
        r20 = null;
    L36:
        n r21 = (n) r20;
    L38:
        if (r18 == 0) goto L40;
        AppletAuthTaskMonitor.a r24 = new AppletAuthTaskMonitor.a("timeout", "applet.requestDouyinGeneralAuth.callback", "aweme_auth_prepare", AppletAuthTaskMonitor.ErrorCode.TIMEOUT, "getAwemeCommonLoginInfo timeout", null, null, null, 480);
    L101:
        if (r21 == null) goto L112;
        String r25 = r21.f();
        if (r25 == null) goto L112;
        String r26 = StringsKt.trim(r25).toString();
        if (r26 == null) goto L112;
        if (r26.length() > 0) goto L110;
        r14 = false;
    L110:
        if (r14 == false) goto L112;
        r15 = r26;
    L112:
        if (r15 != null) goto L114;
        if (r18 != 0) goto L118;
        g.a.w("DouyinGeneralAuthHelper", "fetchDouyinGeneralAuthSubtitle no valid server subtitle, use fallback, appId=" + r1);
    L118:
        return new c("授权豆包获取你抖音账号下收藏的歌曲、本地生活服务、生活缴费及抖音支付等信息，用以向你提供更便捷的服务。", r24);
    L114:
        return new c(r15, r24);
    L40:
        if (r19 != null) goto L42;
    L44:
        boolean r27 = false;
    L45:
        if (r27 == false) goto L51;
        AppletAuthTaskMonitor.ErrorCode r110 = AppletAuthTaskMonitor.ErrorCode.API_FAILED;
        Throwable r28 = Result.exceptionOrNull-impl(r19.unbox-impl());
        if (r28 == null) goto L49;
        String r111 = r28.getMessage();
    L50:
        r24 = new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, "applet.requestDouyinGeneralAuth.callback", "aweme_auth_prepare", r110, r111, null, null, null, 480);
        goto L101
    L49:
        r111 = null;
        goto L50
    L51:
        if (r21 == null) goto L87;
        String r29 = r21.e();
        if (r29 == null) goto L87;
        a.getClass();
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L57
        Object r31 = Result.constructor-impl(com.bytedance.ai.applet.login.a.a(r29));     // Catch: Throwable -> L57
    L60:
        if (Result.isFailure-impl(r31) == false) goto L62;
        r31 = null;
    L62:
        com.bytedance.ai.applet.login.c r32 = (com.bytedance.ai.applet.login.c) r31;
        if (r32 == null) goto L65;
        String r33 = r32.d;
    L66:
        if (r33 != null) goto L68;
    L71:
        boolean r34 = true;
    L72:
        if (r34 == true) goto L84;
        if (r32 == null) goto L75;
        String r35 = r32.f;
    L76:
        if (r35 != null) goto L78;
    L81:
        boolean r36 = true;
    L82:
        if (r36 == true) goto L84;
        boolean r37 = true;
    L85:
        if (r37 == true) goto L87;
        boolean r38 = true;
    L88:
        if (r38 == false) goto L90;
        r24 = new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, "applet.requestDouyinGeneralAuth.callback", "aweme_auth_prepare", AppletAuthTaskMonitor.ErrorCode.AUTH_LINK_INVALID, "invalid aweme authLink", null, null, null, 480);
        goto L101
    L90:
        if (r21 == null) goto L100;
        String r39 = r21.e();
        if (r39 != null) goto L94;
    L97:
        boolean r40 = true;
    L98:
        if (r40 == false) goto L100;
        r24 = new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, "applet.requestDouyinGeneralAuth.callback", "aweme_auth_prepare", AppletAuthTaskMonitor.ErrorCode.AUTH_LINK_INVALID, "invalid aweme authLink", null, null, null, 480);
        goto L101
    L94:
        if (StringsKt.isBlank(r39) == true) goto L97;
        r40 = false;
    L100:
        r24 = null;
        goto L101
    L78:
        if (StringsKt.isBlank(r35) == true) goto L81;
        r36 = false;
        goto L82
    L75:
        r35 = null;
    L84:
        r37 = false;
        goto L85
    L68:
        if (StringsKt.isBlank(r33) == true) goto L71;
        r34 = false;
        goto L72
    L65:
        r33 = null;
    L57:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        r31 = Result.constructor-impl(ResultKt.createFailure(th));
    L87:
        r38 = false;
        goto L88
    L42:
        if (Result.isFailure-impl(r19.unbox-impl()) != true) goto L44;
        r27 = true;
        goto L45
    L37:
        r21 = null;
        goto L38
    L31:
        g.a.w("DouyinGeneralAuthHelper", "fetchDouyinGeneralAuthSubtitle timeout after 1000ms, use fallback, appId=" + r1);
        r19 = null;
        r18 = 1;
    L26:
        e = e;
    L30:
        g.a.w("DouyinGeneralAuthHelper", "fetchDouyinGeneralAuthSubtitle failed, use fallback, appId=" + r1, e);
        Result.Companion r42 = Result.Companion;
        r19 = Result.box-impl(Result.constructor-impl(ResultKt.createFailure(e)));
        goto L32
    L14:
        e = e;
        r18 = r16;
        r1 = r17;
    L16:
        r1 = r17;
        goto L31
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.throwOnFailure(r0);
        DouyinGeneralAuthHelper$fetchDouyinGeneralAuthPrepareResult$result$1 r43 = new DouyinGeneralAuthHelper$fetchDouyinGeneralAuthPrepareResult$result$1(r1, null);     // Catch: Exception -> L28 TimeoutCancellationException -> L119
        r10.L$0 = r1;     // Catch: Exception -> L28 TimeoutCancellationException -> L119
        r10.I$0 = 0;     // Catch: Exception -> L28 TimeoutCancellationException -> L119
        r10.label = 1;     // Catch: Exception -> L28 TimeoutCancellationException -> L119
        r0 = TimeoutKt.b(1000, r43, r10);     // Catch: Exception -> L28 TimeoutCancellationException -> L119
        if (r0 != r12) goto L23;
        return r12;
    L23:
        r18 = 0;
    L28:
        e = e;
        r18 = 0;
    L7:
        r10 = new DouyinGeneralAuthHelper$fetchDouyinGeneralAuthPrepareResult$1(this, r23);
        goto L8
    }

    public static Object a(String r10, String r11, String r12, Continuation r13) {
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r0 = AppletRuntimeManager.d;
        if (r0 == null) goto L5;
        g.a.i("DouyinGeneralAuthHelper", "checkAppletFirstPartyAuthStatus authSource=".concat(r12));
        j r14 = new j(IntrinsicsKt.intercepted(r13), 1);
        r14.C();
        r0.n(r10, r11, new a(r14));
        Object r15 = r14.B();
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r13);
    L9:
        return r15;
    L5:
        return new e(false, "aiAbility is null");
    }

    public final Object c(u2.c r25, u2.d r26, com.bytedance.ai.applet.login.c r27, AppletAuthTaskMonitor.Session r28, Continuation<? super Unit> r29) {
        u2.c r0 = r25;
        AppletAuthTaskMonitor.Session r10 = r28;
        if ((r29 instanceof DouyinGeneralAuthHelper$handleFirstPartyLoginAgree$1) == false) goto L7;
        Continuation<? super d> r11 = (DouyinGeneralAuthHelper$handleFirstPartyLoginAgree$1) r29;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Continuation<? super d> r13 = r11;
        Object r14 = r13.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r13.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        String r1 = (String) r13.L$2;
        AppletAuthTaskMonitor.Session r17 = (AppletAuthTaskMonitor.Session) r13.L$1;
        u2.c r18 = (u2.c) r13.L$0;
        ResultKt.throwOnFailure(r14);
        String r19 = r1;
        r10 = r17;
        r0 = r18;
    L53:
        d r20 = (d) r14;
        g.a.i("DouyinGeneralAuthHelper", "requestAppletFirstPartyAuth callback msgID=" + r19 + ", userAction=" + r20.a + ", errorMsg=" + r20.b);
        String r21 = r20.b;
        if (r21 == null) goto L57;
        if (r10 == null) goto L57;
        r10.d(new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, "AIMcpGrantingManager.reportAuthTraceResultIfNeeded", "aweme_auth_request", AppletAuthTaskMonitor.ErrorCode.API_FAILED, r21, null, null, null, 480));
    L57:
        McpGrantingManager r22 = McpGrantingManager.a;
        GrantingAction r23 = r20.a;
        r22.getClass();
        McpGrantingManager.i(r0, r23);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        if (r27 != null) goto L21;
        g.a.e("DouyinGeneralAuthHelper", "handleFirstPartyLoginAgree: authLinkData is null.");
        if (r10 == null) goto L19;
        r10.d(new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, "AIMcpGrantingManager.reportAuthTraceResultIfNeeded", "aweme_auth_prepare", AppletAuthTaskMonitor.ErrorCode.AUTH_LINK_INVALID, "authLinkData is null", null, null, null, 480));
    L19:
        McpGrantingManager r24 = McpGrantingManager.a;
        GrantingAction r30 = GrantingAction.DISMISSED;
        r24.getClass();
        McpGrantingManager.i(r0, r30);
        return Unit.INSTANCE;
    L21:
        String r31 = r27.d;
        String r32 = r27.f;
        boolean r33 = false;
        if (r31 != null) goto L24;
    L27:
        boolean r34 = true;
    L28:
        if (r34 == true) goto L59;
        if (r32 != null) goto L31;
    L32:
        r33 = true;
    L33:
        if (r33 == true) goto L59;
        u2.b r35 = r0.f;
        r19 = r35.a;
        HashMap<String, Object> r36 = r35.g;
        HashMap r37 = new HashMap();
        if (r36 == null) goto L38;
        r37.putAll(r36);
    L38:
        r37.put("current_page", "chat");
        r37.put("source", "doubao_apps_auth_request");
        r37.put("app_key", r0.a);
        r37.put("app_name", r0.b);
        String r38 = r0.b;
        l r39 = l.a;
        String r40 = l.e(r39, "larus_appEntry_dyAuth_popup_title_cn");
        if (r40 != null) goto L41;
        r40 = "需绑定抖音账号";
    L41:
        String r110 = r40;
        String r41 = r26.d();
        if (r41 != null) goto L44;
        r41 = "";
    L44:
        String r210 = r41;
        String r42 = l.e(r39, "larus_appEntry_dyAuth_popup_btn_confirm_cn");
        if (r42 != null) goto L47;
        r42 = "立即绑定抖音";
    L47:
        String r211 = r42;
        String r43 = l.e(r39, "larus_appEntry_dyAuth_popup_btn_cancel_cn");
        if (r43 != null) goto L50;
        r43 = "以后再说";
    L50:
        u2.i r44 = new u2.i(null, null, r38, r110, r210, r211, r43);
        r13.L$0 = r0;
        r13.L$1 = r10;
        r13.L$2 = r19;
        r13.label = 1;
        r14 = d(r31, r32, r37, r44, "chat", null, r28, r13);
        if (r14 != r15) goto L53;
        return r15;
    L31:
        if (StringsKt.isBlank(r32) == false) goto L33;
    L59:
        g.a.e("DouyinGeneralAuthHelper", "handleFirstPartyLoginAgree: authLink format error");
        if (r10 == null) goto L62;
        r10.d(new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, "AIMcpGrantingManager.reportAuthTraceResultIfNeeded", "aweme_auth_prepare", AppletAuthTaskMonitor.ErrorCode.AUTH_LINK_INVALID, "authLink format error", null, null, null, 480));
    L62:
        McpGrantingManager r45 = McpGrantingManager.a;
        GrantingAction r46 = GrantingAction.DISMISSED;
        r45.getClass();
        McpGrantingManager.i(r0, r46);
        return Unit.INSTANCE;
    L24:
        if (StringsKt.isBlank(r31) == true) goto L27;
        r34 = false;
    L7:
        r11 = new DouyinGeneralAuthHelper$handleFirstPartyLoginAgree$1(this, r29);
        goto L8
    }

    public final Object e(AppletApplication r23, String r24, String r25, ContainerType r26, AppletAuthTaskMonitor.Session r27, Continuation<? super d> r28) {
        if ((r28 instanceof DouyinGeneralAuthHelper$requestDouyinGeneralAuth$1) == false) goto L7;
        DouyinGeneralAuthHelper$requestDouyinGeneralAuth$1 r10 = (DouyinGeneralAuthHelper$requestDouyinGeneralAuth$1) r28;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        DouyinGeneralAuthHelper$requestDouyinGeneralAuth$1 r12 = r10;
        Object r1 = r12.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r12.label;
        if (r14 == 0) goto L20;
        if (r14 == 1) goto L19;
        if (r14 == 2) goto L18;
        if (r14 == 3) goto L17;
        if (r14 != 4) goto L16;
        ResultKt.throwOnFailure(r1);
    L61:
        return r1;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        HashMap r0 = (HashMap) r12.L$5;
        String r15 = (String) r12.L$4;
        AppletAuthTaskMonitor.Session r16 = (AppletAuthTaskMonitor.Session) r12.L$3;
        ContainerType r17 = (ContainerType) r12.L$2;
        String r18 = (String) r12.L$1;
        String r19 = (String) r12.L$0;
        ResultKt.throwOnFailure(r1);
    L44:
        c r20 = (c) r1;
        HashMap r21 = r0;
        String r110 = r15;
        String r22 = r19;
        String r29 = r18;
        ContainerType r30 = r17;
        String r31 = r29;
    L45:
        AppletAuthTaskMonitor.a r32 = r20.b;
        if (r32 == null) goto L49;
        if (r16 == null) goto L49;
        r16.d(r32);
    L49:
        l r33 = l.a;
        String r111 = l.e(r33, "larus_appEntry_dyAuth_popup_title_cn");
        if (r111 != null) goto L52;
        r111 = "需绑定抖音账号";
    L52:
        String r112 = r111;
        String r34 = r20.a;
        String r113 = l.e(r33, "larus_appEntry_dyAuth_popup_btn_confirm_cn");
        if (r113 != null) goto L55;
        r113 = "立即绑定抖音";
    L55:
        String r114 = r113;
        String r35 = l.e(r33, "larus_appEntry_dyAuth_popup_btn_cancel_cn");
        if (r35 != null) goto L58;
        r35 = "以后再说";
    L58:
        u2.i r115 = new u2.i(null, null, r110, r112, r34, r114, r35);
        String r36 = com.bytedance.ai.applet.douyinAuth.a.a(r22);
        r12.L$0 = null;
        r12.L$1 = null;
        r12.L$2 = null;
        r12.L$3 = null;
        r12.L$4 = null;
        r12.L$5 = null;
        r12.L$6 = null;
        r12.label = 4;
        r1 = d("aw730v27vx2bu2qw", r36, r21, r115, r31, r30, r16, r12);
        if (r1 != r13) goto L61;
        return r13;
    L18:
        r0 = (HashMap) r12.L$6;
        r15 = (String) r12.L$5;
        AppletAuthTaskMonitor.Session r37 = (AppletAuthTaskMonitor.Session) r12.L$4;
        r30 = (ContainerType) r12.L$3;
        String r116 = (String) r12.L$2;
        String r117 = (String) r12.L$1;
        AppletApplication r118 = (AppletApplication) r12.L$0;
        ResultKt.throwOnFailure(r1);
    L35:
        r20 = (c) r1;
        if (r20 == null) goto L40;
        r21 = r0;
        r110 = r15;
        r16 = r37;
        r31 = r116;
        r22 = r117;
    L40:
        String r38 = r118.getAppId();
        r12.L$0 = r117;
        r12.L$1 = r116;
        r12.L$2 = r30;
        r12.L$3 = r37;
        r12.L$4 = r15;
        r12.L$5 = r0;
        r12.L$6 = null;
        r12.label = 3;
        r1 = b(r38, r12);
        if (r1 != r13) goto L43;
        return r13;
    L43:
        r16 = r37;
        r17 = r30;
        r18 = r116;
        r19 = r117;
        goto L44
    L19:
        AppletAuthTaskMonitor.Session r39 = (AppletAuthTaskMonitor.Session) r12.L$4;
        ContainerType r40 = (ContainerType) r12.L$3;
        r116 = (String) r12.L$2;
        r117 = (String) r12.L$1;
        r118 = (AppletApplication) r12.L$0;
        ResultKt.throwOnFailure(r1);
    L24:
        AppMeta r41 = (AppMeta) r1;
        if (r41 == null) goto L28;
        String r42 = r41.getAppName();
        if (r42 == null) goto L28;
    L29:
        HashMap r43 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("app_key", r118.getAppId()), TuplesKt.to("app_name", r42)});
        if (r39 == null) goto L39;
        DouyinGeneralAuthHelper$requestDouyinGeneralAuth$prepareResult$1 r44 = new DouyinGeneralAuthHelper$requestDouyinGeneralAuth$prepareResult$1(r118, null);
        r12.L$0 = r118;
        r12.L$1 = r117;
        r12.L$2 = r116;
        r12.L$3 = r40;
        r12.L$4 = r39;
        r12.L$5 = r42;
        r12.L$6 = r43;
        r12.label = 2;
        Object r45 = r39.f(r44, r12);
        if (r45 != r13) goto L34;
        return r13;
    L34:
        r30 = r40;
        r15 = r42;
        r1 = r45;
        r37 = r39;
        r0 = r43;
        goto L35
    L39:
        r37 = r39;
        r30 = r40;
        r0 = r43;
        r15 = r42;
    L28:
        r42 = r118.j().a;
        goto L29
    L20:
        ResultKt.throwOnFailure(r1);
        r12.L$0 = r23;
        r12.L$1 = r24;
        r12.L$2 = r25;
        r12.L$3 = r26;
        r12.L$4 = r27;
        r12.label = 1;
        Object r119 = r23.k(r12);
        if (r119 != r13) goto L23;
        return r13;
    L23:
        r118 = r23;
        r39 = r27;
        r117 = r24;
        r1 = r119;
        r116 = r25;
        r40 = r26;
    L7:
        r10 = new DouyinGeneralAuthHelper$requestDouyinGeneralAuth$1(this, r28);
        goto L8
    }

    public final Object d(String r17, String r18, Map<String, ? extends Object> r19, u2.i r20, String r21, ContainerType r22, AppletAuthTaskMonitor.Session r23, Continuation<? super d> r24) {
        if ((r24 instanceof DouyinGeneralAuthHelper$requestAppletFirstPartyAuth$1) == false) goto L7;
        DouyinGeneralAuthHelper$requestAppletFirstPartyAuth$1 r10 = (DouyinGeneralAuthHelper$requestAppletFirstPartyAuth$1) r24;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.label;
        if (r14 == 0) goto L18;
        if (r14 != 1) goto L17;
        g2.b r0 = (g2.b) r10.L$5;
        AppletAuthTaskMonitor.Session r1 = (AppletAuthTaskMonitor.Session) r10.L$4;
        u2.i r15 = (u2.i) r10.L$3;
        Map r16 = (Map) r10.L$2;
        String r25 = (String) r10.L$1;
        String r26 = (String) r10.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L14
    L41:
        d r27 = (d) r12;     // Catch: Throwable -> L14
        if (r1 == null) goto L44;
        r1.c();
    L44:
        return r27;
    L14:
        th = th;
    L47:
        if (r1 == null) goto L49;
        r1.c();
    L49:
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r12);
        g.a.d("DouyinGeneralAuthHelper", "requestAppletFirstPartyAuth: authSource: " + r21 + ", containerType: " + r22);
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r28 = AppletRuntimeManager.d;
        if (r28 != null) goto L23;
        return new d(GrantingAction.DISMISSED, "aiAbility is null");
    L23:
        if (Intrinsics.areEqual(r21, com.bytedance.android.ec.core.event.a.VALUE_DETAIL_TAB) == true) goto L25;
    L27:
        boolean r29 = false;
    L28:
        if (r23 == null) goto L50;
        r23.b();
    L50:
        r10.L$0 = r17;     // Catch: Throwable -> L45
        r10.L$1 = r18;     // Catch: Throwable -> L45
        r10.L$2 = r19;     // Catch: Throwable -> L45
        r10.L$3 = r20;     // Catch: Throwable -> L45
        r10.L$4 = r23;     // Catch: Throwable -> L45
        r10.L$5 = r28;     // Catch: Throwable -> L45
        r10.Z$0 = r29;     // Catch: Throwable -> L45
        r10.label = 1;     // Catch: Throwable -> L45
        j r110 = new j(IntrinsicsKt.intercepted(r10), 1);     // Catch: Throwable -> L45
        r110.C();     // Catch: Throwable -> L45
        if (r29 == false) goto L34;
        boolean r111 = true;
    L35:
        r28.Q(r17, r18, r111, r19, r20, new b(r110));     // Catch: Throwable -> L45
        r12 = r110.B();     // Catch: Throwable -> L45
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L38;
        DebugProbesKt.probeCoroutineSuspended(r10);     // Catch: Throwable -> L45
    L38:
        if (r12 != r13) goto L40;
        return r13;
    L40:
        r1 = r23;
        goto L41
    L34:
        r111 = false;
    L45:
        th = th;
        r1 = r23;
        goto L47
    L25:
        if (r22 != ContainerType.PAGE) goto L27;
        r29 = true;
    L7:
        r10 = new DouyinGeneralAuthHelper$requestAppletFirstPartyAuth$1(this, r24);
        goto L8
    }
}
