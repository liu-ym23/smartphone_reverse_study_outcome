package com.bytedance.android.livesdk.interactivity.zdanmaku.binder;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.barrage.widget.BarrageWidgetContext;
import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.DanmakuType;
import com.bytedance.live.artist.render.RenderEntity;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p extends com.bytedance.live.zdanmaku.data.b<q72.d> {
    public final q a;
    public final BarrageWidgetContext b;

    public final List b(Object r3) {
        q72.d r4 = (q72.d) r3;
        Intrinsics.checkNotNullParameter(r4, "data");
        return CollectionsKt.listOf(new tk6.b(r4, this.a));
    }

    public p(View r2, BarrageWidgetContext r3) {
        Intrinsics.checkNotNullParameter(r2, "templateView");
        this.b = r3;
        this.a = new q(r2, r3);
    }

    public final void a(RenderEntity r10, Object r11) {
        q72.d r13 = (q72.d) r11;
        Intrinsics.checkNotNullParameter(r10, "entity");
        Intrinsics.checkNotNullParameter(r13, "data");
        r10.b(DanmakuType.Carnival);
        BarrageWidgetContext r0 = this.b;
        if (r0 != null) goto L5;
    L9:
        r10.a(tc2.f.class, new tc2.f(null, null, null, Integer.valueOf(r13.b), (int) r13.a, 7));
        return;
    L5:
        if (r0.isPortrait() == true) goto L9;
        pk6.a r1 = (pk6.a) this.b.getDanmakuAlpha().getValue();
        if (r1 == null) goto L9;
        r10.a(pk6.a.class, r1);
        goto L9
    }
}
