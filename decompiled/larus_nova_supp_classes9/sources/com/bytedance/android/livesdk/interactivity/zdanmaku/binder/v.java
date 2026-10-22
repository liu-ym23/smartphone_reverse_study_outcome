package com.bytedance.android.livesdk.interactivity.zdanmaku.binder;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.barrage.widget.BarrageWidgetContext;
import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.DanmakuType;
import com.bytedance.live.artist.render.RenderEntity;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v extends com.bytedance.live.zdanmaku.data.b<n22.d> {
    public final w a;
    public final BarrageWidgetContext b;

    public final List b(Object r3) {
        n22.d r4 = (n22.d) r3;
        Intrinsics.checkNotNullParameter(r4, "data");
        return CollectionsKt.listOf(new tk6.b(r4, this.a));
    }

    public final void a(RenderEntity r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        Intrinsics.checkNotNullParameter((n22.d) r3, "data");
        r2.b(DanmakuType.Normal);
        BarrageWidgetContext r4 = this.b;
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.isPortrait() == true) goto L15;
        BarrageWidgetContext r5 = this.b;
        if (r5 == null) goto L16;
        com.bytedance.live.datacontext.j<pk6.a> r6 = r5.getDanmakuAlpha();
        if (r6 == null) goto L17;
        pk6.a r7 = (pk6.a) r6.getValue();
        if (r7 == null) goto L18;
        r2.a(pk6.a.class, r7);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    public v(View r2, h80.d<p22.i> r3, BarrageWidgetContext r4) {
        Intrinsics.checkNotNullParameter(r2, "templateView");
        Intrinsics.checkNotNullParameter(r3, "danmakuSettingConfigSupplier");
        this.b = r4;
        this.a = new w(r2, r3);
    }
}
