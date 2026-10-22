package com.bytedance.android.livesdk.gift.platform.business.effect.widget;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.core.util.e;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.live.room.api.messagewindow.identity.CardTypeAndPriority;
import com.bytedance.android.livesdk.gift.platform.business.effect.giftview.GiftEffectInfoDraggableView;
import com.bytedance.android.livesdk.gift.platform.business.effect.giftview.GiftEffectInfoFullScreenView;
import com.bytedance.android.livesdk.gift.platform.business.effect.service.ViewIdentifier;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/widget/GiftFourthLineCardWidget;", "Lcom/bytedance/android/livesdk/gift/platform/business/effect/widget/BaseGiftEffectLynxWidget;", "Lcom/bytedance/android/livesdk/gift/platform/business/effect/service/ViewIdentifier;", "f", "Lcom/bytedance/android/livesdk/gift/platform/business/effect/service/ViewIdentifier;", "getIdentifier", "()Lcom/bytedance/android/livesdk/gift/platform/business/effect/service/ViewIdentifier;", "identifier", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftFourthLineCardWidget extends BaseGiftEffectLynxWidget {
    public final ViewIdentifier f;
    public final Map<String, com.bytedance.android.livesdk.revenue.service.ui.b> g;

    public GiftFourthLineCardWidget() {
        this.f = ViewIdentifier.FourthLineCard;
        this.g = new LinkedHashMap();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseGiftEffectLynxWidget
    public ViewIdentifier getIdentifier() {
        return this.f;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseGiftEffectLynxWidget
    public final void xq(int r1, String r2, String r3) {
        if (r3 != null) goto L5;
        r3 = ViewIdentifier.FourthLineCard.getValue();
    L5:
        if ((!Intrinsics.areEqual(r3, getIdentifier().getValue())) == false) goto L8;
        return;
    L8:
        if (((LinkedHashMap) this.g).get(r2) != null) goto L10;
        return;
    L10:
        if (r2 != null) goto L12;
        String r4 = "default";
    L13:
        yq(r4);
        if (r2 != null) goto L16;
        r2 = "default";
    L16:
        com.bytedance.android.livesdk.revenue.service.ui.b r5 = (com.bytedance.android.livesdk.revenue.service.ui.b) ((LinkedHashMap) this.g).get(r2);
        if (r5 == null) goto L19;
        r5.dismiss();
    L19:
        this.g.remove(r2);
        return;
    L12:
        r4 = r2;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseGiftEffectLynxWidget
    public final void Aq(int r9, boolean r10, float r11, String r13, boolean r14, String r15, String r16) {
        Intrinsics.checkNotNullParameter(r13, "schema");
        if (r16 != null) goto L6;
        r16 = ViewIdentifier.FourthLineCard.getValue();
    L6:
        if ((!Intrinsics.areEqual(r16, getIdentifier().getValue())) == false) goto L8;
        return;
    L8:
        if (r15 != null) goto L11;
        r15 = "default";
    L11:
        if (((LinkedHashMap) this.g).get(r15) == null) goto L16;
        com.bytedance.android.livesdk.revenue.service.ui.b r17 = (com.bytedance.android.livesdk.revenue.service.ui.b) ((LinkedHashMap) this.g).get(r15);
        if (r17 == null) goto L15;
        r17.dismiss();
    L15:
        this.g.remove(r15);
    L16:
        DataCenter r1 = null;
        if (r9 == 0) goto L21;
        if (r9 == 1) goto L20;
        FrameLayout r18 = new GiftEffectInfoFullScreenView(((Widget) this).context, null, 6, 0);
    L22:
        FrameLayout r6 = r18;
        Context r19 = ((Widget) this).context;
        if (((LinkedHashMap) this.b).get(r15) == null) goto L26;
        yq(r15);
    L26:
        if (c.a() == false) goto L28;
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a r20 = f.a(vy0.c.class).q8(r19, UriProtector.parse(r13), null);
    L29:
        if (r20 == null) goto L42;
        r6.addView(r20.c());
        xy0.a r110 = r20.g();
        if (r110 == null) goto L34;
        r110.load();
    L34:
        this.b.put(r15, r20);
        com.bytedance.android.livesdk.revenue.service.room.c r21 = (dy0.b) e.c(j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        com.bytedance.android.livesdk.revenue.service.ui.c r2 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.ui.c.class);
        if (r21 == null) goto L37;
        r1 = r21.getDataCenter();
    L37:
        com.bytedance.android.livesdk.revenue.service.ui.b r23 = r2.C9(r1, CardTypeAndPriority.GiftLynxCard.getPriority(), ((Widget) this).context, r6, new aq2.a(new aq2.b(s1.f(0.0f), s1.f(0.0f), s1.f(0.0f), s1.f(0.0f)), false, 1));
        this.g.put(r15, r23);
        if (r23 == null) goto L41;
        r23.show();
        return;
    L41:
        return;
    L42:
        return;
    L28:
        r20 = f.a(vy0.c.class).J8(r19, UriProtector.parse(r13), null);
        goto L29
    L20:
        GiftEffectInfoDraggableView r24 = new GiftEffectInfoDraggableView(((Widget) this).context, null, 6, 0);
        r24.setDraggable(r10);
        r24.setLayoutParams(new ConstraintLayout.LayoutParams(-2, -2));
        r18 = r24;
        goto L22
    L21:
        GiftEffectInfoFullScreenView r25 = new GiftEffectInfoFullScreenView(((Widget) this).context, null, 6, 0);
        r25.setTouchable(r14);
        r25.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        r18 = r25;
        goto L22
    }
}
