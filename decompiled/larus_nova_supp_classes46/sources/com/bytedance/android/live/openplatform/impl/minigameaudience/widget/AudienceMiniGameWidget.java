package com.bytedance.android.live.openplatform.impl.minigameaudience.widget;

import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.openplatform.impl.minigameaudience.context.AudienceMiniGameContext;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameaudience/widget/AudienceMiniGameWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceMiniGameWidget extends LiveWidget {
    public final String a;
    public AudienceMiniGameContext b;

    public AudienceMiniGameWidget() {
        this.a = "AudienceMiniGameWidget";
    }

    public final void onCreate() {
        super.onCreate();
        Logger.d(this.a, "onCreate");
        if (((Widget) this).context != null) goto L5;
        return;
    L5:
        AudienceMiniGameContext r0 = new AudienceMiniGameContext(((Widget) this).context, ((Widget) this).dataCenter, ((Widget) this).containerView);
        this.b = r0;
        r0.dispatchLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    public final void onDestroy() {
        super.onDestroy();
        Logger.d(this.a, "onDestroy");
        AudienceMiniGameContext r0 = this.b;
        if (r0 == null) goto L6;
        r0.dispatchLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        return;
    }
}
