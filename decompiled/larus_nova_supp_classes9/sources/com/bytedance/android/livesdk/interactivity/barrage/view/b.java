package com.bytedance.android.livesdk.interactivity.barrage.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends Drawable {
    public final float a;
    public final Paint b;
    public final RectF c;
    public final List<String> d;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r13) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        this.c.set(getBounds());
        RectF r0 = this.c;
        float r1 = this.a;
        float r2 = 2;
        r0.inset(r1 / r2, r1 / r2);
        if (this.d == null) goto L5;
        RectF r3 = this.c;
        float r6 = r3.right - r3.left;
        Paint r4 = this.b;
        int r8 = com.bytedance.android.livesdk.interactivity.utils.b.c((String) ListProtector.get(this.d, 0));
        List<String> r5 = this.d;
        r4.setShader(new LinearGradient(0.0f, 1.0f, r6, 1.0f, r8, com.bytedance.android.livesdk.interactivity.utils.b.c((String) ListProtector.get(r5, r5.size() - 1)), Shader.TileMode.CLAMP));
    L5:
        RectF r7 = this.c;
        r13.drawRoundRect(r7, r7.height() / r2, this.c.height() / r2, this.b);
    }

    public b(int r2, List r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r2 = -1;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this.d = r3;
        float r5 = UtilityKotlinExtentionsKt.h(1);
        this.a = r5;
        Paint r0 = new Paint(1);
        r0.setColor(r2);
        r0.setStyle(Paint.Style.STROKE);
        r0.setStrokeWidth(r5);
        Unit r6 = Unit.INSTANCE;
        this.b = r0;
        this.c = new RectF();
    }
}
