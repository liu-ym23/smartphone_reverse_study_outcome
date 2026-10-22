package com.bytedance.android.livesdk.interactivity.zdanmaku.units;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.bytedance.live.artist.render.RenderEntity;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a<T> extends tk6.b<T> {
    public static final sk6.a k = null;
    public final Lazy g;
    public final Matrix h;
    public sk6.a i;
    public Bitmap j;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.zdanmaku.units.a$a, reason: collision with other inner class name */
    public static final class C0222a {
    }

    static {
        k = new sk6.a(0);
    }

    public final void d() {
        super/*of6.c*/.d();
        Object r0 = ((of6.c) this).d;
        boolean r1 = r0 instanceof q72.b;
        if (r1 == true) goto L5;
        Object r3 = null;
    L6:
        q72.b r4 = (q72.b) r3;
        if (r4 == null) goto L9;
        r4.b = null;
    L9:
        if (r1 == true) goto L11;
        Object r2 = null;
    L12:
        q72.b r5 = (q72.b) r2;
        if (r5 == null) goto L16;
        r5.a = null;
    L16:
        if ((r0 instanceof q72.c) == true) goto L18;
        r0 = null;
    L18:
        q72.c r6 = (q72.c) r0;
        if (r6 == null) goto L22;
        r6.f = null;
        return;
    L22:
        return;
    L11:
        r2 = r0;
        goto L12
    L5:
        r3 = r0;
        goto L6
    }

    public final void e() {
        super/*of6.c*/.e();
        of6.a r0 = ((of6.c) this).c;
        if (r0 == null) goto L29;
        this.j = ((tk6.a) r0).i;
        boolean r1 = r0 instanceof tk6.a;
        if (r1 == true) goto L7;
        of6.a r3 = null;
    L8:
        tk6.a r4 = (tk6.a) r3;
        int r5 = 0;
        if (r4 == null) goto L11;
        int r6 = r4.g;
    L12:
        if (r1 == true) goto L14;
        r0 = null;
    L14:
        tk6.a r2 = (tk6.a) r0;
        if (r2 == null) goto L17;
        r5 = r2.h;
    L17:
        float r7 = r6;
        float r8 = r5;
        RenderEntity r9 = ((com.bytedance.live.artist.render.e) this).a;
        if (r9 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("entity");
    L20:
        com.bytedance.live.artist.render.f r10 = r9.c;
        r10.a = r7;
        r10.b = r8;
        RenderEntity r11 = ((com.bytedance.live.artist.render.e) this).a;
        if (r11 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("entity");
    L23:
        sk6.a r13 = r11.e(sk6.a.class);
        if (r13 != null) goto L26;
        r13 = k;
    L26:
        this.i = r13;
        return;
    L11:
        r6 = 0;
        goto L12
    L7:
        r3 = r0;
        goto L8
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.zdanmaku.render.canvas.template.BitmapRenderSnapshot");
    }

    public final void f() {
        if (c().i != null) goto L5;
        super/*of6.c*/.f();
        return;
    L5:
        sk6.a r0 = this.i;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("danmakuAttributes");
    L8:
        float r1 = r0.c.a;
        sk6.a r2 = this.i;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("danmakuAttributes");
    L11:
        float r3 = r2.c.b;
        RenderEntity r4 = c();
        com.bytedance.live.artist.render.b r5 = r4.e;
        r5.a = r1;
        r5.b = r3;
        com.bytedance.live.artist.render.f r6 = r4.c;
        float r7 = r1 - (r6.a / 2.0f);
        float r8 = r3 - (r6.b / 2.0f);
        com.bytedance.live.artist.render.b r9 = r4.d;
        r9.a = r7;
        r9.b = r8;
        this.h.reset();
        Matrix r10 = this.h;
        sk6.a r11 = this.i;
        if (r11 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("danmakuAttributes");
    L14:
        float r13 = r11.b.a;
        sk6.a r14 = this.i;
        if (r14 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("danmakuAttributes");
    L17:
        r10.setScale(r13, r14.b.b, c().c.a * 0.5f, c().c.b * 0.5f);
        this.h.postTranslate(c().d.a, c().d.b);
        Paint r15 = (Paint) this.g.getValue();
        sk6.a r16 = this.i;
        if (r16 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("danmakuAttributes");
    L20:
        r15.setAlpha(r16.a.a);
        Canvas r17 = ((tk6.b) this).f;
        if (r17 == null) goto L28;
        Bitmap r18 = this.j;
        if (r18 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("bitmap");
    L25:
        r17.drawBitmap(r18, this.h, (Paint) this.g.getValue());
        return;
    }

    public a(Object r2, tk6.e r3) {
        Intrinsics.checkNotNullParameter(r3, "template");
        super(r2, r3);
        this.g = LazyKt.lazy(ActionCanvasTemplateRenderUnit$bitmapPaint$2.INSTANCE);
        this.h = new Matrix();
    }
}
