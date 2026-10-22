package ub;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.view.View;
import ge.l;
import he.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class b<T extends View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f12568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f12569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f12570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f12571d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a<T> f12572e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public vb.b.j f12573f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final T f12574g;

    public interface a<T extends View> {
        void a(b<T> r8);

        void b(b<T> r8);
    }

    public b(T r8) {
        i.f(r8, "view");
        this.f12574g = r8;
        this.f12568a = new ArrayList();
        this.f12569b = new LinkedHashMap();
        this.f12570c = 0.5f;
        this.f12571d = 1500.0f;
    }

    public static void a(b r8, l r10, l r11, l r12, int r13) {
        if ((r13 & 1) == 0) goto L6;
        r10 = e.f12579a;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = f.f12580a;
    L9:
        if ((r13 & 4) == 0) goto L11;
        r12 = g.f12581a;
    L11:
        i.f(r10, "onStart");
        i.f(r11, "onCancel");
        i.f(r12, "onEnd");
        r8.f12572e = new h(r10, r11, r12);
    }

    public final void b() {
        ArrayList r8 = this.f12568a;
        if (r8.isEmpty() == true) goto L73;
        List r10 = yd.i.n1(r8);
        r8.clear();
        a<T> r11 = this.f12572e;
        if (r11 == null) goto L8;
        r11.b(this);
    L8:
        Iterator r12 = r10.iterator();
    L10:
        if (r12.hasNext() == false) goto L91;
        f9.a r13 = (f9.a) r12.next();
        ub.a r14 = r13.f7356b;
        r14.getClass();
        vb.c r15 = r13.f7355a;
        i.f(r15, "animation");
        r15.f12807h = r14.f12560c;
        r15.f12806g = Float.MAX_VALUE;
        if (r14.f12558a == false) goto L15;
        r15.f12801b = r14.f12559b;
        r15.f12802c = true;
    L15:
        if (r15.f12814t != null) goto L17;
        r15.f12814t = new vb.d();
    L17:
        vb.d r16 = r15.f12814t;
        i.e(r16, "animation.spring");
        if (r14.f12561d == false) goto L20;
        float r17 = r14.f12563f;
    L22:
        if (r17 < 0.0f) goto L72;
        r16.f12818b = r17;
        r16.f12819c = false;
        vb.d r18 = r15.f12814t;
        i.e(r18, "animation.spring");
        if (r14.f12564g == false) goto L26;
        float r19 = r14.f12566i;
    L28:
        if (r19 <= 0.0f) goto L70;
        r18.f12817a = Math.sqrt(r19);
        r18.f12819c = false;
        vb.d r20 = r15.f12814t;
        i.e(r20, "animation.spring");
        r20.f12825i = r14.f12567j;
        vb.d r21 = r15.f12814t;
        if (r21 == null) goto L68;
        double r22 = (float) r21.f12825i;
        if (r22 > r15.f12806g) goto L66;
        if (r22 < r15.f12807h) goto L64;
        double r23 = Math.abs(r15.f12809j * 0.75f);
        r21.f12820d = r23;
        r21.f12821e = r23 * 62.5d;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L61;
        boolean r24 = r15.f12805f;
        if (r24 == true) goto L10;
        if (r24 == true) goto L10;
        r15.f12805f = true;
        if (r15.f12802c == true) goto L43;
        r15.f12801b = r15.f12804e.k(r15.f12803d);
    L43:
        float r25 = r15.f12801b;
        if (r25 > r15.f12806g) goto L60;
        if (r25 < r15.f12807h) goto L60;
        ThreadLocal<vb.a> r26 = vb.a.f12782f;
        if (r26.get() != null) goto L50;
        r26.set(new vb.a());
    L50:
        vb.a r27 = r26.get();
        ArrayList<vb.a.b> r28 = r27.f12784b;
        if (r28.size() != 0) goto L57;
        if (r27.f12786d != null) goto L55;
        r27.f12786d = new vb.a.d(r27.f12785c);
    L55:
        vb.a.d r29 = r27.f12786d;
        r29.f12790b.postFrameCallback(r29.f12791c);
    L57:
        if (r28.contains(r15) == true) goto L10;
        r28.add(r15);
    L60:
        throw new IllegalArgumentException("Starting value need to be in between min value and max value");
    L61:
        Log.e("DynamicAnimation", "Current Thread Id + " + Thread.currentThread().getId() + " Main Thread Id + " + Looper.getMainLooper().getThread().getId());
        throw new AndroidRuntimeException("Animations may only be started on the main thread");
    L64:
        throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
    L66:
        throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
    L68:
        throw new UnsupportedOperationException("Incomplete com.obric.oui.animation.engine.SpringAnimation: Either final position or a spring force needs to be set.");
    L70:
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    L26:
        r19 = r14.f12565h;
        goto L28
    L72:
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    L20:
        r17 = r14.f12562e;
        goto L22
    L91:
        return;
    }

    public final void c(float r8, l r10) {
        vb.b.C0183b r11 = vb.b.f12793m;
        LinkedHashMap r12 = this.f12569b;
        vb.c r13 = (vb.c) r12.get(r11);
        if (r13 != null) goto L15;
        r13 = new vb.c(this.f12574g);
        d r14 = new d(this);
        if (r13.f12805f == true) goto L14;
        ArrayList<vb.b.j> r15 = r13.f12811l;
        if (r15.contains(r14) == true) goto L9;
        r15.add(r14);
    L9:
        c r16 = new c(this, r14);
        ArrayList<vb.b.i> r17 = r13.f12810k;
        if (r17.contains(r16) == true) goto L12;
        r17.add(r16);
    L12:
        r12.put(r11, r13);
        goto L15
    L14:
        throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
    L15:
        ub.a r18 = new ub.a(r8);
        r10.invoke(r18);
        r18.f12562e = this.f12570c;
        r18.f12565h = this.f12571d;
        this.f12568a.add(new f9.a(r13, r18));
    }
}
