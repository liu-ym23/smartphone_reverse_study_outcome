package com.larus.commercecredit.impl.page;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.larus.bmhome.web.AiChatHostWebService;
import com.larus.commercecredit.impl.databinding.LarusFragmentCommerceCreditWebBinding;
import com.larus.commercecredit.impl.page.behavior.BottomSheetDialogWebViewBehavior;
import com.larus.platform.model.webview.AbsWebFragment;
import com.larus.platform.service.e2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.larus.utils.y0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u0012\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0010\u0018\u00010\u000fH\u0014J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0012H\u0014J\b\u0010\u0017\u001a\u00020\u0012H\u0002J\b\u0010\u0018\u001a\u00020\u0012H\u0002J\b\u0010\u0019\u001a\u00020\u0012H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0012H\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0002J\b\u0010\u001e\u001a\u00020\u0012H\u0002J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020#H\u0014J\b\u0010$\u001a\u00020\u0012H\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larus/commercecredit/impl/page/CommerceCreditWebFragment;", "Lcom/larus/commercecredit/impl/page/BaseCommerceCreditFragment;", "Lcom/larus/commercecredit/impl/databinding/LarusFragmentCommerceCreditWebBinding;", "<init>", "()V", "webUrl", "", "webView", "Landroid/webkit/WebView;", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "getAssociatedActivityClass", "Ljava/lang/Class;", "Landroid/app/Activity;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "parseArguments", "initViews", "setupTopCloseView", "hiddenBottomSheet", "setupWebFragment", "getWebViewScrollCallback", "Lcom/larus/bmhome/web/IWebViewProxyCallback;", "onStart", "setupFullScreen", "setupBottomSheetScrollListener", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "getAvailableBottomSheetHeight", "", "postUpdateBottomSheetHeight", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommerceCreditWebFragment extends BaseCommerceCreditFragment<LarusFragmentCommerceCreditWebBinding> {
    public static final /* synthetic */ int h = 0;
    public String f;
    public WebView g;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.commercecredit.impl.page.BaseCommerceCreditFragment
    public final int U90() {
        com.larus.utils.i0.a.getClass();
        int r0 = com.larus.utils.i0.g();
        Resources r1 = getResources();
        int r2 = WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).heightPixels - r0;
        if (r2 > 0) goto L6;
        int r3 = m0.a;
        return (m0.a(getContext()) - r0) - com.larus.utils.i0.e();
    L6:
        return r2;
    }

    @Override // com.larus.commercecredit.impl.page.BaseCommerceCreditFragment
    public final void W90() {
        WebView r0 = this.g;
        if (r0 == null) goto L6;
        r0.setTag(2131388155, Boolean.FALSE);
        return;
    }

    public CommerceCreditWebFragment() {
        this.f = "";
    }

    public final void X90() {
        Dialog r0 = getDialog();
        BottomSheetBehavior r1 = null;
        if (r0 == null) goto L5;
        View r2 = r0.findViewById(2131368870);
    L6:
        if (r2 == null) goto L8;
        r1 = BottomSheetBehavior.from(r2);
    L8:
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.getState() != 3) goto L14;
        r1.setState(5);
        return;
    L14:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.larus.commercecredit.impl.page.BaseCommerceCreditFragment
    public final void initViews() {
        Dialog r0 = getDialog();
        if (r0 == null) goto L8;
        View r1 = r0.findViewById(2131392603);
        if (r1 == null) goto L8;
        e1.d(r1, new r(this));
        r1.setOnTouchListener(new v(r1, this));
    L8:
        String r2 = this.f;
        if (r2 != null) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == true) goto L39;
        AiChatHostWebService r4 = AiChatHostWebService.a;
        AbsWebFragment r5 = r4.a(new t(this));
        if (r5 == null) goto L36;
        Context r6 = getContext();
        if (r6 == null) goto L22;
        Integer r7 = Integer.valueOf(ContextCompat.getColor(r6, 2131102539));
    L23:
        Integer r8 = r7;
        String r9 = this.f;
        if (r9 != null) goto L26;
        r9 = "";
    L26:
        r5.setArguments(r4.c(new zt8.b(r9, false, false, r8, false, 100)));
        FragmentTransaction r10 = getChildFragmentManager().beginTransaction();
        LarusFragmentCommerceCreditWebBinding r11 = (LarusFragmentCommerceCreditWebBinding) this.d;
        if (r11 == null) goto L37;
        FrameLayout r12 = r11.d;
        if (r12 == null) goto L38;
        int r13 = r12.getId();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r10, r5, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "web_fragment_tag", r13) == true) goto L34;
        r10.replace(r13, r5, "web_fragment_tag");
    L34:
        r10.commit();
        return;
    L38:
        return;
    L37:
        return;
    L22:
        r7 = null;
        goto L23
    L36:
        return;
    L39:
        return;
    L11:
        if (r2.length() == 0) goto L14;
        r3 = false;
        goto L15
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        BottomSheetDialog r0 = getDialog();
        BottomSheetDialog r2 = null;
        if ((r0 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r1 = r0;
    L7:
        if (r1 == null) goto L20;
        int r3 = BottomSheetDialogWebViewBehavior.d;
        Intrinsics.checkNotNullParameter(r1, "dialog");
        View r4 = r1.findViewById(2131368870);
        if (r4 == null) goto L13;
        CoordinatorLayout.LayoutParams r5 = r4.getLayoutParams();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        CoordinatorLayout.LayoutParams r6 = r5;
        r6.setBehavior(new BottomSheetDialogWebViewBehavior(r4.getContext(), null));
        r4.setLayoutParams(r6);
    L13:
        View r7 = r1.findViewById(2131368870);
        if (r7 == null) goto L20;
        Resources r8 = getResources();
        int r9 = WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics()).heightPixels;
        ViewGroup.LayoutParams r10 = r7.getLayoutParams();
        if (r10 == null) goto L19;
        r10.height = r9;
        r7.setLayoutParams(r10);
    L19:
        final BottomSheetBehavior r11 = BottomSheetBehavior.from(r7);
        r11.setPeekHeight(r9);
        r11.setState(3);
        r11.setSkipCollapsed(true);
        r11.setHideable(true);
        r1.setOnShowListener(new s(r11));
    L20:
        BottomSheetDialog r12 = getDialog();
        if ((r12 instanceof BottomSheetDialog) == false) goto L23;
        r2 = r12;
    L23:
        if (r2 == null) goto L30;
        View r13 = r2.findViewById(2131368870);
        if (r13 == null) goto L31;
        BottomSheetBehavior.from(r13).setBottomSheetCallback(new u(this));
        return;
    L31:
        return;
    L30:
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.larus.commercecredit.impl.page.BaseCommerceCreditFragment
    public final Class<? extends Activity> T90() {
        return CommerceCreditWebActivity.class;
    }

    public final void onConfigurationChanged(Configuration r4) {
        Intrinsics.checkNotNullParameter(r4, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r4);
        FLogger.a.d("CommerceCreditWebFragment", "onConfigurationChanged orientation=" + r4.orientation);
        if (e2.a.isPad() == false) goto L8;
        View r5 = getView();
        if (r5 == null) goto L9;
        r5.post(new b(this));
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r3) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r3);
        int r4 = com.larus.commercecredit.impl.utils.k.a;
        this.f = y0.k(y0.b(y0.c(com.larus.commercecredit.impl.utils.k.a(getArguments(), "src_url"), "enter_method", com.larus.commercecredit.impl.utils.k.a(getArguments(), "enter_method")), "prev_page", com.larus.commercecredit.impl.utils.k.a(getArguments(), "previous_page")));
    }

    @Override // com.larus.commercecredit.impl.page.BaseCommerceCreditFragment
    public final ViewBinding S90(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        ConstraintLayout r6 = r4.inflate(2131562362, r5, false);
        int r7 = 2131392493;
        View r0 = ViewBindings.findChildViewById(r6, 2131392493);
        if (r0 == null) goto L11;
        r7 = 2131392603;
        View r1 = ViewBindings.findChildViewById(r6, 2131392603);
        if (r1 == null) goto L11;
        r7 = 2131393115;
        FrameLayout r2 = (FrameLayout) ViewBindings.findChildViewById(r6, 2131393115);
        if (r2 == null) goto L11;
        return new LarusFragmentCommerceCreditWebBinding(r6, r0, r1, r2);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }
}
