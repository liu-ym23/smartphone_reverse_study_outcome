package com.bytedance.android.livesdk.gift.vs.tray.view;

import android.animation.Animator;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.core.util.e;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.gift.platform.business.tray.k;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.gift.platform.core.utils.x;
import com.bytedance.android.livesdk.gift.vs.tray.viewmodel.VSGiftTrayViewModel;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.info.WidgetInfo;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u00020\u00052\u00020\u0006:\u0001\tB\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/gift/vs/tray/view/VSGiftTrayWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "Lcom/bytedance/android/livesdk/gift/platform/business/tray/k;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "<init>", "()V", "a", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSGiftTrayWidget extends LiveRecyclableWidget implements Observer<KVData>, k, ViewModelProvider.Factory {
    public static final /* synthetic */ int j = 0;
    public final Lazy a;
    public final Lazy b;
    public VSGiftTrayAnimationView c;
    public final Lazy d;
    public final Lazy e;
    public float f;
    public Disposable g;
    public WidgetInfo h;
    public final b i;

    public static final class a {
    }

    public static final class b implements s02.a {
        public final /* synthetic */ VSGiftTrayWidget a;

        @Override // s02.a
        public final void a() {
            VSGiftTrayWidget r0 = this.a;
            int r1 = VSGiftTrayWidget.j;
            r0.xq().sendEvent(com.bytedance.android.livesdk.gift.vs.tray.viewmodel.a.b.a);
        }

        @Override // s02.a
        public final void onExit() {
            VSGiftTrayWidget r0 = this.a;
            int r1 = VSGiftTrayWidget.j;
            r0.xq().sendEvent(com.bytedance.android.livesdk.gift.vs.tray.viewmodel.a.c.a);
        }

        @Override // s02.a
        public final void onWaiting() {
            VSGiftTrayWidget r0 = this.a;
            int r1 = VSGiftTrayWidget.j;
            r0.xq().sendEvent(com.bytedance.android.livesdk.gift.vs.tray.viewmodel.a.d.a);
        }

        public b(VSGiftTrayWidget r1) {
            this.a = r1;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ VSGiftTrayWidget a;

        public c(VSGiftTrayWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r8) {
            NormalGiftMessage r9 = (NormalGiftMessage) r8;
            VSGiftTrayWidget r0 = this.a;
            int r1 = VSGiftTrayWidget.j;
            r0.getClass();
            if (r9 != null) goto L5;
            return;
        L5:
            if (r9.p == false) goto L7;
        L51:
            r0.xq().tryConsumeOne();
            return;
        L7:
            if (((Boolean) r0.d.getValue()).booleanValue() == false) goto L51;
            if (x.b() == true) goto L51;
            com.bytedance.android.livesdk.gift.vs.tray.viewmodel.c r2 = (com.bytedance.android.livesdk.gift.vs.tray.viewmodel.c) r0.xq().getState().getValue();
            boolean r3 = true;
            if (Intrinsics.areEqual(r2, com.bytedance.android.livesdk.gift.vs.tray.viewmodel.c.C0089c.a) == false) goto L41;
            r0.xq().sendEvent(com.bytedance.android.livesdk.gift.vs.tray.viewmodel.a.C0087a.a);
            VSGiftTrayAnimationView r4 = r0.c;
            int r5 = 0;
            if (r4 != null) goto L16;
            r0.c = new VSGiftTrayAnimationView(((Widget) r0).context, null, 6, r5);
        L17:
            r0.wq().removeView(r0.c);
            int r6 = r9.w.getType();
            VSGiftTrayAnimationView r7 = r0.c;
            if (r7 != null) goto L20;
        L26:
            VSGiftTrayAnimationView r10 = r0.c;
            if (r10 == null) goto L29;
            r10.setGiftMessage(r9);
        L29:
            VSGiftTrayAnimationView r11 = r0.c;
            if (r11 == null) goto L32;
            r11.h.a(r11, -r0.wq().getWidth(), 0);
        L32:
            r0.wq().addView(r0.c);
            float r13 = s1.f(70.0f);
            com.bytedance.android.livesdk.revenue.service.interactivity.a r14 = (dy0.b) e.c(j.C0.a(), com.bytedance.android.livesdk.revenue.service.interactivity.a.class);
            if (r14 == null) goto L35;
            r14.oe(r13);
        L35:
            VSGiftTrayAnimationView r15 = r0.c;
            if (r15 == null) goto L54;
            b r16 = r0.i;
            r15.f = false;
            r15.i = r16;
            Animator r17 = r15.h.b(r15, r15.y);
            r15.b = r17;
            if (r17 == null) goto L55;
            r17.start();
            return;
        L55:
            return;
        L54:
            return;
        L20:
            if (r6 != 2) goto L22;
        L24:
            r3 = false;
        L25:
            r7.setShowCombo(r3);
            goto L26
        L22:
            if (r6 == 4) goto L24;
        L16:
            r4.f();
            goto L17
        L41:
            if (Intrinsics.areEqual(r2, com.bytedance.android.livesdk.gift.vs.tray.viewmodel.c.d.a) == false) goto L43;
        L44:
            VSGiftTrayAnimationView r18 = r0.c;
            if (r18 == null) goto L58;
            Intrinsics.checkNotNullParameter(r9, "newMsg");
            if (c22.a.a(r18.d, r9) != true) goto L59;
            r0.xq().sendEvent(com.bytedance.android.livesdk.gift.vs.tray.viewmodel.a.C0087a.a);
            VSGiftTrayAnimationView r19 = r0.c;
            if (r19 == null) goto L60;
            r19.d(r9.m);
            return;
        L60:
            return;
        L59:
            return;
        L58:
            return;
        L43:
            if (Intrinsics.areEqual(r2, com.bytedance.android.livesdk.gift.vs.tray.viewmodel.c.b.a) == true) goto L44;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ VSGiftTrayWidget a;

        public d(VSGiftTrayWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            VSGiftTrayWidget r0 = this.a;
            int r1 = VSGiftTrayWidget.j;
            r0.getClass();
            if (Intrinsics.areEqual((com.bytedance.android.livesdk.gift.vs.tray.viewmodel.c) r4, com.bytedance.android.livesdk.gift.vs.tray.viewmodel.c.C0089c.a) == false) goto L11;
            VSGiftTrayAnimationView r5 = r0.c;
            if (r5 == null) goto L7;
            r5.e();
            r0.wq().removeView(r5);
        L7:
            r0.c = null;
            Disposable r6 = r0.g;
            if (r6 == null) goto L10;
            r6.dispose();
        L10:
            r0.g = Observable.timer(300, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(com.bytedance.android.livesdk.gift.vs.tray.view.d.a);
        L14:
            r0.xq().tryConsumeOne();
            return;
        L11:
            Disposable r7 = r0.g;
            if (r7 == null) goto L14;
            r7.dispose();
            goto L14
        }
    }

    static {
    }

    public final /* synthetic */ ViewModel create(Class r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public final /* synthetic */ ViewModel create(KClass r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public final int getLayoutId() {
        return 2131568042;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray.k
    public final void gm(o7 r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    public final void onInit(Object[] r1) {
    }

    public final FrameLayout wq() {
        return (FrameLayout) this.b.getValue();
    }

    public final VSGiftTrayViewModel xq() {
        return (VSGiftTrayViewModel) this.a.getValue();
    }

    public final void onUnload() {
        VSGiftTrayAnimationView r0 = this.c;
        if (r0 == null) goto L5;
        r0.e();
        wq().removeView(r0);
    L5:
        this.c = null;
        xq().sendEvent(com.bytedance.android.livesdk.gift.vs.tray.viewmodel.a.c.a);
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L8;
        r1.removeObserver(this);
    L8:
        Disposable r2 = this.g;
        if (r2 == null) goto L11;
        r2.dispose();
    L11:
        this.h = null;
    }

    public VSGiftTrayWidget() {
        this.a = LazyKt.lazy(new VSGiftTrayWidget$viewModel$2(this));
        this.b = LazyKt.lazy(new VSGiftTrayWidget$normalGiftViewParent$2(this));
        this.d = LazyKt.lazy(new VSGiftTrayWidget$isVertical$2(this));
        this.e = LazyKt.lazy(VSGiftTrayWidget$isVerticalVideo$2.INSTANCE);
        this.f = s1.e(477.0f);
        this.i = new b(this);
    }

    public final <T extends ViewModel> T create(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "modelClass");
        return new VSGiftTrayViewModel(((Widget) this).dataCenter);
    }

    public final void onChanged(Object r1) {
        KVData r2 = (KVData) r1;
        if (r2 == null) goto L6;
        TextUtils.isEmpty(r2.getKey());
        return;
    }

    public final void onLoad(Object[] r3) {
        xq().getCurrentMsg().observe(this, new c(this));
        xq().getState().observe(this, new d(this));
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 == null) goto L6;
        r4.observe("data_vs_interactive_widget_shown", this, true);
    L6:
        if (((Boolean) this.e.getValue()).booleanValue() == false) goto L8;
        wq().setVisibility(8);
    L9:
        WidgetInfo r5 = this.h;
        if (r5 == null) goto L22;
        Intrinsics.checkNotNullParameter(r5, "info");
        if (((Widget) this).contentView != null) goto L14;
        this.h = r5;
        goto L22
    L14:
        float r6 = r5.getContentViewHeight() - s1.e(13.0f);
        if (r6 < s1.e(50.0f)) goto L22;
        this.f = r6;
        ViewGroup.LayoutParams r7 = wq().getLayoutParams();
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == false) goto L20;
        ((ViewGroup.MarginLayoutParams) r7).bottomMargin = (int) this.f;
    L20:
        wq().setLayoutParams(r7);
    L22:
        if (u.p() == false) goto L25;
        xq().initViewModel();
        return;
    L25:
        return;
    L8:
        wq().setVisibility(0);
        goto L9
    }
}
