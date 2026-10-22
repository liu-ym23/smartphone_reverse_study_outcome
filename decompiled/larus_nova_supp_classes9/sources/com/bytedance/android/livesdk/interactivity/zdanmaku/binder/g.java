package com.bytedance.android.livesdk.interactivity.zdanmaku.binder;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.barrage.widget.BarrageWidgetContext;
import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.DanmakuType;
import com.bytedance.live.artist.render.RenderEntity;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g extends com.bytedance.live.zdanmaku.data.b<q72.b> {
    public final j a;
    public final BarrageWidgetContext b;

    public final List b(Object r3) {
        q72.b r4 = (q72.b) r3;
        Intrinsics.checkNotNullParameter(r4, "data");
        return CollectionsKt.listOf(new com.bytedance.android.livesdk.interactivity.zdanmaku.units.a(r4, this.a));
    }

    public g(View r2, BarrageWidgetContext r3) {
        Intrinsics.checkNotNullParameter(r2, "templateView");
        this.b = r3;
        this.a = new j(r2, r3);
    }

    public final void a(RenderEntity r11, Object r13) {
        q72.b r14 = (q72.b) r13;
        Intrinsics.checkNotNullParameter(r11, "entity");
        Intrinsics.checkNotNullParameter(r14, "data");
        r11.b(DanmakuType.Carnival);
        r11.a(sk6.a.class, new sk6.a(0));
        r11.a(sk6.b.class, new sk6.b(r14.getScore()));
        BarrageWidgetContext r15 = this.b;
        if (r15 == null) goto L34;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.interactivity.api.barrage.data.d> r16 = r15.getChatCarnivalMessage();
        if (r16 == null) goto L35;
        com.bytedance.android.livesdk.interactivity.api.barrage.data.d r17 = (com.bytedance.android.livesdk.interactivity.api.barrage.data.d) r16.getValue();
        if (r17 == null) goto L36;
        List<Long> r0 = r17.v();
        if (r0 == null) goto L11;
        int r1 = r0.size();
    L12:
        List<Long> r2 = r17.y();
        if (r2 == null) goto L15;
        int r3 = r2.size();
    L16:
        if (r1 == 0) goto L37;
        if (r3 == 0) goto L38;
        if (r3 != r1) goto L39;
        int r4 = RangesKt.random(RangesKt.until(0, r1), Random.Default);
        List<Long> r5 = r17.v();
        if (r5 == null) goto L25;
        Long r6 = (Long) ListProtector.get(r5, r4);
        if (r6 == null) goto L25;
        long r7 = r6.longValue();
    L26:
        float r8 = r7 / 100.0f;
        List<Long> r18 = r17.y();
        if (r18 == null) goto L31;
        Long r19 = (Long) ListProtector.get(r18, r4);
        if (r19 == null) goto L31;
        long r9 = r19.longValue();
    L32:
        r11.a(pk6.a.class, new pk6.a((int) (255 * r8)));
        r11.a(tc2.f.class, new tc2.f(Float.valueOf(r8), Integer.valueOf((int) r9), null, null, 0, 28));
        return;
    L31:
        r9 = 0;
    L25:
        r7 = 100;
        goto L26
    L39:
        return;
    L38:
        return;
    L37:
        return;
    L15:
        r3 = 0;
        goto L16
    L11:
        r1 = 0;
        goto L12
    L36:
        return;
    L35:
        return;
    }
}
