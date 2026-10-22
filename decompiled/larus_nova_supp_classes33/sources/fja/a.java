package fja;

import android.view.Choreographer;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public final b a;
    public final c b;
    public Function3<? super String, Object, ? super Float, Unit> c;
    public Function2<? super Boolean, ? super Throwable, Unit> d;

    /* JADX INFO: renamed from: fja.a$a, reason: collision with other inner class name */
    public static final class C0056a {
    }

    public static final class b implements Choreographer.FrameCallback {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r21) {
            c r1 = this.a.b;
            if (r1.l == false) goto L11;
            WeakReference<View> r2 = r1.f;
            if (r2 == null) goto L7;
            View r3 = r2.get();
        L8:
            if (r3 != null) goto L11;
            mja.a.C0063a r4 = mja.a.a;
            mja.a.c("doFrame, view is null");
            return;
        L7:
            r3 = null;
        L11:
            c r5 = this.a.b;
            if (r5.g != 0) goto L14;
            r5.g = r21;
        L14:
            float r6 = r5.b;
            if (r5.m == true) goto L17;
        L24:
            long r7 = r5.a;
            if (r7 == 0) goto L27;
            float r8 = 1.0f / ((r21 - r7) / 1.0E9f);
            mja.a.C0063a r9 = mja.a.a;
            mja.a.c("doFrame, 当前刷新率: " + r8 + " Hz");
        L27:
            c r10 = this.a.b;
            r10.a = r21;
            long r11 = r10.j;
            if (r11 <= 0) goto L30;
            r10.k = r10.k + (r21 - r11);
            r10.j = 0;
        L30:
            long r12 = (r21 - r10.g) - r10.k;
            int r13 = fja.b.a[r10.c.ordinal()];
            if (r13 == 1) goto L50;
            if (r13 == 2) goto L34;
            String r14 = "AnimatableRunner";
            boolean r15 = true;
        L47:
            String r16 = r14;
        L85:
            List<? extends bja.a<?>> r17 = this.a.b.e;
            if ((r17 instanceof Collection) == true) goto L88;
        L90:
            Iterator<T> r18 = r17.iterator();
        L92:
            if (r18.hasNext() == false) goto L96;
            if (((bja.a) r18.next()).d == false) goto L92;
            boolean r19 = true;
        L97:
            if (r19 == false) goto L99;
            Choreographer.getInstance().postFrameCallback(this);
            return;
        L99:
            Choreographer.getInstance().removeFrameCallback(this);
            int r20 = fja.b.b[this.a.b.d.ordinal()];
            if (r20 != r15) goto L102;
            mja.a.C0063a r22 = mja.a.a;
            mja.a.c("doFrame, 触发 loop");
            a.a(this.a, false);
            Choreographer.getInstance().postFrameCallback(this);
            return;
        L102:
            if (r20 != 2) goto L104;
            mja.a.C0063a r23 = mja.a.a;
            mja.a.c("doFrame, 触发 reverse");
            c r24 = this.a.b;
            List<? extends bja.a<?>> r25 = CollectionsKt.reversed(r24.e);
            Intrinsics.checkNotNullParameter(r25, "animationInfos");
            r24.e = r25;
            a.a(this.a, r15);
            Choreographer.getInstance().postFrameCallback(this);
            return;
        L104:
            if (r20 != 3) goto L124;
            a r26 = this.a;
            r26.getClass();
            mja.a.C0063a r27 = mja.a.a;
            mja.a.c("endAnimationInternal, clearVelocity: true");
            Choreographer.getInstance().removeFrameCallback(r26.a);
            r26.b.a(r15);
            mja.a.a(r16, "releaseCallbacks, scene: ".concat("endAnimationInternal"));
            r26.c = null;
            r26.d = null;
            return;
        L124:
            return;
        L96:
            r19 = false;
            goto L97
        L88:
            if (r17.isEmpty() == false) goto L90;
        L34:
            a r28 = this.a;
            c r29 = r28.b;
            if (r29.h != (-1)) goto L38;
            r29.h = 0;
        L38:
            if (r29.h < r29.e.size()) goto L40;
            mja.a.C0063a r30 = mja.a.a;
            mja.a.a("AnimatableRunner", "runSequentialAnimations, return case 1");
            r16 = "AnimatableRunner";
            r15 = true;
            goto L85
        L40:
            c r31 = r28.b;
            long r32 = (long) (r12 * r31.i);
            bja.a<?> r110 = (bja.a) ListProtector.get(r31.e, r31.h);
            boolean r33 = r110.a(r32);
            r110.d = !r33;
            if (r33 == false) goto L49;
            r14 = "AnimatableRunner";
            r15 = true;
            r28.b("runSequentialAnimations 1", r12, r110, r21, false);
            c r34 = r28.b;
            int r35 = r34.h + 1;
            r34.h = r35;
            if (r35 < r34.e.size()) goto L48;
            mja.a.C0063a r36 = mja.a.a;
            mja.a.a(r14, "runSequentialAnimations, return case 2");
            Function2<? super Boolean, ? super Throwable, Unit> r37 = r28.d;
            if (r37 == null) goto L47;
            Unit r38 = (Unit) r37.invoke(Boolean.TRUE, null);
            goto L47
        L48:
            c r39 = r28.b;
            r39.g = 0;
            r39.j = 0;
            r39.k = 0;
            r39.a = 0;
            r28.b("runSequentialAnimations 2", 0, (bja.a) ListProtector.get(r39.e, r39.h), r21, true);
            goto L47
        L49:
            r16 = "AnimatableRunner";
            r15 = true;
            r28.b("runSequentialAnimations 3", r12, r110, r21, true);
            goto L85
        L50:
            r16 = "AnimatableRunner";
            r15 = true;
            a r40 = this.a;
            List<? extends bja.a<?>> r111 = r40.b.e;
            if (r111.size() <= 1) goto L62;
            ArrayList r41 = new ArrayList();
            Iterator<T> r42 = r111.iterator();
        L54:
            if (r42.hasNext() == false) goto L59;
            Object r43 = r42.next();
            if (((bja.a) r43).d == false) goto L54;
            r41.add(r43);
            goto L54
        L59:
            if (r41.size() == 1) goto L62;
            boolean r112 = false;
        L63:
            Iterator<T> r113 = r111.iterator();
            int r44 = 0;
            int r45 = 0;
        L65:
            if (r113.hasNext() == false) goto L78;
            Object r46 = r113.next();
            int r114 = r44 + 1;
            if (r44 >= 0) goto L69;
            CollectionsKt.throwIndexOverflow();
        L69:
            bja.a<?> r47 = (bja.a) r46;
            if (r47.d == false) goto L75;
            long r115 = r12;
            int r116 = r45;
            if (r40.b("runParallelAnimations", r12, r47, r21, r112) == true) goto L76;
            r45 = r116;
        L77:
            r44 = r114;
            r12 = r115;
        L76:
            r45 = r116 + 1;
            goto L77
        L75:
            r115 = r12;
            r116 = r45;
            goto L76
        L78:
            int r117 = r45;
            if (r112 == true) goto L85;
            if (r117 != r111.size()) goto L85;
            mja.a.C0063a r48 = mja.a.a;
            mja.a.a(r16, "runParallelAnimations, all finished");
            Function2<? super Boolean, ? super Throwable, Unit> r49 = r40.d;
            if (r49 == null) goto L85;
            Unit r50 = (Unit) r49.invoke(Boolean.TRUE, null);
        L62:
            r112 = true;
            goto L63
        L17:
            if (r6 <= 0) goto L24;
            long r51 = ((long) (1.0E9f / r6)) - ((long) 1000000);
            long r52 = r5.a;
            if (r52 == 0) goto L24;
            if ((r21 - r52) >= r51) goto L24;
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    static {
    }

    public static final void a(a r5, boolean r6) {
        WeakReference<View> r0 = r5.b.f;
        if (r0 == null) goto L5;
        View r1 = r0.get();
    L6:
        Iterator<T> r2 = r5.b.e.iterator();
    L8:
        if (r2.hasNext() == false) goto L19;
        bja.a r3 = (bja.a) r2.next();
        if (r1 == null) goto L16;
        String r4 = r3.e;
        if (r6 == false) goto L14;
        Object r7 = r3.g;
    L15:
        v0.d(r1, r4, r7);
        goto L16
    L14:
        r7 = r3.f;
    L16:
        r3.d = true;
        r3.k = 0.0f;
        r3.b = -1;
        r3.c = -1;
        if (r6 == false) goto L8;
        T r8 = r3.f;
        r3.f = r3.g;
        r3.g = r8;
        goto L8
    L19:
        c r9 = r5.b;
        r9.g = 0;
        r9.j = 0;
        r9.k = 0;
        r9.a = 0;
        r9.h = -1;
        return;
    L5:
        r1 = null;
        goto L6
    }

    public a(c r2, Function3<? super String, Object, ? super Float, Unit> r3, Function2<? super Boolean, ? super Throwable, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "stateManager");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.a = new b(this);
    }

    public final boolean b(String r20, long r21, bja.a<?> r23, long r24, boolean r26) {
        long r13 = (long) (r21 * this.b.i);
        KClass<?> r5 = r23.j;
        Class r15 = Float.TYPE;
        if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(r15)) == false) goto L7;
        cja.a r6 = cja.b.a;
    L5:
        cja.a r7 = r6;
        T r9 = r23.f;
        T r10 = r23.g;
        Float r8 = r23.i;
        if (r8 == null) goto L12;
        float r11 = r8.floatValue();
    L13:
        Object r12 = r7.b(r13, r9, r10, r11, r23.h);
        WeakReference<View> r14 = this.b.f;
        if (r14 == null) goto L16;
        View r16 = r14.get();
    L18:
        if (r23.b != (-1)) goto L20;
        r23.b = r24;
    L20:
        boolean r18 = r23.a(r13);
        if (r16 == null) goto L27;
        String r17 = r23.e;
        if (r18 == false) goto L25;
        Object r19 = r23.g;
    L26:
        v0.d(r16, r17, r19);
        goto L27
    L25:
        r19 = r12;
    L27:
        r23.c = r24;
        r23.d = !r18;
        KClass<?> r3 = r23.j;
        if (Intrinsics.areEqual(r3, Reflection.getOrCreateKotlinClass(r15)) == false) goto L32;
        cja.a r4 = cja.b.a;
    L30:
        cja.a r22 = r4;
        T r25 = r23.f;
        T r110 = r23.g;
        Float r27 = r23.i;
        if (r27 == null) goto L37;
        float r111 = r27.floatValue();
    L38:
        float r28 = r22.c(r13, r25, r110, r111, r23.h);
        r23.k = r28;
        if (r18 == true) goto L41;
        Function3<? super String, Object, ? super Float, Unit> r1 = this.c;
        if (r1 == null) goto L52;
        Unit r2 = (Unit) r1.invoke(r23.e, r12, Float.valueOf(r28));
    L52:
        return r18;
    L41:
        if (r26 == false) goto L48;
        mja.a.C0063a r29 = mja.a.a;
        mja.a.c("executeAnimation, " + r20 + ", return case 1, property: " + r23.e + ", targetValue: " + r23.g);
        Function3<? super String, Object, ? super Float, Unit> r30 = this.c;
        if (r30 == null) goto L45;
        Unit r31 = (Unit) r30.invoke(r23.e, r23.g, Float.valueOf(r28));
    L45:
        Function2<? super Boolean, ? super Throwable, Unit> r32 = this.d;
        if (r32 == null) goto L52;
        Unit r33 = (Unit) r32.invoke(Boolean.TRUE, null);
        goto L52
    L48:
        mja.a.C0063a r34 = mja.a.a;
        mja.a.c("executeAnimation, " + r20 + ", return case 2, property: " + r23.e + ", targetValue: " + r23.g);
        goto L52
    L37:
        r111 = 0.0f;
        goto L38
    L32:
        if (Intrinsics.areEqual(r3, Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L54;
        r4 = cja.c.a;
        goto L30
    L54:
        throw new IllegalArgumentException("Unsupported type " + r23.j);
    L16:
        r16 = null;
        goto L18
    L12:
        r11 = 0.0f;
        goto L13
    L7:
        if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L56;
        r6 = cja.c.a;
        goto L5
    L56:
        throw new IllegalArgumentException("Unsupported type " + r23.j);
    }
}
