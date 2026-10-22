package z19;

import android.view.MotionEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class r implements j {
    public Float a;
    public Float b;

    public r() {
    }

    @Override // z19.j
    public final Float getLastMotionX() {
        return this.a;
    }

    @Override // z19.j
    public final Float getLastMotionY() {
        return this.b;
    }

    public final void a(MotionEvent r2) {
        if (r2 == null) goto L5;
        this.a = Float.valueOf(r2.getX());
        this.b = Float.valueOf(r2.getY());
        return;
    }
}
