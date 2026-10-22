package h50;

import com.bytedance.android.live.core.gl.primitive.Axis;
import k50.f;
import kotlin.jvm.internal.Intrinsics;
import m50.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements l50.b {
    public boolean a;
    public boolean b;
    public float c;
    public boolean d;
    public long e;
    public final Axis f;
    public float g;
    public float h;
    public final float i;

    @Override // l50.b
    public final boolean isFinished() {
        return this.b;
    }

    public a(Axis r2, float r3, float r4) {
        Intrinsics.checkNotNullParameter(r2, "axis");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.i = 1000.0f;
    }

    @Override // l50.b
    public final boolean a(f r6, d r7, n50.b r8) {
        Intrinsics.checkNotNullParameter(r6, "rendererParams");
        Intrinsics.checkNotNullParameter(r7, "modelParams");
        Intrinsics.checkNotNullParameter(r8, "sceneParams");
        if (this.d == true) goto L7;
        r7.c.e(this.f, this.g);
        this.e = r6.d;
        this.d = true;
    L7:
        if (this.b == false) goto L9;
        return true;
    L9:
        long r1 = r6.d;
        float r9 = (r1 - this.e) / this.i;
        if (r9 >= 1.0f) goto L12;
        float r11 = this.g;
        this.c = r11 + ((this.h - r11) * r9);
    L17:
        r7.c.e(this.f, this.c);
        return this.b;
    L12:
        if (this.a == false) goto L14;
        this.c = this.g;
    L15:
        this.e = r1;
        goto L17
    L14:
        this.c = this.h;
        this.b = true;
        goto L15
    }
}
