package m9;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.CarouselLayoutManager;

/* JADX INFO: loaded from: classes.dex */
public final class e extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CarouselLayoutManager f9310b;

    public e(CarouselLayoutManager r8) {
        this.f9310b = r8;
        super(1);
    }

    @Override // m9.g
    public final void a(RectF r8, RectF r10, RectF r11) {
        float r12 = r10.top;
        float r13 = r11.top;
        if (r12 < r13) goto L5;
    L7:
        float r14 = r10.bottom;
        float r15 = r11.bottom;
        if (r14 > r15) goto L10;
        return;
    L10:
        if (r10.top >= r15) goto L14;
        float r16 = r14 - r15;
        r8.bottom = Math.max(r8.bottom - r16, r8.top);
        r10.bottom = Math.max(r10.bottom - r16, r10.top);
        return;
    L14:
        return;
    L5:
        if (r10.bottom <= r13) goto L7;
        float r17 = r13 - r12;
        r8.top += r17;
        r11.top += r17;
        goto L7
    }

    @Override // m9.g
    public final float b(RecyclerView.p r8) {
        return ((ViewGroup.MarginLayoutParams) r8).topMargin + ((ViewGroup.MarginLayoutParams) r8).bottomMargin;
    }

    @Override // m9.g
    public final RectF c(float r8, float r10, float r11, float r12) {
        return new RectF(0.0f, r11, r10, r8 - r11);
    }

    @Override // m9.g
    public final int d() {
        return this.f9310b.f2327o;
    }

    @Override // m9.g
    public final int e() {
        return this.f9310b.f2327o;
    }

    @Override // m9.g
    public final int f() {
        return this.f9310b.D();
    }

    @Override // m9.g
    public final int g() {
        CarouselLayoutManager r8 = this.f9310b;
        return r8.f2326n - r8.E();
    }

    @Override // m9.g
    public final int h() {
        return 0;
    }

    @Override // m9.g
    public final int i() {
        return 0;
    }

    @Override // m9.g
    public final void j(View r8, int r10, int r11) {
        int r12 = f();
        int r13 = g();
        this.f9310b.getClass();
        RecyclerView.o.M(r8, r12, r10, r13, r11);
    }

    @Override // m9.g
    public final void k(RectF r8, RectF r10, RectF r11) {
        if (r10.bottom > r11.top) goto L6;
        float r12 = ((float) Math.floor(r8.bottom)) - 1.0f;
        r8.bottom = r12;
        r8.top = Math.min(r8.top, r12);
    L6:
        if (r10.top < r11.bottom) goto L9;
        float r13 = ((float) Math.ceil(r8.top)) + 1.0f;
        r8.top = r13;
        r8.bottom = Math.max(r13, r8.bottom);
        return;
    }

    @Override // m9.g
    public final void l(float r8, float r10, Rect r11, View r12) {
        r12.offsetTopAndBottom((int) (r10 - (r11.top + r8)));
    }
}
