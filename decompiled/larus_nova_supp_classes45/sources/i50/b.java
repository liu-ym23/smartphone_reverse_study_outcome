package i50;

import android.opengl.Matrix;
import com.bytedance.android.live.core.gl.camera.BaseCamera;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends BaseCamera {
    @Override // com.bytedance.android.live.core.gl.camera.BaseCamera
    public final void a() {
        int[] r1 = this.a;
        int r3 = r1[2];
        if (r3 == 0) goto L5;
    L7:
        float r4 = r3 / r1[3];
        this.g = r4;
        int r2 = a.a[this.k.ordinal()];
        if (r2 == 1) goto L21;
        if (r2 == 2) goto L20;
        if (r2 == 3) goto L16;
        if (r2 == 4) goto L13;
        float r8 = 0.0f;
    L22:
        float r5 = this.g;
        int r6 = a.b[this.k.ordinal()];
        if (r6 == 1) goto L35;
        if (r6 == 2) goto L34;
        if (r6 == 3) goto L31;
        if (r6 == 4) goto L28;
        float r7 = 0.0f;
    L36:
        Matrix.setIdentityM(this.b, 0);
        Matrix.orthoM(this.b, 0, 0.0f - this.h.getLeftMargin(r8), this.h.getRightMargin(r8) + 0.0f, 0.0f - this.h.getBottomMargin(r7), this.h.getTopMargin(r7) + 0.0f, 1.0f, 100.0f);
        return;
    L28:
        float r9 = this.j;
        float r11 = r9 * r5;
        float r12 = this.i;
        r7 = r12 / r5;
        if ((r11 * r9) >= (r12 * r7)) goto L36;
    L33:
        r7 = r9;
        goto L36
    L31:
        r9 = this.j;
        float r13 = r9 * r5;
        float r14 = this.i;
        r7 = r14 / r5;
        if ((r13 * r9) <= (r14 * r7)) goto L36;
    L34:
        r7 = this.j;
        goto L36
    L35:
        r7 = this.i / r5;
        goto L36
    L13:
        float r15 = this.j;
        r8 = r15 * r4;
        float r16 = this.i;
        if ((r15 * r8) < ((r16 / r4) * r16)) goto L22;
    L19:
        r8 = r16;
        goto L22
    L16:
        float r17 = this.j;
        r8 = r17 * r4;
        r16 = this.i;
        if ((r17 * r8) <= ((r16 / r4) * r16)) goto L19;
    L20:
        r8 = r4 * this.j;
        goto L22
    L21:
        r8 = this.i;
        goto L22
    L5:
        if (r1[3] != 0) goto L7;
    }

    public b() {
    }
}
