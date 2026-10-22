package com.bytedance.android.livesdk.gift.platform.business.effect.widget;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.gift.platform.business.effect.giftview.GestureGiftGuideView;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/widget/GestureGiftGuideWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GestureGiftGuideWidget extends LiveRecyclableWidget {
    public GestureGiftGuideView a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ GestureGiftGuideWidget a;

        public a(GestureGiftGuideWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ((jy1.a) r2).getClass();
            GestureGiftGuideView r3 = this.a.a;
            if (r3 == null) goto L5;
            r3.a();
        L5:
            GestureGiftGuideWidget r4 = this.a;
            ((Widget) r4).containerView.removeView(r4.a);
        }
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        GestureGiftGuideView r0 = this.a;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public GestureGiftGuideWidget() {
    }

    public final void onLoad(Object[] r5) {
        this.a = new GestureGiftGuideView(((Widget) this).context, null, 6, 0);
        ((ObservableSubscribeProxy) xs2.b.a().b(jy1.a.class).as(autoDispose())).subscribe(new a(this));
    }
}
