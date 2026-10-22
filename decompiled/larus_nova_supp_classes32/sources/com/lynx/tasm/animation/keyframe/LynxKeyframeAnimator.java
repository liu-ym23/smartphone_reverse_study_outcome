package com.lynx.tasm.animation.keyframe;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIShadowProxy;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.behavior.ui.utils.l;
import com.lynx.tasm.behavior.ui.utils.m;
import com.lynx.tasm.behavior.ui.utils.n;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class LynxKeyframeAnimator {
    public final f a;
    public WeakReference<LynxUI> b;
    public WeakReference<View> c;
    public final HashMap<String, Object> d;
    public long e;
    public d f;
    public ObjectAnimator[] g;
    public LynxKFAnimatorState h;
    public s6a.a i;

    public static final enum LynxAnimationPropertyType extends Enum<LynxAnimationPropertyType> {
        public static final LynxAnimationPropertyType BG_COLOR = null;
        public static final LynxAnimationPropertyType OPACITY = null;
        public static final LynxAnimationPropertyType ROTATE_X = null;
        public static final LynxAnimationPropertyType ROTATE_Y = null;
        public static final LynxAnimationPropertyType ROTATE_Z = null;
        public static final LynxAnimationPropertyType SCALE_X = null;
        public static final LynxAnimationPropertyType SCALE_Y = null;
        public static final LynxAnimationPropertyType TRANSLATE_X = null;
        public static final LynxAnimationPropertyType TRANSLATE_Y = null;
        public static final LynxAnimationPropertyType TRANSLATE_Z = null;
        public static final /* synthetic */ LynxAnimationPropertyType[] a = null;

        static {
            LynxAnimationPropertyType r0 = new LynxAnimationPropertyType("TRANSLATE_X", 0);
            TRANSLATE_X = r0;
            LynxAnimationPropertyType r1 = new LynxAnimationPropertyType("TRANSLATE_Y", 1);
            TRANSLATE_Y = r1;
            LynxAnimationPropertyType r3 = new LynxAnimationPropertyType("TRANSLATE_Z", 2);
            TRANSLATE_Z = r3;
            LynxAnimationPropertyType r5 = new LynxAnimationPropertyType("ROTATE_X", 3);
            ROTATE_X = r5;
            LynxAnimationPropertyType r7 = new LynxAnimationPropertyType("ROTATE_Y", 4);
            ROTATE_Y = r7;
            LynxAnimationPropertyType r9 = new LynxAnimationPropertyType("ROTATE_Z", 5);
            ROTATE_Z = r9;
            LynxAnimationPropertyType r11 = new LynxAnimationPropertyType("SCALE_X", 6);
            SCALE_X = r11;
            LynxAnimationPropertyType r13 = new LynxAnimationPropertyType("SCALE_Y", 7);
            SCALE_Y = r13;
            LynxAnimationPropertyType r15 = new LynxAnimationPropertyType("OPACITY", 8);
            OPACITY = r15;
            LynxAnimationPropertyType r14 = new LynxAnimationPropertyType("BG_COLOR", 9);
            BG_COLOR = r14;
            a = new LynxAnimationPropertyType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
        }

        public static LynxAnimationPropertyType[] values() {
            return (LynxAnimationPropertyType[]) a.clone();
        }

        public static LynxAnimationPropertyType valueOf(String r1) {
            return (LynxAnimationPropertyType) r27.a.a(LynxAnimationPropertyType.class, r1);
        }

        public LynxAnimationPropertyType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum LynxKFAnimatorState extends Enum<LynxKFAnimatorState> {
        public static final LynxKFAnimatorState CANCELED = null;
        public static final LynxKFAnimatorState DESTROYED = null;
        public static final LynxKFAnimatorState IDLE = null;
        public static final LynxKFAnimatorState PAUSED = null;
        public static final LynxKFAnimatorState RUNNING = null;
        public static final /* synthetic */ LynxKFAnimatorState[] a = null;

        static {
            LynxKFAnimatorState r0 = new LynxKFAnimatorState("IDLE", 0);
            IDLE = r0;
            LynxKFAnimatorState r1 = new LynxKFAnimatorState("RUNNING", 1);
            RUNNING = r1;
            LynxKFAnimatorState r3 = new LynxKFAnimatorState("PAUSED", 2);
            PAUSED = r3;
            LynxKFAnimatorState r5 = new LynxKFAnimatorState("CANCELED", 3);
            CANCELED = r5;
            LynxKFAnimatorState r7 = new LynxKFAnimatorState("DESTROYED", 4);
            DESTROYED = r7;
            a = new LynxKFAnimatorState[]{r0, r1, r3, r5, r7};
        }

        public static LynxKFAnimatorState[] values() {
            return (LynxKFAnimatorState[]) a.clone();
        }

        public static LynxKFAnimatorState valueOf(String r1) {
            return (LynxKFAnimatorState) r27.a.a(LynxKFAnimatorState.class, r1);
        }

        public LynxKFAnimatorState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ LynxKeyframeAnimator a;

        public a(LynxKeyframeAnimator r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            LynxUI r3 = this.a.b.get();
            if (r3 != null) goto L5;
            return;
        L5:
            if ((r3.getParent() instanceof UIShadowProxy) == false) goto L9;
            ((UIShadowProxy) r3.getParent()).N();
            return;
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[LynxKFAnimatorState.values().length];
            a = r0;
            r0[LynxKFAnimatorState.IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            a[LynxKFAnimatorState.CANCELED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            a[LynxKFAnimatorState.PAUSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            a[LynxKFAnimatorState.RUNNING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static class c extends AnimatorListenerAdapter {
        public static final Map<String, Object> b = null;
        public final WeakReference<LynxKeyframeAnimator> a;

        static {
            HashMap r0 = new HashMap();
            b = r0;
            r0.put("animation_type", "keyframe-animation");
            r0.put("animation_name", NameKeys.UnloadStrategy_No_Strategy);
        }

        public c(LynxKeyframeAnimator r2) {
            this.a = new WeakReference(r2);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r1) {
            super.onAnimationCancel(r1);
            if (r1 == null) goto L6;
            r1.removeAllListeners();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r8) {
            super.onAnimationEnd(r8);
            LynxKeyframeAnimator r9 = this.a.get();
            if (r9 != null) goto L5;
            return;
        L5:
            s6a.a r0 = r9.i;
            if (r0 == null) goto L8;
            String r1 = r0.a;
        L9:
            LynxKFAnimatorState r2 = r9.h;
            LynxKFAnimatorState r3 = LynxKFAnimatorState.RUNNING;
            boolean r4 = false;
            if (r2 != r3) goto L12;
            boolean r5 = true;
        L13:
            if (r5 == false) goto L22;
            LynxUI r6 = r9.h();
            a(r6, "animationend", r1);
            if (r6 == null) goto L18;
            r6.onAnimationEnd(r1);
        L18:
            if (r9.h != r3) goto L20;
            boolean r7 = true;
        L21:
            LLog.DCHECK(r7);
            r9.h = LynxKFAnimatorState.IDLE;
            goto L22
        L20:
            r7 = false;
        L22:
            if (r0 == null) goto L30;
            int r10 = r0.l;
            if (r10 != 1) goto L26;
        L27:
            r4 = true;
        L28:
            if (r4 == true) goto L30;
            r9.k();
            goto L30
        L26:
            if (r10 != 3) goto L28;
        L30:
            r9.g = null;
            return;
        L12:
            r5 = false;
            goto L13
        L8:
            r1 = NameKeys.UnloadStrategy_No_Strategy;
            goto L9
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r3) {
            super.onAnimationRepeat(r3);
            LynxKeyframeAnimator r4 = this.a.get();
            if (r4 != null) goto L5;
            return;
        L5:
            s6a.a r0 = r4.i;
            if (r0 == null) goto L8;
            String r1 = r0.a;
        L9:
            a(r4.h(), "animationiteration", r1);
            return;
        L8:
            r1 = NameKeys.UnloadStrategy_No_Strategy;
            goto L9
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1) {
            super.onAnimationStart(r1);
        }

        public static void a(LynxUI r3, String r4, String r5) {
            if (r3 != null) goto L5;
            return;
        L5:
            if (r3.getEvents() != null) goto L7;
            return;
        L7:
            if (r3.getEvents().containsKey(r4) == false) goto L11;
            Map<String, Object> r0 = b;
            ((HashMap) r0).put("animation_name", r5);
            r3.getLynxContext().getEventEmitter().sendCustomEvent(new com.lynx.tasm.event.a(r3.getSign(), r4, r0));
            return;
        }
    }

    public class d {
        public final ArrayList<Keyframe> a;
        public final ArrayList<Keyframe> b;
        public final ArrayList<Keyframe> c;
        public final ArrayList<Keyframe> d;
        public final ArrayList<Keyframe> e;
        public final ArrayList<Keyframe> f;
        public final ArrayList<Keyframe> g;
        public final ArrayList<Keyframe> h;
        public final ArrayList<Keyframe> i;
        public final ArrayList<Keyframe> j;
        public boolean k;
        public final Set<LynxAnimationPropertyType> l;
        public final Set<LynxAnimationPropertyType> m;
        public PropertyValuesHolder[] n;
        public PropertyValuesHolder[] o;

        public d() {
            this.a = new ArrayList();
            this.b = new ArrayList();
            this.c = new ArrayList();
            this.d = new ArrayList();
            this.e = new ArrayList();
            this.f = new ArrayList();
            this.g = new ArrayList();
            this.h = new ArrayList();
            this.i = new ArrayList();
            this.j = new ArrayList();
            this.k = false;
            this.l = new HashSet();
            this.m = new HashSet();
        }
    }

    public interface e {
        void a(String r1);
    }

    public static class f {
        public long a;

        public f() {
            this.a = -1;
        }
    }

    public static class g extends AnimatorListenerAdapter {
        public g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1) {
            super.onAnimationStart(r1);
            r1.cancel();
        }
    }

    public final void e() {
        LynxKFAnimatorState r0 = this.h;
        if (r0 != LynxKFAnimatorState.RUNNING) goto L5;
    L7:
        ObjectAnimator[] r1 = this.g;
        if (r1 != null) goto L10;
    L14:
        this.g = null;
        this.h = LynxKFAnimatorState.CANCELED;
        return;
    L10:
        if (r1.length <= 0) goto L14;
        int r2 = r1.length;
        int r3 = 0;
    L12:
        if (r3 >= r2) goto L14;
        r1[r3].cancel();
        r3 = r3 + 1;
        goto L12
    L5:
        if (r0 == LynxKFAnimatorState.PAUSED) goto L7;
    }

    public final void f() {
        LynxKFAnimatorState r0 = this.h;
        if (r0 != LynxKFAnimatorState.CANCELED) goto L5;
    L8:
        LynxUI r1 = h();
        s6a.a r2 = this.i;
        if (r2 == null) goto L11;
        String r3 = r2.a;
    L12:
        c.a(r1, "animationcancel", r3);
    L13:
        e();
        k();
        this.h = LynxKFAnimatorState.DESTROYED;
        return;
    L11:
        r3 = NameKeys.UnloadStrategy_No_Strategy;
        goto L12
    L5:
        if (r0 == LynxKFAnimatorState.RUNNING) goto L8;
        if (r0 != LynxKFAnimatorState.PAUSED) goto L13;
        goto L8
    }

    public final LynxUI h() {
        return this.b.get();
    }

    public final void k() {
        View r0 = this.c.get();
        LynxUI r1 = h();
        if (r1 == null) goto L36;
        if (r0 == null) goto L50;
        Iterator<Map.Entry<String, Object>> r2 = this.d.entrySet().iterator();
    L8:
        if (r2.hasNext() == false) goto L51;
        Map.Entry<String, Object> r3 = r2.next();
        String r4 = r3.getKey();
        r4.getClass();
        byte r6 = -1;
        switch(r4.hashCode()) {
            case -1238332596: goto L25;
            case 63357246: goto L21;
            case 65290051: goto L17;
            case 290107061: goto L13;
            default: goto L28;
        };
    L28:
        switch(r6) {
            case 0: goto L34;
            case 1: goto L32;
            case 2: goto L31;
            case 3: goto L30;
            default: goto L8;
        };
    L30:
        r0.setBackgroundColor(((Integer) r3.getValue()).intValue());
        goto L8
    L31:
        g().setColor(((Integer) r3.getValue()).intValue());
        goto L8
    L32:
        r0.setAlpha(((Float) r3.getValue()).floatValue());
        goto L8
    L34:
        if (r1.getBackgroundManager() == null) goto L8;
        r1.getBackgroundManager().t((List) r3.getValue());
        goto L8
    L13:
        if (r4.equals("BackgroundColor") == false) goto L28;
        r6 = 3;
        goto L28
    L17:
        if (r4.equals("Color") == false) goto L28;
        r6 = 2;
        goto L28
    L21:
        if (r4.equals("Alpha") == false) goto L28;
        r6 = 1;
        goto L28
    L25:
        if (r4.equals("Transform") == false) goto L28;
        r6 = 0;
        goto L28
    L51:
        return;
    L50:
        return;
    }

    public final boolean m() {
        LynxUI r0 = this.b.get();
        d r1 = this.f;
        if (r1 != null) goto L5;
    L7:
        l r2 = h().getTransformOriginStr();
        if (r2 != null) goto L10;
    L24:
        boolean r3 = false;
    L25:
        if (r3 == false) goto L30;
        if (r0 == null) goto L30;
        if (r0.hasSizeChanged() == false) goto L30;
        return true;
    L30:
        return false;
    L10:
        if (r2.b != 1) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == false) goto L15;
    L21:
        boolean r5 = true;
    L22:
        if (r5 == false) goto L24;
    L23:
        r3 = true;
        goto L25
    L15:
        if (r2.d != 1) goto L17;
        boolean r6 = true;
    L18:
        if (r6 == true) goto L21;
        r5 = false;
        goto L22
    L17:
        r6 = false;
        goto L18
    L12:
        r4 = false;
        goto L13
    L5:
        if (r1.k == false) goto L7;
        goto L7
    }

    public final BackgroundDrawable g() {
        LynxUI r0 = h();
        if (r0 != null) goto L5;
        return null;
    L5:
        com.lynx.tasm.behavior.ui.utils.a r1 = r0.getBackgroundManager();
        if (r1 != null) goto L8;
        return null;
    L8:
        return (BackgroundDrawable) r1.b;
    }

    public final void a(s6a.a r11) {
        s6a.a r0 = this.i;
        int r1 = 0;
        boolean r2 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        LLog.DCHECK(r3);
        if (h() != null) goto L12;
        return;
    L12:
        int r4 = b.a[this.h.ordinal()];
        long r5 = 0;
        if (r4 != 1) goto L15;
    L62:
        s6a.a r6 = this.i;
        if (r6 != null) goto L65;
    L69:
        if (r1 == 0) goto L76;
        if (this.h != LynxKFAnimatorState.IDLE) goto L76;
        if (m() == true) goto L76;
        return;
    L76:
        if (r11.k >= 0) goto L78;
        return;
    L78:
        if (r11.b <= 0) goto L88;
        b(r11);
        return;
    L88:
        return;
    L65:
        if (r11.a(r6) == false) goto L69;
        if (r11.n != r6.n) goto L69;
        r1 = 1;
        goto L69
    L15:
        if (r4 == 2) goto L62;
        if (r4 != 3) goto L19;
    L21:
        s6a.a r7 = this.i;
        if (r7 != null) goto L24;
    L28:
        boolean r8 = false;
    L29:
        if (r8 == true) goto L31;
    L33:
        s6a.a r9 = this.i;
        if (r11.a(r9) == true) goto L36;
    L38:
        boolean r10 = false;
    L39:
        if (r10 == false) goto L61;
        LynxKFAnimatorState r12 = this.h;
        LynxKFAnimatorState r13 = LynxKFAnimatorState.PAUSED;
        if (r12 == r13) goto L43;
        j(r11);
        return;
    L43:
        if (r11.n != 1) goto L45;
        boolean r14 = true;
    L46:
        LLog.DCHECK(r14);
        if (this.h == r13) goto L50;
        r2 = false;
    L50:
        LLog.DCHECK(r2);
        this.h = LynxKFAnimatorState.RUNNING;
        ObjectAnimator[] r15 = this.g;
        if (r15 == null) goto L55;
        int r16 = r15.length;
    L53:
        if (r1 >= r16) goto L55;
        r15[r1].resume();
        r1 = r1 + 1;
    L55:
        long r17 = this.e;
        f r18 = this.a;
        if (r18.a == (-1)) goto L59;
        r5 = System.currentTimeMillis() - r18.a;
        r18.a = -1;
    L59:
        this.e = r17 + r5;
        this.i = r11;
        return;
    L45:
        r14 = false;
        goto L46
    L61:
        e();
        a(r11);
        return;
    L36:
        if (r11.n == r9.n) goto L38;
        r10 = true;
        goto L39
    L31:
        if (m() == true) goto L33;
        return;
    L24:
        if (r11.a(r7) == false) goto L28;
        if (r11.n != r7.n) goto L28;
        r8 = true;
        goto L29
    L19:
        if (r4 == 4) goto L21;
        return;
    L5:
        if (r11.a.equals(r0.a) == true) goto L8;
        r3 = false;
        goto L9
    }

    public final void b(s6a.a r24) {
        LynxKFAnimatorState r2 = this.h;
        int r5 = 1;
        if (r2 != LynxKFAnimatorState.IDLE) goto L5;
    L8:
        boolean r3 = true;
    L9:
        LLog.DCHECK(r3);
        View r4 = this.c.get();
        LynxUI r6 = h();
        if (r4 == null) goto L313;
        if (r6 == null) goto L314;
        if (r24 == null) goto L315;
        int r8 = 3;
        if (this.f != null) goto L17;
    L20:
        ReadableMap r7 = r6.getKeyframes(r24.a);
        if (r7 == null) goto L49;
        d r10 = new d();
        ReadableMapKeySetIterator r11 = r7.keySetIterator();
    L24:
        String r15 = "BackgroundColor";
        String r9 = "Alpha";
        if (r11.hasNextKey() == false) goto L64;
        String r12 = r11.nextKey();
        float r17 = CastFloatProtector.parseFloat(r12);
        int r13 = r24.m;
        if (r13 == r5) goto L31;
        if (r13 == r8) goto L31;
        boolean r14 = false;
    L32:
        if (r14 == false) goto L34;
        r17 = 1.0f - r17;
    L34:
        float r16 = r17;
        ReadableMap r18 = r7.getMap(r12);
        ReadableMapKeySetIterator r19 = r18.keySetIterator();
    L36:
        if (r19.hasNextKey() == false) goto L24;
        String r20 = r19.nextKey();
        if (r20.equals("opacity") == false) goto L45;
        l("Alpha", Float.valueOf(this.c.get().getAlpha()));
        d(r16, LynxAnimationPropertyType.OPACITY, r10);
        String r110 = r15;
        float r21 = (float) r18.getDouble(r20);
        if (r21 < 0.0f) goto L49;
        if (r21 > 1.0f) goto L49;
        r10.a.add(Keyframe.ofFloat(r16, r21));
    L61:
        r15 = r110;
    L62:
        r5 = 1;
        r8 = 3;
        goto L36
    L45:
        r110 = r15;
        if (r20.equals("transform") == false) goto L55;
        l("Transform", r6.getTransformRaws());
        List<n> r22 = n.d(r18.getArray(r20));
        r6.getLynxContext().getUIBody().getFontSize();
        r6.getFontSize();
        r6.getLynxContext().getUIBody().getLatestWidth();
        r6.getLynxContext().getUIBody().getLatestHeight();
        m r111 = m.k(r22, r6.getLatestWidth(), r6.getLatestHeight());
        if (r111 == null) goto L49;
        if (n.a(r22) == false) goto L53;
        r10.k = true;
    L53:
        d(r16, LynxAnimationPropertyType.TRANSLATE_X, r10);
        r10.b.add(Keyframe.ofFloat(r16, r111.h()));
        d(r16, LynxAnimationPropertyType.TRANSLATE_Y, r10);
        r10.c.add(Keyframe.ofFloat(r16, r111.i()));
        r6.getView().setOutlineProvider(null);
        d(r16, LynxAnimationPropertyType.TRANSLATE_Z, r10);
        r10.d.add(Keyframe.ofFloat(r16, r111.j()));
        d(r16, LynxAnimationPropertyType.ROTATE_Z, r10);
        r10.e.add(Keyframe.ofFloat(r16, r111.c()));
        d(r16, LynxAnimationPropertyType.ROTATE_X, r10);
        r10.f.add(Keyframe.ofFloat(r16, r111.d()));
        d(r16, LynxAnimationPropertyType.ROTATE_Y, r10);
        r10.g.add(Keyframe.ofFloat(r16, r111.e()));
        d(r16, LynxAnimationPropertyType.SCALE_X, r10);
        r10.h.add(Keyframe.ofFloat(r16, r111.f()));
        d(r16, LynxAnimationPropertyType.SCALE_Y, r10);
        r10.i.add(Keyframe.ofFloat(r16, r111.g()));
        goto L61
    L55:
        if (r20.equals("background-color") == false) goto L61;
        if (g() != null) goto L59;
        r15 = r110;
        l(r15, Integer.valueOf(r6.getBackgroundColor()));
    L60:
        d(r16, LynxAnimationPropertyType.BG_COLOR, r10);
        r10.j.add(Keyframe.ofInt(r16, r18.getInt(r20)));
        goto L62
    L59:
        r15 = r110;
        l("Color", Integer.valueOf(r6.getBackgroundColor()));
    L31:
        r14 = true;
        goto L32
    L64:
        if (g() == null) goto L66;
        int r23 = 2;
    L67:
        int r25 = 0;
    L68:
        if (r25 >= r23) goto L198;
        View r26 = this.c.get();
        LynxUI r112 = h();
        if (r26 == null) goto L188;
        if (r112 == null) goto L188;
        ArrayList r113 = new ArrayList();
        com.lynx.tasm.animation.keyframe.b r114 = new com.lynx.tasm.animation.keyframe.b();
        if (r10.a.size() == 0) goto L84;
        if (r25 != 0) goto L84;
        Set<LynxAnimationPropertyType> r27 = r10.l;
        LynxAnimationPropertyType r115 = LynxAnimationPropertyType.OPACITY;
        if (((HashSet) r27).contains(r115) == true) goto L81;
        r10.a.add(Keyframe.ofFloat(0.0f, r26.getAlpha()));
    L81:
        if (((HashSet) r10.m).contains(r115) == true) goto L83;
        r10.a.add(Keyframe.ofFloat(1.0f, r26.getAlpha()));
    L83:
        Collections.sort(r10.a, r114);
        r113.add(c(r10.a, r9));
    L86:
        if (r10.b.size() == 0) goto L96;
        if (r25 != 0) goto L96;
        Set<LynxAnimationPropertyType> r28 = r10.l;
        LynxAnimationPropertyType r29 = LynxAnimationPropertyType.TRANSLATE_X;
        if (((HashSet) r28).contains(r29) == true) goto L92;
        r10.b.add(Keyframe.ofFloat(0.0f, r26.getTranslationX()));
    L92:
        if (((HashSet) r10.m).contains(r29) == true) goto L94;
        r10.b.add(Keyframe.ofFloat(1.0f, r26.getTranslationX()));
    L94:
        Collections.sort(r10.b, r114);
        r113.add(c(r10.b, "TranslationX"));
    L96:
        if (r10.c.size() == 0) goto L106;
        if (r25 != 0) goto L106;
        Set<LynxAnimationPropertyType> r30 = r10.l;
        LynxAnimationPropertyType r31 = LynxAnimationPropertyType.TRANSLATE_Y;
        if (((HashSet) r30).contains(r31) == true) goto L102;
        r10.c.add(Keyframe.ofFloat(0.0f, r26.getTranslationY()));
    L102:
        if (((HashSet) r10.m).contains(r31) == true) goto L104;
        r10.c.add(Keyframe.ofFloat(1.0f, r26.getTranslationY()));
    L104:
        Collections.sort(r10.c, r114);
        r113.add(c(r10.c, "TranslationY"));
    L106:
        if (r10.d.size() == 0) goto L116;
        if (r25 != 0) goto L116;
        float r32 = r26.getTranslationZ();
        Set<LynxAnimationPropertyType> r33 = r10.l;
        LynxAnimationPropertyType r116 = LynxAnimationPropertyType.TRANSLATE_Z;
        if (((HashSet) r33).contains(r116) == true) goto L113;
        r10.d.add(Keyframe.ofFloat(0.0f, r32));
    L113:
        if (((HashSet) r10.m).contains(r116) == true) goto L115;
        r10.d.add(Keyframe.ofFloat(1.0f, r32));
    L115:
        Collections.sort(r10.d, r114);
        r113.add(c(r10.d, "TranslationZ"));
    L118:
        if (r10.e.size() == 0) goto L128;
        if (r25 != 0) goto L128;
        Set<LynxAnimationPropertyType> r34 = r10.l;
        LynxAnimationPropertyType r35 = LynxAnimationPropertyType.ROTATE_Z;
        if (((HashSet) r34).contains(r35) == true) goto L124;
        r10.e.add(Keyframe.ofFloat(0.0f, r26.getRotation()));
    L124:
        if (((HashSet) r10.m).contains(r35) == true) goto L126;
        r10.e.add(Keyframe.ofFloat(1.0f, r26.getRotation()));
    L126:
        Collections.sort(r10.e, r114);
        r113.add(c(r10.e, "Rotation"));
    L128:
        if (r10.f.size() == 0) goto L138;
        if (r25 != 0) goto L138;
        Set<LynxAnimationPropertyType> r36 = r10.l;
        LynxAnimationPropertyType r37 = LynxAnimationPropertyType.ROTATE_X;
        if (((HashSet) r36).contains(r37) == true) goto L134;
        r10.f.add(Keyframe.ofFloat(0.0f, r26.getRotationX()));
    L134:
        if (((HashSet) r10.m).contains(r37) == true) goto L136;
        r10.f.add(Keyframe.ofFloat(1.0f, r26.getRotationX()));
    L136:
        Collections.sort(r10.f, r114);
        r113.add(c(r10.f, "RotationX"));
    L138:
        if (r10.g.size() == 0) goto L148;
        if (r25 != 0) goto L148;
        Set<LynxAnimationPropertyType> r38 = r10.l;
        LynxAnimationPropertyType r39 = LynxAnimationPropertyType.ROTATE_Y;
        if (((HashSet) r38).contains(r39) == true) goto L144;
        r10.g.add(Keyframe.ofFloat(0.0f, r26.getRotationY()));
    L144:
        if (((HashSet) r10.m).contains(r39) == true) goto L146;
        r10.g.add(Keyframe.ofFloat(1.0f, r26.getRotationY()));
    L146:
        Collections.sort(r10.g, r114);
        r113.add(c(r10.g, "RotationY"));
    L148:
        if (r10.h.size() == 0) goto L158;
        if (r25 != 0) goto L158;
        Set<LynxAnimationPropertyType> r40 = r10.l;
        LynxAnimationPropertyType r41 = LynxAnimationPropertyType.SCALE_X;
        if (((HashSet) r40).contains(r41) == true) goto L154;
        r10.h.add(Keyframe.ofFloat(0.0f, r26.getScaleX()));
    L154:
        if (((HashSet) r10.m).contains(r41) == true) goto L156;
        r10.h.add(Keyframe.ofFloat(1.0f, r26.getScaleX()));
    L156:
        Collections.sort(r10.h, r114);
        r113.add(c(r10.h, "ScaleX"));
    L158:
        if (r10.i.size() == 0) goto L168;
        if (r25 != 0) goto L168;
        Set<LynxAnimationPropertyType> r42 = r10.l;
        LynxAnimationPropertyType r43 = LynxAnimationPropertyType.SCALE_Y;
        if (((HashSet) r42).contains(r43) == true) goto L164;
        r10.i.add(Keyframe.ofFloat(0.0f, r26.getScaleY()));
    L164:
        if (((HashSet) r10.m).contains(r43) == true) goto L166;
        r10.i.add(Keyframe.ofFloat(1.0f, r26.getScaleY()));
    L166:
        Collections.sort(r10.i, r114);
        r113.add(c(r10.i, "ScaleY"));
    L168:
        if (r10.j.size() == 0) goto L186;
        if ((r25 + 1) != r23) goto L186;
        Set<LynxAnimationPropertyType> r44 = r10.l;
        LynxAnimationPropertyType r45 = LynxAnimationPropertyType.BG_COLOR;
        if (((HashSet) r44).contains(r45) == true) goto L176;
        r10.j.add(Keyframe.ofInt(0.0f, r112.getBackgroundColor()));
    L176:
        if (((HashSet) r10.m).contains(r45) == true) goto L179;
        r10.j.add(Keyframe.ofInt(1.0f, r112.getBackgroundColor()));
    L179:
        Collections.sort(r10.j, r114);
        if (r25 != 0) goto L182;
        PropertyValuesHolder r46 = c(r10.j, "BackgroundColor");
    L183:
        r46.setEvaluator(new ArgbEvaluator());
        r113.add(r46);
        goto L186
    L182:
        r46 = c(r10.j, "Color");
    L186:
        if (r113.size() == 0) goto L189;
        PropertyValuesHolder[] r47 = (PropertyValuesHolder[]) r113.toArray(new PropertyValuesHolder[r113.size()]);
    L190:
        if (r47 == null) goto L197;
        if (r25 != 0) goto L195;
        r10.n = r47;
        goto L197
    L195:
        if (r25 != 1) goto L197;
        r10.o = r47;
    L197:
        r25 = r25 + 1;
        r4 = r4;
        r6 = r6;
        r9 = r9;
    L189:
        r47 = null;
    L116:
        r9 = r9;
    L84:
        r4 = r4;
        r6 = r6;
    L188:
        r4 = r4;
        r6 = r6;
        r9 = r9;
        goto L189
    L198:
        View r210 = r4;
        LynxUI r211 = r6;
        this.f = r10;
        boolean r48 = true;
    L199:
        if (r48 == true) goto L202;
        LLog.e("Lynx", "Keyframes input error.");
        return;
    L202:
        long r49 = this.e;
        long r50 = 0;
        if (r49 != (-1)) goto L205;
    L211:
        BackgroundDrawable r51 = g();
        if (r51 == null) goto L214;
        int r52 = 2;
    L215:
        ObjectAnimator[] r53 = new ObjectAnimator[r52];
        int r54 = 0;
        int r117 = 0;
    L216:
        if (r54 >= r52) goto L259;
        d r118 = this.f;
        if (r54 != 1) goto L220;
        PropertyValuesHolder[] r119 = r118.o;
    L221:
        if (r119 == null) goto L258;
        if (r54 != 1) goto L225;
        Object r120 = r51;
    L226:
        ObjectAnimator r121 = ObjectAnimator.ofPropertyValuesHolder(r120, r119);
        r121.addUpdateListener(new a(this));
        r53[r54] = r121;
        r121.setDuration(r24.b);
        r121.setRepeatCount(r24.k);
        int r122 = r24.m;
        if (r122 != 2) goto L229;
    L232:
        boolean r123 = true;
    L233:
        if (r123 == false) goto L235;
        r121.setRepeatMode(2);
    L236:
        r121.setInterpolator(s6a.b.a(r24));
        if (r24.c == r50) goto L247;
        int r124 = r24.l;
        if (r124 == 2) goto L243;
        if (r124 == 3) goto L243;
        boolean r125 = false;
    L244:
        if (r125 == false) goto L247;
        ObjectAnimator r126 = r121.clone();
        r126.setDuration(10000000);
        r126.addListener(new g());
        r126.start();
    L243:
        r125 = true;
    L247:
        r117 = r117 + 1;
        long r127 = r24.c;
        if (r127 < r50) goto L250;
        r121.setStartDelay(r127);
    L252:
        if (this.e == (-1)) goto L257;
        long r128 = System.currentTimeMillis() - this.e;
        long r55 = r24.c;
        if (r128 >= r55) goto L256;
        r121.setStartDelay(r55 - r128);
        goto L257
    L256:
        r121.setCurrentPlayTime(r128 - r55);
    L257:
        r121.start();
        goto L258
    L250:
        r121.setCurrentPlayTime(r127 * (-1));
        goto L252
    L235:
        r121.setRepeatMode(1);
        goto L236
    L229:
        if (r122 == 3) goto L232;
        r123 = false;
        goto L233
    L225:
        r120 = r210;
    L258:
        r54 = r54 + 1;
        r50 = 0;
        goto L216
    L220:
        r119 = r118.n;
        goto L221
    L259:
        if (r117 != 0) goto L261;
        this.g = null;
    L269:
        ObjectAnimator[] r56 = this.g;
        if (r56 == null) goto L276;
        int r57 = r56.length;
        if (r57 <= 0) goto L276;
        r56[r57 - 1].addListener(new c(this));
    L276:
        if (this.e != (-1)) goto L279;
        this.e = System.currentTimeMillis();
    L279:
        if (i(r24) == true) goto L293;
        LynxKFAnimatorState r58 = this.h;
        LynxKFAnimatorState r59 = LynxKFAnimatorState.IDLE;
        if (r58 != r59) goto L283;
        c.a(r211, "animationstart", r24.a);
    L283:
        LynxKFAnimatorState r60 = this.h;
        if (r60 != r59) goto L286;
    L289:
        boolean r61 = true;
    L290:
        LLog.DCHECK(r61);
        this.h = LynxKFAnimatorState.RUNNING;
        if (r24.n != 0) goto L293;
        j(r24);
        goto L293
    L286:
        if (r60 == LynxKFAnimatorState.CANCELED) goto L289;
        r61 = false;
    L293:
        this.i = r24;
        return;
    L261:
        if (r117 != r52) goto L263;
        this.g = r53;
        goto L269
    L263:
        this.g = new ObjectAnimator[r117];
        int r62 = 0;
        int r63 = 0;
    L264:
        if (r62 >= r52) goto L269;
        ObjectAnimator r64 = r53[r62];
        if (r64 == null) goto L268;
        this.g[r63] = r64;
        r63 = r63 + 1;
    L268:
        r62 = r62 + 1;
        goto L264
    L214:
        r52 = 1;
        goto L215
    L205:
        if (r24.n != 1) goto L211;
        f r65 = this.a;
        if (r65.a != (-1)) goto L209;
        long r66 = 0;
    L210:
        this.e = r49 + r66;
        goto L211
    L209:
        r66 = System.currentTimeMillis() - r65.a;
        r65.a = -1;
        goto L210
    L66:
        r23 = 1;
    L49:
        r210 = r4;
        r211 = r6;
        r48 = false;
        goto L199
    L17:
        if (m() == true) goto L20;
        r210 = r4;
        r211 = r6;
        goto L202
    L315:
        return;
    L314:
        return;
    L313:
        return;
    L5:
        if (r2 == LynxKFAnimatorState.CANCELED) goto L8;
        r3 = false;
        goto L9
    }

    public final boolean i(s6a.a r10) {
        if (this.e != (-1)) goto L5;
        return false;
    L5:
        int r0 = r10.k;
        if (r0 < 9.99999999E8d) goto L8;
        long r1 = Long.MAX_VALUE;
    L10:
        if ((System.currentTimeMillis() - this.e) < r1) goto L13;
        return true;
    L13:
        return false;
    L8:
        r1 = (r10.b * ((long) (r0 + 1))) + r10.c;
        goto L10
    }

    public final void j(s6a.a r7) {
        boolean r1 = true;
        int r2 = 0;
        if (r7.n != 0) goto L5;
        boolean r0 = true;
    L6:
        LLog.DCHECK(r0);
        if (this.h == LynxKFAnimatorState.RUNNING) goto L10;
        r1 = false;
    L10:
        LLog.DCHECK(r1);
        this.h = LynxKFAnimatorState.PAUSED;
        ObjectAnimator[] r3 = this.g;
        if (r3 == null) goto L16;
        int r4 = r3.length;
    L13:
        if (r2 >= r4) goto L16;
        r3[r2].pause();
        r2 = r2 + 1;
    L16:
        if (i(r7) == true) goto L20;
        f r5 = this.a;
        if (r5.a != (-1)) goto L20;
        r5.a = System.currentTimeMillis();
    L20:
        this.i = r7;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public LynxKeyframeAnimator(View r3, LynxUI r4) {
        this.a = new f();
        this.d = new HashMap();
        this.e = -1;
        this.f = null;
        this.g = null;
        this.h = LynxKFAnimatorState.IDLE;
        this.i = null;
        this.b = new WeakReference(r4);
        this.c = new WeakReference(r3);
    }

    public static PropertyValuesHolder c(ArrayList r1, String r2) {
        return PropertyValuesHolder.ofKeyframe(r2, (Keyframe[]) r1.toArray(new Keyframe[r1.size()]));
    }

    public final void l(String r2, Object r3) {
        if (this.d.containsKey(r2) == true) goto L6;
        this.d.put(r2, r3);
        return;
    }

    public static void d(float r1, LynxAnimationPropertyType r2, d r3) {
        if (r1 != 0.0f) goto L6;
        ((HashSet) r3.l).add(r2);
    L6:
        if (r1 != 1.0f) goto L9;
        ((HashSet) r3.m).add(r2);
        return;
    }
}
