package com.ss.android.lark.conditional.access.nopermission.manager;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.lark.pb.security.v1.CustomDisplayConfig;
import com.bytedance.lark.pb.security.v1.CustomDisplayHandler;
import com.bytedance.lark.pb.security.v1.CustomDisplayTemplate;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.conditional.access.auth.v2.SecurityPolicyAuthManager;
import com.ss.android.lark.conditional.access.display.DisplayUtilsKt;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.params.SecurityActionHandleContext;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.LarkContext;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class SecurityPolicyDialogActionManager {
    public static final SecurityPolicyDialogActionManager a = null;
    public static final CompositeDisposable b = null;
    public static final StateFlowImpl c = null;
    public static final b1 d = null;
    public static final Lazy<Application.ActivityLifecycleCallbacks> e = null;

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0086\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/ss/android/lark/conditional/access/nopermission/manager/SecurityPolicyDialogActionManager$FilePolicyDialogType;", BuildConfig.FLAVOR, "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public @interface FilePolicyDialogType {
    }

    public static final class a {
        public final int a;
        public final InternalSecurityAction b;
        public Long c;

        public final int getType() {
            return this.a;
        }

        public a(int r2, InternalSecurityAction r3) {
            Intrinsics.checkNotNullParameter(r3, Keys.API_PARAM_KEY_ACTION);
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b<T1, T2> implements ttc.a {
        public static final b<T1, T2> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r1, Object r2) {
            Boolean r3 = (Boolean) r1;
            Throwable r4 = (Throwable) r2;
            SecurityPolicyDialogActionManager.a.getClass();
            SecurityPolicyDialogActionManager.b();
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ Object a;

        public c(Object r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            Disposable r8 = (Disposable) r7;
            ((Handler) SecurityDialogUtil.d.getValue()).postAtTime(k.a, this.a, ((long) 100) + SystemClock.uptimeMillis());
            Intrinsics.checkNotNullParameter(new AtomicBoolean(true), "<set-?>");
        }
    }

    public static final class d<T1, T2> implements ttc.a {
        public final /* synthetic */ Object a;

        public d(Object r1) {
            this.a = r1;
        }

        public final void accept(Object r1, Object r2) {
            CustomDisplayConfig r3 = (CustomDisplayConfig) r1;
            Throwable r4 = (Throwable) r2;
            ((Handler) SecurityDialogUtil.d.getValue()).removeCallbacksAndMessages(this.a);
            Intrinsics.checkNotNullParameter(new AtomicBoolean(false), "<set-?>");
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ InternalSecurityAction b;
        public final /* synthetic */ int c;

        public e(String r1, InternalSecurityAction r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r7) {
            CustomDisplayConfig r8 = (CustomDisplayConfig) r7;
            String r1 = this.a;
            InternalSecurityAction r2 = this.b;
            int r3 = this.c;
            String r4 = qqb.a.d();     // Catch: Throwable -> L13
            qqb.a.f(r1);     // Catch: Throwable -> L11
            if (r8 == null) goto L9;
            CustomDisplayTemplate r9 = r8.template;     // Catch: Throwable -> L11
            if (r9 == null) goto L9;
            CustomDisplayTemplate r10 = DisplayUtilsKt.e(r9, r2);     // Catch: Throwable -> L11
            r2.getInternalParams().put("displayModel", r10);     // Catch: Throwable -> L11
            SecurityPolicyDialogActionManager.e(SecurityPolicyDialogActionManager.a, r3, r2);     // Catch: Throwable -> L11
        L9:
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r4, "traceId");
            qqb.a.g(r4);
            return;
        L11:
            th = th;
        L15:
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r4, "traceId");
            qqb.a.g(r4);
            throw th;
        L13:
            th = th;
            r4 = BuildConfig.FLAVOR;
            goto L15
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ InternalSecurityAction d;

        public f(String r1, String r2, int r3, InternalSecurityAction r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r14) {
            String r0 = BuildConfig.FLAVOR;
            Throwable r15 = (Throwable) r14;
            String r2 = this.a;
            String r3 = this.b;
            int r4 = this.c;
            InternalSecurityAction r5 = this.d;
            String r6 = qqb.a.d();     // Catch: Throwable -> L18
            qqb.a.f(r2);     // Catch: Throwable -> L16
            if ((r15 instanceof TimeoutException) == true) goto L8;
            int r1 = ScsLogger.a;     // Catch: Throwable -> L16
            ScsLogger.c("SecurityPolicy_SecurityPolicyDialogActionManager", String.valueOf(r15.getMessage()));     // Catch: Throwable -> L16
        L10:
            ScsLogger.c("SecurityPolicy_SecurityPolicyDialogActionManager", "getDisplayModelById error!");     // Catch: Throwable -> L16
            if (r4 != 92) goto L13;
            Map<String, Object> r16 = r5.getInternalParams();     // Catch: Throwable -> L16
            CustomDisplayTemplate.Builder r7 = new CustomDisplayTemplate.Builder();     // Catch: Throwable -> L16
            LarkAppContext.Companion.getClass();     // Catch: Throwable -> L16
            r16.put("displayModel", r7.title(UIUtils.getString(LarkAppContext.access$getInstance$cp().getContext(), 2131892538)).text(UIUtils.getString(LarkAppContext.access$getInstance$cp().getContext(), 2131892525)).handler_list(CollectionsKt.listOf(new CustomDisplayHandler(UIUtils.getString(LarkAppContext.access$getInstance$cp().getContext(), 2131892536), "Cancel", BuildConfig.FLAVOR, MapsKt.emptyMap(), MapsKt.emptyMap()))).build());     // Catch: Throwable -> L16
            SecurityPolicyDialogActionManager.e(SecurityPolicyDialogActionManager.a, r4, r5);     // Catch: Throwable -> L16
        L14:
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r6, "traceId");
            qqb.a.g(r6);
            return;
        L13:
            SecurityDialogUtil.b(r5);     // Catch: Throwable -> L16
            goto L14
        L8:
            FileAuthMonitor.e(302, BuildConfig.FLAVOR);     // Catch: Throwable -> L16
            LarkAppContext.Companion.getClass();     // Catch: Throwable -> L16
            ((com.ss.android.lark.conditional.access.display.g) e0c.k.a(LarkAppContext.access$getInstance$cp().getContext(), com.ss.android.lark.conditional.access.display.g.class)).S5(CollectionsKt.listOf(r3), true);     // Catch: Throwable -> L16
        L16:
            th = th;
            r0 = r6;
        L19:
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r0, "traceId");
            qqb.a.g(r0);
            throw th;
        L18:
            th = th;
            goto L19
        }
    }

    public SecurityPolicyDialogActionManager() {
    }

    static {
        a = new SecurityPolicyDialogActionManager();
        b = new CompositeDisposable();
        StateFlowImpl r0 = j1.a(null);
        c = r0;
        d = kotlinx.coroutines.flow.e.b(r0);
        e = LazyKt.lazy(SecurityPolicyDialogActionManager$activityLifecycleCallback$1.INSTANCE);
    }

    public static void b() {
        String r0 = "SecurityPolicy_SecurityPolicyDialogActionManager";
        ScsLogger.d("SecurityPolicy_SecurityPolicyDialogActionManager", "exitDialog.");
        StateFlowImpl r1 = c;
        a r2 = (a) r1.getValue();
        SecurityPolicyAuthManager r3 = null;
        if (r2 == null) goto L5;
        InternalSecurityAction r4 = r2.b;
    L6:
        r1.setValue(null);
        WeakReference<Dialog> r5 = SecurityDialogUtil.a;
        if (r4 == null) goto L76;
        Object r6 = r4.getInternalParams().get("filePolicyModelsSnapshot");
        if ((r6 instanceof List) == false) goto L12;
        List r7 = (List) r6;
    L13:
        if (r7 == null) goto L73;
        ArrayList r8 = new ArrayList();
        Iterator r9 = r7.iterator();
    L16:
        if (r9.hasNext() == false) goto L20;
        Object r10 = r9.next();
        if ((r10 instanceof PolicyModel) == false) goto L16;
        r8.add(r10);
        goto L16
    L20:
        SecurityActionHandleContext r11 = r4.getHandleContext();
        if (r11 == null) goto L77;
        String r12 = r11.getPointKey();
        if (r12 == null) goto L78;
        String r13 = r4.getTraceId();
        boolean r14 = true;
        if (r13.length() <= 0) goto L29;
        boolean r15 = true;
    L30:
        if (r15 == true) goto L33;
        r13 = null;
    L33:
        if (r13 == null) goto L36;
        r0 = r13;
    L36:
        int r16 = h8b.a.a;
        com.ss.android.lark.conditional.access.auth.v2.z.a.getClass();
        com.ss.android.lark.conditional.access.auth.v2.a0 r17 = com.ss.android.lark.conditional.access.auth.v2.z.c;
        if (r17 == null) goto L42;
        com.ss.android.lark.conditional.access.auth.v2.f r18 = r17.b;
        if (r18 == null) goto L42;
        r3 = r18.b;
    L42:
        if (r3 == null) goto L48;
        Intrinsics.checkNotNullParameter(r8, "policyModels");
        Intrinsics.checkNotNullParameter(r0, "traceId");
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r20 = r8.iterator();
    L45:
        if (r20.hasNext() == false) goto L47;
        PolicyModel r110 = (PolicyModel) r20.next();
        r110.setConfig(new PolicyModel.a(r3.b(r110)));
        r19.add(r110);
        goto L45
    L47:
        ((i8b.m) r3.o.getValue()).h(r19);
        int r21 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_SecurityPolicyAuthManager", "removeCaches success, clearCount: " + r19.size() + ", traceId: " + r0);
    L48:
        String r22 = r11.getCacheHitTaskId();
        String r23 = r11.getCacheType();
        if (r22 != null) goto L51;
    L54:
        boolean r111 = true;
    L56:
        if (r111 == true) goto L65;
        if (r23 != null) goto L59;
    L62:
        if (r14 == true) goto L65;
        if (r3 == null) goto L74;
        Intrinsics.checkNotNullParameter(r22, "taskID");
        Intrinsics.checkNotNullParameter(r23, "cacheType");
        Intrinsics.checkNotNullParameter(r0, "traceId");
        ((i8b.m) r3.o.getValue()).g(r22, r23, r12);
        int r24 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_SecurityPolicyAuthManager", "removeCache success, pointKey: " + r12 + ", taskID: " + r22 + ", cacheType: " + r23 + ", traceId: " + r0);
        return;
    L74:
        return;
    L59:
        if (r23.length() == 0) goto L62;
        r14 = false;
    L65:
        int r25 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_CustomDisplayModel", "dialog clear current cache skipped, pointKey: " + r12 + ", cacheHitTaskId: " + r22 + ", cacheType: " + r23);
        return;
    L51:
        if (r22.length() == 0) goto L54;
        r111 = false;
        goto L56
    L29:
        r15 = false;
        goto L30
    L78:
        return;
    L77:
        return;
    L73:
        return;
    L12:
        r7 = null;
        goto L13
    L76:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public static void a(Activity r5) {
        int r0 = ScsLogger.a;
        StringBuilder r1 = new StringBuilder("dialog apply:");
        Boolean r2 = null;
        if (r5 == null) goto L5;
        String r3 = r5.getClass().getSimpleName();
    L6:
        r1.append(r3);
        ScsLogger.d("SecurityPolicy_SecurityPolicyDialogActionManager", r1.toString());
        Lazy<Application.ActivityLifecycleCallbacks> r4 = e;
        if (r4.isInitialized() == true) goto L9;
        LarkContext.getApplication().registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks) r4.getValue());
    L9:
        if (r5 != null) goto L11;
    L13:
        boolean r6 = false;
        if ((r5 instanceof AppCompatActivity) == true) goto L16;
    L29:
        StateFlowImpl r7 = c;
        if (r7.getValue() == null) goto L45;
        if (r5 == null) goto L40;
        a r8 = (a) r7.getValue();
        if (r8 == null) goto L39;
        Intrinsics.checkNotNullParameter(r5, "context");
        if (r8.c != null) goto L38;
        long r9 = System.currentTimeMillis();
        Intent r10 = new Intent(r5, SecurityPolicyPopupWindowActivity.class);
        r10.putExtra("mark", r9);
        r5.startActivity(r10);
        r6 = true;
    L38:
        r2 = Boolean.valueOf(r6);
    L39:
        ScsLogger.d("SecurityPolicy_SecurityPolicyDialogActionManager", "start new activity to show dialog, " + r2);
        return;
    L40:
        ScsLogger.d("SecurityPolicy_SecurityPolicyDialogActionManager", "start new activity to show dialog null");
        return;
    L45:
        return;
    L16:
        if ((r5 instanceof SecurityPolicyPopupWindowActivity) == true) goto L18;
        int r11 = g8b.b.a;
        g8b.b.a.a().getDependency().l(r5);
        goto L29
    L18:
        ScsLogger.d("SecurityPolicy_SecurityPolicyDialogActionManager", "add dialog to ".concat(r5.getClass().getSimpleName()));
        a r12 = (a) d.getValue();
        AppCompatActivity r13 = (AppCompatActivity) r5;
        Fragment r14 = r13.getSupportFragmentManager().findFragmentByTag("sec_dlg");
        if (r12 == null) goto L42;
        if (r14 == null) goto L22;
        return;
    L22:
        if (r13.isDestroyed() == true) goto L44;
        FragmentTransaction r15 = r13.getSupportFragmentManager().beginTransaction();
        SecurityPolicyDialogFragment r16 = new SecurityPolicyDialogFragment();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r15, r16, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "sec_dlg", 0) == true) goto L27;
        r15 = r15.add(r16, "sec_dlg");
    L27:
        r15.commitAllowingStateLoss();
        return;
    L44:
        return;
    L42:
        return;
    L11:
        if (w4c.c.a().X() == false) goto L13;
        int r17 = g8b.b.a;
        g8b.b.a.a().getDependency().i(r5);
        goto L13
    L5:
        r3 = null;
        goto L6
    }

    public static void c(final InternalSecurityAction r4) {
        Intrinsics.checkNotNullParameter(r4, Keys.API_PARAM_KEY_ACTION);
        int r0 = g8b.b.a;
        t4c.a.b(t4c.a.a(g8b.b.a.a().getDependency().c()).doOnEvent(b.a), b, new SecurityPolicyDialogActionManager$getDeviceDeclareSwitch$2(r4), new SecurityPolicyDialogActionManager$getDeviceDeclareSwitch$3(r4));
    }

    public final void d(@FilePolicyDialogType int r4, InternalSecurityAction r5) {
        Intrinsics.checkNotNullParameter(r5, Keys.API_PARAM_KEY_ACTION);
        String r0 = r5.getCurrentAction().getParams().get("entity_operation");
        if (r0 != null) goto L5;
        r0 = BuildConfig.FLAVOR;
    L5:
        int r1 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_SecurityPolicyDialogActionManager", "[start show dialog], handleFilePolicyAction(), operation:" + r0 + ", dialogType is " + r4);
        f(r4, r5);
    }

    public final void f(int r8, InternalSecurityAction r9) {
        Intrinsics.checkNotNullParameter(r9, Keys.API_PARAM_KEY_ACTION);
        String r0 = qqb.a.d();
        Object r1 = r9.getInternalParams().get("comeFrom");
        if (r1 != null) goto L5;
        r1 = "SDK_INTERNAL";
    L5:
        String r2 = (String) r1;
        int r3 = g8b.b.a;
        if (g8b.b.a.a().j() == false) goto L10;
        ScsLogger.d("SecurityPolicy_SecurityPolicyDialogActionManager", "startPopupDialog(), NoPermissionModuleManager.getCurrentUnauthorizedType() != null");
        FileAuthMonitor.UpdateTrigger[] r10 = FileAuthMonitor.a;
        FileAuthMonitor.o(r2, r9.toString(), "inNoAccessStatus");
        return;
    L10:
        if (c.getValue() == null) goto L13;
        ScsLogger.d("SecurityPolicy_SecurityPolicyDialogActionManager", "dialog already exist");
        FileAuthMonitor.UpdateTrigger[] r11 = FileAuthMonitor.a;
        FileAuthMonitor.o(r2, r9.toString(), "dialogAlreadyExist");
        return;
    L13:
        String r4 = r9.getCurrentAction().getParams().get("policyType");
        if (Intrinsics.areEqual(r4, "POLICY_CENTER") == true) goto L16;
        int r5 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_SecurityPolicyDialogActionManager", "snapshot skipped, not policy center, policyType: " + r4);
    L26:
        boolean r6 = false;
        if (ArraysKt.contains(new Integer[]{9, 92}, Integer.valueOf(r8)) == true) goto L29;
        e(this, r8, r9);
        return;
    L29:
        String r7 = r9.getCurrentAction().getParams().get("displayID");
        if (r7 != null) goto L32;
    L33:
        r6 = true;
    L34:
        if (r6 == false) goto L37;
        ScsLogger.c("SecurityPolicy_SecurityPolicyDialogActionManager", "displayID is empty!");
        FileAuthMonitor.UpdateTrigger[] r12 = FileAuthMonitor.a;
        FileAuthMonitor.e(101, r9.toString());
        SecurityDialogUtil.b(r9);
        return;
    L37:
        Object r13 = new Object();
        if (w4c.c.a().Q() == false) goto L40;
        LarkAppContext.Companion.getClass();
        Single<? extends CustomDisplayConfig> r14 = ((com.ss.android.lark.conditional.access.display.g) e0c.k.a(LarkAppContext.access$getInstance$cp().getContext(), com.ss.android.lark.conditional.access.display.g.class)).Ld(r7, r0);
    L41:
        r14.doOnSubscribe(new c(r13)).doOnEvent(new d(r13)).subscribe(new e(r0, r9, r8), new f(r0, r7, r8, r9));
        return;
    L40:
        LarkAppContext.Companion.getClass();
        r14 = ((com.ss.android.lark.conditional.access.display.g) e0c.k.a(LarkAppContext.access$getInstance$cp().getContext(), com.ss.android.lark.conditional.access.display.g.class)).ye(r7, r0).map(j.a).timeout(w4c.c.a().g(), TimeUnit.MILLISECONDS);
        Intrinsics.checkNotNull(r14);
        goto L41
    L32:
        if (r7.length() != 0) goto L34;
    L16:
        SecurityActionHandleContext r15 = r9.getHandleContext();
        if (r15 == null) goto L19;
        String r16 = r15.getPointKey();
    L20:
        if (r16 != null) goto L22;
    L25:
        int r17 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_SecurityPolicyDialogActionManager", "snapshot skipped, pointKey not in clear cache list, pointKey: " + r16);
        goto L26
    L22:
        if (w4c.c.a().p0().contains(r16) == false) goto L25;
        List<PolicyModel> r18 = g8b.b.a.a().getDependency().f();
        r9.getInternalParams().put("filePolicyModelsSnapshot", r18);
        int r19 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_SecurityPolicyDialogActionManager", "snapshot file policy models before dialog show, size: " + r18.size());
        goto L26
    L19:
        r16 = null;
        goto L20
    }

    public static void e(SecurityPolicyDialogActionManager r4, final int r5, final InternalSecurityAction r6) {
        final String r0 = qqb.a.d();
        r4.getClass();
        String r1 = qqb.a.d();     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r0, "traceId");     // Catch: Throwable -> L7
        qqb.a.g(r0);     // Catch: Throwable -> L7
        ScsLogger.d("SecurityPolicy_SecurityPolicyDialogActionManager", "showDialogInternal");     // Catch: Throwable -> L7
        ((Handler) SecurityDialogUtil.d.getValue()).post(new SecurityPolicyDialogActionManager$showDialogInternal$1$1(r5, r6, r0));     // Catch: Throwable -> L7
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r1, "traceId");
        qqb.a.g(r1);
        return;
    L7:
        th = th;
    L11:
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r1, "traceId");
        qqb.a.g(r1);
        throw th;
    L9:
        th = th;
        r1 = BuildConfig.FLAVOR;
        goto L11
    }
}
