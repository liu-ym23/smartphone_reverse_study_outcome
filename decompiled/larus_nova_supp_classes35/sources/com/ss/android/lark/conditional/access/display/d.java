package com.ss.android.lark.conditional.access.display;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.LarkError;
import com.bytedance.lark.pb.security.v1.CustomDisplayHandler;
import com.bytedance.lark.pb.security.v1.CustomDisplayMGetRequest;
import com.bytedance.lark.pb.security.v1.CustomDisplayMGetResponse;
import com.bytedance.lark.pb.security.v1.CustomDisplayModelByKeyRequest;
import com.bytedance.lark.pb.security.v1.CustomDisplayModelRequest;
import com.bytedance.lark.pb.security.v1.CustomDisplayModelResponse;
import com.bytedance.lark.pb.security.v1.CustomDisplayPageListRequest;
import com.bytedance.lark.pb.security.v1.CustomDisplayPageListResponse;
import com.bytedance.lark.pb.security.v1.CustomDisplayTemplate;
import com.bytedance.lark.pb.security.v1.QueryPolicyCenterResourceBlockActionRequest;
import com.bytedance.lark.pb.security.v1.QueryPolicyCenterResourceBlockActionResponse;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.p;
import com.bytedance.lark.rustclient.api.s;
import com.bytedance.lark.rustclient.api.x;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chameleon.error.DocErrorCode;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.nopermission.manager.SecurityPolicyDialogActionManager;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.security.compliance.api.model.filepolicy.SecurityAction;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Map;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class d implements com.ss.android.lark.conditional.access.display.h {
    public final l a;

    public static final class a {
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ String a;

        public b(String r1) {
            this.a = r1;
        }

        public final Object apply(Object r9) {
            x r10 = (s) r9;
            Intrinsics.checkNotNullParameter(r10, "it");
            boolean r1 = r10 instanceof x;
            String r3 = BuildConfig.FLAVOR;
            if (r1 == false) goto L11;
            String r0 = this.a;
            r3 = qqb.a.d();     // Catch: Throwable -> L7
            qqb.a.f(r0);     // Catch: Throwable -> L7
            ScsLogger.d("SecurityPolicy_CustomDisplayNetworkRepository", "fetchCustomDisplayByKeyRust success.");     // Catch: Throwable -> L7
            Single r11 = Single.just(r10.c);     // Catch: Throwable -> L7
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r3, "traceId");
            qqb.a.g(r3);
        L24:
            return r11;
        L7:
            th = move-exception;
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r3, "traceId");
            qqb.a.g(r3);
            throw th;
        L11:
            if ((r10 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L29;
            String r2 = this.a;
            r3 = qqb.a.d();     // Catch: Throwable -> L25
            qqb.a.f(r2);     // Catch: Throwable -> L25
            LarkError r4 = ((com.bytedance.lark.rustclient.api.c) r10).c.b;     // Catch: Throwable -> L25
            Integer r5 = null;
            if (r4 == null) goto L18;
            LarkError.ErrorDetails r6 = r4.details;     // Catch: Throwable -> L25
            if (r6 == null) goto L18;
            String r7 = r6.x_tt_logid;     // Catch: Throwable -> L25
        L19:
            LarkError r8 = ((com.bytedance.lark.rustclient.api.c) r10).c.b;     // Catch: Throwable -> L25
            if (r8 == null) goto L22;
            r5 = r8.code;     // Catch: Throwable -> L25
        L22:
            String r12 = ((com.bytedance.lark.rustclient.api.c) r10).c.c();     // Catch: Throwable -> L25
            int r13 = ScsLogger.a;     // Catch: Throwable -> L25
            ScsLogger.d("SecurityPolicy_CustomDisplayNetworkRepository", "fetchCustomDisplayByKeyRust error. logId is " + r7 + ", code is " + r5 + ", message is " + r12);     // Catch: Throwable -> L25
            r11 = Single.error(((com.bytedance.lark.rustclient.api.c) r10).c.b());     // Catch: Throwable -> L25
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r3, "traceId");
            qqb.a.g(r3);
        L18:
            r7 = null;
        L25:
            th = move-exception;
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r3, "traceId");
            qqb.a.g(r3);
            throw th;
        L29:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ String a;

        public c(String r1) {
            this.a = r1;
        }

        public final Object apply(Object r9) {
            x r10 = (s) r9;
            Intrinsics.checkNotNullParameter(r10, "it");
            boolean r1 = r10 instanceof x;
            String r3 = BuildConfig.FLAVOR;
            if (r1 == false) goto L11;
            String r0 = this.a;
            r3 = qqb.a.d();     // Catch: Throwable -> L7
            qqb.a.f(r0);     // Catch: Throwable -> L7
            ScsLogger.d("SecurityPolicy_CustomDisplayNetworkRepository", "fetchCustomDisplayByRust success.");     // Catch: Throwable -> L7
            Single r11 = Single.just(r10.c);     // Catch: Throwable -> L7
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r3, "traceId");
            qqb.a.g(r3);
        L24:
            return r11;
        L7:
            th = move-exception;
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r3, "traceId");
            qqb.a.g(r3);
            throw th;
        L11:
            if ((r10 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L29;
            String r2 = this.a;
            r3 = qqb.a.d();     // Catch: Throwable -> L25
            qqb.a.f(r2);     // Catch: Throwable -> L25
            LarkError r4 = ((com.bytedance.lark.rustclient.api.c) r10).c.b;     // Catch: Throwable -> L25
            Integer r5 = null;
            if (r4 == null) goto L18;
            LarkError.ErrorDetails r6 = r4.details;     // Catch: Throwable -> L25
            if (r6 == null) goto L18;
            String r7 = r6.x_tt_logid;     // Catch: Throwable -> L25
        L19:
            LarkError r8 = ((com.bytedance.lark.rustclient.api.c) r10).c.b;     // Catch: Throwable -> L25
            if (r8 == null) goto L22;
            r5 = r8.code;     // Catch: Throwable -> L25
        L22:
            String r12 = ((com.bytedance.lark.rustclient.api.c) r10).c.c();     // Catch: Throwable -> L25
            int r13 = ScsLogger.a;     // Catch: Throwable -> L25
            ScsLogger.d("SecurityPolicy_CustomDisplayNetworkRepository", "fetchCustomDisplayByRust error. logId is " + r7 + ", code is " + r5 + ", message is " + r12);     // Catch: Throwable -> L25
            r11 = Single.error(((com.bytedance.lark.rustclient.api.c) r10).c.b());     // Catch: Throwable -> L25
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r3, "traceId");
            qqb.a.g(r3);
        L18:
            r7 = null;
        L25:
            th = move-exception;
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r3, "traceId");
            qqb.a.g(r3);
            throw th;
        L29:
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.conditional.access.display.d$d, reason: collision with other inner class name */
    public static final class C0155d<T> implements Consumer {
        public final /* synthetic */ long a;

        public C0155d(long r1) {
            this.a = r1;
        }

        public final void accept(Object r12) {
            long r6 = System.currentTimeMillis() - this.a;
            FileAuthMonitor.UpdateTrigger[] r0 = FileAuthMonitor.a;
            FileAuthMonitor.g("pageList", 1, r6, null, Integer.valueOf(DocErrorCode.ERRCODE_DEFAULT), ((Throwable) r12).getMessage());
        }
    }

    public static final class e<T, R> implements Function {
        public final /* synthetic */ long a;

        public e(long r1) {
            this.a = r1;
        }

        public final Object apply(Object r14) {
            x r15 = (s) r14;
            Intrinsics.checkNotNullParameter(r15, "it");
            if ((r15 instanceof x) == false) goto L6;
            ScsLogger.d("SecurityPolicy_CustomDisplayNetworkRepository", "fetchCustomDisplayPageList success.");
            FileAuthMonitor.h("pageList", System.currentTimeMillis() - this.a);
            return Single.just(r15.c);
        L6:
            if ((r15 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L19;
            long r8 = System.currentTimeMillis() - this.a;
            com.bytedance.lark.rustclient.api.c r16 = (com.bytedance.lark.rustclient.api.c) r15;
            p r0 = r16.c;
            LarkError r2 = r0.b;
            if (r2 == null) goto L12;
            LarkError.ErrorDetails r4 = r2.details;
            if (r4 == null) goto L12;
            String r10 = r4.x_tt_logid;
        L13:
            if (r2 == null) goto L15;
            Integer r11 = r2.code;
        L16:
            String r12 = r0.c();
            int r1 = ScsLogger.a;
            ScsLogger.d("SecurityPolicy_CustomDisplayNetworkRepository", "fetchCustomDisplayPageList error. logId is " + r10 + ", code is " + r11 + ", message is " + r12);
            FileAuthMonitor.UpdateTrigger[] r3 = FileAuthMonitor.a;
            FileAuthMonitor.g("pageList", 1, r8, r10, r11, r12);
            return Single.error(r16.c.b());
        L15:
            r11 = null;
        L12:
            r10 = null;
            goto L13
        L19:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ long a;

        public f(long r1) {
            this.a = r1;
        }

        public final void accept(Object r12) {
            long r6 = System.currentTimeMillis() - this.a;
            FileAuthMonitor.UpdateTrigger[] r0 = FileAuthMonitor.a;
            FileAuthMonitor.g("mGet", 1, r6, null, Integer.valueOf(DocErrorCode.ERRCODE_DEFAULT), ((Throwable) r12).getMessage());
        }
    }

    public static final class g<T, R> implements Function {
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;

        public g(String r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r19) {
            x r0 = (s) r19;
            Intrinsics.checkNotNullParameter(r0, "it");
            boolean r3 = r0 instanceof x;
            String r5 = BuildConfig.FLAVOR;
            if (r3 == false) goto L11;
            String r2 = this.a;
            long r7 = this.b;
            r5 = qqb.a.d();     // Catch: Throwable -> L7
            qqb.a.f(r2);     // Catch: Throwable -> L7
            ScsLogger.d("SecurityPolicy_CustomDisplayNetworkRepository", "fetchCustomDisplaySpecifiedIds success.");     // Catch: Throwable -> L7
            FileAuthMonitor.h("mGet", System.currentTimeMillis() - r7);     // Catch: Throwable -> L7
            Single r1 = Single.just(r0.c);     // Catch: Throwable -> L7
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r5, "traceId");
            qqb.a.g(r5);
        L25:
            return r1;
        L7:
            th = move-exception;
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r5, "traceId");
            qqb.a.g(r5);
            throw th;
        L11:
            if ((r0 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L30;
            String r4 = this.a;
            long r8 = this.b;
            r5 = qqb.a.d();     // Catch: Throwable -> L26
            qqb.a.f(r4);     // Catch: Throwable -> L26
            long r13 = System.currentTimeMillis() - r8;     // Catch: Throwable -> L26
            LarkError r6 = ((com.bytedance.lark.rustclient.api.c) r0).c.b;     // Catch: Throwable -> L26
            if (r6 == null) goto L18;
            LarkError.ErrorDetails r9 = r6.details;     // Catch: Throwable -> L26
            if (r9 == null) goto L18;
            String r15 = r9.x_tt_logid;     // Catch: Throwable -> L26
        L19:
            LarkError r10 = ((com.bytedance.lark.rustclient.api.c) r0).c.b;     // Catch: Throwable -> L26
            if (r10 == null) goto L22;
            Integer r11 = r10.code;     // Catch: Throwable -> L26
        L23:
            String r12 = ((com.bytedance.lark.rustclient.api.c) r0).c.c();     // Catch: Throwable -> L26
            int r14 = ScsLogger.a;     // Catch: Throwable -> L26
            ScsLogger.d("SecurityPolicy_CustomDisplayNetworkRepository", "fetchCustomDisplaySpecifiedIds error. logId is " + r15 + ", code is " + r11 + ", message is " + r12);     // Catch: Throwable -> L26
            FileAuthMonitor.UpdateTrigger[] r16 = FileAuthMonitor.a;     // Catch: Throwable -> L26
            FileAuthMonitor.g("mGet", 1, r13, r15, r11, r12);     // Catch: Throwable -> L26
            r1 = Single.error(((com.bytedance.lark.rustclient.api.c) r0).c.b());     // Catch: Throwable -> L26
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r5, "traceId");
            qqb.a.g(r5);
            goto L25
        L22:
            r11 = null;
        L18:
            r15 = null;
        L26:
            th = move-exception;
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r5, "traceId");
            qqb.a.g(r5);
            throw th;
        L30:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ CustomDisplayMGetRequest.Builder a;

        public h(CustomDisplayMGetRequest.Builder r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (this.a.id_list.size() == ((CustomDisplayMGetResponse) r2).config_list.size()) goto L6;
            FileAuthMonitor.e(102, BuildConfig.FLAVOR);
            return;
        }
    }

    public static final class i<T, R> implements Function {
        public static final i<T, R> a = null;

        static {
            a = new i();
        }

        public i() {
        }

        public final Object apply(Object r17) {
            x r0 = (s) r17;
            Intrinsics.checkNotNullParameter(r0, "it");
            if ((r0 instanceof x) == false) goto L6;
            ScsLogger.d("SecurityPolicy_CustomDisplayNetworkRepository", "queryBlockAction success.");
            return Single.just(r0.c);
        L6:
            if ((r0 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L18;
            com.bytedance.lark.rustclient.api.c r1 = (com.bytedance.lark.rustclient.api.c) r0;
            p r2 = r1.c;
            LarkError r3 = r2.b;
            Integer r4 = null;
            if (r3 == null) goto L12;
            LarkError.ErrorDetails r5 = r3.details;
            if (r5 == null) goto L12;
            String r6 = r5.x_tt_logid;
        L13:
            if (r3 == null) goto L15;
            r4 = r3.code;
        L15:
            String r7 = r2.c();
            SecurityPolicyDialogActionManager r8 = SecurityPolicyDialogActionManager.a;
            r8.getClass();
            InternalSecurityAction r9 = new InternalSecurityAction(new SecurityAction(BuildConfig.FLAVOR, null, 0, 0, 14, null), new DecisionData.Action(), CollectionsKt.emptyList());
            Map<String, Object> r10 = r9.getInternalParams();
            CustomDisplayTemplate.Builder r11 = new CustomDisplayTemplate.Builder();
            LarkAppContext.Companion.getClass();
            r10.put("displayModel", r11.title(UIUtils.getString(LarkAppContext.access$getInstance$cp().getContext(), 2131892538)).text(UIUtils.getString(LarkAppContext.access$getInstance$cp().getContext(), 2131892525)).handler_list(CollectionsKt.listOf(new CustomDisplayHandler(UIUtils.getString(LarkAppContext.access$getInstance$cp().getContext(), 2131892536), "Cancel", BuildConfig.FLAVOR, MapsKt.emptyMap(), MapsKt.emptyMap()))).build());
            Unit r12 = Unit.INSTANCE;
            SecurityPolicyDialogActionManager.e(r8, 92, r9);
            int r13 = ScsLogger.a;
            ScsLogger.d("SecurityPolicy_CustomDisplayNetworkRepository", "queryBlockAction error. logId is " + r6 + ", code is " + r4 + ", message is " + r7);
            return Single.error(r1.c.b());
        L12:
            r6 = null;
            goto L13
        L18:
            throw new NoWhenBranchMatchedException();
        }
    }

    static {
    }

    @Inject
    public d(l r2) {
        Intrinsics.checkNotNullParameter(r2, "rustClient");
        this.a = r2;
    }

    @Override // com.ss.android.lark.conditional.access.display.h
    public final Single<QueryPolicyCenterResourceBlockActionResponse> U(QueryPolicyCenterResourceBlockActionRequest.Builder r11) {
        Intrinsics.checkNotNullParameter(r11, "builder");
        com.bytedance.lark.rustclient.api.d r0 = new com.bytedance.lark.rustclient.api.d(r11, QueryPolicyCenterResourceBlockActionResponse.ADAPTER, Command.POLICY_CENTER_QUERY_BLOCK_ACTION, null, null, null, null, 248);
        return this.a.h(r0).a().singleOrError().flatMap(i.a);
    }

    @Override // com.ss.android.lark.conditional.access.display.h
    public final Single<CustomDisplayPageListResponse> a(CustomDisplayPageListRequest.Builder r13) {
        Intrinsics.checkNotNullParameter(r13, "builder");
        long r0 = System.currentTimeMillis();
        com.bytedance.lark.rustclient.api.d r11 = new com.bytedance.lark.rustclient.api.d(r13, CustomDisplayPageListResponse.ADAPTER, Command.CUSTOM_DISPLAY_PAGE_LIST, null, null, null, null, 248);
        return this.a.h(r11).a().singleOrError().doOnError(new C0155d(r0)).flatMap(new e(r0));
    }

    @Override // com.ss.android.lark.conditional.access.display.h
    public final Single<CustomDisplayMGetResponse> b(CustomDisplayMGetRequest.Builder r14) {
        Intrinsics.checkNotNullParameter(r14, "builder");
        String r0 = qqb.a.d();
        long r1 = System.currentTimeMillis();
        com.bytedance.lark.rustclient.api.d r12 = new com.bytedance.lark.rustclient.api.d(r14, CustomDisplayMGetResponse.ADAPTER, Command.CUSTOM_DISPLAY_M_GET, null, null, null, null, 248);
        return this.a.h(r12).a().singleOrError().doOnError(new f(r1)).flatMap(new g(r0, r1)).doOnSuccess(new h(r14));
    }

    @Override // com.ss.android.lark.conditional.access.display.h
    public final Single<CustomDisplayModelResponse> c(CustomDisplayModelByKeyRequest.Builder r12) {
        Intrinsics.checkNotNullParameter(r12, "builder");
        String r0 = qqb.a.d();
        com.bytedance.lark.rustclient.api.d r10 = new com.bytedance.lark.rustclient.api.d(r12, CustomDisplayModelResponse.ADAPTER, Command.GET_POLICY_SDK_DISPLAY_CONFIG_BY_KEY, null, null, null, null, 248);
        return this.a.h(r10).a().singleOrError().flatMap(new b(r0));
    }

    @Override // com.ss.android.lark.conditional.access.display.h
    public final Single<CustomDisplayModelResponse> d(CustomDisplayModelRequest.Builder r12) {
        Intrinsics.checkNotNullParameter(r12, "builder");
        String r0 = qqb.a.d();
        com.bytedance.lark.rustclient.api.d r10 = new com.bytedance.lark.rustclient.api.d(r12, CustomDisplayModelResponse.ADAPTER, Command.GET_POLICY_SDK_DISPLAY_CONFIG, null, null, null, null, 248);
        return this.a.h(r10).a().singleOrError().flatMap(new c(r0));
    }
}
