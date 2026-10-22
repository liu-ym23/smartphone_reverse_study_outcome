package z9;

import android.graphics.Paint;
import android.graphics.Path;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f14306i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final float[] f14307j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f14308k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final float[] f14309l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f14310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f14311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f14312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14313d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14314e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f14315f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Path f14316g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f14317h;

    static {
        f14306i = new int[3];
        f14307j = new float[]{0.0f, 0.5f, 1.0f};
        f14308k = new int[4];
        f14309l = new float[]{0.0f, 0.0f, 0.5f, 1.0f};
    }

    public a() {
        this.f14316g = new Path();
        Paint r8 = new Paint();
        this.f14317h = r8;
        this.f14310a = new Paint();
        a(-16777216);
        r8.setColor(0);
        Paint r10 = new Paint(4);
        this.f14311b = r10;
        r10.setStyle(Paint.Style.FILL);
        this.f14312c = new Paint(r10);
    }

    public final void a(int r8) {
        this.f14313d = a0.a.d(r8, 68);
        this.f14314e = a0.a.d(r8, 20);
        this.f14315f = a0.a.d(r8, 0);
        this.f14310a.setColor(this.f14313d);
    }
}
