package xx8;

import com.larus.utils.logger.FLogger;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a implements c {
    public float a;
    public boolean b;

    /* JADX INFO: renamed from: xx8.a$a, reason: collision with other inner class name */
    public static final class C0142a {
    }

    static {
    }

    public a() {
        this.a = 10.0f;
        this.b = true;
    }

    @Override // xx8.c
    public final boolean b() {
        return c.a.a(this);
    }

    @Override // xx8.c
    public final boolean d() {
        return c.a.c(this);
    }

    @Override // xx8.c
    public final boolean h() {
        return c.a.b(this);
    }

    @Override // xx8.c
    public final boolean g() {
        return this.b;
    }

    @Override // xx8.c
    public final Pair<Float, Boolean> a(float r5) {
        if (c.a.a(this) == false) goto L11;
        float r2 = 41.0f;
        if (r5 < 41.0f) goto L7;
        this.b = true;
        this.a = 10.0f;
    L12:
        FLogger.a.i("CameraZoomManager", "checkMaxZoomSupport srcMaxZoomValue=" + r5 + " resMaxZoomValue=" + r2 + " zoomRatioOffset=" + this.a);
        return new Pair(Float.valueOf(r2), Boolean.valueOf(this.b));
    L7:
        r2 = 21.0f;
        if (r5 < 21.0f) goto L10;
        this.b = true;
        this.a = 10.0f;
        goto L12
    L10:
        this.b = false;
        this.a = (r5 - 1.0f) / 4.0f;
    L11:
        r2 = r5;
        goto L12
    }

    @Override // xx8.c
    public final float c(float r3) {
        if (r3 != 1.0f) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return 1.0f;
    L9:
        return ((r3 - 1.0f) / this.a) + 1.0f;
    L5:
        r1 = false;
        goto L6
    }

    @Override // xx8.c
    public final float f(float r3) {
        if (r3 != 1.0f) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return 1.0f;
    L9:
        return ((r3 - 1.0f) * this.a) + 1.0f;
    L5:
        r1 = false;
        goto L6
    }

    @Override // xx8.c
    public final double e(float r5, double r6) {
        if (r5 != 1.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return 0.0d;
    L10:
        return ((double) f(r5)) * (r6 / ((double) (this.a * 4.0f)));
    L5:
        r0 = false;
        goto L6
    }
}
