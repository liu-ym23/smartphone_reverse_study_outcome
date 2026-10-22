package com.ss.ugc.live.barrage.controller;

import android.animation.Animator;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ugc.live.barrage.barrage.AbsBarrage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ScrollBarrageControllerV2 extends ScrollBarrageController {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/ugc/live/barrage/controller/ScrollBarrageControllerV2$BarrageHeat;", "", "LOW", "MEDIUM", "HIGH", "NORMAL", "HIGH_MAX", "barrage_release"}, k = 1, mv = {1, 4, 0})
    public static final enum BarrageHeat extends Enum<BarrageHeat> {
        public static final BarrageHeat HIGH = null;
        public static final BarrageHeat HIGH_MAX = null;
        public static final BarrageHeat LOW = null;
        public static final BarrageHeat MEDIUM = null;
        public static final BarrageHeat NORMAL = null;
        public static final /* synthetic */ BarrageHeat[] a = null;

        static {
            BarrageHeat r1 = new BarrageHeat("LOW", 0);
            LOW = r1;
            BarrageHeat r2 = new BarrageHeat("MEDIUM", 1);
            MEDIUM = r2;
            BarrageHeat r3 = new BarrageHeat("HIGH", 2);
            HIGH = r3;
            BarrageHeat r4 = new BarrageHeat("NORMAL", 3);
            NORMAL = r4;
            BarrageHeat r5 = new BarrageHeat("HIGH_MAX", 4);
            HIGH_MAX = r5;
            a = new BarrageHeat[]{r1, r2, r3, r4, r5};
        }

        public static BarrageHeat valueOf(String r1) {
            return (BarrageHeat) r27.a.a(BarrageHeat.class, r1);
        }

        public static BarrageHeat[] values() {
            return (BarrageHeat[]) a.clone();
        }

        public BarrageHeat(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.ss.ugc.live.barrage.controller.ScrollBarrageController, com.ss.ugc.live.barrage.controller.AbsBarrageController
    public final void b() {
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

    @Override // com.ss.ugc.live.barrage.controller.ScrollBarrageController, com.ss.ugc.live.barrage.controller.AbsBarrageController
    public final void m() {
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

    @Override // com.ss.ugc.live.barrage.controller.ScrollBarrageController, com.ss.ugc.live.barrage.controller.AbsBarrageController
    public final void c(Canvas r5) {
        int r0 = this.a.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        AbsBarrage r2 = (AbsBarrage) ListProtector.get(this.a, r1);
        if ((!Intrinsics.areEqual(r2, null)) == false) goto L9;
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
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.ss.ugc.live.barrage.controller.ScrollBarrageControllerV2$onTouchEvent$1] */
    @Override // com.ss.ugc.live.barrage.controller.ScrollBarrageController, com.ss.ugc.live.barrage.controller.AbsBarrageController
    public final boolean k(MotionEvent r9) {
        ?? r0 = new ScrollBarrageControllerV2$onTouchEvent$1(this);
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

    @Override // com.ss.ugc.live.barrage.controller.ScrollBarrageController, com.ss.ugc.live.barrage.controller.AbsBarrageController
    public final void j(com.ss.ugc.live.barrage.util.a r1, float r2) {
        if (this.E == false) goto L6;
        return;
    L6:
        throw null;
    }
}
