package aa;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f137b;

    public b(float r8, c r10) {
    L4:
        if ((r10 instanceof b) == false) goto L6;
        r10 = ((b) r10).f136a;
        r8 = r8 + ((b) r10).f137b;
        goto L4
    L6:
        this.f136a = r10;
        this.f137b = r8;
    }

    @Override // aa.c
    public final float a(RectF r8) {
        return Math.max(0.0f, this.f136a.a(r8) + this.f137b);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof b) == true) goto L8;
        return false;
    L8:
        b r10 = (b) r8;
        c r11 = r10.f136a;
        if (this.f136a.equals(r11) == false) goto L14;
        if (this.f137b != r10.f137b) goto L14;
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Float r8 = Float.valueOf(this.f137b);
        return Arrays.hashCode(new Object[]{this.f136a, r8});
    }
}
