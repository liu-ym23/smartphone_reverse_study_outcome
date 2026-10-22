package com.bytedance.ai.applet.login;

import android.app.Activity;
import android.net.Uri;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ai.applet.granting.GrantingAction;
import com.bytedance.ai.applet.grantingV2.McpGrantingManager;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.login.AbsLoginWithDoubaoWidgetMethodIDL;
import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.ai.debug.IAISDKDebugService$DebugMode;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.WidgetInfo;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import com.bytedance.mt.protector.impl.UriProtector;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class LoginProcessor {
    public static final LoginProcessor a = null;
    public static WeakReference<f> b;
    public static final Map<String, j> c = null;
    public static String d;
    public static final CoroutineScope e = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ai/applet/login/LoginProcessor$RouteType;", "", "anniexHost", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getAnniexHost", "()Ljava/lang/String;", "WEB", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum RouteType extends Enum<RouteType> {
        public static final RouteType WEB = null;
        public static final /* synthetic */ RouteType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String anniexHost;

        public static EnumEntries<RouteType> getEntries() {
            return b;
        }

        static {
            RouteType r0 = new RouteType();
            WEB = r0;
            RouteType[] r1 = {r0};
            a = r1;
            b = EnumEntriesKt.enumEntries(r1);
        }

        public RouteType() {
            super("WEB", 0);
            this.anniexHost = "sslocal://webview";
        }

        public static RouteType[] values() {
            return (RouteType[]) a.clone();
        }

        public final String getAnniexHost() {
            return this.anniexHost;
        }

        public static RouteType valueOf(String r1) {
            return (RouteType) r27.a.a(RouteType.class, r1);
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[GrantingAction.values().length];
            r0[GrantingAction.DISMISSED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L32:
            r0[GrantingAction.REJECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L42:
            r0[GrantingAction.AGREED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L8:
            a = r0;
            int[] r1 = new int[LocalFinishReason.values().length];
            r1[LocalFinishReason.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L34:
            r1[LocalFinishReason.USER_DISMISS_DIALOG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L44:
            r1[LocalFinishReason.USER_REJECTED_PRIVACY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L28:
            r1[LocalFinishReason.USER_REJECTED_LOGIN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L36:
            r1[LocalFinishReason.USER_REJECTED_COMBINED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L30:
            r1[LocalFinishReason.BIZ_FAILED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L38:
            r1[LocalFinishReason.TIMEOUT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
        L16:
            b = r1;
        }
    }

    public LoginProcessor() {
    }

    static {
        a = new LoginProcessor();
        b = new WeakReference(null);
        c = new LinkedHashMap();
        e = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    public static String c(String r10) {
        boolean r0 = true;
        if (r10 != null) goto L5;
    L8:
        boolean r11 = true;
    L9:
        if (r11 == false) goto L12;
        return "";
    L12:
        RouteType r12 = RouteType.WEB;
        Intrinsics.checkNotNullParameter(r12, "type");
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        String r13 = r12.getAnniexHost();
        if (r13.length() == 0) goto L16;
        r0 = false;
    L16:
        if (r0 == false) goto L18;
        String r1 = null;
    L19:
        if (r1 == null) goto L22;
        r10 = r1;
    L22:
        com.bytedance.ai.utils.g.a.i("LoginProcessor", "buildAnniexUrl: " + r10);
        return r10;
    L18:
        Uri.Builder r14 = UriProtector.parse(r13).buildUpon();
        r14.appendQueryParameter(com.bytedance.android.ec.core.event.a.KEY_URL, r10);
        r1 = r14.build().toString();
        goto L19
    L5:
        if (r10.length() == 0) goto L8;
        r11 = false;
        goto L9
    }

    public static j h(String r10) {
        Intrinsics.checkNotNullParameter(r10, "appletId");
        j r0 = (j) ((LinkedHashMap) c).get(r10);
        if (r0 != null) goto L5;
        com.bytedance.ai.utils.g.a.w("LoginProcessor", "getLoginContext failed for applet: " + r10);
    L5:
        return r0;
    }

    public static String k(AppletAuthTaskMonitor.Session r1) {
        if (r1 == null) goto L6;
        AppletAuthTaskMonitor.b r10 = r1.a;
        if (r10 == null) goto L6;
        String r11 = r10.b;
    L8:
        if (Intrinsics.areEqual(r11, "mcp") == false) goto L10;
        return "AIMcpGrantingManager.reportAuthTraceResultIfNeeded";
    L10:
        return "AppletPageLoginManager.finishLoginTask";
    L6:
        r11 = null;
        goto L8
    }

    public static void l(String r30, h r31) {
        Map<String, j> r10 = c;
        LinkedHashMap r11 = (LinkedHashMap) r10;
        j r12 = (j) r11.get(r30);
        if (r12 != null) goto L6;
        com.bytedance.ai.utils.g.a.e("LoginProcessor", "transitionTo: Can not find loginContext: " + r30);
        return;
    L6:
        Intrinsics.checkNotNullParameter(r31, "<set-?>");
        r12.e = r31;
        com.bytedance.ai.utils.g r13 = com.bytedance.ai.utils.g.a;
        r13.i("LoginProcessor", "Applet [" + r30 + "] transitioned to " + r31);
        if ((r31 instanceof h.d) == false) goto L10;
        g(r30, "mcp-agree-card", r12);
        return;
    L10:
        if ((r31 instanceof h.b) == false) goto L13;
        g(r30, "mcp-login-card", r12);
        return;
    L13:
        if ((r31 instanceof h.e) == false) goto L18;
        AppletAuthTaskMonitor.Session r0 = r12.h;
        if (r0 == null) goto L99;
        r0.b();
        return;
    L99:
        return;
    L18:
        if ((r31 instanceof h.a) == false) goto L101;
        LocalFinishReason r1 = ((h.a) r31).a;
        r13.i("LoginProcessor", "finishLoginProcessing reason: " + r1.getDescription());
        j r14 = (j) r11.get(r30);
        if (r14 != null) goto L22;
        r13.e("LoginProcessor", "finishLoginProcessing: LoginContext not found for " + r30);
        return;
    L22:
        u2.c r15 = r14.a;
        int[] r16 = a.b;
        if (r16[r1.ordinal()] != 1) goto L25;
        String r17 = "1";
    L27:
        if (r14.g == null) goto L29;
        String r18 = "doubao_apps_detail";
    L31:
        if (r14.d == false) goto L33;
        String r19 = "phone";
    L34:
        com.bytedance.ai.monitor.b.b("doubao_apps_login_result", new n(r18, r19, r17, r15));
        String r20 = k(r14.h);
        AppletAuthTaskMonitor.a r21 = r14.i;
        if (r21 == null) goto L37;
    L46:
        AppletAuthTaskMonitor.Session r110 = r14.h;
        if (r110 != null) goto L49;
    L52:
        f3.h<AbsLoginWithDoubaoWidgetMethodIDL.b> r22 = r14.g;
        if (r22 == null) goto L58;
        r13.d("LoginProcessor", "Invoking JSB callback for " + r30);
        if (r1 != LocalFinishReason.SUCCESS) goto L57;
        Intrinsics.checkNotNullParameter(AbsLoginWithDoubaoWidgetMethodIDL.b.class, "<this>");
        BaseModel r111 = k3.c.a(AbsLoginWithDoubaoWidgetMethodIDL.b.class);
        ((AbsLoginWithDoubaoWidgetMethodIDL.b) r111).setResult(true);
        r22.b((ResultModel) r111, "");
        goto L58
    L57:
        f3.h.a.a(r22, "Login failed or was cancelled. Reason: " + r1.getDescription(), null, null, 14);
    L58:
        u2.c r23 = r14.a;
        r23.f.getClass();
        f r24 = b.get();
        if (r24 == null) goto L61;
        Activity r25 = r24.f;
    L63:
        if ((r25 instanceof LifecycleOwner) == false) goto L65;
        LifecycleOwner r26 = (LifecycleOwner) r25;
    L66:
        if (r26 == null) goto L71;
        LifecycleCoroutineScope r112 = LifecycleOwnerKt.getLifecycleScope(r26);
        if (r112 == null) goto L71;
        BuildersKt.launch$default(r112, Dispatchers.getMain(), null, new LoginProcessor$finishLoginProcessing$2(null), 2, null);
    L71:
        switch(r16[r1.ordinal()]) {
            case 1: goto L88;
            case 2: goto L87;
            case 3: goto L90;
            case 4: goto L90;
            case 5: goto L90;
            case 6: goto L75;
            case 7: goto L74;
            default: goto L73;
        };
    L74:
        r13.d("LoginProcessor", "finishLoginProcessing: timeout");
        goto L90
    L75:
        if (r24 == null) goto L77;
        Activity r27 = r24.f;
    L79:
        if ((r27 instanceof LifecycleOwner) == false) goto L81;
        LifecycleOwner r28 = (LifecycleOwner) r27;
    L82:
        if (r28 == null) goto L86;
        LifecycleCoroutineScope r29 = LifecycleOwnerKt.getLifecycleScope(r28);
        if (r29 == null) goto L86;
        BuildersKt.launch$default(r29, Dispatchers.getMain(), null, new LoginProcessor$finishLoginProcessing$3(null), 2, null);
    L86:
        McpGrantingManager r32 = McpGrantingManager.a;
        GrantingAction r33 = GrantingAction.DISMISSED;
        r32.getClass();
        McpGrantingManager.i(r23, r33);
        goto L90
    L81:
        r28 = null;
        goto L82
    L77:
        r27 = null;
        goto L79
    L87:
        McpGrantingManager r34 = McpGrantingManager.a;
        GrantingAction r35 = GrantingAction.DISMISSED;
        r34.getClass();
        McpGrantingManager.i(r23, r35);
        goto L90
    L88:
        McpGrantingManager r36 = McpGrantingManager.a;
        GrantingAction r37 = GrantingAction.AGREED;
        r36.getClass();
        McpGrantingManager.i(r23, r37);
        goto L90
    L73:
        throw new NoWhenBranchMatchedException();
    L90:
        if (Intrinsics.areEqual(d, r30) == false) goto L92;
        d = null;
    L92:
        r10.remove(r30);
        CustomLoginNavigator r38 = CustomLoginNavigator.a;
        Intrinsics.checkNotNullParameter(r30, "appletId");
        if (CustomLoginNavigator.b.remove(r30) != null) goto L95;
        r13.w("CustomLoginNavigator", "clearLaunchContext: launch context not found for appletId=" + r30);
    L95:
        CustomLoginNavigator.c(r30);
        return;
    L65:
        r26 = null;
        goto L66
    L61:
        r25 = null;
        goto L63
    L49:
        if (r21.b != null) goto L51;
        r21 = AppletAuthTaskMonitor.a.a(r21, r20);
    L51:
        r110.d(r21);
        goto L52
    L37:
        switch(r16[r1.ordinal()]) {
            case 1: goto L45;
            case 2: goto L44;
            case 3: goto L43;
            case 4: goto L42;
            case 5: goto L42;
            case 6: goto L41;
            case 7: goto L40;
            default: goto L39;
        };
    L40:
        r21 = new AppletAuthTaskMonitor.a("timeout", null, "applet_auth_timeout", AppletAuthTaskMonitor.ErrorCode.TIMEOUT, null, null, null, null, 498);
        goto L46
    L41:
        r21 = new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, null, "exchange_code", AppletAuthTaskMonitor.ErrorCode.API_FAILED, null, null, null, null, 498);
        goto L46
    L42:
        r21 = new AppletAuthTaskMonitor.a("user_refused", null, "user_decision", AppletAuthTaskMonitor.ErrorCode.USER_REFUSED, null, null, null, null, 498);
        goto L46
    L43:
        r21 = new AppletAuthTaskMonitor.a("user_refused", null, "privacy_commit", AppletAuthTaskMonitor.ErrorCode.USER_REFUSED, null, null, null, null, 498);
        goto L46
    L44:
        r21 = new AppletAuthTaskMonitor.a("user_cancelled", null, "user_decision", AppletAuthTaskMonitor.ErrorCode.USER_CANCELLED, null, null, null, null, 498);
        goto L46
    L45:
        r21 = new AppletAuthTaskMonitor.a("success", null, null, null, null, null, null, null, 510);
        goto L46
    L39:
        throw new NoWhenBranchMatchedException();
    L33:
        r19 = "other";
        goto L34
    L29:
        r18 = "chat";
        goto L31
    L25:
        r17 = "0";
        goto L27
    }

    public static final Object a(LoginProcessor r10, String r11, Continuation r12) {
        r10.getClass();
        if ((r12 instanceof LoginProcessor$checkPrivacy$1) == false) goto L7;
        LoginProcessor$checkPrivacy$1 r0 = (LoginProcessor$checkPrivacy$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r0.label;
        if (r15 == 0) goto L22;
        if (r15 == 1) goto L17;
        if (r15 != 2) goto L16;
        String r16 = (String) r0.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L20
    L41:
        boolean r17 = ((Boolean) r13).booleanValue();     // Catch: Exception -> L20
    L45:
        return Boxing.boxBoolean(r17);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        String r18 = (String) r0.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L20
    L37:
        r17 = ((Boolean) r13).booleanValue();     // Catch: Exception -> L20
        goto L45
    L22:
        ResultKt.throwOnFailure(r13);
        Map<String, j> r19 = c;
        j r20 = (j) ((LinkedHashMap) r19).get(r11);
        if (r20 == null) goto L28;
        u2.c r21 = r20.a;
        if (r21 == null) goto L28;
        String r22 = r21.d;
        if (r22 == null) goto L28;
    L29:
        LoginProcessor$checkPrivacy$request$1 r23 = new LoginProcessor$checkPrivacy$request$1(r11, r22, null);
        j r24 = (j) ((LinkedHashMap) r19).get(r11);     // Catch: Exception -> L20
        if (r24 == null) goto L38;
        AppletAuthTaskMonitor.Session r25 = r24.h;     // Catch: Exception -> L20
        if (r25 == null) goto L38;
        LoginProcessor$checkPrivacy$2 r26 = new LoginProcessor$checkPrivacy$2(r23, null);     // Catch: Exception -> L20
        r0.L$0 = r11;     // Catch: Exception -> L20
        r0.label = 1;     // Catch: Exception -> L20
        r13 = r25.f(r26, r0);     // Catch: Exception -> L20
        if (r13 != r14) goto L37;
        return r14;
    L38:
        r0.L$0 = r11;     // Catch: Exception -> L20
        r0.label = 2;     // Catch: Exception -> L20
        r13 = r23.invoke(r0);     // Catch: Exception -> L20
        if (r13 != r14) goto L41;
        return r14;
    L28:
        r22 = "null";
    L20:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("LoginProcessor", "checkPrivacy failed for appletId: " + r11 + ", " + e.getMessage());
        r17 = false;
    L7:
        r0 = new LoginProcessor$checkPrivacy$1(r10, r12);
        goto L8
    }

    public static final Object b(LoginProcessor r22, String r23, Continuation r24) {
        r22.getClass();
        if ((r24 instanceof LoginProcessor$routeToLoginEntry$1) == false) goto L7;
        LoginProcessor$routeToLoginEntry$1 r10 = (LoginProcessor$routeToLoginEntry$1) r24;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        LoginProcessor$routeToLoginEntry$1 r12 = r10;
        Object r1 = r12.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r12.label;
        String r15 = null;
        if (r14 == 0) goto L20;
        if (r14 == 1) goto L19;
        if (r14 != 2) goto L18;
        j r16 = (j) r12.L$1;
        String r17 = (String) r12.L$0;
        ResultKt.throwOnFailure(r1);     // Catch: Throwable -> L15
        Object r0 = ((Result) r1).unbox-impl();     // Catch: Throwable -> L15
    L43:
        Object r18 = Result.constructor-impl(Result.box-impl(r0));     // Catch: Throwable -> L15
    L48:
        Throwable r19 = Result.exceptionOrNull-impl(r18);
        if (r19 == null) goto L52;
        com.bytedance.ai.utils.g.a.e("LoginProcessor", "routeToLoginEntry: custom login navigation threw for " + r17, r19);
        r18 = Result.box-impl(Result.constructor-impl(ResultKt.createFailure(r19)));
    L52:
        Object r20 = ((Result) r18).unbox-impl();
        if (Result.isFailure-impl(r20) == false) goto L59;
        com.bytedance.ai.utils.g.a.e("LoginProcessor", "routeToLoginEntry: custom login navigation failed for " + r17, Result.exceptionOrNull-impl(r20));
        String r110 = MessageIndication.STATUS_FAILED;
        String r111 = null;
        String r112 = "open_login_page";
        AppletAuthTaskMonitor.ErrorCode r113 = AppletAuthTaskMonitor.ErrorCode.ROUTE_FAILED;
        Throwable r21 = Result.exceptionOrNull-impl(r20);
        if (r21 == null) goto L57;
        r15 = r21.getMessage();
    L57:
        r16.i = new AppletAuthTaskMonitor.a(r110, r111, r112, r113, r15, null, null, null, 482);
        l(r17, new h.a(LocalFinishReason.BIZ_FAILED));
    L59:
        return Unit.INSTANCE;
    L15:
        th = th;
        j r114 = r16;
        String r25 = r17;
    L47:
        Result.Companion r26 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        r17 = r25;
        r16 = r114;
        goto L48
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        j r27 = (j) r12.L$1;
        String r28 = (String) r12.L$0;
        ResultKt.throwOnFailure(r1);
        r114 = r27;
        r25 = r28;
    L60:
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L46
        CustomLoginNavigator r30 = CustomLoginNavigator.a;     // Catch: Throwable -> L46
        String r31 = r114.f;     // Catch: Throwable -> L46
        u2.b r32 = r114.a.f;     // Catch: Throwable -> L46
        String r33 = r32.a;     // Catch: Throwable -> L46
        String r34 = r32.d;     // Catch: Throwable -> L46
        String r35 = r32.e;     // Catch: Throwable -> L46
        r12.L$0 = r25;     // Catch: Throwable -> L46
        r12.L$1 = r114;     // Catch: Throwable -> L46
        r12.label = 2;     // Catch: Throwable -> L46
        r0 = r30.a(r25, r31, r33, r34, r35, r12);     // Catch: Throwable -> L46
        if (r0 == r13) goto L67;
        r17 = r25;
        r16 = r114;
        goto L43
    L67:
        return r13;
    L46:
        th = th;
        goto L47
    L20:
        ResultKt.throwOnFailure(r1);
        j r36 = (j) ((LinkedHashMap) c).get(r23);
        if (r36 != null) goto L26;
        com.bytedance.ai.utils.g.a.e("LoginProcessor", "routeToLoginEntry: Can not find loginContext of " + r23);
        if (Intrinsics.areEqual(d, r23) == false) goto L64;
        d = null;
    L64:
        return Unit.INSTANCE;
    L26:
        CustomLoginNavigator r37 = CustomLoginNavigator.a;
        String r38 = r36.b.c();
        if (r38 != null) goto L29;
    L32:
        boolean r39 = true;
    L33:
        if (r39 == true) goto L35;
        com.bytedance.ai.utils.g.a.i("LoginProcessor", "routeToLoginEntry: phone mask valid, show login dialog for " + r23);
        l(r23, h.b.a);
        return Unit.INSTANCE;
    L35:
        com.bytedance.ai.utils.g.a.i("LoginProcessor", "routeToLoginEntry: phone mask invalid, navigate to custom login page for " + r23);
        l(r23, h.e.a);
        r12.L$0 = r23;
        r12.L$1 = r36;
        r12.label = 1;
        if (BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new LoginProcessor$dismissLoginDrawerIfNeeded$2(null), r12) == r13) goto L66;
        r114 = r36;
        r25 = r23;
        goto L60
    L66:
        return r13;
    L29:
        if (StringsKt.isBlank(r38) == true) goto L32;
        r39 = false;
    L7:
        r10 = new LoginProcessor$routeToLoginEntry$1(r22, r24);
        goto L8
    }

    public static void d(j r11, AppletAuthTaskMonitor.ErrorCode r12, String r13) {
        String r1 = MessageIndication.STATUS_FAILED;
        String r10 = k(r11.h);
        AppletAuthTaskMonitor.a r14 = new AppletAuthTaskMonitor.a(r1, r10, "login_panel_show", r12, r13, null, null, null, 480);
        r11.i = r14;
        AppletAuthTaskMonitor.Session r15 = r11.h;
        if (r15 == null) goto L6;
        r15.d(r14);
        return;
    }

    public static void g(String r36, String r37, j r38) {
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r0 = AppletRuntimeManager.d;
        if (r0 == null) goto L5;
        Activity r12 = r0.currentActivity();
    L7:
        if (r12 != null) goto L13;
        com.bytedance.ai.utils.g.a.e("LoginProcessor", "Top activity is null");
        d(r38, AppletAuthTaskMonitor.ErrorCode.UI_RENDER_FAILED, "Current activity is null.");
        f3.h<AbsLoginWithDoubaoWidgetMethodIDL.b> r1 = r38.g;
        if (r1 == null) goto L88;
        f3.h.a.a(r1, "Current activity is null.", null, null, 14);
        return;
    L88:
        return;
    L13:
        if (b.get() != null) goto L15;
        b = new WeakReference(new f(r12));
    L15:
        f r10 = b.get();
        if (r10 != null) goto L21;
        com.bytedance.ai.utils.g.a.e("LoginProcessor", "loadAddShowWidget: cannot get drawerContainer");
        d(r38, AppletAuthTaskMonitor.ErrorCode.UI_RENDER_FAILED, "Cannot get drawerContainer.");
        f3.h<AbsLoginWithDoubaoWidgetMethodIDL.b> r11 = r38.g;
        if (r11 == null) goto L89;
        f3.h.a.a(r11, "Cannot get drawerContainer.", null, null, 14);
        return;
    L89:
        return;
    L21:
        ViewGroup r13 = r10.c;
        if (r13 != null) goto L28;
        com.bytedance.ai.utils.g.a.e("LoginProcessor", "loadAddShowWidget: cannot get drawerContent");
        d(r38, AppletAuthTaskMonitor.ErrorCode.UI_RENDER_FAILED, "Cannot get drawerContent.");
        f3.h<AbsLoginWithDoubaoWidgetMethodIDL.b> r14 = r38.g;
        if (r14 == null) goto L90;
        f3.h.a.a(r14, "Cannot get drawerContent.", null, null, 14);
        return;
    L90:
        return;
    L28:
        if (r38.g == null) goto L30;
        String r15 = "doubao_apps_detail";
    L31:
        com.bytedance.ai.utils.l r16 = com.bytedance.ai.utils.l.a;
        String r17 = com.bytedance.ai.utils.l.e(r16, "larus_appEntry_bottomSheet_Title_phoneNo_cn");
        if (r17 != null) goto L34;
        r17 = "申请获取并验证你的手机号";
    L34:
        String r18 = com.bytedance.ai.utils.l.e(r16, "larus_appEntry_bottomSheet_option_more");
        if (r18 != null) goto L37;
        r18 = "其他登录方式";
    L37:
        String r19 = com.bytedance.ai.utils.l.e(r16, "larus_appEntry_bottomSheet_option_notNow");
        if (r19 != null) goto L40;
        r19 = "暂不登录";
    L40:
        String r20 = com.bytedance.ai.utils.l.e(r16, "larus_appEntry_bottomSheet_optionDesc_linkedNo_cn");
        if (r20 != null) goto L43;
        r20 = "豆包绑定号码";
    L43:
        String r21 = com.bytedance.ai.utils.l.e(r16, "larus_appEntry_toast_agreeTerms");
        if (r21 != null) goto L46;
        r21 = "需同意相关服务协议和隐私政策";
    L46:
        String r110 = com.bytedance.ai.utils.l.e(r16, "larus_appEntry_chatCard_title_btn_agree");
        if (r110 != null) goto L49;
        r110 = "同意并继续";
    L49:
        String r111 = com.bytedance.ai.utils.l.e(r16, "larus_appEntry_chatCard_title_btn_notNow");
        if (r111 != null) goto L52;
        r111 = "暂不同意";
    L52:
        String r22 = com.bytedance.ai.utils.l.e(r16, "larus_appEntry_chatCard_title_agreePolicy");
        if (r22 != null) goto L56;
        r22 = "隐私协议提示";
    L56:
        if (Intrinsics.areEqual(r37, "mcp-login-card") == false) goto L59;
        String r23 = StringsKt.trimIndent("\n    {\n        \"type\": \"getPhoneNumber\",\n        \"currentPage\": \"" + r15 + "\",\n        \"brand\": {\n          \"name\": \"" + r38.a.b + "\",\n          \"logo\": \"" + r38.a.c + "\"\n        },\n        \"content\": {\n          \"title\": \"" + r17 + "\",\n          \"description\": \"" + r38.b.b() + "\"\n        },\n        \"buttons\": {\n          \"primary\": {\n            \"text\": \"" + r38.b.c() + "\",\n            \"loadingText\": \"登录中...\",\n            \"subtext\": \"" + r20 + "\"\n          },\n          \"other\": {\n            \"text\": \"" + r18 + "\"\n          },\n          \"secondary\": {\n            \"text\": \"" + r19 + "\"\n          }\n        },\n        \"agreement\": {\n          \"text\": [\n            {\n              \"text\": \"已阅读并同意" + r38.a.b + "的\"\n            },\n            {\n              \"text\": \"服务协议\",\n              \"url\": \"" + c(r38.b.f()) + "\"\n            },\n            {\n              \"text\": \"和\"\n            },\n            {\n              \"text\": \"隐私政策\",\n              \"url\": \"" + c(r38.b.e()) + "\"\n            }\n          ]\n        },\n        \"warningToast\": \"" + r21 + "\"\n      }\n                ");
    L61:
        String r112 = r23;
    L63:
        j r24 = (j) ((LinkedHashMap) c).get(r36);
        if (r24 != null) goto L66;
        com.bytedance.ai.utils.g.a.e("LoginProcessor", "constructRenderContext: Can not find loginContext: " + r36);
        h5.k r25 = null;
    L74:
        if (r25 != null) goto L79;
        com.bytedance.ai.utils.g.a.e("LoginProcessor", "renderContext is null");
        d(r38, AppletAuthTaskMonitor.ErrorCode.UI_RENDER_FAILED, "Failed to build renderContext.");
        f3.h<AbsLoginWithDoubaoWidgetMethodIDL.b> r26 = r38.g;
        if (r26 == null) goto L91;
        f3.h.a.a(r26, "Failed to build renderContext.", null, null, 14);
        return;
    L91:
        return;
    L79:
        Activity r113 = r12;
        if ((r113 instanceof LifecycleOwner) == false) goto L82;
        LifecycleOwner r27 = (LifecycleOwner) r113;
    L83:
        if (r27 == null) goto L92;
        LifecycleCoroutineScope r28 = LifecycleOwnerKt.getLifecycleScope(r27);
        if (r28 == null) goto L93;
        BuildersKt.launch$default(r28, Dispatchers.getMain(), null, new LoginProcessor$loadAddShowWidget$1(r25, r36, r38, r10, r113, r37, null), 2, null);
        return;
    L93:
        return;
    L92:
        return;
    L82:
        r27 = null;
        goto L83
    L66:
        String r29 = r24.a.f.d;
        if (StringsKt.isBlank(r29) == false) goto L69;
        r29 = "mocked_conversation_for_login";
    L69:
        String r210 = r29;
        if (IAISDKDebugService.a.getDebugMode() != IAISDKDebugService$DebugMode.SCAN_PREVIEW) goto L72;
        String r211 = r24.a.d;
    L73:
        u2.b r30 = r24.a.f;
        r25 = new h5.k(r30.a, r210, r30.e, r30.b, r30.f, new WidgetInfo(r36, "mcp-privacy-login-card", r112, null, null, null, null, null, null, null, "1", null, null, r211, 7160, null), r13, new l(), 0, null, null, false, null, null, 61440);
        goto L74
    L72:
        r211 = null;
        goto L73
    L59:
        if (Intrinsics.areEqual(r37, "mcp-agree-card") == false) goto L62;
        r23 = StringsKt.trimIndent("\n{\n    \"type\": \"agreePrivacyAuthorization\",\n    \"currentPage\": \"" + r15 + "\",\n    \"brand\": {\n        \"name\": \"" + r38.a.b + "\",\n        \"logo\": \"" + r38.a.c + "\"\n    },\n    \"content\": {\n        \"title\": \"" + r22 + "\",\n        \"description\": \"" + r38.b.d() + "\"\n    },\n    \"buttons\": {\n        \"primary\": {\n             \"text\": \"" + r110 + "\"\n        },\n        \"secondary\": {\n             \"text\": \"" + r111 + "\"\n        }\n    }\n}\n                ");
        goto L61
    L62:
        r112 = null;
        goto L63
    L30:
        r15 = "chat";
        goto L31
    L5:
        r12 = null;
        goto L7
    }

    public static void i(String r10, GrantingAction r11, OperationType r12) {
        Intrinsics.checkNotNullParameter(r10, "appletId");
        Intrinsics.checkNotNullParameter(r11, "action");
        Intrinsics.checkNotNullParameter(r12, "operationType");
        LinkedHashMap r0 = (LinkedHashMap) c;
        j r1 = (j) r0.get(r10);
        if (r1 != null) goto L7;
        com.bytedance.ai.utils.g.a.e("LoginProcessor", "onDrawerDialogAction: Can not find loginContext of " + r10);
        return;
    L7:
        if (Intrinsics.areEqual(r10, d) == true) goto L10;
        com.bytedance.ai.utils.g.a.e("LoginProcessor", "onDrawerDialogAction: Received from non-active applet: " + r10);
        return;
    L10:
        h r13 = r1.e;
        com.bytedance.ai.utils.g r14 = com.bytedance.ai.utils.g.a;
        r14.i("LoginProcessor", "onDrawerDialogAction: appletId=" + r10 + ", action=" + r11 + ", operationType=" + r12 + ", currentState=" + r13);
        AppletAuthTaskMonitor.Session r15 = r1.h;
        if (r15 == null) goto L13;
        r15.c();
    L13:
        int r16 = a.a[r11.ordinal()];
        if (r16 != 1) goto L16;
        d = null;
        l(r10, new h.a(LocalFinishReason.USER_DISMISS_DIALOG));
        return;
    L16:
        if (r16 == 2) goto L35;
        if (r16 != 3) goto L33;
        j r17 = (j) r0.get(r10);
        if (r17 != null) goto L22;
        r14.e("LoginProcessor", "handleDialogAgree: Can not find loginContext of " + r10);
        return;
    L22:
        r14.i("LoginProcessor", "handleDialogAgree: applet: " + r10 + ", currentState: " + r17.e + ", opType: " + r12);
        h r18 = r17.e;
        if ((r18 instanceof h.d) == false) goto L29;
        if (r17.c == false) goto L27;
        l(r10, new h.a(LocalFinishReason.SUCCESS));
        return;
    L27:
        BuildersKt.launch$default(e, null, null, new LoginProcessor$handleDialogAgree$1(r10, null), 3, null);
        return;
    L29:
        if ((r18 instanceof h.b) == false) goto L31;
        l(r10, h.e.a);
        return;
    L31:
        r14.w("LoginProcessor", "handleDialogAgree called in unexpected state: " + r17.e);
        return;
    L33:
        throw new NoWhenBranchMatchedException();
    L35:
        if ((r13 instanceof h.d) == false) goto L38;
        LocalFinishReason r19 = LocalFinishReason.USER_REJECTED_PRIVACY;
    L41:
        l(r10, new h.a(r19));
        return;
    L38:
        if ((r13 instanceof h.b) == false) goto L40;
        r19 = LocalFinishReason.USER_REJECTED_LOGIN;
        goto L41
    L40:
        r19 = LocalFinishReason.USER_REJECTED_LOGIN;
        goto L41
    }

    public static void j(String r10, boolean r11, AppletAuthTaskMonitor.a r12) {
        Intrinsics.checkNotNullParameter(r10, "appletId");
        com.bytedance.ai.utils.g r0 = com.bytedance.ai.utils.g.a;
        r0.i("LoginProcessor", "postLoginResult: appletId=" + r10 + ", success=" + r11);
        LinkedHashMap r1 = (LinkedHashMap) c;
        j r13 = (j) r1.get(r10);
        h r14 = null;
        if (r13 == null) goto L5;
        h r15 = r13.e;
    L7:
        if ((r15 instanceof h.e) == true) goto L12;
        StringBuilder r16 = new StringBuilder("current state=");
        j r17 = (j) r1.get(r10);
        if (r17 == null) goto L11;
        r14 = r17.e;
    L11:
        r16.append(r14);
        r0.w("LoginProcessor", r16.toString());
    L12:
        j r18 = (j) r1.get(r10);
        if (r18 == null) goto L17;
        AppletAuthTaskMonitor.Session r19 = r18.h;
        if (r19 == null) goto L17;
        r19.c();
    L17:
        j r20 = (j) r1.get(r10);
        if (r20 == null) goto L20;
        r20.i = r12;
    L20:
        if (r11 == false) goto L22;
        LocalFinishReason r21 = LocalFinishReason.SUCCESS;
    L23:
        l(r10, new h.a(r21));
        return;
    L22:
        r21 = LocalFinishReason.BIZ_FAILED;
        goto L23
    L5:
        r15 = null;
        goto L7
    }

    public static void e(u2.c r20, u2.j r21, f3.h r22, String r23, AppletAuthTaskMonitor.Session r24) {
        String r10 = r20.a;
        String r0 = d;
        if (r0 != null) goto L5;
    L12:
        d = r10;
        c.put(r10, new j(r20, r21, false, r23, r22, r24));
        com.bytedance.ai.utils.g.a.i("LoginProcessor", "startLoginFlow for " + r10);
        BuildersKt.launch$default(e, null, null, new LoginProcessor$startLoginFlow$1(r10, null), 3, null);
        return;
    L5:
        if (Intrinsics.areEqual(r0, r10) == true) goto L12;
        com.bytedance.ai.utils.g.a.w("LoginProcessor", "handleAgree Applet[" + r10 + "] clicked agree button, but lock is held by " + d);
        if (r24 == null) goto L9;
        r24.d(new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, k(r24), "login_context_check", AppletAuthTaskMonitor.ErrorCode.CONCURRENT_FLOW, null, null, null, null, 496));
    L9:
        if (r22 == null) goto L14;
        f3.h.a.a(r22, "Another login process is active.", null, null, 14);
        return;
    }

    public static void f(u2.c r20, u2.j r21, f3.h r22, String r23, AppletAuthTaskMonitor.Session r24) {
        String r10 = r20.a;
        String r0 = d;
        if (r0 != null) goto L5;
    L12:
        d = r10;
        c.put(r10, new j(r20, r21, true, r23, r22, r24));
        com.bytedance.ai.utils.g.a.i("LoginProcessor", "startLoginFlow for " + r10);
        BuildersKt.launch$default(e, null, null, new LoginProcessor$startPrivacyFlow$1(r10, null), 3, null);
        return;
    L5:
        if (Intrinsics.areEqual(r0, r10) == true) goto L12;
        com.bytedance.ai.utils.g.a.w("LoginProcessor", "handlePrivacyAgree Applet[" + r10 + "] clicked agree button, but lock is held by " + d);
        if (r24 == null) goto L9;
        r24.d(new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, k(r24), "login_context_check", AppletAuthTaskMonitor.ErrorCode.CONCURRENT_FLOW, null, null, null, null, 496));
    L9:
        if (r22 == null) goto L14;
        f3.h.a.a(r22, "Another login process is active.", null, null, 14);
        return;
    }
}
