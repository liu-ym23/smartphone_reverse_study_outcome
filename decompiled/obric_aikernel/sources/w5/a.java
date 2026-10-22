package w5;

import android.content.Context;
import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.resources.b;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f13391f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f13392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f13393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f13394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f13395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f13396e;

    static {
        f13391f = (int) Math.round(5.1000000000000005d);
    }

    public a(@NonNull Context r10) {
        this(b.b(r10, q5.b.elevationOverlayEnabled, false), t5.a.b(r10, q5.b.elevationOverlayColor, 0), t5.a.b(r10, q5.b.elevationOverlayAccentColor, 0), t5.a.b(r10, q5.b.colorSurface, 0), r10.getResources().getDisplayMetrics().density);
    }

    public a(boolean r10, @ColorInt int r11, @ColorInt int r12, @ColorInt int r13, float r14) {
        this.f13392a = r10;
        this.f13393b = r11;
        this.f13394c = r12;
        this.f13395d = r13;
        this.f13396e = r14;
    }

    private boolean f(@ColorInt int r10) {
        if (ColorUtils.setAlphaComponent(r10, 255) != this.f13395d) goto L5;
        return true;
    L5:
        return false;
    }

    public float a(float r10) {
        float r11 = this.f13396e;
        if (r11 > 0.0f) goto L5;
    L9:
        return 0.0f;
    L5:
        if (r10 <= 0.0f) goto L9;
        return Math.min(((((float) Math.log1p(r10 / r11)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    @ColorInt
    public int b(@ColorInt int r10, float r11) {
        float r12 = a(r11);
        int r13 = Color.alpha(r10);
        int r14 = t5.a.h(ColorUtils.setAlphaComponent(r10, 255), this.f13393b, r12);
        if (r12 <= 0.0f) goto L8;
        int r15 = this.f13394c;
        if (r15 == 0) goto L8;
        r14 = t5.a.g(r14, ColorUtils.setAlphaComponent(r15, f13391f));
    L8:
        return ColorUtils.setAlphaComponent(r14, r13);
    }

    @ColorInt
    public int c(@ColorInt int r10, float r11) {
        if (this.f13392a == true) goto L5;
    L8:
        return r10;
    L5:
        if (f(r10) == false) goto L8;
        return b(r10, r11);
    }

    @ColorInt
    public int d(float r10) {
        return c(this.f13395d, r10);
    }

    public boolean e() {
        return this.f13392a;
    }
}
