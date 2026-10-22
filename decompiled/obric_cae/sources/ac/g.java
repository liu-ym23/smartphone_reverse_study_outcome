package ac;

import android.annotation.TargetApi;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f289a;

    public g(h r8) {
        this.f289a = r8;
    }

    @Override // android.view.ViewOutlineProvider
    @TargetApi(21)
    public final void getOutline(View r17, Outline r18) {
        int r8 = r17.getWidth();
        int r10 = r17.getHeight();
        if (r8 == 0) goto L33;
        if (r10 == 0) goto L36;
        h r11 = this.f289a;
        float r12 = r11.m();
        float r13 = r12 * 2.0f;
        float r14 = Math.min(r8, r10);
        if (r13 <= r14) goto L9;
        float r15 = r14 / 2.0f;
    L11:
        if (r11.S == false) goto L14;
        Path r16 = new Path();
        RectF r19 = new RectF(0.0f, 0.0f, r8, r10);
        float r20 = r11.O;
        float r21 = r11.P;
        float r22 = r11.R;
        float r23 = r11.Q;
        r16.addRoundRect(r19, new float[]{r20, r20, r21, r21, r22, r22, r23, r23}, Path.Direction.CW);
        r18.setConvexPath(r16);
        r17.setClipToOutline(true);
        return;
    L14:
        int r24 = r11.f297g0;
        int r25 = Math.max(r24 + 1, r10 - r11.f298h0);
        int r26 = r11.f295e0;
        int r27 = r8 - r11.f296f0;
        if (r11.Y == false) goto L17;
        int r110 = r17.getPaddingLeft() + r26;
        int r28 = r17.getPaddingTop() + r24;
        int r29 = Math.max(r110 + 1, r27 - r17.getPaddingRight());
        int r30 = Math.max(r28 + 1, r25 - r17.getPaddingBottom());
        int r31 = r28;
        int r32 = r110;
    L18:
        float r33 = r11.f294c0;
        if (r11.f293b0 != 0) goto L21;
        r33 = 1.0f;
    L21:
        r18.setAlpha(r33);
        if (r15 > 0.0f) goto L25;
        r18.setRect(r32, r31, r29, r30);
        return;
    L25:
        if (o.f344d == true) goto L27;
        r18.setRoundRect(r32, r31, r29, r30, r15);
        return;
    L27:
        float r111 = r32;
        float r112 = r31;
        float r113 = r29;
        float r114 = r30;
        float r34 = r113 - r111;
        float r35 = r114 - r112;
        float r36 = Math.min(r15, Math.min(Math.abs(r34), Math.abs(r35)) / 2.0f);
        if (r36 >= 0.0f) goto L30;
        float r115 = 0.0f;
    L31:
        r18.setPath(o.c(r115, Math.min(Math.abs(r34), Math.abs(r35))).f9100a.a(r111, r112, r113, r114, r115));
        return;
    L30:
        r115 = r36;
        goto L31
    L17:
        r29 = r27;
        r32 = r26;
        r30 = r25;
        r31 = r24;
        goto L18
    L9:
        r15 = r12;
        goto L11
    L36:
        return;
    }
}
