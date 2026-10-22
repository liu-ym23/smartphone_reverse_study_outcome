package aa;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class h implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f178a;

    public h(float r8) {
        this.f178a = r8;
    }

    @Override // aa.c
    public final float a(RectF r8) {
        return Math.min(r8.width(), r8.height()) * this.f178a;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof h) == true) goto L9;
        return false;
    L9:
        if (this.f178a != ((h) r8).f178a) goto L12;
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f178a)});
    }
}
