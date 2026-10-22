package com.bytedance.android.ec.common.impl.sku.presenter;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.view.SkuContentsLayout;
import com.bytedance.android.ec.model.sku.ContentInfo;
import com.bytedance.android.ec.model.sku.SafeguardComponent;
import com.bytedance.android.ec.model.sku.TextObject;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class t1 extends QFragmentPresenter {
    public SkuViewModel f;
    public TextView g;
    public SkuContentsLayout h;

    public t1(Fragment r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        super(r10);
    }

    public final void b0(QModel r10) {
        this.f = (SkuViewModel) Y().g(SkuViewModel.class);
        this.g = (TextView) Z().b(2131391450).f();
        this.h = (SkuContentsLayout) Z().b(2131378869).f();
        SkuViewModel r11 = this.f;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuInfoVO r12 = (SkuInfoVO) r11.getSkuInfo().a();
        if (r12 == null) goto L8;
        SafeguardComponent r13 = r12.getSafeguardComponent();
    L10:
        if (r13 == null) goto L50;
        List r14 = r13.getHeaders();
        if (r14 == null) goto L50;
        ContentInfo r15 = (ContentInfo) CollectionsKt.firstOrNull(r14);
        if (r15 == null) goto L50;
        TextObject r16 = r15.getTextObject();
        if (r16 == null) goto L50;
        String r17 = r16.getText();
        if (r17 == null) goto L50;
        TextView r18 = this.g;
        if (r18 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("header");
    L22:
        r18.setText(r17);
        String r19 = r16.getFontColor();
        if (r19 != null) goto L68;
    L30:
        Integer r20 = r16.getFontSize();
        if (r20 == null) goto L36;
        int r21 = r20.intValue();
        TextView r22 = this.g;
        if (r22 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("header");
    L35:
        r22.setTextSize(r21);
    L36:
        Boolean r23 = r16.getBold();
        if (r23 == null) goto L45;
        boolean r24 = r23.booleanValue();
        TextView r25 = this.g;
        if (r25 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("header");
    L41:
        if (r24 == false) goto L43;
        Typeface r26 = Typeface.DEFAULT_BOLD;
    L44:
        r25.setTypeface(r26);
        goto L45
    L43:
        r26 = Typeface.DEFAULT;
    L45:
        TextView r27 = this.g;
        if (r27 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("header");
    L48:
        r27.setGravity(16);
        goto L50
    L68:
        TextView r28 = this.g;     // Catch: Exception -> L29
        if (r28 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("header");     // Catch: Exception -> L29
    L27:
        r28.setTextColor(Color.parseColor(r19));     // Catch: Exception -> L29
    L50:
        if (r13 == null) goto L66;
        List<ContentInfo> r29 = r13.getContents();
        if (r29 == null) goto L66;
        TextView r30 = this.g;
        if (r30 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("header");
    L56:
        r30.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        TextView r31 = this.g;
        if (r31 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("header");
    L59:
        int r32 = com.bytedance.android.ec.core.utils.k1.m(Y().c()) - r31.getMeasuredWidth();
        Resources r33 = Resources.getSystem();
        int r34 = r32 - MathKt.roundToInt(TypedValue.applyDimension(1, 16, WindowDisplayMetricsOverride.apply(r33, r33.getDisplayMetrics())));
        Resources r35 = Resources.getSystem();
        int r36 = r34 - MathKt.roundToInt(TypedValue.applyDimension(1, 24, WindowDisplayMetricsOverride.apply(r35, r35.getDisplayMetrics())));
        Resources r37 = Resources.getSystem();
        int r38 = r36 - MathKt.roundToInt(TypedValue.applyDimension(1, 8, WindowDisplayMetricsOverride.apply(r37, r37.getDisplayMetrics())));
        SkuContentsLayout r1 = this.h;
        if (r1 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("contents");
    L62:
        SkuViewModel r39 = this.f;
        if (r39 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L65:
        r1.a(r29, r38, r39);
        return;
    L66:
        Y().d().q(dg.m.class, 8);
        return;
    L8:
        r13 = null;
        goto L10
    }
}
