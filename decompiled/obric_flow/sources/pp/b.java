package pp;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.obric.common.oea.foundation.graphics.smoothcorner.SmoothCornerHelper$Companion$CurveType;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import qp.c;
import qp.e;
import qp.f;
import qp.g;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f21386b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public um.a f21387a;

    static {
        f21386b = CollectionsKt.toList(RangesKt.step(new IntRange(8, 48), 2));
    }

    public b() {
        new rp.a();
        this.f21387a = new f();
    }

    public final void a(float r14, float r15, float r16, float r17, float r18, Canvas r19, Paint r20) {
        float r5 = r18;
        Intrinsics.checkNotNullParameter(r19, "canvas");
        Intrinsics.checkNotNullParameter(r20, "paint");
        if (r5 >= 0.0f) goto L6;
        rp.b.a("invalid radius: " + r5);
        r5 = 0.0f;
    L6:
        if (r5 <= (Math.min(r16 - r14, r17 - r15) / 2)) goto L8;
        um.a r10 = this.f21387a;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r19, "canvas");
        Intrinsics.checkNotNullParameter(r20, "paint");
        RectF r11 = (RectF) r10.f22372b;
        r11.set(r14, r15, r16, r17);
        r19.drawRoundRect(r11, r5, r5, r20);
        return;
    L8:
        um.a r12 = this.f21387a;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r19, "canvas");
        Intrinsics.checkNotNullParameter(r20, "paint");
        r19.drawPath(r12.l(r14, r15, r16, r17, r5), r20);
    }

    public final void b(SmoothCornerHelper$Companion$CurveType r10) {
        Intrinsics.checkNotNullParameter(r10, "curveType");
        Intrinsics.checkNotNullParameter(r10, "curveType");
        String r5 = "setCurveType: " + r10;
        Intrinsics.checkNotNullParameter("SmoothCornerHelper", "tag");
        Intrinsics.checkNotNullParameter(r5, "msg");
        if (rp.b.f21793a == null) goto L5;
        androidx.constraintlayout.motion.widget.a.B(androidx.constraintlayout.motion.widget.a.D("SmoothCornerHelper", "tag", r5, "msg", "SmoothCornerHelper->"), r5, "OEA_SDK");
    L5:
        int r11 = a.f21385a[r10.ordinal()];
        if (r11 != 1) goto L8;
        um.a r12 = new qp.a(8);
    L25:
        this.f21387a = r12;
        return;
    L8:
        if (r11 == 2) goto L21;
        if (r11 != 3) goto L12;
        r12 = new g();
        goto L25
    L12:
        if (r11 != 4) goto L14;
        r12 = new c();
        goto L25
    L14:
        if (r11 != 5) goto L17;
        r12 = new e();
        goto L25
    L17:
        throw new NoWhenBranchMatchedException();
    L21:
        if ((-1.0f) <= 0) goto L23;
        r12 = new f(-1.0f);
        goto L25
    L23:
        r12 = new f();
        goto L25
    }
}
