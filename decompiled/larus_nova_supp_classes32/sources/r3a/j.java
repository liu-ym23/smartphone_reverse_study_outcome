package r3a;

import android.opengl.EGLContext;
import com.larus.im.service.audio.vlm.VideoFrameBufferType;
import com.lynx.canvas.camera.CameraSize;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j {
    public final int a;
    public final int b;
    public final int c;
    public final long d;
    public final float[] e;
    public final int f;
    public final EGLContext g;
    public final VideoFrameBufferType h;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof j) == true) goto L8;
        return false;
    L8:
        j r9 = (j) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a * 31) + this.b) * 31) + this.c) * 31;
        long r1 = this.d;
        int r2 = (((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + Arrays.hashCode(this.e)) * 31) + this.f) * 31;
        EGLContext r3 = this.g;
        if (r3 != null) goto L5;
        int r4 = 0;
    L7:
        return ((r2 + r4) * 31) + this.h.hashCode();
    L5:
        r4 = r3.hashCode();
        goto L7
    }

    public final String toString() {
        return "CameraFrameWrapper(textureId=" + this.a + ", width=" + this.b + ", height=" + this.c + ", timestamp=" + this.d + ", transformMatrix=" + Arrays.toString(this.e) + ", rotation=" + this.f + ", glCtx=" + this.g + ", bufferType=" + this.h + ')';
    }

    public j(int r2, long r3, float[] r5, int r6, EGLContext r7, VideoFrameBufferType r8) {
        Intrinsics.checkNotNullParameter(r5, "transformMatrix");
        Intrinsics.checkNotNullParameter(r8, "bufferType");
        this.a = r2;
        this.b = CameraSize.highWidth;
        this.c = CameraSize.highHeight;
        this.d = r3;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }
}
