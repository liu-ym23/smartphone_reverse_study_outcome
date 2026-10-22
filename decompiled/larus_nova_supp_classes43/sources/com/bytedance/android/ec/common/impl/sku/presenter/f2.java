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
import com.bytedance.android.ec.common.impl.sku.view.SpecItemGroupLayout;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f2 extends QFragmentPresenter {
    public SkuViewModel f;
    public LinearLayout g;
    public SpecItemGroupLayout h;
    public String i;

    public static final class a implements SpecItemGroupLayout.d {
        public final /* synthetic */ f2 a;

        @Override // com.bytedance.android.ec.common.impl.sku.view.SpecItemGroupLayout.d
        public final void b() {
            cg.h r0 = f2.e0(this.a).getSpecTitleEntryEventStruct();
            SkuViewModel r10 = f2.e0(this.a);
            Pair[] r11 = new Pair[4];
            if (f2.e0(this.a).getSkuParams().isFromAnchorV3() == false) goto L5;
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

        public a(f2 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.ec.common.impl.sku.view.SpecItemGroupLayout.d
        public final void a(int r12) {
            String r1 = "1";
            if (f2.e0(this.a).isSizeTabExist() == false) goto L5;
            Object r0 = "1";
        L6:
            SkuInfoVO r10 = (SkuInfoVO) f2.e0(this.a).getSkuInfo().a();
            if (r10 == null) goto L9;
            SkuBannerStruct r11 = r10.getSkuBanner();
        L10:
            if (r11 != null) goto L13;
            r1 = "0";
        L13:
            SkuViewModel r13 = f2.e0(this.a);
            Pair[] r14 = new Pair[5];
            r14[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PREVIOUS_PAGE, f2.e0(this.a).getPreviousPage());
            r14[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_EXIST_SIZE_TAB, r0);
            r14[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_THREE_D, f2.e0(this.a).getSkuParams().getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_THREE_D));
            r14[3] = TuplesKt.to("with_comment", r1);
            if (f2.e0(this.a).isPresaleSkuSpec(r12) == false) goto L16;
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

    public static final class b implements SpecItemGroupLayout.b {
        public final /* synthetic */ f2 a;

        public b(f2 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.ec.common.impl.sku.view.SpecItemGroupLayout.b
        public final void a(String[] r25) {
            Intrinsics.checkNotNullParameter(r25, "checkIdArray");
            f2.h0(this.a);
            SkuRestoreState r10 = f2.e0(this.a).getSkuPanelState();
            if (r10 == null) goto L5;
            r10.setSelectSkuKeys(r25);
        L5:
            f2.e0(this.a).notifySkuChanged();
            Function1<SkuProductDetailInfo, Unit> r11 = f2.e0(this.a).getRefreshDetailInfoCallback();
            if (r11 == null) goto L15;
            String r12 = f2.d0(this.a).getCheckSkuImageUrl();
            Long r13 = f2.d0(this.a).getCheckSkuPrice();
            Long r14 = f2.d0(this.a).getCheckSkuOriginPrice();
            Long r15 = f2.d0(this.a).getCheckSkuDiscountPrice();
            if (r15 == null) goto L10;
            long r16 = r15.longValue();
        L11:
            Long r18 = Long.valueOf(r16);
            String r17 = f2.d0(this.a).getCheckSkuDiscountPriceText();
            if (r17 != null) goto L14;
            r17 = "";
        L14:
            Unit r1 = (Unit) r11.invoke(new SkuProductDetailInfo(r12, new ProductPriceInfo(r13, r14, new PromotionDiscountPrice(r18, null, r17, null, 10, null), null, null, 24, null), f2.d0(this.a).getSelectEPInfo(), this.a.i, false, (String[]) Arrays.copyOf(r25, r25.length), false, 64, null));
            goto L15
        L10:
            r16 = 0;
        L15:
            SkuViewModel r19 = f2.e0(this.a);
            Long r20 = (Long) f2.e0(this.a).m1028getCurrentPrice().a();
            if (r20 == null) goto L18;
            long r21 = r20.longValue();
        L20:
            if (r21 <= 0) goto L22;
            boolean r22 = true;
        L23:
            r19.setHasRefreshDetailInfo(r22);
            return;
        L22:
            r22 = false;
            goto L23
        L18:
            r21 = 0;
            goto L20
        }
    }

    public final void i0() {
        this.g = (LinearLayout) Z().b(2131378865).f();
        Context r1 = Y().c();
        SkuViewModel r10 = this.f;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SpecItemGroupLayout r0 = new SpecItemGroupLayout(r1, r10.getSkuStockData());
        this.h = r0;
        r0.setSpecGroupLogEventLogger(new a(this));
        SpecItemGroupLayout r11 = this.h;
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

    public f2(Fragment r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        super(r10);
    }

    public static final /* synthetic */ SpecItemGroupLayout d0(f2 r1) {
        SpecItemGroupLayout r10 = r1.h;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L5:
        return r10;
    }

    public static final /* synthetic */ SkuViewModel e0(f2 r1) {
        SkuViewModel r10 = r1.f;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        return r10;
    }

    public static final void h0(f2 r26) {
        SkuViewModel r1 = r26.f;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SpecItemGroupLayout r10 = r26.h;
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
        SpecItemGroupLayout r16 = r26.h;
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
        SpecItemGroupLayout r21 = r26.h;
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
        SpecItemGroupLayout r25 = r26.h;
        if (r25 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L45:
        r24.setCurrentPos(r25.getCurrentPosition());
        int r27 = qf.a.a;
        SkuViewModel r28 = r26.f;
        if (r28 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L48:
        long r29 = 0;
        if (qf.a.e.a(r28.getSkuParams()) == false) goto L260;
        SpecItemGroupLayout r30 = r26.h;
        if (r30 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L53:
        String r31 = r30.getCheckSkuImageUrl();
        if (r31 != null) goto L57;
        r31 = "";
    L57:
        if (r31.length() <= 0) goto L59;
        boolean r110 = true;
    L60:
        if (r110 == false) goto L67;
        SkuViewModel r111 = r26.f;
        if (r111 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L65:
        if (Intrinsics.areEqual(r31, (String) r111.getCurrentAvatar().a()) == false) goto L67;
    L71:
        SpecItemGroupLayout r32 = r26.h;
        if (r32 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L74:
        Long r33 = r32.getCheckSkuPrice();
        if (r33 == null) goto L77;
        long r112 = r33.longValue();
    L79:
        if (r112 != (-1)) goto L181;
        SkuViewModel r34 = r26.f;
        if (r34 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L83:
        long r113 = r34.getCurrentPriceWithDefault();
        SkuViewModel r35 = r26.f;
        if (r35 != null) goto L86;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L86:
        SkuInfoVO r36 = (SkuInfoVO) r35.getSkuInfo().a();
        if (r36 == null) goto L89;
        Long r37 = Long.valueOf(r36.getMinPrice());
    L91:
        if (r113 != jg.g.b(r37, 0)) goto L116;
        SkuViewModel r38 = r26.f;
        if (r38 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L95:
        long r114 = r38.getCurrentOriginPrice();
        SkuViewModel r39 = r26.f;
        if (r39 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L98:
        SkuInfoVO r40 = (SkuInfoVO) r39.getSkuInfo().a();
        if (r40 == null) goto L101;
        Long r41 = Long.valueOf(r40.getMarketPrice());
    L103:
        if (r114 != jg.g.b(r41, 0)) goto L116;
        SkuViewModel r42 = r26.f;
        if (r42 != null) goto L107;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L107:
        long r115 = r42.getCurrentDiscountPrice();
        SkuViewModel r43 = r26.f;
        if (r43 != null) goto L110;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L110:
        SkuInfoVO r44 = (SkuInfoVO) r43.getSkuInfo().a();
        if (r44 == null) goto L113;
        Long r45 = r44.getDiscountPrice();
    L115:
        if (r115 != jg.g.b(r45, 0)) goto L116;
    L339:
        SkuViewModel r46 = r26.f;
        if (r46 != null) goto L342;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L342:
        QLiveData<Long> r47 = r46.getCurrentStock();
        SpecItemGroupLayout r48 = r26.h;
        if (r48 != null) goto L345;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L345:
        Long r49 = r48.getRealStock();
        if (r49 == null) goto L348;
        r29 = r49.longValue();
    L348:
        r47.g(Long.valueOf(r29));
        SkuViewModel r50 = r26.f;
        if (r50 != null) goto L351;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L351:
        QLiveData<SkuLimit> r51 = r50.m1031getUpperLimit();
        SpecItemGroupLayout r52 = r26.h;
        if (r52 != null) goto L354;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L354:
        r51.g(r52.getCheckSkuMaxPurchaseCount());
        SkuViewModel r53 = r26.f;
        if (r53 != null) goto L357;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L357:
        QLiveData<SkuLimit> r54 = r53.m1029getLowerLimit();
        SpecItemGroupLayout r55 = r26.h;
        if (r55 != null) goto L360;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L360:
        r54.g(r55.getCheckSkuLeastPurchaseCount());
        SkuViewModel r56 = r26.f;
        if (r56 != null) goto L363;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L363:
        QLiveData<String> r57 = r56.getLimitText();
        SpecItemGroupLayout r58 = r26.h;
        if (r58 != null) goto L366;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L366:
        r57.g(r58.getLimitText());
        SkuViewModel r59 = r26.f;
        if (r59 != null) goto L369;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L369:
        QLiveData<List<PromotionBenefitLabel>> r60 = r59.getCurrentBenefitLabel();
        SpecItemGroupLayout r61 = r26.h;
        if (r61 != null) goto L372;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L372:
        r60.g(r61.getSkuBenefitLabel());
        SpecItemGroupLayout r62 = r26.h;
        if (r62 != null) goto L375;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L375:
        String[] r63 = r62.getCheckedIdArray();
        if (r63 == null) goto L400;
        Integer r64 = Integer.valueOf(ArraysKt.indexOf(r63, null));
        if (r64.intValue() < 0) goto L380;
        boolean r65 = true;
    L381:
        if (r65 == true) goto L384;
        r64 = null;
    L384:
        if (r64 == null) goto L400;
        int r66 = r64.intValue();
        SkuViewModel r67 = r26.f;
        if (r67 != null) goto L388;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L388:
        QLiveData<String> r68 = r67.getUnCheckedName();
        SkuViewModel r69 = r26.f;
        if (r69 != null) goto L391;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L391:
        SkuInfoVO r70 = (SkuInfoVO) r69.getSkuInfo().a();
        if (r70 == null) goto L398;
        List<SpecInfo> r71 = r70.getSpecInfoList();
        if (r71 == null) goto L398;
        SpecInfo r72 = (SpecInfo) ListProtector.get(r71, r66);
        if (r72 == null) goto L398;
        String r73 = r72.getName();
    L399:
        r68.g(r73);
    L404:
        SkuViewModel r74 = r26.f;
        if (r74 != null) goto L407;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L407:
        QLiveData<String> r75 = r74.getCheckedNames();
        StringBuilder r76 = new StringBuilder();
        SpecItemGroupLayout r77 = r26.h;
        if (r77 != null) goto L410;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L410:
        String[] r78 = r77.getCheckedIdArray();
        if (r78 == null) goto L421;
        int r79 = r78.length;
        int r116 = 0;
    L413:
        if (r116 >= r79) goto L421;
        String r117 = r78[r116];
        if (r117 == null) goto L417;
        boolean r118 = true;
    L418:
        if (r118 == true) goto L422;
        r116 = r116 + 1;
    L422:
        if (r117 == null) goto L467;
        int r80 = r78.length;
        int r119 = 0;
        int r120 = 0;
    L424:
        if (r119 >= r80) goto L466;
        String r121 = r78[r119];
        int r122 = r120 + 1;
        SkuViewModel r123 = r26.f;
        if (r123 != null) goto L428;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L428:
        SkuInfoVO r124 = (SkuInfoVO) r123.getSkuInfo().a();
        if (r124 == null) goto L455;
        List<SpecInfo> r125 = r124.getSpecInfoList();
        if (r125 == null) goto L455;
        if (r125.size() <= r120) goto L435;
        boolean r126 = true;
    L436:
        if (r126 == true) goto L439;
        r125 = r14;
    L439:
        if (r125 == null) goto L455;
        SpecInfo r127 = (SpecInfo) ListProtector.get(r125, r120);
        if (r127 == null) goto L455;
        List<SpecInfoItem> r128 = r127.getSpecItems();
        if (r128 == null) goto L455;
        Iterator<T> r129 = r128.iterator();
    L446:
        if (r129.hasNext() == false) goto L451;
        Object r130 = r129.next();
        if (Intrinsics.areEqual(((SpecInfoItem) r130).getId(), r121) == false) goto L446;
    L452:
        SpecInfoItem r131 = (SpecInfoItem) r130;
        if (r131 == null) goto L455;
        r76.append(" " + r131.getName());
        r26.i = r131.getName();
    L465:
        r119 = r119 + 1;
        r120 = r122;
        r14 = null;
        goto L424
    L451:
        r130 = null;
        goto L452
    L435:
        r126 = false;
    L455:
        SkuViewModel r81 = r26.f;
        if (r81 != null) goto L458;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L458:
        SkuInfoVO r82 = (SkuInfoVO) r81.getSkuInfo().a();
        if (r82 == null) goto L465;
        List<SpecInfo> r83 = r82.getSpecInfoList();
        if (r83 == null) goto L465;
        SpecInfo r84 = (SpecInfo) ListProtector.get(r83, r120);
        if (r84 == null) goto L465;
        r84.getName();
        goto L465
    L466:
        String r85 = th.a.h(r26.Y().c(), 2131914031, new Object[]{r76.toString()});
    L477:
        r75.g(r85);
        StringBuilder r86 = new StringBuilder();
        SpecItemGroupLayout r87 = r26.h;
        if (r87 != null) goto L480;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L480:
        String[] r88 = r87.getCheckedIdArray();
        SkuViewModel r89 = r26.f;
        if (r89 != null) goto L484;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L484:
        if (r89.getSkuParams().isFromCartOrInsurance() == false) goto L541;
        if (r88 == null) goto L495;
        int r90 = r88.length;
        int r91 = 0;
    L487:
        if (r91 >= r90) goto L495;
        String r92 = r88[r91];
        if (r92 == null) goto L491;
        boolean r132 = true;
    L492:
        if (r132 == true) goto L496;
        r91 = r91 + 1;
    L496:
        if (r92 == null) goto L541;
        int r93 = r88.length;
        int r94 = 0;
        int r95 = 0;
    L498:
        if (r94 >= r93) goto L537;
        String r133 = r88[r94];
        int r134 = r95 + 1;
        SkuViewModel r135 = r26.f;
        if (r135 != null) goto L502;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L502:
        SkuInfoVO r136 = (SkuInfoVO) r135.getSkuInfo().a();
        if (r136 == null) goto L536;
        List<SpecInfo> r137 = r136.getSpecInfoList();
        if (r137 == null) goto L536;
        if (r137.size() <= r95) goto L509;
        boolean r138 = true;
    L510:
        if (r138 == true) goto L513;
        r137 = null;
    L513:
        if (r137 == null) goto L536;
        SpecInfo r139 = (SpecInfo) ListProtector.get(r137, r95);
        if (r139 == null) goto L536;
        r86.append(r139.getName() + ':');
        Iterator<T> r140 = r139.getSpecItems().iterator();
    L518:
        if (r140.hasNext() == false) goto L522;
        Object r141 = r140.next();
        if (Intrinsics.areEqual(((SpecInfoItem) r141).getId(), r133) == false) goto L518;
    L523:
        SpecInfoItem r142 = (SpecInfoItem) r141;
        if (r142 == null) goto L526;
        r86.append(r142.getName() + ';');
        goto L536
    L526:
        SkuViewModel r143 = r26.f;
        if (r143 != null) goto L529;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L529:
        SkuInfoVO r144 = (SkuInfoVO) r143.getSkuInfo().a();
        if (r144 == null) goto L536;
        List<SpecInfo> r145 = r144.getSpecInfoList();
        if (r145 == null) goto L536;
        SpecInfo r96 = (SpecInfo) ListProtector.get(r145, r95);
        if (r96 == null) goto L536;
        r96.getName();
        goto L536
    L522:
        r141 = null;
        goto L523
    L509:
        r138 = false;
    L536:
        r94 = r94 + 1;
        r95 = r134;
        goto L498
    L537:
        SkuViewModel r97 = r26.f;
        if (r97 != null) goto L540;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L540:
        r97.setCartSelectedDes(r86.toString());
        goto L541
    L491:
        r132 = false;
    L495:
        r92 = null;
    L541:
        SkuViewModel r98 = r26.f;
        if (r98 != null) goto L544;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L544:
        QLiveData<rg.a<String>> r99 = r98.getOnItemChange();
        SpecItemGroupLayout r100 = r26.h;
        if (r100 != null) goto L547;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L547:
        r99.g(new rg.a(r100.getCheckedId()));
        SkuViewModel r101 = r26.f;
        if (r101 != null) goto L550;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L550:
        QLiveData<CarAdaptComponent> r102 = r101.getCurrentCarAdaptComponent();
        SpecItemGroupLayout r0 = r26.h;
        if (r0 != null) goto L553;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L553:
        r102.g(r0.getCheckSkuCarAdapt());
        return;
    L467:
        Context r103 = r26.Y().c();
        Object[] r104 = new Object[1];
        SkuViewModel r105 = r26.f;
        if (r105 != null) goto L470;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L470:
        SkuInfoVO r106 = (SkuInfoVO) r105.getSkuInfo().a();
        if (r106 == null) goto L475;
        List<SpecInfo> r107 = r106.getSpecInfoList();
        if (r107 == null) goto L475;
        String r108 = CollectionsKt.joinToString$default(r107, " ", " ", null, 0, null, SelectPresenter$refreshTitleSpec$3.INSTANCE, 28, null);
    L476:
        r76.append(r108);
        r104[0] = r76.toString();
        r85 = th.a.h(r103, 2131914030, r104);
    L475:
        r108 = null;
        goto L476
    L417:
        r118 = false;
    L421:
        r117 = null;
    L398:
        r73 = null;
        goto L399
    L380:
        r65 = false;
    L400:
        SkuViewModel r109 = r26.f;
        if (r109 != null) goto L403;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L403:
        r109.getUnCheckedName().g(null);
        goto L404
    L113:
        r45 = null;
        goto L115
    L101:
        r41 = null;
    L116:
        SkuViewModel r146 = r26.f;
        if (r146 != null) goto L119;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L119:
        SkuViewModel r147 = r26.f;
        if (r147 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L122:
        SkuInfoVO r148 = (SkuInfoVO) r147.getSkuInfo().a();
        if (r148 == null) goto L125;
        Long r149 = Long.valueOf(r148.getMinPrice());
    L126:
        r146.setCurrentPriceWithDefault(jg.g.b(r149, 0));
        SkuViewModel r150 = r26.f;
        if (r150 != null) goto L129;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L129:
        SkuViewModel r151 = r26.f;
        if (r151 != null) goto L132;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L132:
        SkuInfoVO r152 = (SkuInfoVO) r151.getSkuInfo().a();
        if (r152 == null) goto L135;
        Long r153 = Long.valueOf(r152.getMarketPrice());
    L136:
        r150.setCurrentOriginPrice(jg.g.b(r153, 0));
        SkuViewModel r154 = r26.f;
        if (r154 != null) goto L139;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L139:
        SkuViewModel r155 = r26.f;
        if (r155 != null) goto L142;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L142:
        SkuInfoVO r156 = (SkuInfoVO) r155.getSkuInfo().a();
        if (r156 == null) goto L145;
        Long r157 = r156.getDiscountPrice();
    L146:
        r154.setCurrentDiscountPrice(jg.g.b(r157, 0));
        SkuViewModel r158 = r26.f;
        if (r158 != null) goto L149;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L149:
        SpecItemGroupLayout r159 = r26.h;
        if (r159 != null) goto L152;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L152:
        String r160 = r159.getCheckSkuDiscountPriceText();
        if (r160 != null) goto L155;
        r160 = "";
    L155:
        r158.setCurrentDiscountPriceText(r160);
        SkuViewModel r161 = r26.f;
        if (r161 != null) goto L158;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L158:
        SpecItemGroupLayout r162 = r26.h;
        if (r162 != null) goto L161;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L161:
        String r163 = r162.getCheckSkuCampaignPriceHeader();
        if (r163 == null) goto L165;
        r19 = r163;
    L165:
        r161.setCurrentCampainPriceHeader(r19);
        SkuViewModel r164 = r26.f;
        if (r164 != null) goto L168;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L168:
        SpecItemGroupLayout r165 = r26.h;
        if (r165 != null) goto L171;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L171:
        r164.setCurrentCampainPriceHeaderStyle(r165.getCheckSkuPriceHedaerStyle());
        SkuViewModel r166 = r26.f;
        if (r166 != null) goto L174;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L174:
        SpecItemGroupLayout r167 = r26.h;
        if (r167 != null) goto L177;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L177:
        r166.setCurrentNewBonusText(r167.getNewBonusText());
        SkuViewModel r168 = r26.f;
        if (r168 != null) goto L180;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L180:
        r168.m1028getCurrentPrice().g(Long.valueOf(r112));
        goto L339
    L145:
        r157 = null;
        goto L146
    L135:
        r153 = null;
        goto L136
    L125:
        r149 = null;
        goto L126
    L89:
        r37 = null;
        goto L91
    L181:
        SkuViewModel r169 = r26.f;
        if (r169 != null) goto L184;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L184:
        Long r170 = (Long) r169.m1028getCurrentPrice().a();
        if (r170 != null) goto L188;
    L210:
        SkuViewModel r171 = r26.f;
        if (r171 != null) goto L213;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L213:
        r171.setCurrentPriceWithDefault(r112);
        SkuViewModel r172 = r26.f;
        if (r172 != null) goto L216;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L216:
        SpecItemGroupLayout r173 = r26.h;
        if (r173 != null) goto L219;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L219:
        r172.setCurrentOriginPrice(jg.g.b(r173.getCheckSkuOriginPrice(), 0));
        SkuViewModel r174 = r26.f;
        if (r174 != null) goto L222;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L222:
        SpecItemGroupLayout r175 = r26.h;
        if (r175 != null) goto L225;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L225:
        r174.setCurrentDiscountPrice(jg.g.b(r175.getCheckSkuDiscountPrice(), 0));
        SkuViewModel r176 = r26.f;
        if (r176 != null) goto L228;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L228:
        SpecItemGroupLayout r177 = r26.h;
        if (r177 != null) goto L231;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L231:
        String r178 = r177.getCheckSkuDiscountPriceText();
        if (r178 != null) goto L234;
        r178 = "";
    L234:
        r176.setCurrentDiscountPriceText(r178);
        SkuViewModel r179 = r26.f;
        if (r179 != null) goto L237;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L237:
        SpecItemGroupLayout r180 = r26.h;
        if (r180 != null) goto L240;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L240:
        String r181 = r180.getCheckSkuCampaignPriceHeader();
        if (r181 == null) goto L244;
        r19 = r181;
    L244:
        r179.setCurrentCampainPriceHeader(r19);
        SkuViewModel r182 = r26.f;
        if (r182 != null) goto L247;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L247:
        SpecItemGroupLayout r183 = r26.h;
        if (r183 != null) goto L250;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L250:
        r182.setCurrentCampainPriceHeaderStyle(r183.getCheckSkuPriceHedaerStyle());
        SkuViewModel r184 = r26.f;
        if (r184 != null) goto L253;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L253:
        SpecItemGroupLayout r185 = r26.h;
        if (r185 != null) goto L256;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L256:
        r184.setCurrentNewBonusText(r185.getNewBonusText());
        SkuViewModel r186 = r26.f;
        if (r186 != null) goto L259;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L259:
        r186.m1028getCurrentPrice().g(Long.valueOf(r112));
        goto L339
    L188:
        if (r112 != r170.longValue()) goto L210;
        SkuViewModel r187 = r26.f;
        if (r187 != null) goto L193;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L193:
        if (r187.getCurrentPriceWithDefault() != r112) goto L210;
        SkuViewModel r188 = r26.f;
        if (r188 != null) goto L197;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L197:
        long r189 = r188.getCurrentOriginPrice();
        SpecItemGroupLayout r190 = r26.h;
        if (r190 != null) goto L201;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L201:
        if (r189 != jg.g.b(r190.getCheckSkuOriginPrice(), 0)) goto L210;
        SkuViewModel r191 = r26.f;
        if (r191 != null) goto L205;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L205:
        long r192 = r191.getCurrentDiscountPrice();
        SpecItemGroupLayout r193 = r26.h;
        if (r193 != null) goto L209;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L209:
        if (r192 == jg.g.b(r193.getCheckSkuDiscountPrice(), 0)) goto L339;
    L77:
        r112 = 0;
    L67:
        SkuViewModel r194 = r26.f;
        if (r194 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L70:
        r194.getCurrentAvatar().g(r31);
        goto L71
    L59:
        r110 = false;
        goto L60
    L260:
        SpecItemGroupLayout r195 = r26.h;
        if (r195 != null) goto L263;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L263:
        String r196 = r195.getCheckSkuImageUrl();
        SkuViewModel r197 = r26.f;
        if (r197 != null) goto L266;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L266:
        QLiveData<String> r198 = r197.getCurrentAvatar();
        if (r196 != null) goto L269;
    L274:
        r196 = null;
    L275:
        if (r196 != null) goto L277;
        r196 = "";
    L277:
        r198.g(r196);
        SpecItemGroupLayout r199 = r26.h;
        if (r199 != null) goto L280;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L280:
        Long r200 = r199.getCheckSkuPrice();
        if (r200 == null) goto L283;
        long r1100 = r200.longValue();
    L284:
        SkuViewModel r201 = r26.f;
        if (r201 != null) goto L287;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L287:
        r201.m1028getCurrentPrice().g(Long.valueOf(r1100));
        SkuViewModel r202 = r26.f;
        if (r202 != null) goto L290;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L290:
        SpecItemGroupLayout r1101 = r26.h;
        if (r1101 != null) goto L293;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L293:
        Long r1102 = r1101.getCheckSkuOriginPrice();
        if (r1102 == null) goto L296;
        long r1103 = r1102.longValue();
    L297:
        r202.setCurrentOriginPrice(r1103);
        SkuViewModel r203 = r26.f;
        if (r203 != null) goto L300;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L300:
        SpecItemGroupLayout r1104 = r26.h;
        if (r1104 != null) goto L303;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L303:
        Long r1105 = r1104.getCheckSkuDiscountPrice();
        if (r1105 == null) goto L306;
        long r1106 = r1105.longValue();
    L307:
        r203.setCurrentDiscountPrice(r1106);
        SkuViewModel r204 = r26.f;
        if (r204 != null) goto L310;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L310:
        SpecItemGroupLayout r1107 = r26.h;
        if (r1107 != null) goto L313;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L313:
        String r1108 = r1107.getCheckSkuDiscountPriceText();
        if (r1108 != null) goto L316;
        r1108 = "";
    L316:
        r204.setCurrentDiscountPriceText(r1108);
        SkuViewModel r205 = r26.f;
        if (r205 != null) goto L319;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L319:
        SpecItemGroupLayout r1109 = r26.h;
        if (r1109 != null) goto L322;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L322:
        String r1110 = r1109.getCheckSkuCampaignPriceHeader();
        if (r1110 == null) goto L326;
        r19 = r1110;
    L326:
        r205.setCurrentCampainPriceHeader(r19);
        SkuViewModel r206 = r26.f;
        if (r206 != null) goto L329;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L329:
        SpecItemGroupLayout r207 = r26.h;
        if (r207 != null) goto L332;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L332:
        r206.setCurrentCampainPriceHeaderStyle(r207.getCheckSkuPriceHedaerStyle());
        SkuViewModel r208 = r26.f;
        if (r208 != null) goto L335;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L335:
        SpecItemGroupLayout r209 = r26.h;
        if (r209 != null) goto L338;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L338:
        r208.setCurrentNewBonusText(r209.getNewBonusText());
        goto L339
    L306:
        r1106 = 0;
        goto L307
    L296:
        r1103 = 0;
        goto L297
    L283:
        r1100 = 0;
        goto L284
    L269:
        if (r196.length() <= 0) goto L271;
        boolean r1111 = true;
    L272:
        if (r1111 == false) goto L274;
    L271:
        r1111 = false;
    L38:
        r23 = new ArrayList();
    L24:
        r18 = null;
        goto L25
    }

    public final void b0(QModel r10) {
        this.f = (SkuViewModel) Y().g(SkuViewModel.class);
        i0();
        SkuViewModel r11 = this.f;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r11.getSkuInfo().b(ECQuickUtilKt.a(Y()), new c2(this));
        SkuViewModel r12 = this.f;
        if (r12 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        r12.m1027getCurrentCount().b(ECQuickUtilKt.a(Y()), new d2(this));
        SkuViewModel r13 = this.f;
        if (r13 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L11:
        r13.getSaveState().b(ECQuickUtilKt.a(Y()), new e2(this));
    }
}
