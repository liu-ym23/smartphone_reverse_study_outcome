package r;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.w;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public final class i extends c {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final k.d f21623v;

    public i(w r5, g r10) {
        super(r5, r10);
        k.d r11 = new k.d(r5, this, new q.l("__container", false, r10.f21606a));
        this.f21623v = r11;
        r11.b(Collections.emptyList(), Collections.emptyList());
    }

    @Override // r.c, k.e
    public final void e(RectF r5, Matrix r10, boolean r11) {
        super.e(r5, r10, r11);
        Matrix r12 = this.f21587l;
        this.f21623v.e(r5, r12, r11);
    }

    @Override // r.c
    public final void j(Canvas r5, Matrix r10, int r11) {
        this.f21623v.g(r5, r10, r11);
    }

    @Override // r.c
    public final void m(o.e r5, int r10, ArrayList r11, o.e r12) {
        this.f21623v.d(r5, r10, r11, r12);
    }
}
