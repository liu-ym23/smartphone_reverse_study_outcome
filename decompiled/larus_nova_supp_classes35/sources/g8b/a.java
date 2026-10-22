package g8b;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.security.v1.PolicyCenterMessageBlockActionKey;
import com.bytedance.lark.pb.security.v1.QueryPolicyCenterResourceBlockActionRequest;
import com.bytedance.lark.pb.security.v1.QueryPolicyCenterResourceBlockActionResponse;
import com.bytedance.lark.policy.decision.PolicyDecision;
import com.bytedance.lark.policy.model.ValidateRequest;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.conditional.access.auth.v2.a0;
import com.ss.android.lark.conditional.access.auth.v2.z;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.nopermission.manager.NoPermissionModuleManager;
import com.ss.android.lark.conditional.access.nopermission.manager.e;
import com.ss.android.lark.conditional.access.nopermission.manager.f;
import com.ss.android.lark.conditional.access.nopermission.manager.g;
import com.ss.android.lark.conditional.access.nopermission.manager.h;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.traffic.RegulateDispatcher;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.conditional.access.utils.NoPermissionType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.AuthEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.SecurityAction;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateConfig;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateLogInfo;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.security.compliance.api.model.filepolicy.l;
import com.ss.android.lark.security.compliance.api.model.filepolicy.m;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.suite.lark.component.navroute.NavRouter;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import e0c.k;
import i8b.t;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Singleton
public final class a implements g8b.c {
    public final NoPermissionModuleManager a;
    public final com.ss.android.lark.conditional.access.traffic.a b;

    @Inject
    public k8b.c c;

    /* JADX INFO: renamed from: g8b.a$a, reason: collision with other inner class name */
    public static final class C0225a {
    }

