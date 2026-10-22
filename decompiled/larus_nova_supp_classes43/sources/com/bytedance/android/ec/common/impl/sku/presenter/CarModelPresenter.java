package com.bytedance.android.ec.common.impl.sku.presenter;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
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
public final class CarModelPresenter extends QFragmentPresenter {
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
        public final /* synthetic */ CarModelPresenter a;
        public final /* synthetic */ CarAdaptComponent b;

        public b(CarModelPresenter r1, CarAdaptComponent r10) {
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

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ CarModelPresenter a;
        public final /* synthetic */ CarAdaptComponent b;

        public c(CarModelPresenter r1, CarAdaptComponent r10) {
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

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ CarModelPresenter a;
        public final /* synthetic */ CarAdaptComponent b;

        public d(CarModelPresenter r1, CarAdaptComponent r10) {
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

    public CarModelPresenter(Fragment r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        super(r10);
        this.g = true;
        this.i = LazyKt.lazy(new CarModelPresenter$tvCarDesc$2(this));
        this.j = LazyKt.lazy(new CarModelPresenter$tvSwitchModel$2(this));
        this.k = LazyKt.lazy(new CarModelPresenter$ivRightArrow$2(this));
        this.l = LazyKt.lazy(new CarModelPresenter$icon$2(this));
        this.m = LazyKt.lazy(new CarModelPresenter$tvCarModelStatus$2(this));
        this.n = LazyKt.lazy(new CarModelPresenter$flCarStatus$2(this));
        this.o = LazyKt.lazy(new CarModelPresenter$ivModelRightArrow$2(this));
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
        r14.getCurrentCarAdaptComponent().b(ECQuickUtilKt.a(Y()), new x(this));
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

    public final void d0(final CarAdaptComponent r14) {
        String r0 = null;
        if (r14 != null) goto L11;
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
        SkuViewModel r13 = this.f;
        if (r13 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        Pair[] r15 = new Pair[3];
        r15[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MODULE_NAME, "adaptation");
        boolean r16 = true;
        r15[1] = TuplesKt.to("module_location", "2");
        if (r14 == null) goto L20;
        r0 = r14.getCarDesc();
    L20:
        if (r0 != null) goto L22;
    L25:
        boolean r1 = true;
    L26:
        if (r1 == false) goto L28;
        String r17 = "1";
    L29:
        r15[2] = TuplesKt.to("module_status", r17);
        SkuViewModel.doSkuEventAction$default(r13, "pd_page_module_show", r15, null, null, null, 28, null);
        ECUrlModel r18 = r12.getIcon();
        if (r18 == null) goto L32;
        com.bytedance.android.ec.core.utils.y.a((SimpleDraweeView) this.l.getValue(), r18);
    L32:
        ((TextView) this.m.getValue()).setText(r12.getAdaptResult());
        ImageView r19 = (ImageView) this.o.getValue();
        String r20 = r12.getCarDesc();
        if (r20 != null) goto L35;
    L38:
        jg.g.d(r19, r16);
        ((FrameLayout) this.n.getValue()).setOnClickListener(new d(this, r12));
        this.h = new CarModelPresenter$updateCarInfo$3(this, r14);
        if (com.bytedance.android.ec.core.utils.a2.b(r12.getCarDesc()) == false) goto L41;
        ((TextView) this.i.getValue()).setText(r12.getCarDesc());
        ((TextView) this.i.getValue()).setVisibility(0);
        TextView r110 = (TextView) this.j.getValue();
        r110.setVisibility(0);
        r110.setOnClickListener(new b(this, r12));
        ImageView r111 = (ImageView) this.k.getValue();
        r111.setVisibility(0);
        r111.setOnClickListener(new c(this, r12));
        return;
    L41:
        ((TextView) this.i.getValue()).setVisibility(8);
        ((ImageView) this.k.getValue()).setVisibility(8);
        ((TextView) this.j.getValue()).setVisibility(8);
        return;
    L35:
        if (r20.length() == 0) goto L38;
        r16 = false;
        goto L38
    L28:
        r17 = "0";
        goto L29
    L22:
        if (r0.length() == 0) goto L25;
        r1 = false;
        goto L26
    L10:
        r12 = null;
        goto L12
    L11:
        r12 = r14;
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
