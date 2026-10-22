package m50;

import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import k50.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public e a;
    public e b;
    public e c;
    public e d;
    public c e;
    public int f;

    /* JADX INFO: renamed from: m50.a$a, reason: collision with other inner class name */
    public static final class C0246a {
    }

    static {
    }

    public final void a() {
        e r0 = this.a;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        e r1 = this.c;
        if (r1 == null) goto L8;
        r1.a();
    L8:
        e r2 = this.b;
        if (r2 == null) goto L11;
        r2.a();
    L11:
        e r3 = this.d;
        if (r3 == null) goto L14;
        r3.a();
    L14:
        c r4 = this.e;
        if (r4 == null) goto L21;
        int r5 = r4.g;
        if (r5 == 0) goto L20;
        r4.d = ByteBuffer.allocateDirect(r5 * r4.c).order(ByteOrder.nativeOrder()).asShortBuffer();
        return;
    L20:
        throw new RuntimeException("Cannot allocate zero-sized buffer.");
    }

    public final void d() {
        e r0 = this.a;
        if (r0 == null) goto L5;
        r0.c();
    L5:
        e r1 = this.c;
        if (r1 == null) goto L8;
        r1.c();
    L8:
        e r2 = this.b;
        if (r2 == null) goto L11;
        r2.c();
    L11:
        e r3 = this.d;
        if (r3 == null) goto L14;
        r3.c();
    L14:
        c r4 = this.e;
        if (r4 == null) goto L23;
        ShortBuffer r5 = r4.d;
        if (r5 == null) goto L19;
        r5.put(r4.e);
    L19:
        ShortBuffer r6 = r4.d;
        if (r6 == null) goto L24;
        r6.position(0);
        return;
    L24:
        return;
    }

    public a() {
        this.f = -1;
    }

    public final void c(f r7) {
        Intrinsics.checkNotNullParameter(r7, "rendererParams");
        e r0 = this.a;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        e r1 = this.c;
        if (r1 == null) goto L8;
        r1.b();
    L8:
        e r2 = this.b;
        if (r2 == null) goto L11;
        r2.b();
    L11:
        e r3 = this.d;
        if (r3 == null) goto L14;
        r3.b();
    L14:
        c r4 = this.e;
        if (r4 != null) goto L17;
    L28:
        this.f = r7.b;
        return;
    L17:
        if (r4.d == null) goto L27;
        int[] r5 = new int[1];
        GLES20.glGenBuffers(1, r5, 0);
        int r6 = r5[0];
        r4.f = r6;
        if (r6 >= 0) goto L21;
        int r8 = v50.b.a;
        Intrinsics.checkNotNullParameter("Error creating index buffer object. Handle is " + r4.f + '.', "message");
    L21:
        ShortBuffer r9 = r4.d;
        if (r9 == null) goto L25;
        r9.position(0);
        GLES20.glBindBuffer(r4.a, r4.f);
        GLES20.glBufferData(r4.a, r4.g * r4.c, r9, r4.b);
        GLES20.glBindBuffer(r4.a, 0);
        goto L28
    L25:
        throw new RuntimeException("Buffer is null");
    L27:
        throw new RuntimeException("Buffer is null");
    }

    public final void b(float[] r2, float[] r3, float[] r4, float[] r5, short[] r6) {
        Intrinsics.checkNotNullParameter(r2, "vertices");
        Intrinsics.checkNotNullParameter(r6, "indices");
        this.a = new e(r2);
        if (r3 == null) goto L5;
        this.c = new e(r3);
    L5:
        if (r4 == null) goto L7;
        this.b = new e(r4);
    L7:
        if (r5 == null) goto L9;
        this.d = new e(r5);
    L9:
        this.e = new c(r6);
    }
}
