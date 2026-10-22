package com.bytedance.android.live.openplatform.impl.minigameanchor.widget;

import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.openplatform.impl.minigameanchor.context.LiveAnchorMiniGameContext;
import com.bytedance.android.livesdk.chatroom.widget.RoomWidget;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameanchor/widget/AnchorMiniGameWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomWidget;", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorMiniGameWidget extends RoomWidget {
    public final String b;
    public LiveAnchorMiniGameContext c;

    public AnchorMiniGameWidget() {
        this.b = "AnchorMiniGameWidget";
    }

    public final void onCreate() {
        super.onCreate();
        Logger.d(this.b, "onCreate");
        if (((Widget) this).context != null) goto L5;
        return;
    L5:
        LiveAnchorMiniGameContext r0 = new LiveAnchorMiniGameContext(((Widget) this).context, ((Widget) this).dataCenter, ((Widget) this).containerView);
        this.c = r0;
        r0.dispatchLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onDestroy();
        Logger.d(this.b, "onDestroy");
        LiveAnchorMiniGameContext r0 = this.c;
        if (r0 == null) goto L6;
        r0.dispatchLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        return;
    }
}
