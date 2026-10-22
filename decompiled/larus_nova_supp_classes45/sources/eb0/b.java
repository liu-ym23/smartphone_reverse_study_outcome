package eb0;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.Matrix;
import fb0.e;
import fb0.i;
import ib0.d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements c {
    public final Map<Bitmap, fb0.a> a;
    public final fb0.c b;
    public final ib0.a c;
    public final float[] d;
    public int e;
    public int f;
    public d g;

    public b() {
        e r0 = new e();
        this.a = new WeakHashMap();
        this.b = r0;
        r0.o = new a(this);
        this.c = new ib0.a();
        this.d = new float[4];
    }

    public final void a() {
        Iterator r0 = ((WeakHashMap) this.a).values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((fb0.a) r0.next()).e();
        goto L4
    L6:
        ((WeakHashMap) this.a).clear();
    }

    public final void finalize() throws Throwable {
        super.finalize();
        a();
    }

    public final void b(Bitmap r24, int r25, int r26, d r27) {
        this.g = r27;
        if (r24.isRecycled() == true) goto L86;
        if (r24.isPremultiplied() == true) goto L14;
        if (r24.getConfig() != Bitmap.Config.ARGB_8888) goto L14;
        if (r24.hasAlpha() == false) goto L14;
        throw new RuntimeException("Canvas: trying to use a non-premultiplied bitmap " + r24);
    L14:
        if (((WeakHashMap) this.a).containsKey(r24) == false) goto L16;
        fb0.a r5 = (fb0.a) ((WeakHashMap) this.a).get(r24);
    L18:
        if ((r27 instanceof ib0.c) == false) goto L23;
        ((ib0.c) r27).getClass();
        if ((r5 instanceof i) == false) goto L22;
        ((i) r5).getClass();
        r5 = null;
        goto L23
    L22:
        throw null;
    L23:
        r5.c();
        r27.c(r5);
        fb0.c r6 = this.b;
        int r7 = r24.getWidth();
        int r1 = r24.getHeight();
        e r8 = (e) r6;
        r8.getClass();
        if (r7 <= 0) goto L89;
        if (r1 <= 0) goto L90;
        int r9 = r5.b();
        r8.n = r27;
        if (r9 != 3553) goto L37;
        if (((HashMap) r8.a).containsKey(r27) == false) goto L35;
        int r4 = ((Integer) ((HashMap) r8.a).get(r27)).intValue();
        r8.k = r4;
        e.b[] r11 = r8.q;
        int r12 = 0;
    L33:
        if (r12 >= r11.length) goto L43;
        r11[r12].a(r4);
        r12 = r12 + 1;
    L43:
        RectF r13 = r8.v;
        int r14 = r5.c();
        int r15 = r5.a();
        r5.getClass();
        r13.set(0, 0, r14, r15);
        r8.w.set(r25, r26, r25 + r7, r1 + r26);
        RectF r2 = r8.v;
        int r3 = r5.c();
        int r16 = r5.a();
        int r17 = r5.e;
        int r18 = r5.f;
        float r19 = r17;
        r2.left /= r19;
        float r21 = r2.right / r19;
        r2.right = r21;
        float r22 = r18;
        r2.top /= r22;
        float r110 = r2.bottom / r22;
        r2.bottom = r110;
        float r23 = r3 / r19;
        if (r21 <= r23) goto L46;
        r2.right = r23;
    L46:
        float r28 = r16 / r22;
        if (r110 <= r28) goto L49;
        r2.bottom = r28;
    L49:
        RectF r29 = r8.v;
        RectF r31 = r8.w;
        float r32 = r5.a() / r5.f;
        float r33 = r5.c() / r5.e;
        if (r29.right <= r33) goto L53;
        r31.right = r31.left + ((r31.width() * (r33 - r29.left)) / r29.width());
    L53:
        if (r29.bottom <= r32) goto L55;
        r31.bottom = r31.top + ((r31.height() * (r32 - r29.top)) / r29.height());
    L55:
        RectF r34 = r8.v;
        RectF r35 = r8.w;
        float[] r36 = r8.x;
        r36[0] = r34.width();
        r36[5] = r34.height();
        r36[12] = r34.left;
        r36[13] = r34.top;
        float[] r37 = r8.x;
        int[] r38 = new int[4];
        GLES20.glGetIntegerv(2978, r38, 0);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glGetIntegerv(2978, r38, 0);
        GLES20.glViewport(0, 0, r8.h, r8.i);
        if (r8.m != (-1)) goto L59;
        float[] r39 = e.A;
        FloatBuffer r111 = ByteBuffer.allocateDirect(80).order(ByteOrder.nativeOrder()).asFloatBuffer();
        r111.put(r39, 0, 20).position(0);
        GLES20.glGenBuffers(1, r8.y, 0);
        int r41 = r8.y[0];
        GLES20.glBindBuffer(34962, r41);
        GLES20.glBufferData(34962, r111.capacity() * 4, r111, 35044);
        r8.m = r41;
    L59:
        if (r5.b() != 3553) goto L61;
        e.b[] r42 = r8.q;
        int r112 = r8.k;
    L62:
        GLES20.glUseProgram(r112);
        if (r5.isOpaque() == true) goto L65;
    L68:
        boolean r113 = true;
    L70:
        if (r113 == false) goto L72;
        GLES20.glEnable(3042);
    L73:
        GLES20.glActiveTexture(33984);
        r5.d(r8);
        GLES20.glBindTexture(r5.b(), r5.a);
        GLES20.glUniform1i(r42[3].a, 0);
        GLES20.glUniform1f(r42[4].a, r8.d[r8.f]);
        GLES20.glUniform1i(r42[5].a, 0);
        int r43 = r42[6].a;
        float[] r44 = r8.p;
        GLES20.glUniform4f(r43, r44[0], r44[1], r44[2], r44[3]);
        GLES20.glBindBuffer(34962, r8.m);
        GLES20.glVertexAttribPointer(r42[0].a, 2, 5126, false, 8, 0);
        GLES20.glBindBuffer(34962, 0);
        GLES20.glUniformMatrix4fv(r42[2].a, 1, false, r37, 0);
        if (r8.o != null) goto L76;
    L80:
        float r45 = r35.left;
        float r46 = r35.top;
        float r47 = r35.width();
        float r48 = r35.height();
        GLES20.glViewport(0, 0, r8.h, r8.i);
        Matrix.translateM(r8.u, 0, r8.c, r8.g, r45, r46, 0.0f);
        Matrix.scaleM(r8.u, 0, r47, r48, 1.0f);
        float[] r49 = r8.u;
        Matrix.multiplyMM(r49, 16, r8.j, 0, r49, 0);
        GLES20.glUniformMatrix4fv(r42[1].a, 1, false, r8.u, 16);
        int r51 = r42[0].a;
        GLES20.glEnableVertexAttribArray(r51);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(r51);
        if (r8.e == false) goto L83;
        GLES20.glBindFramebuffer(36160, 0);
    L83:
        GLES20.glViewport(r38[0], r38[1], r38[2], r38[3]);
        return;
    L76:
        if (r5.b() != 3553) goto L78;
        int r52 = r8.k;
    L79:
        r8.n.e(r52);
        goto L80
    L78:
        r52 = r8.l;
        goto L79
    L72:
        GLES20.glDisable(3042);
        goto L73
    L65:
        if (r8.d[r8.f] < 0.95f) goto L68;
        r113 = false;
        goto L70
    L61:
        r42 = r8.r;
        r112 = r8.l;
        goto L62
    L35:
        e.b[] r53 = r8.q;
        r27.d();
        int r54 = e.a(e.b(35633, "uniform mat4 uMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec4 pos = vec4(aPosition, 0.0, 1.0);\n  gl_Position = uMatrix * pos;\n  vTextureCoord = (uTextureMatrix * pos).xy;\n}\n"), e.b(35632, r27.a()), r53, r8.y);
        r8.k = r54;
        ((HashMap) r8.a).put(r27, Integer.valueOf(r54));
        goto L43
    L37:
        if (((HashMap) r8.b).containsKey(r27) == false) goto L42;
        int r55 = ((Integer) ((HashMap) r8.b).get(r27)).intValue();
        r8.l = r55;
        e.b[] r56 = r8.r;
        int r114 = 0;
    L40:
        if (r114 >= r56.length) goto L43;
        r56[r114].a(r55);
        r114 = r114 + 1;
        goto L40
    L42:
        e.b[] r57 = r8.r;
        r27.d();
        int r58 = e.a(e.b(35633, "uniform mat4 uMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec4 pos = vec4(aPosition, 0.0, 1.0);\n  gl_Position = uMatrix * pos;\n  vTextureCoord = (uTextureMatrix * pos).xy;\n}\n"), e.b(35632, r27.b()), r57, r8.y);
        r8.l = r58;
        ((HashMap) r8.b).put(r27, Integer.valueOf(r58));
        goto L43
    L90:
        return;
    L89:
        return;
    L16:
        r5 = new fb0.b(r24);
        ((WeakHashMap) this.a).put(r24, r5);
        goto L18
    L86:
        throw new RuntimeException("Canvas: trying to use a recycled bitmap " + r24);
    }
}
