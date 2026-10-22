package qs;

import android.view.DisplayCutout;
import androidx.core.util.ObjectsCompat;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DisplayCutout f21564a;

    public a(DisplayCutout r5) {
        this.f21564a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L5;
        return true;
    L5:
        if (r5 != null) goto L7;
        return false;
    L7:
        if (a.class == r5.getClass()) goto L10;
        return false;
    L10:
        return ObjectsCompat.equals(this.f21564a, ((a) r5).f21564a);
    }

    public final int hashCode() {
        return this.f21564a.hashCode();
    }

    public final String toString() {
        return "DisplayCutoutCompat{" + this.f21564a + "}";
    }
}
