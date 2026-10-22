package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.revenue.common.i;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.ComboBottomAnimationView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.LiveGiftComboViewNew;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/LiveGiftComboWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveGiftComboWidget extends LiveRecyclableWidget {
    public ComboBottomAnimationView a;
    public int b;
    public LiveGiftComboViewNew c;
    public LottieAnimationView d;

    public static final class a extends AnimatorListenerAdapter {
        public final /* synthetic */ LiveGiftComboWidget a;

        public a(LiveGiftComboWidget r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationCancel(r2);
            LottieAnimationView r3 = this.a.d;
            if (r3 == null) goto L6;
            r3.setVisibility(8);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationEnd(r2);
            LottieAnimationView r3 = this.a.d;
            if (r3 == null) goto L6;
            r3.setVisibility(8);
            return;
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ LiveGiftComboWidget a;

        public b(LiveGiftComboWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            GiftStateMachineConfig.g r6 = (GiftStateMachineConfig.g) r5;
            LiveGiftComboWidget r0 = this.a;
            r0.getClass();
            if ((r6 instanceof GiftStateMachineConfig.a.c) == false) goto L12;
            GiftStateMachineConfig.a.c r2 = (GiftStateMachineConfig.a.c) r6;
            if (r0.b == r2.b) goto L12;
            if (d.k() == false) goto L12;
            int r1 = r2.b;
            r0.b = r1;
            ComboBottomAnimationView r3 = r0.a;
            if (r3 == null) goto L12;
            r3.b(r1);
        L12:
            if ((r6 instanceof GiftStateMachineConfig.a.e) == false) goto L17;
            r0.b = 0;
            ComboBottomAnimationView r4 = r0.a;
            if (r4 == null) goto L18;
            r4.b(0);
            return;
        L18:
            return;
        }
    }

    public final int getLayoutId() {
        return 2131565236;
    }

    public final void onUnload() {
        this.c = null;
        this.d = null;
        ComboBottomAnimationView r0 = this.a;
        if (r0 == null) goto L17;
        Disposable r1 = r0.b;
        if (r1 == null) goto L7;
        r1.dispose();
    L7:
        FrameLayout r2 = (FrameLayout) r0.a(2131367234);
        if (r2 == null) goto L10;
        r2.removeAllViews();
    L10:
        r0.c = false;
        r0.d = false;
        View r3 = r0.a(2131367233);
        if (r3 == null) goto L13;
        r3.setVisibility(4);
    L13:
        View r4 = r0.a(2131367233);
        if (r4 == null) goto L18;
        r4.setTranslationY(0.0f);
        return;
    L18:
        return;
    }

    public final LiveGiftComboViewNew wq() {
        if (isInitialized() == true) goto L7;
        return null;
    L7:
        if (this.c != null) goto L16;
        LiveGiftComboViewNew r0 = new LiveGiftComboViewNew(((Widget) this).context);
        Unit r1 = Unit.INSTANCE;
        ViewGroup r2 = ((Widget) this).containerView;
        if (r2 == null) goto L11;
        r2.addView(r0, new FrameLayout.LayoutParams(-2, -2));
    L11:
        ViewGroup r3 = ((Widget) this).containerView;
        if (r3 == null) goto L14;
        r3.requestLayout();
    L14:
        this.c = r0;
    L16:
        return this.c;
    }

    public final LottieAnimationView xq() {
        if (isInitialized() == true) goto L7;
        return null;
    L7:
        if (this.d != null) goto L24;
        View r0 = new LottieAnimationView(((Widget) this).context);
        Unit r1 = Unit.INSTANCE;
        ViewGroup r2 = ((Widget) this).containerView;
        if (r2 == null) goto L11;
        r2.addView(r0, new FrameLayout.LayoutParams(i.b(80), i.b(160)));
    L11:
        ViewGroup r3 = ((Widget) this).containerView;
        if (r3 == null) goto L14;
        r3.requestLayout();
    L14:
        this.d = r0;
        r0.setImageAssetsFolder("images");
        LottieAnimationView r4 = this.d;
        if (r4 == null) goto L17;
        r4.setAnimation("ttlive_gift_group_guide.json");
    L17:
        LottieAnimationView r5 = this.d;
        if (r5 == null) goto L20;
        r5.setRepeatCount(2);
    L20:
        LottieAnimationView r6 = this.d;
        if (r6 == null) goto L24;
        r6.addAnimatorListener(new a(this));
    L24:
        return this.d;
    }

    public LiveGiftComboWidget() {
    }

    public final void onInit(Object[] r1) {
        this.a = (ComboBottomAnimationView) findViewById(2131367232);
    }

    public final void onLoad(Object[] r3) {
        com.bytedance.android.livesdk.gift.util.b.d("GiftDialogViewModel", this, new b(this), true);
    }

    public final void yq(int r3, int r4) {
        LottieAnimationView r0 = xq();
        if (r0 == null) goto L5;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
    L7:
        if ((r1 instanceof FrameLayout.LayoutParams) == false) goto L9;
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) r1;
        r2.topMargin = r4 - i.b(60);
        r2.leftMargin = r3;
    L9:
        ViewGroup r5 = ((Widget) this).containerView;
        if (r5 == null) goto L12;
        r5.requestLayout();
    L12:
        LottieAnimationView r6 = xq();
        if (r6 == null) goto L15;
        r6.setVisibility(0);
    L15:
        LottieAnimationView r7 = xq();
        if (r7 == null) goto L19;
        r7.playAnimation();
        return;
    L19:
        return;
    L5:
        r1 = null;
        goto L7
    }
}
