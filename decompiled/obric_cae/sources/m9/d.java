package m9;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.o;
import com.google.android.material.carousel.CarouselLayoutManager;

/* JADX INFO: loaded from: classes.dex */
public final class d extends o {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ CarouselLayoutManager f9309q;

    public d(CarouselLayoutManager r8, Context r10) {
        this.f9309q = r8;
        super(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y
    public final PointF a(int r8) {
        return this.f9309q.a(r8);
    }

    @Override // androidx.recyclerview.widget.o
    public final int f(View r8, int r10) {
        CarouselLayoutManager r11 = this.f9309q;
        if (r11.f4506u != null) goto L5;
        return 0;
    L5:
        if (r11.M0() == false) goto L11;
        int r12 = RecyclerView.o.G(r8);
        return (int) (r11.f4501p - r11.J0(r12, r11.H0(r12)));
    L11:
        return 0;
    }

    @Override // androidx.recyclerview.widget.o
    public final int g(View r8, int r10) {
        CarouselLayoutManager r11 = this.f9309q;
        if (r11.f4506u != null) goto L5;
        return 0;
    L5:
        if (r11.M0() == true) goto L11;
        int r12 = RecyclerView.o.G(r8);
        return (int) (r11.f4501p - r11.J0(r12, r11.H0(r12)));
    L11:
        return 0;
    }
}
