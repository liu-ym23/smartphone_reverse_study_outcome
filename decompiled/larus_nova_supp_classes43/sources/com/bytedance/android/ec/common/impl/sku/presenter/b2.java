package com.bytedance.android.ec.common.impl.sku.presenter;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuBannerStruct;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuItemInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuLimit;
import com.bytedance.android.ec.common.impl.sku.model.SpecInfo;
import com.bytedance.android.ec.common.impl.sku.model.SpecInfoItem;
import com.bytedance.android.ec.common.impl.sku.view.SpecItemOptimizeGroupLayout;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.model.ProductPriceInfo;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.PromotionDiscountPrice;
import com.bytedance.android.ec.model.sku.CarAdaptComponent;
import com.bytedance.android.ec.model.sku.SkuProductDetailInfo;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b2 extends QFragmentPresenter {
    public SkuViewModel f;
    public LinearLayout g;
    public SpecItemOptimizeGroupLayout h;
    public String i;

    public static final class a implements SpecItemOptimizeGroupLayout.d {
        public final /* synthetic */ b2 a;

        @Override // com.bytedance.android.ec.common.impl.sku.view.SpecItemOptimizeGroupLayout.d
        public final void b() {
            cg.h r0 = b2.e0(this.a).getSpecTitleEntryEventStruct();
            SkuViewModel r10 = b2.e0(this.a);
            Pair[] r11 = new Pair[4];
            if (b2.e0(this.a).getSkuParams().isFromAnchorV3() == false) goto L5;
            String r1 = com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL;
        L6:
            r11[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PAGE_NAME, r1);
            r11[1] = TuplesKt.to("is_product_recommand", String.valueOf(r0.b));
            r11[2] = TuplesKt.to("is_user_input", String.valueOf(r0.c));
            r11[3] = TuplesKt.to("is_size_recommand", String.valueOf(r0.d));
            SkuViewModel.doSkuEventAction$default(r10, "pd_size_chart_tab_click", r11, null, null, null, 28, null);
            return;
        L5:
            r1 = "live_room_sku";
            goto L6
        }

        public a(b2 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.ec.common.impl.sku.view.SpecItemOptimizeGroupLayout.d
        public final void a(int r12) {
            String r1 = "1";
            if (b2.e0(this.a).isSizeTabExist() == false) goto L5;
            Object r0 = "1";
        L6:
            SkuInfoVO r10 = (SkuInfoVO) b2.e0(this.a).getSkuInfo().a();
            if (r10 == null) goto L9;
            SkuBannerStruct r11 = r10.getSkuBanner();
        L10:
            if (r11 != null) goto L13;
            r1 = "0";
        L13:
            SkuViewModel r13 = b2.e0(this.a);
            Pair[] r14 = new Pair[5];
            r14[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PREVIOUS_PAGE, b2.e0(this.a).getPreviousPage());
            r14[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_EXIST_SIZE_TAB, r0);
            r14[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_THREE_D, b2.e0(this.a).getSkuParams().getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_THREE_D));
            r14[3] = TuplesKt.to("with_comment", r1);
            if (b2.e0(this.a).isPresaleSkuSpec(r12) == false) goto L16;
            String r15 = "true";
        L17:
            r14[4] = TuplesKt.to("with_presell_sku", r15);
            SkuViewModel.doSkuEventAction$default(r13, "params_sku_click", r14, null, null, null, 28, null);
            return;
        L16:
            r15 = "false";
            goto L17
        L9:
            r11 = null;
            goto L10
        L5:
            r0 = "0";
            goto L6
        }
    }

    public static final class b implements SpecItemOptimizeGroupLayout.b {
        public final /* synthetic */ b2 a;

        public b(b2 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.ec.common.impl.sku.view.SpecItemOptimizeGroupLayout.b
        public final void a(String[] r27, boolean r28) {
            Intrinsics.checkNotNullParameter(r27, "checkIdArray");
            b2.h0(this.a, r28);
            SkuRestoreState r10 = b2.e0(this.a).getSkuPanelState();
            if (r10 == null) goto L5;
            r10.setSelectSkuKeys(r27);
        L5:
            b2.e0(this.a).notifySkuChanged();
            Function1<SkuProductDetailInfo, Unit> r11 = b2.e0(this.a).getRefreshDetailInfoCallback();
            if (r11 == null) goto L16;
            String r12 = b2.d0(this.a).getCheckSkuImageUrl();
            Long r17 = b2.d0(this.a).getCheckSkuPrice();
            Long r18 = b2.d0(this.a).getCheckSkuOriginPrice();
            Long r13 = b2.d0(this.a).getCheckSkuDiscountPrice();
            if (r13 == null) goto L10;
            long r14 = r13.longValue();
        L11:
            Long r20 = Long.valueOf(r14);
            String r15 = b2.d0(this.a).getCheckSkuDiscountPriceText();
            if (r15 != null) goto L14;
            String r22 = "";
        L15:
            Unit r16 = (Unit) r11.invoke(new SkuProductDetailInfo(r12, new ProductPriceInfo(r17, r18, new PromotionDiscountPrice(r20, null, r22, null, 10, null), null, null, 24, null), b2.d0(this.a).getSelectEPInfo(), this.a.i, false, (String[]) Arrays.copyOf(r27, r27.length), false, 64, null));
            goto L16
        L14:
            r22 = r15;
            goto L15
        L10:
            r14 = 0;
        L16:
            SkuViewModel r19 = b2.e0(this.a);
            Long r21 = (Long) b2.e0(this.a).m1028getCurrentPrice().a();
            if (r21 == null) goto L19;
            long r23 = r21.longValue();
        L20:
            int r24 = 0;
            if (r23 <= 0) goto L23;
            boolean r25 = true;
        L24:
            r19.setHasRefreshDetailInfo(r25);
            JSONArray r26 = new JSONArray();
            int r29 = r27.length;
        L25:
            if (r24 >= r29) goto L30;
            String r30 = r27[r24];
            if (r30 != null) goto L29;
            r30 = "";
        L29:
            r26.put(r30);
            r24 = r24 + 1;
            goto L25
        L30:
            JSONObject r31 = new JSONObject();
            r31.put("sku_session_id", b2.e0(this.a).getSkuParams().getSkuSessionId());
            r31.put("combo_num", b2.e0(this.a).m1027getCurrentCount().a());
            r31.put("select_spec_ids", r26);
            ECLiveHybridUtil.f("ecom.sku.spec.change", r31);
            SkuRestoreState r32 = b2.e0(this.a).getSkuPanelState();
            if (r32 == null) goto L37;
            r32.setSelectSkuKeys(r27);
            return;
        L37:
            return;
        L23:
            r25 = false;
            goto L24
        L19:
            r23 = 0;
            goto L20
        }
    }

    public final void i0() {
        SpecItemOptimizeGroupLayout r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L5:
        String r1 = r0.getCheckedId();
        SkuViewModel r10 = this.f;
        if (r10 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        SkuInfoVO r11 = (SkuInfoVO) r10.getSkuInfo().a();
        if (r11 == null) goto L17;
        Map<String, SkuItemInfoVO> r12 = r11.getSkuList();
        if (r12 == null) goto L17;
        SkuItemInfoVO r13 = r12.get(r1);
        if (r13 == null) goto L17;
        Map<String, String> r14 = r13.getShowEventTrack();
        if (r14 == null) goto L17;
    L20:
        Map<String, String> r15 = r14;
        SkuViewModel r16 = this.f;
        if (r16 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L23:
        SkuViewModel.doSkuEventAction$default(r16, "sku_panel_module_show", new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MODULE_NAME, "price")}, null, null, r15, 12, null);
        return;
    L17:
        if (r11 == null) goto L19;
        r14 = r11.getShowTrackParams();
        goto L20
    L19:
        r14 = null;
        goto L20
    }

    public final void k0() {
        SkuViewModel r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuRestoreState r10 = r0.getSkuPanelState();
        if (r10 == null) goto L46;
        SpecItemOptimizeGroupLayout r1 = this.h;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L10:
        String[] r11 = r1.getCheckedIdArray();
        SkuViewModel r12 = this.f;
        if (r12 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L13:
        Long r13 = Long.valueOf(r12.getCurrentCount());
        SkuViewModel r14 = this.f;
        if (r14 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L16:
        String r15 = r14.getSelectedSkuId();
        SkuViewModel r16 = this.f;
        if (r16 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L19:
        String r17 = (String) r16.getCheckedNames().a();
        SkuViewModel r18 = this.f;
        if (r18 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L22:
        String r19 = (String) r18.getCurrentAvatar().a();
        if (r19 == null) goto L28;
        String r20 = com.bytedance.android.ec.core.utils.a2.d(r19);
        if (r20 == null) goto L28;
    L27:
        String r21 = r20;
        SkuViewModel r22 = this.f;
        if (r22 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L38:
        Boolean r23 = r22.getCanAddCart();
        SkuViewModel r24 = this.f;
        if (r24 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L41:
        SkuLimit r25 = (SkuLimit) r24.m1029getLowerLimit().a();
        if (r25 == null) goto L44;
        int r26 = (int) r25.getCount();
    L45:
        r10.saveSelectedSpec(r11, r13, r15, r17, r21, r23, r26);
        goto L46
    L44:
        r26 = 1;
    L28:
        SkuViewModel r27 = this.f;
        if (r27 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L31:
        SkuInfoVO r28 = (SkuInfoVO) r27.getSkuInfo().a();
        if (r28 == null) goto L34;
        r20 = r28.getCover();
        goto L27
    L34:
        r20 = null;
    L46:
        SkuViewModel r29 = this.f;
        if (r29 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L49:
        r29.saveAddCartGuideInfo();
    }

    public final void l0() {
        SkuViewModel r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        CharSequence r1 = (CharSequence) r0.getUnCheckedName().a();
        boolean r10 = false;
        if (r1 != null) goto L8;
    L11:
        boolean r11 = true;
    L13:
        if (r11 == false) goto L21;
        SkuViewModel r12 = this.f;
        if (r12 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        QLiveData<String> r13 = r12.getLimitText();
        SpecItemOptimizeGroupLayout r14 = this.h;
        if (r14 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L20:
        r13.g(r14.getLimitText());
        return;
    L21:
        SpecItemOptimizeGroupLayout r15 = this.h;
        if (r15 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L25:
        if (r15.getLimitText().length() != 0) goto L27;
        r10 = true;
    L27:
        if (r10 == false) goto L36;
        SkuViewModel r16 = this.f;
        if (r16 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L31:
        SkuInfoVO r17 = (SkuInfoVO) r16.getSkuInfo().a();
        if (r17 == null) goto L35;
        String r18 = r17.getLimitText();
        if (r18 == null) goto L35;
    L40:
        SkuViewModel r19 = this.f;
        if (r19 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L43:
        r19.getLimitText().g(r18);
        return;
    L35:
        r18 = "";
        goto L40
    L36:
        SpecItemOptimizeGroupLayout r20 = this.h;
        if (r20 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L39:
        r18 = r20.getLimitText();
        goto L40
    L8:
        if (r1.length() == 0) goto L11;
        r11 = false;
        goto L13
    }

    public final void j0() {
        this.g = (LinearLayout) Z().b(2131378865).f();
        Context r1 = Y().c();
        SkuViewModel r10 = this.f;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SpecItemOptimizeGroupLayout r0 = new SpecItemOptimizeGroupLayout(r1, r10.getSkuStockDataOptimize());
        this.h = r0;
        r0.setSpecGroupLogEventLogger(new a(this));
        SpecItemOptimizeGroupLayout r11 = this.h;
        if (r11 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L8:
        r11.setCheckedChangeListener(new b(this));
        LinearLayout r12 = this.g;
        if (r12 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("skuBox");
    L11:
        r12.removeAllViews();
        LinearLayout r13 = this.g;
        if (r13 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("skuBox");
    L14:
        LinearLayoutCompat r14 = this.h;
        if (r14 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L17:
        r13.addView(r14);
    }

    public final void m0() {
        if (com.bytedance.android.ec.core.abtest.d.E() == false) goto L47;
        boolean r10 = true;
        SkuLimit r0 = new SkuLimit(Long.MAX_VALUE, th.a.h(Y().c(), 2131914000, new Object[]{Long.MAX_VALUE}));
        SkuViewModel r11 = this.f;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L7:
        CharSequence r12 = (CharSequence) r11.getUnCheckedName().a();
        if (r12 != null) goto L10;
    L13:
        if (r10 == false) goto L25;
        SkuViewModel r13 = this.f;
        if (r13 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        QLiveData<SkuLimit> r14 = r13.m1031getUpperLimit();
        SpecItemOptimizeGroupLayout r15 = this.h;
        if (r15 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L20:
        SkuLimit r1 = r15.getCheckSkuMaxPurchaseCount();
        if (r1 == null) goto L24;
        r0 = r1;
    L24:
        r14.g(r0);
        return;
    L25:
        SpecItemOptimizeGroupLayout r16 = this.h;
        if (r16 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L29:
        if (r16.getCheckSkuMaxPurchaseCount() != null) goto L39;
        SkuViewModel r17 = this.f;
        if (r17 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L33:
        SkuInfoVO r18 = (SkuInfoVO) r17.getSkuInfo().a();
        if (r18 == null) goto L43;
        SkuLimit r19 = r18.getUpperLimit();
        if (r19 == null) goto L43;
        r0 = r19;
    L43:
        SkuViewModel r20 = this.f;
        if (r20 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L46:
        r20.m1031getUpperLimit().g(r0);
        return;
    L39:
        SpecItemOptimizeGroupLayout r21 = this.h;
        if (r21 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L42:
        r0 = r21.getCheckSkuMaxPurchaseCount();
        goto L43
    L10:
        if (r12.length() == 0) goto L13;
        r10 = false;
        goto L13
    L47:
        SkuViewModel r22 = this.f;
        if (r22 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L50:
        QLiveData<SkuLimit> r23 = r22.m1031getUpperLimit();
        SpecItemOptimizeGroupLayout r24 = this.h;
        if (r24 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L53:
        r23.g(r24.getCheckSkuMaxPurchaseCount());
    }

    public final void n0() {
        if (com.bytedance.android.ec.core.abtest.d.E() == false) goto L44;
        SkuLimit r0 = new SkuLimit(0, Y().c().getString(2131914013));
        SkuViewModel r10 = this.f;
        if (r10 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L7:
        CharSequence r11 = (CharSequence) r10.getUnCheckedName().a();
        if (r11 != null) goto L10;
    L13:
        boolean r12 = true;
    L14:
        if (r12 == false) goto L22;
        SkuViewModel r1 = this.f;
        if (r1 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L18:
        QLiveData<SkuLimit> r13 = r1.m1029getLowerLimit();
        SpecItemOptimizeGroupLayout r14 = this.h;
        if (r14 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L21:
        r13.g(r14.getCheckSkuLeastPurchaseCount());
        return;
    L22:
        SpecItemOptimizeGroupLayout r15 = this.h;
        if (r15 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L26:
        if (r15.getCheckSkuLeastPurchaseCount() != null) goto L36;
        SkuViewModel r16 = this.f;
        if (r16 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L30:
        SkuInfoVO r17 = (SkuInfoVO) r16.getSkuInfo().a();
        if (r17 == null) goto L40;
        SkuLimit r18 = r17.getLowerLimit();
        if (r18 == null) goto L40;
        r0 = r18;
    L40:
        SkuViewModel r19 = this.f;
        if (r19 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L43:
        r19.m1029getLowerLimit().g(r0);
        return;
    L36:
        SpecItemOptimizeGroupLayout r20 = this.h;
        if (r20 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L39:
        r0 = r20.getCheckSkuLeastPurchaseCount();
        goto L40
    L10:
        if (r11.length() == 0) goto L13;
        r12 = false;
        goto L14
    L44:
        SkuViewModel r21 = this.f;
        if (r21 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L47:
        QLiveData<SkuLimit> r22 = r21.m1029getLowerLimit();
        SpecItemOptimizeGroupLayout r23 = this.h;
        if (r23 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L50:
        r22.g(r23.getCheckSkuLeastPurchaseCount());
    }

    public b2(Fragment r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        super(r10);
    }

    public static final /* synthetic */ SpecItemOptimizeGroupLayout d0(b2 r1) {
        SpecItemOptimizeGroupLayout r10 = r1.h;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L5:
        return r10;
    }

    public static final /* synthetic */ SkuViewModel e0(b2 r1) {
        SkuViewModel r10 = r1.f;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        return r10;
    }

    public final void b0(QModel r10) {
        this.f = (SkuViewModel) Y().g(SkuViewModel.class);
        j0();
        SkuViewModel r11 = this.f;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r11.getSkuInfo().b(ECQuickUtilKt.a(Y()), new u1(this));
        SkuViewModel r12 = this.f;
        if (r12 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        r12.m1027getCurrentCount().b(ECQuickUtilKt.a(Y()), new v1(this));
        SkuViewModel r13 = this.f;
        if (r13 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L11:
        r13.getSaveState().b(ECQuickUtilKt.a(Y()), new w1(this));
        SkuViewModel r14 = this.f;
        if (r14 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L14:
        r14.getCurrentAtmosphereStyle().b(ECQuickUtilKt.a(Y()), new x1(this));
        SkuViewModel r15 = this.f;
        if (r15 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        r15.getUnCheckedName().b(ECQuickUtilKt.a(Y()), new y1(this));
        SkuViewModel r16 = this.f;
        if (r16 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L20:
        r16.getHighLightUncheckSpec().b(ECQuickUtilKt.a(Y()), new z1(this));
        SkuViewModel r17 = this.f;
        if (r17 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L23:
        r17.getImageSpecSelectIndex().b(ECQuickUtilKt.a(Y()), new a2(this));
    }

    public final void o0(boolean r14) {
        SpecItemOptimizeGroupLayout r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L5:
        Long r1 = r0.getCheckSkuPrice();
        if (r1 == null) goto L8;
        long r10 = r1.longValue();
    L9:
        String r11 = "";
        if (r10 != (-1)) goto L301;
        SkuViewModel r12 = this.f;
        if (r12 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L14:
        long r13 = r12.getCurrentPriceWithDefault();
        SkuViewModel r15 = this.f;
        if (r15 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        SkuInfoVO r16 = (SkuInfoVO) r15.getSkuInfo().a();
        Integer r17 = null;
        if (r16 == null) goto L20;
        Long r18 = Long.valueOf(r16.getMinPrice());
    L22:
        if (r13 != jg.g.b(r18, 0)) goto L47;
        SkuViewModel r19 = this.f;
        if (r19 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L26:
        long r20 = r19.getCurrentOriginPrice();
        SkuViewModel r21 = this.f;
        if (r21 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L29:
        SkuInfoVO r22 = (SkuInfoVO) r21.getSkuInfo().a();
        if (r22 == null) goto L32;
        Long r23 = Long.valueOf(r22.getMarketPrice());
    L34:
        if (r20 != jg.g.b(r23, 0)) goto L47;
        SkuViewModel r24 = this.f;
        if (r24 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L38:
        long r25 = r24.getCurrentDiscountPrice();
        SkuViewModel r26 = this.f;
        if (r26 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L41:
        SkuInfoVO r27 = (SkuInfoVO) r26.getSkuInfo().a();
        if (r27 == null) goto L44;
        Long r28 = r27.getDiscountPrice();
    L46:
        if (r25 != jg.g.b(r28, 0)) goto L47;
    L494:
        if (r14 == true) goto L497;
        i0();
        return;
    L497:
        return;
    L44:
        r28 = null;
        goto L46
    L32:
        r23 = null;
    L47:
        SkuViewModel r29 = this.f;
        if (r29 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L50:
        SkuViewModel r30 = this.f;
        if (r30 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L53:
        SkuInfoVO r31 = (SkuInfoVO) r30.getSkuInfo().a();
        if (r31 == null) goto L56;
        Long r32 = Long.valueOf(r31.getMinPrice());
    L57:
        r29.setCurrentPriceWithDefault(jg.g.b(r32, 0));
        SkuViewModel r33 = this.f;
        if (r33 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L60:
        SkuViewModel r34 = this.f;
        if (r34 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L63:
        SkuInfoVO r35 = (SkuInfoVO) r34.getSkuInfo().a();
        if (r35 == null) goto L66;
        Long r36 = Long.valueOf(r35.getMarketPrice());
    L67:
        r33.setCurrentOriginPrice(jg.g.b(r36, 0));
        SkuViewModel r37 = this.f;
        if (r37 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L70:
        SkuViewModel r38 = this.f;
        if (r38 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L73:
        SkuInfoVO r39 = (SkuInfoVO) r38.getSkuInfo().a();
        if (r39 == null) goto L76;
        Long r40 = r39.getDiscountPrice();
    L77:
        r37.setCurrentDiscountPrice(jg.g.b(r40, 0));
        SkuViewModel r41 = this.f;
        if (r41 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L80:
        SpecItemOptimizeGroupLayout r42 = this.h;
        if (r42 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L83:
        String r43 = r42.getCheckSkuDiscountPriceText();
        if (r43 != null) goto L86;
        r43 = "";
    L86:
        r41.setCurrentDiscountPriceText(r43);
        SkuViewModel r44 = this.f;
        if (r44 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L89:
        SpecItemOptimizeGroupLayout r45 = this.h;
        if (r45 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L92:
        String r46 = r45.getCheckSkuCampaignPriceHeader();
        if (r46 == null) goto L96;
        r11 = r46;
    L96:
        r44.setCurrentCampainPriceHeader(r11);
        SkuViewModel r47 = this.f;
        if (r47 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L99:
        SpecItemOptimizeGroupLayout r48 = this.h;
        if (r48 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L102:
        r47.setCurrentCampainPriceHeaderStyle(r48.getCheckSkuPriceHedaerStyle());
        SkuViewModel r49 = this.f;
        if (r49 != null) goto L105;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L105:
        SpecItemOptimizeGroupLayout r50 = this.h;
        if (r50 != null) goto L108;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L108:
        r49.setCurrentNewBonusText(r50.getNewBonusText());
        SkuViewModel r51 = this.f;
        if (r51 != null) goto L111;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L111:
        SkuViewModel r52 = this.f;
        if (r52 != null) goto L114;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L114:
        SkuInfoVO r53 = (SkuInfoVO) r52.getSkuInfo().a();
        if (r53 == null) goto L117;
        Long r54 = r53.getFirstPrice();
    L118:
        r51.setCurrentFirstPrice(r54);
        SkuViewModel r55 = this.f;
        if (r55 != null) goto L121;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L121:
        SkuViewModel r56 = this.f;
        if (r56 != null) goto L124;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L124:
        SkuInfoVO r57 = (SkuInfoVO) r56.getSkuInfo().a();
        if (r57 == null) goto L127;
        String r58 = r57.getFirstPricePrefix();
    L128:
        r55.setCurrentFirstPricePrefix(r58);
        SkuViewModel r59 = this.f;
        if (r59 != null) goto L131;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L131:
        SkuViewModel r60 = this.f;
        if (r60 != null) goto L134;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L134:
        SkuInfoVO r61 = (SkuInfoVO) r60.getSkuInfo().a();
        if (r61 == null) goto L137;
        String r62 = r61.getFirstPriceSuffix();
    L138:
        r59.setCurrentFirstPriceSuffix(r62);
        SkuViewModel r63 = this.f;
        if (r63 != null) goto L141;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L141:
        SkuViewModel r64 = this.f;
        if (r64 != null) goto L144;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L144:
        SkuInfoVO r65 = (SkuInfoVO) r64.getSkuInfo().a();
        if (r65 == null) goto L147;
        Boolean r66 = r65.getFirstPriceIsUnderline();
    L148:
        r63.setCurrentFirstPriceIsUnderline(r66);
        SkuViewModel r67 = this.f;
        if (r67 != null) goto L151;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L151:
        SkuViewModel r68 = this.f;
        if (r68 != null) goto L154;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L154:
        SkuInfoVO r69 = (SkuInfoVO) r68.getSkuInfo().a();
        if (r69 == null) goto L157;
        String r70 = r69.getFirstPriceSupplement();
    L158:
        r67.setCurrentFirstPriceSupplement(r70);
        SkuViewModel r71 = this.f;
        if (r71 != null) goto L161;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L161:
        SkuViewModel r72 = this.f;
        if (r72 != null) goto L164;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L164:
        SkuInfoVO r73 = (SkuInfoVO) r72.getSkuInfo().a();
        if (r73 == null) goto L167;
        Long r74 = r73.getSecondPrice();
    L168:
        r71.setCurrentSecondPrice(r74);
        SkuViewModel r75 = this.f;
        if (r75 != null) goto L171;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L171:
        SkuViewModel r76 = this.f;
        if (r76 != null) goto L174;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L174:
        SkuInfoVO r77 = (SkuInfoVO) r76.getSkuInfo().a();
        if (r77 == null) goto L177;
        String r78 = r77.getSecondPricePrefix();
    L178:
        r75.setCurrentSecondPricePrefix(r78);
        SkuViewModel r79 = this.f;
        if (r79 != null) goto L181;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L181:
        SkuViewModel r80 = this.f;
        if (r80 != null) goto L184;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L184:
        SkuInfoVO r81 = (SkuInfoVO) r80.getSkuInfo().a();
        if (r81 == null) goto L187;
        String r82 = r81.getSecondPriceSupplement();
    L188:
        r79.setCurrentSecondPriceSupplement(r82);
        SkuViewModel r83 = this.f;
        if (r83 != null) goto L191;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L191:
        SkuViewModel r84 = this.f;
        if (r84 != null) goto L194;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L194:
        SkuInfoVO r85 = (SkuInfoVO) r84.getSkuInfo().a();
        if (r85 == null) goto L197;
        String r86 = r85.getSecondPriceSuffix();
    L198:
        r83.setCurrentSecondPriceSuffix(r86);
        SkuViewModel r87 = this.f;
        if (r87 != null) goto L201;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L201:
        SkuViewModel r88 = this.f;
        if (r88 != null) goto L204;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L204:
        SkuInfoVO r89 = (SkuInfoVO) r88.getSkuInfo().a();
        if (r89 == null) goto L207;
        Boolean r90 = r89.getSecondPriceIsUnderline();
    L208:
        r87.setCurrentSecondPriceIsUnderline(r90);
        SkuViewModel r91 = this.f;
        if (r91 != null) goto L211;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L211:
        SkuViewModel r92 = this.f;
        if (r92 != null) goto L214;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L214:
        SkuInfoVO r93 = (SkuInfoVO) r92.getSkuInfo().a();
        if (r93 == null) goto L217;
        String r94 = r93.getRegularPriceSupplement();
    L218:
        r91.setCurrentRegularPriceSupplement(r94);
        SkuViewModel r95 = this.f;
        if (r95 != null) goto L221;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L221:
        SkuViewModel r96 = this.f;
        if (r96 != null) goto L224;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L224:
        SkuInfoVO r97 = (SkuInfoVO) r96.getSkuInfo().a();
        if (r97 == null) goto L227;
        Boolean r98 = r97.getSecondPriceIsReducePrice();
    L228:
        r95.setCurrentSecondPriceIsReducePrice(r98);
        SkuViewModel r99 = this.f;
        if (r99 != null) goto L231;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L231:
        SkuViewModel r100 = this.f;
        if (r100 != null) goto L234;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L234:
        SkuInfoVO r101 = (SkuInfoVO) r100.getSkuInfo().a();
        if (r101 == null) goto L237;
        Long r102 = r101.getRegularPrice();
    L238:
        r99.setCurrentRegularPrice(r102);
        SkuViewModel r103 = this.f;
        if (r103 != null) goto L241;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L241:
        SkuViewModel r104 = this.f;
        if (r104 != null) goto L244;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L244:
        SkuInfoVO r105 = (SkuInfoVO) r104.getSkuInfo().a();
        if (r105 == null) goto L247;
        String r106 = r105.getRegularPricePrefix();
    L248:
        r103.setCurrentRegularPricePrefix(r106);
        SkuViewModel r107 = this.f;
        if (r107 != null) goto L251;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L251:
        SkuViewModel r108 = this.f;
        if (r108 != null) goto L254;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L254:
        SkuInfoVO r109 = (SkuInfoVO) r108.getSkuInfo().a();
        if (r109 == null) goto L257;
        String r110 = r109.getRegularPriceSuffix();
    L258:
        r107.setCurrentRegularPriceSuffix(r110);
        SkuViewModel r111 = this.f;
        if (r111 != null) goto L261;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L261:
        SkuViewModel r112 = this.f;
        if (r112 != null) goto L264;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L264:
        SkuInfoVO r113 = (SkuInfoVO) r112.getSkuInfo().a();
        if (r113 == null) goto L267;
        Boolean r114 = r113.getRegularPriceIsUnderline();
    L268:
        r111.setCurrentRegularPriceIsUnderline(r114);
        SkuViewModel r115 = this.f;
        if (r115 != null) goto L271;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L271:
        SkuViewModel r116 = this.f;
        if (r116 != null) goto L274;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L274:
        SkuInfoVO r117 = (SkuInfoVO) r116.getSkuInfo().a();
        if (r117 == null) goto L277;
        Long r118 = r117.getHotMinPrice();
    L278:
        r115.setCurrentHotMinPrice(r118);
        SkuViewModel r119 = this.f;
        if (r119 != null) goto L281;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L281:
        SkuViewModel r120 = this.f;
        if (r120 != null) goto L284;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L284:
        SkuInfoVO r121 = (SkuInfoVO) r120.getSkuInfo().a();
        if (r121 == null) goto L287;
        Long r122 = r121.getHotMaxPrice();
    L288:
        r119.setCurrentHotMaxPrice(r122);
        SkuViewModel r123 = this.f;
        if (r123 != null) goto L291;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L291:
        r123.m1028getCurrentPrice().g(Long.valueOf(r10));
        SkuViewModel r124 = this.f;
        if (r124 != null) goto L294;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L294:
        QLiveData<Integer> r125 = r124.getCurrentAtmosphereStyle();
        SkuViewModel r126 = this.f;
        if (r126 != null) goto L297;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L297:
        SkuInfoVO r127 = (SkuInfoVO) r126.getSkuInfo().a();
        if (r127 == null) goto L300;
        r17 = r127.getAtmosphereStyle();
    L300:
        r125.g(r17);
        goto L494
    L287:
        r122 = null;
        goto L288
    L277:
        r118 = null;
        goto L278
    L267:
        r114 = null;
        goto L268
    L257:
        r110 = null;
        goto L258
    L247:
        r106 = null;
        goto L248
    L237:
        r102 = null;
        goto L238
    L227:
        r98 = null;
        goto L228
    L217:
        r94 = null;
        goto L218
    L207:
        r90 = null;
        goto L208
    L197:
        r86 = null;
        goto L198
    L187:
        r82 = null;
        goto L188
    L177:
        r78 = null;
        goto L178
    L167:
        r74 = null;
        goto L168
    L157:
        r70 = null;
        goto L158
    L147:
        r66 = null;
        goto L148
    L137:
        r62 = null;
        goto L138
    L127:
        r58 = null;
        goto L128
    L117:
        r54 = null;
        goto L118
    L76:
        r40 = null;
        goto L77
    L66:
        r36 = null;
        goto L67
    L56:
        r32 = null;
        goto L57
    L20:
        r18 = null;
        goto L22
    L301:
        SkuViewModel r128 = this.f;
        if (r128 != null) goto L304;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L304:
        Long r129 = (Long) r128.m1028getCurrentPrice().a();
        if (r129 != null) goto L308;
    L330:
        SkuViewModel r130 = this.f;
        if (r130 != null) goto L333;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L333:
        r130.setCurrentPriceWithDefault(r10);
        SkuViewModel r131 = this.f;
        if (r131 != null) goto L336;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L336:
        SpecItemOptimizeGroupLayout r132 = this.h;
        if (r132 != null) goto L339;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L339:
        r131.setCurrentOriginPrice(jg.g.b(r132.getCheckSkuOriginPrice(), 0));
        SkuViewModel r133 = this.f;
        if (r133 != null) goto L342;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L342:
        SpecItemOptimizeGroupLayout r134 = this.h;
        if (r134 != null) goto L345;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L345:
        r133.setCurrentDiscountPrice(jg.g.b(r134.getCheckSkuDiscountPrice(), 0));
        SkuViewModel r135 = this.f;
        if (r135 != null) goto L348;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L348:
        SpecItemOptimizeGroupLayout r136 = this.h;
        if (r136 != null) goto L351;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L351:
        String r137 = r136.getCheckSkuDiscountPriceText();
        if (r137 != null) goto L354;
        r137 = "";
    L354:
        r135.setCurrentDiscountPriceText(r137);
        SkuViewModel r138 = this.f;
        if (r138 != null) goto L357;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L357:
        SpecItemOptimizeGroupLayout r139 = this.h;
        if (r139 != null) goto L360;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L360:
        String r140 = r139.getCheckSkuCampaignPriceHeader();
        if (r140 == null) goto L364;
        r11 = r140;
    L364:
        r138.setCurrentCampainPriceHeader(r11);
        SkuViewModel r141 = this.f;
        if (r141 != null) goto L367;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L367:
        SpecItemOptimizeGroupLayout r142 = this.h;
        if (r142 != null) goto L370;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L370:
        r141.setCurrentCampainPriceHeaderStyle(r142.getCheckSkuPriceHedaerStyle());
        SkuViewModel r143 = this.f;
        if (r143 != null) goto L373;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L373:
        SpecItemOptimizeGroupLayout r144 = this.h;
        if (r144 != null) goto L376;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L376:
        r143.setCurrentNewBonusText(r144.getNewBonusText());
        SkuViewModel r145 = this.f;
        if (r145 != null) goto L379;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L379:
        SpecItemOptimizeGroupLayout r146 = this.h;
        if (r146 != null) goto L382;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L382:
        r145.setCurrentFirstPrice(r146.getCheckSkuFirstPrice());
        SkuViewModel r147 = this.f;
        if (r147 != null) goto L385;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L385:
        SpecItemOptimizeGroupLayout r148 = this.h;
        if (r148 != null) goto L388;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L388:
        r147.setCurrentFirstPricePrefix(r148.getCheckSkuFirstPricePrefix());
        SkuViewModel r149 = this.f;
        if (r149 != null) goto L391;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L391:
        SpecItemOptimizeGroupLayout r150 = this.h;
        if (r150 != null) goto L394;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L394:
        r149.setCurrentFirstPriceSupplement(r150.getCheckSkuFirstPriceSpecDesc());
        SkuViewModel r151 = this.f;
        if (r151 != null) goto L397;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L397:
        SpecItemOptimizeGroupLayout r152 = this.h;
        if (r152 != null) goto L400;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L400:
        r151.setCurrentFirstPriceSuffix(r152.getCheckSkuFirstPriceSuffix());
        SkuViewModel r153 = this.f;
        if (r153 != null) goto L403;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L403:
        SpecItemOptimizeGroupLayout r154 = this.h;
        if (r154 != null) goto L406;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L406:
        r153.setCurrentFirstPriceIsUnderline(r154.getCheckSkuFirstPriceIsUnderline());
        SkuViewModel r155 = this.f;
        if (r155 != null) goto L409;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L409:
        SpecItemOptimizeGroupLayout r156 = this.h;
        if (r156 != null) goto L412;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L412:
        r155.setCurrentSecondPrice(r156.getCheckSkuSecondPrice());
        SkuViewModel r157 = this.f;
        if (r157 != null) goto L415;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L415:
        SpecItemOptimizeGroupLayout r158 = this.h;
        if (r158 != null) goto L418;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L418:
        r157.setCurrentSecondPricePrefix(r158.getCheckSkuSecondPricePrefix());
        SkuViewModel r159 = this.f;
        if (r159 != null) goto L421;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L421:
        SpecItemOptimizeGroupLayout r160 = this.h;
        if (r160 != null) goto L424;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L424:
        r159.setCurrentSecondPriceSuffix(r160.getCheckSkuSecondPriceSuffix());
        SkuViewModel r161 = this.f;
        if (r161 != null) goto L427;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L427:
        SpecItemOptimizeGroupLayout r162 = this.h;
        if (r162 != null) goto L430;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L430:
        r161.setCurrentSecondPriceSupplement(r162.getCheckSkuSecondPriceSpecDesc());
        SkuViewModel r163 = this.f;
        if (r163 != null) goto L433;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L433:
        SpecItemOptimizeGroupLayout r164 = this.h;
        if (r164 != null) goto L436;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L436:
        r163.setCurrentSecondPriceIsUnderline(r164.getCheckSkuSecondPriceIsUnderline());
        SkuViewModel r165 = this.f;
        if (r165 != null) goto L439;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L439:
        SpecItemOptimizeGroupLayout r166 = this.h;
        if (r166 != null) goto L442;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L442:
        r165.setCurrentSecondPriceIsReducePrice(r166.getCheckSkuSecondPriceIsReducePrice());
        SkuViewModel r167 = this.f;
        if (r167 != null) goto L445;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L445:
        SpecItemOptimizeGroupLayout r168 = this.h;
        if (r168 != null) goto L448;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L448:
        r167.setCurrentRegularPrice(r168.getCheckSkuRegularPrice());
        SkuViewModel r169 = this.f;
        if (r169 != null) goto L451;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L451:
        SpecItemOptimizeGroupLayout r170 = this.h;
        if (r170 != null) goto L454;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L454:
        r169.setCurrentRegularPriceSupplement(r170.getCheckSkuRegularPriceSpecDesc());
        SkuViewModel r171 = this.f;
        if (r171 != null) goto L457;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L457:
        SpecItemOptimizeGroupLayout r172 = this.h;
        if (r172 != null) goto L460;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L460:
        r171.setCurrentRegularPricePrefix(r172.getCheckSkuRegularPricePrefix());
        SkuViewModel r173 = this.f;
        if (r173 != null) goto L463;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L463:
        SpecItemOptimizeGroupLayout r174 = this.h;
        if (r174 != null) goto L466;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L466:
        r173.setCurrentRegularPriceSuffix(r174.getCheckSkuRegularPriceSuffix());
        SkuViewModel r175 = this.f;
        if (r175 != null) goto L469;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L469:
        SpecItemOptimizeGroupLayout r176 = this.h;
        if (r176 != null) goto L472;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L472:
        r175.setCurrentRegularPriceIsUnderline(r176.getCheckSkuRegularPriceIsUnderline());
        SkuViewModel r177 = this.f;
        if (r177 != null) goto L475;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L475:
        SpecItemOptimizeGroupLayout r178 = this.h;
        if (r178 != null) goto L478;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L478:
        r177.setCurrentHotMinPrice(r178.getCheckSkuHotMinPrice());
        SkuViewModel r179 = this.f;
        if (r179 != null) goto L481;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L481:
        SpecItemOptimizeGroupLayout r180 = this.h;
        if (r180 != null) goto L484;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L484:
        r179.setCurrentHotMaxPrice(r180.getCheckSkuHotMaxPrice());
        SkuViewModel r181 = this.f;
        if (r181 != null) goto L487;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L487:
        r181.m1028getCurrentPrice().g(Long.valueOf(r10));
        SkuViewModel r182 = this.f;
        if (r182 != null) goto L490;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L490:
        QLiveData<Integer> r183 = r182.getCurrentAtmosphereStyle();
        SpecItemOptimizeGroupLayout r184 = this.h;
        if (r184 != null) goto L493;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L493:
        r183.g(r184.getCheckSkuAtmosphereStyle());
        goto L494
    L308:
        if (r10 != r129.longValue()) goto L330;
        SkuViewModel r185 = this.f;
        if (r185 != null) goto L313;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L313:
        if (r185.getCurrentPriceWithDefault() != r10) goto L330;
        SkuViewModel r186 = this.f;
        if (r186 != null) goto L317;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L317:
        long r187 = r186.getCurrentOriginPrice();
        SpecItemOptimizeGroupLayout r188 = this.h;
        if (r188 != null) goto L321;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L321:
        if (r187 != jg.g.b(r188.getCheckSkuOriginPrice(), 0)) goto L330;
        SkuViewModel r189 = this.f;
        if (r189 != null) goto L325;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L325:
        long r190 = r189.getCurrentDiscountPrice();
        SpecItemOptimizeGroupLayout r191 = this.h;
        if (r191 != null) goto L329;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L329:
        if (r190 == jg.g.b(r191.getCheckSkuDiscountPrice(), 0)) goto L494;
    L8:
        r10 = 0;
        goto L9
    }

    public static final void h0(b2 r26, boolean r27) {
        SkuViewModel r1 = r26.f;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SpecItemOptimizeGroupLayout r10 = r26.h;
        if (r10 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L8:
        r1.setSelectedSkuId(r10.getCheckedSkuId());
        SkuViewModel r11 = r26.f;
        if (r11 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L11:
        SkuViewModel r12 = r26.f;
        if (r12 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L14:
        SkuInfoVO r13 = (SkuInfoVO) r12.getSkuInfo().a();
        List<SpecInfo> r14 = null;
        if (r13 == null) goto L24;
        Map<String, SkuItemInfoVO> r15 = r13.getSkuList();
        if (r15 == null) goto L24;
        SpecItemOptimizeGroupLayout r16 = r26.h;
        if (r16 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L21:
        SkuItemInfoVO r17 = r15.get(r16.getCheckedId());
        if (r17 == null) goto L24;
        String r18 = r17.getId();
    L25:
        String r19 = "";
        if (r18 != null) goto L28;
        r18 = "";
    L28:
        r11.setComboId(r18);
        SkuViewModel r20 = r26.f;
        if (r20 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L31:
        SpecItemOptimizeGroupLayout r21 = r26.h;
        if (r21 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L34:
        String[] r22 = r21.getCheckedIdArray();
        if (r22 == null) goto L38;
        List<String> r23 = ArraysKt.toMutableList(r22);
        if (r23 == null) goto L38;
    L39:
        r20.setCheckedIdArray(r23);
        SkuViewModel r24 = r26.f;
        if (r24 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L42:
        SpecItemOptimizeGroupLayout r25 = r26.h;
        if (r25 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L45:
        r24.setCurrentPos(r25.getCurrentPosition());
        int r28 = qf.a.a;
        SkuViewModel r29 = r26.f;
        if (r29 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L48:
        long r30 = 0;
        if (qf.a.e.a(r29.getSkuParams()) == false) goto L73;
        SpecItemOptimizeGroupLayout r31 = r26.h;
        if (r31 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L53:
        String r32 = r31.getCheckSkuImageUrl();
        if (r32 == null) goto L58;
        r19 = r32;
    L58:
        if (r19.length() <= 0) goto L60;
        boolean r33 = true;
    L61:
        if (r33 == false) goto L68;
        SkuViewModel r34 = r26.f;
        if (r34 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L66:
        if (Intrinsics.areEqual(r19, (String) r34.getCurrentAvatar().a()) == false) goto L68;
    L72:
        r26.o0(r27);
    L506:
        SkuViewModel r35 = r26.f;
        if (r35 != null) goto L509;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L509:
        QLiveData<Long> r36 = r35.getCurrentStock();
        SpecItemOptimizeGroupLayout r37 = r26.h;
        if (r37 != null) goto L512;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L512:
        Long r38 = r37.getRealStock();
        if (r38 == null) goto L515;
        r30 = r38.longValue();
    L515:
        r36.g(Long.valueOf(r30));
        r26.m0();
        r26.n0();
        r26.l0();
        SkuViewModel r39 = r26.f;
        if (r39 != null) goto L518;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L518:
        QLiveData<List<PromotionBenefitLabel>> r40 = r39.getCurrentBenefitLabel();
        SpecItemOptimizeGroupLayout r41 = r26.h;
        if (r41 != null) goto L521;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L521:
        r40.g(r41.getSkuBenefitLabel());
        SpecItemOptimizeGroupLayout r42 = r26.h;
        if (r42 != null) goto L524;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L524:
        String[] r43 = r42.getCheckedIdArray();
        if (r43 == null) goto L549;
        Integer r44 = Integer.valueOf(ArraysKt.indexOf(r43, null));
        if (r44.intValue() < 0) goto L529;
        boolean r45 = true;
    L530:
        if (r45 == true) goto L533;
        r44 = null;
    L533:
        if (r44 == null) goto L549;
        int r46 = r44.intValue();
        SkuViewModel r47 = r26.f;
        if (r47 != null) goto L537;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L537:
        QLiveData<String> r48 = r47.getUnCheckedName();
        SkuViewModel r49 = r26.f;
        if (r49 != null) goto L540;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L540:
        SkuInfoVO r50 = (SkuInfoVO) r49.getSkuInfo().a();
        if (r50 == null) goto L547;
        List<SpecInfo> r51 = r50.getSpecInfoList();
        if (r51 == null) goto L547;
        SpecInfo r52 = (SpecInfo) ListProtector.get(r51, r46);
        if (r52 == null) goto L547;
        String r53 = r52.getName();
    L548:
        r48.g(r53);
    L553:
        SkuViewModel r54 = r26.f;
        if (r54 != null) goto L556;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L556:
        QLiveData<String> r55 = r54.getCheckedNames();
        StringBuilder r56 = new StringBuilder();
        SpecItemOptimizeGroupLayout r57 = r26.h;
        if (r57 != null) goto L559;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L559:
        String[] r58 = r57.getCheckedIdArray();
        if (r58 == null) goto L570;
        int r59 = r58.length;
        int r110 = 0;
    L562:
        if (r110 >= r59) goto L570;
        String r111 = r58[r110];
        if (r111 == null) goto L566;
        boolean r112 = true;
    L567:
        if (r112 == true) goto L571;
        r110 = r110 + 1;
    L571:
        if (r111 == null) goto L616;
        int r60 = r58.length;
        int r113 = 0;
        int r114 = 0;
    L573:
        if (r113 >= r60) goto L615;
        String r115 = r58[r113];
        int r116 = r114 + 1;
        SkuViewModel r117 = r26.f;
        if (r117 != null) goto L577;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L577:
        SkuInfoVO r118 = (SkuInfoVO) r117.getSkuInfo().a();
        if (r118 == null) goto L604;
        List<SpecInfo> r119 = r118.getSpecInfoList();
        if (r119 == null) goto L604;
        if (r119.size() <= r114) goto L584;
        boolean r120 = true;
    L585:
        if (r120 == true) goto L588;
        r119 = r14;
    L588:
        if (r119 == null) goto L604;
        SpecInfo r121 = (SpecInfo) ListProtector.get(r119, r114);
        if (r121 == null) goto L604;
        List<SpecInfoItem> r122 = r121.getSpecItems();
        if (r122 == null) goto L604;
        Iterator<T> r123 = r122.iterator();
    L595:
        if (r123.hasNext() == false) goto L600;
        Object r124 = r123.next();
        if (Intrinsics.areEqual(((SpecInfoItem) r124).getId(), r115) == false) goto L595;
    L601:
        SpecInfoItem r125 = (SpecInfoItem) r124;
        if (r125 == null) goto L604;
        r56.append(" " + r125.getName());
        r26.i = r125.getName();
    L614:
        r113 = r113 + 1;
        r114 = r116;
        r14 = null;
        goto L573
    L600:
        r124 = null;
        goto L601
    L584:
        r120 = false;
    L604:
        SkuViewModel r61 = r26.f;
        if (r61 != null) goto L607;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L607:
        SkuInfoVO r62 = (SkuInfoVO) r61.getSkuInfo().a();
        if (r62 == null) goto L614;
        List<SpecInfo> r63 = r62.getSpecInfoList();
        if (r63 == null) goto L614;
        SpecInfo r64 = (SpecInfo) ListProtector.get(r63, r114);
        if (r64 == null) goto L614;
        r64.getName();
        goto L614
    L615:
        String r65 = th.a.h(r26.Y().c(), 2131914031, new Object[]{r56.toString()});
    L626:
        r55.g(r65);
        SkuViewModel r66 = r26.f;
        if (r66 != null) goto L629;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L629:
        SpecItemOptimizeGroupLayout r67 = r26.h;
        if (r67 != null) goto L632;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L632:
        r66.setCanAddCart(r67.getCanAddCart());
        StringBuilder r68 = new StringBuilder();
        SpecItemOptimizeGroupLayout r69 = r26.h;
        if (r69 != null) goto L635;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L635:
        String[] r70 = r69.getCheckedIdArray();
        SkuViewModel r71 = r26.f;
        if (r71 != null) goto L639;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L639:
        if (r71.getSkuParams().isFromCartOrInsurance() == false) goto L696;
        if (r70 == null) goto L650;
        int r72 = r70.length;
        int r73 = 0;
    L642:
        if (r73 >= r72) goto L650;
        String r74 = r70[r73];
        if (r74 == null) goto L646;
        boolean r126 = true;
    L647:
        if (r126 == true) goto L651;
        r73 = r73 + 1;
    L651:
        if (r74 == null) goto L696;
        int r75 = r70.length;
        int r76 = 0;
        int r77 = 0;
    L653:
        if (r76 >= r75) goto L692;
        String r127 = r70[r76];
        int r128 = r77 + 1;
        SkuViewModel r129 = r26.f;
        if (r129 != null) goto L657;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L657:
        SkuInfoVO r130 = (SkuInfoVO) r129.getSkuInfo().a();
        if (r130 == null) goto L691;
        List<SpecInfo> r131 = r130.getSpecInfoList();
        if (r131 == null) goto L691;
        if (r131.size() <= r77) goto L664;
        boolean r132 = true;
    L665:
        if (r132 == true) goto L668;
        r131 = null;
    L668:
        if (r131 == null) goto L691;
        SpecInfo r133 = (SpecInfo) ListProtector.get(r131, r77);
        if (r133 == null) goto L691;
        r68.append(r133.getName() + ':');
        Iterator<T> r134 = r133.getSpecItems().iterator();
    L673:
        if (r134.hasNext() == false) goto L677;
        Object r135 = r134.next();
        if (Intrinsics.areEqual(((SpecInfoItem) r135).getId(), r127) == false) goto L673;
    L678:
        SpecInfoItem r136 = (SpecInfoItem) r135;
        if (r136 == null) goto L681;
        r68.append(r136.getName() + ';');
        goto L691
    L681:
        SkuViewModel r137 = r26.f;
        if (r137 != null) goto L684;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L684:
        SkuInfoVO r138 = (SkuInfoVO) r137.getSkuInfo().a();
        if (r138 == null) goto L691;
        List<SpecInfo> r139 = r138.getSpecInfoList();
        if (r139 == null) goto L691;
        SpecInfo r78 = (SpecInfo) ListProtector.get(r139, r77);
        if (r78 == null) goto L691;
        r78.getName();
        goto L691
    L677:
        r135 = null;
        goto L678
    L664:
        r132 = false;
    L691:
        r76 = r76 + 1;
        r77 = r128;
        goto L653
    L692:
        SkuViewModel r79 = r26.f;
        if (r79 != null) goto L695;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L695:
        r79.setCartSelectedDes(r68.toString());
        goto L696
    L646:
        r126 = false;
    L650:
        r74 = null;
    L696:
        SkuViewModel r80 = r26.f;
        if (r80 != null) goto L699;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L699:
        QLiveData<rg.a<String>> r81 = r80.getOnItemChange();
        SpecItemOptimizeGroupLayout r82 = r26.h;
        if (r82 != null) goto L702;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L702:
        r81.g(new rg.a(r82.getCheckedId()));
        SkuViewModel r83 = r26.f;
        if (r83 != null) goto L705;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L705:
        QLiveData<CarAdaptComponent> r84 = r83.getCurrentCarAdaptComponent();
        SpecItemOptimizeGroupLayout r85 = r26.h;
        if (r85 != null) goto L708;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L708:
        r84.g(r85.getCheckSkuCarAdapt());
        SkuViewModel r86 = r26.f;
        if (r86 != null) goto L711;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L711:
        QLiveData<String> r87 = r86.getStockDesc();
        SpecItemOptimizeGroupLayout r88 = r26.h;
        if (r88 != null) goto L714;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L714:
        r87.g(r88.getStockDesc());
        r26.k0();
        return;
    L616:
        Context r89 = r26.Y().c();
        Object[] r90 = new Object[1];
        SkuViewModel r91 = r26.f;
        if (r91 != null) goto L619;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L619:
        SkuInfoVO r92 = (SkuInfoVO) r91.getSkuInfo().a();
        if (r92 == null) goto L624;
        List<SpecInfo> r93 = r92.getSpecInfoList();
        if (r93 == null) goto L624;
        String r94 = CollectionsKt.joinToString$default(r93, " ", " ", null, 0, null, SelectOptimizePresenter$refreshTitleSpec$3.INSTANCE, 28, null);
    L625:
        r56.append(r94);
        r90[0] = r56.toString();
        r65 = th.a.h(r89, 2131914030, r90);
    L624:
        r94 = null;
        goto L625
    L566:
        r112 = false;
    L570:
        r111 = null;
    L547:
        r53 = null;
        goto L548
    L529:
        r45 = false;
    L549:
        SkuViewModel r95 = r26.f;
        if (r95 != null) goto L552;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L552:
        r95.getUnCheckedName().g(null);
    L68:
        SkuViewModel r96 = r26.f;
        if (r96 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L71:
        r96.getCurrentAvatar().g(r19);
        goto L72
    L60:
        r33 = false;
        goto L61
    L73:
        SpecItemOptimizeGroupLayout r97 = r26.h;
        if (r97 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L76:
        String r98 = r97.getCheckSkuImageUrl();
        SkuViewModel r140 = r26.f;
        if (r140 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L79:
        QLiveData<String> r141 = r140.getCurrentAvatar();
        if (r98 != null) goto L82;
    L87:
        r98 = null;
    L88:
        if (r98 != null) goto L90;
        r98 = "";
    L90:
        r141.g(r98);
        SpecItemOptimizeGroupLayout r99 = r26.h;
        if (r99 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L93:
        Long r100 = r99.getCheckSkuPrice();
        if (r100 == null) goto L96;
        long r142 = r100.longValue();
    L97:
        SkuViewModel r101 = r26.f;
        if (r101 != null) goto L100;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L100:
        r101.m1028getCurrentPrice().g(Long.valueOf(r142));
        SkuViewModel r102 = r26.f;
        if (r102 != null) goto L103;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L103:
        SpecItemOptimizeGroupLayout r143 = r26.h;
        if (r143 != null) goto L106;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L106:
        Long r144 = r143.getCheckSkuOriginPrice();
        if (r144 == null) goto L109;
        long r145 = r144.longValue();
    L110:
        r102.setCurrentOriginPrice(r145);
        SkuViewModel r103 = r26.f;
        if (r103 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L113:
        SpecItemOptimizeGroupLayout r146 = r26.h;
        if (r146 != null) goto L116;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L116:
        Long r147 = r146.getCheckSkuDiscountPrice();
        if (r147 == null) goto L119;
        long r148 = r147.longValue();
    L120:
        r103.setCurrentDiscountPrice(r148);
        SkuViewModel r104 = r26.f;
        if (r104 != null) goto L123;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L123:
        SpecItemOptimizeGroupLayout r149 = r26.h;
        if (r149 != null) goto L126;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L126:
        String r150 = r149.getCheckSkuDiscountPriceText();
        if (r150 != null) goto L129;
        r150 = "";
    L129:
        r104.setCurrentDiscountPriceText(r150);
        SkuViewModel r105 = r26.f;
        if (r105 != null) goto L132;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L132:
        SpecItemOptimizeGroupLayout r151 = r26.h;
        if (r151 != null) goto L135;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L135:
        String r152 = r151.getCheckSkuCampaignPriceHeader();
        if (r152 == null) goto L139;
        r19 = r152;
    L139:
        r105.setCurrentCampainPriceHeader(r19);
        SkuViewModel r106 = r26.f;
        if (r106 != null) goto L142;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L142:
        SpecItemOptimizeGroupLayout r107 = r26.h;
        if (r107 != null) goto L145;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L145:
        r106.setCurrentCampainPriceHeaderStyle(r107.getCheckSkuPriceHedaerStyle());
        SkuViewModel r108 = r26.f;
        if (r108 != null) goto L148;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L148:
        SpecItemOptimizeGroupLayout r109 = r26.h;
        if (r109 != null) goto L151;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L151:
        r108.setCurrentNewBonusText(r109.getNewBonusText());
        if (r142 != (-1)) goto L367;
        SkuViewModel r153 = r26.f;
        if (r153 != null) goto L156;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L156:
        SkuViewModel r154 = r26.f;
        if (r154 != null) goto L159;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L159:
        SkuInfoVO r155 = (SkuInfoVO) r154.getSkuInfo().a();
        if (r155 == null) goto L162;
        Long r156 = r155.getFirstPrice();
    L163:
        r153.setCurrentFirstPrice(r156);
        SkuViewModel r157 = r26.f;
        if (r157 != null) goto L166;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L166:
        SkuViewModel r158 = r26.f;
        if (r158 != null) goto L169;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L169:
        SkuInfoVO r159 = (SkuInfoVO) r158.getSkuInfo().a();
        if (r159 == null) goto L172;
        String r160 = r159.getFirstPricePrefix();
    L173:
        r157.setCurrentFirstPricePrefix(r160);
        SkuViewModel r161 = r26.f;
        if (r161 != null) goto L176;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L176:
        SkuViewModel r162 = r26.f;
        if (r162 != null) goto L179;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L179:
        SkuInfoVO r163 = (SkuInfoVO) r162.getSkuInfo().a();
        if (r163 == null) goto L182;
        String r164 = r163.getFirstPriceSuffix();
    L183:
        r161.setCurrentFirstPriceSuffix(r164);
        SkuViewModel r165 = r26.f;
        if (r165 != null) goto L186;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L186:
        SkuViewModel r166 = r26.f;
        if (r166 != null) goto L189;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L189:
        SkuInfoVO r167 = (SkuInfoVO) r166.getSkuInfo().a();
        if (r167 == null) goto L192;
        Boolean r168 = r167.getFirstPriceIsUnderline();
    L193:
        r165.setCurrentFirstPriceIsUnderline(r168);
        SkuViewModel r169 = r26.f;
        if (r169 != null) goto L196;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L196:
        SkuViewModel r170 = r26.f;
        if (r170 != null) goto L199;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L199:
        SkuInfoVO r171 = (SkuInfoVO) r170.getSkuInfo().a();
        if (r171 == null) goto L202;
        String r172 = r171.getFirstPriceSupplement();
    L203:
        r169.setCurrentFirstPriceSupplement(r172);
        SkuViewModel r173 = r26.f;
        if (r173 != null) goto L206;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L206:
        SkuViewModel r174 = r26.f;
        if (r174 != null) goto L209;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L209:
        SkuInfoVO r175 = (SkuInfoVO) r174.getSkuInfo().a();
        if (r175 == null) goto L212;
        Long r176 = r175.getSecondPrice();
    L213:
        r173.setCurrentSecondPrice(r176);
        SkuViewModel r177 = r26.f;
        if (r177 != null) goto L216;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L216:
        SkuViewModel r178 = r26.f;
        if (r178 != null) goto L219;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L219:
        SkuInfoVO r179 = (SkuInfoVO) r178.getSkuInfo().a();
        if (r179 == null) goto L222;
        String r180 = r179.getSecondPricePrefix();
    L223:
        r177.setCurrentSecondPricePrefix(r180);
        SkuViewModel r181 = r26.f;
        if (r181 != null) goto L226;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L226:
        SkuViewModel r182 = r26.f;
        if (r182 != null) goto L229;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L229:
        SkuInfoVO r183 = (SkuInfoVO) r182.getSkuInfo().a();
        if (r183 == null) goto L232;
        String r184 = r183.getSecondPriceSuffix();
    L233:
        r181.setCurrentSecondPriceSuffix(r184);
        SkuViewModel r185 = r26.f;
        if (r185 != null) goto L236;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L236:
        SkuViewModel r186 = r26.f;
        if (r186 != null) goto L239;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L239:
        SkuInfoVO r187 = (SkuInfoVO) r186.getSkuInfo().a();
        if (r187 == null) goto L242;
        Boolean r188 = r187.getSecondPriceIsUnderline();
    L243:
        r185.setCurrentSecondPriceIsUnderline(r188);
        SkuViewModel r189 = r26.f;
        if (r189 != null) goto L246;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L246:
        SkuViewModel r190 = r26.f;
        if (r190 != null) goto L249;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L249:
        SkuInfoVO r191 = (SkuInfoVO) r190.getSkuInfo().a();
        if (r191 == null) goto L252;
        Boolean r192 = r191.getSecondPriceIsReducePrice();
    L253:
        r189.setCurrentSecondPriceIsReducePrice(r192);
        SkuViewModel r193 = r26.f;
        if (r193 != null) goto L256;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L256:
        SkuViewModel r194 = r26.f;
        if (r194 != null) goto L259;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L259:
        SkuInfoVO r195 = (SkuInfoVO) r194.getSkuInfo().a();
        if (r195 == null) goto L262;
        String r196 = r195.getSecondPriceSupplement();
    L263:
        r193.setCurrentSecondPriceSupplement(r196);
        SkuViewModel r197 = r26.f;
        if (r197 != null) goto L266;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L266:
        SkuViewModel r198 = r26.f;
        if (r198 != null) goto L269;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L269:
        SkuInfoVO r199 = (SkuInfoVO) r198.getSkuInfo().a();
        if (r199 == null) goto L272;
        Long r200 = r199.getRegularPrice();
    L273:
        r197.setCurrentRegularPrice(r200);
        SkuViewModel r201 = r26.f;
        if (r201 != null) goto L276;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L276:
        SkuViewModel r202 = r26.f;
        if (r202 != null) goto L279;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L279:
        SkuInfoVO r203 = (SkuInfoVO) r202.getSkuInfo().a();
        if (r203 == null) goto L282;
        Long r204 = r203.getPriceType();
    L283:
        r201.setCurrentPriceType(r204);
        SkuViewModel r205 = r26.f;
        if (r205 != null) goto L286;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L286:
        SkuViewModel r206 = r26.f;
        if (r206 != null) goto L289;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L289:
        SkuInfoVO r207 = (SkuInfoVO) r206.getSkuInfo().a();
        if (r207 == null) goto L292;
        String r208 = r207.getRegularPricePrefix();
    L293:
        r205.setCurrentRegularPricePrefix(r208);
        SkuViewModel r209 = r26.f;
        if (r209 != null) goto L296;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L296:
        SkuViewModel r210 = r26.f;
        if (r210 != null) goto L299;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L299:
        SkuInfoVO r211 = (SkuInfoVO) r210.getSkuInfo().a();
        if (r211 == null) goto L302;
        String r212 = r211.getRegularPriceSuffix();
    L303:
        r209.setCurrentRegularPriceSuffix(r212);
        SkuViewModel r213 = r26.f;
        if (r213 != null) goto L306;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L306:
        SkuViewModel r214 = r26.f;
        if (r214 != null) goto L309;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L309:
        SkuInfoVO r215 = (SkuInfoVO) r214.getSkuInfo().a();
        if (r215 == null) goto L312;
        Boolean r216 = r215.getRegularPriceIsUnderline();
    L313:
        r213.setCurrentRegularPriceIsUnderline(r216);
        SkuViewModel r217 = r26.f;
        if (r217 != null) goto L316;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L316:
        SkuViewModel r218 = r26.f;
        if (r218 != null) goto L319;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L319:
        SkuInfoVO r219 = (SkuInfoVO) r218.getSkuInfo().a();
        if (r219 == null) goto L322;
        String r220 = r219.getRegularPriceSupplement();
    L323:
        r217.setCurrentRegularPriceSupplement(r220);
        SkuViewModel r221 = r26.f;
        if (r221 != null) goto L326;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L326:
        SkuViewModel r222 = r26.f;
        if (r222 != null) goto L329;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L329:
        SkuInfoVO r223 = (SkuInfoVO) r222.getSkuInfo().a();
        if (r223 == null) goto L332;
        Long r224 = r223.getHotMinPrice();
    L333:
        r221.setCurrentHotMinPrice(r224);
        SkuViewModel r225 = r26.f;
        if (r225 != null) goto L336;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L336:
        SkuViewModel r226 = r26.f;
        if (r226 != null) goto L339;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L339:
        SkuInfoVO r227 = (SkuInfoVO) r226.getSkuInfo().a();
        if (r227 == null) goto L342;
        Long r228 = r227.getHotMaxPrice();
    L343:
        r225.setCurrentHotMaxPrice(r228);
        SkuViewModel r229 = r26.f;
        if (r229 != null) goto L346;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L346:
        SkuViewModel r230 = r26.f;
        if (r230 != null) goto L349;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L349:
        SkuInfoVO r231 = (SkuInfoVO) r230.getSkuInfo().a();
        if (r231 == null) goto L352;
        String r232 = r231.getHotPricePrefix();
    L353:
        r229.setCurrentHotPricePrefix(r232);
        SkuViewModel r233 = r26.f;
        if (r233 != null) goto L356;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L356:
        r233.m1028getCurrentPrice().g(Long.valueOf(r142));
        SkuViewModel r234 = r26.f;
        if (r234 != null) goto L359;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L359:
        QLiveData<Integer> r235 = r234.getCurrentAtmosphereStyle();
        SkuViewModel r236 = r26.f;
        if (r236 != null) goto L362;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L362:
        SkuInfoVO r237 = (SkuInfoVO) r236.getSkuInfo().a();
        if (r237 == null) goto L365;
        Integer r238 = r237.getAtmosphereStyle();
    L366:
        r235.g(r238);
    L504:
        if (r27 == true) goto L506;
        r26.i0();
        goto L506
    L365:
        r238 = null;
        goto L366
    L352:
        r232 = null;
        goto L353
    L342:
        r228 = null;
        goto L343
    L332:
        r224 = null;
        goto L333
    L322:
        r220 = null;
        goto L323
    L312:
        r216 = null;
        goto L313
    L302:
        r212 = null;
        goto L303
    L292:
        r208 = null;
        goto L293
    L282:
        r204 = null;
        goto L283
    L272:
        r200 = null;
        goto L273
    L262:
        r196 = null;
        goto L263
    L252:
        r192 = null;
        goto L253
    L242:
        r188 = null;
        goto L243
    L232:
        r184 = null;
        goto L233
    L222:
        r180 = null;
        goto L223
    L212:
        r176 = null;
        goto L213
    L202:
        r172 = null;
        goto L203
    L192:
        r168 = null;
        goto L193
    L182:
        r164 = null;
        goto L183
    L172:
        r160 = null;
        goto L173
    L162:
        r156 = null;
        goto L163
    L367:
        SkuViewModel r239 = r26.f;
        if (r239 != null) goto L370;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L370:
        SpecItemOptimizeGroupLayout r240 = r26.h;
        if (r240 != null) goto L373;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L373:
        r239.setCurrentFirstPrice(r240.getCheckSkuFirstPrice());
        SkuViewModel r241 = r26.f;
        if (r241 != null) goto L376;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L376:
        SpecItemOptimizeGroupLayout r242 = r26.h;
        if (r242 != null) goto L379;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L379:
        r241.setCurrentPriceType(r242.getCheckSkuPriceType());
        SkuViewModel r243 = r26.f;
        if (r243 != null) goto L382;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L382:
        SpecItemOptimizeGroupLayout r244 = r26.h;
        if (r244 != null) goto L385;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L385:
        r243.setCurrentFirstPricePrefix(r244.getCheckSkuFirstPricePrefix());
        SkuViewModel r245 = r26.f;
        if (r245 != null) goto L388;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L388:
        SpecItemOptimizeGroupLayout r246 = r26.h;
        if (r246 != null) goto L391;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L391:
        r245.setCurrentFirstPriceSupplement(r246.getCheckSkuFirstPriceSpecDesc());
        SkuViewModel r247 = r26.f;
        if (r247 != null) goto L394;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L394:
        SpecItemOptimizeGroupLayout r248 = r26.h;
        if (r248 != null) goto L397;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L397:
        r247.setCurrentFirstPriceSuffix(r248.getCheckSkuFirstPriceSuffix());
        SkuViewModel r249 = r26.f;
        if (r249 != null) goto L400;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L400:
        SpecItemOptimizeGroupLayout r250 = r26.h;
        if (r250 != null) goto L403;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L403:
        r249.setCurrentFirstPriceIsUnderline(r250.getCheckSkuFirstPriceIsUnderline());
        SkuViewModel r251 = r26.f;
        if (r251 != null) goto L406;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L406:
        SpecItemOptimizeGroupLayout r252 = r26.h;
        if (r252 != null) goto L409;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L409:
        r251.setCurrentSecondPrice(r252.getCheckSkuSecondPrice());
        SkuViewModel r253 = r26.f;
        if (r253 != null) goto L412;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L412:
        SpecItemOptimizeGroupLayout r254 = r26.h;
        if (r254 != null) goto L415;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L415:
        r253.setCurrentSecondPricePrefix(r254.getCheckSkuSecondPricePrefix());
        SkuViewModel r255 = r26.f;
        if (r255 != null) goto L418;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L418:
        SpecItemOptimizeGroupLayout r256 = r26.h;
        if (r256 != null) goto L421;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L421:
        r255.setCurrentSecondPriceSuffix(r256.getCheckSkuSecondPriceSuffix());
        SkuViewModel r257 = r26.f;
        if (r257 != null) goto L424;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L424:
        SpecItemOptimizeGroupLayout r258 = r26.h;
        if (r258 != null) goto L427;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L427:
        r257.setCurrentSecondPriceIsUnderline(r258.getCheckSkuSecondPriceIsUnderline());
        SkuViewModel r259 = r26.f;
        if (r259 != null) goto L430;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L430:
        SpecItemOptimizeGroupLayout r260 = r26.h;
        if (r260 != null) goto L433;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L433:
        r259.setCurrentSecondPriceSupplement(r260.getCheckSkuSecondPriceSpecDesc());
        SkuViewModel r261 = r26.f;
        if (r261 != null) goto L436;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L436:
        SpecItemOptimizeGroupLayout r262 = r26.h;
        if (r262 != null) goto L439;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L439:
        r261.setCurrentSecondPriceIsReducePrice(r262.getCheckSkuSecondPriceIsReducePrice());
        SkuViewModel r263 = r26.f;
        if (r263 != null) goto L442;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L442:
        SpecItemOptimizeGroupLayout r264 = r26.h;
        if (r264 != null) goto L445;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L445:
        r263.setCurrentRegularPrice(r264.getCheckSkuRegularPrice());
        SkuViewModel r265 = r26.f;
        if (r265 != null) goto L448;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L448:
        SpecItemOptimizeGroupLayout r266 = r26.h;
        if (r266 != null) goto L451;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L451:
        r265.setCurrentRegularPricePrefix(r266.getCheckSkuRegularPricePrefix());
        SkuViewModel r267 = r26.f;
        if (r267 != null) goto L454;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L454:
        SpecItemOptimizeGroupLayout r268 = r26.h;
        if (r268 != null) goto L457;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L457:
        r267.setCurrentRegularPriceSuffix(r268.getCheckSkuRegularPriceSuffix());
        SkuViewModel r269 = r26.f;
        if (r269 != null) goto L460;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L460:
        SpecItemOptimizeGroupLayout r270 = r26.h;
        if (r270 != null) goto L463;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L463:
        r269.setCurrentRegularPriceIsUnderline(r270.getCheckSkuRegularPriceIsUnderline());
        SkuViewModel r271 = r26.f;
        if (r271 != null) goto L466;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L466:
        SpecItemOptimizeGroupLayout r272 = r26.h;
        if (r272 != null) goto L469;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L469:
        r271.setCurrentRegularPriceSupplement(r272.getCheckSkuRegularPriceSpecDesc());
        SkuViewModel r273 = r26.f;
        if (r273 != null) goto L472;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L472:
        SpecItemOptimizeGroupLayout r274 = r26.h;
        if (r274 != null) goto L475;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L475:
        r273.setCurrentHotMinPrice(r274.getCheckSkuHotMinPrice());
        SkuViewModel r275 = r26.f;
        if (r275 != null) goto L478;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L478:
        SpecItemOptimizeGroupLayout r276 = r26.h;
        if (r276 != null) goto L481;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L481:
        r275.setCurrentHotMaxPrice(r276.getCheckSkuHotMaxPrice());
        SkuViewModel r277 = r26.f;
        if (r277 != null) goto L484;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L484:
        SpecItemOptimizeGroupLayout r278 = r26.h;
        if (r278 != null) goto L487;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L487:
        r277.setCurrentHotPriceSupplement(r278.getCheckSkuFirstPricePrefix());
        SkuViewModel r279 = r26.f;
        if (r279 != null) goto L490;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L490:
        SkuViewModel r280 = r26.f;
        if (r280 != null) goto L493;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L493:
        SkuInfoVO r281 = (SkuInfoVO) r280.getSkuInfo().a();
        if (r281 == null) goto L496;
        String r282 = r281.getHotPricePrefix();
    L497:
        r279.setCurrentHotPricePrefix(r282);
        SkuViewModel r283 = r26.f;
        if (r283 != null) goto L500;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L500:
        QLiveData<Integer> r284 = r283.getCurrentAtmosphereStyle();
        SpecItemOptimizeGroupLayout r285 = r26.h;
        if (r285 != null) goto L503;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L503:
        r284.g(r285.getCheckSkuAtmosphereStyle());
        goto L504
    L496:
        r282 = null;
        goto L497
    L119:
        r148 = 0;
        goto L120
    L109:
        r145 = 0;
        goto L110
    L96:
        r142 = 0;
        goto L97
    L82:
        if (r98.length() <= 0) goto L84;
        boolean r1100 = true;
    L85:
        if (r1100 == false) goto L87;
    L84:
        r1100 = false;
    L38:
        r23 = new ArrayList();
    L24:
        r18 = null;
        goto L25
    }
}
