package tp9;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public final Function1<Matrix, Unit> a;
    public final Matrix b;
    public final RectF c;
    public final RectF d;
    public final float[] e;
    public float f;
    public float g;

    public final void a() {
        Matrix r0 = this.b;
        r0.setValues(this.e);
        r0.mapRect(this.d, this.c);
        r0.postTranslate(this.f - this.d.centerX(), this.g - this.d.centerY());
        this.a.invoke(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Rect r2, float[] r3, Function1<? super Matrix, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "values");
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.a = r4;
        this.b = new Matrix();
        this.c = new RectF(r2);
        this.d = new RectF();
        this.e = (float[]) r3.clone();
        a();
    }
}
