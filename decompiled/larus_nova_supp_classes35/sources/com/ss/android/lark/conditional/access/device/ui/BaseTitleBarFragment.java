package com.ss.android.lark.conditional.access.device.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewbinding.ViewBinding;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.ui.CommonTitleBar;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u00152\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001f\u0010'\u001a\u00028\u00002\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0015H$¢\u0006\u0002\u0010(J\u001a\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020!2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010,\u001a\u00020*H\u0014R\u001c\u0010\u0006\u001a\u00028\u0000X\u0084.¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\r8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006-"}, d2 = {"Lcom/ss/android/lark/conditional/access/device/ui/BaseTitleBarFragment;", "VB", "Landroidx/viewbinding/ViewBinding;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "viewBinding", "getViewBinding", "()Landroidx/viewbinding/ViewBinding;", "setViewBinding", "(Landroidx/viewbinding/ViewBinding;)V", "Landroidx/viewbinding/ViewBinding;", "backgroundColorId", BuildConfig.FLAVOR, "getBackgroundColorId", "()I", "fullScreenContent", BuildConfig.FLAVOR, "getFullScreenContent", "()Z", "rootView", "Landroid/view/ViewGroup;", "getRootView", "()Landroid/view/ViewGroup;", "setRootView", "(Landroid/view/ViewGroup;)V", "titleBar", "Lcom/ss/android/lark/ui/CommonTitleBar;", "getTitleBar", "()Lcom/ss/android/lark/ui/CommonTitleBar;", "setTitleBar", "(Lcom/ss/android/lark/ui/CommonTitleBar;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "savedInstanceState", "Landroid/os/Bundle;", "inflateViewBinding", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroidx/viewbinding/ViewBinding;", "onViewCreated", BuildConfig.FLAVOR, "view", "onBackIconPressed", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseTitleBarFragment<VB extends ViewBinding> extends BaseFragment {
    public VB d;
    public ViewGroup e;
    public CommonTitleBar f;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ BaseTitleBarFragment<VB> a;

        public a(BaseTitleBarFragment<VB> r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.V90();
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ BaseTitleBarFragment<VB> a;

        public b(BaseTitleBarFragment<VB> r1) {
            this.a = r1;
        }

        public final void a() {
            View r0 = this.a.T90().getRoot();
            BaseTitleBarFragment<VB> r1 = this.a;
            ViewGroup.LayoutParams r2 = r0.getLayoutParams();
            if (r2 == null) goto L7;
            ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
            r1.getClass();
            r3.topMargin = r1.S90().getHeight();
            r0.setLayoutParams(r3);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public abstract VB U90(LayoutInflater r1, ViewGroup r2);

    public final CommonTitleBar S90() {
        CommonTitleBar r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        return null;
    }

    public final VB T90() {
        VB r0 = this.d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        return null;
    }

    public final ViewGroup getRootView() {
        ViewGroup r0 = this.e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        return null;
    }

    public final void V90() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L14;
        FragmentManager r1 = r0.getSupportFragmentManager();
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.getBackStackEntryCount() < 1) goto L10;
        r1.popBackStack();
        return;
    L10:
        FragmentActivity r2 = getActivity();
        if (r2 == null) goto L16;
        r2.finish();
        return;
    L16:
        return;
    }

    public BaseTitleBarFragment() {
    }

    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        UIUtils.setTextStyle(S90().getCenterText(), 2131953919);
        S90().getCenterText().setTextColor(getResources().getColor(2131106622));
        S90().post(new b(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        View r8 = r5.inflate(2131564437, r6, false);
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r9 = (ViewGroup) r8;
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        this.e = r9;
        Context r10 = getContext();
        if (r10 == null) goto L5;
        getRootView().setBackgroundColor(r10.getResources().getColor(2131100545));
    L5:
        VB r11 = (VB) U90(r5, r6);
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        this.d = r11;
        getRootView().addView(T90().getRoot(), 0, new LinearLayout.LayoutParams(-1, -1));
        CommonTitleBar r12 = getRootView().findViewById(2131388807);
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        this.f = r12;
        S90().setBackgroundColor(getResources().getColor(2131100545));
        S90().getLeftText().setOnClickListener(new a(this));
        return getRootView();
    }
}
