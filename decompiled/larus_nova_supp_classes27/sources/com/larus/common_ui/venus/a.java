package com.larus.common_ui.venus;

import android.graphics.Color;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a extends ShapeDrawable {
    public final C0014a a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;

    /* JADX INFO: renamed from: com.larus.common_ui.venus.a$a, reason: collision with other inner class name */
    public static final class C0014a {
        public float[] a;
        public int b;
        public int c;
        public int d;
        public int e;
        public boolean f;
        public int g;
        public boolean h;
        public boolean i;
        public boolean j;
        public boolean k;

        public final int hashCode() {
            return (this.c + this.d) + ((int) (((((long) this.g) + ((long) this.e)) + ((long) this.b)) / ((long) 3)));
        }

        public final boolean equals(Object r4) {
            if ((r4 instanceof C0014a) == true) goto L5;
            return false;
        L5:
            C0014a r5 = (C0014a) r4;
            if (r5.b == this.b) goto L8;
            return false;
        L8:
            if (r5.e == this.e) goto L10;
            return false;
        L10:
            if (r5.c == this.c) goto L12;
            return false;
        L12:
            if (r5.d == this.d) goto L14;
            return false;
        L14:
            if (r5.g == this.g) goto L16;
            return false;
        L16:
            if (r5.f == this.f) goto L18;
            return false;
        L18:
            if (Arrays.equals(r5.a, this.a) == false) goto L27;
            return true;
        L27:
            return false;
        }

        public C0014a(float[] r3, int r4, int r5, int r6, int r7) {
            if ((r7 & 2) == 0) goto L6;
            r4 = 0;
        L6:
            if ((r7 & 16) == 0) goto L9;
            r5 = 0;
        L9:
            if ((r7 & 64) == 0) goto L11;
            r6 = 0;
        L11:
            Intrinsics.checkNotNullParameter(r3, "outerRadii");
            this.a = r3;
            this.b = r4;
            this.c = 0;
            this.d = 0;
            this.e = r5;
            this.f = false;
            this.g = r6;
            this.h = false;
            this.i = false;
            this.j = false;
            this.k = false;
        }
    }

    public a(C0014a r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.a = r2;
        b(r2);
    }

    public final void b(C0014a r10) {
        Intrinsics.checkNotNullParameter(r10, "params");
        if (r10.a.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        float r1 = r10.e;
        this.h = r1;
        float r2 = r10.c;
        float r3 = r10.d;
        float r4 = Color.alpha(r10.g) / 255;
        this.b = r1;
        this.c = r1;
        this.d = r1;
        this.e = r1;
        boolean r5 = r10.f;
        if (r5 == false) goto L12;
        this.b = 0.0f;
        this.c = 0.0f;
    L12:
        if (r10.h == false) goto L15;
        this.b = 0.0f;
    L15:
        if (r10.j == false) goto L18;
        this.c = 0.0f;
    L18:
        if (r10.i == false) goto L21;
        this.d = 0.0f;
    L21:
        if (r10.k == false) goto L23;
        this.e = 0.0f;
    L23:
        this.f = r2;
        this.g = r3;
        if (r10.c == 0) goto L28;
        if (r5 == true) goto L28;
        this.b -= r2;
        this.c += r2;
        float r6 = r4 * r2;
        float r7 = r6 / 2;
        this.h = r1 - r7;
        this.f = (r2 - r6) + r7;
    L28:
        if (r10.d == 0) goto L30;
        this.d -= r3;
        this.e += r3;
        float r8 = r4 * r3;
        float r9 = r8 / 2;
        this.h = r1 - r9;
        this.g = (r3 - r8) + r9;
    L30:
        getPaint().setAntiAlias(true);
        getPaint().setColor(r10.b);
        getPaint().setShadowLayer(this.h, this.f, this.g, r10.g);
        setShape(new RoundRectShape(r10.a, null, null));
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void a(int r8, LayerDrawable r9) {
        Intrinsics.checkNotNullParameter(r9, "layerDrawable");
        r9.setLayerInset(r8, (int) this.b, (int) this.d, (int) this.c, (int) this.e);
    }
}
