package com.bytedance.android.live.openplatform.impl.miniappaudience.widget;

import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformAudienceServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.HashMap;
import kotlin.Metadata;
import to0.a;
import zo0.f;
import zo0.g;
import zo0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappaudience/widget/AudienceMiniAppWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceMiniAppWidget extends LiveWidget {
    public a a;

    public final void onCreate() {
        super.onCreate();
        HashMap<String, f> r0 = g.a;
        f r1 = h.b(PerformanceScene.MINI_APP_CONTEXT);
        int r2 = f.d;
        r1.l("widget_created", null);
        OpenPlatformAudienceServiceImpl.Companion.getClass();
        po0.a.b r3 = (po0.a.b) OpenPlatformAudienceServiceImpl.access$getDiComponent$cp();
        r3.getClass();
        a r4 = (a) r3.a.d.get();
        this.a = r4;
        if (r4 == null) goto L6;
        r4.g(((Widget) this).context, ((Widget) this).dataCenter);
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        a r0 = this.a;
        if (r0 == null) goto L6;
        r0.onDestroy();
        return;
    }

    public AudienceMiniAppWidget() {
    }
}
