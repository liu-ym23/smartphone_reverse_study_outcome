package fsb;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ f.a b;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        f.a.a(this.b);
        String r0 = this.a;
        if (r0 != null) goto L5;
        return true;
    L5:
        if (r0.equals(f.b().a) == false) goto L10;
        f.b().e();
        return true;
    L10:
        return true;
    }

    public e(f.a r1, String r2) {
        this.b = r1;
        this.a = r2;
    }
}
