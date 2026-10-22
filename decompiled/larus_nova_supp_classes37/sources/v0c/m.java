package v0c;

import android.view.MotionEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class m implements p.a {
    public final /* synthetic */ MotionEvent a;

    public m(MotionEvent r1) {
        this.a = r1;
    }

    @Override // v0c.p.a
    public final void a(o r2) {
        ((y0c.b) r2).onDoubleTap(this.a);
    }
}
