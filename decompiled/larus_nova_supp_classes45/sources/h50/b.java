package h50;

import k50.f;
import kotlin.jvm.internal.Intrinsics;
import m50.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements l50.b {
    public boolean a;
    public int b;
    public long c;
    public boolean d;
    public final int[] e;
    public final float f;

    @Override // l50.b
    public final boolean isFinished() {
        return this.d;
    }

    public b(int[] r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "textureIds");
        this.e = r2;
        this.f = r3;
        this.a = true;
        this.c = -1;
    }

    @Override // l50.b
    public final boolean a(f r5, d r6, n50.b r7) {
        Intrinsics.checkNotNullParameter(r5, "rendererParams");
        Intrinsics.checkNotNullParameter(r6, "modelParams");
        Intrinsics.checkNotNullParameter(r7, "sceneParams");
        boolean r8 = this.d;
        if (r8 == false) goto L5;
        return r8;
    L5:
        long r0 = r5.d;
        if ((r0 - this.c) < this.f) goto L15;
        int r9 = this.b + 1;
        this.b = r9;
        int[] r2 = this.e;
        if (r9 >= r2.length) goto L10;
    L13:
        r6.a = r2[this.b];
        this.c = r0;
        goto L15
    L10:
        if (this.a == false) goto L12;
        this.b = 0;
        goto L13
    L12:
        this.b = r2.length - 1;
        this.d = true;
    L15:
        return this.d;
    }
}
