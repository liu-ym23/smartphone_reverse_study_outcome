package com.ss.android.lark.contact.customized.myqrcode.view;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.viewbinding.ViewBindings;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.contact.base.common_ui.InvBaseFragment;
import com.ss.android.lark.contact.customized.common.OfficeContactUtils;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeEmptyStateView;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeLoadingView;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeTitleBar;
import com.ss.android.lark.contact.customized.databinding.ContactDbActivityMyQrcodeBinding;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u001cH\u0002J\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020\u001cH\u0002J\b\u0010(\u001a\u00020\u001cH\u0002J\b\u0010)\u001a\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0010\u0010\u0011¨\u0006+"}, d2 = {"Lcom/ss/android/lark/contact/customized/myqrcode/view/OfficeMyQrCodeFragment;", "Lcom/ss/android/lark/contact/base/common_ui/InvBaseFragment;", "<init>", "()V", "viewBinding", "Lcom/ss/android/lark/contact/customized/databinding/ContactDbActivityMyQrcodeBinding;", "viewModel", "Lcom/ss/android/lark/contact/customized/myqrcode/view/OfficeMyQrCodeViewModel;", "getViewModel", "()Lcom/ss/android/lark/contact/customized/myqrcode/view/OfficeMyQrCodeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "showLoadingRunnable", "Ljava/lang/Runnable;", "sharePanelProtocol", "Lcom/ss/android/lark/biz/officesdk/im/share/IOfficeSDKSharePanel;", "getSharePanelProtocol", "()Lcom/ss/android/lark/biz/officesdk/im/share/IOfficeSDKSharePanel;", "sharePanelProtocol$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", BuildConfig.FLAVOR, "view", "initDataAndObserver", "initView", "renderView", BrowserDependency.UrlClickType.CARD, "Lcom/ss/android/lark/contact/customized/myqrcode/model/OfficeInviteExternalCardRenderModel;", "renderSharePanel", "showError", ChameleonOpenTracker.ParamKey.ERRORMSG, BuildConfig.FLAVOR, "showLoading", "dismissLoading", "cancelDelayedLoading", "Companion", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeMyQrCodeFragment extends InvBaseFragment {
    public static final /* synthetic */ int h = 0;
    public ContactDbActivityMyQrcodeBinding d;
    public final Lazy e;
    public f f;
    public final Lazy g;

    public static final class a {
    }

    static {
    }

    public final OfficeMyQrCodeViewModel T90() {
        return (OfficeMyQrCodeViewModel) this.e.getValue();
    }

    public OfficeMyQrCodeFragment() {
        final Function0<Fragment> r0 = new OfficeMyQrCodeFragment$special$$inlined$viewModels$default$1(this);
        this.e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(OfficeMyQrCodeViewModel.class), new OfficeMyQrCodeFragment$special$$inlined$viewModels$default$2(r0), new OfficeMyQrCodeFragment$special$$inlined$viewModels$default$3(r0, this));
        this.g = LazyKt.lazy(OfficeMyQrCodeFragment$sharePanelProtocol$2.INSTANCE);
    }

    public static final void S90(OfficeMyQrCodeFragment r4) {
        f r0 = r4.f;
        ContactDbActivityMyQrcodeBinding r2 = null;
        if (r0 == null) goto L9;
        ContactDbActivityMyQrcodeBinding r3 = r4.d;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r3 = null;
    L8:
        r3.a.removeCallbacks(r0);
        r4.f = null;
    L9:
        ContactDbActivityMyQrcodeBinding r1 = r4.d;
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r1 = null;
    L12:
        r1.d.a();
        ContactDbActivityMyQrcodeBinding r5 = r4.d;
        if (r5 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L16:
        r2.c.setVisibility(8);
        return;
    L15:
        r2 = r5;
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        ContactDbActivityMyQrcodeBinding r5 = this.d;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r5 = null;
    L5:
        r5.h.setLeftIconClickListener(new d(this));
        Context r6 = getContext();
        if (r6 == null) goto L8;
        Lazy r7 = OfficeContactUtils.a;
        OfficeContactUtils.e(this, UIUtils.getColor(r6, 2131102024));
    L8:
        T90().getInviteCardLiveData().observe(getViewLifecycleOwner(), new c(this));
        T90().onPageViewCreated(SystemClock.elapsedRealtime());
        T90().fetchContactToken();
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        View r13 = r10.inflate(2131559901, r11, false);
        int r14 = 2131374839;
        ContactOfficeEmptyStateView r2 = (ContactOfficeEmptyStateView) ViewBindings.findChildViewById(r13, 2131374839);
        if (r2 == null) goto L19;
        r14 = 2131374840;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(r13, 2131374840);
        if (r3 == null) goto L19;
        r14 = 2131374842;
        ContactOfficeLoadingView r4 = (ContactOfficeLoadingView) ViewBindings.findChildViewById(r13, 2131374842);
        if (r4 == null) goto L19;
        r14 = 2131374844;
        OfficeInviteExternalCardView r5 = (OfficeInviteExternalCardView) ViewBindings.findChildViewById(r13, 2131374844);
        if (r5 == null) goto L19;
        r14 = 2131374845;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r13, 2131374845);
        if (r6 == null) goto L19;
        r14 = 2131378575;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r13, 2131378575);
        if (r7 == null) goto L19;
        r14 = 2131388807;
        ContactOfficeTitleBar r8 = (ContactOfficeTitleBar) ViewBindings.findChildViewById(r13, 2131388807);
        if (r8 == null) goto L19;
        ContactDbActivityMyQrcodeBinding r15 = new ContactDbActivityMyQrcodeBinding((LinearLayout) r13, r2, r3, r4, r5, r6, r7, r8);
        this.d = r15;
        return r15.a;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r14)));
    }
}
