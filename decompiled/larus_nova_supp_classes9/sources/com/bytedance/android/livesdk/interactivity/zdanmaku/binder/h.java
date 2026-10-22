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
public final class h extends com.bytedance.live.zdanmaku.data.b<q72.c> {
    public final i a;
    public final BarrageWidgetContext b;

    public final List b(Object r3) {
        q72.c r4 = (q72.c) r3;
        Intrinsics.checkNotNullParameter(r4, "data");
        if (r4.b == false) goto L6;
        return CollectionsKt.listOf(new com.bytedance.android.livesdk.interactivity.zdanmaku.units.b(r4));
    L6:
        return CollectionsKt.listOf(new com.bytedance.android.livesdk.interactivity.zdanmaku.units.a(r4, this.a));
    }

    public h(View r2, BarrageWidgetContext r3) {
        Intrinsics.checkNotNullParameter(r2, "templateView");
        this.b = r3;
        this.a = new i(r2, r3);
    }

    public final void a(RenderEntity r13, Object r14) {
        q72.c r15 = (q72.c) r14;
        Intrinsics.checkNotNullParameter(r13, "entity");
        Intrinsics.checkNotNullParameter(r15, "data");
        r13.b(DanmakuType.CarnivalEgg);
        int r1 = 0;
        r13.a(sk6.a.class, new sk6.a(0));
        BarrageWidgetContext r0 = this.b;
        if (r0 == null) goto L39;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.interactivity.api.barrage.data.d> r2 = r0.getChatCarnivalMessage();
        if (r2 == null) goto L40;
        com.bytedance.android.livesdk.interactivity.api.barrage.data.d r3 = (com.bytedance.android.livesdk.interactivity.api.barrage.data.d) r2.getValue();
        if (r3 == null) goto L41;
        List<Long> r4 = r3.v();
        if (r4 == null) goto L11;
        int r5 = r4.size();
    L12:
        List<Long> r6 = r3.y();
        if (r6 == null) goto L15;
        int r7 = r6.size();
    L16:
        if (r5 == 0) goto L31;
        if (r7 == 0) goto L31;
        if (r7 != r5) goto L31;
        int r8 = RangesKt.random(RangesKt.until(0, r5), Random.Default);
        List<Long> r9 = r3.v();
        if (r9 == null) goto L25;
        Long r10 = (Long) ListProtector.get(r9, r8);
        if (r10 == null) goto L25;
        long r11 = r10.longValue();
    L26:
        float r16 = r11 / 100.0f;
        List<Long> r17 = r3.y();
        if (r17 == null) goto L32;
        Long r18 = (Long) ListProtector.get(r17, r8);
        if (r18 == null) goto L32;
        r1 = (int) r18.longValue();
    L32:
        r13.a(pk6.a.class, new pk6.a((int) (255 * r16)));
        if (r15.b == true) goto L35;
    L37:
        r13.a(tc2.f.class, new tc2.f(Float.valueOf(r16), Integer.valueOf(r1), null, null, 0, 28));
        return;
    L35:
        if (r15.c == false) goto L37;
        r13.a(tc2.f.class, new tc2.f(Float.valueOf(r16), Integer.valueOf(r1), Boolean.TRUE, null, 0, 24));
        r13.f = 99;
        return;
    L25:
        r11 = 100;
    L31:
        r16 = 1.0f;
        goto L32
    L15:
        r7 = 0;
        goto L16
    L11:
        r5 = 0;
        goto L12
    L41:
        return;
    L40:
        return;
    }
}
