package k41;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.bytedance.android.live.revlink.impl.pk.mixer.mapping.LayoutMode;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> {
    public boolean a;
    public Float b;
    public LayoutMode[] c;
    public float d;
    public Matrix e;
    public Matrix f;
    public RectF g;
    public final a<T> h;

    public final b<T> a() {
        Float r0 = this.b;
        if (r0 == null) goto L29;
        float r1 = r0.floatValue();
        boolean r2 = false;
        if (r1 < (this.h.a() / this.h.c())) goto L15;
        float r3 = this.h.c();
        float r4 = r1 * r3;
        float r6 = this.h.a();
        float r7 = this.h.c();
        if (ArraysKt.contains(this.c, LayoutMode.CenterHorizontal) == false) goto L9;
    L10:
        r2 = true;
    L11:
        if (r2 == false) goto L13;
        float r5 = (r4 - r6) / 2.0f;
    L14:
        float r8 = 0.0f;
    L24:
        RectF r9 = new RectF(r5 / r4, r8 / r3, (r5 + r6) / r4, (r8 + r7) / r3);
        Matrix r10 = b(new RectF(0.0f, 0.0f, r6, r7), new RectF(0.0f, 0.0f, 1.0f, 1.0f));
        r10.postScale(r9.width(), r9.height());
        r10.postTranslate(r9.left, r9.top);
        Matrix r12 = b(new RectF(0.0f, 0.0f, r6, r7), new RectF(0.0f, 0.0f, 1.0f, 1.0f));
        if (this.a == false) goto L27;
        this.e = r10;
        this.f = r12;
        this.g = r9;
        goto L29
    L27:
        this.e = r10;
        this.f = r10;
        this.g = null;
        goto L29
    L13:
        r5 = 0.0f;
        goto L14
    L9:
        if (ArraysKt.contains(this.c, LayoutMode.Center) == false) goto L11;
    L15:
        float r13 = this.h.a();
        float r14 = r13 / r1;
        if (ArraysKt.contains(this.c, LayoutMode.Center) == false) goto L18;
    L19:
        r2 = true;
    L20:
        if (r2 == false) goto L22;
        float r15 = (r14 - this.h.c()) / 2.0f;
    L23:
        r6 = this.h.a();
        r7 = this.h.c();
        r8 = r15;
        r5 = 0.0f;
        r3 = r14;
        r4 = r13;
        goto L24
    L22:
        r15 = this.d * r14;
        goto L23
    L18:
        if (ArraysKt.contains(this.c, LayoutMode.CenterVertical) == false) goto L20;
    L29:
        return new b(this.h, this.g, this.e, this.f);
    }

    public c(a<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        this.h = r2;
        this.c = new LayoutMode[0];
        this.e = new Matrix();
        this.f = new Matrix();
    }

    public static Matrix b(RectF r4, RectF r5) {
        Matrix r0 = new Matrix();
        r0.postTranslate(r5.left - r4.left, r5.top - r4.top);
        r0.postScale(r5.width() / r4.width(), r5.height() / r4.height(), r5.left, r5.top);
        return r0;
    }
}
