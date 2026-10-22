package p19;

import android.graphics.Path;
import com.github.alexzhirkevich.customqrgenerator.vector.style.l;
import com.github.alexzhirkevich.customqrgenerator.vector.style.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a implements l, m {
    public final /* synthetic */ c a;
    public final float b;

    public final Path a(float r2, com.github.alexzhirkevich.customqrgenerator.style.c r3) {
        Intrinsics.checkNotNullParameter(r3, "neighbors");
        return this.a.a(r2, r3);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Float.compare(this.b, ((a) r4).b) == 0) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.b);
    }

    public final String toString() {
        return "Square(scale=" + this.b + ')';
    }

    public a() {
        this(1.0f);
    }

    public a(float r2) {
        this.a = new c(r2);
        this.b = r2;
    }
}
