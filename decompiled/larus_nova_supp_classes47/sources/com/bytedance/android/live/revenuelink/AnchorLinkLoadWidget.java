package com.bytedance.android.live.revenuelink;

import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.common.utility.Logger;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revenuelink/AnchorLinkLoadWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "<init>", "()V", "revenue-link-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AnchorLinkLoadWidget extends LiveWidget {
    public final CompositeDisposable a;

    public AnchorLinkLoadWidget() {
        this.a = new CompositeDisposable();
    }

    public final void onCreate() {
        super.onCreate();
        wq(true);
    }

    public final void onDestroy() {
        super.onDestroy();
        CompositeDisposable r0 = this.a;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        wq(false);
    }

    public final void wq(boolean r3) {
        StringBuilder r0 = new StringBuilder("component ");
        if (r3 == false) goto L5;
        String r4 = "load";
    L6:
        r0.append(r4);
        r0.append(" success, elementType is ");
        r0.append(getElementType());
        r0.append(", class is AnchorLinkLoadWidget");
        Logger.i("InteractionFrameworkTracer", r0.toString());
        return;
    L5:
        r4 = "unload";
        goto L6
    }
}
