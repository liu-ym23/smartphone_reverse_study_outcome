package aa;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f135a;

    public a(float r8) {
        this.f135a = r8;
    }

    @Override // aa.c
    public final float a(RectF r8) {
        return this.f135a;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L9;
        return false;
    L9:
        if (this.f135a != ((a) r8).f135a) goto L12;
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f135a)});
    }
}
