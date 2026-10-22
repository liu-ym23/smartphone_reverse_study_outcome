package u50;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import k50.f;
import kotlin.jvm.internal.Intrinsics;
import v50.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements o50.a {
    public final String a;
    public final int b;
    public int c;
    public final boolean d;
    public int e;
    public final int f;
    public final Bitmap g;

    @Override // o50.a
    public final void unbind() {
        GLES20.glBindTexture(3553, 0);
    }

    @Override // o50.a
    public final void a(f r8) {
        Intrinsics.checkNotNullParameter(r8, "rendererParams");
        if (this.e == r8.b) goto L27;
        Intrinsics.checkNotNullParameter(r8, "rendererParams");
        if (this.e == r8.b) goto L27;
        Bitmap r0 = this.g;
        if (r0 == null) goto L29;
    L14:
        if (r0 == null) goto L27;
        int[] r4 = new int[1];
        GLES20.glGenTextures(1, r4, 0);
        int r2 = r4[0];
        if (r2 == 0) goto L25;
        GLES20.glBindTexture(3553, r2);
        if (this.d == false) goto L21;
        int r1 = 9985;
    L22:
        GLES20.glTexParameteri(3553, 10241, r1);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, r0, 0);
        if (this.d == false) goto L26;
        GLES20.glGenerateMipmap(3553);
    L26:
        this.e = r8.b;
        r0.recycle();
        this.c = r4[0];
        goto L27
    L21:
        r1 = 9729;
        goto L22
    L25:
        int r3 = b.a;
        Intrinsics.checkNotNullParameter("BitmapTexture: textureHandle is 0!", "message");
        goto L26
    L29:
        Resources r5 = r8.getContext().getResources();     // Catch: Exception -> L12
        int r6 = this.b;     // Catch: Exception -> L12
        int r7 = this.f;     // Catch: Exception -> L12
        BitmapFactory.Options r9 = new BitmapFactory.Options();     // Catch: Exception -> L12
        r9.inSampleSize = r7;     // Catch: Exception -> L12
        r0 = BitmapFactory.decodeResource(r5, r6, r9);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        int r11 = b.a;
        Intrinsics.checkNotNullParameter("Texture: Error creating bitmap " + this.a, "message");
        e.printStackTrace();
        r0 = null;
    L27:
        GLES20.glBindTexture(3553, this.c);
    }

    public a(Bitmap r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "bitmap");
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r3, "name");
        this.g = r2;
        this.b = -1;
        this.d = true;
        this.e = -1;
        this.f = 1;
        this.a = r3;
        this.b = 0;
    }
}
