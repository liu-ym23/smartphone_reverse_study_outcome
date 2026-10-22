package com.ss.android.lark.contact.base.contact_list.mvp;

import android.content.Context;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.loading.LKUIStatus;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.contact.base.common_ui.IndexBar;
import com.ss.android.lark.contact.base.contact_list.page.ExternalContactFragment2;
import com.ss.android.lark.contact.base.contact_list.view.ExternalContactAdapter2;
import com.ss.android.lark.contact.base.contact_list.view.FloatingBarItemDecoration;
import com.ss.android.lark.contact.base.dependency.ContactBaseModuleDependency;
import com.ss.android.lark.dynamicconfig.interfaces.IFeatureSwitchService$FeatureKey;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.utils.q;
import com.ss.android.lark.widget.ChatWindowPtrLoadingHeader;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ExternalContactView2 implements m {
    public Context a;
    public c b;
    public m.a c;
    public ExternalContactAdapter2 d;
    public LKUIStatus e;
    public boolean f;

    @BindView(8807)
    View mExternalAddLayout;

    @BindView(8808)
    TextView mExternalAddTv;

    @BindView(8809)
    ViewGroup mExternalContactContentLayout;

    @BindView(8810)
    View mExternalContactEmptyLayout;

    @BindView(8811)
    ViewGroup mExternalContactLayout;

    @BindView(8813)
    RecyclerView mExternalContactRV;

    @BindView(8812)
    LKUIPtrClassicFrameLayout mPtrFrame;

    @BindView(8814)
    CommonTitleBar mTitleBar;

    public static class a {
        public FloatingBarItemDecoration a;

        public a() {
        }
    }

    public static class b {
        public final FrameLayout a;
        public final TextView b;
        public final IndexBar c;
        public Vibrator d;

        public b(ViewGroup r3) {
            this.a = (FrameLayout) r3.findViewById(2131375221);
            TextView r0 = (TextView) r3.findViewById(2131375223);
            this.b = r0;
            this.c = (IndexBar) r3.findViewById(2131375220);
            r0.setVisibility(8);
        }
    }

    public interface c {
    }

    public final void destroy() {
        this.b = null;
        this.c = null;
    }

    public final void create() {
        ButterKnife.bind(this, ((ExternalContactFragment2.a) this.b).a.e);
        this.a = this.mTitleBar.getContext();
        boolean r0 = FeatureGatingModule.getFeatureGatingService().isEnable("contact.external.alphabetic.group");
        if (r0 == false) goto L14;
        yob.e.a().getClass();
        com.ss.android.lark.language.service.impl.c r3 = com.ss.android.lark.language.service.impl.c.a.a;
        if (r3 == null) goto L14;
        if (r3.b() == false) goto L9;
    L12:
        boolean r4 = true;
    L13:
        this.f = r4;
        goto L14
    L9:
        if (r3.c() == true) goto L12;
        r4 = false;
    L14:
        Log.i("ExternalContactView2", "isGroupFgEnable: " + r0 + ", isEnOrZhLang: " + this.f);
        if (ContactBaseModuleDependency.b.isSmallB() == false) goto L17;
        int r1 = 2131891629;
    L18:
        this.mTitleBar.setTitle(r1);
        int r2 = com.ss.android.lark.contact.base.service.a.a;
        Intrinsics.checkNotNullParameter("invite.external.enable", "featureName");
        boolean r5 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("invite.external.enable", false);
        Intrinsics.checkNotNullParameter("invite.union.enable", "featureName");
        boolean r6 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("invite.union.enable", false);
        Intrinsics.checkNotNullParameter(IFeatureSwitchService$FeatureKey.SUITE_TO_C_ENABLE, "featureName");
        boolean r7 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable(IFeatureSwitchService$FeatureKey.SUITE_TO_C_ENABLE, false);
        Log.i("ExternalContactView2", "inviteExternalEnable: " + r5 + ", inviteUnionEnable: " + r6 + ", suiteToCEnable: " + r7);
        if (r6 == false) goto L23;
        if (r5 == true) goto L22;
        if (r7 == false) goto L23;
    L22:
        String r8 = h9b.c.a();
        this.mExternalAddLayout.setVisibility(0);
        this.mExternalAddTv.setText(r8);
        q.a(this.mExternalAddLayout);
        this.mExternalAddLayout.setOnClickListener(new com.ss.android.lark.contact.base.contact_list.mvp.b(this));
    L24:
        ChatWindowPtrLoadingHeader r9 = new ChatWindowPtrLoadingHeader(this.a);
        this.mPtrFrame.setKeepHeaderWhenRefresh(true);
        this.mPtrFrame.setFooterView(r9);
        this.mPtrFrame.addPtrUIHandler(r9);
        this.mPtrFrame.disableWhenHorizontalMove(true);
        this.mExternalContactRV.setLayoutManager(new LinearLayoutManager(this.a, 1, false));
        if (this.d != null) goto L27;
        this.d = new ExternalContactAdapter2();
    L27:
        ExternalContactAdapter2 r10 = this.d;
        r10.e = new g(this);
        this.mExternalContactRV.setAdapter(r10);
        if (this.f == false) goto L30;
        this.d.c = true;
        final b r11 = new b(this.mExternalContactLayout);
        final RecyclerView r12 = this.mExternalContactRV;
        r11.c.setOnTouchingLetterChangedListener(new j(r11, r12));
        r12.getAdapter().A2(new i(r11, r12));
        r12.addOnScrollListener(new k(r11));
        a r13 = new a();
        RecyclerView r14 = this.mExternalContactRV;
        FloatingBarItemDecoration r15 = new FloatingBarItemDecoration(r14.getContext(), this.d.b);
        r13.a = r15;
        r14.addItemDecoration(r15);
        r14.getAdapter().A2(new h(r13, r14));
    L33:
        this.e = new LKUIStatus(new LKUIStatus.b(this.mExternalContactContentLayout));
        return;
    L30:
        this.d.c = false;
        ViewGroup r16 = this.mExternalContactLayout;
        FrameLayout r17 = (FrameLayout) r16.findViewById(2131375221);
        TextView r18 = (TextView) r16.findViewById(2131375223);
        IndexBar r19 = (IndexBar) r16.findViewById(2131375220);
        r18.setVisibility(8);
        if (r17 == null) goto L33;
        r17.setVisibility(8);
    L23:
        this.mExternalAddLayout.setVisibility(8);
        goto L24
    L17:
        r1 = 2131892246;
        goto L18
    }

    @Override // com.ss.android.lark.contact.base.contact_list.mvp.m
    public final void hideLoading() {
        this.e.b();
    }

    @Override // com.ss.android.lark.contact.base.contact_list.mvp.m
    public final List<w8b.a> j6() {
        ExternalContactAdapter2 r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getItems();
    }

    @Override // com.ss.android.lark.contact.base.contact_list.mvp.m
    public final void l3() {
        this.mPtrFrame.setVisibility(8);
        this.mExternalContactEmptyLayout.setVisibility(0);
        y9c.d.k(this.mExternalContactEmptyLayout);
    }

    @Override // com.ss.android.lark.contact.base.contact_list.mvp.m
    public final void showLoading() {
        LKUIStatus r0 = this.e;
        r0.f = r0.f;
        r0.i = 3;
        r0.a.postDelayed(r0.k, 300);
    }

    public ExternalContactView2(c r1) {
        this.b = r1;
    }

    @Override // com.ss.android.lark.contact.base.contact_list.mvp.m
    public final void O6(w8b.a r2) {
        this.d.remove(r2);
        if (CollectionUtils.isEmpty(this.d.getItems()) == false) goto L6;
        l3();
        return;
    }

    @Override // com.ss.android.lark.contact.base.contact_list.mvp.m
    public final void Q4(Chatter r3) {
        ExternalContactFragment2.a r0 = (ExternalContactFragment2.a) this.b;
        r0.getClass();
        ContactBaseModuleDependency.b.jumpProfilePage(r0.a.getActivity(), r3);
    }

    @Override // com.ss.android.lark.contact.base.contact_list.mvp.m
    public final void o2(List<w8b.a> r3) {
        this.mPtrFrame.setVisibility(0);
        this.mExternalContactEmptyLayout.setVisibility(8);
        if (this.f == false) goto L6;
        if (r3 == null) goto L6;
        Collections.sort(r3);
    L6:
        this.d.clear();
        this.d.addAll(r3);
    }

    @Override // com.ss.android.lark.contact.base.contact_list.mvp.m
    public final void p4(w8b.a r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        String r0 = r6.e;
        boolean r1 = r6.k;
        if (TextUtils.isEmpty(r0) == false) goto L8;
        Log.e("remove external contact failed: chatter id is empty");
        return;
    L8:
        List r2 = this.d.getItems();
        if (r1 == false) goto L18;
        Iterator r7 = r2.iterator();
    L12:
        if (r7.hasNext() == false) goto L34;
        w8b.a r3 = (w8b.a) r7.next();
        if (r3 == null) goto L12;
        if (TextUtils.equals(r0, r3.e) == false) goto L12;
        this.d.remove(r3);
    L34:
        if (CollectionUtils.isEmpty(r2) == false) goto L36;
        l3();
        return;
    L36:
        this.mPtrFrame.setVisibility(0);
        this.mExternalContactEmptyLayout.setVisibility(8);
        return;
    L18:
        int r4 = 0;
    L20:
        if (r4 >= r2.size()) goto L27;
        w8b.a r5 = (w8b.a) ListProtector.get(r2, r4);
        if (r5 == null) goto L26;
        if (TextUtils.equals(r0, r5.e) == false) goto L26;
        ListProtector.set(r2, r4, r6);
        this.d.notifyItemChanged(r6);
        boolean r8 = true;
    L28:
        if (r8 == true) goto L34;
        if (this.f == false) goto L32;
        ArrayList r9 = new ArrayList(r2);
        r9.add(r6);
        Collections.sort(r9);
        this.d.diff(r9);
        goto L34
    L32:
        this.d.add(r6);
    L26:
        r4 = r4 + 1;
        goto L20
    L27:
        r8 = false;
        goto L28
    }

    public final void setViewDelegate(IView.IViewDelegate r1) {
        this.c = (m.a) r1;
    }

    @Override // com.ss.android.lark.contact.base.contact_list.mvp.m
    public final void z(int r2) {
        Context r3 = this.a;
        if (r3 == null) goto L6;
        UDToast.show(r3, 2131891667);
        return;
    }
}
