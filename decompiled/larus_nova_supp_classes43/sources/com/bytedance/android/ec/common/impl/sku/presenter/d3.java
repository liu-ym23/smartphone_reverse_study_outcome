package com.bytedance.android.ec.common.impl.sku.presenter;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.model.sku.TradeModeComponent;
import com.bytedance.android.ec.model.sku.TradeModeSelection;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d3 extends QFragmentPresenter {
    public SkuViewModel f;
    public LinearLayout g;
    public boolean h;

    public d3(Fragment r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        super(r10);
    }

    public static final void d0(d3 r14) {
        if (r14.h == true) goto L47;
        Rect r0 = new Rect();
        LinearLayout r1 = r14.g;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L8:
        if (r1.getLocalVisibleRect(r0) == false) goto L48;
        SkuViewModel r10 = r14.f;
        if (r10 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L12:
        SkuInfoVO r11 = (SkuInfoVO) r10.getSkuInfo().a();
        if (r11 == null) goto L40;
        TradeModeComponent r12 = r11.getTradeModeComponent();
        if (r12 == null) goto L40;
        List r13 = r12.getSelections();
        if (r13 == null) goto L40;
        Iterator r15 = r13.iterator();
    L20:
        if (r15.hasNext() == false) goto L30;
        Object r16 = r15.next();
        Integer r17 = ((TradeModeSelection) r16).getType();
        if (r17 != null) goto L25;
    L27:
        boolean r18 = false;
    L28:
        if (r18 == false) goto L20;
    L31:
        TradeModeSelection r19 = (TradeModeSelection) r16;
        if (r19 == null) goto L40;
        SkuViewModel r20 = r14.f;
        if (r20 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L36:
        Pair[] r21 = new Pair[4];
        r21[0] = TuplesKt.to("trade_in_page", "sku");
        SkuViewModel r22 = r14.f;
        if (r22 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L39:
        r21[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_ID, r22.getSkuParams().getProductId());
        r21[2] = TuplesKt.to("trade_benefit_id", String.valueOf(r19.getBenefitType()));
        r21[3] = TuplesKt.to("trade_benefit_text", r19.getSubContent());
        SkuViewModel.doSkuEventAction$default(r20, "show_product_trade_in", r21, null, null, null, 28, null);
        goto L40
    L25:
        if (r17.intValue() != 2) goto L27;
        r18 = true;
        goto L28
    L30:
        r16 = null;
    L40:
        r14.h = true;
        return;
    L48:
        return;
    }

    public final void b0(QModel r12) {
        this.f = (SkuViewModel) Y().g(SkuViewModel.class);
        this.g = (LinearLayout) Z().b(2131378879).f();
        SkuViewModel r13 = this.f;
        if (r13 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuInfoVO r14 = (SkuInfoVO) r13.getSkuInfo().a();
        Integer r1 = null;
        if (r14 == null) goto L8;
        TradeModeComponent r15 = r14.getTradeModeComponent();
    L10:
        if (r15 == null) goto L80;
        List r10 = r15.getSelections();
        if (TextUtils.isEmpty(r15.getTitle()) == true) goto L14;
        ((TextView) Z().b(2131391473).f()).setText(r15.getTitle());
    L14:
        if (r10 != null) goto L16;
        r10 = CollectionsKt.emptyList();
    L16:
        int r11 = 0;
        if (r10.isEmpty() == false) goto L19;
        Y().d().q(dg.u.class, 8);
    L54:
        SkuViewModel r16 = this.f;
        if (r16 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L57:
        r16.getOnItemChange().b(Y().e(), new a3(this));
        SkuViewModel r17 = this.f;
        if (r17 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L60:
        r17.getCurrentTradeModeIndex().b(ECQuickUtilKt.a(Y()), new b3(this));
        SkuViewModel r18 = this.f;
        if (r18 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L63:
        r18.getScrollViewScrollY().b(ECQuickUtilKt.a(Y()), new c3(this));
        SkuViewModel r19 = this.f;
        if (r19 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L66:
        QLiveData<Integer> r110 = r19.getCurrentTradeModeIndex();
        com.bytedance.android.ec.common.impl.sku.utils.q.a r20 = com.bytedance.android.ec.common.impl.sku.utils.q.a;
        SkuViewModel r21 = this.f;
        if (r21 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L69:
        String r0 = r21.getSkuParams().getPromotionId();
        Intrinsics.checkNotNullParameter(r0, "promotionId");
        com.bytedance.android.ec.common.impl.sku.utils.r r22 = com.bytedance.android.ec.common.impl.sku.utils.q.a.get(r0);
        if (r22 != null) goto L72;
    L77:
        if (r1 == null) goto L79;
        r11 = r1.intValue();
    L79:
        r110.g(Integer.valueOf(r11));
        return;
    L72:
        if ((System.currentTimeMillis() - r22.b) > 1800000) goto L74;
        boolean r23 = true;
    L75:
        if (r23 == false) goto L77;
        r1 = Integer.valueOf(r22.a);
        goto L77
    L74:
        r23 = false;
        goto L75
    L19:
        Iterator r111 = r10.iterator();
    L21:
        if (r111.hasNext() == false) goto L54;
        TradeModeSelection r24 = (TradeModeSelection) r111.next();
        LinearLayout r25 = this.g;
        if (r25 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L25:
        SkuViewModel r26 = this.f;
        if (r26 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L28:
        com.bytedance.android.ec.common.impl.sku.view.j r27 = new com.bytedance.android.ec.common.impl.sku.view.j(r26, Y().c());
        int r28 = r10.indexOf(r24);
        int r29 = r10.size();
        Intrinsics.checkNotNullParameter(r24, "selection");
        String r30 = r24.getContent();
        if (r30 == null) goto L31;
        r27.b.setText(r30);
    L31:
        String r31 = r24.getSubContent();
        if (r31 == null) goto L34;
        r27.c.setText(r31);
    L34:
        String r32 = r24.getCornerText();
        if (r32 == null) goto L37;
        r27.d.setText(r32);
    L37:
        jg.g.d(r27.c, jg.g.a(r24.getSubContent()));
        jg.g.d(r27.d, jg.g.a(r24.getCornerText()));
        if (r28 != 0) goto L46;
        ViewGroup.LayoutParams r33 = r27.e.getLayoutParams();
        if ((r33 instanceof ViewGroup.MarginLayoutParams) == true) goto L42;
        r33 = null;
    L42:
        ViewGroup.MarginLayoutParams r34 = (ViewGroup.MarginLayoutParams) r33;
        if (r34 == null) goto L53;
        r34.leftMargin = 0;
    L53:
        r27.setClipChildren(false);
        r27.e.setOnClickListener(new com.bytedance.android.ec.common.impl.sku.view.i(r27, r28, r24));
        Unit r35 = Unit.INSTANCE;
        r25.addView(r27);
        goto L21
    L46:
        if (r28 != (r29 - 1)) goto L53;
        ViewGroup.LayoutParams r36 = r27.e.getLayoutParams();
        if ((r36 instanceof ViewGroup.MarginLayoutParams) == true) goto L50;
        r36 = null;
    L50:
        ViewGroup.MarginLayoutParams r37 = (ViewGroup.MarginLayoutParams) r36;
        if (r37 == null) goto L53;
        r37.rightMargin = 0;
        goto L53
    L80:
        Y().d().q(dg.u.class, 8);
        return;
    L8:
        r15 = null;
        goto L10
    }
}
