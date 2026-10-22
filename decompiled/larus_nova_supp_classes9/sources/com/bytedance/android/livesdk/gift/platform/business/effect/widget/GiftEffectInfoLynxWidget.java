package com.bytedance.android.livesdk.gift.platform.business.effect.widget;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gift.platform.business.effect.giftview.GiftEffectInfoDraggableView;
import com.bytedance.android.livesdk.gift.platform.business.effect.giftview.GiftEffectInfoFullScreenView;
import com.bytedance.android.scope.m;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.UriProtector;
import i12.e;
import i12.o;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import l02.f;
import l02.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/widget/GiftEffectInfoLynxWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftEffectInfoLynxWidget extends LiveRecyclableWidget {
    public final Lazy a;
    public final Lazy b;
    public zy0.b c;
    public final a d;

    public static final class a implements g {
        public final /* synthetic */ GiftEffectInfoLynxWidget a;

        public a(GiftEffectInfoLynxWidget r1) {
            this.a = r1;
        }

        @Override // l02.g
        public final void a(int r1, String r2, String r3) {
            this.a.reset();
        }

        @Override // l02.g
        public final void b(int r1, boolean r2, float r3, String r4, boolean r5, String r6, String r7) {
            Intrinsics.checkNotNullParameter(r4, "schema");
            if (r1 != 0) goto L5;
            GiftEffectInfoLynxWidget r8 = this.a;
            r8.reset();
            ((GiftEffectInfoFullScreenView) r8.a.getValue()).setTouchable(r5);
            ((GiftEffectInfoFullScreenView) r8.a.getValue()).setVisibility(0);
            r8.wq().setVisibility(8);
            r8.xq(r4, (GiftEffectInfoFullScreenView) r8.a.getValue());
            return;
        L5:
            if (r1 != 1) goto L19;
            GiftEffectInfoLynxWidget r9 = this.a;
            r9.reset();
            ((GiftEffectInfoFullScreenView) r9.a.getValue()).setVisibility(8);
            int r10 = s1.f(r3);
            if (r3 < 0.0f) goto L15;
            ViewGroup.LayoutParams r11 = r9.wq().getLayoutParams();
            if ((r11 instanceof FrameLayout.LayoutParams) == true) goto L12;
            r11 = null;
        L12:
            FrameLayout.LayoutParams r13 = (FrameLayout.LayoutParams) r11;
            if (r13 == null) goto L15;
            r13.topMargin = r10;
        L15:
            r9.wq().setTopMarginPx(r10);
            r9.wq().setDraggable(r2);
            r9.wq().setVisibility(0);
            r9.xq(r4, r9.wq());
            return;
        }
    }

    public final int getLayoutId() {
        return 2131566123;
    }

    public final void onInit(Object[] r1) {
    }

    public final GiftEffectInfoDraggableView wq() {
        return (GiftEffectInfoDraggableView) this.b.getValue();
    }

    public final void reset() {
        zy0.b r0 = this.c;
        if (r0 == null) goto L5;
        r0.dispose();
        wq().removeAllViews();
        ((GiftEffectInfoFullScreenView) this.a.getValue()).removeAllViews();
        this.c = null;
    L5:
        GiftEffectInfoDraggableView r1 = wq();
        r1.getClass();
        j80.b.e(r1, new j80.d(0.0f, r1.b));
    }

    public GiftEffectInfoLynxWidget() {
        this.a = LazyKt.lazy(new GiftEffectInfoLynxWidget$fullScreenContainer$2(this));
        this.b = LazyKt.lazy(new GiftEffectInfoLynxWidget$cardContainer$2(this));
        this.d = new a(this);
    }

    public final void onUnload() {
        e r0 = o.b();
        if (r0 == null) goto L5;
        m.e.getClass();
        com.bytedance.android.scope.o r1 = (com.bytedance.android.scope.o) m.b(r0).a(Reflection.getOrCreateKotlinClass(f.class));
    L6:
        f r2 = (f) r1;
        if (r2 == null) goto L10;
        a r3 = this.d;
        Intrinsics.checkNotNullParameter(r3, "listener");
        ((ArrayList) r2.a).remove(r3);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onLoad(Object[] r3) {
        e r4 = o.b();
        if (r4 == null) goto L5;
        m.e.getClass();
        com.bytedance.android.scope.o r5 = (com.bytedance.android.scope.o) m.b(r4).a(Reflection.getOrCreateKotlinClass(f.class));
    L6:
        f r6 = (f) r5;
        if (r6 == null) goto L10;
        a r0 = this.d;
        Intrinsics.checkNotNullParameter(r0, "listener");
        ((ArrayList) r6.a).add(r0);
        return;
    L10:
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void xq(String r5, ViewGroup r6) {
        if (c.a() == false) goto L5;
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a r7 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).q8(((Widget) this).context, UriProtector.parse(r5), null);
    L6:
        this.c = r7;
        if (r7 != null) goto L9;
        return;
    L9:
        if (((Boolean) c.c.getValue(null, c.a[1])).booleanValue() == true) goto L21;
    L15:
        if (r6 == null) goto L17;
        r6.addView(r7.c());
    L17:
        xy0.a r8 = r7.g();
        if (r8 == null) goto L24;
        r8.load();
        return;
    L24:
        return;
    L21:
        r7.x();     // Catch: Exception -> L13
    L13:
        e = move-exception;
        ALogger.e("GiftEffectInfoLynxWidget", "registerKryptonServices error " + e);
        e.printStackTrace();
        goto L15
    L5:
        r7 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).J8(((Widget) this).context, UriProtector.parse(r5), null);
        goto L6
    }
}
