package com.ss.android.lark.contact.customized.externalcontact.view;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.contact.base.common_ui.IndexBar;
import com.ss.android.lark.contact.base.contact_list.view.IndexRecyclerViewAdapter;
import com.ss.android.lark.contact.customized.OfficeContactPageUtils;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeEmptyStateView;
import com.ss.android.lark.contact.customized.databinding.ContactDbFragmentOfficeContactPageLayoutBinding;
import com.ss.android.lark.contact.customized.externalinvite.OfficeInviteExternalActivity;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.ChatWindowPtrLoadingHeader;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0091\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001&\b\u0007\u0018\u0000 U2\u00020\u0001:\u0001UB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u001a\u00100\u001a\u0002012\u0006\u00102\u001a\u00020)2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00103\u001a\u000201H\u0002J\b\u00104\u001a\u000201H\u0002J\b\u00105\u001a\u000201H\u0002J\b\u00106\u001a\u000201H\u0002J\b\u00107\u001a\u000201H\u0002J\b\u00108\u001a\u000201H\u0002J\u0016\u00109\u001a\u0002012\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;H\u0002J\u0016\u0010=\u001a\u0002012\f\u0010:\u001a\b\u0012\u0004\u0012\u00020>0;H\u0002J\b\u0010?\u001a\u000201H\u0002J\b\u0010@\u001a\u000201H\u0002J\b\u0010A\u001a\u000201H\u0002J\b\u0010B\u001a\u000201H\u0002J\b\u0010C\u001a\u000201H\u0002J\b\u0010D\u001a\u000201H\u0002J\b\u0010E\u001a\u000201H\u0002J\b\u0010F\u001a\u000201H\u0002J\b\u0010G\u001a\u000201H\u0002J\f\u0010H\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0002J\b\u0010I\u001a\u00020JH\u0002J\u001c\u0010K\u001a\u0002012\u0012\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0;0MH\u0002J\u001c\u0010N\u001a\u0002012\u0012\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0;0MH\u0002J<\u0010O\u001a\u000201\"\u0004\b\u0000\u0010P2\u0012\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002HP0;0M2\u0018\u0010Q\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002HP0;\u0012\u0004\u0012\u0002010RH\u0002J\u0014\u0010S\u001a\u0002012\n\u0010:\u001a\u0006\u0012\u0002\b\u00030;H\u0002J\b\u0010T\u001a\u000201H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\f\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0010\u0010\u000eR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0017\u0010\u000eR\u001b\u0010\u0019\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001a\u0010\u000eR\u0014\u0010\u001c\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'¨\u0006V"}, d2 = {"Lcom/ss/android/lark/contact/customized/externalcontact/view/OfficeExternalContactFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "viewBinding", "Lcom/ss/android/lark/contact/customized/databinding/ContactDbFragmentOfficeContactPageLayoutBinding;", "viewModel", "Lcom/ss/android/lark/contact/customized/externalcontact/view/OfficeExternalContactViewModel;", "getViewModel", "()Lcom/ss/android/lark/contact/customized/externalcontact/view/OfficeExternalContactViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "isExternalContactScene", BuildConfig.FLAVOR, "()Z", "isExternalContactScene$delegate", "isSidebarExperiment", "isSidebarExperiment$delegate", "from", BuildConfig.FLAVOR, "getFrom", "()Ljava/lang/String;", "from$delegate", "isEnterpriseAccount", "isEnterpriseAccount$delegate", "shouldLoadEnterpriseData", "getShouldLoadEnterpriseData", "shouldLoadEnterpriseData$delegate", "activePageDelegate", "Lcom/ss/android/lark/contact/customized/externalcontact/view/list/OfficeContactPageDelegate;", "skeletonScreen", "Lcom/ethanhua/skeleton/ViewSkeletonScreen;", "isScrollForbidden", "currentBadgeCount", BuildConfig.FLAVOR, "currentNewFriendSubtitle", "selfUserId", "forbiddenScrollItemListener", "com/ss/android/lark/contact/customized/externalcontact/view/OfficeExternalContactFragment$forbiddenScrollItemListener$1", "Lcom/ss/android/lark/contact/customized/externalcontact/view/OfficeExternalContactFragment$forbiddenScrollItemListener$1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", BuildConfig.FLAVOR, "view", "initView", "initData", "initViewModel", "initPulltoRefresh", "initExternalContactView", "initIndexBar", "showDoubaoContacts", "items", BuildConfig.FLAVOR, "Lcom/ss/android/lark/officesdk/contact/api/model/OfficeBaseContactItemModel;", "showEnterpriseContacts", "Lcom/ss/android/lark/officesdk/contact/api/model/OfficeSubordinateItem;", "showExternalContactView", "updateStateLayoutIfNeeded", "showLoading", "hideLoading", "forbidItemsScroll", "allowItemsScroll", "showExternalContactEmptyView", "showErrorView", "hideErrorView", "createPageDelegate", "buildHeaderConfig", "Lcom/ss/android/lark/contact/customized/externalcontact/view/list/OfficeContactHeaderConfig;", "handlePersonalStateChanged", "state", "Lcom/ss/android/lark/contact/customized/common/model/StatefulModel;", "handleEnterpriseStateChanged", "handleStateChanged", "T", "onSuccess", "Lkotlin/Function1;", "submitPageItems", "onDestroyView", "Companion", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeExternalContactFragment extends BaseFragment {
    public static final /* synthetic */ int r = 0;
    public ContactDbFragmentOfficeContactPageLayoutBinding d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public com.ss.android.lark.contact.customized.externalcontact.view.list.a<?> k;
    public lt7.d l;
    public boolean m;
    public int n;
    public String o;
    public String p;
    public final OfficeExternalContactFragment$forbiddenScrollItemListener$1 q;

    public static final class a {
        public static OfficeExternalContactFragment a(boolean r4, boolean r5, String r6) {
            Intrinsics.checkNotNullParameter(r6, "from");
            OfficeExternalContactFragment r1 = new OfficeExternalContactFragment();
            Bundle r2 = new Bundle();
            r2.putBoolean("arg_is_external_contact_scene", r4);
            r2.putBoolean("arg_is_sidebar_experiment", r5);
            r2.putString("from", r6);
            r1.setArguments(r2);
            return r1;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ OfficeExternalContactFragment a;

        public b(OfficeExternalContactFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            Context r4 = this.a.getContext();
            if (r4 == null) goto L6;
            com.ss.android.lark.contact.customized.common.b.a("contact", "contact");
            Lazy r1 = OfficeContactPageUtils.a;
            Intrinsics.checkNotNullParameter(r4, "context");
            int r2 = OfficeInviteExternalActivity.a;
            OfficeInviteExternalActivity.a.a(r4, "contact");
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    static {
    }

    public final boolean W90() {
        return ((Boolean) this.j.getValue()).booleanValue();
    }

    public final OfficeExternalContactViewModel X90() {
        return (OfficeExternalContactViewModel) this.e.getValue();
    }

    public final boolean Z90() {
        return ((Boolean) this.i.getValue()).booleanValue();
    }

    public final boolean aa0() {
        return ((Boolean) this.f.getValue()).booleanValue();
    }

    public final void ba0() {
        ContactDbFragmentOfficeContactPageLayoutBinding r0 = this.d;
        ContactDbFragmentOfficeContactPageLayoutBinding r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r0 = null;
    L5:
        r0.g.setEmptyIcon(2131233633);
        ContactDbFragmentOfficeContactPageLayoutBinding r1 = this.d;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r1 = null;
    L8:
        r1.g.setEmptyText(UIHelper.getString(2131890065));
        boolean r3 = Z90();
        ContactDbFragmentOfficeContactPageLayoutBinding r4 = this.d;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r4 = null;
    L11:
        r4.g.setHideActionButton(r3);
        if (r3 == false) goto L17;
        ContactDbFragmentOfficeContactPageLayoutBinding r5 = this.d;
        if (r5 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r5 = null;
    L16:
        r5.g.setOnActionClickListener(null);
    L24:
        ContactDbFragmentOfficeContactPageLayoutBinding r6 = this.d;
        if (r6 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r6 = null;
    L27:
        r6.g.setOnClickListener(c.a);
        da0(CollectionsKt.emptyList());
        ContactDbFragmentOfficeContactPageLayoutBinding r7 = this.d;
        if (r7 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r7 = null;
    L30:
        r7.f.setVisibility(0);
        ContactDbFragmentOfficeContactPageLayoutBinding r8 = this.d;
        if (r8 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r8 = null;
    L33:
        r8.g.setVisibility(0);
        ContactDbFragmentOfficeContactPageLayoutBinding r9 = this.d;
        if (r9 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L37:
        r2.c.setVisibility(8);
        ea0();
        return;
    L36:
        r2 = r9;
        goto L37
    L17:
        ContactDbFragmentOfficeContactPageLayoutBinding r10 = this.d;
        if (r10 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r10 = null;
    L20:
        r10.g.setEmptyActionText(UIHelper.getString(2131890064));
        ContactDbFragmentOfficeContactPageLayoutBinding r11 = this.d;
        if (r11 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r11 = null;
    L23:
        r11.g.setOnActionClickListener(new b(this));
        goto L24
    }

    public final void ca0() {
        ContactDbFragmentOfficeContactPageLayoutBinding r0 = this.d;
        ContactDbFragmentOfficeContactPageLayoutBinding r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r0 = null;
    L6:
        if (r0.d.getVisibility() == 0) goto L11;
        ContactDbFragmentOfficeContactPageLayoutBinding r2 = this.d;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r2 = null;
    L10:
        r2.d.setVisibility(0);
    L11:
        ContactDbFragmentOfficeContactPageLayoutBinding r3 = this.d;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r3 = null;
    L14:
        r3.f.setVisibility(8);
        ContactDbFragmentOfficeContactPageLayoutBinding r4 = this.d;
        if (r4 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L18:
        r1.g.setVisibility(8);
        return;
    L17:
        r1 = r4;
        goto L18
    }

    public final void ea0() {
        Log.i("Contact_ExtContactFrag", "updateStateLayoutIfNeeded");
        ContactDbFragmentOfficeContactPageLayoutBinding r1 = this.d;
        ContactDbFragmentOfficeContactPageLayoutBinding r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r1 = null;
    L5:
        FrameLayout r3 = r1.f;
        if (r3.getVisibility() == 0) goto L8;
        return;
    L8:
        ContactDbFragmentOfficeContactPageLayoutBinding r4 = this.d;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L12:
        CommonRecyclerView r5 = r2.e;
        int r6 = (r5.getHeight() - r5.getPaddingTop()) - r5.getPaddingBottom();
        if (r6 > 0) goto L15;
        return;
    L15:
        com.ss.android.lark.contact.customized.externalcontact.view.list.a<?> r7 = this.k;
        if (r7 == null) goto L18;
        int r8 = r7.f(r5);
    L19:
        if (r8 > 0) goto L21;
        return;
    L21:
        ViewGroup.LayoutParams r9 = r3.getLayoutParams();
        int r10 = RangesKt.coerceAtLeast(r6 - r8, 0);
        Log.i("Contact_ExtContactFrag", "newHeight: " + r10);
        if (r9 != null) goto L24;
        return;
    L24:
        if (r9.height == r10) goto L28;
        r9.height = r10;
        r3.setLayoutParams(r9);
        return;
    L28:
        return;
    L18:
        r8 = 0;
        goto L19
    L11:
        r2 = r4;
        goto L12
    }

    public final void hideLoading() {
        ContactDbFragmentOfficeContactPageLayoutBinding r0 = this.d;
        ContactDbFragmentOfficeContactPageLayoutBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r0 = null;
    L5:
        r0.c.setVisibility(8);
        ContactDbFragmentOfficeContactPageLayoutBinding r2 = this.d;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L9:
        r1.f.setVisibility(8);
        lt7.d r3 = this.l;
        if (r3 == null) goto L13;
        r3.a();
        return;
    L13:
        return;
    L8:
        r1 = r2;
        goto L9
    }

    public final void onDestroyView() {
        Log.i("Contact_ExtContactFrag", "onDestroyView");
        this.k = null;
        super.onDestroyView();
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.ss.android.lark.contact.customized.externalcontact.view.OfficeExternalContactFragment$forbiddenScrollItemListener$1] */
    public OfficeExternalContactFragment() {
        final Function0<Fragment> r0 = new OfficeExternalContactFragment$special$$inlined$viewModels$default$1(this);
        this.e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(OfficeExternalContactViewModel.class), new OfficeExternalContactFragment$special$$inlined$viewModels$default$2(r0), new OfficeExternalContactFragment$special$$inlined$viewModels$default$3(r0, this));
        LazyThreadSafetyMode r1 = LazyThreadSafetyMode.NONE;
        this.f = LazyKt.lazy(r1, new OfficeExternalContactFragment$isExternalContactScene$2(this));
        this.g = LazyKt.lazy(r1, new OfficeExternalContactFragment$isSidebarExperiment$2(this));
        this.h = LazyKt.lazy(r1, new OfficeExternalContactFragment$from$2(this));
        this.i = LazyKt.lazy(r1, OfficeExternalContactFragment$isEnterpriseAccount$2.INSTANCE);
        this.j = LazyKt.lazy(r1, new OfficeExternalContactFragment$shouldLoadEnterpriseData$2(this));
        this.o = BuildConfig.FLAVOR;
        this.p = BuildConfig.FLAVOR;
        this.q = new OfficeExternalContactFragment$forbiddenScrollItemListener$1();
    }

    public final l9b.a V90() {
        boolean r1 = false;
        if (aa0() == true) goto L5;
        boolean r3 = ((Boolean) this.g.getValue()).booleanValue();
        Integer r0 = Integer.valueOf(this.n);
        if (r0.intValue() <= 0) goto L9;
        r1 = true;
    L9:
        String r2 = null;
        if (r1 == true) goto L13;
        r0 = null;
    L13:
        if (r0 == null) goto L15;
        r2 = r0.toString();
    L15:
        if (r2 != null) goto L17;
        String r4 = BuildConfig.FLAVOR;
    L19:
        return new l9b.a(r3, r4, this.o, true, Z90(), Z90(), new OfficeExternalContactFragment$buildHeaderConfig$2(this), new OfficeExternalContactFragment$buildHeaderConfig$3(this), new OfficeExternalContactFragment$buildHeaderConfig$4(this), new OfficeExternalContactFragment$buildHeaderConfig$5(this));
    L17:
        r4 = r2;
        goto L19
    L5:
        return new l9b.a(0);
    }

    public static final void S90(OfficeExternalContactFragment r2) {
        r2.getClass();
        Log.i("Contact_ExtContactFrag", "allowItemsScroll=" + r2.m);
        if (r2.m == false) goto L10;
        ContactDbFragmentOfficeContactPageLayoutBinding r0 = r2.d;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r0 = null;
    L8:
        r0.e.removeOnItemTouchListener(r2.q);
        r2.m = false;
        return;
    }

    public static final void T90(OfficeExternalContactFragment r2) {
        Log.i("Contact_ExtContactFrag", "forbidItemsScroll=" + r2.m);
        if (r2.m == true) goto L10;
        ContactDbFragmentOfficeContactPageLayoutBinding r0 = r2.d;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r0 = null;
    L8:
        r0.e.addOnItemTouchListener(r2.q);
        r2.m = true;
        return;
    }

    public static final /* synthetic */ Context U90(OfficeExternalContactFragment r0) {
        return ((BaseFragment) r0).mContext;
    }

    public final void da0(List<?> r3) {
        com.ss.android.lark.contact.customized.externalcontact.view.list.a<?> r0 = this.k;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNullParameter(r3, "items");
        r0.g(r3);
        return;
    }

    public final <T> void Y90(i9b.a<? extends List<? extends T>> r8, Function1<? super List<? extends T>, Unit> r9) {
        ContactDbFragmentOfficeContactPageLayoutBinding r4 = null;
        if ((r8 instanceof i9b.a.b) == false) goto L25;
        Log.i("Contact_ExtContactFrag", "state=Loading");
        if (this.l != null) goto L10;
        ContactDbFragmentOfficeContactPageLayoutBinding r10 = this.d;
        if (r10 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r10 = null;
    L9:
        lt7.d.a r11 = new lt7.d.a(r10.c);
        r11.b = 2131559904;
        r11.a(2131108723);
        r11.c = UIUtils.canShowSkeleton();
        this.l = r11.b();
    L10:
        ContactDbFragmentOfficeContactPageLayoutBinding r12 = this.d;
        if (r12 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r12 = null;
    L13:
        r12.c.setVisibility(0);
        ContactDbFragmentOfficeContactPageLayoutBinding r13 = this.d;
        if (r13 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r13 = null;
    L16:
        r13.f.setVisibility(0);
        ContactDbFragmentOfficeContactPageLayoutBinding r14 = this.d;
        if (r14 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L20:
        r4.g.setVisibility(8);
        lt7.d r15 = this.l;
        if (r15 == null) goto L23;
        r15.b();
    L23:
        ea0();
        return;
    L19:
        r4 = r14;
        goto L20
    L25:
        if ((r8 instanceof i9b.a.c) == false) goto L41;
        hideLoading();
        ContactDbFragmentOfficeContactPageLayoutBinding r0 = this.d;
        if (r0 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r0 = null;
    L29:
        r0.d.refreshComplete();
        i9b.a.c r16 = (i9b.a.c) r8;
        if (((List) r16.a).isEmpty() == false) goto L32;
        Log.i("Contact_ExtContactFrag", "state=Success(empty)");
        ba0();
        return;
    L32:
        Log.i("Contact_ExtContactFrag", "state=Success(size=" + ((List) r16.a).size() + ')');
        ContactDbFragmentOfficeContactPageLayoutBinding r1 = this.d;
        if (r1 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r1 = null;
    L35:
        r1.f.setVisibility(8);
        ContactDbFragmentOfficeContactPageLayoutBinding r2 = this.d;
        if (r2 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L39:
        r4.g.setVisibility(8);
        r9.invoke(r16.a);
        return;
    L38:
        r4 = r2;
        goto L39
    L41:
        if ((r8 instanceof i9b.a.C0235a) == false) goto L70;
        Log.i("Contact_ExtContactFrag", "state=Error(message=" + ((i9b.a.C0235a) r8).a + ')');
        hideLoading();
        ContactDbFragmentOfficeContactPageLayoutBinding r17 = this.d;
        if (r17 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r17 = null;
    L45:
        r17.g.setEmptyIcon(2131233634);
        ContactDbFragmentOfficeContactPageLayoutBinding r18 = this.d;
        if (r18 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r18 = null;
    L48:
        r18.g.setEmptyText(UIHelper.getString(2131889966));
        ContactDbFragmentOfficeContactPageLayoutBinding r19 = this.d;
        if (r19 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r19 = null;
    L51:
        r19.g.setEmptyActionText(UIHelper.getString(2131889969));
        ContactDbFragmentOfficeContactPageLayoutBinding r20 = this.d;
        if (r20 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r20 = null;
    L54:
        r20.g.setOnActionClickListener(new l(this));
        ContactDbFragmentOfficeContactPageLayoutBinding r21 = this.d;
        if (r21 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r21 = null;
    L57:
        r21.g.setOnClickListener(m.a);
        ContactDbFragmentOfficeContactPageLayoutBinding r22 = this.d;
        if (r22 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r22 = null;
    L60:
        r22.f.setVisibility(0);
        ContactDbFragmentOfficeContactPageLayoutBinding r23 = this.d;
        if (r23 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r23 = null;
    L63:
        r23.g.setVisibility(0);
        ContactDbFragmentOfficeContactPageLayoutBinding r24 = this.d;
        if (r24 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L67:
        r4.c.setVisibility(8);
        ea0();
        return;
    L66:
        r4 = r24;
        goto L67
    L70:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v12, types: [com.ss.android.lark.contact.customized.externalcontact.view.OfficeExternalContactFragment$initExternalContactView$actionHandler$1, java.lang.Object] */
    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super.onViewCreated(r11, r12);
        Log.i("Contact_ExtContactFrag", "init isExternalContactScene=" + aa0() + " isEnterpriseAccount=" + Z90() + " isSidebarExperiment=" + ((Boolean) this.g.getValue()).booleanValue() + " from=" + ((String) this.h.getValue()));
        X90().onPageViewCreated(SystemClock.elapsedRealtime());
        ChatWindowPtrLoadingHeader r13 = new ChatWindowPtrLoadingHeader(((BaseFragment) this).mContext);
        ContactDbFragmentOfficeContactPageLayoutBinding r0 = this.d;
        ContactDbFragmentOfficeContactPageLayoutBinding r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r0 = null;
    L5:
        boolean r3 = true;
        r0.d.setKeepHeaderWhenRefresh(true);
        ContactDbFragmentOfficeContactPageLayoutBinding r1 = this.d;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r1 = null;
    L8:
        r1.d.setFooterView(r13);
        ContactDbFragmentOfficeContactPageLayoutBinding r4 = this.d;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r4 = null;
    L11:
        r4.d.addPtrUIHandler(r13);
        ContactDbFragmentOfficeContactPageLayoutBinding r14 = this.d;
        if (r14 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r14 = null;
    L14:
        r14.d.disableWhenHorizontalMove(true);
        ContactDbFragmentOfficeContactPageLayoutBinding r15 = this.d;
        if (r15 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r15 = null;
    L17:
        r15.d.setPtrHandler(new f(this));
        LinearLayoutManager r16 = new LinearLayoutManager(((BaseFragment) this).mContext, 1, false);
        ContactDbFragmentOfficeContactPageLayoutBinding r5 = this.d;
        if (r5 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r5 = null;
    L20:
        r5.e.setLayoutManager(r16);
        ?? r17 = new OfficeExternalContactFragment$initExternalContactView$actionHandler$1(this);
        if (aa0() == false) goto L24;
        com.ss.android.lark.contact.customized.externalcontact.view.list.a<?> r6 = new com.ss.android.lark.contact.customized.externalcontact.view.list.l();
    L27:
        this.k = r6;
        l9b.a r7 = V90();
        com.ss.android.lark.contact.customized.externalcontact.view.list.a<?> r8 = this.k;
        if (r8 == null) goto L131;
        Intrinsics.checkNotNullParameter(r17, "actionHandler");
        Intrinsics.checkNotNullParameter(r7, "headerConfig");
        IndexRecyclerViewAdapter r9 = r8.d();
        r8.b = r9;
        if (r9 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        r9 = null;
    L32:
        r8.a(r9, r17);
        r8.a = r8.c(r7);
        ArrayList r18 = new ArrayList();
        RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r10 = r8.a;
        if (r10 == null) goto L35;
        r18.add(r10);
    L35:
        IndexRecyclerViewAdapter<? extends RecyclerView.ViewHolder, ?> r19 = r8.b;
        if (r19 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        r19 = null;
    L38:
        r18.add(r19);
        ConcatAdapter r20 = new ConcatAdapter(r18);
        DefaultItemAnimator r110 = new OfficeExternalContactFragment$initExternalContactView$defaultItemAnimator$1(this);
        r110.setSupportsChangeAnimations(false);
        ContactDbFragmentOfficeContactPageLayoutBinding r21 = this.d;
        if (r21 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r21 = null;
    L41:
        r21.e.setItemAnimator(r110);
        ContactDbFragmentOfficeContactPageLayoutBinding r111 = this.d;
        if (r111 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r111 = null;
    L44:
        r111.e.setAdapter(r20);
        getContext();
        ContactDbFragmentOfficeContactPageLayoutBinding r112 = this.d;
        if (r112 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r112 = null;
    L47:
        LKUIPtrClassicFrameLayout r113 = r112.d;
        ContactDbFragmentOfficeContactPageLayoutBinding r114 = this.d;
        if (r114 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r114 = null;
    L50:
        CommonRecyclerView r115 = r114.e;
        int r116 = DesktopUtil.a;
        ContactDbFragmentOfficeContactPageLayoutBinding r117 = this.d;
        if (r117 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r117 = null;
    L53:
        r117.e.addOnLayoutChangeListener(new e(this));
        com.ss.android.lark.contact.customized.externalcontact.view.list.a<?> r118 = this.k;
        if (r118 == null) goto L59;
        IndexRecyclerViewAdapter<? extends RecyclerView.ViewHolder, ?> r119 = r118.e();
        if (r119 == null) goto L59;
        r119.c = !W90();
    L59:
        if (W90() == false) goto L68;
        ContactDbFragmentOfficeContactPageLayoutBinding r120 = this.d;
        if (r120 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r120 = null;
    L63:
        r120.h.setVisibility(8);
        ContactDbFragmentOfficeContactPageLayoutBinding r121 = this.d;
        if (r121 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L67:
        r2.i.setVisibility(8);
    L113:
        if (W90() == false) goto L115;
        X90().getEnterpriseContacts().observe(getViewLifecycleOwner(), new g(this));
    L116:
        X90().getOpenProfile().observe(getViewLifecycleOwner(), new i(this));
        if (aa0() == true) goto L119;
        X90().getSelfCardHeader().observe(getViewLifecycleOwner(), new j(this));
        X90().getNewFriendBadge().observe(getViewLifecycleOwner(), new k(this));
    L119:
        OfficeExternalContactViewModel r122 = X90();
        boolean r123 = W90();
        boolean r22 = aa0();
        if (((Boolean) this.g.getValue()).booleanValue() == true) goto L122;
    L124:
        r3 = false;
    L125:
        r122.init(r123, r22, r3);
        if (aa0() == true) goto L128;
        int r124 = com.ss.android.lark.contact.customized.common.b.a;
        com.ss.android.lark.contact.customized.common.b.c("contact", (String) this.h.getValue());
    L128:
        X90().fetchData(W90());
        return;
    L122:
        if (aa0() == true) goto L124;
    L115:
        X90().getDoubaoContacts().observe(getViewLifecycleOwner(), new h(this));
        goto L116
    L66:
        r2 = r121;
        goto L67
    L68:
        ContactDbFragmentOfficeContactPageLayoutBinding r23 = this.d;
        if (r23 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r23 = null;
    L71:
        final u r125 = new u(r23.a);
        com.ss.android.lark.contact.customized.externalcontact.view.list.a<?> r24 = this.k;
        if (r24 == null) goto L74;
        final IndexRecyclerViewAdapter<? extends RecyclerView.ViewHolder, ?> r25 = r24.e();
    L75:
        if (r25 != null) goto L77;
        Log.w("Contact_ExtContactFrag", "initIndexBar skipped because active index adapter is null");
        goto L113
    L77:
        ContactDbFragmentOfficeContactPageLayoutBinding r126 = this.d;
        if (r126 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r126 = null;
    L80:
        final CommonRecyclerView r127 = r126.e;
        ConcatAdapter r26 = r127.getAdapter();
        if ((r26 instanceof ConcatAdapter) == false) goto L90;
        Iterator r27 = r26.getAdapters().iterator();
        int r28 = 0;
    L85:
        if (r27.hasNext() == false) goto L90;
        IndexRecyclerViewAdapter<? extends RecyclerView.ViewHolder, ?> r29 = (RecyclerView.Adapter) r27.next();
        if (r29 == r25) goto L91;
        r28 = r28 + r29.getItemCount();
    L91:
        View r30 = r125.d;
        if (r30 == null) goto L94;
        r30.setOnClickListener(new p(r125, r127));
    L94:
        r125.c.setOnTouchingLetterChangedListener(new s(r125, r25, r28, r127));
        r125.a(r25.b);
        r25.A2(new q(r125, r25));
        r127.addOnScrollListener(new t(r125, r28, r25));
        o r128 = new o();
        Map<Integer, String> r129 = r25.b;
        ContactDbFragmentOfficeContactPageLayoutBinding r31 = this.d;
        if (r31 != null) goto L97;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L98:
        CommonRecyclerView r32 = r2.e;
        Context r33 = r32.getContext();
        int r34 = o.b(r32);
        Map<Integer, String> r130 = OfficeFloatingBarItemDecoration.i(r129, r34);
        Integer r35 = Integer.valueOf(UIHelper.dp2px(38.0f));
        Integer r36 = Integer.valueOf(r34);
        Integer r37 = 0;
        Integer r38 = Integer.valueOf(UIUtils.getColor(r33, 2131102042));
        Float r39 = Float.valueOf(UIHelper.sp2px(13.0f));
        if (r36 != null) goto L101;
        int r40 = 0;
    L102:
        OfficeFloatingBarItemDecoration r41 = new OfficeFloatingBarItemDecoration(r33, r130, r40);
        if (r38 == null) goto L105;
        r41.b.setColor(r38.intValue());
    L105:
        if (r39 == null) goto L107;
        r41.b.setTextSize(r39.floatValue());
    L107:
        if (r37 == null) goto L109;
        r41.g = r37.intValue();
    L109:
        if (r35 == null) goto L111;
        r41.d = r35.intValue();
    L111:
        r128.a = r41;
        r32.addItemDecoration(r41);
        o.a(r32).A2(new n(r128, r32));
        goto L113
    L101:
        r40 = r36.intValue();
        goto L102
    L97:
        r2 = r31;
    L90:
        r28 = 0;
        goto L91
    L74:
        r25 = null;
        goto L75
    L131:
        throw new IllegalArgumentException("Required value was null.".toString());
    L24:
        if (Z90() == false) goto L26;
        r6 = new com.ss.android.lark.contact.customized.externalcontact.view.list.h();
        goto L27
    L26:
        r6 = new com.ss.android.lark.contact.customized.externalcontact.view.list.j();
        goto L27
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View onCreateView(LayoutInflater r11, ViewGroup r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r11, "inflater");
        super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.onCreateView(r11, r12, r13);
        View r14 = r11.inflate(2131559908, r12, false);
        int r15 = 2131372000;
        FrameLayout r2 = (FrameLayout) ViewBindings.findChildViewById(r14, 2131372000);
        if (r2 == null) goto L25;
        r15 = 2131372003;
        LinearLayout r3 = (LinearLayout) ViewBindings.findChildViewById(r14, 2131372003);
        if (r3 == null) goto L25;
        r15 = 2131372004;
        LKUIPtrClassicFrameLayout r4 = ViewBindings.findChildViewById(r14, 2131372004);
        if (r4 == null) goto L25;
        r15 = 2131372005;
        CommonRecyclerView r5 = ViewBindings.findChildViewById(r14, 2131372005);
        if (r5 == null) goto L25;
        r15 = 2131372006;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r14, 2131372006);
        if (r6 == null) goto L25;
        r15 = 2131372007;
        ContactOfficeEmptyStateView r7 = (ContactOfficeEmptyStateView) ViewBindings.findChildViewById(r14, 2131372007);
        if (r7 == null) goto L25;
        r15 = 2131375220;
        if (((IndexBar) ViewBindings.findChildViewById(r14, 2131375220)) == null) goto L25;
        r15 = 2131375221;
        FrameLayout r8 = (FrameLayout) ViewBindings.findChildViewById(r14, 2131375221);
        if (r8 == null) goto L25;
        r15 = 2131375222;
        if (((ImageView) ViewBindings.findChildViewById(r14, 2131375222)) == null) goto L25;
        r15 = 2131375223;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r14, 2131375223);
        if (r9 == null) goto L25;
        RelativeLayout r16 = (RelativeLayout) r14;
        this.d = new ContactDbFragmentOfficeContactPageLayoutBinding(r16, r2, r3, r4, r5, r6, r7, r8, r9);
        return r16;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r15)));
    }
}
