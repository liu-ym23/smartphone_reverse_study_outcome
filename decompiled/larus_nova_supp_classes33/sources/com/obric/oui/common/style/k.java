package com.obric.oui.common.style;

import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.obric.oui.material.OMaterialHelper;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class k extends ViewOutlineProvider {
    public final /* synthetic */ l a;

    public k(l r1) {
        this.a = r1;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r18, Outline r19) {
        int r2 = r18.getWidth();
        int r3 = r18.getHeight();
        if (r2 == 0) goto L34;
        if (r3 == 0) goto L38;
        float r4 = this.a.k();
        float r7 = r4 * 2.0f;
        float r5 = Math.min(r2, r3);
        if (r7 <= r5) goto L9;
        float r8 = r5 / 2.0f;
    L10:
        l r6 = this.a;
        if (r6.I == false) goto L14;
        Path r9 = new Path();
        RectF r10 = new RectF(0.0f, 0.0f, r2, r3);
        l r11 = this.a;
        float r12 = r11.E;
        float r13 = r11.F;
        float r14 = r11.H;
        float r15 = r11.G;
        r9.addRoundRect(r10, new float[]{r12, r12, r13, r13, r14, r14, r15, r15}, Path.Direction.CW);
        r19.setConvexPath(r9);
        r18.setClipToOutline(!this.a.J);
        return;
    L14:
        int r16 = r6.k0;
        int r17 = Math.max(r16 + 1, r3 - r6.p0);
        l r20 = this.a;
        int r110 = r20.Y;
        int r21 = r2 - r20.Z;
        if (r20.P == false) goto L17;
        r110 = r110 + r18.getPaddingLeft();
        r16 = r16 + r18.getPaddingTop();
        r21 = Math.max(r110 + 1, r21 - r18.getPaddingRight());
        r17 = Math.max(r16 + 1, r17 - r18.getPaddingBottom());
    L17:
        int r22 = r21;
        int r23 = r17;
        int r24 = r16;
        int r25 = r110;
        l r26 = this.a;
        float r111 = r26.U;
        if (r26.T != 0) goto L20;
        r111 = 1.0f;
    L20:
        r19.setAlpha(r111);
        if (r8 > 0.0f) goto L24;
        r19.setRect(r25, r24, r22, r23);
        return;
    L24:
        if (r.e == true) goto L26;
    L32:
        r19.setRoundRect(r25, r24, r22, r23, r8);
        return;
    L26:
        if (OMaterialHelper.k() == true) goto L32;
        if (Build.VERSION.SDK_INT < 30) goto L31;
        float r112 = r25;
        float r113 = r24;
        float r114 = r22;
        float r115 = r23;
        float r27 = r114 - r112;
        float r28 = r115 - r113;
        float r29 = RangesKt.coerceAtLeast(Math.min(r8, Math.min(Math.abs(r27), Math.abs(r28)) / 2.0f), 0.0f);
        r19.setPath(r.b(r29, Math.min(Math.abs(r27), Math.abs(r28))).a.a(r112, r113, r114, r115, r29));
        return;
    L31:
        r19.setRoundRect(r25, r24, r22, r23, r8);
        return;
    L9:
        r8 = r4;
        goto L10
    L38:
        return;
    }
}
