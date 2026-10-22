package h9;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinearInterpolator f7943a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s0.b f7944b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final s0.a f7945c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final s0.c f7946d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final DecelerateInterpolator f7947e = null;

    static {
        f7943a = new LinearInterpolator();
        f7944b = new s0.b();
        f7945c = new s0.a();
        f7946d = new s0.c();
        f7947e = new DecelerateInterpolator();
    }

    public static float a(float r8, float r10, float r11, float r12, float r13) {
        if (r13 > r11) goto L6;
        return r8;
    L6:
        if (r13 < r12) goto L9;
        return r10;
    L9:
        return defpackage.a.a(r10, r8, (r13 - r11) / (r12 - r11), r8);
    }
}
