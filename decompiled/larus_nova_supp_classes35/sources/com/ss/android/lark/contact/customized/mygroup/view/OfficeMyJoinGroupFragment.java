package com.ss.android.lark.contact.customized.mygroup.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBindings;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.contact.customized.common.OfficeContactUtils;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeEmptyStateView;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeTitleBar;
import com.ss.android.lark.contact.customized.databinding.ContactDbFragmentOfficeMyJoinGroupBinding;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.ChatWindowPtrLoadingHeader;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import zdc.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 12\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0012\u001a\u00020\u00132\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0016J\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u0013H\u0002J\b\u0010#\u001a\u00020\u0013H\u0002J\b\u0010$\u001a\u00020\u0013H\u0002J\b\u0010%\u001a\u00020\u0013H\u0002J\b\u0010&\u001a\u00020\u0013H\u0002J\b\u0010'\u001a\u00020\u0013H\u0002J\b\u0010(\u001a\u00020\u0013H\u0002J\u0016\u0010)\u001a\u00020\u00132\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002J\b\u0010-\u001a\u00020\u0013H\u0002J\u0010\u0010.\u001a\u00020\u00132\u0006\u0010/\u001a\u000200H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/ss/android/lark/contact/customized/mygroup/view/OfficeMyJoinGroupFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "configurationHandler", "Lcom/ss/android/lark/contact/impl/group/ConfigurationHandler;", "viewBinding", "Lcom/ss/android/lark/contact/customized/databinding/ContactDbFragmentOfficeMyJoinGroupBinding;", "viewModel", "Lcom/ss/android/lark/contact/customized/mygroup/view/OfficeMyJoinGroupViewModel;", "getViewModel", "()Lcom/ss/android/lark/contact/customized/mygroup/view/OfficeMyJoinGroupViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "skeletonScreen", "Lcom/ethanhua/skeleton/ViewSkeletonScreen;", "adapter", "Lcom/ss/android/lark/contact/customized/mygroup/view/OfficeMyGroupAdapter;", "onCreate", BuildConfig.FLAVOR, "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "initObservers", "initView", "initTitleBar", "initList", "initPullToLoadMore", "showLoading", "hideLoading", "showGroups", "chats", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chat/entity/chat/Chat;", "showError", "enterGroupChat", "chatId", BuildConfig.FLAVOR, "Companion", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeMyJoinGroupFragment extends BaseFragment {
    public static final /* synthetic */ int i = 0;
    public q9b.a d;
    public ContactDbFragmentOfficeMyJoinGroupBinding e;
    public final Lazy f;
    public lt7.d g;
    public OfficeMyGroupAdapter h;

    public static final class a {
    }

    public static final class b implements q9b.a.InterfaceC0281a {
        public final /* synthetic */ OfficeMyJoinGroupFragment a;

        @Override // q9b.a.InterfaceC0281a
        public final void a() {
            OfficeMyGroupAdapter r0 = this.a.h;
            if (r0 == null) goto L6;
            r0.notifyDataSetChanged();
            return;
        }

        public b(OfficeMyJoinGroupFragment r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final OfficeMyJoinGroupViewModel S90() {
        return (OfficeMyJoinGroupViewModel) this.f.getValue();
    }

    public final void onDestroyView() {
        Log.i("Contact_MyJoinGroupFrag", "onDestroyView");
        this.h = null;
        this.g = null;
        super.onDestroyView();
    }

    public OfficeMyJoinGroupFragment() {
        final Function0<Fragment> r0 = new OfficeMyJoinGroupFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(OfficeMyJoinGroupViewModel.class), new OfficeMyJoinGroupFragment$special$$inlined$viewModels$default$2(r0), new OfficeMyJoinGroupFragment$special$$inlined$viewModels$default$3(r0, this));
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        q9b.a r0 = this.d;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Context r4 = getContext();
        if (r4 == null) goto L7;
        Resources r5 = r4.getResources();
        if (r5 == null) goto L7;
        Configuration r6 = r5.getConfiguration();
    L8:
        if (r6 == null) goto L11;
        q9b.a r0 = new q9b.a(r6);
        b r7 = new b(this);
        Intrinsics.checkNotNullParameter(r7, "onWindowChangedListener");
        r0.b = r7;
        this.d = r0;
        return;
    L11:
        return;
    L7:
        r6 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        S90().onPageViewCreated(SystemClock.elapsedRealtime());
        ContactDbFragmentOfficeMyJoinGroupBinding r6 = this.e;
        ContactDbFragmentOfficeMyJoinGroupBinding r0 = null;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r6 = null;
    L5:
        r6.f.setRightIcon(2131233636);
        ContactDbFragmentOfficeMyJoinGroupBinding r7 = this.e;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r7 = null;
    L8:
        r7.f.setLeftIconClickListener(new e(this));
        ContactDbFragmentOfficeMyJoinGroupBinding r8 = this.e;
        if (r8 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r8 = null;
    L11:
        r8.f.setRightIconClickListener(new f(this));
        Context r9 = getContext();
        if (r9 == null) goto L14;
        Lazy r1 = OfficeContactUtils.a;
        OfficeContactUtils.e(this, UIUtils.getColor(r9, 2131102022));
    L14:
        ContactDbFragmentOfficeMyJoinGroupBinding r10 = this.e;
        if (r10 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r10 = null;
    L17:
        h.a(r10.e);
        ContactDbFragmentOfficeMyJoinGroupBinding r11 = this.e;
        if (r11 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r11 = null;
    L20:
        r11.e.setLayoutManager(new LinearLayoutManager(requireContext()));
        OfficeMyGroupAdapter r12 = new OfficeMyGroupAdapter();
        r12.b = new OfficeMyJoinGroupFragment$initList$1$1(this);
        this.h = r12;
        ContactDbFragmentOfficeMyJoinGroupBinding r13 = this.e;
        if (r13 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r13 = null;
    L23:
        r13.e.setAdapter(this.h);
        ContactDbFragmentOfficeMyJoinGroupBinding r14 = this.e;
        if (r14 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r14 = null;
    L26:
        r14.e.getContext();
        ContactDbFragmentOfficeMyJoinGroupBinding r15 = this.e;
        if (r15 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r15 = null;
    L29:
        LKUIPtrClassicFrameLayout r16 = r15.d;
        ContactDbFragmentOfficeMyJoinGroupBinding r17 = this.e;
        if (r17 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r17 = null;
    L32:
        CommonRecyclerView r18 = r17.e;
        int r19 = DesktopUtil.a;
        ChatWindowPtrLoadingHeader r20 = new ChatWindowPtrLoadingHeader(requireContext());
        ContactDbFragmentOfficeMyJoinGroupBinding r2 = this.e;
        if (r2 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r2 = null;
    L35:
        r2.d.setKeepHeaderWhenRefresh(true);
        ContactDbFragmentOfficeMyJoinGroupBinding r3 = this.e;
        if (r3 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r3 = null;
    L38:
        r3.d.setFooterView(r20);
        ContactDbFragmentOfficeMyJoinGroupBinding r21 = this.e;
        if (r21 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r21 = null;
    L41:
        r21.d.addPtrUIHandler(r20);
        ContactDbFragmentOfficeMyJoinGroupBinding r22 = this.e;
        if (r22 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r22 = null;
    L44:
        r22.d.disableWhenHorizontalMove(true);
        ContactDbFragmentOfficeMyJoinGroupBinding r23 = this.e;
        if (r23 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L48:
        r0.d.setPtrHandler(new d(this));
        S90().getGroups().observe(getViewLifecycleOwner(), new com.ss.android.lark.contact.customized.mygroup.view.b(this));
        S90().getLoadMoreFinished().observe(getViewLifecycleOwner(), new c(this));
        S90().loadInitial();
        return;
    L47:
        r0 = r23;
        goto L48
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        View r11 = r8.inflate(2131559909, r9, false);
        int r12 = 2131371589;
        ContactOfficeEmptyStateView r2 = (ContactOfficeEmptyStateView) ViewBindings.findChildViewById(r11, 2131371589);
        if (r2 == null) goto L15;
        r12 = 2131380560;
        LinearLayout r3 = (LinearLayout) ViewBindings.findChildViewById(r11, 2131380560);
        if (r3 == null) goto L15;
        r12 = 2131380561;
        LKUIPtrClassicFrameLayout r4 = ViewBindings.findChildViewById(r11, 2131380561);
        if (r4 == null) goto L15;
        r12 = 2131380562;
        CommonRecyclerView r5 = ViewBindings.findChildViewById(r11, 2131380562);
        if (r5 == null) goto L15;
        r12 = 2131388807;
        ContactOfficeTitleBar r6 = (ContactOfficeTitleBar) ViewBindings.findChildViewById(r11, 2131388807);
        if (r6 == null) goto L15;
        ContactDbFragmentOfficeMyJoinGroupBinding r13 = new ContactDbFragmentOfficeMyJoinGroupBinding((LinearLayout) r11, r2, r3, r4, r5, r6);
        this.e = r13;
        return r13.a;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
