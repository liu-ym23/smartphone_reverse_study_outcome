package com.bytedance.android.ec.common.impl.sku.presenter;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.utils.CarModelSelectInfo;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.sku.CarAdaptComponent;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class CarModelOptimizePresenter extends QFragmentPresenter {
    public static final /* synthetic */ int p = 0;
    public SkuViewModel f;
    public boolean g;
    public Function1<? super String, Unit> h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ CarModelOptimizePresenter a;
        public final /* synthetic */ CarAdaptComponent b;

        public b(CarModelOptimizePresenter r1, CarAdaptComponent r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            Function1<? super String, Unit> r11 = this.a.h;
            if (r11 == null) goto L6;
            Unit r12 = (Unit) r11.invoke(this.b.getUrl());
            return;
        }
    }

    static {
    }

    public final void c0() {
        ECLiveHybridUtil.p("updateSelectedCarModel", com.bytedance.android.ec.core.utils.k.a);
        com.bytedance.android.ec.core.utils.s0.e(this);
    }

    public CarModelOptimizePresenter(Fragment r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        super(r10);
        this.g = true;
        this.i = LazyKt.lazy(new CarModelOptimizePresenter$ivModelStatus$2(this));
        this.j = LazyKt.lazy(new CarModelOptimizePresenter$tvCarDesc$2(this));
        this.k = LazyKt.lazy(new CarModelOptimizePresenter$tvCarModelAdd$2(this));
        this.l = LazyKt.lazy(new CarModelOptimizePresenter$tvCarModelStatus$2(this));
        this.m = LazyKt.lazy(new CarModelOptimizePresenter$tvSwitchModel$2(this));
        this.n = LazyKt.lazy(new CarModelOptimizePresenter$ivModelRightArrow$2(this));
        this.o = LazyKt.lazy(new CarModelOptimizePresenter$clModelContainer$2(this));
    }

    public final void b0(QModel r10) {
        SkuViewModel r11 = (SkuViewModel) Y().g(SkuViewModel.class);
        this.f = r11;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuInfoVO r12 = (SkuInfoVO) r11.getSkuInfo().a();
        if (r12 == null) goto L8;
        CarAdaptComponent r13 = r12.getCarAdaptComponent();
    L9:
        d0(r13);
        if (this.g == false) goto L16;
        SkuViewModel r14 = this.f;
        if (r14 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L14:
        r14.getCurrentCarAdaptComponent().b(ECQuickUtilKt.a(Y()), new w(this));
        ECLiveHybridUtil.m("updateSelectedCarModel", com.bytedance.android.ec.core.utils.k.a);
        com.bytedance.android.ec.core.utils.s0.c(this);
        this.g = false;
        return;
    L16:
        return;
    L8:
        r13 = null;
        goto L9
    }

    public final void d0(final CarAdaptComponent r13) {
        String r0 = null;
        if (r13 != null) goto L11;
        SkuViewModel r10 = this.f;
        if (r10 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L7:
        SkuInfoVO r11 = (SkuInfoVO) r10.getSkuInfo().a();
        if (r11 == null) goto L10;
        CarAdaptComponent r12 = r11.getCarAdaptComponent();
    L12:
        if (r12 != null) goto L14;
        return;
    L14:
        SkuViewModel r14 = this.f;
        if (r14 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        Pair[] r15 = new Pair[3];
        r15[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MODULE_NAME, "adaptation");
        boolean r16 = true;
        r15[1] = TuplesKt.to("module_location", "2");
        if (r13 == null) goto L20;
        r0 = r13.getCarDesc();
    L20:
        if (r0 != null) goto L22;
    L25:
        if (r16 == false) goto L27;
        String r1 = "1";
    L28:
        r15[2] = TuplesKt.to("module_status", r1);
        SkuViewModel.doSkuEventAction$default(r14, "pd_page_module_show", r15, null, null, null, 28, null);
        this.h = new CarModelOptimizePresenter$updateCarInfo$1(this, r13);
        ECUrlModel r17 = r12.getIcon();
        if (r17 == null) goto L32;
        com.bytedance.android.ec.core.utils.y.a((SimpleDraweeView) this.i.getValue(), r17);
    L32:
        if (com.bytedance.android.ec.core.utils.a2.b(r12.getCarDesc()) == false) goto L34;
        ((TextView) this.k.getValue()).setVisibility(8);
        ((TextView) this.j.getValue()).setVisibility(0);
        ((TextView) this.l.getValue()).setVisibility(0);
        ((TextView) this.m.getValue()).setVisibility(0);
        ((TextView) this.j.getValue()).setText(r12.getCarDesc());
        ((TextView) this.l.getValue()).setText(r12.getAdaptResult());
    L35:
        ((ConstraintLayout) this.o.getValue()).setOnClickListener(new b(this, r12));
        return;
    L34:
        ((TextView) this.k.getValue()).setVisibility(0);
        ((TextView) this.j.getValue()).setVisibility(8);
        ((TextView) this.l.getValue()).setVisibility(8);
        ((TextView) this.m.getValue()).setVisibility(8);
        goto L35
    L27:
        r1 = "0";
        goto L28
    L22:
        if (r0.length() == 0) goto L25;
        r16 = false;
        goto L25
    L10:
        r12 = null;
        goto L12
    L11:
        r12 = r13;
        goto L12
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onCarModelUpdated(com.bytedance.android.ec.core.utils.f1 r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        CarModelSelectInfo r11 = r10.a;
        SkuViewModel r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuParams r1 = r0.getSkuParams();
        if (r11 == null) goto L8;
        String r12 = r11.getId();
    L9:
        r1.setSelectCarId(r12);
        SkuViewModel r13 = this.f;
        if (r13 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L12:
        r13.m1030getSkuInfo();
        return;
    L8:
        r12 = null;
        goto L9
    }
}
