package com.obric.oui.constraintlayout.motion.a;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import com.obric.oui.constraintlayout.motion.widget.MotionLayout;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes5.dex */
public abstract class d extends com.obric.oui.constraintlayout.core.motion.a.j {

    static class a extends d {
        a() {
        }

        @Override // com.obric.oui.constraintlayout.motion.a.d
        public void a(View r1, float r2) {
            r1.setAlpha(a(r2));
        }
    }

    public static class b extends d {
        String d;
        SparseArray<ConstraintAttribute> e;
        float[] f;

        public b(String r2, SparseArray<ConstraintAttribute> r3) {
            this.d = r2.split(",")[1];
            this.e = r3;
        }

        @Override // com.obric.oui.constraintlayout.core.motion.a.j
        public void a(int r13) {
            int r0 = this.e.size();
            int r1 = ((ConstraintAttribute) ZeusTransformUtils.preCheckCast(this.e.valueAt(0), ConstraintAttribute.class, "com.obric.memorydata.plugin")).c();
            double[] r3 = new double[r0];
            this.f = new float[r1];
            double[][] r2 = (double[][]) Array.newInstance(double.class, new int[]{r0, r1});
            int r5 = 0;
        L3:
            if (r5 >= r0) goto L9;
            int r6 = this.e.keyAt(r5);
            ConstraintAttribute r7 = (ConstraintAttribute) ZeusTransformUtils.preCheckCast(this.e.valueAt(r5), ConstraintAttribute.class, "com.obric.memorydata.plugin");
            r3[r5] = ((double) r6) * 0.01d;
            r7.a(this.f);
            int r8 = 0;
        L5:
            float[] r9 = this.f;
            if (r8 >= r9.length) goto L8;
            r2[r5][r8] = r9[r8];
            r8 = r8 + 1;
            goto L5
        L8:
            r5 = r5 + 1;
            goto L3
        L9:
            this.f13581a = com.obric.oui.constraintlayout.core.motion.a.b.a(r13, r3, r2);
        }

        @Override // com.obric.oui.constraintlayout.core.motion.a.j
        public void a(int r1, float r2) {
            throw new RuntimeException("call of custom attribute setPoint");
        }

        public void a(int r1, ConstraintAttribute r2) {
            this.e.append(r1, r2);
        }

        @Override // com.obric.oui.constraintlayout.motion.a.d
        public void a(View r4, float r5) {
            this.f13581a.a(r5, this.f);
            com.obric.oui.constraintlayout.motion.a.a.a((ConstraintAttribute) ZeusTransformUtils.preCheckCast(this.e.valueAt(0), ConstraintAttribute.class, "com.obric.memorydata.plugin"), r4, this.f);
        }
    }

    static class c extends d {
        c() {
        }

