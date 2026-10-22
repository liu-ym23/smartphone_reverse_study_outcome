package x9;

import android.graphics.Typeface;

/* JADX INFO: loaded from: classes.dex */
public final class a extends android.support.v4.media.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Typeface f13741c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC0193a f13742d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f13743e;

    /* JADX INFO: renamed from: x9.a$a, reason: collision with other inner class name */
    public interface InterfaceC0193a {
    }

    public a(com.google.android.material.internal.b r8, Typeface r10) {
        this.f13741c = r10;
        this.f13742d = r8;
    }

    @Override // android.support.v4.media.a
    public final void q(int r8) {
        if (this.f13743e == true) goto L8;
        com.google.android.material.internal.c r10 = ((com.google.android.material.internal.b) this.f13742d).f4824a;
        if (r10.j(this.f13741c) == false) goto L9;
        r10.h(false);
        return;
    L9:
        return;
    }

    @Override // android.support.v4.media.a
    public final void r(Typeface r8, boolean r10) {
        if (this.f13743e == true) goto L8;
        com.google.android.material.internal.c r11 = ((com.google.android.material.internal.b) this.f13742d).f4824a;
        if (r11.j(r8) == false) goto L9;
        r11.h(false);
        return;
    L9:
        return;
    }
}
