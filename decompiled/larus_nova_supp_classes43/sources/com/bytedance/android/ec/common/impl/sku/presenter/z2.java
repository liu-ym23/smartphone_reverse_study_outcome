package com.bytedance.android.ec.common.impl.sku.presenter;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.view.SkuContentsLayout;
import com.bytedance.android.ec.model.sku.BackgroundInfo;
import com.bytedance.android.ec.model.sku.ContentInfo;
import com.bytedance.android.ec.model.sku.TopBannerComponent;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class z2 extends QFragmentPresenter {
    public SkuViewModel f;
    public LinearLayout g;
    public SkuContentsLayout h;
    public final a i;

    public static final class a implements ul.c {
        public final /* synthetic */ z2 a;

        public a(z2 r1) {
            this.a = r1;
        }

        public final void a(boolean r10) {
            if (r10 == false) goto L4;
            this.a.Y().d().q(dg.t.class, 0);
            return;
        L4:
            this.a.Y().d().q(dg.t.class, 8);
        }
    }

    public final void c0() {
        List r0 = ul.b.a;
        ul.b.a(this.i);
        dm.a.a("TopBannerModePresenter").i("onUnBind");
    }

    public z2(Fragment r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        super(r10);
        this.i = new a(this);
    }

    public final void b0(QModel r10) {
        this.f = (SkuViewModel) Y().g(SkuViewModel.class);
        this.g = (LinearLayout) Z().b(2131389116).f();
        this.h = (SkuContentsLayout) Z().b(2131378869).f();
        SkuViewModel r11 = this.f;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuInfoVO r12 = (SkuInfoVO) r11.getSkuInfo().a();
        ViewGroup.LayoutParams r1 = null;
        if (r12 == null) goto L8;
        TopBannerComponent r13 = r12.getTopBannerComponent();
    L10:
        if (r13 == null) goto L50;
        BackgroundInfo r14 = r13.getBackground();
        if (r14 == null) goto L50;
        GradientDrawable r15 = new GradientDrawable();
        Integer r16 = r14.getCornerRadius();
        if (r16 == null) goto L16;
        r15.setCornerRadius(com.bytedance.android.ec.core.utils.q.a(Integer.valueOf(r16.intValue())));
    L16:
        String r17 = r14.getBackgroundColor();
        if (r17 != null) goto L63;
    L21:
        LinearLayout r18 = this.g;
        if (r18 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L24:
        r18.setBackgroundDrawable(r15);
        Integer r19 = r14.getHeight();
        if (r19 == null) goto L50;
        int r20 = r19.intValue();
        LinearLayout r21 = this.g;
        if (r21 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L29:
        ViewParent r22 = r21.getParent();
        if ((r22 instanceof FrameLayout) == true) goto L32;
        r22 = null;
    L32:
        FrameLayout r23 = (FrameLayout) r22;
        if (r23 == null) goto L35;
        ViewGroup.LayoutParams r24 = r23.getLayoutParams();
    L37:
        if ((r24 instanceof RelativeLayout.LayoutParams) == false) goto L40;
        r1 = r24;
    L40:
        RelativeLayout.LayoutParams r25 = (RelativeLayout.LayoutParams) r1;
        if (r25 == null) goto L50;
        Resources r26 = Resources.getSystem();
        int r27 = MathKt.roundToInt(TypedValue.applyDimension(1, 8, WindowDisplayMetricsOverride.apply(r26, r26.getDisplayMetrics())));
        float r28 = r20;
        Resources r29 = Resources.getSystem();
        r25.topMargin = -(r27 + MathKt.roundToInt(TypedValue.applyDimension(1, r28, WindowDisplayMetricsOverride.apply(r29, r29.getDisplayMetrics()))));
        Resources r30 = Resources.getSystem();
        r25.height = MathKt.roundToInt(TypedValue.applyDimension(1, r28, WindowDisplayMetricsOverride.apply(r30, r30.getDisplayMetrics())));
        LinearLayout r31 = this.g;
        if (r31 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L45:
        ViewParent r32 = r31.getParent();
        if (r32 == null) goto L49;
        ((FrameLayout) r32).setLayoutParams(r25);
        goto L50
    L49:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    L35:
        r24 = null;
        goto L37
    L63:
        r15.setColor(Color.parseColor(r17));     // Catch: Exception -> L20
    L50:
        if (r13 == null) goto L60;
        List<ContentInfo> r110 = r13.getContents();
        if (r110 == null) goto L60;
        int r33 = com.bytedance.android.ec.core.utils.k1.m(Y().c());
        float r34 = 24;
        Resources r35 = Resources.getSystem();
        int r36 = r33 - MathKt.roundToInt(TypedValue.applyDimension(1, r34, WindowDisplayMetricsOverride.apply(r35, r35.getDisplayMetrics())));
        Resources r37 = Resources.getSystem();
        int r38 = r36 - MathKt.roundToInt(TypedValue.applyDimension(1, r34, WindowDisplayMetricsOverride.apply(r37, r37.getDisplayMetrics())));
        SkuContentsLayout r39 = this.h;
        if (r39 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("contents");
    L56:
        SkuViewModel r40 = this.f;
        if (r40 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L59:
        r39.a(r110, r38, r40);
    L61:
        List r111 = ul.b.a;
        ul.b.b(this.i);
        dm.a.a("TopBannerModePresenter").i("onBind");
        return;
    L60:
        Y().d().q(dg.t.class, 8);
        goto L61
    L8:
        r13 = null;
        goto L10
    }
}
