package com.ss.android.lark.contact.base.contact_new.mvp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bytedance.lark.pb.basic.v1.CertificationInfo;
import com.bytedance.lark.pb.basic.v1.TenantNameStatus;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.loading.LKUIStatus;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.contact.base.contact_new.page.NewContactFragment;
import com.ss.android.lark.contact.base.dependency.ContactBaseModuleDependency;
import com.ss.android.lark.contact.base.dto.ChatApplication;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.dynamicconfig.interfaces.IFeatureSwitchService$FeatureKey;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.utils.q;
import com.ss.android.lark.widget.ChatWindowPtrLoadingHeader;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class NewContactView implements com.ss.android.lark.contact.base.contact_new.mvp.b {
    public Context a;
    public com.ss.android.lark.contact.base.contact_new.mvp.b.a b;
    public b c;
    public NewContactAdapter d;
    public LKUIStatus e;

    @BindView(8717)
    ViewGroup mContentView;

    @BindView(9196)
    View mNewContactEmptyLayout;

    @BindView(9198)
    RecyclerView mNewContactRV;

    @BindView(9197)
    LKUIPtrClassicFrameLayout mPtrFrame;

    @BindView(9199)
    CommonTitleBar mTitleBar;

    @BindView(9193)
    RelativeLayout newContactAddExtRl;

    @BindView(9194)
    TextView newContactAddExtTv;

    @BindView(9195)
    TextView newContactSubTitleTv;

    public static class a {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public TenantNameStatus f;
        public String g;
        public ChatApplication.Status h;
        public CertificationInfo i;

        public a() {
        }

        public final boolean equals(Object r4) {
            if (r4 != null) goto L6;
            return false;
        L6:
            if (this != r4) goto L9;
            return true;
        L9:
            if ((r4 instanceof a) == true) goto L11;
            return false;
        L11:
            a r5 = (a) r4;
            String r2 = this.a;
            if (r2 != null) goto L17;
            if (r5.a != null) goto L18;
            return true;
        L18:
            return false;
        L17:
            return r2.equals(r5.a);
        }
    }

    public interface b {
    }

    public final void destroy() {
        this.c = null;
        this.b = null;
    }

    @Override // com.ss.android.lark.contact.base.contact_new.mvp.b
    public final void E6() {
        this.mContentView.setVisibility(8);
        this.mNewContactEmptyLayout.setVisibility(0);
        y9c.d.k(this.mNewContactEmptyLayout);
    }

    public final void create() {
        ButterKnife.bind(this, ((NewContactFragment.a) this.c).a.e);
        this.a = this.mTitleBar.getContext();
        this.mTitleBar.setTitle(2131891632);
        this.mTitleBar.setVisibility(0);
        this.mTitleBar.setImmersive(true);
        this.mTitleBar.setLeftClickListener(new k(this));
        int r0 = com.ss.android.lark.contact.base.service.a.a;
        Intrinsics.checkNotNullParameter("invite.external.enable", "featureName");
        boolean r1 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("invite.external.enable", false);
        Intrinsics.checkNotNullParameter("invite.union.enable", "featureName");
        boolean r4 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("invite.union.enable", false);
        Intrinsics.checkNotNullParameter(IFeatureSwitchService$FeatureKey.SUITE_TO_C_ENABLE, "featureName");
        boolean r3 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable(IFeatureSwitchService$FeatureKey.SUITE_TO_C_ENABLE, false);
        if (r4 == false) goto L7;
        if (r1 == true) goto L6;
        if (r3 == false) goto L7;
    L6:
        this.newContactAddExtRl.setVisibility(0);
        q.a(this.newContactAddExtRl);
        this.newContactAddExtRl.setOnClickListener(new i(this));
        String r2 = h9b.c.a();
        this.newContactAddExtTv.setText(r2);
    L9:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.client.contact.opt") == false) goto L11;
        this.newContactSubTitleTv.setVisibility(0);
    L12:
        ChatWindowPtrLoadingHeader r5 = new ChatWindowPtrLoadingHeader(this.a);
        this.mPtrFrame.setKeepHeaderWhenRefresh(true);
        this.mPtrFrame.setFooterView(r5);
        this.mPtrFrame.addPtrUIHandler(r5);
        this.mPtrFrame.disableWhenHorizontalMove(true);
        this.mPtrFrame.setPtrHandler(new l(this));
        LinearLayoutManager r6 = new LinearLayoutManager(this.a, 1, false);
        this.mNewContactRV.setLayoutManager(r6);
        if (this.d != null) goto L15;
        this.d = new NewContactAdapter();
    L15:
        NewContactAdapter r7 = this.d;
        r7.b = new m(this);
        this.mNewContactRV.setAdapter(r7);
        int r8 = DesktopUtil.a;
        this.e = new LKUIStatus(new LKUIStatus.b(this.mContentView));
        return;
    L11:
        this.newContactSubTitleTv.setVisibility(8);
    L7:
        this.newContactAddExtRl.setVisibility(8);
        goto L9
    }

    @Override // com.ss.android.lark.contact.base.contact_new.mvp.b
    public final void hideLoading() {
        this.e.b();
    }

    @Override // com.ss.android.lark.contact.base.contact_new.mvp.b
    public final void n() {
        this.mPtrFrame.refreshComplete();
    }

    @Override // com.ss.android.lark.contact.base.contact_new.mvp.b
    public final void showLoading() {
        LKUIStatus r0 = this.e;
        r0.f = r0.f;
        r0.i = 3;
        r0.a.postDelayed(r0.k, 300);
    }

    public NewContactView(b r1) {
        this.c = r1;
    }

    @Override // com.ss.android.lark.contact.base.contact_new.mvp.b
    public final void B1(List<a> r6) {
        Iterator r7 = ((ArrayList) r6).iterator();
    L4:
        if (r7.hasNext() == false) goto L28;
        a r0 = (a) r7.next();
        List r1 = this.d.getItems();
        if (r1.contains(r0) == false) goto L25;
        a r2 = (a) ListProtector.get(r1, r1.indexOf(r0));
        ChatApplication.Status r3 = r0.h;
        r2.h = r3;
        CertificationInfo r4 = r0.i;
        if (r4 == null) goto L10;
        r2.i = r4;
    L10:
        String r5 = r0.e;
        if (r5 == null) goto L13;
        r2.e = r5;
    L13:
        r2.f = r0.f;
        if (r3 != ChatApplication.Status.AGREED) goto L16;
    L23:
        this.d.notifyItemChanged(r2);
        goto L25
    L16:
        if (r3 == ChatApplication.Status.PEDING) goto L23;
        if (r3 == ChatApplication.Status.EXPIRED) goto L23;
        if (r3 != ChatApplication.Status.DELETED) goto L25;
        this.d.remove(r2);
    L25:
        if (CollectionUtils.isEmpty(r1) == true) goto L26;
        this.mContentView.setVisibility(0);
        this.mNewContactEmptyLayout.setVisibility(8);
        goto L4
    L26:
        E6();
        goto L4
    }

    @Override // com.ss.android.lark.contact.base.contact_new.mvp.b
    public final void G3(List<a> r3) {
        this.mContentView.setVisibility(0);
        this.mNewContactEmptyLayout.setVisibility(8);
        this.d.addAll(r3);
    }

    @Override // com.ss.android.lark.contact.base.contact_new.mvp.b
    public final void e7(a r2) {
        this.d.remove(r2);
        if (CollectionUtils.isEmpty(this.d.getItems()) == false) goto L6;
        E6();
        return;
    }

    public final void setViewDelegate(IView.IViewDelegate r1) {
        this.b = (com.ss.android.lark.contact.base.contact_new.mvp.b.a) r1;
    }

    @Override // com.ss.android.lark.contact.base.contact_new.mvp.b
    public final void z(int r2) {
        Context r3 = this.a;
        if (r3 == null) goto L6;
        UDToast.show(r3, 2131891667);
        return;
    }

    @Override // com.ss.android.lark.contact.base.contact_new.mvp.b
    public final void J(String r3, String r4) {
        NewContactFragment.a r0 = (NewContactFragment.a) this.c;
        r0.getClass();
        ContactBaseModuleDependency.b.startNewContactProfilePage(r0.a.getActivity(), r3, r4);
    }
}
