package com.ss.android.lark.passport.flow.mfa;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passport.PassportApmEvent;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.flow.core.router.FlowStep;
import com.ss.android.lark.passport.flow.core.router.PassportRouterResult;
import com.ss.android.lark.passport.flow.idp_auth.FlowIdpLoginResult;
import com.ss.android.lark.utils.Contexts;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class FlowMfaFlowSession {
    public static final List<String> x = null;
    public static final List<String> y = null;
    public final String a;
    public final String b;
    public final String c;
    public final FlowMfaRepository d;
    public final CompletableDeferred<q> e;
    public final AtomicReference<FlowStep> f;
    public final AtomicBoolean g;
    public final CoroutineScope h;
    public final AtomicReference<Function1<j, Unit>> i;
    public final AtomicReference<String> j;
    public final AtomicReference<String> k;
    public final AtomicReference<WeakReference<Activity>> l;
    public final AtomicReference<WeakReference<Activity>> m;
    public final AtomicReference<WeakReference<Activity>> n;
    public final AtomicReference<WeakReference<Activity>> o;
    public final AtomicBoolean p;
    public final AtomicBoolean q;
    public final AtomicReference<z> r;
    public final AtomicReference<Long> s;
    public final AtomicReference<a0> t;
    public final AtomicReference<syb.b> u;
    public final AtomicReference<com.ss.android.lark.passport.flow.mfa.a> v;
    public final d w;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[ExternalBidpCallbackPhase.values().length];
            r0[ExternalBidpCallbackPhase.IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L45:
            r0[ExternalBidpCallbackPhase.WAITING_CALLBACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L61:
            r0[ExternalBidpCallbackPhase.RESUMED_WAITING_CALLBACK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L47:
            r0[ExternalBidpCallbackPhase.DISPATCHING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L27
        L49:
            r0[ExternalBidpCallbackPhase.TIMED_OUT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L28
        L12:
            a = r0;
            int[] r1 = new int[FlowVerifyFactor.values().length];
            r1[FlowVerifyFactor.PHONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
        L39:
            r1[FlowVerifyFactor.EMAIL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
        L53:
            r1[FlowVerifyFactor.BIDP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L31
        L37:
            r1[FlowVerifyFactor.SPARE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L32
        L51:
            r1[FlowVerifyFactor.OTP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L33
        L41:
            r1[FlowVerifyFactor.PASSWORD.ordinal()] = 6;     // Catch: NoSuchFieldError -> L34
        L19:
            b = r1;
            int[] r2 = new int[FlowMfaBidpWebActivityType.values().length];
            r2[FlowMfaBidpWebActivityType.INTERNAL_AUTH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L35
        L57:
            r2[FlowMfaBidpWebActivityType.EXTERNAL_BROWSER_LOADING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L36
        L22:
            c = r2;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ FlowMfaFlowSession a;
        public final /* synthetic */ Activity b;

        public c(FlowMfaFlowSession r1, Activity r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FlowMfaFlowSession r0 = this.a;     // Catch: Throwable -> L6
            Activity r1 = this.b;     // Catch: Throwable -> L6
            r0.getClass();     // Catch: Throwable -> L6
            if (FlowMfaFlowSession.p(r1) == false) goto L9;
            this.b.finish();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class d implements syb.b {
        public final /* synthetic */ FlowMfaFlowSession a;

        public d(FlowMfaFlowSession r1) {
            this.a = r1;
        }

        @Override // syb.b
        public final boolean a(Context r5, String r6, JSONObject r7) {
            Intrinsics.checkNotNullParameter(r5, "context");
            Intrinsics.checkNotNullParameter(r6, "nextStep");
            FlowMfaFlowSession r0 = this.a;
            if (r0.q() == true) goto L28;
            boolean r1 = r5 instanceof Activity;
            if (r1 == false) goto L8;
            Activity r3 = (Activity) r5;
        L9:
            if (r3 != null) goto L30;
            if (r1 == false) goto L12;
            Activity r8 = Contexts.requireActivity(r5);
        L24:
            r3 = r8;
        L27:
            if (r3 != null) goto L30;
        L12:
            if (r5 == null) goto L20;
            if (TextUtils.equals("com.android.internal.policy.DecorContext", r5.getClass().getName()) == false) goto L20;
            Field r2 = r5.getClass().getDeclaredField("mActivityContext");     // Catch: Exception -> L17
            r2.setAccessible(true);     // Catch: Exception -> L17
            r3 = (Activity) ((WeakReference) r2.get(r5)).get();     // Catch: Exception -> L17
        L17:
            e = move-exception;
            e.printStackTrace();
        L20:
            if ((r5 instanceof ContextWrapper) == false) goto L26;
            if ((r5 instanceof Activity) == true) goto L23;
            r5 = ((ContextWrapper) r5).getBaseContext();
            goto L20
        L23:
            r8 = Contexts.requireActivity(r5);
            goto L24
        L26:
            r3 = null;
        L30:
            if (r7 != null) goto L33;
            r7 = new JSONObject();
        L33:
            return r0.A(r3, new FlowStep(r6, r7, null)).a();
        L8:
            r3 = null;
        L28:
            return false;
        }
    }

    static {
        x = CollectionsKt.listOf(new String[]{"uri", "auth_url", "url", "web_url", "redirect_url"});
        y = CollectionsKt.listOf(new String[]{"tenant_domain", "tenantDomain"});
    }

    public final void e() {
    L2:
        com.ss.android.lark.passport.flow.mfa.a r0 = this.v.get();
        if (r0.a != ExternalBidpCallbackPhase.DISPATCHING) goto L4;
        com.ss.android.lark.passport.flow.mfa.a r1 = com.ss.android.lark.passport.flow.mfa.a.a(r0, ExternalBidpCallbackPhase.IDLE);
        AtomicReference<com.ss.android.lark.passport.flow.mfa.a> r2 = this.v;
    L7:
        if (r2.compareAndSet(r0, r1) == true) goto L8;
        if (r2.get() == r0) goto L7;
        boolean r3 = false;
    L12:
        if (r3 == false) goto L2;
        PassportLog.d("FlowMfaSession", "consume external BIDP dispatch result: attempt=" + r0.b);
        return;
    L8:
        r3 = true;
        goto L12
    }

    public final z f() {
        z r0 = this.r.get();
        if (r0 != null) goto L13;
        FlowStep r1 = g();
        if (r1 == null) goto L9;
        JSONObject r2 = r1.getStepInfo();
        if (r2 == null) goto L9;
        z r3 = D(r2);
    L10:
        if (r3 == null) goto L12;
        return r3;
    L12:
        return new z("bidp", null);
    L9:
        r3 = null;
        goto L10
    L13:
        return r0;
    }

    public final FlowStep g() {
        return this.f.get();
    }

    public final void l() {
        Activity r1 = null;
        WeakReference<Activity> r0 = this.l.getAndSet(null);
        if (r0 == null) goto L5;
        r1 = r0.get();
    L5:
        j(r1);
    }

    public final boolean q() {
        if (this.g.get() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.e.isCompleted() == true) goto L8;
        return false;
    }

    public static FlowMfaError C(Throwable r1) {
        if ((r1 instanceof FlowMfaException) == false) goto L5;
        FlowMfaException r0 = (FlowMfaException) r1;
    L6:
        if (r0 == null) goto L10;
        FlowMfaError r2 = r0.getError();
        if (r2 == null) goto L10;
        return r2;
    L10:
        return g.a(r1);
    L5:
        r0 = null;
        goto L6
    }

    public static z D(JSONObject r4) {
        Set<String> r0 = wyb.a.b;
        String r1 = wyb.a.C0203a.a(r4).a;
        Boolean r2 = null;
        if (r1 != null) goto L5;
    L9:
        r1 = "bidp";
    L10:
        Boolean r3 = r4.getBoolean("has_tenant_domain");
        if (r3 == null) goto L13;
        Boolean r5 = Boolean.valueOf(r3.booleanValue());
    L27:
        return new z(r1, r5);
    L13:
        Boolean r6 = r4.getBoolean("hasTenantDomain");
        if (r6 == null) goto L16;
        r5 = Boolean.valueOf(r6.booleanValue());
        goto L27
    L16:
        Iterator<T> r7 = y.iterator();
    L18:
        if (r7.hasNext() == false) goto L25;
        String r8 = r4.getString((String) r7.next());
        if (r8 == null) goto L22;
        Boolean r9 = Boolean.valueOf(!StringsKt.isBlank(r8));
    L23:
        if (r9 == null) goto L18;
        r2 = r9;
        goto L25
    L22:
        r9 = null;
    L25:
        r5 = r2;
        goto L27
    L5:
        if ((!StringsKt.isBlank(r1)) == true) goto L8;
        r1 = null;
    L8:
        if (r1 != null) goto L10;
        goto L9
    }

    public static boolean p(Activity r1) {
        if (r1.isFinishing() == false) goto L5;
    L7:
        return false;
    L5:
        if (r1.isDestroyed() == true) goto L7;
        return true;
    }

    public final a0 E(y r8) {
        String r1 = r8.a.getWireKey();
        String r2 = r8.d;
        FlowStep r9 = g();
        if (r9 == null) goto L5;
        String r10 = r9.getNextStep();
    L7:
        return new a0(r1, r2, r10, "user_action", this.c);
    L5:
        r10 = null;
        goto L7
    }

    public final AtomicReference<WeakReference<Activity>> c(FlowMfaBidpWebActivityType r2) {
        int r3 = b.c[r2.ordinal()];
        if (r3 == 1) goto L10;
        if (r3 != 2) goto L8;
        return this.n;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return this.m;
    }

    public final void h(FlowMfaError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        if (this.g.compareAndSet(false, true) == false) goto L6;
        m(FlowMfaBidpWebActivityType.INTERNAL_AUTH);
        w(r4);
        t(null, false);
        this.e.completeExceptionally(new FlowMfaException(r4));
        return;
    }

    public final void i(FlowMfaError r3) {
        Intrinsics.checkNotNullParameter(r3, "error");
        h(r3);
        r(new j.c(r3, true));
    }

    public final void j(Activity r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (p(r3) == true) goto L7;
        r3 = null;
    L7:
        if (r3 != null) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L13;
        r3.finish();
        return;
    L13:
        new Handler(Looper.getMainLooper()).post(new c(this, r3));
    }

    public final AtomicBoolean k(FlowMfaBidpWebActivityType r2) {
        int r3 = b.c[r2.ordinal()];
        if (r3 == 1) goto L10;
        if (r3 != 2) goto L8;
        return this.q;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return this.p;
    }

    public final void m(FlowMfaBidpWebActivityType r6) {
        Intrinsics.checkNotNullParameter(r6, "type");
        boolean r1 = true;
        k(r6).set(true);
        String r2 = null;
        WeakReference<Activity> r0 = c(r6).getAndSet(null);
        if (r0 == null) goto L5;
        Activity r3 = r0.get();
    L6:
        StringBuilder r4 = new StringBuilder("finish pending BIDP web activity: type=");
        r4.append(r6);
        r4.append(", hasActivity=");
        if (r3 != null) goto L10;
        r1 = false;
    L10:
        r4.append(r1);
        r4.append(", activity=");
        if (r3 == null) goto L13;
        r2 = r3.getClass().getSimpleName();
    L13:
        r4.append(r2);
        PassportLog.d("FlowMfaSession", r4.toString());
        j(r3);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final j o(final FlowStep r5) {
        final long r0 = System.currentTimeMillis();
        PassportApmEvent r2 = PassportApmEvent.a;
        r2.q(new FlowMfaFlowSession$handleStep$2(r5));
        if (q() == false) goto L7;
        r2.q(new FlowMfaFlowSession$handleStep$3(r0, r5));
        return j.b.a;
    L7:
        if (StringsKt.isBlank(r5.getNextStep()) == false) goto L10;
        r2.q(new FlowMfaFlowSession$handleStep$4(r0, r5));
        int r1 = g.a;
        FlowMfaError r6 = g.e(r5.getNextStep());
        h(r6);
        return new j.c(r6, true);
    L10:
        y(r5);
        r2.q(new FlowMfaFlowSession$handleStep$5(r0, r5));
        return new j.d(r5);
    }

    public final void r(j r2) {
        Function1<j, Unit> r0 = this.i.get();
        if (r0 == null) goto L6;
        r0.invoke(r2);
        return;
    }

    public final void s(FlowStep r10) {
        Intrinsics.checkNotNullParameter(r10, "step");
        JSONObject r0 = r10.getStepInfo();
        Iterator<T> r1 = x.iterator();
    L3:
        String r4 = null;
        if (r1.hasNext() == false) goto L13;
        String r2 = r0.getString((String) r1.next());
        if (r2 != null) goto L8;
    L10:
        r2 = null;
    L11:
        if (r2 == null) goto L3;
    L14:
        if (r2 != null) goto L16;
    L19:
        boolean r3 = true;
    L21:
        if (r3 == true) goto L67;
        JSONObject r11 = r10.getStepInfo();
        Set<String> r5 = wyb.a.b;
        boolean r6 = wyb.a.C0203a.a(r11).a();
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L25
        Object r8 = Result.constructor-impl(UriProtector.parse(r2));     // Catch: Throwable -> L25
    L27:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 != null) goto L65;
        Uri r12 = (Uri) r8;
        Intrinsics.checkNotNull(r12);
        String r13 = i.a(r12, "redirect_url");
        if (r13 != null) goto L32;
    L37:
        Uri r14 = null;
    L38:
        String r15 = i.a(r12, "state");
        if (r15 != null) goto L41;
    L47:
        if (r14 == null) goto L53;
        String r16 = i.a(r14, "state");
        if (r16 == null) goto L53;
        if ((!StringsKt.isBlank(r16)) == false) goto L53;
    L54:
        if (r16 != null) goto L60;
        String r17 = r11.getString("state");
        if (r17 != null) goto L58;
    L61:
        if (r4 == null) goto L63;
        this.j.set(r4);
        PassportLog.d("FlowMfaSession", "prepare BIDP callback success: scheme=" + r12.getScheme() + ", host=" + r12.getHost() + ", path=" + r12.getPath() + ", state saved");
        return;
    L63:
        if (r6 == false) goto L79;
        PassportLog.b("FlowMfaSession", "prepare BIDP callback failed: state is blank");
        return;
    L79:
        return;
    L58:
        if ((true ^ StringsKt.isBlank(r17)) == false) goto L61;
        r4 = r17;
        goto L61
    L60:
        r4 = r16;
    L53:
        r16 = null;
        goto L54
    L41:
        if ((!StringsKt.isBlank(r15)) == true) goto L44;
        r15 = null;
    L44:
        if (r15 == null) goto L47;
        r4 = r15;
        goto L61
    L32:
        if ((!StringsKt.isBlank(r13)) == true) goto L35;
        r13 = null;
    L35:
        if (r13 == null) goto L37;
        r14 = UriProtector.parse(r13);
        goto L38
    L65:
        if (r6 == false) goto L81;
        PassportLog.c("FlowMfaSession", "parse BIDP callback url failed", r9);
        return;
    L81:
        return;
    L25:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    L67:
        Set<String> r19 = wyb.a.b;
        if (wyb.a.C0203a.a(r10.getStepInfo()).a() == false) goto L83;
        PassportLog.b("FlowMfaSession", "prepare BIDP callback failed: auth url is blank");
        return;
    L83:
        return;
    L16:
        if (StringsKt.isBlank(r2) == true) goto L19;
        r3 = false;
        goto L21
    L8:
        if ((!StringsKt.isBlank(r2)) == false) goto L10;
    L13:
        r2 = null;
        goto L14
    }

    public final void u(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "stepInfo");
        final z r5 = D(r4);
        this.r.set(r5);
        this.s.set(Long.valueOf(System.currentTimeMillis()));
        PassportApmEvent.a.q(new FlowMfaFlowSession$reportBidpVerifyStart$1(r5));
    }

    public final void w(final FlowMfaError r3) {
        PassportApmEvent.a.q(new FlowMfaFlowSession$reportRuntimeAnomaly$1(this, r3));
    }

    public final void y(FlowStep r2) {
        Intrinsics.checkNotNullParameter(r2, "step");
        this.f.set(r2);
    }

    public final PassportRouterResult A(Activity r8, final FlowStep r9) {
        Intrinsics.checkNotNullParameter(r8, "activity");
        Intrinsics.checkNotNullParameter(r9, "step");
        final long r2 = System.currentTimeMillis();
        PassportApmEvent.a.q(new FlowMfaFlowSession$startStep$1(r9));
        com.ss.android.lark.passport.flow.core.router.a<m> r4 = l.a;
        Intrinsics.checkNotNullParameter(r8, "activity");
        Intrinsics.checkNotNullParameter(this, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r9, "step");
        com.ss.android.lark.passport.flow.core.router.a<m> r0 = l.a;
        String r1 = r9.getNextStep();
        m r5 = new m(r8, this, r9);
        r0.getClass();
        if (r1 != null) goto L5;
    L8:
        boolean r10 = true;
    L10:
        if (r10 == false) goto L13;
        final PassportRouterResult r11 = new PassportRouterResult(PassportRouterResult.Status.INVALID_NEXT_STEP, r1, null);
    L26:
        PassportApmEvent.a.q(new FlowMfaFlowSession$startStep$2$1(r11, r2, r9));
        if (r11.a() == true) goto L29;
        int r12 = g.a;
        w(g.e(r11.b));
    L29:
        return r11;
    L13:
        if (r0.b.contains(r1) == false) goto L15;
        r11 = new PassportRouterResult(PassportRouterResult.Status.TERMINAL, r1, null);
        goto L26
    L15:
        Iterator<T> r13 = r0.a.iterator();
    L17:
        if (r13.hasNext() == false) goto L21;
        Object r3 = r13.next();
        if (((syb.a) r3).b(r1, r5) == false) goto L17;
    L22:
        syb.a r6 = (syb.a) r3;
        if (r6 == null) goto L25;
        r6.a(r1, r5);
        r11 = new PassportRouterResult(PassportRouterResult.Status.DISPATCHED, r1, r6.getName());
        goto L26
    L25:
        r11 = new PassportRouterResult(PassportRouterResult.Status.UNSUPPORTED, r1, null);
        goto L26
    L21:
        r3 = null;
        goto L22
    L5:
        if (r1.length() == 0) goto L8;
        r10 = false;
        goto L10
    }

    public final Object b(y r9, Continuation<? super j> r10) {
        if ((r10 instanceof FlowMfaFlowSession$applyCode$1) == false) goto L7;
        FlowMfaFlowSession$applyCode$1 r0 = (FlowMfaFlowSession$applyCode$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        final boolean r4 = true;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        final long r5 = r0.J$0;
        final a0 r12 = (a0) r0.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L14
    L27:
        Object r13 = Result.constructor-impl((com.ss.android.lark.passport.flow.mfa.b) r11);     // Catch: Throwable -> L14
    L33:
        Throwable r6 = Result.exceptionOrNull-impl(r13);
        if (r6 != null) goto L36;
        PassportApmEvent.a.q(new FlowMfaFlowSession$reportChallengeResult$1(r12, r4, r5));
        return new j.a((com.ss.android.lark.passport.flow.mfa.b) r13);
    L36:
        PassportLog.e("FlowMfaSession", "apply MFA code failed: ".concat(r6.getClass().getSimpleName()));
        FlowMfaError r14 = C(r6);
        final boolean r7 = false;
        PassportApmEvent.a.q(new FlowMfaFlowSession$reportChallengeResult$1(r12, r7, r5));
        w(r14);
        return new j.c(r14, false);
    L14:
        Throwable th = th;
        long r8 = r5;
    L32:
        Result.Companion r15 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        r5 = r8;
        goto L33
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r11);
        if (q() == true) goto L21;
        final a0 r16 = E(r9);
        r8 = System.currentTimeMillis();
        PassportApmEvent.a.q(new FlowMfaFlowSession$reportChallengeStart$1(r16));
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L30
        FlowMfaRepository r18 = this.d;     // Catch: Throwable -> L30
        String r19 = this.b;     // Catch: Throwable -> L30
        r0.L$0 = r16;     // Catch: Throwable -> L30
        r0.J$0 = r8;     // Catch: Throwable -> L30
        r0.label = 1;     // Catch: Throwable -> L30
        Object r20 = r18.a(r19, r9, r0);     // Catch: Throwable -> L30
        if (r20 != r2) goto L26;
        return r2;
    L26:
        r5 = r8;
        r11 = r20;
        r12 = r16;
    L30:
        th = move-exception;
        th = th;
        r12 = r16;
        goto L32
    L21:
        return j.b.a;
    L7:
        r0 = new FlowMfaFlowSession$applyCode$1(this, r10);
        goto L8
    }

    public final void d(Activity r7, FlowMfaBidpWebActivityType r8) {
        Intrinsics.checkNotNullParameter(r8, "type");
        if (r7 != null) goto L5;
    L18:
        PassportLog.b("FlowMfaSession", "bind BIDP web activity failed: type=" + r8 + ", activity unavailable");
        return;
    L5:
        if (p(r7) == false) goto L18;
        AtomicBoolean r1 = k(r8);
        AtomicReference<WeakReference<Activity>> r2 = c(r8);
        if (r1.get() == false) goto L11;
        PassportLog.d("FlowMfaSession", "bind BIDP web activity after close requested: type=" + r8 + ", activity=" + r7.getClass().getSimpleName());
        j(r7);
        return;
    L11:
        r2.set(new WeakReference(r7));
        PassportLog.d("FlowMfaSession", "bind BIDP web activity success: type=" + r8 + ", activity=" + r7.getClass().getSimpleName());
        if (r1.get() == false) goto L20;
        PassportLog.d("FlowMfaSession", "close BIDP web activity after concurrent bind: type=" + r8);
        Activity r9 = null;
        WeakReference<Activity> r10 = r2.getAndSet(null);
        if (r10 == null) goto L16;
        r9 = r10.get();
    L16:
        j(r9);
        return;
    }

    public final void t(JSONObject r4, final boolean r5) {
        if (r4 == null) goto L4;
        final z r6 = D(r4);
    L5:
        final Long r0 = this.s.getAndSet(null);
        if (r0 != null) goto L8;
        return;
    L8:
        PassportApmEvent.a.q(new FlowMfaFlowSession$reportBidpVerifyResult$1(r6, r5, r0));
        return;
    L4:
        r6 = f();
        goto L5
    }

    public final void v(int r8, String r9) {
        Intrinsics.checkNotNullParameter("verify_list", "stepOrigin");
        FlowVerifyFactor.Companion.getClass();
        FlowVerifyFactor r10 = FlowVerifyFactor.a.a(r8);
        if (r10 != null) goto L5;
        return;
    L5:
        String r1 = r10.getWireKey();
        FlowStep r11 = g();
        if (r11 == null) goto L8;
        String r12 = r11.getNextStep();
    L9:
        final a0 r6 = new a0(r1, r9, r12, "verify_list", this.c);
        a0 r13 = this.t.getAndSet(r6);
        if (r13 != null) goto L12;
    L14:
        PassportApmEvent.a.q(new FlowMfaFlowSession$reportFactorEnter$1(r6));
        return;
    L12:
        if (Intrinsics.areEqual(r13.a, r6.a) == true) goto L14;
        PassportApmEvent.a.q(new FlowMfaFlowSession$reportFactorCancel$1(r13));
        goto L14
    L8:
        r12 = null;
        goto L9
    }

    public final void z(FlowStep r8, Activity r9) {
        Intrinsics.checkNotNullParameter(r8, "step");
        if (q() == false) goto L5;
        return;
    L5:
        y(r8);
        if (r9 != null) goto L8;
    L13:
        this.l.set(null);
    L14:
        BuildersKt.launch$default(this.h, null, null, new FlowMfaFlowSession$startBidpAuthUrlStep$1(this, r8, null), 3, null);
        return;
    L8:
        if ((r9 instanceof FlowMfaTransparentActivity) == true) goto L13;
        if (p(r9) == false) goto L13;
        this.l.set(new WeakReference(r9));
        goto L14
    }

    public final Object B(y r10, String r11, Continuation<? super j> r12) {
        if ((r12 instanceof FlowMfaFlowSession$submitFactor$1) == false) goto L7;
        FlowMfaFlowSession$submitFactor$1 r0 = (FlowMfaFlowSession$submitFactor$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L22;
        if (r3 == 1) goto L21;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        long r14 = r0.J$0;
        a0 r4 = (a0) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L69:
        j r15 = (j) r13;
        boolean r5 = r15 instanceof j.c;
        x(r4, !r5, r14);
        if (r5 == false) goto L77;
        w(((j.c) r15).a);
        return r15;
    L77:
        return r15;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r14 = r0.J$0;
        a0 r6 = (a0) r0.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L19
    L55:
        Object r16 = Result.constructor-impl((FlowStep) r13);     // Catch: Throwable -> L19
    L63:
        Throwable r7 = Result.exceptionOrNull-impl(r16);
        if (r7 != null) goto L72;
        r0.L$0 = r6;
        r0.J$0 = r14;
        r0.label = 3;
        r13 = o((FlowStep) r16);
        if (r13 != r2) goto L68;
        return r2;
    L68:
        r4 = r6;
        goto L69
    L72:
        PassportLog.e("FlowMfaSession", "submit MFA factor failed: ".concat(r7.getClass().getSimpleName()));
        FlowMfaError r17 = C(r7);
        x(r6, false, r14);
        w(r17);
        return new j.c(r17, false);
    L19:
        Throwable th = th;
        long r8 = r14;
    L62:
        Result.Companion r18 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        r14 = r8;
        goto L63
    L21:
        long r19 = r0.J$0;
        a0 r9 = (a0) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L40:
        j r20 = (j) r13;
        boolean r21 = r20 instanceof j.c;
        x(r9, !r21, r19);
        if (r21 == false) goto L43;
        w(((j.c) r20).a);
    L43:
        return r13;
    L22:
        ResultKt.throwOnFailure(r13);
        if (q() == true) goto L25;
        final a0 r110 = E(r10);
        r8 = System.currentTimeMillis();
        this.t.set(r110);
        PassportApmEvent.a.q(new FlowMfaFlowSession$reportVerifyStart$1(r110));
        FlowVerifyFactor r22 = r10.a;
        FlowVerifyFactor r23 = FlowVerifyFactor.BIDP;
        if (r22 != r23) goto L74;
        r0.L$0 = r110;
        r0.J$0 = r8;
        r0.label = 1;
        if (r22 == r23) goto L31;
        int r111 = g.a;
        FlowMfaError r112 = g.e(r22.getWireKey());
        h(r112);
        j r113 = new j.c(r112, true);
    L37:
        if (r113 != r2) goto L39;
        return r2;
    L39:
        r9 = r110;
        r13 = r113;
        r19 = r8;
        goto L40
    L31:
        FlowStep r114 = r10.j;
        if (r114 != null) goto L34;
    L36:
        r113 = o(new FlowStep("get_auth_url", r10.l, null));
        goto L37
    L34:
        if (r114.getStepInfo().isEmpty() == true) goto L36;
        r113 = o(r114);
        goto L37
    L74:
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L60
        switch(b.b[r22.ordinal()]) {
            case 1: goto L51;
            case 2: goto L51;
            case 3: goto L50;
            case 4: goto L47;
            case 5: goto L47;
            case 6: goto L47;
            default: goto L59;
        };     // Catch: Throwable -> L60
    L47:
        int r25 = g.a;     // Catch: Throwable -> L60
        throw new FlowMfaException(g.e(r10.a.getWireKey()));     // Catch: Throwable -> L60
    L51:
        FlowMfaRepository r26 = this.d;     // Catch: Throwable -> L60
        String r27 = this.b;     // Catch: Throwable -> L60
        r0.L$0 = r110;     // Catch: Throwable -> L60
        r0.J$0 = r8;     // Catch: Throwable -> L60
        r0.label = 2;     // Catch: Throwable -> L60
        Object r115 = r26.k(r27, r11, r10, r0);     // Catch: Throwable -> L60
        if (r115 != r2) goto L54;
        return r2;
    L54:
        r6 = r110;
        r13 = r115;
        r14 = r8;
        goto L55
    L59:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L60
    L50:
        throw new IllegalStateException("BIDP is handled before submit".toString());     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        r6 = r110;
        th = th;
        goto L62
    L25:
        return j.b.a;
    L7:
        r0 = new FlowMfaFlowSession$submitFactor$1(this, r12);
        goto L8
    }

    public final void x(final a0 r3, final boolean r4, final long r5) {
        PassportApmEvent.a.q(new FlowMfaFlowSession$reportVerifyResult$1(r3, r4, r5));
        if (r4 == false) goto L10;
        AtomicReference<a0> r6 = this.t;
    L6:
        if (r6.compareAndSet(r3, null) == true) goto L14;
        if (r6.get() == r3) goto L6;
        return;
    L14:
        return;
    }

    public FlowMfaFlowSession(String r3, String r4, String r5, FlowMfaRepository r6) {
        Intrinsics.checkNotNullParameter(r3, "flowId");
        Intrinsics.checkNotNullParameter(r4, "userId");
        Intrinsics.checkNotNullParameter(r5, "scope");
        Intrinsics.checkNotNullParameter(r6, "repository");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.f = new AtomicReference();
        this.g = new AtomicBoolean(false);
        this.h = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.i = new AtomicReference();
        this.j = new AtomicReference();
        this.k = new AtomicReference();
        this.l = new AtomicReference();
        this.m = new AtomicReference();
        this.n = new AtomicReference();
        this.o = new AtomicReference();
        this.p = new AtomicBoolean(false);
        this.q = new AtomicBoolean(false);
        this.r = new AtomicReference();
        this.s = new AtomicReference();
        this.t = new AtomicReference();
        this.u = new AtomicReference();
        this.v = new AtomicReference(new com.ss.android.lark.passport.flow.mfa.a(ExternalBidpCallbackPhase.IDLE, 0));
        this.w = new d(this);
    }

    public static final Object a(FlowMfaFlowSession r9, JSONObject r10, boolean r11, Continuation r12) {
        r9.getClass();
        if ((r12 instanceof FlowMfaFlowSession$fetchBidpAuthUrl$1) == false) goto L7;
        FlowMfaFlowSession$fetchBidpAuthUrl$1 r0 = (FlowMfaFlowSession$fetchBidpAuthUrl$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        final long r14 = r0.J$0;
        final z r4 = (z) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L37:
        j r5 = (j) r13;
        boolean r15 = r5 instanceof j.c;
        final boolean r6 = !r15;
        PassportApmEvent.a.q(new FlowMfaFlowSession$reportBidpPrepareResult$1(r4, r6, r14));
        if (r15 == false) goto L50;
        r9.w(((j.c) r5).a);
        return r5;
    L50:
        return r5;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r14 = r0.J$0;
        boolean r7 = r0.Z$0;
        final z r8 = (z) r0.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L18
    L25:
        Object r16 = Result.constructor-impl((FlowStep) r13);     // Catch: Throwable -> L18
    L31:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 != null) goto L40;
        r0.L$0 = r8;
        r0.J$0 = r14;
        r0.label = 2;
        r13 = r9.o((FlowStep) r16);
        if (r13 == r2) goto L53;
        r4 = r8;
        goto L37
    L53:
        return r2;
    L40:
        PassportLog.e("FlowMfaSession", "fetch BIDP auth url failed: ".concat(r17.getClass().getSimpleName()));
        r9.k.set(null);
        FlowMfaError r18 = C(r17);
        final boolean r19 = false;
        PassportApmEvent.a.q(new FlowMfaFlowSession$reportBidpPrepareResult$1(r8, r19, r14));
        if (r7 == false) goto L43;
        r9.h(r18);
        r9.l();
    L45:
        return new j.c(r18, r7);
    L43:
        r9.w(r18);
    L18:
        Throwable th = th;
        long r20 = r14;
        r11 = r7;
    L30:
        Result.Companion r110 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        r7 = r11;
        r14 = r20;
        goto L31
    L20:
        ResultKt.throwOnFailure(r13);
        byte[] r111 = new byte[32];
        k.a.nextBytes(r111);
        String r112 = Base64.encodeToString(r111, 11);
        MessageDigest r21 = MessageDigest.getInstance("SHA-256");
        Intrinsics.checkNotNull(r112);
        String r22 = Base64.encodeToString(r21.digest(r112.getBytes(Charsets.US_ASCII)), 11);
        Intrinsics.checkNotNull(r22);
        Intrinsics.checkNotNullParameter(r112, "verifier");
        Intrinsics.checkNotNullParameter(r22, "challenge");
        r9.k.set(r112);
        final z r113 = D(r10);
        r9.r.set(r113);
        r20 = System.currentTimeMillis();
        PassportApmEvent.a.q(new FlowMfaFlowSession$reportBidpPrepareStart$1(r113));
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L28
        FlowMfaRepository r24 = r9.d;     // Catch: Throwable -> L28
        String r25 = r9.b;     // Catch: Throwable -> L28
        r0.L$0 = r113;     // Catch: Throwable -> L28
        r0.Z$0 = r11;     // Catch: Throwable -> L28
        r0.J$0 = r20;     // Catch: Throwable -> L28
        r0.label = 1;     // Catch: Throwable -> L28
        Object r114 = r24.g(r25, r10, r22, r0);     // Catch: Throwable -> L28
        if (r114 == r2) goto L52;
        r7 = r11;
        r8 = r113;
        r13 = r114;
        r14 = r20;
        goto L25
    L52:
        return r2;
    L28:
        th = move-exception;
        r8 = r113;
        th = th;
    L7:
        r0 = new FlowMfaFlowSession$fetchBidpAuthUrl$1(r9, r12);
        goto L8
    }

    public final boolean n(FlowIdpLoginResult r20, Activity r21, FlowMfaBidpWebActivityType r22, String r23) {
        PassportLog.d("FlowMfaSession", "handle BIDP login result start: source=" + r23 + ", code=" + r20.getCode());
        boolean r3 = false;
        if (q() == false) goto L6;
        PassportLog.b("FlowMfaSession", "handle BIDP login result failed: source=" + r23 + ", session is terminal");
        return false;
    L6:
        if (r21 == null) goto L9;
        d(r21, r22);
    L9:
        if (r20.getCode() == 0) goto L19;
        FlowMfaErrorCategory r11 = FlowMfaErrorCategory.SERVER;
        String r0 = r20.getMessage();
        if (r0 != null) goto L13;
    L17:
        r0 = "BIDP login result failed";
    L18:
        FlowMfaError r1 = new FlowMfaError(r11, r0, null, null, Integer.valueOf(r20.getCode()), r20.getLogId(), 12, null);
    L40:
        if (r1 == null) goto L43;
        PassportLog.b("FlowMfaSession", "validate BIDP login result failed: source=" + r23 + ", category=" + r1.getCategory() + ", serverCode=" + r1.getServerCode());
        t(null, false);
        h(r1);
        m(r22);
        r(new j.c(r1, true));
        return true;
    L43:
        t(null, true);
        String r2 = r20.getState();
        if (r2 != null) goto L46;
        r2 = "";
    L46:
        String r4 = r2;
        String r5 = this.k.getAndSet(null);
        String r6 = this.j.get();
        if (r6 != null) goto L49;
    L52:
        boolean r7 = true;
    L53:
        this.j.set(null);
        StringBuilder r8 = new StringBuilder("validate BIDP login result success: source=");
        r8.append(r23);
        r8.append(", hasExpectedState=");
        r8.append(!r7);
        r8.append(", hasCodeVerifier=");
        if (r5 == null) goto L56;
        r3 = true;
    L56:
        r8.append(r3);
        PassportLog.d("FlowMfaSession", r8.toString());
        BuildersKt.launch$default(this.h, null, null, new FlowMfaFlowSession$handleBidpLoginResultInternal$1(this, r23, r4, r5, null), 3, null);
        PassportLog.d("FlowMfaSession", "BIDP login result accepted for dispatch: source=".concat(r23));
        return true;
    L49:
        if (StringsKt.isBlank(r6) == true) goto L52;
        r7 = false;
        goto L53
    L13:
        if ((!StringsKt.isBlank(r0)) == true) goto L16;
        r0 = null;
    L16:
        if (r0 != null) goto L18;
    L19:
        String r9 = r20.getState();
        if (r9 != null) goto L22;
    L25:
        boolean r10 = true;
    L26:
        if (r10 == false) goto L28;
        r1 = g.b("BIDP login result state is empty", null);
        goto L40
    L28:
        String r12 = this.j.get();
        if (r12 != null) goto L31;
    L34:
        boolean r13 = true;
    L35:
        if (r13 == false) goto L37;
    L39:
        r1 = null;
        goto L40
    L37:
        if (Intrinsics.areEqual(r12, r9) == true) goto L39;
        r1 = g.b("BIDP login result state mismatch", null);
        goto L40
    L31:
        if (StringsKt.isBlank(r12) == true) goto L34;
        r13 = false;
        goto L35
    L22:
        if (StringsKt.isBlank(r9) == true) goto L25;
        r10 = false;
        goto L26
    }
}
