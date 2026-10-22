package k41;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.bytedance.android.livesdk.revenue.service.livecore.IRegion;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T> {
    public final a<T> a;
    public final RectF b;
    public final Matrix c;
    public final Matrix d;

    public final RectF a(RectF r3) {
        Intrinsics.checkNotNullParameter(r3, "rectF");
        Matrix r0 = this.d;
        RectF r1 = new RectF(r3);
        r0.mapRect(r1);
        return r1;
    }

    public final void b(IRegion r7, T r8) {
        Intrinsics.checkNotNullParameter(r7, "region");
        Matrix r0 = this.c;
        RectF r9 = this.a.b(r8);
        if (r9 != null) goto L6;
        r7.D3(0.1d, 0.1d);
        r7.C4(1.0d, 1.0d);
        return;
    L6:
        RectF r1 = new RectF(r9);
        r0.mapRect(r1);
        r7.D3(r1.width(), r1.height());
        r7.C4(r1.left, r1.top);
    }

    public b(a<T> r2, RectF r3, Matrix r4, Matrix r5) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        Intrinsics.checkNotNullParameter(r4, "matrix2Canvas");
        Intrinsics.checkNotNullParameter(r5, "matrix2Sei");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
