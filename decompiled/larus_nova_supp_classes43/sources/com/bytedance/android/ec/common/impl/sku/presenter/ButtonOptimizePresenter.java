package com.bytedance.android.ec.common.impl.sku.presenter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService;
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.log.SkuLog;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuItemInfoVO;
import com.bytedance.android.ec.common.impl.sku.utils.ActivityCountDownTimer;
import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.data.ActionObserver;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.monitor.listener.ActionRateListener;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.model.ECAdInfo;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.api.LogPbData;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.ec.model.sku.ButtonTipComponent;
import com.bytedance.android.ec.model.sku.ButtonUIParam;
import com.bytedance.android.ec.model.sku.GradientInfo;
import com.bytedance.android.ec.model.sku.HighLightItem;
import com.bytedance.android.ec.model.sku.ImageObject;
import com.bytedance.android.ec.model.sku.OrderComponent;
import com.bytedance.android.ec.model.sku.Position;
import com.bytedance.android.ec.model.sku.SkuBottomButtons;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.model.sku.SkuPoiInfo;
import com.bytedance.android.ec.model.sku.TradeModeSelection;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.data.api.ChainPoint;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ButtonOptimizePresenter extends QFragmentPresenter {
    public SkuViewModel f;
    public boolean g;
    public Long h;
    public boolean i;
    public boolean j;
    public long k;
    public GradientDrawable l;
    public String m;
    public long n;
    public final Lazy o;
    public final Lazy p;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.ec.core.utils.l1.a {
        public final /* synthetic */ ButtonOptimizePresenter a;

        @Override // com.bytedance.android.ec.core.utils.l1.a
        public final void onStart() {
        }

        @Override // com.bytedance.android.ec.core.utils.l1.a
        public final void onFinish() {
            Long r0 = this.a.h;
            if (r0 != null) goto L6;
        L8:
            Long r1 = this.a.h;
            if (r1 != null) goto L12;
            return;
        L12:
            if (r1.longValue() != 7) goto L21;
            TextView r10 = (TextView) this.a.Z().b(2131391440).f();
            if (ButtonOptimizePresenter.e0(this.a).getSkuParams().getAddShopCart() == false) goto L16;
        L18:
            ((LinearLayout) this.a.Z().b(2131378868).f()).setVisibility(8);
            return;
        L16:
            if (ButtonOptimizePresenter.e0(this.a).getSkuParams().isFromCartOrInsurance() == true) goto L18;
            r10.setText(th.a.g(this.a.Y().c(), 2131913821));
            goto L18
        L21:
            return;
        L6:
            if (r0.longValue() != 10) goto L8;
            TextView r11 = (TextView) this.a.Z().b(2131378863).f();
            r11.setOnClickListener(null);
            r11.setEnabled(false);
            r11.setAlpha(0.34f);
            LinearLayout r12 = (LinearLayout) this.a.Z().b(2131378867).f();
            r12.setOnClickListener(null);
            r12.setAlpha(0.34f);
            TextView r13 = (TextView) this.a.Z().b(2131391442).f();
            r13.setVisibility(0);
            r13.setText(th.a.g(this.a.Y().c(), 2131914056));
            this.a.Z().b(2131391443).f().setVisibility(8);
            this.a.Z().b(2131391444).f().setVisibility(8);
        }

        public b(ButtonOptimizePresenter r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.ec.core.utils.l1.a
        public final void onTick(long r14) {
            int r0 = com.bytedance.android.ec.core.utils.c2.h;
            com.bytedance.android.ec.core.utils.c2 r15 = com.bytedance.android.ec.core.utils.c2.a.a(this.a.Y().c(), r14, false);
            Long r16 = this.a.h;
            if (r16 != null) goto L6;
        L11:
            Long r17 = this.a.h;
            if (r17 != null) goto L15;
            return;
        L15:
            if (r17.longValue() != 7) goto L20;
            TextView r18 = (TextView) this.a.Z().b(2131391442).f();
            r18.setVisibility(0);
            r18.setText("距活动结束");
            TextView r19 = (TextView) this.a.Z().b(2131391443).f();
            r19.setVisibility(0);
            r19.setText(th.a.h(this.a.Y().c(), 2131914004, new Object[]{r15.c, r15.d, r15.e}));
            this.a.Z().b(2131391444).f().setVisibility(8);
            return;
        L20:
            return;
        L6:
            if (r16.longValue() != 10) goto L11;
            if (r15.a <= 0) goto L10;
            TextView r110 = (TextView) this.a.Z().b(2131391442).f();
            r110.setVisibility(0);
            StringBuilder r1 = new StringBuilder();
            r1.append(r15.a);
            r1.append(22825);
            r110.setText(r1.toString());
            TextView r111 = (TextView) this.a.Z().b(2131391443).f();
            r111.setVisibility(0);
            r111.setText(th.a.h(this.a.Y().c(), 2131914004, new Object[]{r15.c, r15.d, r15.e}));
            TextView r112 = (TextView) this.a.Z().b(2131391444).f();
            r112.setVisibility(0);
            r112.setText("后结束");
            return;
        L10:
            TextView r113 = (TextView) this.a.Z().b(2131391442).f();
            r113.setVisibility(0);
            r113.setText(th.a.h(this.a.Y().c(), 2131914004, new Object[]{r15.c, r15.d, r15.e}));
            TextView r114 = (TextView) this.a.Z().b(2131391443).f();
            r114.setVisibility(0);
            r114.setText("后结束");
            this.a.Z().b(2131391444).f().setVisibility(8);
        }
    }

    static {
    }

    public final Pair<String, String>[] i0() {
        Pair<String, String>[] r0 = new Pair[5];
        SkuViewModel r1 = this.f;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuInfoVO r10 = (SkuInfoVO) r1.getSkuInfo().a();
        String r11 = null;
        if (r10 == null) goto L8;
        Long r12 = Long.valueOf(r10.getMinPrice());
    L9:
        r0[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_EFFECTIVE_MIN_PRICE, String.valueOf(r12));
        SkuViewModel r13 = this.f;
        if (r13 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L12:
        SkuInfoVO r14 = (SkuInfoVO) r13.getSkuInfo().a();
        if (r14 == null) goto L15;
        Long r15 = r14.getDiscountPrice();
    L16:
        r0[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_DISCOUNT_MIN_PRICE, String.valueOf(r15));
        SkuViewModel r16 = this.f;
        if (r16 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L19:
        SkuInfoVO r17 = (SkuInfoVO) r16.getSkuInfo().a();
        if (r17 == null) goto L22;
        Long r18 = Long.valueOf(r17.getMarketPrice());
    L23:
        r0[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_REGULAR_PRICE, String.valueOf(r18));
        SkuViewModel r19 = this.f;
        if (r19 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L26:
        SkuInfoVO r20 = (SkuInfoVO) r19.getSkuInfo().a();
        if (r20 == null) goto L31;
        LogPbData r21 = r20.getLogPb();
        if (r21 == null) goto L31;
        r11 = r21.getImprId();
    L31:
        r0[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_LOG_ID, r11);
        SkuViewModel r22 = this.f;
        if (r22 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L34:
        r0[4] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SKU_ID, r22.getSelectedSkuId());
        return r0;
    L22:
        r18 = null;
        goto L23
    L15:
        r15 = null;
        goto L16
    L8:
        r12 = null;
        goto L9
    }

    public final void c0() {
        Lazy r0 = ActivityCountDownTimer.c;
        ActivityCountDownTimer.a.a().b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void r0() {
        SkuViewModel r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r0.getCurrentPrice();
        SkuViewModel r1 = this.f;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        SkuInfoVO r10 = (SkuInfoVO) r1.getSkuInfo().a();
        SkuViewModel r11 = this.f;
        if (r11 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L11:
        rg.a r12 = (rg.a) r11.getOnItemChange().a();
        List<SkuBottomButtons> r13 = null;
        if (r12 == null) goto L14;
        String r14 = (String) r12.b;
    L15:
        if (r10 == null) goto L19;
        Map<String, SkuItemInfoVO> r15 = r10.getSkuList();
        if (r15 == null) goto L19;
        SkuItemInfoVO r16 = r15.get(r14);
    L20:
        int r17 = 0;
        if (r16 == null) goto L34;
        List<SkuBottomButtons> r18 = r16.getButtons();
        if (r18 == null) goto L34;
        Iterator<T> r19 = r18.iterator();
    L26:
        if (r19.hasNext() == false) goto L30;
        Object r20 = r19.next();
        if (((SkuBottomButtons) r20).getHideCountDown() == false) goto L26;
    L31:
        SkuBottomButtons r21 = (SkuBottomButtons) r20;
        if (r21 == null) goto L34;
        boolean r22 = r21.getHideCountDown();
    L36:
        if (r16 == null) goto L38;
        this.h = r16.getSkuType();
        this.i = r16.isInDepositPresale();
        this.j = r16.isInSecKill();
        this.k = r16.getCampaignEndTime();
    L59:
        if (this.i == true) goto L66;
        Long r23 = this.h;
        if (r23 == null) goto L66;
        if (r23.longValue() != 10) goto L66;
        ((LinearLayout) Z().b(2131378867).f()).setOnClickListener(null);
        ((TextView) Z().b(2131378863).f()).setOnClickListener(null);
    L67:
        SkuViewModel r24 = this.f;
        if (r24 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L70:
        SkuInfoVO r25 = (SkuInfoVO) r24.getSkuInfo().a();
        if (r25 == null) goto L85;
        List<SkuBottomButtons> r26 = r25.getDefaultButtons();
        if (r26 == null) goto L85;
        Iterator<T> r27 = r26.iterator();
    L76:
        if (r27.hasNext() == false) goto L83;
        Object r28 = r27.next();
        if (((SkuBottomButtons) r28).getButtonType() != 1) goto L80;
        boolean r110 = true;
    L81:
        if (r110 == false) goto L76;
    L84:
        SkuBottomButtons r29 = (SkuBottomButtons) r28;
    L86:
        if (r29 == null) goto L88;
        boolean r30 = true;
    L89:
        if (r30 == false) goto L133;
        if (r10 == null) goto L111;
        Map<String, SkuItemInfoVO> r31 = r10.getSkuList();
        if (r31 == null) goto L111;
        SkuItemInfoVO r32 = r31.get(r14);
        if (r32 == null) goto L111;
        List<SkuBottomButtons> r33 = r32.getButtons();
        if (r33 == null) goto L111;
        Iterator<T> r34 = r33.iterator();
    L99:
        if (r34.hasNext() == false) goto L106;
        Object r35 = r34.next();
        if (((SkuBottomButtons) r35).getButtonType() != 1) goto L103;
        boolean r111 = true;
    L104:
        if (r111 == false) goto L99;
    L107:
        SkuBottomButtons r36 = (SkuBottomButtons) r35;
        if (r36 == null) goto L111;
        String r37 = r36.getText();
        if (r37 == null) goto L111;
    L128:
        if (r37 != null) goto L132;
        if (r10 == null) goto L131;
        r37 = r10.getButtonLabel();
        goto L132
    L131:
        r37 = null;
    L132:
        ((TextView) Z().b(2131391440).f()).setText(r37);
        goto L133
    L103:
        r111 = false;
        goto L104
    L106:
        r35 = null;
    L111:
        if (r10 == null) goto L127;
        List<SkuBottomButtons> r38 = r10.getDefaultButtons();
        if (r38 == null) goto L127;
        Iterator<T> r39 = r38.iterator();
    L116:
        if (r39.hasNext() == false) goto L123;
        Object r40 = r39.next();
        if (((SkuBottomButtons) r40).getButtonType() != 1) goto L120;
        boolean r112 = true;
    L121:
        if (r112 == false) goto L116;
    L124:
        SkuBottomButtons r41 = (SkuBottomButtons) r40;
        if (r41 == null) goto L127;
        r37 = r41.getText();
        goto L128
    L120:
        r112 = false;
        goto L121
    L123:
        r40 = null;
    L127:
        r37 = null;
    L133:
        SkuViewModel r42 = this.f;
        if (r42 != null) goto L136;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L136:
        Integer r43 = (Integer) r42.getCurrentTradeModeIndex().a();
        if (r43 == null) goto L139;
        r17 = r43.intValue();
    L139:
        if (r17 <= 0) goto L152;
        if (r16 == null) goto L142;
        Boolean r44 = r16.getHideTradeIn();
    L144:
        if ((!Intrinsics.areEqual(r44, Boolean.TRUE)) == false) goto L152;
        SkuViewModel r45 = this.f;
        if (r45 != null) goto L148;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L148:
        TradeModeSelection r46 = (TradeModeSelection) r45.getCurrentTradeModeItem().a();
        if (r46 == null) goto L151;
        r13 = r46.getSkuBottomButtons();
    L151:
        l0(r13);
    L164:
        SkuViewModel r47 = this.f;
        if (r47 != null) goto L167;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L167:
        r47.updateButtonTip(new ButtonOptimizePresenter$updateButton$5(this));
        if (r22 == false) goto L171;
        ((LinearLayout) Z().b(2131378868).f()).setVisibility(8);
        return;
    L171:
        if (this.i == false) goto L176;
        if (this.g == true) goto L176;
        m0();
        return;
    L176:
        if (this.j == true) goto L178;
    L182:
        ((LinearLayout) Z().b(2131378868).f()).setVisibility(8);
        return;
    L178:
        if (this.g == true) goto L182;
        if (((this.k - SystemClock.elapsedRealtime()) / 1000) > 86400) goto L204;
        m0();
        return;
    L204:
        return;
    L142:
        r44 = null;
    L152:
        if (r10 == null) goto L161;
        Map<String, SkuItemInfoVO> r48 = r10.getSkuList();
        if (r48 == null) goto L161;
        SkuItemInfoVO r49 = r48.get(r14);
        if (r49 == null) goto L161;
        List<SkuBottomButtons> r50 = r49.getButtons();
        if (r50 == null) goto L161;
        r13 = r50;
    L163:
        l0(r13);
    L161:
        if (r10 == null) goto L163;
        r13 = r10.getDefaultButtons();
        goto L163
    L88:
        r30 = false;
        goto L89
    L80:
        r110 = false;
        goto L81
    L83:
        r28 = null;
    L85:
        r29 = null;
    L66:
        ((LinearLayout) Z().b(2131378867).f()).setOnClickListener((ButtonOptimizePresenter$newClick$2.a) this.o.getValue());
        ((TextView) Z().b(2131378863).f()).setOnClickListener((ButtonOptimizePresenter$newClick$2.a) this.o.getValue());
        goto L67
    L38:
        if (r10 == null) goto L40;
        Long r51 = r10.getSkuType();
    L41:
        this.h = r51;
        if (r10 != null) goto L44;
    L46:
        boolean r52 = false;
    L47:
        this.i = r52;
        if (r10 != null) goto L50;
    L52:
        boolean r53 = false;
    L53:
        this.j = r53;
        if (r10 == null) goto L56;
        long r54 = r10.getCampaignEndTime();
    L57:
        this.k = r54;
        goto L59
    L56:
        r54 = 0;
        goto L57
    L50:
        if (r10.isInSecKillDefault() != true) goto L52;
        r53 = true;
        goto L53
    L44:
        if (r10.isInDepositPresaleDefault() != true) goto L46;
        r52 = true;
        goto L47
    L40:
        r51 = null;
        goto L41
    L30:
        r20 = null;
    L34:
        r22 = false;
    L19:
        r16 = null;
        goto L20
    L14:
        r14 = null;
        goto L15
    }

    public final void m0() {
        ((LinearLayout) Z().b(2131378868).f()).setVisibility(0);
        Lazy r0 = ActivityCountDownTimer.c;
        ActivityCountDownTimer.a.a().b();
        ActivityCountDownTimer.a.a().a(SystemClock.elapsedRealtime() / 1000, this.k / 1000, new b(this));
    }

    public ButtonOptimizePresenter(final Fragment r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        super(r10);
        this.o = LazyKt.lazy(new ButtonOptimizePresenter$newClick$2(this, r10));
        this.p = LazyKt.lazy(new ButtonOptimizePresenter$tipsClick$2(this, r10));
    }

    public static final /* synthetic */ SkuViewModel e0(ButtonOptimizePresenter r1) {
        SkuViewModel r10 = r1.f;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        return r10;
    }

    public final void b0(QModel r12) {
        SkuViewModel r13 = (SkuViewModel) Y().g(SkuViewModel.class);
        this.f = r13;
        if (r13 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        boolean r1 = false;
        if (r13.getSkuParams().getAddShopCart() == true) goto L24;
        SkuViewModel r14 = this.f;
        if (r14 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L11:
        if (r14.getSkuParams().isFromCartOrInsurance() == true) goto L24;
        SkuViewModel r15 = this.f;
        if (r15 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L16:
        if (r15.getSkuParams().isFromMixPage() == true) goto L24;
        SkuViewModel r16 = this.f;
        if (r16 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L21:
        if (r16.getSkuParams().isFromHomePageOneCent() == true) goto L24;
        boolean r17 = false;
    L25:
        this.g = r17;
        SkuViewModel r18 = this.f;
        if (r18 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L29:
        if (r18.getSkuParams().isFromSuperMarket() == true) goto L59;
        SkuViewModel r19 = this.f;
        if (r19 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L34:
        if (r19.getSkuParams().getAddShopCart() == true) goto L59;
        SkuViewModel r110 = this.f;
        if (r110 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L39:
        if (r110.getSkuParams().isFromMixPage() == true) goto L59;
        SkuViewModel r111 = this.f;
        if (r111 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L44:
        if (r111.getSkuParams().isFromShopCart() == true) goto L59;
        SkuViewModel r112 = this.f;
        if (r112 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L50:
        if (r112.getSkuParams().isFromInsuranceApply() == true) goto L58;
        SkuViewModel r113 = this.f;
        if (r113 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L55:
        if (r113.getSkuParams().isFromMatchPurchase() == true) goto L58;
        String r114 = th.a.g(Y().c(), 2131913821);
    L60:
        ((TextView) Z().b(2131391440).f()).setText(r114);
        SkuViewModel r115 = this.f;
        if (r115 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L64:
        if (r115.getSkuParams().getActionType() != 4) goto L66;
        ((TextView) Z().b(2131378863).f()).setVisibility(0);
    L67:
        SkuViewModel r116 = this.f;
        if (r116 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L71:
        if (r116.getSkuParams().getAddShopCart() == false) goto L79;
        SkuViewModel r10 = this.f;
        if (r10 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L75:
        Pair[] r11 = new Pair[1];
        SkuViewModel r117 = this.f;
        if (r117 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L78:
        r11[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r117.getSkuParams().getAddCartEntranceInfo());
        SkuViewModel.doSkuEventAction$default(r10, "show_add_to_cart", r11, "a1.b5267.c7323.d1871", PageFinder.via(((QFragmentPresenter) this).e), null, 16, null);
    L79:
        ((LinearLayout) Z().b(2131378867).f()).setOnTouchListener(new l(this));
        SkuViewModel r118 = this.f;
        if (r118 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L83:
        if (r118.getSkuParams().getUsePrerenderSku() == false) goto L95;
        SkuViewModel r119 = this.f;
        if (r119 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L88:
        if (r119.getSkuParams().getSkuPrerenderId().length() <= 0) goto L90;
        r1 = true;
    L90:
        if (r1 == false) goto L95;
        SkuViewModel r120 = this.f;
        if (r120 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L94:
        r120.getCancelDownTimer().b(ECQuickUtilKt.a(Y()), e.a);
    L95:
        SkuViewModel r121 = this.f;
        if (r121 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L98:
        r121.getCurrentButtonTip().b(ECQuickUtilKt.a(Y()), new f(this));
        SkuViewModel r122 = this.f;
        if (r122 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L101:
        r122.m1027getCurrentCount().b(ECQuickUtilKt.a(Y()), new g(this));
        SkuViewModel r123 = this.f;
        if (r123 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L104:
        r123.m1028getCurrentPrice().b(ECQuickUtilKt.a(Y()), new h(this));
        SkuViewModel r124 = this.f;
        if (r124 != null) goto L107;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L107:
        r124.getSkuInfo().b(ECQuickUtilKt.a(Y()), new i(this));
        SkuViewModel r125 = this.f;
        if (r125 != null) goto L110;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L110:
        r125.getApplyCouponSuccess().b(ECQuickUtilKt.a(Y()), new ActionObserver(new ButtonOptimizePresenter$initSubscribe$6(this)));
        SkuViewModel r126 = this.f;
        if (r126 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L113:
        r126.getDoAddCartMotionAction().b(ECQuickUtilKt.a(Y()), new ActionObserver(new ButtonOptimizePresenter$initSubscribe$7(this)));
        SkuViewModel r127 = this.f;
        if (r127 != null) goto L116;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L116:
        r127.getUnCheckedName().b(ECQuickUtilKt.a(Y()), new j(this));
        SkuViewModel r128 = this.f;
        if (r128 != null) goto L119;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L119:
        r128.getCurrentTradeModeItem().b(ECQuickUtilKt.a(Y()), new k(this));
        return;
    L66:
        ((TextView) Z().b(2131378863).f()).setVisibility(8);
    L58:
        r114 = th.a.g(Y().c(), 2131913838);
    L59:
        r114 = th.a.g(Y().c(), 2131913778);
    L24:
        r17 = true;
        goto L25
    }

    public final void l0(List<SkuBottomButtons> r15) {
        if (r15 == null) goto L72;
        Iterator<T> r0 = r15.iterator();
    L5:
        if (r0.hasNext() == false) goto L99;
        SkuBottomButtons r1 = (SkuBottomButtons) r0.next();
        boolean r11 = true;
        if (r15.size() == 1) goto L8;
        if (r1.getButtonType() == 2) goto L67;
        if (r1.getButtonType() == 5) goto L67;
        if (r1.getButtonType() == 1) goto L44;
        if (r1.getButtonType() == 3) goto L44;
        if (r1.getButtonType() == 6) goto L44;
        if (r1.getButtonType() != 7) goto L5;
    L44:
        Z().b(2131366897).f().setVisibility(0);
        ((TextView) Z().b(2131391440).f()).setText(r1.getText());
        ((LinearLayout) Z().b(2131378867).f()).setEnabled(!r1.isGray());
        if (r1.isGray() == false) goto L47;
        ((LinearLayout) Z().b(2131378867).f()).setAlpha(0.34f);
    L48:
        ((LinearLayout) Z().b(2131378867).f()).setTag(Integer.valueOf(r1.getButtonType()));
        ButtonUIParam r10 = r1.getDisplayStatus();
        if (r10 == null) goto L53;
        GradientInfo r12 = r10.getGradientInfo();
        if (r12 == null) goto L53;
        this.l = p0(r12, r15.size());
        ((LinearLayout) Z().b(2131378867).f()).setBackgroundDrawable(this.l);
    L53:
        SimpleDraweeView r13 = Z().b(2131385281).f();
        ImageObject r14 = r1.getIcon();
        if (r14 == null) goto L66;
        List r16 = r14.getUrlList();
        if (r16 == null) goto L66;
        String r17 = (String) CollectionsKt.firstOrNull(r16);
        if (r17 == null) goto L66;
        if (r17.length() > 0) goto L63;
        r11 = false;
    L63:
        if (r11 == true) goto L64;
        r13.setVisibility(8);
        goto L5
    L64:
        r13.setVisibility(0);
        r13.setImageURI(r17);
    L66:
        r13.setVisibility(8);
        goto L5
    L47:
        ((LinearLayout) Z().b(2131378867).f()).setAlpha(1.0f);
    L67:
        ((TextView) Z().b(2131378863).f()).setVisibility(0);
        ((TextView) Z().b(2131378863).f()).setText(r1.getText());
        ((TextView) Z().b(2131378863).f()).setEnabled(!r1.isGray());
        if (r1.isGray() == false) goto L70;
        ((TextView) Z().b(2131378863).f()).setAlpha(0.34f);
    L71:
        ((TextView) Z().b(2131378863).f()).setTag(Integer.valueOf(r1.getButtonType()));
        goto L5
    L70:
        ((TextView) Z().b(2131378863).f()).setAlpha(1.0f);
        goto L71
    L8:
        Z().b(2131366897).f().setVisibility(0);
        ((TextView) Z().b(2131391440).f()).setText(r1.getText());
        ((LinearLayout) Z().b(2131378867).f()).setEnabled(!r1.isGray());
        ((LinearLayout) Z().b(2131378867).f()).setTag(Integer.valueOf(r1.getButtonType()));
        ((TextView) Z().b(2131378863).f()).setVisibility(8);
        SimpleDraweeView r18 = Z().b(2131385281).f();
        ImageObject r19 = r1.getIcon();
        if (r19 == null) goto L21;
        List r20 = r19.getUrlList();
        if (r20 == null) goto L21;
        String r21 = (String) CollectionsKt.firstOrNull(r20);
        if (r21 == null) goto L21;
        if (r21.length() > 0) goto L18;
        r11 = false;
    L18:
        if (r11 == false) goto L20;
        r18.setVisibility(0);
        r18.setImageURI(r21);
    L22:
        ButtonUIParam r22 = r1.getDisplayStatus();
        if (r22 == null) goto L28;
        GradientInfo r23 = r22.getGradientInfo();
        if (r23 == null) goto L28;
        this.l = p0(r23, r15.size());
        ((LinearLayout) Z().b(2131378867).f()).setBackgroundDrawable(this.l);
    L28:
        if (r1.isGray() == true) goto L29;
        ((LinearLayout) Z().b(2131378867).f()).setAlpha(1.0f);
        goto L5
    L29:
        ((LinearLayout) Z().b(2131378867).f()).setAlpha(0.34f);
        goto L5
    L20:
        r18.setVisibility(8);
    L21:
        r18.setVisibility(8);
        goto L22
    L99:
        return;
    }

    public final void o0(String r13) {
        SkuViewModel r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        ECAdLogExtra r1 = r0.getSkuParams().getAdLogExtra();
        String r10 = null;
        if (r1 == null) goto L9;
        String r11 = r1.getCreativeId();
        if (r11 == null) goto L9;
    L19:
        String r12 = r11;
    L21:
        if (r12 != null) goto L23;
        return;
    L23:
        int r14 = ECSdk.a;
        s83.g r15 = (s83.g) ECSdk.a(s83.g.class);
        SkuViewModel r16 = this.f;
        if (r16 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L26:
        ECAdLogExtra r17 = r16.getSkuParams().getAdLogExtra();
        if (r17 == null) goto L30;
        String r18 = r17.getLogExtra();
        if (r18 == null) goto L30;
    L40:
        String r19 = r18;
    L42:
        Pair[] r20 = new Pair[6];
        SkuViewModel r21 = this.f;
        if (r21 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L45:
        String r22 = r21.getSkuParams().getSourcePage();
        String r23 = "";
        if (r22 != null) goto L48;
        r22 = "";
    L48:
        r20[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTER_FROM, r22);
        SkuViewModel r24 = this.f;
        if (r24 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L51:
        String r25 = r24.getSkuParams().getShopId();
        if (r25 != null) goto L54;
        r25 = "";
    L54:
        r20[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, r25);
        SkuViewModel r26 = this.f;
        if (r26 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L57:
        String r27 = r26.getSkuParams().getProductId();
        if (r27 != null) goto L60;
        r27 = "";
    L60:
        r20[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_ID, r27);
        SkuViewModel r28 = this.f;
        if (r28 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L63:
        String r29 = r28.getSkuParams().getRoomId();
        if (r29 != null) goto L66;
        r29 = "";
    L66:
        r20[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ROOM_ID, r29);
        SkuViewModel r30 = this.f;
        if (r30 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L69:
        String r31 = r30.getSkuParams().getEntranceInfo();
        if (r31 == null) goto L74;
        JSONObject r32 = jg.g.f(r31);
        if (r32 == null) goto L74;
        String r33 = r32.optString(com.bytedance.android.ec.core.event.a.KEY_SEARCH_ID);
    L75:
        if (r33 != null) goto L77;
        r33 = "";
    L77:
        r20[4] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SEARCH_ID, r33);
        SkuViewModel r34 = this.f;
        if (r34 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L80:
        String r35 = r34.getSkuParams().getEntranceInfo();
        if (r35 == null) goto L85;
        JSONObject r36 = jg.g.f(r35);
        if (r36 == null) goto L85;
        r10 = r36.optString("search_keyword");
    L85:
        if (r10 == null) goto L88;
        r23 = r10;
    L88:
        r20[5] = TuplesKt.to("search_keyword", r23);
        Map r37 = MapsKt.mutableMapOf(r20);
        int r38 = r13.hashCode();
        if (r38 == 97926) goto L99;
        if (r38 == 3046176) goto L94;
        return;
    L94:
        if (r13.equals("cart") == true) goto L96;
        return;
    L96:
        if (r15 == null) goto L105;
        r15.d("product_detail_ad", "add_to_cart", com.bytedance.android.ec.core.event.a.VALUE_CLICK_AREA_BUTTON, r12, r19, r37, null, null);
        return;
    L105:
        return;
    L99:
        if (r13.equals("buy") == false) goto L107;
        r37.put("position", "spu_faceplate");
        if (r15 == null) goto L108;
        r15.d("product_detail_ad", "click_buy_right_now", com.bytedance.android.ec.core.event.a.VALUE_CLICK_AREA_BUTTON, r12, r19, r37, null, null);
        return;
    L108:
        return;
    L107:
        return;
    L74:
        r33 = null;
    L30:
        SkuViewModel r39 = this.f;
        if (r39 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L33:
        SkuParams r40 = r39.getSkuParams();
        if (r40 == null) goto L41;
        String r41 = r40.getEntranceInfo();
        if (r41 == null) goto L41;
        JSONObject r42 = jg.g.f(r41);
        if (r42 == null) goto L41;
        r18 = r42.optString(com.bytedance.android.ec.core.event.a.KEY_LOG_EXTRA);
    L41:
        r19 = null;
    L9:
        SkuViewModel r43 = this.f;
        if (r43 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L12:
        SkuParams r44 = r43.getSkuParams();
        if (r44 == null) goto L20;
        String r45 = r44.getEntranceInfo();
        if (r45 == null) goto L20;
        JSONObject r46 = jg.g.f(r45);
        if (r46 == null) goto L20;
        r11 = r46.optString(com.bytedance.android.ec.core.event.a.KEY_CREATIVE_ID);
    L20:
        r12 = null;
        goto L21
    }

    public final void q0(String r36) {
        SkuViewModel r10 = this.f;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuParams r11 = r10.getSkuParams();
        String r12 = r11.getEntranceInfo();
        String r13 = "";
        if (r12 != null) goto L152;
    L10:
        String r14 = "";
    L11:
        String r15 = (String) r11.getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE);
        if (r11.isFromMatchPurchase() == false) goto L14;
        Object r16 = "1";
    L16:
        if (Intrinsics.areEqual(r15, com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_FLOW_PAGE) == false) goto L86;
        if (r11.isFromPlayback() == false) goto L86;
        if (Intrinsics.areEqual(r13, "product_ranking_homepage") == false) goto L53;
        SkuViewModel r17 = this.f;
        if (r17 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L24:
        SpreadBuilder r18 = new SpreadBuilder(14);
        SkuViewModel r19 = this.f;
        if (r19 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L27:
        r18.add(TuplesKt.to("coupon_id", r19.getApplyCouponIds()));
        SkuViewModel r110 = this.f;
        if (r110 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L30:
        r18.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r110.getComboId()));
        r18.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE, r15));
        r18.add(TuplesKt.to("product_detail_reply", "1"));
        r18.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PREVIOUS_PAGE, r14));
        r18.add(TuplesKt.to("is_matching_product", r16));
        SkuViewModel r20 = this.f;
        if (r20 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L33:
        r18.add(TuplesKt.to("recommend_fxh_method", r20.getRecommendTermCount()));
        SkuViewModel r1 = this.f;
        if (r1 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L36:
        r18.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD_LIST, ArraysKt.joinToString$default(CollectionsKt.toIntArray(r1.getTermCountList()), ",", null, null, 0, null, null, 62, null)));
        SkuViewModel r21 = this.f;
        if (r21 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L39:
        r18.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD, r21.getSelectFxhMethod()));
        r18.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BUTTON_STATUS, r36));
        SkuViewModel r22 = this.f;
        if (r22 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L43:
        if (r22.getSelectTradeIn() == false) goto L45;
        Object r111 = "1";
    L46:
        r18.add(TuplesKt.to("select_trade_in", r111));
        SkuViewModel r23 = this.f;
        if (r23 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L49:
        r18.add(TuplesKt.to("trade_benefit_id", r23.getTradeBenefitId()));
        SkuViewModel r24 = this.f;
        if (r24 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L52:
        r18.add(TuplesKt.to("trade_benefit_text", r24.getTradeBenefitText()));
        r18.addSpread(i0());
        SkuViewModel.doSkuEventAction$default(r17, "confirm_product_params", (Pair[]) r18.toArray(new Pair[r18.size()]), "a1.b5267.c7323.d7439", PageFinder.via(((QFragmentPresenter) this).e), null, 16, null);
        return;
    L45:
        r111 = "0";
        goto L46
    L53:
        SkuViewModel r25 = this.f;
        if (r25 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L56:
        SpreadBuilder r26 = new SpreadBuilder(13);
        SkuViewModel r27 = this.f;
        if (r27 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L59:
        r26.add(TuplesKt.to("coupon_id", r27.getApplyCouponIds()));
        SkuViewModel r28 = this.f;
        if (r28 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L62:
        r26.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r28.getComboId()));
        r26.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE, r15));
        r26.add(TuplesKt.to("product_detail_reply", "1"));
        r26.add(TuplesKt.to("is_matching_product", r16));
        r26.addSpread(i0());
        SkuViewModel r29 = this.f;
        if (r29 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L65:
        r26.add(TuplesKt.to("recommend_fxh_method", r29.getRecommendTermCount()));
        SkuViewModel r30 = this.f;
        if (r30 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L68:
        r26.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD_LIST, ArraysKt.joinToString$default(CollectionsKt.toIntArray(r30.getTermCountList()), ",", null, null, 0, null, null, 62, null)));
        r26.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BUTTON_STATUS, r36));
        SkuViewModel r31 = this.f;
        if (r31 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L71:
        r26.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD, r31.getSelectFxhMethod()));
        SkuViewModel r32 = this.f;
        if (r32 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L75:
        if (r32.getSelectTradeIn() == false) goto L77;
        Object r112 = "1";
    L78:
        r26.add(TuplesKt.to("select_trade_in", r112));
        SkuViewModel r33 = this.f;
        if (r33 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L81:
        r26.add(TuplesKt.to("trade_benefit_id", r33.getTradeBenefitId()));
        SkuViewModel r34 = this.f;
        if (r34 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L84:
        r26.add(TuplesKt.to("trade_benefit_text", r34.getTradeBenefitText()));
        SkuViewModel.doSkuEventAction$default(r25, "confirm_product_params", (Pair[]) r26.toArray(new Pair[r26.size()]), "a1.b5267.c7323.d7439", PageFinder.via(((QFragmentPresenter) this).e), null, 16, null);
        return;
    L77:
        r112 = "0";
    L86:
        if (Intrinsics.areEqual(r13, "product_ranking_homepage") == false) goto L119;
        SkuViewModel r35 = this.f;
        if (r35 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L90:
        SpreadBuilder r113 = new SpreadBuilder(12);
        SkuViewModel r37 = this.f;
        if (r37 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L93:
        r113.add(TuplesKt.to("coupon_id", r37.getApplyCouponIds()));
        SkuViewModel r38 = this.f;
        if (r38 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L96:
        r113.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r38.getComboId()));
        r113.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PREVIOUS_PAGE, r14));
        r113.add(TuplesKt.to("is_matching_product", r16));
        r113.addSpread(i0());
        SkuViewModel r39 = this.f;
        if (r39 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L99:
        r113.add(TuplesKt.to("recommend_fxh_method", r39.getRecommendTermCount()));
        SkuViewModel r40 = this.f;
        if (r40 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L102:
        r113.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD_LIST, ArraysKt.joinToString$default(CollectionsKt.toIntArray(r40.getTermCountList()), ",", null, null, 0, null, null, 62, null)));
        r113.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BUTTON_STATUS, r36));
        SkuViewModel r41 = this.f;
        if (r41 != null) goto L105;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L105:
        r113.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD, r41.getSelectFxhMethod()));
        SkuViewModel r42 = this.f;
        if (r42 != null) goto L109;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L109:
        if (r42.getSelectTradeIn() == false) goto L111;
        Object r114 = "1";
    L112:
        r113.add(TuplesKt.to("select_trade_in", r114));
        SkuViewModel r43 = this.f;
        if (r43 != null) goto L115;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L115:
        r113.add(TuplesKt.to("trade_benefit_id", r43.getTradeBenefitId()));
        SkuViewModel r44 = this.f;
        if (r44 != null) goto L118;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L118:
        r113.add(TuplesKt.to("trade_benefit_text", r44.getTradeBenefitText()));
        SkuViewModel.doSkuEventAction$default(r35, "confirm_product_params", (Pair[]) r113.toArray(new Pair[r113.size()]), "a1.b5267.c7323.d7439", PageFinder.via(((QFragmentPresenter) this).e), null, 16, null);
        return;
    L111:
        r114 = "0";
        goto L112
    L119:
        SkuViewModel r45 = this.f;
        if (r45 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L122:
        SpreadBuilder r115 = new SpreadBuilder(11);
        SkuViewModel r46 = this.f;
        if (r46 != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L125:
        r115.add(TuplesKt.to("coupon_id", r46.getApplyCouponIds()));
        SkuViewModel r47 = this.f;
        if (r47 != null) goto L128;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L128:
        r115.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r47.getComboId()));
        r115.add(TuplesKt.to("is_matching_product", r16));
        r115.addSpread(i0());
        SkuViewModel r48 = this.f;
        if (r48 != null) goto L131;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L131:
        r115.add(TuplesKt.to("recommend_fxh_method", r48.getRecommendTermCount()));
        SkuViewModel r49 = this.f;
        if (r49 != null) goto L134;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L134:
        r115.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD_LIST, ArraysKt.joinToString$default(CollectionsKt.toIntArray(r49.getTermCountList()), ",", null, null, 0, null, null, 62, null)));
        r115.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BUTTON_STATUS, r36));
        SkuViewModel r50 = this.f;
        if (r50 != null) goto L137;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L137:
        r115.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD, r50.getSelectFxhMethod()));
        SkuViewModel r51 = this.f;
        if (r51 != null) goto L141;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L141:
        if (r51.getSelectTradeIn() == false) goto L143;
        Object r116 = "1";
    L144:
        r115.add(TuplesKt.to("select_trade_in", r116));
        SkuViewModel r52 = this.f;
        if (r52 != null) goto L147;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L147:
        r115.add(TuplesKt.to("trade_benefit_id", r52.getTradeBenefitId()));
        SkuViewModel r53 = this.f;
        if (r53 != null) goto L150;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L150:
        r115.add(TuplesKt.to("trade_benefit_text", r53.getTradeBenefitText()));
        SkuViewModel.doSkuEventAction$default(r45, "confirm_product_params", (Pair[]) r115.toArray(new Pair[r115.size()]), "a1.b5267.c7323.d7439", PageFinder.via(((QFragmentPresenter) this).e), null, 16, null);
        return;
    L143:
        r116 = "0";
        goto L144
    L14:
        r16 = "0";
        goto L16
    L152:
        JSONObject r54 = new JSONObject(r12);     // Catch: Exception -> L9
        String r55 = r54.optString(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, "");
        r13 = r55;
        r14 = r54.optString(com.bytedance.android.ec.core.event.a.KEY_PREVIOUS_PAGE, "");
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void h0(ButtonOptimizePresenter r14, ButtonTipComponent r15) {
        r14.getClass();
        String r0 = null;
        if (r15 == null) goto L5;
        String r1 = r15.getText();
    L7:
        if (r1 != null) goto L9;
    L12:
        boolean r10 = true;
    L14:
        if (r10 == false) goto L16;
        r14.Z().b(2131366896).f().setVisibility(8);
        r14.Z().b(2131386850).f().setVisibility(0);
        return;
    L16:
        r14.Z().b(2131386850).f().setVisibility(8);
        View r11 = r14.Z().b(2131366896).f();
        r11.setVisibility(0);
        if (r15 != null) goto L184;
    L23:
        if (r15 == null) goto L30;
        int r12 = Integer.valueOf(r15.getBottomOffset()).intValue();
        ViewGroup.LayoutParams r13 = r11.getLayoutParams();
        if ((r13 instanceof ViewGroup.MarginLayoutParams) == true) goto L27;
        r13 = null;
    L27:
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r13;
        if (r16 == null) goto L30;
        r16.bottomMargin = vf4.a.b(Integer.valueOf(r12));
        r11.setLayoutParams(r16);
    L30:
        LinearLayout r17 = (LinearLayout) r14.Z().b(2131378878).f();
        if (r15 != null) goto L33;
    L35:
        int r18 = 8388611;
    L36:
        r17.setGravity(r18);
        TextView r19 = (TextView) r14.Z().b(2131391439).f();
        r19.setVisibility(0);
        if (r15 == null) goto L68;
        List r20 = r15.getHighLightItems();
        if (r20 == null) goto L68;
        SpannableString r21 = new SpannableString(r15.getText());
        int r22 = com.bytedance.android.ec.core.utils.s.a;
        Integer r23 = com.bytedance.android.ec.core.utils.s.b(r15.getTextColor());
        if (r23 == null) goto L47;
        ForegroundColorSpan r110 = new ForegroundColorSpan(r23.intValue());
        String r24 = r15.getText();
        if (r24 == null) goto L45;
        int r25 = r24.length();
    L46:
        r21.setSpan(r110, 0, r25, 33);
        goto L47
    L45:
        r25 = 0;
    L47:
        Iterator r26 = r20.iterator();
    L49:
        if (r26.hasNext() == false) goto L67;
        HighLightItem r27 = (HighLightItem) r26.next();
        Integer r111 = r27.getColorStartIndex();
        if (r111 == null) goto L53;
        int r112 = r111.intValue();
    L54:
        Integer r113 = r27.getColorEndIndex();
        if (r113 == null) goto L57;
        int r114 = r113.intValue();
    L58:
        if (r112 < 0) goto L49;
        String r115 = r15.getText();
        if (r115 == null) goto L62;
        int r116 = r115.length();
    L63:
        if (r114 > r116) goto L49;
        int r117 = com.bytedance.android.ec.core.utils.s.a;
        Integer r28 = com.bytedance.android.ec.core.utils.s.b(r27.getHighLightColor());
        if (r28 == null) goto L49;
        r21.setSpan(new ForegroundColorSpan(r28.intValue()), r112, r114, 33);
        goto L49
    L62:
        r116 = 0;
        goto L63
    L57:
        r114 = 0;
        goto L58
    L53:
        r112 = 0;
        goto L54
    L67:
        r19.setText(r21);
    L78:
        SimpleDraweeView r29 = r14.Z().b(2131376611).f();
        if (r15 == null) goto L85;
        ImageObject r30 = r15.getIcon();
        if (r30 == null) goto L85;
        List r31 = r30.getUrlList();
        if (r31 == null) goto L85;
        String r32 = (String) CollectionsKt.firstOrNull(r31);
    L86:
        if (r32 != null) goto L88;
    L91:
        boolean r33 = true;
    L93:
        if (r33 == false) goto L95;
        r29.setVisibility(8);
    L111:
        if (r15 == null) goto L113;
        String r34 = r15.getButtonText();
    L115:
        if (jg.g.a(r34) == false) goto L130;
        TextView r35 = (TextView) r14.Z().b(2131391467).f();
        r35.setVisibility(0);
        if (r15 == null) goto L119;
        String r36 = r15.getButtonText();
    L120:
        r35.setText(r36);
        if (r15 != null) goto L182;
    L125:
        if (r15 == null) goto L129;
        String r37 = r15.getButtonBorderColor();     // Catch: Exception -> L181
        if (r37 == null) goto L129;
        GradientDrawable r38 = new GradientDrawable();     // Catch: Exception -> L181
        r38.setCornerRadius(com.bytedance.android.ec.core.utils.q.a(4));     // Catch: Exception -> L181
        r38.setStroke(vf4.a.b(Double.valueOf(0.5d)), Color.parseColor(r37));     // Catch: Exception -> L181
        r35.setBackgroundDrawable(r38);     // Catch: Exception -> L181
    L129:
        r35.setOnClickListener((ButtonOptimizePresenter$tipsClick$2.a) r14.p.getValue());
        r14.Z().b(2131391469).f().setVisibility(8);
    L147:
        SkuViewModel r39 = r14.f;
        if (r39 != null) goto L150;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L150:
        SkuInfoVO r40 = (SkuInfoVO) r39.getSkuInfo().a();
        SkuViewModel r41 = r14.f;
        if (r41 != null) goto L153;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L153:
        rg.a r42 = (rg.a) r41.getOnItemChange().a();
        if (r42 == null) goto L156;
        String r43 = (String) r42.b;
    L157:
        if (r40 == null) goto L161;
        Map<String, SkuItemInfoVO> r44 = r40.getSkuList();
        if (r44 == null) goto L161;
        SkuItemInfoVO r45 = r44.get(r43);
    L162:
        if (r15 == null) goto L164;
        String r118 = r15.getType();
    L166:
        if (Intrinsics.areEqual(r118, "time_info") == false) goto L196;
        if (r45 != null) goto L169;
        return;
    L169:
        if ((!Intrinsics.areEqual(r14.m, r45.getId())) == false) goto L198;
        SkuViewModel r119 = r14.f;
        if (r119 != null) goto L173;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L173:
        HashMap<String, String> r46 = r45.getShowEventTrack();
        if (r46 == null) goto L176;
        r0 = r46.get("show_logistics_code");
    L176:
        r119.setShowLogisticsCode(r0);
        SkuViewModel r47 = r14.f;
        if (r47 != null) goto L179;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L179:
        SkuViewModel.doSkuEventAction$default(r47, "sku_panel_module_show", new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MODULE_NAME, "time_info")}, null, null, null, 28, null);
        r14.m = r45.getId();
        return;
    L198:
        return;
    L196:
        return;
    L164:
        r118 = null;
    L161:
        r45 = null;
        goto L162
    L156:
        r43 = null;
        goto L157
    L182:
        String r48 = r15.getButtonTextColor();     // Catch: Exception -> L181
        if (r48 == null) goto L125;
        r35.setTextColor(Color.parseColor(r48));     // Catch: Exception -> L181
        goto L125
    L119:
        r36 = null;
        goto L120
    L130:
        if (r15 == null) goto L146;
        ImageObject r49 = r15.getButtonIcon();
        if (r49 == null) goto L146;
        List r50 = r49.getUrlList();
        if (r50 == null) goto L146;
        String r51 = (String) CollectionsKt.firstOrNull(r50);
        if (r51 == null) goto L146;
        if (jg.g.a(r51) != true) goto L146;
        SimpleDraweeView r52 = r14.Z().b(2131391469).f();
        r52.setVisibility(0);
        ImageObject r53 = r15.getButtonIcon();
        if (r53 == null) goto L144;
        List r54 = r53.getUrlList();
        if (r54 == null) goto L144;
        String r55 = (String) CollectionsKt.firstOrNull(r54);
    L145:
        r52.setImageURI(r55);
        r14.Z().b(2131366896).f().setOnClickListener((ButtonOptimizePresenter$tipsClick$2.a) r14.p.getValue());
        r14.Z().b(2131391467).f().setVisibility(8);
    L144:
        r55 = null;
    L146:
        r14.Z().b(2131391467).f().setVisibility(8);
        r14.Z().b(2131391469).f().setVisibility(8);
        goto L147
    L113:
        r34 = null;
        goto L115
    L95:
        r29.setVisibility(0);
        r29.setImageURI(r32);
        if (r15 != null) goto L98;
    L105:
        ViewGroup.LayoutParams r56 = r29.getLayoutParams();
        if ((r56 instanceof ViewGroup.MarginLayoutParams) == true) goto L108;
        r56 = null;
    L108:
        ViewGroup.MarginLayoutParams r57 = (ViewGroup.MarginLayoutParams) r56;
        if (r57 == null) goto L111;
        r57.rightMargin = vf4.a.b(8);
        r29.setLayoutParams(r57);
        goto L111
    L98:
        if (r15.getAlignmentType() != 1) goto L105;
        ViewGroup.LayoutParams r58 = r29.getLayoutParams();
        if ((r58 instanceof ViewGroup.MarginLayoutParams) == true) goto L102;
        r58 = null;
    L102:
        ViewGroup.MarginLayoutParams r59 = (ViewGroup.MarginLayoutParams) r58;
        if (r59 == null) goto L111;
        r59.rightMargin = vf4.a.b(4);
        r29.setLayoutParams(r59);
        goto L111
    L88:
        if (r32.length() == 0) goto L91;
        r33 = false;
    L85:
        r32 = null;
    L68:
        if (r15 == null) goto L70;
        String r60 = r15.getText();
    L71:
        r19.setText(r60);
        int r61 = com.bytedance.android.ec.core.utils.s.a;
        if (r15 == null) goto L74;
        String r62 = r15.getTextColor();
    L75:
        Integer r63 = com.bytedance.android.ec.core.utils.s.b(r62);
        if (r63 == null) goto L78;
        r19.setTextColor(r63.intValue());
        goto L78
    L74:
        r62 = null;
        goto L75
    L70:
        r60 = null;
        goto L71
    L33:
        if (r15.getAlignmentType() != 1) goto L35;
        r18 = 17;
        goto L36
    L184:
        String r64 = r15.getBgColor();     // Catch: Exception -> L22
        if (r64 == null) goto L23;
        r11.setBackgroundColor(Color.parseColor(r64));     // Catch: Exception -> L22
        goto L23
    L9:
        if (r1.length() == 0) goto L12;
        r10 = false;
        goto L14
    L5:
        r1 = null;
        goto L7
    }

    public static GradientDrawable p0(GradientInfo r10, int r11) {
        GradientDrawable r0 = new GradientDrawable();
        if (r11 <= 1) goto L5;
        r0.setCornerRadii(new float[]{com.bytedance.android.ec.core.utils.q.a(0), com.bytedance.android.ec.core.utils.q.a(0), com.bytedance.android.ec.core.utils.q.a(8), com.bytedance.android.ec.core.utils.q.a(8), com.bytedance.android.ec.core.utils.q.a(8), com.bytedance.android.ec.core.utils.q.a(8), com.bytedance.android.ec.core.utils.q.a(0), com.bytedance.android.ec.core.utils.q.a(0)});
    L6:
        ArrayList r12 = new ArrayList();
        List r13 = r10.getColors();
        if (r13 == null) goto L14;
        Iterator r14 = r13.iterator();
    L10:
        if (r14.hasNext() == false) goto L14;
        Integer r15 = com.bytedance.android.ec.core.utils.s.b((String) r14.next());
        if (r15 == null) goto L10;
        r12.add(Integer.valueOf(r15.intValue()));
    L14:
        r0.setColors(CollectionsKt.toIntArray(r12));
        GradientDrawable.Orientation r16 = GradientDrawable.Orientation.LEFT_RIGHT;
        Intrinsics.checkNotNullParameter(r10, "$this$orientation");
        Intrinsics.checkNotNullParameter(r16, "default");
        Position r17 = r10.getStartPosition();
        Position r18 = r10.getEndPosition();
        if (r17 == null) goto L18;
        if (r18 == null) goto L18;
        double r19 = r18.getY() - r17.getY();
        double r20 = r18.getX() - r17.getX();
    L19:
        double r21 = Math.toDegrees(Math.atan2(r19, r20));
        if (r21 >= 0) goto L22;
        r21 = r21 + 360.0d;
    L22:
        int r22 = MathKt.roundToInt(((int) (r21 % ((double) 360))) / 45) * 45;
        if (r22 == 0) goto L45;
        if (r22 != 45) goto L26;
        r16 = GradientDrawable.Orientation.BL_TR;
    L46:
        r0.setOrientation(r16);
        return r0;
    L26:
        if (r22 != 90) goto L28;
        r16 = GradientDrawable.Orientation.BOTTOM_TOP;
        goto L46
    L28:
        if (r22 != 135) goto L30;
        r16 = GradientDrawable.Orientation.BR_TL;
        goto L46
    L30:
        if (r22 != 180) goto L32;
        r16 = GradientDrawable.Orientation.RIGHT_LEFT;
        goto L46
    L32:
        if (r22 != 225) goto L34;
        r16 = GradientDrawable.Orientation.TR_BL;
        goto L46
    L34:
        if (r22 != 270) goto L36;
        r16 = GradientDrawable.Orientation.TOP_BOTTOM;
        goto L46
    L36:
        if (r22 != 315) goto L46;
        r16 = GradientDrawable.Orientation.TL_BR;
        goto L46
    L45:
        r16 = GradientDrawable.Orientation.LEFT_RIGHT;
    L18:
        r19 = 0.0d;
        r20 = 0.0d;
        goto L19
    L5:
        r0.setCornerRadius(com.bytedance.android.ec.core.utils.q.a(8));
        goto L6
    }

    public static final void d0(ButtonOptimizePresenter r10, boolean r11, sc3.b r12, String r13) {
        SkuViewModel r0 = r10.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuInfoVO r1 = (SkuInfoVO) r0.getSkuInfo().a();
        if (r1 == null) goto L10;
        OrderComponent r14 = r1.getOrderComponent();
        if (r14 == null) goto L10;
        String r15 = r14.getOrderUrl();
    L11:
        if (r15 == null) goto L22;
        SkuViewModel r16 = r10.f;
        if (r16 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L16:
        if (r16.getSkuParams().isLiveSkuCheck() == false) goto L21;
        SkuViewModel r17 = r10.f;
        if (r17 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L20:
        r17.setHalfCloseSku(0);
    L21:
        r10.k0(r11, r15, r12, r13);
        return;
    L22:
        r10.k0(r11, "", r12, r13);
        Lazy r18 = SkuLog.a;
        SkuLog.a("ButtonOptimizePresenter", "finalOrderUrl is null: " + r15);
        return;
    L10:
        r15 = null;
        goto L11
    }

    public static void j0(ButtonOptimizePresenter r22, sc3.b r23, String r24, String r25) {
        String r10 = "提单combo_id为null, product_id:";
        SkuViewModel r11 = r22.f;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        Integer r12 = (Integer) r11.getCurrentTradeModeIndex().a();
        if (r12 == null) goto L8;
        int r13 = r12.intValue();
    L10:
        if (r13 <= 0) goto L117;
        SkuViewModel r14 = r22.f;
        if (r14 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L14:
        TradeModeSelection r15 = (TradeModeSelection) r14.getCurrentTradeModeItem().a();
        if (r15 == null) goto L22;
        List r16 = r15.getSkuBottomButtons();
        if (r16 == null) goto L22;
        SkuBottomButtons r17 = (SkuBottomButtons) CollectionsKt.firstOrNull(r16);
        if (r17 == null) goto L22;
        String r18 = r17.getJumpUrl();
        if (r18 == null) goto L22;
    L23:
        int r19 = com.bytedance.android.ec.common.impl.sku.utils.b.a;
        SkuViewModel r110 = r22.f;
        if (r110 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L26:
        Intrinsics.checkNotNullParameter(r18, "originUrl");
        Intrinsics.checkNotNullParameter(r110, "viewModel");
        Uri r111 = UriProtector.parse(r18);
        JSONObject r112 = new JSONObject();
        if (BuyNowPerformanceOpt.j() == true) goto L30;
        r112.put(com.bytedance.android.ec.core.event.a.KEY_BIOMETRIC_PARAMS, "1");
        int r20 = jg.d.a;
        r112.put(com.bytedance.android.ec.core.event.a.KEY_IS_JAILBREAK, "2");
        r112.put(com.bytedance.android.ec.core.event.a.KEY_BIO_TYPE, "1");
        r112.put(com.bytedance.android.ec.core.event.a.KEY_CJ_SDK, jg.d.a());
    L30:
        String r21 = r110.getSelectFxhMethod();
        if (r21 != null) goto L33;
    L41:
        int r26 = jg.e.a;
        String r27 = jg.e.c(r18, com.bytedance.android.ec.core.event.a.KEY_CJ_INFO, r112.toString());
        String r28 = r110.getComboId();
        if (r28 != null) goto L44;
        r28 = "";
    L44:
        String r29 = jg.e.b(jg.e.b(r27, com.bytedance.android.ec.core.event.a.KEY_SKU_ID, r28), "sku_num", String.valueOf(r110.getCurrentCount()));
        Long r30 = r110.getCurrentSecondPrice();
        if (r30 != null) goto L47;
    L49:
        boolean r31 = false;
    L50:
        if (r31 == false) goto L52;
        Long r32 = r110.getCurrentSecondPrice();
    L53:
        if (r31 == false) goto L55;
        String r33 = r110.getCurrentSecondPricePrefix();
    L56:
        if (r32 == null) goto L58;
        long r210 = r32.longValue();
    L59:
        String r34 = jg.e.b(r29, com.bytedance.android.ec.core.event.a.KEY_PRODUCT_PRICE, String.valueOf(r210));
        if (r33 != null) goto L62;
        r33 = r15;
    L62:
        String r35 = jg.e.b(r34, "product_price_prefix", r33);
        String r36 = UriProtector.getQueryParameter(r111, "mega_object");
        if (r36 != null) goto L309;
    L70:
        JSONObject r113 = new JSONObject();     // Catch: Exception -> L72
    L308:
    L73:
        r113.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, String.valueOf(r110.getSkuParams().getEntranceInfo()));
        ECAdLogExtra r37 = r110.getSkuParams().getAdLogExtra();
        if (r37 == null) goto L77;
        String r38 = r37.getLogExtra();
        if (r38 == null) goto L77;
    L78:
        r113.put(com.bytedance.android.ec.core.event.a.KEY_LOG_EXTRA, r38);
        if (r110.getSkuParams().isLiveSkuCheck() == true) goto L91;
        ECAdLogExtra r39 = r110.getSkuParams().getAdLogExtra();
        if (r39 == null) goto L84;
        String r40 = r39.getLogExtra();
        if (r40 == null) goto L84;
    L85:
        r113.put(com.bytedance.android.ec.core.event.a.KEY_LOG_EXTRA, r40);
        ECAdLogExtra r41 = r110.getSkuParams().getAdLogExtra();
        if (r41 == null) goto L89;
        String r42 = r41.getAdExtraData();
        if (r42 == null) goto L89;
    L90:
        r113.put(com.bytedance.android.ec.core.event.a.KEY_AD_EXTRA_DATA, r42);
    L89:
        r42 = r15;
    L84:
        r40 = r15;
    L91:
        int r43 = jg.e.a;
        String r44 = jg.e.b(r35, "mega_object", r113.toString());
        boolean r45 = ECServiceManager.a;
        ECAdInfo r46 = ((s83.g) ECServiceManager.c(s83.g.class)).A(null);
        if (r46 == null) goto L112;
        String r47 = UriProtector.getQueryParameter(UriProtector.parse(r44), com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        if (r47 != null) goto L306;
    L101:
        JSONObject r114 = new JSONObject();     // Catch: Exception -> L103
    L305:
    L105:
        if (TextUtils.isEmpty(r114.optString(com.bytedance.android.ec.core.event.a.KEY_CREATIVE_ID)) == false) goto L109;
        r114.put(com.bytedance.android.ec.core.event.a.KEY_CREATIVE_ID, r46.getCid());
        com.bytedance.android.ec.core.anchorv3.a.b(r47);
    L109:
        if (TextUtils.isEmpty(r114.optString(com.bytedance.android.ec.core.event.a.KEY_LOG_EXTRA)) == false) goto L111;
        r114.put(com.bytedance.android.ec.core.event.a.KEY_LOG_EXTRA, r46.getLogExtra());
        com.bytedance.android.ec.core.anchorv3.a.b(r47);
    L111:
        int r48 = jg.e.a;
        r44 = jg.e.b(r44, com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r114.toString());
    L113:
        Activity r49 = jg.h.a.getActivity(r22.a0());
        if (r49 == null) goto L116;
        HashMap<String, JSONObject> r50 = com.bytedance.android.ec.core.hybrid.utils.j.a;
        com.bytedance.android.ec.sdk.helper.p.a.openSchema(r49, com.bytedance.android.ec.core.hybrid.utils.j.c(com.bytedance.android.ec.core.btm.c.c(r44, r22.a0(), "a1.b5267.c7323.d7439", new Pair[0]), false, 12));
    L116:
        r22.q0(r25);
        boolean r51 = true;
    L118:
        if (r51 == true) goto L313;
        SkuViewModel r52 = r22.f;
        if (r52 != null) goto L123;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L123:
        SkuInfoVO r53 = (SkuInfoVO) r52.getSkuInfo().a();
        if (r53 == null) goto L126;
        SkuPoiInfo r54 = r53.getPoiInfo();
    L127:
        if (r54 == null) goto L129;
        Long r55 = r54.getTotal();
    L130:
        Set<String> r56 = ECProcessMonitor.a;
        com.bytedance.android.ec.core.monitor.listener.b r57 = ECProcessMonitor.e("ec_sku");
        JSONObject r115 = new JSONObject();
        SkuViewModel r116 = r22.f;     // Catch: Exception -> L143
        if (r116 != null) goto L134;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: Exception -> L143
    L134:
        r115.put(com.bytedance.android.ec.core.event.a.KEY_ENTER_FROM, r116.getSkuParams().getSourcePage());     // Catch: Exception -> L143
        SkuViewModel r117 = r22.f;     // Catch: Exception -> L143
        if (r117 != null) goto L137;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: Exception -> L143
    L137:
        String r118 = r117.getSkuParams().getEntranceInfo();     // Catch: Exception -> L143
        if (r118 == null) goto L145;
        JSONObject r119 = jg.g.f(r118);     // Catch: Exception -> L143
        if (r119 == null) goto L145;
        r115.put(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_SOURCE_PAGE, r119.optString(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_SOURCE_PAGE));     // Catch: Exception -> L143
        r115.put(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, r119.optString(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL));     // Catch: Exception -> L143
    L145:
        Unit r0 = Unit.INSTANCE;
        ActionRateListener.c(r57, r115, null, false, 6);
        Set<String> r1 = ECProcessMonitor.a;
        ECProcessMonitor.e("ec_sku").d();
        if (r54 == null) goto L158;
        if (r55 == null) goto L158;
        if (r55.longValue() <= 0) goto L158;
        if (r54.getSelectedPoiInfo() != null) goto L158;
        SkuViewModel r58 = r22.f;
        if (r58 != null) goto L156;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L156:
        if (r58.getSelectPoiInfo().a() != null) goto L158;
        UIUtils.displayToast(r22.Y().c(), th.a.f(r22.Y().c()).getString(2131914034));
        com.bytedance.android.ec.core.monitor.listener.b.k(ECProcessMonitor.e("ec_sku"), -4, null, 30);
        return;
    L158:
        SkuViewModel r59 = r22.f;
        if (r59 != null) goto L161;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L161:
        SkuInfoVO r60 = (SkuInfoVO) r59.getSkuInfo().a();
        if (r60 == null) goto L168;
        OrderComponent r61 = r60.getOrderComponent();
        if (r61 == null) goto L168;
        String r62 = r61.getOrderUrl();
        if (r62 == null) goto L168;
    L185:
        if (r62.length() <= 0) goto L187;
        boolean r63 = true;
    L188:
        if (r63 == false) goto L190;
        String r64 = r62;
    L191:
        if (r64 == null) goto L312;
        int r65 = ECSdk.a;
        IAdapterService r66 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r66 == null) goto L197;
        com.bytedance.android.ec.adapter.api.j r67 = r66.getLiveWindowService();
        if (r67 == null) goto L197;
        r67.stopShowFloatInNextLifecycle();
    L197:
        if (r23 == null) goto L199;
        r23.c(ChainPoint.CREATE_SCHEMA_START, null);
    L199:
        String r68 = UUID.randomUUID().toString();
        if (BuyNowPerformanceOpt.e() == true) goto L202;
    L204:
        BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b5267.c7323.d7439", Boolean.FALSE).withView(r22.a0()).build());
        SkuViewModel r69 = r22.f;
        if (r69 != null) goto L208;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L208:
        if (r69.getSkuParams().isLiveSkuCheck() == false) goto L213;
        int r70 = com.bytedance.android.ec.common.impl.sku.utils.g.a;
        SkuViewModel r71 = r22.f;
        if (r71 != null) goto L212;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L212:
        String r72 = com.bytedance.android.ec.common.impl.sku.utils.g.a(r24, r71);
    L217:
        Observable.fromCallable(new m(r72, r22.Y().c())).subscribeOn(Schedulers.io()).subscribe();
        String r73 = com.bytedance.android.ec.core.btm.c.c(r72, r22.a0(), "a1.b5267.c7323.d7439", new Pair[0]);
        Intrinsics.checkNotNullParameter(r73, "$this$appendSchemaDiffID");
        if (com.bytedance.android.ec.core.utils.a2.d(r68) == null) goto L220;
        r73 = com.bytedance.android.ec.core.utils.p0.g(r73, "schema_diff_id", r68);
    L220:
        int r74 = com.bytedance.android.ec.common.impl.sku.utils.p.a;
        Intrinsics.checkNotNullParameter(r73, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (StringsKt.contains$default(r73, "webcast_webview", false, 2, null) == false) goto L231;
        int r75 = jg.f.a;
        SkuViewModel r76 = r22.f;
        if (r76 != null) goto L226;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L226:
        if (jg.f.a(r76) == false) goto L231;
        SkuViewModel r77 = r22.f;
        if (r77 != null) goto L230;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L230:
        r73 = com.bytedance.android.ec.common.impl.sku.utils.p.b(r73, r77.getSkuParams().isLiveSkuCheck(), 2);
    L231:
        if (r23 == null) goto L233;
        Object r78 = null;
        r23.c(ChainPoint.CREATE_SCHEMA_END, null);
    L234:
        if (r23 == null) goto L238;
        String r79 = r23.b(r73);
        if (r79 == null) goto L238;
        r73 = r79;
    L238:
        IEShoppingService r80 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r80 == null) goto L243;
        sc3.c r81 = r80.getBuyNowService();
        if (r81 == null) goto L243;
        r81.j(r73, "a1.b5267.c7323.d7439");
    L243:
        Activity r82 = jg.h.a.getActivity(r22.a0());
        if (r82 == null) goto L259;
        ECProcessMonitor.e("ec_sku").g();
        int r83 = com.bytedance.android.ec.common.impl.sku.utils.i.a;
        SkuViewModel r84 = r22.f;
        if (r84 != null) goto L248;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L248:
        String r85 = r84.getSkuParams().getPromotionLogId();
        if (r85 != null) goto L251;
        r85 = r19;
    L251:
        SkuViewModel r120 = r22.f;
        if (r120 != null) goto L254;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L254:
        String r121 = r120.getSkuParams().getSkuLogId();
        if (r121 != null) goto L257;
        String r122 = r19;
    L258:
        boolean r123 = false;
        com.bytedance.android.ec.common.impl.sku.utils.i.a(r73, r82, r85, r122, false);
    L261:
        if (BuyNowPerformanceOpt.f() == false) goto L263;
        Completable.fromAction(new d(r64, r68, r22, r23, r24)).subscribeOn(Schedulers.computation()).subscribe();
    L263:
        SkuViewModel r86 = r22.f;
        if (r86 != null) goto L267;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L267:
        if (r86.getHalfCloseSku() != 1) goto L278;
        Map r87 = BuyNowPerformanceOpt.g();
        if (r87 == null) goto L271;
        Object r124 = r87.get("buynow_enable_close_sku_opt");
    L273:
        if (Intrinsics.areEqual(r124, 1) == true) goto L278;
        SkuViewModel r88 = r22.f;
        if (r88 != null) goto L277;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L277:
        r88.closeDialogFragment(5);
        goto L278
    L271:
        r124 = r78;
    L278:
        r22.q0(r25);
        Result.Companion r89 = Result.Companion;     // Catch: Throwable -> L297
        SkuViewModel r90 = r22.f;     // Catch: Throwable -> L297
        if (r90 != null) goto L282;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: Throwable -> L297
    L282:
        String r91 = r90.getComboId();     // Catch: Throwable -> L297
        if (r91 != null) goto L285;
    L286:
        r123 = true;
    L287:
        if (r123 == false) goto L295;
        SkuViewModel r92 = r22.f;     // Catch: Throwable -> L297
        if (r92 != null) goto L291;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: Throwable -> L297
    L291:
        StringBuilder r93 = new StringBuilder(r10);     // Catch: Throwable -> L297
        SkuViewModel r94 = r22.f;     // Catch: Throwable -> L297
        if (r94 != null) goto L294;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: Throwable -> L297
    L294:
        r93.append(r94.getSkuParams().getProductId());     // Catch: Throwable -> L297
        r92.doSkuErrorEventAction("SERIOUS_BUSINESS_ERROR", r93.toString());     // Catch: Throwable -> L297
    L295:
        Object r95 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L297
    L299:
        Result.box-impl(r95);
        return;
    L285:
        if (r91.length() != 0) goto L287;
    L297:
        th = move-exception;
        Result.Companion r96 = Result.Companion;
        r95 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L299
    L257:
        r122 = r121;
        goto L258
    L259:
        r123 = false;
        goto L261
    L233:
        r78 = null;
        goto L234
    L213:
        int r97 = com.bytedance.android.ec.common.impl.sku.utils.c.a;
        SkuViewModel r98 = r22.f;
        if (r98 != null) goto L216;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L216:
        r72 = com.bytedance.android.ec.common.impl.sku.utils.c.a(r64, r98);
        goto L217
    L202:
        if (r22.n0(r64, r24, r68, r23) == false) goto L204;
        SkuLog.a("ButtonOptimizePresenter", "is orderSchema");
        r78 = null;
        r123 = false;
        goto L263
    L312:
        return;
    L190:
        r64 = null;
        goto L191
    L187:
        r63 = false;
    L168:
        SkuViewModel r99 = r22.f;
        if (r99 != null) goto L171;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L171:
        r62 = r99.getSkuParams().getH5Url();
        if (r62 != null) goto L174;
    L181:
        if (r24 != null) goto L183;
        r62 = r19;
        goto L185
    L183:
        r62 = r24;
        goto L185
    L174:
        if (r62.length() <= 0) goto L176;
        boolean r100 = true;
    L177:
        if (r100 == true) goto L180;
        r62 = null;
    L180:
        if (r62 != null) goto L185;
    L176:
        r100 = false;
    L143:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L145
    L129:
        r55 = null;
        goto L130
    L126:
        r54 = null;
        goto L127
    L313:
        return;
    L103:
        r114 = new JSONObject();
        goto L105
    L306:
        if ((!TextUtils.isEmpty(r47)) == false) goto L98;
        String r125 = r47;
    L99:
        if (r125 == null) goto L101;
        r114 = new JSONObject(r125);     // Catch: Exception -> L103
        goto L305
    L98:
        r125 = null;
        goto L99
    L112:
        r10 = "提单combo_id为null, product_id:";
    L77:
        r38 = r15;
    L72:
        r113 = new JSONObject();
        goto L73
    L309:
        if ((!TextUtils.isEmpty(r36)) == true) goto L68;
        r36 = null;
    L68:
        if (r36 == null) goto L70;
        r113 = new JSONObject(r36);     // Catch: Exception -> L72
        goto L308
    L58:
        r210 = 0;
        goto L59
    L55:
        r33 = r110.getCurrentFirstPricePrefix();
        goto L56
    L52:
        r32 = r110.getCurrentFirstPrice();
        goto L53
    L47:
        if (r30.longValue() <= 0) goto L49;
        r31 = true;
        goto L50
    L33:
        if (r21.length() <= 0) goto L35;
        boolean r101 = true;
    L36:
        if (r101 == true) goto L39;
        r21 = null;
    L39:
        if (r21 == null) goto L41;
        r112.put(com.bytedance.android.ec.core.event.a.KEY_INSTALLMENT_INFO, r21);
        goto L41
    L35:
        r101 = false;
    L22:
        r18 = "";
        goto L23
    L117:
        r10 = "提单combo_id为null, product_id:";
        String r126 = "";
        r51 = false;
        goto L118
    L8:
        r13 = 0;
        goto L10
    }

    public final void k0(boolean r30, String r31, sc3.b r32, String r33) {
        SkuViewModel r10 = this.f;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r10.setLastBehaviorBeforeDismiss(com.bytedance.android.ec.core.event.a.VALUE_FORWARD);
        if (r30 == true) goto L168;
        Set<String> r11 = ECProcessMonitor.a;
        com.bytedance.android.ec.core.monitor.listener.a r12 = ECProcessMonitor.d("ec_sku");
        JSONObject r13 = new JSONObject();
        SkuViewModel r14 = this.f;     // Catch: Exception -> L20
        if (r14 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: Exception -> L20
    L11:
        r13.put(com.bytedance.android.ec.core.event.a.KEY_ENTER_FROM, r14.getSkuParams().getSourcePage());     // Catch: Exception -> L20
        SkuViewModel r15 = this.f;     // Catch: Exception -> L20
        if (r15 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: Exception -> L20
    L14:
        String r16 = r15.getSkuParams().getEntranceInfo();     // Catch: Exception -> L20
        if (r16 == null) goto L22;
        JSONObject r17 = jg.g.f(r16);     // Catch: Exception -> L20
        if (r17 == null) goto L22;
        r13.put(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_SOURCE_PAGE, r17.optString(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_SOURCE_PAGE));     // Catch: Exception -> L20
        r13.put(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, r17.optString(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL));     // Catch: Exception -> L20
    L22:
        Unit r0 = Unit.INSTANCE;
        ActionRateListener.c(r12, r13, null, false, 6);
        Set<String> r18 = ECProcessMonitor.a;
        ECProcessMonitor.d("ec_sku").d();
        SkuViewModel r19 = this.f;
        if (r19 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L26:
        if (r19.getCurrentCount() > 0) goto L28;
        com.bytedance.android.ec.core.monitor.listener.a.k(ECProcessMonitor.d("ec_sku"), -6, null, null, null, 14);
    L162:
        int r1 = ECSdk.a;
        IECUserTrackerService r20 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r20 == null) goto L167;
        of.a r21 = r20.getMarketingService();
        if (r21 == null) goto L167;
        r21.a(com.bytedance.android.ec.core.event.a.VALUE_ADD_CART, PostActionType.DO, com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL);
    L167:
        o0("cart");
        return;
    L28:
        SkuViewModel r22 = this.f;
        if (r22 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L31:
        SkuInfoVO r110 = (SkuInfoVO) r22.getSkuInfo().a();
        if (r110 != null) goto L34;
        com.bytedance.android.ec.core.monitor.listener.a.k(ECProcessMonitor.d("ec_sku"), -7, null, null, null, 14);
        goto L162
    L34:
        SkuViewModel r23 = this.f;
        if (r23 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L37:
        SkuParams r24 = r23.getSkuParams();
        ECProcessMonitor.d("ec_sku").j(r24.isSchemaOpen(), r24.getSceneType());
        int r25 = com.bytedance.android.ec.common.impl.sku.utils.h.a;
        Fragment r26 = ((QFragmentPresenter) this).e;
        SkuViewModel r111 = this.f;
        if (r111 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L40:
        Context r112 = Y().c();
        String r113 = r24.getOriginType();
        String r114 = r24.getOriginId();
        String r115 = r24.getPromotionId();
        String r27 = r24.getProductId();
        if (r27 != null) goto L43;
        String r116 = "";
    L44:
        String r28 = r24.getAuthorId();
        if (r28 != null) goto L47;
        String r117 = "";
    L48:
        String r29 = r24.getRoomId();
        if (r29 != null) goto L51;
        String r118 = "";
    L52:
        String r34 = r24.getShopId();
        if (r34 != null) goto L55;
        String r119 = "";
    L56:
        SkuViewModel r35 = this.f;
        if (r35 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L59:
        String r36 = r35.getComboId();
        if (r36 != null) goto L62;
        String r210 = "";
    L63:
        SkuViewModel r37 = this.f;
        if (r37 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L66:
        String r211 = String.valueOf(r37.getCurrentCount());
        SkuViewModel r38 = this.f;
        if (r38 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L69:
        List<String> r39 = r38.getCheckedIdArray();
        if (r39 == null) goto L76;
        Object[] r40 = r39.toArray(new String[0]);
        if (r40 == null) goto L75;
        String[] r41 = (String[]) r40;
    L77:
        String[] r212 = r41;
        String r42 = r24.getTrackExtra();
        if (r42 != null) goto L80;
        String r213 = "";
    L81:
        String r214 = BtmSDK.INSTANCE.getPageId(PageFinder.via(((QFragmentPresenter) this).e));
        String r43 = r24.getChannelId();
        if (r43 != null) goto L84;
        String r215 = "";
    L85:
        Integer r44 = r24.getChannelType();
        if (r44 == null) goto L88;
        int r216 = r44.intValue();
    L89:
        com.bytedance.android.ec.common.impl.sku.utils.h.b(r26, r111, r110, r112, r113, r114, r115, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r24.getBizCampaignType(), r24.getCpsTrack());
        SkuViewModel r45 = this.f;
        if (r45 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L92:
        String r46 = r45.getSkuParams().getEntranceInfo();
        if (r46 != null) goto L190;
    L97:
        String r47 = "";
        String r48 = r47;
    L98:
        String r49 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b5267.c7323.d1871", Boolean.FALSE).withView(a0()).build());
        SkuViewModel r50 = this.f;
        if (r50 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L102:
        if (r50.getSkuParams().isFromAnchorV3() == true) goto L104;
        SkuViewModel r51 = this.f;
        if (r51 != null) goto L123;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L123:
        if (r51.getSkuParams().isFromVideoFeed() == false) goto L131;
        SkuViewModel r120 = this.f;
        if (r120 != null) goto L127;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L127:
        SpreadBuilder r52 = new SpreadBuilder(4);
        r52.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, "sku_card"));
        SkuViewModel r53 = this.f;
        if (r53 != null) goto L130;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L130:
        r52.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r53.getSelectedSkuId()));
        r52.add(TuplesKt.to("btm_id", r49));
        r52.addSpread(i0());
        SkuViewModel.doSkuEventAction$default(r120, "confirm_add_to_cart", (Pair[]) r52.toArray(new Pair[r52.size()]), null, null, null, 28, null);
        goto L162
    L131:
        SkuViewModel r54 = this.f;
        if (r54 != null) goto L135;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L135:
        if (r54.getSkuParams().isLiveSkuCheck() == false) goto L155;
        SkuViewModel r121 = this.f;
        if (r121 != null) goto L139;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L139:
        SpreadBuilder r55 = new SpreadBuilder(6);
        r55.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, "sku_card"));
        SkuViewModel r56 = this.f;
        if (r56 != null) goto L142;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L142:
        r55.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r56.getSelectedSkuId()));
        SkuViewModel r57 = this.f;
        if (r57 != null) goto L145;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L145:
        String r58 = r57.getSkuParams().getTrackExtra();
        if (r58 != null) goto L188;
        String r59 = null;
    L151:
        r55.add(TuplesKt.to("cart_track", r59));
        SkuViewModel r60 = this.f;
        if (r60 != null) goto L154;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L154:
        r55.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r60.getSkuParams().getAddCartEntranceInfo()));
        r55.add(TuplesKt.to("btm_id", r49));
        r55.addSpread(i0());
        SkuViewModel.doSkuEventAction$default(r121, "click_add_to_cart", (Pair[]) r55.toArray(new Pair[r55.size()]), null, null, null, 28, null);
        goto L162
    L188:
        r59 = new JSONObject(r58).optString("cart_track");     // Catch: Exception -> L149
    L149:
        r59 = "";
        goto L151
    L155:
        SkuViewModel r61 = this.f;
        if (r61 != null) goto L158;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L158:
        SpreadBuilder r62 = new SpreadBuilder(4);
        r62.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, "sku_card"));
        SkuViewModel r63 = this.f;
        if (r63 != null) goto L161;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L161:
        r62.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r63.getSelectedSkuId()));
        r62.add(TuplesKt.to("btm_id", r49));
        r62.addSpread(i0());
        SkuViewModel.doSkuEventAction$default(r61, "confirm_add_to_cart", (Pair[]) r62.toArray(new Pair[r62.size()]), null, null, null, 28, null);
        goto L162
    L104:
        if (Intrinsics.areEqual(r47, "product_ranking_homepage") == false) goto L112;
        SkuViewModel r122 = this.f;
        if (r122 != null) goto L108;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L108:
        SpreadBuilder r64 = new SpreadBuilder(5);
        r64.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, "sku_card"));
        SkuViewModel r65 = this.f;
        if (r65 != null) goto L111;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L111:
        r64.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r65.getSelectedSkuId()));
        r64.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PREVIOUS_PAGE, r48));
        r64.add(TuplesKt.to("btm_id", r49));
        r64.addSpread(i0());
        SkuViewModel.doSkuEventAction$default(r122, "confirm_add_to_cart", (Pair[]) r64.toArray(new Pair[r64.size()]), null, null, null, 28, null);
        goto L162
    L112:
        SkuViewModel r66 = this.f;
        if (r66 != null) goto L115;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L115:
        SpreadBuilder r67 = new SpreadBuilder(4);
        r67.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, "sku_card"));
        SkuViewModel r68 = this.f;
        if (r68 != null) goto L118;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L118:
        r67.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r68.getSelectedSkuId()));
        r67.add(TuplesKt.to("btm_id", r49));
        r67.addSpread(i0());
        SkuViewModel.doSkuEventAction$default(r66, "confirm_add_to_cart", (Pair[]) r67.toArray(new Pair[r67.size()]), null, null, null, 28, null);
        goto L162
    L190:
        JSONObject r69 = new JSONObject(r46);     // Catch: Exception -> L96
        r47 = r69.optString(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, "");
        r48 = r69.optString(com.bytedance.android.ec.core.event.a.KEY_PREVIOUS_PAGE, "");
        goto L98
    L88:
        r216 = 0;
        goto L89
    L84:
        r215 = r43;
        goto L85
    L80:
        r213 = r42;
        goto L81
    L75:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L76:
        r41 = new String[0];
        goto L77
    L62:
        r210 = r36;
        goto L63
    L55:
        r119 = r34;
        goto L56
    L51:
        r118 = r29;
        goto L52
    L47:
        r117 = r28;
        goto L48
    L43:
        r116 = r27;
    L20:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L22
    L168:
        SkuViewModel r70 = this.f;
        if (r70 != null) goto L172;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L172:
        if (r70.getCurrentCount() <= 0) goto L181;
        SkuViewModel r71 = this.f;
        if (r71 != null) goto L177;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L177:
        r71.logAdEvent();
        SkuViewModel r72 = this.f;
        if (r72 != null) goto L180;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L180:
        r72.setApplyCouponIds(null);
        j0(this, r32, r31, r33);
    L181:
        int r73 = ECSdk.a;
        IECUserTrackerService r74 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r74 == null) goto L186;
        of.a r75 = r74.getMarketingService();
        if (r75 == null) goto L186;
        r75.a(com.bytedance.android.ec.core.event.a.VALUE_CLICK_PURCHASE, PostActionType.DO, com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL);
    L186:
        o0("buy");
    }

    public final boolean n0(String r10, String r11, String r12, sc3.b r13) {
        SkuViewModel r0 = this.f;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L6:
        if (r0.getSkuParams().isLiveSkuCheck() == false) goto L11;
        SkuViewModel r1 = this.f;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L10:
        com.bytedance.android.ec.common.impl.sku.buy.b r14 = new com.bytedance.android.ec.common.impl.sku.buy.c(r11, r1);
    L15:
        IOrderSchema r15 = r14.a();
        SkuViewModel r16 = this.f;
        if (r16 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L19:
        if (r16.getSkuParams().isLiveSkuCheck() == false) goto L22;
        if (r15 == null) goto L24;
        com.bytedance.android.ec.core.btm.c.e(r15, a0(), new Pair[0]);
    L24:
        if (r15 == null) goto L27;
        r15.replaceOrAppendParam("schema_diff_id", r12);
    L27:
        if (r14.u() == false) goto L50;
        if (r15 == null) goto L50;
        r14.v();
        if (r13 == null) goto L33;
        r13.c(ChainPoint.CREATE_SCHEMA_END, null);
    L33:
        if (r13 == null) goto L35;
        r13.d(r15);
    L35:
        if (r13 == null) goto L41;
        int r17 = ECSdk.a;
        IEShoppingService r18 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r18 == null) goto L41;
        sc3.c r19 = r18.getBuyNowService();
        if (r19 == null) goto L41;
        r19.b(r15);
    L41:
        Activity r20 = jg.h.a.getActivity(a0());
        if (r20 == null) goto L51;
        int r21 = ECSdk.a;
        IEShoppingService r22 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r22 == null) goto L52;
        sc3.c r23 = r22.getBuyNowService();
        if (r23 == null) goto L53;
        r23.g(r20, r15);
        return true;
    L53:
        return true;
    L52:
        return true;
    L51:
        return true;
    L50:
        return false;
    L22:
        if (r15 == null) goto L24;
        com.bytedance.android.ec.core.btm.c.e(r15, a0(), new Pair[0]);
        goto L24
    L11:
        SkuViewModel r24 = this.f;
        if (r24 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L14:
        r14 = new com.bytedance.android.ec.common.impl.sku.buy.a(r10, r24);
        goto L15
    }
}
