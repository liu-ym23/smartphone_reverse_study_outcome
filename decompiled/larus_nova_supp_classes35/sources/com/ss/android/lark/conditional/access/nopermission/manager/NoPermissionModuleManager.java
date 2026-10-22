package com.ss.android.lark.conditional.access.nopermission.manager;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionActivity;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.conditional.access.utils.NoPermissionType;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.LarkContext;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Singleton
public final class NoPermissionModuleManager {
    public final com.ss.android.lark.security.compliance.infra.network.userscpoe.a a;
    public final com.ss.android.lark.passportc.api.j b;
    public final k8b.c c;
    public final AtomicReference<NoPermissionType> d;
    public Bundle e;
    public String f;
    public boolean g;
    public volatile boolean h;
    public WeakReference<Activity> i;
    public String j;
    public final MutableLiveData<Boolean> k;
    public final CopyOnWriteArrayList<b> l;
    public final HashMap<String, n4c.a> m;
    public boolean n;
    public final c o;
    public Handler p;
    public final d q;

    public static final class a {
    }

    public static final class b {
        public final qnc.e a;
        public final qnc.b b;
        public final qnc.c.a c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "PendingNavRequest(source=" + this.a + ", request=" + this.b + ", chain=" + this.c + ')';
        }

        public b(qnc.e r2, qnc.b r3, qnc.c.a r4) {
            Intrinsics.checkNotNullParameter(r2, "source");
            Intrinsics.checkNotNullParameter(r3, "request");
            Intrinsics.checkNotNullParameter(r4, "chain");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class c implements qnc.g {
        public final /* synthetic */ NoPermissionModuleManager a;

        public c(NoPermissionModuleManager r1) {
            this.a = r1;
        }

        public final boolean a(qnc.e r1, qnc.a r2, qnc.d r3) {
            return qnc.g.a.a(r1, r2, r3);
        }

        public final void b(qnc.e r4, qnc.b r5, qnc.d r6) {
            Intrinsics.checkNotNullParameter(r4, "source");
            Intrinsics.checkNotNullParameter(r5, "request");
            Intrinsics.checkNotNullParameter(r6, "chain");
            int r0 = ScsLogger.a;
            StringBuilder r1 = new StringBuilder("interceptNavigate ");
            r1.append(r5.a);
            r1.append(", hasArgs=");
            if (r5.b == null) goto L5;
            boolean r2 = true;
        L6:
            r1.append(r2);
            ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", r1.toString());
            NoPermissionModuleManager.d(this.a, true, r4, r5, r6);
            return;
        L5:
            r2 = false;
            goto L6
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ NoPermissionModuleManager a;

        public d(NoPermissionModuleManager r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ScsLogger.e("SecurityPolicy_NoPermissionModuleManager", "CALL ACTIVITY FAILED, RELEASE");     // Catch: Throwable -> L4
            this.a.i();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void f() {
        int r0 = ScsLogger.a;
        StringBuilder r1 = new StringBuilder("gotoCurrentNoPermissionActivity, type: ");
        NoPermissionType r2 = this.d.get();
        if (r2 == null) goto L5;
        String r3 = r2.name();
    L6:
        r1.append(r3);
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", r1.toString());
        NoPermissionType r4 = this.d.get();
        if (r4 == null) goto L28;
        UserSession r5 = this.b.b();
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "[start show page], realGotoNoPermissionActivity, type:" + r4);
        Handler r6 = this.p;
        if (r6 == null) goto L11;
        r6.removeCallbacks(this.q);
    L11:
        this.p = null;
        if (r5 != null) goto L14;
        ScsLogger.c("SecurityPolicy_NoPermissionModuleManager", "realGotoNoPermissionActivity, userSession is null!");
        FileAuthMonitor.o("RESPONSE_HEADER", BuildConfig.FLAVOR, "userSessionNull");
        FileAuthMonitor.AccessControlScene r7 = FileAuthMonitor.AccessControlScene.OpenNoPermissionPage;
        Intrinsics.checkNotNullParameter(r7, "scene");
        String r8 = u4c.a.a;
        u4c.a.a("scs_security_policy_usersession_null", MapsKt.mapOf(TuplesKt.to("scene", r7.name())), null, null, 0, 28);
        i();
        this.k.postValue(Boolean.FALSE);
        return;
    L14:
        Activity r9 = AppLifecycle.a.a.f();
        if (r9 != null) goto L18;
    L19:
        boolean r10 = false;
    L21:
        if (r10 == true) goto L30;
        Handler r11 = new Handler(Looper.getMainLooper());
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "setup timer");
        r11.postDelayed(this.q, 5000);
        this.p = r11;
        Application r12 = LarkContext.getApplication();
        int r13 = NoPermissionActivity.n;
        Intrinsics.checkNotNull(r12);
        Bundle r14 = this.e;
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r4, "noPermissionType");
        Intrinsics.checkNotNullParameter(r14, "extra");
        Intrinsics.checkNotNullParameter(r5, "userSession");
        ScsLogger.d("SecurityPolicy_NoPermissionActivity", "startUi: extra: " + r14 + ", type: " + r4.getValue());
        Intent r15 = new Intent(r12, NoPermissionActivity.class);
        PassportcConvention.g(r15, r5);
        r15.putExtra("unauthorized_type", r4.getValue());
        r15.putExtra("biz_extra", r14);
        if ((r12 instanceof Activity) == true) goto L26;
        r15.addFlags(268435456);
    L26:
        r15.putExtra("can_be_covered", false);
        r12.startActivity(r15);
        FileAuthMonitor.UpdateTrigger[] r16 = FileAuthMonitor.a;
        FileAuthMonitor.b(FileAuthMonitor.AccessControlScene.OpenNoPermissionPage);
        return;
    L30:
        return;
    L18:
        if (h(r9) == false) goto L19;
        r10 = true;
        this.h = true;
        this.i = new WeakReference(r9);
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "defer no permission activity for protected oauth web container");
        goto L21
    L28:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void g() {
        BuildersKt.launch$default(com.ss.android.lark.security.compliance.infra.base.a.a, null, null, new NoPermissionModuleManager$handleNoPermissionAction$1(this, null), 3, null);
    }

    public final void i() {
        BuildersKt.launch$default(com.ss.android.lark.security.compliance.infra.base.a.a, null, null, new NoPermissionModuleManager$release$1(this, null), 3, null);
    }

    public final void j() {
        i();
        BuildersKt.launch$default(com.ss.android.lark.security.compliance.infra.base.a.a, null, null, new NoPermissionModuleManager$releaseOnLogout$1(null), 3, null);
    }

    public static final void b(NoPermissionModuleManager r3) {
        String r0 = com.ss.android.lark.security.compliance.infra.util.f.c((InternalSecurityAction) r3.e.getParcelable("param_action"));     // Catch: Exception -> L4
    L5:
        n4c.a r1 = r3.m.get(r3.j);
        if (r1 == null) goto L11;
        NoPermissionType r2 = r3.d.get();
        if (r2 == null) goto L10;
        r2.name();
    L10:
        Intrinsics.checkNotNull(r0);
        r1.b();
        Unit r4 = Unit.INSTANCE;
    L12:
        if (r4 != null) goto L14;
        int r5 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "currentInterceptor " + r3.j + " not found, default handle");
        r3.f();
        return;
    L14:
        r3.k.postValue(Boolean.FALSE);
        return;
    L11:
        r4 = null;
    L4:
        r0 = BuildConfig.FLAVOR;
        goto L5
    }

