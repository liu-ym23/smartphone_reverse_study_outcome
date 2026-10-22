package m9;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.CarouselLayoutManager;

/* JADX INFO: loaded from: classes.dex */
public final class f extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CarouselLayoutManager f9311b;

    public f(CarouselLayoutManager r8) {
        this.f9311b = r8;
        super(0);
    }

    @Override // m9.g
    public final void a(RectF r8, RectF r10, RectF r11) {
        float r12 = r10.left;
        float r13 = r11.left;
        if (r12 < r13) goto L5;
    L7:
        float r14 = r10.right;
        float r15 = r11.right;
        if (r14 > r15) goto L10;
        return;
    L10:
        if (r10.left >= r15) goto L14;
        float r16 = r14 - r15;
        r8.right = Math.max(r8.right - r16, r8.left);
        r10.right = Math.max(r10.right - r16, r10.left);
        return;
    L14:
        return;
    L5:
        if (r10.right <= r13) goto L7;
        float r17 = r13 - r12;
        r8.left += r17;
        r10.left += r17;
        goto L7
    }

    @Override // m9.g
    public final float b(RecyclerView.p r8) {
        return ((ViewGroup.MarginLayoutParams) r8).rightMargin + ((ViewGroup.MarginLayoutParams) r8).leftMargin;
    }

    @Override // m9.g
    public final RectF c(float r8, float r10, float r11, float r12) {
        return new RectF(r12, 0.0f, r10 - r12, r8);
    }

    @Override // m9.g
    public final int d() {
        CarouselLayoutManager r8 = this.f9311b;
        return r8.f2327o - r8.C();
    }

    @Override // m9.g
    public final int e() {
        CarouselLayoutManager r8 = this.f9311b;
        if (r8.N0() == false) goto L6;
        return 0;
    L6:
        return r8.f2326n;
    }

    @Override // m9.g
    public final int f() {
        return 0;
    }

    @Override // m9.g
    public final int g() {
        return this.f9311b.f2326n;
    }

    @Override // m9.g
    public final int h() {
        CarouselLayoutManager r8 = this.f9311b;
        if (r8.N0() == true) goto L7;
        return 0;
    L7:
        return r8.f2326n;
    }

    @Override // m9.g
    public final int i() {
        return this.f9311b.F();
    }

    @Override // m9.g
    public final void j(View r8, int r10, int r11) {
        int r12 = i();
        int r13 = d();
        this.f9311b.getClass();
        RecyclerView.o.M(r8, r10, r12, r11, r13);
    }

    @Override // m9.g
    public final void k(RectF r8, RectF r10, RectF r11) {
        if (r10.right > r11.left) goto L6;
        float r12 = ((float) Math.floor(r8.right)) - 1.0f;
        r8.right = r12;
        r8.left = Math.min(r8.left, r12);
    L6:
        if (r10.left < r11.right) goto L9;
        float r13 = ((float) Math.ceil(r8.left)) + 1.0f;
        r8.left = r13;
        r8.right = Math.max(r13, r8.right);
        return;
    }

    @Override // m9.g
    public final void l(float r8, float r10, Rect r11, View r12) {
        r12.offsetLeftAndRight((int) (r10 - (r11.left + r8)));
    }
}
