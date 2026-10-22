package com.ss.android.lark.passport.flow.mfa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passport.PassportApmEvent;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.flow.core.router.FlowStep;
import com.ss.android.lark.passport.flow.idp_auth.FlowIdpLoginResult;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.utils.LarkContext;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@UserScope
public final class FlowMfaEngine {
    public static final /* synthetic */ int d = 0;
    public final String a;
    public final FlowMfaRepository b;
    public final h c;

    public static final class a {
    }

    static {
    }

    public final boolean b(String r15) {
        Intrinsics.checkNotNullParameter(r15, "url");
        this.c.getClass();
        Intrinsics.checkNotNullParameter(r15, "url");
        PassportLog.d("FlowMfaFlowRegistry", "handle external browser IdP applink start");
        if (StringsKt.isBlank(r15) == false) goto L149;
        PassportLog.b("FlowMfaFlowRegistry", "handle external browser IdP applink failed: url is blank");
        return false;
    L149:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Object r16 = Result.constructor-impl(UriProtector.parse(r15));     // Catch: Throwable -> L7
    L9:
        Throwable r1 = Result.exceptionOrNull-impl(r16);
        if (r1 != null) goto L145;
        Uri r17 = (Uri) r16;
        if (StringsKt.equals("doubaolarkauth", r17.getScheme(), true) == true) goto L14;
    L18:
        boolean r2 = false;
    L19:
        PassportLog.d("FlowMfaFlowRegistry", "parse external browser IdP applink success: scheme=" + r17.getScheme() + ", host=" + r17.getHost() + ", path=" + r17.getPath() + ", isTargetApplink=" + r2);
        if (r2 == true) goto L22;
        PassportLog.b("FlowMfaFlowRegistry", "handle external browser IdP applink failed: route mismatch");
        return false;
    L22:
        String r18 = i.a(r17, AppbrandHostConstants.Schema_RESERVED_FIELD.TOKEN);
        if (r18 != null) goto L25;
    L28:
        boolean r3 = true;
    L29:
        if (r3 == false) goto L31;
        PassportLog.b("FlowMfaFlowRegistry", "handle external browser IdP applink failed: token is blank");
        return false;
    L31:
        FlowIdpLoginResult.Companion.getClass();
        FlowIdpLoginResult r19 = FlowIdpLoginResult.a.a(r18, "external_browser_token");
        if (r19 != null) goto L34;
        PassportLog.b("FlowMfaFlowRegistry", "handle external browser IdP applink failed: decode token failed");
        return false;
    L34:
        String r4 = r19.getState();
        Context r5 = null;
        if (r4 != null) goto L37;
    L39:
        r4 = null;
    L40:
        if (r4 != null) goto L42;
        PassportLog.b("FlowMfaFlowRegistry", "handle external browser IdP applink failed: state is blank");
        return false;
    L42:
        ConcurrentHashMap<String, FlowMfaFlowSession> r6 = o.a;
        Intrinsics.checkNotNullParameter(r4, "state");
        if (StringsKt.isBlank(r4) == false) goto L45;
        PassportLog.b("FlowMfaRuntime", "find BIDP session failed: state is blank");
        FlowMfaFlowSession r9 = null;
    L69:
        if (r9 != null) goto L71;
        PassportLog.b("FlowMfaFlowRegistry", "handle external browser IdP applink failed: session not found");
        return false;
    L71:
        PassportLog.d("FlowMfaFlowRegistry", "external browser IdP session found");
    L72:
        com.ss.android.lark.passport.flow.mfa.a r7 = r9.v.get();
        int r8 = FlowMfaFlowSession.b.a[r7.a.ordinal()];
        if (r8 != 1) goto L75;
    L86:
        boolean r10 = false;
    L88:
        if (r10 == false) goto L89;
        com.ss.android.lark.passport.flow.mfa.a r11 = com.ss.android.lark.passport.flow.mfa.a.a(r7, ExternalBidpCallbackPhase.DISPATCHING);
        AtomicReference<com.ss.android.lark.passport.flow.mfa.a> r12 = r9.v;
    L92:
        if (r12.compareAndSet(r7, r11) == true) goto L93;
        if (r12.get() == r7) goto L92;
        boolean r13 = false;
    L97:
        if (r13 == false) goto L72;
        PassportLog.d("FlowMfaSession", "begin external BIDP dispatch success: previousPhase=" + r7.a + ", attempt=" + r7.b);
        boolean r14 = true;
    L99:
        if (r14 == true) goto L101;
        PassportLog.b("FlowMfaFlowRegistry", "external browser IdP callback rejected by callback state");
        return false;
    L101:
        WeakReference<Activity> r20 = r9.n.get();
        if (r20 == null) goto L110;
        Activity r21 = r20.get();
        if (r21 == null) goto L110;
        if (FlowMfaFlowSession.p(r21) == false) goto L108;
        r5 = r21;
    L108:
        if (r5 == null) goto L110;
    L111:
        StringBuilder r22 = new StringBuilder("launch external browser IdP verify activity: context=");
        r22.append(r5.getClass().getSimpleName());
        r22.append(", fromActivity=");
        boolean r23 = r5 instanceof Activity;
        r22.append(r23);
        PassportLog.d("FlowMfaFlowRegistry", r22.toString());
        FlowMfaSsoVerifyActivity.a r24 = FlowMfaSsoVerifyActivity.h;
        String r25 = r9.a;
        r24.getClass();
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r25, "flowId");
        Intrinsics.checkNotNullParameter(r19, "loginResult");
        PassportLog.d("FlowMfaSsoVerify", "launch start: context=" + r5.getClass().getSimpleName() + ", fromActivity=" + r23);
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L117
        Intent r27 = new Intent(r5, FlowMfaSsoVerifyActivity.class);     // Catch: Throwable -> L117
        if ((r5 instanceof Activity) == true) goto L115;
        r27.addFlags(268435456);     // Catch: Throwable -> L117
    L115:
        r27.addFlags(65536);     // Catch: Throwable -> L117
        p.a(r27);     // Catch: Throwable -> L117
        r27.putExtra("flow_mfa_flow_id", r25);     // Catch: Throwable -> L117
        r27.putExtra("flow_mfa_login_result", r19);     // Catch: Throwable -> L117
        r5.startActivity(r27);     // Catch: Throwable -> L117
        Object r110 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L117
    L120:
        if (Result.isSuccess-impl(r110) == false) goto L122;
        ((Boolean) r110).booleanValue();
        PassportLog.d("FlowMfaSsoVerify", "launch request accepted");
    L122:
        Throwable r28 = Result.exceptionOrNull-impl(r110);
        if (r28 == null) goto L125;
        PassportLog.b("FlowMfaSsoVerify", "launch failed: ".concat(r28.getClass().getSimpleName()));
    L125:
        Boolean r29 = Boolean.FALSE;
        if (Result.isFailure-impl(r110) == false) goto L128;
        r110 = r29;
    L128:
        boolean r30 = ((Boolean) r110).booleanValue();
        if (r30 == false) goto L131;
        PassportLog.d("FlowMfaFlowRegistry", "external browser IdP verify activity launched");
    L178:
        return r30;
    L131:
        com.ss.android.lark.passport.flow.mfa.a r31 = r9.v.get();
        if (r31.a != ExternalBidpCallbackPhase.DISPATCHING) goto L143;
        com.ss.android.lark.passport.flow.mfa.a r32 = com.ss.android.lark.passport.flow.mfa.a.a(r31, ExternalBidpCallbackPhase.WAITING_CALLBACK);
        AtomicReference<com.ss.android.lark.passport.flow.mfa.a> r33 = r9.v;
    L136:
        if (r33.compareAndSet(r31, r32) == true) goto L137;
        if (r33.get() == r31) goto L136;
        boolean r111 = false;
    L141:
        if (r111 == false) goto L131;
        PassportLog.d("FlowMfaSession", "release external BIDP callback reservation: attempt=" + r31.b);
        goto L143
    L137:
        r111 = true;
    L143:
        PassportLog.b("FlowMfaFlowRegistry", "launch external browser IdP verify activity failed");
    L117:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        r110 = Result.constructor-impl(ResultKt.createFailure(th));
    L110:
        r5 = LarkContext.getApplication();
        goto L111
    L93:
        r13 = true;
        goto L97
    L89:
        PassportLog.b("FlowMfaSession", "begin external BIDP dispatch failed: phase=" + r7.a + ", attempt=" + r7.b);
        r14 = false;
        goto L99
    L75:
        if (r8 != 2) goto L77;
    L85:
        r10 = true;
        goto L88
    L77:
        if (r8 == 3) goto L85;
        if (r8 == 4) goto L86;
        if (r8 == 5) goto L86;
        throw new NoWhenBranchMatchedException();
    L45:
        StringBuilder r35 = new StringBuilder("find BIDP session start: sessionCount=");
        ConcurrentHashMap<String, FlowMfaFlowSession> r36 = o.a;
        r35.append(r36.size());
        PassportLog.d("FlowMfaRuntime", r35.toString());
        Iterator<T> r37 = r36.values().iterator();
    L47:
        if (r37.hasNext() == false) goto L64;
        Object r38 = r37.next();
        FlowMfaFlowSession r112 = (FlowMfaFlowSession) r38;
        r112.getClass();
        Intrinsics.checkNotNullParameter(r4, "state");
        String r113 = r112.j.get();
        if ((!StringsKt.isBlank(r4)) == true) goto L51;
    L53:
        boolean r114 = false;
    L54:
        StringBuilder r115 = new StringBuilder("match BIDP state: hasExpectedState=");
        if (r113 != null) goto L57;
    L60:
        boolean r116 = true;
    L61:
        r115.append(!r116);
        r115.append(", matches=");
        r115.append(r114);
        PassportLog.d("FlowMfaSession", r115.toString());
        if (r114 == false) goto L47;
    L65:
        r9 = (FlowMfaFlowSession) r38;
        if (r9 == null) goto L68;
        PassportLog.d("FlowMfaRuntime", "find BIDP session success");
        goto L69
    L68:
        PassportLog.b("FlowMfaRuntime", "find BIDP session failed: no matching session");
        goto L69
    L57:
        if (StringsKt.isBlank(r113) == true) goto L60;
        r116 = false;
        goto L61
    L51:
        if (Intrinsics.areEqual(r113, r4) == false) goto L53;
        r114 = true;
        goto L54
    L64:
        r38 = null;
        goto L65
    L37:
        if ((!StringsKt.isBlank(r4)) == false) goto L39;
    L25:
        if (StringsKt.isBlank(r18) == true) goto L28;
        r3 = false;
        goto L29
    L14:
        if (StringsKt.equals("flow", r17.getHost(), true) == false) goto L18;
        if (Intrinsics.areEqual("/officesdk/passport/sso", r17.getPath()) == false) goto L18;
        r2 = true;
        goto L19
    L145:
        PassportLog.c("FlowMfaFlowRegistry", "parse external browser IdP applink failed", r1);
        return false;
    L7:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public final void d(final FlowMfaError r3) {
        PassportApmEvent.a.q(new FlowMfaEngine$reportRuntimeAnomaly$1(this, r3));
    }

