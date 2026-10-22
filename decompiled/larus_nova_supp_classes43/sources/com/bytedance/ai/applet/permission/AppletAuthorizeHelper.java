package com.bytedance.ai.applet.permission;

import android.content.Context;
import com.bytedance.ai.applet.app.foundation.w;
import com.bytedance.ai.applet.granting.GrantStatus;
import com.bytedance.ai.applet.granting.GrantingAction;
import com.bytedance.ai.bridge.remote.UserAuthService;
import com.bytedance.ai.bridge.remote.model.AppletPermissionDetail;
import com.bytedance.ai.bridge.remote.model.ScopePermissionInfo;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.PermissionDetail;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.security.SecureRandom;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AppletAuthorizeHelper implements w {
    public static final Lazy<Keva> d = null;
    public final String a;
    public final int b;
    public final Applet c;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/applet/permission/AppletAuthorizeHelper$AuthorizeException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", com.bytedance.android.ec.core.event.a.KEY_MSG, "", "extras", "", "", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "getExtras", "()Ljava/util/Map;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AuthorizeException extends Exception {
        private final Map<String, Object> extras;

        public final Map<String, Object> getExtras() {
            return this.extras;
        }

        public AuthorizeException(String r10, Map<String, ? extends Object> r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
            Intrinsics.checkNotNullParameter(r11, "extras");
            super(r10);
            this.extras = r11;
        }

        public /* synthetic */ AuthorizeException(String r1, Map r10, int r11, DefaultConstructorMarker r12) {
            if ((r11 & 2) == 0) goto L5;
            r10 = MapsKt.emptyMap();
        L5:
            this(r1, r10);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[GrantingAction.values().length];
            r0[GrantingAction.AGREED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[GrantingAction.REJECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[GrantingAction.DISMISSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void d() {
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void onDestroy() {
    }

    static {
        d = LazyKt.lazy(new com.bytedance.ai.applet.permission.a());
    }

    public static String i(String r1) {
        switch(r1.hashCode()) {
            case -1750762604: goto L32;
            case -653473286: goto L28;
            case -21617665: goto L24;
            case 411225387: goto L20;
            case 421939912: goto L17;
            case 934308869: goto L13;
            case 1403059833: goto L9;
            case 2106603706: goto L6;
            default: goto L35;
        };
    L35:
        return "";
    L6:
        if (r1.equals("scope.userFuzzyLocation") == false) goto L35;
    L30:
        return com.bytedance.android.ec.core.event.a.KEY_LOCATION;
    L9:
        if (r1.equals("scope.addPhoneContact") == false) goto L35;
        return "addPhoneContact";
    L13:
        if (r1.equals("scope.addPhoneCalendar") == false) goto L35;
        return "addPhoneCalendar";
    L17:
        if (r1.equals("scope.userLocationBackground") == false) goto L35;
    L20:
        if (r1.equals("scope.record") == false) goto L35;
        return "microphone";
    L24:
        if (r1.equals("scope.camera") == false) goto L35;
        return "camera";
    L28:
        if (r1.equals("scope.userLocation") == true) goto L30;
    L32:
        if (r1.equals("scope.bluetooth") == false) goto L35;
        return "bluetooth";
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

    public AppletAuthorizeHelper(String r10, int r11, Applet r12) {
        Intrinsics.checkNotNullParameter(r10, "appletId");
        Intrinsics.checkNotNullParameter(r12, "manifest");
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }

    public static final Object b(AppletAuthorizeHelper r10, String r11, GrantingAction r12, Continuation r13) {
        r10.getClass();
        if ((r13 instanceof AppletAuthorizeHelper$postUserAction$1) == false) goto L7;
        AppletAuthorizeHelper$postUserAction$1 r0 = (AppletAuthorizeHelper$postUserAction$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r0.label;
        if (r16 == 0) goto L18;
        if (r16 != 1) goto L17;
        r12 = (GrantingAction) r0.L$1;
        r11 = (String) r0.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Exception -> L14
        Object r17 = ((Result) r14).unbox-impl();     // Catch: Exception -> L14
    L32:
        boolean r18 = Result.isSuccess-impl(r17);     // Catch: Exception -> L14
        if (r18 == true) goto L38;
        com.bytedance.ai.utils.g.a.e("AppletAuthorizeHelper", "Failed to post user action '" + r12 + "' for scope '" + r11 + '\'');     // Catch: Exception -> L14
    L38:
        return Boxing.boxBoolean(r18);
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r14);
        int r19 = b.a[r12.ordinal()];
        if (r19 != 1) goto L21;
        GrantStatus r110 = GrantStatus.GRANTED;
    L29:
        UserAuthService r20 = UserAuthService.a;     // Catch: Exception -> L14
        String r21 = r10.a;     // Catch: Exception -> L14
        Integer r111 = Boxing.boxInt(u2.g.a(r110));     // Catch: Exception -> L14
        r0.L$0 = r11;     // Catch: Exception -> L14
        r0.L$1 = r12;     // Catch: Exception -> L14
        r0.label = 1;     // Catch: Exception -> L14
        r17 = UserAuthService.r(r21, r11, r111, r0);     // Catch: Exception -> L14
        if (r17 != r15) goto L32;
        return r15;
    L21:
        if (r19 != 2) goto L23;
    L27:
        r110 = GrantStatus.DENIED;
        goto L29
    L23:
        if (r19 == 3) goto L27;
        throw new NoWhenBranchMatchedException();
    L14:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("AppletAuthorizeHelper", "Failed to post user action '" + r12 + "' for scope '" + r11 + '\'', e);
        r18 = false;
    L7:
        r0 = new AppletAuthorizeHelper$postUserAction$1(r10, r13);
        goto L8
    }

    public final <T> Object j(AppletAuthTaskMonitor.Session r10, AppletAuthTaskMonitor.Session r11, Function1<? super Continuation<? super T>, ? extends Object> r12, Continuation<? super T> r13) {
        if ((r13 instanceof AppletAuthorizeHelper$trackPermissionStatusBackend$1) == false) goto L7;
        AppletAuthorizeHelper$trackPermissionStatusBackend$1 r0 = (AppletAuthorizeHelper$trackPermissionStatusBackend$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r0.label;
        if (r16 == 0) goto L18;
        if (r16 != 1) goto L17;
        long r17 = r0.J$0;
        AppletAuthTaskMonitor.Session r18 = (AppletAuthTaskMonitor.Session) r0.L$1;
        AppletAuthTaskMonitor.Session r19 = (AppletAuthTaskMonitor.Session) r0.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L14
    L23:
        long r20 = System.currentTimeMillis() - r17;
        r19.a(r20);
        if (r18 == null) goto L26;
        r18.a(r20);
    L26:
        return r14;
    L14:
        Throwable th2 = th;
    L29:
        long r21 = System.currentTimeMillis() - r17;
        r19.a(r21);
        if (r18 == null) goto L32;
        r18.a(r21);
    L32:
        throw th2;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r14);
        long r22 = System.currentTimeMillis();
        r0.L$0 = r10;     // Catch: Throwable -> L27
        r0.L$1 = r11;     // Catch: Throwable -> L27
        r0.J$0 = r22;     // Catch: Throwable -> L27
        r0.label = 1;     // Catch: Throwable -> L27
        r14 = r12.invoke(r0);     // Catch: Throwable -> L27
        if (r14 != r15) goto L22;
        return r15;
    L22:
        r19 = r10;
        r18 = r11;
        r17 = r22;
    L27:
        th = move-exception;
        th2 = th;
        r19 = r10;
        r18 = r11;
        r17 = r22;
    L7:
        r0 = new AppletAuthorizeHelper$trackPermissionStatusBackend$1(this, r13);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object c(String r39, boolean r40, String r41, AppletAuthTaskMonitor.Session r42, AppletAuthTaskMonitor.Session r43, Continuation<? super f> r44) {
        if ((r44 instanceof AppletAuthorizeHelper$authorize$1) == false) goto L7;
        AppletAuthorizeHelper$authorize$1 r1 = (AppletAuthorizeHelper$authorize$1) r44;
        int r10 = r1.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r10 - Integer.MIN_VALUE;
    L8:
        AppletAuthorizeHelper$authorize$1 r0 = r1;
        Object r11 = r0.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r0.label;
        String r23 = "granted";
        String r14 = "AppletAuthorizeHelper";
        if (r13 == 0) goto L20;
        if (r13 != 1) goto L19;
        AppletAuthTaskMonitor.Session r15 = (AppletAuthTaskMonitor.Session) r0.L$3;
        AppletAuthTaskMonitor.Session r16 = (AppletAuthTaskMonitor.Session) r0.L$2;
        String r17 = (String) r0.L$1;
        String r18 = (String) r0.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Exception -> L14 AuthorizeException -> L16
        AppletAuthTaskMonitor.Session r19 = r16;
        String r110 = r17;
        r14 = "AppletAuthorizeHelper";
        String r111 = ", scopeName=";
        int r112 = 2;
        boolean r113 = false;
    L141:
        Pair r20 = (Pair) r11;     // Catch: AuthorizeException -> L59 Exception -> L61
        boolean r21 = ((Boolean) r20.component1()).booleanValue();     // Catch: AuthorizeException -> L59 Exception -> L61
        boolean r22 = ((Boolean) r20.component2()).booleanValue();     // Catch: AuthorizeException -> L59 Exception -> L61
        String r29 = "success";
        String r31 = null;
        AppletAuthTaskMonitor.ErrorCode r32 = null;
        String r33 = null;
        String r34 = "granted";
        if (this.b != CastIntegerProtector.parseInt("2")) goto L41;
        String r35 = null;
    L42:
        r15.d(new AppletAuthTaskMonitor.a(r29, r110, r31, r32, r33, r34, r35, "granted", 60));     // Catch: AuthorizeException -> L59 Exception -> L61
        Pair[] r24 = new Pair[r112];     // Catch: AuthorizeException -> L59 Exception -> L61
        String r25 = "already_granted";
        if (r21 == false) goto L46;
        Object r26 = "already_granted";
    L47:
        r24[r113 ? 1 : 0] = TuplesKt.to("applet_auth_status", r26);     // Catch: AuthorizeException -> L59 Exception -> L61
        if (r22 == true) goto L51;
        r25 = "approved";
    L51:
        r24[1] = TuplesKt.to("system_auth_status", r25);     // Catch: AuthorizeException -> L59 Exception -> L61
        Map r27 = MapsKt.mapOf(r24);     // Catch: AuthorizeException -> L59 Exception -> L61
        Map r28 = null;
    L148:
        return new f(true, null, r27, r112);
    L57:
        e = e;
    L64:
        String r210 = r110;
        r14 = r14;
    L88:
        com.bytedance.ai.utils.g.a.w(r14, "Authorization failed: appletId=" + this.a + r111 + r18 + ", reason=" + e.getMessage());
        String r30 = e.getMessage();
        int r36 = this.b;
        if (r30 != null) goto L92;
        r30 = "";
    L92:
        if (StringsKt.startsWith$default(r30, "invalid_scope", r113, r112, r28) == false) goto L95;
        AppletAuthTaskMonitor.a r37 = new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, r210, "permission_context_check", AppletAuthTaskMonitor.ErrorCode.INVALID_PARAM, r30, null, null, "refused", 224);
    L115:
        r15.d(r37);
        String r38 = e.getMessage();
        if (r38 != null) goto L119;
        r38 = "";
    L119:
        if (StringsKt.startsWith$default(r38, "invalid_scope", r113, r112, r28) == false) goto L122;
        AppletAuthTaskMonitor.a r45 = new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, null, "permission_context_check", AppletAuthTaskMonitor.ErrorCode.INVALID_PARAM, r38, null, null, null, 482);
    L129:
        if (r19 == null) goto L132;
        r19.d(r45);
    L132:
        return new f(r113, e.getMessage(), e.getExtras());
    L122:
        if (StringsKt.startsWith$default(r38, "network_failure", r113, r112, r28) == false) goto L124;
        r45 = new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, null, "permission_status_check", AppletAuthTaskMonitor.ErrorCode.API_FAILED, r38, null, null, null, 482);
        goto L129
    L124:
        String r211 = MessageIndication.STATUS_FAILED;
        String r212 = null;
        String r213 = "permission_context_check";
        AppletAuthTaskMonitor.ErrorCode r310 = AppletAuthTaskMonitor.ErrorCode.UNKNOWN;
        if (StringsKt.isBlank(r38) == false) goto L127;
        String r311 = r28;
    L128:
        r45 = new AppletAuthTaskMonitor.a(r211, r212, r213, r310, r311, null, null, null, 482);
        goto L129
    L127:
        r311 = r38;
        goto L128
    L95:
        if (StringsKt.startsWith$default(r30, "applet_permission_denied", r113, r112, r28) == false) goto L98;
        r37 = new AppletAuthTaskMonitor.a("user_refused", r210, "user_decision", AppletAuthTaskMonitor.ErrorCode.USER_REFUSED, r30, "refused", null, "refused", 160);
        goto L115
    L98:
        if (StringsKt.startsWith$default(r30, "applet_permission_cancelled", r113, r112, r28) == false) goto L101;
        r37 = new AppletAuthTaskMonitor.a("user_cancelled", r210, "user_decision", AppletAuthTaskMonitor.ErrorCode.USER_CANCELLED, r30, "cancelled", null, "refused", 160);
        goto L115
    L101:
        if (StringsKt.startsWith$default(r30, "system_permission_denied", r113, r112, r28) == false) goto L108;
        String r214 = "user_refused";
        String r215 = "system_permission";
        AppletAuthTaskMonitor.ErrorCode r216 = AppletAuthTaskMonitor.ErrorCode.SYSTEM_PERMISSION_DENIED;
        String r312 = "granted";
        String r313 = "refused";
        if (r36 == CastIntegerProtector.parseInt("2")) goto L106;
        r23 = "refused";
    L106:
        r37 = new AppletAuthTaskMonitor.a(r214, r210, r215, r216, r30, r312, r313, r23, 32);
        goto L115
    L108:
        if (StringsKt.startsWith$default(r30, "network_failure", r113, r112, r28) == false) goto L110;
        r37 = new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, r210, "permission_status_check", AppletAuthTaskMonitor.ErrorCode.API_FAILED, r30, null, null, "refused", 224);
        goto L115
    L110:
        String r217 = MessageIndication.STATUS_FAILED;
        String r218 = "permission_context_check";
        AppletAuthTaskMonitor.ErrorCode r219 = AppletAuthTaskMonitor.ErrorCode.UNKNOWN;
        if (StringsKt.isBlank(r30) == false) goto L113;
        String r314 = r28;
    L114:
        r37 = new AppletAuthTaskMonitor.a(r217, r210, r218, r219, r314, null, null, "refused", 224);
        goto L115
    L113:
        r314 = r30;
    L55:
        e = e;
    L63:
        String r114 = r110;
    L81:
        com.bytedance.ai.utils.g.a.e(r14, "An unexpected error occurred during authorization: appletId=" + this.a + r111 + r18, e);
        AppletAuthTaskMonitor.ErrorCode r46 = AppletAuthTaskMonitor.ErrorCode.UNKNOWN;
        r15.d(new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, r114, "permission_context_check", r46, e.getMessage(), null, null, null, 480));
        if (r19 == null) goto L147;
        r19.d(new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, null, "permission_context_check", r46, e.getMessage(), null, null, null, 482));
    L147:
        return new f(r113, "Error: " + e.getMessage(), r28, 4);
    L46:
        r26 = "approved";
        goto L47
    L41:
        r35 = "granted";
    L59:
        e = e;
        r28 = null;
    L61:
        e = e;
        r28 = null;
        goto L63
    L16:
        e = e;
        r19 = r16;
        r210 = r17;
        r14 = "AppletAuthorizeHelper";
        r111 = ", scopeName=";
        r28 = null;
        r112 = 2;
        r113 = false;
    L14:
        e = e;
        r19 = r16;
        r114 = r17;
        r14 = "AppletAuthorizeHelper";
        r111 = ", scopeName=";
        r28 = null;
        r113 = false;
        goto L81
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r11);
        com.bytedance.ai.utils.g r47 = com.bytedance.ai.utils.g.a;
        StringBuilder r48 = new StringBuilder("authorize enter: appletId=");
        r48.append(this.a);
        r48.append(", appletType=");
        r48.append(this.b);
        r48.append(", scopeName=");
        r48.append(r39);
        r48.append(", manifestAppletId=");
        r48.append(this.c.K);
        r48.append(", manifestPermKeys=");
        Map<String, PermissionDetail> r49 = this.c.W;
        if (r49 == null) goto L23;
        Set<String> r50 = r49.keySet();
    L24:
        r48.append(r50);
        r47.i("AppletAuthorizeHelper", r48.toString());
        if (r42 != null) goto L27;
        SecureRandom r51 = AppletAuthTaskMonitor.a;
        AppletAuthTaskMonitor.Session r52 = AppletAuthTaskMonitor.g(new AppletAuthTaskMonitor.b("authorize", "native_api", "applet_scope", "AppletAuthorizeManager.authorize.call", this.a, "native_container", null, null, null, null, null, r39, 1984));
    L145:
        r0.L$0 = r39;     // Catch: Exception -> L78 AuthorizeException -> L85
        r110 = r41;
        r0.L$1 = r110;     // Catch: Exception -> L74 AuthorizeException -> L76
        r19 = r43;
        r0.L$2 = r19;     // Catch: Exception -> L70 AuthorizeException -> L72
        r0.L$3 = r52;     // Catch: Exception -> L70 AuthorizeException -> L72
        r0.label = 1;     // Catch: Exception -> L70 AuthorizeException -> L72
        r111 = ", scopeName=";
        r112 = 2;
        r113 = false;
        r113 = false;
        r113 = false;
        r11 = f(r39, r40, r52, r41, r43, r0);     // Catch: Exception -> L65 AuthorizeException -> L67
        if (r11 != r12) goto L37;
        return r12;
    L37:
        r15 = r52;
        r18 = r39;
        goto L141
    L67:
        e = e;
        r28 = null;
    L87:
        r15 = r52;
        r210 = r110;
        r18 = r39;
    L65:
        e = e;
        r28 = null;
    L80:
        r15 = r52;
        r114 = r110;
        r18 = r39;
        goto L81
    L72:
        e = e;
    L73:
        r111 = r14;
        r28 = null;
        r112 = 2;
        r113 = false;
    L70:
        e = e;
    L71:
        r111 = r14;
        r28 = null;
        r113 = false;
        goto L80
    L76:
        e = e;
        r19 = r43;
    L74:
        e = e;
    L75:
        r19 = r43;
        goto L71
    L85:
        e = e;
        r110 = r41;
        r19 = r43;
        r111 = r14;
        r28 = null;
        r112 = 2;
        r113 = false;
    L78:
        e = e;
        r110 = r41;
        goto L75
    L27:
        r52 = r42;
        goto L145
    L23:
        r50 = null;
    L7:
        r1 = new AppletAuthorizeHelper$authorize$1(this, r44);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object f(String r30, boolean r31, AppletAuthTaskMonitor.Session r32, String r33, AppletAuthTaskMonitor.Session r34, Continuation<? super Pair<Boolean, Boolean>> r35) {
        String r0 = r30;
        if ((r35 instanceof AppletAuthorizeHelper$authorizeOrThrow$1) == false) goto L7;
        AppletAuthorizeHelper$authorizeOrThrow$1 r10 = (AppletAuthorizeHelper$authorizeOrThrow$1) r35;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        AppletAuthorizeHelper$authorizeOrThrow$1 r12 = r10;
        Object r13 = r12.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r12.label;
        Map r16 = null;
        if (r15 == 0) goto L18;
        if (r15 == 1) goto L15;
        if (r15 != 2) goto L14;
        int r1 = r12.I$0;
        String r17 = (String) r12.L$0;
        ResultKt.throwOnFailure(r13);
    L72:
        boolean r18 = ((Boolean) r13).booleanValue();
        com.bytedance.ai.utils.g.a.d("AppletAuthorizeHelper", "Authorization flow completed successfully for scope '" + r17 + "'.");
        if (r1 == 0) goto L75;
        boolean r19 = true;
    L77:
        return TuplesKt.to(Boxing.boxBoolean(r19), Boxing.boxBoolean(r18));
    L75:
        r19 = false;
        goto L77
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        boolean r20 = r12.Z$0;
        AppletAuthTaskMonitor.Session r21 = (AppletAuthTaskMonitor.Session) r12.L$3;
        String r22 = (String) r12.L$2;
        AppletAuthTaskMonitor.Session r23 = (AppletAuthTaskMonitor.Session) r12.L$1;
        String r24 = (String) r12.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L78
        String r110 = r22;
        AppletAuthTaskMonitor.Session r25 = r23;
        boolean r26 = r20;
        r0 = r24;
    L41:
        AppletPermissionDetail r111 = (AppletPermissionDetail) r13;     // Catch: Exception -> L78
        Map<String, ScopePermissionInfo> r27 = r111.getScopesStatus();
        if (r27 == null) goto L45;
        ScopePermissionInfo r28 = r27.get(r0);
    L46:
        if (r28 == null) goto L53;
        Integer r29 = r28.getGrantStatus();
        int r36 = GrantStatus.GRANTED.getValue();
        if (r29 == null) goto L53;
        if (r29.intValue() != r36) goto L53;
        boolean r37 = true;
    L54:
        if (r37 == false) goto L56;
        String r38 = "granted";
    L57:
        String r210 = r38;
        if (r21 == null) goto L60;
        r21.d(new AppletAuthTaskMonitor.a("success", null, null, null, null, r210, null, r210, 190));
    L60:
        if (r28 == null) goto L67;
        Integer r39 = r28.getGrantStatus();
        int r40 = GrantStatus.GRANTED.getValue();
        if (r39 == null) goto L67;
        if (r39.intValue() != r40) goto L67;
        boolean r41 = true;
    L68:
        boolean r112 = r41;
        AppletAuthorizeHelper$authorizeOrThrow$isSystemAlreadyGranted$1 r42 = new AppletAuthorizeHelper$authorizeOrThrow$isSystemAlreadyGranted$1(r41, r0, r26, this, r28, r25, r110, r111, null);
        r12.L$0 = r0;
        r12.L$1 = null;
        r12.L$2 = null;
        r12.L$3 = null;
        r12.I$0 = r112 ? 1 : 0;
        r12.label = 2;
        r13 = CoroutineScopeKt.coroutineScope(r42, r12);
        if (r13 != r14) goto L71;
        return r14;
    L71:
        r17 = r0;
        r1 = r112 ? 1 : 0;
    L67:
        r41 = false;
        goto L68
    L56:
        r38 = "refused";
    L53:
        r37 = false;
        goto L54
    L45:
        r28 = null;
    L78:
        e = e;
    L82:
        if (r21 == null) goto L84;
        r21.d(new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, null, "permission_status_check", AppletAuthTaskMonitor.ErrorCode.API_FAILED, e.getMessage(), null, null, null, 482));
    L84:
        String r43 = e.getMessage();
        if (r43 == null) goto L94;
        boolean r44 = !StringsKt.isBlank(r43);
        String r45 = r43;
        if (r44 == true) goto L90;
        r45 = r16;
    L90:
        if (r45 == 0) goto L94;
        String r46 = "network_failure:".concat(r45);
        if (r46 == null) goto L94;
    L96:
        throw new AuthorizeException(r46, r16, 2, r16);
    L94:
        r46 = "network_failure";
        goto L96
    L18:
        ResultKt.throwOnFailure(r13);
        if (this.a.length() != 0) goto L21;
        boolean r47 = true;
    L22:
        if (r47 == true) goto L102;
        Scope.Companion.getClass();
        Intrinsics.checkNotNullParameter(r0, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        if (Scope.access$getVALUES$cp().contains(r0) == false) goto L100;
        Map<String, PermissionDetail> r48 = this.c.W;
        if (r48 != null) goto L28;
    L30:
        boolean r49 = false;
    L31:
        com.bytedance.ai.utils.g r50 = com.bytedance.ai.utils.g.a;
        StringBuilder r51 = new StringBuilder("authorizeOrThrow check declaration: appletId=");
        r51.append(this.a);
        r51.append(", scopeName=");
        r51.append(r0);
        r51.append(", hasDeclaredScope=");
        r51.append(r49);
        r51.append(", declaredKeys=");
        if (r48 == null) goto L34;
        Set<String> r52 = r48.keySet();
    L35:
        r51.append(r52);
        r51.append(", manifestAppletId=");
        r51.append(this.c.K);
        r50.i("AppletAuthorizeHelper", r51.toString());
        if (r49 == false) goto L98;
        AppletAuthorizeHelper$authorizeOrThrow$targetAppletDetail$1 r53 = new AppletAuthorizeHelper$authorizeOrThrow$targetAppletDetail$1(this, r0, null);     // Catch: Exception -> L80
        r12.L$0 = r0;     // Catch: Exception -> L80
        r12.L$1 = r32;     // Catch: Exception -> L80
        r12.L$2 = r33;     // Catch: Exception -> L80
        r12.L$3 = r34;     // Catch: Exception -> L80
        r12.Z$0 = r31;     // Catch: Exception -> L80
        r12.label = 1;     // Catch: Exception -> L80
        r13 = j(r32, r34, r53, r12);     // Catch: Exception -> L80
        if (r13 != r14) goto L40;
        return r14;
    L40:
        r25 = r32;
        r21 = r34;
        r110 = r33;
        r26 = r31;
    L80:
        e = e;
        r21 = r34;
        goto L82
    L98:
        throw new AuthorizeException("invalid_scope:" + r0, r16, 2, r16);
    L34:
        r52 = null;
        goto L35
    L28:
        if (r48.containsKey(r0) != true) goto L30;
        r49 = true;
        goto L31
    L100:
        throw new AuthorizeException("invalid_scope:" + r0, r16, 2, r16);
    L102:
        throw new AuthorizeException("Error: appletId is null or empty", r16, 2, r16);
    L21:
        r47 = false;
    L7:
        r10 = new AppletAuthorizeHelper$authorizeOrThrow$1(this, r35);
        goto L8
    }

    public static /* synthetic */ Object e(AppletAuthorizeHelper r10, String r11, boolean r12, String r13, AppletAuthTaskMonitor.Session r14, AppletAuthTaskMonitor.Session r15, Continuation r16, int r17) {
        if ((r17 & 2) == 0) goto L5;
        boolean r18 = false;
    L7:
        if ((r17 & 4) == 0) goto L9;
        r13 = "AppletAuthorizeManager.authorize.callback";
    L9:
        String r19 = r13;
        if ((r17 & 8) == 0) goto L12;
        AppletAuthTaskMonitor.Session r20 = null;
    L14:
        if ((r17 & 16) == 0) goto L16;
        AppletAuthTaskMonitor.Session r21 = null;
    L18:
        return r10.c(r11, r18, r19, r20, r21, r16);
    L16:
        r21 = r15;
        goto L18
    L12:
        r20 = r14;
        goto L14
    L5:
        r18 = r12;
        goto L7
    }
}
