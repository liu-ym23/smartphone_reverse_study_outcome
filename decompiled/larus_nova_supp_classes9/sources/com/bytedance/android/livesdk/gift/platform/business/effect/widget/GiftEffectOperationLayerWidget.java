package com.bytedance.android.livesdk.gift.platform.business.effect.widget;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.android.livesdk.gift.platform.business.effect.service.ViewIdentifier;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/widget/GiftEffectOperationLayerWidget;", "Lcom/bytedance/android/livesdk/gift/platform/business/effect/widget/BaseGiftEffectLynxWidget;", "Lcom/bytedance/android/livesdk/gift/platform/business/effect/service/ViewIdentifier;", "f", "Lcom/bytedance/android/livesdk/gift/platform/business/effect/service/ViewIdentifier;", "getIdentifier", "()Lcom/bytedance/android/livesdk/gift/platform/business/effect/service/ViewIdentifier;", "identifier", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftEffectOperationLayerWidget extends BaseGiftEffectLynxWidget {
    public final ViewIdentifier f;

    public GiftEffectOperationLayerWidget() {
        this.f = ViewIdentifier.Operation;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseGiftEffectLynxWidget
    public ViewIdentifier getIdentifier() {
        return this.f;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseGiftEffectLynxWidget
    public final void onLoad(Object[] r4) {
        super.onLoad(r4);
        enableSubWidgetManager();
        WidgetManager r5 = ((Widget) this).subWidgetManager;
        Context r0 = ((Widget) this).context;
        RelativeLayout.LayoutParams r1 = new RelativeLayout.LayoutParams(-1, -1);
        FrameLayout r2 = new FrameLayout(r0);
        r2.setLayoutParams(r1);
        r2.setId(0);
        r5.load(r2, new GiftEffectMediaLayerWidget(), true);
    }
}
