package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.NitaInflateUtil;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ItemListData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnGiftAnimShakeFinish;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShakeGiftIcon;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowGiftExposureAnim;
import com.bytedance.android.livesdk.gift.platform.core.utils.GiftPanelNitaViewInfo;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class CounterGiftPanelViewHolderItem extends BasePanelViewHolderItem {
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.c e0;
    public final Function0<Integer> f0;

    public static final class a extends o12.b {
        public final /* synthetic */ CounterGiftPanelViewHolderItem a;
        public final /* synthetic */ com.bytedance.android.anya.a0 b;

        @Override // o12.b, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "animation");
            this.a.o(new OnGiftAnimShakeFinish(((ShakeGiftIcon) this.b).getPagerPosition(), ((ShakeGiftIcon) this.b).getPosition(), ((ShakeGiftIcon) this.b).getCounterPosition(), -1, false, 16, null));
        }

        public a(CounterGiftPanelViewHolderItem r1, com.bytedance.android.anya.a0 r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter.BasePanelViewHolderItem
    public final void v(com.bytedance.android.anya.k<ItemListData> r2, ItemListData r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$handleUIDiff");
        Intrinsics.checkNotNullParameter(r3, "state");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter.BasePanelViewHolderItem
    public final boolean d(com.bytedance.android.anya.a0 r5) {
        Intrinsics.checkNotNullParameter(r5, "e");
        if ((r5 instanceof ShowGiftExposureAnim) == false) goto L13;
        ShowGiftExposureAnim r0 = (ShowGiftExposureAnim) r5;
        if (r0.getPosition() != p()) goto L23;
        if (r0.getPagerPosition() != this.a0) goto L23;
        if (r0.getCounterPosition() != ((Number) this.f0.invoke()).intValue()) goto L23;
        u(r0);
        return true;
    L23:
        return super.d(r5);
    L13:
        if ((r5 instanceof ShakeGiftIcon) == false) goto L23;
        ShakeGiftIcon r1 = (ShakeGiftIcon) r5;
        if (r1.getPosition() != p()) goto L23;
        if (r1.getPagerPosition() != this.a0) goto L23;
        if (r1.getCounterPosition() != ((Number) this.f0.invoke()).intValue()) goto L23;
        B(r1.getToastText(), new a(this, r5));
        return true;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter.BasePanelViewHolderItem
    public final boolean y(View r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "v");
        Intrinsics.checkNotNullParameter(r3, "event");
        return this.e0.b(r2, r3);
    }

    public CounterGiftPanelViewHolderItem(ViewGroup r8, final int r9, Function0<Integer> r10) {
        Intrinsics.checkNotNullParameter(r8, "parent");
        Intrinsics.checkNotNullParameter(r10, "getCounterPosition");
        if (com.bytedance.android.livesdk.gift.platform.core.a0.e().L3() == false) goto L9;
        GiftPanelNitaViewInfo r0 = GiftPanelNitaViewInfo.TTLIVE_BASE_COUNTER_GIFT_ITEM;
        int r2 = r0.getResId();
        String r1 = r0.getTag();
        Context r3 = r8.getContext();
        if (r3 == null) goto L8;
        View r4 = NitaInflateUtil.a(r2, r1, (Activity) r3, r8, false);
    L10:
        super(r8, r4, r9, 0, 24);
        this.f0 = r10;
        p();
        this.e0 = new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.c(new CounterGiftPanelViewHolderItem$counterTouchController$1(this, r9), new CounterGiftPanelViewHolderItem$counterTouchController$2(this, r9), new CounterGiftPanelViewHolderItem$counterTouchController$3(this), new CounterGiftPanelViewHolderItem$counterTouchController$4(this));
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L9:
        r4 = LayoutInflater.from(r8.getContext()).inflate(2131565220, r8, false);
        goto L10
    }
}
