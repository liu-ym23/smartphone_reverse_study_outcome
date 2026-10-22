package k;

import android.graphics.Path;
import com.airbnb.lottie.model.content.ShapeTrimPath$Type;
import com.airbnb.lottie.w;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class s implements n, l.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f18562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f18563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w f18564c;
    public final l.k d;
    public boolean e;
    public final ym.j f;

    public s(w r5, r.c r10, q.m r11) {
        this.f18562a = new Path();
        this.f = new ym.j(9);
        r11.getClass();
        this.f18563b = r11.d;
        this.f18564c = r5;
        l.d r12 = r11.f21434c.d();
        this.d = (l.k) r12;
        r10.f(r12);
        r12.a(this);
    }

    @Override // l.a
    public final void a() {
        this.e = false;
        this.f18564c.invalidateSelf();
    }

    @Override // k.c
    public final void b(List r5, List r10) {
        int r11 = 0;
    L3:
        ArrayList r12 = (ArrayList) r5;
        if (r11 >= r12.size()) goto L11;
        c r13 = (c) r12.get(r11);
        if ((r13 instanceof u) == false) goto L10;
        u r14 = (u) r13;
        if (r14.f18571c != ShapeTrimPath$Type.SIMULTANEOUSLY) goto L10;
        ((ArrayList) this.f.f23302a).add(r14);
        r14.c(this);
    L10:
        r11 = r11 + 1;
        goto L3
    }

    @Override // k.n
    public final Path getPath() {
        boolean r5 = this.e;
        Path r10 = this.f18562a;
        if (r5 == false) goto L5;
        return r10;
    L5:
        r10.reset();
        if (this.f18563b == false) goto L9;
        this.e = true;
        return r10;
    L9:
        r10.set((Path) this.d.f());
        r10.setFillType(Path.FillType.EVEN_ODD);
        this.f.c(r10);
        this.e = true;
        return r10;
    }
}
