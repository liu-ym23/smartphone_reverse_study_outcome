package vb;

import android.view.View;
import java.util.ArrayList;
import vb.b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b<T extends b<T>> implements vb.a.b {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final C0183b f12793m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final c f12794n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final d f12795o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final e f12796p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final f f12797q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final g f12798r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final a f12799s = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f12800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f12801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f12803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final android.support.v4.media.a f12804e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f12805f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f12806g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f12807h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f12808i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f12809j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList<i> f12810k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList<j> f12811l;

    public class a extends k {
        @Override // android.support.v4.media.a
        public final float k(Object r8) {
            return ((View) r8).getAlpha();
        }

        @Override // android.support.v4.media.a
        public final void x(Object r8, float r10) {
            ((View) r8).setAlpha(r10);
        }
    }

    /* JADX INFO: renamed from: vb.b$b, reason: collision with other inner class name */
    public class C0183b extends k {
        @Override // android.support.v4.media.a
        public final float k(Object r8) {
            return ((View) r8).getTranslationY();
        }

        @Override // android.support.v4.media.a
        public final void x(Object r8, float r10) {
            ((View) r8).setTranslationY(r10);
        }
    }

    public class c extends k {
        @Override // android.support.v4.media.a
        public final float k(Object r8) {
            return ((View) r8).getScaleX();
        }

        @Override // android.support.v4.media.a
        public final void x(Object r8, float r10) {
            ((View) r8).setScaleX(r10);
        }
    }

    public class d extends k {
        @Override // android.support.v4.media.a
        public final float k(Object r8) {
            return ((View) r8).getScaleY();
        }

        @Override // android.support.v4.media.a
        public final void x(Object r8, float r10) {
            ((View) r8).setScaleY(r10);
        }
    }

    public class e extends k {
        @Override // android.support.v4.media.a
        public final float k(Object r8) {
            return ((View) r8).getRotation();
        }

        @Override // android.support.v4.media.a
        public final void x(Object r8, float r10) {
            ((View) r8).setRotation(r10);
        }
    }

    public class f extends k {
        @Override // android.support.v4.media.a
        public final float k(Object r8) {
            return ((View) r8).getRotationX();
        }

        @Override // android.support.v4.media.a
        public final void x(Object r8, float r10) {
            ((View) r8).setRotationX(r10);
        }
    }

    public class g extends k {
        @Override // android.support.v4.media.a
        public final float k(Object r8) {
            return ((View) r8).getRotationY();
        }

        @Override // android.support.v4.media.a
        public final void x(Object r8, float r10) {
            ((View) r8).setRotationY(r10);
        }
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f12812a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f12813b;
    }

    public interface i {
        void a(b r8, boolean r10);
    }

    public interface j {
        void a(b r8, float r10, float r11);
    }

    public static abstract class k extends android.support.v4.media.a {
    }

    static {
        f12793m = new C0183b();
        f12794n = new c();
        f12795o = new d();
        f12796p = new e();
        f12797q = new f();
        f12798r = new g();
        f12799s = new a();
    }

    public b(View r8) {
        C0183b r10 = f12793m;
        this.f12800a = 0.0f;
        this.f12801b = Float.MAX_VALUE;
        this.f12802c = false;
        this.f12805f = false;
        this.f12806g = Float.MAX_VALUE;
        this.f12807h = -3.4028235E38f;
        this.f12808i = 0;
        this.f12810k = new ArrayList();
        this.f12811l = new ArrayList();
        this.f12803d = r8;
        this.f12804e = r10;
        if (r10 != f12796p) goto L5;
    L19:
        float r11 = 0.1f;
    L20:
        this.f12809j = r11;
        return;
    L5:
        if (r10 == f12797q) goto L19;
        if (r10 == f12798r) goto L19;
        if (r10 != f12799s) goto L13;
    L18:
        r11 = 0.00390625f;
        goto L20
    L13:
        if (r10 == f12794n) goto L18;
        if (r10 == f12795o) goto L18;
        r11 = 1.0f;
        goto L20
    }

    public final void a(float r8) {
        this.f12804e.x(this.f12803d, r8);
        int r10 = 0;
    L3:
        ArrayList<j> r11 = this.f12811l;
        if (r10 >= r11.size()) goto L9;
        if (r11.get(r10) == null) goto L8;
        r11.get(r10).a(this, this.f12801b, this.f12800a);
    L8:
        r10 = r10 + 1;
        goto L3
    L9:
        int r12 = r11.size();
    L10:
        r12 = r12 - 1;
        if (r12 < 0) goto L15;
        if (r11.get(r12) != null) goto L10;
        r11.remove(r12);
        goto L10
    }

    @Override // vb.a.b
    public final boolean doAnimationFrame(long r19) {
        long r8 = this.f12808i;
        if (r8 != 0) goto L6;
        this.f12808i = r19;
        a(this.f12801b);
        return false;
    L6:
        long r10 = r19 - r8;
        this.f12808i = r19;
        vb.c r11 = (vb.c) this;
        if (r11.f12816v == false) goto L12;
        float r12 = r11.f12815u;
        if (r12 == Float.MAX_VALUE) goto L11;
        r11.f12814t.f12825i = r12;
        r11.f12815u = Float.MAX_VALUE;
    L11:
        r11.f12801b = (float) r11.f12814t.f12825i;
        r11.f12800a = 0.0f;
        r11.f12816v = false;
    L24:
        boolean r13 = true;
    L26:
        float r14 = Math.min(this.f12801b, this.f12806g);
        this.f12801b = r14;
        float r15 = Math.max(r14, this.f12807h);
        this.f12801b = r15;
        a(r15);
        if (r13 == false) goto L47;
        this.f12805f = false;
        ThreadLocal<vb.a> r16 = vb.a.f12782f;
        if (r16.get() != null) goto L31;
        r16.set(new vb.a());
    L31:
        vb.a r17 = r16.get();
        r17.f12783a.remove(this);
        ArrayList<vb.a.b> r18 = r17.f12784b;
        int r20 = r18.indexOf(this);
        if (r20 < 0) goto L34;
        r18.set(r20, null);
        r17.f12787e = true;
    L34:
        this.f12808i = 0;
        this.f12802c = false;
        int r21 = 0;
    L35:
        ArrayList<i> r22 = this.f12810k;
        if (r21 >= r22.size()) goto L41;
        if (r22.get(r21) == null) goto L40;
        r22.get(r21).a(this, false);
    L40:
        r21 = r21 + 1;
        goto L35
    L41:
        int r23 = r22.size();
    L42:
        r23 = r23 - 1;
        if (r23 < 0) goto L47;
        if (r22.get(r23) != null) goto L42;
        r22.remove(r23);
    L47:
        return r13;
    L12:
        float r24 = r11.f12815u;
        vb.d r110 = r11.f12814t;
        if (r24 == Float.MAX_VALUE) goto L15;
        double r111 = r110.f12825i;
        r10 = r10 / 2;
        h r25 = r110.a(r11.f12801b, r11.f12800a, r10);
        r110 = r11.f12814t;
        r110.f12825i = r11.f12815u;
        r11.f12815u = Float.MAX_VALUE;
        double r112 = r25.f12812a;
        float r26 = r25.f12813b;
    L16:
        h r27 = r110.a(r112, r26, r10);
        float r28 = r27.f12812a;
        r11.f12801b = r28;
        r11.f12800a = r27.f12813b;
        float r29 = Math.max(r28, r11.f12807h);
        r11.f12801b = r29;
        float r30 = Math.min(r29, r11.f12806g);
        r11.f12801b = r30;
        float r31 = r11.f12800a;
        vb.d r32 = r11.f12814t;
        r32.getClass();
        if (Math.abs(r31) < r32.f12821e) goto L19;
    L21:
        boolean r33 = false;
    L22:
        if (r33 == false) goto L25;
        r11.f12801b = (float) r11.f12814t.f12825i;
        r11.f12800a = 0.0f;
        goto L24
    L25:
        r13 = false;
        goto L26
    L19:
        if (Math.abs(r30 - ((float) r32.f12825i)) >= r32.f12820d) goto L21;
        r33 = true;
        goto L22
    L15:
        r112 = r11.f12801b;
        r26 = r11.f12800a;
        goto L16
    }
}
