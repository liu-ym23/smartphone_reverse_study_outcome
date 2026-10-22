package com.ss.ugc.live.barrage.controller;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.view.Choreographer;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.ReplayDanmakuWidget;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ugc.live.barrage.barrage.AbsBarrage;
import com.ss.ugc.live.barrage.util.UtilsKt;
import com.ss.ugc.live.barrage.view.SurfaceBarrageLayout;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class AbsBarrageController {
    public static final /* synthetic */ KProperty[] l = null;
    public static boolean m;
    public final com.ss.ugc.live.barrage.util.a a;
    public final Deque<AbsBarrage> b;
    public final Deque<AbsBarrage> c;
    public AbsBarrage d;
    public float e;
    public final Lazy f;
    public boolean g;
    public boolean h;
    public final Lazy i;
    public a j;
    public final View k;

    public interface a {
    }

    public static final class b {
    }

    public static final class c implements com.ss.ugc.live.barrage.util.a.b {
        public final /* synthetic */ AbsBarrageController a;

        @Override // com.ss.ugc.live.barrage.util.a.b
        public final void b() {
            a r0 = this.a.j;
        }

        public c(AbsBarrageController r1) {
            this.a = r1;
        }

        @Override // com.ss.ugc.live.barrage.util.a.b
        public final void a(AbsBarrage r3) {
            ReplayDanmakuWidget.e r0 = this.a.j;
            if (r0 == null) goto L9;
            ReplayDanmakuWidget.e r1 = r0;
            if ((r3 instanceof com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.barrage.viewholder.a) == false) goto L7;
            ((HashSet) r1.a.g).remove(r3);
        L7:
            r1.a.t.c();
            r1.a.s.c();
            return;
        }
    }

    static {
        l = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AbsBarrageController.class), "valueAnimator", "getValueAnimator()Landroid/animation/ValueAnimator;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AbsBarrageController.class), "frameAnimator", "getFrameAnimator()Lcom/ss/ugc/live/barrage/util/FrameAnimator;"))};
    }

    public void d(Canvas r1) {
    }

    public final com.ss.ugc.live.barrage.util.d e() {
        Lazy r0 = this.i;
        KProperty r1 = l[1];
        return (com.ss.ugc.live.barrage.util.d) r0.getValue();
    }

    public final ValueAnimator f() {
        Lazy r0 = this.f;
        KProperty r1 = l[0];
        return (ValueAnimator) r0.getValue();
    }

    public abstract void j(com.ss.ugc.live.barrage.util.a r1, float r2);

    public final AbsBarrage g() {
        Iterator<AbsBarrage> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        AbsBarrage r1 = r0.next();
        if (r1.b == false) goto L4;
        r0.remove();
        h();
        return r1;
    L9:
        return null;
    }

    public final void h() {
    L3:
        if (((LinkedList) this.c).size() > 8) goto L10;
        if (((LinkedList) this.b).size() == 0) goto L18;
        AbsBarrage r0 = (AbsBarrage) ((LinkedList) this.b).removeFirst();
        r0.p(AbsBarrage.State.PREPARING);
        if (r0.e == true) goto L8;
        ((LinkedList) this.c).add(r0);
        goto L3
    L8:
        ((LinkedList) this.c).addFirst(r0);
        goto L3
    L18:
        return;
    }

    public final boolean q() {
        if (this.h == false) goto L5;
    L10:
        return true;
    L5:
        if (this.g == true) goto L7;
    L9:
        return false;
    L7:
        if (m == false) goto L9;
        goto L9
    }

    public void b() {
        UtilsKt.a();
        ReplayDanmakuWidget.e r0 = this.j;
        if (r0 == null) goto L5;
        r0.a("clearLists");
    L5:
        ((LinkedList) this.b).clear();
        ((LinkedList) this.c).clear();
    }

    public final void l() {
        UtilsKt.a();
        ReplayDanmakuWidget.e r0 = this.j;
        if (r0 == null) goto L6;
        r0.a("pause");
    L6:
        if (q() == false) goto L16;
        if (e().a == null) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == false) goto L21;
        com.ss.ugc.live.barrage.util.d r2 = e();
        r2.getClass();
        r2.d = System.currentTimeMillis() - r2.c;
        r2.e = true;
        com.ss.ugc.live.barrage.util.d.a r3 = r2.a;
        if (r3 == null) goto L22;
        Choreographer.getInstance().removeFrameCallback(r3);
        r2.a = null;
        return;
    L22:
        return;
    L21:
        return;
    L10:
        r1 = false;
        goto L11
    L16:
        if (f().isPaused() == false) goto L18;
        return;
    L18:
        if (f().isRunning() == false) goto L25;
        f().pause();
        return;
    }

    public void m() {
        UtilsKt.a();
        ReplayDanmakuWidget.e r0 = this.j;
        if (r0 == null) goto L5;
        r0.a("release");
    L5:
        Canvas r1 = null;
        if (q() == false) goto L10;
        com.ss.ugc.live.barrage.util.d r2 = e();
        r2.getClass();
        r2.d = System.currentTimeMillis() - r2.c;
        r2.e = true;
        com.ss.ugc.live.barrage.util.d.a r3 = r2.a;
        if (r3 == null) goto L10;
        Choreographer.getInstance().removeFrameCallback(r3);
        r2.a = null;
    L10:
        f().cancel();
        ((LinkedList) this.b).clear();
        ((LinkedList) this.c).clear();
        this.a.clear();
        this.k.invalidate();
        View r4 = this.k;
        if ((r4 instanceof SurfaceBarrageLayout) == false) goto L20;
        SurfaceBarrageLayout r5 = (SurfaceBarrageLayout) r4;
        SurfaceHolder r6 = r5.d;
        if (r6 == null) goto L15;
        r1 = r6.lockCanvas();
    L15:
        if (r1 == null) goto L21;
        r1.drawColor(0, PorterDuff.Mode.CLEAR);
        SurfaceHolder r7 = r5.d;
        if (r7 == null) goto L22;
        r7.unlockCanvasAndPost(r1);
        return;
    L22:
        return;
    L21:
        return;
    }

    public final void n() {
        UtilsKt.a();
        ReplayDanmakuWidget.e r0 = this.j;
        if (r0 == null) goto L6;
        r0.a("resume");
    L6:
        if (q() == false) goto L14;
        if (e().a == null) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == true) goto L17;
        e().c();
        return;
    L17:
        return;
    L10:
        r1 = false;
        goto L11
    L14:
        if (f().isPaused() == false) goto L19;
        f().resume();
        return;
    }

    public final void o() {
        UtilsKt.a();
        if (q() == false) goto L11;
        if (e().a == null) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L13;
        e().c();
    L13:
        h();
        return;
    L7:
        r0 = false;
        goto L8
    L11:
        if (f().isRunning() == true) goto L13;
        f().start();
        goto L13
    }

    public final void p() {
        UtilsKt.a();
        ReplayDanmakuWidget.e r0 = this.j;
        if (r0 == null) goto L5;
        r0.a("stop");
    L5:
        Canvas r1 = null;
        if (q() == false) goto L16;
        if (e().a == null) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L18;
        com.ss.ugc.live.barrage.util.d r3 = e();
        r3.getClass();
        r3.d = System.currentTimeMillis() - r3.c;
        r3.e = true;
        com.ss.ugc.live.barrage.util.d.a r4 = r3.a;
        if (r4 == null) goto L18;
        Choreographer.getInstance().removeFrameCallback(r4);
        r3.a = null;
    L18:
        this.k.invalidate();
        View r5 = this.k;
        if ((r5 instanceof SurfaceBarrageLayout) == false) goto L28;
        SurfaceBarrageLayout r6 = (SurfaceBarrageLayout) r5;
        SurfaceHolder r7 = r6.d;
        if (r7 == null) goto L23;
        r1 = r7.lockCanvas();
    L23:
        if (r1 == null) goto L29;
        r1.drawColor(0, PorterDuff.Mode.CLEAR);
        SurfaceHolder r8 = r6.d;
        if (r8 == null) goto L30;
        r8.unlockCanvasAndPost(r1);
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L10:
        r2 = false;
        goto L11
    L16:
        if (f().isRunning() == false) goto L18;
        f().cancel();
        goto L18
    }

    public AbsBarrageController(View r3) {
        this.k = r3;
        this.a = new com.ss.ugc.live.barrage.util.a(new c(this), new ArrayList());
        this.b = new LinkedList();
        this.c = new LinkedList();
        this.f = LazyKt.lazy(LazyThreadSafetyMode.NONE, new AbsBarrageController$valueAnimator$2(this));
        this.g = true;
        this.i = LazyKt.lazy(new AbsBarrageController$frameAnimator$2(this));
    }

    public void c(Canvas r4) {
        int r0 = this.a.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((AbsBarrage) ListProtector.get(this.a, r1)).g(r4);
        r1 = r1 + 1;
        goto L3
    }

    public void i(AbsBarrage r2) {
        r2.p(AbsBarrage.State.ADDED);
        o();
    }

    public boolean k(MotionEvent r8) {
        int r0 = r8.getAction();
        if (r0 == 0) goto L30;
        if (r0 != 1) goto L6;
        AbsBarrage r1 = this.d;
        if (r1 == null) goto L39;
        RectF r2 = r1.f;
        if (r2 == null) goto L39;
        if (r2.contains(r8.getX(), r8.getY()) != true) goto L39;
        AbsBarrage r3 = this.d;
        if (r3 != null) goto L29;
        return false;
    L29:
        return r3.l(r8, this.k);
    L39:
        return false;
    L6:
        if (r0 != 2) goto L8;
    L10:
        AbsBarrage r4 = this.d;
        if (r4 == null) goto L39;
        RectF r5 = r4.f;
        if (r5 == null) goto L39;
        if (r5.contains(r8.getX(), r8.getY()) != true) goto L39;
        AbsBarrage r6 = this.d;
        if (r6 != null) goto L19;
        return false;
    L19:
        return r6.l(r8, this.k);
    L8:
        if (r0 == 3) goto L10;
    L30:
        Iterator<AbsBarrage> r7 = this.a.iterator();
    L31:
        com.ss.ugc.live.barrage.util.a.C0201a r9 = (com.ss.ugc.live.barrage.util.a.C0201a) r7;
        if (r9.hasNext() == false) goto L39;
        AbsBarrage r10 = (AbsBarrage) r9.next();
        if (r10.f.contains(r8.getX(), r8.getY()) == false) goto L31;
        if (r10.l(r8, this.k) == false) goto L31;
        this.d = r10;
        return true;
    }

    public final void a(AbsBarrage r1, boolean r2) {
        UtilsKt.a();
        if (r2 == false) goto L5;
        ((LinkedList) this.b).addFirst(r1);
    L6:
        i(r1);
        return;
    L5:
        ((LinkedList) this.b).add(r1);
        goto L6
    }
}