    public static final class b<T> implements Consumer {
        public static final b<T> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            QueryPolicyCenterResourceBlockActionResponse r2 = (QueryPolicyCenterResourceBlockActionResponse) r1;
        }
    }

    public static final class c<T> implements Consumer {
        public static final c<T> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ a a;

        public d(a r1) {
            this.a = r1;
        }

        public final void a() {
            NoPermissionModuleManager r0 = this.a.a;
            r0.getClass();
            ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "NoPermissionModuleManager init");
            AppLifecycle.a.a.b(new com.ss.android.lark.conditional.access.nopermission.manager.d(r0));
            if (w4c.c.a().Y() == false) goto L5;
            ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "add security global router interceptor");
            NavRouter.a r2 = NavRouter.a;
            NoPermissionModuleManager.c r3 = r0.o;
            Intrinsics.checkNotNullParameter(r3, "interceptor");
            NavRouter.c.add(new ync.a(r3));
            r0.k.observeForever(new e(r0));
        L5:
            this.a.a.getClass();
            Object r1 = BuildConfig.FLAVOR;
            Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L8
            Object r5 = Result.constructor-impl(Boolean.valueOf(w4c.c.a().J()));     // Catch: Throwable -> L8
        L10:
            Boolean r6 = Boolean.TRUE;
            if (Result.isFailure-impl(r5) == false) goto L14;
            r5 = r6;
        L14:
            if (((Boolean) r5).booleanValue() == true) goto L53;
            ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "maybeRestoreInterception: setting disabled, skip");
            return;
        L53:
            String r7 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).d();     // Catch: Throwable -> L21
            if (r7 != null) goto L19;
            r7 = BuildConfig.FLAVOR;
        L19:
            Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L21
        L24:
            if (Result.isFailure-impl(r8) == true) goto L28;
            r1 = r8;
        L28:
            if (((String) r1).length() <= 0) goto L30;
            boolean r9 = true;
        L31:
            if (r9 == false) goto L33;
            ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "maybeRestoreInterception: user already logged in, kick prober");
            com.ss.android.lark.conditional.access.nopermission.interception.b.a.getClass();
            com.ss.android.lark.conditional.access.nopermission.interception.b.a();
        L55:
            ((xzb.a) ApiUtils.getApi(xzb.a.class)).registerLoginListener(f.a);     // Catch: Throwable -> L36
            Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L36
        L38:
            Throwable r11 = Result.exceptionOrNull-impl(r10);
            if (r11 == null) goto L51;
            int r12 = ScsLogger.a;
            ScsLogger.c("SecurityPolicy_NoPermissionModuleManager", "maybeRestoreInterception: registerLoginListener failed, " + r11);
        L51:
            ((xzb.a) ApiUtils.getApi(xzb.a.class)).registerUserSwitchListener(g.a);     // Catch: Throwable -> L43
            ((xzb.a) ApiUtils.getApi(xzb.a.class)).registerLogoutListener(h.a);     // Catch: Throwable -> L43
            Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L43
        L45:
            Throwable r14 = Result.exceptionOrNull-impl(r13);
            if (r14 == null) goto L58;
            int r15 = ScsLogger.a;
            ScsLogger.c("SecurityPolicy_NoPermissionModuleManager", "maybeRestoreInterception: register switch/logout listener failed, " + r14);
            return;
        L58:
            return;
        L43:
            th = move-exception;
            Result.Companion r16 = Result.Companion;
            r13 = Result.constructor-impl(ResultKt.createFailure(th));
        L36:
            th = move-exception;
            Result.Companion r17 = Result.Companion;
            r10 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L38
        L33:
            ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "maybeRestoreInterception: waiting for login");
            goto L55
        L30:
            r9 = false;
        L21:
            th = move-exception;
            Result.Companion r18 = Result.Companion;
            r8 = Result.constructor-impl(ResultKt.createFailure(th));
        L8:
            th = move-exception;
            Result.Companion r19 = Result.Companion;
            r5 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L10
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
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

    @Override // g8b.c
    public final k8b.c getDependency() {
        k8b.c r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("dependency");
        return null;
    }

    public final long h() {
        int r0 = h8b.a.a;
        z.a.getClass();
        return w4c.c.a().s();
    }

    public final boolean j() {
        if (this.a.d.get() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void a(PolicyModel r12) {
        Intrinsics.checkNotNullParameter(r12, "policyModel");
        int r1 = h8b.a.a;
        z.a.getClass();
        Intrinsics.checkNotNullParameter(r12, "policyModel");
        if (z.c == null) goto L6;
        int r0 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_SecurityAuthSDK", "do showSecurityPolicyInterceptInteraction(), policyModel.entity.entityOperate is " + r12.getEntity().getEntityOperate());
        DecisionData.Action r2 = new DecisionData.Action();
        r2.setName("FILE_BLOCK_COMMON");
        r2.setParams(MapsKt.hashMapOf(new Pair[]{TuplesKt.to("entity_operation", r12.getEntity().getEntityOperate()), TuplesKt.to("file_biz_domain", com.ss.android.lark.security.compliance.api.model.filepolicy.h.d(r12.getEntity()).getBiz())}));
        LinkedList<DecisionData.Action> r13 = new LinkedList();
        r13.add(r2);
        DecisionData r3 = new DecisionData();
        r3.setActions(r13);
        String r4 = com.ss.android.lark.security.compliance.infra.util.f.c(r3);
        PublishSubject<InternalSecurityAction> r5 = RegulateDispatcher.a;
        Intrinsics.checkNotNull(r4);
        RegulateDispatcher.a(new InternalSecurityAction(new SecurityAction(r4, null, 0, 0, 14, null), r2, r13), "BUSINESS");
        return;
    }

    public final boolean d(PolicyModel r6) {
        Intrinsics.checkNotNullParameter(r6, "policyModel");
        int r1 = h8b.a.a;
        z.a.getClass();
        Intrinsics.checkNotNullParameter(r6, "policyModel");
        boolean r2 = true;
        if (z.c == null) goto L10;
        Intrinsics.checkNotNullParameter(r6, "policyModel");
        qqb.a.h("isEnableFastPass");     // Catch: Throwable -> L7
        ke6.d r0 = ke6.d.a;     // Catch: Throwable -> L7
        ValidateRequest r3 = new ValidateRequest("PC:CLIENT:android:" + r6.getPointKey(), new JSONObject(com.ss.android.lark.security.compliance.infra.util.f.c(r6.getEntity())), true);     // Catch: Throwable -> L7
        r0.getClass();     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r3, "request");     // Catch: Throwable -> L7
        int r7 = PolicyDecision.a;     // Catch: Throwable -> L7
        r2 = PolicyDecision.g(r3);     // Catch: Throwable -> L7
        qqb.a.a();
    L7:
        th = move-exception;
        qqb.a.a();
        throw th;
    L10:
        int r8 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_SecurityAuthSDK", "isEnableFastPass(), result= " + r2);
        return r2;
    }

    public final void e(SecurityAction r3) {
        Intrinsics.checkNotNullParameter(r3, "securityAction");
        int r0 = h8b.a.a;
        z.a.d(r3, "BUSINESS");
    }

    public final void g(l r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        int r0 = h8b.a.a;
        z.a.c(r2);
    }

    public final void i(o4c.b r6) {
        Intrinsics.checkNotNullParameter(r6, "securityActionContext");
        LarkAppContext.Companion.getClass();
        com.ss.android.lark.conditional.access.display.g r0 = (com.ss.android.lark.conditional.access.display.g) k.a(LarkAppContext.access$getInstance$cp().getContext(), com.ss.android.lark.conditional.access.display.g.class);
        QueryPolicyCenterResourceBlockActionRequest.Builder r1 = new QueryPolicyCenterResourceBlockActionRequest.Builder().scope_entity_type(r6.b).scope_entity_domain(r6.a.getBiz());
        PolicyCenterMessageBlockActionKey.Builder r2 = new PolicyCenterMessageBlockActionKey.Builder();
        o4c.a r3 = r6.c;
        String r4 = null;
        if (r3 == null) goto L5;
        String r5 = r3.a;
    L6:
        r2.msg_id(r5);
        o4c.a r7 = r6.c;
        if (r7 == null) goto L9;
        String r8 = r7.b;
    L10:
        r2.cid(r8);
        o4c.a r9 = r6.c;
        if (r9 == null) goto L13;
        String r10 = r9.c;
    L14:
        r2.sender_id(r10);
        o4c.a r11 = r6.c;
        if (r11 == null) goto L17;
        r4 = r11.d;
    L17:
        r2.chat_id(r4);
        Unit r12 = Unit.INSTANCE;
        r0.U(r1.message_block_action_key(r2.build())).subscribe(b.a, c.a);
        return;
    L13:
        r10 = null;
        goto L14
    L9:
        r8 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    @Override // g8b.c
    public final void init(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        if (w4c.c.a().e() == false) goto L5;
        ScsLogger.d("SecurityPolicy_", "conditionAccessDisabled is true");
        boolean r1 = true;
    L7:
        if (r1 == false) goto L9;
        ScsLogger.d("SecurityPolicy_ConditionalAccessImpl", "ConditionAccess init intercept");
    L20:
        if (w4c.c.a().o() == true) goto L22;
        int r2 = h8b.a.a;
        Intrinsics.checkNotNullParameter(r7, "context");
        z.a.getClass();
        Intrinsics.checkNotNullParameter(r7, "context");
        ScsLogger.d("SecurityPolicy_SecurityAuthSDK", "do initSDK()");
        z.b = System.currentTimeMillis();
        z.c = new a0(r7);
    L22:
        ScsLogger.d("SecurityPolicy_ConditionalAccessImpl", "ConditionalAccessModule init, done");
        FileAuthMonitor.UpdateTrigger[] r8 = FileAuthMonitor.a;
        FileAuthMonitor.b(FileAuthMonitor.AccessControlScene.ModuleInit);
        return;
    L9:
        com.ss.android.lark.conditional.access.traffic.a r3 = this.b;
        r3.getClass();
        boolean r4 = w4c.c.a().b();
        int r5 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_GlobalScopeRegulateNetworkTrafficPush", "doListen, subthreadSwitch:" + r4);
        com.ss.android.lark.conditional.access.traffic.d r6 = new com.ss.android.lark.conditional.access.traffic.d(r3);
        if (r4 == false) goto L12;
        CoreThreadPool.getSerialTaskHandler().post(new com.ss.android.lark.conditional.access.traffic.b(r6));
    L13:
        PublishSubject<InternalSecurityAction> r9 = RegulateDispatcher.a;
        ScsLogger.d("SecurityPolicy_RegulateDispatcher", "init()");
        if (w4c.c.a().p() == false) goto L16;
    L18:
        UICallbackExecutor.execute(new d(this));
        goto L20
    L16:
        if (w4c.c.a().o() == true) goto L18;
        CoreThreadPool.getDefault().getFixedThreadPool().execute(com.ss.android.lark.conditional.access.traffic.e.a);
        goto L18
    L12:
        com.ss.android.lark.sdk.g.e.a.b(Command.PUSH_REQ_REGULATE, r6);
        goto L13
    L5:
        r1 = false;
        goto L7
    }

    public final void k(List<ValidateLogInfo> r4) {
        Intrinsics.checkNotNullParameter(r4, "resultLogs");
        int r1 = h8b.a.a;
        z.a.getClass();
        Intrinsics.checkNotNullParameter(r4, "resultLogs");
        ScsLogger.d("SecurityPolicy_SecurityAuthSDK", "reportUserOperate.");
        a0 r2 = z.c;
        if (r2 == null) goto L8;
        Intrinsics.checkNotNullParameter(r4, "resultLogs");
        com.ss.android.lark.conditional.access.auth.v2.f r3 = r2.b;
        if (r3 == null) goto L9;
        Intrinsics.checkNotNullParameter(r4, "resultLogs");
        l r0 = new t(r4);
        Intrinsics.checkNotNullParameter(r0, "event");
        r3.b.c(r0);
        return;
    L9:
        return;
    }

    @Inject
    public a(NoPermissionModuleManager r2, com.ss.android.lark.conditional.access.traffic.a r3) {
        Intrinsics.checkNotNullParameter(r2, "noPermissionModuleManager");
        Intrinsics.checkNotNullParameter(r3, "networkTrafficPush");
        this.a = r2;
        this.b = r3;
    }

    @Override // g8b.c
    public final boolean c(NoPermissionType r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "noPermissionType");
        Intrinsics.checkNotNullParameter(r3, "extra");
        return this.a.k(r2, r3);
    }

    public final ValidateResult b(PolicyModel r4, AuthEntity r5, ValidateConfig r6) {
        Intrinsics.checkNotNullParameter(r4, "policyModel");
        int r1 = h8b.a.a;
        z.a.getClass();
        Intrinsics.checkNotNullParameter(r4, "policyModel");
        String r0 = qqb.a.d();
        String r2 = BuildConfig.FLAVOR;
        if (Intrinsics.areEqual(r0, BuildConfig.FLAVOR) == false) goto L5;
        String r3 = qqb.a.i(qqb.a.e());
    L12:
        r2 = qqb.a.d();     // Catch: Throwable -> L9
        qqb.a.f(r3);     // Catch: Throwable -> L9
        ValidateResult r7 = z.b(r4, r5, r6);     // Catch: Throwable -> L9
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r2, "traceId");
        qqb.a.g(r2);
        return r7;
    L9:
        th = move-exception;
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r2, "traceId");
        qqb.a.g(r2);
        throw th;
    L5:
        r3 = qqb.a.d();
        goto L12
    }

    public final void f(PolicyModel[] r5, AuthEntity r6, ValidateConfig r7, m r8) {
        Intrinsics.checkNotNullParameter(r5, "policyModels");
        Intrinsics.checkNotNullParameter(r8, "callback");
        int r2 = h8b.a.a;
        z r3 = z.a;
        PolicyModel[] r9 = (PolicyModel[]) Arrays.copyOf(r5, r5.length);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r9, "policyModels");
        Intrinsics.checkNotNullParameter(r8, "callback");
        String r0 = qqb.a.d();
        String r1 = BuildConfig.FLAVOR;
        if (Intrinsics.areEqual(r0, BuildConfig.FLAVOR) == false) goto L5;
        String r4 = qqb.a.i(qqb.a.e());
    L12:
        r1 = qqb.a.d();     // Catch: Throwable -> L9
        qqb.a.f(r4);     // Catch: Throwable -> L9
        ScsLogger.d("SecurityPolicy_SecurityAuthSDK", "[start check auth], [validateType: Async], checkSecurityPolicyAsync.");     // Catch: Throwable -> L9
        z.a((PolicyModel[]) Arrays.copyOf(r9, r9.length), r6, r7, r8);     // Catch: Throwable -> L9
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r1, "traceId");
        qqb.a.g(r1);
        return;
    L9:
        th = move-exception;
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r1, "traceId");
        qqb.a.g(r1);
        throw th;
    L5:
        r4 = qqb.a.d();
        goto L12
    }
}
