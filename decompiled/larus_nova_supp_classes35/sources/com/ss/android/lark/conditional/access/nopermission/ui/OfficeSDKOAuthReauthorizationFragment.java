package com.ss.android.lark.conditional.access.nopermission.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.conditional.access.utils.NoPermissionType;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@DwarfInjectPoint(parent = NoPermissionActivity.class)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\rH\u0014J\b\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\rH\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J\b\u0010\u0017\u001a\u00020\rH\u0002J\b\u0010\u0018\u001a\u00020\rH\u0002J\b\u0010\u0019\u001a\u00020\rH\u0002J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/ss/android/lark/conditional/access/nopermission/ui/OfficeSDKOAuthReauthorizationFragment;", "Lcom/ss/android/lark/conditional/access/nopermission/ui/NoPermissionFragment;", "<init>", "()V", "isAuthorizing", BuildConfig.FLAVOR, "authorizationRequestId", BuildConfig.FLAVOR, "resetLoadingRunnable", "Ljava/lang/Runnable;", "mainHandler", "Landroid/os/Handler;", "onViewCreated", BuildConfig.FLAVOR, "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onPrimaryButtonClick", "onPageUpdate", "onDestroyView", "scheduleLoadingFallback", "requestId", "cancelLoadingFallback", "invalidateAuthorizationRequest", "renderPage", "setAuthorizing", "authorizing", "getAuthorizeButtonText", BuildConfig.FLAVOR, "handleAuthorizationResult", ChameleonOpenTracker.ParamKey.RESULT, "Lcom/ss/android/lark/conditional/access/dependency/DeviceTokenClaimsChallengeResult;", "showGenericError", "Companion", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSDKOAuthReauthorizationFragment extends Hilt_OfficeSDKOAuthReauthorizationFragment {
    public boolean j;
    public long k;
    public Runnable l;
    public final Handler m;

    public static final class a {
    }

    public static final class b implements k8b.d {
        public final /* synthetic */ OfficeSDKOAuthReauthorizationFragment a;
        public final /* synthetic */ long b;

        public static final class a implements Runnable {
            public final /* synthetic */ OfficeSDKOAuthReauthorizationFragment a;
            public final /* synthetic */ long b;
            public final /* synthetic */ k8b.b c;

            public a(OfficeSDKOAuthReauthorizationFragment r1, long r2, k8b.b r4) {
                this.a = r1;
                this.b = r2;
                this.c = r4;
            }

            public final void a() {
                if (this.a.isAdded() == true) goto L5;
                return;
            L5:
                if (this.a.getView() == null) goto L44;
                long r0 = this.b;
                OfficeSDKOAuthReauthorizationFragment r2 = this.a;
                if (r0 != r2.k) goto L45;
                r2.Y90();
                boolean r1 = false;
                this.a.aa0(false);
                OfficeSDKOAuthReauthorizationFragment r3 = this.a;
                k8b.b r4 = this.c;
                r3.getClass();
                if (Intrinsics.areEqual(r4, k8b.b.d.a) == false) goto L12;
                ScsLogger.d("SecurityPolicy_OfficeSDKOAuthReauthorizationFragment", "OAuth reauthorization success, start ping");
                r3.W90("device_token_claims_challenge");
                return;
            L12:
                String r6 = null;
                if ((r4 instanceof k8b.b.c) == false) goto L27;
                int r5 = ScsLogger.a;
                StringBuilder r7 = new StringBuilder("OAuth reauthorization failed, code=");
                k8b.b.c r8 = (k8b.b.c) r4;
                r7.append(r8.a);
                ScsLogger.c("SecurityPolicy_OfficeSDKOAuthReauthorizationFragment", r7.toString());
                FileAuthMonitor.UpdateTrigger[] r9 = FileAuthMonitor.a;
                FileAuthMonitor.j("page", r8.a, r8.b);
                String r10 = r8.b;
                if (r10 == null) goto L23;
                String r11 = StringsKt.trim(r10).toString();
                if (r11 == null) goto L23;
                if (r11.length() <= 0) goto L21;
                r1 = true;
            L21:
                if (r1 == false) goto L23;
                r6 = r11;
            L23:
                if (r6 != null) goto L25;
                r3.ba0();
                return;
            L25:
                UDToast.show(r3.requireContext(), r6);
                return;
            L27:
                if (Intrinsics.areEqual(r4, k8b.b.C0247b.a) == false) goto L30;
                ScsLogger.d("SecurityPolicy_OfficeSDKOAuthReauthorizationFragment", "OAuth reauthorization cancelled");
                FileAuthMonitor.UpdateTrigger[] r12 = FileAuthMonitor.a;
                FileAuthMonitor.j("page", "cancelled", null);
                return;
            L30:
                if (Intrinsics.areEqual(r4, k8b.b.a.a) == false) goto L33;
                ScsLogger.c("SecurityPolicy_OfficeSDKOAuthReauthorizationFragment", "OAuth reauthorization failed, app not installed");
                FileAuthMonitor.UpdateTrigger[] r13 = FileAuthMonitor.a;
                FileAuthMonitor.j("page", "app_not_installed", null);
                r3.ba0();
                return;
            L33:
                if (Intrinsics.areEqual(r4, k8b.b.e.a) == false) goto L37;
                ScsLogger.c("SecurityPolicy_OfficeSDKOAuthReauthorizationFragment", "OAuth reauthorization unsupported");
                FileAuthMonitor.UpdateTrigger[] r14 = FileAuthMonitor.a;
                FileAuthMonitor.j("page", "unsupported", null);
                r3.ba0();
                return;
            L37:
                throw new NoWhenBranchMatchedException();
            L45:
                return;
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

        @Override // k8b.d
        public final void a(k8b.b r6) {
            Intrinsics.checkNotNullParameter(r6, ChameleonOpenTracker.ParamKey.RESULT);
            if (this.a.isAdded() == true) goto L5;
            return;
        L5:
            if (this.a.getView() == null) goto L10;
            OfficeSDKOAuthReauthorizationFragment r0 = this.a;
            r0.m.post(new a(r0, this.b, r6));
            return;
        }

        public b(OfficeSDKOAuthReauthorizationFragment r1, long r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public OfficeSDKOAuthReauthorizationFragment() {
        super(NoPermissionType.OAUTH_REAUTHORIZATION);
        this.m = new Handler(Looper.getMainLooper());
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionFragment
    public final void U90() {
        if (this.j == false) goto L5;
        return;
    L5:
        InternalSecurityAction r0 = this.g;
        if (r0 == null) goto L19;
        DecisionData.Action r1 = r0.getCurrentAction();
        if (r1 == null) goto L19;
        String r2 = com.ss.android.lark.conditional.access.network.model.response.a.b(r1).d;
        if (r2 == null) goto L19;
        String r3 = StringsKt.trim(r2).toString();
        if (r3 == null) goto L19;
        if (r3.length() <= 0) goto L16;
        boolean r4 = true;
    L17:
        if (r4 == false) goto L19;
    L20:
        if (r3 != null) goto L23;
        ScsLogger.c("SecurityPolicy_OfficeSDKOAuthReauthorizationFragment", "OAuth challenge code is missing");
        FileAuthMonitor.UpdateTrigger[] r5 = FileAuthMonitor.a;
        FileAuthMonitor.j("page", "missing_challenge_code", null);
        ba0();
        return;
    L23:
        aa0(true);
        long r6 = this.k + 1;
        this.k = r6;
        int r7 = g8b.b.a;
        g8b.b.a.a().getDependency().getPassportDependency().a(r3, new b(this, r6));
        Y90();
        w r8 = new w(r6, this);
        S90().a.postDelayed(r8, 2000);
        this.l = r8;
        return;
    L16:
        r4 = false;
    L19:
        r3 = null;
        goto L20
    }

    public final void Y90() {
        Runnable r0 = this.l;
        if (r0 == null) goto L5;
        S90().a.removeCallbacks(r0);
    L5:
        this.l = null;
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionFragment
    public final void onDestroyView() {
        this.k++;
        Y90();
        this.j = false;
        super.onDestroyView();
    }

    public final void Z90() {
        S90().j.setText(getString(2131892537));
        S90().h.setText(UIHelper.mustacheFormat(2131892543, "APP_DISPLAY_NAME", UIHelper.getString(2131891485)));
        t4c.b.a(S90().b);
        UDButton r0 = S90().c;
        r0.setText(getString(2131890501));
        r0.setEnabled(true);
        Intrinsics.checkNotNull(r0);
        t4c.b.b(r0);
        UDButton r1 = S90().d;
        r1.setText(getString(2131890531));
        r1.setEnabled(true);
        Intrinsics.checkNotNull(r1);
        t4c.b.b(r1);
    }

    public final void ba0() {
        if (isAdded() == false) goto L6;
        UDToast.show(requireContext(), getString(2131890543));
        return;
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionFragment, com.ss.android.lark.conditional.access.nopermission.ui.y
    public final void onPageUpdate() {
        super.onPageUpdate();
        this.k++;
        Y90();
        aa0(false);
        Z90();
    }

    public final void aa0(boolean r5) {
        this.j = r5;
        if (r5 == false) goto L5;
        UDButton r1 = S90().c;
        com.larksuite.component.universe_design.button.d r2 = new com.larksuite.component.universe_design.button.d();
        ((com.larksuite.component.universe_design.button.a) r2).b = getString(2131890501);
        r2.j = Integer.valueOf(ContextCompat.getColor(requireContext(), 2131106521));
        com.larksuite.component.universe_design.button.e.g(r1, r2);
    L6:
        S90().c.setEnabled(!r5);
        return;
    L5:
        UDButton r3 = S90().c;
        String r0 = getString(2131890501);
        com.larksuite.component.universe_design.button.e.a r4 = com.larksuite.component.universe_design.button.e.a;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        com.larksuite.component.universe_design.button.e.b(r3, r0);
        goto L6
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        Z90();
    }
}
