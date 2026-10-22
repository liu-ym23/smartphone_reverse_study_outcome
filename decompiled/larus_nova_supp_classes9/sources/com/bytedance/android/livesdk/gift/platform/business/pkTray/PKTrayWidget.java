package com.bytedance.android.livesdk.gift.platform.business.pkTray;

import android.view.ViewGroup;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/pkTray/PKTrayWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PKTrayWidget extends LiveRecyclableWidget {
    public final int getLayoutId() {
        return 2131567143;
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
    }

    public PKTrayWidget() {
    }

    public final void onLoad(Object[] r2) {
        GiftContext r3 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r3 == null) goto L8;
        com.bytedance.live.datacontext.n<ViewGroup> r4 = r3.getPkTrayTempContainer();
        if (r4 == null) goto L9;
        r4.setValue(((Widget) this).containerView);
        return;
    L9:
        return;
    }
}
