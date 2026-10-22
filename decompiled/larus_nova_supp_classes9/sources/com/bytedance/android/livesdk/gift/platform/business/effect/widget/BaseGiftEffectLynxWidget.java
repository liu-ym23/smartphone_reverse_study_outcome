package com.bytedance.android.livesdk.gift.platform.business.effect.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gift.platform.business.effect.giftview.GiftEffectInfoDraggableView;
import com.bytedance.android.livesdk.gift.platform.business.effect.giftview.GiftEffectInfoFullScreenView;
import com.bytedance.android.livesdk.gift.platform.business.effect.service.ViewIdentifier;
import com.bytedance.android.scope.m;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.UriProtector;
import i12.e;
import i12.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import l02.f;
import l02.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/widget/BaseGiftEffectLynxWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/bytedance/android/livesdk/gift/platform/business/effect/service/ViewIdentifier;", "a", "Lcom/bytedance/android/livesdk/gift/platform/business/effect/service/ViewIdentifier;", "getIdentifier", "()Lcom/bytedance/android/livesdk/gift/platform/business/effect/service/ViewIdentifier;", "identifier", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseGiftEffectLynxWidget extends LiveRecyclableWidget {
    public final ViewIdentifier a;
    public final Map<String, zy0.b> b;
    public final Map<String, GiftEffectInfoFullScreenView> c;
    public final Map<String, GiftEffectInfoDraggableView> d;
    public final b e;

    public static final class a {
    }

    public static final class b implements g {
        public final /* synthetic */ BaseGiftEffectLynxWidget a;

        public b(BaseGiftEffectLynxWidget r1) {
            this.a = r1;
        }

        @Override // l02.g
        public final void a(int r2, String r3, String r4) {
            this.a.xq(r2, r3, r4);
        }

        @Override // l02.g
        public final void b(int r10, boolean r11, float r13, String r14, boolean r15, String r16, String r17) {
            Intrinsics.checkNotNullParameter(r14, "schema");
            this.a.Aq(r10, r11, r13, r14, r15, r16, r17);
        }
    }

    static {
    }

    public int getLayoutId() {
        return 2131566123;
    }

    public void onInit(Object[] r1) {
    }

    public BaseGiftEffectLynxWidget() {
        this.a = ViewIdentifier.Operation;
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new b(this);
    }

    public void onUnload() {
        e r0 = o.b();
        if (r0 == null) goto L5;
        m.e.getClass();
        com.bytedance.android.scope.o r1 = (com.bytedance.android.scope.o) m.b(r0).a(Reflection.getOrCreateKotlinClass(f.class));
    L6:
        f r2 = (f) r1;
        if (r2 == null) goto L9;
        b r3 = this.e;
        Intrinsics.checkNotNullParameter(r3, "listener");
        ((ArrayList) r2.a).remove(r3);
    L9:
        Iterator r4 = ((LinkedHashMap) this.b).entrySet().iterator();
    L11:
        if (r4.hasNext() == false) goto L15;
        zy0.b r5 = (zy0.b) ((Map.Entry) r4.next()).getValue();
        if (r5 == null) goto L11;
        r5.dispose();
        goto L11
    L15:
        ((LinkedHashMap) this.b).clear();
        Iterator r6 = ((LinkedHashMap) this.c).values().iterator();
    L17:
        if (r6.hasNext() == false) goto L19;
        zq((GiftEffectInfoFullScreenView) r6.next());
        goto L17
    L19:
        Iterator r7 = ((LinkedHashMap) this.d).values().iterator();
    L21:
        if (r7.hasNext() == false) goto L23;
        zq((GiftEffectInfoDraggableView) r7.next());
        goto L21
    L23:
        ((LinkedHashMap) this.c).clear();
        ((LinkedHashMap) this.d).clear();
        return;
    L5:
        r1 = null;
        goto L6
    }

    public ViewIdentifier getIdentifier() {
        return this.a;
    }

    public void onLoad(Object[] r3) {
        e r4 = o.b();
        if (r4 == null) goto L5;
        m.e.getClass();
        com.bytedance.android.scope.o r5 = (com.bytedance.android.scope.o) m.b(r4).a(Reflection.getOrCreateKotlinClass(f.class));
    L6:
        f r6 = (f) r5;
        if (r6 == null) goto L10;
        b r0 = this.e;
        Intrinsics.checkNotNullParameter(r0, "listener");
        ((ArrayList) r6.a).add(r0);
        return;
    L10:
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void yq(String r2) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        zy0.b r0 = (zy0.b) ((LinkedHashMap) this.b).get(r2);
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.b.remove(r2);
    }

    public final void zq(View r3) {
        if (getIdentifier() != ViewIdentifier.MediaContainer) goto L5;
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).C2(r3);
        return;
    L5:
        ((Widget) this).containerView.removeView(r3);
    }

    public final void wq(String r5, ViewGroup r6, String r7) {
        if (((LinkedHashMap) this.b).get(r7) == null) goto L6;
        yq(r7);
    L6:
        if (c.a() == false) goto L8;
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a r8 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).q8(((Widget) this).context, UriProtector.parse(r5), null);
    L9:
        if (r8 != null) goto L11;
        return;
    L11:
        if (((Boolean) c.c.getValue(null, c.a[1])).booleanValue() == true) goto L22;
    L17:
        r6.addView(r8.c());
        xy0.a r9 = r8.g();
        if (r9 == null) goto L20;
        r9.load();
    L20:
        this.b.put(r7, r8);
        return;
    L22:
        r8.x();     // Catch: Exception -> L15
    L15:
        e = move-exception;
        ALogger.e("BaseGiftEffectLynxWidget", "registerKryptonServices error " + e);
        e.printStackTrace();
        goto L17
    L8:
        r8 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).J8(((Widget) this).context, UriProtector.parse(r5), null);
        goto L9
    }

    public void xq(int r2, String r3, String r4) {
        if (r4 != null) goto L5;
        r4 = ViewIdentifier.Operation.getValue();
    L5:
        if ((!Intrinsics.areEqual(r4, getIdentifier().getValue())) == false) goto L7;
        return;
    L7:
        if (r3 != null) goto L9;
        r3 = "default";
    L9:
        Intrinsics.checkNotNullParameter(r3, "channel");
        if (r2 == 0) goto L19;
        if (r2 == 1) goto L14;
        return;
    L14:
        if (((LinkedHashMap) this.d).get(r3) == null) goto L24;
        yq(r3);
        GiftEffectInfoDraggableView r5 = this.d.remove(r3);
        if (r5 == null) goto L25;
        zq(r5);
        return;
    L25:
        return;
    L24:
        return;
    L19:
        if (((LinkedHashMap) this.c).get(r3) == null) goto L27;
        yq(r3);
        GiftEffectInfoFullScreenView r6 = this.c.remove(r3);
        if (r6 == null) goto L28;
        zq(r6);
        return;
    L28:
        return;
    }

    public void Aq(int r5, boolean r6, float r7, String r8, boolean r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r8, "schema");
        if (r11 != null) goto L6;
        r11 = ViewIdentifier.Operation.getValue();
    L6:
        if ((!Intrinsics.areEqual(r11, getIdentifier().getValue())) == false) goto L9;
        return;
    L9:
        if (r5 == 0) goto L25;
        if (r5 != 1) goto L37;
        if (r10 != null) goto L14;
        r10 = "default";
    L14:
        View r13 = (GiftEffectInfoDraggableView) ((LinkedHashMap) this.d).get(r10);
        if (r13 == null) goto L17;
        zq(r13);
    L17:
        GiftEffectInfoDraggableView r14 = new GiftEffectInfoDraggableView(((Widget) this).containerView.getContext(), null, 6, 0);
        ConstraintLayout.LayoutParams r15 = new ConstraintLayout.LayoutParams(-2, -2);
        int r16 = s1.f(r7);
        if (r7 < 0.0f) goto L20;
        ((ViewGroup.MarginLayoutParams) r15).topMargin = r16;
    L20:
        r14.setLayoutParams(r15);
        r14.setDraggable(r6);
        r14.setTopMarginPx(r16);
        this.d.put(r10, r14);
        if (getIdentifier() != ViewIdentifier.MediaContainer) goto L23;
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).c3(r14);
    L24:
        wq(r8, r14, r10);
        return;
    L23:
        ((Widget) this).containerView.addView(r14);
        goto L24
    L37:
        return;
    L25:
        if (r10 != null) goto L27;
        r10 = "default";
    L27:
        View r17 = (GiftEffectInfoFullScreenView) ((LinkedHashMap) this.c).get(r10);
        if (r17 == null) goto L30;
        zq(r17);
    L30:
        GiftEffectInfoFullScreenView r18 = new GiftEffectInfoFullScreenView(((Widget) this).containerView.getContext(), null, 6, 0);
        r18.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        r18.setTouchable(r9);
        this.c.put(r10, r18);
        if (getIdentifier() != ViewIdentifier.MediaContainer) goto L33;
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).c3(r18);
    L34:
        wq(r8, r18, r10);
        return;
    L33:
        ((Widget) this).containerView.addView(r18);
        goto L34
    }
}
