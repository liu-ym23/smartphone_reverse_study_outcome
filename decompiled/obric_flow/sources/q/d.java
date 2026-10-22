package q;

import android.graphics.Path;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.w;

/* JADX INFO: loaded from: classes.dex */
public final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GradientType f21396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path.FillType f21397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p.a f21398c;
    public final p.a d;
    public final p.a e;
    public final p.a f;
    public final String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f21399h;

    public d(String r5, GradientType r10, Path.FillType r11, p.a r12, p.a r13, p.a r14, p.a r15, boolean r16) {
        this.f21396a = r10;
        this.f21397b = r11;
        this.f21398c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r5;
        this.f21399h = r16;
    }

    @Override // q.b
    public final k.c a(w r5, r.c r10) {
        return new k.h(r5, r10, this);
    }
}
