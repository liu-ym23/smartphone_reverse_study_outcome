package q;

import com.airbnb.lottie.w;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class l implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f21430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f21431c;

    public l(String r5, boolean r10, List r11) {
        this.f21429a = r5;
        this.f21430b = r11;
        this.f21431c = r10;
    }

    @Override // q.b
    public final k.c a(w r5, r.c r10) {
        return new k.d(r5, r10, this);
    }

    public final String toString() {
        return "ShapeGroup{name='" + this.f21429a + "' Shapes: " + Arrays.toString(this.f21430b.toArray()) + '}';
    }
}
