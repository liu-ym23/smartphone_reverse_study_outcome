package q;

import android.graphics.Path;
import com.airbnb.lottie.w;

/* JADX INFO: loaded from: classes.dex */
public final class k implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f21426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path.FillType f21427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f21428c;
    public final p.a d;
    public final p.a e;
    public final boolean f;

    public k(String r5, boolean r10, Path.FillType r11, p.a r12, p.a r13, boolean r14) {
        this.f21428c = r5;
        this.f21426a = r10;
        this.f21427b = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }

    @Override // q.b
    public final k.c a(w r5, r.c r10) {
        return new k.g(r5, r10, this);
    }

    public final String toString() {
        return androidx.constraintlayout.motion.widget.a.w(new StringBuilder("ShapeFill{color=, fillEnabled="), this.f21426a, '}');
    }
}
