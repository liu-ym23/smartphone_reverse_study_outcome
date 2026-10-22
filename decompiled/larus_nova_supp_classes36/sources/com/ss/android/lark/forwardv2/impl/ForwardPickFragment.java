package com.ss.android.lark.forwardv2.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import butterknife.ButterKnife;
import com.larksuite.framework.utils.KeyboardUtils;
import com.ss.android.lark.desktopmode.app.DesktopCompatFragment;
import com.ss.android.lark.desktopmode.base.FloatWindowParams;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.forwardv2.dto.ForwardTemplate;
import com.ss.android.lark.forwardv2.dto.template.ForwardFeature;
import com.ss.android.lark.forwardv2.dto.template.IForwardCancelListener;
import com.ss.android.lark.forwardv2.dto.template.IForwardProxyExecutor;
import com.ss.android.lark.forwardv2.e;
import com.ss.android.lark.forwardv2.impl.statistics.ForwardHitpointExtraParams$Scene;
import com.ss.android.lark.forwardv2.impl.view.BaseForwardView;
import com.ss.android.lark.forwardv2.impl.view.d0;
import com.ss.android.lark.forwardv3.utils.ForwardDataUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.suite.lark.component.navroute.forseti.f;
import com.suite.lark.component.navroute.forseti.g;
import hib.d;
import java.util.Collections;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class ForwardPickFragment extends DesktopCompatFragment<FloatWindowParams> implements com.ss.android.lark.ui.b {
    public static final /* synthetic */ int h = 0;
    public final a d;
    public ForwardPresenter e;
    public ForwardTemplate f;
    public long g;

    public class a implements BaseForwardView.c {
        public final /* synthetic */ ForwardPickFragment a;

        @Override // com.ss.android.lark.forwardv2.impl.view.BaseForwardView.c
        public final void c() {
            ForwardTemplate r0 = this.a.f;
            if (r0 == null) goto L5;
            ForwardFeature r1 = r0.c;
        L5:
            d r2 = e.a;
            e.a.a().b(this.a);
        }

        @Override // com.ss.android.lark.forwardv2.impl.view.BaseForwardView.c
        public final void finish() {
            if (this.a.getActivity() != null) goto L6;
            Log.e("ForwardPickFragment", "fragment context is null");
            return;
        L6:
            ForwardPickFragment r0 = this.a;
            int r1 = ForwardPickFragment.h;
            r0.T90();
        }

        public final FragmentActivity g() {
            return this.a.getActivity();
        }

        @Override // com.ss.android.lark.forwardv2.impl.view.BaseForwardView.c
        public Context getContext() {
            return this.a.requireContext();
        }

        @Override // com.ss.android.lark.forwardv2.impl.view.BaseForwardView.c
        public final FragmentManager getFragmentManager() {
            return this.a.getChildFragmentManager();
        }

        public a(ForwardPickFragment r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.forwardv2.impl.view.BaseForwardView.c
        public final void b(String r5) {
            SearchChatInfo r6 = ForwardDataUtils.c(r5);
            if (r6 == null) goto L6;
            final ForwardPresenter r0 = this.a.e;
            r0.a.s(Collections.singletonList(r6), ForwardHitpointExtraParams$Scene.GROUP_CREATE_FROM_FORWARD.getValue());
            d r1 = e.a;
            d r2 = e.a.a();
            r6.getId();
            r2.e(new ForwardPresenter.AnonymousClass6(r0));
            return;
        }

        @Override // com.ss.android.lark.forwardv2.impl.view.BaseForwardView.c
        public final void e(iib.c r2) {
            ButterKnife.bind(r2, this.a.getView());
        }

        @Override // com.ss.android.lark.forwardv2.impl.view.BaseForwardView.c
        public final void f(Bundle r2) {
            if ((this.a.getParentFragment() instanceof com.ss.android.lark.ui.b) == false) goto L6;
            this.a.getParentFragment().Sl("updateTitleBar");
            return;
        }

        @Override // com.ss.android.lark.forwardv2.impl.view.BaseForwardView.c
        public final void a(Context r2, String r3) {
            e.d().a(r2, r3);
        }

        @Override // com.ss.android.lark.forwardv2.impl.view.BaseForwardView.c
        public final void d(int r3, Intent r4) {
            if (r4 != null) goto L4;
            r4 = new Intent();
        L4:
            ForwardPickFragment r0 = this.a;
            if (r4.getExtras() != null) goto L7;
            Bundle r5 = new Bundle();
        L8:
            zab.a.b(r0, r3, r5);
            return;
        L7:
            r5 = r4.getExtras();
            goto L8
        }

        @Override // com.ss.android.lark.forwardv2.impl.view.BaseForwardView.c
        public void setResult(int r3, Intent r4) {
            if (this.a.getActivity() != null) goto L7;
            Log.e("ForwardPickFragment", "fragment context is null");
            return;
        L7:
            if (DesktopUtil.a(this.a.getActivity()) == false) goto L11;
            ForwardPickFragment r0 = this.a;
            if (r0.f.h.a != 0) goto L11;
            r0.setResult(r3, r4);
            return;
        L11:
            this.a.getActivity().setResult(r3, r4);
        }
    }

    public final boolean onBackPressed() {
        ForwardTemplate r0 = this.f;
        if (r0 != null) goto L5;
        return false;
    L5:
        ForwardFeature r1 = r0.c;
        if (r1 != null) goto L8;
        return false;
    L8:
        IForwardCancelListener r2 = r1.m;
        if (r2 == null) goto L12;
        r2.onCancel();
    L12:
        if (r1.i == false) goto L19;
        FragmentActivity r3 = getActivity();
        if (r3 != null) goto L16;
        return false;
    L16:
        if (isAdded() == false) goto L21;
        r3.moveTaskToBack(true);
        T90();
        return true;
    L21:
        return false;
    L19:
        return false;
    }

    public ForwardPickFragment() {
        this.d = new a(this);
        this.g = 0;
    }

    public final void T90() {
        g r0 = f.b(this);
        if (r0 == null) goto L5;
        r0.g(null);
        return;
    L5:
        com.ss.android.lark.ui.component_container.a.d(this, null);
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        ForwardPresenter r0 = this.e;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        KeyboardUtils.hideKeyboard(getContext());
    }

    public final void Sl(String r2) {
        if (r2.equals("multiSelect") == false) goto L5;
        d0 r3 = this.e.a;
        r3.d.s3(r3.f);
        return;
    L5:
        if (r2.equals("onCancel") == false) goto L11;
        this.e.a.onCancelClick();
        this.e.b.a3();
        this.e.a.k();
        return;
    }

    public final void onActivityCreated(final Bundle r2) {
        qqb.c.c(new com.ss.android.lark.forwardv2.impl.a(this, r2));
    }

    public static void S90(ForwardPickFragment r7, Bundle r8) {
        super.onActivityCreated(r8);
        Bundle r9 = r7.getArguments();
        if (r9 != null) goto L5;
        r7.T90();
        return;
    L5:
        r7.f = (ForwardTemplate) r9.getParcelable("parcelable_forward_template");
        r7.g = r9.getLong("start_time");
        ForwardTemplate r10 = r7.f;
        if (r10 != null) goto L8;
    L33:
        r7.T90();
        Log.i("ForwardPickFragment", "onActivityCreated return, Forwardpresenter has not been initialized");
        return;
    L8:
        if (r10.c != null) goto L10;
    L26:
        boolean r0 = false;
    L27:
        if (r0 == false) goto L33;
        r7.getActivity();
        IForwardProxyExecutor r11 = r10.k;
        if (r11 == null) goto L32;
        r11.w();
    L32:
        ForwardPresenter r12 = new ForwardPresenter(r7.g, r7.getActivity(), r7.f, r7.d, r7);
        r7.e = r12;
        r12.create();
        return;
    L10:
        if (r10.a == null) goto L26;
        if (r10.b == null) goto L26;
        if (r10.j != null) goto L18;
        if (r10.k == null) goto L26;
    L18:
        if (r10.e == null) goto L26;
        if (r10.d == null) goto L26;
        if (r10.f == null) goto L26;
        if (r10.h == null) goto L26;
        r0 = true;
        goto L27
    }

    public final void onActivityResult(int r2, int r3, Intent r4) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r2, r3, r4);
        ForwardPresenter r5 = this.e;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r2 != 1911) goto L16;
        com.ss.android.lark.forwardv3.plugins.f r6 = r5.e;
        if (r6 != null) goto L10;
        return;
    L10:
        if (r6.b("forward_at_plugin") == null) goto L15;
        r5.e.b("forward_at_plugin").a(r4);
        return;
    L15:
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131558484, r3, false);
    }
}