    @Inject
    public FlowMfaEngine(String r2, FlowMfaRepository r3, h r4) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "repository");
        Intrinsics.checkNotNullParameter(r4, "flowRegistry");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public static void c(final boolean r2, final long r3, final String r5) {
        PassportApmEvent.a.q(new FlowMfaEngine$reportMfaResult$1(r2, r3, r5));
    }

    public final Object a(String r7, String r8, Continuation<? super Result<? extends FlowMfaTokenStatus>> r9) {
        if ((r9 instanceof FlowMfaEngine$checkToken$1) == false) goto L7;
        FlowMfaEngine$checkToken$1 r0 = (FlowMfaEngine$checkToken$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        final long r11 = r0.J$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L14
    L32:
        Object r12 = Result.constructor-impl(r10);     // Catch: Throwable -> L14
        PassportApmEvent.a.q(new FlowMfaEngine$checkToken$4$1(r11));     // Catch: Throwable -> L14
        return r12;
    L14:
        Throwable th = th;
        final long r4 = r11;
    L37:
        PassportLog.e("FlowMfaEngine", "check MFA token failed: ".concat(th.getClass().getSimpleName()));
        FlowMfaError r13 = g.a(th);
        PassportApmEvent.a.q(new FlowMfaEngine$checkToken$5(r4));
        d(r13);
        Result.Companion r14 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new FlowMfaException(r13)));
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r10);
        r4 = System.currentTimeMillis();
        PassportApmEvent r15 = PassportApmEvent.a;
        r15.q(FlowMfaEngine$checkToken$2.INSTANCE);
        if (StringsKt.isBlank(r7) == false) goto L22;
        FlowMfaError r5 = g.c("MFA scope must not be blank");
    L25:
        if (r5 == null) goto L41;
        r15.q(new FlowMfaEngine$checkToken$3(r4));
        d(r5);
        Result.Companion r16 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new FlowMfaException(r5)));
    L41:
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L35
        FlowMfaRepository r18 = this.b;     // Catch: Throwable -> L35
        String r6 = this.a;     // Catch: Throwable -> L35
        r0.J$0 = r4;     // Catch: Throwable -> L35
        r0.label = 1;     // Catch: Throwable -> L35
        r10 = r18.c(r6, r7, r8, r0);     // Catch: Throwable -> L35
        if (r10 != r2) goto L31;
        return r2;
    L31:
        r11 = r4;
    L35:
        th = move-exception;
        th = th;
        goto L37
    L22:
        if (StringsKt.isBlank(r8) == false) goto L24;
        r5 = g.c("MFA token must not be blank");
        goto L25
    L24:
        r5 = null;
    L7:
        r0 = new FlowMfaEngine$checkToken$1(this, r9);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [com.ss.android.lark.passport.flow.mfa.FlowMfaRepository] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v11, types: [com.ss.android.lark.passport.flow.mfa.FlowMfaFlowSession] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v2, types: [com.ss.android.lark.passport.flow.mfa.FlowMfaFlowSession] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v4, types: [long] */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v19, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v23, types: [int] */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.ss.android.lark.passport.flow.mfa.h] */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.ss.android.lark.passport.flow.mfa.h] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.ss.android.lark.passport.flow.mfa.FlowMfaEngine$startFirstParty$1, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v4, types: [long] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [long] */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31, types: [long] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12, types: [com.ss.android.lark.passport.flow.mfa.FlowMfaFlowSession, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15, types: [com.ss.android.lark.passport.flow.mfa.FlowMfaFlowSession, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r6v4, types: [com.ss.android.lark.passport.flow.mfa.FlowMfaFlowSession] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object e(Activity r25, String r26, JSONObject r27, Continuation<? super Result<q>> r28) {
        final ?? r2 = r26;
        if ((r28 instanceof FlowMfaEngine$startFirstParty$1) == false) goto L7;
        FlowMfaEngine$startFirstParty$1 r3 = (FlowMfaEngine$startFirstParty$1) r28;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
        ?? r5 = r3;
    L8:
        Object r0 = r5.result;
        ?? r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r5.label;
        ?? r8 = 4;
        r8 = 4;
        ?? r9 = 1;
        ?? r11 = 2;
        if (r7 == 0) goto L41;
        if (r7 == 1) goto L36;
        if (r7 != 2) goto L134;
        int r10 = r5.I$0;
        long r13 = r5.J$0;
        FlowMfaFlowSession r12 = (FlowMfaFlowSession) r5.L$2;
        String r14 = (String) r5.L$1;
        Activity r15 = (Activity) r5.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L33
        ?? r16 = r10;
        r11 = r14;
        long r17 = r13;
    L32:
        r8 = r12;
        j r1 = (j) r0;     // Catch: Throwable -> L101
        if (Intrinsics.areEqual(r1, j.b.a) == false) goto L80;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L91
        CompletableDeferred<q> r19 = r8.e;     // Catch: Throwable -> L91
        r5.L$0 = r11;     // Catch: Throwable -> L91
        r5.L$1 = r8;     // Catch: Throwable -> L91
        r5.L$2 = null;     // Catch: Throwable -> L91
        r5.J$0 = r17;     // Catch: Throwable -> L91
        r5.I$0 = 1;     // Catch: Throwable -> L91
        r5.label = 3;     // Catch: Throwable -> L91
        r0 = r19.await(r5);     // Catch: Throwable -> L91
        if (r0 != r6) goto L74;
        return r6;
    L74:
        ?? r20 = r11;
        long r21 = r17;
        int r22 = 1;
        ?? r23 = r8;
    L75:
        Object r24 = Result.constructor-impl(r0);     // Catch: Throwable -> L77
        c(true, r21, r20);     // Catch: Throwable -> L77
        r2 = r22;
        r5 = r20;
        r6 = r21;
        r8 = r23;
    L122:
    L114:
        this.c.a(r8);
        return r24;
    L80:
        if ((r1 instanceof j.d) == false) goto L94;
        MainCoroutineDispatcher r29 = Dispatchers.getMain();     // Catch: Throwable -> L101
        FlowMfaEngine$startFirstParty$4 r30 = new FlowMfaEngine$startFirstParty$4(r15, r8, null);     // Catch: Throwable -> L101
        r5.L$0 = r11;     // Catch: Throwable -> L101
        r5.L$1 = r8;     // Catch: Throwable -> L101
        r5.L$2 = null;     // Catch: Throwable -> L101
        r5.J$0 = r17;     // Catch: Throwable -> L101
        r5.I$0 = r16;     // Catch: Throwable -> L101
        r5.label = 4;     // Catch: Throwable -> L101
        ?? r31 = r8;
        ?? r110 = r11;
        ?? r111 = r17;
        if (BuildersKt.withContext(r29, r30, r5) != r6) goto L84;
        return r6;
    L84:
        Result.Companion r32 = Result.Companion;     // Catch: Throwable -> L91
        CompletableDeferred<q> r33 = r31.e;     // Catch: Throwable -> L91
        r5.L$0 = r110;     // Catch: Throwable -> L91
        r5.L$1 = r31;     // Catch: Throwable -> L91
        r5.J$0 = r111;     // Catch: Throwable -> L91
        r5.I$0 = 1;     // Catch: Throwable -> L91
        r5.label = 5;     // Catch: Throwable -> L91
        r0 = r33.await(r5);     // Catch: Throwable -> L91
        if (r0 != r6) goto L87;
        return r6;
    L87:
        ?? r34 = r110;
        ?? r35 = r111;
        int r36 = 1;
        ?? r37 = r31;
    L88:
        r24 = Result.constructor-impl(r0);     // Catch: Throwable -> L77
        c(true, r35, r34);     // Catch: Throwable -> L77
        r2 = r36;
        r5 = r34;
        r6 = r35;
        r8 = r37;
        goto L122
    L94:
        if ((r1 instanceof j.c) == false) goto L97;
        c(false, r17, r11);     // Catch: Throwable -> L101
        d(((j.c) r1).a);     // Catch: Throwable -> L101
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L101
        r24 = Result.constructor-impl(ResultKt.createFailure(new FlowMfaException(((j.c) r1).a)));     // Catch: Throwable -> L101
        goto L114
    L97:
        if ((r1 instanceof j.a) == false) goto L100;
        FlowMfaError r39 = g.b("Unexpected MFA code apply result", null);     // Catch: Throwable -> L101
        c(false, r17, r11);     // Catch: Throwable -> L101
        d(r39);     // Catch: Throwable -> L101
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L101
        r24 = Result.constructor-impl(ResultKt.createFailure(new FlowMfaException(r39)));     // Catch: Throwable -> L101
        goto L114
    L100:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L101
    L101:
        th = th;
        r9 = r16;
    L103:
        ?? r112 = r8;
        ?? r41 = r9;
        ?? r113 = r11;
        long r114 = r17;
    L35:
        ?? r42 = r114;
        ?? r43 = r41;
        ?? r115 = r112;
        ?? r116 = r113;
    L104:
        r2 = r43;
    L132:
        PassportLog.e("FlowMfaEngine", "start first-party MFA failed: " + th.getClass().getSimpleName());     // Catch: Throwable -> L116
        FlowMfaError r44 = g.a(th);     // Catch: Throwable -> L116
        c(false, r42, r116);     // Catch: Throwable -> L116
        if (r2 != 0) goto L112;
        d(r44);     // Catch: Throwable -> L116
    L112:
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L116
        r24 = Result.constructor-impl(ResultKt.createFailure(new FlowMfaException(r44)));     // Catch: Throwable -> L116
        r8 = r115;
    L116:
        th = move-exception;
        this.c.a(r115);
        throw th;
    L33:
        th = th;
        r41 = r10;
        r112 = r12;
        r113 = r14;
        r114 = r13;
        goto L35
    L134:
        if (r7 == 3) goto L25;
        if (r7 == 4) goto L20;
        if (r7 != 5) goto L19;
        int r46 = r5.I$0;
        long r47 = r5.J$0;
        FlowMfaFlowSession r48 = (FlowMfaFlowSession) r5.L$1;
        String r49 = (String) r5.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L28
        r36 = r46;
        r34 = r49;
        r35 = r47;
        r37 = r48;
        goto L88
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        r2 = r5.I$0;
        r42 = r5.J$0;
        r115 = (FlowMfaFlowSession) r5.L$1;
        r116 = (String) r5.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L23
        r111 = r42;
        r31 = r115;
        r110 = r116;
    L23:
        th = th;
        goto L132
    L25:
        int r50 = r5.I$0;
        long r51 = r5.J$0;
        FlowMfaFlowSession r52 = (FlowMfaFlowSession) r5.L$1;
        String r53 = (String) r5.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L28
        r22 = r50;
        r20 = r53;
        r21 = r51;
        r23 = r52;
    L28:
        th = th;
        r116 = r5;
        r115 = 4;
        r42 = r6;
        goto L132
    L36:
        int r54 = r5.I$0;
        long r117 = r5.J$0;
        r12 = (FlowMfaFlowSession) r5.L$2;
        String r118 = (String) r5.L$1;
        Activity r55 = (Activity) r5.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L39
        Activity r56 = r55;
        r2 = r54;
        long r119 = r117;
        ?? r120 = r118;
    L135:
        r5.L$0 = r56;     // Catch: Throwable -> L105
        r5.L$1 = r120;     // Catch: Throwable -> L105
        r5.L$2 = r12;     // Catch: Throwable -> L105
        r5.J$0 = r119;     // Catch: Throwable -> L105
        r5.I$0 = r2;     // Catch: Throwable -> L105
        r5.label = 2;     // Catch: Throwable -> L105
        r0 = r12.o((FlowStep) r0);     // Catch: Throwable -> L105
        if (r0 != r6) goto L68;
        return r6;
    L68:
        r11 = r120;
        r15 = r56;
        r16 = r2;
        r17 = r119;
    L105:
        th = th;
        r115 = r12;
        r42 = r119;
        r116 = r120;
    L39:
        th = th;
        r43 = r54;
        r115 = r12;
        r42 = r117;
        r116 = r118;
        goto L104
    L41:
        ResultKt.throwOnFailure(r0);
        long r121 = System.currentTimeMillis();
        PassportApmEvent.a.q(new FlowMfaEngine$startFirstParty$2(r2));
        if (StringsKt.isBlank(r26) == false) goto L44;
        FlowMfaError r57 = g.c("MFA scope must not be blank");
    L45:
        if (r57 == null) goto L48;
        c(false, r121, r2);
        d(r57);
        Result.Companion r58 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new FlowMfaException(r57)));
    L48:
        h r59 = this.c;
        String r60 = this.a;
        FlowMfaRepository r61 = this.b;
        r59.getClass();
        Intrinsics.checkNotNullParameter(r60, "userId");
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r61, "repository");
        FlowMfaFlowSession r122 = new FlowMfaFlowSession(UUID.randomUUID().toString(), r60, r2, r61);
        AtomicReference<FlowMfaFlowSession> r62 = r59.a;
    L50:
        if (r62.compareAndSet(null, r122) == true) goto L51;
        if (r62.get() == null) goto L50;
        boolean r63 = false;
    L55:
        if (r63 == false) goto L57;
        ConcurrentHashMap<String, FlowMfaFlowSession> r64 = o.a;
        Intrinsics.checkNotNullParameter(r122, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        ConcurrentHashMap<String, FlowMfaFlowSession> r65 = o.a;
        r65.put(r122.a, r122);
        PassportLog.d("FlowMfaRuntime", "register session success: sessionCount=" + r65.size());
        AtomicReference<syb.b> r66 = r122.u;
        AtomicReference<syb.b> r67 = com.ss.android.lark.passport.flow.core.router.a.c;
        r66.set(com.ss.android.lark.passport.flow.core.router.a.c.getAndSet(r122.w));
    L58:
        if (r122 != null) goto L125;
        int r68 = g.a;
        FlowMfaError r69 = new FlowMfaError(FlowMfaErrorCategory.BUSY, "MFA flow is already running", null, null, null, null, 60, null);
        c(false, r121, r2);
        d(r69);
        Result.Companion r70 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new FlowMfaException(r69)));
    L125:
        ?? r71 = this.b;     // Catch: Throwable -> L107
        String r72 = this.a;     // Catch: Throwable -> L107
        r56 = r25;
        r5.L$0 = r56;     // Catch: Throwable -> L107
        r5.L$1 = r2;     // Catch: Throwable -> L107
        r5.L$2 = r122;     // Catch: Throwable -> L107
        r5.J$0 = r121;     // Catch: Throwable -> L107
        r5.I$0 = 0;     // Catch: Throwable -> L107
        r5.label = 1;     // Catch: Throwable -> L107
        r0 = r71.b(r72, r2, r27, r5);     // Catch: Throwable -> L107
        if (r0 != r6) goto L64;
        return r6;
    L64:
        r12 = r122;
        r120 = r2;
        r2 = 0;
        r119 = r121;
    L107:
        th = th;
        r116 = r2;
        r42 = r121;
        r115 = r122;
        r2 = 0;
        goto L132
    L57:
        r122 = null;
        goto L58
    L51:
        r63 = true;
        goto L55
    L44:
        r57 = null;
    L77:
        th = th;
        r115 = r8;
        r42 = r6;
        r116 = r5;
    L91:
        th = th;
    L7:
        r5 = new FlowMfaEngine$startFirstParty$1(this, r28);
        goto L8
    }
}
