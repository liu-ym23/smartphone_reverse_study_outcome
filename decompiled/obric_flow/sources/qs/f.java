package qs;

import android.view.DisplayCutout;
import android.view.WindowInsets;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f extends e {
    public b d;

    @Override // qs.h
    public final i a() {
        return i.a(null, this.f21570b.consumeDisplayCutout());
    }

    @Override // qs.h
    public final i b() {
        return i.a(null, this.f21570b.consumeStableInsets());
    }

    @Override // qs.h
    public final i c() {
        return i.a(null, this.f21570b.consumeSystemWindowInsets());
    }

    @Override // qs.h
    public final a e() {
        DisplayCutout r5 = this.f21570b.getDisplayCutout();
        if (r5 != null) goto L6;
        return null;
    L6:
        return new a(r5);
    }

    @Override // qs.h
    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        WindowInsets r10 = ((f) r5).f21570b;
        return Objects.equals(this.f21570b, r10);
    }

    @Override // qs.h
    public final b h() {
        if (this.d != null) goto L6;
        WindowInsets r5 = this.f21570b;
        this.d = b.a(r5.getStableInsetLeft(), r5.getStableInsetTop(), r5.getStableInsetRight(), r5.getStableInsetBottom());
    L6:
        return this.d;
    }

    @Override // qs.h
    public final int hashCode() {
        return this.f21570b.hashCode();
    }

    @Override // qs.h
    public final boolean j() {
        return this.f21570b.isConsumed();
    }
}
