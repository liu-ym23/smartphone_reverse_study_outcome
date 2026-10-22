package q;

import ai.j0;
import com.airbnb.lottie.w;
import k.s;

/* JADX INFO: loaded from: classes.dex */
public final class m implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p.a f21434c;
    public final boolean d;

    public m(String r5, int r10, p.a r11, boolean r12) {
        this.f21432a = r5;
        this.f21433b = r10;
        this.f21434c = r11;
        this.d = r12;
    }

    @Override // q.b
    public final k.c a(w r5, r.c r10) {
        return new s(r5, r10, this);
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("ShapePath{name=");
        r5.append(this.f21432a);
        r5.append(", index=");
        return j0.n(r5, this.f21433b, '}');
    }
}
