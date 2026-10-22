package r50;

import android.opengl.GLES20;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import k50.f;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import m50.c;
import m50.d;
import m50.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class a implements m50.b {
    public l50.b a;
    public final m50.a b;
    public final d c;

    public a() {
        m50.a r0 = new m50.a();
        d r1 = new d();
        Intrinsics.checkNotNullParameter(r0, "geometry");
        Intrinsics.checkNotNullParameter(r1, "modelParams");
        this.b = r0;
        this.c = r1;
    }

    @Override // m50.b
    public final void b(f r2) {
        Intrinsics.checkNotNullParameter(r2, "rendererParams");
        this.b.c(r2);
    }

    @Override // m50.b
    public final void a(f r23, n50.b r24) {
        Intrinsics.checkNotNullParameter(r23, "rendererParams");
        Intrinsics.checkNotNullParameter(r24, "sceneParams");
        m50.a r5 = this.b;
        d r6 = this.c;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r23, "rendererParams");
        Intrinsics.checkNotNullParameter(r6, "modelParams");
        Intrinsics.checkNotNullParameter(r24, "sceneParams");
        r6.getClass();
        GLES20.glEnable(2884);
        GLES20.glDisable(2929);
        GLES20.glEnable(3042);
        Pair<Integer, Integer> r7 = r23.c;
        GLES20.glBlendFunc(((Number) r7.getFirst()).intValue(), ((Number) r7.getSecond()).intValue());
        com.bytedance.android.live.core.gl.core.shader.b r8 = r23.a.b;
        int r9 = r6.b;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r23, "rendererParams");
        if (r8.a.containsKey(Integer.valueOf(r9)) == true) goto L5;
        int r11 = v50.b.a;
        Intrinsics.checkNotNullParameter("Shader " + r9 + " not found", "message");
    L5:
        com.bytedance.android.live.core.gl.core.shader.a r12 = r8.a.get(Integer.valueOf(r9));
        if (r12 == null) goto L8;
        Intrinsics.checkNotNullParameter(r23, "rendererParams");
        r12.a(r23);
        GLES20.glUseProgram(r12.e);
        r12.e();
    L8:
        l50.b r13 = this.a;
        if (r13 == null) goto L11;
        r13.a(r23, this.c, r24);
    L11:
        m50.a r14 = this.b;
        d r15 = this.c;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r23, "rendererParams");
        Intrinsics.checkNotNullParameter(r15, "modelParams");
        Intrinsics.checkNotNullParameter(r24, "sceneParams");
        r15.getClass();
        if (r23.f == true) goto L14;
        com.bytedance.android.live.core.gl.core.shader.a r3 = r23.a.b.a.get(Integer.valueOf(r15.b));
        if (r3 == null) goto L71;
        r3.d(r23, r15, r24);
        e r2 = r14.a;
        if (r2 == null) goto L69;
        FloatBuffer r4 = r2.d;
        if (r4 == null) goto L46;
        r4.position(0);
    L46:
        GLES20.glEnableVertexAttribArray(r3.h);
        GLES20.glVertexAttribPointer(r3.h, 3, 5126, false, r2.c * 3, r2.d);
        if (r3.i <= 0) goto L58;
        e r16 = r14.c;
        if (r16 == null) goto L57;
        FloatBuffer r17 = r16.d;
        if (r17 == null) goto L53;
        r17.position(0);
    L53:
        GLES20.glEnableVertexAttribArray(r3.i);
        GLES20.glVertexAttribPointer(r3.i, 2, 5126, false, r16.c * 2, r16.d);
        o50.b r18 = r23.a.a;
        int r19 = r15.a;
        r18.getClass();
        Intrinsics.checkNotNullParameter(r23, "rp");
        o50.a r21 = r18.b.get(Integer.valueOf(r19));
        if (r21 == null) goto L59;
        r18.a = r19;
        r21.a(r23);
    L59:
        c r1 = r14.e;
        if (r1 == null) goto L67;
        ShortBuffer r22 = r1.d;
        if (r22 == null) goto L64;
        r22.position(0);
    L64:
        GLES20.glDrawElements(4, r1.g, 5123, r1.d);
        GLES20.glBindBuffer(34962, 0);
        GLES20.glBindBuffer(34963, 0);
        return;
    L67:
        throw new RuntimeException("Index buffer is null");
    L57:
        throw new RuntimeException("Texture coord buffer is null");
    L58:
        r23.a.a.b();
        goto L59
    L69:
        throw new RuntimeException("Vertex buffer is null");
    L71:
        throw new RuntimeException("Shader " + r15.b + " for  not found");
    L14:
        if (r14.f == r23.b) goto L16;
        r14.c(r23);
    L16:
        com.bytedance.android.live.core.gl.core.shader.a r25 = r23.a.b.a.get(Integer.valueOf(r15.b));
        if (r25 == null) goto L38;
        r25.d(r23, r15, r24);
        e r26 = r14.a;
        if (r26 == null) goto L36;
        GLES20.glBindBuffer(r26.a, r26.f);
        GLES20.glVertexAttribPointer(r25.h, 3, 5126, false, 0, 0);
        GLES20.glEnableVertexAttribArray(r25.h);
        if (r25.i <= 0) goto L29;
        e r27 = r14.c;
        if (r27 == null) goto L28;
        GLES20.glBindBuffer(r27.a, r27.f);
        GLES20.glVertexAttribPointer(r25.i, 2, 5126, false, 0, 0);
        GLES20.glEnableVertexAttribArray(r25.i);
        o50.b r28 = r23.a.a;
        int r29 = r15.a;
        r28.getClass();
        Intrinsics.checkNotNullParameter(r23, "rp");
        o50.a r31 = r28.b.get(Integer.valueOf(r29));
        if (r31 == null) goto L30;
        r28.a = r29;
        r31.a(r23);
    L30:
        c r32 = r14.e;
        if (r32 == null) goto L34;
        GLES20.glBindBuffer(r32.a, r32.f);
        GLES20.glDrawElements(4, r32.g, 5123, 0);
        GLES20.glBindBuffer(34962, 0);
        GLES20.glBindBuffer(34963, 0);
        return;
    L34:
        throw new RuntimeException("Index buffer is null");
    L28:
        throw new RuntimeException("Texture coord  buffer is null");
    L29:
        r23.a.a.b();
        goto L30
    L36:
        throw new RuntimeException("Vertex buffer is null");
    L38:
        throw new RuntimeException("Shader " + r15.b + " for  not found");
    }
}
