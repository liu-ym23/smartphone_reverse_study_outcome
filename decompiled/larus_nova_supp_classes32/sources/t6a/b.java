package t6a;

import android.graphics.Rect;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.lynx.tasm.behavior.ui.LynxUI;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class b extends a {
    public abstract boolean d();

    public b() {
    }

    @Override // t6a.a
    public final Animation b(LynxUI r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, int r26, int r27, Rect r28, float r29) {
        View r0 = r11.getView();
        int r2 = this.a.d;
        float r4 = 1.0f;
        float r5 = 0.0f;
        if (r2 == 2) goto L37;
        if (r2 == 4) goto L28;
        if (r2 == 8) goto L19;
        if (d() == false) goto L11;
        float r3 = r29;
    L13:
        if (d() == true) goto L17;
        r5 = r29;
    L17:
        return new h(r0, r3, r5);
    L11:
        r3 = 0.0f;
        goto L13
    L19:
        if (d() == false) goto L21;
        float r1 = 1.0f;
    L23:
        if (d() == false) goto L26;
        r4 = 0.0f;
    L26:
        return new ScaleAnimation(r1, r4, r1, r4, 1, 0.5f, 1, 0.5f);
    L21:
        r1 = 0.0f;
        goto L23
    L28:
        if (d() == false) goto L30;
        float r6 = 1.0f;
    L32:
        if (d() == false) goto L35;
        r4 = 0.0f;
    L35:
        return new ScaleAnimation(1.0f, 1.0f, r6, r4, 1, 0.0f, 1, 0.5f);
    L30:
        r6 = 0.0f;
        goto L32
    L37:
        if (d() == false) goto L39;
        float r7 = 1.0f;
    L41:
        if (d() == false) goto L44;
        r4 = 0.0f;
    L44:
        return new ScaleAnimation(r7, r4, 1.0f, 1.0f, 1, 0.5f, 1, 0.0f);
    L39:
        r7 = 0.0f;
        goto L41
    }
}
