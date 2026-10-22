package com.ss.android.lark.contact.base.contact_mobile_invite;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.larksuite.component.universe_design.tab.UDTabLayout;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.contact.base.common_ui.InvErrorView;
import com.ss.android.lark.contact.base.common_ui.SearchEditText;
import com.ss.android.lark.contact.base.contact_mobile_invite.invite.InviteExternalContactInviteFragment;
import com.ss.android.lark.contact.base.contact_mobile_invite.using.InviteExternalContactUsingFragment;
import com.ss.android.lark.contact.base.databinding.InvInviteExternalContactV2ViewBinding;
import com.ss.android.lark.contact.base.service.InvRequestUtils;
import com.ss.android.lark.contact.base.service.a0;
import com.ss.android.lark.contact.base.service.b0;
import com.ss.android.lark.contact.base.utils.InvApmUtils;
import com.ss.android.lark.contact.base.utils.InvRouterParam$From;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.ui.IActionTitlebar;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.ViewUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010&\u001a\u00020$H\u0002J\b\u0010'\u001a\u00020$H\u0002J\b\u0010(\u001a\u00020$H\u0002J\u0018\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u0016H\u0002J\b\u0010,\u001a\u00020$H\u0002J\b\u0010-\u001a\u00020$H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/ss/android/lark/contact/base/contact_mobile_invite/InviteExternalContactV2Fragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "loading", "Lcom/ss/android/lark/utils/ViewUtils$PageLoadingDialog;", "mFragmentInfos", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/base/fragment/FragmentInfo;", "Lkotlin/collections/ArrayList;", "index", BuildConfig.FLAVOR, "from", BuildConfig.FLAVOR, "isFirst", BuildConfig.FLAVOR, "rootViewBinding", "Lcom/ss/android/lark/contact/base/databinding/InvInviteExternalContactV2ViewBinding;", "iecErrorView", "Lcom/ss/android/lark/contact/base/common_ui/InvErrorView;", "request", "Lcom/ss/android/lark/contact/base/service/InvRequestUtils$LocalAndServerRequest;", "Lcom/ss/android/lark/contact/base/entity/mobile/ContactsMobileFeishuInfo;", "usingFragment", "Lcom/ss/android/lark/contact/base/contact_mobile_invite/using/InviteExternalContactUsingFragment;", "inviteFragment", "Lcom/ss/android/lark/contact/base/contact_mobile_invite/invite/InviteExternalContactInviteFragment;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", BuildConfig.FLAVOR, "view", "init", "fetchData", "showLoading", "initView", "isFromLocal", "info", "initSearchView", "onDestroy", "Companion", "contact-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InviteExternalContactV2Fragment extends BaseFragment {
    public static final /* synthetic */ int n = 0;
    public ViewUtils.c d;
    public final ArrayList<com.ss.android.lark.base.fragment.a> e;
    public int f;
    public String g;
    public boolean h;
    public InvInviteExternalContactV2ViewBinding i;
    public InvErrorView j;
    public InvRequestUtils.LocalAndServerRequestImpl k;
    public InviteExternalContactUsingFragment l;
    public InviteExternalContactInviteFragment m;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ InviteExternalContactV2Fragment a;

        public b(InviteExternalContactV2Fragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            InviteExternalContactV2Fragment r4 = this.a;
            int r0 = InviteExternalContactV2Fragment.n;
            r4.getClass();
            InvApmUtils.g("contact_opt_contact_list_timing_ms");
            y8b.a r1 = new y8b.a(r4);
            int r2 = InvRequestUtils.a;
            Intrinsics.checkNotNullParameter(r1, "callback");
            Intrinsics.checkNotNullParameter(r1, "callback");
            InvRequestUtils.LocalAndServerRequestImpl r5 = new InvRequestUtils.LocalAndServerRequestImpl(r1);
            ViewUtils.runOnUiThread(new b0(r5));
            r4.k = r5;
        }
    }

    public static final class c extends IActionTitlebar.TextAction {
        public final /* synthetic */ InviteExternalContactV2Fragment a;

        public final void performAction(View r3) {
            Intrinsics.checkNotNullParameter(r3, "view");
            Intent r4 = new Intent();
            String r0 = this.a.g;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("from");
            r0 = null;
        L5:
            r4.putExtra(r0, "jump");
            this.a.setResult(-1, r4);
            this.a.finish();
        }

        public c(InviteExternalContactV2Fragment r1, String r2) {
            this.a = r1;
            super(r2, 2131103404);
        }
    }

    static {
    }

    public InviteExternalContactV2Fragment() {
        this.e = new ArrayList();
        this.h = true;
    }

    public final void onDestroy() {
        super.onDestroy();
        InvRequestUtils.LocalAndServerRequestImpl r0 = this.k;
        if (r0 == null) goto L6;
        r0.d.cancel();
        r0.e.cancel();
        return;
    }

    public static final /* synthetic */ String S90(InviteExternalContactV2Fragment r0) {
        return ((BaseFragment) r0).PARENT_TAG;
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        a0.f(true);
        this.j = (InvErrorView) r3.findViewById(2131374847);
        String r5 = com.ss.android.lark.contact.base.contact_mobile_invite.invite.a.k;
        Bundle r6 = getArguments();
        String r7 = BuildConfig.FLAVOR;
        if (r6 == null) goto L6;
        String r8 = r6.getString("invite_msg");
        if (r8 == null) goto L6;
    L7:
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        com.ss.android.lark.contact.base.contact_mobile_invite.invite.a.k = r8;
        Bundle r9 = getArguments();
        if (r9 == null) goto L11;
        String r10 = r9.getString("unique_id");
        if (r10 == null) goto L11;
    L12:
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        com.ss.android.lark.contact.base.contact_mobile_invite.invite.a.l = r10;
        Bundle r11 = getArguments();
        if (r11 == null) goto L18;
        String r12 = r11.getString("from_scenes");
        if (r12 == null) goto L18;
        r7 = r12;
    L18:
        this.g = r7;
        if (Intrinsics.areEqual(InvRouterParam$From.ONBOARDING, r7) == false) goto L32;
        InvInviteExternalContactV2ViewBinding r13 = this.i;
        if (r13 == null) goto L27;
        CommonTitleBar r14 = r13.h;
        if (r14 == null) goto L27;
        TextView r15 = r14.getLeftText();
        if (r15 == null) goto L27;
        r15.setVisibility(8);
    L27:
        c r16 = new c(this, UIHelper.getString(2131890890));
        InvInviteExternalContactV2ViewBinding r17 = this.i;
        if (r17 == null) goto L32;
        CommonTitleBar r18 = r17.h;
        if (r18 == null) goto L32;
        r18.addAction(r16);
    L32:
        InvErrorView r19 = this.j;
        if (r19 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("iecErrorView");
        r19 = null;
    L35:
        r19.setOnClickListener(new b(this));
        InvApmUtils.g("contact_opt_contact_list_timing_ms");
        y8b.a r20 = new y8b.a(this);
        int r21 = InvRequestUtils.a;
        Intrinsics.checkNotNullParameter(r20, "callback");
        Intrinsics.checkNotNullParameter(r20, "callback");
        InvRequestUtils.LocalAndServerRequestImpl r22 = new InvRequestUtils.LocalAndServerRequestImpl(r20);
        ViewUtils.runOnUiThread(new b0(r22));
        this.k = r22;
        return;
    L11:
        r10 = BuildConfig.FLAVOR;
    L6:
        r8 = BuildConfig.FLAVOR;
        goto L7
    }

    public final View onCreateView(LayoutInflater r11, ViewGroup r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r11, "inflater");
        View r14 = r11.inflate(2131561560, r12, false);
        int r15 = 2131374846;
        FrameLayout r2 = (FrameLayout) ViewBindings.findChildViewById(r14, 2131374846);
        if (r2 == null) goto L23;
        r15 = 2131374847;
        if (((InvErrorView) ViewBindings.findChildViewById(r14, 2131374847)) == null) goto L23;
        r15 = 2131374849;
        UDTabLayout r3 = ViewBindings.findChildViewById(r14, 2131374849);
        if (r3 == null) goto L23;
        r15 = 2131374850;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r14, 2131374850);
        if (r4 == null) goto L23;
        r15 = 2131374851;
        SearchEditText r5 = (SearchEditText) ViewBindings.findChildViewById(r14, 2131374851);
        if (r5 == null) goto L23;
        r15 = 2131374852;
        RelativeLayout r6 = (RelativeLayout) ViewBindings.findChildViewById(r14, 2131374852);
        if (r6 == null) goto L23;
        r15 = 2131374853;
        View r7 = ViewBindings.findChildViewById(r14, 2131374853);
        if (r7 == null) goto L23;
        r15 = 2131374854;
        CommonTitleBar r8 = ViewBindings.findChildViewById(r14, 2131374854);
        if (r8 == null) goto L23;
        r15 = 2131374855;
        ViewPager r9 = ViewBindings.findChildViewById(r14, 2131374855);
        if (r9 == null) goto L23;
        RelativeLayout r16 = (RelativeLayout) r14;
        this.i = new InvInviteExternalContactV2ViewBinding(r16, r2, r3, r4, r5, r6, r7, r8, r9);
        return r16;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r15)));
    }
}
