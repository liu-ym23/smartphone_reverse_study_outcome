package fb0;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements fb0.c {
    public static final float[] A = null;
    public static final f B = null;
    public static final String z = null;
    public final Map<ib0.d, Integer> a;
    public final Map<ib0.d, Integer> b;
    public float[] c;
    public float[] d;
    public final boolean e;
    public int f;
    public int g;
    public int h;
    public int i;
    public final float[] j;
    public int k;
    public int l;
    public int m;
    public ib0.d n;
    public fb0.c.a o;
    public final float[] p;
    public final b[] q;
    public final b[] r;
    public final h s;
    public final ArrayList<i> t;
    public final float[] u;
    public final RectF v;
    public final RectF w;
    public final float[] x;
    public final int[] y;

    public static class a extends b {
        public a(String r1) {
            super(r1);
        }

        @Override // fb0.e.b
        public final void a(int r2) {
            this.a = GLES20.glGetAttribLocation(r2, this.b);
            String r3 = e.z;
        }
    }

    public static abstract class b {
        public int a;
        public final String b;

        public abstract void a(int r1);

        public b(String r1) {
            this.b = r1;
        }
    }

    public static class c extends b {
        public c(String r1) {
            super(r1);
        }

        @Override // fb0.e.b
        public final void a(int r2) {
            this.a = GLES20.glGetUniformLocation(r2, this.b);
            String r3 = e.z;
        }
    }

    static {
        z = e.class.getSimpleName();
        A = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f};
        B = new f();
    }

    public e() {
        new HashMap();
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = new float[128];
        this.d = new float[8];
        new h();
        this.e = true;
        this.f = 0;
        this.g = 0;
        this.j = new float[16];
        this.m = -1;
        this.p = new float[4];
        b[] r3 = {new a("aPosition"), new c("uMatrix"), new c("uColor"), new a("aColor")};
        this.q = new b[]{new a("aPosition"), new c("uMatrix"), new c("uTextureMatrix"), new c("uTextureSampler"), new c("uAlpha"), new c("uEdgeFadeEffectEnable"), new c("uEdgeFadeEffectRegion")};
        this.r = new b[]{new a("aPosition"), new c("uMatrix"), new c("uTextureMatrix"), new c("uTextureSampler"), new c("uAlpha")};
        b[] r4 = {new a("aPosition"), new c("uMatrix"), new a("aTextureCoordinate"), new c("uTextureSampler"), new c("uAlpha")};
        this.s = new h();
        ArrayList<i> r2 = new ArrayList();
        this.t = r2;
        this.u = new float[32];
        this.v = new RectF();
        this.w = new RectF();
        float[] r5 = new float[16];
        this.x = r5;
        int[] r6 = new int[1];
        this.y = r6;
        Matrix.setIdentityM(r5, 0);
        Matrix.setIdentityM(this.c, this.g);
        this.d[this.f] = 1.0f;
        r2.add(null);
        a(b(35633, "uniform mat4 uMatrix;\nattribute vec2 aPosition;\nvoid main() {\n  vec4 pos = vec4(aPosition, 0.0, 1.0);\n  gl_Position = uMatrix * pos;\n}\n"), b(35632, "precision mediump float;\nuniform vec4 uColor;\nvoid main() {\n  gl_FragColor = uColor;\n}\n"), r3, r6);
        a(b(35633, "uniform mat4 uMatrix;\nattribute vec2 aPosition;\nattribute vec2 aTextureCoordinate;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec4 pos = vec4(aPosition, 0.0, 1.0);\n  gl_Position = uMatrix * pos;\n  vTextureCoord = aTextureCoordinate;\n}\n"), b(35632, "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nuniform sampler2D uTextureSampler;\nuniform int uEdgeFadeEffectEnable;\nuniform vec4 uEdgeFadeEffectRegion;\nvoid main() {\n  gl_FragColor = texture2D(uTextureSampler, vTextureCoord);\n  gl_FragColor *= uAlpha;\n  if (uEdgeFadeEffectEnable>0) {\n     float leftEdge = uEdgeFadeEffectRegion[0];\n     float topEdge = uEdgeFadeEffectRegion[1];\n     float rightEdge = uEdgeFadeEffectRegion[2];\n     float bottomEdge = uEdgeFadeEffectRegion[3];\n     if(leftEdge > 0.0 && gl_FragCoord.x < leftEdge) {} \n     if(topEdge > 0.0 && gl_FragCoord.y > topEdge) {}\n     if(rightEdge > 0.0 && gl_FragCoord.x > rightEdge) {}\n     if(bottomEdge > 0.0 && gl_FragCoord.y < bottomEdge) {\n        float percent = 1.0 - (bottomEdge - gl_FragCoord.y)/bottomEdge;\n        gl_FragColor *= percent;\n     }\n   }\n}\n"), r4, r6);
        GLES20.glBlendFunc(1, 771);
    }

    public final void d(fb0.a r3) {
        int r0 = r3.b();
        GLES20.glBindTexture(r0, r3.a);
        GLES20.glTexParameteri(r0, 10242, 33071);
        GLES20.glTexParameteri(r0, 10243, 33071);
        GLES20.glTexParameterf(r0, 10241, 9729.0f);
        GLES20.glTexParameterf(r0, 10240, 9729.0f);
    }

    public static int b(int r0, String r1) {
        int r2 = GLES20.glCreateShader(r0);
        GLES20.glShaderSource(r2, r1);
        GLES20.glCompileShader(r2);
        return r2;
    }

    public final void c(int r11, int r12) {
        this.h = r11;
        this.i = r12;
        Matrix.setIdentityM(this.c, this.g);
        float r5 = r11;
        float r13 = r12;
        Matrix.orthoM(this.j, 0, 0.0f, r5, 0.0f, r13, -1.0f, 1.0f);
        ArrayList<i> r14 = this.t;
        if (((i) ListProtector.get(r14, r14.size() - 1)) != null) goto L6;
        Matrix.translateM(this.c, this.g, 0.0f, r13, 0.0f);
        Matrix.scaleM(this.c, this.g, 1.0f, -1.0f, 1.0f);
        return;
    }

    public static int a(int r3, int r4, b[] r5, int[] r6) {
        int r0 = GLES20.glCreateProgram();
        if (r0 != 0) goto L5;
        ALogger.e(z, "Cannot create GL program");
    L5:
        GLES20.glAttachShader(r0, r3);
        GLES20.glAttachShader(r0, r4);
        GLES20.glLinkProgram(r0);
        int r7 = 0;
        GLES20.glGetProgramiv(r0, 35714, r6, 0);
        if (r6[0] == 1) goto L9;
        GLES20.glGetProgramInfoLog(r0);
        GLES20.glDeleteProgram(r0);
        r0 = 0;
    L9:
        if (r7 >= r5.length) goto L11;
        r5[r7].a(r0);
        r7 = r7 + 1;
        goto L9
    L11:
        return r0;
    }

    public final void e(fb0.a r8, int r9, int r11, Bitmap r12, int r13, int r14) {
        int r0 = r8.b();
        GLES20.glBindTexture(r0, r8.a);
        GLUtils.texSubImage2D(r0, 0, r9, r11, r12, r13, r14);
    }
}
