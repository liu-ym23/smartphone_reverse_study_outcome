package com.ss.android.lark.conditional.access.nopermission.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.universe_design.button.UDButton;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.utils.NoPermissionType;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@DwarfInjectPoint(parent = NoPermissionActivity.class)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0002J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0002J\b\u0010\u0017\u001a\u00020\u000eH\u0014J\b\u0010\u0018\u001a\u00020\u000eH\u0002J\b\u0010\u0019\u001a\u00020\u000eH\u0002J\b\u0010\u001a\u001a\u00020\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/conditional/access/nopermission/ui/DeviceAuthenticationNoPermissionFragment;", "Lcom/ss/android/lark/conditional/access/nopermission/ui/NoPermissionFragment;", "<init>", "()V", Keys.API_RETURN_KEY_NONCE, BuildConfig.FLAVOR, "challengeType", BuildConfig.FLAVOR, "needCertVerify", BuildConfig.FLAVOR, "firstLoad", "disposable", "Lio/reactivex/disposables/Disposable;", "onViewCreated", BuildConfig.FLAVOR, "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "initObserver", "initView", "initData", "parseDeviceChallenge", "onPrimaryButtonClick", "showButtonLoading", "resetButton", "onPageUpdate", "Companion", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceAuthenticationNoPermissionFragment extends Hilt_DeviceAuthenticationNoPermissionFragment {
    public static final /* synthetic */ int o = 0;
    public String j;
    public int k;
    public boolean l;
    public boolean m;
    public Disposable n;

    public static final class a {
    }

    static {
    }

    public final void initView() {
        this.m = true;
        S90().j.setText(requireContext().getText(2131890517));
        S90().h.setText(requireContext().getText(2131890515));
        S90().g.setText(requireContext().getText(2131890519));
        Y90();
        t4c.b.a(S90().f);
        t4c.b.a(S90().b);
        t4c.b.b(S90().e.a);
        S90().e.e.setText(requireContext().getText(2131890511));
        t4c.b.b(S90().e.e);
        S90().e.d.setText(requireContext().getText(2131890512));
        S90().e.b.playAnimation();
    }

    public DeviceAuthenticationNoPermissionFragment() {
        super(NoPermissionType.DEVICE_AUTHENTICATION);
        this.j = BuildConfig.FLAVOR;
        this.m = true;
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionFragment
    public final void U90() {
        ScsLogger.d("SecurityPolicy_DeviceAuthenticationNoPermissionFragment", "btnDeviceDeclare onClick");
        Z90();
        qqb.a.h("DeviceAuthenticationNoPermissionFragment button click device authentication");     // Catch: Throwable -> L6
        this.n = T90().startDeviceAuthentication(qqb.a.d());     // Catch: Throwable -> L6
        qqb.a.a();
        return;
    L6:
        th = move-exception;
        qqb.a.a();
        throw th;
    }

    public final void initData() {
        InternalSecurityAction r0 = this.g;
        if (r0 == null) goto L7;
        DecisionData.Action r1 = r0.getCurrentAction();
        if (r1 == null) goto L7;
        m8b.c r2 = com.ss.android.lark.conditional.access.network.model.response.a.b(r1);
    L8:
        if (r2 == null) goto L11;
        String r3 = r2.b;
        if (r3 == null) goto L11;
    L12:
        this.j = r3;
        boolean r4 = false;
        if (r2 == null) goto L17;
        Integer r5 = r2.a;
        if (r5 == null) goto L17;
        int r6 = r5.intValue();
    L18:
        this.k = r6;
        if (r2 == null) goto L23;
        m8b.a r7 = r2.c;
        if (r7 == null) goto L23;
        boolean r8 = r7.a;
    L24:
        this.l = r8;
        qqb.a.h("DeviceAuthenticationNoPermissionFragment silent device authentication");     // Catch: Throwable -> L32
        if (this.j.length() <= 0) goto L28;
        r4 = true;
    L28:
        if (r4 == false) goto L30;
        this.n = T90().startDeviceAuthenticationWithNonce(qqb.a.d(), this.j, this.k, this.l);     // Catch: Throwable -> L32
    L30:
        qqb.a.a();
        return;
    L32:
        th = move-exception;
        qqb.a.a();
        throw th;
    L23:
        r8 = false;
    L17:
        r6 = 0;
    L11:
        r3 = BuildConfig.FLAVOR;
    L7:
        r2 = null;
        goto L8
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionFragment, com.ss.android.lark.conditional.access.nopermission.ui.y
    public final void onPageUpdate() {
        ScsLogger.d("SecurityPolicy_DeviceAuthenticationNoPermissionFragment", "onPageUpdate");
        Disposable r0 = this.n;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        initView();
        initData();
    }

    public final void Y90() {
        UDButton r0 = S90().c;
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L5;
        String r2 = r1.getString(2131890519);
    L6:
        com.larksuite.component.universe_design.button.e.a r3 = com.larksuite.component.universe_design.button.e.a;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        com.larksuite.component.universe_design.button.e.b(r0, r2);
        S90().c.setEnabled(true);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void Z90() {
        UDButton r0 = S90().c;
        com.larksuite.component.universe_design.button.d r1 = new com.larksuite.component.universe_design.button.d();
        FragmentActivity r2 = getActivity();
        Integer r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.getString(2131890516);
    L6:
        ((com.larksuite.component.universe_design.button.a) r1).b = r4;
        FragmentActivity r5 = getActivity();
        if (r5 == null) goto L11;
        Resources r6 = r5.getResources();
        if (r6 == null) goto L11;
        r3 = Integer.valueOf(r6.getColor(2131106521));
    L11:
        r1.j = r3;
        com.larksuite.component.universe_design.button.e.g(r0, r1);
        S90().c.setEnabled(false);
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        ScsLogger.d("SecurityPolicy_DeviceAuthenticationNoPermissionFragment", "onViewCreated");
        initView();
        T90().getAuthLiveData().observe(getViewLifecycleOwner(), new d(this));
        initData();
    }
}
