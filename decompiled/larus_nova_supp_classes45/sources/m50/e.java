package m50;

import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e {
    public final int a;
    public final int b;
    public final int c;
    public FloatBuffer d;
    public float[] e;
    public int f;
    public final int g;

    public final void a() {
        int r0 = this.g;
        if (r0 == 0) goto L7;
        this.d = ByteBuffer.allocateDirect(r0 * this.c).order(ByteOrder.nativeOrder()).asFloatBuffer();
        return;
    L7:
        throw new RuntimeException("Cannot allocate zero-sized buffer.");
    }

    public final void b() {
        if (this.d == null) goto L14;
        int[] r2 = new int[1];
        GLES20.glGenBuffers(1, r2, 0);
        int r0 = r2[0];
        this.f = r0;
        if (r0 >= 0) goto L7;
        int r1 = v50.b.a;
        Intrinsics.checkNotNullParameter("Error creating buffer object. Handle is " + this.f + '.', "message");
    L7:
        FloatBuffer r3 = this.d;
        if (r3 == null) goto L12;
        r3.position(0);
        GLES20.glBindBuffer(this.a, this.f);
        GLES20.glBufferData(this.a, this.g * this.c, r3, this.b);
        GLES20.glBindBuffer(this.a, 0);
        return;
    L12:
        throw new RuntimeException("Buffer is null");
    L14:
        throw new RuntimeException("Buffer is null");
    }

    public final void c() {
        FloatBuffer r0 = this.d;
        if (r0 == null) goto L5;
        r0.put(this.e);
    L5:
        FloatBuffer r1 = this.d;
        if (r1 == null) goto L9;
        r1.position(0);
        return;
    }

    public e(float[] r2) {
        Intrinsics.checkNotNullParameter(r2, "array");
        this.a = 34962;
        this.b = 35044;
        this.c = 4;
        this.f = -1;
        this.g = r2.length;
        this.e = r2;
    }
}
