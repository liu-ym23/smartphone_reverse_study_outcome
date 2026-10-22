package v9;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import kotlin.Deprecated;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f13192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f13193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f13194c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f13195d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f13196e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f13197f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f13198g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f13199h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Interpolator f13200i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Drawable f13201j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Drawable f13202k;

    /* JADX INFO: renamed from: v9.a$a, reason: collision with other inner class name */
    public static final class C0304a {
        private C0304a() {
        }

        public /* synthetic */ C0304a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new C0304a(null);
    }

    public a(Drawable r10, Drawable r11) {
        Intrinsics.checkNotNullParameter(r10, "startDrawable");
        Intrinsics.checkNotNullParameter(r11, "endDrawable");
        this.f13201j = r10;
        this.f13202k = r11;
        this.f13199h = true;
        this.f13200i = new AccelerateInterpolator();
    }

    private final void a(Canvas r10, int r11) {
        this.f13201j.setBounds(getBounds());
        this.f13202k.setBounds(getBounds());
        if (this.f13199h == false) goto L5;
        this.f13201j.setAlpha(255 - r11);
    L5:
        this.f13201j.draw(r10);
        if (this.f13199h == false) goto L8;
        this.f13201j.setAlpha(255);
    L8:
        if (r11 <= 0) goto L11;
        this.f13202k.setAlpha(r11);
        this.f13202k.draw(r10);
        this.f13202k.setAlpha(255);
        return;
    }

    public final void b() {
        this.f13197f = 0;
        this.f13192a = 0;
        invalidateSelf();
    }

    public final void c(int r13) {
        long r10 = SystemClock.uptimeMillis();
        int r11 = 0;
        if (this.f13192a != 2) goto L18;
        long r12 = this.f13193b;
        long r14 = r10 - r12;
        int r15 = this.f13194c;
        if (r14 > r15) goto L18;
        boolean r16 = !this.f13198g;
        this.f13198g = r16;
        this.f13195d = this.f13197f;
        if (r16 == true) goto L11;
        r11 = 255;
    L11:
        this.f13196e = r11;
        long r17 = r10 - r12;
        if (r16 == false) goto L14;
        int r18 = (int) r17;
    L15:
        this.f13194c = r18;
    L16:
        this.f13192a = 1;
        invalidateSelf();
        return;
    L14:
        r18 = r15 - ((int) r17);
    L18:
        this.f13195d = 255;
        this.f13196e = 0;
        this.f13197f = 255;
        this.f13194c = r13;
        this.f13198g = true;
        goto L16
    }

    public final void d() {
        this.f13197f = 255;
        this.f13192a = 0;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        int r11 = this.f13192a;
        if (r11 == 1) goto L10;
        if (r11 != 2) goto L11;
        long r12 = SystemClock.uptimeMillis() - this.f13193b;
        int r13 = this.f13194c;
        if (r12 < r13) goto L9;
        this.f13197f = this.f13196e;
        this.f13192a = 0;
        goto L11
    L9:
        float r14 = this.f13200i.getInterpolation(r12 / r13);
        int r15 = this.f13195d;
        this.f13197f = r15 + ((int) ((this.f13196e - r15) * r14));
    L11:
        int r16 = this.f13197f;
        if (this.f13192a != 0) goto L21;
        if (r16 != 0) goto L17;
        this.f13201j.setBounds(getBounds());
        Drawable r17 = this.f13201j;
    L15:
        r17.draw(r10);
        return;
    L17:
        if (r16 != 255) goto L19;
        this.f13202k.setBounds(getBounds());
        r17 = this.f13202k;
        goto L15
    L19:
        a(r10, r16);
        return;
    L21:
        a(r10, r16);
        if (this.f13192a != 2) goto L26;
        invalidateSelf();
        return;
    L26:
        return;
    L10:
        this.f13193b = SystemClock.uptimeMillis();
        this.f13192a = 2;
        goto L11
    }

    public final void e(int r10) {
        this.f13195d = 0;
        this.f13196e = 255;
        this.f13197f = 0;
        this.f13194c = r10;
        this.f13198g = false;
        this.f13192a = 1;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return Math.max(this.f13201j.getIntrinsicHeight(), this.f13202k.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.max(this.f13201j.getIntrinsicWidth(), this.f13202k.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r10) {
        this.f13201j.setAlpha(r10);
        this.f13202k.setAlpha(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r10) {
        this.f13201j.setColorFilter(r10);
        this.f13202k.setColorFilter(r10);
    }
}
