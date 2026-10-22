package m9;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9312a;

    public g(int r8) {
        this.f9312a = r8;
    }

    public abstract void a(RectF r8, RectF r10, RectF r11);

    public abstract float b(RecyclerView.p r8);

    public abstract RectF c(float r8, float r10, float r11, float r12);

    public abstract int d();

    public abstract int e();

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public abstract void j(View r8, int r10, int r11);

    public abstract void k(RectF r8, RectF r10, RectF r11);

    public abstract void l(float r8, float r10, Rect r11, View r12);
}
