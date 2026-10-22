package com.bytedance.android.ec.common.impl.sku.presenter;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.core.data.ActionObserver;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.widget.StatusView;
import com.bytedance.android.shopping.api.accessibility.AccessibilityDelegateCompatImpl;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m2 extends QFragmentPresenter {
    public SkuViewModel f;
    public com.bytedance.android.ec.common.impl.sku.view.f g;

    public m2(Fragment r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        super(r10);
    }

    public static final /* synthetic */ SkuViewModel d0(m2 r1) {
        SkuViewModel r10 = r1.f;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        return r10;
    }

    public final void b0(QModel r10) {
        this.f = (SkuViewModel) Y().g(SkuViewModel.class);
        View r11 = Z().b(2131376612).f();
        AccessibilityDelegateCompatImpl r1 = new AccessibilityDelegateCompatImpl(r11);
        r1.b = "关闭";
        ViewCompat.setAccessibilityDelegate(r11, r1);
        Z().b(2131376612).f().setOnClickListener(new SkuPanelGroupOptimizePresenter$initViews$2(this));
        SkuViewModel r12 = this.f;
        if (r12 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        String r13 = r12.getSkuParams().getDetailUrl();
        if (r13 != null) goto L8;
    L11:
        boolean r14 = true;
    L13:
        if (r14 == false) goto L21;
        Z().b(2131376612).f().setVisibility(0);
        Z().b(2131392180).f().setVisibility(8);
        View r15 = Z().b(2131372847).f();
        ViewGroup.LayoutParams r0 = r15.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == true) goto L17;
        r0 = null;
    L17:
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r0;
        if (r16 == null) goto L37;
        Resources r17 = Resources.getSystem();
        r16.bottomMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 0, WindowDisplayMetricsOverride.apply(r17, r17.getDisplayMetrics())));
        r15.setLayoutParams(r16);
    L37:
        final Ref.ObjectRef r18 = new Ref.ObjectRef();
        r18.element = null;
        StatusView r19 = (StatusView) Z().b(2131387797).f();
        View r20 = th.a.c(Y().c(), 2131560669, r19, false);
        r18.element = r20;
        if (r20 == null) goto L42;
        View r21 = r20.findViewById(2131390547);
        if (r21 == null) goto L42;
        com.bytedance.android.ec.core.widget.f.c(r21, null, null, new SkuPanelGroupOptimizePresenter$initStatusView$$inlined$apply$lambda$1(this, r18), 3);
    L42:
        SkuViewModel r22 = this.f;
        if (r22 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L45:
        String r23 = r22.getSkuParams().getDetailUrl();
        if (r23 != null) goto L48;
    L51:
        boolean r24 = true;
    L53:
        if (r24 == false) goto L56;
        View r25 = th.a.c(Y().c(), 2131564788, r19, false);
    L62:
        r19.b(r25, (View) r18.element, false);
        Z().b(2131378873).f().setVisibility(4);
        r19.showLoading();
        SkuViewModel r26 = this.f;
        if (r26 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L65:
        r26.getLoadStatus().b(ECQuickUtilKt.a(Y()), new h2(this, r18));
        SkuViewModel r110 = this.f;
        if (r110 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L68:
        r110.getDisplayToast().b(ECQuickUtilKt.a(Y()), new ActionObserver(new SkuPanelGroupOptimizePresenter$initSubscribe$1(this)));
        SkuViewModel r111 = this.f;
        if (r111 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L71:
        r111.getSkuInfo().b(ECQuickUtilKt.a(Y()), new j2(this));
        SkuViewModel r112 = this.f;
        if (r112 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L74:
        r112.getSkuInfo().b(ECQuickUtilKt.a(Y()), new l2(this));
        return;
    L56:
        if (com.bytedance.android.ec.core.abtest.d.F() != 1) goto L58;
    L61:
        r25 = th.a.c(Y().c(), 2131564787, r19, false);
        goto L62
    L58:
        if (com.bytedance.android.ec.core.abtest.d.F() == 2) goto L61;
        r25 = th.a.c(Y().c(), 2131564788, r19, false);
        goto L62
    L48:
        if (r23.length() == 0) goto L51;
        r24 = false;
        goto L53
    L21:
        if (com.bytedance.android.ec.core.abtest.d.F() != 1) goto L23;
    L31:
        Z().b(2131376612).f().setVisibility(8);
        Z().b(2131392180).f().setVisibility(0);
        View r113 = Z().b(2131372847).f();
        ViewGroup.LayoutParams r27 = r113.getLayoutParams();
        if ((r27 instanceof ViewGroup.MarginLayoutParams) == true) goto L34;
        r27 = null;
    L34:
        ViewGroup.MarginLayoutParams r28 = (ViewGroup.MarginLayoutParams) r27;
        if (r28 == null) goto L37;
        Resources r29 = Resources.getSystem();
        r28.bottomMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 12, WindowDisplayMetricsOverride.apply(r29, r29.getDisplayMetrics())));
        r113.setLayoutParams(r28);
        goto L37
    L23:
        if (com.bytedance.android.ec.core.abtest.d.F() == 2) goto L31;
        Z().b(2131376612).f().setVisibility(0);
        Z().b(2131392180).f().setVisibility(8);
        View r114 = Z().b(2131372847).f();
        ViewGroup.LayoutParams r30 = r114.getLayoutParams();
        if ((r30 instanceof ViewGroup.MarginLayoutParams) == true) goto L28;
        r30 = null;
    L28:
        ViewGroup.MarginLayoutParams r31 = (ViewGroup.MarginLayoutParams) r30;
        if (r31 == null) goto L37;
        Resources r32 = Resources.getSystem();
        r31.bottomMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 0, WindowDisplayMetricsOverride.apply(r32, r32.getDisplayMetrics())));
        r114.setLayoutParams(r31);
        goto L37
    L8:
        if (r13.length() == 0) goto L11;
        r14 = false;
        goto L13
    }
}
