package androidx.activity;

import android.window.BackEvent;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f469a = null;

    static {
        f469a = new a();
    }

    public final BackEvent a(float r8, float r10, float r11, int r12) {
        return new BackEvent(r8, r10, r11, r12);
    }

    public final float b(BackEvent r8) {
        he.i.f(r8, "backEvent");
        return r8.getProgress();
    }

    public final int c(BackEvent r8) {
        he.i.f(r8, "backEvent");
        return r8.getSwipeEdge();
    }

    public final float d(BackEvent r8) {
        he.i.f(r8, "backEvent");
        return r8.getTouchX();
    }

    public final float e(BackEvent r8) {
        he.i.f(r8, "backEvent");
        return r8.getTouchY();
    }
}
