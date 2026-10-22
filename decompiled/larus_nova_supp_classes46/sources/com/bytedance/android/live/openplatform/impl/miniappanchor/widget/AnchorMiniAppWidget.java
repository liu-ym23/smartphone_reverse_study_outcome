package com.bytedance.android.live.openplatform.impl.miniappanchor.widget;

import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.live.openplatform.impl.miniappanchor.context.LiveAnchorMiniAppContext;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zo0.f;
import zo0.g;
import zo0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/widget/AnchorMiniAppWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorMiniAppWidget extends LiveWidget {
    public LiveAnchorMiniAppContext a;

    public final void onCreate() {
        super.onCreate();
        HashMap<String, f> r0 = g.a;
        PerformanceScene r1 = PerformanceScene.MINI_APP_CONTEXT;
        h.b(r1).o();
        LiveAnchorMiniAppContext r2 = new LiveAnchorMiniAppContext(((Widget) this).context, ((Widget) this).dataCenter, ((Widget) this).containerView);
        this.a = r2;
        r2.dispatchLifecycleEvent(Lifecycle.Event.ON_CREATE);
        h.b(r1).l("context_initialized", null);
    }

    public final void onDestroy() {
        super.onDestroy();
        LiveAnchorMiniAppContext r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppContext");
    L5:
        r0.dispatchLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    public AnchorMiniAppWidget() {
    }
}
