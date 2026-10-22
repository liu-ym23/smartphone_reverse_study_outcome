package com.ss.ugc.live.barrage.controller;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.p;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.ugc.live.barrage.barrage.AbsBarrage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class ScrollBarrageController extends AbsBarrageController {
    public static final /* synthetic */ KProperty[] J = null;
    public AbsBarrage A;
    public final HashMap<AbsBarrage, RectF> B;
    public final HashSet<Animator> C;
    public final RectF D;
    public boolean E;
    public final RectF F;
    public boolean G;
    public final View H;
    public final h I;
    public boolean n;
    public final Lazy o;
    public b p;
    public final Deque<AbsBarrage> q;
    public final Deque<com.ss.ugc.live.barrage.barrage.d> r;
    public final com.ss.ugc.live.barrage.barrage.b s;
    public final com.ss.ugc.live.barrage.controller.f t;
    public final Random u;
    public final HashMap<Integer, AbsBarrage> v;
    public final ArrayList<Integer> w;
    public final HashMap<AbsBarrage, b> x;
    public final com.ss.ugc.live.barrage.controller.e y;
    public final RectF z;

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L5;
        L28:
            return true;
        L5:
            if ((r5 instanceof b) == false) goto L27;
            b r6 = (b) r5;
            if (this.b != r6.b) goto L9;
            boolean r1 = true;
        L10:
            if (r1 == false) goto L27;
            if (this.c != r6.c) goto L14;
            boolean r2 = true;
        L15:
            if (r2 == false) goto L27;
            if (this.d != r6.d) goto L19;
            boolean r3 = true;
        L20:
            if (r3 == false) goto L27;
            if (this.e != r6.e) goto L24;
            boolean r7 = true;
        L25:
            if (r7 == false) goto L27;
        L24:
            r7 = false;
            goto L25
        L19:
            r3 = false;
            goto L20
        L14:
            r2 = false;
            goto L15
        L9:
            r1 = false;
        L27:
            return false;
        }

        public final int hashCode() {
            return (((((this.b * 31) + this.c) * 31) + this.d) * 31) + this.e;
        }

        public final String toString() {
            return "DanmakuConfig(lineHeight=" + this.b + ", lineSpacing=" + this.c + ", displayHeight=" + this.d + ", duration=" + this.e + ")";
        }

        public b(int r2, int r3, int r4) {
            this.b = r2;
            this.c = 0;
            this.d = r3;
            this.e = r4;
            this.a = (r3 - 0) / (r2 + 0);
        }
    }

    public interface c {
        boolean a();
    }

    public interface d {
        boolean a();
    }

    public interface e {
        int[] b();

        void e();
    }

    public interface f {
        boolean c(int r1);

        void f(float r1);
    }

    public interface g {
        int[] d();
    }

    public interface h {
    }

    public static final class i extends AnimatorListenerAdapter {
        public final /* synthetic */ AbsBarrage a;
        public final /* synthetic */ RectF b;
        public final /* synthetic */ ScrollBarrageController c;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            if (r2 == null) goto L4;
            this.c.C.remove(r2);
        L4:
            this.c.B.remove(this.a);
            this.b.setEmpty();
            this.c.H.invalidate();
        }

        public i(AbsBarrage r1, RectF r2, ScrollBarrageController r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class j implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ RectF a;
        public final /* synthetic */ float b;
        public final /* synthetic */ ScrollBarrageController c;

        public j(RectF r1, float r2, ScrollBarrageController r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            Object r4 = r3.getAnimatedValue();
            if (r4 == null) goto L7;
            float r5 = ((Float) r4).floatValue();
            this.a.offsetTo(r5, this.b);
            this.c.H.invalidate();
            return;
        L7:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    static {
        J = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ScrollBarrageController.class), "danmakuLinePaint", "getDanmakuLinePaint()Landroid/graphics/Paint;"))};
    }

    @Override // com.ss.ugc.live.barrage.controller.AbsBarrageController
    public void b() {
        Iterator<Animator> r0 = this.C.iterator();     // Catch: Throwable -> L8
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().cancel();     // Catch: Throwable -> L8
        goto L4
    L6:
        this.C.clear();     // Catch: Throwable -> L8
        super.b();     // Catch: Throwable -> L8
        return;
    }

    public final Context getContext() {
        return this.H.getContext();
    }

    public final void r() {
        AbsBarrage r0 = this.A;
        if (r0 == null) goto L15;
        r0.i().setAlpha(r0.m.a);
        if (this.E == true) goto L15;
        RectF r1 = new RectF(this.z);
        this.B.put(r0, r1);
        float r2 = r1.left;
        float r3 = r1.top;
        b r4 = this.x.get(r0);
        if (r4 != null) goto L11;
        r4 = this.p;
    L11:
        if ((r0 instanceof f) == false) goto L13;
        float r5 = 0.0f;
    L14:
        ValueAnimator r6 = ValueAnimator.ofFloat(new float[]{r2, r0.f.left - r5}).setDuration(300);
        r6.addListener(new i(r0, r1, this));
        r6.addUpdateListener(new j(r1, r3, this));
        r6.start();
        this.C.add(r6);
        goto L15
    L13:
        r5 = this.I.a(r0) * (300 * (this.H.getWidth() / r4.e));
    L15:
        this.A = null;
        this.z.setEmpty();
        this.H.invalidate();
    }

    @Override // com.ss.ugc.live.barrage.controller.AbsBarrageController
    public void m() {
        p();     // Catch: Throwable -> L8
        Iterator<Animator> r0 = this.C.iterator();     // Catch: Throwable -> L8
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().cancel();     // Catch: Throwable -> L8
        goto L4
    L6:
        this.C.clear();     // Catch: Throwable -> L8
        super.m();     // Catch: Throwable -> L8
        return;
    }

    public final int t() {
        Resources r0 = getContext().getResources();
        return (int) ((6.0f * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    @Override // com.ss.ugc.live.barrage.controller.AbsBarrageController
    public void c(Canvas r5) {
        int r0 = this.a.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        AbsBarrage r2 = (AbsBarrage) ListProtector.get(this.a, r1);
        if ((!Intrinsics.areEqual(r2, this.A)) == false) goto L9;
        if (this.B.containsKey(r2) == true) goto L9;
        r2.g(r5);
    L9:
        r1 = r1 + 1;
        goto L3
    L10:
        Iterator<Map.Entry<AbsBarrage, RectF>> r3 = this.B.entrySet().iterator();
    L12:
        if (r3.hasNext() == false) goto L14;
        Map.Entry<AbsBarrage, RectF> r4 = r3.next();
        AbsBarrage r6 = r4.getKey();
        r6.f.set(r4.getValue());
        r6.g(r5);
        goto L12
    L14:
        AbsBarrage r7 = this.A;
        if (r7 == null) goto L23;
        this.D.set(r7.f);
        r7.f.set(this.z);
        r7.g(r5);
        r7.f.set(this.D);
        return;
    }

    @Override // com.ss.ugc.live.barrage.controller.AbsBarrageController
    public final void d(Canvas r17) {
        if (this.n == false) goto L7;
        float r1 = this.H.getWidth();
        b r2 = this.p;
        float r8 = r2.b;
        float r9 = r2.c;
        int r10 = r2.a;
        float r13 = r9;
        int r12 = 0;
    L5:
        if (r12 >= r10) goto L9;
        Lazy r3 = this.o;
        KProperty[] r15 = J;
        KProperty r4 = r15[0];
        r17.drawLine(0.0f, r13, r1, r13, (Paint) r3.getValue());
        float r14 = r13 + r8;
        Lazy r5 = this.o;
        KProperty r6 = r15[0];
        r17.drawLine(0.0f, r14, r1, r14, (Paint) r5.getValue());
        r13 = r14 + r9;
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.ss.ugc.live.barrage.controller.ScrollBarrageController$onTouchEvent$1] */
    @Override // com.ss.ugc.live.barrage.controller.AbsBarrageController
    public boolean k(MotionEvent r9) {
        ?? r0 = new ScrollBarrageController$onTouchEvent$1(this);
        int r1 = r9.getAction();
        if (r1 == 0) goto L31;
        if (r1 == 1) goto L22;
        if (r1 == 2) goto L10;
        if (r1 == 3) goto L10;
    L40:
        return false;
    L10:
        if (this.G == true) goto L12;
        AbsBarrage r2 = this.d;
        if (r2 == null) goto L40;
        r0.invoke(r2);
        if (this.F.contains(r9.getX(), r9.getY()) == false) goto L40;
        return r2.l(r9, this.k);
    L12:
        if (r9.getAction() != 3) goto L14;
        this.G = false;
    L14:
        return false;
    L22:
        if (this.G == false) goto L25;
        this.G = false;
        return false;
    L25:
        AbsBarrage r3 = this.d;
        if (r3 == null) goto L40;
        r0.invoke(r3);
        if (this.F.contains(r9.getX(), r9.getY()) == false) goto L40;
        return r3.l(r9, this.k);
    L31:
        ((ArrayList) this.s.a).isEmpty();
        this.G = false;
        Iterator<AbsBarrage> r4 = this.a.iterator();
    L32:
        com.ss.ugc.live.barrage.util.a.C0201a r5 = (com.ss.ugc.live.barrage.util.a.C0201a) r4;
        if (r5.hasNext() == false) goto L40;
        AbsBarrage r6 = (AbsBarrage) r5.next();
        r0.invoke(r6);
        if (this.F.contains(r9.getX(), r9.getY()) == false) goto L32;
        if (r6.l(r9, this.k) == false) goto L32;
        this.d = r6;
        return true;
    }

    public final float s(int r2) {
        AbsBarrage r3 = this.v.get(Integer.valueOf(r2));
        if (r3 == null) goto L7;
        RectF r4 = r3.f;
        if (r4 == null) goto L7;
        return r4.right;
    L7:
        return 0.0f;
    }

    public final void u(b r6) {
        if (this.H.getHeight() != r6.d) goto L5;
        int[] r0 = {Math.max((r6.a / 2) - 1, 0), r6.a / 2};
    L6:
        Iterator<T> r7 = this.r.iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        ((com.ss.ugc.live.barrage.barrage.d) r7.next()).v = r0;
        goto L8
    L10:
        return;
    L5:
        r0 = new int[]{Math.max(r6.a - 2, 0), Math.max(r6.a - 1, 0)};
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.ugc.live.barrage.controller.AbsBarrageController
    public void j(com.ss.ugc.live.barrage.util.a r19, float r20) {
        if (this.E == false) goto L5;
        return;
    L5:
        this.v.clear();
        this.w.clear();
        int r2 = this.H.getWidth();
        Iterator<AbsBarrage> r3 = r19.iterator();
    L6:
        com.ss.ugc.live.barrage.util.a.C0201a r4 = (com.ss.ugc.live.barrage.util.a.C0201a) r3;
        boolean r8 = true;
        if (r4.hasNext() == false) goto L37;
        AbsBarrage r5 = (AbsBarrage) r4.next();
        if (r5.f.right >= 0) goto L15;
        if ((!Intrinsics.areEqual(r5, this.A)) == false) goto L15;
        if (this.B.containsKey(r5) == true) goto L15;
        this.x.remove(r5);
        r4.remove();
    L15:
        int r6 = r5.c;
        if ((r5 instanceof f) == false) goto L22;
        f r7 = (f) r5;
        if (r7.c(r2) == false) goto L22;
        r7.f(r20);
        if (r5.f.right < s(r6)) goto L6;
        this.v.put(Integer.valueOf(r6), r5);
    L22:
        b r9 = this.x.get(r5);
        if (r9 != null) goto L26;
        r9 = this.p;
    L26:
        float r10 = ((r20 / r9.e) * r2) * this.I.a(r5);
        if ((r5 instanceof e) == false) goto L29;
        ((e) r5).e();
        this.I.a(r5);
    L29:
        int r11 = r9.a;
        if (r6 < 0) goto L6;
        if (r11 <= r6) goto L6;
        if (r5.f.right <= s(r6)) goto L36;
        this.v.put(Integer.valueOf(r6), r5);
    L36:
        r5.f.offset(-r10, 0.0f);
        goto L6
    L37:
        b r1 = this.p;
        int r12 = r1.b;
        int r13 = r1.c;
        int r14 = r1.a;
        int r15 = 0;
    L38:
        if (r15 >= r14) goto L68;
        AbsBarrage r16 = this.v.get(Integer.valueOf(r15));
        if ((r16 instanceof c) == false) goto L44;
        if (((c) r16).a() == false) goto L44;
        r15 = r15 + 1;
    L44:
        boolean r17 = r16 instanceof d;
        if (r17 == true) goto L47;
    L59:
        if (r17 == false) goto L64;
        if ((r16 instanceof e) == false) goto L64;
        ((e) r16).e();
    L64:
        if (s(r15) >= r2) goto L66;
        this.w.add(Integer.valueOf(r15));
    L66:
        r15 = r15 + 1;
        goto L38
    L47:
        if ((r16 instanceof e) == false) goto L59;
        e r18 = (e) r16;
        r18.e();
        if (((d) r16).a() == false) goto L59;
        int[] r110 = r18.b();
        int r111 = r110.length;
        int r112 = 0;
    L51:
        if (r112 >= r111) goto L58;
        int r113 = r110[r112];
        AbsBarrage r21 = this.v.get(Integer.valueOf(r113));
        if (r21 != null) goto L55;
    L56:
        this.v.put(Integer.valueOf(r113), r16);
    L57:
        r112 = r112 + 1;
        goto L51
    L55:
        if (r21.f.right >= r16.f.right) goto L57;
    L58:
        r15 = r15 + r18.b().length;
        goto L38
    L68:
        ArrayList<Integer> r22 = this.w;
        com.ss.ugc.live.barrage.controller.e r23 = this.y;
        r23.a = r2;
        r23.b = r14;
        Unit r24 = Unit.INSTANCE;
        Collections.sort(r22, r23);
        int r25 = this.w.size();
        int r26 = 0;
        float r27 = 0.0f;
    L69:
        if (r26 >= r25) goto L177;
        int r28 = ((Number) ListProtector.get(this.w, r26)).intValue();
        Iterator<AbsBarrage> r114 = this.q.iterator();
    L72:
        if (r114.hasNext() == false) goto L81;
        AbsBarrage r115 = r114.next();
        if ((r115 instanceof g) == false) goto L72;
        int r116 = this.p.a;
        if (ArraysKt.contains(((g) r115).d(), r28) == false) goto L72;
        if (r115.b == false) goto L72;
        r114.remove();
        int r29 = r25;
        AbsBarrage r117 = r115;
    L125:
        if (r117 == null) goto L168;
        float r30 = r117.f.width();
        boolean r31 = r117 instanceof e;
        if (r31 == false) goto L129;
        ((e) r117).e();
        float r118 = r117.f.height();
    L130:
        if (r31 == false) goto L132;
        ((e) r117).e();
        float r119 = 0.0f;
    L133:
        AbsBarrage r120 = this.v.get(Integer.valueOf(r28));
        if (r120 != null) goto L136;
        float r121 = t();
    L137:
        r27 = r27 + (r121 + this.u.nextInt(t()));
        if (r31 == false) goto L152;
        e r122 = (e) r117;
        r122.e();
        if (r122.b().length != 0) goto L142;
        boolean r123 = true;
    L144:
        if ((!r123) == false) goto L148;
        RectF r32 = r117.f;
        float r124 = r2;
        r32.left = r124;
        r32.right = r124 + r30;
        float r125 = (r119 + r13) + (r122.b()[0] * (r13 + r12));
        r32.top = r125;
        r32.bottom = r125 + r118;
        Unit r33 = Unit.INSTANCE;
        int[] r34 = r122.b();
        int r35 = r34.length;
        int r126 = 0;
    L146:
        if (r126 >= r35) goto L156;
        this.v.put(Integer.valueOf(r34[r126]), r117);
        r126 = r126 + 1;
    L156:
        r117.c = r28;
        if (r31 == false) goto L167;
        e r36 = (e) r117;
        r36.e();
        if (r36.b().length != 0) goto L161;
        boolean r37 = true;
        boolean r38 = true;
    L163:
        if ((r38 ^ r37) == false) goto L167;
        r117.c = r36.b()[0];
        goto L167
    L161:
        r37 = true;
        r38 = false;
    L167:
        this.x.put(r117, r1);
        r19.add(r117);
    L173:
        boolean r39 = false;
    L174:
        if (r39 == true) goto L227;
        r25 = r29;
        r26 = r26 + 1;
        r8 = true;
        goto L69
    L227:
        return;
    L148:
        RectF r127 = r117.f;
        float r128 = r2;
        r127.left = r128;
        r127.right = r128 + r30;
        float r129 = (r119 + r13) + ((r13 + r12) * r28);
        r127.top = r129;
        r127.bottom = r129 + r118;
        Unit r40 = Unit.INSTANCE;
        if (r12 != this.p.d) goto L151;
        float r41 = r12 * 0.5f;
        r127.top = r41 + ((r41 - r118) * 0.5f);
    L151:
        this.v.put(Integer.valueOf(r28), r117);
        goto L156
    L142:
        r123 = false;
        goto L144
    L152:
        RectF r130 = r117.f;
        float r131 = r2 + r27;
        r130.left = r131;
        r130.right = r131 + r30;
        float r132 = (r119 + r13) + ((r13 + r12) * r28);
        r130.top = r132;
        r130.bottom = r132 + r118;
        Unit r42 = Unit.INSTANCE;
        if (r12 != this.p.d) goto L155;
        float r43 = r12 * 0.5f;
        r130.top = r43 + ((r43 - r118) * 0.5f);
    L155:
        this.v.put(Integer.valueOf(r28), r117);
        goto L156
    L136:
        float r133 = r2;
        r121 = Math.max(((((((r120.f.right / r133) * r1.e) / this.I.a(r120)) / r1.e) * r133) * this.I.a(r117)) - r133, t());
        goto L137
    L132:
        r119 = (r12 - r118) / 2;
        goto L133
    L129:
        r118 = Math.min(r117.f.height(), r12);
        goto L130
    L168:
        r26 = r26;
        if (this.q.isEmpty() == false) goto L173;
        if (this.r.isEmpty() == false) goto L173;
        r39 = true;
        goto L174
    L81:
        if ((this.r.isEmpty() ^ r8) == false) goto L98;
        com.ss.ugc.live.barrage.barrage.d r134 = (com.ss.ugc.live.barrage.barrage.d) ((LinkedList) this.r).getFirst();
        if ((r134 instanceof e) == false) goto L98;
        if (ArraysKt.contains(r134.b(), r28) == false) goto L98;
        if (r134.b == false) goto L98;
        int[] r135 = r134.b();
        int r136 = r135.length;
        int r137 = 0;
        boolean r138 = true;
    L89:
        if (r137 >= r136) goto L94;
        int r210 = r25;
        if ((s(r135[r137]) + 0) <= this.H.getWidth()) goto L93;
        r138 = false;
    L93:
        r137 = r137 + 1;
        r25 = r210;
        goto L89
    L94:
        r29 = r25;
        if (r138 == false) goto L97;
        ((LinkedList) this.r).removeFirst();
        r117 = r134;
        goto L125
    L97:
        r117 = null;
    L98:
        r29 = r25;
        AbsBarrage r44 = g();
    L100:
        if ((r44 instanceof g) == false) goto L105;
        int r139 = this.p.a;
        if (ArraysKt.contains(((g) r44).d(), r28) == true) goto L105;
        ((LinkedList) this.q).add(r44);
        r44 = g();
    L105:
        if ((r44 instanceof e) == false) goto L107;
        ((LinkedList) this.r).add((com.ss.ugc.live.barrage.barrage.d) r44);
        r44 = g();
        goto L105
    L107:
        if (r44 == null) goto L109;
    L124:
        r117 = r44;
        goto L125
    L109:
        if ((!this.r.isEmpty()) == false) goto L124;
        com.ss.ugc.live.barrage.barrage.d r45 = (com.ss.ugc.live.barrage.barrage.d) ((LinkedList) this.r).getFirst();
        if ((r45 instanceof e) == false) goto L124;
        if (ArraysKt.contains(r45.b(), r28) == false) goto L124;
        if (r45.b == false) goto L124;
        int[] r46 = r45.b();
        int r140 = r46.length;
        int r141 = 0;
        boolean r142 = true;
    L117:
        if (r141 >= r140) goto L122;
        if ((s(r46[r141]) + 0) <= this.H.getWidth()) goto L121;
        r142 = false;
    L121:
        r141 = r141 + 1;
        goto L117
    L122:
        if (r142 == false) goto L124;
        r44 = (AbsBarrage) ((LinkedList) this.r).removeFirst();
        goto L124
    }

    public ScrollBarrageController(View r1, b r2, p r3) {
        super(r1);
        this.H = r1;
        this.I = r3;
        this.o = LazyKt.lazy(LazyThreadSafetyMode.NONE, ScrollBarrageController$danmakuLinePaint$2.INSTANCE);
        this.p = r2;
        this.q = new LinkedList();
        this.r = new LinkedList();
        this.s = new com.ss.ugc.live.barrage.barrage.b();
        this.t = new com.ss.ugc.live.barrage.controller.f();
        this.u = new Random();
        this.v = new HashMap();
        this.w = new ArrayList();
        this.x = new HashMap();
        this.y = new com.ss.ugc.live.barrage.controller.e(this);
        this.z = new RectF();
        this.B = new HashMap();
        this.C = new HashSet();
        this.D = new RectF();
        this.F = new RectF();
    }
}
