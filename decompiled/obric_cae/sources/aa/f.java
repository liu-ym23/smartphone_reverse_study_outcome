package aa;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import java.util.BitSet;

/* JADX INFO: loaded from: classes.dex */
public class f extends Drawable implements n {
    public static final Paint H = null;
    public final a A;
    public final k B;
    public PorterDuffColorFilter C;
    public PorterDuffColorFilter D;
    public int E;
    public final RectF F;
    public final boolean G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m.f[] f140b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final m.f[] f141m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final BitSet f142n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f143o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Matrix f144p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Path f145q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Path f146r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final RectF f147s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final RectF f148t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Region f149u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Region f150v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public j f151w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Paint f152x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Paint f153y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final z9.a f154z;

    public class a implements k.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f155a;

        public a(f r8) {
            this.f155a = r8;
        }
    }

    public static class b extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public j f156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public s9.a f157b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ColorStateList f158c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ColorStateList f159d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ColorStateList f160e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ColorStateList f161f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public PorterDuff.Mode f162g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Rect f163h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final float f164i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f165j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f166k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f167l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public float f168m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f169n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final float f170o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final int f171p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f172q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f173r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f174s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final boolean f175t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final Paint.Style f176u;

        public b(b r8) {
            this.f158c = null;
            this.f159d = null;
            this.f160e = null;
            this.f161f = null;
            this.f162g = PorterDuff.Mode.SRC_IN;
            this.f163h = null;
            this.f164i = 1.0f;
            this.f165j = 1.0f;
            this.f167l = 255;
            this.f168m = 0.0f;
            this.f169n = 0.0f;
            this.f170o = 0.0f;
            this.f171p = 0;
            this.f172q = 0;
            this.f173r = 0;
            this.f174s = 0;
            this.f175t = false;
            this.f176u = Paint.Style.FILL_AND_STROKE;
            this.f156a = r8.f156a;
            this.f157b = r8.f157b;
            this.f166k = r8.f166k;
            this.f158c = r8.f158c;
            this.f159d = r8.f159d;
            this.f162g = r8.f162g;
            this.f161f = r8.f161f;
            this.f167l = r8.f167l;
            this.f164i = r8.f164i;
            this.f173r = r8.f173r;
            this.f171p = r8.f171p;
            this.f175t = r8.f175t;
            this.f165j = r8.f165j;
            this.f168m = r8.f168m;
            this.f169n = r8.f169n;
            this.f170o = r8.f170o;
            this.f172q = r8.f172q;
            this.f174s = r8.f174s;
            this.f160e = r8.f160e;
            this.f176u = r8.f176u;
            if (r8.f163h == null) goto L6;
            this.f163h = new Rect(r8.f163h);
            return;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            f r8 = new f(this);
            r8.f143o = true;
            return r8;
        }

        public b(j r8) {
            this.f158c = null;
            this.f159d = null;
            this.f160e = null;
            this.f161f = null;
            this.f162g = PorterDuff.Mode.SRC_IN;
            this.f163h = null;
            this.f164i = 1.0f;
            this.f165j = 1.0f;
            this.f167l = 255;
            this.f168m = 0.0f;
            this.f169n = 0.0f;
            this.f170o = 0.0f;
            this.f171p = 0;
            this.f172q = 0;
            this.f173r = 0;
            this.f174s = 0;
            this.f175t = false;
            this.f176u = Paint.Style.FILL_AND_STROKE;
            this.f156a = r8;
            this.f157b = null;
        }
    }

    static {
        Paint r8 = new Paint(1);
        H = r8;
        r8.setColor(-1);
        r8.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public f() {
        this(new j());
    }

    public final void b(RectF r8, Path r10) {
        k r11 = this.B;
        b r12 = this.f139a;
        r11.a(r12.f156a, r12.f165j, r8, this.A, r10);
        if (this.f139a.f164i == 1.0f) goto L5;
        Matrix r13 = this.f144p;
        r13.reset();
        float r14 = this.f139a.f164i;
        r13.setScale(r14, r14, r8.width() / 2.0f, r8.height() / 2.0f);
        r10.transform(r13);
    L5:
        r10.computeBounds(this.F, true);
    }

    public final PorterDuffColorFilter c(ColorStateList r8, PorterDuff.Mode r10, Paint r11, boolean r12) {
        if (r8 == null) goto L9;
        if (r10 == null) goto L9;
        int r13 = r8.getColorForState(getState(), 0);
        if (r12 == false) goto L8;
        r13 = d(r13);
    L8:
        this.E = r13;
        return new PorterDuffColorFilter(r13, r10);
    L9:
        if (r12 == false) goto L13;
        int r14 = r11.getColor();
        int r15 = d(r14);
        this.E = r15;
        if (r15 == r14) goto L13;
        return new PorterDuffColorFilter(r15, PorterDuff.Mode.SRC_IN);
    L13:
        return null;
    }

    public final int d(int r8) {
        b r10 = this.f139a;
        float r11 = (r10.f169n + r10.f170o) + r10.f168m;
        s9.a r12 = r10.f157b;
        if (r12 != null) goto L5;
        return r8;
    L5:
        if (r12.f12051a == true) goto L7;
        return r8;
    L7:
        if (a0.a.d(r8, 255) != r12.f12054d) goto L9;
        boolean r13 = true;
    L10:
        if (r13 == false) goto L27;
        float r14 = r12.f12055e;
        if (r14 > 0.0f) goto L14;
    L17:
        float r15 = 0.0f;
    L18:
        int r16 = Color.alpha(r8);
        int r17 = t2.b.K(r15, a0.a.d(r8, 255), r12.f12052b);
        if (r15 <= 0.0f) goto L24;
        int r18 = r12.f12053c;
        if (r18 == 0) goto L24;
        r17 = a0.a.c(a0.a.d(r18, s9.a.f12050f), r17);
    L24:
        return a0.a.d(r17, r16);
    L14:
        if (r11 <= 0.0f) goto L17;
        r15 = Math.min(((((float) Math.log1p(r11 / r14)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        goto L18
    L27:
        return r8;
    L9:
        r13 = false;
        goto L10
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r22) {
        Paint r8 = this.f152x;
        r8.setColorFilter(this.C);
        int r10 = r8.getAlpha();
        int r11 = this.f139a.f167l;
        r8.setAlpha(((r11 + (r11 >>> 7)) * r10) >>> 8);
        Paint r12 = this.f153y;
        r12.setColorFilter(this.D);
        r12.setStrokeWidth(this.f139a.f166k);
        int r13 = r12.getAlpha();
        int r14 = this.f139a.f167l;
        r12.setAlpha(((r14 + (r14 >>> 7)) * r13) >>> 8);
        boolean r15 = this.f143o;
        Path r16 = this.f145q;
        if (r15 == false) goto L28;
        Paint.Style r17 = this.f139a.f176u;
        if (r17 == Paint.Style.FILL_AND_STROKE) goto L9;
        if (r17 == Paint.Style.STROKE) goto L9;
    L11:
        boolean r18 = false;
    L13:
        if (r18 == false) goto L15;
        float r19 = r12.getStrokeWidth() / 2.0f;
    L16:
        j r20 = this.f139a.f156a;
        g r21 = new g(-r19);
        r20.getClass();
        j.a r23 = new j.a(r20);
        r23.f196e = r21.a(r20.f184e);
        r23.f197f = r21.a(r20.f185f);
        r23.f199h = r21.a(r20.f187h);
        r23.f198g = r21.a(r20.f186g);
        j r24 = new j(r23);
        this.f151w = r24;
        k r110 = this.B;
        float r25 = this.f139a.f165j;
        RectF r26 = this.f148t;
        r26.set(h());
        Paint.Style r27 = this.f139a.f176u;
        if (r27 == Paint.Style.FILL_AND_STROKE) goto L21;
        if (r27 == Paint.Style.STROKE) goto L21;
    L23:
        boolean r28 = false;
    L24:
        if (r28 == false) goto L26;
        float r29 = r12.getStrokeWidth() / 2.0f;
    L27:
        r26.inset(r29, r29);
        r110.a(r24, r25, r26, null, this.f146r);
        b(h(), r16);
        this.f143o = false;
        goto L28
    L26:
        r29 = 0.0f;
    L21:
        if (r12.getStrokeWidth() <= 0.0f) goto L23;
        r28 = true;
        goto L24
    L15:
        r19 = 0.0f;
    L9:
        if (r12.getStrokeWidth() <= 0.0f) goto L11;
        r18 = true;
    L28:
        b r30 = this.f139a;
        int r31 = r30.f171p;
        if (r31 != 1) goto L31;
    L37:
        boolean r32 = false;
    L38:
        if (r32 == false) goto L48;
        r22.save();
        b r33 = this.f139a;
        int r34 = (int) (Math.sin(Math.toRadians(r33.f174s)) * r33.f173r);
        b r35 = this.f139a;
        r22.translate(r34, (int) (Math.cos(Math.toRadians(r35.f174s)) * r35.f173r));
        if (this.G == true) goto L43;
        e(r22);
    L47:
        r22.restore();
        goto L48
    L43:
        RectF r36 = this.F;
        int r37 = (int) (r36.width() - getBounds().width());
        int r38 = (int) (r36.height() - getBounds().height());
        if (r37 < 0) goto L70;
        if (r38 < 0) goto L70;
        Bitmap r39 = Bitmap.createBitmap(((this.f139a.f172q * 2) + ((int) r36.width())) + r37, ((this.f139a.f172q * 2) + ((int) r36.height())) + r38, Bitmap.Config.ARGB_8888);
        Canvas r40 = new Canvas(r39);
        float r41 = (getBounds().left - this.f139a.f172q) - r37;
        float r42 = (getBounds().top - this.f139a.f172q) - r38;
        r40.translate(-r41, -r42);
        e(r40);
        r22.drawBitmap(r39, r41, r42, null);
        r39.recycle();
    L70:
        throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
    L48:
        b r43 = this.f139a;
        Paint.Style r44 = r43.f176u;
        if (r44 != Paint.Style.FILL_AND_STROKE) goto L51;
    L54:
        boolean r45 = true;
    L55:
        if (r45 == false) goto L57;
        f(r22, r8, r16, r43.f156a, h());
    L57:
        Paint.Style r46 = this.f139a.f176u;
        if (r46 == Paint.Style.FILL_AND_STROKE) goto L62;
        if (r46 == Paint.Style.STROKE) goto L62;
    L64:
        boolean r111 = false;
    L65:
        if (r111 == false) goto L67;
        g(r22);
    L67:
        r8.setAlpha(r10);
        r12.setAlpha(r13);
        return;
    L62:
        if (r12.getStrokeWidth() <= 0.0f) goto L64;
        r111 = true;
        goto L65
    L51:
        if (r44 == Paint.Style.FILL) goto L54;
        r45 = false;
        goto L55
    L31:
        if (r30.f172q <= 0) goto L37;
        if (r31 != 2) goto L34;
        r32 = true;
        goto L38
    L34:
        if (r30.f156a.d(h()) == true) goto L37;
        r16.isConvex();
        goto L37
    }

    public final void e(Canvas r8) {
        if (this.f142n.cardinality() <= 0) goto L5;
        Log.w("f", "Compatibility shadow requested but can't be drawn for all operations in this shape.");
    L5:
        int r10 = this.f139a.f173r;
        Path r11 = this.f145q;
        z9.a r12 = this.f154z;
        if (r10 == 0) goto L8;
        r8.drawPath(r11, r12.f14310a);
    L8:
        int r13 = 0;
    L10:
        if (r13 >= 4) goto L13;
        m.f r14 = this.f140b[r13];
        int r15 = this.f139a.f172q;
        Matrix r16 = m.f.f246b;
        r14.a(r16, r12, r15, r8);
        this.f141m[r13].a(r16, r12, this.f139a.f172q, r8);
        r13 = r13 + 1;
        goto L10
    L13:
        if (this.G == false) goto L17;
        b r17 = this.f139a;
        int r18 = (int) (Math.sin(Math.toRadians(r17.f174s)) * r17.f173r);
        b r19 = this.f139a;
        int r20 = (int) (Math.cos(Math.toRadians(r19.f174s)) * r19.f173r);
        r8.translate(-r18, -r20);
        r8.drawPath(r11, H);
        r8.translate(r18, r20);
        return;
    }

    public final void f(Canvas r8, Paint r10, Path r11, j r12, RectF r13) {
        if (r12.d(r13) == false) goto L5;
        float r14 = r12.f185f.a(r13) * this.f139a.f165j;
        r8.drawRoundRect(r13, r14, r14, r10);
        return;
    L5:
        r8.drawPath(r11, r10);
    }

    public void g(Canvas r8) {
        Paint r10 = this.f153y;
        Path r11 = this.f146r;
        j r12 = this.f151w;
        RectF r13 = this.f148t;
        r13.set(h());
        Paint.Style r14 = this.f139a.f176u;
        float r15 = 0.0f;
        if (r14 == Paint.Style.FILL_AND_STROKE) goto L7;
        if (r14 == Paint.Style.STROKE) goto L7;
    L9:
        boolean r16 = false;
    L10:
        if (r16 == false) goto L12;
        r15 = r10.getStrokeWidth() / 2.0f;
    L12:
        r13.inset(r15, r15);
        f(r8, r10, r11, r12, r13);
        return;
    L7:
        if (r10.getStrokeWidth() <= 0.0f) goto L9;
        r16 = true;
        goto L10
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f139a.f167l;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f139a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline r8) {
        b r10 = this.f139a;
        if (r10.f171p != 2) goto L6;
        return;
    L6:
        if (r10.f156a.d(h()) == false) goto L9;
        float r11 = this.f139a.f156a.f184e.a(h()) * this.f139a.f165j;
        r8.setRoundRect(getBounds(), r11);
        return;
    L9:
        RectF r12 = h();
        Path r13 = this.f145q;
        b(r12, r13);
        r8.setPath(r13);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect r8) {
        Rect r10 = this.f139a.f163h;
        if (r10 == null) goto L7;
        r8.set(r10);
        return true;
    L7:
        return super.getPadding(r8);
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        Rect r8 = getBounds();
        Region r10 = this.f149u;
        r10.set(r8);
        RectF r11 = h();
        Path r12 = this.f145q;
        b(r11, r12);
        Region r13 = this.f150v;
        r13.setPath(r12, r10);
        r10.op(r13, Region.Op.DIFFERENCE);
        return r10;
    }

    public final RectF h() {
        RectF r8 = this.f147s;
        r8.set(getBounds());
        return r8;
    }

    public final void i(Context r8) {
        b r10 = this.f139a;
        r10.f157b = new s9.a(r8);
        n();
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        this.f143o = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful() == true) goto L22;
        ColorStateList r8 = this.f139a.f161f;
        if (r8 != null) goto L7;
    L8:
        ColorStateList r10 = this.f139a.f160e;
        if (r10 != null) goto L11;
    L12:
        ColorStateList r11 = this.f139a.f159d;
        if (r11 != null) goto L15;
    L16:
        ColorStateList r12 = this.f139a.f158c;
        if (r12 != null) goto L19;
    L21:
        return false;
    L19:
        if (r12.isStateful() == false) goto L21;
    L15:
        if (r11.isStateful() == true) goto L22;
    L11:
        if (r10.isStateful() == true) goto L22;
    L7:
        if (r8.isStateful() == false) goto L8;
    L22:
        return true;
    }

    public final void j(float r8) {
        b r10 = this.f139a;
        if (r10.f169n == r8) goto L6;
        r10.f169n = r8;
        n();
        return;
    }

    public final void k(ColorStateList r8) {
        b r10 = this.f139a;
        if (r10.f158c == r8) goto L6;
        r10.f158c = r8;
        onStateChange(getState());
        return;
    }

    public final boolean l(int[] r8) {
        if (this.f139a.f158c == null) goto L7;
        Paint r10 = this.f152x;
        int r11 = r10.getColor();
        int r12 = this.f139a.f158c.getColorForState(r8, r11);
        if (r11 == r12) goto L7;
        r10.setColor(r12);
        boolean r13 = true;
    L9:
        if (this.f139a.f159d == null) goto L14;
        Paint r14 = this.f153y;
        int r15 = r14.getColor();
        int r16 = this.f139a.f159d.getColorForState(r8, r15);
        if (r15 == r16) goto L14;
        r14.setColor(r16);
        return true;
    L14:
        return r13;
    L7:
        r13 = false;
        goto L9
    }

    public final boolean m() {
        PorterDuffColorFilter r8 = this.C;
        PorterDuffColorFilter r10 = this.D;
        b r11 = this.f139a;
        this.C = c(r11.f161f, r11.f162g, this.f152x, true);
        b r12 = this.f139a;
        this.D = c(r12.f160e, r12.f162g, this.f153y, false);
        b r13 = this.f139a;
        if (r13.f175t == false) goto L6;
        int r14 = r13.f161f.getColorForState(getState(), 0);
        this.f154z.a(r14);
    L6:
        if (i0.b.a(r8, this.C) == true) goto L8;
        return true;
    L8:
        if (i0.b.a(r10, this.D) == true) goto L11;
        return true;
    L11:
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f139a = new b(this.f139a);
        return this;
    }

    public final void n() {
        b r8 = this.f139a;
        float r10 = r8.f169n + r8.f170o;
        r8.f172q = (int) Math.ceil(0.75f * r10);
        this.f139a.f173r = (int) Math.ceil(r10 * 0.25f);
        m();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r8) {
        this.f143o = true;
        super.onBoundsChange(r8);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] r8) {
        boolean r10 = l(r8);
        boolean r11 = m();
        if (r10 == true) goto L7;
        if (r11 == true) goto L7;
        boolean r12 = false;
    L8:
        if (r12 == false) goto L10;
        invalidateSelf();
    L10:
        return r12;
    L7:
        r12 = true;
        goto L8
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r8) {
        b r10 = this.f139a;
        if (r10.f167l == r8) goto L6;
        r10.f167l = r8;
        super.invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r8) {
        this.f139a.getClass();
        super.invalidateSelf();
    }

    @Override // aa.n
    public final void setShapeAppearanceModel(j r8) {
        this.f139a.f156a = r8;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int r8) {
        setTintList(ColorStateList.valueOf(r8));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList r8) {
        this.f139a.f161f = r8;
        m();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode r8) {
        b r10 = this.f139a;
        if (r10.f162g == r8) goto L6;
        r10.f162g = r8;
        m();
        super.invalidateSelf();
        return;
    }

    public f(b r8) {
        this.f140b = new m.f[4];
        this.f141m = new m.f[4];
        this.f142n = new BitSet(8);
        this.f144p = new Matrix();
        this.f145q = new Path();
        this.f146r = new Path();
        this.f147s = new RectF();
        this.f148t = new RectF();
        this.f149u = new Region();
        this.f150v = new Region();
        Paint r10 = new Paint(1);
        this.f152x = r10;
        Paint r11 = new Paint(1);
        this.f153y = r11;
        this.f154z = new z9.a();
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        k r12 = k.a.f216a;
    L6:
        this.B = r12;
        this.F = new RectF();
        this.G = true;
        this.f139a = r8;
        r11.setStyle(Paint.Style.STROKE);
        r10.setStyle(Paint.Style.FILL);
        m();
        l(getState());
        this.A = new a(this);
        return;
    L5:
        r12 = new k();
        goto L6
    }

    public f(j r8) {
        this(new b(r8));
    }

    public f(Context r8, AttributeSet r10, int r11, int r12) {
        this(j.b(r8, r10, r11, r12).a());
    }
}
