package com.bytedance.android.livesdk.gift.platform.business.effect.atmosphere;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.gift.platform.business.effect.service.ViewIdentifier;
import com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseGiftEffectLynxWidget;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.live.datacontext.n;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/atmosphere/TopAtmosphereWidget;", "Lcom/bytedance/android/livesdk/gift/platform/business/effect/widget/BaseGiftEffectLynxWidget;", "Lcom/bytedance/android/livesdk/gift/platform/business/effect/service/ViewIdentifier;", "getIdentifier", "()Lcom/bytedance/android/livesdk/gift/platform/business/effect/service/ViewIdentifier;", "identifier", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TopAtmosphereWidget extends BaseGiftEffectLynxWidget {
    public FrameLayout f;

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseGiftEffectLynxWidget
    public final int getLayoutId() {
        return 2131565164;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseGiftEffectLynxWidget
    public final void onUnload() {
        super.onUnload();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L8;
        n<ViewGroup> r1 = r0.getAtmosphereContainer();
        if (r1 == null) goto L9;
        r1.setValue(null);
        return;
    L9:
        return;
    }

    public TopAtmosphereWidget() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseGiftEffectLynxWidget
    public ViewIdentifier getIdentifier() {
        return ViewIdentifier.MediaDecorationBehindSeat;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseGiftEffectLynxWidget
    public final void onInit(Object[] r1) {
        this.f = (FrameLayout) findViewById(2131363320);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseGiftEffectLynxWidget
    public final void onLoad(Object[] r2) {
        super.onLoad(r2);
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        GiftContext r3 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r3 == null) goto L8;
        n<ViewGroup> r4 = r3.getAtmosphereContainer();
        if (r4 == null) goto L9;
        r4.setValue(this.f);
        return;
    L9:
        return;
    }
}
