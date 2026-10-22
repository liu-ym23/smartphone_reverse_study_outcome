package u6a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.FloatEvaluator;
import android.animation.ValueAnimator;
import android.util.SparseArray;
import com.larus.voice_setting.voice.base.VoiceDisplayScene;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIShadowProxy;
import com.lynx.tasm.behavior.ui.utils.m;
import com.lynx.tasm.event.LynxTouchEvent;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public int a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    public boolean f;
    public final LynxBaseUI g;
    public final HashMap<Integer, Animator> h;
    public final HashMap<Integer, Animator> i;
    public SparseArray<s6a.a> j;

    /* JADX INFO: renamed from: u6a.a$a, reason: collision with other inner class name */
    public class C0114a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ LynxBaseUI a;

        public C0114a(LynxBaseUI r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Object r3 = r2.getAnimatedValue();
            if (r3 == null) goto L8;
            int r4 = ((Integer) r3).intValue();
            this.a.setTop(r4);
            LynxUI r5 = (LynxUI) this.a;
            if ((r5.getParent() instanceof UIShadowProxy) == false) goto L9;
            ((UIShadowProxy) r5.getParent()).N();
            return;
        L9:
            return;
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ LynxBaseUI a;

        public b(LynxBaseUI r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Object r3 = r2.getAnimatedValue();
            if (r3 == null) goto L8;
            int r4 = ((Integer) r3).intValue();
            this.a.setWidth(r4);
            LynxUI r5 = (LynxUI) this.a;
            if ((r5.getParent() instanceof UIShadowProxy) == false) goto L9;
            ((UIShadowProxy) r5.getParent()).N();
            return;
        L9:
            return;
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ LynxBaseUI a;

        public c(LynxBaseUI r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Object r3 = r2.getAnimatedValue();
            if (r3 == null) goto L8;
            int r4 = ((Integer) r3).intValue();
            this.a.setHeight(r4);
            LynxUI r5 = (LynxUI) this.a;
            if ((r5.getParent() instanceof UIShadowProxy) == false) goto L9;
            ((UIShadowProxy) r5.getParent()).N();
            return;
        L9:
            return;
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ LynxBaseUI a;

        public d(LynxBaseUI r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Object r3 = r2.getAnimatedValue();
            if (r3 == null) goto L8;
            int r4 = ((Integer) r3).intValue();
            this.a.setLeft(r4);
            LynxUI r5 = (LynxUI) this.a;
            if ((r5.getParent() instanceof UIShadowProxy) == false) goto L9;
            ((UIShadowProxy) r5.getParent()).N();
            return;
        L9:
            return;
        }
    }

    public static class e extends g {
        public final WeakReference<a> d;
        public final boolean e;

        @Override // u6a.a.g, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r22) {
            if (this.e == false) goto L5;
            super.onAnimationEnd(r22);
        L5:
            a r1 = this.d.get();
            LynxBaseUI r3 = this.a.get();
            if (r3 == null) goto L30;
            if (r1 == null) goto L31;
            r1.h.remove(Integer.valueOf(this.b));
            int r2 = r3.getOriginLeft();
            int r4 = r3.getOriginTop();
            int r5 = r3.getWidth();
            int r6 = r3.getHeight();
            int r7 = this.b;
            if (r7 != 16) goto L12;
            int r8 = r6;
            int r9 = r1.c;
        L23:
            int r10 = r2;
        L28:
            r3.updateLayout(r10, r4, r9, r8, r3.getPaddingLeft(), r3.getPaddingTop(), r3.getPaddingRight(), r3.getPaddingBottom(), r3.getMarginLeft(), r3.getMarginTop(), r3.getMarginRight(), r3.getMarginBottom(), r3.getBorderLeftWidth(), r3.getBorderTopWidth(), r3.getBorderRightWidth(), r3.getBorderBottomWidth(), r3.getBound());
            return;
        L12:
            if (r7 != 32) goto L14;
            r8 = r1.d;
        L22:
            r9 = r5;
            goto L23
        L14:
            if (r7 != 256) goto L16;
        L25:
            r8 = r6;
            r9 = r5;
            r4 = r4;
            r10 = r1.a;
            goto L28
        L16:
            if (r7 != 512) goto L18;
        L24:
            r10 = r2;
            r8 = r6;
            r9 = r5;
            r4 = r1.b;
            goto L28
        L18:
            if (r7 == 1024) goto L25;
            if (r7 == 2048) goto L24;
            r8 = r6;
            goto L22
        L31:
            return;
        }

        @Override // u6a.a.g, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            if (this.e == false) goto L6;
            super.onAnimationStart(r2);
            return;
        }

        public e(LynxBaseUI r1, int r2, a r3, boolean r4) {
            super(r1, r2);
            this.e = true;
            this.d = new WeakReference(r3);
            this.e = r4;
        }
    }

    public static class f extends AnimatorListenerAdapter {
        public f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1) {
            super.onAnimationStart(r1);
            r1.cancel();
        }
    }

    public static class g extends AnimatorListenerAdapter {
        public static final Map<String, Object> c = null;
        public final WeakReference<LynxBaseUI> a;
        public final int b;

        static {
            HashMap r0 = new HashMap();
            c = r0;
            r0.put("animation_type", "transition");
        }

        public final void a(String r7) {
            LynxBaseUI r0 = this.a.get();
            if (r0 != null) goto L6;
            return;
        L6:
            if ((r0 instanceof UIShadowProxy) == false) goto L9;
            r0 = ((UIShadowProxy) r0).a;
        L9:
            if (r0.getEvents() != null) goto L11;
            return;
        L11:
            if (r0.getEvents().containsKey(r7) == false) goto L34;
            Map<String, Object> r1 = c;
            int r2 = this.b;
            if (r2 != 1) goto L15;
            String r3 = "opacity";
        L31:
            ((HashMap) r1).put("animation_type", "transition-".concat(r3));
            r0.getLynxContext().getEventEmitter().sendCustomEvent(new com.lynx.tasm.event.a(r0.getSign(), r7, r1));
            return;
        L15:
            if (r2 == 2) goto L29;
            switch(r2) {
                case 4: goto L28;
                case 8: goto L27;
                case 16: goto L26;
                case 32: goto L25;
                case 64: goto L24;
                case 128: goto L23;
                case 256: goto L22;
                case 512: goto L21;
                case 1024: goto L20;
                case 2048: goto L19;
                case 4096: goto L18;
                default: goto L17;
            };
        L17:
            LLog.DTHROW(new IllegalArgumentException("Unsupported animated property: " + r2));
            r3 = VoiceDisplayScene.NONE;
            goto L31
        L18:
            r3 = "transform";
            goto L31
        L19:
            r3 = "bottom";
            goto L31
        L20:
            r3 = "right";
            goto L31
        L21:
            r3 = "top";
            goto L31
        L22:
            r3 = "left";
            goto L31
        L23:
            r3 = "visibility";
            goto L31
        L24:
            r3 = "background-color";
            goto L31
        L25:
            r3 = "height";
            goto L31
        L26:
            r3 = "width";
            goto L31
        L27:
            r3 = "scaleXY";
            goto L31
        L28:
            r3 = "scaleY";
            goto L31
        L29:
            r3 = "scaleX";
            goto L31
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r1) {
            super.onAnimationEnd(r1);
            a("transitionend");
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
            super.onAnimationRepeat(r1);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r1) {
            super.onAnimationStart(r1);
            a("transitionstart");
        }

        public g(LynxBaseUI r2, int r3) {
            this.a = new WeakReference(r2);
            this.b = r3;
        }
    }

    public final void e() {
        Iterator r0 = ((HashMap) this.h.clone()).values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Animator) r0.next()).cancel();
        goto L4
    L6:
        this.h.clear();
        this.i.clear();
    }

    public a(LynxUI r2) {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.j = new SparseArray();
        this.g = r2;
        this.h = new HashMap();
        this.i = new HashMap();
    }

    public final boolean b(int r2) {
        if (this.j.size() != 0) goto L5;
    L7:
        return false;
    L5:
        if (this.j.get(r2) == null) goto L7;
        return true;
    }

    public final boolean c(int r2) {
        if (this.j.indexOfKey(r2) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void f(Integer r2) {
        Animator r0 = this.h.get(r2);
        if (r0 == null) goto L6;
        r0.cancel();
        this.h.remove(r2);
        return;
    }

    public final void a(LynxBaseUI r21, int r22, Object r23) {
        if (this.j.size() != 0) goto L5;
        return;
    L5:
        if (this.j.get(r22) == null) goto L60;
        LynxBaseUI r0 = this.g;
        if (r0 == null) goto L10;
        LynxBaseUI r6 = r0;
    L11:
        s6a.a r1 = this.j.get(r22);
        float r2 = 1.0f;
        if (r22 == 1) goto L52;
        if (r22 != 64) goto L16;
        int r9 = ((Integer) r23).intValue();
        ValueAnimator r8 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(r6.getLynxBackground().e), Integer.valueOf(r9)});
        this.i.put(64, r8);
        r8.setDuration(Math.round(r1.b));
        r8.setInterpolator(s6a.b.a(r1));
        r8.setStartDelay(r1.c);
        r8.addListener(new u6a.b(this, r6, r22, r6, r9));
        r8.addUpdateListener(new u6a.c(r6));
        return;
    L16:
        if (r22 == 128) goto L28;
        if (r22 == 4096) goto L21;
        return;
    L21:
        if ((r6 instanceof LynxUI) == false) goto L62;
        LynxUI r12 = (LynxUI) r6;
        r12.getLynxContext().getUIBody().getFontSize();
        r12.getFontSize();
        r12.getLynxContext().getUIBody().getLatestWidth();
        r12.getLynxContext().getUIBody().getLatestHeight();
        m r11 = m.k((List) r23, r12.getLatestWidth(), r12.getLatestHeight());
        if (r11 == null) goto L63;
        float r10 = r12.getTranslationX();
        float r13 = r12.getTranslationY();
        float r14 = r12.getView().getTranslationZ();
        float r15 = r12.getView().getRotation();
        float r16 = r12.getView().getRotationX();
        float r17 = r12.getView().getRotationY();
        float r18 = r12.getView().getScaleX();
        float r19 = r12.getView().getScaleY();
        ValueAnimator r7 = ValueAnimator.ofInt(new int[]{0});
        this.i.put(4096, r7);
        r7.setDuration(r1.b);
        r7.setInterpolator(s6a.b.a(r1));
        r7.setStartDelay(r1.c);
        r7.addListener(new u6a.d(this, r12, r22, r12, r11));
        r7.addUpdateListener(new u6a.e(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19));
        return;
    L63:
        return;
    L62:
        return;
    L28:
        if (this.f == false) goto L31;
        return;
    L31:
        if ((r6.getParent() instanceof UIShadowProxy) == false) goto L33;
        LynxUI r5 = (LynxUI) r6.getParent();
    L34:
        int r110 = ((Integer) r23).intValue();
        int r111 = r5.getView().getVisibility();
        if (r110 != 1) goto L37;
        int r112 = 0;
    L38:
        if (r111 == r112) goto L65;
        this.e = true;
        float r113 = r5.getView().getAlpha();
        float r114 = 0.0f;
        if (r111 != 0) goto L43;
        r114 = r113;
        r2 = 0.0f;
    L49:
        ValueAnimator r20 = ValueAnimator.ofObject(new FloatEvaluator(), new Object[]{Float.valueOf(r114), Float.valueOf(r2)});
        r20.setDuration(r1.b);
        r20.setInterpolator(s6a.b.a(r1));
        r20.setStartDelay(r1.c);
        r20.addUpdateListener(new h(r5));
        r20.addListener(new i(this, r6, r22, r5, r112, r113));
        this.i.put(Integer.valueOf(LynxTouchEvent.kPseudoStateFocusTransition), r20);
        return;
    L43:
        if (r111 != 4) goto L45;
    L46:
        if (r112 != 0) goto L48;
        r5.getView().setAlpha(0.0f);
    L48:
        r114 = r113;
        goto L49
    L45:
        if (r111 != 8) goto L48;
    L65:
        return;
    L37:
        r112 = 4;
        goto L38
    L33:
        r5 = (LynxUI) r6;
        goto L34
    L52:
        if (this.e == true) goto L66;
        float r24 = Math.min(((Float) r23).floatValue(), 1.0f);
        LynxUI r25 = (LynxUI) r6;
        ValueAnimator r26 = ValueAnimator.ofObject(new FloatEvaluator(), new Object[]{Float.valueOf(r25.getView().getAlpha()), Float.valueOf(r24)});
        this.i.put(1, r26);
        r26.setDuration(r1.b);
        r26.setInterpolator(s6a.b.a(r1));
        r26.setStartDelay(r1.c);
        r26.addListener(new u6a.f(this, r25, r22, r25, r24));
        r26.addUpdateListener(new u6a.g(r25));
        this.f = true;
        return;
    L66:
        return;
    L10:
        r6 = r21;
        goto L11
    }

    public final ValueAnimator d(int r3, LynxBaseUI r4, int r5, int r6, s6a.a r7, boolean r8) {
        ValueAnimator r9 = ValueAnimator.ofInt(new int[]{r5, r6});
        r9.setDuration(r7.b);
        r9.setInterpolator(s6a.b.a(r7));
        r9.setStartDelay(r7.c);
        r9.addListener(new e(r4, r3, this, r8));
        if (r3 != 16) goto L5;
        r9.addUpdateListener(new b(r4));
    L19:
        return r9;
    L5:
        if (r3 != 32) goto L7;
        r9.addUpdateListener(new c(r4));
        goto L19
    L7:
        if (r3 != 256) goto L9;
    L16:
        r9.addUpdateListener(new d(r4));
        goto L19
    L9:
        if (r3 != 512) goto L11;
    L15:
        r9.addUpdateListener(new C0114a(r4));
        goto L19
    L11:
        if (r3 == 1024) goto L16;
        if (r3 == 2048) goto L15;
        goto L15
    }
}
