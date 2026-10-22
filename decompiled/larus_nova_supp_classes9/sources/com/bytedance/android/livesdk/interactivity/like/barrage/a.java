package com.bytedance.android.livesdk.interactivity.like.barrage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.ss.ugc.live.barrage.barrage.AbsBarrage;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends com.ss.ugc.live.barrage.barrage.c {
    public final Lazy r;
    public float s;
    public int t;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.like.barrage.a$a, reason: collision with other inner class name */
    public static final class C0167a {
    }

    static {
    }

    public a(Bitmap r3) {
        Intrinsics.checkNotNullParameter(r3, "bitmap");
        super(r3);
        this.t = (int) 153.0d;
        this.r = InfraKotlinExtsKt.mainThreadLazy(DiggBarrage$matrix$2.INSTANCE);
        this.s = 1.0f;
        RectF r4 = ((AbsBarrage) this).f;
        r4.right = r4.left;
        r4.bottom = r4.top;
    }

    public final void g(Canvas r11) {
        Intrinsics.checkNotNullParameter(r11, "canvas");
        if (((AbsBarrage) this).g == AbsBarrage.State.VISIBLE) goto L5;
        return;
    L5:
        if (((com.ss.ugc.live.barrage.barrage.c) this).q.isRecycled() == true) goto L10;
        i().setAlpha(this.t);
        float r0 = ((AbsBarrage) this).f.width();
        float r1 = ((AbsBarrage) this).f.height();
        float r3 = 2;
        float r4 = r0 / r3;
        float r5 = r1 / r3;
        ((Matrix) this.r.getValue()).setRotate(0.0f, r4, r5);
        Matrix r2 = (Matrix) this.r.getValue();
        float r6 = this.s;
        r2.postScale(r6, r6);
        Matrix r7 = (Matrix) this.r.getValue();
        RectF r8 = ((AbsBarrage) this).f;
        float r9 = r8.left;
        float r10 = 1 - this.s;
        r7.postTranslate((r9 + ((r0 * 0.5f) * r10)) - r4, (r8.top + ((r1 * 0.5f) * r10)) - r5);
        r11.drawBitmap(((com.ss.ugc.live.barrage.barrage.c) this).q, (Matrix) this.r.getValue(), i());
        return;
    }
}