        @Override // com.obric.oui.constraintlayout.motion.a.d
        public void a(View r1, float r2) {
            r1.setElevation(a(r2));
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.motion.a.d$d, reason: collision with other inner class name */
    public static class C0739d extends d {
        public C0739d() {
        }

        @Override // com.obric.oui.constraintlayout.motion.a.d
        public void a(View r1, float r2) {
        }

        public void a(View r1, float r2, double r3, double r5) {
            r1.setRotation(a(r2) + ((float) Math.toDegrees(Math.atan2(r5, r3))));
        }
    }

    static class e extends d {
        e() {
        }

        @Override // com.obric.oui.constraintlayout.motion.a.d
        public void a(View r1, float r2) {
            r1.setPivotX(a(r2));
        }
    }

    static class f extends d {
        f() {
        }

        @Override // com.obric.oui.constraintlayout.motion.a.d
        public void a(View r1, float r2) {
            r1.setPivotY(a(r2));
        }
    }

    static class g extends d {
        boolean d;

        g() {
            this.d = false;
        }

        @Override // com.obric.oui.constraintlayout.motion.a.d
        public void a(View r10, float r11) {
            if (ZeusTransformUtils.instanceOf(r10, MotionLayout.class) == false) goto L6;
            ((MotionLayout) ZeusTransformUtils.preCheckCast(r10, MotionLayout.class, "com.obric.memorydata.plugin")).setProgress(a(r11));
            return;
        L6:
            if (this.d == false) goto L8;
            return;
        L8:
            Method r2 = null;
            r2 = r10.getClass().getMethod("setProgress", new Class[]{Float.TYPE});     // Catch: NoSuchMethodException -> L11
        L12:
            if (r2 == null) goto L23;
            r2.invoke(r10, new Object[]{Float.valueOf(a(r11))});     // Catch: Throwable -> L15
            return;
        L15:
            e = move-exception;
            Log.e("ViewSpline", "unable to setProgress", e);
            return;
        L23:
            return;
        L11:
            this.d = true;
            goto L12
        }
    }

    static class h extends d {
        h() {
        }

        @Override // com.obric.oui.constraintlayout.motion.a.d
        public void a(View r1, float r2) {
            r1.setRotation(a(r2));
        }
    }

    static class i extends d {
        i() {
        }

        @Override // com.obric.oui.constraintlayout.motion.a.d
        public void a(View r1, float r2) {
            r1.setRotationX(a(r2));
        }
    }

    static class j extends d {
        j() {
        }

        @Override // com.obric.oui.constraintlayout.motion.a.d
        public void a(View r1, float r2) {
            r1.setRotationY(a(r2));
        }
    }

    static class k extends d {
        k() {
        }

        @Override // com.obric.oui.constraintlayout.motion.a.d
        public void a(View r1, float r2) {
            r1.setScaleX(a(r2));
        }
    }

    static class l extends d {
        l() {
        }

        @Override // com.obric.oui.constraintlayout.motion.a.d
        public void a(View r1, float r2) {
            r1.setScaleY(a(r2));
        }
    }

    static class m extends d {
        m() {
        }

        @Override // com.obric.oui.constraintlayout.motion.a.d
        public void a(View r1, float r2) {
            r1.setTranslationX(a(r2));
        }
    }

    static class n extends d {
        n() {
        }

        @Override // com.obric.oui.constraintlayout.motion.a.d
        public void a(View r1, float r2) {
            r1.setTranslationY(a(r2));
        }
    }

    static class o extends d {
        o() {
        }

        @Override // com.obric.oui.constraintlayout.motion.a.d
        public void a(View r1, float r2) {
            r1.setTranslationZ(a(r2));
        }
    }

    public d() {
    }

    public static d a(String r1, SparseArray<ConstraintAttribute> r2) {
        return new b(r1, r2);
    }

    public static d b(String r2) {
        r2.hashCode();
        byte r1 = -1;
        switch(r2.hashCode()) {
            case -1249320806: goto L66;
            case -1249320805: goto L62;
            case -1225497657: goto L58;
            case -1225497656: goto L54;
            case -1225497655: goto L50;
            case -1001078227: goto L46;
            case -908189618: goto L42;
            case -908189617: goto L38;
            case -797520672: goto L34;
            case -760884510: goto L30;
            case -760884509: goto L26;
            case -40300674: goto L22;
            case -4379043: goto L18;
            case 37232917: goto L14;
            case 92909918: goto L10;
            case 156108012: goto L6;
            default: goto L69;
        };
    L69:
        switch(r1) {
            case 0: goto L103;
            case 1: goto L101;
            case 2: goto L99;
            case 3: goto L97;
            case 4: goto L95;
            case 5: goto L93;
            case 6: goto L91;
            case 7: goto L89;
            case 8: goto L87;
            case 9: goto L85;
            case 10: goto L83;
            case 11: goto L81;
            case 12: goto L79;
            case 13: goto L77;
            case 14: goto L75;
            case 15: goto L73;
            default: goto L70;
        };
    L70:
        return null;
    L73:
        return new a();
    L75:
        return new a();
    L77:
        return new C0739d();
    L79:
        return new c();
    L81:
        return new h();
    L83:
        return new f();
    L85:
        return new e();
    L87:
        return new a();
    L89:
        return new l();
    L91:
        return new k();
    L93:
        return new g();
    L95:
        return new o();
    L97:
        return new n();
    L99:
        return new m();
    L101:
        return new j();
    L103:
        return new i();
    L6:
        if (r2.equals("waveOffset") == false) goto L69;
        r1 = 15;
        goto L69
    L10:
        if (r2.equals("alpha") == false) goto L69;
        r1 = 14;
        goto L69
    L14:
        if (r2.equals("transitionPathRotate") == false) goto L69;
        r1 = 13;
        goto L69
    L18:
        if (r2.equals("elevation") == false) goto L69;
        r1 = 12;
        goto L69
    L22:
        if (r2.equals(Key.ROTATION) == false) goto L69;
        r1 = 11;
        goto L69
    L26:
        if (r2.equals(Key.PIVOT_Y) == false) goto L69;
        r1 = 10;
        goto L69
    L30:
        if (r2.equals(Key.PIVOT_X) == false) goto L69;
        r1 = 9;
        goto L69
    L34:
        if (r2.equals(Key.WAVE_VARIES_BY) == false) goto L69;
        r1 = 8;
        goto L69
    L38:
        if (r2.equals("scaleY") == false) goto L69;
        r1 = 7;
        goto L69
    L42:
        if (r2.equals("scaleX") == false) goto L69;
        r1 = 6;
        goto L69
    L46:
        if (r2.equals("progress") == false) goto L69;
        r1 = 5;
        goto L69
    L50:
        if (r2.equals("translationZ") == false) goto L69;
        r1 = 4;
        goto L69
    L54:
        if (r2.equals("translationY") == false) goto L69;
        r1 = 3;
        goto L69
    L58:
        if (r2.equals("translationX") == false) goto L69;
        r1 = 2;
        goto L69
    L62:
        if (r2.equals("rotationY") == false) goto L69;
        r1 = 1;
        goto L69
    L66:
        if (r2.equals("rotationX") == false) goto L69;
        r1 = 0;
        goto L69
    }

    public abstract void a(View r1, float r2);
}
