package com.ss.android.lark.conditional.access.auth.v2;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import androidx.core.content.ContextCompat;
import com.bytedance.lark.policy.decision.PolicyDecision;
import com.bytedance.lark.policy.event.Event;
import com.bytedance.lark.policy.event.EventManager;
import com.bytedance.lark.policy.model.ValidateRequest;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.conditional.access.auth.v2.handler.RefreshNotifyHandler;
import com.ss.android.lark.conditional.access.auth.v2.service.DeviceControlService;
import com.ss.android.lark.conditional.access.auth.v2.service.PolicyValidateService;
import com.ss.android.lark.conditional.access.auth.v2.service.SecurityLabelControlService;
import com.ss.android.lark.conditional.access.network.easynetwork.EasyNetworkState;
import com.ss.android.lark.conditional.access.network.easynetwork.EasyNetworkType;
import com.ss.android.lark.conditional.access.network.easynetwork.NetworkTypeDetector;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.security.compliance.api.model.filepolicy.CCMFileEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.CalendarFileEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.VCFileEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResultSource;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.LarkContext;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class SecurityPolicyAuthManager implements i8b.q {
    public static final /* synthetic */ int x = 0;
    public boolean a;
    public String b;
    public String c;
    public Context d;
    public final b e;
    public boolean f;
    public EasyNetworkState g;
    public final c h;
    public final Lazy<Handler> i;
    public final com.ss.android.lark.conditional.access.auth.v2.service.m j;
    public final com.ss.android.lark.conditional.access.auth.v2.service.a k;
    public final DeviceControlService l;
    public final SecurityLabelControlService m;
    public final com.ss.android.lark.conditional.access.auth.v2.service.f n;
    public final Lazy o;
    public final PolicyValidateService p;
    public final com.ss.android.lark.conditional.access.auth.v2.service.d q;
    public final com.ss.android.lark.conditional.access.auth.v2.handler.b r;
    public final com.ss.android.lark.conditional.access.auth.v2.handler.f s;
    public boolean t;
    public final d u;
    public final Lazy v;
    public final ArrayList<i8b.a> w;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.appcontext.applifecycle.y {
        public final /* synthetic */ SecurityPolicyAuthManager a;

        public b(SecurityPolicyAuthManager r1) {
            this.a = r1;
        }

        public final void f(com.ss.android.lark.appcontext.applifecycle.y.a r4, com.ss.android.lark.appcontext.applifecycle.y.a r5) {
            Intrinsics.checkNotNullParameter(r4, "oldState");
            Intrinsics.checkNotNullParameter(r5, "newState");
            if (r4.c == true) goto L16;
            boolean r6 = r5.c;
            if (r6 == false) goto L17;
            SecurityPolicyAuthManager r7 = this.a;
            Context r0 = r7.d;
            if (r0 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("context");
            r0 = null;
        L9:
            EasyNetworkState r1 = NetworkTypeDetector.a(r0);
            if (r6 == true) goto L12;
            return;
        L12:
            if (r7.g.sameAs(r1) == true) goto L14;
            ArrayList<String> r8 = com.ss.android.lark.conditional.access.utils.c.a;
            com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_SecurityPolicyAuthManager", "Back to front, and network state changed", true);
            r7.g = new EasyNetworkState(r1.getEasyNetworkType(), r1.getNetworkId());
            r7.c(new i8b.r(FileAuthMonitor.UpdateTrigger.NetworkChange));
        L14:
            r7.k(FileAuthMonitor.UpdateTrigger.BackToFront);
            return;
        L17:
            return;
        }
    }

    public static final class c implements l8b.a {
        public final /* synthetic */ SecurityPolicyAuthManager a;

        public c(SecurityPolicyAuthManager r1) {
            this.a = r1;
        }

        @Override // l8b.a
        public final void a(EasyNetworkState r4) {
            if (this.a.a == false) goto L6;
            SecurityPolicyAuthManager r0 = this.a;
            Intrinsics.checkNotNull(r4);
            r0.getClass();
            Intrinsics.checkNotNullParameter(r4, "networkState");
            r0.g = r4;
            ArrayList<String> r1 = com.ss.android.lark.conditional.access.utils.c.a;
            com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_SecurityPolicyAuthManager", "[onNetTypeChanged] currNetworkState = " + r4, false);
            Event r5 = Event.EVENT_NETWORK_CHANGE;
            ke6.d r2 = ke6.d.a;
            Intrinsics.checkNotNullParameter(r5, "event");
            EventManager.a(r5);
            r0.c(new i8b.r(FileAuthMonitor.UpdateTrigger.NetworkChange));
            return;
        }
    }

    public static final class d implements jdb.c {
        public final /* synthetic */ SecurityPolicyAuthManager a;

        public d(SecurityPolicyAuthManager r1) {
            this.a = r1;
        }

        @Override // jdb.c
        public final void a(boolean r2) {
            if (r2 == false) goto L7;
            SecurityPolicyAuthManager r3 = this.a;
            if (r3.t == true) goto L8;
            r3.k(FileAuthMonitor.UpdateTrigger.UIdChange);
            this.a.n();
            return;
        L8:
            return;
        }
    }

    static {
    }

    @Override // i8b.q
    public final Map<String, com.ss.android.lark.conditional.access.auth.v2.service.i> i() {
        return this.n.d;
    }

    public final void l() {
        RefreshNotifyHandler.b.clear();
        RefreshNotifyHandler.c.clear();
        Handler r0 = com.ss.android.lark.conditional.access.auth.v2.handler.a.b;
        if (r0 == null) goto L5;
        r0.removeCallbacksAndMessages(null);
    L5:
        ((LinkedHashMap) com.ss.android.lark.conditional.access.auth.v2.handler.a.c).clear();
        com.ss.android.lark.conditional.access.auth.v2.handler.b r1 = this.r;
        Handler r2 = r1.b;
        if (r2 == null) goto L8;
        r2.removeCallbacksAndMessages(null);
    L8:
        ((LinkedHashMap) r1.c).clear();
        if (this.i.isInitialized() == false) goto L11;
        ((Handler) this.i.getValue()).removeCallbacksAndMessages(null);
    L11:
        Iterator<T> r3 = this.w.iterator();
    L13:
        if (r3.hasNext() == false) goto L16;
        ((i8b.a) r3.next()).a();
        goto L13
    L16:
        if (this.t == false) goto L20;
        idb.f.a().removeFeatureGatingUpdateListener(this.u, "_normal_fg");
        this.f = false;
        c r4 = this.h;
        NetworkTypeDetector.b.remove(r4);
        AppLifecycle r5 = AppLifecycle.a.a;
        b r6 = this.e;
        r5.h.remove(r6);
        com.bytedance.lark.policy.event.a r7 = (com.bytedance.lark.policy.event.a) this.v.getValue();
        ke6.d r8 = ke6.d.a;
        Intrinsics.checkNotNullParameter(r7, "observer");
        CopyOnWriteArraySet r9 = EventManager.a;
        Intrinsics.checkNotNullParameter(r7, "eventObserver");
        EventManager.a.remove(r7);
        this.t = false;
        return;
    }

    public final void m() {
        qqb.a.h("onUserIdChanged");     // Catch: Throwable -> L30
        this.b = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).d();     // Catch: Throwable -> L30
        User r0 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();     // Catch: Throwable -> L30
        if (r0 == null) goto L7;
        String r1 = r0.getTenantId();     // Catch: Throwable -> L30
        if (r1 == null) goto L7;
    L8:
        this.c = r1;     // Catch: Throwable -> L30
        l();     // Catch: Throwable -> L30
        com.ss.android.lark.storage.kv.repo.a r2 = y.a;     // Catch: Throwable -> L30
        y.c();     // Catch: Throwable -> L30
        if (this.b.length() != 0) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == false) goto L16;
        qqb.a.a();
        return;
    L16:
        z r4 = z.a;     // Catch: Throwable -> L30
        long r5 = System.currentTimeMillis();     // Catch: Throwable -> L30
        r4.getClass();     // Catch: Throwable -> L30
        z.b = r5;     // Catch: Throwable -> L30
        ArrayList<String> r6 = com.ss.android.lark.conditional.access.utils.c.a;     // Catch: Throwable -> L30
        com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_SecurityPolicyAuthManager", "User info changed", false);     // Catch: Throwable -> L30
        Iterator<T> r7 = this.w.iterator();     // Catch: Throwable -> L30
    L18:
        if (r7.hasNext() == false) goto L21;
        ((i8b.a) r7.next()).d(this.b, this.c);     // Catch: Throwable -> L30
        goto L18
    L21:
        if (this.t == true) goto L24;
        idb.f.a().addFeatureGatingUpdateListener("lark.security.file_protection_client", this.u, "_normal_fg");     // Catch: Throwable -> L30
    L24:
        if (com.ss.android.lark.conditional.access.utils.f.a() == true) goto L26;
    L28:
        qqb.a.a();
        return;
    L26:
        if (this.t == true) goto L28;
        n();     // Catch: Throwable -> L30
        goto L28
    L12:
        r3 = false;
    L7:
        r1 = BuildConfig.FLAVOR;
    L30:
        th = move-exception;
        qqb.a.a();
        throw th;
    }

    public final void n() {
        AppLifecycle.a.a.c(this.e);
        if (this.f == true) goto L41;
        this.f = true;
        NetworkTypeDetector.b.add(this.h);
        Context r0 = this.d;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        r0 = null;
    L8:
        if (NetworkTypeDetector.a != null) goto L10;
        NetworkTypeDetector.a = new NetworkTypeDetector();
    L10:
        NetworkTypeDetector.e = NetworkTypeDetector.a(r0);
        IntentFilter r10 = new IntentFilter();
        r10.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        NetworkTypeDetector r11 = NetworkTypeDetector.a;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L44;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L44:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L40;
        ReceiverRegisterCrashOptimizer.registerReceiver(r11, r10);
        goto L41
    L40:
        throw e;
    L14:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L27;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L27;
        int r2 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r11, r10, 0, null, null, 2, r0).result;     // Catch: Exception -> L36
        if (r2 != 1) goto L20;
        r0.registerReceiver(r11, r10);     // Catch: Exception -> L36
    L43:
        goto L41
    L20:
        if (r2 != 2) goto L22;
        new Intent();     // Catch: Exception -> L36
        goto L43
    L22:
        if (r2 == 3) goto L43;
        r0.registerReceiver(r11, r10);     // Catch: Exception -> L36
    L27:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L30;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        r0.registerReceiver(r11, r10, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L36
        goto L43
    L30:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L32;
    L34:
        r0.registerReceiver(r11, r10);     // Catch: Exception -> L36
        goto L43
    L32:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L34;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        ContextCompat.registerReceiver(r0, r11, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L36
    L41:
        com.bytedance.lark.policy.event.a r1 = (com.bytedance.lark.policy.event.a) this.v.getValue();
        ke6.d r3 = ke6.d.a;
        Intrinsics.checkNotNullParameter(r1, "observer");
        CopyOnWriteArraySet r4 = EventManager.a;
        Intrinsics.checkNotNullParameter(r1, "eventObserver");
        EventManager.a.add(r1);
        this.t = true;
    }

    public SecurityPolicyAuthManager() {
        this.b = BuildConfig.FLAVOR;
        this.c = BuildConfig.FLAVOR;
        this.e = new b(this);
        this.g = new EasyNetworkState(EasyNetworkType.NO_INTERNET_CONNECTION, "1");
        this.h = new c(this);
        Lazy<Handler> r0 = LazyKt.lazy(SecurityPolicyAuthManager$timerHandler$1.INSTANCE);
        this.i = r0;
        com.ss.android.lark.conditional.access.auth.v2.service.m r1 = new com.ss.android.lark.conditional.access.auth.v2.service.m(this);
        this.j = r1;
        com.ss.android.lark.conditional.access.auth.v2.service.a r2 = new com.ss.android.lark.conditional.access.auth.v2.service.a(this);
        this.k = r2;
        com.ss.android.lark.conditional.access.auth.v2.service.j r3 = new com.ss.android.lark.conditional.access.auth.v2.service.j(this);
        DeviceControlService r4 = new DeviceControlService(this);
        this.l = r4;
        com.ss.android.lark.conditional.access.auth.v2.service.e r5 = new com.ss.android.lark.conditional.access.auth.v2.service.e(this);
        SecurityLabelControlService r6 = new SecurityLabelControlService(this);
        this.m = r6;
        com.ss.android.lark.conditional.access.auth.v2.service.f r7 = new com.ss.android.lark.conditional.access.auth.v2.service.f(this);
        this.n = r7;
        Lazy r8 = LazyKt.lazy(new SecurityPolicyAuthManager$mCacheService$2(this));
        this.o = r8;
        PolicyValidateService r9 = new PolicyValidateService(this);
        this.p = r9;
        com.ss.android.lark.conditional.access.auth.v2.service.d r10 = new com.ss.android.lark.conditional.access.auth.v2.service.d(this);
        this.q = r10;
        com.ss.android.lark.conditional.access.auth.v2.service.k r11 = new com.ss.android.lark.conditional.access.auth.v2.service.k(this);
        this.r = new com.ss.android.lark.conditional.access.auth.v2.handler.b(this);
        this.s = new com.ss.android.lark.conditional.access.auth.v2.handler.f(this, r0);
        this.u = new d(this);
        this.v = LazyKt.lazy(new SecurityPolicyAuthManager$policyUpdateObserver$2(this));
        this.w = CollectionsKt.arrayListOf(new i8b.a[]{r1, r2, (i8b.m) r8.getValue(), r9, r10, r11, r3, r4, r6, r7, r5});
    }

    @Override // i8b.q
    public final com.ss.android.lark.conditional.access.auth.v2.c a(PolicyModel r8) {
        Intrinsics.checkNotNullParameter(r8, "policyModel");
        this.p.getClass();
        Intrinsics.checkNotNullParameter(r8, "policyModel");
        ScsLogger.d("SecurityPolicy_PolicyValidateService", "do downgradeCheck.");
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.f.a.values().contains(r8.getPointKey()) == true) goto L7;
        ValidateRequest r0 = new ValidateRequest("PC:CLIENT:android:" + r8.getPointKey(), new JSONObject(com.ss.android.lark.security.compliance.infra.util.f.c(r8.getEntity())), true);
        ke6.d r9 = ke6.d.a;
        Intrinsics.checkNotNullParameter(r0, "request");
        int r10 = PolicyDecision.a;
        return com.ss.android.lark.conditional.access.auth.v2.b.a(PolicyDecision.e(r0), ValidateResultSource.DOWNGRADE);
    L7:
        return new com.ss.android.lark.conditional.access.auth.v2.c(ResultType.ALLOW, ValidateResultSource.DOWNGRADE, null, null, 1016);
    }

    @Override // i8b.q
    public final boolean b(PolicyModel r7) {
        Intrinsics.checkNotNullParameter(r7, "model");
        CCMFileEntity r0 = r7.getEntity();
        if ((r0 instanceof CCMFileEntity) == false) goto L35;
        if (w4c.c.a().n() == true) goto L12;
        if (r0.getFileBizDomain() != FileBizDomain.FileBizDomainCCM) goto L12;
        if (Intrinsics.areEqual(r7.getPointKey(), "PointKey_CCM_FILE_UPLOAD") == true) goto L12;
        return true;
    L12:
        if (w4c.c.a().K() == false) goto L17;
        if (r0.getFileBizDomain() != FileBizDomain.FileBizDomainMeetingMinutes) goto L17;
        return true;
    L17:
        if (w4c.c.a().y() == false) goto L52;
        CCMFileEntity r1 = r0;
        FileBizDomain r2 = r1.getFileBizDomain();
        FileBizDomain r5 = FileBizDomain.FileBizDomainCALENDAR;
        if (r2 != r5) goto L26;
        if (Intrinsics.areEqual(r7.getPointKey(), "PointKey_CCM_FILE_DOWNLOAD") == false) goto L23;
    L24:
        return true;
    L23:
        if (Intrinsics.areEqual(r7.getPointKey(), "PointKey_CCM_FILE_PREVIEW") == true) goto L24;
    L26:
        if (r1.getFileBizDomain() != FileBizDomain.FileBizDomainCCM) goto L52;
        if (Intrinsics.areEqual(r7.getPointKey(), "PointKey_CCM_FILE_UPLOAD") == false) goto L52;
        if (r1.getScopedFileBizDomain() != FileBizDomain.FileBizDomainIM) goto L32;
    L33:
        return true;
    L32:
        if (r1.getScopedFileBizDomain() == r5) goto L33;
    L52:
        return this.m.e(com.ss.android.lark.security.compliance.api.model.filepolicy.h.i(r7));
    L35:
        if ((r0 instanceof CalendarFileEntity) == false) goto L48;
        if (((CalendarFileEntity) r0).getFileBizDomain() == FileBizDomain.FileBizDomainCALENDAR) goto L39;
    L45:
        return false;
    L39:
        if (w4c.c.a().y() == false) goto L45;
        if (Intrinsics.areEqual(r7.getPointKey(), "PointKey_CCM_FILE_DOWNLOAD") == false) goto L43;
        return true;
    L43:
        if (Intrinsics.areEqual(r7.getPointKey(), "PointKey_CALENDAR_FILE_PREVIEW") == false) goto L45;
        return true;
    L48:
        if ((r0 instanceof VCFileEntity) == false) goto L52;
        return w4c.c.a().M();
    }

    @Override // com.ss.android.lark.conditional.access.auth.v2.handler.c
    public final void c(com.ss.android.lark.security.compliance.api.model.filepolicy.l r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        if ((r4 instanceof com.ss.android.lark.security.compliance.api.model.filepolicy.k) == false) goto L8;
        Iterator<T> r0 = this.w.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        ((i8b.a) r0.next()).b((com.ss.android.lark.security.compliance.api.model.filepolicy.k) r4);
    L10:
        if (w4c.c.a().V() == false) goto L12;
        this.r.c(r4);
    L12:
        com.ss.android.lark.conditional.access.auth.v2.handler.a.a.c(r4);
        if (w4c.c.a().N() == false) goto L16;
        this.s.c(r4);
    L16:
        if (w4c.c.a().T() == false) goto L20;
        RefreshNotifyHandler.a.c(r4);
        return;
    L20:
        return;
    L8:
        ScsLogger.d("SecurityPolicy_SecurityPolicyAuthManager", "handleEvent(), but event do not handle.");
        goto L10
    }

    @Override // i8b.q
    public final com.ss.android.lark.conditional.access.auth.v2.c d(PolicyModel r2) {
        Intrinsics.checkNotNullParameter(r2, "policyModel");
        return ((i8b.m) this.o.getValue()).f(r2);
    }

    @Override // i8b.q
    public final boolean f(PolicyModel r3) {
        Intrinsics.checkNotNullParameter(r3, "model");
        com.ss.android.lark.conditional.access.auth.v2.service.f r0 = this.n;
        String r4 = com.ss.android.lark.security.compliance.api.model.filepolicy.h.i(r3);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "taskId");
        com.ss.android.lark.conditional.access.auth.v2.service.i r5 = r0.d.get(r4);
        if (r5 != null) goto L7;
        return false;
    L7:
        return r5.a;
    }

    @Override // i8b.q
    public final boolean h(PolicyModel r6) {
        Intrinsics.checkNotNullParameter(r6, "policyModel");
        String r7 = com.ss.android.lark.security.compliance.api.model.filepolicy.h.i(r6);
        DeviceControlService r0 = this.l;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r7, "taskId");
        if (idb.f.a().isEnable("lark.security.file_protection_policy_device") == false) goto L13;
        Integer r1 = r0.c.getDeviceConfigInfo().get(r7);
        if (r1 == null) goto L8;
        Integer r2 = Integer.valueOf(r1.intValue() & 15);
    L9:
        if (r2 == null) goto L13;
        if (r2.intValue() == 0) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == true) goto L23;
        com.ss.android.lark.conditional.access.auth.v2.service.f r4 = this.n;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r7, "taskId");
        com.ss.android.lark.conditional.access.auth.v2.service.i r5 = r4.d.get(r7);
        if (r5 == null) goto L18;
        boolean r8 = r5.a;
    L19:
        if (r8 == true) goto L23;
        if (this.m.e(r7) == true) goto L23;
        return true;
    L18:
        r8 = false;
    L23:
        return false;
    L8:
        r2 = null;
    L13:
        r3 = false;
        goto L14
    }

    public final void k(FileAuthMonitor.UpdateTrigger r4) {
        if (com.ss.android.lark.conditional.access.utils.f.a() == false) goto L6;
        int r0 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_SecurityPolicyAuthManager", "start batchPolicyValidate,fileProtect FG is active, validateRequestFrom is " + r4.name());
        com.ss.android.lark.conditional.access.auth.v2.service.a r1 = this.k;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "validateFrom");
        r1.h.execute(new com.ss.android.lark.conditional.access.auth.v2.service.b(r1, r4));
        return;
    }

    @Override // i8b.q
    public final void g(List<PolicyModel> r3, FileAuthMonitor.UpdateTrigger r4) {
        Intrinsics.checkNotNullParameter(r3, "policyModelList");
        Intrinsics.checkNotNullParameter(r4, "requestFrom");
        if (ArraysKt.contains(FileAuthMonitor.a, r4) == false) goto L5;
        return;
    L5:
        if ((!r3.isEmpty()) == true) goto L7;
        return;
    L7:
        if (com.ss.android.lark.conditional.access.auth.v2.b.d.contains(((PolicyModel) ListProtector.get(r3, 0)).getPointKey()) == false) goto L12;
        ArrayList<String> r5 = com.ss.android.lark.conditional.access.utils.c.a;
        com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_SecurityPolicyAuthManager", "Remove retry task", true);
        this.j.f();
        return;
    }

    @Override // i8b.q
    public final e j(PolicyModel r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "policyModel");
        return ((i8b.m) this.o.getValue()).e(r2, r3);
    }

    @Override // i8b.q
    public final Object e(List<PolicyModel> r4, FileAuthMonitor.UpdateTrigger r5, Continuation<? super Map<String, com.bytedance.lark.policy.model.b0>> r6) {
        int r0 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_SecurityPolicyAuthManager", "start validatePolicy, validateRequestFrom is " + r5.name());
        return this.p.e(r4, new FileAuthMonitor.a(r5, null), r6);
    }
}
