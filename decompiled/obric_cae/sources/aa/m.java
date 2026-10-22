package aa;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public float f224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public float f225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    public float f226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public float f227d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Deprecated
    public float f228e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Deprecated
    public float f229f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList f230g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f231h;

    public static class a extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c f232c;

        public a(c r8) {
            this.f232c = r8;
        }

        @Override // aa.m.f
        public final void a(Matrix r19, z9.a r20, int r21, Canvas r22) {
            c r8 = this.f232c;
            float r10 = r8.f241f;
            float r11 = r8.f242g;
            RectF r12 = new RectF(r8.f237b, r8.f238c, r8.f239d, r8.f240e);
            r20.getClass();
            if (r11 >= 0.0f) goto L5;
            boolean r13 = true;
        L6:
            Path r14 = r20.f14316g;
            int[] r15 = z9.a.f14308k;
            if (r13 == false) goto L9;
            r15[0] = 0;
            r15[1] = r20.f14315f;
            r15[2] = r20.f14314e;
            r15[3] = r20.f14313d;
        L10:
            float r16 = r12.width() / 2.0f;
            if (r16 <= 0.0f) goto L18;
            float r17 = 1.0f - (r21 / r16);
            float[] r18 = z9.a.f14309l;
            r18[1] = r17;
            r18[2] = ((1.0f - r17) / 2.0f) + r17;
            RadialGradient r23 = new RadialGradient(r12.centerX(), r12.centerY(), r16, r15, r18, Shader.TileMode.CLAMP);
            Paint r24 = r20.f14311b;
            r24.setShader(r23);
            r22.save();
            r22.concat(r19);
            r22.scale(1.0f, r12.height() / r12.width());
            if (r13 == true) goto L16;
            r22.clipPath(r14, Region.Op.DIFFERENCE);
            r22.drawPath(r14, r20.f14317h);
        L16:
            r22.drawArc(r12, r10, r11, true, r24);
            r22.restore();
            return;
        L18:
            return;
        L9:
            r14.rewind();
            r14.moveTo(r12.centerX(), r12.centerY());
            r14.arcTo(r12, r10, r11);
            r14.close();
            float r110 = -r21;
            r12.inset(r110, r110);
            r15[0] = 0;
            r15[1] = r20.f14313d;
            r15[2] = r20.f14314e;
            r15[3] = r20.f14315f;
            goto L10
        L5:
            r13 = false;
            goto L6
        }
    }

    public static class b extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final d f233c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f234d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f235e;

        public b(d r8, float r10, float r11) {
            this.f233c = r8;
            this.f234d = r10;
            this.f235e = r11;
        }

        @Override // aa.m.f
        public final void a(Matrix r18, z9.a r19, int r20, Canvas r21) {
            d r8 = this.f233c;
            float r10 = r8.f244c;
            float r11 = this.f235e;
            float r12 = r8.f243b;
            float r13 = this.f234d;
            RectF r14 = new RectF(0.0f, 0.0f, (float) Math.hypot(r10 - r11, r12 - r13), 0.0f);
            Matrix r15 = this.f247a;
            r15.set(r18);
            r15.preTranslate(r13, r11);
            r15.preRotate(b());
            r19.getClass();
            r14.bottom += r20;
            r14.offset(0.0f, -r20);
            int[] r16 = z9.a.f14306i;
            r16[0] = r19.f14315f;
            r16[1] = r19.f14314e;
            r16[2] = r19.f14313d;
            Paint r17 = r19.f14312c;
            float r110 = r14.left;
            r17.setShader(new LinearGradient(r110, r14.top, r110, r14.bottom, r16, z9.a.f14307j, Shader.TileMode.CLAMP));
            r21.save();
            r21.concat(r15);
            r21.drawRect(r14, r17);
            r21.restore();
        }

        public final float b() {
            d r8 = this.f233c;
            return (float) Math.toDegrees(Math.atan((r8.f244c - this.f235e) / (r8.f243b - this.f234d)));
        }
    }

    public static class c extends e {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final RectF f236h = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Deprecated
        public float f237b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Deprecated
        public float f238c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Deprecated
        public float f239d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Deprecated
        public float f240e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Deprecated
        public float f241f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Deprecated
        public float f242g;

        static {
            f236h = new RectF();
        }

        public c(float r8, float r10, float r11, float r12) {
            this.f237b = r8;
            this.f238c = r10;
            this.f239d = r11;
            this.f240e = r12;
        }

        @Override // aa.m.e
        public final void a(Matrix r8, Path r10) {
            Matrix r11 = this.f245a;
            r8.invert(r11);
            r10.transform(r11);
            RectF r12 = f236h;
            r12.set(this.f237b, this.f238c, this.f239d, this.f240e);
            r10.arcTo(r12, this.f241f, this.f242g, false);
            r10.transform(r8);
        }
    }

    public static class d extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f243b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f244c;

        @Override // aa.m.e
        public final void a(Matrix r8, Path r10) {
            Matrix r11 = this.f245a;
            r8.invert(r11);
            r10.transform(r11);
            r10.lineTo(this.f243b, this.f244c);
            r10.transform(r8);
        }
    }

    public static abstract class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Matrix f245a;

        public e() {
            this.f245a = new Matrix();
        }

        public abstract void a(Matrix r8, Path r10);
    }

    public static abstract class f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Matrix f246b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Matrix f247a;

        static {
            f246b = new Matrix();
        }

        public f() {
            this.f247a = new Matrix();
        }

        public abstract void a(Matrix r8, z9.a r10, int r11, Canvas r12);
    }

    public m() {
        this.f230g = new ArrayList();
        this.f231h = new ArrayList();
        e(0.0f, 270.0f, 0.0f);
    }

    public final void a(float r8, float r10, float r11, float r12, float r13, float r14) {
        c r15 = new c(r8, r10, r11, r12);
        r15.f241f = r13;
        r15.f242g = r14;
        this.f230g.add(r15);
        a r16 = new a(r15);
        float r17 = r13 + r14;
        if (r14 >= 0.0f) goto L5;
        boolean r18 = true;
    L7:
        if (r18 == false) goto L9;
        r13 = (r13 + 180.0f) % 360.0f;
    L9:
        if (r18 == false) goto L11;
        float r19 = (180.0f + r17) % 360.0f;
    L12:
        b(r13);
        this.f231h.add(r16);
        this.f228e = r19;
        double r20 = r17;
        this.f226c = (((r11 - r8) / 2.0f) * ((float) Math.cos(Math.toRadians(r20)))) + ((r8 + r11) * 0.5f);
        this.f227d = (((r12 - r10) / 2.0f) * ((float) Math.sin(Math.toRadians(r20)))) + ((r10 + r12) * 0.5f);
        return;
    L11:
        r19 = r17;
        goto L12
    L5:
        r18 = false;
        goto L7
    }

    public final void b(float r8) {
        float r10 = this.f228e;
        if (r10 != r8) goto L5;
        return;
    L5:
        float r11 = ((r8 - r10) + 360.0f) % 360.0f;
        if (r11 <= 180.0f) goto L8;
        return;
    L8:
        float r12 = this.f226c;
        float r13 = this.f227d;
        c r14 = new c(r12, r13, r12, r13);
        r14.f241f = this.f228e;
        r14.f242g = r11;
        this.f231h.add(new a(r14));
        this.f228e = r8;
    }

    public final void c(Matrix r8, Path r10) {
        ArrayList r11 = this.f230g;
        int r12 = r11.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        ((e) r11.get(r13)).a(r8, r10);
        r13 = r13 + 1;
        goto L3
    }

    public final void d(float r8, float r10) {
        d r11 = new d();
        r11.f243b = r8;
        r11.f244c = r10;
        this.f230g.add(r11);
        b r12 = new b(r11, this.f226c, this.f227d);
        float r13 = r12.b() + 270.0f;
        float r14 = r12.b() + 270.0f;
        b(r13);
        this.f231h.add(r12);
        this.f228e = r14;
        this.f226c = r8;
        this.f227d = r10;
    }

    public final void e(float r8, float r10, float r11) {
        this.f224a = 0.0f;
        this.f225b = r8;
        this.f226c = 0.0f;
        this.f227d = r8;
        this.f228e = r10;
        this.f229f = (r10 + r11) % 360.0f;
        this.f230g.clear();
        this.f231h.clear();
    }
}
