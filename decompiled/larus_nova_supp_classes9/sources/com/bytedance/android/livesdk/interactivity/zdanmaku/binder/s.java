package com.bytedance.android.livesdk.interactivity.zdanmaku.binder;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.barrage.widget.BarrageWidgetContext;
import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.DanmakuType;
import com.bytedance.live.artist.render.RenderEntity;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class s extends com.bytedance.live.zdanmaku.data.b<q22.a> {
    public final u a;
    public final BarrageWidgetContext b;

    public final List b(Object r3) {
        q22.a r4 = (q22.a) r3;
        Intrinsics.checkNotNullParameter(r4, "data");
        return CollectionsKt.listOf(new r(r4, this.a, r4));
    }

    public final void a(RenderEntity r11, Object r13) {
        q22.a r14 = (q22.a) r13;
        Intrinsics.checkNotNullParameter(r11, "entity");
        Intrinsics.checkNotNullParameter(r14, "data");
        r11.b(DanmakuType.Gift);
        BarrageWidgetContext r0 = this.b;
        if (r0 != null) goto L5;
    L13:
        r11.a(tc2.e.class, new tc2.e(0, 0, r14.b, 3));
        return;
    L5:
        if (r0.isPortrait() == true) goto L13;
        BarrageWidgetContext r1 = this.b;
        if (r1 == null) goto L13;
        com.bytedance.live.datacontext.j<pk6.a> r2 = r1.getDanmakuAlpha();
        if (r2 == null) goto L13;
        pk6.a r3 = (pk6.a) r2.getValue();
        if (r3 == null) goto L13;
        r11.a(pk6.a.class, r3);
        goto L13
    }

    public s(View r2, h80.d<p22.g> r3, BarrageWidgetContext r4) {
        Intrinsics.checkNotNullParameter(r2, "giftTemplateView");
        Intrinsics.checkNotNullParameter(r3, "giftDanmakuSettingConfigSupplier");
        this.b = r4;
        this.a = new u(r2, r3);
    }
}
