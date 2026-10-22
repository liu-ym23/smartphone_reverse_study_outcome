package com.bytedance.android.ec.common.impl.sku.presenter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.model.response.ProductSelectPoiInfo;
import com.bytedance.android.ec.model.sku.SkuPoiInfo;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class y2 extends QFragmentPresenter {
    public SkuViewModel f;
    public TextView g;
    public TextView h;
    public View i;
    public String j;
    public String k;
    public View l;

    public static final class a extends com.bytedance.android.ec.core.widget.d {
        public final /* synthetic */ y2 g;

        public a(y2 r10) {
            this.g = r10;
            super(null, null, 3);
        }

        @Override // com.bytedance.android.ec.core.widget.d
        public final void a(View r10) {
            Intrinsics.checkNotNullParameter(r10, "v");
            y2 r0 = this.g;
            String r1 = r0.k;
            if (r1 == null) goto L22;
            int r11 = jg.e.a;
            int r12 = com.bytedance.android.ec.core.utils.g0.a;
            View r13 = r0.i;
            if (r13 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("selectPoiView");
        L8:
            if (com.bytedance.android.ec.core.utils.g0.a(r13.getContext()) == false) goto L10;
            String r14 = "1";
        L11:
            String r15 = jg.e.b(r1, "gpsOn", r14);
            String r16 = this.g.j;
            if (r16 != null) goto L14;
            r16 = "";
        L14:
            jg.e.b(r15, "selectedShopId", r16);
            Unit r17 = Unit.INSTANCE;
            Activity r18 = jg.h.a.getActivity(r10.getContext());
            if (r18 == null) goto L17;
            com.bytedance.android.ec.core.hybrid.utils.r.a(r15, r18);
        L17:
            SkuViewModel r19 = this.g.f;
            if (r19 != null) goto L20;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        L20:
            SkuViewModel.doSkuEventAction$default(r19, "click_offline_store_entrance", new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_LOCATION, "sku")}, null, null, null, 28, null);
            return;
        L10:
            r14 = "0";
            goto L11
        }
    }

    public y2(Fragment r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        super(r10);
    }

    public final void b0(QModel r10) {
        SkuViewModel r11 = (SkuViewModel) Y().g(SkuViewModel.class);
        this.f = r11;
        if (r11 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L6:
        if (r11.getSkuParams().isFromInsuranceApply() == false) goto L9;
        Y().d().q(dg.r.class, 8);
        return;
    L9:
        this.g = (TextView) Z().b(2131367574).f();
        this.h = (TextView) Z().b(2131367573).f();
        this.i = Z().b(2131367572).f();
        this.l = Z().b(2131367570).f();
        a r12 = new a(this);
        View r1 = this.i;
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("selectPoiView");
    L12:
        r1.setOnClickListener(r12);
        View r13 = this.l;
        if (r13 == null) goto L15;
        r13.setOnClickListener(r12);
    L15:
        ProductSelectPoiInfo r14 = com.bytedance.android.ec.core.utils.d1.a;
        Long r15 = null;
        if (r14 == null) goto L34;
        SkuViewModel r16 = this.f;
        if (r16 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L20:
        SkuInfoVO r17 = (SkuInfoVO) r16.getSkuInfo().a();
        if (r17 == null) goto L25;
        SkuPoiInfo r18 = r17.getPoiInfo();
        if (r18 == null) goto L25;
        r18.setSelectedPoiInfo(r14);
    L25:
        SkuPoiInfo r19 = new SkuPoiInfo();
        SkuViewModel r20 = this.f;
        if (r20 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L28:
        SkuInfoVO r21 = (SkuInfoVO) r20.getSkuInfo().a();
        if (r21 == null) goto L33;
        SkuPoiInfo r22 = r21.getPoiInfo();
        if (r22 == null) goto L33;
        r15 = r22.getTotal();
    L33:
        r19.setTotal(r15);
        r19.setSelectedPoiInfo(r14);
        Unit r23 = Unit.INSTANCE;
        e0(r19);
    L41:
        SkuViewModel r24 = this.f;
        if (r24 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L44:
        r24.getSelectPoiInfo().b(Y().e(), new x2(this));
        return;
    L34:
        SkuViewModel r25 = this.f;
        if (r25 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L37:
        SkuInfoVO r26 = (SkuInfoVO) r25.getSkuInfo().a();
        if (r26 == null) goto L40;
        r15 = r26.getPoiInfo();
    L40:
        e0(r15);
        goto L41
    }

    public final void d0(ProductSelectPoiInfo r10) {
        SkuViewModel r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuViewModel.doSkuEventAction$default(r0, "show_offline_store_entrance", new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_LOCATION, "sku")}, null, null, null, 28, null);
        ViewGroup.LayoutParams r1 = null;
        if (r10 == null) goto L8;
        String r11 = r10.getPoiId();
    L9:
        this.j = r11;
        Z().b(2131367571).f().setVisibility(0);
        if (r10 != null) goto L12;
    L54:
        Z().b(2131367570).f().setBackgroundResource(2131247938);
        TextView r12 = this.g;
        if (r12 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L57:
        ViewGroup.LayoutParams r13 = r12.getLayoutParams();
        if ((r13 instanceof LinearLayout.LayoutParams) == false) goto L61;
        r1 = r13;
    L61:
        LinearLayout.LayoutParams r14 = (LinearLayout.LayoutParams) r1;
        if (r14 == null) goto L67;
        r14.gravity = 16;
        TextView r15 = this.g;
        if (r15 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L66:
        r15.setLayoutParams(r14);
    L67:
        TextView r16 = this.g;
        if (r16 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L70:
        r16.setVisibility(0);
        TextView r17 = this.g;
        if (r17 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L73:
        TextView r18 = this.g;
        if (r18 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L76:
        r17.setTextColor(th.a.f(r18.getContext()).getColor(2131105996));
        TextView r19 = this.h;
        if (r19 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopAddress");
    L79:
        r19.setVisibility(8);
        int r110 = com.bytedance.android.ec.core.utils.g0.a;
        TextView r111 = this.g;
        if (r111 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L83:
        if (com.bytedance.android.ec.core.utils.g0.a(r111.getContext()) == true) goto L91;
        TextView r112 = this.g;
        if (r112 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L87:
        TextView r20 = this.g;
        if (r20 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L90:
        r112.setText(th.a.f(r20.getContext()).getString(2131914005));
        return;
    L91:
        TextView r113 = this.g;
        if (r113 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L94:
        TextView r21 = this.g;
        if (r21 != null) goto L97;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L97:
        r113.setText(th.a.f(r21.getContext()).getString(2131914011));
        return;
    L12:
        if (com.bytedance.android.ec.core.utils.a2.b(r10.getPoiName()) == true) goto L15;
        r10 = null;
    L15:
        if (r10 == null) goto L54;
        TextView r22 = this.g;
        if (r22 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L19:
        r22.setText(r10.getPoiName());
        Z().b(2131367570).f().setBackgroundResource(2131247936);
        TextView r23 = this.g;
        if (r23 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L22:
        TextView r24 = this.g;
        if (r24 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L25:
        r23.setTextColor(th.a.f(r24.getContext()).getColor(2131101581));
        TextView r25 = this.g;
        if (r25 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L28:
        ViewGroup.LayoutParams r26 = r25.getLayoutParams();
        if ((r26 instanceof LinearLayout.LayoutParams) == false) goto L32;
        r1 = r26;
    L32:
        LinearLayout.LayoutParams r27 = (LinearLayout.LayoutParams) r1;
        if (r27 == null) goto L38;
        r27.gravity = 0;
        TextView r28 = this.g;
        if (r28 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L37:
        r28.setLayoutParams(r27);
    L38:
        TextView r29 = this.g;
        if (r29 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L41:
        r29.setVisibility(0);
        if (com.bytedance.android.ec.core.utils.a2.b(r10.getAddress()) == false) goto L50;
        TextView r30 = this.h;
        if (r30 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopAddress");
    L46:
        r30.setText(r10.getAddress());
        TextView r114 = this.h;
        if (r114 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopAddress");
    L49:
        r114.setVisibility(0);
        return;
    L50:
        TextView r115 = this.h;
        if (r115 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopAddress");
    L53:
        r115.setVisibility(8);
        return;
    L8:
        r11 = null;
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
}
