package com.bytedance.android.livesdk.interactivity.zdanmaku.binder;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.barrage.widget.BarrageWidgetContext;
import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.DanmakuType;
import com.bytedance.live.artist.render.RenderEntity;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n extends com.bytedance.live.zdanmaku.data.b<q72.c> {
    public final o a;

    public final List b(Object r3) {
        q72.c r4 = (q72.c) r3;
        Intrinsics.checkNotNullParameter(r4, "data");
        if (r4.b == false) goto L6;
        return CollectionsKt.listOf(new com.bytedance.android.livesdk.interactivity.zdanmaku.units.b(r4));
    L6:
        return CollectionsKt.listOf(new com.bytedance.android.livesdk.interactivity.zdanmaku.units.a(r4, this.a));
    }

    public n(View r2, BarrageWidgetContext r3) {
        Intrinsics.checkNotNullParameter(r2, "templateView");
        this.a = new o(r2, r3);
    }

    public final void a(final RenderEntity r10, Object r11) {
        final q72.c r13 = (q72.c) r11;
        Intrinsics.checkNotNullParameter(r10, "entity");
        Intrinsics.checkNotNullParameter(r13, "data");
        r10.b(r13.a);
        r10.a(sk6.a.class, new sk6.a(0));
        r10.a(pk6.a.class, new pk6.a(255));
        boolean r0 = r13.b;
        Float r3 = Float.valueOf(1.0f);
        if (r0 == true) goto L5;
    L7:
        r10.a(tc2.f.class, new tc2.f(r3, 0, null, null, 0, 28));
    L9:
        if (r13.a != DanmakuType.RedPacketEgg) goto L15;
        final String r1 = r13.h;
        if (r1 == null) goto L13;
        com.bytedance.android.livesdk.interactivity.utils.u.a(r10, new GeneralCarnivalEggRenderBinder$onBindEntity$$inlined$let$lambda$1(r1, this, r10, r13));
    L13:
        Function1<RenderEntity, Unit> r2 = new GeneralCarnivalEggRenderBinder$onBindEntity$2(this, r13);
        Intrinsics.checkNotNullParameter(r10, "$this$setOnShowListener");
        r10.a(tc2.k.class, new com.bytedance.android.livesdk.interactivity.utils.v(r10, r2));
        return;
    L15:
        return;
    L5:
        if (r13.c == false) goto L7;
        r10.a(tc2.f.class, new tc2.f(r3, 0, Boolean.TRUE, null, 0, 24));
        r10.f = 99;
        goto L9
    }
}
