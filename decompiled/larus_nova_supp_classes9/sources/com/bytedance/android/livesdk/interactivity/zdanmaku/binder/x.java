package com.bytedance.android.livesdk.interactivity.zdanmaku.binder;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.barrage.widget.BarrageWidgetContext;
import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.DanmakuType;
import com.bytedance.live.artist.render.RenderEntity;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class x extends com.bytedance.live.zdanmaku.data.b<com.bytedance.android.livesdk.interactivity.zdanmaku.d> {
    public final z a;
    public final h80.d<p22.i> b;
    public final BarrageWidgetContext c;

    public final List b(Object r3) {
        com.bytedance.android.livesdk.interactivity.zdanmaku.d r4 = (com.bytedance.android.livesdk.interactivity.zdanmaku.d) r3;
        Intrinsics.checkNotNullParameter(r4, "data");
        return CollectionsKt.listOf(new tk6.b(r4, this.a));
    }

    public final void a(RenderEntity r2, Object r3) {
        com.bytedance.android.livesdk.interactivity.zdanmaku.d r4 = (com.bytedance.android.livesdk.interactivity.zdanmaku.d) r3;
        Intrinsics.checkNotNullParameter(r2, "entity");
        Intrinsics.checkNotNullParameter(r4, "data");
        r2.b(DanmakuType.NotifyEffect);
        r2.a(y.class, new y(r4));
        BarrageWidgetContext r5 = this.c;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isPortrait() == true) goto L15;
        BarrageWidgetContext r6 = this.c;
        if (r6 == null) goto L16;
        com.bytedance.live.datacontext.j<pk6.a> r7 = r6.getDanmakuAlpha();
        if (r7 == null) goto L17;
        pk6.a r8 = (pk6.a) r7.getValue();
        if (r8 == null) goto L18;
        r2.a(pk6.a.class, r8);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    public x(View r2, h80.d<p22.i> r3, BarrageWidgetContext r4) {
        Intrinsics.checkNotNullParameter(r2, "templateView");
        Intrinsics.checkNotNullParameter(r3, "textDanmakuSettingConfigSupplier");
        this.b = r3;
        this.c = r4;
        this.a = new z(r2, r3);
    }
}
