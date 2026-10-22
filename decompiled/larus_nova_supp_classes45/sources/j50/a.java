package j50;

import com.bytedance.android.live.core.gl.camera.BaseCamera;
import com.bytedance.android.live.core.gl.core.shader.Shaders;
import com.bytedance.android.live.core.gl.primitive.Align;
import k50.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends n50.a {
    public s50.a e;

    public a() {
        n50.b r0 = new n50.b();
        Intrinsics.checkNotNullParameter(r0, "sp");
        super(r0);
    }

    @Override // n50.a
    public final void c(f r2) {
        Intrinsics.checkNotNullParameter(r2, "rendererParams");
        super.c(r2);
    }

    public final void f(f r5) {
        Intrinsics.checkNotNullParameter(r5, "rendererParams");
        Intrinsics.checkNotNullParameter(r5, "rendererParams");
        this.b = r5;
        com.bytedance.android.live.core.gl.core.shader.b r6 = r5.a.b;
        Shaders r0 = Shaders.DEFAULT_TEXTURE_SHADER;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, "shader");
        int r1 = r0.ordinal();
        if (r6.a.containsKey(Integer.valueOf(r1)) == true) goto L7;
        r6.a.put(Integer.valueOf(r1), r0.createShader());
        return;
    }

    @Override // n50.a
    public final void d(f r6, int r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "rendererParams");
        float r0 = 375.0f;
        if (r7 <= r8) goto L9;
        BaseCamera r3 = this.d.a;
        s50.a r4 = this.e;
        if (r4 == null) goto L7;
        r4.a();
    L8:
        r3.j = r0;
        r3.i = 0.0f;
        r3.k = BaseCamera.ClampType.VERTICAL;
    L14:
        BaseCamera r1 = this.d.a;
        Align r2 = Align.CENTER;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "align");
        r1.h = r2;
        this.d.a.a();
        super.d(r6, r7, r8);
        return;
    L7:
        r0 = 1.0f;
        goto L8
    L9:
        BaseCamera r5 = this.d.a;
        s50.a r9 = this.e;
        if (r9 == null) goto L12;
        r9.a();
    L13:
        r5.i = r0;
        r5.j = 0.0f;
        r5.k = BaseCamera.ClampType.HORIZONTAL;
        goto L14
    L12:
        r0 = 1.0f;
        goto L13
    }
}
