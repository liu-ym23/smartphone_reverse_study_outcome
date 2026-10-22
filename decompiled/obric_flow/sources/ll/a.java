package ll;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements tl.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f19678a;

    @Override // tl.a
    public final void d(String r5, String r10, Throwable r11) {
        if (this.f19678a == false) goto L6;
        Log.d(r5, r10, null);
        return;
    }

    @Override // tl.a
    public final void e(String r5, String r10, Throwable r11) {
        Log.e(r5, r10, r11);
    }

    @Override // tl.a
    public final void i(String r5, String r10, Throwable r11) {
        if (this.f19678a == false) goto L6;
        Log.i(r5, r10, null);
        return;
    }

    @Override // tl.a
    public final void v(String r5, String r10, Throwable r11) {
        if (this.f19678a == false) goto L6;
        Log.v(r5, r10, null);
        return;
    }

    @Override // tl.a
    public final void w(String r5, String r10, Throwable r11) {
        if (this.f19678a == false) goto L6;
        Log.w(r5, r10, r11);
        return;
    }
}
