package com.ss.android.lark.conditional.access.nopermission.ui;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.utils.NoPermissionType;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@DwarfInjectPoint(parent = NoPermissionActivity.class)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\rH\u0002J\b\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\rH\u0002J\b\u0010\u0015\u001a\u00020\rH\u0002J\b\u0010\u0016\u001a\u00020\rH\u0002J\b\u0010\u0017\u001a\u00020\rH\u0002J\b\u0010\u0018\u001a\u00020\rH\u0014J\b\u0010\u0019\u001a\u00020\rH\u0014J\b\u0010\u001a\u001a\u00020\rH\u0016J\b\u0010\u001b\u001a\u00020\bH\u0002J\b\u0010\u001c\u001a\u00020\rH\u0002J\b\u0010\u001d\u001a\u00020\rH\u0016J\b\u0010\u001e\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/ss/android/lark/conditional/access/nopermission/ui/MFANoPermissionFragment;", "Lcom/ss/android/lark/conditional/access/nopermission/ui/NoPermissionFragment;", "<init>", "()V", "mScopeVerifyToken", BuildConfig.FLAVOR, "mUnit", "firstLoadPage", BuildConfig.FLAVOR, "startMFAStatus", "loadingToast", "Lcom/larksuite/component/universe_design/toast/UDToastImpl;", "onViewCreated", BuildConfig.FLAVOR, "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "renderNormalMfaPage", "onResume", "verifyMFAStatus", "setupMFAVerifyButton", "resetMFAVerifyButton", "gotoMFAAuth", "onPrimaryButtonClick", "onRetryButtonClick", "onPageUpdate", "isOfficeSDKDisplayOnly", "renderOfficeSDKDisplayOnly", "onDestroyView", "parseMfaInfo", "Companion", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MFANoPermissionFragment extends Hilt_MFANoPermissionFragment {
    public static final /* synthetic */ int o = 0;
    public String j;
    public String k;
    public boolean l;
    public boolean m;
    public com.ss.android.lark.compose.foundation.toast.g n;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ MFANoPermissionFragment a;

        public b(MFANoPermissionFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Integer r5 = (Integer) r4;
            if (r5 != null) goto L6;
        L8:
            if (r5 != null) goto L11;
        L13:
            ScsLogger.d("SecurityPolicy_MFANoPermissionFragment", "observe: not MFA_AUTHORIZED & MFA_UNAUTHORIZED");
            MFANoPermissionFragment r6 = this.a;
            int r0 = MFANoPermissionFragment.o;
            r6.ca0();
            FragmentActivity r7 = this.a.getActivity();
            if (r7 == null) goto L19;
            UDToast.show(r7, r7.getString(2131890507));
            return;
        L19:
            return;
        L11:
            if (r5.intValue() != 2) goto L13;
            ScsLogger.d("SecurityPolicy_MFANoPermissionFragment", "observe: MFA_UNAUTHORIZED");
            MFANoPermissionFragment r8 = this.a;
            int r1 = MFANoPermissionFragment.o;
            r8.ca0();
            this.a.W90("refresh_button");
            return;
        L6:
            if (r5.intValue() != 1) goto L8;
            ScsLogger.d("SecurityPolicy_MFANoPermissionFragment", "observe: MFA_AUTHORIZED");
            this.a.W90("mfa_success");
        }
    }

    static {
    }

    public MFANoPermissionFragment() {
        super(NoPermissionType.MFA);
        this.j = BuildConfig.FLAVOR;
        this.l = true;
    }

    public static boolean Y90() {
        LarkAppContext.Companion.getClass();
        return LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK();
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionFragment
    public final void V90() {
        ScsLogger.d("SecurityPolicy_MFANoPermissionFragment", "onRetryButtonClick");
        if (Y90() == false) goto L5;
        super.V90();
        return;
    L5:
        da0();
    }

    public final void Z90() {
        InternalSecurityAction r0 = this.g;
        if (r0 == null) goto L5;
        DecisionData.Action r1 = r0.getCurrentAction();
    L6:
        if (r1 == null) goto L18;
        Map<String, String> r2 = r1.getParams();
        if (r2 == null) goto L19;
        String r3 = r2.get("mfa-token");
        String r4 = BuildConfig.FLAVOR;
        if (r3 != null) goto L12;
        r3 = BuildConfig.FLAVOR;
    L12:
        this.j = r3;
        String r5 = r2.get("unit");
        if (r5 == null) goto L16;
        r4 = r5;
    L16:
        this.k = r4;
        return;
    L19:
        return;
    L18:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void ba0() {
        com.ss.android.lark.compose.foundation.toast.g r0 = this.n;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.n = null;
        this.m = false;
        S90().h.setText(UIHelper.mustacheFormat(2131892544, "APP_DISPLAY_NAME", UIHelper.getString(2131891485)));
        t4c.b.a(S90().b);
        t4c.b.a(S90().c);
        UDButton r1 = S90().d;
        r1.setEnabled(true);
        Intrinsics.checkNotNull(r1);
        t4c.b.b(r1);
    }

    public final void ca0() {
        com.ss.android.lark.compose.foundation.toast.g r0 = this.n;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.n = null;
        S90().c.setEnabled(true);
        S90().d.setEnabled(true);
    }

    public final void da0() {
        ScsLogger.d("SecurityPolicy_MFANoPermissionFragment", "verifyMFAStatus");
        com.ss.android.lark.compose.foundation.toast.g r0 = x08.a.b(requireContext(), getString(2131890551));
        this.n = r0;
        r0.show();
        S90().c.setEnabled(false);
        S90().d.setEnabled(false);
        T90().checkMfaState(requireActivity(), this.j, this.k);
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionFragment
    public final void U90() {
        if (Y90() == false) goto L5;
        return;
    L5:
        ScsLogger.d("SecurityPolicy_MFANoPermissionFragment", "btnToVerify onClick");
        ScsLogger.d("SecurityPolicy_MFANoPermissionFragment", "gotoMFAAuth");
        this.m = true;
        T90().startMfaAuth(requireActivity(), this.j, this.k);
    }

    public final void aa0() {
        S90().h.setText(requireContext().getText(2131890545));
        t4c.b.a(S90().b);
        UDButton r0 = S90().c;
        r0.setText(requireContext().getText(2131890502));
        r0.setEnabled(false);
        Intrinsics.checkNotNull(r0);
        t4c.b.b(r0);
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionFragment
    public final void onDestroyView() {
        super.onDestroyView();
        com.ss.android.lark.compose.foundation.toast.g r0 = this.n;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.n = null;
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionFragment, com.ss.android.lark.conditional.access.nopermission.ui.y
    public final void onPageUpdate() {
        super.onPageUpdate();
        ScsLogger.d("SecurityPolicy_MFANoPermissionFragment", "onPageUpdate");
        this.l = true;
        this.m = false;
        if (Y90() == false) goto L6;
        ba0();
        return;
    L6:
        Z90();
        aa0();
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        if (Y90() == false) goto L6;
        return;
    L6:
        if (this.l == false) goto L9;
        ScsLogger.d("SecurityPolicy_MFANoPermissionFragment", "onResume: firstLoadPage");
        this.l = false;
        ca0();
        return;
    L9:
        if (this.m == false) goto L13;
        ScsLogger.d("SecurityPolicy_MFANoPermissionFragment", "onResume: startMFAStatus");
        da0();
        this.m = false;
        return;
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        ScsLogger.d("SecurityPolicy_MFANoPermissionFragment", "onViewCreated");
        if (Y90() == false) goto L6;
        ba0();
        return;
    L6:
        Z90();
        T90().getMfaStatusLiveData().observe(getViewLifecycleOwner(), new b(this));
        aa0();
    }
}