    public static final String c(NoPermissionModuleManager r4) {
        int r0 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "searchInterceptor, currentInterceptor: " + r4.j);
        if (r4.j.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        String r5 = r4.j;
    L16:
        int r2 = ScsLogger.a;
        StringBuilder r3 = new StringBuilder("searchInterceptor, destInterceptor: ");
        String r6 = r5;
        r3.append(r6);
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", r3.toString());
        return r6;
    L8:
        Iterator<Map.Entry<String, n4c.a>> r7 = r4.m.entrySet().iterator();
    L10:
        if (r7.hasNext() == false) goto L15;
        Map.Entry<String, n4c.a> r8 = r7.next();
        if (r8.getValue().a() == true) goto L13;
        int r9 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "biz: " + r8.getValue().getBizName() + ", need: false");
        goto L10
    L13:
        int r10 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "biz: " + r8.getValue().getBizName() + ", need: true");
        r5 = r8.getKey();
        goto L16
    L15:
        r5 = "scs_interceptor";
        goto L16
    L5:
        r1 = false;
        goto L6
    }

    public final void e(String r2) {
        if (this.h == false) goto L5;
    L6:
        int r0 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "clear deferred no permission activity, reason=".concat(r2));
    L7:
        this.h = false;
        this.i = null;
        return;
    L5:
        if (this.i == null) goto L7;
        goto L6
    }

    public final boolean h(Activity r4) {
        if (this.c.n(r4) == false) goto L13;
        Intent r5 = r4.getIntent();
        if (r5 != null) goto L7;
    L9:
        boolean r6 = false;
    L10:
        if (r6 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r5.getBooleanExtra("can_be_covered", true) == true) goto L9;
        r6 = true;
        goto L10
    L13:
        return false;
    }

    public final boolean k(NoPermissionType r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r12, "noPermissionType");
        Intrinsics.checkNotNullParameter(r13, "extra");
        int r0 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "setCurrentNoPermissionType: enter, type=" + r12.name() + ", mainPageStack=0, hasAction=" + r13.containsKey("param_action"));
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == true) goto L9;
        ScsLogger.e("SecurityPolicy_NoPermissionModuleManager", "setCurrentUnauthorizedType fail, mainPageLaunchedInStack: 0");
        if (this.d.get() != null) goto L11;
        ScsLogger.e("SecurityPolicy_NoPermissionModuleManager", "_isProcessingNoPermission set true");
        this.k.postValue(Boolean.TRUE);
        return false;
    L11:
        return false;
    L9:
        BuildersKt.launch$default(com.ss.android.lark.security.compliance.infra.base.a.a, null, null, new NoPermissionModuleManager$setCurrentNoPermissionType$1(this, r12, r13, qqb.a.d(), null), 3, null);
        return true;
    }

    public final void l(String r4, Activity r5) {
        if (this.h == true) goto L6;
        return;
    L6:
        if (this.d.get() != null) goto L8;
    L23:
        e("invalid_no_permission_state");
        return;
    L8:
        if (this.g == true) goto L23;
        AppLifecycle r0 = AppLifecycle.a.a;
        Activity r1 = r0.f();
        if (r1 == null) goto L18;
        if (r1 == r5) goto L18;
        if (h(r1) == false) goto L18;
        this.i = new WeakReference(r1);
        int r6 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "deferred no permission still waits protected oauth, reason=".concat(r4));
        return;
    L18:
        if (r0.h() == true) goto L21;
        int r7 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "deferred no permission waits app foreground, reason=".concat(r4));
        return;
    L21:
        this.h = false;
        this.i = null;
        int r8 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "resume deferred no permission activity, reason=".concat(r4));
        f();
    }

    @Inject
    public NoPermissionModuleManager(com.ss.android.lark.security.compliance.infra.network.userscpoe.a r2, com.ss.android.lark.passportc.api.j r3, k8b.c r4) {
        Intrinsics.checkNotNullParameter(r2, "scRequest");
        Intrinsics.checkNotNullParameter(r3, "passport");
        Intrinsics.checkNotNullParameter(r4, "conditionalAccessDependency");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = new AtomicReference();
        this.e = new Bundle();
        this.f = BuildConfig.FLAVOR;
        this.j = BuildConfig.FLAVOR;
        this.k = new MutableLiveData();
        this.l = new CopyOnWriteArrayList();
        this.m = new HashMap();
        this.n = true;
        this.o = new c(this);
        this.q = new d(this);
    }

    public static final boolean a(NoPermissionModuleManager r1, Activity r2, String r3) {
        if (r1.h(r2) == true) goto L5;
        return false;
    L5:
        r1.i = new WeakReference(r2);
        int r4 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "protected oauth web container bound, scene=".concat(r3));
        return true;
    }

    public static final void d(NoPermissionModuleManager r7, boolean r8, qnc.e r9, qnc.b r10, qnc.c.a r11) {
        r7.getClass();
        List r0 = w4c.c.a().w0();
        String r3 = null;
        if (Intrinsics.areEqual(r10.a, "webview_activity") == true) goto L5;
    L47:
        if (r3 == null) goto L61;
        Bundle r1 = r10.b;
        if (r1 == null) goto L51;
        r1.putBoolean("can_be_covered", false);
    L51:
        int r2 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "mark protected oauth web route, identity: ".concat(r3));
        if (r8 == false) goto L57;
        if (r7.n == false) goto L57;
        new Handler(Looper.getMainLooper()).postDelayed(new i(r7, r9, r10, r11), 200);
    L60:
        r7.n = false;
        return;
    L57:
        if (Intrinsics.areEqual(r7.k.getValue(), Boolean.TRUE) == false) goto L59;
        r7.l.add(new b(r9, r10, r11));
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "pendingNavRequests " + r7.l.size() + ", identity: " + r3);
        goto L60
    L59:
        r11.a(r9, r10);
        goto L60
    L61:
        r11.a(r9, r10);
        return;
    L5:
        if (r0.isEmpty() == true) goto L47;
        Bundle r4 = r10.b;
        if (r4 == null) goto L47;
        String r5 = r4.getString(ChameleonOpenTracker.ParamKey.APP_ID);
        boolean r6 = true;
        if (r5 != null) goto L13;
    L16:
        boolean r12 = true;
    L17:
        if (r12 == false) goto L19;
    L21:
        String r13 = r4.getString("url");
        if (r13 != null) goto L25;
        r13 = BuildConfig.FLAVOR;
    L25:
        if (r13.length() != 0) goto L27;
        boolean r14 = true;
    L28:
        if (r14 == true) goto L47;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L32
        Object r16 = Result.constructor-impl(UriProtector.getQueryParameter(UriProtector.parse(r13), "client_id"));     // Catch: Throwable -> L32
    L35:
        if (Result.isFailure-impl(r16) == false) goto L37;
        r16 = null;
    L37:
        String r17 = (String) r16;
        if (r17 != null) goto L40;
    L43:
        if (r6 == true) goto L47;
        if (r0.contains(r17) == false) goto L47;
        r3 = "client_id=" + r17;
        goto L47
    L40:
        if (r17.length() == 0) goto L43;
        r6 = false;
    L32:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L35
    L27:
        r14 = false;
        goto L28
    L19:
        if (r0.contains(r5) == false) goto L21;
        r3 = "app_id=" + r5;
        goto L47
    L13:
        if (r5.length() == 0) goto L16;
        r12 = false;
        goto L17
    }
}
