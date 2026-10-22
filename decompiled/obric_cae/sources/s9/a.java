package s9;

import android.content.Context;
import com.obric.cae.R;
import x9.b;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f12050f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f12051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f12054d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f12055e;

    static {
        f12050f = (int) Math.round(5.1000000000000005d);
    }

    public a(Context r8) {
        boolean r10 = b.b(r8, false, R.attr.elevationOverlayEnabled);
        int r11 = t2.b.y(r8, R.attr.elevationOverlayColor, 0);
        int r12 = t2.b.y(r8, R.attr.elevationOverlayAccentColor, 0);
        int r13 = t2.b.y(r8, R.attr.colorSurface, 0);
        float r14 = r8.getResources().getDisplayMetrics().density;
        this.f12051a = r10;
        this.f12052b = r11;
        this.f12053c = r12;
        this.f12054d = r13;
        this.f12055e = r14;
    }
}
