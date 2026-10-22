package com.bytedance.android.livesdk.interactivity.zdanmaku.units;

import android.graphics.Canvas;
import com.bytedance.android.livesdk.interactivity.zdanmaku.binder.e0;
import com.bytedance.live.artist.render.RenderEntity;
import kotlin.jvm.internal.Intrinsics;
import tc2.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<T> extends tk6.b<T> {
    public float g;

    public final void e() {
        super/*of6.c*/.e();
        this.g = 0.0f;
        RenderEntity r0 = c();
        of6.a r1 = ((of6.c) this).c;
        if (r1 == null) goto L9;
        RenderEntity r2 = ((com.bytedance.live.artist.render.e) r1).a;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("entity");
    L7:
        com.bytedance.live.artist.render.f r3 = r2.c;
        if (r3 == null) goto L9;
    L10:
        com.bytedance.live.artist.render.f r4 = r0.c;
        r4.a = r3.a;
        r4.b = r3.b;
        return;
    L9:
        r3 = new com.bytedance.live.artist.render.f();
        goto L10
    }

    public final void f() {
        g r0 = (g) c().e(g.class);
        if (r0 == null) goto L5;
        float r1 = r0.a;
    L6:
        Canvas r2 = ((tk6.b) this).f;
        if (r2 == null) goto L9;
        r2.save();
    L9:
        Canvas r3 = ((tk6.b) this).f;
        if (r3 == null) goto L12;
        r3.translate(this.g, 0.0f);
    L12:
        this.g += r1 * 0.2f;
        super/*of6.c*/.f();
        Canvas r4 = ((tk6.b) this).f;
        if (r4 == null) goto L16;
        r4.restore();
        return;
    L16:
        return;
    L5:
        r1 = 0.0f;
        goto L6
    }

    public c(Object r2, e0 r3) {
        Intrinsics.checkNotNullParameter(r3, "template");
        super(r2, r3);
    }
}
