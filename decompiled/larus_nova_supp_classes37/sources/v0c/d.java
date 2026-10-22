package v0c;

import android.view.MotionEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d implements p.a {
    public final /* synthetic */ MotionEvent a;
    public final /* synthetic */ MotionEvent b;
    public final /* synthetic */ float c;
    public final /* synthetic */ float d;

    @Override // v0c.p.a
    public final void a(o r5) {
        ((y0c.b) r5).onScroll(this.a, this.b, this.c, this.d);
    }

    public d(MotionEvent r1, MotionEvent r2, float r3, float r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
