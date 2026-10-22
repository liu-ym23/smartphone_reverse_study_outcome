package com.obric.oui.constraintlayout.motion.a;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import com.obric.oui.constraintlayout.motion.widget.MotionLayout;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes5.dex */
public abstract class c extends com.obric.oui.constraintlayout.core.motion.a.e {

    static class a extends c {
        a() {
        }

        @Override // com.obric.oui.constraintlayout.motion.a.c
        public void a(View r1, float r2) {
            r1.setAlpha(a(r2));
        }
    }

    static class b extends c {
        float[] c;
        protected ConstraintAttribute d;

        b() {
            this.c = new float[1];
        }

        @Override // com.obric.oui.constraintlayout.motion.a.c
        public void a(View r3, float r4) {
            this.c[0] = a(r4);
            com.obric.oui.constraintlayout.motion.a.a.a(this.d, r3, this.c);
        }

        @Override // com.obric.oui.constraintlayout.core.motion.a.e
        public void a(Object r3) {
            this.d = (ConstraintAttribute) ZeusTransformUtils.preCheckCast(r3, ConstraintAttribute.class, "com.obric.memorydata.plugin");
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.motion.a.c$c, reason: collision with other inner class name */
    static class C0738c extends c {
        C0738c() {
        }

        @Override // com.obric.oui.constraintlayout.motion.a.c
        public void a(View r1, float r2) {
            r1.setElevation(a(r2));
        }
    }

    public static class d extends c {
        public d() {
        }

        @Override // com.obric.oui.constraintlayout.motion.a.c
        public void a(View r1, float r2) {
        }

        public void a(View r1, float r2, double r3, double r5) {
            r1.setRotation(a(r2) + ((float) Math.toDegrees(Math.atan2(r5, r3))));
        }
    }

    static class e extends c {
        boolean c;

        e() {
            this.c = false;
        }

        @Override // com.obric.oui.constraintlayout.motion.a.c
        public void a(View r10, float r11) {
            if (ZeusTransformUtils.instanceOf(r10, MotionLayout.class) == false) goto L6;
            ((MotionLayout) ZeusTransformUtils.preCheckCast(r10, MotionLayout.class, "com.obric.memorydata.plugin")).setProgress(a(r11));
            return;
        L6:
            if (this.c == false) goto L8;
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
            Log.e("ViewOscillator", "unable to setProgress", e);
            return;
        L23:
            return;
        L11:
            this.c = true;
            goto L12
        }
    }

    static class f extends c {
        f() {
        }

        @Override // com.obric.oui.constraintlayout.motion.a.c
        public void a(View r1, float r2) {
            r1.setRotation(a(r2));
        }
    }

    static class g extends c {
        g() {
        }

        @Override // com.obric.oui.constraintlayout.motion.a.c
        public void a(View r1, float r2) {
            r1.setRotationX(a(r2));
        }
    }

    static class h extends c {
        h() {
        }

        @Override // com.obric.oui.constraintlayout.motion.a.c
        public void a(View r1, float r2) {
            r1.setRotationY(a(r2));
        }
    }

    static class i extends c {
        i() {
        }

        @Override // com.obric.oui.constraintlayout.motion.a.c
        public void a(View r1, float r2) {
            r1.setScaleX(a(r2));
        }
    }

    static class j extends c {
        j() {
        }

        @Override // com.obric.oui.constraintlayout.motion.a.c
        public void a(View r1, float r2) {
            r1.setScaleY(a(r2));
        }
    }

    static class k extends c {
        k() {
        }

        @Override // com.obric.oui.constraintlayout.motion.a.c
        public void a(View r1, float r2) {
            r1.setTranslationX(a(r2));
        }
    }

    static class l extends c {
        l() {
        }

        @Override // com.obric.oui.constraintlayout.motion.a.c
        public void a(View r1, float r2) {
            r1.setTranslationY(a(r2));
        }
    }

    static class m extends c {
        m() {
        }

        @Override // com.obric.oui.constraintlayout.motion.a.c
        public void a(View r1, float r2) {
            r1.setTranslationZ(a(r2));
        }
    }

    public c() {
    }

    public static c b(String r2) {
        if (r2.startsWith("CUSTOM") == true) goto L5;
        r2.hashCode();
        byte r0 = -1;
        switch(r2.hashCode()) {
            case -1249320806: goto L62;
            case -1249320805: goto L58;
            case -1225497657: goto L54;
            case -1225497656: goto L50;
            case -1225497655: goto L46;
            case -1001078227: goto L42;
            case -908189618: goto L38;
            case -908189617: goto L34;
            case -797520672: goto L30;
            case -40300674: goto L26;
            case -4379043: goto L22;
            case 37232917: goto L18;
            case 92909918: goto L14;
            case 156108012: goto L10;
            default: goto L65;
        };
    L65:
        switch(r0) {
            case 0: goto L95;
            case 1: goto L93;
            case 2: goto L91;
            case 3: goto L89;
            case 4: goto L87;
            case 5: goto L85;
            case 6: goto L83;
            case 7: goto L81;
            case 8: goto L79;
            case 9: goto L77;
            case 10: goto L75;
            case 11: goto L73;
            case 12: goto L71;
            case 13: goto L69;
            default: goto L66;
        };
    L66:
        return null;
    L69:
        return new a();
    L71:
        return new a();
    L73:
        return new d();
    L75:
        return new C0738c();
    L77:
        return new f();
    L79:
        return new a();
    L81:
        return new j();
    L83:
        return new i();
    L85:
        return new e();
    L87:
        return new m();
    L89:
        return new l();
    L91:
        return new k();
    L93:
        return new h();
    L95:
        return new g();
    L10:
        if (r2.equals("waveOffset") == false) goto L65;
        r0 = 13;
        goto L65
    L14:
        if (r2.equals("alpha") == false) goto L65;
        r0 = 12;
        goto L65
    L18:
        if (r2.equals("transitionPathRotate") == false) goto L65;
        r0 = 11;
        goto L65
    L22:
        if (r2.equals("elevation") == false) goto L65;
        r0 = 10;
        goto L65
    L26:
        if (r2.equals(Key.ROTATION) == false) goto L65;
        r0 = 9;
        goto L65
    L30:
        if (r2.equals(Key.WAVE_VARIES_BY) == false) goto L65;
        r0 = 8;
        goto L65
    L34:
        if (r2.equals("scaleY") == false) goto L65;
        r0 = 7;
        goto L65
    L38:
        if (r2.equals("scaleX") == false) goto L65;
        r0 = 6;
        goto L65
    L42:
        if (r2.equals("progress") == false) goto L65;
        r0 = 5;
        goto L65
    L46:
        if (r2.equals("translationZ") == false) goto L65;
        r0 = 4;
        goto L65
    L50:
        if (r2.equals("translationY") == false) goto L65;
        r0 = 3;
        goto L65
    L54:
        if (r2.equals("translationX") == false) goto L65;
        r0 = 2;
        goto L65
    L58:
        if (r2.equals("rotationY") == false) goto L65;
        r0 = 1;
        goto L65
    L62:
        if (r2.equals("rotationX") == false) goto L65;
        r0 = 0;
        goto L65
    L5:
        return new b();
    }

    public abstract void a(View r1, float r2);
}
