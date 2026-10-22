package t50;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.bytedance.android.live.core.gl.primitive.RotationOrder;
import com.bytedance.android.live.core.gl.primitive.c;
import com.bytedance.android.live.core.gl.primitive.e;
import k50.f;
import kotlin.jvm.internal.Intrinsics;
import m50.d;
import n50.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends com.bytedance.android.live.core.gl.core.shader.a {
    @Override // com.bytedance.android.live.core.gl.core.shader.a
    public final void c() {
        String[] r0 = {"a_Position", "a_TexCoordinate"};
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.b = r0;
        Intrinsics.checkNotNullParameter("uniform mat4 u_MVPMatrix; \nattribute vec4 a_Position; \nattribute vec2 a_TexCoordinate; \nvarying vec2 v_TexCoordinate; \nvoid main() { \n   v_TexCoordinate = a_TexCoordinate; \n   gl_Position = u_MVPMatrix * a_Position; \n}", "<set-?>");
        this.c = "uniform mat4 u_MVPMatrix; \nattribute vec4 a_Position; \nattribute vec2 a_TexCoordinate; \nvarying vec2 v_TexCoordinate; \nvoid main() { \n   v_TexCoordinate = a_TexCoordinate; \n   gl_Position = u_MVPMatrix * a_Position; \n}";
        Intrinsics.checkNotNullParameter("precision mediump float; \nuniform sampler2D u_Texture; \nvarying vec2 v_TexCoordinate; \nvoid main() { \n   gl_FragColor = texture2D(u_Texture, v_TexCoordinate);\n}", "<set-?>");
        this.d = "precision mediump float; \nuniform sampler2D u_Texture; \nvarying vec2 v_TexCoordinate; \nvoid main() { \n   gl_FragColor = texture2D(u_Texture, v_TexCoordinate);\n}";
    }

    @Override // com.bytedance.android.live.core.gl.core.shader.a
    public final void e() {
        this.j = GLES20.glGetUniformLocation(this.e, "u_MVPMatrix");
        GLES20.glGetUniformLocation(this.e, "u_Texture");
        this.h = GLES20.glGetAttribLocation(this.e, "a_Position");
        this.i = GLES20.glGetAttribLocation(this.e, "a_TexCoordinate");
    }

    public a() {
    }

    @Override // com.bytedance.android.live.core.gl.core.shader.a
    public final void d(f r21, d r22, b r23) {
        Intrinsics.checkNotNullParameter(r21, "rendererParams");
        Intrinsics.checkNotNullParameter(r22, "modelParams");
        Intrinsics.checkNotNullParameter(r23, "sceneParams");
        Intrinsics.checkNotNullParameter(r22, "modelParams");
        Intrinsics.checkNotNullParameter(r23, "sceneParams");
        float[] r5 = this.k;
        float[] r7 = r23.a.c;
        com.bytedance.android.live.core.gl.primitive.d r1 = r22.c;
        e r3 = r1.a;
        if (r3.d == false) goto L5;
        r3.d = false;
        boolean r4 = true;
    L6:
        if (r4 == true) goto L19;
        e r6 = r1.b;
        if (r6.d == false) goto L10;
        r6.d = false;
        boolean r8 = true;
    L11:
        if (r8 == true) goto L19;
        e r9 = r1.c;
        if (r9.d == false) goto L15;
        r9.d = false;
        boolean r11 = true;
    L16:
        if (r11 == true) goto L19;
        boolean r12 = false;
    L20:
        if (r12 == false) goto L31;
        Matrix.setIdentityM(r1.e, 0);
        float[] r13 = r1.e;
        e r14 = r1.a;
        Matrix.translateM(r13, 0, r14.a, r14.b, r14.c);
        RotationOrder r15 = r1.d;
        switch(c.b[r15.ordinal()]) {
            case 1: goto L29;
            case 2: goto L28;
            case 3: goto L27;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L24;
            default: goto L30;
        };
    L24:
        r1.c();
        r1.b();
        r1.a();
        goto L30
    L25:
        r1.c();
        r1.a();
        r1.b();
        goto L30
    L26:
        r1.b();
        r1.c();
        r1.a();
        goto L30
    L27:
        r1.b();
        r1.a();
        r1.c();
        goto L30
    L28:
        r1.a();
        r1.c();
        r1.b();
        goto L30
    L29:
        r1.a();
        r1.b();
        r1.c();
    L30:
        float[] r16 = r1.e;
        e r17 = r1.c;
        Matrix.scaleM(r16, 0, r17.a, r17.b, r17.c);
    L31:
        Matrix.multiplyMM(r5, 0, r7, 0, r1.e, 0);
        float[] r2 = this.k;
        Matrix.multiplyMM(r2, 0, r23.a.b, 0, r2, 0);
        GLES20.glUniformMatrix4fv(this.j, 1, false, this.k, 0);
        return;
    L15:
        r11 = false;
        goto L16
    L10:
        r8 = false;
    L19:
        r3.d = false;
        r1.b.d = false;
        r1.c.d = false;
        r12 = true;
        goto L20
    L5:
        r4 = false;
        goto L6
    }
}
