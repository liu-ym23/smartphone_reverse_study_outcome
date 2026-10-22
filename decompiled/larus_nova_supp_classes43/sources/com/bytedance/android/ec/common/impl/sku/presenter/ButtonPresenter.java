package com.bytedance.android.ec.common.impl.sku.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.byted.cast.sink.api.IServerListener;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService;
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.log.SkuLog;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuItemInfoVO;
import com.bytedance.android.ec.common.impl.sku.utils.ActivityCountDownTimer;
import com.bytedance.android.ec.core.data.ActionObserver;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.monitor.listener.ActionRateListener;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.api.LogPbData;
import com.bytedance.android.ec.model.sku.OrderComponent;
import com.bytedance.android.ec.model.sku.SkuBottomButtons;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.model.sku.SkuPoiInfo;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.data.api.ChainPoint;
import com.bytedance.common.utility.UIUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ButtonPresenter extends QFragmentPresenter {
    public static final /* synthetic */ int p = 0;
    public SkuViewModel f;
    public boolean g;
    public q83.a h;
    public boolean i;
    public boolean j;
    public Long k;
    public boolean l;
    public boolean m;
    public long n;
    public final Lazy o;

    public static final class a {
    }

    public static final class b implements q83.a {
        public final /* synthetic */ ButtonPresenter a;

        public b(ButtonPresenter r1) {
            this.a = r1;
        }

        public final boolean onTick(long r10) {
            com.bytedance.android.ec.model.response.p r11 = (com.bytedance.android.ec.model.response.p) ButtonPresenter.e0(this.a).getCheckPayNotificationAction().a();
            if (r11 != null) goto L5;
        L10:
            return true;
        L5:
            if (((TextView) this.a.Z().b(2131391464).f()).getVisibility() != 0) goto L10;
            if ((!Intrinsics.areEqual(ButtonPresenter.e0(this.a).getCheckPayNotificationSkuId(), ButtonPresenter.e0(this.a).getSelectedSkuId())) == false) goto L9;
            this.a.q0(false);
            LinearLayout r12 = (LinearLayout) this.a.Z().b(2131378867).f();
            r12.setBackgroundResource(2131247920);
            r12.setClickable(true);
            ButtonPresenter.e0(this.a).cancelQueryPromotionCheckPayNotification(true);
            goto L10
        L9:
            ButtonPresenter.h0(this.a, r11);
            goto L10
        }
    }

    public static final class c implements com.bytedance.android.ec.core.utils.l1.a {
        public final /* synthetic */ ButtonPresenter a;

        @Override // com.bytedance.android.ec.core.utils.l1.a
        public final void onStart() {
        }

        @Override // com.bytedance.android.ec.core.utils.l1.a
        public final void onFinish() {
            Long r0 = this.a.k;
            if (r0 != null) goto L6;
        L8:
            Long r1 = this.a.k;
            if (r1 != null) goto L12;
            return;
        L12:
            if (r1.longValue() != 7) goto L21;
            TextView r10 = (TextView) this.a.Z().b(2131391440).f();
            if (ButtonPresenter.e0(this.a).getSkuParams().getAddShopCart() == false) goto L16;
        L18:
            r10.setTextSize(17.0f);
            ((TextView) this.a.Z().b(2131391441).f()).setVisibility(8);
            return;
        L16:
            if (ButtonPresenter.e0(this.a).getSkuParams().isFromCartOrInsurance() == true) goto L18;
            r10.setText(th.a.g(this.a.Y().c(), 2131913821));
            goto L18
        L21:
            return;
        L6:
            if (r0.longValue() != 10) goto L8;
            TextView r11 = (TextView) this.a.Z().b(2131378863).f();
            r11.setOnClickListener(null);
            r11.setEnabled(false);
            LinearLayout r12 = (LinearLayout) this.a.Z().b(2131378867).f();
            r12.setOnClickListener(null);
            r12.setBackgroundResource(2131247887);
            ((TextView) this.a.Z().b(2131391441).f()).setText(th.a.g(this.a.Y().c(), 2131914056));
        }

        public c(ButtonPresenter r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.ec.core.utils.l1.a
        public final void onTick(long r10) {
            int r0 = com.bytedance.android.ec.core.utils.c2.h;
            com.bytedance.android.ec.core.utils.c2 r11 = com.bytedance.android.ec.core.utils.c2.a.a(this.a.Y().c(), r10, false);
            Long r12 = this.a.k;
            if (r12 != null) goto L6;
        L12:
            Long r13 = this.a.k;
            if (r13 != null) goto L16;
            return;
        L16:
            if (r13.longValue() != 7) goto L20;
            ((TextView) this.a.Z().b(2131391441).f()).setText(th.a.h(this.a.Y().c(), 2131913993, new Object[]{r11.c, r11.d, r11.e}));
            return;
        L20:
            return;
        L6:
            if (r12.longValue() != 10) goto L12;
            TextView r14 = (TextView) this.a.Z().b(2131391441).f();
            if (r11.a <= 0) goto L10;
            String r15 = th.a.h(this.a.Y().c(), 2131913951, new Object[]{Integer.valueOf(r11.a), r11.c, r11.d, r11.e});
        L11:
            r14.setText(r15);
            return;
        L10:
            r15 = th.a.h(this.a.Y().c(), 2131913950, new Object[]{r11.c, r11.d, r11.e});
            goto L11
        }
    }

    static {
    }

    public final Pair<String, String>[] j0() {
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
        SkuViewModel r1 = this.f;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        cf.t r10 = r1.getSkuLiveService();
        if (r10 == null) goto L9;
        r10.a(m0());
        return;
    }

    public final q83.a m0() {
        if (this.h != null) goto L5;
        this.h = new b(this);
    L5:
        q83.a r0 = this.h;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("soldFreeTextTickListener");
    L8:
        return r0;
    }

    public final void o0() {
        ((TextView) Z().b(2131391440).f()).setTextSize(14.0f);
        TextView r0 = (TextView) Z().b(2131391441).f();
        r0.setVisibility(0);
        if (this.l == false) goto L5;
        int r1 = th.a.a(Y().c(), 2131106241);
    L6:
        r0.setTextColor(r1);
        Lazy r10 = ActivityCountDownTimer.c;
        ActivityCountDownTimer.a.a().b();
        ActivityCountDownTimer.a.a().a(SystemClock.elapsedRealtime() / 1000, this.n / 1000, new c(this));
        return;
    L5:
        r1 = th.a.a(Y().c(), 2131106238);
        goto L6
    }

    public ButtonPresenter(final Fragment r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        super(r10);
        this.o = LazyKt.lazy(new ButtonPresenter$newClick$2(this, r10));
    }

    public static final /* synthetic */ SkuViewModel e0(ButtonPresenter r1) {
        SkuViewModel r10 = r1.f;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        return r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void i0(ButtonPresenter r21) {
        SkuViewModel r1 = r21.f;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        long r10 = r1.getCurrentPrice();
        SkuViewModel r11 = r21.f;
        if (r11 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        SkuInfoVO r12 = (SkuInfoVO) r11.getSkuInfo().a();
        SkuViewModel r13 = r21.f;
        if (r13 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L11:
        rg.a r14 = (rg.a) r13.getOnItemChange().a();
        if (r14 == null) goto L14;
        String r15 = (String) r14.b;
    L15:
        if (r12 == null) goto L19;
        Map<String, SkuItemInfoVO> r16 = r12.getSkuList();
        if (r16 == null) goto L19;
        SkuItemInfoVO r17 = r16.get(r15);
    L20:
        boolean r18 = true;
        if (r17 == null) goto L23;
        r21.k = r17.getSkuType();
        r21.l = r17.isInDepositPresale();
        r21.m = r17.isInSecKill();
        r21.n = r17.getCampaignEndTime();
    L43:
        if (r12 == null) goto L45;
        Integer r19 = Integer.valueOf(r12.getStatus());
    L47:
        if (r21.l == true) goto L54;
        Long r20 = r21.k;
        if (r20 == null) goto L54;
        if (r20.longValue() != 10) goto L54;
        ((LinearLayout) r21.Z().b(2131378867).f()).setOnClickListener(null);
        ((TextView) r21.Z().b(2131378863).f()).setOnClickListener(null);
    L56:
        if (r19 != null) goto L59;
    L73:
        ((LinearLayout) r21.Z().b(2131378867).f()).setBackgroundResource(2131247887);
        ((TextView) r21.Z().b(2131378863).f()).setEnabled(false);
    L74:
        SkuViewModel r22 = r21.f;
        if (r22 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L77:
        SkuInfoVO r23 = (SkuInfoVO) r22.getSkuInfo().a();
        if (r23 == null) goto L92;
        List<SkuBottomButtons> r24 = r23.getDefaultButtons();
        if (r24 == null) goto L92;
        Iterator<T> r25 = r24.iterator();
    L83:
        if (r25.hasNext() == false) goto L90;
        Object r26 = r25.next();
        if (((SkuBottomButtons) r26).getButtonType() != 1) goto L87;
        boolean r110 = true;
    L88:
        if (r110 == false) goto L83;
    L91:
        SkuBottomButtons r27 = (SkuBottomButtons) r26;
    L93:
        if (r27 == null) goto L95;
        boolean r28 = true;
    L96:
        if (r28 == false) goto L177;
        r21.g = false;
        if (r12 == null) goto L134;
        SkuViewModel r29 = r21.f;
        if (r29 != null) goto L103;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L103:
        if (r29.getSkuParams().getApplyCoupon() != 1) goto L134;
        Long r30 = r12.getUnUseMinPrice();
        if (r30 == null) goto L107;
        long r111 = r30.longValue();
        long r31 = 0;
    L109:
        if (r111 < r31) goto L134;
        if (r10 > r31) goto L122;
        long r32 = r12.getMinPrice();
        SkuViewModel r33 = r21.f;
        if (r33 != null) goto L115;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L115:
        long r34 = r32 * r33.getCurrentCount();
        Long r35 = r12.getUnUseMinPrice();
        if (r35 == null) goto L118;
        long r36 = r35.longValue();
    L120:
        if (r34 >= r36) goto L131;
    L132:
        boolean r37 = false;
    L133:
        r21.g = r37;
    L131:
        r37 = true;
        goto L133
    L118:
        r36 = 0;
        goto L120
    L122:
        SkuViewModel r38 = r21.f;
        if (r38 != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L125:
        long r39 = r10 * r38.getCurrentCount();
        Long r40 = r12.getUnUseMinPrice();
        if (r40 == null) goto L128;
        long r41 = r40.longValue();
    L130:
        if (r39 < r41) goto L132;
    L128:
        r41 = 0;
        goto L130
    L107:
        r31 = 0;
        r111 = 0;
    L134:
        if (r12 == null) goto L155;
        Map<String, SkuItemInfoVO> r42 = r12.getSkuList();
        if (r42 == null) goto L155;
        SkuItemInfoVO r43 = r42.get(r15);
        if (r43 == null) goto L155;
        List<SkuBottomButtons> r44 = r43.getButtons();
        if (r44 == null) goto L155;
        Iterator<T> r45 = r44.iterator();
    L143:
        if (r45.hasNext() == false) goto L150;
        Object r46 = r45.next();
        if (((SkuBottomButtons) r46).getButtonType() != 1) goto L147;
        boolean r47 = true;
    L148:
        if (r47 == false) goto L143;
    L151:
        SkuBottomButtons r48 = (SkuBottomButtons) r46;
        if (r48 == null) goto L155;
        String r49 = r48.getText();
        if (r49 == null) goto L155;
    L172:
        if (r49 != null) goto L176;
        if (r12 == null) goto L175;
        r49 = r12.getButtonLabel();
        goto L176
    L175:
        r49 = null;
    L176:
        ((TextView) r21.Z().b(2131391440).f()).setText(r49);
        goto L177
    L147:
        r47 = false;
        goto L148
    L150:
        r46 = null;
    L155:
        if (r12 == null) goto L171;
        List<SkuBottomButtons> r50 = r12.getDefaultButtons();
        if (r50 == null) goto L171;
        Iterator<T> r51 = r50.iterator();
    L160:
        if (r51.hasNext() == false) goto L167;
        Object r52 = r51.next();
        if (((SkuBottomButtons) r52).getButtonType() != 1) goto L164;
        boolean r53 = true;
    L165:
        if (r53 == false) goto L160;
    L168:
        SkuBottomButtons r54 = (SkuBottomButtons) r52;
        if (r54 == null) goto L171;
        r49 = r54.getText();
        goto L172
    L164:
        r53 = false;
        goto L165
    L167:
        r52 = null;
    L171:
        r49 = null;
    L177:
        if (r12 == null) goto L184;
        Map<String, SkuItemInfoVO> r55 = r12.getSkuList();
        if (r55 == null) goto L184;
        SkuItemInfoVO r56 = r55.get(r15);
        if (r56 == null) goto L184;
        List<SkuBottomButtons> r57 = r56.getButtons();
        if (r57 == null) goto L184;
    L187:
        r21.n0(r57);
        SkuViewModel r58 = r21.f;
        if (r58 != null) goto L190;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L190:
        r58.setDelayedDispatch(null);
        SkuViewModel r59 = r21.f;
        if (r59 != null) goto L194;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L194:
        if (jg.g.a(r59.getComboId()) == false) goto L293;
        if (r12 == null) goto L295;
        Map<String, SkuItemInfoVO> r60 = r12.getSkuList();
        if (r60 == null) goto L295;
        Collection<SkuItemInfoVO> r61 = r60.values();
        if (r61 == null) goto L295;
        Iterator<T> r62 = r61.iterator();
    L202:
        if (r62.hasNext() == false) goto L209;
        Object r63 = r62.next();
        String r112 = ((SkuItemInfoVO) r63).getId();
        SkuViewModel r113 = r21.f;
        if (r113 != null) goto L207;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L207:
        if (Intrinsics.areEqual(r112, r113.getComboId()) == false) goto L202;
    L210:
        SkuItemInfoVO r64 = (SkuItemInfoVO) r63;
        if (r64 == null) goto L295;
        SkuViewModel r65 = r21.f;
        if (r65 != null) goto L215;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L215:
        long r114 = r65.getCurrentCount();
        String r66 = r64.getDeliveryDelayDesc();
        if (r66 != null) goto L218;
    L221:
        boolean r67 = true;
    L222:
        if (r67 == true) goto L295;
        TextView r68 = (TextView) r21.Z().b(2131391445).f();
        int r69 = r64.getNowStock();
        long r115 = r64.getStockNum();
        if (r64.getDeliveryDelayDesc() == null) goto L227;
        r64.getDeliveryDelayBackground();
    L227:
        long r116 = r115 + 1;
        long r70 = r69;
        if (0 <= r70) goto L231;
    L265:
        SimpleDraweeView r71 = r21.Z().b(2131376613).f();
        if (v.a(r64) == false) goto L283;
        String r72 = r64.getDelayDescIcon();
        if (r72 != null) goto L270;
    L273:
        boolean r73 = true;
    L274:
        if (r73 == true) goto L283;
        CharSequence r74 = r68.getText();
        if (r74 != null) goto L278;
    L281:
        if (r18 == true) goto L283;
        r71.setVisibility(0);
        r71.setImageURI(r64.getDelayDescIcon());
    L285:
        if (v.a(r64) == false) goto L287;
        float r75 = 13.0f;
    L288:
        r68.setTextSize(2, r75);
        Context r76 = r21.Y().c();
        if (v.a(r64) == false) goto L291;
        int r77 = 2131106226;
    L292:
        r68.setTextColor(th.a.a(r76, r77));
        goto L295
    L291:
        r77 = 2131106228;
        goto L292
    L287:
        r75 = 11.0f;
        goto L288
    L278:
        if (r74.length() == 0) goto L281;
        r18 = false;
        goto L281
    L270:
        if (r72.length() == 0) goto L273;
        r73 = false;
    L283:
        r71.setVisibility(8);
        goto L285
    L231:
        if (r116 <= r70) goto L265;
        if (r114 > r70) goto L256;
        if (((TextView) r21.Z().b(2131391464).f()).getVisibility() == 0) goto L237;
        r68.setVisibility(0);
        r21.Z().b(2131386840).f().setVisibility(0);
    L237:
        r21.i = true;
        r68.setText(r64.getDeliveryDelayDesc());
        String r78 = r64.getDeliveryDelayDesc();
        if (r78 != null) goto L240;
    L243:
        boolean r79 = true;
    L244:
        if (r79 == true) goto L250;
        int r80 = com.bytedance.android.ec.core.utils.s.a;
        Integer r81 = com.bytedance.android.ec.core.utils.s.b(r64.getDeliveryDelayBackground());
        if (r81 == null) goto L248;
        r21.Z().b(2131386840).f().setBackgroundColor(r81.intValue());
    L249:
        if (r81 == null) goto L250;
    L251:
        SkuViewModel r82 = r21.f;
        if (r82 != null) goto L254;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L254:
        r82.setDelayedDispatch(0);
        goto L265
    L248:
        r81 = null;
    L250:
        r21.Z().b(2131386840).f().setBackgroundColor(0);
        goto L251
    L240:
        if (r78.length() == 0) goto L243;
        r79 = false;
        goto L244
    L256:
        if (r114 <= r115) goto L258;
        r68.setVisibility(8);
        r21.Z().b(2131386840).f().setVisibility(8);
        r21.i = false;
        goto L265
    L258:
        if (((TextView) r21.Z().b(2131391464).f()).getVisibility() == 0) goto L260;
        r68.setVisibility(0);
        r21.Z().b(2131386840).f().setVisibility(0);
    L260:
        r68.setText(r64.getPresellDelayDesc());
        r21.i = true;
        SkuViewModel r83 = r21.f;
        if (r83 != null) goto L263;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L263:
        r83.setDelayedDispatch(1);
        goto L265
    L218:
        if (r66.length() == 0) goto L221;
        r67 = false;
        goto L222
    L209:
        r63 = null;
    L295:
        if (r21.l == false) goto L300;
        if (r21.j == true) goto L300;
        r21.o0();
        return;
    L300:
        if (r21.m == true) goto L302;
    L306:
        ((TextView) r21.Z().b(2131391441).f()).setVisibility(8);
        return;
    L302:
        if (r21.j == true) goto L306;
        if (((r21.n - SystemClock.elapsedRealtime()) / 1000) > 86400) goto L327;
        r21.o0();
        return;
    L327:
        return;
    L293:
        ((TextView) r21.Z().b(2131391445).f()).setVisibility(8);
        r21.Z().b(2131376613).f().setVisibility(8);
        r21.Z().b(2131386840).f().setVisibility(8);
        r21.i = false;
    L184:
        if (r12 == null) goto L186;
        r57 = r12.getDefaultButtons();
        goto L187
    L186:
        r57 = null;
        goto L187
    L95:
        r28 = false;
        goto L96
    L87:
        r110 = false;
        goto L88
    L90:
        r26 = null;
    L92:
        r27 = null;
        goto L93
    L59:
        if (r19.intValue() != 2) goto L73;
        if (r12.isSoldOut() == true) goto L73;
        if (r12.isUnderStock() == true) goto L73;
        if (r21.l == true) goto L72;
        Long r84 = r21.k;
        if (r84 == null) goto L72;
        if (r84.longValue() == 10) goto L73;
    L72:
        ((LinearLayout) r21.Z().b(2131378867).f()).setBackgroundResource(2131247920);
        ((TextView) r21.Z().b(2131378863).f()).setEnabled(true);
    L54:
        ((LinearLayout) r21.Z().b(2131378867).f()).setOnClickListener((ButtonPresenter$newClick$2.a) r21.o.getValue());
        ((TextView) r21.Z().b(2131378863).f()).setOnClickListener((ButtonPresenter$newClick$2.a) r21.o.getValue());
        goto L56
    L45:
        r19 = null;
        goto L47
    L23:
        if (r12 == null) goto L25;
        Long r85 = r12.getSkuType();
    L26:
        r21.k = r85;
        if (r12 != null) goto L29;
    L31:
        boolean r86 = false;
    L32:
        r21.l = r86;
        if (r12 != null) goto L35;
    L37:
        boolean r87 = false;
    L38:
        r21.m = r87;
        if (r12 == null) goto L41;
        long r117 = r12.getCampaignEndTime();
    L42:
        r21.n = r117;
        goto L43
    L41:
        r117 = 0;
        goto L42
    L35:
        if (r12.isInSecKillDefault() != true) goto L37;
        r87 = true;
        goto L38
    L29:
        if (r12.isInDepositPresaleDefault() != true) goto L31;
        r86 = true;
        goto L32
    L25:
        r85 = null;
    L19:
        r17 = null;
        goto L20
    L14:
        r15 = null;
        goto L15
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
        this.j = r17;
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
        r120.getCancelDownTimer().b(ECQuickUtilKt.a(Y()), new n(this));
    L95:
        SkuViewModel r121 = this.f;
        if (r121 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L98:
        r121.m1027getCurrentCount().b(ECQuickUtilKt.a(Y()), new o(this));
        int r122 = qf.a.a;
        SkuViewModel r123 = this.f;
        if (r123 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L102:
        if (qf.a.e.a(r123.getSkuParams()) == true) goto L107;
        SkuViewModel r124 = this.f;
        if (r124 != null) goto L106;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L106:
        r124.m1028getCurrentPrice().b(ECQuickUtilKt.a(Y()), new p(this));
    L111:
        SkuViewModel r125 = this.f;
        if (r125 != null) goto L114;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L114:
        r125.getSkuInfo().b(ECQuickUtilKt.a(Y()), new r(this));
        SkuViewModel r126 = this.f;
        if (r126 != null) goto L117;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L117:
        r126.getApplyCouponSuccess().b(ECQuickUtilKt.a(Y()), new ActionObserver(new ButtonPresenter$initSubscribe$6(this)));
        SkuViewModel r127 = this.f;
        if (r127 != null) goto L120;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L120:
        r127.getCheckPayNotificationAction().b(ECQuickUtilKt.a(Y()), new s(this));
        SkuViewModel r128 = this.f;
        if (r128 != null) goto L123;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L123:
        r128.getDoAddCartMotionAction().b(ECQuickUtilKt.a(Y()), new ActionObserver(new ButtonPresenter$initSubscribe$8(this)));
        SkuViewModel r129 = this.f;
        if (r129 != null) goto L126;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L126:
        r129.getUnCheckedName().b(ECQuickUtilKt.a(Y()), new t(this));
        return;
    L107:
        SkuViewModel r130 = this.f;
        if (r130 != null) goto L110;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L110:
        r130.getOnItemChange().b(Y().e(), new q(this));
        goto L111
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

    public final void n0(List<SkuBottomButtons> r10) {
        if (r10 == null) goto L17;
        Iterator<T> r0 = r10.iterator();
    L5:
        if (r0.hasNext() == false) goto L30;
        SkuBottomButtons r1 = (SkuBottomButtons) r0.next();
        if (r10.size() == 1) goto L8;
        if (r1.getButtonType() == 2) goto L11;
        if (r1.getButtonType() == 1) goto L16;
        if (r1.getButtonType() != 3) goto L5;
    L16:
        ((LinearLayout) Z().b(2131378867).f()).setVisibility(0);
        ((TextView) Z().b(2131391440).f()).setText(r1.getText());
        ((LinearLayout) Z().b(2131378867).f()).setEnabled(!r1.isGray());
        ((LinearLayout) Z().b(2131378867).f()).setTag(Integer.valueOf(r1.getButtonType()));
        goto L5
    L11:
        ((TextView) Z().b(2131378863).f()).setVisibility(0);
        ((TextView) Z().b(2131378863).f()).setText(r1.getText());
        ((TextView) Z().b(2131378863).f()).setEnabled(!r1.isGray());
        ((TextView) Z().b(2131378863).f()).setTag(Integer.valueOf(r1.getButtonType()));
        goto L5
    L8:
        ((LinearLayout) Z().b(2131378867).f()).setVisibility(0);
        ((TextView) Z().b(2131391440).f()).setText(r1.getText());
        ((LinearLayout) Z().b(2131378867).f()).setEnabled(!r1.isGray());
        ((LinearLayout) Z().b(2131378867).f()).setTag(Integer.valueOf(r1.getButtonType()));
        ((TextView) Z().b(2131378863).f()).setVisibility(8);
        goto L5
    L30:
        return;
    }

    public final void p0(String r13) {
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

    public final void q0(boolean r10) {
        if (r10 == false) goto L5;
        ((TextView) Z().b(2131391464).f()).setVisibility(0);
        ((TextView) Z().b(2131391445).f()).setVisibility(8);
        Z().b(2131376613).f().setVisibility(8);
        Z().b(2131386840).f().setVisibility(8);
        return;
    L5:
        ((TextView) Z().b(2131391464).f()).setVisibility(8);
        if (this.i == false) goto L10;
        ((TextView) Z().b(2131391445).f()).setVisibility(0);
        Z().b(2131386840).f().setVisibility(0);
        return;
    }

    public static final void h0(ButtonPresenter r14, com.bytedance.android.ec.model.response.p r15) {
        r14.getClass();
        long r0 = r15.c;
        if (r0 <= 0) goto L22;
        long r10 = IServerListener.WHAT_BYTELINK_SINK_ERROR;
        long r1 = (r0 * r10) - System.currentTimeMillis();
        if (r1 <= 0) goto L17;
        StringBuilder r11 = new StringBuilder();
        long r12 = 60000;
        long r13 = r1 / r12;
        long r16 = r1 - (r12 * r13);
        long r17 = 9;
        if (r13 > r17) goto L9;
        r11.append(0);
    L9:
        r11.append(r13);
        r11.append(":");
        long r18 = r16 / r10;
        if (r18 > r17) goto L12;
        r11.append(0);
    L12:
        r11.append(r18);
        String r19 = r15.a;
        if (r19 == null) goto L28;
        Intrinsics.checkNotNull(r19);
        if (StringsKt.contains$default(r19, "${t}", false, 2, null) == false) goto L28;
        String r20 = r15.a;
        Intrinsics.checkNotNull(r20);
        String r110 = StringsKt.replace$default(r20, "${t}", r11.toString(), false, 4, null);
    L30:
        if (TextUtils.isEmpty(r110) == true) goto L32;
        ((TextView) r14.Z().b(2131391464).f()).setText(r110);
        r14.q0(true);
        return;
    L32:
        r14.q0(false);
        return;
    L28:
        r110 = "";
        goto L30
    L17:
        r14.q0(false);
        SkuViewModel r111 = r14.f;
        if (r111 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L20:
        SkuViewModel.checkPayNotification$default(r111, false, null, 2, null);
        goto L28
    L22:
        if (r15.d <= 0) goto L28;
        String r21 = r15.a;
        if (r21 == null) goto L28;
        Intrinsics.checkNotNull(r21);
        if (StringsKt.contains$default(r21, "${t}", false, 2, null) == false) goto L28;
        String r22 = r15.a;
        Intrinsics.checkNotNull(r22);
        r110 = StringsKt.replace$default(r22, "${t}", String.valueOf(r15.d), false, 4, null);
        goto L30
    }

    public final void k0(sc3.b r29, String r30) {
        SkuViewModel r10 = this.f;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuInfoVO r11 = (SkuInfoVO) r10.getSkuInfo().a();
        if (r11 == null) goto L8;
        SkuPoiInfo r12 = r11.getPoiInfo();
    L9:
        if (r12 == null) goto L11;
        Long r13 = r12.getTotal();
    L12:
        Set<String> r14 = ECProcessMonitor.a;
        com.bytedance.android.ec.core.monitor.listener.b r15 = ECProcessMonitor.e("ec_sku");
        JSONObject r16 = new JSONObject();
        SkuViewModel r17 = this.f;     // Catch: Exception -> L25
        if (r17 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: Exception -> L25
    L16:
        r16.put(com.bytedance.android.ec.core.event.a.KEY_ENTER_FROM, r17.getSkuParams().getSourcePage());     // Catch: Exception -> L25
        SkuViewModel r18 = this.f;     // Catch: Exception -> L25
        if (r18 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: Exception -> L25
    L19:
        String r19 = r18.getSkuParams().getEntranceInfo();     // Catch: Exception -> L25
        if (r19 == null) goto L27;
        JSONObject r110 = jg.g.f(r19);     // Catch: Exception -> L25
        if (r110 == null) goto L27;
        r16.put(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_SOURCE_PAGE, r110.optString(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_SOURCE_PAGE));     // Catch: Exception -> L25
        r16.put(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, r110.optString(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL));     // Catch: Exception -> L25
    L27:
        Unit r0 = Unit.INSTANCE;
        ActionRateListener.c(r15, r16, null, false, 6);
        Set<String> r1 = ECProcessMonitor.a;
        ECProcessMonitor.e("ec_sku").d();
        if (r12 == null) goto L41;
        if (r13 == null) goto L41;
        if (r13.longValue() <= 0) goto L41;
        if (r12.getSelectedPoiInfo() != null) goto L41;
        SkuViewModel r20 = this.f;
        if (r20 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L38:
        if (r20.getSelectPoiInfo().a() != null) goto L41;
        UIUtils.displayToast(Y().c(), th.a.f(Y().c()).getString(2131914034));
        com.bytedance.android.ec.core.monitor.listener.b.k(ECProcessMonitor.e("ec_sku"), -4, null, 30);
        return;
    L41:
        SkuViewModel r21 = this.f;
        if (r21 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L44:
        SkuInfoVO r22 = (SkuInfoVO) r21.getSkuInfo().a();
        String r23 = "";
        if (r22 == null) goto L51;
        OrderComponent r24 = r22.getOrderComponent();
        if (r24 == null) goto L51;
        String r25 = r24.getOrderUrl();
        if (r25 == null) goto L51;
    L68:
        if (r25.length() <= 0) goto L70;
        boolean r111 = true;
    L71:
        if (r111 == true) goto L74;
        r25 = null;
    L74:
        if (r25 == null) goto L243;
        int r112 = ECSdk.a;
        IAdapterService r113 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r113 == null) goto L80;
        com.bytedance.android.ec.adapter.api.j r114 = r113.getLiveWindowService();
        if (r114 == null) goto L80;
        r114.stopShowFloatInNextLifecycle();
    L80:
        if (r29 == null) goto L82;
        r29.c(ChainPoint.CREATE_SCHEMA_START, null);
    L82:
        BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b5267.c7323.d7439", Boolean.FALSE).withView(a0()).build());
        SkuViewModel r115 = this.f;
        if (r115 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L85:
        SkuParams r116 = r115.getSkuParams();
        Map<String, com.bytedance.android.ec.core.monitor.a> r117 = com.bytedance.android.ec.core.monitor.c.a;
        String r118 = com.bytedance.android.ec.core.monitor.c.c(MonitorScenes.EC_JSON_DEAL_DURATION, null);
        com.bytedance.android.ec.core.monitor.c.e(r118, "type", com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        com.bytedance.android.ec.core.monitor.c.e(r118, "scene", "live");
        com.bytedance.android.ec.core.monitor.c.f(r118, com.bytedance.android.ec.core.event.a.KEY_URL, r25);
        if (r116.isLiveSkuCheck() == false) goto L91;
        com.bytedance.android.ec.core.monitor.c.e(r118, "scene", "live");
        com.bytedance.android.ec.core.monitor.c.h(r118, MetricNames.DEAL_DURATION, null);
        int r26 = com.bytedance.android.ec.common.impl.sku.utils.g.a;
        SkuViewModel r27 = this.f;
        if (r27 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L90:
        String r28 = com.bytedance.android.ec.common.impl.sku.utils.g.a(r30, r27);
    L95:
        com.bytedance.android.ec.core.monitor.c.j(r118, MetricNames.DEAL_DURATION);
        com.bytedance.android.ec.core.monitor.c.d(r118);
        Observable.fromCallable(new u(r28, Y().c())).subscribeOn(Schedulers.io()).subscribe();
        String r31 = com.bytedance.android.ec.core.btm.c.c(r28, a0(), "a1.b5267.c7323.d7439", new Pair[0]);
        int r32 = com.bytedance.android.ec.common.impl.sku.utils.p.a;
        Intrinsics.checkNotNullParameter(r31, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (StringsKt.contains$default(r31, "webcast_webview", false, 2, null) == false) goto L106;
        int r33 = jg.f.a;
        SkuViewModel r34 = this.f;
        if (r34 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L101:
        if (jg.f.a(r34) == false) goto L106;
        SkuViewModel r35 = this.f;
        if (r35 != null) goto L105;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L105:
        r31 = com.bytedance.android.ec.common.impl.sku.utils.p.b(r31, r35.getSkuParams().isLiveSkuCheck(), 2);
    L106:
        if (r29 == null) goto L108;
        r29.c(ChainPoint.CREATE_SCHEMA_END, null);
    L108:
        if (r29 == null) goto L112;
        String r36 = r29.b(r31);
        if (r36 == null) goto L112;
        r31 = r36;
    L112:
        IEShoppingService r37 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r37 == null) goto L117;
        sc3.c r38 = r37.getBuyNowService();
        if (r38 == null) goto L117;
        r38.j(r31, "a1.b5267.c7323.d7439");
    L117:
        Activity r39 = jg.h.a.getActivity(a0());
        if (r39 == null) goto L132;
        ECProcessMonitor.e("ec_sku").g();
        int r40 = com.bytedance.android.ec.common.impl.sku.utils.i.a;
        SkuViewModel r41 = this.f;
        if (r41 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L122:
        String r42 = r41.getSkuParams().getPromotionLogId();
        if (r42 != null) goto L125;
        r42 = "";
    L125:
        SkuViewModel r43 = this.f;
        if (r43 != null) goto L128;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L128:
        String r44 = r43.getSkuParams().getSkuLogId();
        if (r44 != null) goto L131;
        r44 = "";
    L131:
        com.bytedance.android.ec.common.impl.sku.utils.i.a(r31, r39, r42, r44, false);
    L132:
        SkuViewModel r45 = this.f;
        if (r45 != null) goto L136;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L136:
        if (r45.getHalfCloseSku() != 1) goto L141;
        SkuViewModel r46 = this.f;
        if (r46 != null) goto L140;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L140:
        SkuViewModel.closeDialogFragment$default(r46, null, 1, null);
    L141:
        SkuViewModel r47 = this.f;
        if (r47 != null) goto L144;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L144:
        SkuParams r48 = r47.getSkuParams();
        String r49 = r48.getEntranceInfo();
        if (r49 != null) goto L239;
    L149:
        String r50 = "";
    L150:
        String r51 = (String) r48.getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE);
        if (r48.isFromMatchPurchase() == false) goto L153;
        String r52 = "1";
    L155:
        if (Intrinsics.areEqual(r51, com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_FLOW_PAGE) == false) goto L199;
        if (r48.isFromPlayback() == false) goto L199;
        if (Intrinsics.areEqual(r23, "product_ranking_homepage") == false) goto L179;
        SkuViewModel r53 = this.f;
        if (r53 != null) goto L163;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L163:
        SpreadBuilder r119 = new SpreadBuilder(10);
        SkuViewModel r120 = this.f;
        if (r120 != null) goto L166;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L166:
        r119.add(TuplesKt.to("coupon_id", r120.getApplyCouponIds()));
        SkuViewModel r121 = this.f;
        if (r121 != null) goto L169;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L169:
        r119.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r121.getComboId()));
        r119.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE, r51));
        r119.add(TuplesKt.to("product_detail_reply", "1"));
        r119.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PREVIOUS_PAGE, r50));
        r119.add(TuplesKt.to("is_matching_product", r52));
        SkuViewModel r54 = this.f;
        if (r54 != null) goto L172;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L172:
        r119.add(TuplesKt.to("recommend_fxh_method", r54.getRecommendTermCount()));
        SkuViewModel r55 = this.f;
        if (r55 != null) goto L175;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L175:
        r119.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD_LIST, ArraysKt.joinToString$default(CollectionsKt.toIntArray(r55.getTermCountList()), ",", null, null, 0, null, null, 62, null)));
        SkuViewModel r56 = this.f;
        if (r56 != null) goto L178;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L178:
        r119.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD, r56.getSelectFxhMethod()));
        r119.addSpread(j0());
        SkuViewModel.doSkuEventAction$default(r53, "confirm_product_params", (Pair[]) r119.toArray(new Pair[r119.size()]), "a1.b5267.c7323.d7439", PageFinder.via(((QFragmentPresenter) this).e), null, 16, null);
        return;
    L179:
        SkuViewModel r57 = this.f;
        if (r57 != null) goto L182;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L182:
        SpreadBuilder r122 = new SpreadBuilder(9);
        SkuViewModel r58 = this.f;
        if (r58 != null) goto L185;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L185:
        r122.add(TuplesKt.to("coupon_id", r58.getApplyCouponIds()));
        SkuViewModel r59 = this.f;
        if (r59 != null) goto L188;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L188:
        r122.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r59.getComboId()));
        r122.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE, r51));
        r122.add(TuplesKt.to("product_detail_reply", "1"));
        r122.add(TuplesKt.to("is_matching_product", r52));
        r122.addSpread(j0());
        SkuViewModel r60 = this.f;
        if (r60 != null) goto L191;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L191:
        r122.add(TuplesKt.to("recommend_fxh_method", r60.getRecommendTermCount()));
        SkuViewModel r61 = this.f;
        if (r61 != null) goto L194;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L194:
        r122.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD_LIST, ArraysKt.joinToString$default(CollectionsKt.toIntArray(r61.getTermCountList()), ",", null, null, 0, null, null, 62, null)));
        SkuViewModel r62 = this.f;
        if (r62 != null) goto L197;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L197:
        r122.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD, r62.getSelectFxhMethod()));
        SkuViewModel.doSkuEventAction$default(r57, "confirm_product_params", (Pair[]) r122.toArray(new Pair[r122.size()]), "a1.b5267.c7323.d7439", PageFinder.via(((QFragmentPresenter) this).e), null, 16, null);
        return;
    L199:
        if (Intrinsics.areEqual(r23, "product_ranking_homepage") == false) goto L219;
        SkuViewModel r63 = this.f;
        if (r63 != null) goto L203;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L203:
        SpreadBuilder r64 = new SpreadBuilder(8);
        SkuViewModel r65 = this.f;
        if (r65 != null) goto L206;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L206:
        r64.add(TuplesKt.to("coupon_id", r65.getApplyCouponIds()));
        SkuViewModel r66 = this.f;
        if (r66 != null) goto L209;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L209:
        r64.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r66.getComboId()));
        r64.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PREVIOUS_PAGE, r50));
        r64.add(TuplesKt.to("is_matching_product", r52));
        r64.addSpread(j0());
        SkuViewModel r67 = this.f;
        if (r67 != null) goto L212;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L212:
        r64.add(TuplesKt.to("recommend_fxh_method", r67.getRecommendTermCount()));
        SkuViewModel r68 = this.f;
        if (r68 != null) goto L215;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L215:
        r64.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD_LIST, ArraysKt.joinToString$default(CollectionsKt.toIntArray(r68.getTermCountList()), ",", null, null, 0, null, null, 62, null)));
        SkuViewModel r69 = this.f;
        if (r69 != null) goto L218;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L218:
        r64.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD, r69.getSelectFxhMethod()));
        SkuViewModel.doSkuEventAction$default(r63, "confirm_product_params", (Pair[]) r64.toArray(new Pair[r64.size()]), "a1.b5267.c7323.d7439", PageFinder.via(((QFragmentPresenter) this).e), null, 16, null);
        return;
    L219:
        SkuViewModel r70 = this.f;
        if (r70 != null) goto L222;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L222:
        SpreadBuilder r71 = new SpreadBuilder(7);
        SkuViewModel r72 = this.f;
        if (r72 != null) goto L225;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L225:
        r71.add(TuplesKt.to("coupon_id", r72.getApplyCouponIds()));
        SkuViewModel r73 = this.f;
        if (r73 != null) goto L228;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L228:
        r71.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r73.getComboId()));
        r71.add(TuplesKt.to("is_matching_product", r52));
        r71.addSpread(j0());
        SkuViewModel r74 = this.f;
        if (r74 != null) goto L231;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L231:
        r71.add(TuplesKt.to("recommend_fxh_method", r74.getRecommendTermCount()));
        SkuViewModel r75 = this.f;
        if (r75 != null) goto L234;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L234:
        r71.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD_LIST, ArraysKt.joinToString$default(CollectionsKt.toIntArray(r75.getTermCountList()), ",", null, null, 0, null, null, 62, null)));
        SkuViewModel r76 = this.f;
        if (r76 != null) goto L237;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L237:
        r71.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD, r76.getSelectFxhMethod()));
        SkuViewModel.doSkuEventAction$default(r70, "confirm_product_params", (Pair[]) r71.toArray(new Pair[r71.size()]), "a1.b5267.c7323.d7439", PageFinder.via(((QFragmentPresenter) this).e), null, 16, null);
        return;
    L153:
        r52 = "0";
        goto L155
    L239:
        JSONObject r77 = new JSONObject(r49);     // Catch: Exception -> L148
        r23 = r77.optString(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, "");
        r50 = r77.optString(com.bytedance.android.ec.core.event.a.KEY_PREVIOUS_PAGE, "");
        goto L150
    L91:
        com.bytedance.android.ec.core.monitor.c.e(r118, "scene", "video");
        com.bytedance.android.ec.core.monitor.c.h(r118, MetricNames.DEAL_DURATION, null);
        int r78 = com.bytedance.android.ec.common.impl.sku.utils.c.a;
        SkuViewModel r79 = this.f;
        if (r79 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L94:
        r28 = com.bytedance.android.ec.common.impl.sku.utils.c.a(r25, r79);
        goto L95
    L243:
        return;
    L70:
        r111 = false;
    L51:
        SkuViewModel r80 = this.f;
        if (r80 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L54:
        r25 = r80.getSkuParams().getH5Url();
        if (r25 != null) goto L57;
    L64:
        if (r30 != null) goto L66;
        r25 = "";
        goto L68
    L66:
        r25 = r30;
        goto L68
    L57:
        if (r25.length() <= 0) goto L59;
        boolean r123 = true;
    L60:
        if (r123 == true) goto L63;
        r25 = null;
    L63:
        if (r25 != null) goto L68;
    L59:
        r123 = false;
    L25:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L27
    L11:
        r13 = null;
        goto L12
    L8:
        r12 = null;
        goto L9
    }

    public static final void d0(ButtonPresenter r10, boolean r11, sc3.b r12) {
        SkuViewModel r0 = r10.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuInfoVO r1 = (SkuInfoVO) r0.getSkuInfo().a();
        if (r1 == null) goto L10;
        OrderComponent r13 = r1.getOrderComponent();
        if (r13 == null) goto L10;
        String r14 = r13.getOrderUrl();
    L12:
        if (r14 == null) goto L23;
        int r15 = jg.e.a;
        SkuViewModel r16 = r10.f;
        if (r16 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L16:
        String r17 = r16.getComboId();
        if (r17 != null) goto L19;
        r17 = "";
    L19:
        String r18 = jg.e.c(r14, com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r17);
        SkuViewModel r19 = r10.f;
        if (r19 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L22:
        r14 = jg.e.c(r18, "combo_num", String.valueOf(r19.getCurrentCount()));
    L23:
        if (r14 == null) goto L34;
        SkuViewModel r20 = r10.f;
        if (r20 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L28:
        if (r20.getSkuParams().isLiveSkuCheck() == false) goto L33;
        SkuViewModel r21 = r10.f;
        if (r21 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L32:
        r21.setHalfCloseSku(0);
    L33:
        r10.l0(r11, r14, r12);
        return;
    L34:
        r10.l0(r11, "", r12);
        Lazy r22 = SkuLog.a;
        SkuLog.a("ButtonPresenter", "finalOrderUrl is null: " + r14);
        return;
    L10:
        r14 = null;
        goto L12
    }

    public final void l0(boolean r30, String r31, sc3.b r32) {
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
        p0("cart");
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
        String r33 = r24.getShopId();
        if (r33 != null) goto L55;
        String r119 = "";
    L56:
        SkuViewModel r34 = this.f;
        if (r34 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L59:
        String r35 = r34.getComboId();
        if (r35 != null) goto L62;
        String r210 = "";
    L63:
        SkuViewModel r36 = this.f;
        if (r36 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L66:
        String r211 = String.valueOf(r36.getCurrentCount());
        SkuViewModel r37 = this.f;
        if (r37 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L69:
        List<String> r38 = r37.getCheckedIdArray();
        if (r38 == null) goto L76;
        Object[] r39 = r38.toArray(new String[0]);
        if (r39 == null) goto L75;
        String[] r40 = (String[]) r39;
    L77:
        String[] r212 = r40;
        String r41 = r24.getTrackExtra();
        if (r41 != null) goto L80;
        String r213 = "";
    L81:
        String r214 = BtmSDK.INSTANCE.getPageId(PageFinder.via(((QFragmentPresenter) this).e));
        String r42 = r24.getChannelId();
        if (r42 != null) goto L84;
        String r215 = "";
    L85:
        Integer r43 = r24.getChannelType();
        if (r43 == null) goto L88;
        int r216 = r43.intValue();
    L89:
        com.bytedance.android.ec.common.impl.sku.utils.h.b(r26, r111, r110, r112, r113, r114, r115, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r24.getBizCampaignType(), r24.getCpsTrack());
        SkuViewModel r44 = this.f;
        if (r44 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L92:
        String r45 = r44.getSkuParams().getEntranceInfo();
        if (r45 != null) goto L196;
    L97:
        String r46 = "";
        String r47 = r46;
    L98:
        String r48 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b5267.c7323.d1871", Boolean.FALSE).withView(a0()).build());
        SkuViewModel r49 = this.f;
        if (r49 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L102:
        if (r49.getSkuParams().isFromAnchorV3() == true) goto L104;
        SkuViewModel r50 = this.f;
        if (r50 != null) goto L123;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L123:
        if (r50.getSkuParams().isFromVideoFeed() == false) goto L131;
        SkuViewModel r120 = this.f;
        if (r120 != null) goto L127;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L127:
        SpreadBuilder r51 = new SpreadBuilder(4);
        r51.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, "sku_card"));
        SkuViewModel r52 = this.f;
        if (r52 != null) goto L130;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L130:
        r51.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r52.getSelectedSkuId()));
        r51.add(TuplesKt.to("btm_id", r48));
        r51.addSpread(j0());
        SkuViewModel.doSkuEventAction$default(r120, "confirm_add_to_cart", (Pair[]) r51.toArray(new Pair[r51.size()]), null, null, null, 28, null);
        goto L162
    L131:
        SkuViewModel r53 = this.f;
        if (r53 != null) goto L135;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L135:
        if (r53.getSkuParams().isLiveSkuCheck() == false) goto L155;
        SkuViewModel r121 = this.f;
        if (r121 != null) goto L139;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L139:
        SpreadBuilder r54 = new SpreadBuilder(6);
        r54.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, "sku_card"));
        SkuViewModel r55 = this.f;
        if (r55 != null) goto L142;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L142:
        r54.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r55.getSelectedSkuId()));
        SkuViewModel r56 = this.f;
        if (r56 != null) goto L145;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L145:
        String r57 = r56.getSkuParams().getTrackExtra();
        if (r57 != null) goto L194;
        String r58 = null;
    L151:
        r54.add(TuplesKt.to("cart_track", r58));
        SkuViewModel r59 = this.f;
        if (r59 != null) goto L154;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L154:
        r54.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r59.getSkuParams().getAddCartEntranceInfo()));
        r54.add(TuplesKt.to("btm_id", r48));
        r54.addSpread(j0());
        SkuViewModel.doSkuEventAction$default(r121, "click_add_to_cart", (Pair[]) r54.toArray(new Pair[r54.size()]), null, null, null, 28, null);
        goto L162
    L194:
        r58 = new JSONObject(r57).optString("cart_track");     // Catch: Exception -> L149
    L149:
        r58 = "";
        goto L151
    L155:
        SkuViewModel r60 = this.f;
        if (r60 != null) goto L158;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L158:
        SpreadBuilder r61 = new SpreadBuilder(4);
        r61.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, "sku_card"));
        SkuViewModel r62 = this.f;
        if (r62 != null) goto L161;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L161:
        r61.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r62.getSelectedSkuId()));
        r61.add(TuplesKt.to("btm_id", r48));
        r61.addSpread(j0());
        SkuViewModel.doSkuEventAction$default(r60, "confirm_add_to_cart", (Pair[]) r61.toArray(new Pair[r61.size()]), null, null, null, 28, null);
        goto L162
    L104:
        if (Intrinsics.areEqual(r46, "product_ranking_homepage") == false) goto L112;
        SkuViewModel r122 = this.f;
        if (r122 != null) goto L108;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L108:
        SpreadBuilder r63 = new SpreadBuilder(5);
        r63.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, "sku_card"));
        SkuViewModel r64 = this.f;
        if (r64 != null) goto L111;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L111:
        r63.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r64.getSelectedSkuId()));
        r63.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PREVIOUS_PAGE, r47));
        r63.add(TuplesKt.to("btm_id", r48));
        r63.addSpread(j0());
        SkuViewModel.doSkuEventAction$default(r122, "confirm_add_to_cart", (Pair[]) r63.toArray(new Pair[r63.size()]), null, null, null, 28, null);
        goto L162
    L112:
        SkuViewModel r65 = this.f;
        if (r65 != null) goto L115;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L115:
        SpreadBuilder r66 = new SpreadBuilder(4);
        r66.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, "sku_card"));
        SkuViewModel r67 = this.f;
        if (r67 != null) goto L118;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L118:
        r66.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r67.getSelectedSkuId()));
        r66.add(TuplesKt.to("btm_id", r48));
        r66.addSpread(j0());
        SkuViewModel.doSkuEventAction$default(r65, "confirm_add_to_cart", (Pair[]) r66.toArray(new Pair[r66.size()]), null, null, null, 28, null);
        goto L162
    L196:
        JSONObject r68 = new JSONObject(r45);     // Catch: Exception -> L96
        r46 = r68.optString(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, "");
        r47 = r68.optString(com.bytedance.android.ec.core.event.a.KEY_PREVIOUS_PAGE, "");
        goto L98
    L88:
        r216 = 0;
        goto L89
    L84:
        r215 = r42;
        goto L85
    L80:
        r213 = r41;
        goto L81
    L75:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L76:
        r40 = new String[0];
        goto L77
    L62:
        r210 = r35;
        goto L63
    L55:
        r119 = r33;
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
        SkuViewModel r69 = this.f;
        if (r69 != null) goto L172;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L172:
        if (r69.getCurrentCount() <= 0) goto L187;
        SkuViewModel r70 = this.f;
        if (r70 != null) goto L177;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L177:
        r70.logAdEvent();
        SkuViewModel r71 = this.f;
        if (r71 != null) goto L180;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L180:
        r71.setApplyCouponIds(null);
        if (this.g == false) goto L186;
        SkuViewModel r72 = this.f;
        if (r72 != null) goto L185;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L185:
        SkuViewModel.applyCouponAuto$default(r72, Y().c(), r32, r31, null, null, 24, null);
        goto L187
    L186:
        k0(r32, r31);
    L187:
        int r73 = ECSdk.a;
        IECUserTrackerService r74 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r74 == null) goto L192;
        of.a r75 = r74.getMarketingService();
        if (r75 == null) goto L192;
        r75.a(com.bytedance.android.ec.core.event.a.VALUE_CLICK_PURCHASE, PostActionType.DO, com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL);
    L192:
        p0("buy");
    }
}
