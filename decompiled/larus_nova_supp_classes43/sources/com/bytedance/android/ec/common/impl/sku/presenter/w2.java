package com.bytedance.android.ec.common.impl.sku.presenter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuDiscountInfo;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuInstallmentItemInfo;
import com.bytedance.android.ec.common.impl.sku.model.SkuTermInfo;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.model.response.ProductSelectPoiInfo;
import com.bytedance.android.ec.model.sku.DisplayConfig;
import com.bytedance.android.ec.model.sku.SkuPoiInfo;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class w2 extends QFragmentPresenter {
    public SkuViewModel f;
    public TextView g;
    public View h;
    public TextView i;
    public String j;
    public String k;
    public View l;

    public static final class a extends com.bytedance.android.ec.core.widget.d {
        public final /* synthetic */ w2 g;

        public a(w2 r10) {
            this.g = r10;
            super(null, null, 3);
        }

        @Override // com.bytedance.android.ec.core.widget.d
        public final void a(View r14) {
            Intrinsics.checkNotNullParameter(r14, "v");
            w2 r0 = this.g;
            String r1 = r0.k;
            if (r1 == null) goto L22;
            int r10 = jg.e.a;
            int r11 = com.bytedance.android.ec.core.utils.g0.a;
            View r12 = r0.l;
            if (r12 == null) goto L7;
            Context r13 = r12.getContext();
        L9:
            if (com.bytedance.android.ec.core.utils.g0.a(r13) == false) goto L11;
            String r15 = "1";
        L12:
            String r16 = jg.e.b(r1, "gpsOn", r15);
            String r17 = this.g.j;
            if (r17 != null) goto L15;
            r17 = "";
        L15:
            jg.e.b(r16, "selectedShopId", r17);
            Unit r18 = Unit.INSTANCE;
            Activity r19 = jg.h.a.getActivity(r14.getContext());
            if (r19 == null) goto L18;
            com.bytedance.android.ec.core.hybrid.utils.r.a(r16, r19);
        L18:
            SkuViewModel r20 = this.g.f;
            if (r20 != null) goto L21;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        L21:
            SkuViewModel.doSkuEventAction$default(r20, "click_offline_store_entrance", new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_LOCATION, "sku")}, null, null, null, 28, null);
            goto L22
        L11:
            r15 = "0";
            goto L12
        L7:
            r13 = null;
        L22:
            SkuViewModel r21 = this.g.f;
            if (r21 != null) goto L25;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        L25:
            SkuViewModel.doSkuEventAction$default(r21, "sku_panel_module_click", new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MODULE_NAME, "shop_choose")}, null, null, null, 28, null);
        }
    }

    public w2(Fragment r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        super(r10);
    }

    public final void b0(QModel r11) {
        SkuViewModel r12 = (SkuViewModel) Y().g(SkuViewModel.class);
        this.f = r12;
        if (r12 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L6:
        if (r12.getSkuParams().isFromInsuranceApply() == false) goto L9;
        Y().d().q(dg.s.class, 8);
        return;
    L9:
        SkuViewModel r10 = this.f;
        if (r10 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L12:
        SkuViewModel.doSkuEventAction$default(r10, "sku_panel_module_show", new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MODULE_NAME, "shop_choose")}, null, null, null, 28, null);
        this.g = (TextView) Z().b(2131367574).f();
        this.i = (TextView) Z().b(2131367573).f();
        this.l = Z().b(2131367570).f();
        this.h = Z().b(2131367568).f();
        a r13 = new a(this);
        View r1 = this.l;
        if (r1 == null) goto L15;
        r1.setOnClickListener(r13);
    L15:
        ProductSelectPoiInfo r14 = com.bytedance.android.ec.core.utils.d1.a;
        Long r15 = null;
        if (r14 != null) goto L21;
        SkuPoiInfo r16 = com.bytedance.android.ec.core.utils.d1.b;
        if (r16 == null) goto L20;
        r14 = r16.getSelectedPoiInfo();
        goto L21
    L20:
        r14 = null;
    L21:
        if (r14 == null) goto L39;
        SkuViewModel r17 = this.f;
        if (r17 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L25:
        SkuInfoVO r18 = (SkuInfoVO) r17.getSkuInfo().a();
        if (r18 == null) goto L30;
        SkuPoiInfo r19 = r18.getPoiInfo();
        if (r19 == null) goto L30;
        r19.setSelectedPoiInfo(r14);
    L30:
        SkuPoiInfo r20 = new SkuPoiInfo();
        SkuViewModel r21 = this.f;
        if (r21 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L33:
        SkuInfoVO r22 = (SkuInfoVO) r21.getSkuInfo().a();
        if (r22 == null) goto L38;
        SkuPoiInfo r23 = r22.getPoiInfo();
        if (r23 == null) goto L38;
        r15 = r23.getTotal();
    L38:
        r20.setTotal(r15);
        r20.setSelectedPoiInfo(r14);
        Unit r110 = Unit.INSTANCE;
        e0(r20);
    L46:
        SkuViewModel r111 = this.f;
        if (r111 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L49:
        r111.getSelectPoiInfo().b(Y().e(), new u2(this));
        SkuViewModel r112 = this.f;
        if (r112 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L52:
        r112.getSkuInfo().b(ECQuickUtilKt.a(Y()), new v2(this));
        return;
    L39:
        SkuViewModel r113 = this.f;
        if (r113 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L42:
        SkuInfoVO r114 = (SkuInfoVO) r113.getSkuInfo().a();
        if (r114 == null) goto L45;
        r15 = r114.getPoiInfo();
    L45:
        e0(r15);
        goto L46
    }

    public final void d0(ProductSelectPoiInfo r11) {
        SkuViewModel r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuViewModel.doSkuEventAction$default(r0, "show_offline_store_entrance", new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_LOCATION, "sku")}, null, null, null, 28, null);
        SkuInstallmentItemInfo r1 = null;
        if (r11 == null) goto L8;
        String r10 = r11.getPoiId();
    L9:
        this.j = r10;
        Z().b(2131367571).f().setVisibility(0);
        if (r11 != null) goto L12;
    L41:
        TextView r12 = this.g;
        if (r12 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L44:
        r12.setVisibility(0);
        TextView r13 = this.i;
        if (r13 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopAddress");
    L47:
        r13.setVisibility(8);
        TextView r14 = this.g;
        if (r14 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L50:
        TextView r15 = this.g;
        if (r15 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L53:
        r14.setTextColor(th.a.f(r15.getContext()).getColor(2131101659));
        int r16 = com.bytedance.android.ec.core.utils.g0.a;
        TextView r17 = this.g;
        if (r17 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L57:
        if (com.bytedance.android.ec.core.utils.g0.a(r17.getContext()) == true) goto L65;
        TextView r18 = this.g;
        if (r18 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L61:
        TextView r19 = this.g;
        if (r19 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L64:
        r18.setText(th.a.f(r19.getContext()).getString(2131914006));
    L72:
        SkuViewModel r110 = this.f;
        if (r110 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L75:
        SkuInfoVO r111 = (SkuInfoVO) r110.getSkuInfo().a();
        if (r111 == null) goto L78;
        r1 = r111.getInstallmentInfo();
    L78:
        h0(r1);
        return;
    L65:
        TextView r112 = this.g;
        if (r112 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L68:
        TextView r20 = this.g;
        if (r20 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L71:
        r112.setText(th.a.f(r20.getContext()).getString(2131914012));
        goto L72
    L12:
        if (com.bytedance.android.ec.core.utils.a2.b(r11.getPoiName()) == true) goto L15;
        r11 = null;
    L15:
        if (r11 == null) goto L41;
        String r21 = "已选：" + r11.getPoiName();
        TextView r22 = this.g;
        if (r22 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L19:
        r22.setText(r21);
        TextView r23 = this.g;
        if (r23 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L22:
        r23.setVisibility(0);
        TextView r24 = this.g;
        if (r24 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L25:
        TextView r25 = this.g;
        if (r25 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L28:
        r24.setTextColor(th.a.f(r25.getContext()).getColor(2131101565));
        if (com.bytedance.android.ec.core.utils.a2.b(r11.getAddress()) == false) goto L37;
        TextView r26 = this.i;
        if (r26 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopAddress");
    L33:
        r26.setText(r11.getAddress());
        TextView r113 = this.i;
        if (r113 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopAddress");
    L36:
        r113.setVisibility(0);
        goto L72
    L37:
        TextView r114 = this.i;
        if (r114 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopAddress");
    L40:
        r114.setVisibility(8);
        goto L72
    L8:
        r10 = null;
        goto L9
    }

    public final void e0(SkuPoiInfo r10) {
        String r0 = null;
        if (r10 == null) goto L5;
        Long r1 = r10.getTotal();
    L6:
        SkuViewModel r11 = this.f;
        if (r11 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L9:
        SkuInfoVO r12 = (SkuInfoVO) r11.getSkuInfo().a();
        if (r12 == null) goto L14;
        SkuPoiInfo r13 = r12.getPoiInfo();
        if (r13 == null) goto L14;
        r0 = r13.getNavLink();
    L14:
        this.k = r0;
        if (r1 != null) goto L17;
    L20:
        Z().b(2131367571).f().setVisibility(8);
        return;
    L17:
        if (r1.longValue() <= 0) goto L20;
        d0(r10.getSelectedPoiInfo());
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void h0(SkuInstallmentItemInfo r10) {
        SkuViewModel r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuInfoVO r1 = (SkuInfoVO) r0.getSkuInfo().a();
        SkuDiscountInfo r11 = null;
        if (r1 == null) goto L10;
        DisplayConfig r12 = r1.getDisplayConfig();
        if (r12 == null) goto L10;
        Boolean r13 = r12.getShowDouInstallment();
    L11:
        int r14 = 0;
        if (Intrinsics.areEqual(r13, Boolean.TRUE) == false) goto L21;
        if (r10 == null) goto L15;
        SkuTermInfo r15 = r10.getTermInfo();
    L16:
        if (r15 != null) goto L20;
        if (r10 == null) goto L19;
        r11 = r10.getDiscountInfo();
    L19:
        if (r11 == null) goto L21;
    L20:
        boolean r16 = true;
    L22:
        if (r16 == true) goto L25;
        r14 = 8;
    L25:
        View r17 = this.h;
        if (r17 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("divierView");
    L29:
        if (r17.getVisibility() == r14) goto L35;
        View r18 = this.h;
        if (r18 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("divierView");
    L33:
        r18.setVisibility(r14);
        return;
    L35:
        return;
    L15:
        r15 = null;
    L21:
        r16 = false;
    L10:
        r13 = null;
        goto L11
    }
}
