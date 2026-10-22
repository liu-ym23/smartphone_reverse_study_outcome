package com.bytedance.android.live.revlink.impl.multianchor.widget;

import android.content.Context;
import com.bytedance.android.live.core.performance.TimeCostUtil;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i implements com.bytedance.android.live.revlink.link.domain.anchorimpl.l {
    public final LiveWidget a;
    public final boolean b;

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.l
    public final void a() {
        com.bytedance.android.live.core.performance.a r0 = com.bytedance.android.live.core.performance.a.a;
        TimeCostUtil.Tag r1 = TimeCostUtil.Tag.LivePk;
        r1.name();
        this.a.getLifecycle();
        Context r2 = ((Widget) this.a).context;
        r0.getClass();
        r1.name();
        this.a.getLifecycle();
        Context r3 = ((Widget) this.a).context;
        r0.getClass();
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.l
    public final void b() {
        com.bytedance.android.live.core.performance.a r0 = com.bytedance.android.live.core.performance.a.a;
        TimeCostUtil.Tag.LivePk.name();
        TimeCostUtil.a("isAnchor", String.valueOf(this.b));
        r0.getClass();
    }

    public i(LiveWidget r2) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        this.a = r2;
        this.b = true;
    }
}
